package com.bytedance.msdk.f.sr;

import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static Bridge f28357c;

    public static void c(Bridge bridge) {
        f28357c = bridge;
    }

    public static String w() {
        Bridge bridge = f28357c;
        if (bridge != null) {
            return (String) bridge.call(10005, null, String.class);
        }
        return null;
    }

    public static String xv() {
        Bridge bridge = f28357c;
        if (bridge != null) {
            return (String) bridge.call(10006, null, String.class);
        }
        return null;
    }

    public static String c() {
        Bridge bridge = f28357c;
        if (bridge != null) {
            return (String) bridge.call(10004, null, String.class);
        }
        return null;
    }
}
