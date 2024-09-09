package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile h f2423c;

    /* renamed from: a  reason: collision with root package name */
    private Context f2424a;

    /* renamed from: b  reason: collision with root package name */
    private List<cn.jiguang.common.m.e> f2425b;

    private JSONArray a(List<cn.jiguang.common.m.e> list) {
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.common.m.e eVar : list) {
            JSONObject a4 = eVar.a(128);
            if (a4 != null) {
                jSONArray.put(a4);
            }
        }
        return jSONArray;
    }

    private boolean c(Context context) {
        boolean z3 = Build.VERSION.SDK_INT <= 28 && (cn.jiguang.ah.d.a(context, "android.permission.READ_EXTERNAL_STORAGE") || cn.jiguang.ah.d.a(context, "android.permission.WRITE_EXTERNAL_STORAGE"));
        cn.jiguang.w.a.b("JPackageList", "pl has permission is " + z3);
        return z3;
    }

    public static h d() {
        if (f2423c == null) {
            synchronized (h.class) {
                if (f2423c == null) {
                    f2423c = new h();
                }
            }
        }
        return f2423c;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2424a = context;
        return "JPackageList";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return cn.jiguang.ah.c.x(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (c(context) && cn.jiguang.ah.d.e()) {
            try {
                String v3 = cn.jiguang.ah.d.v(context);
                cn.jiguang.w.a.b("JPackageList", "Jpl dataDir is " + v3);
                if (TextUtils.isEmpty(v3)) {
                    return;
                }
                String[] list = new File(v3).list(new FilenameFilter() { // from class: cn.jiguang.as.h.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            return false;
                        }
                        return str2.matches("^([A-Za-z]{1}[A-Za-z\\d_]*\\.)+[A-Za-z][A-Za-z\\d_]*$");
                    }
                });
                if (list == null || list.length <= 0) {
                    cn.jiguang.w.a.f("JPackageList", "collect failed, pl is empty");
                    return;
                }
                if (this.f2425b == null) {
                    this.f2425b = new ArrayList();
                }
                for (String str2 : list) {
                    cn.jiguang.common.m.e eVar = new cn.jiguang.common.m.e();
                    eVar.f3507a = str2;
                    PackageInfo packageInfo = new PackageInfo();
                    packageInfo.packageName = str2;
                    eVar.f3508b = cn.jiguang.common.n.d.a(context, packageInfo, cn.jiguang.ap.b.f2348a);
                    eVar.f3509c = cn.jiguang.common.n.d.a(context, packageInfo, cn.jiguang.ap.b.f2349b);
                    eVar.f3510d = cn.jiguang.common.n.d.a(context, packageInfo, cn.jiguang.ap.b.f2350c);
                    try {
                        String[] split = cn.jiguang.common.n.d.b(str2).split("&");
                        eVar.f3511e = Long.parseLong(split[0]);
                        eVar.f3512f = Long.parseLong(split[1]);
                    } catch (Throwable unused) {
                    }
                    this.f2425b.add(eVar);
                }
                if (this.f2425b.size() > 0) {
                    cn.jiguang.w.a.b("JPackageList", "collect success, size is " + this.f2425b.size());
                    super.b(context, str);
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JPackageList", "package json exception:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        List<cn.jiguang.common.m.e> list;
        if (c(context) && cn.jiguang.ah.d.e()) {
            try {
                list = this.f2425b;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JPackageList", "package json exception:" + th.getMessage());
            }
            if (list != null && !list.isEmpty()) {
                JSONArray a4 = a(this.f2425b);
                super.c(context, str);
                ArrayList<JSONArray> a5 = cn.jiguang.common.n.d.a(a4);
                if (a5 != null && !a5.isEmpty()) {
                    int i4 = 0;
                    int size = a5.size();
                    while (i4 < size) {
                        JSONObject jSONObject = new JSONObject();
                        i4++;
                        jSONObject.put("slice_index", i4);
                        jSONObject.put("slice_count", size);
                        jSONObject.put("data", a5.get(i4));
                        cn.jiguang.ah.d.a(context, jSONObject, "package_list");
                        cn.jiguang.ah.d.a(context, (Object) jSONObject);
                        super.c(context, str);
                    }
                    this.f2425b = null;
                    return;
                }
                return;
            }
            cn.jiguang.w.a.f("JPackageList", "there are no data to report");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return cn.jiguang.ah.c.y(context, str);
    }
}
