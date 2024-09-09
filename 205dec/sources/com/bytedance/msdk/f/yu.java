package com.bytedance.msdk.f;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class yu {
    public static <T> boolean c(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean w(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
