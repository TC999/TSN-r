package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.utils.C11122q;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10719g extends AbstractC10715d {
    public static final Pattern aHi = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aHj = Pattern.compile("\\sd+\\spc");

    /* renamed from: D */
    private NativeExceptionMessage m25038D(File file) {
        String str;
        try {
            str = C11122q.m23738V(file);
        } catch (IOException e) {
            this.mErrorMessage += e + ShellAdbUtils.f33810d;
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + ShellAdbUtils.f33810d;
            }
        }
        C11122q.m23741S(file);
        return nativeExceptionMessage;
    }

    /* renamed from: c */
    private static void m25034c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else if (aHj.matcher(readLine).matches()) {
                        if (threadInfo.mTrace != null) {
                            readLine = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = readLine;
                        threadInfo.mTrace += ShellAdbUtils.f33810d;
                    } else {
                        Matcher matcher = aHi.matcher(readLine);
                        if (matcher.lookingAt()) {
                            threadInfo.mName = matcher.group(1);
                            threadInfo.mTid = Integer.parseInt(matcher.group(2));
                            threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                        }
                    }
                }
                memoryInfo.mNativeThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
            } catch (IOException e) {
                C10331c.printStackTraceOnly(e);
            }
            C10738b.closeQuietly(bufferedReader);
        } catch (Exception e2) {
            C10331c.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.crash.report.AbstractC10715d
    /* renamed from: a */
    protected final ExceptionMessage mo25035a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage m25038D = m25038D(file2);
        try {
            m25037a(m25038D, file);
            m25043b(file3, m25038D);
            AbstractC10715d.m25045a(file4, m25038D);
            m25034c(new File(str + ".ntrace"), m25038D);
            C10745g.m24981a(file, (CharSequence) m25038D.toString(), true);
            C10745g.m24966d(file3, file);
            file.renameTo(file3);
            m25038D.toString();
            m25038D.mDumpsys = C11122q.m23738V(new File(str + ".minfo"));
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            this.mErrorMessage += e + ShellAdbUtils.f33810d;
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            m25038D.mErrorMessage += this.mErrorMessage;
        }
        return m25038D;
    }

    /* renamed from: a */
    private void m25037a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = C10745g.m24964fG(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z && readLine.startsWith("backtrace:")) {
                        z = false;
                        z2 = true;
                    } else if (z2) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    } else if (z) {
                        m25036a(nativeExceptionMessage, readLine, sb2);
                    } else if (readLine.startsWith("*** ***")) {
                        z = true;
                    }
                } catch (IOException e) {
                    this.mErrorMessage += e + ShellAdbUtils.f33810d;
                }
            } finally {
                C10738b.closeQuietly(bufferedReader);
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    /* renamed from: a */
    private static void m25036a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
        } else if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
        } else if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
        } else if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
        } else if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
        } else if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < split.length; i4++) {
                    if ("name:".equals(split[i4])) {
                        i = i4;
                    } else if (">>>".equals(split[i4])) {
                        i2 = i4;
                    } else if ("<<<".equals(split[i4])) {
                        i3 = i4;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                int i5 = i + 1;
                sb2.append(split[i5]);
                while (true) {
                    i5++;
                    if (i5 >= i2) {
                        break;
                    }
                    sb2.append(" ");
                    sb2.append(split[i5]);
                }
                nativeExceptionMessage.mThreadName = sb2.toString();
                sb2.setLength(0);
                int i6 = i2 + 1;
                sb2.append(split[i6]);
                while (true) {
                    i6++;
                    if (i6 < i3) {
                        sb2.append(" ");
                        sb2.append(split[i6]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb2.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = C10745g.m24963fH(split2[2]);
                    nativeExceptionMessage.mCode = C10745g.m24963fH(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb.append(str);
            sb.append('\n');
        }
    }
}
