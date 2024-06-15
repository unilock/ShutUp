package cc.unilock.shutup.mixin.obscure_api;

import com.bawnorton.mixinsquared.TargetHandler;
import com.obscuria.obscureapi.client.tooltips.TooltipBuilder;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = ItemStack.class)
public class ItemStackMixinSquared {
	@TargetHandler(
		mixin = "com.obscuria.obscureapi.mixin.ItemStackMixin",
		name = "modifyTooltip"
	)
	@Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)
	private void modifyTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> cir, CallbackInfo ci) {
		TooltipBuilder.buildTooltip(cir.getReturnValue(), (ItemStack) (Object) this, player);
		ci.cancel();
	}
}
