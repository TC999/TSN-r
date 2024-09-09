package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.exceptions.CompositeException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TestObserver.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class i<T> implements rx.f<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final rx.f<Object> f64191e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<T> f64192a;

    /* renamed from: b  reason: collision with root package name */
    private final List<T> f64193b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Throwable> f64194c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Notification<T>> f64195d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestObserver.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements rx.f<Object> {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    public i(rx.f<T> fVar) {
        this.f64193b = new ArrayList();
        this.f64194c = new ArrayList();
        this.f64195d = new ArrayList();
        this.f64192a = fVar;
    }

    public void F() {
        if (this.f64194c.size() > 1) {
            G("Too many onError events: " + this.f64194c.size());
        }
        if (this.f64195d.size() > 1) {
            G("Too many onCompleted events: " + this.f64195d.size());
        }
        if (this.f64195d.size() == 1 && this.f64194c.size() == 1) {
            G("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f64195d.isEmpty() && this.f64194c.isEmpty()) {
            G("No terminal events received.");
        }
    }

    final void G(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int size = this.f64195d.size();
        sb.append(size);
        sb.append(" completion");
        if (size != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f64194c.isEmpty()) {
            int size2 = this.f64194c.size();
            sb.append(" (+");
            sb.append(size2);
            sb.append(" error");
            if (size2 != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f64194c.isEmpty()) {
            if (this.f64194c.size() == 1) {
                assertionError.initCause(this.f64194c.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.f64194c));
            }
        }
        throw assertionError;
    }

    public List<Object> H() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f64193b);
        arrayList.add(this.f64194c);
        arrayList.add(this.f64195d);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> I() {
        return Collections.unmodifiableList(this.f64195d);
    }

    public void d(List<T> list) {
        if (this.f64193b.size() != list.size()) {
            G("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f64193b.size() + ".\nProvided values: " + list + "\nActual values: " + this.f64193b + "\n");
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            T t3 = list.get(i4);
            T t4 = this.f64193b.get(i4);
            if (t3 == null) {
                if (t4 != null) {
                    G("Value at index: " + i4 + " expected to be [null] but was: [" + t4 + "]\n");
                }
            } else if (!t3.equals(t4)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Value at index: ");
                sb.append(i4);
                sb.append(" expected to be [");
                sb.append(t3);
                sb.append("] (");
                sb.append(t3.getClass().getSimpleName());
                sb.append(") but was: [");
                sb.append(t4);
                sb.append("] (");
                sb.append(t4 != null ? t4.getClass().getSimpleName() : "null");
                sb.append(")\n");
                G(sb.toString());
            }
        }
    }

    public List<Throwable> k() {
        return Collections.unmodifiableList(this.f64194c);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64195d.add(Notification.b());
        this.f64192a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64194c.add(th);
        this.f64192a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64193b.add(t3);
        this.f64192a.onNext(t3);
    }

    public List<T> v() {
        return Collections.unmodifiableList(this.f64193b);
    }

    public i() {
        this.f64193b = new ArrayList();
        this.f64194c = new ArrayList();
        this.f64195d = new ArrayList();
        this.f64192a = (rx.f<T>) f64191e;
    }
}
