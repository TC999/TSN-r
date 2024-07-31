package com.p518qq.p519e.comm.managers.plugin;

import com.tencent.connect.common.Constants;

/* renamed from: com.qq.e.comm.managers.plugin.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C11827d {

    /* renamed from: a */
    private static final String[] f32935a = {"0", "1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "a", "b", "c", "d", "e", "f"};

    /* renamed from: a */
    public static String m20328a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f32935a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
