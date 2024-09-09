package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.embedapplog.collector.Collector;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static ck f26713c = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f26714f = false;

    /* renamed from: r  reason: collision with root package name */
    private static volatile IExtraParams f26715r = null;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile n sr = null;
    private static boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f26716w = new ConcurrentHashMap<>(4);
    public static IAppParam xv;

    public static void c(@NonNull Context context, @NonNull InitConfig initConfig) {
        if (sr != null) {
            be.w(new RuntimeException("Init Twice!"));
        } else if (initConfig.getSensitiveInfoProvider() == null) {
            be.w(new RuntimeException("need to involve setSensitiveInfoProvider!"));
        } else {
            Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
            ys f4 = ys.f();
            n nVar = new n(application, initConfig);
            ck ckVar = new ck(application, nVar);
            f4.c(application, nVar, ckVar, new k(initConfig.getPicker()));
            sr = nVar;
            f26713c = ckVar;
            if (sr.ia()) {
                application.registerReceiver(new Collector(), new IntentFilter());
            }
            be.sr("Inited", null);
        }
    }

    public static String ev() {
        ck ckVar = f26713c;
        return ckVar != null ? ckVar.r() : "";
    }

    public static boolean f() {
        return true;
    }

    public static String gd() {
        ck ckVar = f26713c;
        return ckVar != null ? ckVar.ev() : "";
    }

    public static InitConfig k() {
        if (sr != null) {
            return sr.up();
        }
        return null;
    }

    @NonNull
    public static IDataObserver p() {
        return xu.c();
    }

    public static String r() {
        ck ckVar = f26713c;
        return ckVar != null ? ckVar.ux() : "";
    }

    public static String sr() {
        ck ckVar = f26713c;
        if (ckVar != null) {
            return ckVar.k();
        }
        return null;
    }

    @Nullable
    public static JSONObject ux() {
        if (sr != null) {
            return sr.u();
        }
        return null;
    }

    public static IExtraParams w() {
        return f26715r;
    }

    public static IAppParam xv() {
        return xv;
    }

    public static void w(@NonNull String str, @NonNull JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
            try {
                ys.c(new au(str, jSONObject));
                return;
            } catch (Exception e4) {
                be.xv("call onEventData get exception: ", e4);
                return;
            }
        }
        be.w("call onEventData with invalid params, return", null);
    }

    public static void c() {
        ys.c();
    }

    public static void c(HashMap<String, Object> hashMap) {
        ck ckVar = f26713c;
        if (ckVar != null) {
            ckVar.c(hashMap);
        }
    }

    public static <T> T c(String str, T t3) {
        ck ckVar = f26713c;
        if (ckVar != null) {
            return (T) ckVar.c(str, t3);
        }
        return null;
    }

    public static void c(@NonNull String str, @Nullable JSONObject jSONObject) {
        ys.c(new bj(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void c(@NonNull String str, @Nullable JSONObject jSONObject, int i4) {
        ys.c(new bj(str, false, jSONObject != null ? jSONObject.toString() : null, i4));
    }

    public static void c(@NonNull String str, @Nullable Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        be.w(th);
                        c(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c(str, jSONObject);
    }

    public static void c(@NonNull String str, @Nullable Bundle bundle, int i4) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        be.w(th);
                        c(str, jSONObject, i4);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c(str, jSONObject, i4);
    }

    @AnyThread
    public static void c(@Nullable IOaidObserver iOaidObserver) {
        kk.c(iOaidObserver);
    }
}
