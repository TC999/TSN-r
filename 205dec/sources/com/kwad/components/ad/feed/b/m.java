package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
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
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> fG = new HashMap<>(8);
    private List<Integer> cB;
    private int cP;
    private KsAdVideoPlayConfig dU;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private final a.InterfaceC0650a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private final AdLivePlayStateListener eZ;
    private d.b ek;
    private long ey;
    private LinearLayout fA;
    private TextView fB;
    private ba fC;
    private aw fD;
    private WebCardRegisterLiveMessageListener fE;
    private WebCardRegisterLiveShopListener fF;
    private boolean fH;
    private String fI;
    private ax.b fJ;
    private ax.a fK;
    private boolean fL;
    private com.kwad.components.core.widget.b fM;
    private float fN;
    private float fO;
    private boolean fP;
    private a fQ;
    private ViewGroup.MarginLayoutParams fR;
    private Handler fS;
    private e fT;
    private ar fU;
    private boolean fV;
    private boolean fW;
    private com.kwad.components.core.webview.b fX;
    private com.kwad.components.core.webview.c fY;
    private b.a fZ;
    private OfflineOnAudioConflictListener fa;
    private RatioFrameLayout fy;
    private double fz;
    private IAdLiveEndRequest ga;
    private KsAdWebView mAdWebView;
    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void c(int i4, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.cP = -1;
        this.mIsAudioEnable = false;
        this.fL = false;
        this.fS = new Handler(Looper.getMainLooper());
        this.fV = false;
        this.fW = false;
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eN != null) {
                    m.this.eN.setVideoSoundEnable(false);
                }
                if (m.this.eV != null) {
                    m.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fY = new AnonymousClass11();
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.m.13
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.abm != null) {
                    m.this.abm.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.abm != null && m.this.fL) {
                    m.this.abm.onAdShow();
                }
                if (m.this.fL) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0688a c0688a = new a.C0688a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0688a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0688a);
                    bVar.v((int) Math.ceil(m.this.fz), m.this.mWidth);
                    com.kwad.components.core.s.b.qY().a(m.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.abm != null) {
                    m.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.abm != null) {
                    m.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.abm != null) {
                    m.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bC */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.ga);
            }

            @NonNull
            private static AdLiveEndCommonResultData p(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return p(str);
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bg = com.kwad.sdk.core.response.b.a.bg(m.this.mAdInfo);
                if (TextUtils.isEmpty(bg)) {
                    return;
                }
                com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                if (aVar != null) {
                    m.this.ga = aVar.getAdLiveEndRequest(bg);
                }
                m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ax.a aVar3 = new ax.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (m.this.fJ == null) {
                            m.this.fK = aVar3;
                        } else {
                            m.this.fJ.a(aVar3);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i4, String str) {
                        super.onError(aVar2, i4, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j4) {
                super.onLivePlayProgress(j4);
                m.this.c(j4);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eV.setAudioEnabled(false, false);
            }
        };
        this.eS = new a.InterfaceC0650a() { // from class: com.kwad.components.ad.feed.b.m.10
            @Override // com.kwad.components.core.video.a.InterfaceC0650a
            public final void a(int i4, ac.a aVar) {
                int i5;
                int i6 = 2;
                boolean z3 = false;
                if (i4 == 1) {
                    i5 = 13;
                } else if (i4 == 2) {
                    i5 = 82;
                } else if (i4 != 3) {
                    i5 = 108;
                } else {
                    i5 = 83;
                    i6 = 1;
                    z3 = true;
                }
                m.this.bw();
                com.kwad.components.core.e.d.a.a(new a.C0631a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(i6).ao(z3).aq(true).am(i5).d(aVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        m.this.tj();
                    }
                }));
            }
        };
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eV == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eT.getView().getParent();
        if (viewGroup != this.eL) {
            viewGroup.removeView(this.eT.getView());
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eT.getView());
            this.eL.setTag(this.eT.getView());
            this.eV.setAudioEnabled(g(this.mIsAudioEnable), false);
            IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(this.eT, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ch(this.mAdInfo), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo));
            this.eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        }
        this.eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bi() {
        bj();
        IAdLiveOfflineView view = this.eU.getView(this.mContext, 3);
        this.eT = view;
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(view, ServiceProvider.KP().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ch(this.mAdInfo), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        final View view2 = this.eT.getView();
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(view2);
        this.eL.setTag(view2);
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.m.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.c(view2);
            }
        });
        by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            return;
        }
        this.eM.setImageResource(R.drawable.ksad_ad_live_end);
    }

    private void bt() {
        this.fS.postDelayed(new ay() { // from class: com.kwad.components.ad.feed.b.m.12
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.f("0", 1);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        d.b bVar = new d.b() { // from class: com.kwad.components.ad.feed.b.m.17
            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(final double d4) {
                if (bq.o(m.this.fy, (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f))) {
                    com.kwad.components.core.e.d.a.a(new a.C0631a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(2).ao(false).aq(false).am(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME).al(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.e.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.ea(m.this.mAdTemplate));
                            com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                            bVar2.l(d4);
                            bVar2.cK(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
                            m.this.c(bVar2);
                        }
                    }));
                    return true;
                }
                return false;
            }
        };
        this.ek = bVar;
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate), this.mContext, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bx() {
        return this.cP == 1;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fE != null) {
                    m.this.fE.n(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fF != null) {
                    m.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.m.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (m.this.eW) {
                        if (m.this.eV == null) {
                            m mVar = m.this;
                            mVar.eV = mVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                        m mVar2 = m.this;
                        iAdLivePlayModule.setAudioEnabled(mVar2.g(mVar2.mIsAudioEnable), false);
                    } else if (m.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                        m mVar3 = m.this;
                        aVar.setVideoSoundEnable(mVar3.g(mVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.feed.b.m.18
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0642a().as(bVar.title).at(bVar.url).aC(true).as(m.this.mAdTemplate).pl());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.feed.b.m.14
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                m.this.fJ = bVar;
                if (m.this.fK != null) {
                    m.this.fJ.a(m.this.fK);
                    m.this.fK = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.b.m.7
            private boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.qi().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.adlog.c.bL(m.this.mAdTemplate);
                m.this.fC.aQ(9);
                m.this.eL.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.aW() && m.this.eP == null && !m.this.fV) {
                    m.this.eP = new d(m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.eP, layoutParams);
                    m.this.eP.bn();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j4) {
                m.this.c(j4);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i4, int i5) {
                AdTemplate adTemplate = m.this.mAdTemplate;
                String K = com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo);
                com.kwad.components.ad.feed.monitor.b.a(adTemplate, 2, 1, K, i4 + " " + i5, SystemClock.elapsedRealtime() - m.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ey);
                com.kwad.sdk.core.adlog.c.bK(m.this.mAdTemplate);
                m.this.fC.aQ(3);
                if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                    m.this.eP.bo();
                    m.this.eP = null;
                }
                if (m.this.fT == null && com.kwad.sdk.core.response.b.b.cJ(m.this.mAdTemplate) && m.this.fV) {
                    m.this.fT = new e(m.this.mContext);
                    m.this.eL.addView(m.this.fT, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fT.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.b.b.cK(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(158);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.b.b.cK(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dF(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(153);
                        }
                    });
                    m.this.fT.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fU.aP(1);
                            m.this.eL.removeView(m.this.fT);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
        if (this.eW) {
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule == null) {
                this.eV = bi();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.oG().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        com.kwad.components.ad.feed.monitor.b.aZ();
        this.fy = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.eL = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.fA = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.fB = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        if (this.cP == 1 || this.fH) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        f("0", 1);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        aw awVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.abm) != null && this.fL) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (this.fL || (awVar = this.fD) == null) {
            return;
        }
        awVar.ss();
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
        if ((r0 * r5) < r7) goto L26;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            boolean r1 = com.kwad.sdk.core.config.d.Co()
            if (r1 == 0) goto L8d
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.b.d.dF(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.b.b.cf(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            if (r0 == 0) goto L88
            boolean r0 = r9.fL
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.fO
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r1.maxRange
            double r3 = (double) r3
            double r3 = java.lang.Math.tan(r3)
            double r5 = (double) r0
            java.lang.Double.isNaN(r5)
            double r3 = r3 * r5
            double r7 = (double) r2
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 < 0) goto L82
            int r0 = r1.minRange
            double r0 = (double) r0
            double r0 = java.lang.Math.tan(r0)
            java.lang.Double.isNaN(r5)
            double r0 = r0 * r5
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L88
        L82:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
        L88:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L8d:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.m.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z3);
        if (z3) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eL) {
                viewGroup.removeView(this.eN);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.eO.setVideoPlayCallback(getVideoPlayCallback());
                this.eO.setAdClickListener(this.eS);
                this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eO.rM();
                this.eO.setAutoRelease(true);
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eV) == null) {
            return;
        }
        iAdLivePlayModule.onPause();
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i4) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fQ;
        if (aVar2 != null) {
            aVar2.c(this.cP == 1 ? 2 : 1, "");
        }
        this.fQ = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r3 = this.mAdTemplate;
                if (r3 != 0) {
                    r3.mIsAudioEnable = isVideoSoundEnable;
                }
                IAdLiveOfflineView iAdLiveOfflineView = this.eT;
                if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
                    iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
                } else {
                    com.kwad.sdk.core.video.videoview.a aVar = this.eN;
                    if (aVar != null) {
                        aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                    }
                }
                if (this.mIsAudioEnable) {
                    com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
                }
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eO) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i4) {
        if (i4 <= 0) {
            i4 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i4;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void ay() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jp();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().az(this.mAdTemplate).aF(com.kwad.sdk.core.response.b.b.cG(this.mAdTemplate)).d(this.mAdWebView).k(this.fy).f(this.mApkDownloadHelper).a(this.fY));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cG(this.mAdTemplate));
        R r3 = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r3, com.kwad.sdk.core.response.b.b.cG(r3));
        bt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i4) {
        int i5;
        com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError " + str);
        this.fS.removeCallbacksAndMessages(null);
        if (this.fH) {
            return;
        }
        this.fH = true;
        if (this.mAdWebView != null) {
            R r3 = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r3, com.kwad.sdk.core.response.b.b.cG(r3), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i4);
        }
        com.kwad.components.core.o.a qi = com.kwad.components.core.o.a.qi();
        AdTemplate adTemplate = this.mAdTemplate;
        qi.b(adTemplate, com.kwad.sdk.core.response.b.b.cG(adTemplate), str);
        try {
            i5 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i5 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.b(i5, com.kwad.sdk.core.response.b.a.be(this.mAdInfo), this.mAdTemplate);
        a aVar = this.fQ;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fQ = null;
        if (this.fM == null) {
            this.fL = true;
            com.kwad.components.core.widget.b.c(this);
            int be = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eV.onDestroy();
                this.eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eT = null;
            }
            com.kwad.components.core.widget.b a4 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), be);
            this.fM = a4;
            if (a4 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(this.mContext, 16.0f));
                this.fy.removeAllViews();
                this.fy.setRatio(0.0d);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eL.setVisibility(8);
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.fy.addView(this.fM);
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z3) {
        if (z3) {
            if (this.eY != null) {
                com.kwad.components.core.j.a.oG();
                if (!com.kwad.components.core.j.a.b(this.eY)) {
                    return false;
                }
            }
            if (!com.kwad.sdk.core.config.d.gs()) {
                if (com.kwad.components.core.s.a.ah(this.mContext).qX()) {
                    return !com.kwad.components.core.s.a.ah(this.mContext).qW();
                }
                return com.kwad.components.core.s.a.ah(this.mContext).aN(false);
            }
            if (!this.eQ) {
                this.eQ = com.kwad.components.core.s.a.ah(this.mContext).aN(true);
            }
            return this.eQ;
        }
        return false;
    }

    private static float h(AdTemplate adTemplate) {
        int i4 = adTemplate.type;
        if (i4 == 1) {
            return 0.6013f;
        }
        return (i4 == 2 || i4 == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Double d4 = fG.get(Long.valueOf(this.mAdTemplate.posId));
        if (d4 != null) {
            this.fy.setRatio(d4.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate) > 0.0d) {
            this.fy.setRatio(com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate));
        } else if (this.fy.getRatio() == 0.0d) {
            this.fy.setRatio(h(this.mAdTemplate));
        }
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.oK() && com.kwad.sdk.core.response.b.a.cL(this.mAdInfo)) {
            this.eW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final int i4) {
        bw();
        com.kwad.components.core.e.d.a.a(new a.C0631a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(1).ao(true).am(i4).al(5).aq(false).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.8
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.aL(i4);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        if (this.ek != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate), this.mContext, this.ek);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.fS.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.ej(this.mAdTemplate);
        d.b bVar = this.ek;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
        com.kwad.components.core.j.a.oG().c(this.eY);
        this.fJ = null;
        this.fK = null;
    }

    static /* synthetic */ boolean d(m mVar, boolean z3) {
        mVar.fV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        AdTemplate n4 = com.kwad.sdk.core.response.b.c.n(adResultData);
        g(n4);
        n4.realShowType = 2;
        super.b((m) adResultData);
        if (this.fH) {
            com.kwad.components.core.widget.b bVar = this.fM;
            if (bVar != null) {
                bVar.b((com.kwad.components.core.widget.b) adResultData);
                com.kwad.components.core.widget.b bVar2 = this.fM;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dU);
                }
            }
        } else if (!com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate)) {
            f("0", 0);
        } else {
            if (!bx()) {
                i(this.mAdTemplate);
            }
            try {
                String str = this.fI;
                if (str == null || !str.equals(n4.mOriginJString)) {
                    if (bx()) {
                        this.mAdWebView.reload();
                    } else {
                        this.cP = -2;
                        ay();
                    }
                }
            } catch (Throwable unused) {
                f("0", 0);
            }
            this.fI = n4.mOriginJString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4) {
        int ceil = (int) Math.ceil(((float) j4) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void g(AdTemplate adTemplate) {
        if (this.fW) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.fW = true;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.feed.b.m$11  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    final class AnonymousClass11 extends com.kwad.components.core.webview.c {
        AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aDL = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.f(m.this.mAdTemplate.loadType));
            m.this.fC = new ba();
            aVar.a(m.this.fC);
            aVar.a(new ao(m.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (m.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo) || m.this.eW) {
                            m mVar = m.this;
                            mVar.fR = (ViewGroup.MarginLayoutParams) mVar.eL.getLayoutParams();
                            int ceil = (int) Math.ceil(m.this.fz);
                            int i4 = m.this.mWidth;
                            if (videoPosition.widthRation == 0.0d) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = m.this.fR;
                            double d4 = videoPosition.topMarginRation;
                            double d5 = ceil;
                            Double.isNaN(d5);
                            marginLayoutParams.topMargin = (int) (d4 * d5);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = m.this.fR;
                            double d6 = videoPosition.leftMarginRation;
                            double d7 = i4;
                            Double.isNaN(d7);
                            marginLayoutParams2.leftMargin = (int) (d6 * d7);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = m.this.fR;
                            double d8 = videoPosition.widthRation;
                            Double.isNaN(d7);
                            marginLayoutParams3.width = (int) (d7 * d8);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = m.this.fR;
                            double d9 = m.this.fR.width;
                            double d10 = videoPosition.heightWidthRation;
                            Double.isNaN(d9);
                            marginLayoutParams4.height = (int) (d9 * d10);
                            m.this.eL.setRadius(videoPosition.borderRadius);
                            m.this.eL.setLayoutParams(m.this.fR);
                            m.this.eL.setVisibility(0);
                            if ((m.this.dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) m.this.dU).getVideoSoundValue() != 0) {
                                m mVar2 = m.this;
                                mVar2.mIsAudioEnable = mVar2.dU.isVideoSoundEnable();
                            } else {
                                m mVar3 = m.this;
                                mVar3.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(mVar3.mAdInfo);
                            }
                            m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                            m mVar4 = m.this;
                            mVar4.cB = com.kwad.sdk.core.response.b.a.bm(mVar4.mAdInfo);
                            if (m.this.eW) {
                                if (m.this.eV != null) {
                                    IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                                    m mVar5 = m.this;
                                    iAdLivePlayModule.setAudioEnabled(mVar5.g(mVar5.mIsAudioEnable), false);
                                    return;
                                }
                                return;
                            }
                            m mVar6 = m.this;
                            mVar6.a(mVar6.dU);
                        }
                    }
                }
            }));
            aVar.a(new ab(bVar, new ab.a() { // from class: com.kwad.components.ad.feed.b.m.11.2
                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void bA() {
                    m.this.fS.post(new ay() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            m.this.tk();
                        }
                    });
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.ay(new ay.a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    m.d(m.this, true);
                    m.this.bu();
                }
            }));
            m.this.fU = new ar();
            aVar.a(m.this.fU);
            if (m.this.eW) {
                aVar.a(new com.kwad.components.core.webview.jshandler.e(1, 1));
                m.this.fF = new WebCardRegisterLiveShopListener();
                m.this.fE = new WebCardRegisterLiveMessageListener();
                aVar.a(m.this.fF);
                aVar.a(m.this.fE);
                aVar.a(new ax(m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i4, String str) {
            m.this.f("1", 2);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.ad.feed.b.m.11.4
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (m.this.abm == null || m.this.fL) {
                        return;
                    }
                    m.this.abm.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cG(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            m.this.fD = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aj.a aVar) {
            double d4;
            if (m.this.fL) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.fz == 0.0d) {
                m.this.fz = aVar.height;
                m.this.fy.setRatio((float) d4);
                m.fG.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ac.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            m.this.bw();
            int i4 = aVar.XC;
            if (aVar.Kr) {
                i4 = aVar.XA ? 1 : 2;
            }
            boolean bc = com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.XD;
            com.kwad.components.core.e.d.a.a(new a.C0631a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).an(i4).am(aVar.kl).ag((cVar == null || TextUtils.isEmpty(cVar.KG)) ? "" : aVar.XD.KG).al(5).au(aVar.Kr).as(bc).v(m.this.eV == null ? 0L : m.this.eV.getPlayDuration()).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (m.this.abm != null) {
                        m.this.abm.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            if (m.this.fH) {
                return;
            }
            m.this.cP = aVar.status;
            if (m.this.cP != 1) {
                m.this.f("3", 3);
                return;
            }
            m.this.fS.removeCallbacksAndMessages(null);
            if (m.this.fM != null) {
                m.this.fM.setVisibility(8);
            }
            m.this.mAdWebView.setVisibility(0);
            com.kwad.components.core.o.a.qi().au(m.this.mAdTemplate);
            if (m.this.fQ != null) {
                m.this.fQ.c(2, "");
            }
        }
    }

    static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    static /* synthetic */ boolean a(m mVar, boolean z3) {
        mVar.eQ = false;
        return false;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fN = motionEvent.getX();
        this.fO = motionEvent.getY();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            if (view == this.eL || view == this.fB) {
                a(this.eN, 153);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.m.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.Kr) {
            return aVar.XA;
        }
        return aVar.XC == 1;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view == this.eL) {
            if (this.eN.isIdle()) {
                com.kwad.sdk.utils.l.ek(this.mAdTemplate);
                this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
                this.eN.start();
                return;
            }
            a(this.eN, 100);
        } else if (view == this.fB) {
            a(this.eN, 25);
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i4) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            FeedType.fromInt(this.mAdTemplate.type);
            bw();
            com.kwad.components.core.e.d.a.a(new a.C0631a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).as(com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.aL(i4);
                }
            }));
        }
    }
}
