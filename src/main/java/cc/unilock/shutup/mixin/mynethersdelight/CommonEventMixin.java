package cc.unilock.shutup.mixin.mynethersdelight;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.soytutta.mynethersdelight.common.events.CommonEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = CommonEvent.class, remap = false)
public class CommonEventMixin {
	@WrapOperation(method = "livingDie", at = @At(value = "INVOKE", target = "Ljava/lang/Integer;intValue()I"))
	private static int intValue(Integer instance, Operation<Integer> original) {
		return instance != null ? original.call(instance) : 0;
	}
}
