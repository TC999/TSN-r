package com.ss.android.downloadlib.r;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    static final c f48932c = new C0957w();

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {
        private c() {
        }

        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.gd.sr.w.f29861c, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.r.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class C0957w extends c {
        private C0957w() {
            super();
        }

        @Override // com.ss.android.downloadlib.r.w.c
        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f48932c.c(asyncTask, tArr);
    }
}
