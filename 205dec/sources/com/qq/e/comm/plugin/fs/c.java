package com.qq.e.comm.plugin.fs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.fs.e.d;
import com.qq.e.comm.plugin.fs.f.e.d.f;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.h0.i;
import com.qq.e.comm.plugin.h0.l;
import com.qq.e.comm.plugin.rewardvideo.q;
import com.qq.e.comm.plugin.util.n2;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements ACTD {

    /* renamed from: l  reason: collision with root package name */
    private static final String f43175l = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final Activity f43176c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f43177d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.f.a f43178e;

    /* renamed from: f  reason: collision with root package name */
    private f f43179f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.d.b f43180g;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.d.d.a f43181h;

    /* renamed from: i  reason: collision with root package name */
    private e f43182i;

    /* renamed from: j  reason: collision with root package name */
    private String f43183j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.a f43184k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends FrameLayout {
        a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(c.this.f43177d);
            if (d4 != null) {
                d4.a(motionEvent, false);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public c(Activity activity) {
        this.f43176c = activity;
    }

    private void c() {
        com.qq.e.comm.plugin.fs.d.b bVar = this.f43180g;
        if (bVar != null) {
            bVar.n();
        }
        com.qq.e.comm.plugin.fs.d.b a4 = com.qq.e.comm.plugin.fs.d.c.a(this.f43176c, this.f43182i, this.f43181h);
        this.f43180g = a4;
        a4.a(this.f43177d, this.f43178e, this.f43179f);
    }

    private void d() {
        z.c(this.f43176c, z.a(this.f43182i));
        this.f43178e = new com.qq.e.comm.plugin.fs.f.a(this.f43176c, this.f43182i, this.f43181h);
        FrameLayout frameLayout = this.f43177d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = new a(this.f43176c);
        this.f43177d = aVar;
        aVar.setBackgroundColor(-16777216);
        this.f43177d.addView(this.f43178e, new FrameLayout.LayoutParams(-1, -1));
        com.qq.e.comm.plugin.fs.d.d.a aVar2 = this.f43181h;
        if (aVar2 != null && aVar2.s()) {
            a(this.f43181h);
        }
        this.f43176c.setContentView(this.f43177d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.comm.plugin.fs.f.a b() {
        return this.f43178e;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.f43176c.getIntent().getStringExtra("objectId");
        this.f43183j = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            GDTLogger.e(f43175l + " \u5168\u5c4f\u89c6\u9891\u5e7f\u544a\u9875Activity\u521b\u5efa\u5931\u8d25\uff0cOBJECT_ID\u4e3a\u7a7a");
            a((FSCallback) null);
            return;
        }
        FSCallback fSCallback = (FSCallback) com.qq.e.comm.plugin.h.a.b(this.f43183j, FSCallback.class);
        e a4 = ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(this.f43183j, com.qq.e.comm.plugin.d0.b.b.class)).a();
        this.f43182i = a4;
        if (a4 == null) {
            GDTLogger.e(f43175l + " \u5168\u5c4f\u89c6\u9891\u5e7f\u544a\u9875Activity\u521b\u5efa\u5931\u8d25\uff0c\u5e7f\u544a\u6570\u636e\u4e3a\u7a7a");
            a(fSCallback);
            return;
        }
        a4.c(3);
        com.qq.e.comm.plugin.fs.d.d.a a5 = com.qq.e.comm.plugin.fs.d.d.b.a(this.f43182i);
        this.f43181h = a5;
        if (a5 == null) {
            GDTLogger.e(f43175l + " \u5168\u5c4f\u89c6\u9891\u5e7f\u544a\u9875Activity\u521b\u5efa\u5931\u8d25\uff0c\u4e1a\u52a1\u6570\u636e\u4e3a\u7a7a");
            a(fSCallback);
            return;
        }
        d.h(this.f43182i);
        d();
        c();
        a().l().b(LifecycleCallback.a.AFTER_CREATED);
        fSCallback.A().a();
        com.qq.e.comm.plugin.fs.d.b bVar = this.f43180g;
        if (bVar != null) {
            bVar.l();
        }
        l.a().b(1).b("afterCreate", 2302101, com.qq.e.comm.plugin.n0.c.a(this.f43182i));
        if (i.e()) {
            new com.qq.e.comm.plugin.h0.e(this.f43176c, 2302103).c();
        }
        this.f43184k = new b(this, this.f43182i);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        com.qq.e.comm.plugin.fs.d.b bVar = this.f43180g;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        l.a().b(1).b("beforeCreate", 2302100, null);
        this.f43176c.requestWindowFeature(1);
        Window window = this.f43176c.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setBackgroundDrawable(new ColorDrawable(-16777216));
            }
            window.setFlags(16778368, 16778368);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        f fVar = this.f43179f;
        if (fVar != null) {
            fVar.onDestroy();
            this.f43179f = null;
        }
        com.qq.e.comm.plugin.fs.a aVar = this.f43184k;
        if (aVar != null) {
            aVar.onDestroy();
        }
        com.qq.e.comm.plugin.fs.d.b bVar = this.f43180g;
        if (bVar != null) {
            bVar.n();
        }
        com.qq.e.comm.plugin.fs.f.a aVar2 = this.f43178e;
        if (aVar2 != null) {
            n2.a(aVar2);
        }
        a().l().b(LifecycleCallback.a.DESTROYED);
        com.qq.e.comm.plugin.d0.b.e.b(this.f43183j, com.qq.e.comm.plugin.d0.b.b.class);
        com.qq.e.comm.plugin.e.a.a().b(this.f43177d);
        l.a().a(1);
        i.g();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        a().l().b(LifecycleCallback.a.PAUSED);
        com.qq.e.comm.plugin.fs.a aVar = this.f43184k;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        l.a().b(1).a("onResume", 2302102, com.qq.e.comm.plugin.n0.c.a(this.f43182i));
        a().l().b(LifecycleCallback.a.RESUMED);
        com.qq.e.comm.plugin.fs.a aVar = this.f43184k;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
        a().l().b(LifecycleCallback.a.STOPPED);
    }

    private void a(FSCallback fSCallback) {
        if (fSCallback != null) {
            fSCallback.G().b(5001);
        }
        com.qq.e.comm.plugin.d0.b.e.a(com.qq.e.comm.plugin.d0.b.b.class);
        this.f43176c.finish();
    }

    private void a(com.qq.e.comm.plugin.fs.d.d.a aVar) {
        Activity activity = this.f43176c;
        e eVar = this.f43182i;
        String d4 = aVar.d();
        e eVar2 = this.f43182i;
        f a4 = com.qq.e.comm.plugin.fs.f.e.d.b.a(activity, eVar, d4, q.a(eVar2, ((u) eVar2).f()), aVar);
        this.f43179f = a4;
        a4.a(this.f43177d);
        this.f43179f.c();
    }

    private LifecycleCallback a() {
        return (LifecycleCallback) com.qq.e.comm.plugin.h.a.b(this.f43183j, LifecycleCallback.class);
    }
}
