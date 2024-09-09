package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bf;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aqt = new ConcurrentHashMap();
    private static SharedPreferences aqu = null;

    private static SharedPreferences Bt() {
        if (aqu == null) {
            aqu = bf.gO("ksadsdk_config");
        }
        return aqu;
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> dj = dj(key);
        if (dj == null) {
            dj = new CopyOnWriteArraySet<>();
            aqt.put(key, dj);
        }
        dj.add(bVar);
    }

    @WorkerThread
    public static synchronized void aQ(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences Bt = Bt();
                if (Bt != null) {
                    SharedPreferences.Editor edit = Bt.edit();
                    a(edit);
                    edit.commit();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @WorkerThread
    public static synchronized void aR(Context context) {
        synchronized (b.class) {
            SharedPreferences Bt = Bt();
            if (Bt != null) {
                a(Bt);
            }
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aqt.get(str);
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aqt.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aqt.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.k(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : aqt.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = aqt.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : aqt.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = aqt.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e4) {
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences Bt;
        if (bVar == null || (Bt = Bt()) == null) {
            return;
        }
        try {
            bVar.a(Bt);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }
}
