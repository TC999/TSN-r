package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.eq;

@Keep
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LogAdapter implements com.bytedance.sdk.component.c {
    public static LogAdapter sAdapter;

    /* renamed from: c  reason: collision with root package name */
    private TTILog f36290c;

    private LogAdapter() {
    }

    @Keep
    public static void zzz(TTILog tTILog) {
        if (eq.f33190w > 5300 && sAdapter == null) {
            zzz(tTILog, false);
        }
    }

    public TTILog c() {
        return this.f36290c;
    }

    @Override // com.bytedance.sdk.component.c
    public void sr(String str, String str2) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void ux(String str, String str2) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void w(String str, String str2) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.d(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void xv(String str, String str2) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.i(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void c(String str, String str2) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.v(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void w(String str, String str2, Throwable th) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.e(str, str2, th);
        }
    }

    public static void zzz(TTILog tTILog, boolean z3) {
        LogAdapter logAdapter = new LogAdapter();
        sAdapter = logAdapter;
        if (z3) {
            logAdapter.f36290c = new c(tTILog);
        } else {
            logAdapter.f36290c = tTILog;
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void c(String str, String str2, Throwable th) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.w(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.c
    public void c(String str, Throwable th) {
        TTILog tTILog = this.f36290c;
        if (tTILog != null) {
            tTILog.e(str, th);
        }
    }
}
