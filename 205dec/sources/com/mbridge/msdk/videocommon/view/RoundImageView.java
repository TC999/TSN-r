package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.MBImageView;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RoundImageView extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f41062a;

    /* renamed from: b  reason: collision with root package name */
    private int f41063b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f41064c;

    /* renamed from: d  reason: collision with root package name */
    private int f41065d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f41066e;

    /* renamed from: f  reason: collision with root package name */
    private BitmapShader f41067f;

    /* renamed from: g  reason: collision with root package name */
    private int f41068g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f41069h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41066e = new Matrix();
        Paint paint = new Paint();
        this.f41064c = paint;
        paint.setAntiAlias(true);
        this.f41063b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f41062a = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            x.d("View", th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (getDrawable() == null) {
                return;
            }
            Drawable drawable = getDrawable();
            if (drawable != null) {
                Bitmap a4 = a(drawable);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f41067f = new BitmapShader(a4, tileMode, tileMode);
                int i4 = this.f41062a;
                float f4 = 1.0f;
                if (i4 == 0) {
                    f4 = (this.f41068g * 1.0f) / Math.min(a4.getWidth(), a4.getHeight());
                } else if (i4 == 1) {
                    f4 = Math.max((getWidth() * 1.0f) / a4.getWidth(), (getHeight() * 1.0f) / a4.getHeight());
                }
                this.f41066e.setScale(f4, f4);
                this.f41067f.setLocalMatrix(this.f41066e);
                this.f41064c.setShader(this.f41067f);
            }
            if (this.f41062a == 1) {
                RectF rectF = this.f41069h;
                int i5 = this.f41063b;
                canvas.drawRoundRect(rectF, i5, i5, this.f41064c);
                return;
            }
            int i6 = this.f41065d;
            canvas.drawCircle(i6, i6, i6, this.f41064c);
        } catch (Throwable th) {
            x.d("RoundImageView", th.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f41062a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f41068g = min;
            this.f41065d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f41062a = bundle.getInt("state_type");
            this.f41063b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f41062a);
        bundle.putInt("state_border_radius", this.f41063b);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (this.f41062a == 1) {
            this.f41069h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i4) {
        int b4 = ac.b(getContext(), i4);
        if (this.f41063b != b4) {
            this.f41063b = b4;
            invalidate();
        }
    }

    public void setType(int i4) {
        if (this.f41062a != i4) {
            this.f41062a = i4;
            if (i4 != 1 && i4 != 0) {
                this.f41062a = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41066e = new Matrix();
        Paint paint = new Paint();
        this.f41064c = paint;
        paint.setAntiAlias(true);
        this.f41063b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f41062a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.f41066e = new Matrix();
        Paint paint = new Paint();
        this.f41064c = paint;
        paint.setAntiAlias(true);
        this.f41063b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f41062a = 1;
    }
}
