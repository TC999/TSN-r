package l0;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: PagePart.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f60797a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f60798b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f60799c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f60800d;

    /* renamed from: e  reason: collision with root package name */
    private int f60801e;

    public b(int i4, Bitmap bitmap, RectF rectF, boolean z3, int i5) {
        this.f60797a = i4;
        this.f60798b = bitmap;
        this.f60799c = rectF;
        this.f60800d = z3;
        this.f60801e = i5;
    }

    public int a() {
        return this.f60801e;
    }

    public int b() {
        return this.f60797a;
    }

    public RectF c() {
        return this.f60799c;
    }

    public Bitmap d() {
        return this.f60798b;
    }

    public boolean e() {
        return this.f60800d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return bVar.b() == this.f60797a && bVar.c().left == this.f60799c.left && bVar.c().right == this.f60799c.right && bVar.c().top == this.f60799c.top && bVar.c().bottom == this.f60799c.bottom;
        }
        return false;
    }

    public void f(int i4) {
        this.f60801e = i4;
    }
}
