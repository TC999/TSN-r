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
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.s;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {
    private static final String TAG = "g";
    private static final File aHO = new File("/proc/self/fd");
    private static final File aHP = new File("/proc/self/task");

    private g() {
    }

    public static void E(File file) {
        try {
            d.a(SystemUtil.ed(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-b", AVErrorInfo.CRASH, "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    public static void F(File file) {
        if (file == null) {
            return;
        }
        try {
            q.T(file);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    public static void G(File file) {
        try {
            q.P(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b4 = b(entry.getValue());
                            if (b4.isEmpty()) {
                                b4 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(b4);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e5) {
                        e = e5;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e8);
        }
    }

    public static void H(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = s.getField(s.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.ed(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.ed(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.ed(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.ed(19)) {
                Boolean bool5 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.ed(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            s.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.Hu().getContext())});
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    private static int If() {
        File[] listFiles;
        File file = aHO;
        ap.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void a(ExceptionMessage exceptionMessage, int i4) {
        com.kwad.sdk.crash.h HA = com.kwad.sdk.crash.e.Hu().HA();
        if (HA == null) {
            com.kwad.sdk.core.e.c.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = HA.nb().toString();
        }
    }

    private static String aj(@NonNull String str, String str2) {
        ap.gH(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    private static double aw(long j4) {
        return BigDecimal.valueOf(((float) (j4 >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String bx(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString("task_id");
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return "";
        } catch (JSONException e5) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e5);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String by(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.Hu().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + bz(context) + "\n");
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
        return sb.toString();
    }

    private static String bz(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i4 = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            sb.append(sb2.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i4++;
                sb.append("\nClassLoader " + i4 + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + fI(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static void d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            q.P(file);
            q.P(file2);
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
                            } catch (FileNotFoundException e4) {
                                e = e4;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e5) {
                                e = e5;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e6) {
                        e = e6;
                    } catch (IOException e7) {
                        e = e7;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                    bufferedReader = null;
                } catch (IOException e9) {
                    e = e9;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e10) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e10);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.Hu().Hx();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.Hu().getSdkVersion();
    }

    public static String fG(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String fH(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long fI(String str) {
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

    private static String fJ(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList<String> arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        for (String str3 : arrayList) {
            sb.append(str3);
            sb.append("\n");
        }
        return sb.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean q(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String r(Throwable th) {
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    f.a(th, printWriter);
                    th2 = stringWriter.toString();
                    b.closeQuietly(stringWriter);
                } catch (Exception e4) {
                    e = e4;
                    printWriter = stringWriter;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    b.closeQuietly(printWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = stringWriter;
                    b.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return th2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
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
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.Hu().HB();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.Hu().Hy()));
        exceptionMessage.mBuildConfigInfo = by(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bx(context);
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String r3 = r(th);
        if (th instanceof StackOverflowError) {
            r3 = fJ(r3);
        }
        exceptionMessage.mCrashDetail = r3.replaceAll("[\n\t]", "#");
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.aFE.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.aFF.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.aFG.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aFH.matcher(absolutePath);
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

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (q(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a MR = SystemUtil.MR();
        MR.aQr = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        MR.aQn = SystemUtil.MQ();
        long pss = Debug.getPss();
        MR.aQq = pss;
        memoryInfo.mTotalMB = (int) (MR.aQn / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aFD / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (MR.aQr / 1048576);
        memoryInfo.mVssMB = (int) (MR.aQo / 1024);
        memoryInfo.mRssMB = (int) (MR.aQp / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = MR.mThreadsCount;
        memoryInfo.mFdCount = If();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.cV(context) / 1048576);
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
                    } catch (Exception e4) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (MR.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z3 = (bVar.aGf & 2) != 0 && com.kwad.framework.a.a.adI.booleanValue();
        String str = TAG;
        com.kwad.sdk.core.e.c.d(str, "isNativeOpen:" + z3);
        return z3;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = aHP.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.I(new File(file, "comm"));
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = aj(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aw(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
                diskInfo.mDataAvailableGB = aw(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aw(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aw(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        String readLine;
        try {
            q.P(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e4) {
                                e = e4;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e5) {
                                e = e5;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e6) {
                    e = e6;
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e8);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z3) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z3) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z3);
    }

    private static void a(File file, String str, Charset charset, boolean z3) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = q.a(file, z3);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                return false;
            }
        }
        return true;
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i4) {
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

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z3 = true;
        z3 = ((bVar.aGf & 1) == 0 || !com.kwad.framework.a.a.adD.booleanValue()) ? false : false;
        String str = TAG;
        com.kwad.sdk.core.e.c.d(str, "isAnrOpen:" + z3);
        return z3;
    }
}
