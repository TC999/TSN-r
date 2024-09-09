package rx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Subscriber.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class l<T> implements f<T>, m {
    private static final long NOT_SET = Long.MIN_VALUE;
    private g producer;
    private long requested;
    private final l<?> subscriber;
    private final rx.internal.util.m subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public l() {
        this(null, false);
    }

    private void addToRequested(long j4) {
        long j5 = this.requested;
        if (j5 == Long.MIN_VALUE) {
            this.requested = j4;
            return;
        }
        long j6 = j5 + j4;
        if (j6 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j6;
        }
    }

    public final void add(m mVar) {
        this.subscriptions.a(mVar);
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j4) {
        if (j4 >= 0) {
            synchronized (this) {
                g gVar = this.producer;
                if (gVar != null) {
                    gVar.request(j4);
                    return;
                } else {
                    addToRequested(j4);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j4);
    }

    public void setProducer(g gVar) {
        long j4;
        l<?> lVar;
        boolean z3;
        synchronized (this) {
            j4 = this.requested;
            this.producer = gVar;
            lVar = this.subscriber;
            z3 = lVar != null && j4 == Long.MIN_VALUE;
        }
        if (z3) {
            lVar.setProducer(gVar);
        } else if (j4 == Long.MIN_VALUE) {
            gVar.request(Long.MAX_VALUE);
        } else {
            gVar.request(j4);
        }
    }

    @Override // rx.m
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(l<?> lVar) {
        this(lVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(l<?> lVar, boolean z3) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = lVar;
        this.subscriptions = (!z3 || lVar == null) ? new rx.internal.util.m() : lVar.subscriptions;
    }
}
