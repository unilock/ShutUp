package cc.unilock.shutup.mixin.gear_core;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.unascribed.exco.client.screen.TerminalScreen;
import me.fzzyhmstrs.gear_core.modifier_util.EquipmentModifierHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = EquipmentModifierHelper.class, remap = false)
public class EquipmentModifierHelperMixin {
	@WrapMethod(method = "fixUpOldNbt")
	private void fixUpOldNbt(NbtCompound nbt, Operation<Void> original) {
		if (!(MinecraftClient.getInstance().currentScreen instanceof TerminalScreen)) {
			original.call(nbt);
		}
	}
}
