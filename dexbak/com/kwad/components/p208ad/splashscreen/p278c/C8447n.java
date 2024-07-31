package com.kwad.components.p208ad.splashscreen.p278c;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a;
import com.kwad.components.p208ad.splashscreen.widget.C8516c;
import com.kwad.components.p208ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8447n extends C8421e {

    /* renamed from: DJ */
    private AdMatrixInfo.SplashSlideInfo f27782DJ;

    /* renamed from: DK */
    private TextView f27783DK;

    /* renamed from: DL */
    private ImageView f27784DL;

    /* renamed from: DM */
    private C8516c f27785DM;

    /* renamed from: DN */
    private KsSplashSlidePathView f27786DN;

    /* renamed from: DO */
    private C8619c f27787DO;

    /* renamed from: DP */
    private double f27788DP;

    /* renamed from: Dt */
    private AbstractC8483a f27789Dt;

    /* renamed from: hz */
    private TextView f27790hz;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.f27782DJ = splashSlideInfo;
        this.f27788DP = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        C8516c c8516c = new C8516c(getContext(), i);
        this.f27785DM = c8516c;
        this.f27784DL.setImageDrawable(c8516c);
        this.f27784DL.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.n.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8447n.this.m30710lt();
                if (C8447n.this.f27785DM != null) {
                    C8447n.this.f27785DM.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.f27782DJ.title)) {
            this.f27790hz.setText(this.f27782DJ.title);
        } else if (i == 0) {
            this.f27790hz.setText("向上滑动");
        } else if (i == 1) {
            this.f27790hz.setText("向左滑动");
        } else if (i == 2) {
            this.f27790hz.setText("向右滑动");
        }
        if (!TextUtils.isEmpty(this.f27782DJ.subtitle)) {
            this.f27783DK.setText(this.f27782DJ.subtitle);
        } else if (C10483a.m25956aF(this.mAdInfo)) {
            this.f27783DK.setText(C8474d.m30659a(this.f27734Dg.mAdTemplate, this.mAdInfo, this.f27787DO.m30141nW(), 0));
        } else {
            this.f27783DK.setText("跳转详情页或者第三方应用");
        }
    }

    /* renamed from: ls */
    private void m30711ls() {
        AbstractC8483a abstractC8483a = this.f27789Dt;
        if (abstractC8483a == null) {
            AbstractC8483a abstractC8483a2 = new AbstractC8483a(getContext(), this.f27734Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.n.4
                {
                    super(r3);
                }

                @Override // com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a
                /* renamed from: k */
                public final void mo30633k(int i, String str) {
                    C8447n.this.f27783DK.setText(str);
                }
            };
            this.f27789Dt = abstractC8483a2;
            this.f27787DO.m30151b(abstractC8483a2);
            return;
        }
        abstractC8483a.setAdTemplate(this.f27734Dg.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lt */
    public void m30710lt() {
        if (this.f27782DJ != null) {
            C9908c.m27309d(this.f27734Dg.mAdTemplate, (JSONObject) null, new C9913b().m27256cU(this.f27782DJ.style).m27264cM(190));
            C9279a.m29119sY().m29121aW(190);
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f27734Dg == null) {
            return;
        }
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.n.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8447n.this.f27734Dg.f27876CI = SystemClock.elapsedRealtime() - C8447n.this.mStartTime;
            }
        });
        this.mAdInfo = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        this.f27787DO = this.f27734Dg.mApkDownloadHelper;
        initView();
        if (C10483a.m25956aF(this.mAdInfo)) {
            m30711ls();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ((ViewStub) findViewById(C9659R.C9662id.ksad_slide_layout)).inflate();
        this.f27790hz = (TextView) findViewById(C9659R.C9662id.ksad_splash_slide_title);
        this.f27783DK = (TextView) findViewById(C9659R.C9662id.ksad_splash_slide_actiontext);
        this.f27784DL = (ImageView) findViewById(C9659R.C9662id.ksad_splash_slideView);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(C9659R.C9662id.ksad_splash_slideTouchView)).inflate();
        this.f27786DN = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.InterfaceC8507a() { // from class: com.kwad.components.ad.splashscreen.c.n.1
            @Override // com.kwad.components.p208ad.splashscreen.widget.KsSplashSlidePathView.InterfaceC8507a
            /* renamed from: a */
            public final void mo30498a(float f, float f2, float f3, float f4) {
                C8447n c8447n;
                C8489h c8489h;
                final float px2dip = C10751a.px2dip(C8447n.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                if (px2dip < C8447n.this.f27788DP || (c8489h = (c8447n = C8447n.this).f27734Dg) == null) {
                    return;
                }
                c8489h.m30624a(1, c8447n.getContext(), 153, 2, new C8489h.InterfaceC8492a() { // from class: com.kwad.components.ad.splashscreen.c.n.1.1
                    @Override // com.kwad.components.p208ad.splashscreen.C8489h.InterfaceC8492a
                    /* renamed from: b */
                    public final void mo30595b(@NonNull C9913b c9913b) {
                        c9913b.m27256cU(C8447n.this.f27782DJ.style);
                        c9913b.m27255cV((int) px2dip);
                    }
                });
            }

            @Override // com.kwad.components.p208ad.splashscreen.widget.KsSplashSlidePathView.InterfaceC8507a
            /* renamed from: lu */
            public final void mo30497lu() {
                C8447n c8447n;
                C8489h c8489h;
                if (!C8489h.m30597n(C8447n.this.mAdInfo) || (c8489h = (c8447n = C8447n.this).f27734Dg) == null) {
                    return;
                }
                c8489h.m30618c(1, c8447n.getContext(), 53, 2);
            }
        });
    }
}
