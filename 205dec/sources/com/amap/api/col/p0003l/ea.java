package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthTerrainTask.java */
/* renamed from: com.amap.api.col.3l.ea  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ea {

    /* renamed from: a  reason: collision with root package name */
    private Context f7507a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<IAMapDelegate> f7508b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f7509c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f7510d;

    /* renamed from: e  reason: collision with root package name */
    private c f7511e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f7512f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f7513g = new b();

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.ea$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ea.this.f7511e == null) {
                ea eaVar = ea.this;
                eaVar.f7511e = new c(eaVar.f7507a, ea.this);
            }
            y2.a().b(ea.this.f7511e);
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.ea$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) ea.this.f7508b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            h2.b(ea.this.f7507a, "\u5730\u5f62\u56fe\u9274\u6743\u5931\u8d25\uff0c\u5f53\u524dkey\u6ca1\u6709\u5730\u5f62\u56fe\u7684\u4f7f\u7528\u6743\u9650\uff0c\u5730\u5f62\u56fe\uff0c\u5c06\u4e0d\u4f1a\u5448\u73b0\uff01");
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.ea$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class c extends a8 {

        /* renamed from: a  reason: collision with root package name */
        private Context f7516a;

        /* renamed from: b  reason: collision with root package name */
        private ea f7517b;

        /* renamed from: c  reason: collision with root package name */
        private d f7518c;

        public c(Context context, ea eaVar) {
            this.f7516a = context;
            this.f7517b = eaVar;
            this.f7518c = new d(context, "");
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                e n4 = this.f7518c.n();
                if (n4 == null) {
                    this.f7517b.d(PolicyConfig.mServerBusyRetryBaseInternal);
                } else if (n4.f7523d) {
                } else {
                    this.f7517b.h();
                }
            } catch (fc e4) {
                e4.printStackTrace();
                this.f7517b.d(PolicyConfig.mServerBusyRetryBaseInternal);
            }
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.ea$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class d extends x3<String, e> {

        /* renamed from: r  reason: collision with root package name */
        private boolean f7519r;

        public d(Context context, String str) {
            super(context, str);
            this.f9405p = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.f7519r = true;
        }

        private static e p(String str) throws fc {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("infocode");
                String optString3 = jSONObject.optString("status");
                boolean z3 = false;
                e eVar = new e((byte) 0);
                eVar.f7520a = optString;
                eVar.f7521b = optString2;
                eVar.f7522c = optString3;
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString2, "10000")) {
                    z3 = true;
                }
                eVar.f7523d = z3;
                return eVar;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        private static e q(byte[] bArr) throws fc {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e4) {
                e4.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return p(str);
        }

        @Override // com.amap.api.col.p0003l.x3
        protected final /* synthetic */ e e(String str) throws fc {
            return p(str);
        }

        @Override // com.amap.api.col.p0003l.x3
        protected final /* synthetic */ e f(byte[] bArr) throws fc {
            return q(bArr);
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return a3.y(getURL());
        }

        @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
            if (this.f7519r) {
                hashtable.put("pname", "3dmap");
            }
            String a4 = h4.a();
            String c4 = h4.c(this.f9404k, a4, q4.r(hashtable));
            hashtable.put("ts", a4);
            hashtable.put("scode", c4);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return "http://restsdk.amap.com" + this.f9405p;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0003l.x3
        protected final String m() {
            return null;
        }
    }

    public ea(Context context, IAMapDelegate iAMapDelegate) {
        this.f7507a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7508b = new WeakReference<>(iAMapDelegate);
        f();
    }

    private void f() {
        if (this.f7509c == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.f7509c = handlerThread;
            handlerThread.start();
            this.f7510d = new Handler(this.f7509c.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Handler handler = this.f7510d;
        if (handler != null) {
            handler.postDelayed(this.f7513g, 1000L);
        }
    }

    public final void c() {
        Handler handler = this.f7510d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f7510d = null;
        }
        HandlerThread handlerThread = this.f7509c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f7509c = null;
        }
    }

    public final void d(long j4) {
        Handler handler = this.f7510d;
        if (handler != null) {
            handler.postDelayed(this.f7512f, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.ea$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f7520a;

        /* renamed from: b  reason: collision with root package name */
        public String f7521b;

        /* renamed from: c  reason: collision with root package name */
        public String f7522c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7523d;

        private e() {
            this.f7523d = false;
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }
}
