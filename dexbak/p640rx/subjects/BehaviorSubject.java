package p640rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import p640rx.Observable;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action1;
import p640rx.internal.operators.NotificationLite;
import p640rx.subjects.SubjectSubscriptionManager;

/* renamed from: rx.subjects.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {

    /* renamed from: c */
    private static final Object[] f46997c = new Object[0];

    /* renamed from: b */
    private final SubjectSubscriptionManager<T> f46998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorSubject.java */
    /* renamed from: rx.subjects.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16168a implements Action1<SubjectSubscriptionManager.C16182c<T>> {

        /* renamed from: a */
        final /* synthetic */ SubjectSubscriptionManager f46999a;

        C16168a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f46999a = subjectSubscriptionManager;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.C16182c) ((SubjectSubscriptionManager.C16182c) obj));
        }

        public void call(SubjectSubscriptionManager.C16182c<T> c16182c) {
            c16182c.m387F(this.f46999a.m395c());
        }
    }

    protected BehaviorSubject(Observable.InterfaceC15567a<T> interfaceC15567a, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(interfaceC15567a);
        this.f46998b = subjectSubscriptionManager;
    }

    /* renamed from: x7 */
    public static <T> BehaviorSubject<T> m431x7() {
        return m429z7(null, false);
    }

    /* renamed from: y7 */
    public static <T> BehaviorSubject<T> m430y7(T t) {
        return m429z7(t, true);
    }

    /* renamed from: z7 */
    private static <T> BehaviorSubject<T> m429z7(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.m391g(NotificationLite.m1043j(t));
        }
        C16168a c16168a = new C16168a(subjectSubscriptionManager);
        subjectSubscriptionManager.f47048d = c16168a;
        subjectSubscriptionManager.f47049e = c16168a;
        return new BehaviorSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    /* renamed from: A7 */
    public Throwable m439A7() {
        Object m395c = this.f46998b.m395c();
        if (NotificationLite.m1046g(m395c)) {
            return NotificationLite.m1049d(m395c);
        }
        return null;
    }

    /* renamed from: B7 */
    public T m438B7() {
        Object m395c = this.f46998b.m395c();
        if (NotificationLite.m1045h(m395c)) {
            return (T) NotificationLite.m1048e(m395c);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C7 */
    public Object[] m437C7() {
        Object[] objArr = f46997c;
        Object[] m436D7 = m436D7(objArr);
        return m436D7 == objArr ? new Object[0] : m436D7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D7 */
    public T[] m436D7(T[] tArr) {
        Object m395c = this.f46998b.m395c();
        if (NotificationLite.m1045h(m395c)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = NotificationLite.m1048e(m395c);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    /* renamed from: E7 */
    public boolean m435E7() {
        return NotificationLite.m1047f(this.f46998b.m395c());
    }

    /* renamed from: F7 */
    public boolean m434F7() {
        return NotificationLite.m1046g(this.f46998b.m395c());
    }

    /* renamed from: G7 */
    public boolean m433G7() {
        return NotificationLite.m1045h(this.f46998b.m395c());
    }

    /* renamed from: H7 */
    int m432H7() {
        return this.f46998b.m393e().length;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        if (this.f46998b.m395c() == null || this.f46998b.f47046b) {
            Object m1051b = NotificationLite.m1051b();
            for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f46998b.m390h(m1051b)) {
                c16182c.m385H(m1051b);
            }
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        if (this.f46998b.m395c() == null || this.f46998b.f47046b) {
            Object m1050c = NotificationLite.m1050c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f46998b.m390h(m1050c)) {
                try {
                    c16182c.m385H(m1050c);
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
        if (this.f46998b.m395c() == null || this.f46998b.f47046b) {
            Object m1043j = NotificationLite.m1043j(t);
            for (SubjectSubscriptionManager.C16182c<T> c16182c : this.f46998b.m394d(m1043j)) {
                c16182c.m385H(m1043j);
            }
        }
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f46998b.m393e().length > 0;
    }
}
