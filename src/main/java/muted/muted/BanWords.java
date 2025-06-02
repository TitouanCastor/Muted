package muted.muted;

import java.util.*;

public class BanWords {
    private static final BanWords instance = new BanWords();

    private final Map<String, List<String>> muteMap = new HashMap<>();

    private BanWords() {}

    public static BanWords getInstance() {
        return instance;
    }

    public void add(String owner, String target) {
        muteMap.computeIfAbsent(owner, k -> new ArrayList<>()).add(target);
    }

    public void del(String owner, String target) {
        List<String> muted = muteMap.get(owner);
        if (muted != null) {
            muted.remove(target);
        }
    }

    public boolean isBanned(String owner, String toBan) {
        List<String> muted = muteMap.get(owner);
        return muted != null && muted.contains(toBan);
    }

    public List<String> getList(String owner) {
        return muteMap.getOrDefault(owner, Collections.emptyList());
    }
}
