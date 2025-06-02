package muted.muted.commands;

import muted.muted.MutedList;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListmuteCommand extends BukkitCommand {

    public ListmuteCommand() {
        super("listmute");
        setDescription("Affiche la liste des joueurs mute");
        setUsage("/listmute");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        MutedList mutedlist = MutedList.getInstance();
        List<String> list = mutedlist.getMuted(sender.getName());

        sender.sendMessage(ChatColor.AQUA + "Liste des joueurs que tu as mute:\n");
        for (String element : list)
            sender.sendMessage("• " + element);
        return true;
    }
}