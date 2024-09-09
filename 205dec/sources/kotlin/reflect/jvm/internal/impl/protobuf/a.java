package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: AbstractMessageLite.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a implements n {
    protected int memoizedHashCode = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream J = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(serializedSize) + serializedSize));
        J.o0(serializedSize);
        writeTo(J);
        J.I();
    }

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class AbstractC1158a<BuilderType extends AbstractC1158a> implements n.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException c(n nVar) {
            return new UninitializedMessageException(nVar);
        }

        @Override // 
        /* renamed from: a */
        public abstract BuilderType clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
        /* renamed from: b */
        public abstract BuilderType g(e eVar, f fVar) throws IOException;

        /* compiled from: AbstractMessageLite.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1159a extends FilterInputStream {

            /* renamed from: a  reason: collision with root package name */
            private int f57622a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C1159a(InputStream inputStream, int i4) {
                super(inputStream);
                this.f57622a = i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f57622a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f57622a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f57622a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j4) throws IOException {
                long skip = super.skip(Math.min(j4, this.f57622a));
                if (skip >= 0) {
                    this.f57622a = (int) (this.f57622a - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) throws IOException {
                int i6 = this.f57622a;
                if (i6 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i4, Math.min(i5, i6));
                if (read >= 0) {
                    this.f57622a -= read;
                }
                return read;
            }
        }
    }
}
