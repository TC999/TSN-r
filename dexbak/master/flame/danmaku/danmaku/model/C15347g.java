package master.flame.danmaku.danmaku.model;

/* compiled from: Duration.java */
/* renamed from: master.flame.danmaku.danmaku.model.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15347g {

    /* renamed from: a */
    private long f43887a;

    /* renamed from: b */
    private float f43888b = 1.0f;

    /* renamed from: c */
    public long f43889c;

    public C15347g(long j) {
        this.f43887a = j;
        this.f43889c = j;
    }

    /* renamed from: a */
    public void m3068a(float f) {
        if (this.f43888b != f) {
            this.f43888b = f;
            this.f43889c = ((float) this.f43887a) * f;
        }
    }

    /* renamed from: b */
    public void m3067b(long j) {
        this.f43887a = j;
        this.f43889c = ((float) j) * this.f43888b;
    }
}
