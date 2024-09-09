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
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AspectRatioTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private final float f54523a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f54524b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f54525c;

    /* renamed from: d  reason: collision with root package name */
    private int f54526d;

    /* renamed from: e  reason: collision with root package name */
    private float f54527e;

    /* renamed from: f  reason: collision with root package name */
    private String f54528f;

    /* renamed from: g  reason: collision with root package name */
    private float f54529g;

    /* renamed from: h  reason: collision with root package name */
    private float f54530h;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void a(@ColorInt int i4) {
        Paint paint = this.f54525c;
        if (paint != null) {
            paint.setColor(i4);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i4, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget)}));
    }

    private void c(@NonNull TypedArray typedArray) {
        setGravity(1);
        this.f54528f = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f54529g = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f4 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f54530h = f4;
        float f5 = this.f54529g;
        if (f5 != 0.0f && f4 != 0.0f) {
            this.f54527e = f5 / f4;
        } else {
            this.f54527e = 0.0f;
        }
        this.f54526d = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f54525c = paint;
        paint.setStyle(Paint.Style.FILL);
        d();
        a(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void d() {
        if (TextUtils.isEmpty(this.f54528f)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f54529g), Integer.valueOf((int) this.f54530h)));
        } else {
            setText(this.f54528f);
        }
    }

    private void e() {
        if (this.f54527e != 0.0f) {
            float f4 = this.f54529g;
            float f5 = this.f54530h;
            this.f54529g = f5;
            this.f54530h = f4;
            this.f54527e = f5 / f4;
        }
    }

    public float b(boolean z3) {
        if (z3) {
            e();
            d();
        }
        return this.f54527e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f54524b);
            Rect rect = this.f54524b;
            float f4 = rect.bottom - (rect.top / 2.0f);
            int i4 = this.f54526d;
            canvas.drawCircle((rect.right - rect.left) / 2.0f, f4 - (i4 * 1.5f), i4 / 2.0f, this.f54525c);
        }
    }

    public void setActiveColor(@ColorInt int i4) {
        a(i4);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f54528f = aspectRatio.a();
        this.f54529g = aspectRatio.b();
        float c4 = aspectRatio.c();
        this.f54530h = c4;
        float f4 = this.f54529g;
        if (f4 != 0.0f && c4 != 0.0f) {
            this.f54527e = f4 / c4;
        } else {
            this.f54527e = 0.0f;
        }
        d();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54523a = 1.5f;
        this.f54524b = new Rect();
        c(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f54523a = 1.5f;
        this.f54524b = new Rect();
        c(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }
}
