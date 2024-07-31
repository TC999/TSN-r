package p616l0;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* renamed from: l0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PagePart {

    /* renamed from: a */
    private int f43477a;

    /* renamed from: b */
    private Bitmap f43478b;

    /* renamed from: c */
    private RectF f43479c;

    /* renamed from: d */
    private boolean f43480d;

    /* renamed from: e */
    private int f43481e;

    public PagePart(int i, Bitmap bitmap, RectF rectF, boolean z, int i2) {
        this.f43477a = i;
        this.f43478b = bitmap;
        this.f43479c = rectF;
        this.f43480d = z;
        this.f43481e = i2;
    }

    /* renamed from: a */
    public int m3469a() {
        return this.f43481e;
    }

    /* renamed from: b */
    public int m3468b() {
        return this.f43477a;
    }

    /* renamed from: c */
    public RectF m3467c() {
        return this.f43479c;
    }

    /* renamed from: d */
    public Bitmap m3466d() {
        return this.f43478b;
    }

    /* renamed from: e */
    public boolean m3465e() {
        return this.f43480d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PagePart) {
            PagePart pagePart = (PagePart) obj;
            return pagePart.m3468b() == this.f43477a && pagePart.m3467c().left == this.f43479c.left && pagePart.m3467c().right == this.f43479c.right && pagePart.m3467c().top == this.f43479c.top && pagePart.m3467c().bottom == this.f43479c.bottom;
        }
        return false;
    }

    /* renamed from: f */
    public void m3464f(int i) {
        this.f43481e = i;
    }
}
