package muted.muted;

import java.util.*;

public class MutedList {
    private static final MutedList instance = new MutedList();

    private final Map<String, List<String>> muteMap = new HashMap<>();

    private MutedList() {}

    public static MutedList getInstance() {
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

    public boolean isMuted(String owner, String target) {
        List<String> muted = muteMap.get(owner);
        return muted != null && muted.contains(target);
    }

    public List<String> getMuted(String owner) {
        return muteMap.getOrDefault(owner, Collections.emptyList());
    }
}
