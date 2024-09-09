package cn.jiguang.ca;

import cn.jiguang.bk.h;
import cn.jiguang.bq.d;
import cn.jiguang.bx.f;
import cn.jiguang.f.i;
import cn.jiguang.net.SSLTrustManager;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.security.SecureRandom;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends a {

    /* renamed from: j  reason: collision with root package name */
    protected SSLContext f3215j;

    /* renamed from: k  reason: collision with root package name */
    private SSLEngine f3216k;

    /* renamed from: l  reason: collision with root package name */
    private ByteBuffer f3217l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f3218m;

    /* renamed from: n  reason: collision with root package name */
    private ByteBuffer f3219n = ByteBuffer.allocate(8192);

    /* renamed from: o  reason: collision with root package name */
    private ByteBuffer f3220o;

    /* renamed from: p  reason: collision with root package name */
    private final int f3221p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3222q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jiguang.ca.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3223a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3224b;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            f3224b = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3224b[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3224b[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3224b[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3224b[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[SSLEngineResult.Status.values().length];
            f3223a = iArr2;
            try {
                iArr2[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3223a[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3223a[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3223a[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public b(int i4, int i5) {
        this.f3221p = i4;
        this.f3211f = i5;
    }

    private int a(SocketChannel socketChannel, SSLEngine sSLEngine) {
        this.f3220o.clear();
        int read = socketChannel.read(this.f3219n);
        if (read < 0) {
            cn.jiguang.ck.a.a().a(12);
            throw new f(-996, "read len < 0: " + read);
        }
        while (this.f3219n.hasRemaining()) {
            try {
                this.f3219n.flip();
                SSLEngineResult unwrap = sSLEngine.unwrap(this.f3219n, this.f3220o);
                this.f3219n.compact();
                int i4 = AnonymousClass1.f3223a[unwrap.getStatus().ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            this.f3219n = c(sSLEngine, this.f3219n);
                            return 0;
                        } else if (i4 != 4) {
                            cn.jiguang.ck.a.a().a(11);
                            throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                        } else {
                            d.i("NioSSLSocketClient", "ssl connect need to close[" + this.f3213h + ":" + this.f3214i + "]");
                            return -1;
                        }
                    }
                    this.f3220o = b(sSLEngine, this.f3220o);
                }
            } catch (Throwable th) {
                d.i("NioSSLSocketClient", "recv data failed for unwrap net data, " + th);
                cn.jiguang.ck.a.a().a(10);
                throw new SSLException("unwrap ssl net data failed: " + th.getMessage());
            }
        }
        return 0;
    }

    private ByteBuffer a(ByteBuffer byteBuffer, int i4) {
        return i4 > byteBuffer.capacity() ? ByteBuffer.allocate(i4) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    private ByteBuffer a(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return a(byteBuffer, sSLEngine.getSession().getPacketBufferSize());
    }

    private boolean a(SocketChannel socketChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3216k.beginHandshake();
        SSLEngineResult.HandshakeStatus handshakeStatus = this.f3216k.getHandshakeStatus();
        while (this.f3210e) {
            if (System.currentTimeMillis() - currentTimeMillis > 15000) {
                d.c("NioSSLSocketClient", "ssl hand shake time out");
                cn.jiguang.ck.a.a().a(14);
                return false;
            }
            int i4 = AnonymousClass1.f3224b[handshakeStatus.ordinal()];
            if (i4 == 2) {
                handshakeStatus = e();
            } else if (i4 == 3) {
                if (socketChannel.read(this.f3219n) > 0) {
                    d.c("NioSSLSocketClient", "NEED_UNWRAP read:" + this.f3219n.toString());
                }
                this.f3219n.flip();
                handshakeStatus = f();
            } else if (i4 == 4) {
                handshakeStatus = g();
                socketChannel.write(this.f3218m);
                this.f3218m.clear();
            } else if (i4 == 5) {
                socketChannel.configureBlocking(false);
                socketChannel.register(this.f3209d, 1);
                return true;
            }
        }
        return false;
    }

    private ByteBuffer b(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return a(byteBuffer, sSLEngine.getSession().getApplicationBufferSize());
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                d.k("NioSSLSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                return c(bArr);
            }
            d.c("NioSSLSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e4) {
            d.j("NioSSLSocketClient", "send data error:" + e4.getMessage());
            close();
            return false;
        }
    }

    private ByteBuffer c(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        if (sSLEngine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer a4 = a(sSLEngine, byteBuffer);
        byteBuffer.flip();
        a4.put(byteBuffer);
        return a4;
    }

    private boolean c(byte[] bArr) {
        this.f3217l.clear();
        this.f3217l.put(bArr);
        this.f3217l.flip();
        while (this.f3217l.hasRemaining()) {
            this.f3218m.clear();
            SSLEngineResult wrap = this.f3216k.wrap(this.f3217l, this.f3218m);
            int i4 = AnonymousClass1.f3223a[wrap.getStatus().ordinal()];
            if (i4 == 1) {
                this.f3218m.flip();
                int i5 = 0;
                while (this.f3218m.hasRemaining()) {
                    i5 += this.f3207b.write(this.f3218m);
                }
                d.c("NioSSLSocketClient", "send data to server, writeLen: " + i5 + ", isRemaining: " + this.f3217l.hasRemaining());
            } else if (i4 != 2) {
                if (i4 == 3) {
                    cn.jiguang.ck.a.a().a(13);
                    throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                } else if (i4 != 4) {
                    cn.jiguang.ck.a.a().a(11);
                    throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                } else {
                    throw new Exception("connect close");
                }
            } else {
                this.f3218m = a(this.f3216k, this.f3218m);
            }
        }
        return true;
    }

    private SSLEngineResult.HandshakeStatus e() {
        Runnable delegatedTask;
        while (this.f3210e && (delegatedTask = this.f3216k.getDelegatedTask()) != null) {
            d.a("NioSSLSocketClient", "running delegated task...");
            delegatedTask.run();
        }
        SSLEngineResult.HandshakeStatus handshakeStatus = this.f3216k.getHandshakeStatus();
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            d.a("NioSSLSocketClient", "handshake shouldn't need additional tasks");
        }
        return handshakeStatus;
    }

    private SSLEngineResult.HandshakeStatus f() {
        SSLEngineResult.HandshakeStatus e4;
        do {
            SSLEngineResult unwrap = this.f3216k.unwrap(this.f3219n, this.f3220o);
            e4 = e();
            if (unwrap.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW && this.f3210e && e4 == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            }
        } while (this.f3219n.remaining() > 0);
        this.f3219n.compact();
        return e4;
    }

    private SSLEngineResult.HandshakeStatus g() {
        this.f3216k.wrap(ByteBuffer.wrap("".getBytes()), this.f3218m);
        SSLEngineResult.HandshakeStatus e4 = e();
        this.f3218m.flip();
        return e4;
    }

    @Override // cn.jiguang.ca.a
    public synchronized int a(String str, int i4) {
        super.a(str, i4);
        if (!d()) {
            d.a("NioSSLSocketClient", "#unexcepted - create SSL failed");
            return -992;
        }
        d.a("NioSSLSocketClient", "tcp connecting...");
        this.f3207b = SocketChannel.open();
        this.f3209d = Selector.open();
        this.f3207b.configureBlocking(false);
        this.f3207b.connect(new InetSocketAddress(str, i4));
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f3207b.finishConnect()) {
            if (!this.f3210e) {
                d.c("NioSSLSocketClient", "has close channel when connect...");
                return -991;
            }
            Thread.sleep(10L);
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                close();
                cn.jiguang.ck.a.a().a(2);
                return -994;
            }
        }
        if (!this.f3210e) {
            d.c("NioSSLSocketClient", "has close channel when connected...");
            return -991;
        }
        d.c("NioSSLSocketClient", "begin doHandShake");
        boolean a4 = a(this.f3207b);
        this.f3222q = a4;
        if (!a4) {
            d.c("NioSSLSocketClient", "handShake failed");
            cn.jiguang.ck.a.a().a(3);
            return -992;
        }
        this.f3219n.clear();
        d.c("NioSSLSocketClient", "tcp connected [" + str + ":" + i4 + "]");
        return 0;
    }

    @Override // cn.jiguang.ca.a
    public synchronized int a(byte[] bArr) {
        if (bArr == null) {
            d.c("NioSSLSocketClient", "sendData failed, send data was null");
            return 103;
        }
        d.c("NioSSLSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.f3221p) {
            return b(bArr) ? 0 : 103;
        }
        d.c("NioSSLSocketClient", "sendData failed, data length must less than " + this.f3221p);
        return 6026;
    }

    @Override // cn.jiguang.ca.a
    public ByteBuffer a(int i4) {
        ByteBuffer b4;
        if (b()) {
            int c4 = c();
            if (c4 > 0 && (b4 = b(c4)) != null) {
                cn.jiguang.ck.a.a().a(0);
                return b4;
            }
            try {
                int i5 = 4;
                if (!b()) {
                    d.c("NioSSLSocketClient", "recv register error,the connect is invalid");
                    cn.jiguang.ck.a.a().a(4);
                    return null;
                }
                int i6 = 1048576;
                int i7 = 0;
                while (b() && this.f3208c < i6) {
                    int select = i4 > 0 ? this.f3209d.select(i4) : this.f3209d.select();
                    if (select == 0) {
                        d.c("NioSSLSocketClient", "readSelect:" + select + ", time out:" + i4);
                        if (i4 > 0) {
                            cn.jiguang.ck.a.a().a(2);
                            throw new f(-994, "recv time out");
                        }
                    } else {
                        Iterator<SelectionKey> it = this.f3209d.selectedKeys().iterator();
                        while (it.hasNext()) {
                            SelectionKey next = it.next();
                            it.remove();
                            SocketChannel socketChannel = (SocketChannel) next.channel();
                            if (!b()) {
                                d.c("NioSSLSocketClient", "tcp connect has set false in select key");
                                cn.jiguang.ck.a.a().a(i5);
                                return null;
                            }
                            if (!next.isReadable()) {
                                next.isWritable();
                            } else if (this.f3216k.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                                continue;
                            } else {
                                int a4 = a(socketChannel, this.f3216k);
                                if (a4 != 0) {
                                    next.cancel();
                                    return null;
                                }
                                this.f3220o.flip();
                                i7 = this.f3220o.limit();
                                if (this.f3206a.remaining() < i7) {
                                    cn.jiguang.ck.a.a().a(5);
                                    throw new f(-996, "the total buf remaining less than readLen,remaining:" + this.f3206a.remaining() + ",readLen:" + i7);
                                }
                                this.f3206a.put(this.f3220o);
                                this.f3208c += i7;
                                this.f3220o.compact();
                                if (this.f3208c < this.f3211f) {
                                    cn.jiguang.ck.a.a().a(6);
                                    d.c("NioSSLSocketClient", "totalbuf can not parse head:" + this.f3208c + ",peerNetData len:" + i7 + ",read:" + a4);
                                } else {
                                    i6 = c();
                                }
                            }
                            i5 = 4;
                        }
                        continue;
                    }
                }
                if (i6 == 1048576) {
                    cn.jiguang.ck.a.a().a(9);
                    throw new f(-997, "recv empty data or tcp has close");
                }
                d.c("NioSSLSocketClient", "read len:" + i7 + ",recvTotalLen:" + this.f3208c + ",shouldLen:" + i6);
                ByteBuffer b5 = b(i6);
                if (b5 != null) {
                    cn.jiguang.ck.a.a().a(0);
                    return b5;
                }
                cn.jiguang.ck.a.a().a(8);
                throw new f(-1001, "parse error");
            } catch (Throwable th) {
                if (th instanceof SocketTimeoutException) {
                    cn.jiguang.ck.a.a().a(2);
                    throw new f(-994, th.getMessage());
                } else if (th instanceof f) {
                    throw th;
                } else {
                    cn.jiguang.ck.a.a().a(7);
                    throw new f(-997, th.getMessage());
                }
            }
        }
        throw new f(-991, "recv error,the connect is invalid");
    }

    @Override // cn.jiguang.ca.a
    public boolean b() {
        return super.b() && this.f3222q;
    }

    @Override // cn.jiguang.ca.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.a("NioSSLSocketClient", "close this connect...");
        super.close();
        ByteBuffer byteBuffer = this.f3217l;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f3218m;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = this.f3220o;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
        }
        ByteBuffer byteBuffer4 = this.f3219n;
        if (byteBuffer4 != null) {
            byteBuffer4.clear();
        }
        Selector selector = this.f3209d;
        if (selector != null) {
            try {
                selector.close();
            } catch (Exception e4) {
                d.c("NioSSLSocketClient", "selector close error\uff1a" + e4.getMessage());
            }
        }
        i.a(this.f3207b);
        this.f3207b = null;
        d.a("NioSSLSocketClient", "tcp has closed");
    }

    protected boolean d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            this.f3215j = sSLContext;
            sSLContext.init(null, new TrustManager[]{new SSLTrustManager(h.a())}, new SecureRandom());
            SSLEngine createSSLEngine = this.f3215j.createSSLEngine();
            this.f3216k = createSSLEngine;
            createSSLEngine.setUseClientMode(true);
            SSLSession session = this.f3216k.getSession();
            int applicationBufferSize = session.getApplicationBufferSize();
            int packetBufferSize = session.getPacketBufferSize();
            this.f3220o = ByteBuffer.allocate(applicationBufferSize + 10);
            this.f3219n = ByteBuffer.allocate(packetBufferSize);
            this.f3217l = ByteBuffer.allocate(packetBufferSize);
            this.f3218m = ByteBuffer.allocate(packetBufferSize);
            d.a("NioSSLSocketClient", "application size:" + session.getApplicationBufferSize() + ",package size:" + session.getPacketBufferSize());
            return true;
        } catch (Throwable th) {
            cn.jiguang.ck.a.a().a(1);
            d.j("NioSSLSocketClient", "NioSSLSocketClient create ssl error, cur time is:" + System.currentTimeMillis() + ",error:" + th);
            return false;
        }
    }
}
