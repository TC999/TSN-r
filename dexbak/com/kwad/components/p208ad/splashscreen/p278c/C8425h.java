package com.kwad.components.p208ad.splashscreen.p278c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.p208ad.splashscreen.SplashPreloadManager;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.kwad.components.ad.splashscreen.c.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8425h extends C8421e {

    /* renamed from: Di */
    private ImageView f27737Di;

    /* renamed from: Dj */
    private ImageView f27738Dj;

    /* renamed from: Dk */
    private boolean f27739Dk = false;

    /* renamed from: Dl */
    private boolean f27740Dl = false;

    /* renamed from: Dm */
    Runnable f27741Dm = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.5
        @Override // java.lang.Runnable
        public final void run() {
            C8497b.m30550kV();
            C8497b.m30566ae(C8425h.this.f27734Dg.mAdTemplate);
            C8425h.this.m30740lh();
        }
    };
    private AdInfo mAdInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.c.h$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C84261 implements ImageLoadingListener {
        C84261() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            C8425h.this.m30739li();
            C8425h.this.f27738Dj.setVisibility(0);
            GlobalThreadPools.m25606FC().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    C8425h.this.f27738Dj.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8425h.this.f27738Dj.setImageDrawable(new BitmapDrawable(C8425h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            C8425h.this.m30740lh();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: lg */
    private void m30741lg() {
        if (C10251d.m26527a(C8363a.f27628CQ)) {
            C8497b.m30550kV();
            C8497b.m30568ac(this.f27734Dg.mAdTemplate);
            C11064bn.runOnUiThreadDelay(this.f27741Dm, C10251d.m26524a(C8363a.f27629CR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lh */
    public void m30740lh() {
        if (this.f27739Dk) {
            return;
        }
        this.f27739Dk = true;
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        findViewById(C9659R.C9662id.ksad_splash_default_image_view).setVisibility(0);
        KSCornerImageView kSCornerImageView = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_splash_default_icon);
        kSCornerImageView.setRadius(C10751a.m24924a(getContext(), 12.0f));
        KSImageLoader.loadImage(kSCornerImageView, C10483a.m25820cf(m25641dQ), this.f27734Dg.mAdTemplate);
        ((TextView) findViewById(C9659R.C9662id.ksad_splash_default_title)).setText(C10483a.m25823cc(m25641dQ));
        TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_splash_default_desc);
        if (TextUtils.isEmpty(C10483a.m25915au(m25641dQ))) {
            textView.setVisibility(8);
        } else {
            textView.setText(C10483a.m25915au(m25641dQ));
        }
        this.f27737Di.setVisibility(8);
        this.f27738Dj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: li */
    public void m30739li() {
        if (this.f27740Dl) {
            return;
        }
        this.f27740Dl = true;
        if (C10251d.m26527a(C8363a.f27628CQ)) {
            C8497b.m30550kV();
            C8497b.m30567ad(this.f27734Dg.mAdTemplate);
            C11064bn.m23858c(this.f27741Dm);
        }
    }

    /* renamed from: m */
    private void m30738m(String str, int i) {
        if (i == 0) {
            this.f27737Di.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f27737Di.setVisibility(0);
            KSImageLoader.loadImage(this.f27737Di, str, this.f27734Dg.mAdTemplate, new C84261());
            return;
        }
        this.f27738Dj.setVisibility(0);
        if (C10251d.m26527a(C8363a.f27627CP)) {
            m30746a(this.f27738Dj, this.mAdInfo);
        } else {
            m30747a(this.f27738Dj);
        }
        KSImageLoader.loadImage(this.f27738Dj, str, this.f27734Dg.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.h.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                return false;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingCancelled(String str2, View view) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                C8425h.this.m30739li();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                C8425h.this.m30740lh();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingStarted(String str2, View view) {
            }
        });
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27738Dj = (ImageView) findViewById(C9659R.C9662id.ksad_splash_background);
        this.f27737Di = (ImageView) findViewById(C9659R.C9662id.ksad_splash_foreground);
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        this.mAdInfo = m25641dQ;
        String str = C10483a.m25941aU(m25641dQ).materialUrl;
        this.f27738Dj.setVisibility(0);
        int i = C10483a.m25941aU(this.mAdInfo).source;
        m30741lg();
        if (getContext() != null) {
            SplashPreloadManager.m30908ky();
            File m30914T = SplashPreloadManager.m30914T(this.mAdInfo.adPreloadInfo.preloadId);
            if (m30914T != null && m30914T.exists() && m30914T.length() > 0) {
                str = Uri.fromFile(m30914T).toString();
            }
            m30738m(str, i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m30739li();
    }

    /* renamed from: a */
    private void m30746a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.f27734Dg.mRootContainer.findViewById(C9659R.C9662id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo m25815ck = C10483a.m25815ck(adInfo);
        imageView.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.h.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = C10483a.m25941aU(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = m25815ck;
                double d2 = cutRuleInfo.picHeight;
                double d3 = cutRuleInfo.viewTopMargin;
                double d4 = cutRuleInfo.safeAreaHeight;
                if (d2 <= Utils.DOUBLE_EPSILON || d4 <= Utils.DOUBLE_EPSILON) {
                    return;
                }
                double d5 = width;
                Double.isNaN(d5);
                Double.isNaN(d);
                double d6 = d5 / d;
                Double.isNaN(d2);
                Double.isNaN(d4);
                Double.isNaN(d3);
                double d7 = d3 / (d2 - d4);
                Double.isNaN(d3);
                double d8 = d3 * d6;
                Double.isNaN(d2);
                double d9 = height;
                Double.isNaN(d9);
                double d10 = (d2 * d6) - d9;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d10 / 2.0d) - (d8 - (d8 - (d7 * d10)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    /* renamed from: a */
    private void m30747a(final ImageView imageView) {
        ((FrameLayout) this.f27734Dg.mRootContainer.findViewById(C9659R.C9662id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.h.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f = width * 2340.0f;
                float height = imageView.getHeight();
                float f2 = (f - height) / 2.0f;
                float f3 = f - (((width * 880.0f) * 1152.0f) / 880.0f);
                float f4 = (f3 * 0.5589225f) - f2;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((f4 - ((0.44107744f * f3) - f2)) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }
}
