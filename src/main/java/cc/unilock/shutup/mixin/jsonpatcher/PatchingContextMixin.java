package cc.unilock.shutup.mixin.jsonpatcher;

import io.github.mattidragon.jsonpatcher.patch.PatchingContext;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PatchingContext.class, remap = false)
public class PatchingContextMixin {
	@Redirect(method = "patchInputStream", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"))
	private static void warn(Logger instance, String format, Object arg1, Object arg2) {
		// NO-OP
	}
}
