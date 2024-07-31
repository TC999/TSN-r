package com.kwad.components.p208ad.p221f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.C8680d;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.widget.C9362a;
import com.kwad.components.core.widget.C9371c;
import com.kwad.components.p208ad.p221f.C7418b;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.f.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogInterface$OnDismissListenerC7465d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, InterfaceC8677a {

    /* renamed from: eh */
    private Vibrator f25497eh;
    private AdInfo mAdInfo;
    @NonNull
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;
    private C11063bm mTimerHelper;

    /* renamed from: mj */
    private C7418b.InterfaceC7423c f25498mj;

    /* renamed from: mn */
    private boolean f25499mn;
    @Nullable

    /* renamed from: mo */
    private KsNativeAd.AdInteractionListener f25500mo;

    /* renamed from: mp */
    private C7492f f25501mp;

    /* renamed from: mq */
    private C7477e f25502mq;
    @Nullable

    /* renamed from: mr */
    private KsNativeAd.VideoPlayListener f25503mr;

    /* renamed from: ms */
    private boolean f25504ms = false;

    /* renamed from: bZ */
    private C8679c f25496bZ = new C8679c();

    /* renamed from: mt */
    private int f25505mt = 0;

    /* renamed from: mu */
    private int f25506mu = 0;

    /* renamed from: mv */
    private KsNativeAd.VideoPlayListener f25507mv = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.f.d.8
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                try {
                    DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayPause();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                try {
                    DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayReady();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                try {
                    DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayResume();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25503mr != null) {
                DialogInterface$OnDismissListenerC7465d.this.f25503mr.onVideoPlayStart();
            }
        }
    };

    /* renamed from: mw */
    private InterfaceC7476a f25508mw = new InterfaceC7476a() { // from class: com.kwad.components.ad.f.d.9
        @Override // com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.InterfaceC7476a
        /* renamed from: er */
        public final void mo33199er() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25500mo != null) {
                DialogInterface$OnDismissListenerC7465d.this.f25500mo.onAdShow(DialogInterface$OnDismissListenerC7465d.this);
            }
        }

        @Override // com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.InterfaceC7476a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (DialogInterface$OnDismissListenerC7465d.this.f25500mo != null) {
                try {
                    return DialogInterface$OnDismissListenerC7465d.this.f25500mo.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.InterfaceC7476a
        /* renamed from: l */
        public final void mo33198l(View view) {
            if (DialogInterface$OnDismissListenerC7465d.this.f25500mo != null) {
                DialogInterface$OnDismissListenerC7465d.this.f25500mo.onAdClicked(new FrameLayout(C10887l.m24557dp(view.getContext())), DialogInterface$OnDismissListenerC7465d.this);
            }
        }

        @Override // com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.InterfaceC7476a
        public final void onDownloadTipsDialogDismiss() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25500mo != null) {
                try {
                    DialogInterface$OnDismissListenerC7465d.this.f25500mo.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.InterfaceC7476a
        public final void onDownloadTipsDialogShow() {
            if (DialogInterface$OnDismissListenerC7465d.this.f25500mo != null) {
                try {
                    DialogInterface$OnDismissListenerC7465d.this.f25500mo.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.f.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7476a {
        /* renamed from: er */
        void mo33199er();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        /* renamed from: l */
        void mo33198l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public DialogInterface$OnDismissListenerC7465d(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        if (C10483a.m25956aF(m25641dQ)) {
            C8619c c8619c = new C8619c(this.mAdTemplate);
            this.mApkDownloadHelper = c8619c;
            c8619c.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.m30155a(new C8619c.InterfaceC8628a() { // from class: com.kwad.components.ad.f.d.1
                @Override // com.kwad.components.core.p289e.p293d.C8619c.InterfaceC8628a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return DialogInterface$OnDismissListenerC7465d.this.f25508mw.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(C10483a.m25973O(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public Vibrator m33233D(Context context) {
        if (this.f25497eh == null) {
            this.f25497eh = (Vibrator) context.getSystemService("vibrator");
        }
        return this.f25497eh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: en */
    public C8680d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature m25940aV = C10483a.m25940aV(this.mAdInfo);
        if (TextUtils.isEmpty(m25940aV.coverUrl)) {
            return null;
        }
        return new C8680d(m25940aV.width, m25940aV.height, m25940aV.coverUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eo */
    public void m33209eo() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.f25505mt = nativeAdExtraDataImpl.showLiveStatus;
            this.f25506mu = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return true;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return C10483a.m25957aE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return C10483a.m25915au(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return C10483a.m25958aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        if (i != 1) {
            return adInfo.adBaseInfo.adMarkIcon;
        }
        return adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return C10483a.m25910az(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return C10483a.m25820cf(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return C10483a.m25914av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return C10483a.m25911ay(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return C10483a.m25901bG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return C10483a.m25903bE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return C10483a.m25961aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return C10483a.m25902bF(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return C10483a.m25854bz(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return C10483a.m25944aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        int m25875be = C10483a.m25875be(this.mAdInfo);
        if (m25875be == 2 || m25875be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : m25641dQ.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new C8680d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return C10483a.m25945aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfo() {
        return C10483a.m25905bC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfoUrl() {
        return C10483a.m25904bD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
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

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return C10483a.m25907bA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return C10483a.m25906bB(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return C10483a.m25912ax(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        return BitmapFactory.decodeResource(ServiceProvider.getContext().getResources(), C9659R.C9661drawable.ksad_sdk_logo);
    }

    public final C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new C11063bm();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return C10483a.m25976L(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        return C10483a.m25842cL(this.mAdInfo) ? PredefinedCaptureConfigurations.f24405o : C10483a.m25940aV(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return C10483a.m25977K(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !C10829k.m24699zd().m24700ys()) {
            return null;
        }
        return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        return C10483a.m25842cL(this.mAdInfo) ? PredefinedCaptureConfigurations.f24404n : C10483a.m25940aV(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f25508mw.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        InterfaceC7476a interfaceC7476a = this.f25508mw;
        if (interfaceC7476a != null) {
            interfaceC7476a.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        C9908c.m27323bL(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        C9908c.m27324bK(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || ksAppDownloadListener == null) {
            return;
        }
        c8619c.m30151b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f25503mr = videoPlayListener;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m33217b(DialogInterface$OnDismissListenerC7465d dialogInterface$OnDismissListenerC7465d, C11008ac.C11009a c11009a) {
        return m33213c(c11009a);
    }

    /* renamed from: c */
    private static boolean m33213c(C11008ac.C11009a c11009a) {
        return (Math.abs(c11009a.m24152LV() - c11009a.m24150LX()) < 20) && (Math.abs(c11009a.m24151LW() - c11009a.m24149LY()) < 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m33204j(final View view) {
        if (C10483a.m25927ai(this.mAdInfo)) {
            this.f25498mj = new C7418b.InterfaceC7423c() { // from class: com.kwad.components.ad.f.d.7
                @Override // com.kwad.components.p208ad.p221f.C7418b.InterfaceC7423c
                /* renamed from: f */
                public final void mo33200f(final double d) {
                    if (DialogInterface$OnDismissListenerC7465d.this.mAdInfo.status == 3 || DialogInterface$OnDismissListenerC7465d.this.mAdInfo.status == 2) {
                        return;
                    }
                    C8615a.m30233a(new C8615a.C8616a(C10887l.wrapContextIfNeed(view.getContext())).m30198aq(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate).m30189b(DialogInterface$OnDismissListenerC7465d.this.mApkDownloadHelper).m30191av(false).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.f.d.7.1
                        @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                        public final void onAdClicked() {
                            C9908c.m27340a(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, new C9913b().m27266cK(157).m27246l(d), (JSONObject) null);
                            DialogInterface$OnDismissListenerC7465d.this.f25508mw.mo33198l(view);
                        }
                    }));
                    C11064bn.m23863a(view.getContext(), DialogInterface$OnDismissListenerC7465d.this.m33233D(view.getContext()));
                }
            };
            C7418b.m33300el().m33306a(C10483a.m25926aj(this.mAdInfo), view, this.f25498mj);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f25500mo = adInteractionListener;
        m33227a(viewGroup);
        m33230a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m33216b(C11008ac.C11009a c11009a) {
        return ((Math.abs(c11009a.m24152LV() - c11009a.m24150LX()) > 20) || (Math.abs(c11009a.m24151LW() - c11009a.m24149LY()) > 20)) && C10486d.m25657dF(this.mAdTemplate);
    }

    /* renamed from: c */
    private static void m33215c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C9362a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f25500mo = adInteractionListener;
        m33227a(viewGroup);
        m33229a(activity, viewGroup, map);
    }

    /* renamed from: b */
    private static C9371c m33219b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C9371c) {
                return (C9371c) childAt;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        View m33220b;
        View view = null;
        if (context == null || !C10829k.m24699zd().m24700ys()) {
            return null;
        }
        try {
            context = C10887l.wrapContextIfNeed(context);
            C10819a.m24739ak("native", TTLogUtil.TAG_EVENT_SHOW);
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (C10483a.m25842cL(this.mAdInfo)) {
                m33220b = m33228a(context, kSAdVideoPlayConfigImpl);
            } else {
                m33220b = m33220b(context, kSAdVideoPlayConfigImpl);
            }
            view = m33220b;
            C10819a.m24738al("native", TTLogUtil.TAG_EVENT_SHOW);
            return view;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(runtimeException);
                return view;
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m33230a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view : list) {
            m33231a(activity, viewGroup, 0, view, false);
        }
    }

    /* renamed from: a */
    private void m33229a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                m33231a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f25496bZ.m30028b(interfaceC8678b);
    }

    /* renamed from: b */
    private View m33220b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            C10331c.m26246w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.f25501mp == null) {
            C7492f c7492f = new C7492f(context);
            this.f25501mp = c7492f;
            c7492f.setInnerAdInteractionListener(this.f25508mw);
            this.f25501mp.setVideoPlayListener(this.f25507mv);
            this.f25501mp.m33151a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.f25501mp;
    }

    /* renamed from: a */
    private void m33231a(final Activity activity, @NonNull final ViewGroup viewGroup, final int i, final View view, final boolean z) {
        final C11008ac.C11009a c11009a = new C11008ac.C11009a();
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.f.d.2

            /* renamed from: my */
            private int[] f25516my = new int[2];

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    c11009a.m24146z(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.f25516my);
                    c11009a.m24148f(Math.abs(motionEvent.getRawX() - this.f25516my[0]), Math.abs(motionEvent.getRawY() - this.f25516my[1]));
                } else if (action == 1) {
                    c11009a.m24147g(Math.abs(motionEvent.getRawX() - this.f25516my[0]), Math.abs(motionEvent.getRawY() - this.f25516my[1]));
                    if (DialogInterface$OnDismissListenerC7465d.this.m33216b(c11009a)) {
                        view.setPressed(false);
                        DialogInterface$OnDismissListenerC7465d.this.m33232a(activity, view2, c11009a, i, z, 153);
                    } else if (C10251d.m26564Bx()) {
                        if (DialogInterface$OnDismissListenerC7465d.m33217b(DialogInterface$OnDismissListenerC7465d.this, c11009a)) {
                            DialogInterface$OnDismissListenerC7465d.this.m33232a(activity, view2, c11009a, i, z, 0);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.f.d.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogInterface$OnDismissListenerC7465d.this.m33232a(activity, view2, c11009a, i, z, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r4 = r4;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m33232a(@androidx.annotation.Nullable android.app.Activity r4, final android.view.View r5, final com.kwad.sdk.utils.C11008ac.C11009a r6, int r7, boolean r8, final int r9) {
        /*
            r3 = this;
            if (r4 != 0) goto L6
            android.content.Context r4 = r5.getContext()
        L6:
            android.content.Context r4 = com.kwad.sdk.p445n.C10887l.wrapContextIfNeed(r4)
            r0 = 0
            com.kwad.components.ad.f.e r2 = r3.f25502mq
            if (r2 == 0) goto L19
            com.kwad.components.offline.api.core.adlive.IAdLivePlayModule r2 = r2.f25547eV
            if (r2 == 0) goto L19
            long r0 = r2.getPlayDuration()
            goto L25
        L19:
            com.kwad.components.ad.f.f r2 = r3.f25501mp
            if (r2 == 0) goto L25
            com.kwad.components.ad.f.c.a r2 = r2.f25585mO
            if (r2 == 0) goto L25
            long r0 = r2.getPlayDuration()
        L25:
            com.kwad.components.core.e.d.a$a r2 = new com.kwad.components.core.e.d.a$a
            r2.<init>(r4)
            com.kwad.sdk.core.response.model.AdTemplate r4 = r3.mAdTemplate
            com.kwad.components.core.e.d.a$a r4 = r2.m30198aq(r4)
            com.kwad.components.core.e.d.c r2 = r3.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r4 = r4.m30189b(r2)
            com.kwad.components.core.e.d.a$a r4 = r4.m30199aq(r7)
            r7 = 1
            com.kwad.components.core.e.d.a$a r4 = r4.m30202ao(r7)
            com.kwad.components.core.e.d.a$a r4 = r4.m30158v(r0)
            com.kwad.components.core.e.d.a$a r4 = r4.m30191av(r8)
            com.kwad.components.ad.f.d$4 r7 = new com.kwad.components.ad.f.d$4
            r7.<init>()
            com.kwad.components.core.e.d.a$a r4 = r4.m30216a(r7)
            com.kwad.components.core.p289e.p293d.C8615a.m30233a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d.m33232a(android.app.Activity, android.view.View, com.kwad.sdk.utils.ac$a, int, boolean, int):void");
    }

    /* renamed from: a */
    private void m33227a(final ViewGroup viewGroup) {
        if (!this.f25499mn) {
            this.f25499mn = true;
            C9828c.m27589by(this.mAdTemplate);
        }
        if (!C10251d.m26541Cn() && C10251d.m26542Cm() >= 0.0f) {
            m33215c(viewGroup);
            C9362a c9362a = new C9362a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(c9362a);
            c9362a.setViewCallback(new C9362a.InterfaceC9363a() { // from class: com.kwad.components.ad.f.d.5
                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ac */
                public final void mo28883ac() {
                    C7668b.m32688eI().m32692a(DialogInterface$OnDismissListenerC7465d.this);
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ad */
                public final void mo28882ad() {
                    try {
                        long m23864Nq = DialogInterface$OnDismissListenerC7465d.this.getTimerHelper().m23864Nq();
                        if (DialogInterface$OnDismissListenerC7465d.this.mAdTemplate.mPvReported && DialogInterface$OnDismissListenerC7465d.this.f25504ms) {
                            C9908c.m27346a(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, m23864Nq, (JSONObject) null);
                            DialogInterface$OnDismissListenerC7465d.this.f25504ms = false;
                        }
                        if (C10483a.m25841cM(DialogInterface$OnDismissListenerC7465d.this.mAdInfo)) {
                            C9908c.m27291m(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, ((int) m23864Nq) / 1000);
                        }
                        DialogInterface$OnDismissListenerC7465d.this.f25496bZ.m30026i(DialogInterface$OnDismissListenerC7465d.this);
                        C7418b.m33300el().m33305a(DialogInterface$OnDismissListenerC7465d.this.f25498mj);
                        C7668b.m32688eI().m32690b(DialogInterface$OnDismissListenerC7465d.this);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ep */
                public final void mo28881ep() {
                    try {
                        if (DialogInterface$OnDismissListenerC7465d.this.mAdTemplate.mPvReported && DialogInterface$OnDismissListenerC7465d.this.f25504ms) {
                            C9908c.m27346a(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, DialogInterface$OnDismissListenerC7465d.this.getTimerHelper().m23864Nq(), (JSONObject) null);
                            DialogInterface$OnDismissListenerC7465d.this.f25504ms = false;
                            C7418b.m33300el().m33305a(DialogInterface$OnDismissListenerC7465d.this.f25498mj);
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: k */
                public final void mo28880k(View view) {
                    if (!DialogInterface$OnDismissListenerC7465d.this.mAdTemplate.mPvReported) {
                        DialogInterface$OnDismissListenerC7465d.this.f25508mw.mo33199er();
                        DialogInterface$OnDismissListenerC7465d.this.m33209eo();
                        C9913b c9913b = new C9913b();
                        c9913b.m27245v(viewGroup.getHeight(), viewGroup.getWidth());
                        if (C10483a.m25842cL(DialogInterface$OnDismissListenerC7465d.this.mAdInfo)) {
                            C9893a.C9894a c9894a = new C9893a.C9894a();
                            c9894a.showLiveStyle = DialogInterface$OnDismissListenerC7465d.this.f25506mu;
                            c9894a.showLiveStatus = DialogInterface$OnDismissListenerC7465d.this.f25505mt;
                            c9913b.m27268b(c9894a);
                        }
                        C8934b.m29570qY().m29571a(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, null, c9913b);
                    }
                    if (!DialogInterface$OnDismissListenerC7465d.this.f25504ms) {
                        DialogInterface$OnDismissListenerC7465d.this.m33204j(view);
                        DialogInterface$OnDismissListenerC7465d.this.getTimerHelper().startTiming();
                        DialogInterface$OnDismissListenerC7465d.this.f25496bZ.m30027h(DialogInterface$OnDismissListenerC7465d.this);
                    }
                    DialogInterface$OnDismissListenerC7465d.this.f25504ms = true;
                }
            });
            c9362a.m28904ti();
            return;
        }
        C9371c m33219b = m33219b(viewGroup);
        if (m33219b == null) {
            m33219b = new C9371c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(m33219b);
        }
        m33219b.setViewCallback(new C9371c.InterfaceC9372a() { // from class: com.kwad.components.ad.f.d.6
            @Override // com.kwad.components.core.widget.C9371c.InterfaceC9372a
            /* renamed from: eq */
            public final void mo28875eq() {
                if (!DialogInterface$OnDismissListenerC7465d.this.mAdTemplate.mPvReported) {
                    DialogInterface$OnDismissListenerC7465d.this.f25508mw.mo33199er();
                }
                DialogInterface$OnDismissListenerC7465d.this.m33209eo();
                C9913b c9913b = new C9913b();
                c9913b.m27245v(viewGroup.getHeight(), viewGroup.getWidth());
                if (C10483a.m25842cL(DialogInterface$OnDismissListenerC7465d.this.mAdInfo)) {
                    C9893a.C9894a c9894a = new C9893a.C9894a();
                    c9894a.showLiveStyle = DialogInterface$OnDismissListenerC7465d.this.f25506mu;
                    c9894a.showLiveStatus = DialogInterface$OnDismissListenerC7465d.this.f25505mt;
                    c9913b.m27268b(c9894a);
                }
                C8934b.m29570qY().m29571a(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate, null, c9913b);
                C9828c.m27588bz(DialogInterface$OnDismissListenerC7465d.this.mAdTemplate);
            }
        });
        m33219b.setNeedCheckingShow(true);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f25496bZ.m30029a(interfaceC8678b);
    }

    /* renamed from: a */
    private View m33228a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        if (interfaceC8695a == null || !interfaceC8695a.mo28869oK()) {
            return null;
        }
        if (this.f25502mq == null) {
            C7477e c7477e = new C7477e(context);
            this.f25502mq = c7477e;
            c7477e.setInnerAdInteractionListener(this.f25508mw);
            this.f25502mq.setVideoPlayListener(this.f25507mv);
            this.f25502mq.m33197a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.f25502mq;
    }
}
