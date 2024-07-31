package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.DomainMBridgeConstans;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AuthorityInfoBean {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final AuthorityInfoBean m22850a(int i) {
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a("authority_applist", String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a("authority_app_download", String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a("authority_imsi_id", String.valueOf(i));
        SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.AUTHORITY_OA_ID, String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final AuthorityInfoBean m22849b(int i) {
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final AuthorityInfoBean m22848c(int i) {
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final AuthorityInfoBean m22847d(int i) {
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final AuthorityInfoBean m22846e(int i) {
        SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.AUTHORITY_OA_ID, String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final AuthorityInfoBean m22845f(int i) {
        SharedPerferenceManager.m22949a().m22945a("authority_applist", String.valueOf(i));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final AuthorityInfoBean m22844g(int i) {
        SharedPerferenceManager.m22949a().m22945a("authority_app_download", String.valueOf(i));
        return this;
    }

    public int getAuthAppDownloadStatus() {
        if (SharedPerferenceManager.m22949a().m22944b("authority_app_download").equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b("authority_app_download"));
    }

    public int getAuthAppListStatus() {
        if (SharedPerferenceManager.m22949a().m22944b("authority_applist").equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b("authority_applist"));
    }

    public int getAuthDeviceIdStatus() {
        if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_DEVICE_ID));
    }

    public int getAuthGenDataStatus() {
        if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_GENERAL_DATA));
    }

    public int getAuthImsiIdStatus() {
        if (SharedPerferenceManager.m22949a().m22944b("authority_imsi_id").equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b("authority_imsi_id"));
    }

    public int getAuthOaidStatus() {
        if (SharedPerferenceManager.m22949a().m22944b(DomainMBridgeConstans.AUTHORITY_OA_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b(DomainMBridgeConstans.AUTHORITY_OA_ID));
    }

    public int getAuthSerialIdStatus() {
        if (SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
            return 1;
        }
        return Integer.parseInt(SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.AUTHORITY_SERIAL_ID));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final AuthorityInfoBean m22843h(int i) {
        SharedPerferenceManager.m22949a().m22945a(MBridgeConstans.AUTHORITY_OTHER, String.valueOf(i));
        return this;
    }
}
