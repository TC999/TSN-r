package com.baidu.liantian.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.liantian.b.g;
import com.baidu.liantian.e;

/* compiled from: ReportHeader.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    public static String a(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f12229b.getString("rpiiem", "");
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.f12231d.putString("rpiiem", str);
                    eVar.f12231d.commit();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        return str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f12229b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = g.f(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.f12231d.putString("rpandid", str);
                    eVar.f12231d.commit();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        return str;
    }

    public static String c(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f12229b.getString("rpmacadd", "");
            if (TextUtils.isEmpty(str)) {
                str = g.a();
                if (!TextUtils.isEmpty(str)) {
                    eVar.f12231d.putString("rpmacadd", str);
                    eVar.f12231d.commit();
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        return str;
    }
}
