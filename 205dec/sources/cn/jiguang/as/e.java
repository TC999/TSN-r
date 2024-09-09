package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static e f2408e;

    /* renamed from: a  reason: collision with root package name */
    private Context f2409a;

    /* renamed from: b  reason: collision with root package name */
    private a f2410b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Integer> f2411c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Integer> f2412d = new HashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f2413a;

        /* renamed from: b  reason: collision with root package name */
        private String f2414b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2415c;

        public a a(String str) {
            this.f2414b = str;
            return this;
        }

        public a a(boolean z3) {
            this.f2415c = z3;
            return this;
        }

        public String a() {
            return this.f2414b;
        }

        public a b(String str) {
            this.f2413a = str;
            return this;
        }

        public boolean b() {
            return this.f2415c;
        }

        public String c() {
            return this.f2413a;
        }
    }

    private String a(String str) {
        try {
            return str.split("\\|")[0];
        } catch (Throwable unused) {
            return str;
        }
    }

    private int b(String str) {
        HashMap<String, Integer> hashMap = this.f2411c;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, Integer> entry : this.f2411c.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getValue().intValue();
                }
            }
        }
        return -1;
    }

    public static e d() {
        if (f2408e == null) {
            synchronized (e.class) {
                if (f2408e == null) {
                    f2408e = new e();
                }
            }
        }
        return f2408e;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2409a = context;
        return "JAppProbe";
    }

    public void a(a aVar) {
        this.f2410b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (System.currentTimeMillis() < cn.jiguang.ah.d.f(context) + 604800000) {
            cn.jiguang.w.a.b("JAppProbe", "can't probe because r time");
            return false;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        HashMap<String, Integer> hashMap;
        int i4;
        HashMap<String, Integer> hashMap2;
        int i5;
        HashMap<String, Integer> hashMap3;
        int i6;
        if (cn.jiguang.ar.a.a().e(1106)) {
            a aVar = this.f2410b;
            if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                cn.jiguang.w.a.b("JAppProbe", "not app probe, because config is null");
                return;
            }
            cn.jiguang.w.a.b("JAppProbe", "start probe, p idx: " + this.f2410b.a());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str2 : this.f2410b.a().split("&&")) {
                String[] split = str2.split("&");
                if (split != null && split.length > 1) {
                    this.f2411c.put(split[1], Integer.valueOf(Integer.parseInt(split[0])));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (cn.jiguang.common.n.d.a(context, false, (Object) arrayList) instanceof List) {
                cn.jiguang.w.a.b("JAppProbe", "app probe by list");
                for (String str3 : this.f2411c.keySet()) {
                    String a4 = a(str3);
                    if (arrayList.contains(a4)) {
                        hashMap3 = this.f2412d;
                        i6 = 1;
                    } else {
                        hashMap3 = this.f2412d;
                        i6 = 0;
                    }
                    hashMap3.put(a4, i6);
                }
            } else if (!this.f2410b.b()) {
                cn.jiguang.w.a.b("JAppProbe", "app probe by dy activity");
                for (String str4 : this.f2411c.keySet()) {
                    String a5 = a(str4);
                    if (cn.jiguang.ag.a.g(context, str4)) {
                        hashMap = this.f2412d;
                        i4 = 1;
                    } else {
                        hashMap = this.f2412d;
                        i4 = 0;
                    }
                    hashMap.put(a5, i4);
                }
            } else if (cn.jiguang.common.n.d.d(context)) {
                cn.jiguang.w.a.b("JAppProbe", "app probe by launch intent");
                for (String str5 : this.f2411c.keySet()) {
                    String a6 = a(str5);
                    if (cn.jiguang.ag.a.f(context, a6)) {
                        hashMap2 = this.f2412d;
                        i5 = 1;
                    } else {
                        hashMap2 = this.f2412d;
                        i5 = 0;
                    }
                    hashMap2.put(a6, i5);
                }
            } else {
                cn.jiguang.w.a.b("JAppProbe", "it can't probe app by launch intent, because no QUERY_ALL_PACKAGES permission on android R");
            }
            cn.jiguang.w.a.b("JAppProbe", "app probe completed and cost time: " + (System.currentTimeMillis() - currentTimeMillis));
            super.b(context, str);
        }
    }

    public String c(Context context) {
        String c4 = cn.jiguang.ao.e.c(context, "prb.catch");
        if (TextUtils.isEmpty(c4)) {
            return null;
        }
        try {
            return new String(cn.jiguang.ap.b.a(c4, a.C0049a.f2221j, a.C0049a.f2222k), "UTF-8");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JAppProbe", "readProbesFromCache failed, " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().e(1106)) {
            if (this.f2412d.size() == 0) {
                cn.jiguang.w.a.b("JAppProbe", "no probe data to report");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.f2412d.keySet()) {
                int b4 = b(str2);
                int intValue = this.f2412d.get(str2).intValue();
                sb.append(b4);
                sb.append("&");
                sb.append(intValue);
                sb.append("|");
            }
            int length = sb.length();
            sb.delete(length - 1, length);
            cn.jiguang.w.a.b("JAppProbe", "probe data package ready and start to report, data: " + ((Object) sb));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", sb);
                cn.jiguang.ah.d.a(context, jSONObject, "app_probe");
                cn.jiguang.ah.d.a(context, (Object) jSONObject);
                this.f2412d.clear();
                super.c(context, str);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JAppProbe", "report probe data failed, error: " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return true;
    }

    public a e() {
        return this.f2410b;
    }

    public void f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cn.jiguang.ao.e.a(context, "prb.catch", cn.jiguang.ap.b.a(str.getBytes(), a.C0049a.f2221j, a.C0049a.f2222k));
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JAppProbe", "writeProbesToCache failed, " + th.getMessage());
        }
    }
}
