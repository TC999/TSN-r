package com.baidu.idl.face.platform;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum LicenseStatusEnum {
    StateSuccess,
    StateWarningValidityComing,
    StateErrorBegin,
    StateErrorNotFindLicense,
    StateErrorExpired,
    StateErrorAuthorized,
    StateErrorNetwork,
    StateNotInit,
    StateInitializing,
    StateUnknown;

    public static LicenseStatusEnum getLicenseStatus(int i4) {
        return StateUnknown;
    }
}
