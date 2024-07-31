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
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.C11852R;
import com.scwang.smartrefresh.layout.util.C11925c;
import com.scwang.smartrefresh.layout.util.ColorUtils;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FunGameHeader extends FunGameBase implements RefreshHeader {

    /* renamed from: l */
    protected float f33302l;

    /* renamed from: m */
    private RelativeLayout f33303m;

    /* renamed from: n */
    private RelativeLayout f33304n;

    /* renamed from: o */
    private TextView f33305o;

    /* renamed from: p */
    private TextView f33306p;

    /* renamed from: q */
    private int f33307q;

    /* renamed from: r */
    private boolean f33308r;

    /* renamed from: s */
    private String f33309s;

    /* renamed from: t */
    private String f33310t;

    /* renamed from: u */
    private int f33311u;

    /* renamed from: v */
    private int f33312v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.fungame.FunGameHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11870a extends AnimatorListenerAdapter {
        C11870a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FunGameHeader.this.f33305o.setVisibility(8);
            FunGameHeader.this.f33306p.setVisibility(8);
            FunGameHeader.this.f33304n.setVisibility(8);
            FunGameHeader.this.mo20097I();
        }
    }

    public FunGameHeader(Context context) {
        super(context);
        this.f33302l = 1.0f;
        this.f33308r = false;
        this.f33309s = "下拉即将展开";
        this.f33310t = "拖动控制游戏";
        m20101H(context, null);
    }

    /* renamed from: E */
    private void m20104E() {
        if (getChildCount() >= 2 || isInEditMode()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f33292b);
        addView(this.f33304n, layoutParams);
        addView(this.f33303m, layoutParams);
        this.f33307q = (int) (this.f33292b * 0.5f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f33307q);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f33307q);
        layoutParams3.topMargin = this.f33292b - this.f33307q;
        this.f33303m.addView(this.f33305o, layoutParams2);
        this.f33303m.addView(this.f33306p, layoutParams3);
    }

    /* renamed from: F */
    private TextView m20103F(Context context, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setBackgroundColor(-1);
        textView.setGravity(i2 | 1);
        textView.setTextSize(0, i);
        textView.setText(str);
        return textView;
    }

    /* renamed from: G */
    private void m20102G(long j) {
        TextView textView = this.f33305o;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.f33307q);
        TextView textView2 = this.f33306p;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), this.f33307q);
        RelativeLayout relativeLayout = this.f33304n;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(relativeLayout, "alpha", relativeLayout.getAlpha(), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(j);
        animatorSet.start();
        animatorSet.addListener(new C11870a());
    }

    /* renamed from: H */
    private void m20101H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.FunGameHeader);
        int i = C11852R.styleable.FunGameHeader_fgvMaskTopText;
        if (obtainStyledAttributes.hasValue(i)) {
            this.f33309s = obtainStyledAttributes.getString(i);
        }
        int i2 = C11852R.styleable.FunGameHeader_fgvMaskBottomText;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f33310t = obtainStyledAttributes.getString(i2);
        }
        this.f33311u = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        this.f33312v = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i3 = C11852R.styleable.FunGameHeader_fgvBottomTextSize;
        this.f33311u = obtainStyledAttributes.getDimensionPixelSize(i3, this.f33311u);
        this.f33312v = obtainStyledAttributes.getDimensionPixelSize(i3, this.f33312v);
        obtainStyledAttributes.recycle();
        this.f33303m = new RelativeLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f33304n = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#3A3A3A"));
        this.f33305o = m20103F(context, this.f33309s, this.f33311u, 80);
        this.f33306p = m20103F(context, this.f33310t, this.f33312v, 48);
        this.f33302l = Math.max(1, C11925c.m19766b(0.5f));
    }

    /* renamed from: I */
    protected void mo20097I() {
    }

    /* renamed from: J */
    public void m20100J() {
        this.f33308r = false;
        TextView textView = this.f33305o;
        textView.setTranslationY(textView.getTranslationY() + this.f33307q);
        TextView textView2 = this.f33306p;
        textView2.setTranslationY(textView2.getTranslationY() - this.f33307q);
        this.f33304n.setAlpha(1.0f);
        this.f33305o.setVisibility(0);
        this.f33306p.setVisibility(0);
        this.f33304n.setVisibility(0);
    }

    /* renamed from: K */
    public void m20099K() {
        if (this.f33308r) {
            return;
        }
        m20102G(200L);
        this.f33308r = true;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        super.mo2098o(refreshKernel, i, i2);
        m20104E();
    }

    public void setBottomMaskViewText(String str) {
        this.f33310t = str;
        this.f33306p.setText(str);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.f33305o.setTextColor(iArr[0]);
            this.f33306p.setTextColor(iArr[0]);
            if (iArr.length > 1) {
                this.f33304n.setBackgroundColor(ColorUtils.m19794A(iArr[1], 200));
                this.f33305o.setBackgroundColor(ColorUtils.m19794A(iArr[1], 200));
                this.f33306p.setBackgroundColor(ColorUtils.m19794A(iArr[1], 200));
            }
        }
    }

    public void setTopMaskViewText(String str) {
        this.f33309s = str;
        this.f33305o.setText(str);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
        super.mo2096u(refreshLayout, i, i2);
        m20099K();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        if (!this.f33297g) {
            m20100J();
        }
        return super.mo2095v(refreshLayout, z);
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33302l = 1.0f;
        this.f33308r = false;
        this.f33309s = "下拉即将展开";
        this.f33310t = "拖动控制游戏";
        m20101H(context, attributeSet);
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33302l = 1.0f;
        this.f33308r = false;
        this.f33309s = "下拉即将展开";
        this.f33310t = "拖动控制游戏";
        m20101H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33302l = 1.0f;
        this.f33308r = false;
        this.f33309s = "下拉即将展开";
        this.f33310t = "拖动控制游戏";
        m20101H(context, attributeSet);
    }
}
