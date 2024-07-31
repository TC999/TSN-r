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
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.widget.MBImageView;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RoundImageView extends MBImageView {

    /* renamed from: a */
    private int f32351a;

    /* renamed from: b */
    private int f32352b;

    /* renamed from: c */
    private Paint f32353c;

    /* renamed from: d */
    private int f32354d;

    /* renamed from: e */
    private Matrix f32355e;

    /* renamed from: f */
    private BitmapShader f32356f;

    /* renamed from: g */
    private int f32357g;

    /* renamed from: h */
    private RectF f32358h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32355e = new Matrix();
        Paint paint = new Paint();
        this.f32353c = paint;
        paint.setAntiAlias(true);
        this.f32352b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f32351a = 1;
    }

    /* renamed from: a */
    private Bitmap m20639a(Drawable drawable) {
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
            SameLogTool.m21733d("View", th.getMessage());
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
                Bitmap m20639a = m20639a(drawable);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f32356f = new BitmapShader(m20639a, tileMode, tileMode);
                int i = this.f32351a;
                float f = 1.0f;
                if (i == 0) {
                    f = (this.f32357g * 1.0f) / Math.min(m20639a.getWidth(), m20639a.getHeight());
                } else if (i == 1) {
                    f = Math.max((getWidth() * 1.0f) / m20639a.getWidth(), (getHeight() * 1.0f) / m20639a.getHeight());
                }
                this.f32355e.setScale(f, f);
                this.f32356f.setLocalMatrix(this.f32355e);
                this.f32353c.setShader(this.f32356f);
            }
            if (this.f32351a == 1) {
                RectF rectF = this.f32358h;
                int i2 = this.f32352b;
                canvas.drawRoundRect(rectF, i2, i2, this.f32353c);
                return;
            }
            int i3 = this.f32354d;
            canvas.drawCircle(i3, i3, i3, this.f32353c);
        } catch (Throwable th) {
            SameLogTool.m21733d("RoundImageView", th.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f32351a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f32357g = min;
            this.f32354d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f32351a = bundle.getInt("state_type");
            this.f32352b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f32351a);
        bundle.putInt("state_border_radius", this.f32352b);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f32351a == 1) {
            this.f32358h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i) {
        int m22001b = SameTool.m22001b(getContext(), i);
        if (this.f32352b != m22001b) {
            this.f32352b = m22001b;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.f32351a != i) {
            this.f32351a = i;
            if (i != 1 && i != 0) {
                this.f32351a = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32355e = new Matrix();
        Paint paint = new Paint();
        this.f32353c = paint;
        paint.setAntiAlias(true);
        this.f32352b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f32351a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.f32355e = new Matrix();
        Paint paint = new Paint();
        this.f32353c = paint;
        paint.setAntiAlias(true);
        this.f32352b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f32351a = 1;
    }
}
