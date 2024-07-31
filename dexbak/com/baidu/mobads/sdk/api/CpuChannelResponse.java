package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.C2715l;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CpuChannelResponse {
    private C2715l mCpuChannelInfo;

    public CpuChannelResponse(C2715l c2715l) {
        this.mCpuChannelInfo = c2715l;
    }

    public int getChannelId() {
        C2715l c2715l = this.mCpuChannelInfo;
        if (c2715l != null) {
            return c2715l.m50360a();
        }
        return -1;
    }

    public String getChannelName() {
        C2715l c2715l = this.mCpuChannelInfo;
        return c2715l != null ? c2715l.m50357b() : "";
    }
}
