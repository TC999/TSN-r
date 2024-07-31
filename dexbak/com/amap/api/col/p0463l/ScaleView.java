package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.clj.fastble.BleManager;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.tencent.bugly.BUGLY;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: com.amap.api.col.3l.ek */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ScaleView extends View {

    /* renamed from: a */
    private String f4025a;

    /* renamed from: b */
    private int f4026b;

    /* renamed from: c */
    private IAMapDelegate f4027c;

    /* renamed from: d */
    private Paint f4028d;

    /* renamed from: e */
    private Paint f4029e;

    /* renamed from: f */
    private Rect f4030f;

    /* renamed from: g */
    private IPoint f4031g;

    /* renamed from: h */
    private float f4032h;

    /* renamed from: i */
    private final int[] f4033i;

    public ScaleView(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4025a = "";
        this.f4026b = 0;
        this.f4032h = 0.0f;
        this.f4033i = new int[]{PredefinedCaptureConfigurations.f24413w, PredefinedCaptureConfigurations.f24403m, 2000000, 1000000, 500000, 200000, BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 30000, 20000, BleManager.f22896l, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f4027c = iAMapDelegate;
        this.f4028d = new Paint();
        this.f4030f = new Rect();
        this.f4028d.setAntiAlias(true);
        this.f4028d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4028d.setStrokeWidth(ConfigableConst.f3941a * 2.0f);
        this.f4028d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.f4029e = paint;
        paint.setAntiAlias(true);
        this.f4029e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4029e.setTextSize(ConfigableConst.f3941a * 20.0f);
        this.f4032h = ResourcesUtil.m53806a(context, 1.0f);
        this.f4031g = new IPoint();
    }

    /* renamed from: b */
    private void m55135b(int i) {
        this.f4026b = i;
    }

    /* renamed from: c */
    private void m55134c(String str) {
        this.f4025a = str;
    }

    /* renamed from: a */
    public final void m55136a() {
        this.f4028d = null;
        this.f4029e = null;
        this.f4030f = null;
        this.f4025a = null;
        this.f4031g = null;
    }

    /* renamed from: d */
    public final void m55133d(boolean z) {
        if (z) {
            setVisibility(0);
            m55132e();
            return;
        }
        m55134c("");
        m55135b(0);
        setVisibility(8);
    }

    /* renamed from: e */
    public final void m55132e() {
        IPoint iPoint;
        IAMapDelegate iAMapDelegate = this.f4027c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f4027c.getPreciseLevel(engineIDWithType);
            this.f4027c.getGeoCenter(engineIDWithType, this.f4031g);
            if (this.f4031g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            float mapZoomScale = this.f4027c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.f7978y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int[] iArr = this.f4033i;
            int i = (int) preciseLevel;
            double d = iArr[i];
            double d2 = mapZoomScale;
            Double.isNaN(cos);
            Double.isNaN(d2);
            Double.isNaN(d);
            int i2 = (int) (d / (cos * d2));
            String m55689u = C1732a3.m55689u(iArr[i]);
            m55135b(i2);
            m55134c(m55689u);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f4025a;
        if (str == null || "".equals(str) || this.f4026b == 0 || (waterMarkerPositon = this.f4027c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.f4029e;
        String str2 = this.f4025a;
        paint.getTextBounds(str2, 0, str2.length(), this.f4030f);
        int i = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f4030f.height()) + 5;
        canvas.drawText(this.f4025a, ((this.f4026b - this.f4030f.width()) / 2) + i, height, this.f4029e);
        float f = i;
        float height2 = height + (this.f4030f.height() - 5);
        canvas.drawLine(f, height2 - (this.f4032h * 2.0f), f, height2 + ConfigableConst.f3941a, this.f4028d);
        canvas.drawLine(f, height2, this.f4026b + i, height2, this.f4028d);
        int i2 = this.f4026b;
        canvas.drawLine(i + i2, height2 - (this.f4032h * 2.0f), i + i2, height2 + ConfigableConst.f3941a, this.f4028d);
    }
}
