package cn.jiguang.bz;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f3176a;

    /* renamed from: b  reason: collision with root package name */
    public int f3177b;

    /* renamed from: c  reason: collision with root package name */
    public int f3178c;

    /* renamed from: d  reason: collision with root package name */
    public int f3179d;

    /* renamed from: e  reason: collision with root package name */
    private final c f3180e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f3181f;

    /* renamed from: g  reason: collision with root package name */
    private int f3182g;

    /* renamed from: h  reason: collision with root package name */
    private String f3183h;

    /* renamed from: i  reason: collision with root package name */
    private String f3184i;

    public d(c cVar, ByteBuffer byteBuffer) {
        this.f3180e = cVar;
        if (byteBuffer == null) {
            cn.jiguang.bq.d.i("LoginResponse", "No body to parse.");
            return;
        }
        this.f3181f = byteBuffer;
        a();
    }

    private void a() {
        try {
            this.f3176a = this.f3181f.getShort();
        } catch (Throwable unused) {
            this.f3176a = 10000;
        }
        if (this.f3176a > 0) {
            cn.jiguang.bq.d.l("LoginResponse", "Response error - code:" + this.f3176a);
        }
        ByteBuffer byteBuffer = this.f3181f;
        this.f3179d = -1;
        int i4 = this.f3176a;
        if (i4 != 0) {
            if (i4 == 1012) {
                try {
                    this.f3184i = b.a(byteBuffer);
                } catch (Throwable unused2) {
                    this.f3176a = 10000;
                }
                cn.jiguang.bu.a.a(JCoreManager.getAppContext(null), this.f3184i);
                return;
            }
            return;
        }
        try {
            this.f3177b = byteBuffer.getInt();
            this.f3182g = byteBuffer.getShort();
            this.f3183h = b.a(byteBuffer);
            this.f3178c = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.f3176a = 10000;
        }
        try {
            this.f3179d = byteBuffer.get();
            cn.jiguang.bq.d.c("LoginResponse", "idc parse success, value:" + this.f3179d);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("LoginResponse", "parse idc failed, error:" + th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.f3176a + ",sid:" + this.f3177b + ", serverVersion:" + this.f3182g + ", sessionKey:" + this.f3183h + ", serverTime:" + this.f3178c + ", idc:" + this.f3179d + ", connectInfo:" + this.f3184i;
    }
}
