package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class ab implements w {
    private final SparseArray<Handler> afh = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bh(int i4) {
        return this.afh.get(i4) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void p(List<Integer> list) {
        for (Integer num : list) {
            b(this.afh.get(num.intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void va() {
        for (int i4 = 0; i4 < this.afh.size(); i4++) {
            a(this.afh.get(this.afh.keyAt(i4)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int vb() {
        return this.afh.size();
    }
}
