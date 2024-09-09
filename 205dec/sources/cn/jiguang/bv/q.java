package cn.jiguang.bv;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q extends cn.jiguang.cm.b {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3012a;

    /* renamed from: b  reason: collision with root package name */
    private cn.jiguang.ca.a f3013b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3014c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(cn.jiguang.ca.a aVar, Context context, byte[] bArr) {
        this.f3014c = context;
        this.f3012a = bArr;
        this.f3462h = "TcpRecvAction";
        this.f3013b = aVar;
    }

    @Override // cn.jiguang.cm.b
    public void a() {
        try {
            cn.jiguang.bx.h.a().a(this.f3014c, "tcp_a22", null);
            cn.jiguang.bz.a.a(this.f3013b, this.f3014c, this.f3012a);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
