package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetResponse;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.GetExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.NetExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1003b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.C1008e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.ProcessUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.WeakHandler;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AppConfig implements WeakHandler.InterfaceC1009a {

    /* renamed from: a */
    private final boolean f708a;

    /* renamed from: i */
    private final Context f716i;

    /* renamed from: k */
    private NetClient f718k;

    /* renamed from: l */
    private int f719l;

    /* renamed from: b */
    private volatile boolean f709b = false;

    /* renamed from: c */
    private boolean f710c = true;

    /* renamed from: d */
    private boolean f711d = false;

    /* renamed from: e */
    private long f712e = 0;

    /* renamed from: f */
    private long f713f = 0;

    /* renamed from: g */
    private ThreadPoolExecutor f714g = null;

    /* renamed from: h */
    private AtomicBoolean f715h = new AtomicBoolean(false);

    /* renamed from: j */
    private volatile boolean f717j = false;

    /* renamed from: m */
    final WeakHandler f720m = new WeakHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0996a implements Runnable {
        RunnableC0996a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppConfig.this.m59057c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0997b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f722a;

        RunnableC0997b(boolean z) {
            this.f722a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppConfig.this.m59056c(this.f722a);
        }
    }

    public AppConfig(Context context, int i) {
        this.f716i = context;
        this.f708a = ProcessUtils.m58980b(context);
        this.f719l = i;
    }

    /* renamed from: d */
    private void m59054d(boolean z) {
        if (this.f711d) {
            return;
        }
        if (this.f710c) {
            this.f710c = false;
            this.f712e = 0L;
            this.f713f = 0L;
        }
        long j = z ? 10800000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f712e <= j || currentTimeMillis - this.f713f <= 120000) {
            return;
        }
        boolean m58983a = C1008e.m58983a(this.f716i);
        if (!this.f717j || m58983a) {
            m59062a(m58983a);
        }
    }

    /* renamed from: g */
    private boolean m59051g() {
        String[] m59069a = m59069a();
        if (m59069a != null && m59069a.length != 0) {
            m59068a(0);
        }
        return false;
    }

    /* renamed from: h */
    private NetClient m59050h() {
        if (this.f718k == null) {
            NetClient.C0995b c0995b = new NetClient.C0995b();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f718k = c0995b.m59079a(10L, timeUnit).m59076b(10L, timeUnit).m59075c(10L, timeUnit).m59080a();
        }
        return this.f718k;
    }

    /* renamed from: c */
    synchronized void m59057c() {
        if (System.currentTimeMillis() - this.f712e > C7193bi.f24584s) {
            this.f712e = System.currentTimeMillis();
            try {
                if (TncInstanceManager.m59006a().m59005a(this.f719l).m59015d() != null) {
                    TncInstanceManager.m59006a().m59005a(this.f719l).m59015d().m59034c();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    public void m59053e() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.f708a) {
                m59055d();
            } else {
                m59057c();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public void m59052f() {
        m59058b(false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.WeakHandler.InterfaceC1009a
    public void handleMsg(Message message) {
        int i = message.what;
        if (i == 101) {
            this.f711d = false;
            this.f712e = System.currentTimeMillis();
            C1003b.m58992a("TNCManager", "doRefresh, succ");
            if (this.f710c) {
                m59052f();
            }
            this.f715h.set(false);
        } else if (i != 102) {
        } else {
            this.f711d = false;
            if (this.f710c) {
                m59052f();
            }
            C1003b.m58992a("TNCManager", "doRefresh, error");
            this.f715h.set(false);
        }
    }

    /* renamed from: b */
    public synchronized void m59058b(boolean z) {
        if (this.f708a) {
            m59054d(z);
        } else if (this.f712e <= 0) {
            try {
                m59061b().execute(new RunnableC0996a());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public boolean m59062a(boolean z) {
        C1003b.m58992a("TNCManager", "doRefresh: updating state " + this.f715h.get());
        if (!this.f715h.compareAndSet(false, true)) {
            C1003b.m58992a("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.f713f = System.currentTimeMillis();
        }
        m59061b().execute(new RunnableC0997b(z));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59060b(int i) {
        WeakHandler weakHandler = this.f720m;
        if (weakHandler != null) {
            weakHandler.sendEmptyMessage(i);
        }
    }

    /* renamed from: c */
    void m59056c(boolean z) {
        C1003b.m58992a("TNCManager", "doRefresh, actual request");
        m59055d();
        this.f711d = true;
        if (!z) {
            this.f720m.sendEmptyMessage(102);
            return;
        }
        try {
            m59051g();
        } catch (Exception unused) {
            this.f715h.set(false);
        }
    }

    /* renamed from: a */
    public String[] m59069a() {
        String[] mo59047a = TncInstanceManager.m59006a().m59005a(this.f719l).m59021b() != null ? TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59047a() : null;
        return (mo59047a == null || mo59047a.length <= 0) ? new String[0] : mo59047a;
    }

    /* renamed from: b */
    public ThreadPoolExecutor m59061b() {
        if (this.f714g == null) {
            synchronized (AppConfig.class) {
                if (this.f714g == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    this.f714g = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return this.f714g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0998c extends NetCallback {

        /* renamed from: a */
        final /* synthetic */ int f724a;

        C0998c(int i) {
            this.f724a = i;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59049a(NetExecutor netExecutor, NetResponse netResponse) {
            JSONObject jSONObject;
            if (netResponse == null || !netResponse.m59070e()) {
                AppConfig.this.m59068a(this.f724a + 1);
                return;
            }
            String str = null;
            try {
                jSONObject = new JSONObject(netResponse.m59074a());
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                AppConfig.this.m59068a(this.f724a + 1);
                return;
            }
            try {
                str = jSONObject.getString("message");
            } catch (Exception unused2) {
            }
            if (!"success".equals(str)) {
                AppConfig.this.m59068a(this.f724a + 1);
                return;
            }
            try {
                if (AppConfig.this.m59064a(jSONObject)) {
                    AppConfig.this.m59060b(101);
                } else {
                    AppConfig.this.m59068a(this.f724a + 1);
                }
            } catch (Exception unused3) {
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59048a(NetExecutor netExecutor, IOException iOException) {
            AppConfig.this.m59068a(this.f724a + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m59064a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = this.f716i.getSharedPreferences("m_ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (TncInstanceManager.m59006a().m59005a(this.f719l).m59015d() != null) {
            TncInstanceManager.m59006a().m59005a(this.f719l).m59015d().m59037a(jSONObject2);
            return true;
        }
        return true;
    }

    /* renamed from: d */
    public synchronized void m59055d() {
        if (this.f717j) {
            return;
        }
        this.f717j = true;
        long j = this.f716i.getSharedPreferences("m_ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > currentTimeMillis) {
            j = currentTimeMillis;
        }
        this.f712e = j;
        if (TncInstanceManager.m59006a().m59005a(this.f719l).m59015d() != null) {
            TncInstanceManager.m59006a().m59005a(this.f719l).m59015d().m59036b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m59068a(int i) {
        String[] m59069a = m59069a();
        if (m59069a != null && m59069a.length > i) {
            String str = m59069a[i];
            if (TextUtils.isEmpty(str)) {
                m59060b(102);
                return;
            }
            try {
                String m59063a = m59063a(str);
                if (TextUtils.isEmpty(m59063a)) {
                    m59060b(102);
                    return;
                }
                GetExecutor m59084a = m59050h().m59084a();
                m59084a.m58997b(m59063a);
                m59065a(m59084a);
                m59084a.m59003a(new C0998c(i));
                return;
            } catch (Throwable th) {
                C1003b.m58992a("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        m59060b(102);
    }

    /* renamed from: a */
    private String m59063a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    /* renamed from: a */
    private void m59065a(GetExecutor getExecutor) {
        String str;
        if (getExecutor == null) {
            return;
        }
        Address mo59046a = TncInstanceManager.m59006a().m59005a(this.f719l).m59021b() != null ? TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59046a(this.f716i) : null;
        if (mo59046a != null && mo59046a.hasLatitude() && mo59046a.hasLongitude()) {
            getExecutor.m59002b("latitude", mo59046a.getLatitude() + "");
            getExecutor.m59002b("longitude", mo59046a.getLongitude() + "");
            String locality = mo59046a.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                getExecutor.m59002b(DistrictSearchQuery.KEYWORDS_CITY, Uri.encode(locality));
            }
        }
        if (this.f709b) {
            getExecutor.m59002b(TTDownloadField.TT_FORCE, "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            getExecutor.m59002b("abi", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TncInstanceManager.m59006a().m59005a(this.f719l).m59021b() != null) {
            getExecutor.m59002b(CommonNetImpl.AID, TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59042c() + "");
            getExecutor.m59002b("device_platform", TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59043b());
            getExecutor.m59002b("channel", TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59041d());
            getExecutor.m59002b("version_code", TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59040e() + "");
            getExecutor.m59002b("custom_info_1", TncInstanceManager.m59006a().m59005a(this.f719l).m59021b().mo59039f());
        }
    }
}
