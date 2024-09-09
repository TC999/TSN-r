package cn.jiguang.bx;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    int f3083a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f3084b;

    /* renamed from: c  reason: collision with root package name */
    public String f3085c;

    /* renamed from: d  reason: collision with root package name */
    int f3086d;

    /* renamed from: e  reason: collision with root package name */
    int f3087e;

    /* renamed from: f  reason: collision with root package name */
    long f3088f;

    /* renamed from: g  reason: collision with root package name */
    byte[] f3089g;

    /* renamed from: h  reason: collision with root package name */
    long f3090h;

    /* renamed from: i  reason: collision with root package name */
    long f3091i;

    /* renamed from: j  reason: collision with root package name */
    boolean f3092j;

    public d(long j4, String str, int i4, int i5, long j5, long j6, byte[] bArr) {
        this.f3084b = j4;
        this.f3085c = str;
        this.f3086d = i4;
        this.f3087e = i5;
        this.f3088f = j5;
        this.f3091i = j6;
        this.f3089g = bArr;
        if (j6 > 0) {
            this.f3092j = true;
        }
    }

    public void a() {
        this.f3083a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.f3083a + ", requestId=" + this.f3084b + ", sdkType='" + this.f3085c + "', command=" + this.f3086d + ", ver=" + this.f3087e + ", rid=" + this.f3088f + ", reqeustTime=" + this.f3090h + ", timeout=" + this.f3091i + '}';
    }
}
