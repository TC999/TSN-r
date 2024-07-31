package com.mbridge.msdk.p457c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.SettingCampaignDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.p458a.SettingConst;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SettingManager {

    /* renamed from: a */
    public static final String f29871a = "b";

    /* renamed from: b */
    private static SettingManager f29872b;

    /* renamed from: c */
    private static HashMap<String, UnitSetting> f29873c = new HashMap<>();

    /* renamed from: d */
    private static volatile Setting f29874d = null;

    private SettingManager() {
    }

    /* renamed from: a */
    public static SettingManager m23261a() {
        if (f29872b == null) {
            synchronized (SettingManager.class) {
                if (f29872b == null) {
                    f29872b = new SettingManager();
                }
            }
        }
        return f29872b;
    }

    /* renamed from: h */
    private UnitSetting m23239h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = MBSDKContext.m22865f().m22860k();
        }
        String str3 = str + "_" + str2;
        UnitSetting unitSetting = null;
        if (f29873c.containsKey(str3)) {
            return f29873c.get(str3);
        }
        try {
            unitSetting = UnitSetting.m23201b(SharedPerferenceManager.m22949a().m22944b(str3));
            f29873c.put(str3, unitSetting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unitSetting;
    }

    /* renamed from: b */
    public final void m23251b(String str, String str2) {
        SharedPerferenceManager.m22949a().m22945a(str, str2);
        f29874d = Setting.m23319f(str2);
        if (f29874d != null) {
            f29874d.m23349aw();
        }
        Setting setting = f29874d;
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            PackageManager packageManager = m22861j != null ? m22861j.getPackageManager() : null;
            if (setting == null || packageManager == null) {
                return;
            }
            if (setting.m23428M() > 0) {
                List<CampaignEx> m23424O = setting.m23424O();
                if (m23424O == null || m23424O.size() <= 0 || setting.m23422P() != 1) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < m23424O.size(); i++) {
                    CampaignEx campaignEx = m23424O.get(i);
                    String packageName = campaignEx.getPackageName();
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                        String installerPackageName = packageManager.getInstallerPackageName(packageName);
                        campaignEx.setPackageName("");
                        campaignEx.setIex(1);
                        campaignEx.setTs(packageInfo.lastUpdateTime);
                        campaignEx.setLabel(UMCommonContent.f37801ae);
                        campaignEx.setPkgSource(installerPackageName);
                        campaignEx.setcVersionCode(packageInfo.versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                        campaignEx.setPackageName("");
                        campaignEx.setIex(1);
                        campaignEx.setTs(0L);
                        campaignEx.setLabel("ni");
                        campaignEx.setPkgSource("");
                    }
                    arrayList.add(campaignEx);
                }
                m23254a(arrayList, 1);
                return;
            }
            SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22671b();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public final String m23249c(String str) {
        if (str == null) {
            return "";
        }
        try {
            String m22944b = SharedPerferenceManager.m22949a().m22944b(str);
            return m22944b == null ? "" : m22944b;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    /* renamed from: d */
    public final void m23247d(final String str) {
        m23248c(MBSDKContext.m22865f().m22860k(), str);
        final String str2 = UnitSetting.f29913a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            C11385e.m22074a(m22861j, str2, str, 2, "alert url is exception ,url:" + str2);
            return;
        }
        H5DownLoadManager.getInstance().downloadH5Res(str2, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.c.b.1
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str3, String str4) {
                C11385e.m22074a(MBSDKContext.m22865f().m22861j(), str2, str, 2, str4);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str3) {
                C11385e.m22074a(MBSDKContext.m22865f().m22861j(), str2, str, 1, "");
            }
        });
    }

    /* renamed from: e */
    public final UnitSetting m23244e(String str, String str2) {
        UnitSetting m23239h = m23239h(str, str2);
        if (m23239h != null && m23239h.m23187j() == 0) {
            m23239h.m23199c(1);
        }
        return m23239h;
    }

    /* renamed from: f */
    public final UnitSetting m23242f(String str, String str2) {
        return m23239h(str, str2);
    }

    /* renamed from: g */
    public final void m23240g(String str, String str2) {
        try {
            SharedPerferenceManager m22949a = SharedPerferenceManager.m22949a();
            String m22944b = m22949a.m22944b(str + "_" + str2);
            if (TextUtils.isEmpty(m22944b)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(m22944b);
            jSONObject.put("current_time", System.currentTimeMillis());
            m23255a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            SameLogTool.m21733d(f29871a, th.getMessage());
        }
    }

    /* renamed from: f */
    public final void m23243f(String str) {
        SharedPerferenceManager m22949a = SharedPerferenceManager.m22949a();
        m22949a.m22942c("ivreward_" + str);
    }

    /* renamed from: c */
    public final UnitSetting m23248c(String str, String str2) {
        UnitSetting m23244e = m23244e(str, str2);
        return m23244e == null ? UnitSetting.m23185l() : m23244e;
    }

    /* renamed from: e */
    public final String m23245e(String str) {
        SharedPerferenceManager m22949a = SharedPerferenceManager.m22949a();
        return m22949a.m22944b("ivreward_" + str);
    }

    /* renamed from: a */
    public final boolean m23258a(String str) {
        Setting m23252b = m23252b(str);
        if (m23252b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long m23358an = m23252b.m23358an() + (m23252b.m23362aj() * 1000);
            if (m23358an > currentTimeMillis) {
                String str2 = f29871a;
                SameLogTool.m21736b(str2, "app setting nexttime is not ready  [settingNextRequestTime= " + m23358an + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        SameLogTool.m21736b(f29871a, "app setting timeout or not exists");
        return true;
    }

    /* renamed from: g */
    public final Setting m23241g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return m23253b();
            }
            Setting m23252b = m23252b(str);
            return m23252b == null ? m23253b() : m23252b;
        } catch (Exception unused) {
            return m23253b();
        }
    }

    /* renamed from: d */
    public final UnitSetting m23246d(String str, String str2) {
        UnitSetting m23239h = m23239h(str, str2);
        return m23239h == null ? UnitSetting.m23185l() : m23239h;
    }

    /* renamed from: a */
    public final boolean m23257a(String str, int i, String str2) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            String str3 = str + "_" + i + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            long longValue = ((Long) C11400ae.m21961b(m22861j, str3, 0L)).longValue();
            Setting m23252b = m23252b(str);
            if (m23252b == null) {
                m23252b = m23261a().m23253b();
            } else {
                j = longValue;
            }
            if (j + (m23252b.m23405Y() * 1000) > currentTimeMillis) {
                return false;
            }
            C11400ae.m21963a(m22861j, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m23256a(String str, String str2) {
        Setting m23252b = m23252b(str2);
        if (m23258a(str2) && m23257a(str2, 1, str)) {
            new SettingRequestController().m23216a(MBSDKContext.m22865f().m22861j(), str2, MBSDKContext.m22865f().m22859l());
        }
        UnitSetting m23244e = m23244e(str2, str);
        if (m23252b != null && m23244e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long m23176u = m23244e.m23176u() + (m23252b.m23367ae() * 1000);
            if (m23176u > currentTimeMillis) {
                String str3 = f29871a;
                SameLogTool.m21736b(str3, "unit setting  nexttime is not ready  [settingNextRequestTime= " + m23176u + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        SameLogTool.m21736b(f29871a, "unit setting timeout or not exists");
        return true;
    }

    /* renamed from: a */
    private ReportData m23254a(List<CampaignEx> list, int i) {
        ReportData reportData = new ReportData();
        try {
            reportData.m22464d(m23250b(list, i));
            reportData.m22470a(i + "");
            if (SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22675a() > 500) {
                SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22670b("0");
            }
            SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22673a(reportData);
        } catch (Exception unused) {
        }
        return reportData;
    }

    /* renamed from: b */
    private String m23250b(List<CampaignEx> list, int i) {
        String str = "key=2000079&iex=" + i + "&cal=";
        try {
            JSONArray jSONArray = new JSONArray();
            for (CampaignEx campaignEx : list) {
                jSONArray.put(m23259a(campaignEx));
            }
            return str + SameBase64Tool.m21813a(jSONArray.toString());
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
                return str;
            }
            return str;
        }
    }

    /* renamed from: a */
    private JSONObject m23259a(CampaignEx campaignEx) {
        JSONObject jSONObject = null;
        if (campaignEx == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("campaignid", campaignEx.getId());
                jSONObject2.put("ts", campaignEx.getTs());
                jSONObject2.put(TTDownloadField.TT_LABEL, campaignEx.getLabel());
                jSONObject2.put("vc", campaignEx.getcVersionCode());
                String pkgSource = campaignEx.getPkgSource();
                if (pkgSource == null) {
                    pkgSource = "";
                }
                jSONObject2.put("pkg_source", pkgSource);
                return jSONObject2;
            } catch (Exception e) {
                e = e;
                jSONObject = jSONObject2;
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return jSONObject;
                }
                return jSONObject;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public final Setting m23252b(String str) {
        if (f29874d == null) {
            try {
                f29874d = Setting.m23319f(SharedPerferenceManager.m22949a().m22944b(str));
                if (f29874d != null) {
                    f29874d.m23349aw();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f29874d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m23260a(android.content.Context r5, java.lang.String r6) {
        /*
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.SDKController.m22827a()
            boolean r0 = r0.m22818d()
            java.lang.String r1 = "mbridge"
            r2 = 0
            if (r0 == 0) goto L1d
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch: java.lang.Exception -> L1d
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.p475b.MBridgeDir.MBRIDGE_700_CONFIG     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager.m22347b(r3)     // Catch: java.lang.Exception -> L1d
            r0.<init>(r3, r1)     // Catch: java.lang.Exception -> L1d
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch: java.lang.Exception -> L1d
            goto L1e
        L1d:
            r0 = r2
        L1e:
            java.lang.String r3 = "_"
            if (r0 == 0) goto L68
            java.util.Map r2 = r0.getAll()     // Catch: java.lang.Exception -> L27
            goto L28
        L27:
        L28:
            if (r2 == 0) goto Lae
            java.util.Set r5 = r2.keySet()     // Catch: java.lang.Exception -> L63
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L63
        L32:
            boolean r0 = r5.hasNext()     // Catch: java.lang.Exception -> L63
            if (r0 == 0) goto Lae
            java.lang.Object r0 = r5.next()     // Catch: java.lang.Exception -> L63
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L63
            r1.<init>()     // Catch: java.lang.Exception -> L63
            r1.append(r6)     // Catch: java.lang.Exception -> L63
            r1.append(r3)     // Catch: java.lang.Exception -> L63
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L63
            boolean r1 = r0.startsWith(r1)     // Catch: java.lang.Exception -> L63
            if (r1 == 0) goto L32
            java.util.HashMap<java.lang.String, com.mbridge.msdk.c.d> r1 = com.mbridge.msdk.p457c.SettingManager.f29873c     // Catch: java.lang.Exception -> L63
            java.lang.Object r4 = r2.get(r0)     // Catch: java.lang.Exception -> L63
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L63
            com.mbridge.msdk.c.d r4 = com.mbridge.msdk.p457c.UnitSetting.m23201b(r4)     // Catch: java.lang.Exception -> L63
            r1.put(r0, r4)     // Catch: java.lang.Exception -> L63
            goto L32
        L63:
            r5 = move-exception
            r5.printStackTrace()
            goto Lae
        L68:
            r0 = 0
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r1, r0)     // Catch: java.lang.Exception -> Laa
            java.util.Map r5 = r5.getAll()     // Catch: java.lang.Exception -> Laa
            java.util.Set r0 = r5.keySet()     // Catch: java.lang.Exception -> Laa
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Laa
        L79:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Laa
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Laa
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Laa
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laa
            r2.<init>()     // Catch: java.lang.Exception -> Laa
            r2.append(r6)     // Catch: java.lang.Exception -> Laa
            r2.append(r3)     // Catch: java.lang.Exception -> Laa
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Laa
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Exception -> Laa
            if (r2 == 0) goto L79
            java.util.HashMap<java.lang.String, com.mbridge.msdk.c.d> r2 = com.mbridge.msdk.p457c.SettingManager.f29873c     // Catch: java.lang.Exception -> Laa
            java.lang.Object r4 = r5.get(r1)     // Catch: java.lang.Exception -> Laa
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> Laa
            com.mbridge.msdk.c.d r4 = com.mbridge.msdk.p457c.UnitSetting.m23201b(r4)     // Catch: java.lang.Exception -> Laa
            r2.put(r1, r4)     // Catch: java.lang.Exception -> Laa
            goto L79
        Laa:
            r5 = move-exception
            r5.printStackTrace()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.p457c.SettingManager.m23260a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: b */
    public final Setting m23253b() {
        Setting setting = new Setting();
        setting.m23310h(86400L);
        setting.m23423O(1);
        setting.m23421P(1);
        setting.m23323e(true);
        setting.m23318f(true);
        setting.m23320f(3600L);
        setting.m23315g(0L);
        setting.m23328d(false);
        setting.m23333c(false);
        setting.m23343b(7200L);
        setting.m23330d(20L);
        setting.m23325e(10L);
        setting.m23435I(1);
        setting.m23433J(1);
        setting.m23324e("正在下载中，请去通知栏查看下载进度");
        setting.m23334c("mbridge");
        setting.m23282u(1);
        setting.m23335c(1800L);
        setting.m23437H(100);
        setting.m23439G(43200);
        setting.m23441F(1);
        setting.m23401a(604800L);
        setting.m23425N(1);
        setting.m23431K(3);
        setting.m23280v(1);
        setting.m23443E(1);
        setting.m23447C(1);
        setting.m23445D(86400);
        setting.m23429L(259200);
        setting.m23278w(1);
        setting.m23276x(900);
        setting.m23274y(20);
        setting.m23329d("pid");
        setting.m23272z(1);
        setting.m23451A(1);
        setting.m23449B(1);
        setting.m23427M(1);
        setting.m23292p(1);
        setting.m23294o(1);
        setting.m23290q(1);
        setting.m23288r(0);
        setting.m23286s(1);
        setting.m23284t(-1);
        setting.m23342b(SettingConst.f29870a);
        setting.m23296n(2);
        setting.m23298m(86400);
        setting.m23331d(0);
        setting.m23309h("https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js");
        setting.m23314g("https://mtg-native.rayjump.com/omsdk/omsdkjs_common_js.txt");
        setting.m23336c(120);
        setting.m23344b(10);
        setting.m23313g(false);
        setting.m23417R(0);
        setting.m23415S(120);
        setting.m23413T(1);
        setting.m23304j(CommonConst.f30571L);
        setting.m23307i(CommonConst.f30573N);
        setting.m23311h(CommonConst.f30572M);
        setting.m23402a(10);
        setting.m23302k(CommonConst.f30577R);
        setting.m23316g(10);
        setting.m23409V(0);
        setting.m23411U(0);
        setting.m23399a("");
        setting.m23407W(1);
        setting.m23321f(1);
        setting.m23326e(24);
        setting.m23398a(false);
        setting.m23419Q(1);
        setting.m23341b(true);
        return setting;
    }

    /* renamed from: a */
    public final void m23255a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        SharedPerferenceManager.m22949a().m22945a(str4, str3);
        f29873c.put(str4, UnitSetting.m23201b(str3));
    }
}
