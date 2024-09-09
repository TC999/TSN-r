package master.flame.danmaku.danmaku.model.android;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CachingPolicy.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final int f61074h = 16;

    /* renamed from: i  reason: collision with root package name */
    public static final int f61075i = 32;

    /* renamed from: j  reason: collision with root package name */
    public static final int f61076j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f61077k = -1;

    /* renamed from: l  reason: collision with root package name */
    public static final c f61078l;

    /* renamed from: m  reason: collision with root package name */
    public static final c f61079m;

    /* renamed from: n  reason: collision with root package name */
    public static final c f61080n;

    /* renamed from: a  reason: collision with root package name */
    public int f61081a;

    /* renamed from: b  reason: collision with root package name */
    public float f61082b;

    /* renamed from: c  reason: collision with root package name */
    public long f61083c;

    /* renamed from: d  reason: collision with root package name */
    public float f61084d;

    /* renamed from: e  reason: collision with root package name */
    public int f61085e;

    /* renamed from: f  reason: collision with root package name */
    public int f61086f = 20;

    /* renamed from: g  reason: collision with root package name */
    public int f61087g = 150;

    static {
        c cVar = new c(16, 0.3f, 0L, 50, 0.01f);
        f61078l = cVar;
        f61079m = new c(16, 0.5f, -1L, 50, 0.005f);
        f61080n = cVar;
    }

    public c(int i4, float f4, long j4, int i5, float f5) {
        this.f61082b = 0.3f;
        this.f61083c = 0L;
        this.f61084d = 0.01f;
        this.f61085e = 0;
        this.f61081a = i4;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f61081a = 32;
        }
        this.f61082b = f4;
        this.f61083c = j4;
        this.f61085e = i5;
        this.f61084d = f5;
    }
}
