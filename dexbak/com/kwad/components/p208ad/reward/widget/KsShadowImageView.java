package com.kwad.components.p208ad.reward.widget;

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
import com.kwad.sdk.C9659R;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.kwad.components.ad.reward.widget.KsShadowImageView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsShadowImageView extends ImageView {

    /* renamed from: AU */
    private Paint f27513AU;

    /* renamed from: AV */
    private BlurMaskFilter f27514AV;

    /* renamed from: AW */
    private int f27515AW;

    /* renamed from: AX */
    private boolean f27516AX;

    /* renamed from: AY */
    private boolean f27517AY;

    /* renamed from: AZ */
    private boolean f27518AZ;

    /* renamed from: Ba */
    private boolean f27519Ba;

    /* renamed from: Bb */
    private Rect f27520Bb;
    @ColorInt

    /* renamed from: Bc */
    private int f27521Bc;

    public KsShadowImageView(Context context) {
        super(context);
        this.f27519Ba = true;
        m30981a(context, null, 0);
    }

    /* renamed from: a */
    private void m30981a(Context context, @Nullable AttributeSet attributeSet, int i) {
        this.f27513AU = new Paint();
        this.f27514AV = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.f27520Bb = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KsShadowImageView, i, 0);
        this.f27515AW = obtainStyledAttributes.getDimensionPixelSize(C9659R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.f27521Bc = obtainStyledAttributes.getColor(C9659R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.f27516AX = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.f27517AY = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.f27518AZ = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.f27519Ba = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f27513AU.setMaskFilter(this.f27514AV);
        this.f27513AU.setColor(this.f27521Bc);
        this.f27513AU.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.f27520Bb;
        rect.left = this.f27516AX ? this.f27515AW : 0;
        rect.top = this.f27518AZ ? this.f27515AW : 0;
        rect.right = measuredWidth - (this.f27517AY ? this.f27515AW : 0);
        rect.bottom = measuredHeight - (this.f27519Ba ? this.f27515AW : 0);
        canvas.drawRect(rect, this.f27513AU);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27519Ba = true;
        m30981a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27519Ba = true;
        m30981a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f27519Ba = true;
        m30981a(context, attributeSet, i);
    }
}
