package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.ee */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CompassView extends LinearLayout {

    /* renamed from: a */
    Bitmap f3949a;

    /* renamed from: b */
    Bitmap f3950b;

    /* renamed from: c */
    Bitmap f3951c;

    /* renamed from: d */
    ImageView f3952d;

    /* renamed from: e */
    IAMapDelegate f3953e;

    /* renamed from: f */
    Matrix f3954f;

    /* compiled from: CompassView.java */
    /* renamed from: com.amap.api.col.3l.ee$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class View$OnTouchListenerC1783a implements View.OnTouchListener {
        View$OnTouchListenerC1783a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            if (CompassView.this.f3953e.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    CompassView compassView = CompassView.this;
                    compassView.f3952d.setImageBitmap(compassView.f3950b);
                } else if (motionEvent.getAction() == 1) {
                    CompassView compassView2 = CompassView.this;
                    compassView2.f3952d.setImageBitmap(compassView2.f3949a);
                    CameraPosition cameraPosition = CompassView.this.f3953e.getCameraPosition();
                    CompassView.this.f3953e.animateCamera(CameraUpdateFactoryDelegate.m54549f(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                }
                return false;
            }
            return false;
        }
    }

    public CompassView(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f3954f = new Matrix();
        this.f3953e = iAMapDelegate;
        try {
            Bitmap m55698l = C1732a3.m55698l(context, "maps_dav_compass_needle_large.png");
            this.f3951c = m55698l;
            this.f3950b = C1732a3.m55697m(m55698l, ConfigableConst.f3941a * 0.8f);
            Bitmap m55697m = C1732a3.m55697m(this.f3951c, ConfigableConst.f3941a * 0.7f);
            this.f3951c = m55697m;
            Bitmap bitmap = this.f3950b;
            if (bitmap != null && m55697m != null) {
                this.f3949a = Bitmap.createBitmap(bitmap.getWidth(), this.f3950b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f3949a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f3951c, (this.f3950b.getWidth() - this.f3951c.getWidth()) / 2.0f, (this.f3950b.getHeight() - this.f3951c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f3952d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f3952d.setImageBitmap(this.f3949a);
                this.f3952d.setClickable(true);
                m55187c();
                this.f3952d.setOnTouchListener(new View$OnTouchListenerC1783a());
                addView(this.f3952d);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m55189a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f3949a;
            if (bitmap != null) {
                C1732a3.m55743B(bitmap);
            }
            Bitmap bitmap2 = this.f3950b;
            if (bitmap2 != null) {
                C1732a3.m55743B(bitmap2);
            }
            Bitmap bitmap3 = this.f3951c;
            if (bitmap3 != null) {
                C1732a3.m55743B(bitmap3);
            }
            Matrix matrix = this.f3954f;
            if (matrix != null) {
                matrix.reset();
                this.f3954f = null;
            }
            this.f3951c = null;
            this.f3949a = null;
            this.f3950b = null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m55188b(boolean z) {
        if (z) {
            setVisibility(0);
            m55187c();
            return;
        }
        setVisibility(8);
    }

    /* renamed from: c */
    public final void m55187c() {
        try {
            IAMapDelegate iAMapDelegate = this.f3953e;
            if (iAMapDelegate == null || this.f3952d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine() != null ? this.f3953e.getGLMapEngine().getEngineIDWithType(1) : 0;
            float cameraDegree = this.f3953e.getCameraDegree(engineIDWithType);
            float mapAngle = this.f3953e.getMapAngle(engineIDWithType);
            if (this.f3954f == null) {
                this.f3954f = new Matrix();
            }
            this.f3954f.reset();
            this.f3954f.postRotate(-mapAngle, this.f3952d.getDrawable().getBounds().width() / 2.0f, this.f3952d.getDrawable().getBounds().height() / 2.0f);
            Matrix matrix = this.f3954f;
            double d = cameraDegree;
            Double.isNaN(d);
            matrix.postScale(1.0f, (float) Math.cos((d * 3.141592653589793d) / 180.0d), this.f3952d.getDrawable().getBounds().width() / 2.0f, this.f3952d.getDrawable().getBounds().height() / 2.0f);
            this.f3952d.setImageMatrix(this.f3954f);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
