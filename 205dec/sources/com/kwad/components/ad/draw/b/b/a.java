package com.kwad.components.ad.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private InterfaceC0555a cF;
    @Nullable
    private b cG;
    private boolean cH = false;
    private AdTemplate mAdTemplate;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0555a {
        void aq();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        boolean ar();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0555a interfaceC0555a) {
        this.cF = interfaceC0555a;
    }

    public final void ap() {
        InterfaceC0555a interfaceC0555a;
        if (this.cH) {
            return;
        }
        this.cH = true;
        if (e.dQ(this.mAdTemplate).status == 1 || e.dQ(this.mAdTemplate).status == 2 || e.dQ(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.cG;
        if ((bVar == null || !bVar.ar()) && (interfaceC0555a = this.cF) != null) {
            interfaceC0555a.aq();
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.cG = bVar;
    }
}
