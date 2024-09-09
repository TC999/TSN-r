package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f2405c;

    /* renamed from: a  reason: collision with root package name */
    private List<cn.jiguang.common.m.d> f2406a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2407b;

    public static d d() {
        if (f2405c == null) {
            synchronized (d.class) {
                if (f2405c == null) {
                    f2405c = new d();
                }
            }
        }
        return f2405c;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2407b = context;
        return "JAppPermission";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1300)) {
            return;
        }
        this.f2406a = cn.jiguang.common.n.d.a(context, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        ArrayList<JSONArray> a4;
        if (cn.jiguang.ar.a.a().g(1300)) {
            return;
        }
        List<cn.jiguang.common.m.d> list = this.f2406a;
        if (list == null || list.size() == 0) {
            cn.jiguang.w.a.f("JAppPermission", "there are no data to report");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (cn.jiguang.common.m.d dVar : this.f2406a) {
                JSONObject b4 = dVar.b(128);
                if (b4 != null) {
                    jSONArray.put(b4);
                }
            }
            a4 = cn.jiguang.common.n.d.a(jSONArray);
        } catch (Throwable unused) {
        }
        if (a4 != null && !a4.isEmpty()) {
            int i4 = 0;
            int size = a4.size();
            while (i4 < size) {
                JSONObject jSONObject = new JSONObject();
                i4++;
                jSONObject.put("slice_index", i4);
                jSONObject.put("slice_count", size);
                jSONObject.put("pers_data", a4.get(i4));
                cn.jiguang.ah.d.a(context, jSONObject, "android_permissions");
                cn.jiguang.ah.d.a(context, (Object) jSONObject);
                super.c(context, str);
            }
            this.f2406a = null;
        }
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        cn.jiguang.w.a.b("JAppPermission", "for googlePlay:false");
        return cn.jiguang.ar.a.a().e(1300);
    }
}
