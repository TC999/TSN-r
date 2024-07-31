package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.C3025R;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: a */
    ImageView f11658a;

    /* renamed from: b */
    TextView f11659b;

    /* renamed from: c */
    private boolean f11660c;

    /* renamed from: d */
    private String f11661d;

    /* renamed from: e */
    private AnimationDrawable f11662e;

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11660c = false;
        init(context);
    }

    public void init(Context context) {
        if (this.f11660c) {
            return;
        }
        this.f11660c = true;
        ImageView imageView = new ImageView(context);
        this.f11658a = imageView;
        imageView.setBackgroundResource(C3025R.C3027drawable.anim_shake);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f11658a, layoutParams);
        this.f11662e = (AnimationDrawable) this.f11658a.getBackground();
    }

    public void setTitleText(String str) {
        this.f11661d = str;
        TextView textView = this.f11659b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void startShake() {
        AnimationDrawable animationDrawable = this.f11662e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopShake() {
        AnimationDrawable animationDrawable = this.f11662e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void updateTwistRollAnim() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f11658a = imageView;
        imageView.setBackgroundResource(C3025R.C3027drawable.beizi_twist_roll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f11658a, layoutParams);
        this.f11662e = (AnimationDrawable) this.f11658a.getBackground();
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11660c = false;
        init(context);
    }

    public ShakeView(Context context) {
        super(context);
        this.f11660c = false;
        init(context);
    }
}
