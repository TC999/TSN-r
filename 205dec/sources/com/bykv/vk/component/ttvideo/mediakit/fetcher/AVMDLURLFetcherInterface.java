package com.bykv.vk.component.ttvideo.mediakit.fetcher;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface AVMDLURLFetcherInterface {
    void close();

    String[] getURLs();

    int start(String str, String str2, String str3, AVMDLURLFetcherListener aVMDLURLFetcherListener);
}
