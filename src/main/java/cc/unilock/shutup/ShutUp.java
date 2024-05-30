package cc.unilock.shutup;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutUp implements ModInitializer {
	public static final String MOD_ID = "shutup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("UNILOCK WAS HERE");
	}
}
