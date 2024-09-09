package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f15245a;

    /* renamed from: b  reason: collision with root package name */
    TextView f15246b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15247c;

    /* renamed from: d  reason: collision with root package name */
    private String f15248d;

    /* renamed from: e  reason: collision with root package name */
    private AnimationDrawable f15249e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15250f;

    public ShakeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15247c = false;
        init(context);
    }

    private void a() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f15245a = imageView;
        imageView.setBackgroundResource(R.drawable.anim_shake_download);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f15245a, layoutParams);
        this.f15249e = (AnimationDrawable) this.f15245a.getBackground();
    }

    public void init(Context context) {
        if (this.f15247c) {
            return;
        }
        this.f15247c = true;
        ImageView imageView = new ImageView(context);
        this.f15245a = imageView;
        imageView.setBackgroundResource(R.drawable.anim_shake);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f15245a, layoutParams);
        this.f15249e = (AnimationDrawable) this.f15245a.getBackground();
    }

    public void setDownloadApp(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        this.f15250f = booleanValue;
        if (booleanValue) {
            a();
        }
    }

    public void setTitleText(String str) {
        this.f15248d = str;
        TextView textView = this.f15246b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void startShake() {
        AnimationDrawable animationDrawable = this.f15249e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopShake() {
        AnimationDrawable animationDrawable = this.f15249e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void updateTwistRollAnim() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f15245a = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_twist_roll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f15245a, layoutParams);
        this.f15249e = (AnimationDrawable) this.f15245a.getBackground();
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15247c = false;
        init(context);
    }

    public ShakeView(Context context) {
        super(context);
        this.f15247c = false;
        init(context);
    }
}
