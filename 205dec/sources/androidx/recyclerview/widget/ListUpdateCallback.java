package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ListUpdateCallback {
    void onChanged(int i4, int i5, @Nullable Object obj);

    void onInserted(int i4, int i5);

    void onMoved(int i4, int i5);

    void onRemoved(int i4, int i5);
}