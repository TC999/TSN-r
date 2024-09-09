package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Duration.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private long f61174a;

    /* renamed from: b  reason: collision with root package name */
    private float f61175b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public long f61176c;

    public g(long j4) {
        this.f61174a = j4;
        this.f61176c = j4;
    }

    public void a(float f4) {
        if (this.f61175b != f4) {
            this.f61175b = f4;
            this.f61176c = ((float) this.f61174a) * f4;
        }
    }

    public void b(long j4) {
        this.f61174a = j4;
        this.f61176c = ((float) j4) * this.f61175b;
    }
}
