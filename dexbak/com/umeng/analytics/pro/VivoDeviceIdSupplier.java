package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.vivo.identifier.C15418e;

/* renamed from: com.umeng.analytics.pro.bf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class VivoDeviceIdSupplier implements IDeviceIdSupplier {
    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        String str = null;
        try {
            if (!C15418e.m2699a(context)) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                str = C15418e.m2697c(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}
