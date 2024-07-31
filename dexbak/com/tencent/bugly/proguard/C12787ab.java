package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tv.cjump.jni.DeviceUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ab */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12787ab {

    /* renamed from: a */
    private static final ArrayList<AbstractC12790a> f36474a = new ArrayList<AbstractC12790a>() { // from class: com.tencent.bugly.proguard.ab.1
        {
            add(new C12801l((byte) 0));
            add(new C12795f((byte) 0));
            add(new C12796g((byte) 0));
            add(new C12802m((byte) 0));
            add(new C12797h((byte) 0));
            add(new C12798i((byte) 0));
            add(new C12800k((byte) 0));
            add(new C12794e((byte) 0));
            add(new C12799j((byte) 0));
            add(new C12791b((byte) 0));
            add(new C12793d((byte) 0));
            add(new C12792c((byte) 0));
        }
    };

    /* renamed from: b */
    private static final Map<Integer, String> f36475b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.ab.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c */
    private static final String[] f36476c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractC12790a {
        private AbstractC12790a() {
        }

        /* renamed from: a */
        public abstract String mo15951a();

        /* synthetic */ AbstractC12790a(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12791b extends AbstractC12790a {
        private C12791b() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.gn.gnromvernumber");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "amigo/" + m15833a + "/" + C12828ap.m15833a("ro.build.display.id");
        }

        /* synthetic */ C12791b(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12792c extends AbstractC12790a {
        private C12792c() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            return C12828ap.m15833a("ro.build.fingerprint") + "/" + C12828ap.m15833a("ro.build.rom.id");
        }

        /* synthetic */ C12792c(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12793d extends AbstractC12790a {
        private C12793d() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.build.tyd.kbstyle_version");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "dido/".concat(m15833a);
        }

        /* synthetic */ C12793d(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12794e extends AbstractC12790a {
        private C12794e() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.aa.romver");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "htc/" + m15833a + "/" + C12828ap.m15833a("ro.build.description");
        }

        /* synthetic */ C12794e(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12795f extends AbstractC12790a {
        private C12795f() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.build.version.emui");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "HuaWei/EMOTION/".concat(m15833a);
        }

        /* synthetic */ C12795f(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12796g extends AbstractC12790a {
        private C12796g() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.lenovo.series");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "Lenovo/VIBE/".concat(String.valueOf(C12828ap.m15833a("ro.build.version.incremental")));
        }

        /* synthetic */ C12796g(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12797h extends AbstractC12790a {
        private C12797h() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.meizu.product.model");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "Meizu/FLYME/" + C12828ap.m15833a("ro.build.display.id");
        }

        /* synthetic */ C12797h(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$i */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12798i extends AbstractC12790a {
        private C12798i() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.build.version.opporom");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "Oppo/COLOROS/".concat(m15833a);
        }

        /* synthetic */ C12798i(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$j */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12799j extends AbstractC12790a {
        private C12799j() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.lewa.version");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "tcl/" + m15833a + "/" + C12828ap.m15833a("ro.build.display.id");
        }

        /* synthetic */ C12799j(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$k */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12800k extends AbstractC12790a {
        private C12800k() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.vivo.os.build.display.id");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "vivo/FUNTOUCH/".concat(m15833a);
        }

        /* synthetic */ C12800k(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$l */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12801l extends AbstractC12790a {
        private C12801l() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.miui.ui.version.name");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "XiaoMi/MIUI/".concat(m15833a);
        }

        /* synthetic */ C12801l(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ab$m */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12802m extends AbstractC12790a {
        private C12802m() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.C12787ab.AbstractC12790a
        /* renamed from: a */
        public final String mo15951a() {
            String m15833a = C12828ap.m15833a("ro.build.nubia.rom.name");
            if (C12828ap.m15817b(m15833a) || m15833a.equals(CommonNetImpl.FAIL)) {
                return null;
            }
            return "Zte/NUBIA/" + m15833a + "_" + C12828ap.m15833a("ro.build.nubia.rom.code");
        }

        /* synthetic */ C12802m(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static String m15973a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return CommonNetImpl.FAIL;
            }
            th.printStackTrace();
            return CommonNetImpl.FAIL;
        }
    }

    /* renamed from: b */
    public static String m15971b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return CommonNetImpl.FAIL;
            }
            th.printStackTrace();
            return CommonNetImpl.FAIL;
        }
    }

    /* renamed from: c */
    public static int m15969c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: d */
    public static String m15967d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return CommonNetImpl.FAIL;
            }
            th.printStackTrace();
            return CommonNetImpl.FAIL;
        }
    }

    /* renamed from: e */
    public static long m15966e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: f */
    public static long m15965f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0034 -> B:35:0x0046). Please submit an issue!!! */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m15964g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L38
        L13:
            if (r2 == 0) goto L2f
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L2a
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L38
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L38
            goto L2f
        L2a:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L38
            goto L13
        L2f:
            r3.close()     // Catch: java.lang.Throwable -> L33
            goto L46
        L33:
            r2 = move-exception
            r2.printStackTrace()
            goto L46
        L38:
            r2 = move-exception
            goto L3e
        L3a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L3e:
            com.tencent.bugly.proguard.C12820al.m15877a(r2)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.lang.Throwable -> L33
        L46:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L4b:
            r0 = move-exception
            if (r3 == 0) goto L56
            r3.close()     // Catch: java.lang.Throwable -> L52
            goto L56
        L52:
            r1 = move-exception
            r1.printStackTrace()
        L56:
            goto L58
        L57:
            throw r0
        L58:
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12787ab.m15964g():long");
    }

    /* renamed from: h */
    public static long m15963h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /* renamed from: i */
    public static long m15962i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (!C12820al.m15877a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e2) {
                    if (C12820al.m15877a(e2)) {
                        return -1L;
                    }
                    e2.printStackTrace();
                    return -1L;
                }
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                if (!C12820al.m15877a(e3)) {
                    e3.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e4) {
                if (!C12820al.m15877a(e4)) {
                    e4.printStackTrace();
                }
            }
            return parseLong;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        if (!C12820al.m15877a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e6) {
                        if (C12820al.m15877a(e6)) {
                            return -2L;
                        }
                        e6.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        if (!C12820al.m15877a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!C12820al.m15877a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    /* renamed from: j */
    public static long m15961j() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (!C12820al.m15877a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e2) {
                    if (!C12820al.m15877a(e2)) {
                        e2.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!C12820al.m15877a(e3)) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e4) {
                    if (!C12820al.m15877a(e4)) {
                        e4.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    if (!C12820al.m15877a(e5)) {
                        e5.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e6) {
                    if (!C12820al.m15877a(e6)) {
                        e6.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = j + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e7) {
                if (!C12820al.m15877a(e7)) {
                    e7.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e8) {
                if (!C12820al.m15877a(e8)) {
                    e8.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e9) {
                        if (!C12820al.m15877a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e10) {
                        if (C12820al.m15877a(e10)) {
                            return -2L;
                        }
                        e10.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        if (!C12820al.m15877a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e12) {
                        if (!C12820al.m15877a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    /* renamed from: k */
    public static long m15960k() {
        if (m15952s()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (C12820al.m15877a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    /* renamed from: l */
    public static long m15959l() {
        if (m15952s()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (C12820al.m15877a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    /* renamed from: m */
    public static String m15958m() {
        return "";
    }

    /* renamed from: n */
    public static String m15957n() {
        Iterator<AbstractC12790a> it = f36474a.iterator();
        while (it.hasNext()) {
            String mo15951a = it.next().mo15951a();
            if (!TextUtils.isEmpty(mo15951a)) {
                return mo15951a;
            }
        }
        return null;
    }

    /* renamed from: o */
    public static boolean m15956o() {
        return !TextUtils.isEmpty(new C12798i((byte) 0).mo15951a());
    }

    /* renamed from: p */
    public static boolean m15955p() {
        return !TextUtils.isEmpty(new C12800k((byte) 0).mo15951a());
    }

    /* renamed from: q */
    public static boolean m15954q() {
        boolean z;
        String[] strArr = f36476c;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    /* renamed from: r */
    public static boolean m15953r() {
        double maxMemory = Runtime.getRuntime().maxMemory();
        Double.isNaN(maxMemory);
        float f = (float) ((maxMemory * 1.0d) / 1048576.0d);
        double d = Runtime.getRuntime().totalMemory();
        Double.isNaN(d);
        float f2 = (float) ((d * 1.0d) / 1048576.0d);
        float f3 = f - f2;
        C12820al.m15874c("maxMemory : %f", Float.valueOf(f));
        C12820al.m15874c("totalMemory : %f", Float.valueOf(f2));
        C12820al.m15874c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    /* renamed from: s */
    private static boolean m15952s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static String m15972a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return CommonNetImpl.FAIL;
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith(DeviceUtils.f47125a)) {
                return DeviceUtils.f47125a;
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return CommonNetImpl.FAIL;
    }

    /* renamed from: b */
    public static long m15970b(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        if (activityManager != null) {
            pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
            return pss * 1024;
        }
        return 0L;
    }

    /* renamed from: c */
    public static String m15968c(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e = e;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            String str2 = f36475b.get(Integer.valueOf(networkType));
            if (str2 == null) {
                try {
                    str = "MOBILE(" + networkType + ")";
                } catch (Exception e2) {
                    e = e2;
                    str = str2;
                    if (!C12820al.m15877a(e)) {
                        e.printStackTrace();
                    }
                    return str;
                }
            } else {
                str = str2;
            }
        }
        return str;
    }
}
