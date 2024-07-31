package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

/* renamed from: cn.bluemobi.dylan.photoview.library.scrollerproxy.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PreGingerScroller extends ScrollerProxy {

    /* renamed from: a */
    private final Scroller f1964a;

    public PreGingerScroller(Context context) {
        this.f1964a = new Scroller(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: a */
    public boolean mo57509a() {
        return this.f1964a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: b */
    public void mo57508b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1964a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: c */
    public void mo57507c(boolean z) {
        this.f1964a.forceFinished(z);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: d */
    public int mo57506d() {
        return this.f1964a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: e */
    public int mo57505e() {
        return this.f1964a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: g */
    public boolean mo57503g() {
        return this.f1964a.isFinished();
    }
}
