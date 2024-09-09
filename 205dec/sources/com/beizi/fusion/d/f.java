package com.beizi.fusion.d;

import android.content.Context;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.beizi.fusion.BeiZis;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BdAdManagerHolder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14646a;

    public static void a(Context context, String str) {
        b(context, str);
    }

    private static void b(Context context, String str) {
        if (f14646a) {
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
            f14646a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
