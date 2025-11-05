package cc.unilock.shutup.mixin.expandedstorage;

import compasses.expandedstorage.impl.ThreadClientHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ThreadClientHelper.class, remap = false)
public class ThreadClientHelperMixin {
	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcompasses/expandedstorage/impl/ThreadClientHelper;isModLoaded(Ljava/lang/String;)Z"))
	private boolean isModLoaded(ThreadClientHelper instance, String modId) {
		return false;
	}
}
