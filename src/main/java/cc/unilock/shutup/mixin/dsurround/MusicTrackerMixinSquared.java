package cc.unilock.shutup.mixin.dsurround;

import com.bawnorton.mixinsquared.TargetHandler;
import net.minecraft.client.sound.MusicTracker;
import org.orecruncher.dsurround.lib.logging.IModLog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = MusicTracker.class, priority = 1500)
public class MusicTrackerMixinSquared {
	@TargetHandler(
		mixin = "org.orecruncher.dsurround.mixins.audio.MixinMusicManager",
		name = "dsurround_startPlaying"
	)
	@Redirect(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lorg/orecruncher/dsurround/lib/logging/IModLog;info(Ljava/lang/String;[Ljava/lang/Object;)V"))
	private void dsurround_startPlaying(IModLog instance, String msg) {
		// NO-OP
	}
}
