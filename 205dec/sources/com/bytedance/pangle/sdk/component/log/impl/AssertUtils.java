package com.bytedance.pangle.sdk.component.log.impl;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AssertUtils {
    public static void assertHelper(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void assertParams(Object obj, String str) {
        if (obj == null) {
            assertHelper(str);
        }
    }

    public static void assertHelper(boolean z3, String str) {
        if (z3) {
            assertHelper(str);
        }
    }
}
