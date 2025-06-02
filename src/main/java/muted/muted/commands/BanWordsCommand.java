package muted.muted.commands;

import muted.muted.BanWords;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

public class BanWordsCommand extends BukkitCommand {

    public BanWordsCommand() {
        super("banwords");
        setDescription("Supprime les messages contenant des mots bannis");
        setUsage("/banwords + <add> | <remove> | <list> + [mot à bannir]");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
            listBanWords(sender, args);
            return true;
        }
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /banwords + <add> | <remove> | <list> + [mot à bannir]");
            return true;
        }
        if (args[0].equalsIgnoreCase("add")) {
            addBanWord(sender, args);
        }
        if (args[0].equalsIgnoreCase("remove")) {
            rmBanWord(sender, args);
        }
        return true;
    }

    static void addBanWord(CommandSender sender, String[] args) {
        BanWords banwords = BanWords.getInstance();

        if (banwords.isBanned(sender.getName(), args[1])) {
            sender.sendMessage(ChatColor.YELLOW + "Ce mot est déja banni.");
            return;
        }
        sender.sendMessage(ChatColor.GREEN + "Tu ne verras plus les messages contenant le mot [" + args[1] + "].");
        banwords.add(sender.getName(), args[1]);
    }

    static void rmBanWord(CommandSender sender, String[] args) {
        BanWords banwords = BanWords.getInstance();

        if (!(banwords.isBanned(sender.getName(), args[1]))) {
            sender.sendMessage(ChatColor.YELLOW + "Ce mot n'est pas banni.");
            return;
        }
        sender.sendMessage(ChatColor.GREEN + "Tu verras les messages contenant le mot [" + args[1] + "].");
        banwords.del(sender.getName(), args[1]);
    }

    static void listBanWords(CommandSender sender, String[] args) {
        BanWords banwords = BanWords.getInstance();

        sender.sendMessage(ChatColor.AQUA + "Liste des mots bannis:");
        for (String str : banwords.getList(sender.getName())) {
            sender.sendMessage("• " + str);
        }
    }
}