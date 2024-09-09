package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final c aFY = new c((byte) 0);
    }

    /* synthetic */ c(byte b4) {
        this();
    }

    public static c HK() {
        return a.aFY;
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, ((f) ServiceProvider.get(f.class)).yp());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Hu().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    private c() {
    }

    private void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z3) {
        boolean z4;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpFile;
        File file2 = this.mLogFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th.toString();
            if (this.mLogDir.exists() || this.mLogDir.mkdirs()) {
                z4 = true;
            } else {
                exceptionMessage.mErrorMessage += "create " + HK().mLogDir.getPath() + " failed!\n";
                z4 = false;
            }
            if (file == null || andIncrement != 0) {
                try {
                    file = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".dump");
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        exceptionMessage.mErrorMessage += th;
                        try {
                            String jSONObject = exceptionMessage.toJson().toString();
                            if (!z4) {
                                if (uploader != null) {
                                    com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploader.uploadEvent(message);");
                                    CountDownLatch countDownLatch = z3 ? new CountDownLatch(1) : null;
                                    uploader.a(exceptionMessage, countDownLatch);
                                    exceptionMessage.toString();
                                    if (countDownLatch != null) {
                                        try {
                                            countDownLatch.await(5L, TimeUnit.SECONDS);
                                            return;
                                        } catch (InterruptedException unused) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            g.a(file, jSONObject);
                            g.G(file3);
                            g.E(file2);
                            if (com.kwad.sdk.crash.e.Hu().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                exceptionMessage.toString();
                                if (z3) {
                                    CountDownLatch countDownLatch2 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch2);
                                    try {
                                        countDownLatch2.await(5L, TimeUnit.SECONDS);
                                    } catch (InterruptedException unused2) {
                                    }
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.H(file4);
                            return;
                        } catch (Throwable th3) {
                            if (uploader != null) {
                                try {
                                    g.r(th3);
                                    return;
                                } catch (Exception unused3) {
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Throwable th4) {
                        try {
                            String jSONObject2 = exceptionMessage.toJson().toString();
                            if (z4) {
                                g.a(file, jSONObject2);
                                g.G(file3);
                                g.E(file2);
                                if (com.kwad.sdk.crash.e.Hu().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    exceptionMessage.toString();
                                    if (z3) {
                                        CountDownLatch countDownLatch3 = new CountDownLatch(1);
                                        reportException(new File[]{file}, countDownLatch3);
                                        try {
                                            countDownLatch3.await(5L, TimeUnit.SECONDS);
                                        } catch (InterruptedException unused4) {
                                        }
                                    } else {
                                        uploadRemainingExceptions();
                                    }
                                }
                                g.H(file4);
                            } else if (uploader != null) {
                                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploader.uploadEvent(message);");
                                CountDownLatch countDownLatch4 = z3 ? new CountDownLatch(1) : null;
                                uploader.a(exceptionMessage, countDownLatch4);
                                exceptionMessage.toString();
                                if (countDownLatch4 != null) {
                                    try {
                                        countDownLatch4.await(5L, TimeUnit.SECONDS);
                                    } catch (InterruptedException | Exception unused5) {
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            if (uploader != null) {
                                g.r(th5);
                            }
                        }
                        throw th4;
                    }
                }
            }
            if (file2 == null || andIncrement != 0) {
                file2 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".log");
            }
            if (file3 == null || andIncrement != 0) {
                file3 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".jtrace");
            }
            if (file4 == null || andIncrement != 0) {
                file4 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".minfo");
            }
            g.b(th, exceptionMessage, context);
            g.a(exceptionMessage, getCrashType());
            com.kwad.sdk.crash.f fVar = this.mExceptionListener;
            if (fVar != null) {
                fVar.a(getCrashType(), exceptionMessage);
            }
            try {
                String jSONObject3 = exceptionMessage.toJson().toString();
                if (!z4) {
                    if (uploader != null) {
                        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploader.uploadEvent(message);");
                        CountDownLatch countDownLatch5 = z3 ? new CountDownLatch(1) : null;
                        uploader.a(exceptionMessage, countDownLatch5);
                        exceptionMessage.toString();
                        if (countDownLatch5 != null) {
                            try {
                                countDownLatch5.await(5L, TimeUnit.SECONDS);
                                return;
                            } catch (InterruptedException unused6) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                g.a(file, jSONObject3);
                g.G(file3);
                g.E(file2);
                if (com.kwad.sdk.crash.e.Hu().isDebug()) {
                    backupLogFiles(this.mLogDir);
                }
                if (uploader != null) {
                    exceptionMessage.toString();
                    if (z3) {
                        CountDownLatch countDownLatch6 = new CountDownLatch(1);
                        reportException(new File[]{file}, countDownLatch6);
                        try {
                            countDownLatch6.await(5L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused7) {
                        }
                    } else {
                        uploadRemainingExceptions();
                    }
                }
                g.H(file4);
            } catch (Throwable th6) {
                if (uploader != null) {
                    try {
                        g.r(th6);
                    } catch (Exception unused8) {
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            z4 = true;
        }
    }
}
