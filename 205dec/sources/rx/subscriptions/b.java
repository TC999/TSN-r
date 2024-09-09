package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: CompositeSubscription.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private Set<m> f64353a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f64354b;

    public b() {
    }

    private static void H(Collection<m> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (m mVar : collection) {
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

    public boolean F() {
        Set<m> set;
        boolean z3 = false;
        if (this.f64354b) {
            return false;
        }
        synchronized (this) {
            if (!this.f64354b && (set = this.f64353a) != null && !set.isEmpty()) {
                z3 = true;
            }
        }
        return z3;
    }

    public void G(m mVar) {
        Set<m> set;
        if (this.f64354b) {
            return;
        }
        synchronized (this) {
            if (!this.f64354b && (set = this.f64353a) != null) {
                boolean remove = set.remove(mVar);
                if (remove) {
                    mVar.unsubscribe();
                }
            }
        }
    }

    public void a(m mVar) {
        if (mVar.isUnsubscribed()) {
            return;
        }
        if (!this.f64354b) {
            synchronized (this) {
                if (!this.f64354b) {
                    if (this.f64353a == null) {
                        this.f64353a = new HashSet(4);
                    }
                    this.f64353a.add(mVar);
                    return;
                }
            }
        }
        mVar.unsubscribe();
    }

    public void b(m... mVarArr) {
        int i4 = 0;
        if (!this.f64354b) {
            synchronized (this) {
                if (!this.f64354b) {
                    if (this.f64353a == null) {
                        this.f64353a = new HashSet(mVarArr.length);
                    }
                    int length = mVarArr.length;
                    while (i4 < length) {
                        m mVar = mVarArr[i4];
                        if (!mVar.isUnsubscribed()) {
                            this.f64353a.add(mVar);
                        }
                        i4++;
                    }
                    return;
                }
            }
        }
        int length2 = mVarArr.length;
        while (i4 < length2) {
            mVarArr[i4].unsubscribe();
            i4++;
        }
    }

    public void d() {
        Set<m> set;
        if (this.f64354b) {
            return;
        }
        synchronized (this) {
            if (!this.f64354b && (set = this.f64353a) != null) {
                this.f64353a = null;
                H(set);
            }
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f64354b;
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.f64354b) {
            return;
        }
        synchronized (this) {
            if (this.f64354b) {
                return;
            }
            this.f64354b = true;
            Set<m> set = this.f64353a;
            this.f64353a = null;
            H(set);
        }
    }

    public b(m... mVarArr) {
        this.f64353a = new HashSet(Arrays.asList(mVarArr));
    }
}
