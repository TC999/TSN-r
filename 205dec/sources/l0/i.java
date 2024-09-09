package l0;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class i {
    public static float a(String str, float f4) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            return f4;
        }
    }

    public static int b(String str, int i4) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            return i4;
        }
    }

    public static long c(String str, long j4) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            return j4;
        }
    }

    public static boolean d(String str, boolean z3) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            return z3;
        }
    }
}
