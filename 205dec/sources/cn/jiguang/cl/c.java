package cn.jiguang.cl;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    int f3449a;

    /* renamed from: b  reason: collision with root package name */
    int f3450b;

    /* renamed from: c  reason: collision with root package name */
    int f3451c;

    /* renamed from: d  reason: collision with root package name */
    Long f3452d;

    /* renamed from: e  reason: collision with root package name */
    int f3453e;

    /* renamed from: f  reason: collision with root package name */
    long f3454f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3455g;

    public c(boolean z3, int i4, int i5, int i6, long j4, int i7, long j5) {
        this.f3455g = z3;
        this.f3449a = i4;
        this.f3450b = i5;
        this.f3451c = i6;
        this.f3452d = Long.valueOf(j4);
        this.f3453e = i7;
        this.f3454f = j5;
    }

    public c(boolean z3, int i4, int i5, long j4) {
        this(z3, 0, i4, i5, j4, 0, 0L);
    }

    public c(boolean z3, byte[] bArr) {
        this.f3455g = z3;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f3449a = wrap.getShort() & Short.MAX_VALUE;
        this.f3450b = wrap.get();
        this.f3451c = wrap.get();
        Long valueOf = Long.valueOf(wrap.getLong());
        this.f3452d = valueOf;
        this.f3452d = Long.valueOf(valueOf.longValue() & 65535);
        if (z3) {
            this.f3453e = wrap.getInt();
        }
        this.f3454f = wrap.getLong();
    }

    public int a() {
        return this.f3451c;
    }

    public void a(int i4) {
        this.f3449a = i4;
    }

    public void a(long j4) {
        this.f3454f = j4;
    }

    public Long b() {
        return this.f3452d;
    }

    public void b(int i4) {
        this.f3453e = i4;
    }

    public long c() {
        return this.f3454f;
    }

    public int d() {
        return this.f3453e;
    }

    public int e() {
        return this.f3450b;
    }

    public byte[] f() {
        if (this.f3449a != 0) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.putShort((short) this.f3449a);
            allocate.put((byte) this.f3450b);
            allocate.put((byte) this.f3451c);
            allocate.putLong(this.f3452d.longValue());
            if (this.f3455g) {
                allocate.putInt(this.f3453e);
            }
            allocate.putLong(this.f3454f);
            allocate.flip();
            return ProtocolUtil.getBytesConsumed(allocate);
        }
        throw new IllegalStateException("The head is not initialized yet.");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f3449a);
        sb.append(", version:");
        sb.append(this.f3450b);
        sb.append(", command:");
        sb.append(this.f3451c);
        sb.append(", rid:");
        sb.append(this.f3452d);
        if (this.f3455g) {
            str = ", sid:" + this.f3453e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f3454f);
        return sb.toString();
    }
}
