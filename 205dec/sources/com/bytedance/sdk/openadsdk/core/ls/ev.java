package com.bytedance.sdk.openadsdk.core.ls;

import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private int f33877c;

    /* renamed from: w  reason: collision with root package name */
    private Result f33878w;

    public ev(Result result, int i4) {
        this.f33877c = i4;
        this.f33878w = result;
    }

    public int getType() {
        return this.f33877c;
    }

    public void setResult(Result result) {
        this.f33878w = result;
    }

    public Result xv() {
        return this.f33878w;
    }
}
