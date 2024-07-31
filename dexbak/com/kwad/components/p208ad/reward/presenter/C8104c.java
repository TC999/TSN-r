package com.kwad.components.p208ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11015ai;
import java.io.InputStream;

/* renamed from: com.kwad.components.ad.reward.presenter.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8104c extends C8094b {

    /* renamed from: sc */
    private ImageView f26974sc;

    /* renamed from: sd */
    private AdInfo f26975sd;

    public C8104c(AdInfo adInfo) {
        this.f26975sd = adInfo;
    }

    /* renamed from: a */
    private static void m31580a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f26957qo.mAdTemplate;
        if (m31612hq() || adTemplate.adInfoList.size() <= 0) {
            return;
        }
        String m25964X = C10483a.m25964X(adTemplate.adInfoList.get(0));
        this.f26974sc.setVisibility(mo31500hs());
        try {
            m31580a(this.f26974sc, m25964X, adTemplate);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    /* renamed from: hr */
    protected int mo31501hr() {
        return C9659R.C9662id.ksad_blur_video_cover;
    }

    /* renamed from: hs */
    protected int mo31500hs() {
        getContext();
        if (!C7907g.m32063F(this.f26957qo.mAdTemplate) || C11015ai.m24123LZ()) {
            if (!C7907g.m32065E(this.f26957qo.mAdTemplate) || C11015ai.m24123LZ()) {
                if ((!C10487e.m25629ec(this.f26957qo.mAdTemplate) || C11015ai.m24123LZ()) && !C7907g.m31991g(this.f26975sd)) {
                    return (C10483a.m25850cD(this.f26975sd) && C7844b.m32192gC() && !C11015ai.m24123LZ()) ? 0 : 8;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26974sc = (ImageView) findViewById(mo31501hr());
    }
}
