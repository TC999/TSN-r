package cn.jiguang.ac;

import android.annotation.SuppressLint;
import android.content.Context;
import cn.jiguang.af.g;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f2063b;

    /* renamed from: a  reason: collision with root package name */
    private Context f2064a;

    /* renamed from: c  reason: collision with root package name */
    private cn.jiguang.ad.a f2065c;

    public static d d() {
        if (f2063b == null) {
            synchronized (d.class) {
                if (f2063b == null) {
                    f2063b = new d();
                }
            }
        }
        return f2063b;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2064a = context;
        g.f2138a = true;
        return "JWakeReport";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        this.f2065c = cn.jiguang.af.b.b(context);
        super.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (this.f2065c.f2088w) {
            JSONArray b4 = cn.jiguang.af.c.b(context);
            if (b4 == null || b4.length() == 0) {
                cn.jiguang.w.a.b("JWakeReport", "no report wakeData");
            } else {
                cn.jiguang.w.a.b("JWakeReport", "report wakeData:" + b4);
                cn.jiguang.ah.d.a(context, b4);
                cn.jiguang.af.c.c(context);
                super.c(context, str);
            }
        } else {
            cn.jiguang.w.a.f("JWakeReport", "server set do not report wake data.");
        }
        if (!this.f2065c.f2089x) {
            cn.jiguang.w.a.f("JWakeReport", "server set do not report waked data.");
            return;
        }
        JSONArray a4 = g.a(context);
        if (a4 == null || a4.length() == 0) {
            cn.jiguang.w.a.b("JWakeReport", "no report wakedData");
            return;
        }
        cn.jiguang.w.a.b("JWakeReport", "report wakedData:" + a4);
        cn.jiguang.ah.d.a(context, a4);
        g.b(context);
        super.c(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return cn.jiguang.ah.c.d(context, str);
    }
}
