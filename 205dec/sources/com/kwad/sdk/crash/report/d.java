package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d {
    protected String mErrorMessage = "";
    protected e mUploader;

    @SuppressLint({"CheckResult"})
    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String fC(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    @SuppressLint({"CheckResult"})
    public final void C(File file) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    protected abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        File[] listFiles;
        String fG = com.kwad.sdk.crash.utils.g.fG(file.getPath());
        File file2 = new File(fG + ".msg");
        File file3 = new File(fG + ".log");
        File file4 = new File(fG + ".blog");
        File file5 = new File(fG + ".jtrace");
        File file6 = new File(fG + ".minfo");
        ArrayList<File> arrayList = new ArrayList();
        try {
            ExceptionMessage a4 = a(file, file2, file3, fG);
            if (a4 == null) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file7 : arrayList) {
                        q.delete(file7.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "message.mCrashSource=" + a4.mCrashSource);
            if (a4.mCrashSource == 2) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file8 : arrayList) {
                        q.delete(file8.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a4, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", " java crash \u4e0d\u4e0a\u4f20\u6587\u4ef6");
                try {
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.E(file4);
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
                    if (!file10.isDirectory() && (file10.getName().startsWith(a4.mLogUUID) || file10.getName().startsWith(fC(a4.mLogUUID)))) {
                        arrayList.add(file10);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(a4, arrayList2, countDownLatch);
            try {
                q.delete(file.getPath());
                q.delete(file3.getPath());
                q.delete(file4.getPath());
                q.delete(file2.getPath());
                q.delete(file5.getPath());
                q.delete(file6.getPath());
                for (File file11 : arrayList) {
                    q.delete(file11.getPath());
                }
                com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.r(th5);
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file12 : arrayList) {
                        q.delete(file12.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th6);
                }
            } finally {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file13 : arrayList) {
                        q.delete(file13.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th32) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th32);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z3 = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z3 && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z3 = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb2 = new StringBuilder();
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(exceptionMessage.mLockInfo);
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        }
                                        exceptionMessage.mLockInfo = sb2.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            sb3 = new StringBuilder();
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        } else {
                                            sb3 = new StringBuilder();
                                            sb3.append(exceptionMessage.mMonitorInfo);
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        }
                                        exceptionMessage.mMonitorInfo = sb3.toString();
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            sb4 = new StringBuilder();
                                            sb4.append(readLine);
                                            sb4.append("\n");
                                        } else {
                                            sb4 = new StringBuilder();
                                            sb4.append(exceptionMessage.mSlowLooper);
                                            sb4.append(readLine);
                                            sb4.append("\n");
                                        }
                                        exceptionMessage.mSlowLooper = sb4.toString();
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            sb5 = new StringBuilder();
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                        } else {
                                            sb5 = new StringBuilder();
                                            sb5.append(exceptionMessage.mSlowOperation);
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                        }
                                        exceptionMessage.mSlowOperation = sb5.toString();
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb = new StringBuilder();
                                    sb.append(readLine);
                                    sb.append("\n");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(exceptionMessage.mGCInfo);
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                exceptionMessage.mGCInfo = sb.toString();
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "compressAndUpload");
        File Hp = this.mUploader.Hp();
        if (!Hp.exists()) {
            Hp.mkdir();
        }
        File file = new File(Hp, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            b(file, countDownLatch);
            return;
        }
        q.S(file);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(File file, ExceptionMessage exceptionMessage) {
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        bufferedReader = readLine;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        bufferedReader = bufferedReader;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e6);
        }
    }
}
