package com.p521ss.android.socialbase.downloader.network;

import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.ss.android.socialbase.downloader.network.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12636r {

    /* renamed from: ok */
    private static final String f35604ok = "r";

    /* renamed from: a */
    private final C12640s f35605a;

    /* renamed from: bl */
    private volatile boolean f35606bl;

    /* renamed from: h */
    private int f35607h;

    /* renamed from: kf */
    private final ArrayList<InterfaceC12638a> f35608kf;

    /* renamed from: n */
    private AtomicReference<EnumC12621j> f35609n;

    /* renamed from: s */
    private final AtomicReference<EnumC12621j> f35610s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.network.r$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C126371 {

        /* renamed from: ok */
        static final /* synthetic */ int[] f35611ok;

        static {
            int[] iArr = new int[EnumC12621j.values().length];
            f35611ok = iArr;
            try {
                iArr[EnumC12621j.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35611ok[EnumC12621j.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35611ok[EnumC12621j.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35611ok[EnumC12621j.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.r$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12638a {
        /* renamed from: ok */
        void m16901ok(EnumC12621j enumC12621j);
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.r$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12639ok {

        /* renamed from: ok */
        public static final C12636r f35612ok = new C12636r(null);
    }

    /* synthetic */ C12636r(C126371 c126371) {
        this();
    }

    /* renamed from: bl */
    private boolean m16906bl() {
        if (this.f35605a == null) {
            return false;
        }
        try {
            int i = C126371.f35611ok[this.f35610s.get().ordinal()];
            double d = 2000.0d;
            double d2 = 550.0d;
            if (i == 1) {
                d2 = 0.0d;
                d = 150.0d;
            } else if (i == 2) {
                d = 550.0d;
                d2 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d = 3.4028234663852886E38d;
                d2 = 2000.0d;
            }
            double m16900ok = this.f35605a.m16900ok();
            if (m16900ok > d) {
                if (m16900ok > d * 1.25d) {
                    return true;
                }
            } else if (m16900ok < d2 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: ok */
    public static C12636r m16905ok() {
        return C12639ok.f35612ok;
    }

    /* renamed from: s */
    private void m16902s() {
        try {
            int size = this.f35608kf.size();
            for (int i = 0; i < size; i++) {
                this.f35608kf.get(i).m16901ok(this.f35610s.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized EnumC12621j m16907a() {
        C12640s c12640s = this.f35605a;
        if (c12640s == null) {
            return EnumC12621j.UNKNOWN;
        }
        return m16904ok(c12640s.m16900ok());
    }

    private C12636r() {
        this.f35605a = new C12640s(0.05d);
        this.f35606bl = false;
        this.f35610s = new AtomicReference<>(EnumC12621j.UNKNOWN);
        this.f35608kf = new ArrayList<>();
    }

    /* renamed from: ok */
    public synchronized void m16903ok(long j, long j2) {
        EnumC12621j m16907a;
        double d = j;
        Double.isNaN(d);
        double d2 = j2;
        Double.isNaN(d2);
        double d3 = ((d * 1.0d) / d2) * 8.0d;
        if (j2 == 0 || d3 < 3.0d) {
            return;
        }
        try {
            this.f35605a.m16899ok(d3);
            m16907a = m16907a();
        } catch (Throwable unused) {
        }
        if (this.f35606bl) {
            this.f35607h++;
            if (m16907a != this.f35609n.get()) {
                this.f35606bl = false;
                this.f35607h = 1;
            }
            if (this.f35607h >= 5.0d && m16906bl()) {
                this.f35606bl = false;
                this.f35607h = 1;
                this.f35610s.set(this.f35609n.get());
                m16902s();
            }
            return;
        }
        if (this.f35610s.get() != m16907a) {
            this.f35606bl = true;
            this.f35609n = new AtomicReference<>(m16907a);
        }
    }

    /* renamed from: ok */
    private EnumC12621j m16904ok(double d) {
        if (d < Utils.DOUBLE_EPSILON) {
            return EnumC12621j.UNKNOWN;
        }
        if (d < 150.0d) {
            return EnumC12621j.POOR;
        }
        if (d < 550.0d) {
            return EnumC12621j.MODERATE;
        }
        if (d < 2000.0d) {
            return EnumC12621j.GOOD;
        }
        return EnumC12621j.EXCELLENT;
    }
}
