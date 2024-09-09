package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CompassView.java */
/* renamed from: com.amap.api.col.3l.ee  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ee extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f7527a;

    /* renamed from: b  reason: collision with root package name */
    Bitmap f7528b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f7529c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f7530d;

    /* renamed from: e  reason: collision with root package name */
    IAMapDelegate f7531e;

    /* renamed from: f  reason: collision with root package name */
    Matrix f7532f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CompassView.java */
    /* renamed from: com.amap.api.col.3l.ee$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                u5.p(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            if (ee.this.f7531e.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    ee eeVar = ee.this;
                    eeVar.f7530d.setImageBitmap(eeVar.f7528b);
                } else if (motionEvent.getAction() == 1) {
                    ee eeVar2 = ee.this;
                    eeVar2.f7530d.setImageBitmap(eeVar2.f7527a);
                    CameraPosition cameraPosition = ee.this.f7531e.getCameraPosition();
                    ee.this.f7531e.animateCamera(m.f(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                }
                return false;
            }
            return false;
        }
    }

    public ee(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f7532f = new Matrix();
        this.f7531e = iAMapDelegate;
        try {
            Bitmap l4 = a3.l(context, "maps_dav_compass_needle_large.png");
            this.f7529c = l4;
            this.f7528b = a3.m(l4, fa.f7730a * 0.8f);
            Bitmap m4 = a3.m(this.f7529c, fa.f7730a * 0.7f);
            this.f7529c = m4;
            Bitmap bitmap = this.f7528b;
            if (bitmap != null && m4 != null) {
                this.f7527a = Bitmap.createBitmap(bitmap.getWidth(), this.f7528b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f7527a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f7529c, (this.f7528b.getWidth() - this.f7529c.getWidth()) / 2.0f, (this.f7528b.getHeight() - this.f7529c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f7530d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f7530d.setImageBitmap(this.f7527a);
                this.f7530d.setClickable(true);
                c();
                this.f7530d.setOnTouchListener(new a());
                addView(this.f7530d);
            }
        } catch (Throwable th) {
            u5.p(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f7527a;
            if (bitmap != null) {
                a3.B(bitmap);
            }
            Bitmap bitmap2 = this.f7528b;
            if (bitmap2 != null) {
                a3.B(bitmap2);
            }
            Bitmap bitmap3 = this.f7529c;
            if (bitmap3 != null) {
                a3.B(bitmap3);
            }
            Matrix matrix = this.f7532f;
            if (matrix != null) {
                matrix.reset();
                this.f7532f = null;
            }
            this.f7529c = null;
            this.f7527a = null;
            this.f7528b = null;
        } catch (Throwable th) {
            u5.p(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public final void b(boolean z3) {
        if (z3) {
            setVisibility(0);
            c();
            return;
        }
        setVisibility(8);
    }

    public final void c() {
        try {
            IAMapDelegate iAMapDelegate = this.f7531e;
            if (iAMapDelegate == null || this.f7530d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine() != null ? this.f7531e.getGLMapEngine().getEngineIDWithType(1) : 0;
            float cameraDegree = this.f7531e.getCameraDegree(engineIDWithType);
            float mapAngle = this.f7531e.getMapAngle(engineIDWithType);
            if (this.f7532f == null) {
                this.f7532f = new Matrix();
            }
            this.f7532f.reset();
            this.f7532f.postRotate(-mapAngle, this.f7530d.getDrawable().getBounds().width() / 2.0f, this.f7530d.getDrawable().getBounds().height() / 2.0f);
            Matrix matrix = this.f7532f;
            double d4 = cameraDegree;
            Double.isNaN(d4);
            matrix.postScale(1.0f, (float) Math.cos((d4 * 3.141592653589793d) / 180.0d), this.f7530d.getDrawable().getBounds().width() / 2.0f, this.f7530d.getDrawable().getBounds().height() / 2.0f);
            this.f7530d.setImageMatrix(this.f7532f);
        } catch (Throwable th) {
            u5.p(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
