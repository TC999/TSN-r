package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.r1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorBufferWithTime<T> implements Observable.InterfaceC15568b<List<T>, T> {

    /* renamed from: a */
    final long f45767a;

    /* renamed from: b */
    final long f45768b;

    /* renamed from: c */
    final TimeUnit f45769c;

    /* renamed from: d */
    final int f45770d;

    /* renamed from: e */
    final Scheduler f45771e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithTime.java */
    /* renamed from: rx.internal.operators.r1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15849a extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45772a;

        /* renamed from: b */
        final Scheduler.AbstractC15607a f45773b;

        /* renamed from: c */
        List<T> f45774c = new ArrayList();

        /* renamed from: d */
        boolean f45775d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithTime.java */
        /* renamed from: rx.internal.operators.r1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15850a implements Action0 {
            C15850a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15849a.this.m1111F();
            }
        }

        public C15849a(Subscriber<? super List<T>> subscriber, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45772a = subscriber;
            this.f45773b = abstractC15607a;
        }

        /* renamed from: F */
        void m1111F() {
            synchronized (this) {
                if (this.f45775d) {
                    return;
                }
                List<T> list = this.f45774c;
                this.f45774c = new ArrayList();
                try {
                    this.f45772a.onNext(list);
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        /* renamed from: G */
        void m1110G() {
            Scheduler.AbstractC15607a abstractC15607a = this.f45773b;
            C15850a c15850a = new C15850a();
            OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
            long j = operatorBufferWithTime.f45767a;
            abstractC15607a.mo459G(c15850a, j, j, operatorBufferWithTime.f45769c);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                this.f45773b.unsubscribe();
                synchronized (this) {
                    if (this.f45775d) {
                        return;
                    }
                    this.f45775d = true;
                    List<T> list = this.f45774c;
                    this.f45774c = null;
                    this.f45772a.onNext(list);
                    this.f45772a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45772a);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f45775d) {
                    return;
                }
                this.f45775d = true;
                this.f45774c = null;
                this.f45772a.onError(th);
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (this.f45775d) {
                    return;
                }
                this.f45774c.add(t);
                if (this.f45774c.size() == OperatorBufferWithTime.this.f45770d) {
                    list = this.f45774c;
                    this.f45774c = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.f45772a.onNext(list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithTime.java */
    /* renamed from: rx.internal.operators.r1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15851b extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45778a;

        /* renamed from: b */
        final Scheduler.AbstractC15607a f45779b;

        /* renamed from: c */
        final List<List<T>> f45780c = new LinkedList();

        /* renamed from: d */
        boolean f45781d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithTime.java */
        /* renamed from: rx.internal.operators.r1$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15852a implements Action0 {
            C15852a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15851b.this.m1107H();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithTime.java */
        /* renamed from: rx.internal.operators.r1$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15853b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ List f45784a;

            C15853b(List list) {
                this.f45784a = list;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15851b.this.m1109F(this.f45784a);
            }
        }

        public C15851b(Subscriber<? super List<T>> subscriber, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45778a = subscriber;
            this.f45779b = abstractC15607a;
        }

        /* renamed from: F */
        void m1109F(List<T> list) {
            boolean z;
            synchronized (this) {
                if (this.f45781d) {
                    return;
                }
                Iterator<List<T>> it = this.f45780c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == list) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    try {
                        this.f45778a.onNext(list);
                    } catch (Throwable th) {
                        C15575a.m1473f(th, this);
                    }
                }
            }
        }

        /* renamed from: G */
        void m1108G() {
            Scheduler.AbstractC15607a abstractC15607a = this.f45779b;
            C15852a c15852a = new C15852a();
            OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
            long j = operatorBufferWithTime.f45768b;
            abstractC15607a.mo459G(c15852a, j, j, operatorBufferWithTime.f45769c);
        }

        /* renamed from: H */
        void m1107H() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f45781d) {
                    return;
                }
                this.f45780c.add(arrayList);
                Scheduler.AbstractC15607a abstractC15607a = this.f45779b;
                C15853b c15853b = new C15853b(arrayList);
                OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
                abstractC15607a.mo460F(c15853b, operatorBufferWithTime.f45767a, operatorBufferWithTime.f45769c);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f45781d) {
                        return;
                    }
                    this.f45781d = true;
                    LinkedList<List> linkedList = new LinkedList(this.f45780c);
                    this.f45780c.clear();
                    for (List list : linkedList) {
                        this.f45778a.onNext(list);
                    }
                    this.f45778a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45778a);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f45781d) {
                    return;
                }
                this.f45781d = true;
                this.f45780c.clear();
                this.f45778a.onError(th);
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                if (this.f45781d) {
                    return;
                }
                Iterator<List<T>> it = this.f45780c.iterator();
                LinkedList<List> linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t);
                    if (next.size() == OperatorBufferWithTime.this.f45770d) {
                        it.remove();
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(next);
                    }
                }
                if (linkedList != null) {
                    for (List list : linkedList) {
                        this.f45778a.onNext(list);
                    }
                }
            }
        }
    }

    public OperatorBufferWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.f45767a = j;
        this.f45768b = j2;
        this.f45769c = timeUnit;
        this.f45770d = i;
        this.f45771e = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45771e.mo450a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f45767a == this.f45768b) {
            C15849a c15849a = new C15849a(serializedSubscriber, mo450a);
            c15849a.add(mo450a);
            subscriber.add(c15849a);
            c15849a.m1110G();
            return c15849a;
        }
        C15851b c15851b = new C15851b(serializedSubscriber, mo450a);
        c15851b.add(mo450a);
        subscriber.add(c15851b);
        c15851b.m1107H();
        c15851b.m1108G();
        return c15851b;
    }
}
