package com.ss.android.downloadlib.h;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    static final ok ok = new C0950a();

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.h.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class C0950a extends ok {
        private C0950a() {
            super();
        }

        @Override // com.ss.android.downloadlib.h.a.ok
        public <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        private ok() {
        }

        public <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        ok.ok(asyncTask, tArr);
    }
}
