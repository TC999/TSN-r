package com.baidu.mobads.sdk.api;

import com.baidu.mobads.proxy.C2537R;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawableUtil {
    public static Integer getDrawableId(String str) {
        if ("blur_bg_white".equals(str)) {
            return Integer.valueOf(C2537R.C2538drawable.bd_bg_blur_white);
        }
        if ("rsp_small_red_heart".equals(str)) {
            return Integer.valueOf(C2537R.C2538drawable.bd_rsp_small_red_heart);
        }
        if ("rsp_big_red_heart".equals(str)) {
            return Integer.valueOf(C2537R.C2538drawable.bd_rsp_big_red_heart);
        }
        if ("cpu_drama_video".equals(str)) {
            return Integer.valueOf(C2537R.C2538drawable.cpu_drama_video);
        }
        return null;
    }
}
