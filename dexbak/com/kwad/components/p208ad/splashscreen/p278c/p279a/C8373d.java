package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a;
import com.kwad.components.p208ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.io.InputStream;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8373d extends C8421e implements InterfaceC10385c {

    /* renamed from: EB */
    private CloseCountDownView f27657EB;

    /* renamed from: EF */
    private ImageView f27658EF;

    /* renamed from: EG */
    private TextView f27659EG;

    /* renamed from: EH */
    private TextView f27660EH;

    /* renamed from: EK */
    private ViewGroup f27661EK;

    /* renamed from: EL */
    private ImageView f27662EL;

    /* renamed from: EM */
    private KsLogoView f27663EM;

    /* renamed from: EN */
    private TextView f27664EN;

    /* renamed from: EO */
    private TextView f27665EO;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m30863V(String str) {
        TextView textView = this.f27664EN;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.f27661EK = (ViewGroup) viewStub.inflate();
        } else {
            this.f27661EK = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_end_card_native_root);
        }
        this.f27662EL = (ImageView) findViewById(C9659R.C9662id.ksad_splash_end_card_native_bg);
        this.f27658EF = (ImageView) findViewById(C9659R.C9662id.ksad_ad_endcard_icon);
        this.f27659EG = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_appname);
        this.f27660EH = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_appdesc);
        this.f27663EM = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_endcard_logo);
        this.f27664EN = (TextView) findViewById(C9659R.C9662id.ksad_ad_btn_title);
        this.f27665EO = (TextView) findViewById(C9659R.C9662id.ksad_ad_btn_sub_title);
        this.f27657EB = (CloseCountDownView) findViewById(C9659R.C9662id.ksad_ad_endcard_close_root);
    }

    /* renamed from: lC */
    private void m30860lC() {
        if (C10483a.m25956aF(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            AbstractC8483a abstractC8483a = new AbstractC8483a(getContext(), this.f27734Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.a.d.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a
                /* renamed from: k */
                public final void mo30633k(int i, String str) {
                    C8373d.this.m30863V(str);
                }
            };
            C8619c c8619c = this.f27734Dg.mApkDownloadHelper;
            if (c8619c != null) {
                c8619c.m30151b(abstractC8483a);
            }
        }
    }

    /* renamed from: lD */
    private void m30859lD() {
        this.f27661EK.setVisibility(0);
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        m30862a(this.f27662EL, C10483a.m25941aU(m25641dQ).materialUrl, this.f27734Dg.mAdTemplate);
        this.f27658EF.setImageResource(C9659R.C9661drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.f27658EF, C10483a.m25820cf(m25641dQ), this.f27734Dg.mAdTemplate, 24);
        this.f27659EG.setText(C10483a.m25823cc(m25641dQ));
        this.f27660EH.setText(C10483a.m25915au(m25641dQ));
        this.f27663EM.m28912aD(this.f27734Dg.mAdTemplate);
        if (!C10483a.m25956aF(m25641dQ)) {
            this.f27664EN.setText("点击查看");
            this.f27665EO.setVisibility(0);
            this.f27665EO.setText("跳转详情页/第三方应用");
        } else {
            m30858y(m25641dQ);
        }
        this.f27657EB.m30525a(m25641dQ);
    }

    /* renamed from: y */
    private void m30858y(AdInfo adInfo) {
        C8489h c8489h = this.f27734Dg;
        C8619c c8619c = c8489h.mApkDownloadHelper;
        if (c8619c == null) {
            return;
        }
        String m30659a = C8474d.m30659a(c8489h.mAdTemplate, adInfo, c8619c.m30141nW(), 0);
        if (!TextUtils.isEmpty(m30659a)) {
            this.f27664EN.setText(m30659a);
        } else {
            this.f27664EN.setText(C10483a.m25957aE(adInfo));
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        this.f27657EB.m30524aM();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        this.f27657EB.m30523aN();
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27734Dg.f27881Cs.mo26187a(this);
        C9908c.m27337b(this.f27734Dg.mAdTemplate, 87, (JSONObject) null);
        m30860lC();
        m30859lD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27657EB.m30520bf();
        this.f27734Dg.f27881Cs.mo26186b(this);
    }

    /* renamed from: a */
    private static void m30862a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.a.d.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }
}
