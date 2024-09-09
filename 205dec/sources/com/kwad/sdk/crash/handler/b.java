package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b {
    public static final String FILE_NAME_BASE = UUID.randomUUID().toString();
    private static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static File sBackupDir;
    protected File mDumpFile;
    protected f mExceptionListener;
    protected AtomicInteger mIndex = new AtomicInteger();
    protected File mJavaTraceFile;
    protected File mLogDir;
    protected File mLogFile;
    protected File mMemoryInfoFile;
    protected e mUploader;

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (file.exists()) {
            return;
        }
        sBackupDir.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void backupLogFiles(File file) {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            q.g(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    protected abstract int getCrashType();

    public final e getUploader() {
        return this.mUploader;
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        String str = FILE_NAME_BASE;
        sb.append(str);
        sb.append("-");
        sb.append(this.mIndex);
        sb.append(".dump");
        this.mDumpFile = new File(file2, sb.toString());
        File file3 = this.mLogDir;
        this.mLogFile = new File(file3, str + "-" + this.mIndex + ".log");
        File file4 = this.mLogDir;
        this.mJavaTraceFile = new File(file4, str + "-" + this.mIndex + ".jtrace");
        File file5 = this.mLogDir;
        this.mMemoryInfoFile = new File(file5, str + "-" + this.mIndex + ".minfo");
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }

    protected abstract void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadRemainingExceptions() {
        File[] listFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (listFiles == null || listFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
        reportException(listFiles, countDownLatch);
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }
}
