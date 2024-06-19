package cc.unilock.shutup.mixin.minecraft;

import cc.unilock.shutup.ShutUp;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomPayloadC2SPacket.class)
public class CustomPayloadS2CPacketMixin {
	@Shadow
	@Final
	private Identifier channel;

	@Inject(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", at = @At("TAIL"))
	private void initA(CallbackInfo ci) {
		if (ShutUp.PACKET_DEBUG)
			ShutUp.LOGGER.info("Created packet with channel {}", this.channel);
	}

	@Inject(method = "<init>(Lnet/minecraft/util/Identifier;Lnet/minecraft/network/PacketByteBuf;)V", at = @At("TAIL"))
	private void initB(CallbackInfo ci) {
		if (ShutUp.PACKET_DEBUG)
			ShutUp.LOGGER.info("Created packet with channel {}", this.channel);
	}
}
