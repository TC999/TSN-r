package com.bykv.vk.component.ttvideo.mediakit.medialoader;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface AVMDLDataLoaderListener {
    String getCheckSumInfo(String str);

    long getInt64Value(int i4, long j4);

    String getStringValue(int i4, long j4, String str);

    void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo);
}
