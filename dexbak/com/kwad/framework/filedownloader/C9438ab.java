package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.ab */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9438ab implements InterfaceC9579w {
    private final SparseArray<Handler> afh = new SparseArray<>();

    /* renamed from: a */
    private static void m28806a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    /* renamed from: b */
    private static void m28805b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9579w
    /* renamed from: bh */
    public final boolean mo28334bh(int i) {
        return this.afh.get(i) != null;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9579w
    /* renamed from: p */
    public final void mo28333p(List<Integer> list) {
        for (Integer num : list) {
            m28805b(this.afh.get(num.intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9579w
    /* renamed from: va */
    public final void mo28332va() {
        for (int i = 0; i < this.afh.size(); i++) {
            m28806a(this.afh.get(this.afh.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9579w
    /* renamed from: vb */
    public final int mo28331vb() {
        return this.afh.size();
    }
}
