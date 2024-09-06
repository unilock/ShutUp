package cc.unilock.shutup;

import com.bawnorton.mixinsquared.adjuster.tools.AdjustableAnnotationNode;
import com.bawnorton.mixinsquared.adjuster.tools.AdjustableWrapWithConditionNode;
import com.bawnorton.mixinsquared.api.MixinAnnotationAdjuster;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class ShutUpMixinAnnotationAdjuster implements MixinAnnotationAdjuster {
	@Override
	public AdjustableAnnotationNode adjust(List<String> targetClassNames, String mixinClassName, MethodNode handlerNode, AdjustableAnnotationNode annotationNode) {
		if ("io.github.fabricators_of_create.porting_lib.entity.mixin.common.LivingEntityMixin".equals(mixinClassName) && annotationNode.is(WrapWithCondition.class)) {
			AdjustableWrapWithConditionNode wrap = annotationNode.as(AdjustableWrapWithConditionNode.class);

			if (wrap.getMethod().get(0).equals("removeAllEffects")) {
				return null;
			}
		}

		return annotationNode;
	}
}
