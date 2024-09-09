package rx.internal.subscriptions;

import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public enum Unsubscribed implements m {
    INSTANCE;

    @Override // rx.m
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.m
    public void unsubscribe() {
    }
}
