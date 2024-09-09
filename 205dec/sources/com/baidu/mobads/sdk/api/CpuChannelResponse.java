package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CpuChannelResponse {
    private l mCpuChannelInfo;

    public CpuChannelResponse(l lVar) {
        this.mCpuChannelInfo = lVar;
    }

    public int getChannelId() {
        l lVar = this.mCpuChannelInfo;
        if (lVar != null) {
            return lVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        l lVar = this.mCpuChannelInfo;
        return lVar != null ? lVar.b() : "";
    }
}
