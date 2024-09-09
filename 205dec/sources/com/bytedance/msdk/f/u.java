package com.bytedance.msdk.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u {
    public static String c(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            sb.append(iArr[i4]);
            if (i4 != iArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
