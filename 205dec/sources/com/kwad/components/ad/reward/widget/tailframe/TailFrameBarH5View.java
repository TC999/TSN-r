package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView dL;
    protected TextView dM;
    protected ValueAnimator jo;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i4) {
        l.inflate(context, i4, this);
        this.dL = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void kl() {
        if (this.jo != null) {
            km();
            this.jo.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(1200L);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dM.setScaleY(floatValue);
                TailFrameBarH5View.this.dM.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        this.dL.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(dQ));
        kl();
    }

    public final void g(boolean z3, boolean z4) {
        int i4;
        if (!z3) {
            i4 = R.layout.ksad_video_tf_bar_h5_landscape;
        } else if (z4) {
            i4 = R.layout.ksad_video_tf_bar_h5_portrait_vertical;
        } else {
            i4 = R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
        }
        f(getContext(), i4);
    }

    public TextView getH5OpenBtn() {
        return this.dM;
    }

    public final void km() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.jo.cancel();
        this.jo.end();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
