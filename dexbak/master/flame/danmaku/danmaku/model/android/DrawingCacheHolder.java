package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;

/* renamed from: master.flame.danmaku.danmaku.model.android.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DrawingCacheHolder {

    /* renamed from: a */
    public Canvas f43818a;

    /* renamed from: b */
    public Bitmap f43819b;

    /* renamed from: c */
    public Bitmap[][] f43820c;

    /* renamed from: d */
    public Object f43821d;

    /* renamed from: e */
    public int f43822e;

    /* renamed from: f */
    public int f43823f;

    /* renamed from: g */
    public boolean f43824g;

    /* renamed from: h */
    private int f43825h;

    /* renamed from: d */
    private void m3131d(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    /* renamed from: e */
    private void m3130e() {
        if (this.f43820c != null) {
            for (int i = 0; i < this.f43820c.length; i++) {
                int i2 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.f43820c;
                    if (i2 < bitmapArr[i].length) {
                        m3131d(bitmapArr[i][i2]);
                        i2++;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private void m3128g() {
        Bitmap[][] bitmapArr = this.f43820c;
        this.f43820c = null;
        if (bitmapArr != null) {
            for (int i = 0; i < bitmapArr.length; i++) {
                for (int i2 = 0; i2 < bitmapArr[i].length; i2++) {
                    if (bitmapArr[i][i2] != null) {
                        bitmapArr[i][i2].recycle();
                        bitmapArr[i][i2] = null;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m3134a(int i, int i2, int i3, boolean z, int i4) {
        Bitmap bitmap;
        boolean z2 = true;
        if (!z ? i > this.f43822e || i2 > this.f43823f : i != this.f43822e || i2 != this.f43823f) {
            z2 = false;
        }
        if (z2 && (bitmap = this.f43819b) != null) {
            bitmap.eraseColor(0);
            this.f43818a.setBitmap(this.f43819b);
            m3128g();
            return;
        }
        if (this.f43819b != null) {
            m3129f();
        }
        this.f43822e = i;
        this.f43823f = i2;
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        if (i4 == 32) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap m267a = NativeBitmapFactory.m267a(i, i2, config);
        this.f43819b = m267a;
        if (i3 > 0) {
            this.f43825h = i3;
            m267a.setDensity(i3);
        }
        Canvas canvas = this.f43818a;
        if (canvas == null) {
            Canvas canvas2 = new Canvas(this.f43819b);
            this.f43818a = canvas2;
            canvas2.setDensity(i3);
            return;
        }
        canvas.setBitmap(this.f43819b);
    }

    /* renamed from: b */
    public final synchronized boolean m3133b(Canvas canvas, float f, float f2, Paint paint) {
        if (this.f43820c != null) {
            for (int i = 0; i < this.f43820c.length; i++) {
                int i2 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.f43820c;
                    if (i2 < bitmapArr[i].length) {
                        Bitmap bitmap = bitmapArr[i][i2];
                        if (bitmap != null) {
                            float width = (bitmap.getWidth() * i2) + f;
                            if (width <= canvas.getWidth() && bitmap.getWidth() + width >= 0.0f) {
                                float height = (bitmap.getHeight() * i) + f2;
                                if (height <= canvas.getHeight() && bitmap.getHeight() + height >= 0.0f) {
                                    canvas.drawBitmap(bitmap, width, height, paint);
                                }
                            }
                        }
                        i2++;
                    }
                }
            }
            return true;
        }
        Bitmap bitmap2 = this.f43819b;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, f, f2, paint);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m3132c() {
        m3131d(this.f43819b);
        m3130e();
    }

    /* renamed from: f */
    public synchronized void m3129f() {
        Bitmap bitmap = this.f43819b;
        this.f43819b = null;
        this.f43823f = 0;
        this.f43822e = 0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        m3128g();
        this.f43821d = null;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public void m3127h(int i, int i2, int i3, int i4) {
        int i5;
        m3128g();
        int i6 = this.f43822e;
        if (i6 <= 0 || (i5 = this.f43823f) <= 0 || this.f43819b == null) {
            return;
        }
        if (i6 > i3 || i5 > i4) {
            int min = Math.min(i3, i);
            int min2 = Math.min(i4, i2);
            int i7 = this.f43822e;
            int i8 = (i7 / min) + (i7 % min == 0 ? 0 : 1);
            int i9 = this.f43823f;
            int i10 = (i9 / min2) + (i9 % min2 == 0 ? 0 : 1);
            int i11 = i7 / i8;
            int i12 = i9 / i10;
            Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance(Bitmap.class, i10, i8);
            if (this.f43818a == null) {
                Canvas canvas = new Canvas();
                this.f43818a = canvas;
                int i13 = this.f43825h;
                if (i13 > 0) {
                    canvas.setDensity(i13);
                }
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i8; i15++) {
                    Bitmap[] bitmapArr2 = bitmapArr[i14];
                    Bitmap m267a = NativeBitmapFactory.m267a(i11, i12, Bitmap.Config.ARGB_8888);
                    bitmapArr2[i15] = m267a;
                    int i16 = this.f43825h;
                    if (i16 > 0) {
                        m267a.setDensity(i16);
                    }
                    this.f43818a.setBitmap(m267a);
                    int i17 = i15 * i11;
                    int i18 = i14 * i12;
                    rect.set(i17, i18, i17 + i11, i18 + i12);
                    rect2.set(0, 0, m267a.getWidth(), m267a.getHeight());
                    this.f43818a.drawBitmap(this.f43819b, rect, rect2, (Paint) null);
                }
            }
            this.f43818a.setBitmap(this.f43819b);
            this.f43820c = bitmapArr;
        }
    }
}
