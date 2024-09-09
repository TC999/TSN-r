package f1;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* compiled from: PagePart.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f54661a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f54662b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f54663c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f54664d;

    /* renamed from: e  reason: collision with root package name */
    private int f54665e;

    public b(int i4, Bitmap bitmap, RectF rectF, boolean z3, int i5) {
        this.f54661a = i4;
        this.f54662b = bitmap;
        this.f54663c = rectF;
        this.f54664d = z3;
        this.f54665e = i5;
    }

    public int a() {
        return this.f54665e;
    }

    public int b() {
        return this.f54661a;
    }

    public RectF c() {
        return this.f54663c;
    }

    public Bitmap d() {
        return this.f54662b;
    }

    public boolean e() {
        return this.f54664d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return bVar.b() == this.f54661a && bVar.c().left == this.f54663c.left && bVar.c().right == this.f54663c.right && bVar.c().top == this.f54663c.top && bVar.c().bottom == this.f54663c.bottom;
        }
        return false;
    }

    public void f(int i4) {
        this.f54665e = i4;
    }
}
