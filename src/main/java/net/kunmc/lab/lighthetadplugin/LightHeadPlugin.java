package net.kunmc.lab.lighthetadplugin;

import net.kunmc.lab.lighthetadplugin.commands.HeadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class LightHeadPlugin extends JavaPlugin
{
    private static LightHeadPlugin plugin;

    public static LightHeadPlugin getPlugin()
    {
        return plugin;
    }

    @Override
    public void onEnable()
    {
        plugin = this;
        getCommand("head").setExecutor(new HeadCommand());
        getCommand("head").setTabCompleter(new HeadCommand());
    }
}
