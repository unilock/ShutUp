package cc.unilock.shutup;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class ShutUpMixinCanceller implements MixinCanceller {
	private static final List<String> CANCELLED = List.of(
		"com.hakimen.kawaiidishes.mixin.PacifyEntityMixin",
		"de.dafuqs.spectrum.mixin.LivingEntityPreventStatusClearMixin",
		"org.quiltmc.qsl.entity.effect.mixin.LivingEntityMixin"
	);

	@Override
	public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
		return CANCELLED.contains(mixinClassName);
	}
}
