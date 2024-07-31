package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Okio {

    /* renamed from: a */
    static final Logger f823a = Logger.getLogger(Okio.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1013a implements Sink {

        /* renamed from: a */
        final /* synthetic */ Timeout f824a;

        /* renamed from: b */
        final /* synthetic */ OutputStream f825b;

        C1013a(Timeout timeout, OutputStream outputStream) {
            this.f824a = timeout;
            this.f825b = outputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            Util.m58867a(buffer.f805b, 0L, j);
            while (j > 0) {
                this.f824a.mo58869e();
                Segment segment = buffer.f804a;
                int min = (int) Math.min(j, segment.f837c - segment.f836b);
                this.f825b.write(segment.f835a, segment.f836b, min);
                int i = segment.f836b + min;
                segment.f836b = i;
                long j2 = min;
                j -= j2;
                buffer.f805b -= j2;
                if (i == segment.f837c) {
                    buffer.f804a = segment.m58895b();
                    SegmentPool.m58892a(segment);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f825b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
        public void flush() throws IOException {
            this.f825b.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: t */
        public Timeout mo58560t() {
            return this.f824a;
        }

        public String toString() {
            return "sink(" + this.f825b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1014b implements Source {

        /* renamed from: a */
        final /* synthetic */ Timeout f826a;

        /* renamed from: b */
        final /* synthetic */ InputStream f827b;

        C1014b(Timeout timeout, InputStream inputStream) {
            this.f826a = timeout;
            this.f827b = inputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
                return 0L;
            } else {
                try {
                    this.f826a.mo58869e();
                    Segment m58953b = buffer.m58953b(1);
                    int read = this.f827b.read(m58953b.f835a, m58953b.f837c, (int) Math.min(j, 8192 - m58953b.f837c));
                    if (read == -1) {
                        return -1L;
                    }
                    m58953b.f837c += read;
                    long j2 = read;
                    buffer.f805b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (Okio.m58922a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f827b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return this.f826a;
        }

        public String toString() {
            return "source(" + this.f827b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1015c extends AsyncTimeout {

        /* renamed from: k */
        final /* synthetic */ Socket f828k;

        C1015c(Socket socket) {
            this.f828k = socket;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout
        /* renamed from: b */
        protected IOException mo58554b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout
        /* renamed from: i */
        protected void mo58553i() {
            try {
                this.f828k.close();
            } catch (AssertionError e) {
                if (Okio.m58922a(e)) {
                    Logger logger = Okio.f823a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.f828k, (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                Logger logger2 = Okio.f823a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.f828k, (Throwable) e2);
            }
        }
    }

    private Okio() {
    }

    /* renamed from: a */
    public static BufferedSource m58926a(Source source) {
        return new RealBufferedSource(source);
    }

    /* renamed from: b */
    public static Source m58920b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                AsyncTimeout m58919c = m58919c(socket);
                return m58919c.m58975a(m58924a(socket.getInputStream(), m58919c));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: c */
    private static AsyncTimeout m58919c(Socket socket) {
        return new C1015c(socket);
    }

    /* renamed from: a */
    public static BufferedSink m58927a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    /* renamed from: a */
    private static Sink m58923a(OutputStream outputStream, Timeout timeout) {
        if (outputStream != null) {
            if (timeout != null) {
                return new C1013a(timeout, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public static Sink m58921a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                AsyncTimeout m58919c = m58919c(socket);
                return m58919c.m58976a(m58923a(socket.getOutputStream(), m58919c));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: a */
    public static Source m58925a(InputStream inputStream) {
        return m58924a(inputStream, new Timeout());
    }

    /* renamed from: a */
    private static Source m58924a(InputStream inputStream, Timeout timeout) {
        if (inputStream != null) {
            if (timeout != null) {
                return new C1014b(timeout, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: a */
    static boolean m58922a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
