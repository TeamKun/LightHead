package net.kunmc.lab.lighthetadplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils
{

    public static boolean hasPermission(CommandSender perm, String permission)
    {
        if (perm.hasPermission(permission))
            return true;
        perm.sendMessage(ChatColor.RED + "エラー：権限がありません！");
        return false;
    }

    public static boolean isPlayer(CommandSender sender)
    {
        if (sender instanceof Player)
            return true;
        sender.sendMessage(ChatColor.RED + "エラー：プレイヤーから実行する必要があります。");
        return false;
    }

    public static Player getPlayerAllowOffline(String playerName)
    {
        Player player = Bukkit.getPlayer(playerName);
        if (player == null)
            for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers())
                if (offlinePlayer.getName() != null && offlinePlayer.getName().equalsIgnoreCase(playerName))
                    player = offlinePlayer.getPlayer();

        return player;
    }

    public static boolean invalidLengthMessage(CommandSender sender, String[] args, int min, int max)
    {
        if (args.length < min || args.length > max)
        {
            sender.sendMessage(ChatColor.RED + "エラー：引数の長さがおかしいです！");
            return false;
        }

        return true;
    }
}
