package cc.unilock.shutup.mixin.lootintegrations;

import com.lootintegrations.loot.LootModifierManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LootModifierManager.class, remap = false)
public class LootModifierManagerMixin {
	@Redirect(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;)V"), remap = true)
	private void warn(Logger instance, String s) {
		// NO-OP
	}

	@Redirect(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;Ljava/lang/Throwable;)V"), remap = true)
	private void warn(Logger instance, String s, Throwable throwable) {
		// NO-OP
	}
}
