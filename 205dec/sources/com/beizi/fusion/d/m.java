package com.beizi.fusion.d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.au;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: JadYunAdManagerHolder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14667a;

    public static void a(Context context, String str) {
        b(context, str);
    }

    private static void b(Context context, String str) {
        if (f14667a) {
            return;
        }
        try {
            JADYunSdk.init(context, new JADYunSdkConfig.Builder().setAppId(str).setEnableLog(true).setPrivateController(a(context)).build());
            f14667a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static JADPrivateController a(final Context context) {
        return new JADPrivateController() { // from class: com.beizi.fusion.d.m.1
            public String getIP() {
                return "";
            }

            public String getImei() {
                return "";
            }

            public String getOaid() {
                return (String) au.b(context, "__OAID__", "");
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
