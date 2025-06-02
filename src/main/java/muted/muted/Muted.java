package muted.muted;

import muted.muted.commands.BanWordsCommand;
import muted.muted.commands.MuteCommand;
import muted.muted.commands.UnmuteCommand;
import muted.muted.commands.ListmuteCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandMap;
import org.bukkit.Bukkit;

public final class Muted extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        CommandMap commandMap = Bukkit.getServer().getCommandMap();
        commandMap.register("mute", new MuteCommand());
        commandMap.register("unmute", new UnmuteCommand());
        commandMap.register("listmute", new ListmuteCommand());
        commandMap.register("banwords", new BanWordsCommand());
    }
}
