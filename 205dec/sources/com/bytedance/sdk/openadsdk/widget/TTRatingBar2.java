package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTRatingBar2 extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f36380c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f36381f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f36382k;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f36383p;

    /* renamed from: r  reason: collision with root package name */
    private int f36384r;
    private int sr;
    private double ux;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f36385w;
    private int xv;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36380c = new LinearLayout(getContext());
        this.f36385w = new LinearLayout(getContext());
        this.f36380c.setOrientation(0);
        this.f36380c.setGravity(8388611);
        this.f36385w.setOrientation(0);
        this.f36385w.setGravity(8388611);
        this.f36383p = i.xv(context, "tt_ratingbar_empty_star2");
        this.f36382k = i.xv(context, "tt_ratingbar_full_star2");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.xv, this.sr);
        layoutParams.leftMargin = this.f36381f;
        layoutParams.topMargin = this.f36384r;
        layoutParams.rightMargin = this.ev;
        layoutParams.bottomMargin = this.gd;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void c(int i4, int i5) {
        this.xv = i5;
        this.sr = i4;
    }

    public Drawable getEmptyStarDrawable() {
        return this.f36383p;
    }

    public Drawable getFillStarDrawable() {
        return this.f36382k;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        this.f36380c.measure(i4, i5);
        double floor = Math.floor(this.ux);
        int i6 = this.f36381f;
        int i7 = this.xv;
        double d4 = this.ev + i6 + i7;
        Double.isNaN(d4);
        double d5 = i6;
        Double.isNaN(d5);
        double d6 = (d4 * floor) + d5;
        double d7 = this.ux - floor;
        double d8 = i7;
        Double.isNaN(d8);
        this.f36385w.measure(View.MeasureSpec.makeMeasureSpec((int) (d6 + (d7 * d8)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f36380c.getMeasuredHeight(), 1073741824));
    }

    public void setRating(double d4) {
        this.ux = d4;
    }

    public void c() {
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.f36385w.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.f36380c.addView(starImageView2);
        }
        addView(this.f36380c);
        addView(this.f36385w);
        requestLayout();
    }

    public void c(int i4, int i5, int i6, int i7) {
        this.f36381f = i4;
        this.f36384r = i5;
        this.ev = i6;
        this.gd = i7;
    }
}
