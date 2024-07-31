package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.handler.AbstractC10685b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.report.upload.C10731d;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.utils.C11104m;
import com.kwad.sdk.utils.C11122q;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10715d {
    protected String mErrorMessage = "";
    protected InterfaceC10717e mUploader;

    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    private static void m25042b(File file, @Nullable CountDownLatch countDownLatch) {
        C10731d.m25016a(file, true, countDownLatch);
    }

    /* renamed from: fC */
    private static String m25041fC(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: C */
    public final void m25048C(File file) {
        C10331c.m26254d("AdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                m25044a(file2, (CountDownLatch) null);
            }
        }
    }

    /* renamed from: a */
    protected abstract ExceptionMessage mo25035a(@NonNull File file, File file2, File file3, String str);

    /* renamed from: a */
    public final void m25046a(InterfaceC10717e interfaceC10717e) {
        this.mUploader = interfaceC10717e;
    }

    /* renamed from: a */
    public final void m25044a(File file, @Nullable CountDownLatch countDownLatch) {
        File[] listFiles;
        String m24964fG = C10745g.m24964fG(file.getPath());
        File file2 = new File(m24964fG + ".msg");
        File file3 = new File(m24964fG + ".log");
        File file4 = new File(m24964fG + ".blog");
        File file5 = new File(m24964fG + ".jtrace");
        File file6 = new File(m24964fG + ".minfo");
        ArrayList<File> arrayList = new ArrayList();
        try {
            ExceptionMessage mo25035a = mo25035a(file, file2, file3, m24964fG);
            if (mo25035a == null) {
                try {
                    C11122q.delete(file.getPath());
                    C11122q.delete(file3.getPath());
                    C11122q.delete(file4.getPath());
                    C11122q.delete(file2.getPath());
                    C11122q.delete(file5.getPath());
                    C11122q.delete(file6.getPath());
                    for (File file7 : arrayList) {
                        C11122q.delete(file7.getPath());
                    }
                    C10745g.m24995F(AbstractC10685b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                    return;
                }
            }
            C10331c.m26254d("AdExceptionCollector", "message.mCrashSource=" + mo25035a.mCrashSource);
            if (mo25035a.mCrashSource == 2) {
                try {
                    C11122q.delete(file.getPath());
                    C11122q.delete(file3.getPath());
                    C11122q.delete(file4.getPath());
                    C11122q.delete(file2.getPath());
                    C11122q.delete(file5.getPath());
                    C11122q.delete(file6.getPath());
                    for (File file8 : arrayList) {
                        C11122q.delete(file8.getPath());
                    }
                    C10745g.m24995F(AbstractC10685b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    C10331c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.mo25039a(mo25035a, countDownLatch);
            if (this instanceof C10718f) {
                C10331c.m26254d("AdExceptionCollector", " java crash 不上传文件");
                try {
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
            C10745g.m24996E(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (!it.next().exists()) {
                    it.remove();
                }
            }
            File file9 = new File(file.getParentFile().getParent(), "custom");
            if (file9.exists()) {
                for (File file10 : file9.listFiles()) {
                    if (!file10.isDirectory() && (file10.getName().startsWith(mo25035a.mLogUUID) || file10.getName().startsWith(m25041fC(mo25035a.mLogUUID)))) {
                        arrayList.add(file10);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            m25047a(mo25035a, arrayList2, countDownLatch);
            try {
                C11122q.delete(file.getPath());
                C11122q.delete(file3.getPath());
                C11122q.delete(file4.getPath());
                C11122q.delete(file2.getPath());
                C11122q.delete(file5.getPath());
                C11122q.delete(file6.getPath());
                for (File file11 : arrayList) {
                    C11122q.delete(file11.getPath());
                }
                C10745g.m24995F(AbstractC10685b.sBackupDir);
            } catch (Throwable th4) {
                C10331c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                C10331c.printStackTraceOnly(th5);
                C10745g.m24959r(th5);
                try {
                    C11122q.delete(file.getPath());
                    C11122q.delete(file3.getPath());
                    C11122q.delete(file4.getPath());
                    C11122q.delete(file2.getPath());
                    C11122q.delete(file5.getPath());
                    C11122q.delete(file6.getPath());
                    for (File file12 : arrayList) {
                        C11122q.delete(file12.getPath());
                    }
                    C10745g.m24995F(AbstractC10685b.sBackupDir);
                } catch (Throwable th6) {
                    C10331c.printStackTraceOnly(th6);
                }
            } finally {
                try {
                    C11122q.delete(file.getPath());
                    C11122q.delete(file3.getPath());
                    C11122q.delete(file4.getPath());
                    C11122q.delete(file2.getPath());
                    C11122q.delete(file5.getPath());
                    C11122q.delete(file6.getPath());
                    for (File file13 : arrayList) {
                        C11122q.delete(file13.getPath());
                    }
                    C10745g.m24995F(AbstractC10685b.sBackupDir);
                } catch (Throwable th32) {
                    C10331c.printStackTraceOnly(th32);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m25043b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb2 = new StringBuilder();
                                            sb2.append(readLine);
                                            sb2.append(ShellAdbUtils.f33810d);
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(exceptionMessage.mLockInfo);
                                            sb2.append(readLine);
                                            sb2.append(ShellAdbUtils.f33810d);
                                        }
                                        exceptionMessage.mLockInfo = sb2.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            sb3 = new StringBuilder();
                                            sb3.append(readLine);
                                            sb3.append(ShellAdbUtils.f33810d);
                                        } else {
                                            sb3 = new StringBuilder();
                                            sb3.append(exceptionMessage.mMonitorInfo);
                                            sb3.append(readLine);
                                            sb3.append(ShellAdbUtils.f33810d);
                                        }
                                        exceptionMessage.mMonitorInfo = sb3.toString();
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            sb4 = new StringBuilder();
                                            sb4.append(readLine);
                                            sb4.append(ShellAdbUtils.f33810d);
                                        } else {
                                            sb4 = new StringBuilder();
                                            sb4.append(exceptionMessage.mSlowLooper);
                                            sb4.append(readLine);
                                            sb4.append(ShellAdbUtils.f33810d);
                                        }
                                        exceptionMessage.mSlowLooper = sb4.toString();
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            sb5 = new StringBuilder();
                                            sb5.append(readLine);
                                            sb5.append(ShellAdbUtils.f33810d);
                                        } else {
                                            sb5 = new StringBuilder();
                                            sb5.append(exceptionMessage.mSlowOperation);
                                            sb5.append(readLine);
                                            sb5.append(ShellAdbUtils.f33810d);
                                        }
                                        exceptionMessage.mSlowOperation = sb5.toString();
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb = new StringBuilder();
                                    sb.append(readLine);
                                    sb.append(ShellAdbUtils.f33810d);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(exceptionMessage.mGCInfo);
                                    sb.append(readLine);
                                    sb.append(ShellAdbUtils.f33810d);
                                }
                                exceptionMessage.mGCInfo = sb.toString();
                            }
                        } else {
                            C10738b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + ShellAdbUtils.f33810d;
                        C10738b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + ShellAdbUtils.f33810d;
                        C10738b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C10738b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private void m25047a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        C10331c.m26254d("AdExceptionCollector", "compressAndUpload");
        File mo25040Hp = this.mUploader.mo25040Hp();
        if (!mo25040Hp.exists()) {
            mo25040Hp.mkdir();
        }
        File file = new File(mo25040Hp, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        C10331c.m26254d("AdExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        C11104m.m23771a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            m25042b(file, countDownLatch);
            return;
        }
        C11122q.m23741S(file);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m25045a(File file, ExceptionMessage exceptionMessage) {
        String readLine;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else {
                                if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                                    threadInfo.mName = readLine;
                                }
                                if (threadInfo.mTrace == null) {
                                    str = readLine;
                                } else {
                                    str = threadInfo.mTrace + readLine;
                                }
                                threadInfo.mTrace = str;
                                threadInfo.mTrace += "#";
                            }
                        }
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        C10738b.closeQuietly(bufferedReader2);
                        bufferedReader = readLine;
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        C10331c.printStackTraceOnly(e);
                        C10738b.closeQuietly(bufferedReader);
                        bufferedReader = bufferedReader;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C10738b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            C10331c.printStackTraceOnly(e3);
        }
    }
}
