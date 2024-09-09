package cn.jiguang.at;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends a {
    private long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    @TargetApi(22)
    private HashMap<String, cn.jiguang.common.m.c> a(Context context) {
        cn.jiguang.common.m.c cVar;
        HashMap<String, cn.jiguang.common.m.c> hashMap = new HashMap<>();
        if (!b(context)) {
            cn.jiguang.w.a.b("CollectByUsageStateManager", "no usage state permission");
            return hashMap;
        }
        cn.jiguang.w.a.b("CollectByUsageStateManager", "start collect active data by usage state");
        long a4 = a();
        long b4 = b();
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, a4, b4);
        if (queryUsageStats != null && !queryUsageStats.isEmpty()) {
            a(usageStatsManager, hashMap, a4, b4);
            for (UsageStats usageStats : queryUsageStats) {
                String packageName = usageStats.getPackageName();
                long lastTimeStamp = usageStats.getLastTimeStamp();
                if (!hashMap.containsKey(packageName) || (cVar = hashMap.get(packageName)) == null || cVar.f3492e.isEmpty() || cVar.f3492e.get(0).longValue() < lastTimeStamp) {
                    cn.jiguang.common.m.c cVar2 = hashMap.get(packageName);
                    if (cVar2 == null) {
                        cVar2 = new cn.jiguang.common.m.c();
                        cVar2.f3488a = packageName;
                        hashMap.put(packageName, cVar2);
                    }
                    cVar2.f3489b = usageStats.getTotalTimeInForeground() / 1000;
                    cVar2.f3492e.add(Long.valueOf(lastTimeStamp));
                    cVar2.f3491d.add(1);
                }
            }
        }
        return hashMap;
    }

    @TargetApi(21)
    private void a(UsageStatsManager usageStatsManager, HashMap<String, cn.jiguang.common.m.c> hashMap, long j4, long j5) {
        ArrayList arrayList = new ArrayList();
        UsageEvents queryEvents = usageStatsManager.queryEvents(j4, j5);
        while (queryEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            queryEvents.getNextEvent(event);
            if (event.getEventType() == 1) {
                cn.jiguang.common.m.c cVar = new cn.jiguang.common.m.c();
                cVar.f3488a = event.getPackageName();
                arrayList.add(cVar);
            }
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            cn.jiguang.common.m.c cVar2 = (cn.jiguang.common.m.c) arrayList.get(i4);
            String str = cVar2.f3488a;
            if (str.contains("launcher") && i4 > 0) {
                cn.jiguang.common.m.c cVar3 = (cn.jiguang.common.m.c) arrayList.get(i4 - 1);
                String str2 = cVar3.f3488a;
                if (!str2.contains("launcher")) {
                    cVar3.f3490c = hashMap.get(str2) == null ? 1 : hashMap.get(str2).f3490c + 1;
                    hashMap.put(str2, cVar3);
                }
            }
            if (i4 == arrayList.size() - 1 && !str.contains("launcher")) {
                cVar2.f3490c = hashMap.get(str) == null ? 1 : hashMap.get(str).f3490c + 1;
                hashMap.put(str, cVar2);
            }
        }
        arrayList.clear();
    }

    private long b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    @TargetApi(21)
    private boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // cn.jiguang.at.a
    public HashMap<String, cn.jiguang.common.m.c> a(Context context, List<String> list) {
        return a(context);
    }
}
