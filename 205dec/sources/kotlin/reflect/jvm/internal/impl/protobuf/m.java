package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiteralByteString.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class m extends d {

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f57673c;

    /* renamed from: d  reason: collision with root package name */
    private int f57674d = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiteralByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private int f57675a;

        /* renamed from: b  reason: collision with root package name */
        private final int f57676b;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(c());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte c() {
            try {
                byte[] bArr = m.this.f57673c;
                int i4 = this.f57675a;
                this.f57675a = i4 + 1;
                return bArr[i4];
            } catch (ArrayIndexOutOfBoundsException e4) {
                throw new NoSuchElementException(e4.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57675a < this.f57676b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            this.f57675a = 0;
            this.f57676b = m.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(byte[] bArr) {
        this.f57673c = bArr;
    }

    static int G(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void C(OutputStream outputStream, int i4, int i5) throws IOException {
        outputStream.write(this.f57673c, F() + i4, i5);
    }

    public byte D(int i4) {
        return this.f57673c[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(m mVar, int i4, int i5) {
        if (i5 <= mVar.size()) {
            if (i4 + i5 <= mVar.size()) {
                byte[] bArr = this.f57673c;
                byte[] bArr2 = mVar.f57673c;
                int F = F() + i5;
                int F2 = F();
                int F3 = mVar.F() + i4;
                while (F2 < F) {
                    if (bArr[F2] != bArr2[F3]) {
                        return false;
                    }
                    F2++;
                    F3++;
                }
                return true;
            }
            int size = mVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i4);
            sb.append(", ");
            sb.append(i5);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i5);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int F() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof d) && size() == ((d) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof m) {
                return E((m) obj, 0, size());
            }
            if (obj instanceof r) {
                return obj.equals(this);
            }
            String valueOf = String.valueOf(obj.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 49);
            sb.append("Has a new type of ByteString been created? Found ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.f57674d;
        if (i4 == 0) {
            int size = size();
            i4 = v(size, 0, size);
            if (i4 == 0) {
                i4 = 1;
            }
            this.f57674d = i4;
        }
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void o(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.f57673c, i4, bArr, i5, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int p() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean q() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean r() {
        int F = F();
        return u.f(this.f57673c, F, size() + F);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: s */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f57673c.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public e t() {
        return e.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i4, int i5, int i6) {
        return G(i4, this.f57673c, F() + i5, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w(int i4, int i5, int i6) {
        int F = F() + i5;
        return u.g(i4, this.f57673c, F, i6 + F);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x() {
        return this.f57674d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String z(String str) throws UnsupportedEncodingException {
        return new String(this.f57673c, F(), size(), str);
    }
}
