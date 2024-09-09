package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SlideClickView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15263a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f15264b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f15265c;

    /* renamed from: d  reason: collision with root package name */
    private String f15266d;

    /* renamed from: e  reason: collision with root package name */
    private int f15267e;

    /* renamed from: f  reason: collision with root package name */
    private int f15268f;

    /* renamed from: g  reason: collision with root package name */
    private int f15269g;

    /* renamed from: h  reason: collision with root package name */
    private AnimationDrawable f15270h;

    public SlideClickView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15263a = false;
        this.f15268f = 45;
        this.f15269g = 45;
        init(context);
    }

    private void a() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.f15270h = animationDrawable;
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.slide_down_one), 600);
        this.f15270h.addFrame(getResources().getDrawable(R.drawable.slide_down_two), 600);
        this.f15270h.addFrame(getResources().getDrawable(R.drawable.slide_down_three), 600);
        this.f15270h.setOneShot(false);
        ImageView imageView = this.f15264b;
        if (imageView != null) {
            imageView.setImageDrawable(this.f15270h);
        }
    }

    public void init(Context context) {
        if (this.f15263a) {
            return;
        }
        this.f15263a = true;
        TextView textView = new TextView(context);
        this.f15265c = textView;
        textView.setGravity(17);
        this.f15264b = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(17);
        addView(this.f15265c, layoutParams);
        addView(this.f15264b, layoutParams2);
        a();
    }

    public void setImageWidthAndHeight(int i4, int i5) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i5);
        ImageView imageView = this.f15264b;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void setTitleFont(int i4) {
        TextView textView;
        this.f15267e = i4;
        if (i4 == 0 || (textView = this.f15265c) == null) {
            return;
        }
        textView.setTextSize(2, i4);
    }

    public void setTitleText(String str) {
        TextView textView;
        this.f15266d = str;
        if (TextUtils.isEmpty(str) || (textView = this.f15265c) == null) {
            return;
        }
        textView.setText(str);
        this.f15265c.setTypeface(Typeface.DEFAULT, 1);
        this.f15265c.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.f15265c.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
    }

    public void startAnim() {
        AnimationDrawable animationDrawable = this.f15270h;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnim() {
        AnimationDrawable animationDrawable = this.f15270h;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public SlideClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15263a = false;
        this.f15268f = 45;
        this.f15269g = 45;
        init(context);
    }

    public SlideClickView(Context context) {
        super(context);
        this.f15263a = false;
        this.f15268f = 45;
        this.f15269g = 45;
        init(context);
    }
}
