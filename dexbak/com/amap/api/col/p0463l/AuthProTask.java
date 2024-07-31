package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0463l.AuthRequest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3l.z9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AuthProTask extends Thread {

    /* renamed from: e */
    private static int f5834e = 0;

    /* renamed from: f */
    private static int f5835f = 3;

    /* renamed from: g */
    private static long f5836g = 30000;

    /* renamed from: h */
    private static boolean f5837h;

    /* renamed from: a */
    private WeakReference<Context> f5838a;

    /* renamed from: b */
    private IAMapDelegate f5839b;

    /* renamed from: c */
    private C2014b f5840c = null;

    /* renamed from: d */
    private Handler f5841d = new HandlerC2013a(Looper.getMainLooper());

    /* compiled from: AuthProTask.java */
    /* renamed from: com.amap.api.col.3l.z9$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class HandlerC2013a extends Handler {
        HandlerC2013a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (AuthProTask.f5837h) {
                return;
            }
            if (AuthProTask.this.f5840c == null) {
                AuthProTask authProTask = AuthProTask.this;
                authProTask.f5840c = new C2014b(authProTask.f5839b, AuthProTask.this.f5838a == null ? null : (Context) AuthProTask.this.f5838a.get());
            }
            ThreadUtil.m53406a().m53405b(AuthProTask.this.f5840c);
        }
    }

    /* compiled from: AuthProTask.java */
    /* renamed from: com.amap.api.col.3l.z9$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C2014b extends ThreadTask {

        /* renamed from: a */
        private WeakReference<IAMapDelegate> f5843a;

        /* renamed from: b */
        private WeakReference<Context> f5844b;

        /* renamed from: c */
        private AuthRequest f5845c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AuthProTask.java */
        /* renamed from: com.amap.api.col.3l.z9$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public final class RunnableC2015a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ IAMapDelegate f5846a;

            RunnableC2015a(IAMapDelegate iAMapDelegate) {
                this.f5846a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IAMapDelegate iAMapDelegate = this.f5846a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f5846a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f5846a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f5846a.reloadMapCustomStyle();
                    AuthLogUtil.m54856b(C2014b.this.f5844b == null ? null : (Context) C2014b.this.f5844b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                }
            }
        }

        public C2014b(IAMapDelegate iAMapDelegate, Context context) {
            this.f5843a = null;
            this.f5844b = null;
            this.f5843a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f5844b = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            AuthRequest.C1739a m53534n;
            WeakReference<Context> weakReference;
            try {
                if (AuthProTask.f5837h) {
                    return;
                }
                if (this.f5845c == null && (weakReference = this.f5844b) != null && weakReference.get() != null) {
                    this.f5845c = new AuthRequest(this.f5844b.get(), "");
                }
                AuthProTask.m53304d();
                if (AuthProTask.f5834e > AuthProTask.f5835f) {
                    AuthProTask.m53299i();
                    m53296a();
                    return;
                }
                AuthRequest authRequest = this.f5845c;
                if (authRequest == null || (m53534n = authRequest.m53534n()) == null) {
                    return;
                }
                if (!m53534n.f3572d) {
                    m53296a();
                }
                AuthProTask.m53299i();
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "authForPro", "loadConfigData_uploadException");
                String str = LinkLogConfig.f3647e;
                LinkLogManager.m55482l(str, "auth exception get data " + th.getMessage());
            }
        }

        /* renamed from: a */
        private void m53296a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f5843a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f5843a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new RunnableC2015a(iAMapDelegate));
        }
    }

    public AuthProTask(Context context, IAMapDelegate iAMapDelegate) {
        this.f5838a = null;
        if (context != null) {
            this.f5838a = new WeakReference<>(context);
        }
        this.f5839b = iAMapDelegate;
        m53298j();
    }

    /* renamed from: d */
    static /* synthetic */ int m53304d() {
        int i = f5834e;
        f5834e = i + 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ boolean m53299i() {
        f5837h = true;
        return true;
    }

    /* renamed from: j */
    private static void m53298j() {
        f5834e = 0;
        f5837h = false;
    }

    /* renamed from: k */
    private void m53297k() {
        if (f5837h) {
            return;
        }
        int i = 0;
        while (i <= f5835f) {
            i++;
            this.f5841d.sendEmptyMessageDelayed(0, i * f5836g);
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.f5839b = null;
        this.f5838a = null;
        Handler handler = this.f5841d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f5841d = null;
        this.f5840c = null;
        m53298j();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            m53297k();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            String str = LinkLogConfig.f3647e;
            LinkLogManager.m55482l(str, "auth pro exception " + th.getMessage());
        }
    }
}
