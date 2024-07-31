package p640rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import p640rx.Scheduler;

/* renamed from: rx.internal.schedulers.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: a */
    private final ThreadFactory f46375a;

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f46375a = threadFactory;
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new NewThreadWorker(this.f46375a);
    }
}
