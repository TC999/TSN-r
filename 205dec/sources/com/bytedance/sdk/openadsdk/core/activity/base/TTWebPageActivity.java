package com.bytedance.sdk.openadsdk.core.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.bw;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.dislike.ui.c;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.xv.f;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.ck;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ux;
import com.bytedance.sdk.openadsdk.core.xk;
import com.bytedance.sdk.openadsdk.core.ys.c;
import com.bytedance.sdk.openadsdk.core.ys.sr;
import com.bytedance.sdk.openadsdk.k.xv;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTWebPageActivity extends Activity implements n.c, sr {
    private static final String xv = "TTWebPageActivity";

    /* renamed from: a  reason: collision with root package name */
    private TextView f31962a;
    private me ba;
    private LinearLayout bk;
    private xv bw;

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.dislike.ui.c f31963c;
    private boolean ck;
    private String eq;
    private TextView ev;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f31964f;
    private TTViewStub fp;
    private TTViewStub fz;
    private xk gb;
    private TextView gd;
    private com.bytedance.sdk.openadsdk.core.widget.c.sr gw;

    /* renamed from: i  reason: collision with root package name */
    private TTProgressBar f31965i;
    private TTViewStub ia;

    /* renamed from: j  reason: collision with root package name */
    private String f31966j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f31967k;
    private String ls;
    private Object me;
    private int mt;

    /* renamed from: n  reason: collision with root package name */
    private int f31969n;
    private int oo;

    /* renamed from: p  reason: collision with root package name */
    private TextView f31970p;
    private Activity pr;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f31971q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f31972r;

    /* renamed from: s  reason: collision with root package name */
    private TTViewStub f31973s;
    private SSWebView sr;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f31974t;

    /* renamed from: u  reason: collision with root package name */
    private Button f31975u;
    private boolean up;
    private ImageView ux;
    private boolean vc;

    /* renamed from: w  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.a.sr f31976w;

    /* renamed from: x  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f31977x;

    /* renamed from: y  reason: collision with root package name */
    private String f31978y;
    private Context ys;

    /* renamed from: z  reason: collision with root package name */
    private String f31979z;
    private int wv = 0;
    private int xk = 0;
    private AtomicBoolean yu = new AtomicBoolean(true);
    private JSONArray wx = null;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> f31968m = Collections.synchronizedMap(new HashMap());
    private final n au = new n(Looper.getMainLooper(), this);
    private String bj = "\u7acb\u5373\u4e0b\u8f7d";
    private com.bytedance.sdk.openadsdk.core.p.w.c bm = new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.c(tTWebPageActivity.f());
            c.C0525c.c(TTWebPageActivity.this.f31966j, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void w(long j4, long j5, String str, String str2) {
            TTWebPageActivity.this.c("\u6682\u505c");
            if (j4 > 0) {
                c.C0525c.c(TTWebPageActivity.this.f31966j, 2, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void xv(long j4, long j5, String str, String str2) {
            TTWebPageActivity.this.c("\u4e0b\u8f7d\u5931\u8d25");
            if (j4 > 0) {
                c.C0525c.c(TTWebPageActivity.this.f31966j, 4, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, long j5, String str, String str2) {
            TTWebPageActivity.this.c("\u4e0b\u8f7d\u4e2d...");
            String str3 = TTWebPageActivity.xv;
            a.w(str3, "onDownloadActive: totalBytes = " + j4 + "; currBytes = " + j5 + "; fileName=" + str);
            if (j4 > 0) {
                c.C0525c.c(TTWebPageActivity.this.f31966j, 3, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, String str, String str2) {
            TTWebPageActivity.this.c("\u70b9\u51fb\u5b89\u88c5");
            c.C0525c.c(TTWebPageActivity.this.f31966j, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(String str, String str2) {
            TTWebPageActivity.this.c("\u70b9\u51fb\u6253\u5f00");
            c.C0525c.c(TTWebPageActivity.this.f31966j, 6, 100);
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 extends com.bytedance.sdk.openadsdk.core.widget.c.sr {
        AnonymousClass1(Context context, xk xkVar, String str, com.bytedance.sdk.openadsdk.core.a.sr srVar, xv xvVar) {
            super(context, xkVar, str, srVar, xvVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTWebPageActivity.this.f31965i == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.f31965i.setVisibility(8);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TextUtils.isEmpty(TTWebPageActivity.this.eq)) {
                    return super.shouldInterceptRequest(webView, str);
                }
                TTWebPageActivity.xv(TTWebPageActivity.this);
                WebResourceResponse c4 = com.bytedance.sdk.openadsdk.core.t.c.c().c(TTWebPageActivity.this.me, TTWebPageActivity.this.ba, str);
                if (c4 != null) {
                    TTWebPageActivity.f(TTWebPageActivity.this);
                    Log.d(TTWebPageActivity.xv, "GeckoLog: hit++");
                    return c4;
                }
                return super.shouldInterceptRequest(webView, str);
            } catch (Throwable th) {
                Log.e(TTWebPageActivity.xv, "shouldInterceptRequest url error", th);
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass6 extends com.bytedance.sdk.openadsdk.core.widget.c.xv {
        AnonymousClass6(xk xkVar, com.bytedance.sdk.openadsdk.core.a.sr srVar) {
            super(xkVar, srVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
            if (TTWebPageActivity.this.f31965i == null || TTWebPageActivity.this.isFinishing()) {
                return;
            }
            if (i4 != 100 || !TTWebPageActivity.this.f31965i.isShown()) {
                TTWebPageActivity.this.f31965i.setProgress(i4);
            } else {
                TTWebPageActivity.this.f31965i.setVisibility(8);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$7  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.c(tTWebPageActivity.ba);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$8  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.w(tTWebPageActivity.ba);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements DownloadListener {

        /* renamed from: c  reason: collision with root package name */
        private Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> f31994c;
        private String sr;

        /* renamed from: w  reason: collision with root package name */
        private me f31995w;
        private Context xv;

        c(Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map, me meVar, Context context, String str) {
            this.f31994c = map;
            this.f31995w = meVar;
            this.xv = context;
            this.sr = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.f31994c;
            if (map != null && map.containsKey(str)) {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31994c.get(str);
                if (xvVar != null) {
                    xvVar.c(me.ux(this.f31995w));
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.xv, str, this.f31995w, this.sr);
            c4.c(k.c(this.f31995w));
            this.f31994c.put(str, c4);
            c4.c(me.ux(this.f31995w));
        }
    }

    static {
        StubApp.interface11(17892);
    }

    static /* synthetic */ int f(TTWebPageActivity tTWebPageActivity) {
        int i4 = tTWebPageActivity.xk;
        tTWebPageActivity.xk = i4 + 1;
        return i4;
    }

    static /* synthetic */ int xv(TTWebPageActivity tTWebPageActivity) {
        int i4 = tTWebPageActivity.wv;
        tTWebPageActivity.wv = i4 + 1;
        return i4;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((me.xv(this.ba) || ck.c(this.ba)) && com.bytedance.sdk.openadsdk.core.eq.xk.c(this.sr)) {
                return;
            }
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ux();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.eq)) {
            xv.c.c(this.xk, this.wv, this.ba);
        }
        com.bytedance.sdk.openadsdk.core.t.c.c().c(this.me);
        SSWebView sSWebView = this.sr;
        if (sSWebView != null) {
            bw.c(this.ys, sSWebView.getWebView());
            bw.c(this.sr.getWebView());
        }
        this.sr = null;
        com.bytedance.sdk.openadsdk.k.xv xvVar = this.bw;
        if (xvVar != null) {
            xvVar.w();
        }
        xk xkVar = this.gb;
        if (xkVar != null) {
            xkVar.y();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.f31977x;
        if (xvVar2 != null) {
            xvVar2.f();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.f31968m;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().f();
                }
            }
            this.f31968m.clear();
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.f31976w;
        if (srVar != null) {
            srVar.ux();
        }
        com.bytedance.sdk.openadsdk.core.playable.sr.c().w(this.ba);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        xk xkVar = this.gb;
        if (xkVar != null) {
            xkVar.ba();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31977x;
        if (xvVar != null) {
            xvVar.ux();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.f31968m;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().ux();
                }
            }
        }
        t();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        xk xkVar = this.gb;
        if (xkVar != null) {
            xkVar.z();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31977x;
        if (xvVar != null) {
            xvVar.sr();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.f31968m;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().sr();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.f31976w;
        if (srVar != null) {
            srVar.xv();
        }
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar2 = this.gw;
        if (srVar2 != null) {
            srVar2.xv();
        }
        p();
        ys();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.f31976w;
        if (srVar != null) {
            srVar.sr();
        }
    }

    private void a() {
        this.mt = 0;
        if (this.vc) {
            this.mt = com.bytedance.sdk.openadsdk.core.r.xv.f34517c;
        } else if (this.up && !com.bytedance.sdk.openadsdk.core.r.xv.sr) {
            this.mt = m.t(this.ba);
        }
        w(this.mt);
        if (this.mt > 0 && !this.au.hasMessages(10)) {
            if (this.vc) {
                this.au.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.up) {
                this.au.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private boolean bk() {
        return this.vc || this.up;
    }

    private void ev() {
        TTViewStub tTViewStub;
        if (!this.vc && !this.up) {
            int ys = com.bytedance.sdk.openadsdk.core.k.sr().ys();
            if (ys == 0) {
                TTViewStub tTViewStub2 = this.fp;
                if (tTViewStub2 != null) {
                    tTViewStub2.setVisibility(0);
                }
            } else if (ys == 1 && (tTViewStub = this.ia) != null) {
                tTViewStub.setVisibility(0);
            }
        } else {
            TTViewStub tTViewStub3 = this.f31973s;
            if (tTViewStub3 != null) {
                tTViewStub3.setVisibility(0);
            }
            this.f31974t = (ImageView) findViewById(2114387846);
        }
        ImageView imageView = (ImageView) findViewById(2114387704);
        this.ux = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.bytedance.sdk.openadsdk.core.eq.xk.c(TTWebPageActivity.this.sr)) {
                        return;
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387703);
        this.f31964f = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.f31972r = (TextView) findViewById(2114387952);
        this.ev = (TextView) findViewById(2114387626);
        this.gd = (TextView) findViewById(2114387609);
        this.f31970p = (TextView) findViewById(2114387700);
        this.f31967k = (TextView) findViewById(2114387597);
        this.f31962a = (TextView) findViewById(2114387699);
        this.bk = (LinearLayout) findViewById(2114387675);
        TextView textView = this.ev;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        me meVar = this.ba;
        if (meVar != null && !TextUtils.isEmpty(meVar.dk())) {
            this.bj = this.ba.dk();
        }
        return this.bj;
    }

    private void gd() {
        SSWebView sSWebView = this.sr;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ba);
        xk xkVar = new xk(this.pr);
        this.gb = xkVar;
        xkVar.sr(this.ck);
        this.gb.w(this.sr).c(this.ba).xv(arrayList).w(this.f31966j).xv(this.ls).xv(this.f31969n).c(this.f31979z).sr(wv.t(this.ba)).c(this.sr).c(true).w(k.c(this.ba)).c(this);
    }

    private void k() {
        this.up = m.fz(this.ba);
        boolean z3 = m.s(this.ba) && !com.bytedance.sdk.openadsdk.core.r.xv.xv;
        this.vc = z3;
        if (this.up) {
            if (!com.bytedance.sdk.openadsdk.core.r.xv.sr) {
                this.vc = false;
            } else if (z3) {
                this.up = false;
            }
        }
    }

    private void p() {
        if (this.ba == null) {
            return;
        }
        JSONArray w3 = w(this.f31978y);
        int gd = wv.gd(this.ba);
        int ev = wv.ev(this.ba);
        com.bytedance.sdk.openadsdk.core.ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
        if (w3 == null || c4 == null || gd <= 0 || ev <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
        wvVar.f34864f = w3;
        w oo = this.ba.oo();
        if (oo == null) {
            return;
        }
        c4.c(com.bytedance.sdk.openadsdk.core.eq.n.w(oo).xv(6).c(), wvVar, ev, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                TTWebPageActivity.this.c(0);
                wVar.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                if (cVar != null) {
                    try {
                        TTWebPageActivity.this.yu.set(false);
                        TTWebPageActivity.this.gb.c(new JSONObject(cVar.xv()));
                    } catch (Exception unused) {
                        TTWebPageActivity.this.c(0);
                    }
                }
            }
        });
    }

    private View r() {
        Activity activity = this.pr;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.f31971q = new LinearLayout(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f31971q.setOrientation(1);
        this.f31971q.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.ys, new com.bytedance.sdk.openadsdk.res.layout.c.w());
        this.fp = tTViewStub;
        tTViewStub.setId(2114387772);
        this.f31971q.addView(this.fp, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.ys, new com.bytedance.sdk.openadsdk.res.layout.c.xv());
        this.ia = tTViewStub2;
        tTViewStub2.setId(2114387794);
        this.f31971q.addView(this.ia, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.ys, new com.bytedance.sdk.openadsdk.res.layout.c.sr());
        this.f31973s = tTViewStub3;
        tTViewStub3.setId(2114387939);
        this.f31971q.addView(this.f31973s, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.pr);
        this.f31971q.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.pr);
        this.sr = sSWebView;
        sSWebView.setId(2114387734);
        this.sr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.sr);
        TTViewStub tTViewStub4 = new TTViewStub(this.ys, new com.bytedance.sdk.openadsdk.res.layout.c.c());
        this.fz = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.fz, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.pr, null, 16973855);
        this.f31965i = tTProgressBar;
        tTProgressBar.setId(2114387928);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.f31965i.setLayoutParams(layoutParams3);
        this.f31965i.setProgress(1);
        this.f31965i.setProgressDrawable(i.xv(this.pr, "tt_browser_progress_style"));
        frameLayout.addView(this.f31965i);
        return this.f31971q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void sr() {
        int fp = ia.fp(this.ba);
        me meVar = this.ba;
        if (meVar != null) {
            if (meVar.v() == 4 || fp != 0) {
                if (this.f31977x == null) {
                    com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.pr, this.ba, TextUtils.isEmpty(this.f31979z) ? wv.c(this.f31969n) : this.f31979z);
                    this.f31977x = c4;
                    c4.c(k.c(this.ba));
                    this.f31977x.c(this.bm, false);
                }
                this.f31977x.c(this.pr);
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31977x;
                if (xvVar instanceof f) {
                    ((f) xvVar).w(true);
                    ((f) this.f31977x).c().c(false);
                }
                com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.pr, this.ba, "embeded_ad_landingpage", this.f31969n);
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
                this.f31977x.w(me.ux(this.ba));
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f31977x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (bk()) {
            this.au.removeMessages(10);
        }
    }

    private void ux() {
        me meVar = this.ba;
        if (meVar == null || meVar.v() != 4 || this.ba.sr()) {
            return;
        }
        TTViewStub tTViewStub = this.fz;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387730);
        this.f31975u = button;
        if (button != null) {
            c(f());
            if (this.f31977x == null) {
                com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.pr, this.ba, TextUtils.isEmpty(this.f31979z) ? wv.c(this.f31969n) : this.f31979z);
                this.f31977x = c4;
                c4.c(k.c(this.ba));
                this.f31977x.c(this.bm, false);
            }
            this.f31977x.c(this.pr);
            com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f31977x;
            if (xvVar instanceof f) {
                ((f) xvVar).w(true);
            }
            com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.pr, this.ba, "embeded_ad_landingpage", this.f31969n);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
            this.f31975u.setOnClickListener(cVar);
            this.f31975u.setOnTouchListener(cVar);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f31977x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys() {
        if (!bk() || this.au.hasMessages(10)) {
            return;
        }
        this.au.sendEmptyMessageDelayed(10, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(me meVar) {
        if (meVar == null) {
            return;
        }
        String o4 = meVar.o();
        t();
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.ys, meVar.jr(), new f.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                TTWebPageActivity.this.ys();
                TTWebPageActivity.this.sr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                TTWebPageActivity.this.ys();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                TTWebPageActivity.this.ys();
            }
        }, o4);
    }

    private void xv(me meVar) {
        LinearLayout linearLayout = this.bk;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        } else if (this.ba == null) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            String o4 = meVar.o();
            if (TextUtils.isEmpty(o4)) {
                LinearLayout linearLayout2 = this.bk;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                if (TextUtils.isEmpty(o4)) {
                    return;
                }
                ux ux = com.bytedance.sdk.openadsdk.core.w.ux(new JSONObject(o4));
                if (ux == null) {
                    LinearLayout linearLayout3 = this.bk;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(ux.k())) {
                    LinearLayout linearLayout4 = this.bk;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                } else {
                    LinearLayout linearLayout5 = this.bk;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(0);
                    }
                    String ux2 = ux.ux();
                    String r3 = ux.r();
                    String a4 = ux.a();
                    if (TextUtils.isEmpty(a4)) {
                        a4 = k.w(meVar);
                    }
                    if (this.gd != null) {
                        this.gd.setText(String.format(i.c(this.ys, "tt_open_app_detail_developer"), r3));
                    }
                    if (this.f31970p != null) {
                        this.f31970p.setText(String.format(i.c(this.ys, "tt_open_landing_page_app_name"), a4, ux2));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(me meVar) {
        if (meVar == null) {
            return;
        }
        String o4 = meVar.o();
        t();
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.ys, meVar.jr(), o4, new f.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                TTWebPageActivity.this.ys();
                TTWebPageActivity.this.sr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                TTWebPageActivity.this.ys();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                TTWebPageActivity.this.ys();
            }
        });
    }

    private JSONArray w(String str) {
        int i4;
        JSONArray jSONArray = this.wx;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.wx;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i4 = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i4, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.f31975u) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.f31975u == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.f31975u.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        if (me.xv(this.ba)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31964f, 4);
        } else if (me.xv(this.ba)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31964f, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.sr
    public void c(boolean z3, JSONArray jSONArray) {
        if (!z3 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.wx = jSONArray;
        p();
    }

    void w() {
        try {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(this.pr, this.ba.ve(), this.f31979z, true);
            this.f31963c = cVar;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.pr, cVar, this.ba);
            this.f31963c.c(new c.InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void c() {
                    TTWebPageActivity.this.t();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void w() {
                    TTWebPageActivity.this.ys();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void c(int i4, String str, boolean z3) {
                    TTWebPageActivity.this.ys();
                }
            });
        } catch (Exception e4) {
            a.xv(e4.getMessage());
        }
    }

    protected void c() {
        if (this.ba == null || isFinishing()) {
            return;
        }
        if (this.f31963c == null) {
            w();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.f31963c;
        if (cVar != null) {
            cVar.c();
        }
    }

    private void w(int i4) {
        if (i4 > 0) {
            if (this.vc) {
                TextView textView = this.f31972r;
                com.bytedance.sdk.openadsdk.core.eq.xk.c(textView, i4 + "s\u540e\u53ef\u9886\u53d6\u5956\u52b1");
            } else if (this.up) {
                SpannableString spannableString = new SpannableString("\u6d4f\u89c8 " + i4 + "\u79d2 \u83b7\u5f97\u66f4\u591a\u798f\u5229");
                spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() + (-4), spannableString.length(), 17);
                com.bytedance.sdk.openadsdk.core.eq.xk.c(this.f31972r, spannableString);
            }
        } else if (this.vc) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c(this.f31972r, "\u9886\u53d6\u6210\u529f");
        } else if (this.up) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31974t, 8);
            com.bytedance.sdk.openadsdk.core.eq.xk.c(this.f31972r, "\u606d\u559c\u4f60\uff01\u798f\u5229\u5df2\u9886\u53d6");
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 10 && bk()) {
            int i4 = this.oo + 1;
            this.oo = i4;
            if (this.vc) {
                com.bytedance.sdk.openadsdk.core.r.xv.f34518w = i4;
            }
            int max = Math.max(0, this.mt - i4);
            w(max);
            if (max <= 0 && this.up) {
                com.bytedance.sdk.openadsdk.core.r.xv.sr = true;
            }
            this.au.sendEmptyMessageDelayed(10, 1000L);
        }
    }
}
