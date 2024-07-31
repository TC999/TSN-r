package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.clj.fastble.BleManager;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ay */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12859ay {

    /* renamed from: f */
    public static C12859ay f36680f;

    /* renamed from: b */
    public final ActivityManager f36682b;

    /* renamed from: c */
    final C12786aa f36683c;

    /* renamed from: d */
    final C12818ak f36684d;

    /* renamed from: e */
    String f36685e;

    /* renamed from: g */
    private final Context f36686g;

    /* renamed from: h */
    private final C12803ac f36687h;

    /* renamed from: i */
    private final C12832as f36688i;

    /* renamed from: k */
    private FileObserver f36690k;

    /* renamed from: m */
    private C12873bg f36692m;

    /* renamed from: n */
    private int f36693n;

    /* renamed from: a */
    public final AtomicBoolean f36681a = new AtomicBoolean(false);

    /* renamed from: j */
    private final Object f36689j = new Object();

    /* renamed from: l */
    private boolean f36691l = true;

    /* renamed from: o */
    private long f36694o = 0;

    public C12859ay(Context context, C12803ac c12803ac, C12786aa c12786aa, C12818ak c12818ak, C12832as c12832as) {
        Context m15844a = C12828ap.m15844a(context);
        this.f36686g = m15844a;
        this.f36682b = (ActivityManager) m15844a.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (C12828ap.m15817b(NativeCrashHandler.getDumpFilePath())) {
            this.f36685e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f36685e = NativeCrashHandler.getDumpFilePath();
        }
        this.f36683c = c12786aa;
        this.f36684d = c12818ak;
        this.f36687h = c12803ac;
        this.f36688i = c12832as;
    }

    /* renamed from: c */
    private synchronized void m15708c() {
        if (m15704e()) {
            C12820al.m15873d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/") { // from class: com.tencent.bugly.proguard.ay.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str == null) {
                    return;
                }
                final String concat = "/data/anr/".concat(str);
                C12820al.m15873d("watching file %s", concat);
                if (!concat.contains("trace")) {
                    C12820al.m15873d("not anr file %s", concat);
                } else {
                    C12859ay.this.f36684d.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C12859ay c12859ay = C12859ay.this;
                            String str2 = concat;
                            if (c12859ay.m15711a(true)) {
                                try {
                                    C12820al.m15874c("read trace first dump for create time!", new Object[0]);
                                    TraceFileHelper.C12779a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str2, false);
                                    long j = readFirstDumpInfo != null ? readFirstDumpInfo.f36374c : -1L;
                                    if (j == -1) {
                                        C12820al.m15873d("trace dump fail could not get time!", new Object[0]);
                                        j = System.currentTimeMillis();
                                    }
                                    if (c12859ay.m15718a(j)) {
                                        return;
                                    }
                                    c12859ay.m15717a(j, str2);
                                } catch (Throwable th) {
                                    if (!C12820al.m15877a(th)) {
                                        th.printStackTrace();
                                    }
                                    C12820al.m15872e("handle anr error %s", th.getClass().toString());
                                }
                            }
                        }
                    });
                }
            }
        };
        this.f36690k = fileObserver;
        fileObserver.startWatching();
        C12820al.m15878a("start anr monitor!", new Object[0]);
        this.f36684d.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.2
            @Override // java.lang.Runnable
            public final void run() {
                C12859ay.m15715a(C12859ay.this);
            }
        });
    }

    /* renamed from: d */
    private synchronized void m15706d() {
        if (!m15704e()) {
            C12820al.m15873d("close when closed!", new Object[0]);
            return;
        }
        this.f36690k.stopWatching();
        this.f36690k = null;
        C12820al.m15873d("close anr monitor!", new Object[0]);
    }

    /* renamed from: e */
    private synchronized boolean m15704e() {
        return this.f36690k != null;
    }

    /* renamed from: f */
    private synchronized boolean m15703f() {
        return this.f36691l;
    }

    /* renamed from: g */
    private synchronized void m15702g() {
        if (m15704e()) {
            C12820al.m15873d("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f36685e)) {
        } else {
            synchronized (this.f36689j) {
                C12873bg c12873bg = this.f36692m;
                if (c12873bg == null || !c12873bg.isAlive()) {
                    C12873bg c12873bg2 = new C12873bg();
                    this.f36692m = c12873bg2;
                    boolean z = this.f36683c.f36417S;
                    c12873bg2.f36732b = z;
                    C12820al.m15874c("set record stack trace enable:".concat(String.valueOf(z)), new Object[0]);
                    C12873bg c12873bg3 = this.f36692m;
                    StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                    int i = this.f36693n;
                    this.f36693n = i + 1;
                    sb.append(i);
                    c12873bg3.setName(sb.toString());
                    this.f36692m.m15672b();
                }
            }
            FileObserver fileObserver = new FileObserver(this.f36685e) { // from class: com.tencent.bugly.proguard.ay.3
                @Override // android.os.FileObserver
                public final void onEvent(int i2, String str) {
                    if (str == null) {
                        return;
                    }
                    boolean z2 = true;
                    C12820al.m15873d("observe file, dir:%s fileName:%s", C12859ay.this.f36685e, str);
                    if (!((str.startsWith("manual_bugly_trace_") && str.endsWith(".txt")) ? false : false)) {
                        C12820al.m15874c("not manual trace file, ignore.", new Object[0]);
                    } else if (!C12859ay.this.f36681a.get()) {
                        C12820al.m15874c("proc is not in anr, just ignore", new Object[0]);
                    } else if (C12859ay.this.f36683c.m16011a()) {
                        C12820al.m15874c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                        long m15868a = C12821am.m15868a(str, "manual_bugly_trace_", ".txt");
                        C12859ay c12859ay = C12859ay.this;
                        c12859ay.m15717a(m15868a, C12859ay.this.f36685e + "/" + str);
                        C12820al.m15874c("Finish handling one anr.", new Object[0]);
                    } else {
                        C12820al.m15874c("Found background anr, resend sigquit later.", new Object[0]);
                        long m15868a2 = C12821am.m15868a(str, "manual_bugly_trace_", ".txt");
                        C12859ay c12859ay2 = C12859ay.this;
                        c12859ay2.m15717a(m15868a2, C12859ay.this.f36685e + "/" + str);
                        C12820al.m15874c("Finish handling one anr, now resend sigquit.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                    }
                }
            };
            this.f36690k = fileObserver;
            fileObserver.startWatching();
            C12820al.m15878a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f36685e);
            this.f36684d.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.4
                @Override // java.lang.Runnable
                public final void run() {
                    C12859ay.m15715a(C12859ay.this);
                }
            });
        }
    }

    /* renamed from: h */
    private synchronized void m15701h() {
        if (!m15704e()) {
            C12820al.m15873d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f36689j) {
            C12873bg c12873bg = this.f36692m;
            if (c12873bg != null) {
                c12873bg.m15674a();
                this.f36692m = null;
            }
        }
        C12820al.m15878a("stopWatchingPrivateAnrDir", new Object[0]);
        this.f36690k.stopWatching();
        this.f36690k = null;
        C12820al.m15873d("close anr monitor!", new Object[0]);
    }

    /* renamed from: b */
    public final void m15709b(boolean z) {
        m15705d(z);
        boolean m15703f = m15703f();
        C12803ac m15950a = C12803ac.m15950a();
        if (m15950a != null) {
            m15703f = m15703f && m15950a.m15941c().f36296f;
        }
        if (m15703f != m15704e()) {
            C12820al.m15878a("anr changed to %b", Boolean.valueOf(m15703f));
            m15707c(m15703f);
        }
    }

    /* renamed from: a */
    public static synchronized C12859ay m15719a() {
        C12859ay c12859ay;
        synchronized (C12859ay.class) {
            c12859ay = f36680f;
        }
        return c12859ay;
    }

    /* renamed from: a */
    private CrashDetailBean m15716a(C12858ax c12858ax) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f36316C = C12787ab.m15961j();
            crashDetailBean.f36317D = C12787ab.m15965f();
            crashDetailBean.f36318E = C12787ab.m15959l();
            crashDetailBean.f36319F = this.f36683c.m15989k();
            crashDetailBean.f36320G = this.f36683c.m15990j();
            crashDetailBean.f36321H = this.f36683c.m15988l();
            crashDetailBean.f36322I = C12787ab.m15970b(this.f36686g);
            crashDetailBean.f36323J = C12787ab.m15964g();
            crashDetailBean.f36324K = C12787ab.m15963h();
            crashDetailBean.f36342b = 3;
            crashDetailBean.f36345e = this.f36683c.m15994g();
            C12786aa c12786aa = this.f36683c;
            crashDetailBean.f36346f = c12786aa.f36462o;
            crashDetailBean.f36347g = c12786aa.m15983q();
            crashDetailBean.f36353m = this.f36683c.m15996f();
            crashDetailBean.f36354n = "ANR_EXCEPTION";
            crashDetailBean.f36355o = c12858ax.f36678f;
            crashDetailBean.f36357q = c12858ax.f36679g;
            HashMap hashMap = new HashMap();
            crashDetailBean.f36333T = hashMap;
            hashMap.put("BUGLY_CR_01", c12858ax.f36677e);
            String str = crashDetailBean.f36357q;
            int indexOf = str != null ? str.indexOf(ShellAdbUtils.f33810d) : -1;
            crashDetailBean.f36356p = indexOf > 0 ? crashDetailBean.f36357q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f36358r = c12858ax.f36675c;
            String str2 = crashDetailBean.f36357q;
            if (str2 != null) {
                crashDetailBean.f36361u = C12828ap.m15810c(str2.getBytes());
            }
            crashDetailBean.f36366z = c12858ax.f36674b;
            crashDetailBean.f36314A = c12858ax.f36673a;
            crashDetailBean.f36315B = "main(1)";
            crashDetailBean.f36325L = this.f36683c.m15981s();
            crashDetailBean.f36348h = this.f36683c.m15984p();
            crashDetailBean.f36349i = this.f36683c.m16018A();
            crashDetailBean.f36362v = c12858ax.f36676d;
            C12786aa c12786aa2 = this.f36683c;
            crashDetailBean.f36329P = c12786aa2.f36468u;
            crashDetailBean.f36330Q = c12786aa2.f36424a;
            crashDetailBean.f36331R = c12786aa2.m16011a();
            crashDetailBean.f36334U = this.f36683c.m15974z();
            C12786aa c12786aa3 = this.f36683c;
            crashDetailBean.f36335V = c12786aa3.f36471x;
            crashDetailBean.f36336W = c12786aa3.m15980t();
            crashDetailBean.f36337X = this.f36683c.m15975y();
            crashDetailBean.f36365y = C12824ao.m15864a();
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: b */
    public final synchronized void m15710b() {
        C12820al.m15873d("customer decides whether to open or close.", new Object[0]);
    }

    /* renamed from: d */
    private synchronized void m15705d(boolean z) {
        if (this.f36691l != z) {
            C12820al.m15878a("user change anr %b", Boolean.valueOf(z));
            this.f36691l = z;
        }
    }

    /* renamed from: c */
    private synchronized void m15707c(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                m15708c();
            } else {
                m15706d();
            }
        } else if (z) {
            m15702g();
        } else {
            m15701h();
        }
    }

    /* renamed from: a */
    private static boolean m15713a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.C12779a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f36375d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.f36375d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append(ShellAdbUtils.f33810d);
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f36375d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append(ShellAdbUtils.f33810d);
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return C12821am.m15869a(str2, sb.toString(), sb.length() * 2);
        }
        C12820al.m15872e("not found trace dump for %s", str3);
        return false;
    }

    /* renamed from: a */
    private static String m15712a(List<C12867ba> list, long j) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
        sb.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i = 0; i < list.size(); i++) {
            C12867ba c12867ba = list.get(i);
            sb.append("Thread name:");
            sb.append(c12867ba.f36701a);
            sb.append(ShellAdbUtils.f33810d);
            long j2 = c12867ba.f36702b - j;
            String str = j2 <= 0 ? "before " : "after ";
            sb.append("Got ");
            sb.append(str);
            sb.append("anr:");
            sb.append(Math.abs(j2));
            sb.append("ms\n");
            sb.append(c12867ba.f36703c);
            sb.append(ShellAdbUtils.f33810d);
            if (sb.length() * 2 >= 101376) {
                break;
            }
        }
        sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb.toString();
    }

    /* renamed from: a */
    public final boolean m15711a(boolean z) {
        boolean compareAndSet = this.f36681a.compareAndSet(!z, z);
        C12820al.m15874c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a A[Catch: all -> 0x01f8, TRY_LEAVE, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[Catch: all -> 0x01f8, TRY_ENTER, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019d A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01dd A[Catch: all -> 0x01f2, TRY_ENTER, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:13:0x004f, B:18:0x0059, B:21:0x0069, B:24:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:34:0x00d6, B:36:0x00f5, B:39:0x0102, B:41:0x012b, B:43:0x0159, B:44:0x015c, B:50:0x016a, B:51:0x017b, B:57:0x018c, B:59:0x019d, B:61:0x01ac, B:65:0x01ca, B:67:0x01d0, B:68:0x01d5, B:69:0x01dc, B:60:0x01a5, B:42:0x0143, B:56:0x0185, B:33:0x00d2, B:22:0x0072, B:70:0x01dd, B:72:0x01e1, B:73:0x01ed, B:45:0x015d, B:47:0x0161, B:48:0x0167, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:91:0x0007 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m15717a(long r19, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12859ay.m15717a(long, java.lang.String):void");
    }

    /* renamed from: a */
    public final boolean m15718a(long j) {
        if (Math.abs(j - this.f36694o) < 10000) {
            C12820al.m15873d("should not process ANR too Fre in %dms", Integer.valueOf((int) BleManager.f22896l));
            return true;
        }
        this.f36694o = j;
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m15715a(C12859ay c12859ay) {
        long currentTimeMillis = (C12848at.f36619j + System.currentTimeMillis()) - C12828ap.m15823b();
        C12821am.m15867a(c12859ay.f36685e, "bugly_trace_", ".txt", currentTimeMillis);
        C12821am.m15867a(c12859ay.f36685e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        C12821am.m15867a(c12859ay.f36685e, "main_stack_record_", ".txt", currentTimeMillis);
        C12821am.m15867a(c12859ay.f36685e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }
}
