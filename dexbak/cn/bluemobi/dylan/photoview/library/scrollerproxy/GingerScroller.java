package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
/* renamed from: cn.bluemobi.dylan.photoview.library.scrollerproxy.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class GingerScroller extends ScrollerProxy {

    /* renamed from: a */
    protected final OverScroller f1962a;

    /* renamed from: b */
    private boolean f1963b = false;

    public GingerScroller(Context context) {
        this.f1962a = new OverScroller(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: a */
    public boolean mo57509a() {
        if (this.f1963b) {
            this.f1962a.computeScrollOffset();
            this.f1963b = false;
        }
        return this.f1962a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: b */
    public void mo57508b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1962a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: c */
    public void mo57507c(boolean z) {
        this.f1962a.forceFinished(z);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: d */
    public int mo57506d() {
        return this.f1962a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: e */
    public int mo57505e() {
        return this.f1962a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: g */
    public boolean mo57503g() {
        return this.f1962a.isFinished();
    }
}
