package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7990p extends C9072ak {

    /* renamed from: qh */
    private WeakReference<C7907g> f26693qh;

    /* renamed from: xm */
    private long f26694xm;

    /* renamed from: xn */
    private String f26695xn;

    public C7990p(C7907g c7907g, String str, long j, C10605b c10605b) {
        super(c10605b);
        this.f26695xn = str;
        this.f26694xm = j;
        if (c7907g != null) {
            this.f26693qh = new WeakReference<>(c7907g);
        }
    }

    /* renamed from: Q */
    private static boolean m31903Q(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.C9072ak
    /* renamed from: b */
    public final void mo29305b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable C9913b c9913b) {
        C7955b.m31926a(z, adTemplate, null, c9913b);
    }

    /* renamed from: b */
    private boolean m31901b(C9072ak.C9074b c9074b) {
        WeakReference<C7907g> weakReference;
        if (c9074b.getActionType() == 140 && C10251d.m26501yT() && m31903Q(c9074b.m29297sp()) && (weakReference = this.f26693qh) != null && weakReference.get() != null) {
            final C7907g c7907g = this.f26693qh.get();
            C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.k.p.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    c7907g.m31990x(C7990p.this.f26695xn);
                }
            }, 1500L);
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.jshandler.C9072ak
    /* renamed from: a */
    public final void mo29307a(@NonNull C9072ak.C9074b c9074b) {
        if (m31901b(c9074b)) {
            return;
        }
        super.mo29307a(c9074b);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9072ak
    /* renamed from: a */
    public final void mo29306a(C9913b c9913b) {
        super.mo29306a(c9913b);
        WeakReference<C7907g> weakReference = this.f26693qh;
        if (weakReference != null && weakReference.get() != null) {
            c9913b.m27269ah(this.f26693qh.get().f26529oJ.getPlayDuration());
            return;
        }
        long j = this.f26694xm;
        if (j > 0) {
            c9913b.m27269ah(j);
        }
    }
}
