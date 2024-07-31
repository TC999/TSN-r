package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.s.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AutoTCommonParam {

    /* renamed from: a */
    private Context f5848a;

    public AutoTCommonParam(Context context) {
        this.f5848a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: b */
    private static String m53293b() {
        return "ANDA0605000";
    }

    /* renamed from: c */
    private static String m53292c() {
        return "";
    }

    /* renamed from: d */
    private String m53291d() {
        return C2023c1.m53164j(this.f5848a);
    }

    /* renamed from: e */
    private static String m53290e() {
        return "9.7.0";
    }

    /* renamed from: f */
    private static String m53289f() {
        return "";
    }

    /* renamed from: g */
    private static String m53288g() {
        return C2023c1.m53196H();
    }

    /* renamed from: h */
    private static String m53287h() {
        return "";
    }

    /* renamed from: i */
    private static String m53286i() {
        return "";
    }

    /* renamed from: j */
    private static String m53285j() {
        return "";
    }

    /* renamed from: k */
    private static String m53284k() {
        return "";
    }

    /* renamed from: l */
    private static String m53283l() {
        return "";
    }

    /* renamed from: m */
    private static String m53282m() {
        return "";
    }

    /* renamed from: n */
    private static String m53281n() {
        return "";
    }

    /* renamed from: o */
    private static String m53280o() {
        return "ANDH070308";
    }

    /* renamed from: p */
    private static String m53279p() {
        return FaceEnvironment.f8430OS;
    }

    /* renamed from: q */
    private static String m53278q() {
        return "";
    }

    /* renamed from: r */
    private static String m53277r() {
        return "";
    }

    /* renamed from: a */
    public final String m53294a() {
        StringBuilder sb = new StringBuilder("");
        sb.append("personal_switch=false");
        sb.append("&autodiv=");
        sb.append(m53293b());
        String m53292c = m53292c();
        if (!TextUtils.isEmpty(m53292c)) {
            sb.append("&tid=");
            sb.append(m53292c);
        }
        String m53291d = m53291d();
        if (!TextUtils.isEmpty(m53291d)) {
            sb.append("&adiu=");
            sb.append(m53291d);
        }
        String m53290e = m53290e();
        if (!TextUtils.isEmpty(m53290e)) {
            sb.append("&app_version=");
            sb.append(m53290e);
        }
        String m53289f = m53289f();
        if (!TextUtils.isEmpty(m53289f)) {
            sb.append("&cifa=");
            sb.append(m53289f);
        }
        String m53288g = m53288g();
        if (!TextUtils.isEmpty(m53288g)) {
            sb.append("&deviceid=");
            sb.append(m53288g);
        }
        String m53287h = m53287h();
        if (!TextUtils.isEmpty(m53287h)) {
            sb.append("&did=");
            sb.append(m53287h);
        }
        String m53286i = m53286i();
        if (!TextUtils.isEmpty(m53286i)) {
            sb.append("&didv=");
            sb.append(m53286i);
        }
        String m53285j = m53285j();
        if (!TextUtils.isEmpty(m53285j)) {
            sb.append("&dic=");
            sb.append(m53285j);
        }
        String m53284k = m53284k();
        if (!TextUtils.isEmpty(m53284k)) {
            sb.append("&dip=");
            sb.append(m53284k);
        }
        String m53283l = m53283l();
        if (!TextUtils.isEmpty(m53283l)) {
            sb.append("&diu=");
            sb.append(m53283l);
        }
        String m53282m = m53282m();
        if (!TextUtils.isEmpty(m53282m)) {
            sb.append("&diu2=");
            sb.append(m53282m);
        }
        String m53281n = m53281n();
        if (!TextUtils.isEmpty(m53281n)) {
            sb.append("&diu3=");
            sb.append(m53281n);
        }
        String m53280o = m53280o();
        if (!TextUtils.isEmpty(m53280o)) {
            sb.append("&div=");
            sb.append(m53280o);
        }
        String m53279p = m53279p();
        if (!TextUtils.isEmpty(m53279p)) {
            sb.append("&os=");
            sb.append(m53279p);
        }
        String m53278q = m53278q();
        if (!TextUtils.isEmpty(m53278q)) {
            sb.append("&stepid=");
            sb.append(m53278q);
        }
        String m53277r = m53277r();
        if (!TextUtils.isEmpty(m53277r)) {
            sb.append("&session=");
            sb.append(m53277r);
        }
        return sb.toString();
    }
}
