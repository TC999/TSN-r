package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.page.p321c.C8799a;
import com.kwad.components.core.page.p321c.C8826b;
import com.kwad.components.core.page.recycle.C8850e;
import com.kwad.components.core.page.splitLandingPage.p324a.C8860a;
import com.kwad.components.core.page.splitLandingPage.view.C8862a;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.proxy.C8888e;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.page.splitLandingPage.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8853a extends C8888e {

    /* renamed from: NZ */
    private FeedVideoView f28666NZ;

    /* renamed from: Oa */
    private LinearLayout f28667Oa;

    /* renamed from: PX */
    private SplitScrollWebView f28668PX;

    /* renamed from: PY */
    private Presenter f28669PY;

    /* renamed from: PZ */
    private C8862a f28670PZ;

    /* renamed from: Qa */
    private C8799a f28671Qa;

    /* renamed from: Qb */
    private boolean f28672Qb;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: at */
    public static C8853a m29735at(AdTemplate adTemplate) {
        C8853a c8853a = new C8853a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        c8853a.setArguments(bundle);
        return c8853a;
    }

    private void initView() {
        C8850e c8850e = new C8850e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.f28669PY.m24605k(c8850e);
        C8862a c8862a = new C8862a(this.mContext, new C8860a(c8850e.adTemplate, c8850e.f28661Kz));
        this.f28670PZ = c8862a;
        c8862a.m29721a(new C8862a.InterfaceC8866a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.C8862a.InterfaceC8866a
            /* renamed from: pX */
            public final boolean mo29710pX() {
                return C8853a.this.m29728pU();
            }
        });
        this.f28666NZ.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8853a.this.f28668PX.setTranslationY(C8853a.this.f28668PX.getTranslationY() + C8853a.this.f28666NZ.getHeight());
            }
        });
        this.f28668PX.setSplitScrollWebViewListener(new SplitScrollWebView.InterfaceC8861a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.InterfaceC8861a
            /* renamed from: d */
            public final void mo29723d(float f) {
                C8853a.this.f28668PX.setTranslationY(C8853a.this.f28668PX.getTranslationY() - f);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.InterfaceC8861a
            /* renamed from: pY */
            public final boolean mo29722pY() {
                if (C8853a.this.f28670PZ.m29712pZ() || C10251d.m26566Bv() != 2) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator m29530a = C8951n.m29530a((View) C8853a.this.f28668PX, (Interpolator) null, C8853a.this.f28668PX.getTranslationY(), 0.0f);
                    if (C10251d.m26566Bv() == 2) {
                        if (!C8853a.this.f28666NZ.isComplete()) {
                            animatorSet.playSequentially(m29530a, C8853a.this.f28670PZ.m29719aH(true));
                        } else {
                            animatorSet.playTogether(m29530a);
                        }
                    } else if (C10251d.m26566Bv() == 1) {
                        animatorSet.playTogether(m29530a);
                    }
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            C8853a.this.f28666NZ.m28944pW();
                            if (C10251d.m26566Bv() != 2 || C8853a.this.f28666NZ.isComplete()) {
                                return;
                            }
                            C8853a.this.f28670PZ.m29711qa();
                        }
                    });
                    animatorSet.start();
                    return true;
                }
                return false;
            }
        });
    }

    /* renamed from: j */
    private void m29729j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.f28669PY = presenter;
        presenter.m24616G(viewGroup);
        C8826b c8826b = new C8826b();
        c8826b.m24616G(this.f28668PX);
        C8799a c8799a = new C8799a();
        this.f28671Qa = c8799a;
        c8799a.m24616G(this.f28666NZ);
        this.f28669PY.m24612a(c8826b);
        this.f28669PY.m24612a(this.f28671Qa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pU */
    public boolean m29728pU() {
        SplitScrollWebView splitScrollWebView = this.f28668PX;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.f28672Qb) {
            return false;
        }
        this.f28668PX.setDisableAnimation(false);
        this.f28672Qb = true;
        SplitScrollWebView splitScrollWebView2 = this.f28668PX;
        Animator m29530a = C8951n.m29530a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.f28666NZ.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (C10251d.m26566Bv() == 2 && this.f28670PZ.isVisible()) {
            this.f28670PZ.m29713pW();
            animatorSet.playSequentially(this.f28670PZ.m29719aH(false), m29530a);
        } else {
            animatorSet.play(m29530a);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C8853a.this.m29727pV();
                C8853a.this.f28666NZ.m28942qa();
                C8853a.m29736a(C8853a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pV */
    public void m29727pV() {
        this.f28671Qa.m24604lW();
        this.f28671Qa.m24616G(this.f28666NZ);
        this.f28671Qa.m24605k(new C8850e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    /* renamed from: w */
    private void m29725w(View view) {
        this.f28667Oa = (LinearLayout) view.findViewById(C9659R.C9662id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(C9659R.C9662id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(C9659R.C9662id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8853a.this.f28667Oa.setVisibility(8);
            }
        });
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        boolean m25857bw = C10483a.m25857bw(m25641dQ);
        String m25861bs = C10483a.m25861bs(m25641dQ);
        if (m25857bw) {
            this.f28667Oa.setVisibility(0);
            textView.setText(m25861bs);
            textView.setSelected(true);
            return;
        }
        this.f28667Oa.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.p443m.p444a.InterfaceC10861b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.f28668PX;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.f28668PX.goBack();
            return true;
        } else if (m29728pU()) {
            return true;
        } else {
            FeedVideoView feedVideoView = this.f28666NZ;
            if (feedVideoView != null) {
                return feedVideoView.m28936tq();
            }
            return false;
        }
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                C10331c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f28666NZ = (FeedVideoView) findViewById(C9659R.C9662id.ksad_split_land_ad_feed_video);
        this.f28668PX = (SplitScrollWebView) findViewById(C9659R.C9662id.ksad_video_webView);
        m29725w(view);
        m29729j(this.f28748lD);
        initView();
    }

    /* renamed from: pW */
    public final void m29726pW() {
        this.f28666NZ.m28944pW();
    }

    @Override // com.kwad.components.core.proxy.C8888e
    /* renamed from: pc */
    public final int mo29671pc() {
        return C9659R.C9663layout.ksad_split_land_page;
    }

    public final void setApkDownloadHelper(C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m29736a(C8853a c8853a, boolean z) {
        c8853a.f28672Qb = false;
        return false;
    }
}
