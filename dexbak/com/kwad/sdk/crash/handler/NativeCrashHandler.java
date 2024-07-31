package com.kwad.sdk.crash.handler;

import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10656b;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.AbstractC10713c;
import com.kwad.sdk.crash.report.C10719g;
import com.kwad.sdk.crash.report.InterfaceC10717e;
import com.kwad.sdk.crash.utils.C10745g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NativeCrashHandler extends AbstractC10685b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.crash.handler.NativeCrashHandler$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10683a {
        private static final NativeCrashHandler aFZ = new NativeCrashHandler();
    }

    public static native void doCrash();

    public static NativeCrashHandler getInstance() {
        return C10683a.aFZ;
    }

    public static native void install(@NonNull String str, boolean z, @NonNull String str2, int i);

    @Keep
    public static void onCallFromNative() {
        C10331c.m26254d(TAG, "onCallFromNative NativeCrashHandler.doCrash()");
        File file = getInstance().mLogDir;
        File file2 = getInstance().mMessageFile;
        File file3 = getInstance().mJavaTraceFile;
        File file4 = getInstance().mMemoryInfoFile;
        InterfaceC10717e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb.append(exceptionMessage.mErrorMessage);
                sb.append("create ");
                sb.append(file.getPath());
                sb.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(AbstractC10685b.FILE_NAME_BASE);
                sb2.append(".msg");
                file2 = new File(file, sb2.toString());
            }
            if (file3 == null) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(AbstractC10685b.FILE_NAME_BASE);
                sb3.append(".jtrace");
                file3 = new File(file, sb3.toString());
            }
            if (file4 == null) {
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(AbstractC10685b.FILE_NAME_BASE);
                sb4.append(".minfo");
                file4 = new File(file, sb4.toString());
            }
            C10745g.m24971b(null, mMessage, C10671e.m25134Hu().getContext());
            C10745g.m24990a(mMessage, getInstance().getCrashType());
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.mo25125a(getInstance().getCrashType(), mMessage);
            }
            try {
                C10745g.m24983a(file2, mMessage.toJson().toString());
                C10745g.m24994G(file3);
                getInstance().backupLogFiles(file);
                C10745g.m24984a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                C10745g.m24993H(file4);
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
                if (uploader != null) {
                    C10745g.m24959r(th);
                }
            }
        } catch (Throwable th2) {
            try {
                StringBuilder sb5 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb5.append(exceptionMessage2.mErrorMessage);
                sb5.append(th2);
                exceptionMessage2.mErrorMessage = sb5.toString();
                C10331c.printStackTraceOnly(th2);
            } finally {
                if (file2 != null) {
                    try {
                        C10745g.m24983a(file2, mMessage.toJson().toString());
                    } catch (Throwable th3) {
                        C10331c.printStackTraceOnly(th3);
                        if (uploader != null) {
                            C10745g.m24959r(th3);
                        }
                    }
                }
                C10745g.m24994G(file3);
                getInstance().backupLogFiles(file);
                C10745g.m24984a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                C10745g.m24993H(file4);
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z, @NonNull String str, AbstractC10713c abstractC10713c) {
        super.init(file, null, abstractC10713c);
        if (C10656b.m25224Hd()) {
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AbstractC10685b.FILE_NAME_BASE;
            sb.append(str2);
            sb.append(".dump");
            this.mDumpFile = new File(file, sb.toString());
            this.mJavaTraceFile = new File(file, str2 + ".jtrace");
            this.mMemoryInfoFile = new File(file, str2 + ".minfo");
            try {
                C10331c.m26254d(TAG, "ANR init2 " + this.mDumpFile.getPath());
                install(this.mDumpFile.getPath(), z, str, Build.VERSION.SDK_INT);
                this.mMessageFile = new File(file, str2 + ".msg");
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        C10719g c10719g = new C10719g();
        c10719g.m25046a(getUploader());
        for (File file : fileArr) {
            c10719g.m25044a(file, countDownLatch);
        }
    }

    private NativeCrashHandler() {
    }
}
