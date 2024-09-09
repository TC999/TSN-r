package com.kwad.components.ad.splashscreen.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.io.File;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends e {
    private ImageView Di;
    private ImageView Dj;
    private boolean Dk = false;
    private boolean Dl = false;
    Runnable Dm = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.5
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.ae(h.this.Dg.mAdTemplate);
            h.this.lh();
        }
    };
    private AdInfo mAdInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.c.h$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class AnonymousClass1 implements ImageLoadingListener {
        AnonymousClass1() {
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
            h.this.li();
            h.this.Dj.setVisibility(0);
            GlobalThreadPools.FC().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Dj.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            h.this.Dj.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.lh();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    private void lg() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ)) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.ac(this.Dg.mAdTemplate);
            bn.runOnUiThreadDelay(this.Dm, com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        if (this.Dk) {
            return;
        }
        this.Dk = true;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        findViewById(R.id.ksad_splash_default_image_view).setVisibility(0);
        KSCornerImageView kSCornerImageView = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        kSCornerImageView.setRadius(com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
        KSImageLoader.loadImage(kSCornerImageView, com.kwad.sdk.core.response.b.a.cf(dQ), this.Dg.mAdTemplate);
        ((TextView) findViewById(R.id.ksad_splash_default_title)).setText(com.kwad.sdk.core.response.b.a.cc(dQ));
        TextView textView = (TextView) findViewById(R.id.ksad_splash_default_desc);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(dQ))) {
            textView.setVisibility(8);
        } else {
            textView.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        }
        this.Di.setVisibility(8);
        this.Dj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.Dl) {
            return;
        }
        this.Dl = true;
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ)) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.ad(this.Dg.mAdTemplate);
            bn.c(this.Dm);
        }
    }

    private void m(String str, int i4) {
        if (i4 == 0) {
            this.Di.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Di.setVisibility(0);
            KSImageLoader.loadImage(this.Di, str, this.Dg.mAdTemplate, new AnonymousClass1());
            return;
        }
        this.Dj.setVisibility(0);
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            a(this.Dj, this.mAdInfo);
        } else {
            a(this.Dj);
        }
        KSImageLoader.loadImage(this.Dj, str, this.Dg.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.h.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                return false;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingCancelled(String str2, View view) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                h.this.li();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                h.this.lh();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingStarted(String str2, View view) {
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Dj = (ImageView) findViewById(R.id.ksad_splash_background);
        this.Di = (ImageView) findViewById(R.id.ksad_splash_foreground);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        this.mAdInfo = dQ;
        String str = com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl;
        this.Dj.setVisibility(0);
        int i4 = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).source;
        lg();
        if (getContext() != null) {
            SplashPreloadManager.ky();
            File T = SplashPreloadManager.T(this.mAdInfo.adPreloadInfo.preloadId);
            if (T != null && T.exists() && T.length() > 0) {
                str = Uri.fromFile(T).toString();
            }
            m(str, i4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        li();
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Dg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo ck = com.kwad.sdk.core.response.b.a.ck(adInfo);
        imageView.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.h.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d4 = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = ck;
                double d5 = cutRuleInfo.picHeight;
                double d6 = cutRuleInfo.viewTopMargin;
                double d7 = cutRuleInfo.safeAreaHeight;
                if (d5 <= 0.0d || d7 <= 0.0d) {
                    return;
                }
                double d8 = width;
                Double.isNaN(d8);
                Double.isNaN(d4);
                double d9 = d8 / d4;
                Double.isNaN(d5);
                Double.isNaN(d7);
                Double.isNaN(d6);
                double d10 = d6 / (d5 - d7);
                Double.isNaN(d6);
                double d11 = d6 * d9;
                Double.isNaN(d5);
                double d12 = height;
                Double.isNaN(d12);
                double d13 = (d5 * d9) - d12;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d13 / 2.0d) - (d11 - (d11 - (d10 * d13)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Dg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.h.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f4 = width * 2340.0f;
                float height = imageView.getHeight();
                float f5 = (f4 - height) / 2.0f;
                float f6 = f4 - (((width * 880.0f) * 1152.0f) / 880.0f);
                float f7 = (f6 * 0.5589225f) - f5;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((f7 - ((0.44107744f * f6) - f5)) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }
}
