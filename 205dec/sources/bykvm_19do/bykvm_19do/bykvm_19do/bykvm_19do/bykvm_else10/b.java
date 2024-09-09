package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b0;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.m;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.o;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.s;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.w;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.WeakHandler;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: SdkSettingsHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements Runnable, WeakHandler.IHandler {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f331h = new AtomicLong(0);
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    private static volatile b f332i;

    /* renamed from: a  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a f333a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f334b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f335c = Executors.newFixedThreadPool(2);

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f336d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f337e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f338f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private final WeakHandler f339g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SdkSettingsHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f340a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f341b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f342c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f343d;

        /* compiled from: SdkSettingsHelper.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        class RunnableC0021a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b f345a;

            RunnableC0021a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b bVar) {
                this.f345a = bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x010f A[Catch: all -> 0x01be, TryCatch #4 {all -> 0x01be, blocks: (B:6:0x000d, B:8:0x001e, B:10:0x003a, B:13:0x0065, B:28:0x00d8, B:30:0x00f4, B:32:0x00fa, B:33:0x0101, B:35:0x010f, B:38:0x0119, B:40:0x0144, B:43:0x015b, B:45:0x0165, B:46:0x019a, B:20:0x0096, B:27:0x00cf, B:22:0x00a8, B:15:0x0073), top: B:62:0x000d }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0119 A[Catch: all -> 0x01be, TryCatch #4 {all -> 0x01be, blocks: (B:6:0x000d, B:8:0x001e, B:10:0x003a, B:13:0x0065, B:28:0x00d8, B:30:0x00f4, B:32:0x00fa, B:33:0x0101, B:35:0x010f, B:38:0x0119, B:40:0x0144, B:43:0x015b, B:45:0x0165, B:46:0x019a, B:20:0x0096, B:27:0x00cf, B:22:0x00a8, B:15:0x0073), top: B:62:0x000d }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0159  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 505
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a.RunnableC0021a.run():void");
            }
        }

        a(int[] iArr, boolean z3, int[] iArr2, long j4) {
            this.f340a = iArr;
            this.f341b = z3;
            this.f342c = iArr2;
            this.f343d = j4;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            ThreadHelper.runOnMSDKThread(new RunnableC0021a(bVar2));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            Logger.e("SdkSettingsHelper", "setting request failed..." + iOException.getMessage());
            try {
                b.this.j();
                Logger.e("SdkSettingsHelper", "request failed...>>>>> retryLoadSettingData");
            } catch (Throwable unused) {
            }
            b.this.f337e.set(false);
            int[] iArr = this.f342c;
            iArr[0] = 0;
            int[] iArr2 = this.f340a;
            iArr2[0] = -2;
            if (this.f341b) {
                return;
            }
            g.a(iArr[0], iArr2[0], System.currentTimeMillis() - this.f343d);
        }
    }

    private b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a aVar) {
        this.f333a = aVar == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f() : aVar;
        this.f334b = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
        this.f339g = new WeakHandler(Looper.getMainLooper(), this);
    }

    public static b a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a aVar) {
        if (f332i == null) {
            synchronized (b.class) {
                try {
                    if (f332i == null) {
                        f332i = new b(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f332i;
    }

    private String a(JSONObject jSONObject) {
        JSONObject a4 = b0.a(jSONObject);
        if (a4 != null) {
            return a4.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), map.get(str));
            }
        }
        return hashMap;
    }

    private void a(boolean z3) {
        int[] iArr = {0};
        int[] iArr2 = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b.b().a().b();
        b4.b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.f());
        String o4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().o();
        if (!TextUtils.isEmpty(o4)) {
            b4.a("X-Tt-Env", o4);
            b4.a("x-use-ppe", "1");
        }
        b4.a("User-Agent", com.bytedance.msdk.base.b.f27663b);
        b4.c(a(i()));
        b4.a(new a(iArr2, z3, iArr, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                Logger.openDebugMode();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean e() {
        long a4 = r.a("tt_sdk_settings", this.f334b).a("max_expire_time", 0L);
        if (this.f338f.get() && System.currentTimeMillis() > a4) {
            Logger.i("SdkSettingsHelper", "setting \u7f13\u5b58\u8fc7\u671f\uff0c\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            this.f338f.set(false);
            d();
        }
        return System.currentTimeMillis() > a4;
    }

    private static List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("pangle");
        arrayList.add("gdt");
        arrayList.add("admob");
        arrayList.add("unity");
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add("mintegral");
        arrayList.add("ks");
        return arrayList;
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        Map<String, ITTAdapterConfiguration> c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.c();
        List<String> f4 = f();
        if (c4 != null && f4 != null) {
            for (String str : f4) {
                ITTAdapterConfiguration iTTAdapterConfiguration = c4.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                if (iTTAdapterConfiguration != null) {
                    try {
                        jSONObject.put(str, iTTAdapterConfiguration.getNetworkSdkVersion());
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    private JSONObject h() {
        Map<String, String> customInfos;
        JSONObject jSONObject = new JSONObject();
        UserInfoForSegment s3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().s();
        if (s3 == null || (customInfos = s3.getCustomInfos()) == null) {
            return null;
        }
        try {
            for (String str : customInfos.keySet()) {
                jSONObject.put(str, customInfos.get(str));
            }
            return jSONObject;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private JSONObject i() {
        d b4;
        for (char c4 = '\b'; c4 != 7 && (c4 == '\b' || c4 != '\t'); c4 = '\t') {
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("media_sdk_version", "2.9.2.1");
            jSONObject.put("app_id", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c());
            jSONObject.put("package_name", b0.a());
            jSONObject.put("app_version", b0.e());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("android_id", k.a(this.f334b));
            jSONObject2.put("imei", k.e(this.f334b));
            jSONObject2.put("imei_md5", m.a(k.e(this.f334b)));
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, o.a());
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, f.c().a());
            jSONObject2.put("applog_did", k.d(this.f334b));
            jSONObject2.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().q());
            jSONObject2.put("conn_type", n.b(this.f334b));
            jSONObject2.put("os", 1);
            jSONObject2.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject2.put("vendor", Build.MANUFACTURER);
            String str = Build.MODEL;
            jSONObject2.put("device_model", str);
            jSONObject2.put("mcc", s.b());
            jSONObject2.put("mnc", s.c());
            jSONObject2.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
            jSONObject2.put("ip", i.a());
            jSONObject2.put("locale_language", i.b());
            jSONObject2.put("total_space", "" + i.g());
            jSONObject2.put("carrier_name", s.a());
            jSONObject2.put("device_name", Settings.Global.getString(this.f334b.getContentResolver(), "device_name"));
            jSONObject2.put("pb", "");
            Object[] objArr = new Object[1];
            double currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            Double.isNaN(currentTimeMillis);
            double d4 = currentTimeMillis / 1000.0d;
            Formatter formatter = new Formatter();
            objArr[0] = Double.valueOf(d4);
            Formatter format = formatter.format("%.6f", objArr);
            jSONObject2.put("boot", "" + format.toString());
            jSONObject2.put("device_city", "");
            jSONObject2.put("country_code", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().g());
            jSONObject2.put("total_mem", "" + i.f());
            jSONObject2.put("device_type", str);
            jSONObject2.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("device", jSONObject2);
            jSONObject.put("grouping_params", b());
            JSONObject h4 = h();
            if (h4 != null) {
                jSONObject.put("user_defined_grouping_params", h4);
            }
            if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().v()) {
                jSONObject.put(DownloadModel.ETAG, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().h());
            }
            if (e.b(this.f334b) != null) {
                jSONObject.put("latitude", b4.f631a);
                jSONObject.put("longitude", b4.f632b);
            }
            jSONObject.put("adn_version_list", g());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws Throwable {
        r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).f("server_dist_host");
        this.f337e.set(false);
        if (this.f338f.get()) {
            this.f339g.removeMessages(1);
        } else if (this.f336d.get() < 3) {
            this.f336d.incrementAndGet();
            c();
        } else {
            this.f339g.removeMessages(1);
            this.f339g.sendEmptyMessageDelayed(1, 600000L);
            Logger.i("SdkSettingsHelper", "setting \u91cd\u8bd5\u6b21\u6570\u8d85\u8fc73\u6b21\u5c31\u95f4\u9694\u65f6\u95f4:600000\u6beb\u79d2\u540e\u518d\u6267\u884c....");
        }
    }

    public void a() {
        try {
            if (this.f337e.get()) {
                Logger.i("SdkSettingsHelper", "setting \u6b63\u5728\u52a0\u8f7d\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            } else {
                this.f335c.execute(this);
            }
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public JSONObject b() {
        String userId;
        JSONObject jSONObject = new JSONObject();
        UserInfoForSegment s3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().s();
        if (s3 != null) {
            try {
                userId = s3.getUserId();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            userId = "";
        }
        jSONObject.put("user_id", userId);
        jSONObject.put("channel", s3 != null ? s3.getChannel() : "");
        jSONObject.put("sub_channel", s3 != null ? s3.getSubChannel() : "");
        jSONObject.put("age", s3 != null ? s3.getAge() : 0);
        jSONObject.put("gender", s3 != null ? s3.getGender() : "");
        jSONObject.put("user_value_group", s3 != null ? s3.getUserValueGroup() : "");
        jSONObject.put("init_time", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().f());
        jSONObject.put("android_os_version_int", Build.VERSION.SDK_INT);
        return jSONObject;
    }

    public void c() {
        if (TextUtils.isEmpty(k.d(this.f334b))) {
            k.a(this.f334b, w.b());
        }
        try {
            if (!e()) {
                Logger.i("SdkSettingsHelper", "setting \u7f13\u5b58\u672a\u8fc7\u671f\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            } else if (this.f337e.get()) {
                Logger.i("SdkSettingsHelper", "setting \u6b63\u5728\u52a0\u8f7d\uff0c\u65e0\u9700\u518d\u6b21\u53d1\u8d77\u8bf7\u6c42...");
            } else {
                this.f335c.execute(this);
            }
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public b d() {
        this.f336d.set(0);
        return this;
    }

    @Override // com.bytedance.msdk.adapter.util.WeakHandler.IHandler
    public void handleMsg(Message message) {
        int i4 = message.what;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            g.b();
            return;
        }
        this.f336d.set(0);
        try {
            if (this.f338f.get()) {
                return;
            }
            c();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        for (char c4 = 'I'; c4 != 'H' && c4 != 'J'; c4 = 'H') {
        }
        if (!n.a(this.f334b)) {
            try {
                this.f333a.a();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean p3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().p();
        if (!p3) {
            this.f339g.sendEmptyMessageDelayed(2, 3000L);
        }
        this.f337e.set(true);
        f331h.set(SystemClock.currentThreadTimeMillis());
        a(p3);
    }
}
