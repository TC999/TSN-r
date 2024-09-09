package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GingerScroller.java */
@TargetApi(9)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected final OverScroller f1939a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1940b = false;

    public a(Context context) {
        this.f1939a = new OverScroller(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean a() {
        if (this.f1940b) {
            this.f1939a.computeScrollOffset();
            this.f1940b = false;
        }
        return this.f1939a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void b(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f1939a.fling(i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void c(boolean z3) {
        this.f1939a.forceFinished(z3);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int d() {
        return this.f1939a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int e() {
        return this.f1939a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean g() {
        return this.f1939a.isFinished();
    }
}
