package com.kwad.components.p208ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.widget.AppScoreView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AppScoreView extends LinearLayout {

    /* renamed from: HS */
    private ImageView f28000HS;

    /* renamed from: HT */
    private ImageView f28001HT;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        LinearLayout.inflate(getContext(), C9659R.C9663layout.ksad_app_score, this);
        this.f28000HS = (ImageView) findViewById(C9659R.C9662id.ksad_score_fourth);
        this.f28001HT = (ImageView) findViewById(C9659R.C9662id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            ImageView imageView = this.f28000HS;
            int i = C9659R.C9661drawable.ksad_star_checked;
            imageView.setImageResource(i);
            this.f28001HT.setImageResource(i);
        } else if (d > 4.0d) {
            this.f28000HS.setImageResource(C9659R.C9661drawable.ksad_star_checked);
            this.f28001HT.setImageResource(C9659R.C9661drawable.ksad_star_half);
        } else if (d > 3.5d) {
            this.f28000HS.setImageResource(C9659R.C9661drawable.ksad_star_checked);
            this.f28001HT.setImageResource(C9659R.C9661drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.f28000HS.setImageResource(C9659R.C9661drawable.ksad_star_half);
            this.f28001HT.setImageResource(C9659R.C9661drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            ImageView imageView2 = this.f28000HS;
            int i2 = C9659R.C9661drawable.ksad_star_unchecked;
            imageView2.setImageResource(i2);
            this.f28001HT.setImageResource(i2);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
