package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36130c;

    public w(Bridge bridge) {
        this.f36130c = bridge == null ? b.f24741d : bridge;
    }

    public float a() {
        return ((Float) this.f36130c.call(266011, b.b(0).l(), Float.TYPE)).floatValue();
    }

    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.xv bk() {
        Bridge bridge = (Bridge) this.f36130c.call(266102, null, Bridge.class);
        if (bridge != null) {
            return new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.xv(bridge);
        }
        return null;
    }

    public boolean c() {
        return ((Boolean) this.f36130c.call(266001, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public String ev() {
        return (String) this.f36130c.call(266008, b.b(0).l(), String.class);
    }

    public Map<String, Object> f() {
        return (Map) this.f36130c.call(266006, b.b(0).l(), Map.class);
    }

    public boolean gd() {
        return ((Boolean) this.f36130c.call(266009, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public float k() {
        return ((Float) this.f36130c.call(266010, b.b(0).l(), Float.TYPE)).floatValue();
    }

    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w p() {
        Bridge bridge = (Bridge) this.f36130c.call(266101, null, Bridge.class);
        if (bridge != null) {
            return new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w(bridge);
        }
        return null;
    }

    public boolean r() {
        return ((Boolean) this.f36130c.call(266007, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public float sr() {
        return ((Float) this.f36130c.call(266004, b.b(0).l(), Float.TYPE)).floatValue();
    }

    public String t() {
        return (String) this.f36130c.call(266103, b.b(0).l(), String.class);
    }

    public boolean ux() {
        return ((Boolean) this.f36130c.call(266005, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public boolean w() {
        return ((Boolean) this.f36130c.call(266002, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public boolean xv() {
        return ((Boolean) this.f36130c.call(266003, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public int ys() {
        return ((Integer) this.f36130c.call(266104, b.b(0).l(), Integer.TYPE)).intValue();
    }
}
