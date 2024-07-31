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
import com.beizi.fusion.C3025R;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SlideClickView extends LinearLayout {

    /* renamed from: a */
    private boolean f11675a;

    /* renamed from: b */
    private ImageView f11676b;

    /* renamed from: c */
    private TextView f11677c;

    /* renamed from: d */
    private String f11678d;

    /* renamed from: e */
    private int f11679e;

    /* renamed from: f */
    private int f11680f;

    /* renamed from: g */
    private int f11681g;

    /* renamed from: h */
    private AnimationDrawable f11682h;

    public SlideClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11675a = false;
        this.f11680f = 45;
        this.f11681g = 45;
        init(context);
    }

    /* renamed from: a */
    private void m48043a() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.f11682h = animationDrawable;
        animationDrawable.addFrame(getResources().getDrawable(C3025R.C3027drawable.slide_down_one), 600);
        this.f11682h.addFrame(getResources().getDrawable(C3025R.C3027drawable.slide_down_two), 600);
        this.f11682h.addFrame(getResources().getDrawable(C3025R.C3027drawable.slide_down_three), 600);
        this.f11682h.setOneShot(false);
        ImageView imageView = this.f11676b;
        if (imageView != null) {
            imageView.setImageDrawable(this.f11682h);
        }
    }

    public void init(Context context) {
        if (this.f11675a) {
            return;
        }
        this.f11675a = true;
        TextView textView = new TextView(context);
        this.f11677c = textView;
        textView.setGravity(17);
        this.f11676b = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(17);
        addView(this.f11677c, layoutParams);
        addView(this.f11676b, layoutParams2);
        m48043a();
    }

    public void setImageWidthAndHeight(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        ImageView imageView = this.f11676b;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void setTitleFont(int i) {
        TextView textView;
        this.f11679e = i;
        if (i == 0 || (textView = this.f11677c) == null) {
            return;
        }
        textView.setTextSize(2, i);
    }

    public void setTitleText(String str) {
        TextView textView;
        this.f11678d = str;
        if (TextUtils.isEmpty(str) || (textView = this.f11677c) == null) {
            return;
        }
        textView.setText(str);
        this.f11677c.setTypeface(Typeface.DEFAULT, 1);
        this.f11677c.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.f11677c.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
    }

    public void startAnim() {
        AnimationDrawable animationDrawable = this.f11682h;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnim() {
        AnimationDrawable animationDrawable = this.f11682h;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public SlideClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11675a = false;
        this.f11680f = 45;
        this.f11681g = 45;
        init(context);
    }

    public SlideClickView(Context context) {
        super(context);
        this.f11675a = false;
        this.f11680f = 45;
        this.f11681g = 45;
        init(context);
    }
}
