package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ByteString.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d implements Iterable<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f57629a = new m(new byte[0]);

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f57630b = false;

    /* compiled from: ByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a extends Iterator<Byte> {
        byte c();
    }

    private static d a(Iterator<d> it, int i4) {
        if (i4 == 1) {
            return it.next();
        }
        int i5 = i4 >>> 1;
        return a(it, i5).c(a(it, i4 - i5));
    }

    public static d g(Iterable<d> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            for (d dVar : iterable) {
                collection.add(dVar);
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return f57629a;
        }
        return a(collection.iterator(), collection.size());
    }

    public static d k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static d l(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return new m(bArr2);
    }

    public static d m(String str) {
        try {
            return new m(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("UTF-8 not supported?", e4);
        }
    }

    public static b u() {
        return new b(128);
    }

    public String A() {
        try {
            return z("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("UTF-8 not supported?", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(OutputStream outputStream, int i4, int i5) throws IOException {
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i4);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i5 >= 0) {
            int i6 = i4 + i5;
            if (i6 <= size()) {
                if (i5 > 0) {
                    C(outputStream, i4, i5);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder(39);
            sb2.append("Source end offset exceeded: ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i5);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void C(OutputStream outputStream, int i4, int i5) throws IOException;

    public d c(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 < 2147483647L) {
            return r.G(this, dVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void n(byte[] bArr, int i4, int i5, int i6) {
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i4);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i5 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i5);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i6 >= 0) {
            int i7 = i4 + i6;
            if (i7 <= size()) {
                int i8 = i5 + i6;
                if (i8 <= bArr.length) {
                    if (i6 > 0) {
                        o(bArr, i4, i5, i6);
                        return;
                    }
                    return;
                }
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Target end offset < 0: ");
                sb3.append(i8);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i7);
            throw new IndexOutOfBoundsException(sb4.toString());
        } else {
            StringBuilder sb5 = new StringBuilder(23);
            sb5.append("Length < 0: ");
            sb5.append(i6);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void o(byte[] bArr, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int p();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean q();

    public abstract boolean r();

    @Override // java.lang.Iterable
    /* renamed from: s */
    public abstract a iterator();

    public abstract int size();

    public abstract e t();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int v(int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int w(int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int x();

    public byte[] y() {
        int size = size();
        if (size == 0) {
            return h.f57662a;
        }
        byte[] bArr = new byte[size];
        o(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String z(String str) throws UnsupportedEncodingException;

    /* compiled from: ByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends OutputStream {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f57631f = new byte[0];

        /* renamed from: a  reason: collision with root package name */
        private final int f57632a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<d> f57633b;

        /* renamed from: c  reason: collision with root package name */
        private int f57634c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f57635d;

        /* renamed from: e  reason: collision with root package name */
        private int f57636e;

        b(int i4) {
            if (i4 >= 0) {
                this.f57632a = i4;
                this.f57633b = new ArrayList<>();
                this.f57635d = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] a(byte[] bArr, int i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i4));
            return bArr2;
        }

        private void b(int i4) {
            this.f57633b.add(new m(this.f57635d));
            int length = this.f57634c + this.f57635d.length;
            this.f57634c = length;
            this.f57635d = new byte[Math.max(this.f57632a, Math.max(i4, length >>> 1))];
            this.f57636e = 0;
        }

        private void d() {
            int i4 = this.f57636e;
            byte[] bArr = this.f57635d;
            if (i4 >= bArr.length) {
                this.f57633b.add(new m(this.f57635d));
                this.f57635d = f57631f;
            } else if (i4 > 0) {
                this.f57633b.add(new m(a(bArr, i4)));
            }
            this.f57634c += this.f57636e;
            this.f57636e = 0;
        }

        public synchronized int e() {
            return this.f57634c + this.f57636e;
        }

        public synchronized d g() {
            d();
            return d.g(this.f57633b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(e()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i4) {
            if (this.f57636e == this.f57635d.length) {
                b(1);
            }
            byte[] bArr = this.f57635d;
            int i5 = this.f57636e;
            this.f57636e = i5 + 1;
            bArr[i5] = (byte) i4;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = this.f57635d;
            int length = bArr2.length;
            int i6 = this.f57636e;
            if (i5 <= length - i6) {
                System.arraycopy(bArr, i4, bArr2, i6, i5);
                this.f57636e += i5;
            } else {
                int length2 = bArr2.length - i6;
                System.arraycopy(bArr, i4, bArr2, i6, length2);
                int i7 = i5 - length2;
                b(i7);
                System.arraycopy(bArr, i4 + length2, this.f57635d, 0, i7);
                this.f57636e = i7;
            }
        }
    }
}
