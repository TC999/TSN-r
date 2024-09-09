package com.bytedance.sdk.openadsdk.n;

import com.bytedance.embedapplog.util.TTEncryptUtils;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {
    public static byte[] c(byte[] bArr, int i4) {
        if (bArr != null && i4 > 0) {
            try {
                if (bArr.length == i4) {
                    return TTEncryptUtils.a(bArr, i4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
