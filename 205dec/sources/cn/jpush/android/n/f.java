package cn.jpush.android.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final LocationManager f4264a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4265b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f4266c;

    /* renamed from: e  reason: collision with root package name */
    private volatile a f4268e;

    /* renamed from: f  reason: collision with root package name */
    private volatile b f4269f;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, JSONObject> f4267d = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f4270g = false;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f4273a;

        /* renamed from: b  reason: collision with root package name */
        public double f4274b;

        /* renamed from: c  reason: collision with root package name */
        public double f4275c;

        public a() {
        }

        public void a(Context context) {
            String m4 = cn.jpush.android.cache.a.m(context);
            if (TextUtils.isEmpty(m4)) {
                return;
            }
            Logger.d("GeofencePullHelper", "last pull state:" + m4);
            try {
                a(new JSONObject(m4));
            } catch (JSONException unused) {
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            Logger.d("GeofencePullHelper", "saveGeofenceLastPullState:" + jSONObject.toString());
            a(jSONObject);
            cn.jpush.android.cache.a.f(f.this.f4265b, jSONObject.toString());
        }

        public void a(JSONObject jSONObject) {
            f.this.f4268e.f4274b = jSONObject.optDouble("lat", 200.0d);
            f.this.f4268e.f4275c = jSONObject.optDouble("lng", 200.0d);
            f.this.f4268e.f4273a = jSONObject.optLong("time", 0L);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4277a = 1800;

        /* renamed from: b  reason: collision with root package name */
        public int f4278b = 10800;

        /* renamed from: c  reason: collision with root package name */
        public int f4279c = 900;

        /* renamed from: d  reason: collision with root package name */
        public int f4280d = 20;

        public b() {
        }

        private void a(JSONObject jSONObject) {
            f.this.f4269f.f4277a = jSONObject.optInt("minInterval", f.this.f4269f.f4277a);
            f.this.f4269f.f4278b = jSONObject.optInt("nextInterval", f.this.f4269f.f4278b);
            f.this.f4269f.f4279c = jSONObject.optInt("minLBSInterval", f.this.f4269f.f4279c);
            f.this.f4269f.f4280d = jSONObject.optInt("minLBSKilo", f.this.f4269f.f4280d);
        }

        private void a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i4) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, i4);
            }
        }

        public void a(Context context) {
            String l4 = cn.jpush.android.cache.a.l(context);
            if (TextUtils.isEmpty(l4)) {
                return;
            }
            Logger.d("GeofencePullHelper", "pull limit:" + l4);
            try {
                a(new JSONObject(l4));
            } catch (Throwable unused) {
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject, jSONObject2, "minInterval", f.this.f4269f.f4277a);
                a(jSONObject, jSONObject2, "nextInterval", f.this.f4269f.f4278b);
                a(jSONObject, jSONObject2, "minLBSInterval", f.this.f4269f.f4279c);
                a(jSONObject, jSONObject2, "minLBSKilo", f.this.f4269f.f4280d);
                cn.jpush.android.cache.a.e(context, jSONObject2.toString());
            } catch (Throwable unused) {
                Logger.d("GeofencePullHelper", "save limit failed");
            }
        }
    }

    public f(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f4265b = origApplicationContext;
        this.f4264a = (LocationManager) origApplicationContext.getSystemService("location");
        c();
        i();
        j();
    }

    private void a(double d4, double d5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", d4);
            jSONObject.put("lng", d5);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            long a4 = cn.jpush.android.helper.f.a();
            Logger.dd("GeofencePullHelper", "will send report geo request:" + jSONObject + ",requestid:" + a4);
            HashMap<String, JSONObject> hashMap = this.f4267d;
            StringBuilder sb = new StringBuilder();
            sb.append(a4);
            sb.append("");
            hashMap.put(sb.toString(), jSONObject);
            JCoreHelper.sendRequest(this.f4265b, JPushConstants.SDK_TYPE, 37, 1, a4, 0L, cn.jpush.android.z.b.c(jSONObject.toString()));
        } catch (Throwable th) {
            Logger.dd("GeofencePullHelper", "send report geo request failed:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4) {
        StringBuilder sb = new StringBuilder();
        sb.append("pull geofence after ");
        long j5 = j4 * 1000;
        sb.append(j5);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f4266c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f4266c.removeMessages(1000);
        }
        this.f4266c.sendEmptyMessageDelayed(1000, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j4) {
        StringBuilder sb = new StringBuilder();
        sb.append("compile loc after ");
        long j5 = j4 * 1000;
        sb.append(j5);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f4266c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1002)) {
            this.f4266c.removeMessages(1002);
        }
        this.f4266c.sendEmptyMessageDelayed(1002, j5);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_gph_thread") { // from class: cn.jpush.android.n.f.1
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e4) {
                        Logger.e("GeofencePullHelper", "handler thread run e:" + e4 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f4266c = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.n.f.2
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            f fVar = f.this;
                            fVar.a(fVar.f4269f.f4278b);
                            break;
                        case 1001:
                            break;
                        case 1002:
                            if (f.this.g()) {
                                f.this.a(0L);
                            }
                            f fVar2 = f.this;
                            fVar2.b(fVar2.f4269f.f4279c);
                            return;
                        default:
                            return;
                    }
                    f.this.f();
                }
            };
        } catch (Throwable th) {
            Logger.ww("GeofencePullHelper", "init geofence pull handler failed:" + th);
        }
    }

    private void d() {
        Logger.dd("GeofencePullHelper", "start schedule geofence pull");
        a((h() || g()) ? 0L : this.f4269f.f4278b);
        b(this.f4269f.f4279c);
    }

    private void e() {
        Logger.dd("GeofencePullHelper", "stop schedule geofence pull");
        Handler handler = this.f4266c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f4266c.removeMessages(1000);
        }
        if (this.f4266c.hasMessages(1001)) {
            this.f4266c.removeMessages(1001);
        }
        if (this.f4266c.hasMessages(1002)) {
            this.f4266c.removeMessages(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void f() {
        Logger.dd("GeofencePullHelper", "try pull...");
        Location a4 = c.a(this.f4265b, this.f4264a, false);
        if (a4 == null) {
            Logger.dd("GeofencePullHelper", "stop pull,get loction failed");
        } else {
            a(a4.getLatitude(), a4.getLongitude());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Location a4 = c.a(this.f4265b, this.f4264a, false);
        if (a4 != null) {
            double a5 = m.a(a4.getLongitude(), a4.getLatitude(), this.f4268e.f4275c, this.f4268e.f4274b);
            Logger.d("GeofencePullHelper", "check current distance to last pull distance:" + a5 + ",lbsKilo:" + (this.f4269f.f4280d * 1000));
            if (a5 > this.f4269f.f4280d * 1000) {
                return true;
            }
        }
        Logger.dd("GeofencePullHelper", "loc limit");
        return false;
    }

    private boolean h() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j4 = this.f4268e.f4273a;
        Logger.dd("GeofencePullHelper", "lastPullTime:" + j4 + ",currentTime:" + currentTimeMillis + ",minInterval:" + this.f4269f.f4277a);
        if (currentTimeMillis - j4 < this.f4269f.f4277a) {
            Logger.dd("GeofencePullHelper", "time limit");
            return false;
        }
        return true;
    }

    private void i() {
        this.f4268e = new a();
        this.f4268e.a(this.f4265b);
    }

    private void j() {
        this.f4269f = new b();
        this.f4269f.a(this.f4265b);
        this.f4270g = cn.jpush.android.cache.a.k(this.f4265b);
    }

    public void a() {
        Logger.d("GeofencePullHelper", "onLogin");
        if (this.f4270g) {
            d();
        } else {
            Logger.dd("GeofencePullHelper", "do not support pull");
        }
    }

    public void a(long j4, int i4, d dVar) {
        String str;
        StringBuilder sb;
        String str2;
        HashMap<String, JSONObject> hashMap = this.f4267d;
        JSONObject remove = hashMap.remove(j4 + "");
        if (i4 == JPushInterface.ErrorCode.TIMEOUT) {
            sb = new StringBuilder();
            str2 = "pull geo is timeout,requestid:";
        } else if (remove != null) {
            JSONObject a4 = dVar.a();
            if (a4 == null) {
                str = "onPullResponse empty pull response";
                Logger.dd("GeofencePullHelper", str);
            }
            this.f4269f.a(this.f4265b, a4);
            JSONArray b4 = dVar.b();
            if (b4 == null) {
                b4 = new JSONArray();
            }
            Logger.dd("GeofencePullHelper", "onPullResponse:" + b4);
            if (b4.length() == 0) {
                this.f4270g = false;
                cn.jpush.android.cache.a.c(this.f4265b, false);
                e();
            }
            this.f4268e.a(this.f4265b, remove);
            e.a().a(b4);
            cn.jpush.android.n.a.a(this.f4265b, b4.toString());
            return;
        } else {
            sb = new StringBuilder();
            str2 = "can not find request from requestid:";
        }
        sb.append(str2);
        sb.append(j4);
        str = sb.toString();
        Logger.dd("GeofencePullHelper", str);
    }

    public void a(cn.jpush.android.n.b bVar) {
        if (bVar == null) {
            return;
        }
        int a4 = bVar.a();
        Logger.d("GeofencePullHelper", "control pull geo type:" + a4);
        if (this.f4270g ^ (a4 == 1)) {
            boolean z3 = a4 == 1;
            this.f4270g = z3;
            cn.jpush.android.cache.a.c(this.f4265b, z3);
            if (this.f4270g) {
                d();
            } else {
                e();
            }
        }
    }

    public void b() {
        Logger.d("GeofencePullHelper", "onTcpDisconnected");
        e();
    }
}
