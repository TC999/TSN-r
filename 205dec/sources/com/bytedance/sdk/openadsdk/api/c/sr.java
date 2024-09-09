package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private DownloadShortInfo f31374c;

    public sr(DownloadShortInfo downloadShortInfo) {
        this.f31374c = downloadShortInfo;
    }

    public long c() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
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
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public int f() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public boolean r() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public long sr() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    public String ux() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().f(223702, c()).e(223703, w()).f(223704, xv()).f(223705, sr()).i(223706, ux()).e(223707, f()).j(223708, r()).l();
    }

    public int w() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long xv() {
        DownloadShortInfo downloadShortInfo = this.f31374c;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }
}
