package cn.jiguang.cf;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ci.e;
import cn.jiguang.ci.f;
import cn.jiguang.ci.g;
import cn.jiguang.ci.h;
import cn.jiguang.ci.j;
import cn.jiguang.cm.d;
import cn.jiguang.internal.JConstants;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import com.stub.StubApp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static volatile c f3393d;

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, cn.jiguang.cg.a> f3394a;

    /* renamed from: c  reason: collision with root package name */
    private Context f3396c;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f3395b = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private String f3397e = "netmt.catch.";

    private c() {
    }

    public static c a() {
        if (f3393d == null) {
            synchronized (c.class) {
                if (f3393d == null) {
                    f3393d = new c();
                }
            }
        }
        return f3393d;
    }

    private void a(final cn.jiguang.cg.a aVar) {
        d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.c.1
            @Override // cn.jiguang.cm.b
            public void a() {
                JSONArray jSONArray;
                try {
                    synchronized (c.class) {
                        JSONObject b4 = aVar.b();
                        cn.jiguang.bq.d.c("NetMoniterManager", "save moniter data:" + b4);
                        JSONObject c4 = c.this.c();
                        if (c4 != null && c4.has("data")) {
                            jSONArray = c4.optJSONArray("data");
                            jSONArray.put(b4);
                            c4.put("data", jSONArray);
                            c.this.a(c4);
                        }
                        c4 = new JSONObject();
                        c4.put("type", "sdk_moniter");
                        jSONArray = new JSONArray();
                        jSONArray.put(b4);
                        c4.put("data", jSONArray);
                        c.this.a(c4);
                    }
                } catch (Throwable th) {
                    cn.jiguang.bq.d.i("NetMoniterManager", "save data error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        try {
            Object onEvent = JCoreManager.onEvent(this.f3396c, JConstants.SDK_TYPE, 41, null, null, this.f3397e, jSONObject);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("NetMoniterManager", "writeJson throwable:" + th.getMessage());
            return false;
        }
    }

    private void b() {
        d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.c.2
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    synchronized (c.class) {
                        JSONObject c4 = c.this.c();
                        if (c4 != null && c4.has("data")) {
                            cn.jiguang.bq.d.c("NetMoniterManager", "start report moniter data");
                            JCoreManager.onEvent(c.this.f3396c, JConstants.SDK_TYPE, 39, null, null, cn.jiguang.d.a.a(c.this.f3396c, c4, "sdk_moniter"));
                            if (!c.this.a((JSONObject) null)) {
                                c.this.f3396c.deleteFile(c.this.f3397e);
                            }
                        }
                    }
                } catch (Throwable th) {
                    cn.jiguang.bq.d.i("NetMoniterManager", "save data error:" + th.getMessage());
                }
            }
        });
    }

    private boolean b(Context context) {
        a(context);
        return this.f3395b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c() {
        try {
            Object onEvent = JCoreManager.onEvent(this.f3396c, JConstants.SDK_TYPE, 42, null, null, this.f3397e);
            if (onEvent instanceof JSONObject) {
                return (JSONObject) onEvent;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("NetMoniterManager", "readJson throwable:" + th.getMessage());
            return null;
        }
    }

    public String a(Context context, HttpRequest httpRequest, boolean z3) {
        String str = "";
        try {
            if (b(context)) {
                j jVar = new j(this.f3396c);
                jVar.a(httpRequest, z3);
                str = jVar.c();
                this.f3394a.put(str, jVar);
                return str;
            }
            return "";
        } catch (Throwable th) {
            cn.jiguang.bq.d.c("NetMoniterManager", "httpStart wrong:" + th.getMessage());
            return str;
        }
    }

    public String a(String str) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                cn.jiguang.ci.a aVar = new cn.jiguang.ci.a(this.f3396c);
                aVar.a(str);
                str2 = aVar.c();
                this.f3394a.put(str2, aVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "dnsStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public String a(String str, int i4, int i5) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                cn.jiguang.ci.d dVar = new cn.jiguang.ci.d(this.f3396c);
                dVar.a(str, i4, i5 + "");
                str2 = dVar.c();
                this.f3394a.put(str2, dVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpConnStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public String a(String str, int i4, int i5, int i6) {
        if (this.f3395b.get()) {
            try {
                e eVar = new e(this.f3396c);
                eVar.a(str, i4, i5 + "", i6);
                a(eVar);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpDisconnect wrong:" + th.getMessage());
            }
        }
        return "";
    }

    public void a(Context context) {
        if (this.f3396c == null) {
            synchronized (c.class) {
                this.f3396c = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f3395b.set(((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.aA())).booleanValue());
                this.f3397e += cn.jiguang.f.a.a(this.f3396c).replace(this.f3396c.getPackageName(), "");
                cn.jiguang.bq.d.c("NetMoniterManager", "init state :" + this.f3395b.get());
                if (this.f3395b.get()) {
                    this.f3394a = new ConcurrentHashMap<>();
                    b();
                } else {
                    this.f3396c.deleteFile(this.f3397e);
                }
            }
        }
    }

    public void a(Context context, String str, HttpResponse httpResponse) {
        cn.jiguang.cg.a remove;
        try {
            if (!b(context) || TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof j)) {
                return;
            }
            ((j) remove).a(httpResponse);
            a(remove);
        } catch (Throwable th) {
            cn.jiguang.bq.d.c("NetMoniterManager", "httpEnd wrong:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z3) {
        a(context);
        synchronized (c.class) {
            if (this.f3395b.get() != z3) {
                this.f3395b.set(z3);
                cn.jiguang.g.b.a(this.f3396c, cn.jiguang.g.a.aA().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
                cn.jiguang.bq.d.c("NetMoniterManager", "change state :" + this.f3395b.get());
                if (this.f3395b.get()) {
                    this.f3394a = new ConcurrentHashMap<>();
                } else {
                    this.f3394a = null;
                }
            }
        }
    }

    public void a(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof cn.jiguang.ci.a)) {
                    return;
                }
                ((cn.jiguang.ci.a) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "dnsEnd wrong:" + th.getMessage());
            }
        }
    }

    public String b(String str, int i4) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                cn.jiguang.ci.c cVar = new cn.jiguang.ci.c(this.f3396c);
                cVar.a(str, i4);
                str2 = cVar.c();
                this.f3394a.put(str2, cVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "sisStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public String b(String str, int i4, int i5) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                g gVar = new g(this.f3396c);
                gVar.a(str, i4, i5 + "");
                str2 = gVar.c();
                this.f3394a.put(str2, gVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpRegisterStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public String c(String str, int i4, int i5) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                f fVar = new f(this.f3396c);
                fVar.a(str, i4, i5 + "");
                str2 = fVar.c();
                this.f3394a.put(str2, fVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpLoginStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public void c(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof cn.jiguang.ci.c)) {
                    return;
                }
                ((cn.jiguang.ci.c) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "sisEnd wrong:" + th.getMessage());
            }
        }
    }

    public String d(String str, int i4, int i5) {
        String str2 = "";
        if (this.f3395b.get()) {
            try {
                h hVar = new h(this.f3396c);
                hVar.a(str, i4, i5 + "");
                str2 = hVar.c();
                this.f3394a.put(str2, hVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpReportStart wrong:" + th.getMessage());
                return str2;
            }
        }
        return "";
    }

    public void d(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof cn.jiguang.ci.d)) {
                    return;
                }
                ((cn.jiguang.ci.d) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpConnEnd wrong:" + th.getMessage());
            }
        }
    }

    public void e(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof g)) {
                    return;
                }
                ((g) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpRegisterEnd wrong:" + th.getMessage());
            }
        }
    }

    public void f(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof f)) {
                    return;
                }
                ((f) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpLoginEnd wrong:" + th.getMessage());
            }
        }
    }

    public void g(String str, int i4) {
        cn.jiguang.cg.a remove;
        if (this.f3395b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f3394a.remove(str)) == null || !(remove instanceof h)) {
                    return;
                }
                ((h) remove).a(i4);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bq.d.c("NetMoniterManager", "tcpReportEnd wrong:" + th.getMessage());
            }
        }
    }
}
