package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import p587e2.OpenIDSDK;

/* renamed from: com.umeng.analytics.pro.bd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OppoDeviceIdSupplier implements IDeviceIdSupplier {

    /* renamed from: a */
    private boolean f37739a = false;

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        try {
            if (!this.f37739a) {
                OpenIDSDK.m12816a(context);
                this.f37739a = true;
            }
            if (!OpenIDSDK.m12815b()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return OpenIDSDK.m12813d(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
