package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f816a = Logger.getLogger(l.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f817a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutputStream f818b;

        a(t tVar, OutputStream outputStream) {
            this.f817a = tVar;
            this.f818b = outputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            u.a(cVar.f798b, 0L, j4);
            while (j4 > 0) {
                this.f817a.e();
                o oVar = cVar.f797a;
                int min = (int) Math.min(j4, oVar.f830c - oVar.f829b);
                this.f818b.write(oVar.f828a, oVar.f829b, min);
                int i4 = oVar.f829b + min;
                oVar.f829b = i4;
                long j5 = min;
                j4 -= j5;
                cVar.f798b -= j5;
                if (i4 == oVar.f830c) {
                    cVar.f797a = oVar.b();
                    p.a(oVar);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f818b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            this.f818b.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t t() {
            return this.f817a;
        }

        public String toString() {
            return "sink(" + this.f818b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b implements s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f820b;

        b(t tVar, InputStream inputStream) {
            this.f819a = tVar;
            this.f820b = inputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j4);
            } else if (i4 == 0) {
                return 0L;
            } else {
                try {
                    this.f819a.e();
                    o b4 = cVar.b(1);
                    int read = this.f820b.read(b4.f828a, b4.f830c, (int) Math.min(j4, 8192 - b4.f830c));
                    if (read == -1) {
                        return -1L;
                    }
                    b4.f830c += read;
                    long j5 = read;
                    cVar.f798b += j5;
                    return j5;
                } catch (AssertionError e4) {
                    if (l.a(e4)) {
                        throw new IOException(e4);
                    }
                    throw e4;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f820b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t t() {
            return this.f819a;
        }

        public String toString() {
            return "source(" + this.f820b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Socket f821k;

        c(Socket socket) {
            this.f821k = socket;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected void i() {
            try {
                this.f821k.close();
            } catch (AssertionError e4) {
                if (l.a(e4)) {
                    Logger logger = l.f816a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.f821k, (Throwable) e4);
                    return;
                }
                throw e4;
            } catch (Exception e5) {
                Logger logger2 = l.f816a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.f821k, (Throwable) e5);
            }
        }
    }

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static s b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c4 = c(socket);
                return c4.a(a(socket.getInputStream(), c4));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c(Socket socket) {
        return new c(socket);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    private static r a(OutputStream outputStream, t tVar) {
        if (outputStream != null) {
            if (tVar != null) {
                return new a(tVar, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c4 = c(socket);
                return c4.a(a(socket.getOutputStream(), c4));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(InputStream inputStream, t tVar) {
        if (inputStream != null) {
            if (tVar != null) {
                return new b(tVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
