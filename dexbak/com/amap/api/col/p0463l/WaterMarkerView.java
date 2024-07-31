package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.amap.api.col.3l.el */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class WaterMarkerView extends View {

    /* renamed from: a */
    private Bitmap f4034a;

    /* renamed from: b */
    private Bitmap f4035b;

    /* renamed from: c */
    private Bitmap f4036c;

    /* renamed from: d */
    private Bitmap f4037d;

    /* renamed from: e */
    private Bitmap f4038e;

    /* renamed from: f */
    private Bitmap f4039f;

    /* renamed from: g */
    private Bitmap f4040g;

    /* renamed from: h */
    private Paint f4041h;

    /* renamed from: i */
    private boolean f4042i;

    /* renamed from: j */
    private int f4043j;

    /* renamed from: k */
    private int f4044k;

    /* renamed from: l */
    private int f4045l;

    /* renamed from: m */
    private int f4046m;

    /* renamed from: n */
    private int f4047n;

    /* renamed from: o */
    private int f4048o;

    /* renamed from: p */
    private int f4049p;

    /* renamed from: q */
    private int f4050q;

    /* renamed from: r */
    private boolean f4051r;

    /* renamed from: s */
    private boolean f4052s;

    /* renamed from: t */
    private Context f4053t;

    /* renamed from: u */
    private boolean f4054u;

    /* renamed from: v */
    private float f4055v;

    /* renamed from: w */
    private float f4056w;

    /* renamed from: x */
    private boolean f4057x;

    /* renamed from: y */
    private boolean f4058y;

    /* compiled from: WaterMarkerView.java */
    /* renamed from: com.amap.api.col.3l.el$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1797a extends ThreadTask {
        C1797a() {
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            WaterMarkerView.this.m55127e(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
            WaterMarkerView.this.m55127e(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
            if ("".equals(PreferenceTools.m54147b(WaterMarkerView.this.f4053t, "amap_web_logo", "md5_day", ""))) {
                if (WaterMarkerView.this.f4036c != null && WaterMarkerView.this.f4037d != null) {
                    PreferenceTools.m54146c(WaterMarkerView.this.f4053t, "amap_web_logo", "md5_day", C1849l4.m54586a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                    String m54586a = C1849l4.m54586a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                    if (!"".equals(m54586a)) {
                        PreferenceTools.m54146c(WaterMarkerView.this.f4053t, "amap_web_logo", "md5_night", m54586a);
                    }
                    WaterMarkerView.this.m55116p(true);
                    return;
                }
                PreferenceTools.m54146c(WaterMarkerView.this.f4053t, "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
                PreferenceTools.m54146c(WaterMarkerView.this.f4053t, "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
            }
        }
    }

    public WaterMarkerView(Context context) {
        super(context);
        InputStream inputStream;
        InputStream open;
        this.f4041h = new Paint();
        this.f4042i = false;
        this.f4043j = 0;
        this.f4044k = 0;
        this.f4045l = 0;
        this.f4046m = 10;
        this.f4047n = 0;
        this.f4048o = 0;
        this.f4049p = 10;
        this.f4050q = 8;
        this.f4051r = false;
        this.f4052s = false;
        this.f4054u = true;
        this.f4055v = 0.0f;
        this.f4056w = 0.0f;
        this.f4057x = true;
        this.f4058y = false;
        InputStream inputStream2 = null;
        try {
            this.f4053t = StubApp.getOrigApplicationContext(context.getApplicationContext());
            open = ResourcesUtil.m53805b(context).open("ap.data");
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            this.f4039f = decodeStream;
            this.f4034a = C1732a3.m55697m(decodeStream, ConfigableConst.f3941a);
            open.close();
            inputStream2 = ResourcesUtil.m53805b(context).open("ap1.data");
            Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
            this.f4040g = decodeStream2;
            this.f4035b = C1732a3.m55697m(decodeStream2, ConfigableConst.f3941a);
            inputStream2.close();
            this.f4044k = this.f4035b.getWidth();
            this.f4043j = this.f4035b.getHeight();
            this.f4041h.setAntiAlias(true);
            this.f4041h.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f4041h.setStyle(Paint.Style.STROKE);
            AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
            AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
            ThreadUtil.m53406a().m53405b(new C1797a());
            try {
                open.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                inputStream2.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStream2;
            inputStream2 = open;
            try {
                SDKLogHandler.m53863p(th, "WaterMarkerView", "create");
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } catch (Throwable th7) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                }
                throw th7;
            }
        }
    }

    /* renamed from: r */
    private Bitmap m55114r() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.f4058y || (bitmap3 = this.f4038e) == null) ? this.f4042i ? (!this.f4052s || (bitmap2 = this.f4037d) == null) ? this.f4035b : bitmap2 : (!this.f4052s || (bitmap = this.f4036c) == null) ? this.f4034a : bitmap : bitmap3;
    }

    /* renamed from: s */
    private void m55113s() {
        int i = this.f4048o;
        if (i == 0) {
            m55111u();
        } else if (i == 2) {
            m55112t();
        }
        this.f4046m = this.f4049p;
        int height = (getHeight() - this.f4050q) - this.f4043j;
        this.f4047n = height;
        if (this.f4046m < 0) {
            this.f4046m = 0;
        }
        if (height < 0) {
            this.f4047n = 0;
        }
    }

    /* renamed from: t */
    private void m55112t() {
        if (this.f4057x) {
            this.f4049p = (int) (getWidth() * this.f4055v);
        } else {
            this.f4049p = (int) ((getWidth() * this.f4055v) - this.f4044k);
        }
        this.f4050q = (int) (getHeight() * this.f4056w);
    }

    /* renamed from: u */
    private void m55111u() {
        int i = this.f4045l;
        if (i == 1) {
            this.f4049p = (getWidth() - this.f4044k) / 2;
        } else if (i == 2) {
            this.f4049p = (getWidth() - this.f4044k) - 10;
        } else {
            this.f4049p = 10;
        }
        this.f4050q = 8;
    }

    /* renamed from: b */
    public final void m55130b() {
        try {
            Bitmap bitmap = this.f4034a;
            if (bitmap != null) {
                C1732a3.m55743B(bitmap);
                this.f4034a = null;
            }
            Bitmap bitmap2 = this.f4035b;
            if (bitmap2 != null) {
                C1732a3.m55743B(bitmap2);
                this.f4035b = null;
            }
            this.f4034a = null;
            this.f4035b = null;
            Bitmap bitmap3 = this.f4039f;
            if (bitmap3 != null) {
                C1732a3.m55743B(bitmap3);
                this.f4039f = null;
            }
            Bitmap bitmap4 = this.f4040g;
            if (bitmap4 != null) {
                C1732a3.m55743B(bitmap4);
                this.f4040g = null;
            }
            Bitmap bitmap5 = this.f4036c;
            if (bitmap5 != null) {
                C1732a3.m55743B(bitmap5);
            }
            this.f4036c = null;
            Bitmap bitmap6 = this.f4037d;
            if (bitmap6 != null) {
                C1732a3.m55743B(bitmap6);
            }
            this.f4037d = null;
            Bitmap bitmap7 = this.f4038e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f4041h = null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m55129c(int i) {
        this.f4048o = 0;
        this.f4045l = i;
        m55120l();
    }

    /* renamed from: d */
    public final void m55128d(int i, float f) {
        if (this.f4054u) {
            this.f4048o = 2;
            float max = Math.max(0.0f, Math.min(f, 1.0f));
            if (i == 0) {
                this.f4055v = max;
                this.f4057x = true;
            } else if (i == 1) {
                this.f4055v = 1.0f - max;
                this.f4057x = false;
            } else if (i == 2) {
                this.f4056w = 1.0f - max;
            }
            m55120l();
        }
    }

    /* renamed from: e */
    public final void m55127e(String str, int i) {
        try {
            if (this.f4054u && new File(str).exists()) {
                if (i == 0) {
                    Bitmap bitmap = this.f4036c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f4039f = decodeFile;
                    this.f4036c = C1732a3.m55697m(decodeFile, ConfigableConst.f3941a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    C1732a3.m55743B(bitmap);
                } else if (i == 1) {
                    Bitmap bitmap2 = this.f4037d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f4039f = decodeFile2;
                    this.f4037d = C1732a3.m55697m(decodeFile2, ConfigableConst.f3941a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    C1732a3.m55743B(bitmap2);
                }
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: f */
    public final void m55126f(boolean z) {
        if (this.f4054u) {
            try {
                this.f4042i = z;
                if (z) {
                    this.f4041h.setColor(-1);
                } else {
                    this.f4041h.setColor(ViewCompat.MEASURED_STATE_MASK);
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public final Point m55124h() {
        return new Point(this.f4046m, this.f4047n - 2);
    }

    /* renamed from: i */
    public final void m55123i(int i) {
        this.f4048o = 1;
        this.f4050q = i;
        m55120l();
    }

    /* renamed from: j */
    public final void m55122j(boolean z) {
        if (this.f4054u) {
            this.f4058y = z;
            if (z) {
                Bitmap bitmap = this.f4038e;
                if (bitmap != null) {
                    this.f4044k = bitmap.getWidth();
                    this.f4043j = this.f4038e.getHeight();
                    return;
                }
                return;
            }
            this.f4044k = this.f4034a.getWidth();
            this.f4043j = this.f4034a.getHeight();
        }
    }

    /* renamed from: l */
    public final void m55120l() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        m55113s();
        postInvalidate();
    }

    /* renamed from: m */
    public final void m55119m(int i) {
        this.f4048o = 1;
        this.f4049p = i;
        m55120l();
    }

    /* renamed from: n */
    public final void m55118n(boolean z) {
        this.f4054u = z;
    }

    /* renamed from: o */
    public final float m55117o(int i) {
        float f;
        if (this.f4054u) {
            if (i != 0) {
                if (i == 1) {
                    f = this.f4055v;
                } else if (i != 2) {
                    return 0.0f;
                } else {
                    f = this.f4056w;
                }
                return 1.0f - f;
            }
            return this.f4055v;
        }
        return 0.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (!this.f4054u || getWidth() == 0 || getHeight() == 0 || this.f4035b == null) {
                return;
            }
            if (!this.f4051r) {
                m55113s();
                this.f4051r = true;
            }
            canvas.drawBitmap(m55114r(), this.f4046m, this.f4047n, this.f4041h);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    /* renamed from: p */
    public final void m55116p(boolean z) {
        if (this.f4054u && this.f4052s != z) {
            this.f4052s = z;
            if (z) {
                if (this.f4042i) {
                    Bitmap bitmap = this.f4037d;
                    if (bitmap != null) {
                        this.f4044k = bitmap.getWidth();
                        this.f4043j = this.f4037d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.f4036c;
                if (bitmap2 != null) {
                    this.f4044k = bitmap2.getWidth();
                    this.f4043j = this.f4036c.getHeight();
                    return;
                }
                return;
            }
            this.f4044k = this.f4034a.getWidth();
            this.f4043j = this.f4034a.getHeight();
        }
    }

    /* renamed from: q */
    public final boolean m55115q() {
        return this.f4042i;
    }
}
