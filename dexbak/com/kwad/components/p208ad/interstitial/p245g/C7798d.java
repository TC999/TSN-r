package com.kwad.components.p208ad.interstitial.p245g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.p213d.C7355b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.interstitial.g.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7798d extends KSFrameLayout implements InterfaceC11145c {

    /* renamed from: dE */
    private ImageView f26321dE;

    /* renamed from: eF */
    private TextView f26322eF;

    /* renamed from: eM */
    private ImageView f26323eM;

    /* renamed from: kL */
    private KSFrameLayout f26324kL;

    /* renamed from: kr */
    private KSFrameLayout f26325kr;

    /* renamed from: lF */
    private String f26326lF;
    @Nullable

    /* renamed from: lG */
    private View f26327lG;

    /* renamed from: lH */
    private ImageView f26328lH;

    /* renamed from: lI */
    private TextProgressBar f26329lI;

    /* renamed from: lJ */
    private ViewGroup f26330lJ;

    /* renamed from: lK */
    private ViewGroup f26331lK;

    /* renamed from: lL */
    private ImageView f26332lL;

    /* renamed from: lM */
    private View f26333lM;

    /* renamed from: lN */
    private View f26334lN;

    /* renamed from: lO */
    private TextView f26335lO;

    /* renamed from: lP */
    private ImageView f26336lP;

    /* renamed from: lQ */
    private TextView f26337lQ;

    /* renamed from: lR */
    private TextView f26338lR;

    /* renamed from: lS */
    private TextView f26339lS;

    /* renamed from: lT */
    private TextProgressBar f26340lT;

    /* renamed from: lU */
    private TextView f26341lU;

    /* renamed from: lV */
    private InterfaceC7801e f26342lV;

    /* renamed from: lW */
    private final C7800a f26343lW;

    /* renamed from: lX */
    private boolean f26344lX;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.interstitial.g.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7800a {

        /* renamed from: lZ */
        private boolean f26346lZ = false;

        /* renamed from: ma */
        private boolean f26347ma = false;

        /* renamed from: mb */
        private int f26348mb = 0;

        /* renamed from: mc */
        private boolean f26349mc = true;

        /* renamed from: F */
        public final void m32327F(int i) {
            this.f26348mb = i;
        }

        /* renamed from: ej */
        public final int m32324ej() {
            return this.f26348mb;
        }

        /* renamed from: ek */
        public final boolean m32323ek() {
            return this.f26349mc;
        }

        /* renamed from: v */
        public final void m32322v(boolean z) {
            this.f26346lZ = z;
        }

        /* renamed from: w */
        public final void m32321w(boolean z) {
            this.f26347ma = z;
        }

        /* renamed from: x */
        public final void m32320x(boolean z) {
            this.f26349mc = z;
        }
    }

    public C7798d(@NonNull Context context, C7800a c7800a) {
        super(context);
        this.f26326lF = "%s秒后进入试玩页";
        this.f26344lX = false;
        this.f26343lW = c7800a;
        C10887l.inflate(context, c7800a.m32323ek() ? C9659R.C9663layout.ksad_interstitial_native_above : C9659R.C9663layout.ksad_interstitial_native, this);
        m32332s(c7800a.f26346lZ);
    }

    /* renamed from: d */
    private void m32341d(View view, int i) {
        C10751a.m24917b(view, 0, C10751a.m24924a(getContext(), i), 0, 0);
    }

    /* renamed from: ed */
    private void m32340ed() {
        m32350a(this.f26336lP, 40, 40);
        m32350a(this.f26340lT, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, 30);
        this.f26338lR.setTextSize(14.0f);
        m32341d(this.f26340lT, 11);
        m32341d(this.f26338lR, 7);
        m32341d(this.f26339lS, 7);
    }

    /* renamed from: s */
    private void m32332s(boolean z) {
        setClickable(true);
        this.f26325kr = (KSFrameLayout) findViewById(C9659R.C9662id.ksad_interstitial_native_container);
        this.f26324kL = (KSFrameLayout) findViewById(C9659R.C9662id.ksad_interstitial_native_video_container);
        this.f26327lG = findViewById(C9659R.C9662id.ksad_interstitial_full_bg);
        this.f26328lH = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_tail_frame);
        this.f26323eM = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_interstitial_logo);
        this.f26330lJ = (ViewGroup) findViewById(C9659R.C9662id.ksad_interstitial_playing);
        this.f26331lK = (ViewGroup) findViewById(C9659R.C9662id.ksad_interstitial_play_end);
        this.f26329lI = (TextProgressBar) findViewById(C9659R.C9662id.ksad_interstitial_download_btn);
        this.f26333lM = findViewById(C9659R.C9662id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.f26329lI;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(C10751a.m24924a(getContext(), 10.0f));
            this.f26329lI.setTextColor(-1);
        }
        this.f26332lL = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_mute);
        this.f26335lO = (TextView) findViewById(C9659R.C9662id.ksad_interstitial_count_down);
        this.f26336lP = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_logo);
        this.f26338lR = (TextView) findViewById(C9659R.C9662id.ksad_interstitial_name);
        this.f26339lS = (TextView) findViewById(C9659R.C9662id.ksad_interstitial_desc);
        this.f26340lT = (TextProgressBar) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.f26334lN = findViewById(C9659R.C9662id.ksad_ad_download_container);
        this.f26321dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f26337lQ = (TextView) findViewById(C9659R.C9662id.ksad_app_title);
        this.f26322eF = (TextView) findViewById(C9659R.C9662id.ksad_app_desc);
        new GestureDetector$OnGestureListenerC11148f(this, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26323eM, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26329lI, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26340lT, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26333lM, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26331lK, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26335lO, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26334lN, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26321dE, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26337lQ, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26322eF, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26336lP, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26338lR, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26339lS, this);
        this.f26332lL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.g.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7798d.this.f26332lL.setSelected(!C7798d.this.f26332lL.isSelected());
                if (C7798d.this.f26342lV != null) {
                    C7798d.this.f26342lV.mo32304o(C7798d.this.f26332lL.isSelected());
                }
            }
        });
        this.f26341lU = (TextView) findViewById(C9659R.C9662id.ksad_interstitial_playable_timer);
        m32347a(this.f26324kL, z);
        if (C11015ai.isOrientationPortrait()) {
            return;
        }
        m32340ed();
    }

    /* renamed from: c */
    public final void m32343c(String str, AdTemplate adTemplate) {
        if (C11053bg.isNullString(str)) {
            return;
        }
        this.f26323eM.setImageDrawable(null);
        KSImageLoader.loadImage(this.f26323eM, str, adTemplate);
    }

    /* renamed from: ee */
    public final void m32339ee() {
        TextView textView = this.f26335lO;
        if (textView != null) {
            textView.setVisibility(8);
            this.f26344lX = true;
        }
    }

    /* renamed from: ef */
    public final void m32338ef() {
        View view = this.f26333lM;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: eg */
    public final void m32337eg() {
        m32331t(false);
        this.f26331lK.setVisibility(0);
        this.f26328lH.setVisibility(0);
    }

    /* renamed from: eh */
    public final void m32336eh() {
        this.f26331lK.setVisibility(8);
        this.f26328lH.setVisibility(8);
        m32331t(true);
    }

    /* renamed from: ei */
    public final boolean m32335ei() {
        ViewGroup viewGroup = this.f26331lK;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    /* renamed from: f */
    public final void m32334f(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
    }

    /* renamed from: g */
    public final void m32333g(String str, int i) {
        TextProgressBar textProgressBar = this.f26329lI;
        if (textProgressBar != null) {
            textProgressBar.m29709e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.f26340lT;
        if (textProgressBar2 != null) {
            textProgressBar2.m29709e(str, 0);
        }
    }

    @Nullable
    public final View getBlurBgView() {
        return this.f26327lG;
    }

    public final ImageView getTailFrameView() {
        return this.f26328lH;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(InterfaceC7801e interfaceC7801e) {
        this.f26342lV = interfaceC7801e;
    }

    /* renamed from: t */
    public final void m32331t(boolean z) {
        ViewGroup viewGroup = this.f26330lJ;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: u */
    public final void m32330u(boolean z) {
        ImageView imageView = this.f26332lL;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    /* renamed from: w */
    public final void m32329w(String str) {
        TextView textView = this.f26335lO;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.f26343lW.f26347ma || this.f26344lX || this.f26335lO.getVisibility() == 0) {
            return;
        }
        this.f26335lO.setVisibility(0);
    }

    /* renamed from: y */
    public final void m32328y(AdTemplate adTemplate) {
        this.mLogoView.m28912aD(adTemplate);
    }

    /* renamed from: a */
    private void m32347a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(kSFrameLayout, this);
        this.f26324kL.setWidthBasedRatio(!z);
    }

    /* renamed from: b */
    public final void m32344b(boolean z, int i) {
        TextView textView = this.f26341lU;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.f26341lU.setText(String.format(this.f26326lF, String.valueOf(i)));
        }
    }

    /* renamed from: c */
    public final void m32342c(boolean z, boolean z2) {
        ImageView imageView = this.f26323eM;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
            this.f26323eM.setClickable(z2);
        }
    }

    /* renamed from: a */
    private void m32350a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = C10751a.m24924a(getContext(), i);
        layoutParams.height = C10751a.m24924a(getContext(), i2);
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m32346b(View view, boolean z) {
        InterfaceC7801e interfaceC7801e;
        InterfaceC7801e interfaceC7801e2;
        InterfaceC7801e interfaceC7801e3 = this.f26342lV;
        if (interfaceC7801e3 != null) {
            interfaceC7801e3.mo32303p(z);
            this.f26342lV.mo32319a(this.f26325kr);
        }
        if (view.equals(this)) {
            InterfaceC7801e interfaceC7801e4 = this.f26342lV;
            if (interfaceC7801e4 != null) {
                interfaceC7801e4.mo32317dg();
            }
        } else if (view.equals(this.f26333lM)) {
            if (!(1 == this.f26343lW.m32324ej()) || (interfaceC7801e2 = this.f26342lV) == null) {
                return;
            }
            interfaceC7801e2.mo32318df();
        } else if (view.equals(this.f26340lT)) {
            InterfaceC7801e interfaceC7801e5 = this.f26342lV;
            if (interfaceC7801e5 != null) {
                interfaceC7801e5.mo32316dh();
            }
        } else if (view.equals(this.f26331lK)) {
            InterfaceC7801e interfaceC7801e6 = this.f26342lV;
            if (interfaceC7801e6 != null) {
                interfaceC7801e6.mo32305ds();
            }
        } else if (view.equals(this.f26329lI)) {
            InterfaceC7801e interfaceC7801e7 = this.f26342lV;
            if (interfaceC7801e7 != null) {
                interfaceC7801e7.mo32315di();
            }
        } else if (view.equals(this.f26334lN)) {
            InterfaceC7801e interfaceC7801e8 = this.f26342lV;
            if (interfaceC7801e8 != null) {
                interfaceC7801e8.mo32312dl();
            }
        } else if (view.equals(this.f26324kL)) {
            InterfaceC7801e interfaceC7801e9 = this.f26342lV;
            if (interfaceC7801e9 != null) {
                interfaceC7801e9.mo32314dj();
            }
        } else if (view.equals(this.f26323eM)) {
            InterfaceC7801e interfaceC7801e10 = this.f26342lV;
            if (interfaceC7801e10 != null) {
                interfaceC7801e10.mo32313dk();
            }
        } else if (view.equals(this.f26321dE)) {
            InterfaceC7801e interfaceC7801e11 = this.f26342lV;
            if (interfaceC7801e11 != null) {
                interfaceC7801e11.mo32311dm();
            }
        } else if (view.equals(this.f26337lQ)) {
            InterfaceC7801e interfaceC7801e12 = this.f26342lV;
            if (interfaceC7801e12 != null) {
                interfaceC7801e12.mo32310dn();
            }
        } else if (view.equals(this.f26322eF)) {
            InterfaceC7801e interfaceC7801e13 = this.f26342lV;
            if (interfaceC7801e13 != null) {
                interfaceC7801e13.mo32309do();
            }
        } else if (view.equals(this.f26336lP)) {
            InterfaceC7801e interfaceC7801e14 = this.f26342lV;
            if (interfaceC7801e14 != null) {
                interfaceC7801e14.mo32308dp();
            }
        } else if (view.equals(this.f26338lR)) {
            InterfaceC7801e interfaceC7801e15 = this.f26342lV;
            if (interfaceC7801e15 != null) {
                interfaceC7801e15.mo32307dq();
            }
        } else if (!view.equals(this.f26339lS) || (interfaceC7801e = this.f26342lV) == null) {
        } else {
            interfaceC7801e.mo32306dr();
        }
    }

    /* renamed from: a */
    public final void m32348a(AdTemplate adTemplate, AdInfo adInfo) {
        ImageView imageView = this.f26336lP;
        int i = C9659R.C9661drawable.ksad_default_app_icon;
        imageView.setImageResource(i);
        if (C10483a.m25827ca(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.f26336lP, C10483a.m25845cI(adInfo), getContext().getResources().getDrawable(i));
            this.f26338lR.setText(C10483a.m25821ce(adInfo));
            this.f26339lS.setText(C10483a.m25915au(adInfo));
            if (C10483a.m25849cE(adInfo)) {
                this.f26340lT.m29709e(C7355b.m33444X(), 0);
            } else {
                this.f26340lT.m29709e(C7355b.m33441aa(), 0);
            }
        } else if (C7721b.m32568cL() && C10483a.m25827ca(adInfo) == 3) {
            AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
            KSImageLoader.loadWithRadius(this.f26336lP, m25838cP.icon, adTemplate, 4);
            this.f26338lR.setText(m25838cP.name);
            this.f26339lS.setVisibility(8);
            this.f26340lT.m29709e(C7355b.m33443Y(), 0);
        } else if (C10483a.m25956aF(adInfo)) {
            KSImageLoader.loadWithRadius(this.f26336lP, C10483a.m25820cf(adInfo), adTemplate, 4);
            this.f26338lR.setText(C10483a.m25914av(adInfo));
            this.f26339lS.setText(C10483a.m25915au(adInfo));
            this.f26340lT.m29709e(C10483a.m25957aE(adInfo), 0);
        } else {
            KSImageLoader.loadWithRadius(this.f26336lP, C10487e.m25636dV(adTemplate), adTemplate, 4);
            this.f26338lR.setText(C10483a.m25823cc(adInfo));
            this.f26339lS.setText(C10483a.m25915au(adInfo));
            this.f26340lT.m29709e(C10483a.m25957aE(adInfo), 0);
        }
    }

    /* renamed from: a */
    public final void m32351a(float f, TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        this.f26324kL.setRatio(f);
        this.f26324kL.addView(textureView$SurfaceTextureListenerC10537a);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textureView$SurfaceTextureListenerC10537a.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        textureView$SurfaceTextureListenerC10537a.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m32346b(view, true);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m32346b(view, false);
        }
    }
}
