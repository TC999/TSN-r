package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.content.Context;

/* renamed from: cn.bluemobi.dylan.photoview.library.scrollerproxy.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class ScrollerProxy {
    /* renamed from: f */
    public static ScrollerProxy m57504f(Context context) {
        return new IcsScroller(context);
    }

    /* renamed from: a */
    public abstract boolean mo57509a();

    /* renamed from: b */
    public abstract void mo57508b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    /* renamed from: c */
    public abstract void mo57507c(boolean z);

    /* renamed from: d */
    public abstract int mo57506d();

    /* renamed from: e */
    public abstract int mo57505e();

    /* renamed from: g */
    public abstract boolean mo57503g();
}
