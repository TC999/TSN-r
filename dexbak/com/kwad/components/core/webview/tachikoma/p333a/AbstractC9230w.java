package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9230w implements InterfaceC10625a {

    /* renamed from: ZU */
    private InterfaceC10627c f29305ZU;
    @NonNull

    /* renamed from: ZV */
    private CopyOnWriteArrayList<InterfaceC9914b> f29306ZV = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    public final void m29171b(final InterfaceC9914b interfaceC9914b) {
        if (this.f29305ZU != null) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.a.w.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (AbstractC9230w.this.f29305ZU != null) {
                        AbstractC9230w.this.f29305ZU.mo25251a(interfaceC9914b);
                    }
                }
            });
        } else {
            this.f29306ZV.add(interfaceC9914b);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public void onDestroy() {
        this.f29305ZU = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29305ZU = interfaceC10627c;
        if (this.f29306ZV.size() > 0) {
            Iterator<InterfaceC9914b> it = this.f29306ZV.iterator();
            while (it.hasNext()) {
                InterfaceC9914b next = it.next();
                m29171b(next);
                this.f29306ZV.remove(next);
            }
        }
    }
}
