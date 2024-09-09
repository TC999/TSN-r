package cn.jiguang.ca;

import cn.jiguang.bq.d;
import cn.jiguang.bx.f;
import cn.jiguang.f.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private final int f3225j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f3226k = ByteBuffer.allocate(8192);

    public c(int i4, int i5) {
        this.f3225j = i4;
        this.f3211f = i5;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                d.k("NioSocketClient", "send error -tcp connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int write = this.f3207b.write(ByteBuffer.wrap(bArr));
                if (write > 0) {
                    d.a("NioSocketClient", "isWritable has send len:" + write);
                    return true;
                } else if (write < 0) {
                    d.a("NioSocketClient", "isWritable error:" + write);
                    return false;
                } else {
                    return true;
                }
            }
            d.c("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e4) {
            d.j("NioSocketClient", "send data error:" + e4);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.ca.a
    public synchronized int a(String str, int i4) {
        super.a(str, i4);
        this.f3207b = SocketChannel.open();
        this.f3209d = Selector.open();
        this.f3207b.configureBlocking(false);
        this.f3207b.connect(new InetSocketAddress(str, i4));
        d.c("NioSocketClient", "tcp connecting...");
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f3207b.finishConnect()) {
            if (!this.f3210e) {
                d.c("NioSocketClient", "has close channel when connect...");
                return -991;
            }
            Thread.sleep(10L);
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                close();
                return -994;
            }
        }
        if (!this.f3210e) {
            d.c("NioSocketClient", "has close channel when connected...");
            return -991;
        }
        d.c("NioSocketClient", "tcp connected [" + str + ":" + i4 + "]");
        this.f3207b.register(this.f3209d, 1);
        return 0;
    }

    @Override // cn.jiguang.ca.a
    public synchronized int a(byte[] bArr) {
        if (bArr == null) {
            d.i("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        d.c("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.f3225j) {
            return b(bArr) ? 0 : 103;
        }
        d.i("NioSocketClient", "sendData failed, data length must less than " + this.f3225j);
        return 6026;
    }

    @Override // cn.jiguang.ca.a
    public ByteBuffer a(int i4) {
        ByteBuffer b4;
        try {
            if (b()) {
                int c4 = c();
                if (c4 <= 0 || (b4 = b(c4)) == null) {
                    int i5 = 0;
                    int i6 = 1048576;
                    while (b() && this.f3208c < i6) {
                        int select = i4 > 0 ? this.f3209d.select(i4) : this.f3209d.select();
                        if (select == 0) {
                            d.c("NioSocketClient", "readSelect:" + select + ",time out:" + i4);
                            if (i4 > 0) {
                                throw new f(-994, "recv time out");
                            }
                        } else {
                            Iterator<SelectionKey> it = this.f3209d.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.f3226k);
                                    if (read < 0) {
                                        throw new f(-996, "read len < 0:" + read);
                                    }
                                    this.f3226k.flip();
                                    int limit = this.f3226k.limit();
                                    if (this.f3206a.remaining() < limit) {
                                        throw new f(-996, "the total buf remaining less than readLen,remaining:" + this.f3206a.remaining() + ",readLen:" + limit);
                                    }
                                    this.f3206a.put(this.f3226k);
                                    this.f3208c += limit;
                                    this.f3226k.compact();
                                    if (this.f3208c < this.f3211f) {
                                        d.c("NioSocketClient", "totalbuf can not parse head:" + this.f3208c + ",peerNetData len:" + limit + ",read:" + read);
                                    } else {
                                        i6 = c();
                                    }
                                    i5 = limit;
                                } else {
                                    next.isWritable();
                                }
                                it.remove();
                            }
                            continue;
                        }
                    }
                    if (i6 != 1048576) {
                        d.c("NioSocketClient", "read len:" + i5 + ",recvTotalLen:" + this.f3208c + ",shouldLen:" + i6);
                        ByteBuffer b5 = b(i6);
                        if (b5 != null) {
                            return b5;
                        }
                        throw new f(-1001, "parse error");
                    }
                    throw new f(-997, "recv empty data or tcp has close");
                }
                return b4;
            }
            throw new f(-991, "recv error,the connect is invalid");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new f(-994, th.getMessage());
            }
            if (th instanceof f) {
                throw th;
            }
            throw new f(-997, th.getMessage());
        }
    }

    @Override // cn.jiguang.ca.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.f3209d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        i.a(this.f3207b);
        this.f3207b = null;
    }
}
