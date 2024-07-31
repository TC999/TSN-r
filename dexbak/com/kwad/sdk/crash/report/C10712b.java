package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.utils.C11122q;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10712b extends AbstractC10715d {
    /* renamed from: B */
    private AnrExceptionMessage m25059B(File file) {
        String str;
        try {
            str = C11122q.m23738V(file);
        } catch (IOException e) {
            this.mErrorMessage += e + ShellAdbUtils.f33810d;
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + ShellAdbUtils.f33810d;
            }
        }
        C11122q.m23741S(file);
        return anrExceptionMessage;
    }

    /* renamed from: fA */
    private String m25057fA(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        if (file.exists()) {
            try {
                str2 = C11122q.m23738V(file);
            } catch (IOException e) {
                this.mErrorMessage += e + ShellAdbUtils.f33810d;
            }
            C11122q.m23741S(file);
        }
        return str2;
    }

    /* renamed from: fB */
    private static boolean m25056fB(@NonNull String str) {
        String[] m25133Hv;
        for (String str2 : C10671e.m25134Hu().m25133Hv()) {
            if (str.contains(str2)) {
                C10331c.m26254d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.crash.report.AbstractC10715d
    /* renamed from: a */
    protected final ExceptionMessage mo25035a(@NonNull File file, File file2, File file3, String str) {
        C10331c.m26254d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage m25059B = m25059B(file2);
        try {
            m25059B.mReason = m25057fA(str);
            m25058a(m25059B, file);
            m25043b(file3, m25059B);
            C10745g.m24981a(file, (CharSequence) m25059B.toString(), true);
            C10745g.m24966d(file3, file);
            file.renameTo(file3);
            m25059B.toString();
            m25059B.mDumpsys = C11122q.m23738V(new File(str + ".minfo"));
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            this.mErrorMessage += e + ShellAdbUtils.f33810d;
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            m25059B.mErrorMessage += this.mErrorMessage;
        }
        return m25059B;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m25058a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.C10712b.m25058a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }
}
