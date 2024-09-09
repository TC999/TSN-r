package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.r;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBStarLevelLayoutView extends MBLinearLayout {
    public MBStarLevelLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int dip2px(Context context, float f4) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f4 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i4) {
        removeAllViews();
        if (i4 == 0) {
            i4 = 5;
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.mbridge.msdk.widget.custom.b.a.a(getContext(), 10), com.mbridge.msdk.widget.custom.b.a.a(getContext(), 10));
            if (i5 < i4) {
                imageView.setImageResource(r.a(getContext(), "mbridge_download_message_dialog_star_sel", "drawable"));
            } else {
                imageView.setImageResource(r.a(getContext(), "mbridge_download_message_dilaog_star_nor", "drawable"));
            }
            layoutParams.leftMargin = dip2px(getContext(), com.mbridge.msdk.widget.custom.b.a.a(getContext(), 1));
            addView(imageView, layoutParams);
        }
    }
}
