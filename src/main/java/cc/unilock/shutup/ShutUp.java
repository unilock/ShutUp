package cc.unilock.shutup;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutUp implements ModInitializer {
	public static final String MOD_ID = "shutup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean PACKET_DEBUG = false;

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("UNILOCK WAS HERE");
	}
}
