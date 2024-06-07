package cc.unilock.shutup.mixin.porting_lib;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.github.fabricators_of_create.porting_lib.core.PortingLib;
import io.github.fabricators_of_create.porting_lib.models.obj.ObjLoader;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.IOException;

@Mixin(value = ObjLoader.class, remap = false)
public class ObjLoaderMixin {
	/**
	 * @author unilock
	 * @reason Catch JsonParseException
	 */
	@Overwrite
	private JsonObject tryLoadModelJson(Identifier id, Resource resource) {
		try {
			JsonObject json = JsonParser.parseReader(resource.getReader()).getAsJsonObject();
			if (json.has(ObjLoader.OBJ_MARKER)) {
				return json;
			}
		} catch (IOException | IllegalStateException | JsonParseException e) {
			if (!("meatweapons".equals(id.getNamespace()) || "neepmeat".equals(id.getNamespace()))) {
				PortingLib.LOGGER.error("Error loading obj model from models/misc: " + id, e);
			}
		}
		return null;
	}
}
