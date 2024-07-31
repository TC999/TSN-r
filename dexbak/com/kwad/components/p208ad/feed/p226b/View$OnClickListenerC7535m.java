package com.kwad.components.p208ad.feed.p226b;

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
import com.alibaba.fastjson.asm.Opcodes;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.liveEnd.C8693a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p299j.C8682a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.C8993e;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.core.webview.AbstractC9028c;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.C9013b;
import com.kwad.components.core.webview.jshandler.C9040ab;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9067aj;
import com.kwad.components.core.webview.jshandler.C9089ao;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9096ar;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9111ax;
import com.kwad.components.core.webview.jshandler.C9116ay;
import com.kwad.components.core.webview.jshandler.C9123ba;
import com.kwad.components.core.webview.jshandler.C9145e;
import com.kwad.components.core.webview.jshandler.C9147f;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b;
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
import com.kwad.components.p208ad.feed.C7499b;
import com.kwad.components.p208ad.feed.C7586d;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.components.p208ad.feed.p225a.C7498b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.feed.b.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7535m extends AbstractDialogInterface$OnDismissListenerC9367b<AdResultData, AdTemplate> implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: fG */
    private static final HashMap<Long, Double> f25694fG = new HashMap<>(8);

    /* renamed from: cB */
    private List<Integer> f25695cB;

    /* renamed from: cP */
    private int f25696cP;

    /* renamed from: dU */
    private KsAdVideoPlayConfig f25697dU;

    /* renamed from: eL */
    private KSRelativeLayout f25698eL;

    /* renamed from: eM */
    private ImageView f25699eM;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f25700eN;

    /* renamed from: eO */
    private C8993e f25701eO;

    /* renamed from: eP */
    private C7518d f25702eP;

    /* renamed from: eQ */
    private boolean f25703eQ;

    /* renamed from: eS */
    private final View$OnClickListenerC8966a.InterfaceC8968a f25704eS;

    /* renamed from: eT */
    private IAdLiveOfflineView f25705eT;

    /* renamed from: eU */
    private InterfaceC8695a f25706eU;

    /* renamed from: eV */
    private IAdLivePlayModule f25707eV;

    /* renamed from: eW */
    private boolean f25708eW;

    /* renamed from: eX */
    private View f25709eX;

    /* renamed from: eY */
    private C8682a.C8684b f25710eY;

    /* renamed from: eZ */
    private final AdLivePlayStateListener f25711eZ;

    /* renamed from: ek */
    private C7586d.InterfaceC7590b f25712ek;

    /* renamed from: ey */
    private long f25713ey;

    /* renamed from: fA */
    private LinearLayout f25714fA;

    /* renamed from: fB */
    private TextView f25715fB;

    /* renamed from: fC */
    private C9123ba f25716fC;

    /* renamed from: fD */
    private C9109aw f25717fD;

    /* renamed from: fE */
    private WebCardRegisterLiveMessageListener f25718fE;

    /* renamed from: fF */
    private WebCardRegisterLiveShopListener f25719fF;

    /* renamed from: fH */
    private boolean f25720fH;

    /* renamed from: fI */
    private String f25721fI;

    /* renamed from: fJ */
    private C9111ax.C9114b f25722fJ;

    /* renamed from: fK */
    private C9111ax.C9113a f25723fK;

    /* renamed from: fL */
    private boolean f25724fL;

    /* renamed from: fM */
    private AbstractDialogInterface$OnDismissListenerC9367b f25725fM;

    /* renamed from: fN */
    private float f25726fN;

    /* renamed from: fO */
    private float f25727fO;

    /* renamed from: fP */
    private boolean f25728fP;

    /* renamed from: fQ */
    private InterfaceC7565a f25729fQ;

    /* renamed from: fR */
    private ViewGroup.MarginLayoutParams f25730fR;

    /* renamed from: fS */
    private Handler f25731fS;

    /* renamed from: fT */
    private C7522e f25732fT;

    /* renamed from: fU */
    private C9096ar f25733fU;

    /* renamed from: fV */
    private boolean f25734fV;

    /* renamed from: fW */
    private boolean f25735fW;

    /* renamed from: fX */
    private C9013b f25736fX;

    /* renamed from: fY */
    private AbstractC9028c f25737fY;

    /* renamed from: fZ */
    private AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a f25738fZ;

    /* renamed from: fa */
    private OfflineOnAudioConflictListener f25739fa;

    /* renamed from: fy */
    private RatioFrameLayout f25740fy;

    /* renamed from: fz */
    private double f25741fz;

    /* renamed from: ga */
    private IAdLiveEndRequest f25742ga;
    private KsAdWebView mAdWebView;
    @Nullable
    private C8619c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final AbstractC10436l<C8693a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* renamed from: com.kwad.components.ad.feed.b.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7565a {
        /* renamed from: c */
        void mo32843c(int i, String str);
    }

    public View$OnClickListenerC7535m(@NonNull Context context) {
        super(context);
        this.f25696cP = -1;
        this.mIsAudioEnable = false;
        this.f25724fL = false;
        this.f25731fS = new Handler(Looper.getMainLooper());
        this.f25734fV = false;
        this.f25735fW = false;
        this.f25739fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                View$OnClickListenerC7535m.m33013a(View$OnClickListenerC7535m.this, false);
                if (View$OnClickListenerC7535m.this.f25700eN != null) {
                    View$OnClickListenerC7535m.this.f25700eN.setVideoSoundEnable(false);
                }
                if (View$OnClickListenerC7535m.this.f25707eV != null) {
                    View$OnClickListenerC7535m.this.f25707eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.f25737fY = new C753911();
        this.f25738fZ = new AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a() { // from class: com.kwad.components.ad.feed.b.m.13
            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdClicked() {
                if (View$OnClickListenerC7535m.this.abm != null) {
                    View$OnClickListenerC7535m.this.abm.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdShow() {
                if (View$OnClickListenerC7535m.this.abm != null && View$OnClickListenerC7535m.this.f25724fL) {
                    View$OnClickListenerC7535m.this.abm.onAdShow();
                }
                if (View$OnClickListenerC7535m.this.f25724fL) {
                    C9913b c9913b = new C9913b();
                    C9893a.C9894a c9894a = new C9893a.C9894a();
                    FeedType fromInt = FeedType.fromInt(View$OnClickListenerC7535m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c9894a.templateId = String.valueOf(fromInt.getType());
                    c9913b.m27268b(c9894a);
                    c9913b.m27245v((int) Math.ceil(View$OnClickListenerC7535m.this.f25741fz), View$OnClickListenerC7535m.this.mWidth);
                    C8934b.m29570qY().m29571a(View$OnClickListenerC7535m.this.mAdTemplate, null, c9913b);
                    C7601b.m32817a(View$OnClickListenerC7535m.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDislikeClicked() {
                if (View$OnClickListenerC7535m.this.abm != null) {
                    View$OnClickListenerC7535m.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogDismiss() {
                if (View$OnClickListenerC7535m.this.abm != null) {
                    View$OnClickListenerC7535m.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogShow() {
                if (View$OnClickListenerC7535m.this.abm != null) {
                    View$OnClickListenerC7535m.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new AbstractC10436l<C8693a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: bC */
            public C8693a createRequest() {
                return new C8693a(View$OnClickListenerC7535m.this.f25742ga);
            }

            @NonNull
            /* renamed from: p */
            private static AdLiveEndCommonResultData m32924p(String str) {
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
                return m32924p(str);
            }
        };
        this.f25711eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String m25873bg = C10483a.m25873bg(View$OnClickListenerC7535m.this.mAdInfo);
                if (TextUtils.isEmpty(m25873bg)) {
                    return;
                }
                InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
                if (interfaceC8695a != null) {
                    View$OnClickListenerC7535m.this.f25742ga = interfaceC8695a.getAdLiveEndRequest(m25873bg);
                }
                View$OnClickListenerC7535m.this.mNetworking.request(new AbstractC10439o<C8693a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
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
                        if (View$OnClickListenerC7535m.this.f25722fJ == null) {
                            View$OnClickListenerC7535m.this.f25723fK = c9113a;
                        } else {
                            View$OnClickListenerC7535m.this.f25722fJ.m29259a(c9113a);
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
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                View$OnClickListenerC7535m.this.m32961c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                C8682a.m30020oG().m30023a(View$OnClickListenerC7535m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = View$OnClickListenerC7535m.this.f25707eV;
                View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                iAdLivePlayModule.setAudioEnabled(view$OnClickListenerC7535m.m32948g(view$OnClickListenerC7535m.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                C8682a.m30020oG().m30023a(View$OnClickListenerC7535m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = View$OnClickListenerC7535m.this.f25707eV;
                View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                iAdLivePlayModule.setAudioEnabled(view$OnClickListenerC7535m.m32948g(view$OnClickListenerC7535m.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                View$OnClickListenerC7535m.this.f25707eV.setAudioEnabled(false, false);
            }
        };
        this.f25704eS = new View$OnClickListenerC8966a.InterfaceC8968a() { // from class: com.kwad.components.ad.feed.b.m.10
            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8968a
            /* renamed from: a */
            public final void mo28932a(int i, C11008ac.C11009a c11009a) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                View$OnClickListenerC7535m.this.m32965bw();
                C8615a.m30233a(new C8615a.C8616a(View$OnClickListenerC7535m.this.getContext()).m30198aq(View$OnClickListenerC7535m.this.mAdTemplate).m30189b(View$OnClickListenerC7535m.this.mApkDownloadHelper).m30205an(i3).m30202ao(z).m30197aq(true).m30207am(i2).m30185d(c11009a).m30194as(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        View$OnClickListenerC7535m.this.m28885tj();
                    }
                }));
            }
        };
    }

    /* renamed from: bh */
    private boolean m32970bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.f25705eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.f25707eV == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.f25705eT.getView().getParent();
        if (viewGroup != this.f25698eL) {
            viewGroup.removeView(this.f25705eT.getView());
            if (this.f25698eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.f25698eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.f25698eL.setTag(null);
            }
            this.f25698eL.addView(this.f25705eT.getView());
            this.f25698eL.setTag(this.f25705eT.getView());
            this.f25707eV.setAudioEnabled(m32948g(this.mIsAudioEnable), false);
            IAdLivePlayModule adLivePlayModule = this.f25706eU.getAdLivePlayModule(this.f25705eT, ServiceProvider.getAppId(), String.valueOf(C10483a.m25819cg(this.mAdInfo)), C10483a.m25818ch(this.mAdInfo), C10483a.m25817ci(this.mAdInfo));
            this.f25707eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.f25711eZ);
        }
        this.f25707eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bi */
    public IAdLivePlayModule m32969bi() {
        m32968bj();
        IAdLiveOfflineView view = this.f25706eU.getView(this.mContext, 3);
        this.f25705eT = view;
        IAdLivePlayModule adLivePlayModule = this.f25706eU.getAdLivePlayModule(view, ServiceProvider.m24362KP().appId, String.valueOf(C10483a.m25819cg(this.mAdInfo)), C10483a.m25818ch(this.mAdInfo), C10483a.m25817ci(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(m32948g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.f25711eZ);
        final View view2 = this.f25705eT.getView();
        if (this.f25698eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.f25698eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.f25698eL.setTag(null);
        }
        this.f25698eL.addView(view2);
        this.f25698eL.setTag(view2);
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.m.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC7535m.this.m32960c(view2);
            }
        });
        m32963by();
        if (this.mIsAudioEnable) {
            C8932a.m29575ah(this.mContext).m29577a(this.f25739fa);
        }
        return adLivePlayModule;
    }

    /* renamed from: bj */
    private void m32968bj() {
        String url = C10483a.m25862br(this.mAdInfo).getUrl();
        this.f25699eM.setVisibility(0);
        this.f25709eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.f25699eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.f25699eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            return;
        }
        this.f25699eM.setImageResource(C9659R.C9661drawable.ksad_ad_live_end);
    }

    /* renamed from: bt */
    private void m32967bt() {
        this.f25731fS.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.m.12
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC7535m.this.mAdWebView.stopLoading();
                View$OnClickListenerC7535m.this.mAdWebView.setVisibility(8);
                View$OnClickListenerC7535m.this.m32951f("0", 1);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bu */
    public void m32966bu() {
        C7586d.InterfaceC7590b interfaceC7590b = new C7586d.InterfaceC7590b() { // from class: com.kwad.components.ad.feed.b.m.17
            @Override // com.kwad.components.p208ad.feed.C7586d.InterfaceC7590b
            /* renamed from: b */
            public final boolean mo32832b(final double d) {
                if (C11067bq.m23850o(View$OnClickListenerC7535m.this.f25740fy, (int) (C10251d.m26543Cl() * 100.0f))) {
                    C8615a.m30233a(new C8615a.C8616a(View$OnClickListenerC7535m.this.getContext()).m30198aq(View$OnClickListenerC7535m.this.mAdTemplate).m30189b(View$OnClickListenerC7535m.this.mApkDownloadHelper).m30205an(2).m30202ao(false).m30197aq(false).m30207am(157).m30209al(5).m30194as(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                        @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                        public final void onAdClicked() {
                            C10331c.m26254d("FeedWebView", "convertEnable End" + C10487e.m25631ea(View$OnClickListenerC7535m.this.mAdTemplate));
                            C9913b c9913b = new C9913b();
                            c9913b.m27246l(d);
                            c9913b.m27266cK(157);
                            View$OnClickListenerC7535m.this.m28886c(c9913b);
                        }
                    }));
                    return true;
                }
                return false;
            }
        };
        this.f25712ek = interfaceC7590b;
        C7586d.m32838a(C10484b.m25780cL(this.mAdTemplate), this.mContext, interfaceC7590b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bw */
    public void m32965bw() {
        if (this.f25728fP) {
            return;
        }
        this.f25728fP = true;
        C7601b.m32814a(this.mAdTemplate, 2, getStayTime());
    }

    /* renamed from: bx */
    private boolean m32964bx() {
        return this.f25696cP == 1;
    }

    /* renamed from: by */
    private void m32963by() {
        this.f25705eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (View$OnClickListenerC7535m.this.f25718fE != null) {
                    View$OnClickListenerC7535m.this.f25718fE.m29345n(list);
                }
            }
        });
        this.f25705eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (View$OnClickListenerC7535m.this.f25719fF != null) {
                    View$OnClickListenerC7535m.this.f25719fF.m29344a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8682a.C8684b getCurrentVoiceItem() {
        if (this.f25710eY == null) {
            this.f25710eY = new C8682a.C8684b(new C8682a.InterfaceC8685c() { // from class: com.kwad.components.ad.feed.b.m.2
                @Override // com.kwad.components.core.p299j.C8682a.InterfaceC8685c
                /* renamed from: bk */
                public final void mo30017bk() {
                    if (View$OnClickListenerC7535m.this.f25708eW) {
                        if (View$OnClickListenerC7535m.this.f25707eV == null) {
                            View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                            view$OnClickListenerC7535m.f25707eV = view$OnClickListenerC7535m.m32969bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = View$OnClickListenerC7535m.this.f25707eV;
                        View$OnClickListenerC7535m view$OnClickListenerC7535m2 = View$OnClickListenerC7535m.this;
                        iAdLivePlayModule.setAudioEnabled(view$OnClickListenerC7535m2.m32948g(view$OnClickListenerC7535m2.mIsAudioEnable), false);
                    } else if (View$OnClickListenerC7535m.this.f25700eN != null) {
                        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = View$OnClickListenerC7535m.this.f25700eN;
                        View$OnClickListenerC7535m view$OnClickListenerC7535m3 = View$OnClickListenerC7535m.this;
                        textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(view$OnClickListenerC7535m3.m32948g(view$OnClickListenerC7535m3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.f25710eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9089ao.InterfaceC9090a getOpenNewPageListener() {
        return new C9089ao.InterfaceC9090a() { // from class: com.kwad.components.ad.feed.b.m.18
            @Override // com.kwad.components.core.webview.jshandler.C9089ao.InterfaceC9090a
            /* renamed from: a */
            public final void mo29284a(C9011b c9011b) {
                AdWebViewActivityProxy.launch(View$OnClickListenerC7535m.this.mContext, new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9011b.title).m29854at(c9011b.url).m29859aC(true).m29856as(View$OnClickListenerC7535m.this.mAdTemplate).m29851pl());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9111ax.InterfaceC9115c getRegisterLiveListener() {
        return new C9111ax.InterfaceC9115c() { // from class: com.kwad.components.ad.feed.b.m.14
            @Override // com.kwad.components.core.webview.jshandler.C9111ax.InterfaceC9115c
            /* renamed from: a */
            public final void mo29258a(C9111ax.C9114b c9114b) {
                View$OnClickListenerC7535m.this.f25722fJ = c9114b;
                if (View$OnClickListenerC7535m.this.f25723fK != null) {
                    View$OnClickListenerC7535m.this.f25722fJ.m29259a(View$OnClickListenerC7535m.this.f25723fK);
                    View$OnClickListenerC7535m.this.f25723fK = null;
                }
            }
        };
    }

    private View$OnClickListenerC8966a.InterfaceC8969b getVideoPlayCallback() {
        return new View$OnClickListenerC8966a.InterfaceC8969b() { // from class: com.kwad.components.ad.feed.b.m.7

            /* renamed from: cC */
            private boolean f25769cC = false;

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bl */
            public final void mo28935bl() {
                if (!this.f25769cC) {
                    this.f25769cC = true;
                    C8766a.m29888qi().m29902b(View$OnClickListenerC7535m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = View$OnClickListenerC7535m.this.f25700eN;
                View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(view$OnClickListenerC7535m.m32948g(view$OnClickListenerC7535m.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bm */
            public final void mo28934bm() {
                C9908c.m27323bL(View$OnClickListenerC7535m.this.mAdTemplate);
                View$OnClickListenerC7535m.this.f25716fC.m29251aQ(9);
                View$OnClickListenerC7535m.this.f25698eL.setVisibility(8);
                if (C7498b.m33148aW() && View$OnClickListenerC7535m.this.f25702eP == null && !View$OnClickListenerC7535m.this.f25734fV) {
                    View$OnClickListenerC7535m.this.f25702eP = new C7518d(View$OnClickListenerC7535m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                    view$OnClickListenerC7535m.addView(view$OnClickListenerC7535m.f25702eP, layoutParams);
                    View$OnClickListenerC7535m.this.f25702eP.m33090bn();
                }
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: e */
            public final void mo28933e(long j) {
                View$OnClickListenerC7535m.this.m32961c(j);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8969b
            public final void onVideoPlayError(int i, int i2) {
                AdTemplate adTemplate = View$OnClickListenerC7535m.this.mAdTemplate;
                String m25977K = C10483a.m25977K(View$OnClickListenerC7535m.this.mAdInfo);
                C7601b.m32815a(adTemplate, 2, 1, m25977K, i + " " + i2, SystemClock.elapsedRealtime() - View$OnClickListenerC7535m.this.f25713ey);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            public final void onVideoPlayStart() {
                C8682a.m30020oG().m30023a(View$OnClickListenerC7535m.this.getCurrentVoiceItem());
                C7601b.m32815a(View$OnClickListenerC7535m.this.mAdTemplate, 1, 1, C10483a.m25977K(View$OnClickListenerC7535m.this.mAdInfo), null, SystemClock.elapsedRealtime() - View$OnClickListenerC7535m.this.f25713ey);
                C9908c.m27324bK(View$OnClickListenerC7535m.this.mAdTemplate);
                View$OnClickListenerC7535m.this.f25716fC.m29251aQ(3);
                if (View$OnClickListenerC7535m.this.f25702eP != null && (View$OnClickListenerC7535m.this.f25702eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) View$OnClickListenerC7535m.this.f25702eP.getParent()).removeView(View$OnClickListenerC7535m.this.f25702eP);
                    View$OnClickListenerC7535m.this.f25702eP.m33089bo();
                    View$OnClickListenerC7535m.this.f25702eP = null;
                }
                if (View$OnClickListenerC7535m.this.f25732fT == null && C10484b.m25782cJ(View$OnClickListenerC7535m.this.mAdTemplate) && View$OnClickListenerC7535m.this.f25734fV) {
                    View$OnClickListenerC7535m.this.f25732fT = new C7522e(View$OnClickListenerC7535m.this.mContext);
                    View$OnClickListenerC7535m.this.f25698eL.addView(View$OnClickListenerC7535m.this.f25732fT, new FrameLayout.LayoutParams(-1, -1));
                    View$OnClickListenerC7535m.this.f25732fT.setOnViewEventListener(new InterfaceC11145c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        @Override // com.kwad.sdk.widget.InterfaceC11145c
                        /* renamed from: a */
                        public final void mo23546a(View view) {
                            if (C10484b.m25781cK(View$OnClickListenerC7535m.this.mAdTemplate)) {
                                return;
                            }
                            View$OnClickListenerC7535m.this.m32931v((int) Opcodes.IFLE);
                        }

                        @Override // com.kwad.sdk.widget.InterfaceC11145c
                        /* renamed from: b */
                        public final void mo23545b(View view) {
                            if (C10484b.m25781cK(View$OnClickListenerC7535m.this.mAdTemplate) || !C10486d.m25657dF(View$OnClickListenerC7535m.this.mAdTemplate)) {
                                return;
                            }
                            View$OnClickListenerC7535m.this.m32931v(153);
                        }
                    });
                    View$OnClickListenerC7535m.this.f25732fT.m33079a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            View$OnClickListenerC7535m.this.f25733fU.m29280aP(1);
                            View$OnClickListenerC7535m.this.f25698eL.removeView(View$OnClickListenerC7535m.this.f25732fT);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        super.mo26182aM();
        C8682a.m30020oG().m30023a(getCurrentVoiceItem());
        if (this.f25708eW) {
            IAdLivePlayModule iAdLivePlayModule = this.f25707eV;
            if (iAdLivePlayModule == null) {
                this.f25707eV = m32969bi();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        super.mo26181aN();
        IAdLivePlayModule iAdLivePlayModule = this.f25707eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        C8682a.m30020oG().m30021c(this.f25710eY);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        C7601b.m32808aZ();
        this.f25740fy = (RatioFrameLayout) findViewById(C9659R.C9662id.ksad_container);
        this.f25698eL = (KSRelativeLayout) findViewById(C9659R.C9662id.ksad_video_container);
        this.f25714fA = (LinearLayout) findViewById(C9659R.C9662id.ksad_video_immerse_text_container);
        this.f25715fB = (TextView) findViewById(C9659R.C9662id.ksad_video_immerse_text);
        this.f25699eM = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.f25709eX = findViewById(C9659R.C9662id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bf */
    public final void mo28889bf() {
        super.mo28889bf();
        if (this.f25696cP == 1 || this.f25720fH) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        m32951f("0", 1);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bv */
    public final void mo28888bv() {
        C9109aw c9109aw;
        AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a interfaceC9370a;
        if (!this.mAdTemplate.mPvReported && (interfaceC9370a = this.abm) != null && this.f25724fL) {
            interfaceC9370a.onAdShow();
            C7601b.m32817a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (this.f25724fL || (c9109aw = this.f25717fD) == null) {
            return;
        }
        c9109aw.m29267ss();
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_webview;
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
            boolean r1 = com.kwad.sdk.core.config.C10251d.m26540Co()
            if (r1 == 0) goto L8d
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.p409b.C10486d.m25657dF(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.p409b.C10484b.m25762cf(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.m33035a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            if (r0 == 0) goto L88
            boolean r0 = r9.f25724fL
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.f25726fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.f25726fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.f25727fO
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7535m.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (z) {
            if (m32970bh()) {
                return;
            }
            TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f25700eN;
            if (textureView$SurfaceTextureListenerC10537a != null && (viewGroup = (ViewGroup) textureView$SurfaceTextureListenerC10537a.getParent()) != this.f25698eL) {
                viewGroup.removeView(this.f25700eN);
                if (this.f25698eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.f25698eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.f25698eL.setTag(null);
                }
                this.f25698eL.addView(this.f25700eN);
                this.f25698eL.setTag(this.f25700eN);
                this.f25700eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.f25701eO.setVideoPlayCallback(getVideoPlayCallback());
                this.f25701eO.setAdClickListener(this.f25704eS);
                this.f25701eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.f25701eO.m29426rM();
                this.f25701eO.setAutoRelease(true);
            }
            AdVideoPlayerViewCache.getInstance().remove(C10483a.m25977K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.f25705eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.f25707eV) == null) {
            return;
        }
        iAdLivePlayModule.onPause();
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final void setMargin(int i) {
    }

    public final void setPreloadListener(InterfaceC7565a interfaceC7565a) {
        InterfaceC7565a interfaceC7565a2 = this.f25729fQ;
        if (interfaceC7565a2 != null) {
            interfaceC7565a2.mo32843c(this.f25696cP == 1 ? 2 : 1, "");
        }
        this.f25729fQ = interfaceC7565a;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        C8993e c8993e;
        IAdLivePlayModule iAdLivePlayModule;
        this.f25697dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r = this.mAdTemplate;
                if (r != 0) {
                    r.mIsAudioEnable = isVideoSoundEnable;
                }
                IAdLiveOfflineView iAdLiveOfflineView = this.f25705eT;
                if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.f25707eV) != null) {
                    iAdLivePlayModule.setAudioEnabled(m32948g(this.mIsAudioEnable), false);
                } else {
                    TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f25700eN;
                    if (textureView$SurfaceTextureListenerC10537a != null) {
                        textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(m32948g(this.mIsAudioEnable));
                    }
                }
                if (this.mIsAudioEnable) {
                    C8932a.m29575ah(this.mContext).m29577a(this.f25739fa);
                }
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (c8993e = this.f25701eO) == null) {
                return;
            }
            c8993e.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: ay */
    private void m32977ay() {
        C9013b c9013b = this.f25736fX;
        if (c9013b != null) {
            c9013b.m29378jp();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.f25736fX = new C9013b();
        this.f25736fX.m29391a(new C9013b.C9027a().m29368az(this.mAdTemplate).m29370aF(C10484b.m25785cG(this.mAdTemplate)).m29366d(this.mAdWebView).m29362k(this.f25740fy).m29364f(this.mApkDownloadHelper).m29371a(this.f25737fY));
        this.mAdWebView.loadUrl(C10484b.m25785cG(this.mAdTemplate));
        R r = this.mAdTemplate;
        C7601b.m32813a(r, C10484b.m25785cG(r));
        m32967bt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m32951f(String str, int i) {
        int i2;
        C10331c.m26254d("FeedWebView", "handleWebViewError " + str);
        this.f25731fS.removeCallbacksAndMessages(null);
        if (this.f25720fH) {
            return;
        }
        this.f25720fH = true;
        if (this.mAdWebView != null) {
            R r = this.mAdTemplate;
            C7601b.m32811a(r, C10484b.m25785cG(r), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i);
        }
        C8766a m29888qi = C8766a.m29888qi();
        AdTemplate adTemplate = this.mAdTemplate;
        m29888qi.m29901b(adTemplate, C10484b.m25785cG(adTemplate), str);
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C10331c.m26254d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i2 = 0;
        }
        C7601b.m32807b(i2, C10483a.m25875be(this.mAdInfo), this.mAdTemplate);
        InterfaceC7565a interfaceC7565a = this.f25729fQ;
        if (interfaceC7565a != null) {
            interfaceC7565a.mo32843c(1, str);
        }
        this.f25729fQ = null;
        if (this.f25725fM == null) {
            this.f25724fL = true;
            AbstractDialogInterface$OnDismissListenerC9367b.m28887c(this);
            int m25875be = C10483a.m25875be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.f25707eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.f25707eV.onDestroy();
                this.f25707eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.f25705eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.f25705eT = null;
            }
            AbstractDialogInterface$OnDismissListenerC9367b m33145a = C7499b.m33145a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), m25875be);
            this.f25725fM = m33145a;
            if (m33145a != null) {
                this.f25725fM.setMargin(C10751a.m24924a(this.mContext, 16.0f));
                this.f25740fy.removeAllViews();
                this.f25740fy.setRatio(Utils.DOUBLE_EPSILON);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.f25698eL.setVisibility(8);
                this.f25725fM.setInnerAdInteractionListener(this.f25738fZ);
                this.f25740fy.addView(this.f25725fM);
                this.f25725fM.mo28891b((AbstractDialogInterface$OnDismissListenerC9367b) this.mAdResultData);
                AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25725fM;
                if (abstractDialogInterface$OnDismissListenerC9367b instanceof AbstractView$OnClickListenerC7506c) {
                    ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b).m33124a(this.f25697dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m32948g(boolean z) {
        if (z) {
            if (this.f25710eY != null) {
                C8682a.m30020oG();
                if (!C8682a.m30022b(this.f25710eY)) {
                    return false;
                }
            }
            if (!C10251d.m26517gs()) {
                if (C8932a.m29575ah(this.mContext).m29572qX()) {
                    return !C8932a.m29575ah(this.mContext).m29573qW();
                }
                return C8932a.m29575ah(this.mContext).m29576aN(false);
            }
            if (!this.f25703eQ) {
                this.f25703eQ = C8932a.m29575ah(this.mContext).m29576aN(true);
            }
            return this.f25703eQ;
        }
        return false;
    }

    /* renamed from: h */
    private static float m32946h(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    private void m32944i(AdTemplate adTemplate) {
        C8619c c8619c = new C8619c(this.mAdTemplate);
        this.mApkDownloadHelper = c8619c;
        c8619c.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        Double d = f25694fG.get(Long.valueOf(this.mAdTemplate.posId));
        if (d != null) {
            this.f25740fy.setRatio(d.floatValue());
        } else if (C10484b.m25779cM(this.mAdTemplate) > Utils.DOUBLE_EPSILON) {
            this.f25740fy.setRatio(C10484b.m25779cM(this.mAdTemplate));
        } else if (this.f25740fy.getRatio() == Utils.DOUBLE_EPSILON) {
            this.f25740fy.setRatio(m32946h(this.mAdTemplate));
        }
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        this.f25706eU = interfaceC8695a;
        if (interfaceC8695a != null && interfaceC8695a.mo28869oK() && C10483a.m25842cL(this.mAdInfo)) {
            this.f25708eW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m32931v(final int i) {
        m32965bw();
        C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(1).m30202ao(true).m30207am(i).m30209al(5).m30197aq(false).m30194as(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.m.8
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                View$OnClickListenerC7535m.this.m28893aL(i);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        if (this.f25712ek != null) {
            C7586d.m32838a(C10484b.m25780cL(this.mAdTemplate), this.mContext, this.f25712ek);
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        this.f25731fS.removeCallbacksAndMessages(null);
        C11103l.m23775ej(this.mAdTemplate);
        C7586d.InterfaceC7590b interfaceC7590b = this.f25712ek;
        if (interfaceC7590b != null) {
            C7586d.m32837a(interfaceC7590b);
        }
        IAdLivePlayModule iAdLivePlayModule = this.f25707eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.f25707eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.f25705eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.f25705eT = null;
        }
        C8682a.m30020oG().m30021c(this.f25710eY);
        this.f25722fJ = null;
        this.f25723fK = null;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m32954d(View$OnClickListenerC7535m view$OnClickListenerC7535m, boolean z) {
        view$OnClickListenerC7535m.f25734fV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m32960c(View view) {
        int width = this.f25698eL.getWidth();
        int height = this.f25698eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        m32949g(m25661n);
        m25661n.realShowType = 2;
        super.mo28891b((View$OnClickListenerC7535m) adResultData);
        if (this.f25720fH) {
            AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25725fM;
            if (abstractDialogInterface$OnDismissListenerC9367b != null) {
                abstractDialogInterface$OnDismissListenerC9367b.mo28891b((AbstractDialogInterface$OnDismissListenerC9367b) adResultData);
                AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b2 = this.f25725fM;
                if (abstractDialogInterface$OnDismissListenerC9367b2 instanceof AbstractView$OnClickListenerC7506c) {
                    ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b2).m33124a(this.f25697dU);
                }
            }
        } else if (!C10484b.m25778cN(this.mAdTemplate)) {
            m32951f("0", 0);
        } else {
            if (!m32964bx()) {
                m32944i(this.mAdTemplate);
            }
            try {
                String str = this.f25721fI;
                if (str == null || !str.equals(m25661n.mOriginJString)) {
                    if (m32964bx()) {
                        this.mAdWebView.reload();
                    } else {
                        this.f25696cP = -2;
                        m32977ay();
                    }
                }
            } catch (Throwable unused) {
                m32951f("0", 0);
            }
            this.f25721fI = m25661n.mOriginJString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m32961c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f25695cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f25695cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* renamed from: g */
    private void m32949g(AdTemplate adTemplate) {
        if (this.f25735fW) {
            return;
        }
        if (C10483a.m25842cL(C10487e.m25641dQ(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(C9659R.C9662id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(C9659R.C9662id.ksad_web_default_bottom_card_webView);
        }
        this.f25735fW = true;
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$11 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    final class C753911 extends AbstractC9028c {
        C753911() {
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29355a(C9003a c9003a, C10605b c10605b) {
            c10605b.aDL = false;
            c9003a.m29403a(new C9147f(View$OnClickListenerC7535m.this.mAdTemplate.loadType));
            View$OnClickListenerC7535m.this.f25716fC = new C9123ba();
            c9003a.m29403a(View$OnClickListenerC7535m.this.f25716fC);
            c9003a.m29403a(new C9089ao(View$OnClickListenerC7535m.this.getOpenNewPageListener()));
            c9003a.m29403a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.InterfaceC9030a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.InterfaceC9030a
                /* renamed from: a */
                public final void mo29341a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (View$OnClickListenerC7535m.this.mAdInfo != null) {
                        if (C10483a.m25877bc(View$OnClickListenerC7535m.this.mAdInfo) || View$OnClickListenerC7535m.this.f25708eW) {
                            View$OnClickListenerC7535m view$OnClickListenerC7535m = View$OnClickListenerC7535m.this;
                            view$OnClickListenerC7535m.f25730fR = (ViewGroup.MarginLayoutParams) view$OnClickListenerC7535m.f25698eL.getLayoutParams();
                            int ceil = (int) Math.ceil(View$OnClickListenerC7535m.this.f25741fz);
                            int i = View$OnClickListenerC7535m.this.mWidth;
                            if (videoPosition.widthRation == Utils.DOUBLE_EPSILON) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = View$OnClickListenerC7535m.this.f25730fR;
                            double d = videoPosition.topMarginRation;
                            double d2 = ceil;
                            Double.isNaN(d2);
                            marginLayoutParams.topMargin = (int) (d * d2);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = View$OnClickListenerC7535m.this.f25730fR;
                            double d3 = videoPosition.leftMarginRation;
                            double d4 = i;
                            Double.isNaN(d4);
                            marginLayoutParams2.leftMargin = (int) (d3 * d4);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = View$OnClickListenerC7535m.this.f25730fR;
                            double d5 = videoPosition.widthRation;
                            Double.isNaN(d4);
                            marginLayoutParams3.width = (int) (d4 * d5);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = View$OnClickListenerC7535m.this.f25730fR;
                            double d6 = View$OnClickListenerC7535m.this.f25730fR.width;
                            double d7 = videoPosition.heightWidthRation;
                            Double.isNaN(d6);
                            marginLayoutParams4.height = (int) (d6 * d7);
                            View$OnClickListenerC7535m.this.f25698eL.setRadius(videoPosition.borderRadius);
                            View$OnClickListenerC7535m.this.f25698eL.setLayoutParams(View$OnClickListenerC7535m.this.f25730fR);
                            View$OnClickListenerC7535m.this.f25698eL.setVisibility(0);
                            if ((View$OnClickListenerC7535m.this.f25697dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) View$OnClickListenerC7535m.this.f25697dU).getVideoSoundValue() != 0) {
                                View$OnClickListenerC7535m view$OnClickListenerC7535m2 = View$OnClickListenerC7535m.this;
                                view$OnClickListenerC7535m2.mIsAudioEnable = view$OnClickListenerC7535m2.f25697dU.isVideoSoundEnable();
                            } else {
                                View$OnClickListenerC7535m view$OnClickListenerC7535m3 = View$OnClickListenerC7535m.this;
                                view$OnClickListenerC7535m3.mIsAudioEnable = C10483a.m25888bT(view$OnClickListenerC7535m3.mAdInfo);
                            }
                            View$OnClickListenerC7535m.this.mAdTemplate.mIsAudioEnable = View$OnClickListenerC7535m.this.mIsAudioEnable;
                            View$OnClickListenerC7535m view$OnClickListenerC7535m4 = View$OnClickListenerC7535m.this;
                            view$OnClickListenerC7535m4.f25695cB = C10483a.m25867bm(view$OnClickListenerC7535m4.mAdInfo);
                            if (View$OnClickListenerC7535m.this.f25708eW) {
                                if (View$OnClickListenerC7535m.this.f25707eV != null) {
                                    IAdLivePlayModule iAdLivePlayModule = View$OnClickListenerC7535m.this.f25707eV;
                                    View$OnClickListenerC7535m view$OnClickListenerC7535m5 = View$OnClickListenerC7535m.this;
                                    iAdLivePlayModule.setAudioEnabled(view$OnClickListenerC7535m5.m32948g(view$OnClickListenerC7535m5.mIsAudioEnable), false);
                                    return;
                                }
                                return;
                            }
                            View$OnClickListenerC7535m view$OnClickListenerC7535m6 = View$OnClickListenerC7535m.this;
                            view$OnClickListenerC7535m6.m33012a(view$OnClickListenerC7535m6.f25697dU);
                        }
                    }
                }
            }));
            c9003a.m29403a(new C9040ab(c10605b, new C9040ab.InterfaceC9042a() { // from class: com.kwad.components.ad.feed.b.m.11.2
                @Override // com.kwad.components.core.webview.jshandler.C9040ab.InterfaceC9042a
                /* renamed from: bA */
                public final void mo29331bA() {
                    View$OnClickListenerC7535m.this.f25731fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            View$OnClickListenerC7535m.this.m28884tk();
                        }
                    });
                }
            }));
            c9003a.m29403a(new C9116ay(new C9116ay.InterfaceC9118a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                @Override // com.kwad.components.core.webview.jshandler.C9116ay.InterfaceC9118a
                /* renamed from: bB */
                public final void mo29256bB() {
                    View$OnClickListenerC7535m.m32954d(View$OnClickListenerC7535m.this, true);
                    View$OnClickListenerC7535m.this.m32966bu();
                }
            }));
            View$OnClickListenerC7535m.this.f25733fU = new C9096ar();
            c9003a.m29403a(View$OnClickListenerC7535m.this.f25733fU);
            if (View$OnClickListenerC7535m.this.f25708eW) {
                c9003a.m29403a(new C9145e(1, 1));
                View$OnClickListenerC7535m.this.f25719fF = new WebCardRegisterLiveShopListener();
                View$OnClickListenerC7535m.this.f25718fE = new WebCardRegisterLiveMessageListener();
                c9003a.m29403a(View$OnClickListenerC7535m.this.f25719fF);
                c9003a.m29403a(View$OnClickListenerC7535m.this.f25718fE);
                c9003a.m29403a(new C9111ax(View$OnClickListenerC7535m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: g */
        public final void mo29348g(int i, String str) {
            View$OnClickListenerC7535m.this.m32951f("1", 2);
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        public final void onAdShow() {
            super.onAdShow();
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.m.11.4
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (View$OnClickListenerC7535m.this.abm == null || View$OnClickListenerC7535m.this.f25724fL) {
                        return;
                    }
                    View$OnClickListenerC7535m.this.abm.onAdShow();
                    C7601b.m32817a(View$OnClickListenerC7535m.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        public final void onPageFinished() {
            C7601b.m32812a(View$OnClickListenerC7535m.this.mAdTemplate, C10484b.m25785cG(View$OnClickListenerC7535m.this.mAdTemplate), System.currentTimeMillis() - View$OnClickListenerC7535m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29351a(C9109aw c9109aw) {
            View$OnClickListenerC7535m.this.f25717fD = c9109aw;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29353a(C9067aj.C9070a c9070a) {
            double d;
            if (View$OnClickListenerC7535m.this.f25724fL) {
                return;
            }
            View$OnClickListenerC7535m.this.mAdWebView.setVisibility(0);
            if (View$OnClickListenerC7535m.this.f25741fz == Utils.DOUBLE_EPSILON) {
                View$OnClickListenerC7535m.this.f25741fz = c9070a.height;
                View$OnClickListenerC7535m.this.f25740fy.setRatio((float) d);
                View$OnClickListenerC7535m.f25694fG.put(Long.valueOf(View$OnClickListenerC7535m.this.mAdTemplate.posId), Double.valueOf(c9070a.height / View$OnClickListenerC7535m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29354a(C9043ac.C9044a c9044a) {
            c9044a.height = 0;
            c9044a.width = View$OnClickListenerC7535m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29349a(C10640a c10640a) {
            View$OnClickListenerC7535m.this.m32965bw();
            int i = c10640a.f29644XC;
            if (c10640a.f29642Kr) {
                i = c10640a.f29643XA ? 1 : 2;
            }
            boolean m25877bc = C10483a.m25877bc(View$OnClickListenerC7535m.this.mAdInfo);
            C10642c c10642c = c10640a.f29645XD;
            C8615a.m30233a(new C8615a.C8616a(View$OnClickListenerC7535m.this.getContext()).m30198aq(View$OnClickListenerC7535m.this.mAdTemplate).m30189b(View$OnClickListenerC7535m.this.mApkDownloadHelper).m30202ao(View$OnClickListenerC7535m.m33016a(View$OnClickListenerC7535m.this, c10640a)).m30205an(i).m30207am(c10640a.f29646kl).m30212ag((c10642c == null || TextUtils.isEmpty(c10642c.f29649KG)) ? "" : c10640a.f29645XD.f29649KG).m30209al(5).m30192au(c10640a.f29642Kr).m30194as(m25877bc).m30158v(View$OnClickListenerC7535m.this.f25707eV == null ? 0L : View$OnClickListenerC7535m.this.f25707eV.getPlayDuration()).m30197aq(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    if (View$OnClickListenerC7535m.this.abm != null) {
                        View$OnClickListenerC7535m.this.abm.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29352a(C9092aq.C9094a c9094a) {
            if (View$OnClickListenerC7535m.this.f25720fH) {
                return;
            }
            View$OnClickListenerC7535m.this.f25696cP = c9094a.status;
            if (View$OnClickListenerC7535m.this.f25696cP != 1) {
                View$OnClickListenerC7535m.this.m32951f("3", 3);
                return;
            }
            View$OnClickListenerC7535m.this.f25731fS.removeCallbacksAndMessages(null);
            if (View$OnClickListenerC7535m.this.f25725fM != null) {
                View$OnClickListenerC7535m.this.f25725fM.setVisibility(8);
            }
            View$OnClickListenerC7535m.this.mAdWebView.setVisibility(0);
            C8766a.m29888qi().m29907au(View$OnClickListenerC7535m.this.mAdTemplate);
            if (View$OnClickListenerC7535m.this.f25729fQ != null) {
                View$OnClickListenerC7535m.this.f25729fQ.mo32843c(2, "");
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m33016a(View$OnClickListenerC7535m view$OnClickListenerC7535m, C10640a c10640a) {
        return m32971b(c10640a);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m33013a(View$OnClickListenerC7535m view$OnClickListenerC7535m, boolean z) {
        view$OnClickListenerC7535m.f25703eQ = false;
        return false;
    }

    /* renamed from: a */
    private void m33035a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.f25726fN = motionEvent.getX();
        this.f25727fO = motionEvent.getY();
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            if (view == this.f25698eL || view == this.f25715fB) {
                m33011a(this.f25700eN, 153);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m33012a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7535m.m33012a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    /* renamed from: b */
    private static boolean m32971b(C10640a c10640a) {
        if (c10640a.f29642Kr) {
            return c10640a.f29643XA;
        }
        return c10640a.f29644XC == 1;
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        if (view == this.f25698eL) {
            if (this.f25700eN.isIdle()) {
                C11103l.m23774ek(this.mAdTemplate);
                this.f25700eN.setKsPlayLogParam(C9877a.m27478bD(this.mAdTemplate));
                this.f25700eN.start();
                return;
            }
            m33011a(this.f25700eN, 100);
        } else if (view == this.f25715fB) {
            m33011a(this.f25700eN, 25);
        }
    }

    /* renamed from: a */
    private void m33011a(TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a, final int i) {
        if (textureView$SurfaceTextureListenerC10537a != null) {
            String m25977K = C10483a.m25977K(this.mAdInfo);
            this.f25701eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().m25523a(m25977K, this.f25700eN);
            FeedType.fromInt(this.mAdTemplate.type);
            m32965bw();
            C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(2).m30194as(C10483a.m25877bc(this.mAdInfo)).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.m.9
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC7535m.this.m28893aL(i);
                }
            }));
        }
    }
}
