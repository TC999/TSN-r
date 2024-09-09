package com.umeng.commonsdk.statistics.common;

import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY),
    ANDROIDID("android_id", "android_id"),
    MAC("mac", "mac"),
    SERIALNO("serial_no", "serial_no"),
    IDFA(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY, AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY),
    DEFAULT("null", "null");
    
    private String description;
    private String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }
}
