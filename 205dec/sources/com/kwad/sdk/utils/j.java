package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class j<T> {
    protected boolean Jd;
    protected boolean aOB = false;

    public j(boolean z3) {
        this.Jd = z3;
    }

    @Nullable
    public final T bO(Context context) {
        if (this.Jd && !this.aOB) {
            try {
                return bP(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                return null;
            }
        }
        return null;
    }

    @Nullable
    protected abstract T bP(Context context);

    public final void bQ(boolean z3) {
        this.Jd = z3;
    }
}
