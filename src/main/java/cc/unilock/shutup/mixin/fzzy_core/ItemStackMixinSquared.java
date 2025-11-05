package cc.unilock.shutup.mixin.fzzy_core;

import com.bawnorton.mixinsquared.TargetHandler;
import com.unascribed.exco.storage.unmodifiable.UnmodifiableItemStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemStack.class, priority = 1500)
public class ItemStackMixinSquared {
	@TargetHandler(
		mixin = "me.fzzyhmstrs.fzzy_core.mixins.ItemStackMixin",
		name = "fzzy_core_initializeFromNbt"
	)
	@Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)
	private void fzzy_core_initializeFromNbt(CallbackInfo ci) {
		if ((ItemStack) (Object) this instanceof UnmodifiableItemStack) {
			ci.cancel();
		}
	}

	@TargetHandler(
		mixin = "me.fzzyhmstrs.fzzy_core.mixins.ItemStackMixin",
		name = "fzzy_core_initializeFromItem"
	)
	@Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)
	private void fzzy_core_initializeFromItem(CallbackInfo ci) {
		if ((ItemStack) (Object) this instanceof UnmodifiableItemStack) {
			ci.cancel();
		}
	}
}
