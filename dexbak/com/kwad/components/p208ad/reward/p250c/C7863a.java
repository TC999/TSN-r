package com.kwad.components.p208ad.reward.p250c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.C7885f;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.C11128v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.reward.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7863a {

    /* renamed from: rh */
    private static volatile C7863a f26476rh;

    /* renamed from: qo */
    private C7907g f26477qo;
    @Nullable

    /* renamed from: ri */
    private C7864b f26478ri;

    /* renamed from: rj */
    private volatile boolean f26479rj = false;

    /* renamed from: rk */
    private volatile boolean f26480rk = false;

    /* renamed from: rl */
    private List<WeakReference<C9151h>> f26481rl = new CopyOnWriteArrayList();

    private C7863a() {
    }

    /* renamed from: gL */
    public static C7863a m32133gL() {
        if (f26476rh == null) {
            synchronized (C7863a.class) {
                if (f26476rh == null) {
                    f26476rh = new C7863a();
                }
            }
        }
        return f26476rh;
    }

    /* renamed from: gN */
    private synchronized boolean m32131gN() {
        boolean z;
        C7864b c7864b = this.f26478ri;
        if (c7864b != null) {
            z = c7864b.f26485rp == C7864b.f26482rm;
        }
        return z;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.f26477qo.mAdResultData.adGlobalConfigInfo;
        return adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1;
    }

    /* renamed from: M */
    public final void m32138M(Context context) {
        boolean m32131gN = m32131gN();
        C10331c.m26254d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + m32131gN + ", hadToast: " + this.f26480rk);
        if (this.f26480rk || !m32131gN) {
            return;
        }
        this.f26480rk = true;
        C11128v.m23672O(context, "恭喜获得第2份奖励");
    }

    /* renamed from: a */
    public final synchronized void m32136a(AdTemplate adTemplate, C7864b c7864b) {
        if (adTemplate == null) {
            return;
        }
        C10331c.m26254d("CurrentExtraRewardHolder", "updateExtraReward: " + c7864b.toJson().toString());
        this.f26478ri = c7864b;
        if (c7864b.f26485rp == C7864b.f26482rm && !this.f26479rj) {
            this.f26479rj = true;
            C7865c.m32128a(this.f26478ri, C7885f.m32095G(adTemplate.getUniqueId()));
            C9908c.m27300h(adTemplate, isNeoScan());
        }
        for (WeakReference<C9151h> weakReference : this.f26481rl) {
            if (weakReference.get() == null) {
                this.f26481rl.remove(weakReference);
            } else {
                C7864b m32132gM = m32132gM();
                C10331c.m26254d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + m32132gM.toJson().toString());
                weakReference.get().m29235a(m32132gM);
            }
        }
    }

    /* renamed from: c */
    public final synchronized void m32135c(AdTemplate adTemplate, int i) {
        C10331c.m26254d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        C7907g c7907g = this.f26477qo;
        if (c7907g != null && c7907g.m32001fN() && i == C7864b.STATUS_NONE) {
            C10331c.m26254d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        C7864b m32132gM = m32133gL().m32132gM();
        m32132gM.m32130M(i);
        m32133gL().m32136a(adTemplate, m32132gM);
    }

    @NonNull
    /* renamed from: gM */
    public final synchronized C7864b m32132gM() {
        if (this.f26478ri == null) {
            C7864b m32126gP = C7865c.m32126gP();
            this.f26478ri = m32126gP;
            m32126gP.f26485rp = 0;
        }
        C10331c.m26254d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.f26478ri.f26485rp);
        return this.f26478ri;
    }

    public final synchronized void reset() {
        this.f26478ri = null;
        this.f26480rk = false;
        this.f26479rj = false;
        this.f26477qo = null;
    }

    public final void setCallerContext(C7907g c7907g) {
        this.f26477qo = c7907g;
    }

    /* renamed from: a */
    public final void m32137a(C9151h c9151h) {
        C10331c.m26254d("CurrentExtraRewardHolder", "addGetNativeHandler: " + c9151h);
        if (c9151h != null) {
            this.f26481rl.add(new WeakReference<>(c9151h));
        }
    }
}
