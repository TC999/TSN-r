package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BoundedByteString.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c extends m {

    /* renamed from: e  reason: collision with root package name */
    private final int f57624e;

    /* renamed from: f  reason: collision with root package name */
    private final int f57625f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BoundedByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private int f57626a;

        /* renamed from: b  reason: collision with root package name */
        private final int f57627b;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(c());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte c() {
            int i4 = this.f57626a;
            if (i4 < this.f57627b) {
                byte[] bArr = c.this.f57673c;
                this.f57626a = i4 + 1;
                return bArr[i4];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57626a < this.f57627b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            int F = c.this.F();
            this.f57626a = F;
            this.f57627b = F + c.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(byte[] bArr, int i4, int i5) {
        super(bArr);
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i5 >= 0) {
            if (i4 + i5 <= bArr.length) {
                this.f57624e = i4;
                this.f57625f = i5;
                return;
            }
            StringBuilder sb2 = new StringBuilder(48);
            sb2.append("Offset+Length too large: ");
            sb2.append(i4);
            sb2.append("+");
            sb2.append(i5);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i4);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m
    public byte D(int i4) {
        if (i4 >= 0) {
            if (i4 < size()) {
                return this.f57673c[this.f57624e + i4];
            }
            int size = size();
            StringBuilder sb = new StringBuilder(41);
            sb.append("Index too large: ");
            sb.append(i4);
            sb.append(", ");
            sb.append(size);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("Index too small: ");
        sb2.append(i4);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m
    public int F() {
        return this.f57624e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d
    public void o(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.f57673c, F() + i4, bArr, i5, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: s */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f57625f;
    }
}
