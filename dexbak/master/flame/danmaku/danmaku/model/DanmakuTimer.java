package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuTimer {

    /* renamed from: a */
    public long f43885a;

    /* renamed from: b */
    private long f43886b;

    public DanmakuTimer() {
    }

    /* renamed from: a */
    public long m3070a(long j) {
        return update(this.f43885a + j);
    }

    /* renamed from: b */
    public long m3069b() {
        return this.f43886b;
    }

    public long update(long j) {
        long j2 = j - this.f43885a;
        this.f43886b = j2;
        this.f43885a = j;
        return j2;
    }

    public DanmakuTimer(long j) {
        update(j);
    }
}
