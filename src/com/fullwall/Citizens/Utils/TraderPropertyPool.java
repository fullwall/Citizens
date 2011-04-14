package com.fullwall.Citizens.Utils;

import java.util.ArrayList;

import net.minecraft.server.InventoryPlayer;

import org.bukkit.craftbukkit.inventory.CraftInventoryPlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.fullwall.Citizens.PropertyHandler;

public class TraderPropertyPool {
	public static final PropertyHandler traders = new PropertyHandler(
			"plugins/Citizens/Traders/Citizens.traders");
	public static final PropertyHandler inventories = new PropertyHandler(
			"plugins/Citizens/Traders/Citizens.inventories");
	public static final PropertyHandler buying = new PropertyHandler(
			"plugins/Citizens/Traders/Citizens.buying");
	public static final PropertyHandler selling = new PropertyHandler(
			"plugins/Citizens/Traders/Citizens.selling");
	public static final PropertyHandler balances = new PropertyHandler(
			"plugins/Citizens/Traders/Citizens.balances");

	public static void saveAll() {
		traders.save();
		inventories.save();
		buying.save();
		selling.save();
		balances.save();
	}

	public static void saveTrader(int UID, boolean state) {
		traders.setBoolean(UID, state);
	}

	public static boolean isTrader(int UID) {
		return traders.keyExists(UID);
	}

	public static boolean getTraderState(int UID) {
		return traders.getBoolean(UID);
	}

	public static void removeTrader(int UID) {
		traders.removeKey(UID);
	}

	public static void saveInventory(int UID, PlayerInventory inv) {
		String save = "";
		for (ItemStack i : inv.getContents()) {
			save += i.getTypeId() + "/" + i.getAmount() + "/"
					+ ((i.getData() == null) ? 0 : i.getData().getData()) + ",";
		}
		inventories.setString(UID, save);
	}

	public static PlayerInventory getInventory(int UID) {
		String save = inventories.getString(UID);
		ArrayList<ItemStack> array = new ArrayList<ItemStack>();
		for (String s : save.split(",")) {
			String[] split = s.split("/");
			array.add(new ItemStack(parse(split[0]), parse(split[1]),
					(short) 0, (byte) parse(split[2])));
		}
		PlayerInventory inv = new CraftInventoryPlayer(
				new InventoryPlayer(null));
		inv.setContents((ItemStack[]) array.toArray());
		return inv;
	}

	private static int parse(String passed) {
		return Integer.parseInt(passed);
	}

	public static void saveBalance(int UID, int balance) {
		balances.setInt(UID, balance);
	}

	public static int getBalance(int UID) {
		return balances.getInt(UID);
	}

}