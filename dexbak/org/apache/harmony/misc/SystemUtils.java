package org.apache.harmony.misc;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SystemUtils {
    public static final int ARC_IA32 = 1;
    public static final int ARC_IA64 = 2;
    public static final int ARC_UNKNOWN = -1;
    public static final int OS_LINUX = 2;
    public static final int OS_UNKNOWN = -1;
    public static final int OS_WINDOWS = 1;
    private static int arc;

    /* renamed from: os */
    private static int f44160os;

    public static int getOS() {
        if (f44160os == 0) {
            String substring = System.getProperty("os.name").substring(0, 3);
            if (substring.compareToIgnoreCase("win") == 0) {
                f44160os = 1;
            } else if (substring.compareToIgnoreCase("lin") == 0) {
                f44160os = 2;
            } else {
                f44160os = -1;
            }
        }
        return f44160os;
    }
}
