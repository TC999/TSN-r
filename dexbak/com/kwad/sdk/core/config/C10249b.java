package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.config.item.AbstractC10254b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11052bf;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10249b {
    public static final Map<String, Set<AbstractC10254b>> aqt = new ConcurrentHashMap();
    private static SharedPreferences aqu = null;

    /* renamed from: Bt */
    private static SharedPreferences m26602Bt() {
        if (aqu == null) {
            aqu = C11052bf.m23931gO("ksadsdk_config");
        }
        return aqu;
    }

    /* renamed from: a */
    public static <T> void m26598a(@NonNull AbstractC10254b<T> abstractC10254b) {
        String key = abstractC10254b.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<AbstractC10254b> m26595dj = m26595dj(key);
        if (m26595dj == null) {
            m26595dj = new CopyOnWriteArraySet<>();
            aqt.put(key, m26595dj);
        }
        m26595dj.add(abstractC10254b);
    }

    @WorkerThread
    /* renamed from: aQ */
    public static synchronized void m26597aQ(Context context) {
        synchronized (C10249b.class) {
            try {
                SharedPreferences m26602Bt = m26602Bt();
                if (m26602Bt != null) {
                    SharedPreferences.Editor edit = m26602Bt.edit();
                    m26600a(edit);
                    edit.commit();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @WorkerThread
    /* renamed from: aR */
    public static synchronized void m26596aR(Context context) {
        synchronized (C10249b.class) {
            SharedPreferences m26602Bt = m26602Bt();
            if (m26602Bt != null) {
                m26599a(m26602Bt);
            }
        }
    }

    @Nullable
    /* renamed from: dj */
    private static Set<AbstractC10254b> m26595dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aqt.get(str);
    }

    /* renamed from: j */
    public static void m26594j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aqt.keySet()) {
            Set<AbstractC10254b> set = aqt.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (AbstractC10254b abstractC10254b : set) {
                    if (abstractC10254b != null) {
                        abstractC10254b.mo26478k(jSONObject);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m26600a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : aqt.keySet()) {
                Set<AbstractC10254b> set = aqt.get(str);
                if (set != null && !set.isEmpty()) {
                    for (AbstractC10254b abstractC10254b : set) {
                        if (abstractC10254b != null) {
                            abstractC10254b.mo26479b(editor);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m26599a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : aqt.keySet()) {
                Set<AbstractC10254b> set = aqt.get(str);
                if (set != null && !set.isEmpty()) {
                    for (AbstractC10254b abstractC10254b : set) {
                        if (abstractC10254b != null) {
                            try {
                                abstractC10254b.mo26480a(sharedPreferences);
                            } catch (Exception e) {
                                C10331c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m26601a(Context context, AbstractC10254b<?> abstractC10254b) {
        SharedPreferences m26602Bt;
        if (abstractC10254b == null || (m26602Bt = m26602Bt()) == null) {
            return;
        }
        try {
            abstractC10254b.mo26480a(m26602Bt);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}
