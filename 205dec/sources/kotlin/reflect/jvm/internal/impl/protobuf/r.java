package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RopeByteString.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f57678i;

    /* renamed from: c  reason: collision with root package name */
    private final int f57679c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f57680d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f57681e;

    /* renamed from: f  reason: collision with root package name */
    private final int f57682f;

    /* renamed from: g  reason: collision with root package name */
    private final int f57683g;

    /* renamed from: h  reason: collision with root package name */
    private int f57684h;

    /* compiled from: RopeByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> f57685a;

        private b() {
            this.f57685a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f57685a.pop();
            while (!this.f57685a.isEmpty()) {
                pop = new r(this.f57685a.pop(), pop);
            }
            return pop;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.q()) {
                insert(dVar);
            } else if (dVar instanceof r) {
                r rVar = (r) dVar;
                c(rVar.f57680d);
                c(rVar.f57681e);
            } else {
                String valueOf = String.valueOf(dVar.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i4) {
            int binarySearch = Arrays.binarySearch(r.f57678i, i4);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void insert(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int d4 = d(dVar.size());
            int i4 = r.f57678i[d4 + 1];
            if (!this.f57685a.isEmpty() && this.f57685a.peek().size() < i4) {
                int i5 = r.f57678i[d4];
                kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f57685a.pop();
                while (!this.f57685a.isEmpty() && this.f57685a.peek().size() < i5) {
                    pop = new r(this.f57685a.pop(), pop);
                }
                r rVar = new r(pop, dVar);
                while (!this.f57685a.isEmpty()) {
                    if (this.f57685a.peek().size() >= r.f57678i[d(rVar.size()) + 1]) {
                        break;
                    }
                    rVar = new r(this.f57685a.pop(), rVar);
                }
                this.f57685a.push(rVar);
                return;
            }
            this.f57685a.push(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements Iterator<m> {

        /* renamed from: a  reason: collision with root package name */
        private final Stack<r> f57686a;

        /* renamed from: b  reason: collision with root package name */
        private m f57687b;

        private m a(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof r) {
                r rVar = (r) dVar;
                this.f57686a.push(rVar);
                dVar = rVar.f57680d;
            }
            return (m) dVar;
        }

        private m b() {
            while (!this.f57686a.isEmpty()) {
                m a4 = a(this.f57686a.pop().f57681e);
                if (!a4.isEmpty()) {
                    return a4;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: d */
        public m next() {
            m mVar = this.f57687b;
            if (mVar != null) {
                this.f57687b = b();
                return mVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57687b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f57686a = new Stack<>();
            this.f57687b = a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f57688a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f57689b;

        /* renamed from: c  reason: collision with root package name */
        int f57690c;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(c());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte c() {
            if (!this.f57689b.hasNext()) {
                this.f57689b = this.f57688a.next().iterator();
            }
            this.f57690c--;
            return this.f57689b.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57690c > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private d() {
            c cVar = new c(r.this);
            this.f57688a = cVar;
            this.f57689b = cVar.next().iterator();
            this.f57690c = r.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        int i5 = 1;
        while (i4 > 0) {
            arrayList.add(Integer.valueOf(i4));
            int i6 = i5 + i4;
            i5 = i4;
            i4 = i6;
        }
        arrayList.add(Integer.MAX_VALUE);
        f57678i = new int[arrayList.size()];
        int i7 = 0;
        while (true) {
            int[] iArr = f57678i;
            if (i7 >= iArr.length) {
                return;
            }
            iArr[i7] = ((Integer) arrayList.get(i7)).intValue();
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kotlin.reflect.jvm.internal.impl.protobuf.d G(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        r rVar = dVar instanceof r ? (r) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return H(dVar, dVar2);
            }
            if (rVar != null && rVar.f57681e.size() + dVar2.size() < 128) {
                dVar2 = new r(rVar.f57680d, H(rVar.f57681e, dVar2));
            } else if (rVar != null && rVar.f57680d.p() > rVar.f57681e.p() && rVar.p() > dVar2.p()) {
                dVar2 = new r(rVar.f57680d, new r(rVar.f57681e, dVar2));
            } else {
                if (size >= f57678i[Math.max(dVar.p(), dVar2.p()) + 1]) {
                    return new r(dVar, dVar2);
                }
                return new b().b(dVar, dVar2);
            }
        }
        return dVar2;
    }

    private static m H(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.n(bArr, 0, 0, size);
        dVar2.n(bArr, 0, size, size2);
        return new m(bArr);
    }

    private boolean I(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        m next = cVar.next();
        c cVar2 = new c(dVar);
        m next2 = cVar2.next();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int size = next.size() - i4;
            int size2 = next2.size() - i5;
            int min = Math.min(size, size2);
            if (!(i4 == 0 ? next.E(next2, i5, min) : next2.E(next, i4, min))) {
                return false;
            }
            i6 += min;
            int i7 = this.f57679c;
            if (i6 >= i7) {
                if (i6 == i7) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = cVar.next();
                i4 = 0;
            } else {
                i4 += min;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i5 = 0;
            } else {
                i5 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void C(OutputStream outputStream, int i4, int i5) throws IOException {
        int i6 = i4 + i5;
        int i7 = this.f57682f;
        if (i6 <= i7) {
            this.f57680d.C(outputStream, i4, i5);
        } else if (i4 >= i7) {
            this.f57681e.C(outputStream, i4 - i7, i5);
        } else {
            int i8 = i7 - i4;
            this.f57680d.C(outputStream, i4, i8);
            this.f57681e.C(outputStream, 0, i5 - i8);
        }
    }

    public boolean equals(Object obj) {
        int x3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d) {
            kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
            if (this.f57679c != dVar.size()) {
                return false;
            }
            if (this.f57679c == 0) {
                return true;
            }
            if (this.f57684h == 0 || (x3 = dVar.x()) == 0 || this.f57684h == x3) {
                return I(dVar);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.f57684h;
        if (i4 == 0) {
            int i5 = this.f57679c;
            i4 = v(i5, 0, i5);
            if (i4 == 0) {
                i4 = 1;
            }
            this.f57684h = i4;
        }
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void o(byte[] bArr, int i4, int i5, int i6) {
        int i7 = i4 + i6;
        int i8 = this.f57682f;
        if (i7 <= i8) {
            this.f57680d.o(bArr, i4, i5, i6);
        } else if (i4 >= i8) {
            this.f57681e.o(bArr, i4 - i8, i5, i6);
        } else {
            int i9 = i8 - i4;
            this.f57680d.o(bArr, i4, i5, i9);
            this.f57681e.o(bArr, 0, i5 + i9, i6 - i9);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int p() {
        return this.f57683g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean q() {
        return this.f57679c >= f57678i[this.f57683g];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean r() {
        int w3 = this.f57680d.w(0, 0, this.f57682f);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.f57681e;
        return dVar.w(w3, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: s */
    public d.a iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f57679c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e t() {
        return kotlin.reflect.jvm.internal.impl.protobuf.e.g(new e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.f57682f;
        if (i7 <= i8) {
            return this.f57680d.v(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.f57681e.v(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.f57681e.v(this.f57680d.v(i4, i5, i9), 0, i6 - i9);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.f57682f;
        if (i7 <= i8) {
            return this.f57680d.w(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.f57681e.w(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.f57681e.w(this.f57680d.w(i4, i5, i9), 0, i6 - i9);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x() {
        return this.f57684h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String z(String str) throws UnsupportedEncodingException {
        return new String(y(), str);
    }

    private r(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.f57684h = 0;
        this.f57680d = dVar;
        this.f57681e = dVar2;
        int size = dVar.size();
        this.f57682f = size;
        this.f57679c = size + dVar2.size();
        this.f57683g = Math.max(dVar.p(), dVar2.p()) + 1;
    }

    /* compiled from: RopeByteString.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class e extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private c f57692a;

        /* renamed from: b  reason: collision with root package name */
        private m f57693b;

        /* renamed from: c  reason: collision with root package name */
        private int f57694c;

        /* renamed from: d  reason: collision with root package name */
        private int f57695d;

        /* renamed from: e  reason: collision with root package name */
        private int f57696e;

        /* renamed from: f  reason: collision with root package name */
        private int f57697f;

        public e() {
            d();
        }

        private void b() {
            if (this.f57693b != null) {
                int i4 = this.f57695d;
                int i5 = this.f57694c;
                if (i4 == i5) {
                    this.f57696e += i5;
                    this.f57695d = 0;
                    if (this.f57692a.hasNext()) {
                        m next = this.f57692a.next();
                        this.f57693b = next;
                        this.f57694c = next.size();
                        return;
                    }
                    this.f57693b = null;
                    this.f57694c = 0;
                }
            }
        }

        private void d() {
            c cVar = new c(r.this);
            this.f57692a = cVar;
            m next = cVar.next();
            this.f57693b = next;
            this.f57694c = next.size();
            this.f57695d = 0;
            this.f57696e = 0;
        }

        private int e(byte[] bArr, int i4, int i5) {
            int i6 = i5;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                b();
                if (this.f57693b != null) {
                    int min = Math.min(this.f57694c - this.f57695d, i6);
                    if (bArr != null) {
                        this.f57693b.n(bArr, this.f57695d, i4, min);
                        i4 += min;
                    }
                    this.f57695d += min;
                    i6 -= min;
                } else if (i6 == i5) {
                    return -1;
                }
            }
            return i5 - i6;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return r.this.size() - (this.f57696e + this.f57695d);
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
            this.f57697f = this.f57696e + this.f57695d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            bArr.getClass();
            if (i4 >= 0 && i5 >= 0 && i5 <= bArr.length - i4) {
                return e(bArr, i4, i5);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            e(null, 0, this.f57697f);
        }

        @Override // java.io.InputStream
        public long skip(long j4) {
            if (j4 >= 0) {
                if (j4 > 2147483647L) {
                    j4 = 2147483647L;
                }
                return e(null, 0, (int) j4);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            b();
            m mVar = this.f57693b;
            if (mVar == null) {
                return -1;
            }
            int i4 = this.f57695d;
            this.f57695d = i4 + 1;
            return mVar.D(i4) & 255;
        }
    }
}
