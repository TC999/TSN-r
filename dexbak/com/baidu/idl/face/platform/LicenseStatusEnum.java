package com.baidu.idl.face.platform;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static LicenseStatusEnum getLicenseStatus(int i) {
        return StateUnknown;
    }
}
