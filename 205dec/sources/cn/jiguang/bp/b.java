package cn.jiguang.bp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private long f2812b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2811a = false;

    /* renamed from: c  reason: collision with root package name */
    private long f2813c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j4) {
        this.f2812b = j4;
    }

    public long a() {
        return this.f2813c;
    }

    public void a(boolean z3, long j4) {
        if (this.f2811a == z3) {
            return;
        }
        this.f2811a = z3;
        if (z3) {
            this.f2813c = (this.f2813c + j4) - this.f2812b;
        }
        this.f2812b = j4;
    }
}
