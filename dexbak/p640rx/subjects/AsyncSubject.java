package p640rx.subjects;

import java.util.ArrayList;
import p640rx.Observable;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action1;
import p640rx.internal.operators.NotificationLite;
import p640rx.internal.producers.SingleProducer;
import p640rx.subjects.SubjectSubscriptionManager;

/* renamed from: rx.subjects.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class AsyncSubject<T> extends Subject<T, T> {

    /* renamed from: b */
    final SubjectSubscriptionManager<T> f46994b;

    /* renamed from: c */
    volatile Object f46995c;

    /* compiled from: AsyncSubject.java */
    /* renamed from: rx.subjects.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16167a implements Action1<SubjectSubscriptionManager.C16182c<T>> {

        /* renamed from: a */
        final /* synthetic */ SubjectSubscriptionManager f46996a;

        C16167a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f46996a = subjectSubscriptionManager;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.C16182c) ((SubjectSubscriptionManager.C16182c) obj));
        }

        public void call(SubjectSubscriptionManager.C16182c<T> c16182c) {
            Object m395c = this.f46996a.m395c();
            if (m395c != null && !NotificationLite.m1047f(m395c)) {
                if (NotificationLite.m1046g(m395c)) {
                    c16182c.onError(NotificationLite.m1049d(m395c));
                    return;
                } else {
                    c16182c.f47057a.setProducer(new SingleProducer(c16182c.f47057a, NotificationLite.m1048e(m395c)));
                    return;
                }
            }
            c16182c.onCompleted();
        }
    }

    protected AsyncSubject(Observable.InterfaceC15567a<T> interfaceC15567a, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(interfaceC15567a);
        this.f46994b = subjectSubscriptionManager;
    }

    /* renamed from: x7 */
    public static <T> AsyncSubject<T> m442x7() {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.f47049e = new C16167a(subjectSubscriptionManager);
        return new AsyncSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    /* renamed from: A7 */
    public boolean m445A7() {
        Object m395c = this.f46994b.m395c();
        return (m395c == null || NotificationLite.m1046g(m395c)) ? false : true;
    }

    /* renamed from: B7 */
    public boolean m444B7() {
        return NotificationLite.m1046g(this.f46994b.m395c());
    }

    /* renamed from: C7 */
    public boolean m443C7() {
        return !NotificationLite.m1046g(this.f46994b.m395c()) && NotificationLite.m1045h(this.f46995c);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        SubjectSubscriptionManager.C16182c<T>[] m390h;
        if (this.f46994b.f47046b) {
            Object obj = this.f46995c;
            if (obj == null) {
                obj = NotificationLite.m1051b();
            }
            for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f46994b.m390h(obj)) {
                if (obj == NotificationLite.m1051b()) {
                    c16182c.onCompleted();
                } else {
                    c16182c.f47057a.setProducer(new SingleProducer(c16182c.f47057a, NotificationLite.m1048e(obj)));
                }
            }
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        if (this.f46994b.f47046b) {
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f46994b.m390h(NotificationLite.m1050c(th))) {
                try {
                    c16182c.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C15575a.m1475d(arrayList);
        }
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46995c = NotificationLite.m1043j(t);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f46994b.m393e().length > 0;
    }

    /* renamed from: y7 */
    public Throwable m441y7() {
        Object m395c = this.f46994b.m395c();
        if (NotificationLite.m1046g(m395c)) {
            return NotificationLite.m1049d(m395c);
        }
        return null;
    }

    /* renamed from: z7 */
    public T m440z7() {
        Object obj = this.f46995c;
        if (NotificationLite.m1046g(this.f46994b.m395c()) || !NotificationLite.m1045h(obj)) {
            return null;
        }
        return (T) NotificationLite.m1048e(obj);
    }
}
