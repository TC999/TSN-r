package com.bytedance.sdk.gromore.init;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements EventListener {

    /* renamed from: c  reason: collision with root package name */
    private EventListener f31272c;

    /* renamed from: w  reason: collision with root package name */
    private EventListener f31273w;

    public ux(EventListener eventListener) {
        this.f31272c = eventListener;
    }

    public void c(EventListener eventListener) {
        this.f31273w = eventListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i4, Result result) {
        if (result != null) {
            if (!result.isSuccess()) {
                EventListener eventListener = this.f31272c;
                if (eventListener != null) {
                    eventListener.onEvent(i4, result);
                    return null;
                }
                return null;
            } else if (i4 == 8001) {
                EventListener eventListener2 = this.f31273w;
                if (eventListener2 != null) {
                    eventListener2.onEvent(i4, result);
                    return null;
                }
                return null;
            } else {
                EventListener eventListener3 = this.f31272c;
                if (eventListener3 != null) {
                    eventListener3.onEvent(i4, result);
                    return null;
                }
                return null;
            }
        }
        return null;
    }
}
