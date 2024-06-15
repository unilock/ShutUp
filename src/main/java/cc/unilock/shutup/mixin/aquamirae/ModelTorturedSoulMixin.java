package cc.unilock.shutup.mixin.aquamirae;

import com.obscuria.aquamirae.client.models.ModelTorturedSoul;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.PrintStream;

@Mixin(value = ModelTorturedSoul.class, remap = false)
public class ModelTorturedSoulMixin {
	@Redirect(method = "setAngles(Lcom/obscuria/aquamirae/common/entities/TorturedSoulEntity;FFFFF)V", at = @At(value = "INVOKE", target = "Ljava/io/PrintStream;println(F)V"))
	private void println(PrintStream instance, float x) {
		// NO-OP
	}
}
