package com.p521ss.android.downloadlib.p534h;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* renamed from: com.ss.android.downloadlib.h.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12190a {

    /* renamed from: ok */
    static final C12193ok f34465ok = new C12192a();

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.h.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12192a extends C12193ok {
        private C12192a() {
            super();
        }

        @Override // com.p521ss.android.downloadlib.p534h.C12190a.C12193ok
        /* renamed from: ok */
        public <T> void mo18818ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.h.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12193ok {
        private C12193ok() {
        }

        /* renamed from: ok */
        public <T> void mo18818ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ok */
    public static <T> void m18819ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f34465ok.mo18818ok(asyncTask, tArr);
    }
}
