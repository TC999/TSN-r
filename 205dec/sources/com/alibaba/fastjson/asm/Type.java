package com.alibaba.fastjson.asm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i4, char[] cArr, int i5, int i6) {
        this.sort = i4;
        this.buf = cArr;
        this.off = i5;
        this.len = i6;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i4;
        int i5 = 1;
        int i6 = 1;
        int i7 = 1;
        while (true) {
            i4 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i6 = i4 + 1;
                    if (str.charAt(i4) == ';') {
                        break;
                    }
                    i4 = i6;
                }
                i7++;
            } else {
                i7 = (charAt == 'D' || charAt == 'J') ? i7 + 2 : i7 + 1;
                i6 = i4;
            }
        }
        char charAt2 = str.charAt(i4);
        int i8 = i7 << 2;
        if (charAt2 == 'V') {
            i5 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i5 = 2;
        }
        return i8 | i5;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    private static Type getType(char[] cArr, int i4) {
        int i5;
        char c4 = cArr[i4];
        if (c4 != 'F') {
            if (c4 != 'S') {
                if (c4 != 'V') {
                    if (c4 != 'I') {
                        if (c4 != 'J') {
                            if (c4 != 'Z') {
                                if (c4 != '[') {
                                    switch (c4) {
                                        case 'B':
                                            return BYTE_TYPE;
                                        case 'C':
                                            return CHAR_TYPE;
                                        case 'D':
                                            return DOUBLE_TYPE;
                                        default:
                                            int i6 = 1;
                                            while (cArr[i4 + i6] != ';') {
                                                i6++;
                                            }
                                            return new Type(10, cArr, i4 + 1, i6 - 1);
                                    }
                                }
                                int i7 = 1;
                                while (true) {
                                    i5 = i4 + i7;
                                    if (cArr[i5] != '[') {
                                        break;
                                    }
                                    i7++;
                                }
                                if (cArr[i5] == 'L') {
                                    do {
                                        i7++;
                                    } while (cArr[i4 + i7] != ';');
                                    return new Type(9, cArr, i4, i7 + 1);
                                }
                                return new Type(9, cArr, i4, i7 + 1);
                            }
                            return BOOLEAN_TYPE;
                        }
                        return LONG_TYPE;
                    }
                    return INT_TYPE;
                }
                return VOID_TYPE;
            }
            return SHORT_TYPE;
        }
        return FLOAT_TYPE;
    }
}
