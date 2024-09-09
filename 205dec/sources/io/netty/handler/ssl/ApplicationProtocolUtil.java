package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    private ApplicationProtocolUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> toList(Iterable<String> iterable) {
        return toList(2, iterable);
    }

    static List<String> toList(int i4, Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i4);
        for (String str : iterable) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            } else {
                throw new IllegalArgumentException("protocol cannot be null or empty");
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("protocols cannot empty");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> toList(String... strArr) {
        return toList(2, strArr);
    }

    static List<String> toList(int i4, String... strArr) {
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i4);
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            } else {
                throw new IllegalArgumentException("protocol cannot be null or empty");
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("protocols cannot empty");
        }
        return arrayList;
    }
}
