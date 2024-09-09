package com.kwad.components.ad.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements Runnable {
    private static final Handler nN = new Handler(Looper.getMainLooper());
    private static volatile boolean nR;
    private final long nO;
    private final AdTemplate nP;
    private boolean nQ = false;
    @Nullable
    private d nS;

    public c(@NonNull com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.nP = adTemplate;
        long cV = com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        this.nO = cV;
        com.kwad.sdk.core.e.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + cV);
    }

    static /* synthetic */ boolean access$002(boolean z3) {
        nR = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void eN() {
        d dVar;
        if (!b.eI().eK()) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        nR = false;
        if (this.nQ || (dVar = this.nS) == null || !dVar.eS()) {
            return;
        }
        this.nQ = true;
        this.nS.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.h.c.3
            @Override // com.kwad.components.ad.b.a.b
            public final void T() {
                y.aF(System.currentTimeMillis());
                e.eV().eR();
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void U() {
                com.kwad.sdk.core.e.c.d("PushAdManager", "onAdClose: ");
                e.eV().eT();
                b.eI().a(c.this);
            }
        });
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.nP)) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.nO + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.ag()) {
            a(1000001, this, this.nO);
        }
    }

    public final void eM() {
        com.kwad.sdk.core.e.c.w("PushAdManager", "startRequestPushAd processingPush: " + nR);
        if (nR || this.nP.mAdScene == null) {
            return;
        }
        nR = true;
        com.kwad.components.core.i.a.b(this.nP.mAdScene, new a.InterfaceC0636a() { // from class: com.kwad.components.ad.h.c.1
            @Override // com.kwad.components.core.i.a.InterfaceC0636a
            public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
                com.kwad.sdk.core.e.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list != null && list.size() > 0) {
                    AdTemplate adTemplate = list.get(0).getAdTemplate();
                    if (com.kwad.sdk.core.response.b.a.cT(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
                        com.kwad.sdk.core.e.c.d("PushAdManager", "loadPushTK");
                        Context context = ServiceProvider.getContext();
                        c.this.nS = new d(context, adTemplate);
                        return;
                    }
                    c.access$002(false);
                    com.kwad.sdk.core.e.c.d("PushAdManager", "pushAdInfo templateId invalid");
                    return;
                }
                c.access$002(false);
            }

            @Override // com.kwad.components.core.i.a.InterfaceC0636a
            public final void onError(int i4, String str) {
                com.kwad.sdk.core.e.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.i.a.InterfaceC0636a
            public final void onRequestResult(int i4) {
            }
        });
    }

    public final void eO() {
        com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: ");
        if (nN.hasMessages(1000001)) {
            return;
        }
        com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.nf().isShowing()) {
            com.kwad.components.core.e.a.e.nf().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.h.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void eP() {
                    com.kwad.components.core.e.a.e.nf().b(this);
                    c.this.eN();
                }
            });
        } else {
            eN();
        }
    }

    private static void a(int i4, Runnable runnable, long j4) {
        Handler handler = nN;
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i4;
        handler.sendMessageDelayed(obtain, j4);
    }
}
