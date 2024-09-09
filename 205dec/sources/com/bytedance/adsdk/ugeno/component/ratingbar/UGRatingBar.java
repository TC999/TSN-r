package com.bytedance.adsdk.ugeno.component.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import j0.d;
import l0.b;
import l0.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UGRatingBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f26198a;

    /* renamed from: b  reason: collision with root package name */
    private float f26199b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f26200c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f26201d;

    /* renamed from: e  reason: collision with root package name */
    private double f26202e;

    /* renamed from: f  reason: collision with root package name */
    private float f26203f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f26204g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f26205h;

    /* renamed from: i  reason: collision with root package name */
    private Context f26206i;

    /* renamed from: j  reason: collision with root package name */
    private d f26207j;

    public UGRatingBar(Context context) {
        super(context);
        this.f26206i = context;
        this.f26204g = new LinearLayout(context);
        this.f26205h = new LinearLayout(context);
        this.f26204g.setOrientation(0);
        this.f26204g.setGravity(8388611);
        this.f26205h.setOrientation(0);
        this.f26205h.setGravity(8388611);
        this.f26200c = f.b(context, "tt_star_thick");
        this.f26201d = f.b(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.f26198a, (int) this.f26199b);
        layoutParams.leftMargin = 1;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = 1;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void a(double d4, int i4, int i5, int i6) {
        removeAllViews();
        this.f26204g.removeAllViews();
        this.f26205h.removeAllViews();
        float f4 = i5;
        this.f26198a = (int) b.a(this.f26206i, f4);
        this.f26199b = (int) b.a(this.f26206i, f4);
        this.f26202e = d4;
        this.f26203f = i6;
        for (int i7 = 0; i7 < 5; i7++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.f26205h.addView(starImageView);
        }
        for (int i8 = 0; i8 < 5; i8++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f26204g.addView(starImageView2);
        }
        addView(this.f26204g);
        addView(this.f26205h);
        requestLayout();
    }

    public void b(d dVar) {
        this.f26207j = dVar;
    }

    public Drawable getStarEmptyDrawable() {
        return this.f26200c;
    }

    public Drawable getStarFillDrawable() {
        return this.f26201d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26207j;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26207j;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar = this.f26207j;
        if (dVar != null) {
            dVar.c(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        d dVar = this.f26207j;
        if (dVar != null) {
            dVar.c(i4, i5, i6, i7);
        }
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f26207j;
        if (dVar != null) {
            dVar.c(i4, i5);
        }
        super.onMeasure(i4, i5);
        this.f26204g.measure(i4, i5);
        double floor = Math.floor(this.f26202e);
        float f4 = this.f26198a;
        double d4 = 2.0f + f4;
        Double.isNaN(d4);
        double d5 = this.f26202e - floor;
        double d6 = f4;
        Double.isNaN(d6);
        this.f26205h.measure(View.MeasureSpec.makeMeasureSpec((int) ((d4 * floor) + 1.0d + (d5 * d6)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f26204g.getMeasuredHeight(), 1073741824));
    }
}
