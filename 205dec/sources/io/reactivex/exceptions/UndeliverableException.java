package io.reactivex.exceptions;

import io.reactivex.annotations.Beta;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Beta
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UndeliverableException extends IllegalStateException {
    private static final long serialVersionUID = 1644750035281290266L;

    public UndeliverableException(Throwable th) {
        super(th);
    }
}
