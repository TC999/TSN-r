package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AutoTCommonParam.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f9599a;

    public a(Context context) {
        this.f9599a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static String b() {
        return "ANDA0605000";
    }

    private static String c() {
        return "";
    }

    private String d() {
        return c1.j(this.f9599a);
    }

    private static String e() {
        return "9.7.0";
    }

    private static String f() {
        return "";
    }

    private static String g() {
        return c1.H();
    }

    private static String h() {
        return "";
    }

    private static String i() {
        return "";
    }

    private static String j() {
        return "";
    }

    private static String k() {
        return "";
    }

    private static String l() {
        return "";
    }

    private static String m() {
        return "";
    }

    private static String n() {
        return "";
    }

    private static String o() {
        return "ANDH070308";
    }

    private static String p() {
        return "android";
    }

    private static String q() {
        return "";
    }

    private static String r() {
        return "";
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("");
        sb.append("personal_switch=false");
        sb.append("&autodiv=");
        sb.append(b());
        String c4 = c();
        if (!TextUtils.isEmpty(c4)) {
            sb.append("&tid=");
            sb.append(c4);
        }
        String d4 = d();
        if (!TextUtils.isEmpty(d4)) {
            sb.append("&adiu=");
            sb.append(d4);
        }
        String e4 = e();
        if (!TextUtils.isEmpty(e4)) {
            sb.append("&app_version=");
            sb.append(e4);
        }
        String f4 = f();
        if (!TextUtils.isEmpty(f4)) {
            sb.append("&cifa=");
            sb.append(f4);
        }
        String g4 = g();
        if (!TextUtils.isEmpty(g4)) {
            sb.append("&deviceid=");
            sb.append(g4);
        }
        String h4 = h();
        if (!TextUtils.isEmpty(h4)) {
            sb.append("&did=");
            sb.append(h4);
        }
        String i4 = i();
        if (!TextUtils.isEmpty(i4)) {
            sb.append("&didv=");
            sb.append(i4);
        }
        String j4 = j();
        if (!TextUtils.isEmpty(j4)) {
            sb.append("&dic=");
            sb.append(j4);
        }
        String k4 = k();
        if (!TextUtils.isEmpty(k4)) {
            sb.append("&dip=");
            sb.append(k4);
        }
        String l4 = l();
        if (!TextUtils.isEmpty(l4)) {
            sb.append("&diu=");
            sb.append(l4);
        }
        String m4 = m();
        if (!TextUtils.isEmpty(m4)) {
            sb.append("&diu2=");
            sb.append(m4);
        }
        String n4 = n();
        if (!TextUtils.isEmpty(n4)) {
            sb.append("&diu3=");
            sb.append(n4);
        }
        String o4 = o();
        if (!TextUtils.isEmpty(o4)) {
            sb.append("&div=");
            sb.append(o4);
        }
        String p3 = p();
        if (!TextUtils.isEmpty(p3)) {
            sb.append("&os=");
            sb.append(p3);
        }
        String q3 = q();
        if (!TextUtils.isEmpty(q3)) {
            sb.append("&stepid=");
            sb.append(q3);
        }
        String r3 = r();
        if (!TextUtils.isEmpty(r3)) {
            sb.append("&session=");
            sb.append(r3);
        }
        return sb.toString();
    }
}
