package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class kk {

    /* renamed from: c  reason: collision with root package name */
    private static oh<gp> f26756c = new oh<gp>() { // from class: com.bytedance.embedapplog.kk.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public gp c(Object... objArr) {
            return new gp((Context) objArr[0]);
        }
    };

    @AnyThread
    public static void c(@NonNull Context context) {
        f26756c.w(context).w();
    }

    @WorkerThread
    public static String c(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return mu.c(sharedPreferences);
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> c(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        gp w3 = f26756c.w(context);
        return w3.c(w3.c() instanceof lw ? 200 : 100);
    }

    @Nullable
    @AnyThread
    public static String c(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    @AnyThread
    public static void c(@Nullable IOaidObserver iOaidObserver) {
        gp.c(iOaidObserver);
    }
}
