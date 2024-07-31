package com.kwad.components.p208ad.reward.p258k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.ad.reward.k.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7992q extends C9185x {

    /* renamed from: vz */
    private long f26698vz;

    /* renamed from: xp */
    private WeakReference<C7907g> f26699xp;

    public C7992q(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable C7907g c7907g, long j, @Nullable InterfaceC10635a interfaceC10635a, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(c10605b, c8619c, interfaceC10635a, onDismissListener);
        this.f26698vz = j;
        if (c7907g != null) {
            this.f26699xp = new WeakReference<>(c7907g);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.C9185x
    /* renamed from: a */
    public final C8615a.C8616a mo29207a(C8615a.C8616a c8616a, C10640a c10640a, AdTemplate adTemplate) {
        WeakReference<C7907g> weakReference = this.f26699xp;
        long j = 0;
        if (weakReference != null && weakReference.get() != null) {
            j = this.f26699xp.get().f26529oJ.getPlayDuration();
        } else {
            long j2 = this.f26698vz;
            if (j2 > 0) {
                j = j2;
            }
        }
        return super.mo29207a(c8616a, c10640a, adTemplate).m30157w(j);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9185x
    /* renamed from: jh */
    public final void mo29195jh() {
        super.mo29195jh();
        if (this.f29270Wf != null) {
            C7863a.m32133gL().m32135c(this.f29270Wf.getAdTemplate(), C7864b.STATUS_NONE);
        }
    }
}
