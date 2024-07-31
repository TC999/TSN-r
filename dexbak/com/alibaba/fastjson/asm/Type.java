package com.alibaba.fastjson.asm;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
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

    private Type(int i, char[] cArr, int i2, int i3) {
        this.sort = i;
        this.buf = cArr;
        this.off = i2;
        this.len = i3;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                i4 = (charAt == 'D' || charAt == 'J') ? i4 + 2 : i4 + 1;
                i3 = i;
            }
        }
        char charAt2 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt2 == 'V') {
            i2 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
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

    private static Type getType(char[] cArr, int i) {
        int i2;
        char c = cArr[i];
        if (c != 'F') {
            if (c != 'S') {
                if (c != 'V') {
                    if (c != 'I') {
                        if (c != 'J') {
                            if (c != 'Z') {
                                if (c != '[') {
                                    switch (c) {
                                        case 'B':
                                            return BYTE_TYPE;
                                        case 'C':
                                            return CHAR_TYPE;
                                        case 'D':
                                            return DOUBLE_TYPE;
                                        default:
                                            int i3 = 1;
                                            while (cArr[i + i3] != ';') {
                                                i3++;
                                            }
                                            return new Type(10, cArr, i + 1, i3 - 1);
                                    }
                                }
                                int i4 = 1;
                                while (true) {
                                    i2 = i + i4;
                                    if (cArr[i2] != '[') {
                                        break;
                                    }
                                    i4++;
                                }
                                if (cArr[i2] == 'L') {
                                    do {
                                        i4++;
                                    } while (cArr[i + i4] != ';');
                                    return new Type(9, cArr, i, i4 + 1);
                                }
                                return new Type(9, cArr, i, i4 + 1);
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
