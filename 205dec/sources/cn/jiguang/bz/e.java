package cn.jiguang.bz;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f3185a;

    /* renamed from: b  reason: collision with root package name */
    public long f3186b;

    /* renamed from: c  reason: collision with root package name */
    public String f3187c;

    /* renamed from: d  reason: collision with root package name */
    public String f3188d;

    /* renamed from: e  reason: collision with root package name */
    public String f3189e;

    /* renamed from: f  reason: collision with root package name */
    private final c f3190f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f3191g;

    /* renamed from: h  reason: collision with root package name */
    private String f3192h;

    /* renamed from: i  reason: collision with root package name */
    private String f3193i;

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f3190f = cVar;
        if (byteBuffer == null) {
            cn.jiguang.bq.d.i("RegisterResponse", "No body to parse.");
            return;
        }
        this.f3191g = byteBuffer;
        a();
    }

    private void a() {
        try {
            this.f3185a = this.f3191g.getShort();
        } catch (Throwable unused) {
            this.f3185a = 10000;
        }
        if (this.f3185a > 0) {
            cn.jiguang.bq.d.l("RegisterResponse", "Response error - code:" + this.f3185a);
        }
        ByteBuffer byteBuffer = this.f3191g;
        int i4 = this.f3185a;
        try {
            if (i4 == 0) {
                this.f3186b = byteBuffer.getLong();
                this.f3187c = b.a(byteBuffer);
                this.f3188d = b.a(byteBuffer);
            } else if (i4 != 1007) {
                if (i4 == 1012) {
                    try {
                        this.f3193i = b.a(byteBuffer);
                    } catch (Throwable unused2) {
                        this.f3185a = 10000;
                    }
                    cn.jiguang.bu.a.a(JCoreManager.getAppContext(null), this.f3193i);
                }
            } else {
                this.f3192h = b.a(byteBuffer);
            }
        } catch (Throwable unused3) {
            this.f3185a = 10000;
        }
    }

    public String toString() {
        return "[RegisterResponse] - code:" + this.f3185a + ", juid:" + this.f3186b + ", password:" + this.f3187c + ", regId:" + this.f3188d + ", deviceId:" + this.f3189e + ", connectInfo:" + this.f3193i;
    }
}
