package com.kwad.components.p208ad.reward.p253f;

import androidx.annotation.NonNull;
import com.kwad.components.core.video.InterfaceC8996g;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.components.p208ad.p246j.AbstractC7812a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p434g.InterfaceC10761a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.reward.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7897a extends AbstractC7812a<InterfaceC8996g> {

    /* renamed from: eV */
    private IAdLivePlayModule f26508eV;

    /* renamed from: rB */
    private List<InterfaceC8996g> f26509rB;

    /* renamed from: rC */
    private long f26510rC;

    /* renamed from: rD */
    private AdLivePlayStateListener f26511rD;

    public C7897a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.f26509rB = new CopyOnWriteArrayList();
        this.f26510rC = 30000L;
        this.f26511rD = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* bridge */ /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    /* renamed from: c */
                    private static void m32071c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32071c(interfaceC8996g);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    /* renamed from: c */
                    private static void m32070c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onLivePlayEnd();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32070c(interfaceC8996g);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    /* renamed from: c */
                    private static void m32072c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onMediaPlayPaused();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32072c(interfaceC8996g);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    /* renamed from: c */
                    public void accept(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onMediaPlayProgress(C7897a.this.f26510rC, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    /* renamed from: c */
                    private static void m32073c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onLivePlayResume();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32073c(interfaceC8996g);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    /* renamed from: c */
                    private static void m32074c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32074c(interfaceC8996g);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                C7897a.this.m32079a(new InterfaceC10761a<InterfaceC8996g>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    /* renamed from: c */
                    private static void m32076c(InterfaceC8996g interfaceC8996g) {
                        interfaceC8996g.onMediaPrepared();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8996g interfaceC8996g) {
                        m32076c(interfaceC8996g);
                    }
                });
            }
        };
        this.f26508eV = iAdLivePlayModule;
        if (C10487e.m25647dK(adTemplate) == 2) {
            this.f26510rC = C10483a.m25929ag(C10487e.m25641dQ(adTemplate));
        }
        this.f26508eV.registerAdLivePlayStateListener(this.f26511rD);
    }

    /* renamed from: gU */
    private void m32077gU() {
        try {
            this.f26509rB.clear();
            this.f26508eV.unRegisterAdLivePlayStateListener(this.f26511rD);
            this.f26508eV.onDestroy();
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.f26508eV.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final long getPlayDuration() {
        return this.f26508eV.getPlayDuration();
    }

    public final void onPause() {
        this.f26508eV.onPause();
    }

    public final void onResume() {
        this.f26508eV.onResume();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void pause() {
        this.f26508eV.pause();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.f26508eV.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void release() {
        super.release();
        m32077gU();
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.f26508eV.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        this.f26508eV.resume();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f26508eV.setAudioEnabled(z, z2);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void skipToEnd() {
        this.f26508eV.skipToEnd();
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.f26508eV.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo31844a(InterfaceC8996g interfaceC8996g) {
        if (interfaceC8996g != null) {
            this.f26509rB.remove(interfaceC8996g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32079a(InterfaceC10761a<InterfaceC8996g> interfaceC10761a) {
        if (interfaceC10761a != null) {
            for (InterfaceC8996g interfaceC8996g : this.f26509rB) {
                interfaceC10761a.accept(interfaceC8996g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo31843b(InterfaceC8996g interfaceC8996g) {
        if (interfaceC8996g != null) {
            this.f26509rB.add(interfaceC8996g);
        }
    }
}
