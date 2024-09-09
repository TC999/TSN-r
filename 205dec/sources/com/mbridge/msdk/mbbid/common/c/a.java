package com.mbridge.msdk.mbbid.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: BidReport.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40009a = "com.mbridge.msdk.mbbid.common.c.a";

    public static void b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.a().f39564a, e.a("key=2000064&result=2&network_type=" + t.D(context) + "&reason=" + str2, context, str), new b() { // from class: com.mbridge.msdk.mbbid.common.c.a.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str3) {
                    x.d(a.f40009a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str3) {
                    x.d(a.f40009a, str3);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f40009a, e4.getMessage());
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("key=");
            sb.append("2000064");
            sb.append("&");
            sb.append("result=");
            sb.append("1");
            sb.append("&");
            sb.append("network_type=");
            sb.append(t.D(context));
            sb.append("&");
            sb.append("bidid=");
            sb.append(str2);
            if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                com.mbridge.msdk.foundation.same.report.b.a().a(sb.toString());
                return;
            }
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.a().f39564a, e.a(sb.toString(), context, str), new b() { // from class: com.mbridge.msdk.mbbid.common.c.a.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str3) {
                    x.d(a.f40009a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str3) {
                    x.d(a.f40009a, str3);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f40009a, e4.getMessage());
        }
    }
}
