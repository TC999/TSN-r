package cn.jiguang.ca;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class a implements Closeable {

    /* renamed from: j  reason: collision with root package name */
    private static AtomicInteger f3205j = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    protected SocketChannel f3207b;

    /* renamed from: c  reason: collision with root package name */
    protected int f3208c;

    /* renamed from: d  reason: collision with root package name */
    protected Selector f3209d;

    /* renamed from: g  reason: collision with root package name */
    public int f3212g;

    /* renamed from: h  reason: collision with root package name */
    public String f3213h;

    /* renamed from: i  reason: collision with root package name */
    public int f3214i;

    /* renamed from: f  reason: collision with root package name */
    protected int f3211f = 20;

    /* renamed from: a  reason: collision with root package name */
    protected ByteBuffer f3206a = ByteBuffer.allocate(49152);

    /* renamed from: e  reason: collision with root package name */
    protected boolean f3210e = false;

    public a() {
        this.f3212g = 0;
        this.f3212g = f3205j.incrementAndGet();
    }

    public int a(String str, int i4) {
        if (this.f3206a == null) {
            this.f3206a = ByteBuffer.allocate(49152);
        }
        this.f3206a.clear();
        this.f3208c = 0;
        this.f3210e = true;
        this.f3213h = str;
        this.f3214i = i4;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public ByteBuffer a() {
        return a(0);
    }

    public abstract ByteBuffer a(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer b(int i4) {
        int i5 = this.f3208c;
        if (i5 >= i4) {
            this.f3208c = i5 - i4;
            byte[] bArr = new byte[i4];
            this.f3206a.flip();
            this.f3206a.get(bArr, 0, i4);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f3206a.compact();
            return wrap;
        }
        return null;
    }

    public boolean b() {
        SocketChannel socketChannel;
        return this.f3210e && (socketChannel = this.f3207b) != null && socketChannel.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        if (this.f3208c < this.f3211f) {
            return 0;
        }
        int position = this.f3206a.position();
        this.f3206a.position(0);
        int i4 = this.f3206a.getShort() & Short.MAX_VALUE;
        this.f3206a.position(position);
        return i4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3210e = false;
        ByteBuffer byteBuffer = this.f3206a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f3208c = 0;
    }
}
