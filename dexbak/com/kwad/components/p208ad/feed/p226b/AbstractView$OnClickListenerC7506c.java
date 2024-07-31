package com.kwad.components.p208ad.feed.p226b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p299j.C8682a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.C8993e;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.p208ad.feed.C7598f;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.components.p208ad.feed.p225a.C7498b;
import com.kwad.components.p208ad.widget.DownloadProgressView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.InterfaceC11154j;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.feed.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractView$OnClickListenerC7506c extends AbstractC7501a implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: cB */
    private List<Integer> f25613cB;

    /* renamed from: cC */
    private volatile boolean f25614cC;

    /* renamed from: cD */
    private InterfaceC11154j f25615cD;

    /* renamed from: dE */
    private ImageView f25616dE;

    /* renamed from: dF */
    private TextView f25617dF;

    /* renamed from: dM */
    private TextView f25618dM;

    /* renamed from: dU */
    private KsAdVideoPlayConfig f25619dU;

    /* renamed from: eB */
    private TextView f25620eB;

    /* renamed from: eD */
    private ImageView f25621eD;

    /* renamed from: eF */
    private TextView f25622eF;

    /* renamed from: eG */
    private TextView f25623eG;

    /* renamed from: eH */
    private View f25624eH;

    /* renamed from: eI */
    private DownloadProgressView f25625eI;

    /* renamed from: eL */
    private KSRelativeLayout f25626eL;

    /* renamed from: eM */
    private ImageView f25627eM;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f25628eN;

    /* renamed from: eO */
    private C8993e f25629eO;

    /* renamed from: eP */
    private C7518d f25630eP;

    /* renamed from: eQ */
    private boolean f25631eQ;

    /* renamed from: eR */
    private TextView f25632eR;

    /* renamed from: eS */
    private final View$OnClickListenerC8966a.InterfaceC8968a f25633eS;

    /* renamed from: eT */
    private IAdLiveOfflineView f25634eT;

    /* renamed from: eU */
    private InterfaceC8695a f25635eU;

    /* renamed from: eV */
    private IAdLivePlayModule f25636eV;

    /* renamed from: eW */
    private boolean f25637eW;

    /* renamed from: eX */
    private View f25638eX;

    /* renamed from: eY */
    private C8682a.C8684b f25639eY;

    /* renamed from: eZ */
    private final AdLivePlayStateListener f25640eZ;

    /* renamed from: fa */
    private OfflineOnAudioConflictListener f25641fa;

    /* renamed from: fb */
    private View$OnClickListenerC8966a.InterfaceC8969b f25642fb;
    private C8619c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    public AbstractView$OnClickListenerC7506c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.f25614cC = false;
        this.f25615cD = new InterfaceC11154j() { // from class: com.kwad.components.ad.feed.b.c.1
            @Override // com.kwad.sdk.widget.InterfaceC11154j
            /* renamed from: ao */
            public final void mo23526ao() {
                C11103l.m23773el(AbstractView$OnClickListenerC7506c.this.mAdTemplate);
            }
        };
        this.f25633eS = new View$OnClickListenerC8966a.InterfaceC8968a() { // from class: com.kwad.components.ad.feed.b.c.3
            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8968a
            /* renamed from: a */
            public final void mo28932a(int i, C11008ac.C11009a c11009a) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                AbstractView$OnClickListenerC7506c.this.m33140ba();
                C8615a.m30233a(new C8615a.C8616a(AbstractView$OnClickListenerC7506c.this.getContext()).m30198aq(AbstractView$OnClickListenerC7506c.this.mAdTemplate).m30189b(AbstractView$OnClickListenerC7506c.this.mApkDownloadHelper).m30205an(i3).m30202ao(z).m30197aq(true).m30209al(5).m30207am(i2).m30185d(c11009a).m30194as(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        AbstractView$OnClickListenerC7506c.this.m28885tj();
                    }
                }));
            }
        };
        this.f25640eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.c.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                AbstractView$OnClickListenerC7506c.this.f25632eR.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                AbstractView$OnClickListenerC7506c.this.m33114c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                C8682a.m30020oG().m30023a(AbstractView$OnClickListenerC7506c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = AbstractView$OnClickListenerC7506c.this.f25636eV;
                AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c = AbstractView$OnClickListenerC7506c.this;
                iAdLivePlayModule.setAudioEnabled(abstractView$OnClickListenerC7506c.m33107g(abstractView$OnClickListenerC7506c.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                C8682a.m30020oG().m30023a(AbstractView$OnClickListenerC7506c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = AbstractView$OnClickListenerC7506c.this.f25636eV;
                AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c = AbstractView$OnClickListenerC7506c.this;
                iAdLivePlayModule.setAudioEnabled(abstractView$OnClickListenerC7506c.m33107g(abstractView$OnClickListenerC7506c.mIsAudioEnable), false);
            }
        };
        this.f25641fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.c.8
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                AbstractView$OnClickListenerC7506c.m33121b(AbstractView$OnClickListenerC7506c.this, false);
                if (AbstractView$OnClickListenerC7506c.this.f25628eN != null) {
                    AbstractView$OnClickListenerC7506c.this.f25628eN.setVideoSoundEnable(false);
                }
                if (AbstractView$OnClickListenerC7506c.this.f25636eV != null) {
                    AbstractView$OnClickListenerC7506c.this.f25636eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.f25642fb = new View$OnClickListenerC8966a.InterfaceC8969b() { // from class: com.kwad.components.ad.feed.b.c.10
            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bl */
            public final void mo28935bl() {
                TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = AbstractView$OnClickListenerC7506c.this.f25628eN;
                AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c = AbstractView$OnClickListenerC7506c.this;
                textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(abstractView$OnClickListenerC7506c.m33107g(abstractView$OnClickListenerC7506c.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bm */
            public final void mo28934bm() {
                if (C7498b.m33148aW() && AbstractView$OnClickListenerC7506c.this.f25630eP == null) {
                    AbstractView$OnClickListenerC7506c.this.f25630eP = new C7518d(AbstractView$OnClickListenerC7506c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c = AbstractView$OnClickListenerC7506c.this;
                    abstractView$OnClickListenerC7506c.addView(abstractView$OnClickListenerC7506c.f25630eP, layoutParams);
                    AbstractView$OnClickListenerC7506c.this.f25630eP.m33090bn();
                }
                C9908c.m27323bL(AbstractView$OnClickListenerC7506c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: e */
            public final void mo28933e(long j) {
                AbstractView$OnClickListenerC7506c.this.m33114c(j);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8969b
            public final void onVideoPlayError(int i, int i2) {
                AdTemplate adTemplate = AbstractView$OnClickListenerC7506c.this.mAdTemplate;
                String m25977K = C10483a.m25977K(AbstractView$OnClickListenerC7506c.this.mAdInfo);
                C7601b.m32815a(adTemplate, 2, 1, m25977K, i + " " + i2, SystemClock.elapsedRealtime() - AbstractView$OnClickListenerC7506c.this.f25596ey);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            public final void onVideoPlayStart() {
                C8682a.m30020oG().m30023a(AbstractView$OnClickListenerC7506c.this.getCurrentVoiceItem());
                if (AbstractView$OnClickListenerC7506c.this.f25630eP != null && (AbstractView$OnClickListenerC7506c.this.f25630eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) AbstractView$OnClickListenerC7506c.this.f25630eP.getParent()).removeView(AbstractView$OnClickListenerC7506c.this.f25630eP);
                    AbstractView$OnClickListenerC7506c.this.f25630eP.m33089bo();
                    AbstractView$OnClickListenerC7506c.this.f25630eP = null;
                }
                C7601b.m32815a(AbstractView$OnClickListenerC7506c.this.mAdTemplate, 1, 1, C10483a.m25977K(AbstractView$OnClickListenerC7506c.this.mAdInfo), null, SystemClock.elapsedRealtime() - AbstractView$OnClickListenerC7506c.this.f25596ey);
                C9908c.m27324bK(AbstractView$OnClickListenerC7506c.this.mAdTemplate);
            }
        };
    }

    /* renamed from: bd */
    private void m33120bd() {
        findViewById(C9659R.C9662id.ksad_ad_h5_container).setVisibility(0);
        findViewById(C9659R.C9662id.ksad_ad_download_container).setVisibility(8);
        this.f25623eG = (TextView) findViewById(C9659R.C9662id.ksad_h5_desc);
        this.f25618dM = (TextView) findViewById(C9659R.C9662id.ksad_h5_open_btn);
        this.f25624eH = findViewById(C9659R.C9662id.ksad_h5_open_cover);
        this.f25623eG.setText(C7598f.m32829c(this.mAdTemplate));
        this.f25618dM.setText(C10483a.m25957aE(this.mAdInfo));
        this.f25624eH.setOnClickListener(this);
        this.f25623eG.setOnClickListener(this);
        this.f25618dM.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25624eH, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25623eG, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25618dM, this);
    }

    /* renamed from: be */
    private void m33119be() {
        findViewById(C9659R.C9662id.ksad_ad_download_container).setVisibility(0);
        findViewById(C9659R.C9662id.ksad_ad_h5_container).setVisibility(8);
        this.f25616dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f25617dF = (TextView) findViewById(C9659R.C9662id.ksad_app_title);
        TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_app_desc);
        this.f25622eF = textView;
        C10751a.m24923a(this, this.f25616dE, this.f25617dF, textView);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25616dE, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25617dF, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25622eF, this);
        this.f25617dF.setText(C10483a.m25914av(this.mAdInfo));
        this.f25616dE.setImageResource(C9659R.C9661drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.f25616dE, C10483a.m25820cf(this.mAdInfo), this.mAdTemplate, 8);
        this.f25622eF.setText(C7598f.m32829c(this.mAdTemplate));
        m33139bb();
        this.f25625eI.m30446ai(this.mAdTemplate);
        this.f25625eI.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25625eI, this);
        C8619c c8619c = new C8619c(this.mAdTemplate, null, this.f25625eI.getAppDownloadListener());
        this.mApkDownloadHelper = c8619c;
        c8619c.m30146d(this.f25625eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    /* renamed from: bg */
    private void m33118bg() {
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        this.f25635eU = interfaceC8695a;
        if (interfaceC8695a != null && interfaceC8695a.mo28869oK() && C10483a.m25842cL(this.mAdInfo)) {
            this.f25637eW = true;
        }
    }

    /* renamed from: bh */
    private boolean m33117bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.f25634eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.f25637eW) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.f25634eT.getView().getParent();
        if (viewGroup != this.f25626eL) {
            viewGroup.removeView(this.f25634eT.getView());
            if (this.f25626eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.f25626eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.f25626eL.setTag(null);
            }
            this.f25626eL.addView(this.f25634eT.getView());
            this.f25626eL.setTag(this.f25634eT.getView());
            this.f25636eV.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.f25635eU.getAdLivePlayModule(this.f25634eT, ServiceProvider.getAppId(), String.valueOf(C10483a.m25819cg(this.mAdInfo)), C10483a.m25818ch(this.mAdInfo), C10483a.m25817ci(this.mAdInfo));
            this.f25636eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.f25640eZ);
        }
        this.f25636eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bi */
    public IAdLivePlayModule m33116bi() {
        m33115bj();
        IAdLiveOfflineView view = this.f25635eU.getView(this.mContext, 3);
        this.f25634eT = view;
        IAdLivePlayModule adLivePlayModule = this.f25635eU.getAdLivePlayModule(view, ServiceProvider.m24362KP().appId, String.valueOf(C10483a.m25819cg(this.mAdInfo)), C10483a.m25818ch(this.mAdInfo), C10483a.m25817ci(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(m33107g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.f25640eZ);
        final View view2 = this.f25634eT.getView();
        if (this.f25626eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.f25626eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.f25626eL.setTag(null);
        }
        this.f25626eL.addView(view2);
        this.f25626eL.setTag(view2);
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.c.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AbstractView$OnClickListenerC7506c.this.m33113c(view2);
            }
        });
        if (this.mIsAudioEnable) {
            C8932a.m29575ah(this.mContext).m29577a(this.f25641fa);
        }
        return adLivePlayModule;
    }

    /* renamed from: bj */
    private void m33115bj() {
        String url = C10483a.m25862br(this.mAdInfo).getUrl();
        this.f25627eM.setVisibility(0);
        this.f25638eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.f25627eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.f25627eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.c.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            return;
        }
        this.f25627eM.setImageResource(C9659R.C9661drawable.ksad_ad_live_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8682a.C8684b getCurrentVoiceItem() {
        if (this.f25639eY == null) {
            this.f25639eY = new C8682a.C8684b(new C8682a.InterfaceC8685c() { // from class: com.kwad.components.ad.feed.b.c.2
                @Override // com.kwad.components.core.p299j.C8682a.InterfaceC8685c
                /* renamed from: bk */
                public final void mo30017bk() {
                    if (AbstractView$OnClickListenerC7506c.this.f25637eW) {
                        if (AbstractView$OnClickListenerC7506c.this.f25636eV == null) {
                            AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c = AbstractView$OnClickListenerC7506c.this;
                            abstractView$OnClickListenerC7506c.f25636eV = abstractView$OnClickListenerC7506c.m33116bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = AbstractView$OnClickListenerC7506c.this.f25636eV;
                        AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c2 = AbstractView$OnClickListenerC7506c.this;
                        iAdLivePlayModule.setAudioEnabled(abstractView$OnClickListenerC7506c2.m33107g(abstractView$OnClickListenerC7506c2.mIsAudioEnable), false);
                    } else if (AbstractView$OnClickListenerC7506c.this.f25628eN != null) {
                        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = AbstractView$OnClickListenerC7506c.this.f25628eN;
                        AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c3 = AbstractView$OnClickListenerC7506c.this;
                        textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(abstractView$OnClickListenerC7506c3.m33107g(abstractView$OnClickListenerC7506c3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.f25639eY;
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        super.mo26182aM();
        C8993e c8993e = this.f25629eO;
        if (c8993e != null) {
            c8993e.setVideoPlayCallback(this.f25642fb);
        }
        C8682a.m30020oG().m30023a(getCurrentVoiceItem());
        if (this.f25637eW) {
            IAdLivePlayModule iAdLivePlayModule = this.f25636eV;
            if (iAdLivePlayModule == null) {
                this.f25636eV = m33116bi();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        super.mo26181aN();
        IAdLivePlayModule iAdLivePlayModule = this.f25636eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        C8682a.m30020oG().m30021c(this.f25639eY);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C11103l.m23775ej(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.f25636eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.f25636eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.f25634eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.f25634eT = null;
        }
        C8682a.m30020oG().m30021c(this.f25639eY);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        this.f25620eB = (TextView) findViewById(C9659R.C9662id.ksad_ad_desc);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(C9659R.C9662id.ksad_video_container);
        this.f25626eL = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.f25621eD = (ImageView) findViewById(C9659R.C9662id.ksad_ad_dislike);
        this.f25627eM = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_dislike_logo);
        this.f25625eI = (DownloadProgressView) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.f25632eR = (TextView) findViewById(C9659R.C9662id.ksad_live_end_text);
        this.f25638eX = findViewById(C9659R.C9662id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bf */
    public final void mo28889bf() {
        super.mo28889bf();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this.f25625eI.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            C8932a.m29575ah(this.mContext).m29574b(this.f25641fa);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:
        if (r5 == r4.f25628eN) goto L24;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.f25621eD
            if (r5 != r0) goto L8
            r4.m28884tk()
            return
        L8:
            com.kwad.sdk.widget.KSRelativeLayout r0 = r4.f25626eL
            if (r5 != r0) goto L2c
            com.kwad.sdk.core.video.videoview.a r0 = r4.f25628eN
            if (r0 == 0) goto L2c
            boolean r0 = r0.isIdle()
            if (r0 == 0) goto L2c
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.utils.C11103l.m23774ek(r5)
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.contentalliance.a.a.a r5 = com.kwad.sdk.contentalliance.p383a.p384a.C9877a.m27478bD(r5)
            com.kwad.sdk.core.video.videoview.a r0 = r4.f25628eN
            r0.setKsPlayLogParam(r5)
            com.kwad.sdk.core.video.videoview.a r5 = r4.f25628eN
            r5.start()
            return
        L2c:
            r0 = 35
            android.widget.TextView r1 = r4.f25620eB
            r2 = 1
            r3 = 100
            if (r5 != r1) goto L38
            r0 = 25
            goto L6c
        L38:
            com.kwad.sdk.widget.KSRelativeLayout r1 = r4.f25626eL
            if (r5 != r1) goto L3f
        L3c:
            r0 = 100
            goto L6c
        L3f:
            com.kwad.components.ad.widget.DownloadProgressView r1 = r4.f25625eI
            if (r5 == r1) goto L6b
            android.widget.TextView r1 = r4.f25618dM
            if (r5 == r1) goto L6b
            android.view.View r1 = r4.f25624eH
            if (r5 != r1) goto L4c
            goto L6b
        L4c:
            android.widget.ImageView r1 = r4.f25616dE
            if (r5 != r1) goto L53
            r0 = 13
            goto L6c
        L53:
            android.widget.TextView r1 = r4.f25617dF
            if (r5 != r1) goto L5a
            r0 = 14
            goto L6c
        L5a:
            android.widget.TextView r1 = r4.f25622eF
            if (r5 == r1) goto L68
            android.widget.TextView r1 = r4.f25623eG
            if (r5 != r1) goto L63
            goto L68
        L63:
            com.kwad.sdk.core.video.videoview.a r1 = r4.f25628eN
            if (r5 != r1) goto L6c
            goto L3c
        L68:
            r0 = 101(0x65, float:1.42E-43)
            goto L6c
        L6b:
            r0 = 1
        L6c:
            com.kwad.sdk.core.video.videoview.a r1 = r4.f25628eN
            com.kwad.components.ad.widget.DownloadProgressView r3 = r4.f25625eI
            if (r5 != r3) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            r4.m33123a(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.AbstractView$OnClickListenerC7506c.onClick(android.view.View):void");
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (m33117bh()) {
                return;
            }
            TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f25628eN;
            if (textureView$SurfaceTextureListenerC10537a != null && this.f25629eO != null) {
                ViewGroup viewGroup = (ViewGroup) textureView$SurfaceTextureListenerC10537a.getParent();
                if (this.f25628eN.getParent() != this.f25626eL) {
                    viewGroup.removeView(this.f25628eN);
                    if (this.f25626eL.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.f25626eL;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.f25626eL.setTag(null);
                    }
                    this.f25626eL.addView(this.f25628eN);
                    this.f25626eL.setTag(this.f25628eN);
                    C10483a.m25977K(this.mAdInfo);
                    this.f25628eN.setVideoSoundEnable(this.mIsAudioEnable);
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                    this.f25629eO.setAdClickListener(this.f25633eS);
                    this.f25629eO.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.f25629eO.m29426rM();
                    this.f25629eO.setAutoRelease(true);
                }
            }
            AdVideoPlayerViewCache.getInstance().remove(C10483a.m25977K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.f25634eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null) {
            return;
        }
        this.f25636eV.onPause();
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        C8993e c8993e;
        IAdLivePlayModule iAdLivePlayModule;
        this.f25619dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = C10483a.m25888bT(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.f25634eT;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.f25636eV) != null) {
                iAdLivePlayModule.setAudioEnabled(m33107g(this.mIsAudioEnable), false);
            } else {
                TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f25628eN;
                if (textureView$SurfaceTextureListenerC10537a != null) {
                    textureView$SurfaceTextureListenerC10537a.setVideoSoundEnable(m33107g(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                C8932a.m29575ah(this.mContext).m29577a(this.f25641fa);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (c8993e = this.f25629eO) == null) {
                return;
            }
            c8993e.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m33121b(AbstractView$OnClickListenerC7506c abstractView$OnClickListenerC7506c, boolean z) {
        abstractView$OnClickListenerC7506c.f25631eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33113c(final View view) {
        view.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.c.6
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int width = AbstractView$OnClickListenerC7506c.this.f25626eL.getWidth();
                int height = AbstractView$OnClickListenerC7506c.this.f25626eL.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m33107g(boolean z) {
        if (z) {
            if (!C10251d.m26517gs()) {
                if (C8932a.m29575ah(this.mContext).m29572qX()) {
                    return !C8932a.m29575ah(this.mContext).m29573qW();
                }
                return C8932a.m29575ah(this.mContext).m29576aN(false);
            }
            if (!this.f25631eQ) {
                this.f25631eQ = C8932a.m29575ah(this.mContext).m29576aN(true);
            }
            return this.f25631eQ;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33114c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f25613cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f25613cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((AbstractView$OnClickListenerC7506c) adResultData);
        this.f25620eB.setText(C7598f.m32829c(this.mAdTemplate));
        this.mLogoView.m28912aD(this.mAdTemplate);
        m33118bg();
        if (C10483a.m25956aF(this.mAdInfo)) {
            m33119be();
        } else {
            m33120bd();
        }
        this.f25620eB.setOnClickListener(this);
        this.f25626eL.setOnClickListener(this);
        this.f25621eD.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25620eB, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25626eL, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25621eD, this);
        setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m33124a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.AbstractView$OnClickListenerC7506c.m33124a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m33123a(this.f25628eN, view == this.f25625eI, 153);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        onClick(view);
    }

    /* renamed from: a */
    private void m33123a(TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a, boolean z, final int i) {
        if (textureView$SurfaceTextureListenerC10537a != null || this.f25637eW) {
            String m25977K = C10483a.m25977K(this.mAdInfo);
            if (!this.f25637eW) {
                this.f25629eO.setAutoRelease(false);
            }
            int i2 = z ? 1 : 2;
            if (!this.f25637eW) {
                AdVideoPlayerViewCache.getInstance().m25523a(m25977K, this.f25628eN);
            }
            m33140ba();
            C8615a.C8616a m30202ao = new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(z);
            IAdLivePlayModule iAdLivePlayModule = this.f25636eV;
            C8615a.m30233a(m30202ao.m30158v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).m30205an(i2).m30194as(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.c.9
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    AbstractView$OnClickListenerC7506c.this.m28893aL(i);
                }
            }));
        }
    }
}
