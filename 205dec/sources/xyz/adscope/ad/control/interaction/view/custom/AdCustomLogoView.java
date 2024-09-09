package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCustomLogoView extends RelativeLayout {
    private AdCustomImageView imageView;
    private TextView textView;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Ids {
        public static final int ASNP_LOGGO_TITLE = 12932;
        public static final int ASNP_LOGGO_VIEW = 12933;
    }

    public AdCustomLogoView(Context context) {
        super(context);
        this.imageView = null;
        this.textView = null;
        init(context);
    }

    private void init(Context context) {
        AdCustomImageView adCustomImageView = new AdCustomImageView(context);
        this.imageView = adCustomImageView;
        adCustomImageView.setId(Ids.ASNP_LOGGO_VIEW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15, -1);
        this.imageView.setLayoutParams(layoutParams);
        this.imageView.setPadding(0, 0, 3, 0);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setId(Ids.ASNP_LOGGO_TITLE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(17, Ids.ASNP_LOGGO_VIEW);
        this.textView.setLayoutParams(layoutParams2);
        this.textView.setPadding(0, 0, 0, 0);
        addView(this.imageView);
        addView(this.textView);
    }

    public void setImageDrawable(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }

    public void setLogoTitle(String str) {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setOuterPadding(int i4) {
        int i5 = (int) (i4 * getContext().getResources().getDisplayMetrics().density);
        setPadding(i5, i5, i5, i5);
    }

    public void setTextColor(int i4) {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setTextColor(i4);
        }
    }

    public void setTextSize(float f4) {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setTextSize(f4);
        }
    }

    public AdCustomLogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imageView = null;
        this.textView = null;
        init(context);
    }

    public AdCustomLogoView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.imageView = null;
        this.textView = null;
        init(context);
    }
}
