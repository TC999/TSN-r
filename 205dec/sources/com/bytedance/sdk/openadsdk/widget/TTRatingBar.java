package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTRatingBar extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private int f36376c;
    private Drawable ev;

    /* renamed from: f  reason: collision with root package name */
    private float f36377f;
    private Drawable gd;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f36378r;
    private float sr;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private int f36379w;
    private int xv;

    public TTRatingBar(Context context) {
        super(context);
        this.f36376c = 5;
        this.f36379w = 0;
        this.xv = 0;
        c(context);
    }

    private void c(Context context) {
        setOrientation(0);
        this.f36378r = i.xv(context, "tt_star_empty_bg");
        this.ev = i.xv(context, "tt_star_full_bg");
        this.gd = i.xv(context, "tt_star_empty_bg");
        this.sr = c(context, 15.0f);
        this.ux = c(context, 15.0f);
        this.f36377f = c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.sr), Math.round(this.ux)));
        imageView.setPadding(0, 0, Math.round(this.f36377f), 0);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.f36378r;
    }

    public int getStarEmptyNum() {
        return this.xv;
    }

    public Drawable getStarFillDrawable() {
        return this.ev;
    }

    public int getStarFillNum() {
        return this.f36376c;
    }

    public Drawable getStarHalfDrawable() {
        return this.gd;
    }

    public int getStarHalfNum() {
        return this.f36379w;
    }

    public float getStarImageHeight() {
        return this.ux;
    }

    public float getStarImagePadding() {
        return this.f36377f;
    }

    public float getStarImageWidth() {
        return this.sr;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f36378r = drawable;
    }

    public void setStarEmptyNum(int i4) {
        this.xv = i4;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.ev = drawable;
    }

    public void setStarFillNum(int i4) {
        this.f36376c = i4;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.gd = drawable;
    }

    public void setStarHalfNum(int i4) {
        this.f36379w = i4;
    }

    public void setStarImageHeight(float f4) {
        this.ux = f4;
    }

    public void setStarImagePadding(float f4) {
        this.f36377f = f4;
    }

    public void setStarImageWidth(float f4) {
        this.sr = f4;
    }

    private int c(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void c() {
        removeAllViews();
        for (int i4 = 0; i4 < getStarFillNum(); i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i5 = 0; i5 < getStarHalfNum(); i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i6 = 0; i6 < getStarEmptyNum(); i6++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }
}
