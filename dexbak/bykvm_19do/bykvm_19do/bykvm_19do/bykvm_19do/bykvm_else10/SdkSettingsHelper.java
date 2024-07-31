package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.URLConst;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTNetClient;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdLocation;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdLocationUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdvertisingIdHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.MD5;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.OAIDHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SimUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTPangleUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ToolUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetResponse;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.NetExecutor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PostExecutor;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.WeakHandler;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.msdk.base.Sdk;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SdkSettingsHelper implements Runnable, WeakHandler.IHandler {

    /* renamed from: h */
    private static final AtomicLong f334h = new AtomicLong(0);
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i */
    private static volatile SdkSettingsHelper f335i;

    /* renamed from: a */
    private final ISettings f336a;

    /* renamed from: b */
    private final Context f337b;

    /* renamed from: c */
    private final ExecutorService f338c = Executors.newFixedThreadPool(2);

    /* renamed from: d */
    private final AtomicInteger f339d = new AtomicInteger(0);

    /* renamed from: e */
    private final AtomicBoolean f340e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicBoolean f341f = new AtomicBoolean(false);

    /* renamed from: g */
    private final WeakHandler f342g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SdkSettingsHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0955a extends NetCallback {

        /* renamed from: a */
        final /* synthetic */ int[] f343a;

        /* renamed from: b */
        final /* synthetic */ boolean f344b;

        /* renamed from: c */
        final /* synthetic */ int[] f345c;

        /* renamed from: d */
        final /* synthetic */ long f346d;

        /* compiled from: SdkSettingsHelper.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class RunnableC0956a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ NetResponse f348a;

            RunnableC0956a(NetResponse netResponse) {
                this.f348a = netResponse;
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
                throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper.C0955a.RunnableC0956a.run():void");
            }
        }

        C0955a(int[] iArr, boolean z, int[] iArr2, long j) {
            this.f343a = iArr;
            this.f344b = z;
            this.f345c = iArr2;
            this.f346d = j;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59049a(NetExecutor netExecutor, NetResponse netResponse) {
            ThreadHelper.runOnMSDKThread(new RunnableC0956a(netResponse));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback
        /* renamed from: a */
        public void mo59048a(NetExecutor netExecutor, IOException iOException) {
            Logger.m37557e("SdkSettingsHelper", "setting request failed..." + iOException.getMessage());
            try {
                SdkSettingsHelper.this.m59771j();
                Logger.m37557e("SdkSettingsHelper", "request failed...>>>>> retryLoadSettingData");
            } catch (Throwable unused) {
            }
            SdkSettingsHelper.this.f340e.set(false);
            int[] iArr = this.f345c;
            iArr[0] = 0;
            int[] iArr2 = this.f343a;
            iArr2[0] = -2;
            if (this.f344b) {
                return;
            }
            AdEventUtil.m59331a(iArr[0], iArr2[0], System.currentTimeMillis() - this.f346d);
        }
    }

    private SdkSettingsHelper(ISettings iSettings) {
        this.f336a = iSettings == null ? InternalContainer.m59943f() : iSettings;
        this.f337b = InternalContainer.m59945d();
        this.f342g = new WeakHandler(Looper.getMainLooper(), this);
    }

    /* renamed from: a */
    public static SdkSettingsHelper m59791a(ISettings iSettings) {
        if (f335i == null) {
            synchronized (SdkSettingsHelper.class) {
                try {
                    if (f335i == null) {
                        f335i = new SdkSettingsHelper(iSettings);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f335i;
    }

    /* renamed from: a */
    private String m59786a(JSONObject jSONObject) {
        JSONObject m59257a = ToolUtils.m59257a(jSONObject);
        if (m59257a != null) {
            return m59257a.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m59787a(Map<String, String> map) {
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

    /* renamed from: a */
    private void m59785a(boolean z) {
        int[] iArr = {0};
        int[] iArr2 = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        PostExecutor m59082b = TTNetClient.m59292b().m59293a().m59082b();
        m59082b.m58997b(URLConst.m59444f());
        String m59898o = SdkGlobalInfo.m59939B().m59898o();
        if (!TextUtils.isEmpty(m59898o)) {
            m59082b.m58998a("X-Tt-Env", m59898o);
            m59082b.m58998a("x-use-ppe", "1");
        }
        m59082b.m58998a("User-Agent", Sdk.f21749b);
        m59082b.m58993c(m59786a(m59772i()));
        m59082b.m58996a(new C0955a(iArr2, z, iArr, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59782b(JSONObject jSONObject) {
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

    /* renamed from: e */
    private boolean m59777e() {
        long m59132a = SPUtils.m59131a("tt_sdk_settings", this.f337b).m59132a("max_expire_time", 0L);
        if (this.f341f.get() && System.currentTimeMillis() > m59132a) {
            Logger.m37554i("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.f341f.set(false);
            m59779d();
        }
        return System.currentTimeMillis() > m59132a;
    }

    /* renamed from: f */
    private static List<String> m59775f() {
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

    /* renamed from: g */
    private JSONObject m59774g() {
        JSONObject jSONObject = new JSONObject();
        Map<String, ITTAdapterConfiguration> m59273c = InitHelper.m59273c();
        List<String> m59775f = m59775f();
        if (m59273c != null && m59775f != null) {
            for (String str : m59775f) {
                ITTAdapterConfiguration iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                if (iTTAdapterConfiguration != null) {
                    try {
                        jSONObject.put(str, iTTAdapterConfiguration.getNetworkSdkVersion());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: h */
    private JSONObject m59773h() {
        Map<String, String> customInfos;
        JSONObject jSONObject = new JSONObject();
        UserInfoForSegment m59894s = SdkGlobalInfo.m59939B().m59894s();
        if (m59894s == null || (customInfos = m59894s.getCustomInfos()) == null) {
            return null;
        }
        try {
            for (String str : customInfos.keySet()) {
                jSONObject.put(str, customInfos.get(str));
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: i */
    private JSONObject m59772i() {
        AdLocation m59243b;
        for (char c = '\b'; c != 7 && (c == '\b' || c != '\t'); c = '\t') {
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("media_sdk_version", "2.9.2.1");
            jSONObject.put("app_id", SdkGlobalInfo.m59939B().m59921c());
            jSONObject.put("package_name", ToolUtils.m59259a());
            jSONObject.put("app_version", ToolUtils.m59252e());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, IdUtils.m59201a(this.f337b));
            jSONObject2.put("imei", IdUtils.m59190e(this.f337b));
            jSONObject2.put("imei_md5", MD5.m59172a(IdUtils.m59190e(this.f337b)));
            jSONObject2.put("oaid", OAIDHelper.m59164a());
            jSONObject2.put("gaid", AdvertisingIdHelper.m59229c().m59235a());
            jSONObject2.put("applog_did", IdUtils.m59191d(this.f337b));
            jSONObject2.put("publisher_did", SdkGlobalInfo.m59939B().m59896q());
            jSONObject2.put("conn_type", NetworkUtils.m59169b(this.f337b));
            jSONObject2.put("os", 1);
            jSONObject2.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject2.put("vendor", Build.MANUFACTURER);
            String str = Build.MODEL;
            jSONObject2.put("device_model", str);
            jSONObject2.put("mcc", SimUtils.m59116b());
            jSONObject2.put("mnc", SimUtils.m59115c());
            jSONObject2.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
            jSONObject2.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, DeviceUtils.m59223a());
            jSONObject2.put("locale_language", DeviceUtils.m59218b());
            jSONObject2.put("total_space", "" + DeviceUtils.m59209g());
            jSONObject2.put("carrier_name", SimUtils.m59117a());
            jSONObject2.put(UMCommonContent.f37753J, Settings.Global.getString(this.f337b.getContentResolver(), UMCommonContent.f37753J));
            jSONObject2.put("pb", "");
            Object[] objArr = new Object[1];
            double currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            Double.isNaN(currentTimeMillis);
            double d = currentTimeMillis / 1000.0d;
            Formatter formatter = new Formatter();
            objArr[0] = Double.valueOf(d);
            Formatter format = formatter.format("%.6f", objArr);
            jSONObject2.put("boot", "" + format.toString());
            jSONObject2.put("device_city", "");
            jSONObject2.put("country_code", InternalContainer.m59943f().m59740g());
            jSONObject2.put("total_mem", "" + DeviceUtils.m59210f());
            jSONObject2.put(UMCommonContent.f37805ai, str);
            jSONObject2.put("language", Locale.getDefault().getLanguage());
            jSONObject.put(ConstantHelper.LOG_DE, jSONObject2);
            jSONObject.put("grouping_params", m59784b());
            JSONObject m59773h = m59773h();
            if (m59773h != null) {
                jSONObject.put("user_defined_grouping_params", m59773h);
            }
            if (!SdkGlobalInfo.m59939B().m59891v()) {
                jSONObject.put(DownloadModel.ETAG, InternalContainer.m59943f().m59739h());
            }
            if (AdLocationUtils.m59243b(this.f337b) != null) {
                jSONObject.put("latitude", m59243b.f638a);
                jSONObject.put("longitude", m59243b.f639b);
            }
            jSONObject.put("adn_version_list", m59774g());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m59771j() throws Throwable {
        SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d()).m59118f("server_dist_host");
        this.f340e.set(false);
        if (this.f341f.get()) {
            this.f342g.removeMessages(1);
        } else if (this.f339d.get() < 3) {
            this.f339d.incrementAndGet();
            m59781c();
        } else {
            this.f342g.removeMessages(1);
            this.f342g.sendEmptyMessageDelayed(1, TTAdConstant.AD_MAX_EVENT_TIME);
            Logger.m37554i("SdkSettingsHelper", "setting 重试次数超过3次就间隔时间:600000毫秒后再执行....");
        }
    }

    /* renamed from: a */
    public void m59792a() {
        try {
            if (this.f340e.get()) {
                Logger.m37554i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                this.f338c.execute(this);
            }
        } catch (Throwable th) {
            Logger.m37561d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /* renamed from: b */
    public JSONObject m59784b() {
        String userId;
        JSONObject jSONObject = new JSONObject();
        UserInfoForSegment m59894s = SdkGlobalInfo.m59939B().m59894s();
        if (m59894s != null) {
            try {
                userId = m59894s.getUserId();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            userId = "";
        }
        jSONObject.put(SocializeConstants.TENCENT_UID, userId);
        jSONObject.put("channel", m59894s != null ? m59894s.getChannel() : "");
        jSONObject.put("sub_channel", m59894s != null ? m59894s.getSubChannel() : "");
        jSONObject.put("age", m59894s != null ? m59894s.getAge() : 0);
        jSONObject.put("gender", m59894s != null ? m59894s.getGender() : "");
        jSONObject.put("user_value_group", m59894s != null ? m59894s.getUserValueGroup() : "");
        jSONObject.put("init_time", SdkGlobalInfo.m59939B().m59910f());
        jSONObject.put("android_os_version_int", Build.VERSION.SDK_INT);
        return jSONObject;
    }

    /* renamed from: c */
    public void m59781c() {
        if (TextUtils.isEmpty(IdUtils.m59191d(this.f337b))) {
            IdUtils.m59200a(this.f337b, TTPangleUtil.m59104b());
        }
        try {
            if (!m59777e()) {
                Logger.m37554i("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.f340e.get()) {
                Logger.m37554i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                this.f338c.execute(this);
            }
        } catch (Throwable th) {
            Logger.m37561d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /* renamed from: d */
    public SdkSettingsHelper m59779d() {
        this.f339d.set(0);
        return this;
    }

    @Override // com.bytedance.msdk.adapter.util.WeakHandler.IHandler
    public void handleMsg(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            AdEventUtil.m59306b();
            return;
        }
        this.f339d.set(0);
        try {
            if (this.f341f.get()) {
                return;
            }
            m59781c();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        for (char c = 'I'; c != 'H' && c != 'J'; c = 'H') {
        }
        if (!NetworkUtils.m59170a(this.f337b)) {
            try {
                this.f336a.mo59767a();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean m59731p = InternalContainer.m59943f().m59731p();
        if (!m59731p) {
            this.f342g.sendEmptyMessageDelayed(2, 3000L);
        }
        this.f340e.set(true);
        f334h.set(SystemClock.currentThreadTimeMillis());
        m59785a(m59731p);
    }
}
