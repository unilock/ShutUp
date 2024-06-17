package cc.unilock.shutup.mixin.minecraft;

import com.mojang.blaze3d.glfw.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WindowMixin {
	@Inject(method = "logGlError", at = @At("HEAD"), cancellable = true)
	private void logGlError(int error, long description, CallbackInfo ci) {
		if (error == 65539) ci.cancel();
	}
}
