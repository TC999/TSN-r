package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s implements Bridge {
    private DownloadShortInfo ok;

    public s(DownloadShortInfo downloadShortInfo) {
        this.ok = downloadShortInfo;
    }

    public int a() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long bl() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 223700:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(223709, Object.class)));
            case 223701:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public boolean h() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public int kf() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public String n() {
        DownloadShortInfo downloadShortInfo = this.ok;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    public long ok() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public long s() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().g(223702, ok()).f(223703, a()).g(223704, bl()).g(223705, s()).i(223706, n()).f(223707, kf()).j(223708, h()).a();
    }
}
