package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC12903o;
import com.tencent.bugly.proguard.C12786aa;
import com.tencent.bugly.proguard.C12820al;
import com.tencent.bugly.proguard.C12848at;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CrashModule extends AbstractC12903o {
    public static final int MODULE_ID = 1004;

    /* renamed from: c */
    private static int f36261c;

    /* renamed from: e */
    private static CrashModule f36262e = new CrashModule();

    /* renamed from: a */
    private long f36263a;

    /* renamed from: b */
    private BUGLY.C12768a f36264b;

    /* renamed from: d */
    private boolean f36265d = false;

    /* renamed from: a */
    private synchronized void m16050a(Context context, BUGLY bugly) {
        if (bugly == null) {
            return;
        }
        String libBuglySOFilePath = bugly.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            C12786aa.m16009a(context).f36467t = libBuglySOFilePath;
            C12820al.m15878a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (bugly.getCrashHandleCallback() != null) {
            this.f36264b = bugly.getCrashHandleCallback();
            C12820al.m15878a("setted CrashHanldeCallback", new Object[0]);
        }
        if (bugly.getAppReportDelay() > 0) {
            long appReportDelay = bugly.getAppReportDelay();
            this.f36263a = appReportDelay;
            C12820al.m15878a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f36262e;
        crashModule.f36889id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.AbstractC12903o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f36265d;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0033, B:11:0x0055, B:14:0x0066, B:16:0x0078, B:18:0x007f, B:21:0x0086, B:24:0x0096, B:27:0x009d, B:30:0x00ad, B:32:0x00b5, B:34:0x00bc, B:28:0x00a8, B:22:0x0091, B:12:0x005b, B:13:0x0061), top: B:42:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0033, B:11:0x0055, B:14:0x0066, B:16:0x0078, B:18:0x007f, B:21:0x0086, B:24:0x0096, B:27:0x009d, B:30:0x00ad, B:32:0x00b5, B:34:0x00bc, B:28:0x00a8, B:22:0x0091, B:12:0x005b, B:13:0x0061), top: B:42:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    @Override // com.tencent.bugly.proguard.AbstractC12903o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.BUGLY r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto Le4
            boolean r0 = r4.f36265d     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L9
            goto Le4
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12820al.m15878a(r0, r2)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.u r0 = com.tencent.bugly.proguard.C12916u.m15524a()     // Catch: java.lang.Throwable -> Le1
            int r2 = com.tencent.bugly.CrashModule.f36261c     // Catch: java.lang.Throwable -> Le1
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f36261c = r2     // Catch: java.lang.Throwable -> Le1
            r0.m15523a(r2)     // Catch: java.lang.Throwable -> Le1
            r4.f36265d = r3     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.crashreport.CrashReport.setContext(r5)     // Catch: java.lang.Throwable -> Le1
            r4.m16050a(r5, r7)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.BuglyStrategy$a r0 = r4.f36264b     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.at r6 = com.tencent.bugly.proguard.C12848at.m15753a(r5, r6, r0)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.av r0 = r6.f36633t     // Catch: java.lang.Throwable -> Le1
            r0.m15733a()     // Catch: java.lang.Throwable -> Le1
            if (r7 == 0) goto L61
            int r0 = r7.getCallBackType()     // Catch: java.lang.Throwable -> Le1
            r6.f36629B = r0     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Le1
            r6.f36630C = r0     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.isUploadSpotCrash()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12848at.f36624o = r0     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.C12786aa.m16009a(r5)     // Catch: java.lang.Throwable -> Le1
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch: java.lang.Throwable -> Le1
            r0.f36417S = r2     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            if (r0 != 0) goto L5b
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f36634u     // Catch: java.lang.Throwable -> Le1
            r0.disableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            goto L66
        L5b:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f36634u     // Catch: java.lang.Throwable -> Le1
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
            goto L66
        L61:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f36634u     // Catch: java.lang.Throwable -> Le1
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> Le1
        L66:
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.C12786aa.m16005b()     // Catch: java.lang.Throwable -> Le1
            java.lang.String r0 = r0.f36451d     // Catch: java.lang.Throwable -> Le1
            android.content.Context r2 = r6.f36631c     // Catch: java.lang.Throwable -> Le1
            java.lang.String r2 = com.tencent.bugly.proguard.C12924z.m15476a(r2)     // Catch: java.lang.Throwable -> Le1
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L7d
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.f36634u     // Catch: java.lang.Throwable -> Le1
            r0.removeEmptyNativeRecordFiles()     // Catch: java.lang.Throwable -> Le1
        L7d:
            if (r7 == 0) goto L91
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L86
            goto L91
        L86:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12820al.m15878a(r0, r2)     // Catch: java.lang.Throwable -> Le1
            r6.m15746d()     // Catch: java.lang.Throwable -> Le1
            goto L94
        L91:
            r6.m15745e()     // Catch: java.lang.Throwable -> Le1
        L94:
            if (r7 == 0) goto La8
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> Le1
            if (r0 == 0) goto L9d
            goto La8
        L9d:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12820al.m15878a(r0, r1)     // Catch: java.lang.Throwable -> Le1
            r6.m15743g()     // Catch: java.lang.Throwable -> Le1
            goto Lab
        La8:
            r6.m15744f()     // Catch: java.lang.Throwable -> Le1
        Lab:
            if (r7 == 0) goto Lb3
            boolean r0 = r7.isMerged()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12848at.f36614e = r0     // Catch: java.lang.Throwable -> Le1
        Lb3:
            if (r7 == 0) goto Lba
            long r0 = r7.getAppReportDelay()     // Catch: java.lang.Throwable -> Le1
            goto Lbc
        Lba:
            r0 = 0
        Lbc:
            r6.m15754a(r0)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r6 = r6.f36634u     // Catch: java.lang.Throwable -> Le1
            r6.checkUploadRecordCrash()     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.C12853au.m15737a(r5)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.aq r6 = com.tencent.bugly.proguard.C12829aq.m15806a()     // Catch: java.lang.Throwable -> Le1
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.m15802a(r7)     // Catch: java.lang.Throwable -> Le1
            r6.m15805a(r5)     // Catch: java.lang.Throwable -> Le1
            com.tencent.bugly.proguard.u r5 = com.tencent.bugly.proguard.C12916u.m15524a()     // Catch: java.lang.Throwable -> Le1
            int r6 = com.tencent.bugly.CrashModule.f36261c     // Catch: java.lang.Throwable -> Le1
            int r6 = r6 - r3
            com.tencent.bugly.CrashModule.f36261c = r6     // Catch: java.lang.Throwable -> Le1
            r5.m15523a(r6)     // Catch: java.lang.Throwable -> Le1
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

    @Override // com.tencent.bugly.proguard.AbstractC12903o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        C12848at m15755a;
        if (strategyBean == null || (m15755a = C12848at.m15755a()) == null) {
            return;
        }
        m15755a.f36633t.m15732a(strategyBean);
        m15755a.f36634u.onStrategyChanged(strategyBean);
        m15755a.f36637x.m15710b();
    }
}
