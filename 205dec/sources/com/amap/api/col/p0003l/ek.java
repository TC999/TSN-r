package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ScaleView.java */
/* renamed from: com.amap.api.col.3l.ek  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ek extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f7603a;

    /* renamed from: b  reason: collision with root package name */
    private int f7604b;

    /* renamed from: c  reason: collision with root package name */
    private IAMapDelegate f7605c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f7606d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f7607e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f7608f;

    /* renamed from: g  reason: collision with root package name */
    private IPoint f7609g;

    /* renamed from: h  reason: collision with root package name */
    private float f7610h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f7611i;

    public ek(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f7603a = "";
        this.f7604b = 0;
        this.f7610h = 0.0f;
        this.f7611i = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f7605c = iAMapDelegate;
        this.f7606d = new Paint();
        this.f7608f = new Rect();
        this.f7606d.setAntiAlias(true);
        this.f7606d.setColor(-16777216);
        this.f7606d.setStrokeWidth(fa.f7730a * 2.0f);
        this.f7606d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.f7607e = paint;
        paint.setAntiAlias(true);
        this.f7607e.setColor(-16777216);
        this.f7607e.setTextSize(fa.f7730a * 20.0f);
        this.f7610h = u2.a(context, 1.0f);
        this.f7609g = new IPoint();
    }

    private void b(int i4) {
        this.f7604b = i4;
    }

    private void c(String str) {
        this.f7603a = str;
    }

    public final void a() {
        this.f7606d = null;
        this.f7607e = null;
        this.f7608f = null;
        this.f7603a = null;
        this.f7609g = null;
    }

    public final void d(boolean z3) {
        if (z3) {
            setVisibility(0);
            e();
            return;
        }
        c("");
        b(0);
        setVisibility(8);
    }

    public final void e() {
        IPoint iPoint;
        IAMapDelegate iAMapDelegate = this.f7605c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f7605c.getPreciseLevel(engineIDWithType);
            this.f7605c.getGeoCenter(engineIDWithType, this.f7609g);
            if (this.f7609g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            float mapZoomScale = this.f7605c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.f11672y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int[] iArr = this.f7611i;
            int i4 = (int) preciseLevel;
            double d4 = iArr[i4];
            double d5 = mapZoomScale;
            Double.isNaN(cos);
            Double.isNaN(d5);
            Double.isNaN(d4);
            int i5 = (int) (d4 / (cos * d5));
            String u3 = a3.u(iArr[i4]);
            b(i5);
            c(u3);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f7603a;
        if (str == null || "".equals(str) || this.f7604b == 0 || (waterMarkerPositon = this.f7605c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.f7607e;
        String str2 = this.f7603a;
        paint.getTextBounds(str2, 0, str2.length(), this.f7608f);
        int i4 = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f7608f.height()) + 5;
        canvas.drawText(this.f7603a, ((this.f7604b - this.f7608f.width()) / 2) + i4, height, this.f7607e);
        float f4 = i4;
        float height2 = height + (this.f7608f.height() - 5);
        canvas.drawLine(f4, height2 - (this.f7610h * 2.0f), f4, height2 + fa.f7730a, this.f7606d);
        canvas.drawLine(f4, height2, this.f7604b + i4, height2, this.f7606d);
        int i5 = this.f7604b;
        canvas.drawLine(i4 + i5, height2 - (this.f7610h * 2.0f), i4 + i5, height2 + fa.f7730a, this.f7606d);
    }
}
