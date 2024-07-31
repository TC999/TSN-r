package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.model.DownloadShortInfo;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6313s implements Bridge {

    /* renamed from: ok */
    private DownloadShortInfo f22426ok;

    public C6313s(DownloadShortInfo downloadShortInfo) {
        this.f22426ok = downloadShortInfo;
    }

    /* renamed from: a */
    public int m36646a() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    /* renamed from: bl */
    public long m36645bl() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    /* renamed from: h */
    public boolean m36644h() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    /* renamed from: kf */
    public int m36643kf() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    /* renamed from: n */
    public String m36642n() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    /* renamed from: ok */
    public long m36641ok() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.f33852id;
        }
        return -1L;
    }

    /* renamed from: s */
    public long m36640s() {
        DownloadShortInfo downloadShortInfo = this.f22426ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37920g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, m36641ok()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, m36646a()).m37920g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, m36645bl()).m37920g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, m36640s()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, m36642n()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, m36643kf()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, m36644h()).m37926a();
    }
}
