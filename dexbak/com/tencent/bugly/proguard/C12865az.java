package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.az */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12865az {
    /* renamed from: a */
    public static ActivityManager.ProcessErrorStateInfo m15700a(ActivityManager activityManager, long j) {
        if (activityManager == null) {
            C12820al.m15874c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        C12820al.m15874c("get anr state, timeout:%d", Long.valueOf(j));
        long j2 = j / 500;
        int i = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo m15698a = m15698a(activityManager.getProcessesInErrorState());
            if (m15698a == null) {
                C12820al.m15874c("found proc state is null", new Object[0]);
            } else {
                int i2 = m15698a.condition;
                if (i2 == 2) {
                    C12820al.m15874c("found proc state is anr! proc:%s", m15698a.processName);
                    return m15698a;
                } else if (i2 == 1) {
                    C12820al.m15874c("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i3 = i + 1;
            if (i < j2) {
                C12820al.m15874c("try the %s times:", Integer.valueOf(i3));
                C12828ap.m15822b(500L);
                i = i3;
            } else {
                return m15699a("Find process anr, but unable to get anr message.");
            }
        }
    }

    /* renamed from: a */
    private static ActivityManager.ProcessErrorStateInfo m15698a(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list != null && !list.isEmpty()) {
            int myPid = Process.myPid();
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
                if (processErrorStateInfo.pid == myPid) {
                    if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                        return null;
                    }
                    C12820al.m15874c("found current proc in the error state", new Object[0]);
                    return processErrorStateInfo;
                }
            }
            C12820al.m15874c("current proc not in the error state", new Object[0]);
            return null;
        }
        C12820al.m15874c("error state info list is null", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static ActivityManager.ProcessErrorStateInfo m15699a(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = C12924z.m15478a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }
}
