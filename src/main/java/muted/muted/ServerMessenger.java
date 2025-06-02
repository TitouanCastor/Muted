package muted.muted;

import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class ServerMessenger {
    public static void broadcast(String message) {
        BanWords banwords = BanWords.getInstance();

        for (Player viewer : Bukkit.getOnlinePlayers()) {
            boolean allowed = banwords.getList(viewer.getName())
                    .stream()
                    .noneMatch(banned -> message.toLowerCase().contains(banned.toLowerCase()));

            if (allowed) {
                viewer.sendMessage(message);
            }
        }
    }
}
