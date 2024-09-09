package com.bytedance.msdk.adapter.xv.c;

import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.sr.w.xv;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.msdk.api.sr.c.w.f.c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private xv f27259c;
    private Context sr;

    /* renamed from: w  reason: collision with root package name */
    private Bridge f27260w;
    private Bridge xv;

    public w() {
        xv c4 = xv.c(com.bytedance.msdk.core.w.k().up());
        this.f27259c = c4;
        this.f27260w = c4.c();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.f.c
    public void c(Context context, com.bytedance.msdk.api.sr.c.w.xv.w wVar, Map<String, Object> map) {
        this.sr = context;
        if (wVar != null) {
            b a4 = b.a();
            a4.h(8089, com.bytedance.msdk.core.w.k().up());
            a4.h(8545, wVar.c());
            a4.h(8400, map);
            a4.h(8401, this);
            a4.j(8098, true);
            this.f27260w.call(AVMDLDataLoader.KeyIsLiveLoaderEnable, a4.l(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8216) {
            this.xv = (Bridge) valueSet.objectValue(8402, Bridge.class);
        } else if (i4 == 8219) {
            xv();
        } else if (i4 == 8220) {
            return (T) Boolean.valueOf(sr());
        }
        return (T) com.bytedance.msdk.core.s.c.c(cls);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.f.c
    public String w() {
        return "0.0";
    }

    @Override // com.bytedance.msdk.api.sr.c.w.f.c
    public String w(Context context, Map<String, Object> map) {
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        a4.h(8075, map);
        Bridge bridge = this.xv;
        if (bridge != null) {
            return (String) bridge.call(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue, a4.l(), String.class);
        }
        return super.w(context, map);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.f.c
    public String c(Context context, Map<String, Object> map) {
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        a4.h(8075, map);
        Bridge bridge = this.xv;
        if (bridge != null) {
            return (String) bridge.call(8139, a4.l(), String.class);
        }
        return super.c(context, map);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.f.c
    public String c() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            return (String) bridge.call(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel, null, String.class);
        }
        return null;
    }
}
