package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends cn.jiguang.ah.b {

    /* renamed from: a  reason: collision with root package name */
    public static int f2384a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f2385b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f2386c = 0;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f2387d = null;

    /* renamed from: i  reason: collision with root package name */
    private static int f2388i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static int f2389j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static int f2390k;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f2391e = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private boolean f2392f = false;

    /* renamed from: g  reason: collision with root package name */
    private Context f2393g;

    /* renamed from: h  reason: collision with root package name */
    private List<cn.jiguang.common.m.d> f2394h;

    private JSONArray a(List<cn.jiguang.common.m.d> list) {
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.common.m.d dVar : list) {
            JSONObject a4 = dVar.a(128);
            if (a4 != null) {
                jSONArray.put(a4);
            }
        }
        return jSONArray;
    }

    public static b d() {
        if (f2387d == null) {
            synchronized (b.class) {
                if (f2387d == null) {
                    f2387d = new b();
                }
            }
        }
        return f2387d;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2393g = context;
        return "JAppAll";
    }

    public void a(int i4) {
        f2386c = i4;
    }

    public void a(boolean z3) {
        this.f2392f = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (this.f2391e.get()) {
            return true;
        }
        if (this.f2392f) {
            cn.jiguang.w.a.b("JAppAll", "isBusinessEnable isCmd true");
            return true;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (this.f2392f || !cn.jiguang.ar.a.a().g(1100)) {
            this.f2391e.set(false);
            cn.jiguang.w.a.b("JAppAll", "doBusiness isCmd :" + this.f2392f);
            List<cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(context, true, true, this.f2392f);
            this.f2394h = a4;
            if (a4 == null || a4.isEmpty()) {
                cn.jiguang.w.a.f("JAppAll", "collect failed, installedAppList is empty");
                return;
            }
            cn.jiguang.w.a.b("JAppAll", "collect success");
            super.b(context, str);
            String a5 = cn.jiguang.common.n.d.a((Collection<cn.jiguang.common.m.d>) this.f2394h);
            if (TextUtils.isEmpty(a5)) {
                return;
            }
            cn.jiguang.w.a.b("JAppAll", "save appList [" + a5 + "]");
            cn.jiguang.ao.e.d(context, "bal.catch");
            cn.jiguang.ao.e.a(context, "bal.catch", a5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean b() {
        if (this.f2392f) {
            cn.jiguang.w.a.b("JAppAll", "isActionCommandEnable isCmd true");
            return true;
        }
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject, java.lang.Object] */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        int i4;
        List<cn.jiguang.common.m.d> list;
        ArrayList<JSONArray> a4;
        if (this.f2392f) {
            i4 = f2389j;
        } else if (cn.jiguang.ar.a.a().g(1100)) {
            return;
        } else {
            i4 = f2388i;
        }
        f2390k = i4;
        int i5 = 0;
        a(false);
        try {
            list = this.f2394h;
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JAppAll", "package json exception:" + e4.getMessage());
        }
        if (list != null && !list.isEmpty()) {
            JSONArray a5 = a(this.f2394h);
            if (a5 != null && a5.length() != 0 && (a4 = cn.jiguang.common.n.d.a(a5)) != null && !a4.isEmpty()) {
                boolean d4 = cn.jiguang.common.n.d.d(context);
                ?? r3 = d4;
                if (d4) {
                    r3 = d4;
                    if (this.f2394h.size() == 1) {
                        r3 = 2;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(f2390k);
                jSONArray.put(f2386c);
                int size = a4.size();
                while (i5 < size) {
                    ?? jSONObject = new JSONObject();
                    i5++;
                    jSONObject.put("slice_index", i5);
                    jSONObject.put("slice_count", size);
                    jSONObject.put("sources", jSONArray);
                    jSONObject.put("query_permission", r3);
                    jSONObject.put("data", a4.get(i5));
                    cn.jiguang.ah.d.a(context, (JSONObject) jSONObject, "app_list");
                    cn.jiguang.ah.d.a(context, (Object) jSONObject);
                    super.c(context, str);
                }
                this.f2394h = null;
                return;
            }
            return;
        }
        cn.jiguang.w.a.f("JAppAll", "there are no data to report");
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        if (this.f2392f) {
            cn.jiguang.w.a.b("JAppAll", "isActionUserEnable isCmd true");
            return true;
        }
        return cn.jiguang.ar.a.a().e(1100);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        if (this.f2392f) {
            cn.jiguang.w.a.b("JAppAll", "isReportEnable isCmd true");
            return true;
        }
        return super.d(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean e(Context context, String str) {
        if (this.f2392f) {
            cn.jiguang.w.a.b("JAppAll", "isProtectionTime isCmd true");
            return true;
        }
        return super.e(context, str);
    }
}
