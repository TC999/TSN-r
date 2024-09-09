package com.qq.e.comm.plugin.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.n0.w.f;
import com.qq.e.comm.plugin.q0.d;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.j;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.l0;
import com.qq.e.comm.plugin.util.m0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a extends j implements View.OnTouchListener {

    /* renamed from: d  reason: collision with root package name */
    protected e f42116d;

    /* renamed from: e  reason: collision with root package name */
    protected h f42117e;

    /* renamed from: f  reason: collision with root package name */
    protected final long f42118f;

    /* renamed from: g  reason: collision with root package name */
    protected com.qq.e.comm.plugin.n0.c f42119g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42121i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f42122j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f42123k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f42124l;

    /* renamed from: m  reason: collision with root package name */
    protected String f42125m;

    /* renamed from: n  reason: collision with root package name */
    private long f42126n;

    /* renamed from: o  reason: collision with root package name */
    private long f42127o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f42128p;

    /* renamed from: q  reason: collision with root package name */
    private String f42129q;

    /* renamed from: r  reason: collision with root package name */
    private int f42130r;

    /* renamed from: s  reason: collision with root package name */
    private long f42131s;

    /* renamed from: c  reason: collision with root package name */
    protected int f42115c = 1;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f42120h = true;

    /* renamed from: t  reason: collision with root package name */
    private int f42132t = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0794a implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f42133a;

        C0794a(long j4) {
            this.f42133a = j4;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if ("true".equals(str)) {
                a.this.a(4003048, this.f42133a, 1);
            } else {
                a.this.a(4003049, this.f42133a, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f42135a;

        b(long j4) {
            this.f42135a = j4;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (TextUtils.isEmpty(str)) {
                a.this.a(4003049, this.f42135a, 3);
                return;
            }
            a.this.a(4003048, this.f42135a, 3);
            if ("true".equals(str)) {
                return;
            }
            a.this.f42123k = false;
            a.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f42137a;

        c(long j4) {
            this.f42137a = j4;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            int length;
            int optInt;
            a.this.d();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.this.a(4003048, this.f42137a, 2);
                JSONArray optJSONArray = jSONObject.optJSONArray("event_report");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        if (jSONObject2 != null && (optInt = jSONObject2.optInt("eventId")) != 0) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("biz");
                            if (optJSONObject != null) {
                                optJSONObject.remove("traceid");
                            }
                            f.a(optInt, a.this.f42128p, a.this.f42115c, a.this.f42119g, optJSONObject);
                        }
                    }
                }
            } catch (JSONException e4) {
                d1.a(e4.getMessage(), e4);
                a.this.a(4003049, this.f42137a, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Activity activity) {
        this.f42118f = activity.getIntent().getLongExtra("landingPageStartTime", System.currentTimeMillis());
        this.f42125m = activity.getIntent().getStringExtra("url");
    }

    private void f() {
        if (!this.f42121i || this.f42122j || !this.f42123k || this.f42117e == null) {
            return;
        }
        this.f42122j = true;
        long currentTimeMillis = System.currentTimeMillis();
        f.a(4003047, this.f42128p, this.f42115c, this.f42119g, 0L, 3);
        this.f42117e.a("typeof __TG_GET_PAGE_PERFORMANCE__ === \"function\"", new b(currentTimeMillis));
    }

    private void g() {
        if (this.f42121i && this.f42117e != null) {
            a(4003047, 0L, 2);
            this.f42117e.a("__TG_GET_PAGE_PERFORMANCE__()", new c(System.currentTimeMillis()));
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f42121i || this.f42123k || this.f42117e == null) {
            return;
        }
        this.f42123k = true;
        String replace = f.a().replace("__CLICK_TIME__", String.valueOf(this.f42118f));
        long currentTimeMillis = System.currentTimeMillis();
        a(4003047, 0L, 1);
        this.f42117e.a(replace, new C0794a(currentTimeMillis));
    }

    private void i() {
        int i4 = this.f42132t;
        if (i4 != 4 && i4 != 5) {
            if (i4 != 3) {
                b(4003023);
            } else if (!this.f42124l) {
                b(4003024);
            } else {
                b(4003026);
            }
            this.f42132t = 5;
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(String str) {
        if (this.f42117e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f42131s = System.currentTimeMillis();
        if (this.f42120h && !TextUtils.isEmpty(f.a())) {
            this.f42121i = true;
        }
        b(4003008);
        this.f42117e.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        c();
        h hVar = this.f42117e;
        if (hVar == null || !hVar.canGoBack()) {
            return false;
        }
        this.f42117e.goBack();
        return true;
    }

    protected final void j() {
        int i4 = this.f42132t;
        if (i4 == 4 || i4 == 3) {
            return;
        }
        this.f42132t = 3;
        b(4003010);
    }

    protected final void k() {
        this.f42124l = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        this.f42127o = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        if (this.f42127o > 0) {
            this.f42126n += System.currentTimeMillis() - this.f42127o;
            this.f42127o = 0L;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        k();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f42116d = eVar;
        this.f42119g = com.qq.e.comm.plugin.n0.c.a(eVar);
        String x3 = eVar.x();
        this.f42129q = x3;
        this.f42128p = i2.a(this.f42125m, x3);
        this.f42130r = l0.a(eVar);
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void c(String str) {
        super.c(str);
        j();
    }

    private void c() {
        this.f42123k = false;
        this.f42122j = false;
    }

    private void e(String str) {
        if (this.f42125m.equals(str)) {
            this.f42132t = 4;
            b(4003009);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
        super.a(str, bitmap);
        if (this.f42128p && i2.a(str, this.f42129q)) {
            return;
        }
        if (this.f42132t == 1) {
            this.f42132t = 2;
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        int i4 = this.f42132t;
        if (i4 != 3 && i4 != 4) {
            r1 = System.currentTimeMillis() - this.f42131s > ((long) this.f42130r);
            if (!r1) {
                m0.b(this.f42119g, this.f42116d);
            }
        }
        return r1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        h hVar = this.f42117e;
        if (hVar != null) {
            hVar.e();
            this.f42117e = null;
        }
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
        super.a(i4);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i4) {
        if (this.f42120h) {
            long j4 = this.f42118f;
            if (i4 == 4003026) {
                j4 += this.f42126n;
            }
            f.a(i4, this.f42128p, this.f42115c, this.f42119g, j4);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
        super.a(i4, str, str2);
        e(str2);
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f.a
    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.a(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return;
        }
        e(webResourceRequest.getUrl().toString());
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(String str) {
        super.a(str);
        if (this.f42132t == 4) {
            this.f42132t = 1;
        }
        if (i2.a(this.f42125m, this.f42129q)) {
            this.f42125m = str;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final h a(Activity activity, e eVar) {
        h hVar;
        try {
            b(4003005);
            hVar = new d(activity, eVar).a();
            try {
                b(4003007);
                hVar.a(this);
                hVar.a().setOnTouchListener(this);
                if (a(eVar)) {
                    hVar.d(true);
                }
            } catch (Throwable unused) {
                b(4003006);
                return hVar;
            }
        } catch (Throwable unused2) {
            hVar = null;
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, long j4, int i5) {
        if (this.f42120h) {
            f.a(i4, this.f42128p, this.f42115c, this.f42119g, j4, i5);
        }
    }

    private boolean a(e eVar) {
        String[] split;
        String a4 = com.qq.e.comm.plugin.t.c.a("dtlvampa", eVar.q0(), "1,4,10", eVar.p0());
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        for (String str : a4.split(",")) {
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(eVar.G()))) {
                return true;
            }
        }
        return false;
    }
}
