package cn.jiguang.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile g f3868b;

    /* renamed from: a  reason: collision with root package name */
    private Context f3869a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends cn.jiguang.ah.e {

        /* renamed from: b  reason: collision with root package name */
        private Context f3871b;

        public a(Context context) {
            this.f3871b = context;
            this.f2244d = "JLocationv2#RequestConfigAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            String b4 = f.a().b(this.f3871b);
            cn.jiguang.ah.c.e(this.f3871b, "JLocationv2_cfg");
            if (TextUtils.isEmpty(b4)) {
                return;
            }
            f.a(this.f3871b, b4);
            cn.jiguang.ah.c.w(this.f3871b, b4);
            g.this.b(this.f3871b, "JLocationv2");
        }
    }

    public static g a() {
        if (f3868b == null) {
            synchronized (g.class) {
                if (f3868b == null) {
                    f3868b = new g();
                }
            }
        }
        return f3868b;
    }

    private boolean c(Context context) {
        return (cn.jiguang.ah.d.a(context, "android.permission.ACCESS_COARSE_LOCATION") || cn.jiguang.ah.d.a(context, "android.permission.ACCESS_FINE_LOCATION")) && cn.jiguang.ah.d.o(context);
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f3869a = context;
        if (cn.jiguang.ar.a.a().a(1500)) {
            try {
                String l4 = cn.jiguang.ah.c.l(context);
                cn.jiguang.w.a.b("JLocationv2", "locationConfig:" + l4);
                f.a(context, l4);
                if (System.currentTimeMillis() - cn.jiguang.ah.c.f(context, "JLocationv2_cfg") > 86400000) {
                    a(context, cn.jiguang.t.a.a().b(true));
                }
            } catch (Throwable unused) {
            }
            return "JLocationv2";
        }
        return "JLocationv2";
    }

    public void a(Context context, int i4) {
        if (!c()) {
            cn.jiguang.y.a.a(context, "loc_info_v2", -4);
            return;
        }
        try {
            cn.jiguang.ah.d.a(new a(context), i4);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationv2", "[requestConfig failed] " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return cn.jiguang.ar.a.a().a(1500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (!cn.jiguang.ar.a.a().a(1500)) {
            cn.jiguang.y.a.a(context, "loc_info_v2", -3);
        } else if (!c(context)) {
            cn.jiguang.y.a.a(context, "loc_info_v2", -5);
        } else {
            cn.jiguang.w.a.b("JLocationv2", " doBusiness , gpsEnanble:" + e.f3848b + ",wifiEnanble :" + e.f3847a + ",cellEnanble:" + e.f3849c);
            if (!e.f3848b || !cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
                cn.jiguang.y.a.a(context, "loc_info_v2", "g", !e.f3848b ? 1 : -3);
            } else if (cn.jiguang.ah.c.b(context, "JLocationv2_g")) {
                h.a(context).b();
                h.a(context).c();
                cn.jiguang.ah.c.e(context, "JLocationv2_g");
            }
            if (!e.f3847a || !cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                cn.jiguang.y.a.a(context, "loc_info_v2", "w", !e.f3847a ? 1 : -3);
            } else if (cn.jiguang.ah.c.b(context, "JLocationv2_w")) {
                h.a(context).a();
                cn.jiguang.ah.c.e(context, "JLocationv2_w");
            }
            if (!e.f3849c || !cn.jiguang.ar.a.a().e(1501)) {
                cn.jiguang.y.a.a(context, "loc_info_v2", "c", e.f3849c ? -3 : 1);
            } else if (cn.jiguang.ah.c.b(context, "JLocationv2_c")) {
                h.a(context).d();
                cn.jiguang.ah.c.e(context, "JLocationv2_c");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean b() {
        return cn.jiguang.ah.c.k(this.f3869a, "JLocationv2");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().a(1500) && c(context)) {
            JSONObject e4 = h.a(context).e();
            if (e4 == null) {
                cn.jiguang.w.a.b("JLocationv2", "there are no data to report");
                return;
            }
            cn.jiguang.ah.d.a(context, e4, "loc_info_v2");
            cn.jiguang.ah.d.a(context, (Object) e4);
            cn.jiguang.w.a.b("JLocationv2", "clean cache");
            h.a(context).f();
            super.c(context, str);
        }
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        boolean i4 = cn.jiguang.h.a.i(this.f3869a);
        if (cn.jiguang.ar.a.a().a(1500) && i4) {
            return cn.jiguang.ah.c.l(this.f3869a, "JLocation");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        if (cn.jiguang.ar.a.a().a(1500)) {
            return cn.jiguang.ah.c.d(context, str);
        }
        return false;
    }
}
