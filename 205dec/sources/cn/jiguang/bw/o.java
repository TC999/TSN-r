package cn.jiguang.bw;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    protected long f3078a;

    /* renamed from: b  reason: collision with root package name */
    protected SelectionKey f3079b;

    public o(long j4) {
        Selector selector;
        SocketChannel open = SocketChannel.open();
        this.f3078a = j4;
        try {
            selector = Selector.open();
        } catch (Throwable th) {
            th = th;
            selector = null;
        }
        try {
            open.configureBlocking(false);
            this.f3079b = open.register(selector, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selector != null) {
                selector.close();
            }
            open.close();
            throw th;
        }
    }

    protected static void a(SelectionKey selectionKey, long j4) {
        long currentTimeMillis = j4 - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    private byte[] a(int i4) {
        SocketChannel socketChannel = (SocketChannel) this.f3079b.channel();
        byte[] bArr = new byte[i4];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f3079b.interestOps(1);
        int i5 = 0;
        while (i5 < i4) {
            try {
                if (this.f3079b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i5 += (int) read;
                    if (i5 < i4 && System.currentTimeMillis() > this.f3078a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f3079b, this.f3078a);
                }
            } finally {
                if (this.f3079b.isValid()) {
                    this.f3079b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j4) {
        o oVar = new o(j4);
        if (socketAddress != null) {
            try {
                oVar.a(socketAddress);
            } finally {
                oVar.b();
            }
        }
        oVar.b(socketAddress2);
        oVar.a(bArr);
        return oVar.a();
    }

    void a(SocketAddress socketAddress) {
        ((SocketChannel) this.f3079b.channel()).socket().bind(socketAddress);
    }

    void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f3079b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.f3079b.interestOps(4);
        int i4 = 0;
        while (i4 < bArr.length + 2) {
            try {
                if (this.f3079b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i4 += (int) write;
                    if (i4 < bArr.length + 2 && System.currentTimeMillis() > this.f3078a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f3079b, this.f3078a);
                }
            } finally {
                if (this.f3079b.isValid()) {
                    this.f3079b.interestOps(0);
                }
            }
        }
    }

    byte[] a() {
        byte[] a4 = a(2);
        byte[] a5 = a(((a4[0] & 255) << 8) + (a4[1] & 255));
        SocketChannel socketChannel = (SocketChannel) this.f3079b.channel();
        return a5;
    }

    void b() {
        this.f3079b.selector().close();
        this.f3079b.channel().close();
    }

    void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f3079b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f3079b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f3079b.isConnectable()) {
                    a(this.f3079b, this.f3078a);
                }
            } finally {
                if (this.f3079b.isValid()) {
                    this.f3079b.interestOps(0);
                }
            }
        }
    }
}
