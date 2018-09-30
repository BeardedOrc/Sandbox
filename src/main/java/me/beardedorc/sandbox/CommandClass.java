package me.beardedorc.sandbox;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CommandClass implements CommandExecutor {

    public Map<String, ItemStack> getCustomItemData() {
        return customItemData;
    }

    public void setCustomItemData(Map<String, ItemStack> customItemData) {
        this.customItemData = customItemData;
    }

    private Map<String, ItemStack> customItemData = new HashMap<>();

    int count = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) {
            if (sender instanceof Player) {
                count++;
                Player player = (Player) sender;
                String name = args[0];
                ItemStack item = new ItemStack(player.getInventory().getItemInMainHand());
     //           customItemData.put("test" + count, item);
                saveItemDataToMap(name , item);
                playerMessage(player, "You have " + item);
                playerMessage(player, "array " + getCustomItemData().size());
            } else {
                sender.sendMessage(ChatColor.RED + "Only players may use this command");
            }
        }
        if (command.getName().equalsIgnoreCase("test2")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
        //        String name = args[0];
          //      playerMessage(player, name + " exists? " + checkItemExistsMap(name));
                playerMessage(player, "array " + getCustomItemData().size());

            }
        }
        return true;
    }

    private void playerMessage(Player player, String message) {
        player.sendMessage(ChatColor.GOLD + "PlayerMessage: " + ChatColor.AQUA + message);
    }

    private void saveItemDataToMap(String name, ItemStack item) {
        getCustomItemData().put(name, item);
    }

    private boolean checkItemExistsMap(String name) {
        if ((getCustomItemData().containsKey(name))) {
            return true;
        }
        return false;
    }
}
