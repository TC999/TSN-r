package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsShadowImageView extends ImageView {
    private Paint AU;
    private BlurMaskFilter AV;
    private int AW;
    private boolean AX;
    private boolean AY;
    private boolean AZ;
    private boolean Ba;
    private Rect Bb;
    @ColorInt
    private int Bc;

    public KsShadowImageView(Context context) {
        super(context);
        this.Ba = true;
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i4) {
        this.AU = new Paint();
        this.AV = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Bb = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i4, 0);
        this.AW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Bc = obtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.AX = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.AY = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.AZ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.Ba = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.AU.setMaskFilter(this.AV);
        this.AU.setColor(this.Bc);
        this.AU.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.Bb;
        rect.left = this.AX ? this.AW : 0;
        rect.top = this.AZ ? this.AW : 0;
        rect.right = measuredWidth - (this.AY ? this.AW : 0);
        rect.bottom = measuredHeight - (this.Ba ? this.AW : 0);
        canvas.drawRect(rect, this.AU);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ba = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Ba = true;
        a(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.Ba = true;
        a(context, attributeSet, i4);
    }
}
