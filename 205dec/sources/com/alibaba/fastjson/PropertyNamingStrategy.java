package com.alibaba.fastjson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String translate(String str) {
        char charAt;
        int i4 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int i5 = 0;
        if (i4 == 1) {
            StringBuilder sb = new StringBuilder();
            while (i5 < str.length()) {
                char charAt2 = str.charAt(i5);
                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                    char c4 = (char) (charAt2 + ' ');
                    if (i5 > 0) {
                        sb.append('_');
                    }
                    sb.append(c4);
                } else {
                    sb.append(charAt2);
                }
                i5++;
            }
            return sb.toString();
        } else if (i4 == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i5 < str.length()) {
                char charAt3 = str.charAt(i5);
                if (charAt3 >= 'A' && charAt3 <= 'Z') {
                    char c5 = (char) (charAt3 + ' ');
                    if (i5 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c5);
                } else {
                    sb2.append(charAt3);
                }
                i5++;
            }
            return sb2.toString();
        } else if (i4 != 3) {
            if (i4 == 4 && (charAt = str.charAt(0)) >= 'A' && charAt <= 'Z') {
                char[] charArray = str.toCharArray();
                charArray[0] = (char) (charArray[0] + ' ');
                return new String(charArray);
            }
            return str;
        } else {
            char charAt4 = str.charAt(0);
            if (charAt4 < 'a' || charAt4 > 'z') {
                return str;
            }
            char[] charArray2 = str.toCharArray();
            charArray2[0] = (char) (charArray2[0] - ' ');
            return new String(charArray2);
        }
    }
}
