package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SubscriptionList.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class m implements rx.m {

    /* renamed from: a  reason: collision with root package name */
    private List<rx.m> f63976a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f63977b;

    public m() {
    }

    private static void G(Collection<rx.m> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (rx.m mVar : collection) {
            try {
                mVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        rx.exceptions.a.d(arrayList);
    }

    public void F(rx.m mVar) {
        if (this.f63977b) {
            return;
        }
        synchronized (this) {
            List<rx.m> list = this.f63976a;
            if (!this.f63977b && list != null) {
                boolean remove = list.remove(mVar);
                if (remove) {
                    mVar.unsubscribe();
                }
            }
        }
    }

    public void a(rx.m mVar) {
        if (mVar.isUnsubscribed()) {
            return;
        }
        if (!this.f63977b) {
            synchronized (this) {
                if (!this.f63977b) {
                    List list = this.f63976a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f63976a = list;
                    }
                    list.add(mVar);
                    return;
                }
            }
        }
        mVar.unsubscribe();
    }

    public void b() {
        List<rx.m> list;
        if (this.f63977b) {
            return;
        }
        synchronized (this) {
            list = this.f63976a;
            this.f63976a = null;
        }
        G(list);
    }

    public boolean d() {
        List<rx.m> list;
        boolean z3 = false;
        if (this.f63977b) {
            return false;
        }
        synchronized (this) {
            if (!this.f63977b && (list = this.f63976a) != null && !list.isEmpty()) {
                z3 = true;
            }
        }
        return z3;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f63977b;
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.f63977b) {
            return;
        }
        synchronized (this) {
            if (this.f63977b) {
                return;
            }
            this.f63977b = true;
            List<rx.m> list = this.f63976a;
            this.f63976a = null;
            G(list);
        }
    }

    public m(rx.m... mVarArr) {
        this.f63976a = new LinkedList(Arrays.asList(mVarArr));
    }

    public m(rx.m mVar) {
        LinkedList linkedList = new LinkedList();
        this.f63976a = linkedList;
        linkedList.add(mVar);
    }
}
