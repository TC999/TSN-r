package com.ss.android.downloadlib.ux;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c<T> {
        T w();
    }

    public static <T> T c(boolean z3, String str, @NonNull c<T> cVar) {
        try {
            return cVar.w();
        } catch (Throwable th) {
            if (!(th instanceof com.ss.android.downloadlib.ux.c)) {
                xv.c().c(z3, th, str);
                if (TextUtils.isEmpty(str)) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    public static <T> T c(c<T> cVar) {
        return (T) c(true, null, cVar);
    }

    public static void c(final Runnable runnable) {
        c(new c<Void>() { // from class: com.ss.android.downloadlib.ux.w.1
            @Override // com.ss.android.downloadlib.ux.w.c
            /* renamed from: c */
            public Void w() {
                runnable.run();
                return null;
            }
        });
    }
}
