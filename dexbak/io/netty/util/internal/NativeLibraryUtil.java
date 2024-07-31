package io.netty.util.internal;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class NativeLibraryUtil {
    private NativeLibraryUtil() {
    }

    public static void loadLibrary(String str, boolean z) {
        if (z) {
            System.load(str);
        } else {
            System.loadLibrary(str);
        }
    }
}
