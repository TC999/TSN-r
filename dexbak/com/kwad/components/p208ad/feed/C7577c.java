package com.kwad.components.p208ad.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b;
import com.kwad.components.model.FeedType;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.components.p208ad.feed.p226b.AbstractView$OnClickListenerC7506c;
import com.kwad.components.p208ad.feed.p226b.C7566n;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7535m;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11102k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.components.ad.feed.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7577c extends AbstractKsFeedAd implements InterfaceC8677a {

    /* renamed from: dQ */
    private KsFeedAd.AdInteractionListener f25804dQ;

    /* renamed from: dR */
    private AbstractDialogInterface$OnDismissListenerC9367b f25805dR;

    /* renamed from: dS */
    private C7566n f25806dS;

    /* renamed from: dT */
    private boolean f25807dT;

    /* renamed from: dU */
    private final KsAdVideoPlayConfig f25808dU;
    private final AdInfo mAdInfo;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: dV */
    private AtomicBoolean f25809dV = new AtomicBoolean(false);

    /* renamed from: dW */
    private AtomicBoolean f25810dW = new AtomicBoolean(false);

    /* renamed from: dX */
    private AtomicInteger f25811dX = new AtomicInteger(2);

    /* renamed from: bZ */
    private C8679c f25803bZ = new C8679c();

    /* renamed from: bT */
    private AbstractC10384b f25802bT = new AbstractC10384b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ah */
        public final void mo26184ah() {
            C7577c.this.f25803bZ.m30027h(C7577c.this);
        }

        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ai */
        public final void mo26183ai() {
            C7577c.this.f25803bZ.m30026i(C7577c.this);
        }
    };

    /* renamed from: com.kwad.components.ad.feed.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7585a {
        /* renamed from: c */
        void mo32830c(int i, String str);
    }

    public C7577c(@NonNull AdResultData adResultData, boolean z) {
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        m25661n.mInitVoiceStatus = 1;
        this.mAdInfo = C10487e.m25641dQ(m25661n);
        this.f25807dT = z;
        this.f25808dU = new KSAdVideoPlayConfigImpl();
        C7668b.m32688eI().m32692a(this);
    }

    @Nullable
    /* renamed from: C */
    private AbstractDialogInterface$OnDismissListenerC9367b<?, ?> m32855C(Context context) {
        AbstractDialogInterface$OnDismissListenerC9367b<?, ?> m33145a;
        int width = this.mAdTemplate.mAdScene.getWidth();
        double m26525a = C10251d.m26525a(C10250c.asN);
        double screenWidth = C11102k.getScreenWidth(context);
        Double.isNaN(screenWidth);
        if (width < m26525a * screenWidth) {
            int m25875be = C10483a.m25875be(this.mAdInfo);
            AdTemplate adTemplate = this.mAdTemplate;
            C7601b.m32821a(width, m25875be, adTemplate.type, adTemplate);
        }
        if (C10484b.m25777cO(this.mAdTemplate)) {
            C7566n c7566n = new C7566n(C10887l.wrapContextIfNeed(context));
            this.f25806dS = c7566n;
            c7566n.setWidth(width);
            this.f25806dS.setVideoPlayConfig(this.f25808dU);
            m33145a = this.f25806dS;
        } else if (this.f25807dT && C10484b.m25778cN(this.mAdTemplate)) {
            try {
                context = C10887l.wrapContextIfNeed(context);
                View$OnClickListenerC7535m view$OnClickListenerC7535m = new View$OnClickListenerC7535m(context);
                view$OnClickListenerC7535m.setWidth(width);
                view$OnClickListenerC7535m.setVideoPlayConfig(this.f25808dU);
                m33145a = view$OnClickListenerC7535m;
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
                m33145a = null;
            }
        } else {
            m33145a = C7499b.m33145a(context, FeedType.fromInt(this.mAdTemplate.type), C10483a.m25875be(this.mAdInfo));
        }
        if (m33145a != null) {
            if (!(m33145a instanceof C7566n)) {
                m33145a.setMargin(C10751a.m24924a(context, 16.0f));
            }
            m33145a.setPageExitListener(this.f25802bT);
        }
        return m33145a;
    }

    /* renamed from: aS */
    private void m32850aS() {
        if (this.mAdTemplate != null) {
            C10291a m26395Dc = C10291a.m26395Dc();
            m26395Dc.remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.f25808dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return C10483a.m25888bT(this.mAdInfo);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return C10483a.m25944aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !C10829k.m24699zd().m24700ys()) {
            return null;
        }
        try {
            Context wrapContextIfNeed = C10887l.wrapContextIfNeed(context);
            C10819a.m24739ak("feed", TTLogUtil.TAG_EVENT_SHOW);
            C9828c.m27589by(this.mAdTemplate);
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b != null) {
                if (abstractDialogInterface$OnDismissListenerC9367b.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f25805dR.getParent()).removeView(this.f25805dR);
                }
                C10819a.m24738al("feed", TTLogUtil.TAG_EVENT_SHOW);
                return this.f25805dR;
            }
            m32850aS();
            this.mAdTemplate.loadType = 1;
            AbstractDialogInterface$OnDismissListenerC9367b<?, ?> m32855C = m32855C(wrapContextIfNeed);
            this.f25805dR = m32855C;
            if (m32855C == null) {
                C10819a.m24738al("feed", TTLogUtil.TAG_EVENT_SHOW);
                return null;
            }
            m32855C.mo28891b((AbstractDialogInterface$OnDismissListenerC9367b<?, ?>) this.mAdResultData);
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b2 = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b2 instanceof AbstractView$OnClickListenerC7506c) {
                ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b2).m33124a(this.f25808dU);
            }
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b3 = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b3 instanceof View$OnClickListenerC7535m) {
                m32851a(abstractDialogInterface$OnDismissListenerC9367b3, false);
            } else {
                m32851a(abstractDialogInterface$OnDismissListenerC9367b3, true);
            }
            C10819a.m24738al("feed", TTLogUtil.TAG_EVENT_SHOW);
            return this.f25805dR;
        } catch (Throwable th) {
            if (C10829k.m24699zd().m24703yp()) {
                ServiceProvider.reportSdkCaughtException(th);
                return null;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return C10483a.m25945aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return C10483a.m25875be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (C10251d.m26570BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void render(final KsFeedAd.AdRenderListener adRenderListener) {
        if (this.f25810dW.get()) {
            if (this.f25805dR == null) {
                C10419e c10419e = C10419e.avD;
                adRenderListener.onAdRenderFailed(c10419e.errorCode, c10419e.msg);
                this.f25810dW.set(false);
                this.f25809dV.set(false);
                return;
            }
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.c.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    adRenderListener.onAdRenderSuccess(C7577c.this.f25805dR);
                    C7601b.m32822a(2, C7577c.this.mAdTemplate, C10483a.m25878bb(C7577c.this.mAdInfo), C7577c.this.f25811dX.get());
                }
            });
        } else if (this.f25809dV.get()) {
        } else {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            C7601b.m32802e(this.mAdTemplate);
            final int i = C10484b.m25777cO(this.mAdTemplate) ? 3 : 2;
            this.f25809dV.set(true);
            m32854a(new InterfaceC7585a() { // from class: com.kwad.components.ad.feed.c.3
                @Override // com.kwad.components.p208ad.feed.C7577c.InterfaceC7585a
                /* renamed from: c */
                public final void mo32830c(int i2, String str) {
                    C7601b.m32816a(C7577c.this.getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                    C7577c.this.f25811dX.set(i2);
                    C7577c.this.f25810dW.set(true);
                    try {
                        if (adRenderListener != null) {
                            if (C7577c.this.f25805dR == null) {
                                KsFeedAd.AdRenderListener adRenderListener2 = adRenderListener;
                                C10419e c10419e2 = C10419e.avD;
                                adRenderListener2.onAdRenderFailed(c10419e2.errorCode, c10419e2.msg);
                            } else {
                                C11064bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        C75803 c75803 = C75803.this;
                                        adRenderListener.onAdRenderSuccess(C7577c.this.f25805dR);
                                        C7601b.m32822a(2, C7577c.this.mAdTemplate, C10483a.m25878bb(C7577c.this.mAdInfo), C7577c.this.f25811dX.get());
                                    }
                                });
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f25804dQ = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    @SuppressLint({"WrongConstant"})
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.f25808dU.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.f25808dU.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.f25808dU.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.f25808dU.setDataFlowAutoStart(C10251d.m26550Ce());
                try {
                    this.f25808dU.setVideoAutoPlayType(0);
                } catch (NoSuchMethodError unused) {
                } catch (Throwable th) {
                    C8571a.reportSdkCaughtException(th);
                }
            }
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b instanceof View$OnClickListenerC7535m) {
                ((View$OnClickListenerC7535m) abstractDialogInterface$OnDismissListenerC9367b).setVideoPlayConfig(this.f25808dU);
            }
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b2 = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b2 instanceof C7566n) {
                ((C7566n) abstractDialogInterface$OnDismissListenerC9367b2).setVideoPlayConfig(this.f25808dU);
            }
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b3 = this.f25805dR;
            if (abstractDialogInterface$OnDismissListenerC9367b3 instanceof AbstractView$OnClickListenerC7506c) {
                ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b3).setVideoPlayConfig(this.f25808dU);
            }
        }
        if (isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        this.f25808dU.setVideoSoundEnable(z);
        if (this.f25808dU.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f25803bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j2);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f25803bZ.m30029a(interfaceC8678b);
    }

    /* renamed from: a */
    public final void m32854a(@NonNull final InterfaceC7585a interfaceC7585a) {
        C10819a.m24734g("feed", TTLogUtil.TAG_EVENT_SHOW, "feed_preload_view");
        Context context = ServiceProvider.getContext();
        this.mAdTemplate.loadType = 2;
        this.f25809dV.set(true);
        AbstractDialogInterface$OnDismissListenerC9367b<?, ?> m32855C = m32855C(context);
        this.f25805dR = m32855C;
        if (m32855C != null) {
            if (m32855C instanceof View$OnClickListenerC7535m) {
                View$OnClickListenerC7535m view$OnClickListenerC7535m = (View$OnClickListenerC7535m) m32855C;
                view$OnClickListenerC7535m.setPreloadListener(new View$OnClickListenerC7535m.InterfaceC7565a() { // from class: com.kwad.components.ad.feed.c.4
                    @Override // com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7535m.InterfaceC7565a
                    /* renamed from: c */
                    public final void mo32843c(int i, String str) {
                        C7577c c7577c = C7577c.this;
                        c7577c.m32851a(c7577c.f25805dR, false);
                        C7577c.this.f25810dW.set(true);
                        interfaceC7585a.mo32830c(i, str);
                    }
                });
                view$OnClickListenerC7535m.mo28891b(this.mAdResultData);
            } else if (m32855C instanceof C7566n) {
                C7566n c7566n = (C7566n) m32855C;
                c7566n.setTKLoadListener(new C7566n.InterfaceC7576a() { // from class: com.kwad.components.ad.feed.c.5
                    @Override // com.kwad.components.p208ad.feed.p226b.C7566n.InterfaceC7576a
                    /* renamed from: c */
                    public final void mo32842c(int i, String str) {
                        C7577c c7577c = C7577c.this;
                        c7577c.m32851a(c7577c.f25805dR, false);
                        C7577c.this.f25810dW.set(true);
                        interfaceC7585a.mo32830c(i, str);
                    }
                });
                c7566n.mo28891b(this.mAdResultData);
            } else {
                m32855C.mo28891b((AbstractDialogInterface$OnDismissListenerC9367b<?, ?>) this.mAdResultData);
                AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25805dR;
                if (abstractDialogInterface$OnDismissListenerC9367b instanceof AbstractView$OnClickListenerC7506c) {
                    ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b).m33124a(this.f25808dU);
                }
                m32851a(this.f25805dR, true);
                this.f25810dW.set(true);
                interfaceC7585a.mo32830c(1, "");
            }
        } else {
            this.f25810dW.set(false);
            this.f25809dV.set(false);
            interfaceC7585a.mo32830c(1, "render Failed");
        }
        C10819a.m24732h("feed", TTLogUtil.TAG_EVENT_SHOW, "feed_preload_view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32851a(final AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b, final boolean z) {
        if (abstractDialogInterface$OnDismissListenerC9367b == null) {
            return;
        }
        abstractDialogInterface$OnDismissListenerC9367b.setInnerAdInteractionListener(new AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a() { // from class: com.kwad.components.ad.feed.c.6
            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdClicked() {
                if (C7577c.this.f25804dQ != null) {
                    C7577c.this.f25804dQ.onAdClicked();
                }
                C7601b.m32822a(4, C7577c.this.mAdTemplate, C10483a.m25878bb(C7577c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdShow() {
                C7601b.m32800f(C7577c.this.mAdTemplate);
                C9828c.m27588bz(C7577c.this.mAdTemplate);
                if (C7577c.this.f25804dQ != null) {
                    C7577c.this.f25804dQ.onAdShow();
                }
                C7601b.m32822a(3, C7577c.this.mAdTemplate, C10483a.m25878bb(C7577c.this.mAdInfo), z ? 1 : 2);
                if (z) {
                    C9913b c9913b = new C9913b();
                    C9893a.C9894a c9894a = new C9893a.C9894a();
                    FeedType fromInt = FeedType.fromInt(C7577c.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c9894a.templateId = String.valueOf(fromInt.getType());
                    c9913b.m27268b(c9894a);
                    c9913b.m27245v(C7577c.this.f25805dR.getHeight(), C7577c.this.f25805dR.getWidth());
                    C8934b.m29570qY().m29571a(C7577c.this.mAdTemplate, null, c9913b);
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDislikeClicked() {
                if (C7577c.this.f25804dQ != null) {
                    C7577c.this.f25804dQ.onDislikeClicked();
                    try {
                        if (abstractDialogInterface$OnDismissListenerC9367b.getParent() instanceof ViewGroup) {
                            ((ViewGroup) abstractDialogInterface$OnDismissListenerC9367b.getParent()).removeView(abstractDialogInterface$OnDismissListenerC9367b);
                        }
                    } catch (Exception e) {
                        C10331c.printStackTrace(e);
                    }
                }
                C7601b.m32822a(5, C7577c.this.mAdTemplate, C10483a.m25878bb(C7577c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogDismiss() {
                if (C7577c.this.f25804dQ != null) {
                    try {
                        C7577c.this.f25804dQ.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogShow() {
                if (C7577c.this.f25804dQ != null) {
                    try {
                        C7577c.this.f25804dQ.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
