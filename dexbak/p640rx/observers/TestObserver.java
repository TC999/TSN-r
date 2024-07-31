package p640rx.observers;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p640rx.Notification;
import p640rx.Observer;
import p640rx.exceptions.CompositeException;

@Deprecated
/* renamed from: rx.observers.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class TestObserver<T> implements Observer<T> {

    /* renamed from: e */
    private static final Observer<Object> f46922e = new C16135a();

    /* renamed from: a */
    private final Observer<T> f46923a;

    /* renamed from: b */
    private final List<T> f46924b;

    /* renamed from: c */
    private final List<Throwable> f46925c;

    /* renamed from: d */
    private final List<Notification<T>> f46926d;

    /* compiled from: TestObserver.java */
    /* renamed from: rx.observers.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16135a implements Observer<Object> {
        C16135a() {
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
        }

        @Override // p640rx.Observer
        public void onNext(Object obj) {
        }
    }

    public TestObserver(Observer<T> observer) {
        this.f46924b = new ArrayList();
        this.f46925c = new ArrayList();
        this.f46926d = new ArrayList();
        this.f46923a = observer;
    }

    /* renamed from: F */
    public void m630F() {
        if (this.f46925c.size() > 1) {
            m629G("Too many onError events: " + this.f46925c.size());
        }
        if (this.f46926d.size() > 1) {
            m629G("Too many onCompleted events: " + this.f46926d.size());
        }
        if (this.f46926d.size() == 1 && this.f46925c.size() == 1) {
            m629G("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f46926d.isEmpty() && this.f46925c.isEmpty()) {
            m629G("No terminal events received.");
        }
    }

    /* renamed from: G */
    final void m629G(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int size = this.f46926d.size();
        sb.append(size);
        sb.append(" completion");
        if (size != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f46925c.isEmpty()) {
            int size2 = this.f46925c.size();
            sb.append(" (+");
            sb.append(size2);
            sb.append(" error");
            if (size2 != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f46925c.isEmpty()) {
            if (this.f46925c.size() == 1) {
                assertionError.initCause(this.f46925c.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.f46925c));
            }
        }
        throw assertionError;
    }

    /* renamed from: H */
    public List<Object> m628H() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f46924b);
        arrayList.add(this.f46925c);
        arrayList.add(this.f46926d);
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: I */
    public List<Notification<T>> m627I() {
        return Collections.unmodifiableList(this.f46926d);
    }

    /* renamed from: d */
    public void m626d(List<T> list) {
        if (this.f46924b.size() != list.size()) {
            m629G("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f46924b.size() + ".\nProvided values: " + list + ShellAdbUtils.f33810d + "Actual values: " + this.f46924b + ShellAdbUtils.f33810d);
        }
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            T t2 = this.f46924b.get(i);
            if (t == null) {
                if (t2 != null) {
                    m629G("Value at index: " + i + " expected to be [null] but was: [" + t2 + "]\n");
                }
            } else if (!t.equals(t2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Value at index: ");
                sb.append(i);
                sb.append(" expected to be [");
                sb.append(t);
                sb.append("] (");
                sb.append(t.getClass().getSimpleName());
                sb.append(") but was: [");
                sb.append(t2);
                sb.append("] (");
                sb.append(t2 != null ? t2.getClass().getSimpleName() : "null");
                sb.append(")\n");
                m629G(sb.toString());
            }
        }
    }

    /* renamed from: k */
    public List<Throwable> m625k() {
        return Collections.unmodifiableList(this.f46925c);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46926d.add(Notification.m2005b());
        this.f46923a.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46925c.add(th);
        this.f46923a.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46924b.add(t);
        this.f46923a.onNext(t);
    }

    /* renamed from: v */
    public List<T> m624v() {
        return Collections.unmodifiableList(this.f46924b);
    }

    public TestObserver() {
        this.f46924b = new ArrayList();
        this.f46925c = new ArrayList();
        this.f46926d = new ArrayList();
        this.f46923a = (Observer<T>) f46922e;
    }
}
