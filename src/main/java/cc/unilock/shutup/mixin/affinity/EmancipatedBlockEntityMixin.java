package cc.unilock.shutup.mixin.affinity;

import io.wispforest.affinity.entity.EmancipatedBlockEntity;
import net.minecraft.entity.data.TrackedDataHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EmancipatedBlockEntity.class, remap = false)
public class EmancipatedBlockEntityMixin {
	@Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/data/TrackedDataHandlerRegistry;register(Lnet/minecraft/entity/data/TrackedDataHandler;)V"))
	private static void register(TrackedDataHandler<?> handler) {
		// NO-OP
	}
}
