package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003l.ba;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthProTask.java */
/* renamed from: com.amap.api.col.3l.aa  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class aa extends Thread {

    /* renamed from: e  reason: collision with root package name */
    private static int f7120e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f7121f = 3;

    /* renamed from: g  reason: collision with root package name */
    private static long f7122g = 30000;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f7123h;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f7124a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f7125b;

    /* renamed from: c  reason: collision with root package name */
    private b f7126c = null;

    /* renamed from: d  reason: collision with root package name */
    private Handler f7127d = new a(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthProTask.java */
    /* renamed from: com.amap.api.col.3l.aa$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (aa.f7123h) {
                return;
            }
            if (aa.this.f7126c == null) {
                aa aaVar = aa.this;
                aaVar.f7126c = new b(aaVar.f7125b, aa.this.f7124a == null ? null : (Context) aa.this.f7124a.get());
            }
            y2.a().b(aa.this.f7126c);
        }
    }

    /* compiled from: AuthProTask.java */
    /* renamed from: com.amap.api.col.3l.aa$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class b extends a8 {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<IAMapDelegate> f7129a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Context> f7130b;

        /* renamed from: c  reason: collision with root package name */
        private ba f7131c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AuthProTask.java */
        /* renamed from: com.amap.api.col.3l.aa$b$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ IAMapDelegate f7132a;

            a(IAMapDelegate iAMapDelegate) {
                this.f7132a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IAMapDelegate iAMapDelegate = this.f7132a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f7132a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f7132a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f7132a.reloadMapCustomStyle();
                    h2.b(b.this.f7130b == null ? null : (Context) b.this.f7130b.get(), "\u9274\u6743\u5931\u8d25\uff0c\u5f53\u524dkey\u6ca1\u6709\u81ea\u5b9a\u4e49\u7eb9\u7406\u7684\u4f7f\u7528\u6743\u9650\uff0c\u81ea\u5b9a\u4e49\u7eb9\u7406\u76f8\u5173\u5185\u5bb9\uff0c\u5c06\u4e0d\u4f1a\u5448\u73b0\uff01");
                }
            }
        }

        public b(IAMapDelegate iAMapDelegate, Context context) {
            this.f7129a = null;
            this.f7130b = null;
            this.f7129a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f7130b = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            ba.a n4;
            WeakReference<Context> weakReference;
            try {
                if (aa.f7123h) {
                    return;
                }
                if (this.f7131c == null && (weakReference = this.f7130b) != null && weakReference.get() != null) {
                    this.f7131c = new ba(this.f7130b.get(), "");
                }
                aa.d();
                if (aa.f7120e > aa.f7121f) {
                    aa.i();
                    a();
                    return;
                }
                ba baVar = this.f7131c;
                if (baVar == null || (n4 = baVar.n()) == null) {
                    return;
                }
                if (!n4.f7282d) {
                    a();
                }
                aa.i();
            } catch (Throwable th) {
                u5.p(th, "authForPro", "loadConfigData_uploadException");
                String str = b3.f7208e;
                c3.l(str, "auth exception get data " + th.getMessage());
            }
        }

        private void a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f7129a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f7129a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new a(iAMapDelegate));
        }
    }

    public aa(Context context, IAMapDelegate iAMapDelegate) {
        this.f7124a = null;
        if (context != null) {
            this.f7124a = new WeakReference<>(context);
        }
        this.f7125b = iAMapDelegate;
        j();
    }

    static /* synthetic */ int d() {
        int i4 = f7120e;
        f7120e = i4 + 1;
        return i4;
    }

    static /* synthetic */ boolean i() {
        f7123h = true;
        return true;
    }

    private static void j() {
        f7120e = 0;
        f7123h = false;
    }

    private void k() {
        if (f7123h) {
            return;
        }
        int i4 = 0;
        while (i4 <= f7121f) {
            i4++;
            this.f7127d.sendEmptyMessageDelayed(0, i4 * f7122g);
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.f7125b = null;
        this.f7124a = null;
        Handler handler = this.f7127d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f7127d = null;
        this.f7126c = null;
        j();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            k();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            String str = b3.f7208e;
            c3.l(str, "auth pro exception " + th.getMessage());
        }
    }
}
