package com.bytedance.sdk.openadsdk.core;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.eq.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements c.w {

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, WeakReference<c.w>> f33528c = new HashMap();

    public void c(Bridge bridge) {
        if (bridge == null) {
            return;
        }
        bridge.call(9, b.b(1).h(0, new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.f.1
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i4, Result result) {
                if (i4 == 0) {
                    f.this.c();
                    return null;
                } else if (i4 != 1) {
                    return null;
                } else {
                    f.this.w();
                    return null;
                }
            }
        }).l(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void w() {
        Iterator<Map.Entry<Integer, WeakReference<c.w>>> it = this.f33528c.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<c.w> value = it.next().getValue();
            if (value != null) {
                c.w wVar = value.get();
                if (wVar != null) {
                    wVar.w();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public void c(c.w wVar) {
        if (wVar == null) {
            return;
        }
        this.f33528c.put(Integer.valueOf(wVar.hashCode()), new WeakReference<>(wVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void c() {
        Iterator<Map.Entry<Integer, WeakReference<c.w>>> it = this.f33528c.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<c.w> value = it.next().getValue();
            if (value != null) {
                c.w wVar = value.get();
                if (wVar != null) {
                    wVar.c();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
