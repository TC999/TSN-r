package com.kuaishou.weapon.p205p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import kotlin.UByte;

/* renamed from: com.kuaishou.weapon.p0.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7212c {

    /* renamed from: a */
    public static final int f24626a = 0;

    /* renamed from: b */
    public static final int f24627b = 1;

    /* renamed from: c */
    public static final int f24628c = 2;

    /* renamed from: d */
    public static final int f24629d = 4;

    /* renamed from: e */
    public static final int f24630e = 8;

    /* renamed from: f */
    public static final int f24631f = 16;

    /* renamed from: g */
    static final /* synthetic */ boolean f24632g = true;

    /* renamed from: h */
    private static final Pattern f24633h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractC7213a {

        /* renamed from: a */
        public byte[] f24634a;

        /* renamed from: b */
        public int f24635b;

        AbstractC7213a() {
        }

        /* renamed from: a */
        public abstract int mo34101a(int i);

        /* renamed from: a */
        public abstract boolean mo34100a(byte[] bArr, int i, int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7214b extends AbstractC7213a {

        /* renamed from: c */
        private static final int[] f24636c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d */
        private static final int[] f24637d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e */
        private static final int f24638e = -1;

        /* renamed from: f */
        private static final int f24639f = -2;

        /* renamed from: g */
        private int f24640g;

        /* renamed from: h */
        private int f24641h;

        /* renamed from: i */
        private final int[] f24642i;

        public C7214b(int i, byte[] bArr) {
            this.f24634a = bArr;
            this.f24642i = (i & 8) == 0 ? f24636c : f24637d;
            this.f24640g = 0;
            this.f24641h = 0;
        }

        @Override // com.kuaishou.weapon.p205p0.C7212c.AbstractC7213a
        /* renamed from: a */
        public int mo34101a(int i) {
            return ((i * 3) / 4) + 10;
        }

        @Override // com.kuaishou.weapon.p205p0.C7212c.AbstractC7213a
        /* renamed from: a */
        public boolean mo34100a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f24640g;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f24641h;
            byte[] bArr2 = this.f24634a;
            int[] iArr = this.f24642i;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4) {
                            break;
                        }
                        i6 = iArr[bArr[i9 + 3] & UByte.f41242c] | (iArr[bArr[i9 + 1] & UByte.f41242c] << 12) | (iArr[bArr[i9] & UByte.f41242c] << 18) | (iArr[bArr[i9 + 2] & UByte.f41242c] << 6);
                        if (i6 < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & UByte.f41242c];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f24640g = 6;
                                return false;
                            }
                        }
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                if (i12 != -2) {
                                    if (i12 != -1) {
                                        this.f24640g = 6;
                                        return false;
                                    }
                                }
                                i8++;
                            } else if (i8 == 5 && i12 != -1) {
                                this.f24640g = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i6 = (i6 << 6) | i12;
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i11;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i9 = i11;
                            i8 = 5;
                        } else if (i12 != -1) {
                            this.f24640g = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i12 == -2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                        i9 = i11;
                        i8 = 4;
                    } else if (i12 != -1) {
                        this.f24640g = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i6 = i12;
                } else if (i12 != -1) {
                    this.f24640g = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.f24640g = i8;
                this.f24641h = i6;
                this.f24635b = i7;
                return true;
            } else if (i8 != 1) {
                if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.f24640g = 6;
                    return false;
                }
                this.f24640g = i8;
                this.f24635b = i7;
                return true;
            } else {
                this.f24640g = 6;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.c$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7215c extends AbstractC7213a {

        /* renamed from: c */
        public static final int f24643c = 19;

        /* renamed from: h */
        static final /* synthetic */ boolean f24644h = true;

        /* renamed from: i */
        private static final byte[] f24645i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: j */
        private static final byte[] f24646j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: d */
        int f24647d;

        /* renamed from: e */
        public final boolean f24648e;

        /* renamed from: f */
        public final boolean f24649f;

        /* renamed from: g */
        public final boolean f24650g;

        /* renamed from: k */
        private final byte[] f24651k;

        /* renamed from: l */
        private int f24652l;

        /* renamed from: m */
        private final byte[] f24653m;

        public C7215c(int i, byte[] bArr) {
            this.f24634a = bArr;
            this.f24648e = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.f24649f = z;
            this.f24650g = (i & 4) != 0;
            this.f24653m = (i & 8) == 0 ? f24645i : f24646j;
            this.f24651k = new byte[2];
            this.f24647d = 0;
            this.f24652l = z ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p205p0.C7212c.AbstractC7213a
        /* renamed from: a */
        public int mo34101a(int i) {
            return ((i * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        @Override // com.kuaishou.weapon.p205p0.C7212c.AbstractC7213a
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean mo34100a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7212c.C7215c.mo34100a(byte[], int, int, boolean):boolean");
        }
    }

    private C7212c() {
    }

    /* renamed from: a */
    public static byte[] m34111a(String str, int i) {
        return m34109a(str.getBytes(), i);
    }

    /* renamed from: b */
    public static String m34106b(String str, int i) {
        try {
            return new String(m34109a(str.getBytes(), i));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static byte[] m34103c(byte[] bArr, int i) {
        try {
            return m34102c(bArr, 0, bArr.length, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m34110a(byte[] bArr) {
        return m34108a(bArr, 0, bArr.length, 0);
    }

    /* renamed from: b */
    public static String m34105b(byte[] bArr, int i) {
        try {
            return new String(m34103c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    public static byte[] m34102c(byte[] bArr, int i, int i2, int i3) {
        C7215c c7215c = new C7215c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (c7215c.f24648e) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        }
        if (c7215c.f24649f && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (c7215c.f24650g ? 2 : 1);
        }
        c7215c.f24634a = new byte[i4];
        c7215c.mo34100a(bArr, i, i2, true);
        if (f24632g || c7215c.f24635b == i4) {
            return c7215c.f24634a;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static byte[] m34109a(byte[] bArr, int i) {
        return m34108a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m34108a(byte[] bArr, int i, int i2, int i3) {
        C7214b c7214b = new C7214b(i3, new byte[(i2 * 3) / 4]);
        if (c7214b.mo34100a(bArr, i, i2, true)) {
            int i4 = c7214b.f24635b;
            byte[] bArr2 = c7214b.f24634a;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    /* renamed from: b */
    public static String m34104b(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(m34102c(bArr, i, i2, i3), "US-ASCII");
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    /* renamed from: a */
    public static String m34107a(byte[] bArr, String str) {
        try {
            return new String(m34103c(bArr, 0), str);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static boolean m34112a(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return f24633h.matcher(str).matches();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
