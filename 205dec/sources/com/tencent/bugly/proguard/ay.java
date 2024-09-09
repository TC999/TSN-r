package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ay {

    /* renamed from: f  reason: collision with root package name */
    public static ay f51050f;

    /* renamed from: b  reason: collision with root package name */
    public final ActivityManager f51052b;

    /* renamed from: c  reason: collision with root package name */
    final aa f51053c;

    /* renamed from: d  reason: collision with root package name */
    final ak f51054d;

    /* renamed from: e  reason: collision with root package name */
    String f51055e;

    /* renamed from: g  reason: collision with root package name */
    private final Context f51056g;

    /* renamed from: h  reason: collision with root package name */
    private final ac f51057h;

    /* renamed from: i  reason: collision with root package name */
    private final as f51058i;

    /* renamed from: k  reason: collision with root package name */
    private FileObserver f51060k;

    /* renamed from: m  reason: collision with root package name */
    private bg f51062m;

    /* renamed from: n  reason: collision with root package name */
    private int f51063n;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f51051a = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final Object f51059j = new Object();

    /* renamed from: l  reason: collision with root package name */
    private boolean f51061l = true;

    /* renamed from: o  reason: collision with root package name */
    private long f51064o = 0;

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a4 = ap.a(context);
        this.f51056g = a4;
        this.f51052b = (ActivityManager) a4.getSystemService("activity");
        if (ap.b(NativeCrashHandler.getDumpFilePath())) {
            this.f51055e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f51055e = NativeCrashHandler.getDumpFilePath();
        }
        this.f51053c = aaVar;
        this.f51054d = akVar;
        this.f51057h = acVar;
        this.f51058i = asVar;
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/") { // from class: com.tencent.bugly.proguard.ay.1
            @Override // android.os.FileObserver
            public final void onEvent(int i4, String str) {
                if (str == null) {
                    return;
                }
                final String concat = "/data/anr/".concat(str);
                al.d("watching file %s", concat);
                if (!concat.contains("trace")) {
                    al.d("not anr file %s", concat);
                } else {
                    ay.this.f51054d.a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ay ayVar = ay.this;
                            String str2 = concat;
                            if (ayVar.a(true)) {
                                try {
                                    al.c("read trace first dump for create time!", new Object[0]);
                                    TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str2, false);
                                    long j4 = readFirstDumpInfo != null ? readFirstDumpInfo.f50798c : -1L;
                                    if (j4 == -1) {
                                        al.d("trace dump fail could not get time!", new Object[0]);
                                        j4 = System.currentTimeMillis();
                                    }
                                    if (ayVar.a(j4)) {
                                        return;
                                    }
                                    ayVar.a(j4, str2);
                                } catch (Throwable th) {
                                    if (!al.a(th)) {
                                        th.printStackTrace();
                                    }
                                    al.e("handle anr error %s", th.getClass().toString());
                                }
                            }
                        }
                    });
                }
            }
        };
        this.f51060k = fileObserver;
        fileObserver.startWatching();
        al.a("start anr monitor!", new Object[0]);
        this.f51054d.a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.2
            @Override // java.lang.Runnable
            public final void run() {
                ay.a(ay.this);
            }
        });
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        this.f51060k.stopWatching();
        this.f51060k = null;
        al.d("close anr monitor!", new Object[0]);
    }

    private synchronized boolean e() {
        return this.f51060k != null;
    }

    private synchronized boolean f() {
        return this.f51061l;
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f51055e)) {
        } else {
            synchronized (this.f51059j) {
                bg bgVar = this.f51062m;
                if (bgVar == null || !bgVar.isAlive()) {
                    bg bgVar2 = new bg();
                    this.f51062m = bgVar2;
                    boolean z3 = this.f51053c.S;
                    bgVar2.f51102b = z3;
                    al.c("set record stack trace enable:".concat(String.valueOf(z3)), new Object[0]);
                    bg bgVar3 = this.f51062m;
                    StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                    int i4 = this.f51063n;
                    this.f51063n = i4 + 1;
                    sb.append(i4);
                    bgVar3.setName(sb.toString());
                    this.f51062m.b();
                }
            }
            FileObserver fileObserver = new FileObserver(this.f51055e) { // from class: com.tencent.bugly.proguard.ay.3
                @Override // android.os.FileObserver
                public final void onEvent(int i5, String str) {
                    if (str == null) {
                        return;
                    }
                    boolean z4 = true;
                    al.d("observe file, dir:%s fileName:%s", ay.this.f51055e, str);
                    if (!((str.startsWith("manual_bugly_trace_") && str.endsWith(".txt")) ? false : false)) {
                        al.c("not manual trace file, ignore.", new Object[0]);
                    } else if (!ay.this.f51051a.get()) {
                        al.c("proc is not in anr, just ignore", new Object[0]);
                    } else if (ay.this.f51053c.a()) {
                        al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                        long a4 = am.a(str, "manual_bugly_trace_", ".txt");
                        ay ayVar = ay.this;
                        ayVar.a(a4, ay.this.f51055e + TTPathConst.sSeparator + str);
                        al.c("Finish handling one anr.", new Object[0]);
                    } else {
                        al.c("Found background anr, resend sigquit later.", new Object[0]);
                        long a5 = am.a(str, "manual_bugly_trace_", ".txt");
                        ay ayVar2 = ay.this;
                        ayVar2.a(a5, ay.this.f51055e + TTPathConst.sSeparator + str);
                        al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                    }
                }
            };
            this.f51060k = fileObserver;
            fileObserver.startWatching();
            al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f51055e);
            this.f51054d.a(new Runnable() { // from class: com.tencent.bugly.proguard.ay.4
                @Override // java.lang.Runnable
                public final void run() {
                    ay.a(ay.this);
                }
            });
        }
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f51059j) {
            bg bgVar = this.f51062m;
            if (bgVar != null) {
                bgVar.a();
                this.f51062m = null;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        this.f51060k.stopWatching();
        this.f51060k = null;
        al.d("close anr monitor!", new Object[0]);
    }

    public final void b(boolean z3) {
        d(z3);
        boolean f4 = f();
        ac a4 = ac.a();
        if (a4 != null) {
            f4 = f4 && a4.c().f50746f;
        }
        if (f4 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(f4));
            c(f4);
        }
    }

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f51050f;
        }
        return ayVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.f51053c.k();
            crashDetailBean.G = this.f51053c.j();
            crashDetailBean.H = this.f51053c.l();
            crashDetailBean.I = ab.b(this.f51056g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f50766b = 3;
            crashDetailBean.f50769e = this.f51053c.g();
            aa aaVar = this.f51053c;
            crashDetailBean.f50770f = aaVar.f50836o;
            crashDetailBean.f50771g = aaVar.q();
            crashDetailBean.f50777m = this.f51053c.f();
            crashDetailBean.f50778n = "ANR_EXCEPTION";
            crashDetailBean.f50779o = axVar.f51048f;
            crashDetailBean.f50781q = axVar.f51049g;
            HashMap hashMap = new HashMap();
            crashDetailBean.T = hashMap;
            hashMap.put("BUGLY_CR_01", axVar.f51047e);
            String str = crashDetailBean.f50781q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f50780p = indexOf > 0 ? crashDetailBean.f50781q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f50782r = axVar.f51045c;
            String str2 = crashDetailBean.f50781q;
            if (str2 != null) {
                crashDetailBean.f50785u = ap.c(str2.getBytes());
            }
            crashDetailBean.f50790z = axVar.f51044b;
            crashDetailBean.A = axVar.f51043a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.f50764L = this.f51053c.s();
            crashDetailBean.f50772h = this.f51053c.p();
            crashDetailBean.f50773i = this.f51053c.A();
            crashDetailBean.f50786v = axVar.f51046d;
            aa aaVar2 = this.f51053c;
            crashDetailBean.P = aaVar2.f50842u;
            crashDetailBean.Q = aaVar2.f50822a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = this.f51053c.z();
            aa aaVar3 = this.f51053c;
            crashDetailBean.V = aaVar3.f50845x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f51053c.y();
            crashDetailBean.f50789y = ao.a();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    private synchronized void d(boolean z3) {
        if (this.f51061l != z3) {
            al.a("user change anr %b", Boolean.valueOf(z3));
            this.f51061l = z3;
        }
    }

    private synchronized void c(boolean z3) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z3) {
                c();
            } else {
                d();
            }
        } else if (z3) {
            g();
        } else {
            h();
        }
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f50799d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.f50799d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append("\n");
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f50799d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append("\n");
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return am.a(str2, sb.toString(), sb.length() * 2);
        }
        al.e("not found trace dump for %s", str3);
        return false;
    }

    private static String a(List<ba> list, long j4) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append("\n>>>>> \u4ee5\u4e0b\u4e3aanr\u8fc7\u7a0b\u4e2d\u4e3b\u7ebf\u7a0b\u5806\u6808\u8bb0\u5f55\uff0c\u53ef\u6839\u636e\u5806\u6808\u51fa\u73b0\u6b21\u6570\u63a8\u6d4b\u5728\u8be5\u5806\u6808\u963b\u585e\u7684\u65f6\u95f4\uff0c\u51fa\u73b0\u6b21\u6570\u8d8a\u591a\u5bf9anr\u8d21\u732e\u8d8a\u5927\uff0c\u8d8a\u53ef\u80fd\u662f\u9020\u6210anr\u7684\u539f\u56e0 >>>>>\n");
        sb.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i4 = 0; i4 < list.size(); i4++) {
            ba baVar = list.get(i4);
            sb.append("Thread name:");
            sb.append(baVar.f51071a);
            sb.append("\n");
            long j5 = baVar.f51072b - j4;
            String str = j5 <= 0 ? "before " : "after ";
            sb.append("Got ");
            sb.append(str);
            sb.append("anr:");
            sb.append(Math.abs(j5));
            sb.append("ms\n");
            sb.append(baVar.f51073c);
            sb.append("\n");
            if (sb.length() * 2 >= 101376) {
                break;
            }
        }
        sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb.toString();
    }

    public final boolean a(boolean z3) {
        boolean compareAndSet = this.f51051a.compareAndSet(!z3, z3);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z3), Boolean.valueOf(compareAndSet));
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r19, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ay.a(long, java.lang.String):void");
    }

    public final boolean a(long j4) {
        if (Math.abs(j4 - this.f51064o) < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f51064o = j4;
        return false;
    }

    static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (at.f50992j + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.f51055e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f51055e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f51055e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.f51055e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }
}
