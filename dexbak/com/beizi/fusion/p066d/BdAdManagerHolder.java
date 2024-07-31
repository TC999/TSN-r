package com.beizi.fusion.p066d;

import android.content.Context;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.beizi.fusion.BeiZis;

/* renamed from: com.beizi.fusion.d.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BdAdManagerHolder {

    /* renamed from: a */
    private static boolean f11129a;

    /* renamed from: a */
    public static void m48656a(Context context, String str) {
        m48655b(context, str);
    }

    /* renamed from: b */
    private static void m48655b(Context context, String str) {
        if (f11129a) {
            return;
        }
        try {
            if (BeiZis.getCustomController() != null) {
                MobadsPermissionSettings.setPermissionReadDeviceID(BeiZis.getCustomController().isCanUsePhoneState());
                MobadsPermissionSettings.setPermissionLocation(BeiZis.getCustomController().isCanUseLocation());
                if (!BeiZis.getCustomController().isCanUseAppList()) {
                    MobadsPermissionSettings.setPermissionAppList(false);
                }
            }
            new BDAdConfig.Builder().setAppsid(str).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build()).build(context).init();
            f11129a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
