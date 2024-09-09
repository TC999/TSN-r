package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;
import rx.subscriptions.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class SequentialSubscription extends AtomicReference<m> implements m {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public m current() {
        m mVar = (m) super.get();
        return mVar == Unsubscribed.INSTANCE ? f.e() : mVar;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    public boolean replace(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == Unsubscribed.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        return true;
    }

    public boolean replaceWeak(m mVar) {
        m mVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar2 == unsubscribed) {
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return false;
        } else if (!compareAndSet(mVar2, mVar) && get() == unsubscribed) {
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return false;
        } else {
            return true;
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        m andSet;
        m mVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == unsubscribed) {
            return;
        }
        andSet.unsubscribe();
    }

    public boolean update(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == Unsubscribed.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        if (mVar2 != null) {
            mVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(m mVar) {
        m mVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar2 == unsubscribed) {
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(mVar2, mVar)) {
            return true;
        } else {
            m mVar3 = get();
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return mVar3 == unsubscribed;
        }
    }

    public SequentialSubscription(m mVar) {
        lazySet(mVar);
    }
}
