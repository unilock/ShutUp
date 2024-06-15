package cc.unilock.shutup;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class ShutUpMixinCanceller implements MixinCanceller {
	@Override
	public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
		return false;
	}
}
