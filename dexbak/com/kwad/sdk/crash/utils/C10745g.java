package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10670d;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.InterfaceC10677h;
import com.kwad.sdk.crash.model.C10691b;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.report.InterfaceC10717e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.C11023ap;
import com.kwad.sdk.utils.C11122q;
import com.kwad.sdk.utils.C11124s;
import com.kwad.sdk.utils.SystemUtil;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.umeng.analytics.pro.UContent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.utils.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10745g {
    private static final String TAG = "g";
    private static final File aHO = new File("/proc/self/fd");
    private static final File aHP = new File("/proc/self/task");

    private C10745g() {
    }

    /* renamed from: E */
    public static void m24996E(File file) {
        try {
            C10740d.m25005a(SystemUtil.m24267ed(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", ConstantHelper.LOG_OS, "-b", UContent.f38134ax, "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", ConstantHelper.LOG_OS, "-b", UContent.f38134ax, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: F */
    public static void m24995F(File file) {
        if (file == null) {
            return;
        }
        try {
            C11122q.m23740T(file);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: G */
    public static void m24994G(File file) {
        try {
            C11122q.m23744P(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String m24970b = m24970b(entry.getValue());
                            if (m24970b.isEmpty()) {
                                m24970b = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(m24970b);
                            bufferedWriter2.newLine();
                        }
                        C10738b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        C10331c.printStackTraceOnly(e);
                        C10738b.closeQuietly(bufferedWriter);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        C10331c.printStackTraceOnly(e);
                        C10738b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        C10738b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            C10331c.printStackTraceOnly(e5);
        }
    }

    /* renamed from: H */
    public static void m24993H(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = C11124s.getField(C11124s.m23705a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.m24267ed(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.m24267ed(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                C11124s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.m24267ed(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                C11124s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.m24267ed(19)) {
                Boolean bool5 = Boolean.TRUE;
                C11124s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.m24267ed(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            C11124s.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(C10671e.m25134Hu().getContext())});
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: If */
    private static int m24992If() {
        File[] listFiles;
        File file = aHO;
        C11023ap.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    /* renamed from: a */
    public static void m24990a(ExceptionMessage exceptionMessage, int i) {
        InterfaceC10677h m25136HA = C10671e.m25134Hu().m25136HA();
        if (m25136HA == null) {
            C10331c.m26254d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = m25136HA.mo25114nb().toString();
        }
    }

    /* renamed from: aj */
    private static String m24976aj(@NonNull String str, String str2) {
        C11023ap.m24086gH(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    /* renamed from: aw */
    private static double m24975aw(long j) {
        return BigDecimal.valueOf(((float) (j >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    /* renamed from: b */
    public static void m24971b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            m24972b(th, exceptionMessage);
        }
        m24989a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        m24986a(exceptionMessage, memoryInfo, context);
        m24988a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            m24987a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            m24978a(th, exceptionMessage);
        }
    }

    /* renamed from: bx */
    private static String m24969bx(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(C10747h.m24942d(inputStream)).getString("task_id");
        } catch (IOException e) {
            C10331c.printStackTraceOnly(e);
            return "";
        } catch (JSONException e2) {
            C10331c.printStackTraceOnly(e2);
            return "";
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return "";
        } finally {
            C10738b.closeQuietly(inputStream);
        }
    }

    /* renamed from: by */
    private static String m24968by(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + C10671e.m25134Hu().getSdkVersion() + ShellAdbUtils.f33810d);
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + ShellAdbUtils.f33810d);
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + ShellAdbUtils.f33810d);
            sb.append("DexPath: " + m24967bz(context) + ShellAdbUtils.f33810d);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        return sb.toString();
    }

    /* renamed from: bz */
    private static String m24967bz(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            sb.append(sb2.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i++;
                sb.append("\nClassLoader " + i + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + m24962fI(split[1]));
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static void m24966d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            C11122q.m23744P(file);
            C11122q.m23744P(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                C10331c.printStackTraceOnly(e);
                                C10738b.closeQuietly(bufferedWriter);
                                C10738b.closeQuietly(bufferedReader);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                C10331c.printStackTraceOnly(e);
                                C10738b.closeQuietly(bufferedWriter);
                                C10738b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                C10738b.closeQuietly(bufferedWriter);
                                C10738b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        C10738b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader = null;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                C10738b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e7) {
            C10331c.printStackTraceOnly(e7);
        }
    }

    /* renamed from: e */
    private static void m24965e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = C10671e.m25134Hu().m25131Hx();
        exceptionMessage.mVersionCode = C10671e.m25134Hu().getSdkVersion();
    }

    /* renamed from: fG */
    public static String m24964fG(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    /* renamed from: fH */
    public static String m24963fH(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    /* renamed from: fI */
    private static long m24962fI(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* renamed from: fJ */
    private static String m24961fJ(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split(ShellAdbUtils.f33810d)) {
            hashSet.add(str2);
        }
        ArrayList<String> arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        for (String str3 : arrayList) {
            sb.append(str3);
            sb.append(ShellAdbUtils.f33810d);
        }
        return sb.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    /* renamed from: q */
    private static boolean m24960q(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r */
    public static String m24959r(Throwable th) {
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    C10742f.m24998a(th, printWriter);
                    th2 = stringWriter.toString();
                    C10738b.closeQuietly(stringWriter);
                } catch (Exception e) {
                    e = e;
                    printWriter = stringWriter;
                    C10331c.printStackTraceOnly(e);
                    C10738b.closeQuietly(printWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = stringWriter;
                    C10738b.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return th2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    private static void m24989a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = C10671e.m25134Hu().m25135HB();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", C10671e.m25134Hu().m25130Hy()));
        exceptionMessage.mBuildConfigInfo = m24968by(context);
        m24965e(exceptionMessage);
        m24973b(exceptionMessage, context);
        exceptionMessage.mTaskId = m24969bx(context);
    }

    /* renamed from: b */
    private static void m24972b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String m24959r = m24959r(th);
        if (th instanceof StackOverflowError) {
            m24959r = m24961fJ(m24959r);
        }
        exceptionMessage.mCrashDetail = m24959r.replaceAll("[\n\t]", "#");
    }

    /* renamed from: b */
    private static void m24973b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            C10331c.printStackTraceOnly(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!C10670d.aFE.matcher(absolutePath).matches() && !C10670d.aFF.matcher(absolutePath).matches()) {
            Matcher matcher = C10670d.aFG.matcher(absolutePath);
            Matcher matcher2 = C10670d.aFH.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    /* renamed from: a */
    private static void m24978a(Throwable th, ExceptionMessage exceptionMessage) {
        if (m24960q(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    /* renamed from: a */
    private static void m24986a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.C10976a m24272MR = SystemUtil.m24272MR();
        m24272MR.aQr = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        m24272MR.aQn = SystemUtil.m24273MQ();
        long pss = Debug.getPss();
        m24272MR.aQq = pss;
        memoryInfo.mTotalMB = (int) (m24272MR.aQn / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (C10670d.aFD / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (m24272MR.aQr / 1048576);
        memoryInfo.mVssMB = (int) (m24272MR.aQo / 1024);
        memoryInfo.mRssMB = (int) (m24272MR.aQp / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = m24272MR.mThreadsCount;
        memoryInfo.mFdCount = m24992If();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.m24268cV(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = aHO.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            memoryInfo.mFds.add(Os.readlink(file.getPath()));
                        } else {
                            memoryInfo.mFds.add(file.getCanonicalPath());
                        }
                    } catch (Exception e) {
                        C10331c.printStackTraceOnly(e);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (m24272MR.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            m24985a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                /* renamed from: a */
                private static int m24958a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return m24958a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    /* renamed from: b */
    private static String m24970b(StackTraceElement[] stackTraceElementArr) {
        return m24977a(stackTraceElementArr, 0);
    }

    /* renamed from: b */
    public static boolean m24974b(C10691b c10691b) {
        boolean z = (c10691b.aGf & 2) != 0 && C9425a.adI.booleanValue();
        String str = TAG;
        C10331c.m26254d(str, "isNativeOpen:" + z);
        return z;
    }

    /* renamed from: a */
    private static void m24985a(MemoryInfo memoryInfo) {
        File[] listFiles = aHP.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = C10747h.m24957I(new File(file, "comm"));
            } catch (IOException e) {
                C10331c.printStackTraceOnly(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = m24976aj(threadInfo.mName, ShellAdbUtils.f33810d);
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    /* renamed from: a */
    private static void m24987a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    /* renamed from: a */
    private static void m24988a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = m24975aw(C10747h.getTotalBytes(path));
            if (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(1024L)) {
                diskInfo.mDataAvailableGB = m24975aw(C10747h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = m24975aw(C10747h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = m24975aw(C10747h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    /* renamed from: a */
    public static void m24984a(InterfaceC10717e interfaceC10717e, String str, File file) {
        String readLine;
        try {
            C11122q.m23744P(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (interfaceC10717e != null) {
                        do {
                            try {
                                readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                C10331c.printStackTraceOnly(e);
                                C10738b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                C10331c.printStackTraceOnly(e);
                                C10738b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                C10738b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    C10738b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            C10331c.printStackTraceOnly(e5);
        }
    }

    /* renamed from: a */
    public static void m24983a(File file, CharSequence charSequence) {
        m24982a(file, charSequence, Charset.defaultCharset(), false);
    }

    /* renamed from: a */
    public static void m24981a(File file, CharSequence charSequence, boolean z) {
        m24982a(file, charSequence, Charset.defaultCharset(), true);
    }

    /* renamed from: a */
    private static void m24982a(File file, CharSequence charSequence, Charset charset, boolean z) {
        m24980a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    /* renamed from: a */
    private static void m24980a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = C11122q.m23728a(file, z);
            C10747h.m24946a(str, fileOutputStream, charset);
            m24979a(fileOutputStream);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        } finally {
            C10738b.closeQuietly(fileOutputStream);
        }
    }

    /* renamed from: a */
    private static boolean m24979a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e) {
                C10331c.printStackTraceOnly(e);
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m24977a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    /* renamed from: a */
    public static boolean m24991a(C10691b c10691b) {
        boolean z = true;
        z = ((c10691b.aGf & 1) == 0 || !C9425a.adD.booleanValue()) ? false : false;
        String str = TAG;
        C10331c.m26254d(str, "isAnrOpen:" + z);
        return z;
    }
}
