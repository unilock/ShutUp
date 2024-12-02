package cc.unilock.shutup;

import io.github.fabricators_of_create.porting_lib.entity.events.living.MobEffectEvent;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
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

		if (QuiltLoader.isModLoaded("porting_lib_entity")) {
			StatusEffectEvents.SHOULD_REMOVE.register((entity, effect, reason) -> {
				var event = new MobEffectEvent.Remove(entity, effect);
				event.sendEvent();
				return event.isCanceled() ? TriState.FALSE : TriState.DEFAULT;
			});
		}
	}
}
