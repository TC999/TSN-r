package rx.android.schedulers;

import android.os.Handler;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: HandlerScheduler.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b extends c {
    private b(Handler handler) {
        super(handler);
    }

    @Deprecated
    public static b e(Handler handler) {
        if (handler != null) {
            return new b(handler);
        }
        throw new NullPointerException("handler == null");
    }

    @Override // rx.android.schedulers.c, rx.h
    public /* bridge */ /* synthetic */ h.a a() {
        return super.a();
    }
}
