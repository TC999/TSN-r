package com.kwad.components.p208ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TailFrameBarH5View extends LinearLayout {

    /* renamed from: dL */
    protected TextView f27568dL;

    /* renamed from: dM */
    protected TextView f27569dM;

    /* renamed from: jo */
    protected ValueAnimator f27570jo;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    /* renamed from: f */
    private void m30938f(Context context, int i) {
        C10887l.inflate(context, i, this);
        this.f27568dL = (TextView) findViewById(C9659R.C9662id.ksad_tf_h5_ad_desc);
        this.f27569dM = (TextView) findViewById(C9659R.C9662id.ksad_tf_h5_open_btn);
    }

    /* renamed from: kl */
    private void m30936kl() {
        if (this.f27570jo != null) {
            m30935km();
            this.f27570jo.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f27570jo = ofFloat;
        ofFloat.setDuration(1200L);
        this.f27570jo.setRepeatCount(-1);
        this.f27570jo.setRepeatMode(1);
        this.f27570jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.f27569dM.setScaleY(floatValue);
                TailFrameBarH5View.this.f27569dM.setScaleX(floatValue);
            }
        });
        this.f27570jo.start();
    }

    /* renamed from: b */
    public final void m30939b(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.f27568dL.setText(C10483a.m25915au(m25641dQ));
        this.f27569dM.setText(C10483a.m25957aE(m25641dQ));
        m30936kl();
    }

    /* renamed from: g */
    public final void m30937g(boolean z, boolean z2) {
        int i;
        if (!z) {
            i = C9659R.C9663layout.ksad_video_tf_bar_h5_landscape;
        } else if (z2) {
            i = C9659R.C9663layout.ksad_video_tf_bar_h5_portrait_vertical;
        } else {
            i = C9659R.C9663layout.ksad_video_tf_bar_h5_portrait_horizontal;
        }
        m30938f(getContext(), i);
    }

    public TextView getH5OpenBtn() {
        return this.f27569dM;
    }

    /* renamed from: km */
    public final void m30935km() {
        ValueAnimator valueAnimator = this.f27570jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f27570jo.cancel();
        this.f27570jo.end();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
