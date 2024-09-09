package cn.jiguang.z;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f3893a;

    /* renamed from: b  reason: collision with root package name */
    private String f3894b;

    /* renamed from: c  reason: collision with root package name */
    private int f3895c;

    /* renamed from: d  reason: collision with root package name */
    private long f3896d;

    public a a(int i4) {
        this.f3895c = i4;
        return this;
    }

    public a a(long j4) {
        this.f3896d = j4;
        return this;
    }

    public a a(String str) {
        this.f3893a = str;
        return this;
    }

    public String a() {
        return this.f3893a;
    }

    public a b(String str) {
        this.f3894b = str;
        return this;
    }

    public String b() {
        return this.f3894b;
    }

    public int c() {
        return this.f3895c;
    }

    public long d() {
        return this.f3896d;
    }

    public String toString() {
        return "JCollectResultInfo{\ncollectType='" + this.f3893a + "'\ncollectChildType='" + this.f3894b + "'\n, collectResultCode=" + this.f3895c + "\n, collectMillTime=" + this.f3896d + "\n}";
    }
}
