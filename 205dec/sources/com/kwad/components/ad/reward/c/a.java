package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    private static volatile a rh;
    private g qo;
    @Nullable
    private b ri;
    private volatile boolean rj = false;
    private volatile boolean rk = false;
    private List<WeakReference<h>> rl = new CopyOnWriteArrayList();

    private a() {
    }

    public static a gL() {
        if (rh == null) {
            synchronized (a.class) {
                if (rh == null) {
                    rh = new a();
                }
            }
        }
        return rh;
    }

    private synchronized boolean gN() {
        boolean z3;
        b bVar = this.ri;
        if (bVar != null) {
            z3 = bVar.rp == b.rm;
        }
        return z3;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.qo.mAdResultData.adGlobalConfigInfo;
        return adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1;
    }

    public final void M(Context context) {
        boolean gN = gN();
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gN + ", hadToast: " + this.rk);
        if (this.rk || !gN) {
            return;
        }
        this.rk = true;
        v.O(context, "\u606d\u559c\u83b7\u5f97\u7b2c2\u4efd\u5956\u52b1");
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.ri = bVar;
        if (bVar.rp == b.rm && !this.rj) {
            this.rj = true;
            c.a(this.ri, com.kwad.components.ad.reward.e.f.G(adTemplate.getUniqueId()));
            com.kwad.sdk.core.adlog.c.h(adTemplate, isNeoScan());
        }
        for (WeakReference<h> weakReference : this.rl) {
            if (weakReference.get() == null) {
                this.rl.remove(weakReference);
            } else {
                b gM = gM();
                com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gM.toJson().toString());
                weakReference.get().a(gM);
            }
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i4) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i4);
        g gVar = this.qo;
        if (gVar != null && gVar.fN() && i4 == b.STATUS_NONE) {
            com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b gM = gL().gM();
        gM.M(i4);
        gL().a(adTemplate, gM);
    }

    @NonNull
    public final synchronized b gM() {
        if (this.ri == null) {
            b gP = c.gP();
            this.ri = gP;
            gP.rp = 0;
        }
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.ri.rp);
        return this.ri;
    }

    public final synchronized void reset() {
        this.ri = null;
        this.rk = false;
        this.rj = false;
        this.qo = null;
    }

    public final void setCallerContext(g gVar) {
        this.qo = gVar;
    }

    public final void a(h hVar) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + hVar);
        if (hVar != null) {
            this.rl.add(new WeakReference<>(hVar));
        }
    }
}
