package cc.unilock.shutup.mixin.nbt_ac;

import com.mt1006.nbt_ac.autocomplete.loader.typeloader.TypeLoader;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = TypeLoader.class, remap = false)
public class TypeLoaderMixin {
	@Redirect(method = "loadEntityTypes", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"))
	private static void loadEntityTypes$error(Logger instance, String msg, Object arg1, Object arg2) {
		// NO-OP
	}

	@Redirect(method = "loadEntityTypes", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;)V"))
	private static void loadEntityTypes$error(Logger instance, String msg, Object arg) {
		// NO-OP
	}

	@Redirect(method = "loadEntityTypes", at = @At(value = "INVOKE", target = "Lcom/mt1006/nbt_ac/autocomplete/loader/Loader;printStackTrace(Ljava/lang/Exception;)V"))
	private static void loadEntityTypes$printStackTrace(Exception exception) {
		// NO-OP
	}

	@Redirect(method = "loadBlockEntityTypes", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"))
	private static void loadBlockEntityTypes$error(Logger instance, String msg, Object arg1, Object arg2) {
		// NO-OP
	}

	@Redirect(method = "loadBlockEntityTypes", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;)V"))
	private static void loadBlockEntityTypes$error(Logger instance, String msg, Object arg) {
		// NO-OP
	}

	@Redirect(method = "loadBlockEntityTypes", at = @At(value = "INVOKE", target = "Lcom/mt1006/nbt_ac/autocomplete/loader/Loader;printStackTrace(Ljava/lang/Exception;)V"))
	private static void loadBlockEntityTypes$printStackTrace(Exception exception) {
		// NO-OP
	}
}
