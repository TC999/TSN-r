package androidx.databinding;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ObservableList<T> extends List<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T sender);

        public abstract void onItemRangeChanged(T sender, int positionStart, int itemCount);

        public abstract void onItemRangeInserted(T sender, int positionStart, int itemCount);

        public abstract void onItemRangeMoved(T sender, int fromPosition, int toPosition, int itemCount);

        public abstract void onItemRangeRemoved(T sender, int positionStart, int itemCount);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> callback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> callback);
}
