package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.video.C8994f;
import com.kwad.components.core.video.p331a.AbstractC8971a;
import com.kwad.components.core.video.p331a.C8974d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.AbstractC10545b;
import com.kwad.sdk.core.video.videoview.InterfaceC10547c;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11062bl;
import com.kwad.sdk.widget.KSRelativeLayout;

@SuppressLint({"ViewConstructor"})
@Deprecated
/* renamed from: com.kwad.components.core.video.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class View$OnClickListenerC8966a extends AbstractC10545b implements View.OnClickListener {

    /* renamed from: TA */
    private boolean f28898TA;

    /* renamed from: TB */
    private LinearLayout f28899TB;

    /* renamed from: TC */
    private LinearLayout f28900TC;

    /* renamed from: TD */
    private ImageView f28901TD;

    /* renamed from: TE */
    private ViewGroup f28902TE;

    /* renamed from: TF */
    private TextView f28903TF;

    /* renamed from: TG */
    private InterfaceC8970c f28904TG;

    /* renamed from: TH */
    private InterfaceC8968a f28905TH;

    /* renamed from: TI */
    protected AbstractC8971a f28906TI;

    /* renamed from: TJ */
    private final AbstractC10298a f28907TJ;

    /* renamed from: Ts */
    protected boolean f28908Ts;

    /* renamed from: Tt */
    private boolean f28909Tt;

    /* renamed from: Tu */
    protected boolean f28910Tu;

    /* renamed from: Tv */
    private int f28911Tv;

    /* renamed from: Tw */
    private int f28912Tw;

    /* renamed from: Tx */
    private KSRelativeLayout f28913Tx;

    /* renamed from: Ty */
    private RelativeLayout f28914Ty;

    /* renamed from: Tz */
    private boolean f28915Tz;
    protected AdInfo mAdInfo;
    @NonNull
    protected AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    protected Context mContext;

    /* renamed from: mS */
    protected ImageView f28916mS;

    /* renamed from: mT */
    protected TextView f28917mT;

    /* renamed from: nm */
    private ProgressBar f28918nm;

    /* renamed from: np */
    private boolean f28919np;

    /* renamed from: zS */
    private ImageView f28920zS;

    /* renamed from: zT */
    private TextView f28921zT;

    /* renamed from: com.kwad.components.core.video.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8968a {
        /* renamed from: a */
        void mo28932a(int i, C11008ac.C11009a c11009a);
    }

    /* renamed from: com.kwad.components.core.video.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8969b extends InterfaceC8970c {
        void onVideoPlayError(int i, int i2);
    }

    /* renamed from: com.kwad.components.core.video.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8970c {
        /* renamed from: bl */
        void mo28935bl();

        /* renamed from: bm */
        void mo28934bm();

        /* renamed from: e */
        void mo28933e(long j);

        void onVideoPlayStart();
    }

    public View$OnClickListenerC8966a(Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC10547c interfaceC10547c) {
        super(context, interfaceC10547c);
        this.f28909Tt = true;
        this.f28910Tu = false;
        this.f28898TA = false;
        this.f28907TJ = new AbstractC10298a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25957aE(View$OnClickListenerC8966a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25882bY(View$OnClickListenerC8966a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25795dm(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                View$OnClickListenerC8966a view$OnClickListenerC8966a = View$OnClickListenerC8966a.this;
                view$OnClickListenerC8966a.m29507aD(C10483a.m25957aE(view$OnClickListenerC8966a.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25933ac(View$OnClickListenerC8966a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25980Fg());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                View$OnClickListenerC8966a.this.f28903TF.setText(C10483a.m25795dm(i));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        init();
    }

    /* renamed from: aL */
    private void m29506aL(int i) {
        try {
            InterfaceC8968a interfaceC8968a = this.f28905TH;
            if (interfaceC8968a != null) {
                interfaceC8968a.mo28932a(i, this.f28913Tx.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void init() {
        C10887l.inflate(this.mContext, C9659R.C9663layout.ksad_feed_video_palyer_controller, this);
        this.f28913Tx = (KSRelativeLayout) findViewById(C9659R.C9662id.ksad_video_root_container);
        this.f28914Ty = (RelativeLayout) findViewById(C9659R.C9662id.ksad_data_flow_container);
        this.f28917mT = (TextView) findViewById(C9659R.C9662id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_data_flow_play_btn);
        this.f28916mS = imageView;
        imageView.setOnClickListener(this);
        this.f28899TB = (LinearLayout) findViewById(C9659R.C9662id.ksad_video_network_unavailable);
        this.f28900TC = (LinearLayout) findViewById(C9659R.C9662id.ksad_video_error_container);
        this.f28918nm = (ProgressBar) findViewById(C9659R.C9662id.ksad_video_progress);
        this.f28901TD = (ImageView) findViewById(C9659R.C9662id.ksad_video_thumb_image);
        String url = C10483a.m25862br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f28901TD.setImageDrawable(null);
            KSImageLoader.loadImage(this.f28901TD, url, this.mAdTemplate);
            this.f28901TD.setVisibility(0);
        } else {
            this.f28901TD.setVisibility(8);
        }
        this.f28917mT.setText(C11062bl.m23867ab(C10483a.m25976L(this.mAdInfo) * 1000));
        this.f28906TI = C8974d.m29494ay(this.mAdTemplate);
        mo29421rh();
    }

    /* renamed from: ri */
    private void m29504ri() {
        ViewGroup viewGroup = this.f28902TE;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: rm */
    private void m29500rm() {
        this.f28914Ty.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        if (this.f28898TA) {
            return;
        }
        this.f28918nm.setVisibility(z ? 0 : 8);
        this.f28915Tz = z;
    }

    /* renamed from: aD */
    public final void m29507aD(String str) {
        ((TextView) findViewById(C9659R.C9662id.ksad_app_download)).setText(str);
    }

    /* renamed from: aO */
    public final void m29505aO(boolean z) {
        if (this.f28898TA) {
            return;
        }
        if (z) {
            if (this.f28915Tz) {
                this.f28918nm.setVisibility(0);
                return;
            }
            return;
        }
        this.f28918nm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ex */
    public void mo29423ex() {
        if (C10483a.m25956aF(this.mAdInfo)) {
            this.f28920zS = (ImageView) findViewById(C9659R.C9662id.ksad_video_complete_app_icon);
            this.f28921zT = (TextView) findViewById(C9659R.C9662id.ksad_app_name);
            this.f28903TF = (TextView) findViewById(C9659R.C9662id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.f28920zS, C10487e.m25636dV(this.mAdTemplate), this.mAdTemplate, 12);
            this.f28921zT.setText(C10483a.m25823cc(this.mAdInfo));
            this.f28903TF.setText(C10483a.m25957aE(this.mAdInfo));
            this.f28902TE = (LinearLayout) findViewById(C9659R.C9662id.ksad_video_complete_app_container);
            this.f28920zS.setOnClickListener(this);
            this.f28921zT.setOnClickListener(this);
            this.f28903TF.setOnClickListener(this);
            C8619c c8619c = new C8619c(this.mAdTemplate);
            this.mApkDownloadHelper = c8619c;
            c8619c.m30151b(this.f28907TJ);
        } else {
            TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_h5_open);
            this.f28903TF = textView;
            textView.setText(C10483a.m25957aE(this.mAdInfo));
            this.f28903TF.setOnClickListener(this);
            this.f28902TE = (LinearLayout) findViewById(C9659R.C9662id.ksad_video_complete_h5_container);
        }
        this.f28902TE.setOnClickListener(this);
        this.f28902TE.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.AbstractC10545b
    /* renamed from: n */
    public final void mo25494n(int i, int i2) {
        this.f28912Tw = i2;
        this.f28911Tv = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f28916mS) {
            this.f28908Ts = true;
            this.f28909Tt = true;
            mo29420rn();
        } else if (view == this.f28920zS) {
            m29506aL(1);
        } else if (view == this.f28921zT) {
            m29506aL(2);
        } else if (view == this.f28903TF) {
            m29506aL(3);
        } else {
            m29506aL(4);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.AbstractC10545b
    public final void onPlayStateChanged(int i) {
        AbstractC8971a abstractC8971a;
        C10331c.m26254d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            m25491rx();
            setTopBottomVisible(false);
            this.f28899TB.setVisibility(8);
            this.f28900TC.setVisibility(0);
            InterfaceC8970c interfaceC8970c = this.f28904TG;
            if (interfaceC8970c instanceof C8994f.InterfaceC8995a) {
                ((C8994f.InterfaceC8995a) interfaceC8970c).onVideoPlayError(this.f28911Tv, this.f28912Tw);
            }
            InterfaceC8970c interfaceC8970c2 = this.f28904TG;
            if (interfaceC8970c2 instanceof InterfaceC8969b) {
                ((InterfaceC8969b) interfaceC8970c2).onVideoPlayError(this.f28911Tv, this.f28912Tw);
            }
            C8766a.m29888qi().m29900c(this.mAdTemplate, this.f28911Tv, this.f28912Tw);
            AbstractC8971a abstractC8971a2 = this.f28906TI;
            if (abstractC8971a2 != null) {
                abstractC8971a2.onMediaPlayError(this.f28911Tv, this.f28912Tw);
            }
        } else if (i == 9) {
            InterfaceC8970c interfaceC8970c3 = this.f28904TG;
            if (interfaceC8970c3 != null) {
                interfaceC8970c3.mo28934bm();
            }
            m25491rx();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.f28901TD, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
            this.f28901TD.setVisibility(0);
            mo29423ex();
            AbstractC8971a abstractC8971a3 = this.f28906TI;
            if (abstractC8971a3 != null) {
                abstractC8971a3.onMediaPlayCompleted();
            }
        } else if (i == 1) {
            m29500rm();
            this.f28899TB.setVisibility(8);
            this.f28900TC.setVisibility(8);
            this.f28918nm.setVisibility(8);
            m29504ri();
        } else if (i == 2) {
            InterfaceC8970c interfaceC8970c4 = this.f28904TG;
            if (interfaceC8970c4 != null) {
                interfaceC8970c4.onVideoPlayStart();
            }
            AbstractC8971a abstractC8971a4 = this.f28906TI;
            if (abstractC8971a4 != null) {
                abstractC8971a4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            m25492rw();
        } else if (i == 4) {
            InterfaceC8970c interfaceC8970c5 = this.f28904TG;
            if (interfaceC8970c5 != null) {
                interfaceC8970c5.mo28935bl();
            }
            this.f28901TD.setVisibility(8);
            AbstractC8971a abstractC8971a5 = this.f28906TI;
            if (abstractC8971a5 != null) {
                abstractC8971a5.mo29491oD();
                this.f28906TI.onMediaPlaying();
            }
        } else if (i == 5) {
            AbstractC8971a abstractC8971a6 = this.f28906TI;
            if (abstractC8971a6 != null) {
                abstractC8971a6.onMediaPlayPaused();
            }
        } else if (i != 6) {
            if (i == 7 && (abstractC8971a = this.f28906TI) != null) {
                abstractC8971a.onVideoPlayBufferingPaused();
            }
        } else {
            AbstractC8971a abstractC8971a7 = this.f28906TI;
            if (abstractC8971a7 != null) {
                abstractC8971a7.onVideoPlayBufferingPlaying();
            }
        }
    }

    public void release() {
        this.aBE.release();
        AbstractC8971a abstractC8971a = this.f28906TI;
        if (abstractC8971a != null) {
            abstractC8971a.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.AbstractC10545b
    @UiThread
    public final void reset() {
        m25491rx();
        this.f28918nm.setProgress(0);
        this.f28918nm.setSecondaryProgress(0);
        m29500rm();
        this.f28899TB.setVisibility(8);
        this.f28900TC.setVisibility(8);
        this.f28918nm.setVisibility(8);
        this.f28901TD.setVisibility(8);
        this.f28914Ty.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        m29504ri();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rh */
    public void mo29421rh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rj */
    public final void m29503rj() {
        this.f28899TB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rk */
    public final void m29502rk() {
        this.f28899TB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rl */
    public final void m29501rl() {
        this.f28914Ty.setVisibility(0);
        this.f28901TD.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rn */
    public void mo29420rn() {
        if (this.aBE.isIdle()) {
            AbstractC8971a abstractC8971a = this.f28906TI;
            if (abstractC8971a != null) {
                abstractC8971a.onStart();
            }
            if (!C11013ag.isNetworkConnected(this.mContext)) {
                m29503rj();
                return;
            }
            m29502rk();
            if (this.f28910Tu) {
                m29499ro();
                this.aBE.start();
            } else if (this.f28909Tt && C11013ag.isWifiConnected(this.mContext)) {
                m29499ro();
                this.aBE.start();
            } else if (this.f28909Tt && (this.f28919np || this.f28908Ts)) {
                m29499ro();
                this.aBE.start();
            } else {
                m29501rl();
            }
        } else if (this.aBE.isPaused() || this.aBE.mo25490Gj()) {
            m29499ro();
            this.aBE.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ro */
    public final void m29499ro() {
        this.aBE.setKsPlayLogParam(C9877a.m27478bD(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rp */
    public void mo29419rp() {
        this.aBE.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.AbstractC10545b
    /* renamed from: rq */
    public final void mo25493rq() {
        long currentPosition = this.aBE.getCurrentPosition();
        long duration = this.aBE.getDuration();
        this.f28918nm.setSecondaryProgress(this.aBE.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.f28918nm.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        InterfaceC8970c interfaceC8970c = this.f28904TG;
        if (interfaceC8970c != null) {
            interfaceC8970c.mo28933e(currentPosition);
        }
    }

    /* renamed from: rr */
    public final void m29498rr() {
        this.f28898TA = true;
        this.f28918nm.setVisibility(8);
    }

    public void setAdClickListener(InterfaceC8968a interfaceC8968a) {
        this.f28905TH = interfaceC8968a;
    }

    public void setCanControlPlay(boolean z) {
        this.f28910Tu = z;
    }

    public void setDataAutoStart(boolean z) {
        this.f28909Tt = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f28919np = z;
    }

    public void setVideoPlayCallback(InterfaceC8970c interfaceC8970c) {
        this.f28904TG = interfaceC8970c;
    }
}
