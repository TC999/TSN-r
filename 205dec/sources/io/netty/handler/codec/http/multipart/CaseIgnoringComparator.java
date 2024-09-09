package io.netty.handler.codec.http.multipart;

import java.io.Serializable;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class CaseIgnoringComparator implements Comparator<CharSequence>, Serializable {
    static final CaseIgnoringComparator INSTANCE = new CaseIgnoringComparator();
    private static final long serialVersionUID = 4582133183775373862L;

    private CaseIgnoringComparator() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(CharSequence charSequence, CharSequence charSequence2) {
        char upperCase;
        char upperCase2;
        char lowerCase;
        char lowerCase2;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        for (int i4 = 0; i4 < min; i4++) {
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence2.charAt(i4);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && (lowerCase = Character.toLowerCase(upperCase)) != (lowerCase2 = Character.toLowerCase(upperCase2))) {
                return lowerCase - lowerCase2;
            }
        }
        return length - length2;
    }
}