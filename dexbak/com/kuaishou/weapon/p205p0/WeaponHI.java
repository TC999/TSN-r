package com.kuaishou.weapon.p205p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.WeaponHI */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WeaponHI {

    /* renamed from: as */
    public static boolean f24463as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";

    /* renamed from: ii */
    public static int f24464ii = 0;
    public static List<Integer> isList = null;
    public static boolean isLoad = true;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    /* renamed from: iD */
    public static void m34448iD() {
        try {
            m34447iP(mContext);
        } catch (Throwable unused) {
        }
        try {
            C7254db.m33999a(mContext).m34000a(100, 0);
            C7243cx.m34020a(mContext).m34021a(100);
            C7258dd.m33993a(mContext).m33994a(100);
            C7247cz.m34014a(mContext).m34015a(100);
            C7260de.m33990a(mContext).m33991a(100);
            C7250da.m34007a(mContext).m34008a();
            C7245cy.m34017a(mContext).m34018a(100);
            C7256dc.m33996a(mContext).m33997a(100);
        } catch (Exception unused2) {
        }
    }

    /* renamed from: iP */
    public static void m34447iP(Context context) {
        try {
            long m33982b = C7262df.m33986a(context).m33982b();
            long currentTimeMillis = (System.currentTimeMillis() - m33982b) - (C7283h.m33888a(context, "re_po_rt").m33872c(C7262df.f24896h, 12) * C7193bi.f24584s);
            if (m33982b < 1 || currentTimeMillis > 0) {
                C7292n.m33830a().m33828a(new RunnableC7241cw(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            mContext = origApplicationContext;
            if (origApplicationContext instanceof Application) {
                C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = IWeaponInitParams.this;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.3.0";
                            WeaponHI.hostVersionName = C7191bh.m34230q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.f24463as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.isLoad = IWeaponInitParams.this.isLoadSo();
                            WeaponHI.cookieData = C7191bh.m34221z(WeaponHI.mContext);
                            try {
                                C7283h m33888a = C7283h.m33888a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", C7229cm.m34056m());
                                jSONObject.put("d", C7229cm.m34078b(WeaponHI.mContext));
                                jSONObject.put("a", C7191bh.m34230q(WeaponHI.mContext));
                                jSONObject.put("p", C7191bh.m34228s(WeaponHI.mContext));
                                jSONObject.put("s", "5.3.0");
                                jSONObject.put("n", TextUtils.isEmpty(m33888a.m33887a(C7262df.f24895g)) ? 1 : 0);
                                WeaponHI.encryENV = new C7198bn(WeaponHI.mContext).m34153c(jSONObject.toString());
                                String m33887a = m33888a.m33887a(C7262df.f24909u);
                                if (!TextUtils.isEmpty(m33887a)) {
                                    WeaponHI.isList = Arrays.asList(m33887a.split("\\|"));
                                    WeaponHI.f24464ii = m33888a.m33872c(C7262df.f24910v, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } else {
                Log.e("Risk", "context  is not application！！！");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setPS(final boolean z) {
        try {
            C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        C7283h m33888a = C7283h.m33888a(context, "re_po_rt");
                        boolean z2 = z;
                        if (!z2) {
                            m33888a.m33883a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                        } else if (m33888a.m33867e("a1_p_s_p_s_c_b")) {
                        } else {
                            m33888a.m33883a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                            try {
                                if (m33888a.m33872c(C7262df.f24885bq, 1) == 1) {
                                    C7258dd.m33993a(WeaponHI.mContext).m33994a(103);
                                    C7254db.m33999a(WeaponHI.mContext).m34000a(103, 0);
                                    C7245cy.m34017a(WeaponHI.mContext).m34018a(103);
                                    C7256dc.m33996a(WeaponHI.mContext).m33997a(103);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void init(String str, String str2, boolean z) {
        try {
            C7283h.m33888a(mContext, "re_po_rt").m33883a("a1_p_s_p_s", Boolean.valueOf(z));
            C7292n.m33830a();
            C7205bt.m34131a(mContext);
            C7204bs.m34142a(mContext);
        } catch (Exception unused) {
        }
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C7299q m33786a = C7299q.m33786a(WeaponHI.mContext);
                    if (m33786a == null) {
                        return;
                    }
                    m33786a.m33789a();
                } catch (Exception unused2) {
                }
            }
        });
    }
}
