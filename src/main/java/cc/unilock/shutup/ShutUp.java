package cc.unilock.shutup;

import io.wispforest.affinity.entity.EmancipatedBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Optional;

public class ShutUp implements ModInitializer {
	public static final String MOD_ID = "shutup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		this.affinity();
	}

	private void affinity() {
		try {
			Field optionalNbtField = EmancipatedBlockEntity.class.getDeclaredField("OPTIONAL_NBT");
			optionalNbtField.setAccessible(true);
			TrackedDataHandlerRegistry.register((TrackedDataHandler<Optional<NbtCompound>>) optionalNbtField.get(null));
		} catch (Exception e) {
			LOGGER.error("Could not register EmancipatedBlockEntity.OPTIONAL_NBT", e);
		}
	}
}
