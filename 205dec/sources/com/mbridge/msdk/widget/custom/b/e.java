package com.mbridge.msdk.widget.custom.b;

/* compiled from: XmlUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class e {
    public static boolean a(String str) {
        if (str != null && str.length() != 0) {
            try {
                try {
                    try {
                        Integer.parseInt(str);
                        return true;
                    } catch (NumberFormatException unused) {
                        Double.parseDouble(str);
                        return true;
                    }
                } catch (NumberFormatException unused2) {
                    Float.parseFloat(str);
                    return true;
                }
            } catch (NumberFormatException unused3) {
            }
        }
        return false;
    }
}
