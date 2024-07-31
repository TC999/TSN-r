package p640rx.internal.schedulers;

import p640rx.Scheduler;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;

/* renamed from: rx.internal.schedulers.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class SleepingAction implements Action0 {

    /* renamed from: a */
    private final Action0 f46417a;

    /* renamed from: b */
    private final Scheduler.AbstractC15607a f46418b;

    /* renamed from: c */
    private final long f46419c;

    public SleepingAction(Action0 action0, Scheduler.AbstractC15607a abstractC15607a, long j) {
        this.f46417a = action0;
        this.f46418b = abstractC15607a;
        this.f46419c = j;
    }

    @Override // p640rx.functions.Action0
    public void call() {
        if (this.f46418b.isUnsubscribed()) {
            return;
        }
        long mo457b = this.f46419c - this.f46418b.mo457b();
        if (mo457b > 0) {
            try {
                Thread.sleep(mo457b);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                C15575a.m1476c(e);
            }
        }
        if (this.f46418b.isUnsubscribed()) {
            return;
        }
        this.f46417a.call();
    }
}
