package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PreGingerScroller.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Scroller f1941a;

    public c(Context context) {
        this.f1941a = new Scroller(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean a() {
        return this.f1941a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void b(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f1941a.fling(i4, i5, i6, i7, i8, i9, i10, i11);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void c(boolean z3) {
        this.f1941a.forceFinished(z3);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int d() {
        return this.f1941a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int e() {
        return this.f1941a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean g() {
        return this.f1941a.isFinished();
    }
}
