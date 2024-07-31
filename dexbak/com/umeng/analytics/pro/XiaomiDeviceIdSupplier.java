package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import p591f2.IdentifierManager;

/* renamed from: com.umeng.analytics.pro.bg */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class XiaomiDeviceIdSupplier implements IDeviceIdSupplier {
    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        String str = null;
        try {
            if (!IdentifierManager.m12747c()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                str = IdentifierManager.m12746d(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}
