package com.qq.e.comm.plugin.a0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.d0.b.e;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.d;
import com.qq.e.comm.plugin.q0.f;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.AdErrorConvertor;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements ACTD, View.OnClickListener, f {

    /* renamed from: l  reason: collision with root package name */
    private static final String f41694l = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final Activity f41695c;

    /* renamed from: d  reason: collision with root package name */
    private HybridADListener f41696d;

    /* renamed from: e  reason: collision with root package name */
    private HybridADSetting f41697e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f41698f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.a0.c f41699g;

    /* renamed from: h  reason: collision with root package name */
    private h f41700h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressBar f41701i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f41702j;

    /* renamed from: k  reason: collision with root package name */
    private String f41703k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.a0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0778a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f41704c;

        RunnableC0778a(int i4) {
            this.f41704c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f41696d.onError(AdErrorConvertor.formatErrorCode(this.f41704c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f41696d.onClose();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f41696d.onLoadFinished();
        }
    }

    public a(Activity activity) {
        this.f41695c = activity;
    }

    private void b(int i4) {
        p0.a((Runnable) new RunnableC0778a(i4));
    }

    private void c() {
        if (this.f41700h.canGoBackOrForward(-1)) {
            this.f41700h.goBack();
        } else {
            b();
        }
    }

    private void d() {
        this.f41698f = new RelativeLayout(this.f41695c);
        com.qq.e.comm.plugin.a0.c cVar = new com.qq.e.comm.plugin.a0.c(this.f41695c, this.f41697e);
        this.f41699g = cVar;
        cVar.setId(2131755009);
        this.f41699g.a().setOnClickListener(this);
        this.f41699g.c().setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f1.a((Context) this.f41695c, this.f41697e.getTitleBarHeight()));
        layoutParams.addRule(10, -1);
        this.f41698f.addView(this.f41699g, layoutParams);
        h a4 = new d(this.f41695c).a();
        this.f41700h = a4;
        a4.a(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 2131755009);
        this.f41698f.addView(this.f41700h.a(), layoutParams2);
        ProgressBar progressBar = new ProgressBar(this.f41695c);
        this.f41701i = progressBar;
        progressBar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f1.a((Context) this.f41695c, 46), f1.a((Context) this.f41695c, 46));
        layoutParams3.addRule(13, -1);
        this.f41698f.addView(this.f41701i, layoutParams3);
        this.f41695c.setContentView(this.f41698f, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        return false;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
        d1.a("gdt_tag_callback", "onActivityResult(requestCode, resultCode, data)");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        d1.a("gdt_tag_callback", "onAfterCreate(savedInstanceState)");
        String stringExtra = this.f41695c.getIntent().getStringExtra("objectId");
        this.f41703k = stringExtra;
        com.qq.e.comm.plugin.d0.b.c cVar = (com.qq.e.comm.plugin.d0.b.c) e.a(stringExtra, com.qq.e.comm.plugin.d0.b.c.class);
        this.f41696d = cVar.a();
        this.f41697e = cVar.b();
        String stringExtra2 = this.f41695c.getIntent().getStringExtra("url");
        if (this.f41696d != null && this.f41697e != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                d1.a("HybridAD activity \u521b\u5efa\u5931\u8d25\uff0curl \u4e3a\u7a7a");
                this.f41695c.finish();
                return;
            }
            d();
            if (this.f41697e.getType() != 1) {
                d1.a("unknow HybridAD type");
                b(4001);
                this.f41695c.finish();
                return;
            }
            com.qq.e.comm.plugin.a0.d.a aVar = new com.qq.e.comm.plugin.a0.d.a();
            this.f41700h.c().a(aVar.a(), aVar);
            this.f41700h.loadUrl(stringExtra2);
            v.a(21042, null, 2);
            return;
        }
        d1.a("HybridAD activity \u521b\u5efa\u5931\u8d25\uff0cHybridADListener \u6216 HybridADSetting \u4e3a\u7a7a");
        e.a(com.qq.e.comm.plugin.d0.b.c.class);
        this.f41695c.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        d1.a("gdt_tag_callback", "onBackPressed()");
        c();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        d1.a("gdt_tag_callback", "onBeforeCreate(savedInstanceState)");
        this.f41695c.requestWindowFeature(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131755009) {
            c();
            v.a(21052, (com.qq.e.comm.plugin.n0.c) null);
        } else if (id != 2131755011) {
        } else {
            b();
            v.a(21062, (com.qq.e.comm.plugin.n0.c) null);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
        d1.a("gdt_tag_callback", "onConfigurationChanged(newConfig)");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        d1.a("gdt_tag_callback", "onDestroy()");
        h hVar = this.f41700h;
        if (hVar != null) {
            hVar.e();
        }
        p0.a((Object) null);
        e.b(this.f41703k, com.qq.e.comm.plugin.d0.b.c.class);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        d1.a("gdt_tag_callback", "onPause()");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        d1.a("gdt_tag_callback", "onResume()");
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
        d1.a("gdt_tag_callback", "onStop()");
    }

    private void b() {
        p0.a((Runnable) new b());
        this.f41695c.finish();
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
        d1.a("gdt_tag_callback", "onPageStarted(url, favicon)");
        d1.a(f41694l, "onPageStarted : url = %s", str);
        this.f41701i.setVisibility(0);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void c(String str) {
        d1.a("gdt_tag_callback", "onPageFinished(url)");
        d1.a(f41694l, "onPageFinished : url = %s", str);
        if (!this.f41702j) {
            p0.a((Runnable) new c());
            v.a(21042, null, 3);
            this.f41702j = true;
        }
        this.f41701i.setVisibility(8);
        if (this.f41700h.canGoBackOrForward(-1)) {
            this.f41699g.b().setVisibility(0);
            this.f41699g.c().setVisibility(0);
            return;
        }
        this.f41699g.b().setVisibility(4);
        this.f41699g.c().setVisibility(4);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void b(String str) {
        d1.a("gdt_tag_callback", "onReceivedTitle(title)");
        HybridADSetting hybridADSetting = this.f41697e;
        if (hybridADSetting == null || TextUtils.isEmpty(hybridADSetting.getTitle())) {
            this.f41699g.d().setText(str);
        }
    }
}
