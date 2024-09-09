package com.qq.e.dl.l.m.a;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.qq.e.dl.b;
import com.qq.e.dl.l.h;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.dl.l.m.a.a {
    private c B;
    private float[] C;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public h a(com.qq.e.dl.a aVar) {
            return new b(aVar);
        }
    }

    public b(com.qq.e.dl.a aVar) {
        super(aVar);
        c cVar = new c(aVar.b());
        this.B = cVar;
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.B.a(this);
        if (Build.VERSION.SDK_INT >= 16) {
            this.B.setCropToPadding(true);
        }
        this.f47070h = new com.qq.e.dl.l.k.b(this, this.B);
    }

    private ImageView.ScaleType j(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    return ImageView.ScaleType.FIT_XY;
                }
                return ImageView.ScaleType.CENTER;
            }
            return ImageView.ScaleType.CENTER_CROP;
        }
        return ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.qq.e.dl.l.m.a.a
    public void a(Object obj) {
        if (this.f47237x == null) {
            return;
        }
        this.f47073k.c().a(obj, new C0920b(this.f47238y, this.C, this.f47237x, this.B, this.f47239z));
    }

    @Override // com.qq.e.dl.l.m.a.a
    public void i(int i4) {
        ImageView.ScaleType j4 = j(i4);
        if (Build.VERSION.SDK_INT >= 16 && j4 == ImageView.ScaleType.CENTER_CROP) {
            this.B.setCropToPadding(true);
        }
        this.B.setScaleType(j4);
    }

    @Override // com.qq.e.dl.l.h
    /* renamed from: w */
    public ImageView m() {
        return this.B;
    }

    @Override // com.qq.e.dl.l.m.a.a
    protected void a(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            return;
        }
        this.C = fArr;
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.dl.l.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class C0920b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f47240a;

        /* renamed from: b  reason: collision with root package name */
        private final float[] f47241b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f47242c;

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<c> f47243d;

        /* renamed from: e  reason: collision with root package name */
        protected JSONArray f47244e;

        public C0920b(int i4, float[] fArr, Object obj, c cVar, JSONArray jSONArray) {
            this.f47240a = i4;
            this.f47241b = fArr;
            this.f47242c = obj;
            this.f47243d = new WeakReference<>(cVar);
            this.f47244e = jSONArray;
        }

        private int a(int i4, float f4) {
            if (i4 <= 0 || f4 <= 0.0f) {
                return 0;
            }
            int i5 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
            if (i5 != 0) {
                float f5 = i4;
                return f4 >= f5 ? i4 : i5 > 0 ? (int) f4 : (int) (f5 * f4);
            }
            return i4;
        }

        @Override // com.qq.e.dl.b.a
        public void a(File file, Object obj) {
            c cVar = this.f47243d.get();
            if (cVar == null) {
                return;
            }
            if (obj instanceof Bitmap) {
                int i4 = this.f47240a;
                if (i4 == 0) {
                    Bitmap bitmap = (Bitmap) obj;
                    float[] fArr = this.f47241b;
                    if (fArr != null) {
                        bitmap = a(bitmap, fArr);
                    }
                    cVar.setImageBitmap(bitmap);
                    return;
                }
                com.qq.e.dl.j.c.a(this.f47242c, cVar, (Bitmap) obj, i4, this.f47244e);
            } else if (obj instanceof Movie) {
                cVar.a((Movie) obj);
            } else if (obj instanceof Drawable) {
                cVar.setImageDrawable((Drawable) obj);
            }
        }

        @Override // com.qq.e.dl.b.a
        public void a(Object obj, int i4, Exception exc) {
        }

        private Bitmap a(Bitmap bitmap, float[] fArr) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int a4 = a(width, fArr[0]);
            int a5 = a(height, fArr[1]);
            int a6 = a(width, fArr[2]);
            int a7 = a(height, fArr[3]);
            if (a4 + a6 > width) {
                a6 = width - a4;
            }
            if (a5 + a7 > height) {
                a7 = height - a5;
            }
            return (a6 == 0 || a7 == 0) ? bitmap : Bitmap.createBitmap(bitmap, a4, a5, a6, a7);
        }
    }
}
