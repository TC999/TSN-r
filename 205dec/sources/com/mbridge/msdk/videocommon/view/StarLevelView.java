package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.r;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StarLevelView extends LinearLayout {
    public StarLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public void initScore(double d4) {
        for (int i4 = 0; i4 < ((int) d4); i4++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(r.a(getContext(), "mbridge_video_common_full_star", "drawable"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i4 != 0) {
                layoutParams.setMargins(5, 0, 5, 0);
            }
            addView(imageView, layoutParams);
        }
        int i5 = (int) (50.0d - (d4 * 10.0d));
        if (i5 <= 0) {
            return;
        }
        if (i5 > 1 && i5 < 10) {
            if (i5 > 0 && i5 < 5) {
                ImageView imageView2 = new ImageView(getContext());
                imageView2.setImageResource(r.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(5, 0, 5, 0);
                addView(imageView2, layoutParams2);
            } else {
                ImageView imageView3 = new ImageView(getContext());
                imageView3.setImageResource(r.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(5, 0, 5, 0);
                addView(imageView3, layoutParams3);
            }
        }
        int i6 = i5 / 10;
        if (i6 >= 1) {
            int i7 = i5 % (i6 * 10);
            if (i7 > 0 && i7 < 5) {
                ImageView imageView4 = new ImageView(getContext());
                imageView4.setImageResource(r.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(5, 0, 5, 0);
                addView(imageView4, layoutParams4);
            } else if (i7 >= 5 && i7 <= 9) {
                ImageView imageView5 = new ImageView(getContext());
                imageView5.setImageResource(r.a(getContext(), "mbridge_video_common_half_star", "drawable"));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.setMargins(5, 0, 5, 0);
                addView(imageView5, layoutParams5);
            }
            for (int i8 = 0; i8 < i6; i8++) {
                ImageView imageView6 = new ImageView(getContext());
                imageView6.setImageResource(r.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams6.setMargins(5, 0, 5, 0);
                addView(imageView6, layoutParams6);
            }
        }
    }

    public StarLevelView(Context context) {
        super(context);
        setOrientation(0);
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        setOrientation(0);
    }
}
