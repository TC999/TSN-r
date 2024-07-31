package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.C13495R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AspectRatioTextView extends TextView {

    /* renamed from: a */
    private final float f40016a;

    /* renamed from: b */
    private final Rect f40017b;

    /* renamed from: c */
    private Paint f40018c;

    /* renamed from: d */
    private int f40019d;

    /* renamed from: e */
    private float f40020e;

    /* renamed from: f */
    private String f40021f;

    /* renamed from: g */
    private float f40022g;

    /* renamed from: h */
    private float f40023h;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m12914a(@ColorInt int i) {
        Paint paint = this.f40018c;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i, ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_widget)}));
    }

    /* renamed from: c */
    private void m12912c(@NonNull TypedArray typedArray) {
        setGravity(1);
        this.f40021f = typedArray.getString(C13495R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f40022g = typedArray.getFloat(C13495R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f = typedArray.getFloat(C13495R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f40023h = f;
        float f2 = this.f40022g;
        if (f2 != 0.0f && f != 0.0f) {
            this.f40020e = f2 / f;
        } else {
            this.f40020e = 0.0f;
        }
        this.f40019d = getContext().getResources().getDimensionPixelSize(C13495R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f40018c = paint;
        paint.setStyle(Paint.Style.FILL);
        m12911d();
        m12914a(getResources().getColor(C13495R.C13497color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    /* renamed from: d */
    private void m12911d() {
        if (TextUtils.isEmpty(this.f40021f)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f40022g), Integer.valueOf((int) this.f40023h)));
        } else {
            setText(this.f40021f);
        }
    }

    /* renamed from: e */
    private void m12910e() {
        if (this.f40020e != 0.0f) {
            float f = this.f40022g;
            float f2 = this.f40023h;
            this.f40022g = f2;
            this.f40023h = f;
            this.f40020e = f2 / f;
        }
    }

    /* renamed from: b */
    public float m12913b(boolean z) {
        if (z) {
            m12910e();
            m12911d();
        }
        return this.f40020e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f40017b);
            Rect rect = this.f40017b;
            float f = rect.bottom - (rect.top / 2.0f);
            int i = this.f40019d;
            canvas.drawCircle((rect.right - rect.left) / 2.0f, f - (i * 1.5f), i / 2.0f, this.f40018c);
        }
    }

    public void setActiveColor(@ColorInt int i) {
        m12914a(i);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f40021f = aspectRatio.m13052a();
        this.f40022g = aspectRatio.m13051b();
        float m13050c = aspectRatio.m13050c();
        this.f40023h = m13050c;
        float f = this.f40022g;
        if (f != 0.0f && m13050c != 0.0f) {
            this.f40020e = f / m13050c;
        } else {
            this.f40020e = 0.0f;
        }
        m12911d();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40016a = 1.5f;
        this.f40017b = new Rect();
        m12912c(context.obtainStyledAttributes(attributeSet, C13495R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f40016a = 1.5f;
        this.f40017b = new Rect();
        m12912c(context.obtainStyledAttributes(attributeSet, C13495R.styleable.ucrop_AspectRatioTextView));
    }
}
