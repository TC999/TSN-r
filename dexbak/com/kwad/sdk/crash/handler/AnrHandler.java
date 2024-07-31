package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10656b;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.InterfaceC10673f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.report.C10712b;
import com.kwad.sdk.crash.report.InterfaceC10717e;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11122q;
import com.kwad.sdk.utils.SystemUtil;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AnrHandler extends AbstractC10685b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.m24267ed(21);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10681a {
        private static final AnrHandler aFW = new AnrHandler();
    }

    private static synchronized void dumpAnr(@Nullable String str, int i) {
        synchronized (AnrHandler.class) {
            C10331c.m26254d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i);
            AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
            File file = getInstance().mLogDir;
            boolean z = true;
            if (!file.exists() && !file.mkdirs()) {
                C10331c.m26254d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file.getPath() + " failed!\n";
                z = false;
            }
            if (str != null && z) {
                StringBuilder sb = new StringBuilder();
                getInstance();
                String str2 = AbstractC10685b.FILE_NAME_BASE;
                sb.append(str2);
                sb.append("-");
                sb.append(i);
                sb.append(".dump");
                C11122q.m23721f(new File(str), new File(file, sb.toString()));
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(str2);
                sb2.append("-");
                sb2.append(i);
                sb2.append(".log");
                C10745g.m24996E(new File(file, sb2.toString()));
            }
            C10745g.m24971b(null, anrExceptionMessage, C10671e.m25134Hu().getContext());
            C10745g.m24990a(anrExceptionMessage, 3);
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.mo25125a(getInstance().getCrashType(), anrExceptionMessage);
            }
            dumpAnrReason(str, i, anrExceptionMessage, z);
        }
    }

    private static void dumpAnrReason(@Nullable String str, int i, @NonNull AnrExceptionMessage anrExceptionMessage, boolean z) {
        C10331c.m26254d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i + " dirReady=" + z);
        InterfaceC10717e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            final StringBuilder sb = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb2 = sb;
                    sb2.append(str2);
                    sb2.append(ShellAdbUtils.f33810d);
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            String jSONObject = anrExceptionMessage.toJson().toString();
            StringBuilder sb2 = new StringBuilder();
            getInstance();
            String str2 = AbstractC10685b.FILE_NAME_BASE;
            sb2.append(str2);
            sb2.append("-");
            sb2.append(i);
            sb2.append(".dump");
            File file2 = new File(file, sb2.toString());
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(str2);
                sb3.append("-");
                sb3.append(i);
                sb3.append(".msg");
                File file3 = new File(file, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(str2);
                sb4.append("-");
                sb4.append(i);
                sb4.append(".minfo");
                File file4 = new File(file, sb4.toString());
                C10745g.m24983a(file3, jSONObject);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    anrExceptionMessage.toString();
                }
                C10745g.m24984a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                C10745g.m24993H(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.mo25039a(anrExceptionMessage, null);
                }
                anrExceptionMessage.toString();
            }
            StringBuilder sb5 = new StringBuilder();
            getInstance();
            sb5.append(str2);
            sb5.append("-");
            sb5.append(i);
            sb5.append(".anr");
            getAnrReason(str, new File(file, sb5.toString()));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            if (uploader != null) {
                C10745g.m24959r(th);
            }
        }
    }

    private static void getAnrReason(@Nullable String str, final File file) {
        C10331c.m26254d(TAG, "ANR getAnrReason");
        if (str == null) {
            C11095g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, file);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAnrReasonInner(@Nullable String str, File file) {
        C10331c.m26254d(TAG, "ANR getAnrReasonInner");
        getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < PARSE_TRACE_INTERVAL) {
                    return;
                }
                sLastTime = lastModified;
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) C10671e.m25134Hu().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (activityManager == null) {
            return;
        }
        for (int i = 0; i < TRY_TIMES; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(GET_REASON_INTERVAL);
        }
        if (processErrorStateInfo != null && processErrorStateInfo.pid == MY_PID) {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            C10745g.m24983a(file, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return C10681a.aFW;
    }

    public static native void install(String str, int i);

    @Keep
    public static void onCallFromNative(int i) {
        C10331c.m26254d(TAG, "ANR onCallFromNative index=" + i);
        dumpAnr(null, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        C10331c.m26254d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    private boolean parseTraceFile(String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                int i = -1;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (PID_PATTERN.matcher(readLine).matches()) {
                                i = Integer.parseInt(readLine.split("\\s")[2]);
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        C10738b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        C10738b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C10738b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z = i == MY_PID;
                C10738b.closeQuietly(bufferedReader2);
                return z;
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void watchTraceFile() {
        C10331c.m26254d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    public final void init(File file, InterfaceC10673f interfaceC10673f, InterfaceC10717e interfaceC10717e) {
        super.init(file, interfaceC10673f, interfaceC10717e);
        if (C10656b.m25224Hd()) {
            C10331c.m26254d(TAG, "ANR init ");
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = new File(this.mLogDir, AbstractC10685b.FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                install(file2.getPath(), Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.AbstractC10685b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        C10712b c10712b = new C10712b();
        c10712b.m25046a(getUploader());
        for (File file : fileArr) {
            c10712b.m25044a(file, countDownLatch);
        }
    }

    private AnrHandler() {
    }
}
