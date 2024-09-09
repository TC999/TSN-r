package cn.jiguang.ay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f2479c;

    /* renamed from: a  reason: collision with root package name */
    private Context f2480a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f2481b;

    /* renamed from: d  reason: collision with root package name */
    private String f2482d;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.ah.e {

        /* renamed from: a  reason: collision with root package name */
        private Context f2483a;

        private a(Context context) {
            this.f2483a = context;
            this.f2244d = "JDevice#RegisterAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                Context context = this.f2483a;
                cn.jiguang.bb.a.a(context, cn.jiguang.bb.a.c(context));
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JDevice", "RegisterAction failed:" + th.getMessage());
            }
        }
    }

    private JSONObject c(Context context) {
        StringBuilder sb;
        String message;
        JSONObject e4;
        JSONObject a4;
        if (context == null) {
            cn.jiguang.w.a.f("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "";
            if (cn.jiguang.ar.a.a().e(1017)) {
                String c4 = cn.jiguang.ag.a.c(context);
                if (TextUtils.isEmpty(c4)) {
                    c4 = "";
                }
                jSONObject.put("resolution", c4);
            }
            if (cn.jiguang.ar.a.a().e(1020)) {
                jSONObject.put("screensize", cn.jiguang.bb.a.a(context));
            }
            if (cn.jiguang.ar.a.a().e(1014)) {
                jSONObject.put("os_version", cn.jiguang.ag.a.v(context));
            }
            if (cn.jiguang.ar.a.a().e(1013)) {
                jSONObject.put("model", cn.jiguang.ag.a.p(context));
            }
            if (cn.jiguang.ar.a.a().e(1002)) {
                jSONObject.put("brand", cn.jiguang.ag.a.r(context));
            }
            if (cn.jiguang.ar.a.a().e(1015)) {
                jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, cn.jiguang.ag.a.n(context));
            }
            if (cn.jiguang.ar.a.a().e(1007)) {
                String.format(Locale.ENGLISH, Build.FINGERPRINT, new Object[0]);
                jSONObject.put("fingerprint", cn.jiguang.ag.a.o(context));
            }
            if (cn.jiguang.ar.a.a().e(1009)) {
                jSONObject.put("language", cn.jiguang.ag.a.s(context));
            }
            if (cn.jiguang.ar.a.a().e(1011)) {
                jSONObject.put("manufacturer", cn.jiguang.ag.a.t(context));
            }
            if (cn.jiguang.ar.a.a().e(1026)) {
                jSONObject.put("timezone", cn.jiguang.ag.a.u(context));
            }
            if (cn.jiguang.ar.a.a().e(1019)) {
                String a5 = cn.jiguang.bb.e.a(context);
                if (TextUtils.isEmpty(a5)) {
                    a5 = "";
                }
                jSONObject.put("romversion", a5);
            }
            if (cn.jiguang.ar.a.a().e(1010)) {
                String c5 = cn.jiguang.ah.d.c(context, "");
                if (TextUtils.isEmpty(c5)) {
                    c5 = "";
                }
                jSONObject.put("mac", c5);
            }
            if (cn.jiguang.ar.a.a().e(1012)) {
                jSONObject.put("meid", cn.jiguang.bb.c.a(context));
            }
            if (cn.jiguang.ar.a.a().e(1022)) {
                jSONObject.put("sim_slots", cn.jiguang.bb.a.b(context));
            }
            if (cn.jiguang.ar.a.a().e(1001)) {
                String n4 = cn.jiguang.ah.d.n(context);
                if (!TextUtils.isEmpty(n4)) {
                    str = n4;
                }
                jSONObject.put("android_id", str);
            }
            if (cn.jiguang.ar.a.a().e(1008) && (a4 = cn.jiguang.bd.a.a(context)) != null) {
                jSONObject.put("ids", a4);
            }
            if (cn.jiguang.ar.a.a().e(2500)) {
                jSONObject.put("root_state", cn.jiguang.ag.a.h(context) ? 1 : 0);
            }
            if (cn.jiguang.ar.a.a().e(1027)) {
                jSONObject.put("simulator_state", cn.jiguang.ag.a.i(context) ? 1 : 0);
            }
            if (cn.jiguang.ar.a.a().a(1028) && (e4 = cn.jiguang.bb.a.e(context)) != null) {
                jSONObject.put("cid_box", e4);
            }
            if (cn.jiguang.ar.a.a().e(1029)) {
                jSONObject.put("ncid_box", cn.jiguang.bb.a.f(context));
            }
            if (cn.jiguang.ar.a.a().e(1030)) {
                jSONObject.put("boot_id", cn.jiguang.ag.a.w(context));
            }
            if (cn.jiguang.ar.a.a().e(1031)) {
                jSONObject.put("media_drm_id", cn.jiguang.ag.a.x(context));
            }
            if (cn.jiguang.ar.a.a().e(1032)) {
                jSONObject.put("first_boot", cn.jiguang.ag.a.y(context));
            }
            jSONObject.put("android_ver", Build.VERSION.SDK_INT);
            jSONObject.put("android_target_ver", context.getApplicationInfo().targetSdkVersion);
            return jSONObject;
        } catch (JSONException e5) {
            sb = new StringBuilder();
            sb.append("package json exception: ");
            message = e5.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JDevice", sb.toString());
            return null;
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("getDeviceInfo exception: ");
            message = th.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JDevice", sb.toString());
            return null;
        }
    }

    public static b d() {
        if (f2479c == null) {
            synchronized (b.class) {
                if (f2479c == null) {
                    f2479c = new b();
                }
            }
        }
        return f2479c;
    }

    private static String g(Context context) {
        try {
            String a4 = cn.jiguang.ah.d.a(context);
            String b4 = cn.jiguang.ah.d.b(context);
            PackageInfo a5 = cn.jiguang.ag.a.a(context, 0);
            String str = a5 == null ? "" : a5.versionName;
            String valueOf = a5 == null ? "" : String.valueOf(a5.versionCode);
            String a6 = cn.jiguang.ah.d.a();
            String valueOf2 = String.valueOf(cn.jiguang.ah.d.b());
            StringBuilder sb = new StringBuilder();
            sb.append(a4);
            sb.append(",");
            if (TextUtils.isEmpty(b4)) {
                b4 = "";
            }
            sb.append(b4);
            sb.append(",");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "";
            }
            sb.append(valueOf);
            sb.append(",");
            if (TextUtils.isEmpty(a6)) {
                a6 = "";
            }
            sb.append(a6);
            sb.append(",");
            if (TextUtils.isEmpty(valueOf2)) {
                valueOf2 = "";
            }
            sb.append(valueOf2);
            sb.append(",");
            TextUtils.isEmpty("");
            sb.append("");
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDevice", "getCurrentCondition throwable: " + th.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2480a = context;
        return "JDevice";
    }

    public void a(Context context, int i4) {
        cn.jiguang.ah.d.a(new a(context), i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (!cn.jiguang.ar.a.a().a(1000)) {
            cn.jiguang.w.a.b("JDevice", "will not report");
            return;
        }
        JSONObject c4 = c(context);
        this.f2481b = c4;
        if (c4 == null) {
            cn.jiguang.w.a.f("JDevice", "collect failed");
            return;
        }
        cn.jiguang.w.a.b("JDevice", "collect success:" + this.f2481b);
        super.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        JSONObject jSONObject = this.f2481b;
        if (jSONObject == null) {
            cn.jiguang.w.a.b("JDevice", "there are no data to report");
            return;
        }
        cn.jiguang.ah.d.a(context, jSONObject, "device_info");
        cn.jiguang.ah.d.a(context, this.f2481b, new cn.jiguang.ay.a(context, this.f2482d, str));
        this.f2481b = null;
    }

    @Override // cn.jiguang.ah.b
    public Object d(Context context) {
        return c(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        if (cn.jiguang.ah.c.c(context, str)) {
            JSONObject jSONObject = this.f2481b;
            if (jSONObject == null) {
                cn.jiguang.w.a.f("JDevice", "there are no data to report");
                return false;
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return false;
            }
            this.f2482d = cn.jiguang.ah.d.b(jSONObject2 + g(context));
            String i4 = cn.jiguang.ah.c.i(context);
            if (TextUtils.isEmpty(this.f2482d) || TextUtils.equals(this.f2482d, i4)) {
                cn.jiguang.w.a.b("JDevice", "device detail is not change");
                return false;
            }
            cn.jiguang.w.a.b("JDevice", "device detail is change");
            return super.d(context, str);
        }
        return false;
    }
}
