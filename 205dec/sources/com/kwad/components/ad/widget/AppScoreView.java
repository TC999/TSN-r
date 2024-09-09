package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AppScoreView extends LinearLayout {
    private ImageView HS;
    private ImageView HT;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
        this.HS = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.HT = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f4) {
        double d4 = f4;
        if (d4 > 4.5d) {
            ImageView imageView = this.HS;
            int i4 = R.drawable.ksad_star_checked;
            imageView.setImageResource(i4);
            this.HT.setImageResource(i4);
        } else if (d4 > 4.0d) {
            this.HS.setImageResource(R.drawable.ksad_star_checked);
            this.HT.setImageResource(R.drawable.ksad_star_half);
        } else if (d4 > 3.5d) {
            this.HS.setImageResource(R.drawable.ksad_star_checked);
            this.HT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d4 > 3.0d) {
            this.HS.setImageResource(R.drawable.ksad_star_half);
            this.HT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d4 == 3.0d) {
            ImageView imageView2 = this.HS;
            int i5 = R.drawable.ksad_star_unchecked;
            imageView2.setImageResource(i5);
            this.HT.setImageResource(i5);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        initView();
    }
}
