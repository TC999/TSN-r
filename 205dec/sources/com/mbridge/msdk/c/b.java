package com.mbridge.msdk.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38715a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static b f38716b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, d> f38717c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f38718d = null;

    private b() {
    }

    public static b a() {
        if (f38716b == null) {
            synchronized (b.class) {
                if (f38716b == null) {
                    f38716b = new b();
                }
            }
        }
        return f38716b;
    }

    private d h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.a.f().k();
        }
        String str3 = str + "_" + str2;
        d dVar = null;
        if (f38717c.containsKey(str3)) {
            return f38717c.get(str3);
        }
        try {
            dVar = d.b(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
            f38717c.put(str3, dVar);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return dVar;
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(str, str2);
        f38718d = a.f(str2);
        if (f38718d != null) {
            f38718d.aw();
        }
        a aVar = f38718d;
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            PackageManager packageManager = j4 != null ? j4.getPackageManager() : null;
            if (aVar == null || packageManager == null) {
                return;
            }
            if (aVar.M() > 0) {
                List<CampaignEx> O = aVar.O();
                if (O == null || O.size() <= 0 || aVar.P() != 1) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < O.size(); i4++) {
                    CampaignEx campaignEx = O.get(i4);
                    String packageName = campaignEx.getPackageName();
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                        String installerPackageName = packageManager.getInstallerPackageName(packageName);
                        campaignEx.setPackageName("");
                        campaignEx.setIex(1);
                        campaignEx.setTs(packageInfo.lastUpdateTime);
                        campaignEx.setLabel("is");
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
                a(arrayList, 1);
                return;
            }
            q.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).b();
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public final String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            String b4 = com.mbridge.msdk.foundation.a.a.a.a().b(str);
            return b4 == null ? "" : b4;
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
            return "";
        }
    }

    public final void d(final String str) {
        c(com.mbridge.msdk.foundation.controller.a.f().k(), str);
        final String str2 = d.f38757a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            e.a(j4, str2, str, 2, "alert url is exception ,url:" + str2);
            return;
        }
        H5DownLoadManager.getInstance().downloadH5Res(str2, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.c.b.1
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str3, String str4) {
                e.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str, 2, str4);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str3) {
                e.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str, 1, "");
            }
        });
    }

    public final d e(String str, String str2) {
        d h4 = h(str, str2);
        if (h4 != null && h4.j() == 0) {
            h4.c(1);
        }
        return h4;
    }

    public final d f(String str, String str2) {
        return h(str, str2);
    }

    public final void g(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.a.a.a a4 = com.mbridge.msdk.foundation.a.a.a.a();
            String b4 = a4.b(str + "_" + str2);
            if (TextUtils.isEmpty(b4)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(b4);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            x.d(f38715a, th.getMessage());
        }
    }

    public final void f(String str) {
        com.mbridge.msdk.foundation.a.a.a a4 = com.mbridge.msdk.foundation.a.a.a.a();
        a4.c("ivreward_" + str);
    }

    public final d c(String str, String str2) {
        d e4 = e(str, str2);
        return e4 == null ? d.l() : e4;
    }

    public final String e(String str) {
        com.mbridge.msdk.foundation.a.a.a a4 = com.mbridge.msdk.foundation.a.a.a.a();
        return a4.b("ivreward_" + str);
    }

    public final boolean a(String str) {
        a b4 = b(str);
        if (b4 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long an = b4.an() + (b4.aj() * 1000);
            if (an > currentTimeMillis) {
                String str2 = f38715a;
                x.b(str2, "app setting nexttime is not ready  [settingNextRequestTime= " + an + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        x.b(f38715a, "app setting timeout or not exists");
        return true;
    }

    public final a g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return b();
            }
            a b4 = b(str);
            return b4 == null ? b() : b4;
        } catch (Exception unused) {
            return b();
        }
    }

    public final d d(String str, String str2) {
        d h4 = h(str, str2);
        return h4 == null ? d.l() : h4;
    }

    public final boolean a(String str, int i4, String str2) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            String str3 = str + "_" + i4 + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j5 = 0;
            long longValue = ((Long) ae.b(j4, str3, 0L)).longValue();
            a b4 = b(str);
            if (b4 == null) {
                b4 = a().b();
            } else {
                j5 = longValue;
            }
            if (j5 + (b4.Y() * 1000) > currentTimeMillis) {
                return false;
            }
            ae.a(j4, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        a b4 = b(str2);
        if (a(str2) && a(str2, 1, str)) {
            new c().a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, com.mbridge.msdk.foundation.controller.a.f().l());
        }
        d e4 = e(str2, str);
        if (b4 != null && e4 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long u3 = e4.u() + (b4.ae() * 1000);
            if (u3 > currentTimeMillis) {
                String str3 = f38715a;
                x.b(str3, "unit setting  nexttime is not ready  [settingNextRequestTime= " + u3 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        x.b(f38715a, "unit setting timeout or not exists");
        return true;
    }

    private n a(List<CampaignEx> list, int i4) {
        n nVar = new n();
        try {
            nVar.d(b(list, i4));
            nVar.a(i4 + "");
            if (q.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a() > 500) {
                q.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).b("0");
            }
            q.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(nVar);
        } catch (Exception unused) {
        }
        return nVar;
    }

    private String b(List<CampaignEx> list, int i4) {
        String str = "key=2000079&iex=" + i4 + "&cal=";
        try {
            JSONArray jSONArray = new JSONArray();
            for (CampaignEx campaignEx : list) {
                jSONArray.put(a(campaignEx));
            }
            return str + s.a(jSONArray.toString());
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
                return str;
            }
            return str;
        }
    }

    private JSONObject a(CampaignEx campaignEx) {
        JSONObject jSONObject = null;
        if (campaignEx == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("campaignid", campaignEx.getId());
                jSONObject2.put("ts", campaignEx.getTs());
                jSONObject2.put("label", campaignEx.getLabel());
                jSONObject2.put("vc", campaignEx.getcVersionCode());
                String pkgSource = campaignEx.getPkgSource();
                if (pkgSource == null) {
                    pkgSource = "";
                }
                jSONObject2.put("pkg_source", pkgSource);
                return jSONObject2;
            } catch (Exception e4) {
                e = e4;
                jSONObject = jSONObject2;
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return jSONObject;
                }
                return jSONObject;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final a b(String str) {
        if (f38718d == null) {
            try {
                f38718d = a.f(com.mbridge.msdk.foundation.a.a.a.a().b(str));
                if (f38718d != null) {
                    f38718d.aw();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return f38718d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, java.lang.String r6) {
        /*
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.a()
            boolean r0 = r0.d()
            java.lang.String r1 = "mbridge"
            r2 = 0
            if (r0 == 0) goto L1d
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch: java.lang.Exception -> L1d
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.b(r3)     // Catch: java.lang.Exception -> L1d
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
            java.util.HashMap<java.lang.String, com.mbridge.msdk.c.d> r1 = com.mbridge.msdk.c.b.f38717c     // Catch: java.lang.Exception -> L63
            java.lang.Object r4 = r2.get(r0)     // Catch: java.lang.Exception -> L63
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L63
            com.mbridge.msdk.c.d r4 = com.mbridge.msdk.c.d.b(r4)     // Catch: java.lang.Exception -> L63
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
            java.util.HashMap<java.lang.String, com.mbridge.msdk.c.d> r2 = com.mbridge.msdk.c.b.f38717c     // Catch: java.lang.Exception -> Laa
            java.lang.Object r4 = r5.get(r1)     // Catch: java.lang.Exception -> Laa
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> Laa
            com.mbridge.msdk.c.d r4 = com.mbridge.msdk.c.d.b(r4)     // Catch: java.lang.Exception -> Laa
            r2.put(r1, r4)     // Catch: java.lang.Exception -> Laa
            goto L79
        Laa:
            r5 = move-exception
            r5.printStackTrace()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.b.a(android.content.Context, java.lang.String):void");
    }

    public final a b() {
        a aVar = new a();
        aVar.h(86400L);
        aVar.O(1);
        aVar.P(1);
        aVar.e(true);
        aVar.f(true);
        aVar.f(3600L);
        aVar.g(0L);
        aVar.d(false);
        aVar.c(false);
        aVar.b(7200L);
        aVar.d(20L);
        aVar.e(10L);
        aVar.I(1);
        aVar.J(1);
        aVar.e("\u6b63\u5728\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u53bb\u901a\u77e5\u680f\u67e5\u770b\u4e0b\u8f7d\u8fdb\u5ea6");
        aVar.c("mbridge");
        aVar.u(1);
        aVar.c(1800L);
        aVar.H(100);
        aVar.G(43200);
        aVar.F(1);
        aVar.a(604800L);
        aVar.N(1);
        aVar.K(3);
        aVar.v(1);
        aVar.E(1);
        aVar.C(1);
        aVar.D(86400);
        aVar.L(259200);
        aVar.w(1);
        aVar.x(900);
        aVar.y(20);
        aVar.d("pid");
        aVar.z(1);
        aVar.A(1);
        aVar.B(1);
        aVar.M(1);
        aVar.p(1);
        aVar.o(1);
        aVar.q(1);
        aVar.r(0);
        aVar.s(1);
        aVar.t(-1);
        aVar.b(com.mbridge.msdk.c.a.b.f38710a);
        aVar.n(2);
        aVar.m(86400);
        aVar.d(0);
        aVar.h("https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js");
        aVar.g("https://mtg-native.rayjump.com/omsdk/omsdkjs_common_js.txt");
        aVar.c(120);
        aVar.b(10);
        aVar.g(false);
        aVar.R(0);
        aVar.S(120);
        aVar.T(1);
        aVar.j(com.mbridge.msdk.foundation.same.a.f39372L);
        aVar.i(com.mbridge.msdk.foundation.same.a.N);
        aVar.h(com.mbridge.msdk.foundation.same.a.M);
        aVar.a(10);
        aVar.k(com.mbridge.msdk.foundation.same.a.R);
        aVar.g(10);
        aVar.V(0);
        aVar.U(0);
        aVar.a("");
        aVar.W(1);
        aVar.f(1);
        aVar.e(24);
        aVar.a(false);
        aVar.Q(1);
        aVar.b(true);
        return aVar;
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f38717c.put(str4, d.b(str3));
    }
}
