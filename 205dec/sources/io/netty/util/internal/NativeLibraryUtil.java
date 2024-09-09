package io.netty.util.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class NativeLibraryUtil {
    private NativeLibraryUtil() {
    }

    public static void loadLibrary(String str, boolean z3) {
        if (z3) {
            System.load(str);
        } else {
            System.loadLibrary(str);
        }
    }
}
