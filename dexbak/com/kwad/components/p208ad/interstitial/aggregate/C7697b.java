package com.kwad.components.p208ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.aggregate.C7693a;
import com.kwad.components.p208ad.interstitial.aggregate.C7709c;
import com.kwad.components.p208ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p240c.C7723a;
import com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a;
import com.kwad.components.p208ad.interstitial.p245g.C7796c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p403h.C10386d;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7697b extends AbstractC7794a {

    /* renamed from: bQ */
    private C9366b f26066bQ;

    /* renamed from: df */
    private final InterfaceC10385c f26067df;

    /* renamed from: iA */
    private ValueAnimator f26068iA;

    /* renamed from: iB */
    private boolean f26069iB;

    /* renamed from: iC */
    private InterstitialAggregateManualTipsView f26070iC;

    /* renamed from: iD */
    private boolean f26071iD;

    /* renamed from: iE */
    private boolean f26072iE;

    /* renamed from: iF */
    private final ViewPager.OnPageChangeListener f26073iF;

    /* renamed from: ie */
    protected KsInterstitialAd.AdInteractionListener f26074ie;

    /* renamed from: im */
    private final List<AdResultData> f26075im;

    /* renamed from: iq */
    private boolean f26076iq;

    /* renamed from: iv */
    private TransViewPager f26077iv;

    /* renamed from: iw */
    private C7693a f26078iw;

    /* renamed from: ix */
    private ViewPagerIndicator f26079ix;

    /* renamed from: iy */
    private SlideTipsView f26080iy;

    /* renamed from: iz */
    private SlideTipsView f26081iz;
    protected AdInfo mAdInfo;
    @NonNull
    protected AdResultData mAdResultData;
    @NonNull
    protected AdTemplate mAdTemplate;
    private final View mRootView;

    public C7697b(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    static /* synthetic */ AnimationSet m32620a(C7697b c7697b, float f, float f2) {
        return m32618b(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cq */
    public void m32614cq() {
        if (this.mAdTemplate.mAdScene != null) {
            C7709c.m32583cx().m32588a(16, C7721b.m32570cJ(), this.mAdTemplate.mAdScene, new C7709c.InterfaceC7716b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                @Override // com.kwad.components.p208ad.interstitial.aggregate.C7709c.InterfaceC7716b
                public final void onInterstitialAdLoad(@Nullable List<AdResultData> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    C7697b.this.f26075im.addAll(list);
                    C7697b.this.f26078iw.m32622d(C7697b.this.f26075im);
                    C7697b.this.f26078iw.notifyDataSetChanged();
                    C7697b.this.f26077iv.setOffscreenPageLimit(C7697b.this.f26075im.size() - 1);
                    C7697b.this.f26077iv.addOnPageChangeListener(C7697b.this.f26073iF);
                    C7697b.this.m32613ct();
                    C7697b.this.f26079ix.setViewPager(C7697b.this.f26077iv);
                    C7697b.this.f26079ix.setVisibility(0);
                    C7697b.this.f26066bQ.mo26187a(C7697b.this.f26067df);
                    C7723a.m32566H(C7697b.this.mContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ct */
    public void m32613ct() {
        this.f26079ix.setPlayProgressListener(new ViewPagerIndicator.InterfaceC7692a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // com.kwad.components.p208ad.interstitial.aggregate.ViewPagerIndicator.InterfaceC7692a
            /* renamed from: cw */
            public final void mo32589cw() {
                C7697b.m32619a(C7697b.this, true);
                if (C7697b.this.f26076iq) {
                    C7697b.this.m32611cv();
                } else {
                    C7697b.this.m32612cu();
                }
                C7697b.this.f26077iv.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cu */
    public void m32612cu() {
        if (this.f26071iD) {
            this.f26070iC.m32646a(this.mAdTemplate, this.f26077iv);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.f26068iA = ofInt;
        ofInt.setDuration(1200L);
        this.f26068iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                C7697b.this.f26077iv.scrollTo(C10751a.m24924a(C7697b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                C7697b.this.f26077iv.onPageScrolled(0, C10751a.m24924a(C7697b.this.mContext, f) / C7697b.this.getWidth(), 0);
            }
        });
        this.f26068iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (C7697b.this.f26071iD) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    C7697b.this.f26070iC.startAnimation(alphaAnimation);
                    C7697b.this.f26070iC.setVisibility(0);
                }
                C7697b.this.f26080iy.setVisibility(0);
                C7697b.this.f26080iy.startAnimation(C7697b.m32620a(C7697b.this, 0.5f, 0.1f));
            }
        });
        this.f26068iA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cv */
    public void m32611cv() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.f26068iA = ofInt;
        ofInt.setDuration(800L);
        this.f26068iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C7697b.this.f26077iv.scrollTo(intValue, 0);
                C7697b.this.f26077iv.onPageScrolled(0, intValue / C7697b.this.getWidth(), 0);
            }
        });
        this.f26068iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C7697b.this.f26077iv.setCurrentItem(1);
                C7697b.this.f26081iz.setVisibility(0);
                C7697b.this.f26081iz.startAnimation(C7697b.m32620a(C7697b.this, -0.5f, -0.1f));
            }
        });
        this.f26068iA.start();
    }

    private void initView() {
        this.f26077iv = (TransViewPager) this.mRootView.findViewById(C9659R.C9662id.ksad_multi_ad_container);
        this.f26079ix = (ViewPagerIndicator) this.mRootView.findViewById(C9659R.C9662id.ksad_multi_ad_indicator);
        this.f26080iy = (SlideTipsView) this.mRootView.findViewById(C9659R.C9662id.ksad_left_slide);
        this.f26081iz = (SlideTipsView) this.mRootView.findViewById(C9659R.C9662id.ksad_right_slide);
        this.f26070iC = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(C9659R.C9662id.ksad_manual_tips_view);
        this.f26066bQ = new C9366b(this.mRootView, 100);
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: cr */
    public final void mo32359cr() {
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: cs */
    public final void mo32358cs() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f26066bQ.mo26186b(this.f26067df);
        this.f26066bQ.m28899tx();
        this.f26075im.clear();
        this.f26077iv.clearOnPageChangeListeners();
        C7709c.m32583cx().release();
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f26074ie = adInteractionListener;
    }

    private C7697b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.f26075im = new ArrayList();
        this.f26067df = new C10386d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aM */
            public final void mo26182aM() {
                super.mo26182aM();
                if (Build.VERSION.SDK_INT >= 19 && C7697b.this.f26069iB) {
                    if (C7697b.this.f26079ix != null) {
                        C7697b.this.f26079ix.m32627cD();
                    }
                    if (C7697b.this.f26068iA != null) {
                        C7697b.this.f26068iA.resume();
                    }
                    C7697b.this.f26069iB = false;
                }
            }

            @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aN */
            public final void mo26181aN() {
                super.mo26181aN();
                if (Build.VERSION.SDK_INT >= 19 && !C7697b.this.f26069iB) {
                    if (C7697b.this.f26079ix != null) {
                        C7697b.this.f26079ix.m32628cC();
                    }
                    if (C7697b.this.f26068iA != null) {
                        C7697b.this.f26068iA.pause();
                    }
                    C7697b.this.f26069iB = true;
                }
            }
        };
        this.f26073iF = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3

            /* renamed from: iH */
            private int f26087iH = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                if (f != 0.0f) {
                    if (C7697b.this.f26080iy.getVisibility() == 0) {
                        C7697b.this.f26080iy.clearAnimation();
                        C7697b.this.f26080iy.setVisibility(8);
                    }
                    if (C7697b.this.f26081iz.getVisibility() == 0) {
                        C7697b.this.f26081iz.clearAnimation();
                        C7697b.this.f26081iz.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                C7796c m32639y = C7697b.this.f26077iv.m32639y(i);
                if (m32639y != null) {
                    m32639y.m32355dZ();
                }
                if (this.f26087iH != i) {
                    C9908c.m27346a(C10485c.m25661n((AdResultData) C7697b.this.f26075im.get(this.f26087iH)), -1L, (JSONObject) null);
                    C7796c m32639y2 = C7697b.this.f26077iv.m32639y(this.f26087iH);
                    if (m32639y2 != null) {
                        m32639y2.m32354ea();
                    }
                }
                this.f26087iH = i;
            }
        };
        this.mContext = context;
        this.mRootView = C10887l.inflate(context, C9659R.C9663layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32619a(C7697b c7697b, boolean z) {
        c7697b.f26072iE = true;
        return true;
    }

    /* renamed from: b */
    private static AnimationSet m32618b(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f, 1, f2, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: a */
    public final void mo32360a(@NonNull AdResultData adResultData, AlertDialogC7725d alertDialogC7725d, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f;
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        AdInfo m25641dQ = C10487e.m25641dQ(m25661n);
        this.mAdInfo = m25641dQ;
        this.f26076iq = C10483a.m25807cs(m25641dQ) == 1;
        this.f26075im.clear();
        this.f26075im.add(this.mAdResultData);
        this.f26074ie = adInteractionListener;
        C7693a c7693a = new C7693a(this.mAdResultData, alertDialogC7725d, ksAdVideoPlayConfig, adInteractionListener);
        this.f26078iw = c7693a;
        c7693a.m32625a(new C7693a.InterfaceC7696b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.p208ad.interstitial.aggregate.C7693a.InterfaceC7696b
            /* renamed from: a */
            public final void mo32591a(C7796c c7796c, int i) {
                C7697b.this.f26077iv.m32641a(i, c7796c);
            }
        });
        this.f26078iw.m32626a(new C7693a.InterfaceC7695a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.p208ad.interstitial.aggregate.C7693a.InterfaceC7695a
            /* renamed from: cp */
            public final void mo32590cp() {
                if (C7697b.this.f26072iE) {
                    return;
                }
                if (C7697b.this.f26068iA != null) {
                    C7697b.this.f26068iA.cancel();
                }
                C7697b.this.f26079ix.setPlayProgressListener(null);
                C7697b.this.f26079ix.setVisibility(8);
                C7697b.this.f26077iv.setScrollable(false);
            }
        });
        this.f26077iv.setAdapter(this.f26078iw);
        this.f26078iw.m32622d(this.f26075im);
        this.f26078iw.notifyDataSetChanged();
        this.f26066bQ.m28900tw();
        ViewPagerIndicator viewPagerIndicator = this.f26079ix;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean m24123LZ = C11015ai.m24123LZ();
            this.f26071iD = m24123LZ;
            Context context = this.mContext;
            if (m24123LZ) {
                f = this.f26076iq ? 12 : 4;
            } else {
                f = 6.0f;
            }
            marginLayoutParams.bottomMargin = C10751a.m24924a(context, f);
            this.f26079ix.setLayoutParams(marginLayoutParams);
        }
        this.f26079ix.setFirstAdShowTime(C10483a.m25806ct(this.mAdInfo));
        post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C7697b.this.m32614cq();
            }
        });
    }
}
