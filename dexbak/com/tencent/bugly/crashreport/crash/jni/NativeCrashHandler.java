package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C12786aa;
import com.tencent.bugly.proguard.C12787ab;
import com.tencent.bugly.proguard.C12803ac;
import com.tencent.bugly.proguard.C12818ak;
import com.tencent.bugly.proguard.C12820al;
import com.tencent.bugly.proguard.C12828ap;
import com.tencent.bugly.proguard.C12832as;
import com.tencent.bugly.proguard.C12848at;
import com.tencent.bugly.proguard.C12870bd;
import com.tencent.bugly.proguard.C12871be;
import com.tencent.bugly.proguard.InterfaceC12905q;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeCrashHandler implements InterfaceC12905q {

    /* renamed from: a */
    static String f36381a = null;

    /* renamed from: b */
    private static NativeCrashHandler f36382b = null;

    /* renamed from: c */
    private static int f36383c = 1;

    /* renamed from: n */
    private static boolean f36384n = true;

    /* renamed from: d */
    private final Context f36385d;

    /* renamed from: e */
    private final C12786aa f36386e;

    /* renamed from: f */
    private final C12818ak f36387f;

    /* renamed from: g */
    private NativeExceptionHandler f36388g;

    /* renamed from: h */
    private final boolean f36389h;

    /* renamed from: i */
    private boolean f36390i = false;

    /* renamed from: j */
    private boolean f36391j = false;

    /* renamed from: k */
    private boolean f36392k = false;

    /* renamed from: l */
    private boolean f36393l = false;

    /* renamed from: m */
    private C12832as f36394m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, C12786aa c12786aa, C12832as c12832as, C12818ak c12818ak, boolean z, String str) {
        this.f36385d = C12828ap.m15844a(context);
        if (C12828ap.m15817b(f36381a)) {
            try {
                if (C12828ap.m15817b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + C12786aa.m16009a(context).f36450c + "/app_bugly";
            }
            f36381a = str;
        }
        this.f36394m = c12832as;
        this.f36386e = c12786aa;
        this.f36387f = c12818ak;
        this.f36389h = z;
        this.f36388g = new C12870bd(context, c12786aa, c12832as, C12803ac.m15950a());
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f36381a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C12786aa c12786aa, C12832as c12832as, C12803ac c12803ac, C12818ak c12818ak, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f36382b == null) {
                f36382b = new NativeCrashHandler(context, c12786aa, c12832as, c12818ak, z, str);
            }
            nativeCrashHandler = f36382b;
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f36384n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f36381a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z) {
        f36384n = z;
        NativeCrashHandler nativeCrashHandler = f36382b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.m16030a(999, String.valueOf(z));
        }
    }

    @Override // com.tencent.bugly.proguard.InterfaceC12905q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f36390i || this.f36391j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f36391j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f36387f.m15886a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                if (!C12828ap.m15843a(NativeCrashHandler.this.f36385d, "native_record_lock")) {
                    C12820al.m15878a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f36384n) {
                    NativeCrashHandler.this.m16030a(999, "false");
                }
                CrashDetailBean m15694a = C12871be.m15694a(NativeCrashHandler.this.f36385d, NativeCrashHandler.f36381a, NativeCrashHandler.this.f36388g);
                if (m15694a != null) {
                    C12820al.m15878a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f36394m.m15789a(m15694a, true)) {
                        NativeCrashHandler.this.f36394m.m15768b(m15694a, false);
                    }
                    C12871be.m15686a(false, NativeCrashHandler.f36381a);
                }
                final NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long m15823b = C12828ap.m15823b() - C12848at.f36619j;
                long m15823b2 = C12828ap.m15823b() + 86400000;
                File file = new File(NativeCrashHandler.f36381a);
                if (file.exists() && file.isDirectory()) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.2
                                @Override // java.util.Comparator
                                public final /* synthetic */ int compare(File file2, File file3) {
                                    return (file3.lastModified() > file2.lastModified() ? 1 : (file3.lastModified() == file2.lastModified() ? 0 : -1));
                                }
                            });
                            long j = 0;
                            int length = listFiles.length;
                            int i2 = 0;
                            int i3 = 0;
                            int i4 = 0;
                            while (i2 < length) {
                                File file2 = listFiles[i2];
                                long lastModified = file2.lastModified();
                                j += file2.length();
                                if (lastModified >= m15823b && lastModified < m15823b2 && j < C12848at.f36618i) {
                                    i = length;
                                    i2++;
                                    length = i;
                                }
                                i = length;
                                C12820al.m15878a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i3++;
                                if (file2.delete()) {
                                    i4++;
                                }
                                i2++;
                                length = i;
                            }
                            C12820al.m15874c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i3), Integer.valueOf(i4));
                        }
                    } catch (Throwable th) {
                        C12820al.m15877a(th);
                    }
                }
                C12828ap.m15821b(NativeCrashHandler.this.f36385d, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f36383c = 1;
        }
    }

    public void dumpAnrNativeStack() {
        m16030a(19, "1");
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f36383c |= 2;
        }
    }

    public boolean filterSigabrtSysLog() {
        return m16030a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.InterfaceC12905q
    public String getLogFromNative() {
        if (this.f36390i || this.f36391j) {
            try {
                if (this.f36391j) {
                    return getNativeLog();
                }
                return (String) C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
            } catch (UnsatisfiedLinkError unused) {
                return null;
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f36388g;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            C12820al.m15873d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.f36391j || this.f36390i) ? getProperties(str) : CommonNetImpl.FAIL;
    }

    public boolean isEnableCatchAnrTrace() {
        return (f36383c & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f36393l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f36296f;
            if (z != this.f36392k) {
                C12820al.m15873d("server native changed to %b", Boolean.valueOf(z));
            }
        }
        boolean z2 = C12803ac.m15950a().m15941c().f36296f && this.f36393l;
        if (z2 != this.f36392k) {
            C12820al.m15878a("native changed to %b", Boolean.valueOf(z2));
            m16023b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f36390i || this.f36391j) && str != null && str2 != null) {
            try {
                if (this.f36391j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        C12871be.m15682c(f36381a);
    }

    protected native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        m16030a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return m16030a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m16030a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return m16030a(10, str);
    }

    protected native void setNativeInfo(int i, String str);

    @Override // com.tencent.bugly.proguard.InterfaceC12905q
    public boolean setNativeIsAppForeground(boolean z) {
        return m16030a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return m16030a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (C12820al.m15877a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return m16030a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        m16020c(z);
        boolean isUserOpened = isUserOpened();
        C12803ac m15950a = C12803ac.m15950a();
        if (m15950a != null) {
            isUserOpened = isUserOpened && m15950a.m15941c().f36296f;
        }
        if (isUserOpened != this.f36392k) {
            C12820al.m15878a("native changed to %b", Boolean.valueOf(isUserOpened));
            m16023b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f36391j && !this.f36390i) {
            boolean z = !C12828ap.m15817b(this.f36386e.f36467t);
            if (C12848at.f36612b) {
                boolean m16027a = m16027a(z ? this.f36386e.f36467t : "Bugly_Native", z);
                this.f36391j = m16027a;
                if (!m16027a && !z) {
                    this.f36390i = m16027a("NativeRQD", false);
                }
            } else {
                String str = "Bugly_Native";
                C12786aa c12786aa = this.f36386e;
                String str2 = c12786aa.f36467t;
                if (z) {
                    str = str2;
                } else {
                    c12786aa.getClass();
                }
                this.f36391j = m16027a(str, z);
            }
            if (this.f36391j || this.f36390i) {
                m16026a(this.f36389h);
                setNativeAppVersion(this.f36386e.f36462o);
                setNativeAppChannel(this.f36386e.f36466s);
                setNativeAppPackage(this.f36386e.f36450c);
                setNativeUserId(this.f36386e.m15996f());
                setNativeIsAppForeground(this.f36386e.m16011a());
                setNativeLaunchTime(this.f36386e.f36424a);
                return;
            }
            return;
        }
        m16026a(this.f36389h);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (!this.f36391j) {
            C12820al.m15873d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void unBlockSigquit(boolean z) {
        if (z) {
            m16030a(21, "true");
        } else {
            m16030a(21, "false");
        }
    }

    protected native String unregist();

    /* renamed from: c */
    private synchronized void m16022c() {
        if (!this.f36392k) {
            C12820al.m15873d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            C12820al.m15878a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f36392k = false;
        } else {
            C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f36392k = false;
            C12820al.m15878a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    /* renamed from: b */
    private synchronized void m16023b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m16022c();
        }
    }

    /* renamed from: a */
    private synchronized void m16026a(boolean z) {
        if (this.f36392k) {
            C12820al.m15873d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f36391j) {
            String regist = regist(f36381a, z, f36383c);
            if (regist != null) {
                C12820al.m15878a("[Native] Native Crash Report enable.", new Object[0]);
                this.f36386e.f36468u = regist;
                String concat = "-".concat(regist);
                if (!C12848at.f36612b && !this.f36386e.f36455h.contains(concat)) {
                    C12786aa c12786aa = this.f36386e;
                    c12786aa.f36455h = c12786aa.f36455h.concat("-").concat(this.f36386e.f36468u);
                }
                C12820al.m15878a("comInfo.sdkVersion %s", this.f36386e.f36455h);
                this.f36392k = true;
                String runningCpuAbi = getRunningCpuAbi();
                if (!TextUtils.isEmpty(runningCpuAbi)) {
                    this.f36386e.m15997e(runningCpuAbi);
                }
                return;
            }
        } else if (this.f36390i) {
            try {
                Class cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = f36381a;
                objArr[1] = C12787ab.m15967d();
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
                if (str == null) {
                    C12786aa.m16005b();
                    str = (String) C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f36381a, C12787ab.m15967d(), Integer.valueOf(C12786aa.m16017B())});
                }
                if (str != null) {
                    this.f36392k = true;
                    this.f36386e.f36468u = str;
                    C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    C12828ap.m15830a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f36386e.m15997e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.f36391j = false;
        this.f36390i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f36382b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        m16030a(16, String.valueOf(z));
        m16030a(17, String.valueOf(z2));
        m16030a(18, String.valueOf(z3));
        testNativeCrash();
    }

    /* renamed from: c */
    private synchronized void m16020c(boolean z) {
        if (this.f36393l != z) {
            C12820al.m15878a("user change native %b", Boolean.valueOf(z));
            this.f36393l = z;
        }
    }

    /* renamed from: a */
    private static boolean m16027a(String str, boolean z) {
        boolean z2;
        try {
            C12820al.m15878a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C12820al.m15878a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                C12820al.m15873d(th.getMessage(), new Object[0]);
                C12820al.m15873d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16030a(int i, String str) {
        if (this.f36391j) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                return false;
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
