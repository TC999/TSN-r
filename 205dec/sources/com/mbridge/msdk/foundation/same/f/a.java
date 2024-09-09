package com.mbridge.msdk.foundation.same.f;

import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: ReportTask.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f39472a;

    /* renamed from: b  reason: collision with root package name */
    private String f39473b;

    public a(String str, String str2) {
        this.f39472a = str;
        this.f39473b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            x.d("ReportTask", "start report");
            new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j()).c(0, d.a().f39564a, e.a(this.f39472a, com.mbridge.msdk.foundation.controller.a.f().j(), this.f39473b), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.f.a.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str) {
                    x.d("ReportTask", str);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str) {
                    x.d("ReportTask", str);
                }
            });
        } catch (Throwable th) {
            x.d("ReportTask", th.getMessage());
        }
    }
}
