package com.bytedance.sdk.component.xv.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    static final Logger f30663c = Logger.getLogger(a.class.getName());

    private a() {
    }

    public static ux c(fz fzVar) {
        return new t(fzVar);
    }

    public static s w(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s xv(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static sr c(s sVar) {
        return new bk(sVar);
    }

    public static s c(OutputStream outputStream) {
        return c(outputStream, new u());
    }

    public static fz w(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                c xv = xv(socket);
                return xv.c(c(socket.getInputStream(), xv));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static c xv(final Socket socket) {
        return new c() { // from class: com.bytedance.sdk.component.xv.c.a.4
            @Override // com.bytedance.sdk.component.xv.c.c
            protected IOException w(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.component.xv.c.c
            protected void y_() {
                try {
                    socket.close();
                } catch (AssertionError e4) {
                    if (a.c(e4)) {
                        Logger logger = a.f30663c;
                        Level level = Level.WARNING;
                        logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e4);
                        return;
                    }
                    throw e4;
                } catch (Exception e5) {
                    Logger logger2 = a.f30663c;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e5);
                }
            }
        };
    }

    private static s c(final OutputStream outputStream, final u uVar) {
        if (outputStream != null) {
            if (uVar != null) {
                return new s() { // from class: com.bytedance.sdk.component.xv.c.a.1
                    @Override // com.bytedance.sdk.component.xv.c.s
                    public void a_(xv xvVar, long j4) throws IOException {
                        try {
                            i.c(xvVar.f30701w, 0L, j4);
                            while (j4 > 0) {
                                u.this.r();
                                ys ysVar = xvVar.f30700c;
                                int min = (int) Math.min(j4, ysVar.xv - ysVar.f30706w);
                                outputStream.write(ysVar.f30703c, ysVar.f30706w, min);
                                int i4 = ysVar.f30706w + min;
                                ysVar.f30706w = i4;
                                long j5 = min;
                                j4 -= j5;
                                xvVar.f30701w -= j5;
                                if (i4 == ysVar.xv) {
                                    xvVar.f30700c = ysVar.w();
                                    fp.c(ysVar);
                                }
                            }
                        } catch (IOException | Exception unused) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.xv.c.s
                    public u c() {
                        return u.this;
                    }

                    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static s c(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                c xv = xv(socket);
                return xv.c(c(socket.getOutputStream(), xv));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static fz c(InputStream inputStream) {
        return c(inputStream, new u());
    }

    private static fz c(final InputStream inputStream, final u uVar) {
        if (inputStream != null) {
            if (uVar != null) {
                return new fz() { // from class: com.bytedance.sdk.component.xv.c.a.2
                    @Override // com.bytedance.sdk.component.xv.c.fz
                    public long c(xv xvVar, long j4) throws IOException {
                        if (j4 < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j4);
                        } else if (j4 == 0) {
                            return 0L;
                        } else {
                            try {
                                u.this.r();
                                ys ux = xvVar.ux(1);
                                int read = inputStream.read(ux.f30703c, ux.xv, (int) Math.min(j4, 8192 - ux.xv));
                                if (read == -1) {
                                    return -1L;
                                }
                                ux.xv += read;
                                long j5 = read;
                                xvVar.f30701w += j5;
                                return j5;
                            } catch (AssertionError e4) {
                                if (a.c(e4)) {
                                    throw new IOException(e4);
                                }
                                throw e4;
                            } catch (Throwable th) {
                                throw new IOException(th.getMessage());
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }

                    @Override // com.bytedance.sdk.component.xv.c.fz
                    public u c() {
                        return u.this;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static fz c(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s c() {
        return new s() { // from class: com.bytedance.sdk.component.xv.c.a.3
            @Override // com.bytedance.sdk.component.xv.c.s
            public void a_(xv xvVar, long j4) throws IOException {
                xvVar.ev(j4);
            }

            @Override // com.bytedance.sdk.component.xv.c.s
            public u c() {
                return u.xv;
            }

            @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
