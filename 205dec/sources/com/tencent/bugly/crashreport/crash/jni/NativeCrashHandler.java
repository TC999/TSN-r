package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NativeCrashHandler implements q {

    /* renamed from: a  reason: collision with root package name */
    static String f50805a = null;

    /* renamed from: b  reason: collision with root package name */
    private static NativeCrashHandler f50806b = null;

    /* renamed from: c  reason: collision with root package name */
    private static int f50807c = 1;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f50808n = true;

    /* renamed from: d  reason: collision with root package name */
    private final Context f50809d;

    /* renamed from: e  reason: collision with root package name */
    private final aa f50810e;

    /* renamed from: f  reason: collision with root package name */
    private final ak f50811f;

    /* renamed from: g  reason: collision with root package name */
    private NativeExceptionHandler f50812g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f50813h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f50814i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f50815j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f50816k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f50817l = false;

    /* renamed from: m  reason: collision with root package name */
    private as f50818m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z3, String str) {
        this.f50809d = ap.a(context);
        if (ap.b(f50805a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).f50824c + "/app_bugly";
            }
            f50805a = str;
        }
        this.f50818m = asVar;
        this.f50810e = aaVar;
        this.f50811f = akVar;
        this.f50813h = z3;
        this.f50812g = new bd(context, aaVar, asVar, ac.a());
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f50805a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z3, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f50806b == null) {
                f50806b = new NativeCrashHandler(context, aaVar, asVar, akVar, z3, str);
            }
            nativeCrashHandler = f50806b;
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f50808n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f50805a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z3) {
        f50808n = z3;
        NativeCrashHandler nativeCrashHandler = f50806b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z3));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f50814i || this.f50815j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f50815j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f50811f.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                int i4;
                if (!ap.a(NativeCrashHandler.this.f50809d, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f50808n) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a4 = be.a(NativeCrashHandler.this.f50809d, NativeCrashHandler.f50805a, NativeCrashHandler.this.f50812g);
                if (a4 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f50818m.a(a4, true)) {
                        NativeCrashHandler.this.f50818m.b(a4, false);
                    }
                    be.a(false, NativeCrashHandler.f50805a);
                }
                final NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long b4 = ap.b() - at.f50992j;
                long b5 = ap.b() + 86400000;
                File file = new File(NativeCrashHandler.f50805a);
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
                            long j4 = 0;
                            int length = listFiles.length;
                            int i5 = 0;
                            int i6 = 0;
                            int i7 = 0;
                            while (i5 < length) {
                                File file2 = listFiles[i5];
                                long lastModified = file2.lastModified();
                                j4 += file2.length();
                                if (lastModified >= b4 && lastModified < b5 && j4 < at.f50991i) {
                                    i4 = length;
                                    i5++;
                                    length = i4;
                                }
                                i4 = length;
                                al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i6++;
                                if (file2.delete()) {
                                    i7++;
                                }
                                i5++;
                                length = i4;
                            }
                            al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i6), Integer.valueOf(i7));
                        }
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
                ap.b(NativeCrashHandler.this.f50809d, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f50807c = 1;
        }
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f50807c |= 2;
        }
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (this.f50814i || this.f50815j) {
            try {
                if (this.f50815j) {
                    return getNativeLog();
                }
                return (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
            } catch (UnsatisfiedLinkError unused) {
                return null;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f50812g;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed\uff0cplease upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.f50815j || this.f50814i) ? getProperties(str) : "fail";
    }

    public boolean isEnableCatchAnrTrace() {
        return (f50807c & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f50817l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z3 = strategyBean.f50746f;
            if (z3 != this.f50816k) {
                al.d("server native changed to %b", Boolean.valueOf(z3));
            }
        }
        boolean z4 = ac.a().c().f50746f && this.f50817l;
        if (z4 != this.f50816k) {
            al.a("native changed to %b", Boolean.valueOf(z4));
            b(z4);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f50814i || this.f50815j) && str != null && str2 != null) {
            try {
                if (this.f50815j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z3, int i4);

    public void removeEmptyNativeRecordFiles() {
        be.c(f50805a);
    }

    protected native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i4, String str);

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z3) {
        return a(14, z3 ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j4) {
        try {
            return a(15, String.valueOf(j4));
        } catch (NumberFormatException e4) {
            if (al.a(e4)) {
                return false;
            }
            e4.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z3) {
        c(z3);
        boolean isUserOpened = isUserOpened();
        ac a4 = ac.a();
        if (a4 != null) {
            isUserOpened = isUserOpened && a4.c().f50746f;
        }
        if (isUserOpened != this.f50816k) {
            al.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f50815j && !this.f50814i) {
            boolean z3 = !ap.b(this.f50810e.f50841t);
            if (at.f50985b) {
                boolean a4 = a(z3 ? this.f50810e.f50841t : "Bugly_Native", z3);
                this.f50815j = a4;
                if (!a4 && !z3) {
                    this.f50814i = a("NativeRQD", false);
                }
            } else {
                String str = "Bugly_Native";
                aa aaVar = this.f50810e;
                String str2 = aaVar.f50841t;
                if (z3) {
                    str = str2;
                } else {
                    aaVar.getClass();
                }
                this.f50815j = a(str, z3);
            }
            if (this.f50815j || this.f50814i) {
                a(this.f50813h);
                setNativeAppVersion(this.f50810e.f50836o);
                setNativeAppChannel(this.f50810e.f50840s);
                setNativeAppPackage(this.f50810e.f50824c);
                setNativeUserId(this.f50810e.f());
                setNativeIsAppForeground(this.f50810e.a());
                setNativeLaunchTime(this.f50810e.f50822a);
                return;
            }
            return;
        }
        a(this.f50813h);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (!this.f50815j) {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void unBlockSigquit(boolean z3) {
        if (z3) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    protected native String unregist();

    private synchronized void c() {
        if (!this.f50816k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f50816k = false;
        } else {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f50816k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    private synchronized void b(boolean z3) {
        if (z3) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    private synchronized void a(boolean z3) {
        if (this.f50816k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f50815j) {
            String regist = regist(f50805a, z3, f50807c);
            if (regist != null) {
                al.a("[Native] Native Crash Report enable.", new Object[0]);
                this.f50810e.f50842u = regist;
                String concat = "-".concat(regist);
                if (!at.f50985b && !this.f50810e.f50829h.contains(concat)) {
                    aa aaVar = this.f50810e;
                    aaVar.f50829h = aaVar.f50829h.concat("-").concat(this.f50810e.f50842u);
                }
                al.a("comInfo.sdkVersion %s", this.f50810e.f50829h);
                this.f50816k = true;
                String runningCpuAbi = getRunningCpuAbi();
                if (!TextUtils.isEmpty(runningCpuAbi)) {
                    this.f50810e.e(runningCpuAbi);
                }
                return;
            }
        } else if (this.f50814i) {
            try {
                Class cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = f50805a;
                objArr[1] = ab.d();
                objArr[2] = Integer.valueOf(z3 ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
                if (str == null) {
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f50805a, ab.d(), Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f50816k = true;
                    this.f50810e.f50842u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z3 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f50810e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.f50815j = false;
        this.f50814i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f50806b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z3, boolean z4, boolean z5) {
        a(16, String.valueOf(z3));
        a(17, String.valueOf(z4));
        a(18, String.valueOf(z5));
        testNativeCrash();
    }

    private synchronized void c(boolean z3) {
        if (this.f50817l != z3) {
            al.a("user change native %b", Boolean.valueOf(z3));
            this.f50817l = z3;
        }
    }

    private static boolean a(String str, boolean z3) {
        boolean z4;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z3) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z4 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z4;
            }
        } catch (Throwable th2) {
            th = th2;
            z4 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i4, String str) {
        if (this.f50815j) {
            try {
                setNativeInfo(i4, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                return false;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
