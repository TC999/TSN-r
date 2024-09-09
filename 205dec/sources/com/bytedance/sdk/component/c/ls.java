package com.bytedance.sdk.component.c;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum ls {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ls c(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
