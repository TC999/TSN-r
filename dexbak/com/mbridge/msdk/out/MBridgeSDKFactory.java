package com.mbridge.msdk.out;

import com.mbridge.msdk.system.MBridgeSDKImpl;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBridgeSDKFactory {
    private static MBridgeSDKImpl instance;

    private MBridgeSDKFactory() {
    }

    public static MBridgeSDKImpl getMBridgeSDK() {
        if (instance == null) {
            synchronized (MBridgeSDKFactory.class) {
                if (instance == null) {
                    instance = new MBridgeSDKImpl();
                }
            }
        }
        return instance;
    }
}
