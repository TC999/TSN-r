package com.bykv.vk.component.ttvideo.utils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveUtils {
    public static int versionStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < split.length; i5++) {
            if (i5 == 0) {
                i4 = Integer.parseInt(split[i5]);
            } else {
                i4 = (i4 * 100) + Integer.parseInt(split[i5]);
            }
        }
        return i4;
    }
}
