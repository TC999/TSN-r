package com.beizi.fusion.p066d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.p072g.C3137at;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;

/* renamed from: com.beizi.fusion.d.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class JadYunAdManagerHolder {

    /* renamed from: a */
    private static boolean f11150a;

    /* renamed from: a */
    public static void m48624a(Context context, String str) {
        m48623b(context, str);
    }

    /* renamed from: b */
    private static void m48623b(Context context, String str) {
        if (f11150a) {
            return;
        }
        try {
            JADYunSdk.init(context, new JADYunSdkConfig.Builder().setAppId(str).setEnableLog(true).setPrivateController(m48625a(context)).build());
            f11150a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static JADPrivateController m48625a(final Context context) {
        return new JADPrivateController() { // from class: com.beizi.fusion.d.m.1
            public String getIP() {
                return "";
            }

            public String getImei() {
                return "";
            }

            public String getOaid() {
                return (String) C3137at.m48313b(context, "__OAID__", "");
            }

            public boolean isCanUseIP() {
                return super.isCanUseIP();
            }

            public boolean isCanUseLocation() {
                if (BeiZis.getCustomController() != null) {
                    return BeiZis.getCustomController().isCanUseLocation();
                }
                return super.isCanUseLocation();
            }

            public boolean isCanUsePhoneState() {
                if (BeiZis.getCustomController() != null) {
                    return BeiZis.getCustomController().isCanUsePhoneState();
                }
                return super.isCanUsePhoneState();
            }
        };
    }
}
