package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ListUpdateCallback {
    void onChanged(int i, int i2, @Nullable Object obj);

    void onInserted(int i, int i2);

    void onMoved(int i, int i2);

    void onRemoved(int i, int i2);
}
