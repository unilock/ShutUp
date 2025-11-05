package cc.unilock.shutup.mixin.aurorasdeco;

import dev.lambdaurora.aurorasdeco.resource.Datagen;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Datagen.class, remap = false)
public class DatagenMixin {
	@Redirect(method = "lambda$generateDirectionalSignsClientData$12", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V"))
	private static void errorA(Logger instance, String msg, Throwable throwable) {
		// NO-OP
	}

	@Redirect(method = "lambda$generateDirectionalSignsClientData$13", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;)V"))
	private static void errorB(Logger instance, String msg) {
		// NO-OP
	}

	@Redirect(method = "lambda$generateDirectionalSignsClientData$13", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V"))
	private static void errorC(Logger instance, String msg, Throwable throwable) {
		// NO-OP
	}
}
