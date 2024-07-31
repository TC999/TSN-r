package com.kwad.sdk.collector.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.core.p397e.C10331c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.collector.model.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9809c {
    /* renamed from: a */
    public static void m27734a(@NonNull AppStatusRules.Strategy strategy, @NonNull List<InterfaceC9807a> list) {
        ArrayList<InterfaceC9810d> target = strategy.getTarget();
        if (target == null || target.size() == 0) {
            return;
        }
        for (InterfaceC9810d interfaceC9810d : target) {
            if (m27728b(interfaceC9810d) != null && m27728b(interfaceC9810d).size() != 0) {
                String m27731a = m27731a(interfaceC9810d);
                HashSet hashSet = new HashSet(m27728b(interfaceC9810d));
                long startTimeWithMS = strategy.getStartTimeWithMS();
                AppRunningInfoNative m27730a = m27730a(m27731a, strategy);
                if (m27730a != null) {
                    list.add(new AnalyseTaskNative(m27730a, hashSet, startTimeWithMS));
                }
            }
        }
    }

    /* renamed from: b */
    private static List<String> m27728b(InterfaceC9810d interfaceC9810d) {
        if (interfaceC9810d instanceof RulesTargetNative) {
            return Arrays.asList(AppStatusNative.rulesTargetGetPaths((RulesTargetNative) interfaceC9810d));
        }
        return null;
    }

    /* renamed from: c */
    public static long m27727c(InterfaceC9808b interfaceC9808b) {
        if (interfaceC9808b instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetLastRunningTime((AppRunningInfoNative) interfaceC9808b);
        }
        return 0L;
    }

    /* renamed from: d */
    public static ArrayList<InterfaceC9810d> m27726d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return m27725e(jSONArray);
    }

    /* renamed from: e */
    private static ArrayList<InterfaceC9810d> m27725e(@NonNull JSONArray jSONArray) {
        ArrayList<InterfaceC9810d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException unused) {
            }
            if (jSONObject != null) {
                RulesTargetNative rulesTargetNative = new RulesTargetNative();
                rulesTargetNative.parseJson(jSONObject);
                arrayList.add(rulesTargetNative);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String m27729b(InterfaceC9808b interfaceC9808b) {
        if (interfaceC9808b instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetPackageName((AppRunningInfoNative) interfaceC9808b);
        }
        return null;
    }

    /* renamed from: a */
    private static AppRunningInfoNative m27730a(String str, @Nullable AppStatusRules.Strategy strategy) {
        try {
            return new AppRunningInfoNative(strategy == null ? -1L : strategy.getHistoryGranularity(), "", str);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m27731a(InterfaceC9810d interfaceC9810d) {
        if (interfaceC9810d instanceof RulesTargetNative) {
            return AppStatusNative.rulesTargetGetPackageName((RulesTargetNative) interfaceC9810d);
        }
        return null;
    }

    /* renamed from: a */
    public static String m27733a(InterfaceC9808b interfaceC9808b) {
        if (interfaceC9808b instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetName((AppRunningInfoNative) interfaceC9808b);
        }
        return null;
    }

    /* renamed from: a */
    public static void m27732a(InterfaceC9808b interfaceC9808b, long j) {
        AppStatusNative.appRunningInfoSetLastRunningTime((AppRunningInfoNative) interfaceC9808b, j);
    }
}
