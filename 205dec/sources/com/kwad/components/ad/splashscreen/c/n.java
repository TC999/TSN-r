package com.kwad.components.ad.splashscreen.c;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n extends e {
    private AdMatrixInfo.SplashSlideInfo DJ;
    private TextView DK;
    private ImageView DL;
    private com.kwad.components.ad.splashscreen.widget.c DM;
    private KsSplashSlidePathView DN;
    private com.kwad.components.core.e.d.c DO;
    private double DP;
    private com.kwad.components.ad.splashscreen.f.a Dt;
    private TextView hz;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.DJ = splashSlideInfo;
        this.DP = splashSlideInfo.convertDistance;
        int i4 = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.c cVar = new com.kwad.components.ad.splashscreen.widget.c(getContext(), i4);
        this.DM = cVar;
        this.DL.setImageDrawable(cVar);
        this.DL.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.n.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                n.this.lt();
                if (n.this.DM != null) {
                    n.this.DM.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.DJ.title)) {
            this.hz.setText(this.DJ.title);
        } else if (i4 == 0) {
            this.hz.setText("\u5411\u4e0a\u6ed1\u52a8");
        } else if (i4 == 1) {
            this.hz.setText("\u5411\u5de6\u6ed1\u52a8");
        } else if (i4 == 2) {
            this.hz.setText("\u5411\u53f3\u6ed1\u52a8");
        }
        if (!TextUtils.isEmpty(this.DJ.subtitle)) {
            this.DK.setText(this.DJ.subtitle);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.DK.setText(com.kwad.components.ad.splashscreen.d.a(this.Dg.mAdTemplate, this.mAdInfo, this.DO.nW(), 0));
        } else {
            this.DK.setText("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u8005\u7b2c\u4e09\u65b9\u5e94\u7528");
        }
    }

    private void ls() {
        com.kwad.components.ad.splashscreen.f.a aVar = this.Dt;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.f.a aVar2 = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.n.4
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.f.a
                public final void k(int i4, String str) {
                    n.this.DK.setText(str);
                }
            };
            this.Dt = aVar2;
            this.DO.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.Dg.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.DJ != null) {
            com.kwad.sdk.core.adlog.c.d(this.Dg.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cU(this.DJ.style).cM(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME));
            com.kwad.components.core.webview.tachikoma.d.a.sY().aW(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.Dg == null) {
            return;
        }
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.c.n.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                n.this.Dg.CI = SystemClock.elapsedRealtime() - n.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        this.DO = this.Dg.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            ls();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ((ViewStub) findViewById(R.id.ksad_slide_layout)).inflate();
        this.hz = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.DK = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.DL = (ImageView) findViewById(R.id.ksad_splash_slideView);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.ksad_splash_slideTouchView)).inflate();
        this.DN = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.c.n.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f4, float f5, float f6, float f7) {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                final float px2dip = com.kwad.sdk.d.a.a.px2dip(n.this.getContext(), (float) Math.sqrt(Math.pow(f6 - f4, 2.0d) + Math.pow(f7 - f5, 2.0d)));
                if (px2dip < n.this.DP || (hVar = (nVar = n.this).Dg) == null) {
                    return;
                }
                hVar.a(1, nVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.n.1.1
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                        bVar.cU(n.this.DJ.style);
                        bVar.cV((int) px2dip);
                    }
                });
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void lu() {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (!com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo) || (hVar = (nVar = n.this).Dg) == null) {
                    return;
                }
                hVar.c(1, nVar.getContext(), 53, 2);
            }
        });
    }
}
