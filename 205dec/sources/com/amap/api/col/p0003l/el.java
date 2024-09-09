package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: WaterMarkerView.java */
/* renamed from: com.amap.api.col.3l.el  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class el extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f7612a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f7613b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f7614c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f7615d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f7616e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f7617f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f7618g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f7619h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7620i;

    /* renamed from: j  reason: collision with root package name */
    private int f7621j;

    /* renamed from: k  reason: collision with root package name */
    private int f7622k;

    /* renamed from: l  reason: collision with root package name */
    private int f7623l;

    /* renamed from: m  reason: collision with root package name */
    private int f7624m;

    /* renamed from: n  reason: collision with root package name */
    private int f7625n;

    /* renamed from: o  reason: collision with root package name */
    private int f7626o;

    /* renamed from: p  reason: collision with root package name */
    private int f7627p;

    /* renamed from: q  reason: collision with root package name */
    private int f7628q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7629r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7630s;

    /* renamed from: t  reason: collision with root package name */
    private Context f7631t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7632u;

    /* renamed from: v  reason: collision with root package name */
    private float f7633v;

    /* renamed from: w  reason: collision with root package name */
    private float f7634w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7635x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f7636y;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: WaterMarkerView.java */
    /* renamed from: com.amap.api.col.3l.el$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends a8 {
        a() {
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            el.this.e(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
            el.this.e(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
            if ("".equals(q2.b(el.this.f7631t, "amap_web_logo", "md5_day", ""))) {
                if (el.this.f7614c != null && el.this.f7615d != null) {
                    q2.c(el.this.f7631t, "amap_web_logo", "md5_day", m4.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                    String a4 = m4.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                    if (!"".equals(a4)) {
                        q2.c(el.this.f7631t, "amap_web_logo", "md5_night", a4);
                    }
                    el.this.p(true);
                    return;
                }
                q2.c(el.this.f7631t, "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
                q2.c(el.this.f7631t, "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
            }
        }
    }

    public el(Context context) {
        super(context);
        InputStream inputStream;
        InputStream open;
        this.f7619h = new Paint();
        this.f7620i = false;
        this.f7621j = 0;
        this.f7622k = 0;
        this.f7623l = 0;
        this.f7624m = 10;
        this.f7625n = 0;
        this.f7626o = 0;
        this.f7627p = 10;
        this.f7628q = 8;
        this.f7629r = false;
        this.f7630s = false;
        this.f7632u = true;
        this.f7633v = 0.0f;
        this.f7634w = 0.0f;
        this.f7635x = true;
        this.f7636y = false;
        InputStream inputStream2 = null;
        try {
            this.f7631t = StubApp.getOrigApplicationContext(context.getApplicationContext());
            open = u2.b(context).open("ap.data");
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            this.f7617f = decodeStream;
            this.f7612a = a3.m(decodeStream, fa.f7730a);
            open.close();
            inputStream2 = u2.b(context).open("ap1.data");
            Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
            this.f7618g = decodeStream2;
            this.f7613b = a3.m(decodeStream2, fa.f7730a);
            inputStream2.close();
            this.f7622k = this.f7613b.getWidth();
            this.f7621j = this.f7613b.getHeight();
            this.f7619h.setAntiAlias(true);
            this.f7619h.setColor(-16777216);
            this.f7619h.setStyle(Paint.Style.STROKE);
            AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
            AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
            y2.a().b(new a());
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
                u5.p(th, "WaterMarkerView", "create");
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

    private Bitmap r() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.f7636y || (bitmap3 = this.f7616e) == null) ? this.f7620i ? (!this.f7630s || (bitmap2 = this.f7615d) == null) ? this.f7613b : bitmap2 : (!this.f7630s || (bitmap = this.f7614c) == null) ? this.f7612a : bitmap : bitmap3;
    }

    private void s() {
        int i4 = this.f7626o;
        if (i4 == 0) {
            u();
        } else if (i4 == 2) {
            t();
        }
        this.f7624m = this.f7627p;
        int height = (getHeight() - this.f7628q) - this.f7621j;
        this.f7625n = height;
        if (this.f7624m < 0) {
            this.f7624m = 0;
        }
        if (height < 0) {
            this.f7625n = 0;
        }
    }

    private void t() {
        if (this.f7635x) {
            this.f7627p = (int) (getWidth() * this.f7633v);
        } else {
            this.f7627p = (int) ((getWidth() * this.f7633v) - this.f7622k);
        }
        this.f7628q = (int) (getHeight() * this.f7634w);
    }

    private void u() {
        int i4 = this.f7623l;
        if (i4 == 1) {
            this.f7627p = (getWidth() - this.f7622k) / 2;
        } else if (i4 == 2) {
            this.f7627p = (getWidth() - this.f7622k) - 10;
        } else {
            this.f7627p = 10;
        }
        this.f7628q = 8;
    }

    public final void b() {
        try {
            Bitmap bitmap = this.f7612a;
            if (bitmap != null) {
                a3.B(bitmap);
                this.f7612a = null;
            }
            Bitmap bitmap2 = this.f7613b;
            if (bitmap2 != null) {
                a3.B(bitmap2);
                this.f7613b = null;
            }
            this.f7612a = null;
            this.f7613b = null;
            Bitmap bitmap3 = this.f7617f;
            if (bitmap3 != null) {
                a3.B(bitmap3);
                this.f7617f = null;
            }
            Bitmap bitmap4 = this.f7618g;
            if (bitmap4 != null) {
                a3.B(bitmap4);
                this.f7618g = null;
            }
            Bitmap bitmap5 = this.f7614c;
            if (bitmap5 != null) {
                a3.B(bitmap5);
            }
            this.f7614c = null;
            Bitmap bitmap6 = this.f7615d;
            if (bitmap6 != null) {
                a3.B(bitmap6);
            }
            this.f7615d = null;
            Bitmap bitmap7 = this.f7616e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f7619h = null;
        } catch (Throwable th) {
            u5.p(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final void c(int i4) {
        this.f7626o = 0;
        this.f7623l = i4;
        l();
    }

    public final void d(int i4, float f4) {
        if (this.f7632u) {
            this.f7626o = 2;
            float max = Math.max(0.0f, Math.min(f4, 1.0f));
            if (i4 == 0) {
                this.f7633v = max;
                this.f7635x = true;
            } else if (i4 == 1) {
                this.f7633v = 1.0f - max;
                this.f7635x = false;
            } else if (i4 == 2) {
                this.f7634w = 1.0f - max;
            }
            l();
        }
    }

    public final void e(String str, int i4) {
        try {
            if (this.f7632u && new File(str).exists()) {
                if (i4 == 0) {
                    Bitmap bitmap = this.f7614c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f7617f = decodeFile;
                    this.f7614c = a3.m(decodeFile, fa.f7730a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    a3.B(bitmap);
                } else if (i4 == 1) {
                    Bitmap bitmap2 = this.f7615d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f7617f = decodeFile2;
                    this.f7615d = a3.m(decodeFile2, fa.f7730a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    a3.B(bitmap2);
                }
            }
        } catch (Throwable th) {
            u5.p(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void f(boolean z3) {
        if (this.f7632u) {
            try {
                this.f7620i = z3;
                if (z3) {
                    this.f7619h.setColor(-1);
                } else {
                    this.f7619h.setColor(-16777216);
                }
            } catch (Throwable th) {
                u5.p(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final Point h() {
        return new Point(this.f7624m, this.f7625n - 2);
    }

    public final void i(int i4) {
        this.f7626o = 1;
        this.f7628q = i4;
        l();
    }

    public final void j(boolean z3) {
        if (this.f7632u) {
            this.f7636y = z3;
            if (z3) {
                Bitmap bitmap = this.f7616e;
                if (bitmap != null) {
                    this.f7622k = bitmap.getWidth();
                    this.f7621j = this.f7616e.getHeight();
                    return;
                }
                return;
            }
            this.f7622k = this.f7612a.getWidth();
            this.f7621j = this.f7612a.getHeight();
        }
    }

    public final void l() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        s();
        postInvalidate();
    }

    public final void m(int i4) {
        this.f7626o = 1;
        this.f7627p = i4;
        l();
    }

    public final void n(boolean z3) {
        this.f7632u = z3;
    }

    public final float o(int i4) {
        float f4;
        if (this.f7632u) {
            if (i4 != 0) {
                if (i4 == 1) {
                    f4 = this.f7633v;
                } else if (i4 != 2) {
                    return 0.0f;
                } else {
                    f4 = this.f7634w;
                }
                return 1.0f - f4;
            }
            return this.f7633v;
        }
        return 0.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (!this.f7632u || getWidth() == 0 || getHeight() == 0 || this.f7613b == null) {
                return;
            }
            if (!this.f7629r) {
                s();
                this.f7629r = true;
            }
            canvas.drawBitmap(r(), this.f7624m, this.f7625n, this.f7619h);
        } catch (Throwable th) {
            u5.p(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public final void p(boolean z3) {
        if (this.f7632u && this.f7630s != z3) {
            this.f7630s = z3;
            if (z3) {
                if (this.f7620i) {
                    Bitmap bitmap = this.f7615d;
                    if (bitmap != null) {
                        this.f7622k = bitmap.getWidth();
                        this.f7621j = this.f7615d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.f7614c;
                if (bitmap2 != null) {
                    this.f7622k = bitmap2.getWidth();
                    this.f7621j = this.f7614c.getHeight();
                    return;
                }
                return;
            }
            this.f7622k = this.f7612a.getWidth();
            this.f7621j = this.f7612a.getHeight();
        }
    }

    public final boolean q() {
        return this.f7620i;
    }
}
