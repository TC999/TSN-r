package xyz.adscope.amps.tool.util;

import android.content.Context;
import xyz.adscope.common.info.DeviceInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSScreenUtil {
    public static final int getScreenHeight(Context context) {
        return DeviceInfo.getInstance(context).getResolutionHeight();
    }

    public static final int getScreenWidth(Context context) {
        return DeviceInfo.getInstance(context).getResolutionWidth();
    }
}
