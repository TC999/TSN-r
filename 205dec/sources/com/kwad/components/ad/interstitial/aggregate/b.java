package com.kwad.components.ad.interstitial.aggregate;

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
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.ad.interstitial.aggregate.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.ad.interstitial.g.a {
    private com.kwad.components.core.widget.a.b bQ;
    private final com.kwad.sdk.core.h.c df;
    private ValueAnimator iA;
    private boolean iB;
    private InterstitialAggregateManualTipsView iC;
    private boolean iD;
    private boolean iE;
    private final ViewPager.OnPageChangeListener iF;
    protected KsInterstitialAd.AdInteractionListener ie;
    private final List<AdResultData> im;
    private boolean iq;
    private TransViewPager iv;
    private a iw;
    private ViewPagerIndicator ix;
    private SlideTipsView iy;
    private SlideTipsView iz;
    protected AdInfo mAdInfo;
    @NonNull
    protected AdResultData mAdResultData;
    @NonNull
    protected AdTemplate mAdTemplate;
    private final View mRootView;

    public b(@NonNull Context context) {
        this(context, null);
    }

    static /* synthetic */ AnimationSet a(b bVar, float f4, float f5) {
        return b(f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq() {
        if (this.mAdTemplate.mAdScene != null) {
            c.cx().a(16, com.kwad.components.ad.interstitial.b.b.cJ(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                @Override // com.kwad.components.ad.interstitial.aggregate.c.b
                public final void onInterstitialAdLoad(@Nullable List<AdResultData> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.this.im.addAll(list);
                    b.this.iw.d(b.this.im);
                    b.this.iw.notifyDataSetChanged();
                    b.this.iv.setOffscreenPageLimit(b.this.im.size() - 1);
                    b.this.iv.addOnPageChangeListener(b.this.iF);
                    b.this.ct();
                    b.this.ix.setViewPager(b.this.iv);
                    b.this.ix.setVisibility(0);
                    b.this.bQ.a(b.this.df);
                    com.kwad.components.ad.interstitial.c.a.H(b.this.mContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct() {
        this.ix.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void cw() {
                b.a(b.this, true);
                if (b.this.iq) {
                    b.this.cv();
                } else {
                    b.this.cu();
                }
                b.this.iv.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu() {
        if (this.iD) {
            this.iC.a(this.mAdTemplate, this.iv);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.iA = ofInt;
        ofInt.setDuration(1200L);
        this.iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f4;
                b.this.iv.scrollTo(com.kwad.sdk.d.a.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                b.this.iv.onPageScrolled(0, com.kwad.sdk.d.a.a.a(b.this.mContext, f4) / b.this.getWidth(), 0);
            }
        });
        this.iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.iD) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    b.this.iC.startAnimation(alphaAnimation);
                    b.this.iC.setVisibility(0);
                }
                b.this.iy.setVisibility(0);
                b.this.iy.startAnimation(b.a(b.this, 0.5f, 0.1f));
            }
        });
        this.iA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.iA = ofInt;
        ofInt.setDuration(800L);
        this.iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.iv.scrollTo(intValue, 0);
                b.this.iv.onPageScrolled(0, intValue / b.this.getWidth(), 0);
            }
        });
        this.iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.this.iv.setCurrentItem(1);
                b.this.iz.setVisibility(0);
                b.this.iz.startAnimation(b.a(b.this, -0.5f, -0.1f));
            }
        });
        this.iA.start();
    }

    private void initView() {
        this.iv = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.ix = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.iy = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_left_slide);
        this.iz = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_right_slide);
        this.iC = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(R.id.ksad_manual_tips_view);
        this.bQ = new com.kwad.components.core.widget.a.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cr() {
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cs() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bQ.b(this.df);
        this.bQ.tx();
        this.im.clear();
        this.iv.clearOnPageChangeListeners();
        c.cx().release();
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
    }

    private b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.im = new ArrayList();
        this.df = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void aM() {
                super.aM();
                if (Build.VERSION.SDK_INT >= 19 && b.this.iB) {
                    if (b.this.ix != null) {
                        b.this.ix.cD();
                    }
                    if (b.this.iA != null) {
                        b.this.iA.resume();
                    }
                    b.this.iB = false;
                }
            }

            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void aN() {
                super.aN();
                if (Build.VERSION.SDK_INT >= 19 && !b.this.iB) {
                    if (b.this.ix != null) {
                        b.this.ix.cC();
                    }
                    if (b.this.iA != null) {
                        b.this.iA.pause();
                    }
                    b.this.iB = true;
                }
            }
        };
        this.iF = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            private int iH = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i4, float f4, int i5) {
                if (f4 != 0.0f) {
                    if (b.this.iy.getVisibility() == 0) {
                        b.this.iy.clearAnimation();
                        b.this.iy.setVisibility(8);
                    }
                    if (b.this.iz.getVisibility() == 0) {
                        b.this.iz.clearAnimation();
                        b.this.iz.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i4) {
                com.kwad.components.ad.interstitial.g.c y3 = b.this.iv.y(i4);
                if (y3 != null) {
                    y3.dZ();
                }
                if (this.iH != i4) {
                    com.kwad.sdk.core.adlog.c.a(com.kwad.sdk.core.response.b.c.n((AdResultData) b.this.im.get(this.iH)), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.g.c y4 = b.this.iv.y(this.iH);
                    if (y4 != null) {
                        y4.ea();
                    }
                }
                this.iH = i4;
            }
        };
        this.mContext = context;
        this.mRootView = l.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    static /* synthetic */ boolean a(b bVar, boolean z3) {
        bVar.iE = true;
        return true;
    }

    private static AnimationSet b(float f4, float f5) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f4, 1, f5, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f4;
        this.mAdResultData = adResultData;
        AdTemplate n4 = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n4;
        AdInfo dQ = e.dQ(n4);
        this.mAdInfo = dQ;
        this.iq = com.kwad.sdk.core.response.b.a.cs(dQ) == 1;
        this.im.clear();
        this.im.add(this.mAdResultData);
        this.ie = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.iw = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.g.c cVar, int i4) {
                b.this.iv.a(i4, cVar);
            }
        });
        this.iw.a(new a.InterfaceC0570a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0570a
            public final void cp() {
                if (b.this.iE) {
                    return;
                }
                if (b.this.iA != null) {
                    b.this.iA.cancel();
                }
                b.this.ix.setPlayProgressListener(null);
                b.this.ix.setVisibility(8);
                b.this.iv.setScrollable(false);
            }
        });
        this.iv.setAdapter(this.iw);
        this.iw.d(this.im);
        this.iw.notifyDataSetChanged();
        this.bQ.tw();
        ViewPagerIndicator viewPagerIndicator = this.ix;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean LZ = ai.LZ();
            this.iD = LZ;
            Context context = this.mContext;
            if (LZ) {
                f4 = this.iq ? 12 : 4;
            } else {
                f4 = 6.0f;
            }
            marginLayoutParams.bottomMargin = com.kwad.sdk.d.a.a.a(context, f4);
            this.ix.setLayoutParams(marginLayoutParams);
        }
        this.ix.setFirstAdShowTime(com.kwad.sdk.core.response.b.a.ct(this.mAdInfo));
        post(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.cq();
            }
        });
    }
}
