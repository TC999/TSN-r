package com.kwad.components.p208ad.p236h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.p289e.p290a.AbstractC8581c;
import com.kwad.components.core.p289e.p290a.C8583e;
import com.kwad.components.core.p298i.C8665a;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11137y;
import java.util.List;

/* renamed from: com.kwad.components.ad.h.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RunnableC7670c implements Runnable {

    /* renamed from: nN */
    private static final Handler f25987nN = new Handler(Looper.getMainLooper());

    /* renamed from: nR */
    private static volatile boolean f25988nR;

    /* renamed from: nO */
    private final long f25989nO;

    /* renamed from: nP */
    private final AdTemplate f25990nP;

    /* renamed from: nQ */
    private boolean f25991nQ = false;
    @Nullable

    /* renamed from: nS */
    private C7674d f25992nS;

    public RunnableC7670c(@NonNull InterfaceC8677a interfaceC8677a) {
        AdTemplate adTemplate = interfaceC8677a.getAdTemplate();
        this.f25990nP = adTemplate;
        long m25832cV = C10483a.m25832cV(C10487e.m25641dQ(adTemplate));
        this.f25989nO = m25832cV;
        C10331c.m26254d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + m25832cV);
    }

    static /* synthetic */ boolean access$002(boolean z) {
        f25988nR = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* renamed from: eN */
    public void m32677eN() {
        C7674d c7674d;
        if (!C7668b.m32688eI().m32686eK()) {
            C10331c.m26254d("PushAdManager", "run preCheckResult false");
            return;
        }
        f25988nR = false;
        if (this.f25991nQ || (c7674d = this.f25992nS) == null || !c7674d.m32670eS()) {
            return;
        }
        this.f25991nQ = true;
        this.f25992nS.m32673c(new InterfaceC7342b() { // from class: com.kwad.components.ad.h.c.3
            @Override // com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b
            /* renamed from: T */
            public final void mo32675T() {
                C11137y.m23609aF(System.currentTimeMillis());
                C7678e.m32662eV().m32664eR();
            }

            @Override // com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b
            /* renamed from: U */
            public final void mo30303U() {
                C10331c.m26254d("PushAdManager", "onAdClose: ");
                C7678e.m32662eV().m32663eT();
                C7668b.m32688eI().m32693a(RunnableC7670c.this);
            }
        });
    }

    /* renamed from: d */
    public final void m32679d(InterfaceC8677a interfaceC8677a) {
        AdTemplate adTemplate = interfaceC8677a.getAdTemplate();
        if (!adTemplate.equals(this.f25990nP)) {
            C10331c.m26254d("PushAdManager", "onAdExit not current ad");
            return;
        }
        C10331c.m26254d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.f25989nO + ", adTemplate: " + adTemplate.hashCode());
        if (interfaceC8677a.mo30033ag()) {
            m32682a(1000001, this, this.f25989nO);
        }
    }

    /* renamed from: eM */
    public final void m32678eM() {
        C10331c.m26246w("PushAdManager", "startRequestPushAd processingPush: " + f25988nR);
        if (f25988nR || this.f25990nP.mAdScene == null) {
            return;
        }
        f25988nR = true;
        C8665a.m30043b(this.f25990nP.mAdScene, new C8665a.InterfaceC8672a() { // from class: com.kwad.components.ad.h.c.1
            @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
            /* renamed from: e */
            public final void mo30038e(@Nullable List<C8674c> list) {
                C10331c.m26254d("PushAdManager", "onInnerAdLoad: " + list);
                if (list != null && list.size() > 0) {
                    AdTemplate adTemplate = list.get(0).getAdTemplate();
                    if (C10483a.m25834cT(C10487e.m25641dQ(adTemplate))) {
                        C10331c.m26254d("PushAdManager", "loadPushTK");
                        Context context = ServiceProvider.getContext();
                        RunnableC7670c.this.f25992nS = new C7674d(context, adTemplate);
                        return;
                    }
                    RunnableC7670c.access$002(false);
                    C10331c.m26254d("PushAdManager", "pushAdInfo templateId invalid");
                    return;
                }
                RunnableC7670c.access$002(false);
            }

            @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
            public final void onError(int i, String str) {
                C10331c.m26254d("PushAdManager", "onError: " + str);
                RunnableC7670c.access$002(false);
            }

            @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
            public final void onRequestResult(int i) {
            }
        });
    }

    /* renamed from: eO */
    public final void m32676eO() {
        C10331c.m26254d("PushAdManager", "onOutSDKPage: ");
        if (f25987nN.hasMessages(1000001)) {
            return;
        }
        C10331c.m26254d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        m32682a(1000002, this, 500L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C8583e.m30309nf().isShowing()) {
            C8583e.m30309nf().m30321a(new AbstractC8581c() { // from class: com.kwad.components.ad.h.c.2
                @Override // com.kwad.components.core.p289e.p290a.AbstractC8581c, com.kwad.components.core.p289e.p290a.InterfaceC8580b
                /* renamed from: eP */
                public final void mo30302eP() {
                    C8583e.m30309nf().m30314b(this);
                    RunnableC7670c.this.m32677eN();
                }
            });
        } else {
            m32677eN();
        }
    }

    /* renamed from: a */
    private static void m32682a(int i, Runnable runnable, long j) {
        Handler handler = f25987nN;
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i;
        handler.sendMessageDelayed(obtain, j);
    }
}
