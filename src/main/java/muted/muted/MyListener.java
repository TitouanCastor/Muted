package muted.muted;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class MyListener implements Listener {
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        Player sender = event.getPlayer();

        event.viewers().removeIf(audience -> {
            if (audience instanceof Player viewer) {
                return MutedList.getInstance().isMuted(viewer.getName(), sender.getName());
            }
            return false;
        });

        BanWords banwords = BanWords.getInstance();
        event.viewers().removeIf(audience -> {
            if (audience instanceof Player viewer) {
                String plainMessage = PlainTextComponentSerializer.plainText().serialize(event.message());
                return banwords.getList(viewer.getName()).stream().anyMatch(plainMessage::contains);
            }
            return false;
        });
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        MutedList list = MutedList.getInstance();

        list.getMuted(player.getName()).clear();
    }
}
