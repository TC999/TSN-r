package com.tencent.gatherer.a.a.a.h;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.tencent.gatherer.a.a.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C1035a implements c {

        /* renamed from: b  reason: collision with root package name */
        private byte[] f51549b;

        /* renamed from: c  reason: collision with root package name */
        int f51550c = 0;

        /* renamed from: d  reason: collision with root package name */
        private d f51551d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f51552e;

        /* compiled from: A */
        /* renamed from: com.tencent.gatherer.a.a.a.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C1036a implements d {

            /* renamed from: a  reason: collision with root package name */
            private int f51553a;

            /* renamed from: b  reason: collision with root package name */
            private short f51554b;

            /* renamed from: c  reason: collision with root package name */
            private short f51555c;

            /* renamed from: d  reason: collision with root package name */
            private short f51556d;

            /* renamed from: e  reason: collision with root package name */
            private g[] f51557e;

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.a.a.a.h.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class C1037a extends g {

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f51559c;

                C1037a(C1035a c1035a, int i4) {
                    this.f51559c = i4;
                }

                @Override // com.tencent.gatherer.a.a.a.h.g
                public Object a() {
                    return new b(this.f51559c);
                }
            }

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.a.a.a.h.a$a$a$b */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class b implements e {

                /* renamed from: a  reason: collision with root package name */
                private int f51561a;

                /* renamed from: b  reason: collision with root package name */
                private int f51562b;

                /* renamed from: c  reason: collision with root package name */
                private int f51563c;

                /* renamed from: d  reason: collision with root package name */
                private int f51564d;

                /* renamed from: e  reason: collision with root package name */
                private int f51565e;

                /* renamed from: f  reason: collision with root package name */
                private g f51566f;

                /* compiled from: A */
                /* renamed from: com.tencent.gatherer.a.a.a.h.a$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\2450172.dex */
                class C1038a extends g {

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ int f51568c;

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ int f51569d;

                    C1038a(C1036a c1036a, int i4, int i5) {
                        this.f51568c = i4;
                        this.f51569d = i5;
                    }

                    @Override // com.tencent.gatherer.a.a.a.h.g
                    public Object a() {
                        return new c(C1036a.this, this.f51568c, this.f51569d);
                    }
                }

                b(int i4) throws com.tencent.gatherer.a.a.a.h.b {
                    C1036a.this.b(i4);
                    this.f51561a = C1036a.this.d();
                    this.f51562b = C1036a.this.d();
                    C1036a.this.b(C1036a.this.f() + 8);
                    this.f51563c = C1036a.this.d();
                    this.f51564d = C1036a.this.d();
                    this.f51565e = C1036a.this.d();
                    C1036a.this.b(C1036a.this.f() + 12);
                    int i5 = this.f51562b;
                    if (i5 != 2) {
                        if (i5 == 3) {
                            this.f51566f = new C1038a(C1036a.this, this.f51563c, this.f51564d);
                            return;
                        } else if (i5 != 11) {
                            return;
                        }
                    }
                    g[] gVarArr = new g[this.f51564d / this.f51565e];
                }

                @Override // com.tencent.gatherer.a.a.a.h.e
                public f a() {
                    g gVar = this.f51566f;
                    if (gVar != null) {
                        return (f) gVar.b();
                    }
                    return null;
                }

                @Override // com.tencent.gatherer.a.a.a.h.e
                public String getName() {
                    if (this.f51561a == 0) {
                        return null;
                    }
                    return C1035a.this.a().b().get(this.f51561a);
                }

                @Override // com.tencent.gatherer.a.a.a.h.e
                public int getOffset() {
                    return this.f51563c;
                }

                @Override // com.tencent.gatherer.a.a.a.h.e
                public int getSize() {
                    return this.f51564d;
                }
            }

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.a.a.a.h.a$a$a$c */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class c implements f {

                /* renamed from: a  reason: collision with root package name */
                private byte[] f51571a;

                /* renamed from: b  reason: collision with root package name */
                private int f51572b;

                c(C1036a c1036a, int i4, int i5) throws com.tencent.gatherer.a.a.a.h.b {
                    c1036a.b(i4);
                    byte[] bArr = new byte[i5];
                    this.f51571a = bArr;
                    int a4 = c1036a.a(bArr);
                    if (a4 == i5) {
                        int i6 = 0;
                        this.f51572b = 0;
                        while (true) {
                            byte[] bArr2 = this.f51571a;
                            if (i6 >= bArr2.length) {
                                return;
                            }
                            if (bArr2[i6] == 0) {
                                this.f51572b++;
                            }
                            i6++;
                        }
                    } else {
                        throw new com.tencent.gatherer.a.a.a.h.b("Error reading string table (read " + a4 + "bytes, expected to read " + this.f51571a.length + "bytes).");
                    }
                }

                @Override // com.tencent.gatherer.a.a.a.h.f
                public String get(int i4) {
                    int i5 = i4;
                    while (this.f51571a[i5] != 0) {
                        i5++;
                    }
                    return new String(this.f51571a, i4, i5 - i4);
                }
            }

            C1036a() throws com.tencent.gatherer.a.a.a.h.b {
                e();
                e();
                b(f() + 12);
                this.f51553a = d();
                b(f() + 4 + 6);
                this.f51554b = e();
                this.f51555c = e();
                this.f51556d = e();
                this.f51557e = new g[this.f51555c];
                for (int i4 = 0; i4 < this.f51555c; i4++) {
                    com.tencent.gatherer.a.a.a.d.a("i: " + i4 + ", sh_offset:" + this.f51553a + ", sh_entry_size:" + ((int) this.f51554b));
                    this.f51557e[i4] = new C1037a(C1035a.this, this.f51553a + (this.f51554b * i4));
                }
            }

            public e a(int i4) {
                return (e) this.f51557e[i4].b();
            }

            @Override // com.tencent.gatherer.a.a.a.h.d
            public f b() {
                return a(this.f51556d).a();
            }

            public short c() {
                return this.f51555c;
            }

            int f() {
                return C1035a.this.f51550c;
            }

            void b(int i4) {
                int length = C1035a.this.f51549b.length;
                C1035a.this.f51550c = i4;
            }

            int d() {
                byte[] bArr = new byte[4];
                a(bArr);
                return a(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            short e() {
                byte[] bArr = new byte[2];
                a(bArr);
                return b(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            @Override // com.tencent.gatherer.a.a.a.h.d
            public byte[] a() {
                byte[] bArr = new byte[0];
                for (int i4 = 1; i4 < c(); i4++) {
                    e a4 = a(i4);
                    if (".rodata".equals(a4.getName())) {
                        int offset = a4.getOffset();
                        int size = a4.getSize();
                        byte[] bArr2 = new byte[size];
                        System.arraycopy(C1035a.this.f51549b, offset, bArr2, 0, size);
                        bArr = bArr2;
                    }
                }
                return bArr;
            }

            public short b(byte[] bArr, ByteOrder byteOrder) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(byteOrder);
                return wrap.getShort();
            }

            int a(byte[] bArr) {
                int length = C1035a.this.f51549b.length - C1035a.this.f51550c;
                if (length < 1) {
                    return length;
                }
                int min = Math.min(length, bArr.length);
                System.arraycopy(C1035a.this.f51549b, C1035a.this.f51550c, bArr, 0, min);
                C1035a.this.f51550c += min;
                return min;
            }

            private int a(byte[] bArr, ByteOrder byteOrder) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(byteOrder);
                return wrap.getInt();
            }
        }

        C1035a(byte[] bArr) throws b {
            byte[] bArr2 = new byte[16];
            this.f51552e = bArr2;
            this.f51549b = bArr;
            int a4 = a(bArr2);
            if (a4 == this.f51552e.length) {
                if (Arrays.equals(b(), c.f51573a)) {
                    this.f51551d = new C1036a();
                    return;
                }
                throw new b("Bad magic number for file.");
            }
            throw new b("Error reading elf header (read " + a4 + "bytes, expected to read " + this.f51552e.length + "bytes).");
        }

        int a(byte[] bArr) {
            int min = Math.min(this.f51549b.length - this.f51550c, bArr.length);
            System.arraycopy(this.f51549b, this.f51550c, bArr, 0, min);
            this.f51550c += min;
            return min;
        }

        public byte[] b() {
            byte[] bArr = this.f51552e;
            return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]};
        }

        @Override // com.tencent.gatherer.a.a.a.h.c
        public d a() {
            return this.f51551d;
        }
    }

    public static c a(byte[] bArr) throws b {
        return new C1035a(bArr);
    }
}
