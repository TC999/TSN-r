package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(14)
/* renamed from: cn.bluemobi.dylan.photoview.library.scrollerproxy.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.GingerScroller, cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy
    /* renamed from: a */
    public boolean mo57509a() {
        return this.f1962a.computeScrollOffset();
    }
}
