package com.mbridge.msdk.widget.custom.p517b;

/* renamed from: com.mbridge.msdk.widget.custom.b.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class XmlUtils {
    /* renamed from: a */
    public static boolean m20565a(String str) {
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
