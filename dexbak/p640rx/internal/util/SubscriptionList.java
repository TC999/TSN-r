package p640rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.util.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SubscriptionList implements Subscription {

    /* renamed from: a */
    private List<Subscription> f46545a;

    /* renamed from: b */
    private volatile boolean f46546b;

    public SubscriptionList() {
    }

    /* renamed from: G */
    private static void m809G(Collection<Subscription> collection) {
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
    public void m810F(Subscription subscription) {
        if (this.f46546b) {
            return;
        }
        synchronized (this) {
            List<Subscription> list = this.f46545a;
            if (!this.f46546b && list != null) {
                boolean remove = list.remove(subscription);
                if (remove) {
                    subscription.unsubscribe();
                }
            }
        }
    }

    /* renamed from: a */
    public void m808a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.f46546b) {
            synchronized (this) {
                if (!this.f46546b) {
                    List list = this.f46545a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f46545a = list;
                    }
                    list.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    /* renamed from: b */
    public void m807b() {
        List<Subscription> list;
        if (this.f46546b) {
            return;
        }
        synchronized (this) {
            list = this.f46545a;
            this.f46545a = null;
        }
        m809G(list);
    }

    /* renamed from: d */
    public boolean m806d() {
        List<Subscription> list;
        boolean z = false;
        if (this.f46546b) {
            return false;
        }
        synchronized (this) {
            if (!this.f46546b && (list = this.f46545a) != null && !list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f46546b;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        if (this.f46546b) {
            return;
        }
        synchronized (this) {
            if (this.f46546b) {
                return;
            }
            this.f46546b = true;
            List<Subscription> list = this.f46545a;
            this.f46545a = null;
            m809G(list);
        }
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.f46545a = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.f46545a = linkedList;
        linkedList.add(subscription);
    }
}
