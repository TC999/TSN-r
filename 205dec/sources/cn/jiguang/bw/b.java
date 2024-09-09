package cn.jiguang.bw;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f3019a;

    /* renamed from: b  reason: collision with root package name */
    private int f3020b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f3021c = -1;

    public b(byte[] bArr) {
        this.f3019a = ByteBuffer.wrap(bArr);
    }

    private void c(int i4) {
        if (i4 > b()) {
            throw new IOException("end of input");
        }
    }

    public int a() {
        return this.f3019a.position();
    }

    public void a(int i4) {
        if (i4 > this.f3019a.capacity() - this.f3019a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f3019a;
        byteBuffer.limit(byteBuffer.position() + i4);
    }

    public void a(byte[] bArr, int i4, int i5) {
        c(i5);
        this.f3019a.get(bArr, i4, i5);
    }

    public int b() {
        return this.f3019a.remaining();
    }

    public void b(int i4) {
        if (i4 >= this.f3019a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f3019a.position(i4);
        ByteBuffer byteBuffer = this.f3019a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void c() {
        ByteBuffer byteBuffer = this.f3019a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d() {
        this.f3020b = this.f3019a.position();
        this.f3021c = this.f3019a.limit();
    }

    public void e() {
        int i4 = this.f3020b;
        if (i4 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f3019a.position(i4);
        this.f3019a.limit(this.f3021c);
        this.f3020b = -1;
        this.f3021c = -1;
    }

    public int f() {
        c(1);
        return this.f3019a.get() & 255;
    }

    public int g() {
        c(2);
        return this.f3019a.getShort() & 65535;
    }

    public long h() {
        c(4);
        return this.f3019a.getInt() & 4294967295L;
    }
}
