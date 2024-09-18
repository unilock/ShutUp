package cc.unilock.shutup.mixin.jei;

import mezz.jei.fabric.input.FabricJeiKeyMappingCategoryBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = FabricJeiKeyMappingCategoryBuilder.class, remap = false)
public class FabricJeiKeyMappingCategoryBuilderMixin {
	@Redirect(method = "createMapping", at = @At(value = "INVOKE", target = "Lnet/fabricmc/loader/api/FabricLoader;isModLoaded(Ljava/lang/String;)Z"))
	private boolean isModLoaded(FabricLoader instance, String id) {
		return false;
	}
}
