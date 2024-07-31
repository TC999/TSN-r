package p640rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;

/* renamed from: rx.subscriptions.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompositeSubscription implements Subscription {

    /* renamed from: a */
    private Set<Subscription> f47084a;

    /* renamed from: b */
    private volatile boolean f47085b;

    public CompositeSubscription() {
    }

    /* renamed from: H */
    private static void m360H(Collection<Subscription> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Subscription subscription : collection) {
            try {
                subscription.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        C15575a.m1475d(arrayList);
    }

    /* renamed from: F */
    public boolean m362F() {
        Set<Subscription> set;
        boolean z = false;
        if (this.f47085b) {
            return false;
        }
        synchronized (this) {
            if (!this.f47085b && (set = this.f47084a) != null && !set.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: G */
    public void m361G(Subscription subscription) {
        Set<Subscription> set;
        if (this.f47085b) {
            return;
        }
        synchronized (this) {
            if (!this.f47085b && (set = this.f47084a) != null) {
                boolean remove = set.remove(subscription);
                if (remove) {
                    subscription.unsubscribe();
                }
            }
        }
    }

    /* renamed from: a */
    public void m359a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.f47085b) {
            synchronized (this) {
                if (!this.f47085b) {
                    if (this.f47084a == null) {
                        this.f47084a = new HashSet(4);
                    }
                    this.f47084a.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    /* renamed from: b */
    public void m358b(Subscription... subscriptionArr) {
        int i = 0;
        if (!this.f47085b) {
            synchronized (this) {
                if (!this.f47085b) {
                    if (this.f47084a == null) {
                        this.f47084a = new HashSet(subscriptionArr.length);
                    }
                    int length = subscriptionArr.length;
                    while (i < length) {
                        Subscription subscription = subscriptionArr[i];
                        if (!subscription.isUnsubscribed()) {
                            this.f47084a.add(subscription);
                        }
                        i++;
                    }
                    return;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i < length2) {
            subscriptionArr[i].unsubscribe();
            i++;
        }
    }

    /* renamed from: d */
    public void m357d() {
        Set<Subscription> set;
        if (this.f47085b) {
            return;
        }
        synchronized (this) {
            if (!this.f47085b && (set = this.f47084a) != null) {
                this.f47084a = null;
                m360H(set);
            }
        }
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f47085b;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        if (this.f47085b) {
            return;
        }
        synchronized (this) {
            if (this.f47085b) {
                return;
            }
            this.f47085b = true;
            Set<Subscription> set = this.f47084a;
            this.f47084a = null;
            m360H(set);
        }
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.f47084a = new HashSet(Arrays.asList(subscriptionArr));
    }
}
