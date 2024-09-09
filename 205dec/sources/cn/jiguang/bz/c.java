package cn.jiguang.bz;

import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f3168a;

    /* renamed from: b  reason: collision with root package name */
    public int f3169b;

    /* renamed from: c  reason: collision with root package name */
    public int f3170c;

    /* renamed from: d  reason: collision with root package name */
    public byte f3171d;

    /* renamed from: e  reason: collision with root package name */
    public long f3172e;

    /* renamed from: f  reason: collision with root package name */
    public int f3173f;

    /* renamed from: g  reason: collision with root package name */
    public long f3174g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3175h;

    public c(boolean z3, byte[] bArr) {
        try {
            this.f3175h = z3;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f3168a = wrap.getShort() & Short.MAX_VALUE;
            this.f3169b = wrap.get();
            this.f3170c = wrap.get();
            this.f3171d = wrap.get();
            wrap.get();
            wrap.getInt();
            this.f3172e = wrap.getShort();
            if (z3) {
                this.f3173f = wrap.getInt();
            }
            this.f3174g = wrap.getLong();
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f3168a);
        sb.append(", version:");
        sb.append(this.f3169b);
        sb.append(", command:");
        sb.append(this.f3170c);
        sb.append(", rid:");
        sb.append(this.f3172e);
        if (this.f3175h) {
            str = ", sid:" + this.f3173f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f3174g);
        return sb.toString();
    }
}
