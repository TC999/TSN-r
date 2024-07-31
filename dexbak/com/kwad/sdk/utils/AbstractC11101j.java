package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.utils.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC11101j<T> {

    /* renamed from: Jd */
    protected boolean f29684Jd;
    protected boolean aOB = false;

    public AbstractC11101j(boolean z) {
        this.f29684Jd = z;
    }

    @Nullable
    /* renamed from: bO */
    public final T m23784bO(Context context) {
        if (this.f29684Jd && !this.aOB) {
            try {
                return mo23783bP(context);
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
                return null;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: bP */
    protected abstract T mo23783bP(Context context);

    /* renamed from: bQ */
    public final void m23782bQ(boolean z) {
        this.f29684Jd = z;
    }
}
