package com.bytedance.sdk.openadsdk.core.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.bw;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.dislike.ui.c;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.p.xv.f;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.ck;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ux;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.w.c.w.r;
import com.bytedance.sdk.openadsdk.core.xk;
import com.bytedance.sdk.openadsdk.core.ys.c;
import com.bytedance.sdk.openadsdk.core.ys.sr;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTVideoWebPageActivity extends Activity implements xv.InterfaceC0335xv, sr {

    /* renamed from: a  reason: collision with root package name */
    private TextView f31924a;
    private com.bytedance.sdk.openadsdk.core.a.sr au;
    private TextView ba;
    private com.bytedance.sdk.openadsdk.k.xv bj;
    private LinearLayout bk;

    /* renamed from: c  reason: collision with root package name */
    c f31926c;
    private TextView eq;
    private TextView ev;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f31927f;
    private String fp;
    private RelativeLayout fz;
    private TextView gd;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31928h;
    private xk ia;

    /* renamed from: j  reason: collision with root package name */
    private me f31930j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f31931k;
    private TextView me;
    private int mt;
    private Activity ok;
    private com.bytedance.sdk.openadsdk.core.multipro.w.c oo;
    private Object ox;

    /* renamed from: p  reason: collision with root package name */
    private TextView f31934p;

    /* renamed from: q  reason: collision with root package name */
    private long f31935q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f31936r;

    /* renamed from: s  reason: collision with root package name */
    private int f31937s;
    private SSWebView sr;

    /* renamed from: t  reason: collision with root package name */
    private Context f31938t;

    /* renamed from: u  reason: collision with root package name */
    private FrameLayout f31939u;
    private ImageView ux;

    /* renamed from: w  reason: collision with root package name */
    protected NativeVideoTsView f31940w;
    private String wo;
    private TTViewStub wv;
    private com.bytedance.sdk.openadsdk.core.p.w.xv wx;

    /* renamed from: x  reason: collision with root package name */
    private String f31941x;
    private Button xk;
    protected xv xv;

    /* renamed from: y  reason: collision with root package name */
    private RoundImageView f31942y;
    private String ys;
    private TTProgressBar yu;

    /* renamed from: z  reason: collision with root package name */
    private RelativeLayout f31943z;

    /* renamed from: i  reason: collision with root package name */
    private int f31929i = -1;
    private int ls = 0;
    private int gb = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f31933n = 0;
    private int ck = 0;
    private final Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> pr = Collections.synchronizedMap(new HashMap());
    private boolean bw = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f31932m = false;
    private boolean gw = true;
    private boolean vc = false;
    private String up = null;
    private AtomicBoolean bm = new AtomicBoolean(true);

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f31925b = null;
    private int xu = 0;
    private int ng = 0;
    private String oh = "\u7acb\u5373\u4e0b\u8f7d";
    private com.bytedance.sdk.openadsdk.core.p.w.c fm = new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.w(tTVideoWebPageActivity.bk());
            c.C0525c.c(TTVideoWebPageActivity.this.ys, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void w(long j4, long j5, String str, String str2) {
            TTVideoWebPageActivity.this.w("\u6682\u505c");
            if (j4 > 0) {
                c.C0525c.c(TTVideoWebPageActivity.this.ys, 2, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void xv(long j4, long j5, String str, String str2) {
            TTVideoWebPageActivity.this.w("\u4e0b\u8f7d\u5931\u8d25");
            if (j4 > 0) {
                c.C0525c.c(TTVideoWebPageActivity.this.ys, 4, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, long j5, String str, String str2) {
            TTVideoWebPageActivity.this.w("\u4e0b\u8f7d\u4e2d...");
            a.w("TTVideoWebPageActivity", "onDownloadActive: totalBytes = " + j4 + "; currBytes = " + j5 + "; fileName=" + str);
            if (j4 > 0) {
                c.C0525c.c(TTVideoWebPageActivity.this.ys, 3, (int) ((j5 * 100) / j4));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, String str, String str2) {
            TTVideoWebPageActivity.this.w("\u70b9\u51fb\u5b89\u88c5");
            c.C0525c.c(TTVideoWebPageActivity.this.ys, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(String str, String str2) {
            TTVideoWebPageActivity.this.w("\u70b9\u51fb\u6253\u5f00");
            c.C0525c.c(TTVideoWebPageActivity.this.ys, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.w.c te = null;
    private final xv.w ge = new xv.w() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.w
        public void c(boolean z3) {
            TTVideoWebPageActivity.this.bw = z3;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z3) {
                com.bytedance.sdk.openadsdk.core.eq.xk.c((View) TTVideoWebPageActivity.this.sr, 8);
                com.bytedance.sdk.openadsdk.core.eq.xk.c((View) TTVideoWebPageActivity.this.fz, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.f31939u.getLayoutParams();
                TTVideoWebPageActivity.this.gb = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.ls = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.f31933n = marginLayoutParams.width;
                TTVideoWebPageActivity.this.ck = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.f31939u.setLayoutParams(marginLayoutParams);
                return;
            }
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) TTVideoWebPageActivity.this.sr, 0);
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) TTVideoWebPageActivity.this.fz, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.f31939u.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.f31933n;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.ck;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.gb;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.ls;
            TTVideoWebPageActivity.this.f31939u.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean ta = false;
    private final ls.c eu = new ls.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
        @Override // com.bytedance.sdk.component.utils.ls.c
        public void c(Context context, Intent intent, boolean z3, int i4) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.mt == 0 && i4 != 0 && TTVideoWebPageActivity.this.sr != null && TTVideoWebPageActivity.this.up != null) {
                    ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.sr != null) {
                                TTVideoWebPageActivity.this.sr.c(TTVideoWebPageActivity.this.up);
                            }
                        }
                    });
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.f31940w;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.j() && TTVideoWebPageActivity.this.mt != i4) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) TTVideoWebPageActivity.this.f31940w.getNativeVideoController()).c(context, i4);
                }
                TTVideoWebPageActivity.this.mt = i4;
            }
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 extends com.bytedance.sdk.openadsdk.core.widget.c.sr {
        AnonymousClass1(Context context, xk xkVar, String str, com.bytedance.sdk.openadsdk.core.a.sr srVar, com.bytedance.sdk.openadsdk.k.xv xvVar) {
            super(context, xkVar, str, srVar, xvVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTVideoWebPageActivity.this.yu == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.yu.setVisibility(8);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TextUtils.isEmpty(TTVideoWebPageActivity.this.wo)) {
                    return super.shouldInterceptRequest(webView, str);
                }
                TTVideoWebPageActivity.xv(TTVideoWebPageActivity.this);
                WebResourceResponse c4 = com.bytedance.sdk.openadsdk.core.t.c.c().c(TTVideoWebPageActivity.this.ox, TTVideoWebPageActivity.this.f31930j, str);
                if (c4 != null) {
                    TTVideoWebPageActivity.f(TTVideoWebPageActivity.this);
                    return c4;
                }
                return super.shouldInterceptRequest(webView, str);
            } catch (Throwable unused) {
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$10  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass10 implements DownloadListener {
        AnonymousClass10() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            if (TTVideoWebPageActivity.this.pr.containsKey(str)) {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = (com.bytedance.sdk.openadsdk.core.p.w.xv) TTVideoWebPageActivity.this.pr.get(str);
                if (xvVar != null) {
                    xvVar.c(me.ux(TTVideoWebPageActivity.this.f31930j));
                    return;
                }
                return;
            }
            if (TTVideoWebPageActivity.this.f31930j != null && TTVideoWebPageActivity.this.f31930j.kr() != null) {
                TTVideoWebPageActivity.this.f31930j.kr().c();
            }
            com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(TTVideoWebPageActivity.this.ok, str, TTVideoWebPageActivity.this.f31930j, TTVideoWebPageActivity.this.f31941x);
            c4.c(k.c(TTVideoWebPageActivity.this.f31930j));
            TTVideoWebPageActivity.this.pr.put(str, c4);
            c4.c(me.ux(TTVideoWebPageActivity.this.f31930j));
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$11  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.w(tTVideoWebPageActivity.f31930j);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$12  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.xv(tTVideoWebPageActivity.f31930j);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$9  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass9 extends com.bytedance.sdk.openadsdk.core.widget.c.xv {
        AnonymousClass9(xk xkVar, com.bytedance.sdk.openadsdk.core.a.sr srVar) {
            super(xkVar, srVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
            if (TTVideoWebPageActivity.this.yu == null || TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (i4 != 100 || !TTVideoWebPageActivity.this.yu.isShown()) {
                TTVideoWebPageActivity.this.yu.setProgress(i4);
            } else {
                TTVideoWebPageActivity.this.yu.setVisibility(8);
            }
        }
    }

    static {
        StubApp.interface11(17877);
    }

    static /* synthetic */ int f(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i4 = tTVideoWebPageActivity.ng;
        tTVideoWebPageActivity.ng = i4 + 1;
        return i4;
    }

    static /* synthetic */ int xv(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i4 = tTVideoWebPageActivity.xu;
        tTVideoWebPageActivity.xu = i4 + 1;
        return i4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void C_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void D_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void E_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void F_() {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((me.xv(this.f31930j) || ck.c(this.f31930j)) && com.bytedance.sdk.openadsdk.core.eq.xk.c(this.sr)) {
            return;
        }
        if (this.bw && (nativeVideoTsView = this.f31940w) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.sr.c) this.f31940w.getNativeVideoController()).ux(null, null);
            this.bw = false;
            return;
        }
        c("detail_back");
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        f();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.wo)) {
            xv.c.c(this.ng, this.xu, this.f31930j);
        }
        com.bytedance.sdk.openadsdk.core.t.c.c().c(this.ox);
        SSWebView sSWebView = this.sr;
        if (sSWebView != null) {
            bw.c(this.f31938t, sSWebView.getWebView());
            bw.c(this.sr.getWebView());
        }
        this.sr = null;
        com.bytedance.sdk.openadsdk.k.xv xvVar = this.bj;
        if (xvVar != null) {
            xvVar.w();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.wx;
        if (xvVar2 != null) {
            xvVar2.f();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.pr;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().f();
                }
            }
            this.pr.clear();
        }
        xk xkVar = this.ia;
        if (xkVar != null) {
            xkVar.y();
        }
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.f31940w.getNativeVideoController().p();
        }
        NativeVideoTsView nativeVideoTsView2 = this.f31940w;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.s();
            this.f31940w = null;
        }
        this.f31930j = null;
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.au;
        if (srVar != null) {
            srVar.ux();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.f31932m && !k()) {
                this.f31932m = true;
                this.xv.f();
            }
        } catch (Throwable th) {
            a.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        xk xkVar = this.ia;
        if (xkVar != null) {
            xkVar.ba();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.wx;
        if (xvVar != null) {
            xvVar.ux();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.pr;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().ux();
                }
            }
        }
        if (j() || ((nativeVideoTsView2 = this.f31940w) != null && nativeVideoTsView2.getNativeVideoController() != null && this.f31940w.getNativeVideoController().u())) {
            com.bytedance.sdk.component.f.c c4 = ba.c("sp_multi_native_video_data");
            c4.c("key_video_is_update_flag", true);
            c4.c("key_native_video_complete", true);
            c4.c("key_video_isfromvideodetailpage", true);
        }
        if (j() || (nativeVideoTsView = this.f31940w) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        c(this.f31940w.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.gw = false;
        if (this.f31932m && p() && !k()) {
            this.f31932m = false;
            this.xv.ev();
        }
        xk xkVar = this.ia;
        if (xkVar != null) {
            xkVar.z();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.wx;
        if (xvVar != null) {
            xvVar.sr();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> map = this.pr;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().sr();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.au;
        if (srVar != null) {
            srVar.xv();
        }
        q();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        me meVar = this.f31930j;
        bundle.putString("material_meta", meVar != null ? meVar.mo().toString() : null);
        bundle.putLong("video_play_position", this.f31935q);
        bundle.putBoolean("is_complete", j());
        long j4 = this.f31935q;
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            j4 = this.f31940w.getNativeVideoController().k();
        }
        bundle.putLong("video_play_position", j4);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.au;
        if (srVar != null) {
            srVar.sr();
        }
    }

    private void a() {
        me meVar = this.f31930j;
        if (meVar == null || meVar.v() != 4) {
            return;
        }
        this.wv.setVisibility(0);
        Button button = (Button) findViewById(2114387730);
        this.xk = button;
        if (button != null) {
            w(bk());
            if (this.wx != null) {
                if (TextUtils.isEmpty(this.f31941x)) {
                    wv.c(this.f31937s);
                }
                this.wx.c(this.fm, false);
            }
            this.xk.setOnClickListener(this.te);
            this.xk.setOnTouchListener(this.te);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bk() {
        me meVar = this.f31930j;
        if (meVar != null && !TextUtils.isEmpty(meVar.dk())) {
            this.oh = this.f31930j.dk();
        }
        return this.oh;
    }

    private long fp() {
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.f31940w.getNativeVideoController().t();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fz() {
        me meVar = this.f31930j;
        if (meVar == null || meVar.v() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.ok, this.f31930j, this.f31941x);
        this.wx = c4;
        c4.c(this.ok);
        this.wx.c(k.c(this.f31930j));
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.wx;
        if (xvVar instanceof f) {
            ((f) xvVar).w(true);
        }
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.ok, this.f31930j, "embeded_ad_landingpage", this.f31937s);
        this.te = cVar;
        ((w) cVar.c(w.class)).xv(true);
        ((w) this.te.c(w.class)).c(true);
        ((r) this.te.c(r.class)).w(true);
        this.me.setOnClickListener(this.te);
        this.me.setOnTouchListener(this.te);
        ((w) this.te.c(w.class)).c(this.wx);
    }

    private void i() {
        SSWebView sSWebView = this.sr;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f31930j);
        xk xkVar = new xk(this.ok);
        this.ia = xkVar;
        xkVar.sr(this.f31928h);
        this.ia.w(this.sr).c(this.f31930j).xv(arrayList).w(this.ys).xv(this.fp).w(k.c(this.f31930j)).xv(this.f31937s).c(this.sr).c(true).sr(wv.t(this.f31930j));
    }

    private int ia() {
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f31940w.getNativeVideoController().ys();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.f31940w.getNativeVideoController().u();
    }

    private boolean ls() {
        me meVar = this.f31930j;
        if (meVar == null) {
            return false;
        }
        int m4 = meVar.m();
        return this.f31937s == 1 && "embeded_ad_landingpage".equals(this.f31941x) && (m4 == 1 || m4 == 2);
    }

    private void q() {
        if (this.f31930j == null) {
            return;
        }
        JSONArray xv = xv(this.up);
        int gd = wv.gd(this.f31930j);
        int ev = wv.ev(this.f31930j);
        com.bytedance.sdk.openadsdk.core.ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = com.bytedance.sdk.openadsdk.core.ls.c();
        if (xv == null || c4 == null || gd <= 0 || ev <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
        wvVar.f34864f = xv;
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo = this.f31930j.oo();
        if (oo == null) {
            return;
        }
        c4.c(n.w(oo).xv(6).c(), wvVar, ev, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                TTVideoWebPageActivity.this.c(0);
                wVar.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar) {
                if (cVar != null) {
                    try {
                        TTVideoWebPageActivity.this.bm.set(false);
                        TTVideoWebPageActivity.this.ia.c(new JSONObject(cVar.xv()));
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.c(0);
                    }
                }
            }
        });
    }

    private void s() {
        String yh;
        me meVar = this.f31930j;
        if (meVar == null || meVar.v() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31943z, 0);
        if (!TextUtils.isEmpty(this.f31930j.ny())) {
            yh = this.f31930j.ny();
        } else if (!TextUtils.isEmpty(this.f31930j.ju())) {
            yh = this.f31930j.ju();
        } else {
            yh = !TextUtils.isEmpty(this.f31930j.yh()) ? this.f31930j.yh() : "";
        }
        gb kr = this.f31930j.kr();
        if (kr != null && kr.c() != null) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31942y, 0);
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ba, 4);
            com.bytedance.sdk.openadsdk.r.w.c(kr).c(this.f31942y);
        } else if (!TextUtils.isEmpty(yh)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31942y, 4);
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ba, 0);
            this.ba.setText(yh.substring(0, 1));
        }
        if (this.eq != null && !TextUtils.isEmpty(yh)) {
            this.eq.setText(yh);
        }
        if (!TextUtils.isEmpty(this.f31930j.dk())) {
            this.me.setText(this.f31930j.dk());
        }
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.eq, 0);
        if (ls()) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.me, 8);
        } else {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.me, 0);
        }
    }

    private void t() {
        this.yu = (TTProgressBar) findViewById(2114387928);
        this.wv = (TTViewStub) findViewById(2114387956);
        this.sr = (SSWebView) findViewById(2114387734);
        this.ux = (ImageView) findViewById(2114387704);
        me meVar = this.f31930j;
        if (meVar != null && meVar.ve() != null) {
            this.f31930j.ve().c("landing_page");
        }
        ImageView imageView = this.ux;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.bytedance.sdk.openadsdk.core.eq.xk.c(TTVideoWebPageActivity.this.sr)) {
                        return;
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387703);
        this.f31927f = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387626);
        this.ev = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.r();
                }
            });
        }
        this.f31936r = (TextView) findViewById(2114387952);
        this.gd = (TextView) findViewById(2114387890);
        this.f31934p = (TextView) findViewById(2114387746);
        this.f31931k = (TextView) findViewById(2114387646);
        this.f31924a = (TextView) findViewById(2114387611);
        this.bk = (LinearLayout) findViewById(2114387894);
        this.f31939u = (FrameLayout) findViewById(2114387707);
        this.fz = (RelativeLayout) findViewById(2114387949);
        this.f31943z = (RelativeLayout) findViewById(2114387654);
        this.ba = (TextView) findViewById(2114387957);
        this.eq = (TextView) findViewById(2114387766);
        this.me = (TextView) findViewById(2114387685);
        this.f31942y = (RoundImageView) findViewById(2114387663);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        int fp = ia.fp(this.f31930j);
        me meVar = this.f31930j;
        if (meVar != null) {
            if (meVar.v() == 4 || fp != 0) {
                com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.ok, this.f31930j, this.f31941x);
                this.wx = c4;
                c4.c(this.ok);
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.wx;
                if (xvVar instanceof f) {
                    ((f) xvVar).w(true);
                    ((f) this.wx).c().c(false);
                }
                com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.ok, this.f31930j, "embeded_ad_landingpage", this.f31937s);
                this.te = cVar;
                ((w) cVar.c(w.class)).xv(true);
                ((w) this.te.c(w.class)).c(true);
                ((r) this.te.c(r.class)).w(true);
                this.wx.w(me.ux(this.f31930j));
                ((w) this.te.c(w.class)).c(this.wx);
            }
        }
    }

    private void ys() {
        if (me.w(this.f31930j)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f31940w = new NativeVideoTsView(this.f31938t, this.f31930j, true, true);
                } else {
                    this.f31940w = new NativeVideoTsView(this.f31938t, this.f31930j, true, false);
                }
                if (this.f31940w.getNativeVideoController() != null) {
                    this.f31940w.getNativeVideoController().c(false);
                    if (this.oo != null) {
                        this.f31940w.getNativeVideoController().xv(this.oo.f33977c);
                    }
                }
                this.f31940w.setVideoAdInteractionListener(this);
                if (!this.vc) {
                    this.f31935q = 0L;
                }
                if (this.oo != null && this.f31940w.getNativeVideoController() != null) {
                    this.f31940w.getNativeVideoController().xv(this.oo.f33979r);
                    this.f31940w.getNativeVideoController().sr(this.oo.ux);
                }
                if (this.f31940w.getNativeVideoController() != null) {
                    this.f31940w.getNativeVideoController().c(false);
                    this.f31940w.getNativeVideoController().c(this.ge);
                    this.f31940w.setIsQuiet(com.bytedance.sdk.openadsdk.core.ls.w().sr(wv.gd(this.f31930j)));
                }
                if (this.f31940w.c(this.f31935q, this.gw, j())) {
                    this.f31939u.setVisibility(0);
                    this.f31939u.removeAllViews();
                    this.f31939u.addView(this.f31940w);
                }
                if (j()) {
                    this.f31940w.sr(true);
                }
                this.xv = this.f31940w.getNativeVideoController();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (ys.xv(StubApp.getOrigApplicationContext(this.ok.getApplicationContext())) == 0) {
                try {
                    Activity activity = this.ok;
                    Toast.makeText(activity, i.c(activity, "tt_no_network"), 0).show();
                } catch (Exception unused) {
                }
            }
        }
    }

    void ev() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(this.ok, this.f31930j.ve(), this.f31941x, true);
        this.f31926c = cVar;
        com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.ok, cVar, this.f31930j);
        this.f31926c.c(new c.InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c() {
                if (TTVideoWebPageActivity.this.gd()) {
                    TTVideoWebPageActivity.this.xv.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void w() {
                if (TTVideoWebPageActivity.this.p()) {
                    TTVideoWebPageActivity.this.xv.ev();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c(int i4, String str, boolean z3) {
                if (TTVideoWebPageActivity.this.p()) {
                    TTVideoWebPageActivity.this.xv.ev();
                }
            }
        });
    }

    boolean gd() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.xv;
        return (xvVar == null || xvVar.ia() == null || !this.xv.ia().bk()) ? false : true;
    }

    protected boolean k() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.f31926c;
        if (cVar != null) {
            return cVar.xv();
        }
        return false;
    }

    protected boolean p() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.xv;
        return (xvVar == null || xvVar.ia() == null || !this.xv.ia().t()) ? false : true;
    }

    protected void r() {
        if (isFinishing() || this.f31930j == null) {
            return;
        }
        if (this.f31926c == null) {
            ev();
        }
        this.f31926c.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(me meVar) {
        if (meVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.f31938t, meVar.jr(), new f.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                TTVideoWebPageActivity.this.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        }, meVar.o());
    }

    protected void f() {
        try {
            ls.c(this.eu);
        } catch (Exception unused) {
        }
    }

    protected void ux() {
        ls.c(this.eu, this.f31938t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(me meVar) {
        if (meVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.f31938t, meVar.jr(), meVar.o(), new f.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                TTVideoWebPageActivity.this.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        });
    }

    private JSONArray xv(String str) {
        int i4;
        JSONArray jSONArray = this.f31925b;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.f31925b;
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

    private void c(me meVar) {
        LinearLayout linearLayout = this.bk;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        } else if (meVar == null) {
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
                        this.gd.setText(String.format(i.c(this.f31938t, "tt_open_app_detail_developer"), r3));
                    }
                    if (this.f31934p != null) {
                        this.f31934p.setText(String.format(i.c(this.f31938t, "tt_open_landing_page_app_name"), a4, ux2));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.xk) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.xk == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.xk.setText(str);
            }
        });
    }

    public void c(String str) {
        NativeVideoTsView nativeVideoTsView = this.f31940w;
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f31930j, "embeded_ad", str, fp(), ia(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : wv.c(this.f31930j, this.f31940w.getNativeVideoController().a(), this.f31940w.getNativeVideoController().ia()));
    }

    private void c(com.bykv.vk.openvk.component.video.api.sr.xv xvVar) {
        a.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + xvVar.u() + ",position=" + xvVar.k() + ",totalPlayDuration=" + (xvVar.t() + xvVar.a()) + ",duration=" + xvVar.t());
        com.bytedance.sdk.component.f.c c4 = ba.c("sp_multi_native_video_data");
        c4.c("key_video_is_update_flag", true);
        c4.c("key_video_isfromvideodetailpage", true);
        c4.c("key_native_video_complete", xvVar.u());
        c4.c("key_video_current_play_position", xvVar.k());
        c4.c("key_video_total_play_duration", xvVar.t() + xvVar.a());
        c4.c("key_video_duration", xvVar.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        if (me.xv(this.f31930j)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31927f, 4);
        } else if (me.xv(this.f31930j)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.f31927f, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.sr
    public void c(boolean z3, JSONArray jSONArray) {
        if (!z3 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f31925b = jSONArray;
        q();
    }

    public static boolean c(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null) {
                return false;
            }
            return TTVideoWebPageActivity.class.getName().equals(intent.getComponent().getClassName());
        } catch (Throwable th) {
            a.c("TTVideoWebPageActivity", "isThisClass error", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void c(long j4, long j5) {
        if (ls()) {
            com.bytedance.sdk.openadsdk.core.k.sr().c(j4);
        }
    }
}
