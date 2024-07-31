package com.bun.miitmdid.content;

import androidx.annotation.Keep;
import com.bun.miitmdid.content.ProviderList;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SystemParamters {
    private static volatile SystemParamters g_insans;

    /* renamed from: mf */
    private String f14581mf;
    @Keep
    private String sdk_version = "10025";
    @Keep
    private String sdk_vname = "1.0.25";

    private SystemParamters() {
    }

    public static ProviderList.DEVICE_PROVIDER checkDeviceSystem() {
        Object[] objArr = new Object[3];
        objArr[1] = 13;
        objArr[2] = 1606976968485L;
        return (ProviderList.DEVICE_PROVIDER) Utils.m20485rL(objArr);
    }

    public static SystemParamters getIns() {
        Object[] objArr = new Object[3];
        objArr[1] = 14;
        objArr[2] = 1606976968486L;
        return (SystemParamters) Utils.m20485rL(objArr);
    }

    public static String getSysProperty(String str, String str2) {
        Object[] objArr = new Object[5];
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = 15;
        objArr[4] = 1606976968487L;
        return (String) Utils.m20485rL(objArr);
    }

    public static boolean isFreeMeOS() {
        Object[] objArr = new Object[3];
        objArr[1] = 16;
        objArr[2] = 1606976968488L;
        return ((Boolean) Utils.m20485rL(objArr)).booleanValue();
    }

    private static boolean isSsuiOS() {
        Object[] objArr = new Object[3];
        objArr[1] = 17;
        objArr[2] = 1606976968489L;
        return ((Boolean) Utils.m20485rL(objArr)).booleanValue();
    }

    public String getMf() {
        return (String) Utils.m20485rL(new Object[]{this, 18, 1606976968490L});
    }

    public String getSdkVersion() {
        return (String) Utils.m20485rL(new Object[]{this, 19, 1606976968491L});
    }

    public String getSdkVname() {
        return (String) Utils.m20485rL(new Object[]{this, 20, 1606976968492L});
    }
}
