package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends d {
    private AnrExceptionMessage B(File file) {
        String str;
        try {
            str = q.V(file);
        } catch (IOException e4) {
            this.mErrorMessage += e4 + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e5) {
                this.mErrorMessage += e5 + "\n";
            }
        }
        q.S(file);
        return anrExceptionMessage;
    }

    private String fA(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        if (file.exists()) {
            try {
                str2 = q.V(file);
            } catch (IOException e4) {
                this.mErrorMessage += e4 + "\n";
            }
            q.S(file);
        }
        return str2;
    }

    private static boolean fB(@NonNull String str) {
        String[] Hv;
        for (String str2 : com.kwad.sdk.crash.e.Hu().Hv()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.e.c.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        com.kwad.sdk.core.e.c.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage B = B(file2);
        try {
            B.mReason = fA(str);
            a(B, file);
            b(file3, B);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) B.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            B.toString();
            B.mDumpsys = q.V(new File(str + ".minfo"));
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            this.mErrorMessage += e4 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            B.mErrorMessage += this.mErrorMessage;
        }
        return B;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }
}
