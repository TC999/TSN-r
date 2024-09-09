package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
interface ThreadUtil<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface BackgroundCallback<T> {
        void loadTile(int i4, int i5);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i4);

        void updateRange(int i4, int i5, int i6, int i7, int i8);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface MainThreadCallback<T> {
        void addTile(int i4, TileList.Tile<T> tile);

        void removeTile(int i4, int i5);

        void updateItemCount(int i4, int i5);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
