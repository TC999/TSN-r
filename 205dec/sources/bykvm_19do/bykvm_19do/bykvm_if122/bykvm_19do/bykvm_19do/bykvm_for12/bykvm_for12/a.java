package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: AppConfig.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f701a;

    /* renamed from: i  reason: collision with root package name */
    private final Context f709i;

    /* renamed from: k  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a f711k;

    /* renamed from: l  reason: collision with root package name */
    private int f712l;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f702b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f703c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f704d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f705e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f706f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ThreadPoolExecutor f707g = null;

    /* renamed from: h  reason: collision with root package name */
    private AtomicBoolean f708h = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f710j = false;

    /* renamed from: m  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g f713m = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class RunnableC0029a implements Runnable {
        RunnableC0029a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f715a;

        b(boolean z3) {
            this.f715a = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.f715a);
        }
    }

    public a(Context context, int i4) {
        this.f709i = context;
        this.f701a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f.b(context);
        this.f712l = i4;
    }

    private void d(boolean z3) {
        if (this.f704d) {
            return;
        }
        if (this.f703c) {
            this.f703c = false;
            this.f705e = 0L;
            this.f706f = 0L;
        }
        long j4 = z3 ? 10800000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f705e <= j4 || currentTimeMillis - this.f706f <= PolicyConfig.THREAD_BLOCK_TIMEOUT) {
            return;
        }
        boolean a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f709i);
        if (!this.f710j || a4) {
            a(a4);
        }
    }

    private boolean g() {
        String[] a4 = a();
        if (a4 != null && a4.length != 0) {
            a(0);
        }
        return false;
    }

    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a h() {
        if (this.f711k == null) {
            a.b bVar = new a.b();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f711k = bVar.a(10L, timeUnit).b(10L, timeUnit).c(10L, timeUnit).a();
        }
        return this.f711k;
    }

    synchronized void c() {
        if (System.currentTimeMillis() - this.f705e > 3600000) {
            this.f705e = System.currentTimeMillis();
            try {
                if (h.a().a(this.f712l).d() != null) {
                    h.a().a(this.f712l).d().c();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void e() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.f701a) {
                d();
            } else {
                c();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        b(false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g.a
    public void handleMsg(Message message) {
        int i4 = message.what;
        if (i4 == 101) {
            this.f704d = false;
            this.f705e = System.currentTimeMillis();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, succ");
            if (this.f703c) {
                f();
            }
            this.f708h.set(false);
        } else if (i4 != 102) {
        } else {
            this.f704d = false;
            if (this.f703c) {
                f();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, error");
            this.f708h.set(false);
        }
    }

    public synchronized void b(boolean z3) {
        if (this.f701a) {
            d(z3);
        } else if (this.f705e <= 0) {
            try {
                b().execute(new RunnableC0029a());
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a(boolean z3) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh: updating state " + this.f708h.get());
        if (!this.f708h.compareAndSet(false, true)) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z3) {
            this.f706f = System.currentTimeMillis();
        }
        b().execute(new b(z3));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g gVar = this.f713m;
        if (gVar != null) {
            gVar.sendEmptyMessage(i4);
        }
    }

    void c(boolean z3) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, actual request");
        d();
        this.f704d = true;
        if (!z3) {
            this.f713m.sendEmptyMessage(102);
            return;
        }
        try {
            g();
        } catch (Exception unused) {
            this.f708h.set(false);
        }
    }

    public String[] a() {
        String[] a4 = h.a().a(this.f712l).b() != null ? h.a().a(this.f712l).b().a() : null;
        return (a4 == null || a4.length <= 0) ? new String[0] : a4;
    }

    public ThreadPoolExecutor b() {
        if (this.f707g == null) {
            synchronized (a.class) {
                if (this.f707g == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    this.f707g = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return this.f707g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppConfig.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f717a;

        c(int i4) {
            this.f717a = i4;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            JSONObject jSONObject;
            if (bVar2 == null || !bVar2.e()) {
                a.this.a(this.f717a + 1);
                return;
            }
            String str = null;
            try {
                jSONObject = new JSONObject(bVar2.a());
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                a.this.a(this.f717a + 1);
                return;
            }
            try {
                str = jSONObject.getString("message");
            } catch (Exception unused2) {
            }
            if (!"success".equals(str)) {
                a.this.a(this.f717a + 1);
                return;
            }
            try {
                if (a.this.a(jSONObject)) {
                    a.this.b(101);
                } else {
                    a.this.a(this.f717a + 1);
                }
            } catch (Exception unused3) {
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            a.this.a(this.f717a + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
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
            SharedPreferences.Editor edit = this.f709i.getSharedPreferences("m_ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (h.a().a(this.f712l).d() != null) {
            h.a().a(this.f712l).d().a(jSONObject2);
            return true;
        }
        return true;
    }

    public synchronized void d() {
        if (this.f710j) {
            return;
        }
        this.f710j = true;
        long j4 = this.f709i.getSharedPreferences("m_ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j4 > currentTimeMillis) {
            j4 = currentTimeMillis;
        }
        this.f705e = j4;
        if (h.a().a(this.f712l).d() != null) {
            h.a().a(this.f712l).d().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        String[] a4 = a();
        if (a4 != null && a4.length > i4) {
            String str = a4[i4];
            if (TextUtils.isEmpty(str)) {
                b(102);
                return;
            }
            try {
                String a5 = a(str);
                if (TextUtils.isEmpty(a5)) {
                    b(102);
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a a6 = h().a();
                a6.b(a5);
                a(a6);
                a6.a(new c(i4));
                return;
            } catch (Throwable th) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        b(102);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JPushConstants.HTTPS_PRE + str + "/get_domains/v4/";
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        Address a4 = h.a().a(this.f712l).b() != null ? h.a().a(this.f712l).b().a(this.f709i) : null;
        if (a4 != null && a4.hasLatitude() && a4.hasLongitude()) {
            aVar.b("latitude", a4.getLatitude() + "");
            aVar.b("longitude", a4.getLongitude() + "");
            String locality = a4.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                aVar.b("city", Uri.encode(locality));
            }
        }
        if (this.f702b) {
            aVar.b("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            aVar.b("abi", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (h.a().a(this.f712l).b() != null) {
            aVar.b("aid", h.a().a(this.f712l).b().c() + "");
            aVar.b("device_platform", h.a().a(this.f712l).b().b());
            aVar.b("channel", h.a().a(this.f712l).b().d());
            aVar.b("version_code", h.a().a(this.f712l).b().e() + "");
            aVar.b("custom_info_1", h.a().a(this.f712l).b().f());
        }
    }
}
