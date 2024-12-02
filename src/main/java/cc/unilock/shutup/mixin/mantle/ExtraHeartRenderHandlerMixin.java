package cc.unilock.shutup.mixin.mantle;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.mantle.client.ExtraHeartRenderHandler;

@Mixin(value = ExtraHeartRenderHandler.class, remap = false)
public class ExtraHeartRenderHandlerMixin {
	@Inject(method = "renderHealthbar", at = @At("HEAD"), cancellable = true)
	private void renderHealthbar(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}
