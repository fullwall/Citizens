package com.citizens.npcs;

import java.util.Map;

import com.citizens.npctypes.interfaces.NPCFactory;
import com.citizens.npctypes.interfaces.NPCType;
import com.google.common.collect.Maps;

public class NPCTypeManager {
	private static final Map<String, NPCType> types = Maps.newHashMap();

	public static NPCFactory getFactory(String string) {
		return types.get(string).factory();
	}

	public static void registerType(NPCType type) {
		types.put(type.getType(), type);
	}

	public static boolean validType(String type) {
		return types.get(type) != null;
	}

	public static NPCType getType(String type) {
		return types.get(type);
	}

	public static void registerType(NPCType type, boolean autosave) {
		if (autosave) {
			type.registerAutosave();
		}
		registerType(type);
	}

	public static Map<String, NPCType> getTypes() {
		return types;
	}
}