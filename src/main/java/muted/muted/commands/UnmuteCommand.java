package muted.muted.commands;

import muted.muted.MutedList;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class UnmuteCommand extends BukkitCommand {

    public UnmuteCommand() {
        super("demute");
        setDescription("Demute un joueur");
        setUsage("/unmute <joueur>");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Veuillez entrer un joueur");
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Veuillez entrer un seul joueur");
            return true;
        }

        String toUnmute = args[0];
        String whoUnmutes = sender.getName();

        MutedList list = MutedList.getInstance();

        if (!list.isMuted(whoUnmutes, toUnmute)) {
            sender.sendMessage(ChatColor.YELLOW + toUnmute + " n'est pas mute.");
            return true;
        }

        list.del(whoUnmutes, toUnmute);
        sender.sendMessage(ChatColor.GREEN + "Tu peux maintenant revoir les messages de " + toUnmute);
        return true;
    }
}