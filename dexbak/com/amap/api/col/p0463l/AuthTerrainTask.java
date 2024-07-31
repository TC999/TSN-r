package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.da */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthTerrainTask {

    /* renamed from: a */
    private Context f3884a;

    /* renamed from: b */
    private WeakReference<IAMapDelegate> f3885b;

    /* renamed from: c */
    private HandlerThread f3886c;

    /* renamed from: d */
    private Handler f3887d;

    /* renamed from: e */
    private C1776c f3888e;

    /* renamed from: f */
    private final Runnable f3889f = new RunnableC1774a();

    /* renamed from: g */
    private final Runnable f3890g = new RunnableC1775b();

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class RunnableC1774a implements Runnable {
        RunnableC1774a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AuthTerrainTask.this.f3888e == null) {
                AuthTerrainTask authTerrainTask = AuthTerrainTask.this;
                authTerrainTask.f3888e = new C1776c(authTerrainTask.f3884a, AuthTerrainTask.this);
            }
            ThreadUtil.m53406a().m53405b(AuthTerrainTask.this.f3888e);
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class RunnableC1775b implements Runnable {
        RunnableC1775b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) AuthTerrainTask.this.f3885b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            AuthLogUtil.m54856b(AuthTerrainTask.this.f3884a, "地形图鉴权失败，当前key没有地形图的使用权限，地形图，将不会呈现！");
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1776c extends ThreadTask {

        /* renamed from: a */
        private Context f3893a;

        /* renamed from: b */
        private AuthTerrainTask f3894b;

        /* renamed from: c */
        private C1777d f3895c;

        public C1776c(Context context, AuthTerrainTask authTerrainTask) {
            this.f3893a = context;
            this.f3894b = authTerrainTask;
            this.f3895c = new C1777d(context, "");
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                C1778e m53534n = this.f3895c.m53534n();
                if (m53534n == null) {
                    this.f3894b.m55262d(30000L);
                } else if (m53534n.f3900d) {
                } else {
                    this.f3894b.m55258h();
                }
            } catch (AMapException e) {
                e.printStackTrace();
                this.f3894b.m55262d(30000L);
            }
        }
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1777d extends AbstractBasicHandler<String, C1778e> {

        /* renamed from: r */
        private boolean f3896r;

        public C1777d(Context context, String str) {
            super(context, str);
            this.f5674p = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.f3896r = true;
        }

        /* renamed from: p */
        private static C1778e m55256p(String str) throws AMapException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("infocode");
                String optString3 = jSONObject.optString("status");
                boolean z = false;
                C1778e c1778e = new C1778e((byte) 0);
                c1778e.f3897a = optString;
                c1778e.f3898b = optString2;
                c1778e.f3899c = optString3;
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString2, "10000")) {
                    z = true;
                }
                c1778e.f3900d = z;
                return c1778e;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: q */
        private static C1778e m55255q(byte[] bArr) throws AMapException {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return m55256p(str);
        }

        @Override // com.amap.api.col.p0463l.AbstractBasicHandler
        /* renamed from: e */
        protected final /* synthetic */ C1778e mo53402e(String str) throws AMapException {
            return m55256p(str);
        }

        @Override // com.amap.api.col.p0463l.AbstractBasicHandler
        /* renamed from: f */
        protected final /* synthetic */ C1778e mo53538f(byte[] bArr) throws AMapException {
            return m55255q(bArr);
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getIPV6URL() {
            return C1732a3.m55685y(getURL());
        }

        @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
            if (this.f3896r) {
                hashtable.put("pname", "3dmap");
            }
            String m54933a = ClientInfo.m54933a();
            String m54931c = ClientInfo.m54931c(this.f5673k, m54933a, C1925p4.m54186r(hashtable));
            hashtable.put("ts", m54933a);
            hashtable.put("scode", m54931c);
            return hashtable;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            return "http://restsdk.amap.com" + this.f5674p;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0463l.AbstractBasicHandler
        /* renamed from: m */
        protected final String mo53401m() {
            return null;
        }
    }

    public AuthTerrainTask(Context context, IAMapDelegate iAMapDelegate) {
        this.f3884a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3885b = new WeakReference<>(iAMapDelegate);
        m55260f();
    }

    /* renamed from: f */
    private void m55260f() {
        if (this.f3886c == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.f3886c = handlerThread;
            handlerThread.start();
            this.f3887d = new Handler(this.f3886c.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m55258h() {
        Handler handler = this.f3887d;
        if (handler != null) {
            handler.postDelayed(this.f3890g, 1000L);
        }
    }

    /* renamed from: c */
    public final void m55263c() {
        Handler handler = this.f3887d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3887d = null;
        }
        HandlerThread handlerThread = this.f3886c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f3886c = null;
        }
    }

    /* renamed from: d */
    public final void m55262d(long j) {
        Handler handler = this.f3887d;
        if (handler != null) {
            handler.postDelayed(this.f3889f, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1778e {

        /* renamed from: a */
        public String f3897a;

        /* renamed from: b */
        public String f3898b;

        /* renamed from: c */
        public String f3899c;

        /* renamed from: d */
        public boolean f3900d;

        private C1778e() {
            this.f3900d = false;
        }

        /* synthetic */ C1778e(byte b) {
            this();
        }
    }
}
