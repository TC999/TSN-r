package p640rx.subjects;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.internal.operators.NotificationLite;
import p640rx.schedulers.TestScheduler;
import p640rx.subjects.SubjectSubscriptionManager;

/* renamed from: rx.subjects.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class TestSubject<T> extends Subject<T, T> {

    /* renamed from: b */
    private final SubjectSubscriptionManager<T> f47064b;

    /* renamed from: c */
    private final Scheduler.AbstractC15607a f47065c;

    /* compiled from: TestSubject.java */
    /* renamed from: rx.subjects.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16183a implements Action1<SubjectSubscriptionManager.C16182c<T>> {

        /* renamed from: a */
        final /* synthetic */ SubjectSubscriptionManager f47066a;

        C16183a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f47066a = subjectSubscriptionManager;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.C16182c) ((SubjectSubscriptionManager.C16182c) obj));
        }

        public void call(SubjectSubscriptionManager.C16182c<T> c16182c) {
            c16182c.m387F(this.f47066a.m395c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TestSubject.java */
    /* renamed from: rx.subjects.h$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16184b implements Action0 {
        C16184b() {
        }

        @Override // p640rx.functions.Action0
        public void call() {
            TestSubject.this.m375y7();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TestSubject.java */
    /* renamed from: rx.subjects.h$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16185c implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Throwable f47068a;

        C16185c(Throwable th) {
            this.f47068a = th;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            TestSubject.this.m374z7(this.f47068a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TestSubject.java */
    /* renamed from: rx.subjects.h$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16186d implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Object f47070a;

        C16186d(Object obj) {
            this.f47070a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.functions.Action0
        public void call() {
            TestSubject.this.m380A7(this.f47070a);
        }
    }

    protected TestSubject(Observable.InterfaceC15567a<T> interfaceC15567a, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(interfaceC15567a);
        this.f47064b = subjectSubscriptionManager;
        this.f47065c = testScheduler.mo450a();
    }

    /* renamed from: x7 */
    public static <T> TestSubject<T> m376x7(TestScheduler testScheduler) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        C16183a c16183a = new C16183a(subjectSubscriptionManager);
        subjectSubscriptionManager.f47048d = c16183a;
        subjectSubscriptionManager.f47049e = c16183a;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    /* renamed from: A7 */
    void m380A7(T t) {
        for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f47064b.m393e()) {
            c16182c.onNext(t);
        }
    }

    /* renamed from: B7 */
    public void m379B7(long j) {
        this.f47065c.mo460F(new C16184b(), j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: C7 */
    public void m378C7(Throwable th, long j) {
        this.f47065c.mo460F(new C16185c(th), j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: D7 */
    public void m377D7(T t, long j) {
        this.f47065c.mo460F(new C16186d(t), j, TimeUnit.MILLISECONDS);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        m379B7(0L);
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        m378C7(th, 0L);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        m377D7(t, 0L);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f47064b.m393e().length > 0;
    }

    /* renamed from: y7 */
    void m375y7() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.f47064b;
        if (subjectSubscriptionManager.f47046b) {
            for (SubjectSubscriptionManager.C16182c<T> c16182c : subjectSubscriptionManager.m390h(NotificationLite.m1051b())) {
                c16182c.onCompleted();
            }
        }
    }

    /* renamed from: z7 */
    void m374z7(Throwable th) {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.f47064b;
        if (subjectSubscriptionManager.f47046b) {
            for (SubjectSubscriptionManager.C16182c<T> c16182c : subjectSubscriptionManager.m390h(NotificationLite.m1050c(th))) {
                c16182c.onError(th);
            }
        }
    }
}
