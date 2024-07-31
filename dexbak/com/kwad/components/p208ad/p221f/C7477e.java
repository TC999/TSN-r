package com.kwad.components.p208ad.p221f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.liveEnd.C8693a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p299j.C8682a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9089ao;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9111ax;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9123ba;
import com.kwad.components.core.webview.jshandler.C9145e;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.f.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7477e extends KSRelativeLayout implements InterfaceC10385c {

    /* renamed from: bQ */
    private C9366b f25537bQ;

    /* renamed from: cB */
    private List<Integer> f25538cB;

    /* renamed from: cN */
    private C9003a f25539cN;

    /* renamed from: cO */
    private C10605b f25540cO;

    /* renamed from: cP */
    private int f25541cP;

    /* renamed from: cU */
    private C9092aq.InterfaceC9095b f25542cU;

    /* renamed from: eL */
    private KSRelativeLayout f25543eL;

    /* renamed from: eQ */
    private boolean f25544eQ;

    /* renamed from: eT */
    private IAdLiveOfflineView f25545eT;

    /* renamed from: eU */
    private InterfaceC8695a f25546eU;

    /* renamed from: eV */
    public IAdLivePlayModule f25547eV;

    /* renamed from: eY */
    private C8682a.C8684b f25548eY;

    /* renamed from: eZ */
    private final AdLivePlayStateListener f25549eZ;

    /* renamed from: fC */
    private C9123ba f25550fC;

    /* renamed from: fD */
    private C9109aw f25551fD;

    /* renamed from: fE */
    private WebCardRegisterLiveMessageListener f25552fE;

    /* renamed from: fF */
    private WebCardRegisterLiveShopListener f25553fF;

    /* renamed from: fJ */
    private C9111ax.C9114b f25554fJ;

    /* renamed from: fK */
    private C9111ax.C9113a f25555fK;

    /* renamed from: fa */
    private OfflineOnAudioConflictListener f25556fa;

    /* renamed from: ga */
    private IAdLiveEndRequest f25557ga;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private C8619c mApkDownloadHelper;
    private Context mContext;

    /* renamed from: mG */
    private ImageView f25558mG;

    /* renamed from: mH */
    private RelativeLayout f25559mH;

    /* renamed from: mI */
    private AdBasePvFrameLayout f25560mI;
    private boolean mIsAudioEnable;

    /* renamed from: mJ */
    private KSAdVideoPlayConfigImpl f25561mJ;
    private final AbstractC10436l<C8693a, AdLiveEndCommonResultData> mNetworking;

    /* renamed from: mr */
    private KsNativeAd.VideoPlayListener f25562mr;

    /* renamed from: mt */
    private int f25563mt;

    /* renamed from: mu */
    private int f25564mu;

    /* renamed from: mw */
    private DialogInterface$OnDismissListenerC7465d.InterfaceC7476a f25565mw;

    public C7477e(@NonNull Context context) {
        super(context);
        this.f25563mt = 0;
        this.f25564mu = 0;
        this.f25542cU = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.ad.f.e.10
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                C7477e.this.f25541cP = c9094a.status;
                if (C7477e.this.f25541cP != 1) {
                    C7477e.this.mAdWebView.setVisibility(8);
                } else {
                    C7477e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new AbstractC10436l<C8693a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: bC */
            public C8693a createRequest() {
                return new C8693a(C7477e.this.f25557ga);
            }

            @NonNull
            /* renamed from: p */
            private static AdLiveEndCommonResultData m33157p(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return m33157p(str);
            }
        };
        this.f25549eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.f.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (C7477e.this.f25562mr != null) {
                    C7477e.this.f25562mr.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (C7477e.this.f25562mr != null) {
                    C7477e.this.f25562mr.onVideoPlayComplete();
                }
                String m25873bg = C10483a.m25873bg(C7477e.this.mAdInfo);
                if (TextUtils.isEmpty(m25873bg)) {
                    return;
                }
                InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
                if (interfaceC8695a != null) {
                    C7477e.this.f25557ga = interfaceC8695a.getAdLiveEndRequest(m25873bg);
                }
                C7477e.this.mNetworking.request(new AbstractC10439o<C8693a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.2.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
                    /* renamed from: a */
                    public void onStartRequest(@NonNull C8693a c8693a) {
                        super.onStartRequest(c8693a);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
                    /* renamed from: a */
                    public void onSuccess(@NonNull C8693a c8693a, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(c8693a, adLiveEndCommonResultData);
                        C9111ax.C9113a c9113a = new C9111ax.C9113a();
                        c9113a.status = 9;
                        c9113a.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        c9113a.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        c9113a.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        c9113a.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        c9113a.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        c9113a.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (C7477e.this.f25554fJ == null) {
                            C7477e.this.f25555fK = c9113a;
                        } else {
                            C7477e.this.f25554fJ.m29259a(c9113a);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
                    /* renamed from: a */
                    public void onError(@NonNull C8693a c8693a, int i, String str) {
                        super.onError(c8693a, i, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    C7477e.this.f25562mr.onVideoPlayPause();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                C7477e.this.m33179c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                C8682a.m30020oG().m30023a(C7477e.this.getCurrentVoiceItem());
                C7477e c7477e = C7477e.this;
                c7477e.f25547eV.setAudioEnabled(c7477e.m33169g(c7477e.mIsAudioEnable), false);
                try {
                    C7477e.this.f25562mr.onVideoPlayResume();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                C8682a.m30020oG().m30023a(C7477e.this.getCurrentVoiceItem());
                C7477e c7477e = C7477e.this;
                c7477e.f25547eV.setAudioEnabled(c7477e.m33169g(c7477e.mIsAudioEnable), false);
                if (C7477e.this.f25562mr != null) {
                    C7477e.this.f25562mr.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                C8682a.m30020oG().m30023a(C7477e.this.getCurrentVoiceItem());
                try {
                    C7477e.this.f25562mr.onVideoPlayReady();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
                IAdLivePlayModule iAdLivePlayModule = C7477e.this.f25547eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        this.f25556fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = C7477e.this.f25547eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        initView();
    }

    /* renamed from: aA */
    private void m33187aA() {
        C9003a c9003a = this.f25539cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f25539cN = null;
        }
    }

    /* renamed from: ax */
    private void m33186ax() {
        C10605b c10605b = new C10605b();
        this.f25540cO = c10605b;
        c10605b.setAdTemplate(this.mAdTemplate);
        C10605b c10605b2 = this.f25540cO;
        c10605b2.mScreenOrientation = 0;
        c10605b2.aDJ = null;
        c10605b2.f29621OE = this.f25560mI;
        c10605b2.f29620NY = this.mAdWebView;
        c10605b2.mReportExtData = null;
        c10605b2.aDL = false;
    }

    /* renamed from: ay */
    private void m33185ay() {
        if (C10484b.m25775cQ(this.mAdTemplate)) {
            m33172et();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bi */
    public IAdLivePlayModule m33183bi() {
        m33182bj();
        IAdLiveOfflineView view = this.f25546eU.getView(this.mContext, 3);
        this.f25545eT = view;
        IAdLivePlayModule adLivePlayModule = this.f25546eU.getAdLivePlayModule(view, ServiceProvider.m24362KP().appId, String.valueOf(C10483a.m25819cg(this.mAdInfo)), C10483a.m25818ch(this.mAdInfo), C10483a.m25817ci(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(m33169g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.f25549eZ);
        final View view2 = this.f25545eT.getView();
        this.f25559mH.removeAllViews();
        this.f25559mH.addView(view2);
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.e.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C7477e.this.m33178c(view2);
            }
        });
        m33180by();
        if (this.mIsAudioEnable) {
            C8932a.m29575ah(this.mContext).m29577a(this.f25556fa);
        }
        return adLivePlayModule;
    }

    /* renamed from: bj */
    private void m33182bj() {
        String url = C10483a.m25862br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f25558mG.setImageDrawable(null);
            KSImageLoader.loadImage(this.f25558mG, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.f.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.f25558mG.setVisibility(0);
            return;
        }
        this.f25558mG.setVisibility(8);
    }

    /* renamed from: bx */
    private boolean m33181bx() {
        return this.f25541cP == 1;
    }

    /* renamed from: by */
    private void m33180by() {
        this.f25545eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.f.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (C7477e.this.f25552fE != null) {
                    C7477e.this.f25552fE.m29345n(list);
                }
            }
        });
        this.f25545eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.f.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (C7477e.this.f25553fF != null) {
                    C7477e.this.f25553fF.m29344a(adLiveShopInfo);
                }
            }
        });
    }

    /* renamed from: eo */
    private void m33174eo() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.f25563mt = nativeAdExtraDataImpl.showLiveStatus;
            this.f25564mu = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: es */
    private void m33173es() {
        this.mAdWebView.setVisibility(8);
        m33186ax();
        if (m33181bx()) {
            this.mAdWebView.reload();
        } else {
            m33185ay();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: et */
    private void m33172et() {
        m33187aA();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().m25331ei(this.mAdTemplate));
        C9003a c9003a = new C9003a(this.mAdWebView);
        this.f25539cN = c9003a;
        m33188a(c9003a);
        this.mAdWebView.addJavascriptInterface(this.f25539cN, "KwaiAd");
        this.mAdWebView.loadUrl(C10484b.m25783cI(this.mAdTemplate));
    }

    @NonNull
    private InterfaceC10635a getClickListener() {
        return new InterfaceC10635a() { // from class: com.kwad.components.ad.f.e.11
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                int i = c10640a.f29644XC;
                if (c10640a.f29642Kr) {
                    i = c10640a.f29643XA ? 1 : 2;
                }
                boolean m25877bc = C10483a.m25877bc(C7477e.this.mAdInfo);
                C10642c c10642c = c10640a.f29645XD;
                String str = (c10642c == null || TextUtils.isEmpty(c10642c.f29649KG)) ? "" : c10640a.f29645XD.f29649KG;
                C8615a.C8616a m30194as = new C8615a.C8616a(C7477e.this.getContext()).m30198aq(C7477e.this.mAdTemplate).m30189b(C7477e.this.mApkDownloadHelper).m30202ao(false).m30205an(i).m30192au(c10640a.f29642Kr).m30194as(m25877bc);
                IAdLivePlayModule iAdLivePlayModule = C7477e.this.f25547eV;
                C8615a.m30233a(m30194as.m30158v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).m30212ag(str).m30197aq(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.f.e.11.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        if (C7477e.this.f25565mw != null) {
                            C7477e.this.f25565mw.mo33198l(C7477e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8682a.C8684b getCurrentVoiceItem() {
        if (this.f25548eY == null) {
            this.f25548eY = new C8682a.C8684b(new C8682a.InterfaceC8685c() { // from class: com.kwad.components.ad.f.e.4
                @Override // com.kwad.components.core.p299j.C8682a.InterfaceC8685c
                /* renamed from: bk */
                public final void mo30017bk() {
                    C7477e c7477e = C7477e.this;
                    if (c7477e.f25547eV == null) {
                        c7477e.f25547eV = c7477e.m33183bi();
                    }
                    C7477e c7477e2 = C7477e.this;
                    c7477e2.f25547eV.setAudioEnabled(c7477e2.m33169g(c7477e2.mIsAudioEnable), false);
                }
            });
        }
        return this.f25548eY;
    }

    private C9089ao.InterfaceC9090a getOpenNewPageListener() {
        return new C9089ao.InterfaceC9090a() { // from class: com.kwad.components.ad.f.e.9
            @Override // com.kwad.components.core.webview.jshandler.C9089ao.InterfaceC9090a
            /* renamed from: a */
            public final void mo29284a(C9011b c9011b) {
                AdWebViewActivityProxy.launch(C7477e.this.mContext, new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9011b.title).m29854at(c9011b.url).m29856as(C7477e.this.mAdTemplate).m29851pl());
            }
        };
    }

    private C9111ax.InterfaceC9115c getRegisterLiveListener() {
        return new C9111ax.InterfaceC9115c() { // from class: com.kwad.components.ad.f.e.8
            @Override // com.kwad.components.core.webview.jshandler.C9111ax.InterfaceC9115c
            /* renamed from: a */
            public final void mo29258a(C9111ax.C9114b c9114b) {
                C7477e.this.f25554fJ = c9114b;
                if (C7477e.this.f25555fK != null) {
                    C7477e.this.f25554fJ.m29259a(C7477e.this.f25555fK);
                    C7477e.this.f25555fK = null;
                }
            }
        };
    }

    private void initView() {
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        this.f25560mI = adBasePvFrameLayout;
        this.f25558mG = (ImageView) adBasePvFrameLayout.findViewById(C9659R.C9662id.ksad_live_bg_img);
        this.f25543eL = (KSRelativeLayout) this.f25560mI.findViewById(C9659R.C9662id.ksad_live_container);
        this.f25559mH = (RelativeLayout) this.f25560mI.findViewById(C9659R.C9662id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f25560mI.findViewById(C9659R.C9662id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f25546eU = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C8682a.m30020oG().m30023a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.f25547eV;
        if (iAdLivePlayModule == null) {
            this.f25547eV = m33183bi();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        IAdLivePlayModule iAdLivePlayModule = this.f25547eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        C8682a.m30020oG().m30021c(this.f25548eY);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    /* renamed from: ac */
    public final void mo23551ac() {
        super.mo23551ac();
        this.f25537bQ.m28900tw();
        this.f25537bQ.mo26187a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    /* renamed from: ad */
    public final void mo23550ad() {
        super.mo23550ad();
        this.f25537bQ.m28900tw();
        this.f25537bQ.mo26186b(this);
        IAdLivePlayModule iAdLivePlayModule = this.f25547eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.f25547eV = null;
        }
        C8682a.m30020oG().m30021c(this.f25548eY);
        this.f25555fK = null;
        this.f25554fJ = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.f25545eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.f25545eT = null;
        }
    }

    public final void setInnerAdInteractionListener(DialogInterface$OnDismissListenerC7465d.InterfaceC7476a interfaceC7476a) {
        this.f25565mw = interfaceC7476a;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f25562mr = videoPlayListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33178c(View view) {
        int width = this.f25543eL.getWidth();
        int height = this.f25543eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m33169g(boolean z) {
        if (z) {
            if (this.f25548eY != null) {
                C8682a.m30020oG();
                if (!C8682a.m30022b(this.f25548eY)) {
                    return false;
                }
            }
            if (!C10251d.m26517gs()) {
                if (C8932a.m29575ah(this.mContext).m29572qX()) {
                    return !C8932a.m29575ah(this.mContext).m29573qW();
                }
                return C8932a.m29575ah(this.mContext).m29576aN(false);
            }
            if (!this.f25544eQ) {
                this.f25544eQ = C8932a.m29575ah(this.mContext).m29576aN(true);
            }
            return this.f25544eQ;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33179c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f25538cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f25538cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    public final void m33197a(Context context, AdTemplate adTemplate, @Nullable C8619c c8619c, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        this.mContext = context;
        this.f25561mJ = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = c8619c;
        this.f25538cB = C10483a.m25867bm(m25641dQ);
        this.f25537bQ = new C9366b(getParent() == null ? this : (View) getParent(), 30);
        if (this.f25561mJ.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.f25561mJ.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = C10483a.m25888bT(this.mAdInfo);
        }
        m33174eo();
        m33173es();
    }

    /* renamed from: a */
    private void m33188a(C9003a c9003a) {
        this.f25550fC = new C9123ba();
        C9109aw c9109aw = new C9109aw();
        this.f25551fD = c9109aw;
        c9003a.m29403a(c9109aw);
        c9003a.m29403a(new C9036aa(this.f25540cO, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        c9003a.m29403a(new C9185x(this.f25540cO, this.mApkDownloadHelper, getClickListener()));
        c9003a.m29403a(new C9200f());
        c9003a.m29403a(new C9046ad(this.f25540cO));
        c9003a.m29403a(new C9057ag(this.f25540cO));
        c9003a.m29403a(new C9043ac(this.f25540cO));
        c9003a.m29403a(new C9092aq(this.f25542cU, C10484b.m25785cG(this.mAdTemplate)));
        c9003a.m29403a(new C9119az(this.f25540cO, this.mApkDownloadHelper));
        c9003a.m29403a(new C9072ak(this.f25540cO));
        c9003a.m29402b(new C9163m(this.f25540cO));
        c9003a.m29402b(new C9161l(this.f25540cO));
        c9003a.m29403a(this.f25550fC);
        c9003a.m29403a(new C9089ao(getOpenNewPageListener()));
        c9003a.m29403a(new C9145e(this.f25563mt, this.f25564mu));
        this.f25553fF = new WebCardRegisterLiveShopListener();
        this.f25552fE = new WebCardRegisterLiveMessageListener();
        c9003a.m29403a(this.f25553fF);
        c9003a.m29403a(this.f25552fE);
        c9003a.m29403a(new C9111ax(getRegisterLiveListener()));
    }
}
