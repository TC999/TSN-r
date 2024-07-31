package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.InterfaceC10673f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.C10718f;
import com.kwad.sdk.crash.report.InterfaceC10717e;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.crash.handler.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10687c extends AbstractC10685b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.crash.handler.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10688a {
        private static final C10687c aFY = new C10687c((byte) 0);
    }

    /* synthetic */ C10687c(byte b) {
        this();
    }

    /* renamed from: HK */
    public static C10687c m25109HK() {
        return C10688a.aFY;
    }

    /* renamed from: a */
    public final void m25108a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        m25107a(th, exceptionMessage, context, ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp());
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    public final void init(File file, InterfaceC10673f interfaceC10673f, InterfaceC10717e interfaceC10717e) {
        super.init(file, interfaceC10673f, interfaceC10717e);
        if (C10671e.m25134Hu().isDebug()) {
            AbstractC10685b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        C10718f c10718f = new C10718f();
        c10718f.m25046a(getUploader());
        for (File file : fileArr) {
            c10718f.m25044a(file, countDownLatch);
        }
    }

    private C10687c() {
    }

    /* renamed from: a */
    private void m25107a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z) {
        boolean z2;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpFile;
        File file2 = this.mLogFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        InterfaceC10717e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th.toString();
            if (this.mLogDir.exists() || this.mLogDir.mkdirs()) {
                z2 = true;
            } else {
                exceptionMessage.mErrorMessage += "create " + m25109HK().mLogDir.getPath() + " failed!\n";
                z2 = false;
            }
            if (file == null || andIncrement != 0) {
                try {
                    file = new File(this.mLogDir, AbstractC10685b.FILE_NAME_BASE + "-" + andIncrement + ".dump");
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        exceptionMessage.mErrorMessage += th;
                        try {
                            String jSONObject = exceptionMessage.toJson().toString();
                            if (!z2) {
                                if (uploader != null) {
                                    C10331c.m26254d("AdExceptionCollector", "uploader.uploadEvent(message);");
                                    CountDownLatch countDownLatch = z ? new CountDownLatch(1) : null;
                                    uploader.mo25039a(exceptionMessage, countDownLatch);
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
                            C10745g.m24983a(file, jSONObject);
                            C10745g.m24994G(file3);
                            C10745g.m24996E(file2);
                            if (C10671e.m25134Hu().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                exceptionMessage.toString();
                                if (z) {
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
                            C10745g.m24993H(file4);
                            return;
                        } catch (Throwable th3) {
                            if (uploader != null) {
                                try {
                                    C10745g.m24959r(th3);
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
                            if (z2) {
                                C10745g.m24983a(file, jSONObject2);
                                C10745g.m24994G(file3);
                                C10745g.m24996E(file2);
                                if (C10671e.m25134Hu().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    exceptionMessage.toString();
                                    if (z) {
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
                                C10745g.m24993H(file4);
                            } else if (uploader != null) {
                                C10331c.m26254d("AdExceptionCollector", "uploader.uploadEvent(message);");
                                CountDownLatch countDownLatch4 = z ? new CountDownLatch(1) : null;
                                uploader.mo25039a(exceptionMessage, countDownLatch4);
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
                                C10745g.m24959r(th5);
                            }
                        }
                        throw th4;
                    }
                }
            }
            if (file2 == null || andIncrement != 0) {
                file2 = new File(this.mLogDir, AbstractC10685b.FILE_NAME_BASE + "-" + andIncrement + ".log");
            }
            if (file3 == null || andIncrement != 0) {
                file3 = new File(this.mLogDir, AbstractC10685b.FILE_NAME_BASE + "-" + andIncrement + ".jtrace");
            }
            if (file4 == null || andIncrement != 0) {
                file4 = new File(this.mLogDir, AbstractC10685b.FILE_NAME_BASE + "-" + andIncrement + ".minfo");
            }
            C10745g.m24971b(th, exceptionMessage, context);
            C10745g.m24990a(exceptionMessage, getCrashType());
            InterfaceC10673f interfaceC10673f = this.mExceptionListener;
            if (interfaceC10673f != null) {
                interfaceC10673f.mo25125a(getCrashType(), exceptionMessage);
            }
            try {
                String jSONObject3 = exceptionMessage.toJson().toString();
                if (!z2) {
                    if (uploader != null) {
                        C10331c.m26254d("AdExceptionCollector", "uploader.uploadEvent(message);");
                        CountDownLatch countDownLatch5 = z ? new CountDownLatch(1) : null;
                        uploader.mo25039a(exceptionMessage, countDownLatch5);
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
                C10745g.m24983a(file, jSONObject3);
                C10745g.m24994G(file3);
                C10745g.m24996E(file2);
                if (C10671e.m25134Hu().isDebug()) {
                    backupLogFiles(this.mLogDir);
                }
                if (uploader != null) {
                    exceptionMessage.toString();
                    if (z) {
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
                C10745g.m24993H(file4);
            } catch (Throwable th6) {
                if (uploader != null) {
                    try {
                        C10745g.m24959r(th6);
                    } catch (Exception unused8) {
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            z2 = true;
        }
    }
}
