package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AuthorityInfoBean {
    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean a(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a("authority_applist", String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a("authority_app_download", String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a("authority_imsi_id", String.valueOf(i4));
        com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.AUTHORITY_OA_ID, String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean b(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean c(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean d(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean e(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.AUTHORITY_OA_ID, String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean f(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a("authority_applist", String.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean g(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a("authority_app_download", String.valueOf(i4));
        return this;
    }

    public int getAuthAppDownloadStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b("authority_app_download").equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b("authority_app_download"));
    }

    public int getAuthAppListStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b("authority_applist").equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b("authority_applist"));
    }

    public int getAuthDeviceIdStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID));
    }

    public int getAuthGenDataStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA));
    }

    public int getAuthImsiIdStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b("authority_imsi_id").equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b("authority_imsi_id"));
    }

    public int getAuthOaidStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b(com.mbridge.msdk.a.AUTHORITY_OA_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b(com.mbridge.msdk.a.AUTHORITY_OA_ID));
    }

    public int getAuthSerialIdStatus() {
        if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthorityInfoBean h(int i4) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_OTHER, String.valueOf(i4));
        return this;
    }
}
