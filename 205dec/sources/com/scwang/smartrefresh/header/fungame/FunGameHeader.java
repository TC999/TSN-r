package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.layout.util.c;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FunGameHeader extends FunGameBase implements e {

    /* renamed from: l  reason: collision with root package name */
    protected float f47710l;

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f47711m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f47712n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f47713o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f47714p;

    /* renamed from: q  reason: collision with root package name */
    private int f47715q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f47716r;

    /* renamed from: s  reason: collision with root package name */
    private String f47717s;

    /* renamed from: t  reason: collision with root package name */
    private String f47718t;

    /* renamed from: u  reason: collision with root package name */
    private int f47719u;

    /* renamed from: v  reason: collision with root package name */
    private int f47720v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FunGameHeader.this.f47713o.setVisibility(8);
            FunGameHeader.this.f47714p.setVisibility(8);
            FunGameHeader.this.f47712n.setVisibility(8);
            FunGameHeader.this.I();
        }
    }

    public FunGameHeader(Context context) {
        super(context);
        this.f47710l = 1.0f;
        this.f47716r = false;
        this.f47717s = "\u4e0b\u62c9\u5373\u5c06\u5c55\u5f00";
        this.f47718t = "\u62d6\u52a8\u63a7\u5236\u6e38\u620f";
        H(context, null);
    }

    private void E() {
        if (getChildCount() >= 2 || isInEditMode()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f47700b);
        addView(this.f47712n, layoutParams);
        addView(this.f47711m, layoutParams);
        this.f47715q = (int) (this.f47700b * 0.5f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f47715q);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f47715q);
        layoutParams3.topMargin = this.f47700b - this.f47715q;
        this.f47711m.addView(this.f47713o, layoutParams2);
        this.f47711m.addView(this.f47714p, layoutParams3);
    }

    private TextView F(Context context, String str, int i4, int i5) {
        TextView textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setBackgroundColor(-1);
        textView.setGravity(i5 | 1);
        textView.setTextSize(0, i4);
        textView.setText(str);
        return textView;
    }

    private void G(long j4) {
        TextView textView = this.f47713o;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.f47715q);
        TextView textView2 = this.f47714p;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), this.f47715q);
        RelativeLayout relativeLayout = this.f47712n;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(relativeLayout, "alpha", relativeLayout.getAlpha(), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(j4);
        animatorSet.start();
        animatorSet.addListener(new a());
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameHeader);
        int i4 = R.styleable.FunGameHeader_fgvMaskTopText;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f47717s = obtainStyledAttributes.getString(i4);
        }
        int i5 = R.styleable.FunGameHeader_fgvMaskBottomText;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f47718t = obtainStyledAttributes.getString(i5);
        }
        this.f47719u = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        this.f47720v = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i6 = R.styleable.FunGameHeader_fgvBottomTextSize;
        this.f47719u = obtainStyledAttributes.getDimensionPixelSize(i6, this.f47719u);
        this.f47720v = obtainStyledAttributes.getDimensionPixelSize(i6, this.f47720v);
        obtainStyledAttributes.recycle();
        this.f47711m = new RelativeLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f47712n = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#3A3A3A"));
        this.f47713o = F(context, this.f47717s, this.f47719u, 80);
        this.f47714p = F(context, this.f47718t, this.f47720v, 48);
        this.f47710l = Math.max(1, c.b(0.5f));
    }

    protected void I() {
    }

    public void J() {
        this.f47716r = false;
        TextView textView = this.f47713o;
        textView.setTranslationY(textView.getTranslationY() + this.f47715q);
        TextView textView2 = this.f47714p;
        textView2.setTranslationY(textView2.getTranslationY() - this.f47715q);
        this.f47712n.setAlpha(1.0f);
        this.f47713o.setVisibility(0);
        this.f47714p.setVisibility(0);
        this.f47712n.setVisibility(0);
    }

    public void K() {
        if (this.f47716r) {
            return;
        }
        G(200L);
        this.f47716r = true;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    public void o(g gVar, int i4, int i5) {
        super.o(gVar, i4, i5);
        E();
    }

    public void setBottomMaskViewText(String str) {
        this.f47718t = str;
        this.f47714p.setText(str);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.f47713o.setTextColor(iArr[0]);
            this.f47714p.setTextColor(iArr[0]);
            if (iArr.length > 1) {
                this.f47712n.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
                this.f47713o.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
                this.f47714p.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
            }
        }
    }

    public void setTopMaskViewText(String str) {
        this.f47717s = str;
        this.f47713o.setText(str);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    public void u(h hVar, int i4, int i5) {
        super.u(hVar, i4, i5);
        K();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    public int v(h hVar, boolean z3) {
        if (!this.f47705g) {
            J();
        }
        return super.v(hVar, z3);
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47710l = 1.0f;
        this.f47716r = false;
        this.f47717s = "\u4e0b\u62c9\u5373\u5c06\u5c55\u5f00";
        this.f47718t = "\u62d6\u52a8\u63a7\u5236\u6e38\u620f";
        H(context, attributeSet);
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47710l = 1.0f;
        this.f47716r = false;
        this.f47717s = "\u4e0b\u62c9\u5373\u5c06\u5c55\u5f00";
        this.f47718t = "\u62d6\u52a8\u63a7\u5236\u6e38\u620f";
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47710l = 1.0f;
        this.f47716r = false;
        this.f47717s = "\u4e0b\u62c9\u5373\u5c06\u5c55\u5f00";
        this.f47718t = "\u62d6\u52a8\u63a7\u5236\u6e38\u620f";
        H(context, attributeSet);
    }
}
