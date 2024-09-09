package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
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

    public static void iD() {
        try {
            iP(mContext);
        } catch (Throwable unused) {
        }
        try {
            db.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            dd.a(mContext).a(100);
            cz.a(mContext).a(100);
            de.a(mContext).a(100);
            da.a(mContext).a();
            cy.a(mContext).a(100);
            dc.a(mContext).a(100);
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long b4 = df.a(context).b();
            long currentTimeMillis = (System.currentTimeMillis() - b4) - (h.a(context, "re_po_rt").c("plc001_b_pti", 12) * 3600000);
            if (b4 < 1 || currentTimeMillis > 0) {
                n.a().a(new cw(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            mContext = origApplicationContext;
            if (origApplicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = IWeaponInitParams.this;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.3.0";
                            WeaponHI.hostVersionName = bh.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.isLoad = IWeaponInitParams.this.isLoadSo();
                            WeaponHI.cookieData = bh.z(WeaponHI.mContext);
                            try {
                                h a4 = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cm.m());
                                jSONObject.put("d", cm.b(WeaponHI.mContext));
                                jSONObject.put("a", bh.q(WeaponHI.mContext));
                                jSONObject.put("p", bh.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.3.0");
                                jSONObject.put("n", TextUtils.isEmpty(a4.a("plc001_v")) ? 1 : 0);
                                WeaponHI.encryENV = new bn(WeaponHI.mContext).c(jSONObject.toString());
                                String a5 = a4.a("plc001_f_is");
                                if (!TextUtils.isEmpty(a5)) {
                                    WeaponHI.isList = Arrays.asList(a5.split("\\|"));
                                    WeaponHI.ii = a4.c("plc001_f_ii", 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } else {
                Log.e("Risk", "context  is not application\uff01\uff01\uff01");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setPS(final boolean z3) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h a4 = h.a(context, "re_po_rt");
                        boolean z4 = z3;
                        if (!z4) {
                            a4.a("a1_p_s_p_s_c_b", Boolean.valueOf(z4));
                        } else if (a4.e("a1_p_s_p_s_c_b")) {
                        } else {
                            a4.a("a1_p_s_p_s_c_b", Boolean.valueOf(z3));
                            try {
                                if (a4.c("l_p_i_s", 1) == 1) {
                                    dd.a(WeaponHI.mContext).a(103);
                                    db.a(WeaponHI.mContext).a(103, 0);
                                    cy.a(WeaponHI.mContext).a(103);
                                    dc.a(WeaponHI.mContext).a(103);
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
    public static void init(String str, String str2, boolean z3) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z3));
            n.a();
            bt.a(mContext);
            bs.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q a4 = q.a(WeaponHI.mContext);
                    if (a4 == null) {
                        return;
                    }
                    a4.a();
                } catch (Exception unused2) {
                }
            }
        });
    }
}
