package cc.unilock.shutup.mixin.aurorasdeco;

import dev.lambdaurora.aurorasdeco.AurorasDeco;
import org.objectweb.asm.Opcodes;
import org.quiltmc.qsl.resource.loader.api.ResourcePackActivationType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = AurorasDeco.class, remap = false)
public class AurorasDecoMixin {
	@Redirect(method = "onInitialize", at = @At(value = "FIELD", target = "Lorg/quiltmc/qsl/resource/loader/api/ResourcePackActivationType;DEFAULT_ENABLED:Lorg/quiltmc/qsl/resource/loader/api/ResourcePackActivationType;", opcode = Opcodes.GETSTATIC))
	private ResourcePackActivationType getDefaultEnabled() {
		return ResourcePackActivationType.NORMAL;
	}
}
