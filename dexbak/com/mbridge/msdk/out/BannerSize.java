package com.mbridge.msdk.out;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameDiTool;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BannerSize {
    public static final int DEV_SET_TYPE = 5;
    public static final int LARGE_TYPE = 1;
    public static final int MEDIUM_TYPE = 2;
    public static final int SMART_TYPE = 3;
    public static final int STANDARD_TYPE = 4;
    private int height;
    private int width;

    public BannerSize(int i, int i2, int i3) {
        if (i == 1) {
            this.height = 90;
            this.width = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        } else if (i == 2) {
            this.height = 250;
            this.width = 300;
        } else if (i == 3) {
            setSmartMode();
        } else if (i == 4) {
            this.height = 50;
            this.width = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        } else if (i != 5) {
        } else {
            this.height = i3;
            this.width = i2;
        }
    }

    private void setSmartMode() {
        if (SameDiTool.m21763y(MBSDKContext.m22865f().m22861j()) < 720) {
            this.height = 50;
            this.width = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
            return;
        }
        this.height = 90;
        this.width = 728;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
