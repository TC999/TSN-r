package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakuTimer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f61172a;

    /* renamed from: b  reason: collision with root package name */
    private long f61173b;

    public f() {
    }

    public long a(long j4) {
        return update(this.f61172a + j4);
    }

    public long b() {
        return this.f61173b;
    }

    public long update(long j4) {
        long j5 = j4 - this.f61172a;
        this.f61173b = j5;
        this.f61172a = j4;
        return j5;
    }

    public f(long j4) {
        update(j4);
    }
}
