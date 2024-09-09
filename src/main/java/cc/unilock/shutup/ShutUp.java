package cc.unilock.shutup;

import de.dafuqs.spectrum.api.status_effect.Incurable;
import de.dafuqs.spectrum.mixin.accessors.StatusEffectInstanceAccessor;
import de.dafuqs.spectrum.registries.SpectrumStatusEffects;
import io.github.fabricators_of_create.porting_lib.entity.events.living.MobEffectEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.s2c.play.EntityStatusEffectUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.base.api.util.TriState;
import org.quiltmc.qsl.entity.effect.api.StatusEffectEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutUp implements ModInitializer {
	public static final String MOD_ID = "shutup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean PACKET_DEBUG = false;

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("UNILOCK WAS HERE");

		StatusEffectEvents.SHOULD_REMOVE.register((entity, effect, reason) -> {
			var event = new MobEffectEvent.Remove(entity, effect);
			event.sendEvent();
			return event.isCanceled() ? TriState.FALSE : TriState.DEFAULT;
		});
		StatusEffectEvents.SHOULD_REMOVE.register((entity, effect, reason) -> {
			if (Incurable.isIncurable(effect) && !affectedByImmunity(entity, effect.getAmplifier())) {
				if (effect.getDuration() > 1200) {
					((StatusEffectInstanceAccessor) effect).setDuration(effect.getDuration() - 1200);
					if (!entity.getWorld().isClient()) {
						((ServerWorld) entity.getWorld()).getChunkManager().sendToNearbyPlayers(entity, new EntityStatusEffectUpdateS2CPacket(entity.getId(), effect));
					}
				}
				return TriState.FALSE;
			}
			return TriState.DEFAULT;
		});
	}

	private static boolean affectedByImmunity(LivingEntity instance, int amplifier) {
		var immunity = instance.getStatusEffect(SpectrumStatusEffects.IMMUNITY);
		var cost = 1200 + 600 * amplifier;

		if (immunity != null && immunity.getDuration() >= cost) {
			((StatusEffectInstanceAccessor) immunity).setDuration(Math.max(5, immunity.getDuration() - cost));
			if (!instance.getWorld().isClient()) {
				((ServerWorld) instance.getWorld()).getChunkManager().sendToNearbyPlayers(instance, new EntityStatusEffectUpdateS2CPacket(instance.getId(), immunity));
			}
			return true;
		}
		return false;
	}
}
