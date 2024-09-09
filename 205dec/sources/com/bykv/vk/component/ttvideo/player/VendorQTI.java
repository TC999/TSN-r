package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class VendorQTI {
    private static final int LEVEL_HIGH = 2;
    private static final int LEVEL_LITE = 0;
    private static final int LEVEL_MIDIUM = 1;
    private static final String TAG = "VendorQTI";

    public static void debugEffect(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
        Log.d(TAG, "mediaformat = " + mediaFormat.toString());
    }

    public static void enableLowLatency(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
    }

    @TargetApi(16)
    public static void setupVpp(android.media.MediaFormat mediaFormat, int i4) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setString("vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        if (i4 == 0 || i4 == 1) {
            mediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", i4 == 0 ? 10 : 20);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 65);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 60);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        } else if (i4 != 2) {
            return;
        } else {
            mediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", 15);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 70);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 70);
            mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        }
        mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-low", 20);
        mediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-high", 20);
    }
}
