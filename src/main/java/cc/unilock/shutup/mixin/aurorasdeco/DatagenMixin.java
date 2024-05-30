package cc.unilock.shutup.mixin.aurorasdeco;

import dev.lambdaurora.aurorasdeco.resource.Datagen;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Datagen.class, remap = false)
public class DatagenMixin {
	@Redirect(method = "lambda$generateDirectionalSignsClientData$14", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;)V"))
	private static void error(Logger instance, String msg) {
		// NO-OP
	}
}
