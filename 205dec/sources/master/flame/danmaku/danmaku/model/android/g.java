package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DrawingCacheHolder.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Canvas f61126a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f61127b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap[][] f61128c;

    /* renamed from: d  reason: collision with root package name */
    public Object f61129d;

    /* renamed from: e  reason: collision with root package name */
    public int f61130e;

    /* renamed from: f  reason: collision with root package name */
    public int f61131f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61132g;

    /* renamed from: h  reason: collision with root package name */
    private int f61133h;

    private void d(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    private void e() {
        if (this.f61128c != null) {
            for (int i4 = 0; i4 < this.f61128c.length; i4++) {
                int i5 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.f61128c;
                    if (i5 < bitmapArr[i4].length) {
                        d(bitmapArr[i4][i5]);
                        i5++;
                    }
                }
            }
        }
    }

    private void g() {
        Bitmap[][] bitmapArr = this.f61128c;
        this.f61128c = null;
        if (bitmapArr != null) {
            for (int i4 = 0; i4 < bitmapArr.length; i4++) {
                for (int i5 = 0; i5 < bitmapArr[i4].length; i5++) {
                    if (bitmapArr[i4][i5] != null) {
                        bitmapArr[i4][i5].recycle();
                        bitmapArr[i4][i5] = null;
                    }
                }
            }
        }
    }

    public void a(int i4, int i5, int i6, boolean z3, int i7) {
        Bitmap bitmap;
        boolean z4 = true;
        if (!z3 ? i4 > this.f61130e || i5 > this.f61131f : i4 != this.f61130e || i5 != this.f61131f) {
            z4 = false;
        }
        if (z4 && (bitmap = this.f61127b) != null) {
            bitmap.eraseColor(0);
            this.f61126a.setBitmap(this.f61127b);
            g();
            return;
        }
        if (this.f61127b != null) {
            f();
        }
        this.f61130e = i4;
        this.f61131f = i5;
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        if (i7 == 32) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap a4 = NativeBitmapFactory.a(i4, i5, config);
        this.f61127b = a4;
        if (i6 > 0) {
            this.f61133h = i6;
            a4.setDensity(i6);
        }
        Canvas canvas = this.f61126a;
        if (canvas == null) {
            Canvas canvas2 = new Canvas(this.f61127b);
            this.f61126a = canvas2;
            canvas2.setDensity(i6);
            return;
        }
        canvas.setBitmap(this.f61127b);
    }

    public final synchronized boolean b(Canvas canvas, float f4, float f5, Paint paint) {
        if (this.f61128c != null) {
            for (int i4 = 0; i4 < this.f61128c.length; i4++) {
                int i5 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.f61128c;
                    if (i5 < bitmapArr[i4].length) {
                        Bitmap bitmap = bitmapArr[i4][i5];
                        if (bitmap != null) {
                            float width = (bitmap.getWidth() * i5) + f4;
                            if (width <= canvas.getWidth() && bitmap.getWidth() + width >= 0.0f) {
                                float height = (bitmap.getHeight() * i4) + f5;
                                if (height <= canvas.getHeight() && bitmap.getHeight() + height >= 0.0f) {
                                    canvas.drawBitmap(bitmap, width, height, paint);
                                }
                            }
                        }
                        i5++;
                    }
                }
            }
            return true;
        }
        Bitmap bitmap2 = this.f61127b;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, f4, f5, paint);
            return true;
        }
        return false;
    }

    public void c() {
        d(this.f61127b);
        e();
    }

    public synchronized void f() {
        Bitmap bitmap = this.f61127b;
        this.f61127b = null;
        this.f61131f = 0;
        this.f61130e = 0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        g();
        this.f61129d = null;
    }

    @SuppressLint({"NewApi"})
    public void h(int i4, int i5, int i6, int i7) {
        int i8;
        g();
        int i9 = this.f61130e;
        if (i9 <= 0 || (i8 = this.f61131f) <= 0 || this.f61127b == null) {
            return;
        }
        if (i9 > i6 || i8 > i7) {
            int min = Math.min(i6, i4);
            int min2 = Math.min(i7, i5);
            int i10 = this.f61130e;
            int i11 = (i10 / min) + (i10 % min == 0 ? 0 : 1);
            int i12 = this.f61131f;
            int i13 = (i12 / min2) + (i12 % min2 == 0 ? 0 : 1);
            int i14 = i10 / i11;
            int i15 = i12 / i13;
            Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance(Bitmap.class, i13, i11);
            if (this.f61126a == null) {
                Canvas canvas = new Canvas();
                this.f61126a = canvas;
                int i16 = this.f61133h;
                if (i16 > 0) {
                    canvas.setDensity(i16);
                }
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            for (int i17 = 0; i17 < i13; i17++) {
                for (int i18 = 0; i18 < i11; i18++) {
                    Bitmap[] bitmapArr2 = bitmapArr[i17];
                    Bitmap a4 = NativeBitmapFactory.a(i14, i15, Bitmap.Config.ARGB_8888);
                    bitmapArr2[i18] = a4;
                    int i19 = this.f61133h;
                    if (i19 > 0) {
                        a4.setDensity(i19);
                    }
                    this.f61126a.setBitmap(a4);
                    int i20 = i18 * i14;
                    int i21 = i17 * i15;
                    rect.set(i20, i21, i20 + i14, i21 + i15);
                    rect2.set(0, 0, a4.getWidth(), a4.getHeight());
                    this.f61126a.drawBitmap(this.f61127b, rect, rect2, (Paint) null);
                }
            }
            this.f61126a.setBitmap(this.f61127b);
            this.f61128c = bitmapArr;
        }
    }
}
