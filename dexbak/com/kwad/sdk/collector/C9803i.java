package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.collector.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9803i {
    /* renamed from: a */
    public static void m27748a(Context context, AppStatusRules.Strategy strategy, long j) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(m27747b(strategy), j).apply();
    }

    /* renamed from: b */
    private static String m27747b(AppStatusRules.Strategy strategy) {
        String name = strategy.getName() == null ? "defaultStrategy" : strategy.getName();
        return "appstatus_strategy_pref_" + name;
    }

    /* renamed from: c */
    public static List<AppStatusRules.Strategy> m27746c(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return new ArrayList();
        }
        return appStatusRules.obtainNamedStrategyList();
    }

    @NonNull
    /* renamed from: d */
    public static AppStatusRules.Strategy m27745d(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return AppStatusRules.Strategy.LOCAL_DEFAULT;
        }
        return appStatusRules.obtainDefaultStrategy();
    }

    /* renamed from: a */
    public static boolean m27749a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong(m27747b(strategy), -1L);
        if (j < 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j + minLaunchIntervalWithMS < currentTimeMillis;
    }
}
