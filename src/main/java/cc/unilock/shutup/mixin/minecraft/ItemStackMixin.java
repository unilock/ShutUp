package cc.unilock.shutup.mixin.minecraft;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.unascribed.exco.client.screen.TerminalScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@WrapOperation(method = "getName", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;remove(Ljava/lang/String;)V", ordinal = 0))
	private void getName$removeA(NbtCompound instance, String key, Operation<Void> original) {
		if (!(MinecraftClient.getInstance().currentScreen instanceof TerminalScreen)) {
			original.call(instance, key);
		}
	}

	@WrapOperation(method = "getName", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;remove(Ljava/lang/String;)V", ordinal = 1))
	private void getName$removeB(NbtCompound instance, String key, Operation<Void> original) {
		if (!(MinecraftClient.getInstance().currentScreen instanceof TerminalScreen)) {
			original.call(instance, key);
		}
	}

	@WrapOperation(method = "getTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;remove(Ljava/lang/String;)V"))
	private void getTooltip$remove(NbtCompound instance, String key, Operation<Void> original) {
		if (!(MinecraftClient.getInstance().currentScreen instanceof TerminalScreen)) {
			original.call(instance, key);
		}
	}
}
