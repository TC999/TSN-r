package com.kwad.sdk.p364a.p365a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.p372a.C9813a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11059bi;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC9693e implements View.OnClickListener {
    private final boolean alK;
    private final boolean alL;
    private View alM;
    private ImageView alN;
    private TextView alO;
    private Button alP;
    private int alQ;
    private int alR;
    private boolean alS;
    private final AdInfo mAdInfo;
    @NonNull
    private final AdTemplate mAdTemplate;
    @NonNull
    private final Context mContext;
    @NonNull
    private View mRootView = m28022zU();

    public View$OnClickListenerC9693e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.alK = z;
        this.alL = z2;
        this.alS = z3;
        m28023lR();
    }

    /* renamed from: B */
    private Animator m28029B(View view) {
        ObjectAnimator ofFloat;
        if (this.alK && this.alL) {
            ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f, this.alR);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f, -this.alQ);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    /* renamed from: c */
    private void m28025c(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C9659R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C9659R.dimen.ksad_install_tips_card_margin);
        this.alQ = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.alQ);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    /* renamed from: d */
    private void m28024d(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = C11059bi.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C9659R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C9659R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(C9659R.dimen.ksad_install_tips_bottom_height);
        this.alR = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.alR);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    /* renamed from: lR */
    private void m28023lR() {
        this.alP.setText(this.alK ? "安装" : "打开");
        this.alM.setOnClickListener(this);
        this.alP.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.alN, C10483a.m25820cf(C10487e.m25641dQ(this.mAdTemplate)), this.mAdTemplate, 8);
        String m25914av = C10483a.m25914av(C10487e.m25641dQ(this.mAdTemplate));
        if (m25914av.length() >= 8) {
            m25914av = m25914av.substring(0, 7) + "...";
        }
        this.alO.setText(this.mContext.getString(this.alK ? C9659R.C9664string.ksad_install_tips : C9659R.C9664string.ksad_launch_tips, m25914av));
    }

    private void show() {
        ObjectAnimator ofFloat;
        if (this.alK && this.alL) {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_X, this.alR, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_Y, -this.alQ, 0.0f);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    @SuppressLint({"InflateParams"})
    /* renamed from: zU */
    private View m28022zU() {
        if (this.alK && this.alL) {
            this.mRootView = C10887l.inflate(this.mContext, C9659R.C9663layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = C10887l.inflate(this.mContext, C9659R.C9663layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(C9659R.dimen.ksad_install_tips_card_elevation));
        this.alM = this.mRootView.findViewById(C9659R.C9662id.ksad_install_tips_close);
        this.alN = (ImageView) this.mRootView.findViewById(C9659R.C9662id.ksad_install_tips_icon);
        this.alO = (TextView) this.mRootView.findViewById(C9659R.C9662id.ksad_install_tips_content);
        this.alP = (Button) this.mRootView.findViewById(C9659R.C9662id.ksad_install_tips_install);
        return this.mRootView;
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator m28029B = m28029B(this.mRootView);
        m28029B.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(View$OnClickListenerC9693e.this.mRootView);
            }
        });
        m28029B.start();
        C9679c.m28040zM().m28035zR();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == C9659R.C9662id.ksad_install_tips_install) {
            if (this.alK) {
                if (this.alS) {
                    C9913b c9913b = new C9913b();
                    c9913b.m27264cM(29);
                    c9913b.m27257cT(23);
                    C9908c.m27306e(this.mAdTemplate, (JSONObject) null, c9913b);
                } else {
                    C9908c.m27288o(this.mAdTemplate, 45);
                }
                C11017ak.m24115a(C10483a.m25979H(this.mAdInfo), new C11017ak.InterfaceC11018a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
                    /* renamed from: d */
                    public final void mo24107d(Throwable th) {
                        C9813a.m27708i(View$OnClickListenerC9693e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
                    /* renamed from: ol */
                    public final void mo24106ol() {
                        C9908c.m27302h(View$OnClickListenerC9693e.this.mAdTemplate, 1);
                        C9813a.m27712aY(View$OnClickListenerC9693e.this.mAdTemplate);
                    }
                });
                return;
            }
            if (C11017ak.m24112ap(this.mContext, C10483a.m25911ay(this.mAdInfo))) {
                C9908c.m27327bH(this.mAdTemplate);
            }
            C9908c.m27289n(this.mAdTemplate, 47);
        } else if (view.getId() == C9659R.C9662id.ksad_install_tips_close) {
            if (this.alK) {
                if (this.alS) {
                    C9913b c9913b2 = new C9913b();
                    c9913b2.m27264cM(69);
                    c9913b2.m27257cT(23);
                    c9913b2.m27253cX(1);
                    C9908c.m27306e(this.mAdTemplate, (JSONObject) null, c9913b2);
                    return;
                }
                C9908c.m27288o(this.mAdTemplate, 46);
                return;
            }
            C9908c.m27289n(this.mAdTemplate, 48);
        }
    }

    /* renamed from: b */
    public final void m28027b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.alK && this.alL) {
            m28024d(frameLayout);
        } else {
            m28025c(frameLayout);
        }
        this.mRootView.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC9693e.this.dismiss();
            }
        }, 10000L);
    }
}
