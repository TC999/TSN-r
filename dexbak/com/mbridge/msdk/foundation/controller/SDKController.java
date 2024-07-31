package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.C7073a;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.entity.AtfEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.SettingCampaignDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.VolleyManager;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.same.report.p488b.CrashHandlerUtil;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDCardTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.out.AdMobClickListener;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.p455b.PreloadController;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.SettingRequestController;
import com.mbridge.msdk.p462d.ShortCutsManager;
import com.mbridge.msdk.p465e.TimerController;
import com.mbridge.msdk.rover.RoverController;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.mbridge.msdk.foundation.controller.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SDKController {

    /* renamed from: j */
    private static SDKController f30287j;

    /* renamed from: k */
    private Context f30297k;

    /* renamed from: l */
    private String f30298l;

    /* renamed from: m */
    private String f30299m;

    /* renamed from: n */
    private String f30300n;

    /* renamed from: o */
    private String f30301o;

    /* renamed from: p */
    private String f30302p;

    /* renamed from: r */
    private PreloadController f30304r;

    /* renamed from: s */
    private String f30305s;

    /* renamed from: u */
    private FastKV f30307u;

    /* renamed from: v */
    private Map<String, Object> f30308v;

    /* renamed from: w */
    private int f30309w;

    /* renamed from: x */
    private AdMobClickListener f30310x;

    /* renamed from: q */
    private boolean f30303q = false;

    /* renamed from: a */
    public final int f30288a = 1;

    /* renamed from: b */
    public final int f30289b = 2;

    /* renamed from: c */
    public final int f30290c = 3;

    /* renamed from: d */
    public final int f30291d = 4;

    /* renamed from: e */
    public final int f30292e = 5;

    /* renamed from: f */
    public final int f30293f = 6;

    /* renamed from: g */
    public final int f30294g = 7;

    /* renamed from: h */
    public final int f30295h = 8;

    /* renamed from: t */
    private AtomicBoolean f30306t = null;

    /* renamed from: i */
    Handler f30296i = new Handler() { // from class: com.mbridge.msdk.foundation.controller.b.4
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            List list;
            List<ReportData> list2;
            try {
                switch (message.what) {
                    case 2:
                        Object obj = message.obj;
                        if (!(obj instanceof List) || (list = (List) obj) == null || list.size() <= 0) {
                            return;
                        }
                        ReportController reportController = new ReportController(SDKController.this.f30297k, 0);
                        for (int i = 0; i < list.size(); i++) {
                            ReportData reportData = (ReportData) list.get(i);
                            Boolean bool = Boolean.FALSE;
                            if (i == list.size() - 1) {
                                bool = Boolean.TRUE;
                            }
                            reportController.m22100a(reportData, bool);
                        }
                        return;
                    case 3:
                        File file = (File) message.obj;
                        if (file != null) {
                            String m21756a = SameFileTool.m21756a(file);
                            if (TextUtils.isEmpty(m21756a)) {
                                return;
                            }
                            String[] split = m21756a.split("====");
                            if (split.length > 0) {
                                new ReportController(SDKController.this.f30297k).m22096a(split[0], file);
                                return;
                            }
                            return;
                        }
                        return;
                    case 4:
                        String str = (String) message.obj;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (MBBatchReportManager.m22142a().m22135c()) {
                            MBBatchReportManager.m22142a().m22139a(str);
                            return;
                        } else {
                            new ReportController(SDKController.this.f30297k, 0).m22095a("click_duration", str, (String) null, (Frame) null);
                            return;
                        }
                    case 5:
                        String str2 = (String) message.obj;
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        if (MBBatchReportManager.m22142a().m22135c()) {
                            MBBatchReportManager.m22142a().m22139a(str2);
                            return;
                        } else {
                            new ReportController(SDKController.this.f30297k, 0).m22095a("load_duration", str2, (String) null, (Frame) null);
                            return;
                        }
                    case 6:
                        Object obj2 = message.obj;
                        if (obj2 == null || !(obj2 instanceof String)) {
                            return;
                        }
                        String str3 = (String) obj2;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (MBBatchReportManager.m22142a().m22135c()) {
                            MBBatchReportManager.m22142a().m22139a(str3);
                            return;
                        } else {
                            new ReportController(SDKController.this.f30297k, 0).m22095a("device_data", str3, (String) null, (Frame) null);
                            return;
                        }
                    case 7:
                        Object obj3 = message.obj;
                        if (obj3 == null || !(obj3 instanceof List) || (list2 = (List) obj3) == null || list2.size() <= 0 || !SDKAuthorityController.m22842a().m22840a("authority_applist")) {
                            return;
                        }
                        C11400ae.m21963a(SDKController.this.f30297k, "mbridge_setting_campaign_time", new Long(System.currentTimeMillis()));
                        for (ReportData reportData2 : list2) {
                            new ReportController(SDKController.this.f30297k, 0).m22101a(reportData2);
                        }
                        return;
                    case 8:
                        Object obj4 = message.obj;
                        if (obj4 == null || !(obj4 instanceof String)) {
                            return;
                        }
                        String str4 = (String) obj4;
                        if (StringUtils.m21956b(str4)) {
                            if (MBBatchReportManager.m22142a().m22135c()) {
                                MBBatchReportManager.m22142a().m22139a(str4);
                                return;
                            } else {
                                new ReportController(SDKController.this.f30297k, 0).m22098a(str4);
                                return;
                            }
                        }
                        return;
                    case 9:
                        if (((Setting) message.obj).m23432K() == 1) {
                            CrashHandlerUtil.m22127a(SDKController.this.f30297k).m22128a();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception unused) {
                SameLogTool.m21733d("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    private SDKController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m22816e() {
        try {
            TimerController.class.getDeclaredMethod(CampaignEx.JSON_NATIVE_VIDEO_START, new Class[0]).invoke(TimerController.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            SameLogTool.m21735b("SDKController", th.getMessage(), th);
        }
    }

    /* renamed from: d */
    public final boolean m22818d() {
        Context context = this.f30297k;
        if (context != null && this.f30306t == null) {
            int i = context.getSharedPreferences("mb_optimization_setting", 0).getInt("use_thread_pool", 0);
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            this.f30306t = atomicBoolean;
            atomicBoolean.set(i == 0);
        }
        AtomicBoolean atomicBoolean2 = this.f30306t;
        if (atomicBoolean2 != null) {
            return atomicBoolean2.get();
        }
        return true;
    }

    /* renamed from: a */
    public static SDKController m22827a() {
        if (f30287j == null) {
            synchronized (SDKController.class) {
                if (f30287j == null) {
                    f30287j = new SDKController();
                }
            }
        }
        return f30287j;
    }

    /* renamed from: b */
    public final void m22822b() {
        Handler handler = this.f30296i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: c */
    public final void m22820c() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.5
            /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:10:0x002c, B:12:0x0032, B:13:0x0046, B:15:0x005c, B:16:0x0074, B:18:0x007e, B:20:0x0084, B:22:0x008a, B:23:0x0093, B:25:0x0099, B:28:0x00b7, B:30:0x01ca, B:32:0x01d1, B:33:0x01d6, B:29:0x0159, B:34:0x01f5, B:35:0x01f9, B:36:0x0208, B:38:0x021b, B:40:0x0221, B:42:0x0228, B:44:0x0230, B:5:0x000e, B:7:0x001c), top: B:48:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:10:0x002c, B:12:0x0032, B:13:0x0046, B:15:0x005c, B:16:0x0074, B:18:0x007e, B:20:0x0084, B:22:0x008a, B:23:0x0093, B:25:0x0099, B:28:0x00b7, B:30:0x01ca, B:32:0x01d1, B:33:0x01d6, B:29:0x0159, B:34:0x01f5, B:35:0x01f9, B:36:0x0208, B:38:0x021b, B:40:0x0221, B:42:0x0228, B:44:0x0230, B:5:0x000e, B:7:0x001c), top: B:48:0x0000 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 612
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.SDKController.RunnableC112715.run():void");
            }
        }).start();
    }

    /* renamed from: d */
    static /* synthetic */ void m22817d(SDKController sDKController) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Setting m23252b = SettingManager.m23261a().m23252b(sDKController.f30300n);
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            long longValue = ((Long) C11400ae.m21961b(sDKController.f30297k, "mbridge_setting_campaign_time", new Long(0L))).longValue();
            if (longValue <= 0 || longValue + (m23252b.m23426N() * 1000) <= currentTimeMillis) {
                if (m23252b.m23428M() <= 0) {
                    SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22671b();
                    return;
                }
                List<ReportData> m22669c = SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(sDKController.f30297k)).m22669c();
                if (m22669c == null || m22669c.size() <= 0) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.obj = m22669c;
                obtain.what = 7;
                sDKController.f30296i.sendMessage(obtain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m22823a(Map map, final Context context) {
        String str;
        List<AtfEntity> m23297n;
        Object newInstance;
        Object newInstance2;
        String str2 = "";
        if (context != null) {
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                this.f30300n = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
            }
            this.f30297k = StubApp.getOrigApplicationContext(context.getApplicationContext());
            MBSDKContext.m22865f().m22875b(this.f30297k);
            try {
                String str3 = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                if (!TextUtils.isEmpty(str3)) {
                    SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.SDK_APP_ID, str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                VolleyManager.m22159a(this.f30297k);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT < 26) {
                ShortCutsManager.m22996a(context).m22998a(30000, this.f30300n);
            }
            if (this.f30303q) {
                RoverController m21326a = RoverController.m21326a();
                m21326a.m21325a(context);
                m21326a.m21323b();
                new ReportController(context).m22106a();
                return;
            }
            SameDiTool.m21806C(context);
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                this.f30300n = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                this.f30301o = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                this.f30302p = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
            }
            if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                this.f30305s = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                this.f30299m = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
            }
            try {
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b != null && (m23297n = m23252b.m23297n()) != null && m23297n.size() > 0) {
                    for (AtfEntity atfEntity : m23297n) {
                        if (atfEntity.m22624a() == 287) {
                            Class<?> cls = Class.forName("com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler");
                            if (this.f30297k != null && (newInstance = cls.getConstructor(String.class, String.class).newInstance("", atfEntity.m22623b())) != null) {
                                cls.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance, new Object[0]);
                            }
                        } else if (atfEntity.m22624a() == 94 && (newInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", atfEntity.m22623b())) != null) {
                            MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance2, new Object[0]);
                        }
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
            MBSDKContext.m22865f().m22870c(this.f30300n);
            MBSDKContext.m22865f().m22868d(this.f30301o);
            MBSDKContext.m22865f().m22866e(this.f30302p);
            MBSDKContext.m22865f().m22873b(this.f30298l);
            MBSDKContext.m22865f().m22881a(this.f30305s);
            MBSDKContext.m22865f().m22884a(new MBSDKContext.InterfaceC11266b() { // from class: com.mbridge.msdk.foundation.controller.b.6
                @Override // com.mbridge.msdk.foundation.controller.MBSDKContext.InterfaceC11266b
                /* renamed from: a */
                public final void mo22815a() {
                    SDKController.m22817d(SDKController.this);
                }
            }, this.f30296i);
            Context origApplicationContext = StubApp.getOrigApplicationContext(this.f30297k.getApplicationContext());
            try {
                C7073a.m34842a(origApplicationContext);
                if (!C7073a.m34840c()) {
                    new ReportController(origApplicationContext, 0).m22093a("", "", "", "", "activate om failed");
                }
            } catch (IllegalArgumentException e2) {
                SameLogTool.m21735b("SDKController", e2.getMessage(), e2);
            }
            SameLogTool.m21736b("SDKController", "facebook = " + this.f30298l + "appId = " + this.f30300n + "appKey = " + this.f30301o);
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(this.f30297k.getApplicationContext());
            try {
                if (m22818d() && this.f30307u == null) {
                    try {
                        this.f30307u = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), SameBase64Tool.m21812b("H+tU+FeXHM==")).build();
                    } catch (Exception unused2) {
                        this.f30307u = null;
                    }
                }
                FastKV fastKV = this.f30307u;
                if (fastKV != null) {
                    String string = fastKV.getString(SameBase64Tool.m21812b("H+tU+bfPhM=="), "");
                    String string2 = this.f30307u.getString(SameBase64Tool.m21812b("H+tU+Fz8"), "");
                    if (TextUtils.isEmpty(CommonConst.f30596s) && TextUtils.isEmpty(CommonConst.f30597t)) {
                        CommonConst.f30596s = SharedPerferenceManager.m22949a().m22944b("b");
                        CommonConst.f30597t = SharedPerferenceManager.m22949a().m22944b("c");
                    }
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        if (!TextUtils.isEmpty(CommonConst.f30596s) || !TextUtils.isEmpty(CommonConst.f30597t)) {
                            this.f30307u.putString(SameBase64Tool.m21812b("H+tU+bfPhM=="), CommonConst.f30596s);
                            this.f30307u.putString(SameBase64Tool.m21812b("H+tU+Fz8"), CommonConst.f30597t);
                        }
                    } else {
                        CommonConst.f30596s = string;
                        CommonConst.f30597t = string2;
                        SharedPerferenceManager.m22949a().m22945a("b", CommonConst.f30596s);
                        SharedPerferenceManager.m22949a().m22945a("c", CommonConst.f30597t);
                    }
                } else {
                    SharedPreferences sharedPreferences = origApplicationContext2.getSharedPreferences(SameBase64Tool.m21812b("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        str2 = sharedPreferences.getString(SameBase64Tool.m21812b("H+tU+bfPhM=="), "");
                        str = sharedPreferences.getString(SameBase64Tool.m21812b("H+tU+Fz8"), "");
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(CommonConst.f30596s) && TextUtils.isEmpty(CommonConst.f30597t)) {
                        CommonConst.f30596s = SharedPerferenceManager.m22949a().m22944b("b");
                        CommonConst.f30597t = SharedPerferenceManager.m22949a().m22944b("c");
                    }
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                        if ((!TextUtils.isEmpty(CommonConst.f30596s) || !TextUtils.isEmpty(CommonConst.f30597t)) && sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(SameBase64Tool.m21812b("H+tU+bfPhM=="), CommonConst.f30596s);
                            edit.putString(SameBase64Tool.m21812b("H+tU+Fz8"), CommonConst.f30597t);
                            edit.apply();
                        }
                    } else {
                        CommonConst.f30596s = str2;
                        CommonConst.f30597t = str;
                        SharedPerferenceManager.m22949a().m22945a("b", CommonConst.f30596s);
                        SharedPerferenceManager.m22949a().m22945a("c", CommonConst.f30597t);
                    }
                }
            } catch (Throwable th3) {
                SameLogTool.m21735b("SDKController", th3.getMessage(), th3);
            }
            try {
                if (MBridgeConstans.INIT_UA_IN) {
                    ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Looper.prepare();
                            SDKController.this.m22816e();
                            SDKController sDKController = SDKController.this;
                            SDKController.m22825a(sDKController, sDKController.f30300n);
                            Looper.loop();
                        }
                    });
                } else if (Looper.myLooper() == Looper.getMainLooper()) {
                    ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            Looper.prepare();
                            SDKController.this.m22816e();
                            Looper.loop();
                        }
                    });
                } else {
                    m22816e();
                }
            } catch (Exception unused3) {
                SameLogTool.m21733d("SDKController", "get app setting failed");
            }
            m22820c();
            SameSDCardTool.m22041a(this.f30297k);
            this.f30303q = true;
            RoverController m21326a2 = RoverController.m21326a();
            m21326a2.m21325a(context);
            m21326a2.m21323b();
            long m23403a = SettingManager.m23261a().m23241g(this.f30300n).m23403a();
            if (m23403a != 1300) {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SameDiTool.m21808B(context);
                    }
                }, m23403a);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bd -> B:40:0x00c0). Please submit an issue!!! */
    /* renamed from: a */
    public final void m22824a(Map<String, Object> map, int i) {
        Map<String, Object> map2;
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            SameLogTool.m21733d("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f30308v = map;
        this.f30309w = i;
        MBSDKContext.m22865f().m22860k();
        if (map != null) {
            if (this.f30304r == null) {
                this.f30304r = new PreloadController();
            }
            try {
                map2 = this.f30308v;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (map2 != null && map2.size() > 0 && this.f30308v.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                int intValue = ((Integer) this.f30308v.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                if (intValue == 0) {
                    Map<String, Object> map3 = this.f30308v;
                    int i2 = this.f30309w;
                    AdMobClickListener adMobClickListener = this.f30310x;
                    try {
                        Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.e.a");
                        cls.getMethod("preload", Map.class, Integer.TYPE, AdMobClickListener.class).invoke(cls.newInstance(), map3, Integer.valueOf(i2), adMobClickListener);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (3 == intValue) {
                    Map<String, Object> map4 = this.f30308v;
                    try {
                        Class<?> cls2 = Class.forName("com.mbridge.msdk.appwall.service.HandlerProvider");
                        cls2.getMethod("preload", Map.class).invoke(cls2.newInstance(), map4);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } else if (1 != intValue && 2 != intValue) {
                    SameLogTool.m21733d("SDKController", "unknow layout type in preload");
                }
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22825a(SDKController sDKController, String str) {
        if (SettingManager.m23261a() == null) {
            return;
        }
        SettingManager m23261a = SettingManager.m23261a();
        if (m23261a != null) {
            Setting m23252b = m23261a.m23252b(str);
            if (m23252b != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = m23252b.m23385aM();
                MBridgeConstans.OMID_JS_H5_URL = m23252b.m23386aL();
                if (!TextUtils.isEmpty(m23252b.m23360al())) {
                    RequestUrlUtil.m22248a().f30793c = m23252b.m23360al();
                    RequestUrlUtil.m22248a().m22240e();
                }
                if (!TextUtils.isEmpty(m23252b.m23359am())) {
                    RequestUrlUtil.m22248a().f30794d = m23252b.m23359am();
                    RequestUrlUtil.m22248a().m22239f();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = "https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js";
                MBridgeConstans.OMID_JS_H5_URL = "https://mtg-native.rayjump.com/omsdk/omsdkjs_common_js.txt";
            }
        }
        if (SettingManager.m23261a().m23258a(str) && SettingManager.m23261a().m23257a(str, 1, (String) null)) {
            new SettingRequestController().m23216a(sDKController.f30297k, str, sDKController.f30301o);
        } else {
            new ReportController(sDKController.f30297k).m22106a();
        }
    }
}
