package ms.bz.bd.c.Pgl;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pblx {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class pblb extends Exception {
        public pblb(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class pgla<A, B> {

        /* renamed from: a  reason: collision with root package name */
        private final A f61452a;

        /* renamed from: b  reason: collision with root package name */
        private final B f61453b;

        private pgla(A a4, B b4) {
            this.f61452a = a4;
            this.f61453b = b4;
        }

        public static <A, B> pgla<A, B> b(A a4, B b4) {
            return new pgla<>(a4, b4);
        }

        public A a() {
            return this.f61452a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && pgla.class == obj.getClass()) {
                pgla pglaVar = (pgla) obj;
                A a4 = this.f61452a;
                if (a4 == null) {
                    if (pglaVar.f61452a != null) {
                        return false;
                    }
                } else if (!a4.equals(pglaVar.f61452a)) {
                    return false;
                }
                B b4 = this.f61453b;
                B b5 = pglaVar.f61453b;
                return b4 == null ? b5 == null : b4.equals(b5);
            }
            return false;
        }

        public int hashCode() {
            A a4 = this.f61452a;
            int hashCode = ((a4 == null ? 0 : a4.hashCode()) + 31) * 31;
            B b4 = this.f61453b;
            return hashCode + (b4 != null ? b4.hashCode() : 0);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:5|(4:6|7|8|9)|(5:10|11|12|13|(3:16|(5:21|22|23|(3:25|26|28)|(1:14))|29))|37|38|39) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:9:0x0028, B:11:0x003c, B:12:0x0044, B:14:0x004a, B:17:0x0053, B:20:0x005a), top: B:34:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.Integer, java.lang.String> a(java.lang.String r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L95
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "95678c"
            r8 = 1
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L95
            r9 = 0
            r10 = 58
            r8[r9] = r10     // Catch: java.lang.Throwable -> L95
            java.lang.Object r3 = ms.bz.bd.c.Pgl.pblk.a(r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L95
            r2.<init>(r11, r3)     // Catch: java.lang.Throwable -> L95
            java.nio.channels.FileChannel r11 = r2.getChannel()     // Catch: java.lang.Throwable -> L93
            ms.bz.bd.c.Pgl.pblx$pgla r11 = c(r11)     // Catch: java.lang.Throwable -> L93
            java.lang.Object r11 = r11.a()     // Catch: java.lang.Throwable -> L93
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11     // Catch: java.lang.Throwable -> L93
            java.util.Map r11 = b(r11)     // Catch: java.lang.Throwable -> L93
            java.util.LinkedHashMap r11 = (java.util.LinkedHashMap) r11
            java.util.Set r11 = r11.entrySet()     // Catch: java.lang.Throwable -> L93
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L93
        L44:
            boolean r1 = r11.hasNext()     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L99
            java.lang.Object r1 = r11.next()     // Catch: java.lang.Throwable -> L93
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L53
            goto L44
        L53:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L93
            if (r3 != 0) goto L5a
            goto L44
        L5a:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L93
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L93
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L93
            r4 = 1896449818(0x7109871a, float:6.810044E29)
            if (r3 != r4) goto L6a
            goto L44
        L6a:
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L44
            java.lang.Object r4 = r1.getValue()     // Catch: java.lang.Throwable -> L44
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch: java.lang.Throwable -> L44
            byte[] r5 = r4.array()     // Catch: java.lang.Throwable -> L44
            int r6 = r4.arrayOffset()     // Catch: java.lang.Throwable -> L44
            int r7 = r4.position()     // Catch: java.lang.Throwable -> L44
            int r7 = r7 + r6
            int r4 = r4.limit()     // Catch: java.lang.Throwable -> L44
            int r6 = r6 + r4
            byte[] r4 = java.util.Arrays.copyOfRange(r5, r7, r6)     // Catch: java.lang.Throwable -> L44
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L44
            java.lang.Object r1 = r1.getKey()     // Catch: java.lang.Throwable -> L44
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L44
            goto L44
        L93:
            r1 = r2
            goto L96
        L95:
        L96:
            if (r1 == 0) goto L9c
            r2 = r1
        L99:
            r2.close()     // Catch: java.lang.Throwable -> L9c
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblx.a(java.lang.String):java.util.Map");
    }

    public static Map<Integer, ByteBuffer> b(ByteBuffer byteBuffer) throws pblb {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int capacity = byteBuffer.capacity() - 24;
            if (capacity >= 8) {
                byteBuffer.capacity();
                if (capacity <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(capacity);
                        byteBuffer.position(8);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        while (slice.hasRemaining()) {
                            if (slice.remaining() < 8) {
                                throw new pblb((String) pblk.a(16777217, 0, 0L, "c7628a", new byte[]{36}));
                            }
                            long j4 = slice.getLong();
                            if (j4 < 4 || j4 > 2147483647L) {
                                throw new pblb((String) pblk.a(16777217, 0, 0L, "c0aa51", new byte[]{37}));
                            }
                            int i4 = (int) j4;
                            int position2 = slice.position() + i4;
                            if (i4 > slice.remaining()) {
                                throw new pblb((String) pblk.a(16777217, 0, 0L, "84320d", new byte[]{113}));
                            }
                            Integer valueOf = Integer.valueOf(slice.getInt());
                            int i5 = i4 - 4;
                            if (i5 < 0) {
                                throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "babd03", new byte[]{33}));
                            }
                            int limit2 = slice.limit();
                            int position3 = slice.position();
                            int i6 = i5 + position3;
                            if (i6 < position3 || i6 > limit2) {
                                throw new BufferUnderflowException();
                            }
                            slice.limit(i6);
                            try {
                                ByteBuffer slice2 = slice.slice();
                                slice2.order(slice.order());
                                slice.position(i6);
                                slice.limit(limit2);
                                linkedHashMap.put(valueOf, slice2);
                                slice.position(position2);
                            } catch (Throwable th) {
                                slice.limit(limit2);
                                throw th;
                            }
                        }
                        return linkedHashMap;
                    } catch (Throwable th2) {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        throw th2;
                    }
                }
                throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "eb1d3a", new byte[]{33}));
            }
            throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "2afa33", new byte[]{119}));
        }
        throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "036734", new byte[]{112}));
    }

    public static pgla<ByteBuffer, Long> c(FileChannel fileChannel) throws IOException, pblb {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) pblk.a(16777217, 0, 0L, "09eb9a", new byte[]{112, 106}));
        }
        long j4 = size - 22;
        long min = Math.min(j4, 65535L);
        int i4 = 0;
        while (true) {
            long j5 = i4;
            if (j5 > min) {
                throw new IOException((String) pblk.a(16777217, 0, 0L, "00bb8c", new byte[]{112, 98}));
            }
            long j6 = j4 - j5;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j6);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j6 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s3 = allocate2.getShort(0);
                if (s3 == i4) {
                    ByteBuffer allocate3 = ByteBuffer.allocate(4);
                    allocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - s3) - 6);
                    fileChannel.read(allocate3);
                    long j7 = allocate3.getInt(0);
                    if (j7 >= 32) {
                        fileChannel.position(j7 - 24);
                        ByteBuffer allocate4 = ByteBuffer.allocate(24);
                        fileChannel.read(allocate4);
                        allocate4.order(byteOrder);
                        if (allocate4.getLong(8) == 2334950737559900225L && allocate4.getLong(16) == 3617552046287187010L) {
                            long j8 = allocate4.getLong(0);
                            if (j8 >= allocate4.capacity() && j8 <= 2147483639) {
                                int i5 = (int) (8 + j8);
                                long j9 = j7 - i5;
                                if (j9 >= 0) {
                                    fileChannel.position(j9);
                                    ByteBuffer allocate5 = ByteBuffer.allocate(i5);
                                    fileChannel.read(allocate5);
                                    allocate5.order(byteOrder);
                                    if (allocate5.getLong(0) == j8) {
                                        return pgla.b(allocate5, Long.valueOf(j9));
                                    }
                                }
                            }
                        }
                        return null;
                    }
                    throw new pblb((String) pblk.a(16777217, 0, 0L, "7dd6c4", new byte[]{Byte.MAX_VALUE}));
                }
            }
            i4++;
        }
    }

    public static boolean d() {
        return e((String) pblk.a(16777217, 0, 0L, "1dfc96", new byte[]{35, 105, 24, 89, 4, 56, 38, 64, 51, 50, 46, 101, 16, 89, 0, 51, 51, 72, 32, 60, 50, 109, 91, 20, 9, 51, 55, 11, 36, 55, 43, 107, 26, 25, 15, 53, 61, 87, 121, 3, 39, 106, 38, 51, 45, 12, 61, 75, 62, 39, 47, 116, 32, 3, 15, 45, 33}));
    }

    private static boolean e(String... strArr) {
        boolean z3;
        boolean z4 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z3 = true;
            } catch (Throwable unused) {
                z3 = false;
            }
            z4 &= z3;
            if (!z4) {
                break;
            }
        }
        return z4;
    }
}
