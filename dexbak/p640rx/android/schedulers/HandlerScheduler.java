package p640rx.android.schedulers;

import android.os.Handler;
import p640rx.Scheduler;

@Deprecated
/* renamed from: rx.android.schedulers.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class HandlerScheduler extends LooperScheduler {
    private HandlerScheduler(Handler handler) {
        super(handler);
    }

    @Deprecated
    /* renamed from: F */
    public static HandlerScheduler m1981F(Handler handler) {
        if (handler != null) {
            return new HandlerScheduler(handler);
        }
        throw new NullPointerException("handler == null");
    }

    @Override // p640rx.android.schedulers.LooperScheduler, p640rx.Scheduler
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Scheduler.AbstractC15607a mo450a() {
        return super.mo450a();
    }
}
