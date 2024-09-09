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
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSRelativeLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    private boolean TA;
    private LinearLayout TB;
    private LinearLayout TC;
    private ImageView TD;
    private ViewGroup TE;
    private TextView TF;
    private c TG;
    private InterfaceC0650a TH;
    protected com.kwad.components.core.video.a.a TI;
    private final com.kwad.sdk.core.download.a.a TJ;
    protected boolean Ts;
    private boolean Tt;
    protected boolean Tu;
    private int Tv;
    private int Tw;
    private KSRelativeLayout Tx;
    private RelativeLayout Ty;
    private boolean Tz;
    protected AdInfo mAdInfo;
    @NonNull
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    protected ImageView mS;
    protected TextView mT;
    private ProgressBar nm;
    private boolean np;
    private ImageView zS;
    private TextView zT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0650a {
        void a(int i4, ac.a aVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b extends c {
        void onVideoPlayError(int i4, int i5);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void bl();

        void bm();

        void e(long j4);

        void onVideoPlayStart();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Tt = true;
        this.Tu = false;
        this.TA = false;
        this.TJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.bY(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.dm(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aD(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.Fg());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.dm(i4));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        init();
    }

    private void aL(int i4) {
        try {
            InterfaceC0650a interfaceC0650a = this.TH;
            if (interfaceC0650a != null) {
                interfaceC0650a.a(i4, this.Tx.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void init() {
        com.kwad.sdk.n.l.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Tx = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Ty = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.mT = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.mS = imageView;
        imageView.setOnClickListener(this);
        this.TB = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.TC = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.nm = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.TD = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.TD.setImageDrawable(null);
            KSImageLoader.loadImage(this.TD, url, this.mAdTemplate);
            this.TD.setVisibility(0);
        } else {
            this.TD.setVisibility(8);
        }
        this.mT.setText(bl.ab(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.TI = com.kwad.components.core.video.a.d.ay(this.mAdTemplate);
        rh();
    }

    private void ri() {
        ViewGroup viewGroup = this.TE;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void rm() {
        this.Ty.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z3) {
        if (this.TA) {
            return;
        }
        this.nm.setVisibility(z3 ? 0 : 8);
        this.Tz = z3;
    }

    public final void aD(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public final void aO(boolean z3) {
        if (this.TA) {
            return;
        }
        if (z3) {
            if (this.Tz) {
                this.nm.setVisibility(0);
                return;
            }
            return;
        }
        this.nm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.zS = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.zT = (TextView) findViewById(R.id.ksad_app_name);
            this.TF = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.zS, com.kwad.sdk.core.response.b.e.dV(this.mAdTemplate), this.mAdTemplate, 12);
            this.zT.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
            this.TF.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.TE = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.zS.setOnClickListener(this);
            this.zT.setOnClickListener(this);
            this.TF.setOnClickListener(this);
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.TJ);
        } else {
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
            this.TF = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.TF.setOnClickListener(this);
            this.TE = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
        }
        this.TE.setOnClickListener(this);
        this.TE.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void n(int i4, int i5) {
        this.Tw = i5;
        this.Tv = i4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mS) {
            this.Ts = true;
            this.Tt = true;
            rn();
        } else if (view == this.zS) {
            aL(1);
        } else if (view == this.zT) {
            aL(2);
        } else if (view == this.TF) {
            aL(3);
        } else {
            aL(4);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i4) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.e.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i4);
        if (i4 == -1) {
            rx();
            setTopBottomVisible(false);
            this.TB.setVisibility(8);
            this.TC.setVisibility(0);
            c cVar = this.TG;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Tv, this.Tw);
            }
            c cVar2 = this.TG;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Tv, this.Tw);
            }
            com.kwad.components.core.o.a.qi().c(this.mAdTemplate, this.Tv, this.Tw);
            com.kwad.components.core.video.a.a aVar2 = this.TI;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.Tv, this.Tw);
            }
        } else if (i4 == 9) {
            c cVar3 = this.TG;
            if (cVar3 != null) {
                cVar3.bm();
            }
            rx();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.TD, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            this.TD.setVisibility(0);
            ex();
            com.kwad.components.core.video.a.a aVar3 = this.TI;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
            }
        } else if (i4 == 1) {
            rm();
            this.TB.setVisibility(8);
            this.TC.setVisibility(8);
            this.nm.setVisibility(8);
            ri();
        } else if (i4 == 2) {
            c cVar4 = this.TG;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.TI;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            rw();
        } else if (i4 == 4) {
            c cVar5 = this.TG;
            if (cVar5 != null) {
                cVar5.bl();
            }
            this.TD.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.TI;
            if (aVar5 != null) {
                aVar5.oD();
                this.TI.onMediaPlaying();
            }
        } else if (i4 == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.TI;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
            }
        } else if (i4 != 6) {
            if (i4 == 7 && (aVar = this.TI) != null) {
                aVar.onVideoPlayBufferingPaused();
            }
        } else {
            com.kwad.components.core.video.a.a aVar7 = this.TI;
            if (aVar7 != null) {
                aVar7.onVideoPlayBufferingPlaying();
            }
        }
    }

    public void release() {
        this.aBE.release();
        com.kwad.components.core.video.a.a aVar = this.TI;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        rx();
        this.nm.setProgress(0);
        this.nm.setSecondaryProgress(0);
        rm();
        this.TB.setVisibility(8);
        this.TC.setVisibility(8);
        this.nm.setVisibility(8);
        this.TD.setVisibility(8);
        this.Ty.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        ri();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rj() {
        this.TB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rk() {
        this.TB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rl() {
        this.Ty.setVisibility(0);
        this.TD.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rn() {
        if (this.aBE.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.TI;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(this.mContext)) {
                rj();
                return;
            }
            rk();
            if (this.Tu) {
                ro();
                this.aBE.start();
            } else if (this.Tt && ag.isWifiConnected(this.mContext)) {
                ro();
                this.aBE.start();
            } else if (this.Tt && (this.np || this.Ts)) {
                ro();
                this.aBE.start();
            } else {
                rl();
            }
        } else if (this.aBE.isPaused() || this.aBE.Gj()) {
            ro();
            this.aBE.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ro() {
        this.aBE.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rp() {
        this.aBE.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void rq() {
        long currentPosition = this.aBE.getCurrentPosition();
        long duration = this.aBE.getDuration();
        this.nm.setSecondaryProgress(this.aBE.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.nm.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        c cVar = this.TG;
        if (cVar != null) {
            cVar.e(currentPosition);
        }
    }

    public final void rr() {
        this.TA = true;
        this.nm.setVisibility(8);
    }

    public void setAdClickListener(InterfaceC0650a interfaceC0650a) {
        this.TH = interfaceC0650a;
    }

    public void setCanControlPlay(boolean z3) {
        this.Tu = z3;
    }

    public void setDataAutoStart(boolean z3) {
        this.Tt = z3;
    }

    public void setDataFlowAutoStart(boolean z3) {
        this.np = z3;
    }

    public void setVideoPlayCallback(c cVar) {
        this.TG = cVar;
    }
}
