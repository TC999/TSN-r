package com.qq.e.comm.plugin.h0;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.qq.e.comm.plugin.h0.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private static final String f44021d = "e";

    /* renamed from: a  reason: collision with root package name */
    private final Activity f44022a;

    /* renamed from: b  reason: collision with root package name */
    private final int f44023b;

    /* renamed from: c  reason: collision with root package name */
    private final f f44024c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.util.i {
        a() {
        }

        @Override // com.qq.e.comm.plugin.util.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity != e.this.f44022a) {
                return;
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            d1.a(e.f44021d, "onActivityDestroyed, fps stop");
            e.this.f44024c.stop();
            e.this.d();
        }
    }

    public e(Activity activity, int i4) {
        this.f44022a = activity;
        this.f44023b = i4;
        long refreshRate = Build.VERSION.SDK_INT >= 23 ? 1.0E9f / ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMode().getRefreshRate() : 16666666L;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f44024c = new d(this.f44022a, refreshRate);
        } else {
            this.f44024c = new c(this.f44022a, refreshRate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        f.a a4 = this.f44024c.a();
        long j4 = (a4.f44030e * C.NANOS_PER_SECOND) + (a4.f44029d * C.MICROS_PER_SECOND) + (a4.f44028c * 1000) + a4.f44027b + (a4.f44026a * 0);
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(this.f44023b);
        hVar.b(j4);
        v.a(hVar);
        d1.a(f44021d, "FPS \u7edf\u8ba1\u7ed3\u679c\uff1a\nNormal: count = %s, \nMiddle: count = %s, \nHigh: count = %s,\nFrozen: count = %s, \ntraceValue: %s\n", Integer.valueOf(a4.f44027b), Integer.valueOf(a4.f44028c), Integer.valueOf(a4.f44029d), Integer.valueOf(a4.f44030e), Long.valueOf(j4));
    }

    private void b() {
        this.f44022a.getApplication().registerActivityLifecycleCallbacks(new a());
    }

    public void c() {
        if (Build.VERSION.SDK_INT < 16) {
            d1.b(f44021d, "\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301 fps \u68c0\u6d4b");
            return;
        }
        this.f44024c.start();
        b();
    }
}
