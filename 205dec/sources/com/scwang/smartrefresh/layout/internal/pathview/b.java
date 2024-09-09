package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathsDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends Drawable {

    /* renamed from: n  reason: collision with root package name */
    protected static final Region f48054n = new Region();

    /* renamed from: o  reason: collision with root package name */
    protected static final Region f48055o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    protected Paint f48056a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Path> f48057b;

    /* renamed from: c  reason: collision with root package name */
    protected List<Integer> f48058c;

    /* renamed from: d  reason: collision with root package name */
    protected int f48059d = 1;

    /* renamed from: e  reason: collision with root package name */
    protected int f48060e = 1;

    /* renamed from: f  reason: collision with root package name */
    protected int f48061f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f48062g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f48063h;

    /* renamed from: i  reason: collision with root package name */
    protected int f48064i;

    /* renamed from: j  reason: collision with root package name */
    protected List<Path> f48065j;

    /* renamed from: k  reason: collision with root package name */
    protected List<String> f48066k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f48067l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f48068m;

    public b() {
        Paint paint = new Paint();
        this.f48056a = paint;
        paint.setColor(-15614977);
        this.f48056a.setStyle(Paint.Style.FILL);
        this.f48056a.setAntiAlias(true);
    }

    private void d(Canvas canvas) {
        canvas.translate(-this.f48061f, -this.f48062g);
        if (this.f48057b != null) {
            for (int i4 = 0; i4 < this.f48057b.size(); i4++) {
                List<Integer> list = this.f48058c;
                if (list != null && i4 < list.size()) {
                    this.f48056a.setColor(this.f48058c.get(i4).intValue());
                }
                canvas.drawPath(this.f48057b.get(i4), this.f48056a);
            }
        }
    }

    public boolean a(int i4, int i5) {
        return i4 == this.f48067l.getWidth() && i5 == this.f48067l.getHeight();
    }

    public boolean b() {
        return !this.f48068m;
    }

    public void c(int i4, int i5) {
        if (this.f48067l == null || !a(i4, i5)) {
            this.f48067l = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            this.f48068m = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f48056a.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f48061f, bounds.top - this.f48062g);
            if (this.f48057b != null) {
                for (int i4 = 0; i4 < this.f48057b.size(); i4++) {
                    List<Integer> list = this.f48058c;
                    if (list != null && i4 < list.size()) {
                        this.f48056a.setColor(this.f48058c.get(i4).intValue());
                    }
                    canvas.drawPath(this.f48057b.get(i4), this.f48056a);
                }
                this.f48056a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        c(width, height);
        if (!b()) {
            m(width, height);
            l();
        }
        canvas.drawBitmap(this.f48067l, bounds.left, bounds.top, this.f48056a);
    }

    public Paint e() {
        return this.f48056a;
    }

    public int f() {
        return getBounds().height();
    }

    protected void g() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.f48057b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                Region region = f48054n;
                region.setPath(path, f48055o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f48061f = num4 == null ? 0 : num4.intValue();
        this.f48062g = num == null ? 0 : num.intValue();
        this.f48059d = num2 == null ? 0 : num2.intValue() - this.f48061f;
        int intValue = num3 != null ? num3.intValue() - this.f48062g : 0;
        this.f48060e = intValue;
        if (this.f48063h == 0) {
            this.f48063h = this.f48059d;
        }
        if (this.f48064i == 0) {
            this.f48064i = intValue;
        }
        Rect bounds2 = getBounds();
        int i4 = bounds2.left;
        int i5 = bounds2.top;
        super.setBounds(i4, i5, this.f48059d + i4, this.f48060e + i5);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int... iArr) {
        this.f48058c = new ArrayList();
        for (int i4 : iArr) {
            this.f48058c.add(Integer.valueOf(i4));
        }
    }

    public void i(String... strArr) {
        this.f48064i = 0;
        this.f48063h = 0;
        this.f48066k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f48065j = arrayList;
        this.f48057b = arrayList;
        for (String str : strArr) {
            this.f48066k.add(str);
            this.f48065j.add(a.e(str));
        }
        g();
    }

    public void j(int i4) {
        Rect bounds = getBounds();
        float height = (i4 * 1.0f) / bounds.height();
        setBounds((int) (bounds.left * height), (int) (bounds.top * height), (int) (bounds.right * height), (int) (bounds.bottom * height));
    }

    public void k(int i4) {
        Rect bounds = getBounds();
        float width = (i4 * 1.0f) / bounds.width();
        setBounds((int) (bounds.left * width), (int) (bounds.top * width), (int) (bounds.right * width), (int) (bounds.bottom * width));
    }

    public void l() {
        this.f48068m = false;
    }

    public void m(int i4, int i5) {
        this.f48067l.eraseColor(0);
        d(new Canvas(this.f48067l));
    }

    public int n() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f48056a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        List<Path> list = this.f48065j;
        if (list != null && list.size() > 0 && (i8 != this.f48059d || i9 != this.f48060e)) {
            this.f48057b = a.j((i8 * 1.0f) / this.f48063h, (i9 * 1.0f) / this.f48064i, this.f48065j, this.f48066k);
            g();
            return;
        }
        super.setBounds(i4, i5, i6, i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f48056a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
