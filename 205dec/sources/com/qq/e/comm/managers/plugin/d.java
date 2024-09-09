package com.qq.e.comm.managers.plugin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f41669a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 : bArr) {
            if (i4 < 0) {
                i4 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f41669a;
            sb.append(strArr[i4 / 16]);
            sb.append(strArr[i4 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
