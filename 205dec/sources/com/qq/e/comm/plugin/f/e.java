package com.qq.e.comm.plugin.f;

import android.content.Context;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.u1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    private static final String f43037f = "e";

    /* renamed from: g  reason: collision with root package name */
    private static final e f43038g = new e();

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f43039a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f43040b = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Long> f43043e = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.f.a f43041c = new com.qq.e.comm.plugin.f.d();

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.f.a f43042d = new g();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(com.qq.e.comm.plugin.d0.a.d().a(), true);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f43045a;

        b(Context context) {
            this.f43045a = context;
        }

        @Override // com.qq.e.comm.plugin.f.a.b
        public void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("sr");
            String optString2 = jSONObject.optString("r");
            ArrayList arrayList = new ArrayList();
            e.a(e.this, this.f43045a, optString, arrayList, 3);
            e.a(e.this, this.f43045a, optString2, arrayList, 2);
            e.a(e.this, this.f43045a, arrayList, 1);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f43047c;

        c(Context context) {
            this.f43047c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(e.this, this.f43047c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f43049a;

        d(Context context) {
            this.f43049a = context;
        }

        @Override // com.qq.e.comm.plugin.f.a.b
        public void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("s");
            ArrayList arrayList = new ArrayList();
            e.a(e.this, this.f43049a, optString, arrayList, 1);
            e.a(e.this, this.f43049a, arrayList, 2);
            u1.b("wlrt", System.currentTimeMillis());
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.f.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0817e extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43051a;

        C0817e(e eVar, int i4) {
            this.f43051a = i4;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            d1.a(e.a(), "\u4e0a\u62a5\u6210\u529f: reportScene = %s", Integer.valueOf(this.f43051a));
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            String a4 = e.a();
            d1.b(a4, "\u4e0a\u62a5\u5931\u8d25, reportScene = " + this.f43051a);
            if (this.f43051a == 2) {
                u1.a("wlrt");
            }
            v.a(9200004, null, Integer.valueOf(this.f43051a), Integer.valueOf(i4), null);
        }
    }

    private e() {
    }

    private long a(Context context, String str) {
        return pro.getJresult(21, 0, this, context, str);
    }

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(22, 1, new Object[0]);
    }

    private void a(int i4, m mVar, JSONObject jSONObject, int i5) {
        pro.getVresult(23, 0, this, Integer.valueOf(i4), mVar, jSONObject, Integer.valueOf(i5));
    }

    private void a(Context context, String str, long j4, m mVar, int i4) {
        pro.getVresult(24, 0, this, context, str, Long.valueOf(j4), mVar, Integer.valueOf(i4));
    }

    private void a(Context context, String str, List<JSONObject> list, int i4) {
        pro.getVresult(25, 0, this, context, str, list, Integer.valueOf(i4));
    }

    private void a(Context context, List<JSONObject> list, int i4) {
        pro.getVresult(26, 0, this, context, list, Integer.valueOf(i4));
    }

    private void a(Context context, JSONArray jSONArray, int i4) {
        pro.getVresult(27, 0, this, context, jSONArray, Integer.valueOf(i4));
    }

    static /* synthetic */ void a(e eVar, Context context) {
        pro.getVresult(28, 1, eVar, context);
    }

    static /* synthetic */ void a(e eVar, Context context, String str, List list, int i4) {
        pro.getVresult(29, 1, eVar, context, str, list, Integer.valueOf(i4));
    }

    static /* synthetic */ void a(e eVar, Context context, List list, int i4) {
        pro.getVresult(30, 1, eVar, context, list, Integer.valueOf(i4));
    }

    private void a(j0 j0Var, String str, long j4) {
        pro.getVresult(31, 0, this, j0Var, str, Long.valueOf(j4));
    }

    private void b(Context context, boolean z3) {
        pro.getVresult(32, 0, this, context, Boolean.valueOf(z3));
    }

    private void c(Context context) {
        pro.getVresult(33, 0, this, context);
    }

    public static e d() {
        return (e) pro.getobjresult(34, 1, new Object[0]);
    }

    private void d(Context context) {
        pro.getVresult(35, 0, this, context);
    }

    private void e(Context context) {
        pro.getVresult(36, 0, this, context);
    }

    j0 a(Context context) {
        return (j0) pro.getobjresult(37, 0, this, context);
    }

    public void a(Context context, boolean z3) {
        pro.getVresult(38, 0, this, context, Boolean.valueOf(z3));
    }

    public void a(String str, m mVar) {
        pro.getVresult(39, 0, this, str, mVar);
    }

    public void a(String str, boolean z3) {
        pro.getVresult(40, 0, this, str, Boolean.valueOf(z3));
    }

    public void b() {
        pro.getVresult(41, 0, this);
    }

    public void b(Context context) {
        pro.getVresult(42, 0, this, context);
    }

    public JSONObject c() {
        return (JSONObject) pro.getobjresult(43, 0, this);
    }

    public void e() {
        pro.getVresult(44, 0, this);
    }
}
