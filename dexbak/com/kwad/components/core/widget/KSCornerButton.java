package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.widget.C11151h;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSCornerButton extends Button {
    private C11151h mViewRCHelper;

    public KSCornerButton(Context context) {
        super(context);
        m28929a(context, null);
    }

    /* renamed from: a */
    private void m28929a(Context context, @Nullable AttributeSet attributeSet) {
        C11151h.C11152a c11152a = new C11151h.C11152a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KSCornerImageView);
        c11152a.m23531cf(obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSCornerImageView_ksad_leftTopCorner, true));
        c11152a.m23530cg(obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSCornerImageView_ksad_topRightCorner, true));
        c11152a.m23529ch(obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSCornerImageView_ksad_rightBottomCorner, true));
        c11152a.m23528ci(obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSCornerImageView_ksad_bottomLeftCorner, true));
        obtainStyledAttributes.recycle();
        C11151h c11151h = new C11151h(c11152a);
        this.mViewRCHelper = c11151h;
        c11151h.initAttrs(context, attributeSet);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @NonNull
    public C11151h.C11152a getCornerConf() {
        return this.mViewRCHelper.getCornerConf();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m28929a(context, attributeSet);
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28929a(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m28929a(context, attributeSet);
    }
}
