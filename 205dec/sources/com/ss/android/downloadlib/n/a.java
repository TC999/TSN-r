package com.ss.android.downloadlib.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok<T> {
        T a();
    }

    public static <T> T ok(boolean z3, String str, @NonNull ok<T> okVar) {
        try {
            return okVar.a();
        } catch (Throwable th) {
            if (!(th instanceof com.ss.android.downloadlib.n.ok)) {
                bl.ok().ok(z3, th, str);
                if (TextUtils.isEmpty(str)) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    public static <T> T ok(ok<T> okVar) {
        return (T) ok(true, null, okVar);
    }

    public static void ok(final Runnable runnable) {
        ok(new ok<Void>() { // from class: com.ss.android.downloadlib.n.a.1
            @Override // com.ss.android.downloadlib.n.a.ok
            /* renamed from: ok */
            public Void a() {
                runnable.run();
                return null;
            }
        });
    }
}
