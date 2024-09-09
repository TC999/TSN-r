package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTRatingBar2 extends FrameLayout {
    private static final int gd = (k.w("", 0.0f, true)[1] / 2) + 1;

    /* renamed from: p  reason: collision with root package name */
    private static final int f29632p = (k.w("", 0.0f, true)[1] / 2) + 3;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f29633c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f29634f;

    /* renamed from: r  reason: collision with root package name */
    private double f29635r;
    private float sr;
    private Drawable ux;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f29636w;
    private float xv;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29633c = new LinearLayout(getContext());
        this.f29636w = new LinearLayout(getContext());
        this.f29633c.setOrientation(0);
        this.f29633c.setGravity(8388611);
        this.f29636w.setOrientation(0);
        this.f29636w.setGravity(8388611);
        this.ux = i.xv(context, "tt_star_thick");
        this.f29634f = i.xv(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.xv, (int) this.sr));
        imageView.setPadding(1, gd, 1, f29632p);
        return imageView;
    }

    public void c(double d4, int i4, int i5, int i6) {
        float f4 = i5;
        this.xv = (int) f.xv(getContext(), f4);
        this.sr = (int) f.xv(getContext(), f4);
        this.f29635r = d4;
        this.ev = i6;
        removeAllViews();
        for (int i7 = 0; i7 < 5; i7++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.f29636w.addView(starImageView);
        }
        for (int i8 = 0; i8 < 5; i8++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f29633c.addView(starImageView2);
        }
        addView(this.f29633c);
        addView(this.f29636w);
        requestLayout();
    }

    public Drawable getStarEmptyDrawable() {
        return this.ux;
    }

    public Drawable getStarFillDrawable() {
        return this.f29634f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        LinearLayout linearLayout;
        super.onMeasure(i4, i5);
        this.f29633c.measure(i4, i5);
        double d4 = this.f29635r;
        float f4 = this.xv;
        double d5 = (((int) d4) * f4) + 1.0f;
        double d6 = f4 - 2.0f;
        double d7 = (int) d4;
        Double.isNaN(d7);
        Double.isNaN(d6);
        Double.isNaN(d5);
        this.f29636w.measure(View.MeasureSpec.makeMeasureSpec((int) (d5 + (d6 * (d4 - d7))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f29633c.getMeasuredHeight(), 1073741824));
        if (this.ev > 0.0f) {
            this.f29633c.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.ev)) / 2, 0, 0);
            this.f29636w.setPadding(0, ((int) (this.f29633c.getMeasuredHeight() - this.ev)) / 2, 0, 0);
        }
    }
}
