package master.flame.danmaku.danmaku.model.android;

import android.os.Build;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: master.flame.danmaku.danmaku.model.android.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CachingPolicy {

    /* renamed from: h */
    public static final int f43766h = 16;

    /* renamed from: i */
    public static final int f43767i = 32;

    /* renamed from: j */
    public static final int f43768j = 0;

    /* renamed from: k */
    public static final int f43769k = -1;

    /* renamed from: l */
    public static final CachingPolicy f43770l;

    /* renamed from: m */
    public static final CachingPolicy f43771m;

    /* renamed from: n */
    public static final CachingPolicy f43772n;

    /* renamed from: a */
    public int f43773a;

    /* renamed from: b */
    public float f43774b;

    /* renamed from: c */
    public long f43775c;

    /* renamed from: d */
    public float f43776d;

    /* renamed from: e */
    public int f43777e;

    /* renamed from: f */
    public int f43778f = 20;

    /* renamed from: g */
    public int f43779g = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;

    static {
        CachingPolicy cachingPolicy = new CachingPolicy(16, 0.3f, 0L, 50, 0.01f);
        f43770l = cachingPolicy;
        f43771m = new CachingPolicy(16, 0.5f, -1L, 50, 0.005f);
        f43772n = cachingPolicy;
    }

    public CachingPolicy(int i, float f, long j, int i2, float f2) {
        this.f43774b = 0.3f;
        this.f43775c = 0L;
        this.f43776d = 0.01f;
        this.f43777e = 0;
        this.f43773a = i;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f43773a = 32;
        }
        this.f43774b = f;
        this.f43775c = j;
        this.f43777e = i2;
        this.f43776d = f2;
    }
}
