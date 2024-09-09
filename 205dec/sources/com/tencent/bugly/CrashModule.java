package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* renamed from: c  reason: collision with root package name */
    private static int f50711c;

    /* renamed from: e  reason: collision with root package name */
    private static CrashModule f50712e = new CrashModule();

    /* renamed from: a  reason: collision with root package name */
    private long f50713a;

    /* renamed from: b  reason: collision with root package name */
    private BuglyStrategy.a f50714b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f50715d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            aa.a(context).f50841t = libBuglySOFilePath;
            al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f50714b = buglyStrategy.getCrashHandleCallback();
            al.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f50713a = appReportDelay;
            al.a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f50712e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f50715d;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0033, B:11:0x0055, B:14:0x0066, B:16:0x0078, B:18:0x007f, B:21:0x0086, B:24:0x0096, B:27:0x009d, B:30:0x00ad, B:32:0x00b5, B:34:0x00bc, B:28:0x00a8, B:22:0x0091, B:12:0x005b, B:13:0x0061), top: B:42:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0033, B:11:0x0055, B:14:0x0066, B:16:0x0078, B:18:0x007f, B:21:0x0086, B:24:0x0096, B:27:0x009d, B:30:0x00ad, B:32:0x00b5, B:34:0x00bc, B:28:0x00a8, B:22:0x0091, B:12:0x005b, B:13:0x0061), top: B:42:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    @Override // com.tencent.bugly.proguard.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.BuglyStrategy r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto Le4
            boolean r0 = r4.f50715d     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L9
            goto Le4
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.u r0 = com.tencent.bugly.proguard.u.a()     // Catch: java.lang.Throwable -> Le1
            int r2 = com.tencent.bugly.CrashModule.f50711c     // Catch: java.lang.Throwable -> Le1
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f50711c = r2     // Catch: java.lang.Throwable -> Le1
            r0.a(r2)     // Catch: java.lang.Throwable -> Le1
            r4.f50715d = r3     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.crashreport.CrashReport.setContext(r5)     // Catch: java.lang.Throwable -> Le1
            r4.a(r5, r7)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.BuglyStrategy$a r0 = r4.f50714b     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.at r6 = com.tencent.bugly.proguard.at.a(r5, r6, r0)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.av r0 = r6.f51003t     // Catch: java.lang.Throwable -> Le1
            r0.a()     // Catch: java.lang.Throwable -> Le1
            if (r7 == 0) goto L61
            int r0 = r7.getCallBackType()     // Catch: java.lang.Throwable -> Le1
            r6.B = r0     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Le1
            r6.C = r0     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.isUploadSpotCrash()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.at.f50997o = r0     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a(r5)     // Catch: java.lang.Throwable -> Le1
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch: java.lang.Throwable -> Le1
            r0.S = r2     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            if (r0 != 0) goto L5b
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f51004u     // Catch: java.lang.Throwable -> Le1
            r0.disableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            goto L66
        L5b:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f51004u     // Catch: java.lang.Throwable -> Le1
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            goto L66
        L61:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f51004u     // Catch: java.lang.Throwable -> Le1
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
        L66:
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.b()     // Catch: java.lang.Throwable -> Le1
            java.lang.String r0 = r0.f50825d     // Catch: java.lang.Throwable -> Le1
            android.content.Context r2 = r6.f51001c     // Catch: java.lang.Throwable -> Le1
            java.lang.String r2 = com.tencent.bugly.proguard.z.a(r2)     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L7d
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f51004u     // Catch: java.lang.Throwable -> Le1
            r0.removeEmptyNativeRecordFiles()     // Catch: java.lang.Throwable -> Le1
        L7d:
            if (r7 == 0) goto L91
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L86
            goto L91
        L86:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> Le1
            r6.d()     // Catch: java.lang.Throwable -> Le1
            goto L94
        L91:
            r6.e()     // Catch: java.lang.Throwable -> Le1
        L94:
            if (r7 == 0) goto La8
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L9d
            goto La8
        L9d:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.al.a(r0, r1)     // Catch: java.lang.Throwable -> Le1
            r6.g()     // Catch: java.lang.Throwable -> Le1
            goto Lab
        La8:
            r6.f()     // Catch: java.lang.Throwable -> Le1
        Lab:
            if (r7 == 0) goto Lb3
            boolean r0 = r7.isMerged()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.at.f50987e = r0     // Catch: java.lang.Throwable -> Le1
        Lb3:
            if (r7 == 0) goto Lba
            long r0 = r7.getAppReportDelay()     // Catch: java.lang.Throwable -> Le1
            goto Lbc
        Lba:
            r0 = 0
        Lbc:
            r6.a(r0)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r6 = r6.f51004u     // Catch: java.lang.Throwable -> Le1
            r6.checkUploadRecordCrash()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.au.a(r5)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.aq r6 = com.tencent.bugly.proguard.aq.a()     // Catch: java.lang.Throwable -> Le1
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.a(r7)     // Catch: java.lang.Throwable -> Le1
            r6.a(r5)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.u r5 = com.tencent.bugly.proguard.u.a()     // Catch: java.lang.Throwable -> Le1
            int r6 = com.tencent.bugly.CrashModule.f50711c     // Catch: java.lang.Throwable -> Le1
            int r6 = r6 - r3
            com.tencent.bugly.CrashModule.f50711c = r6     // Catch: java.lang.Throwable -> Le1
            r5.a(r6)     // Catch: java.lang.Throwable -> Le1
            monitor-exit(r4)
            return
        Le1:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        Le4:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a4;
        if (strategyBean == null || (a4 = at.a()) == null) {
            return;
        }
        a4.f51003t.a(strategyBean);
        a4.f51004u.onStrategyChanged(strategyBean);
        a4.f51007x.b();
    }
}
