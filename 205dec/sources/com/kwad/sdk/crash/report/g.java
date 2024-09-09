package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends d {
    public static final Pattern aHi = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aHj = Pattern.compile("\\sd+\\spc");

    private NativeExceptionMessage D(File file) {
        String str;
        try {
            str = q.V(file);
        } catch (IOException e4) {
            this.mErrorMessage += e4 + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e5) {
                this.mErrorMessage += e5 + "\n";
            }
        }
        q.S(file);
        return nativeExceptionMessage;
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
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
                        threadInfo.mTrace += "\n";
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
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
        } catch (Exception e5) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e5);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage D = D(file2);
        try {
            a(D, file);
            b(file3, D);
            d.a(file4, D);
            c(new File(str + ".ntrace"), D);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) D.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            D.toString();
            D.mDumpsys = q.V(new File(str + ".minfo"));
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            this.mErrorMessage += e4 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            D.mErrorMessage += this.mErrorMessage;
        }
        return D;
    }

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.fG(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z3 && readLine.startsWith("backtrace:")) {
                        z3 = false;
                        z4 = true;
                    } else if (z4) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    } else if (z3) {
                        a(nativeExceptionMessage, readLine, sb2);
                    } else if (readLine.startsWith("*** ***")) {
                        z3 = true;
                    }
                } catch (IOException e4) {
                    this.mErrorMessage += e4 + "\n";
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
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
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < split.length; i7++) {
                    if ("name:".equals(split[i7])) {
                        i4 = i7;
                    } else if (">>>".equals(split[i7])) {
                        i5 = i7;
                    } else if ("<<<".equals(split[i7])) {
                        i6 = i7;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                int i8 = i4 + 1;
                sb2.append(split[i8]);
                while (true) {
                    i8++;
                    if (i8 >= i5) {
                        break;
                    }
                    sb2.append(" ");
                    sb2.append(split[i8]);
                }
                nativeExceptionMessage.mThreadName = sb2.toString();
                sb2.setLength(0);
                int i9 = i5 + 1;
                sb2.append(split[i9]);
                while (true) {
                    i9++;
                    if (i9 < i6) {
                        sb2.append(" ");
                        sb2.append(split[i9]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb2.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.fH(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.fH(split2[5]);
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
