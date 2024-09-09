package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DefaultConstructor implements CreateConstructor {
    @Override // com.bykv.vk.component.ttvideo.mediakit.net.CreateConstructor
    public BaseDNS createDns(String str, AVMDLNetClient aVMDLNetClient, int i4, Handler handler) {
        try {
            return new HTTPDNS(str, aVMDLNetClient, i4, handler);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
