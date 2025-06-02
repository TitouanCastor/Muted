package muted.muted.commands;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import muted.muted.MutedList;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class MuteCommand extends BukkitCommand {

    public MuteCommand() {
        super("mute");
        setDescription("Mute un joueur");
        setUsage("/mute <joueur>");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Veuillez entrer un joueur.");
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Veuillez entrer un seul joueur.");
            return true;
        }
        String ToMute = args[0];
        String WhoMute = sender.getName();

        MutedList list = MutedList.getInstance();

        int isConnected = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals(ToMute))
                isConnected = 1;
        }

        if (ToMute.equals(WhoMute)) {
            sender.sendMessage(ChatColor.YELLOW + "T'es un petit rigolo toi.");
            return true;
        }
        if (isConnected == 0) {
            sender.sendMessage(ChatColor.YELLOW + ToMute + " n'est pas connecté.");
            return true;
        };
        if (list.isMuted(WhoMute, ToMute)) {
            sender.sendMessage(ChatColor.YELLOW + ToMute + " est déja mute.");
            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "Tu ne verras plus les messages de " + args[0] + ".");
        list.add(WhoMute, ToMute);
        return true;
    }
}
