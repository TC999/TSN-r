package androidx.databinding;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ObservableMap<K, V> extends Map<K, V> {

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
        public abstract void onMapChanged(T sender, K key);
    }

    void addOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> callback);

    void removeOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> callback);
}
