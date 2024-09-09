package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: IcsScroller.java */
@TargetApi(14)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.a, cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean a() {
        return this.f1939a.computeScrollOffset();
    }
}
