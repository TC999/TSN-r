package com.qq.e.comm.plugin.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.u1;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43052a = "f";

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            Object opt = GlobalSetting.getSettings().opt("ecais");
            if (opt == null || !(opt instanceof Boolean)) {
                i4 = -1;
            } else {
                i4 = ((Boolean) opt).booleanValue() ? 1 : 0;
            }
            v.a(1130038, null, Integer.valueOf(i4));
        }
    }

    f() {
    }

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(10, 1, new Object[0]);
    }

    private JSONObject a(PackageInfo packageInfo) {
        return (JSONObject) pro.getobjresult(11, 0, this, packageInfo);
    }

    private void a(int i4, int i5, int i6) {
        pro.getVresult(12, 0, this, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private void a(Context context, int i4, boolean z3) {
        pro.getVresult(13, 0, this, context, Integer.valueOf(i4), Boolean.valueOf(z3));
    }

    private void a(Context context, JSONArray jSONArray, int i4) {
        pro.getVresult(14, 0, this, context, jSONArray, Integer.valueOf(i4));
    }

    private boolean a(PackageInfo packageInfo, boolean z3) {
        return pro.getZresult(15, 0, this, packageInfo, Boolean.valueOf(z3));
    }

    private boolean a(String str, String[] strArr, boolean z3) {
        return pro.getZresult(16, 0, this, str, strArr, Boolean.valueOf(z3));
    }

    private List<ResolveInfo> b() {
        return (List) pro.getobjresult(17, 0, this);
    }

    private boolean c() {
        return pro.getZresult(18, 0, this);
    }

    boolean a(Context context) {
        return pro.getZresult(19, 0, this, context);
    }

    void d() {
        pro.getVresult(20, 0, this);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43053a;

        a(f fVar, int i4) {
            this.f43053a = i4;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            d1.a(f.a(), "\u4e0a\u62a5\u6210\u529f: reportScene = %s", Integer.valueOf(this.f43053a));
            u1.b("alt_report_time", System.currentTimeMillis());
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            String a4 = f.a();
            d1.b(a4, "\u4e0a\u62a5\u5931\u8d25, reportScene = " + this.f43053a);
            v.a(9200004, null, Integer.valueOf(this.f43053a), Integer.valueOf(i4), null);
        }
    }
}
