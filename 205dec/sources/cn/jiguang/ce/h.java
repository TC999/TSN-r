package cn.jiguang.ce;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Date f3351a;

    /* renamed from: b  reason: collision with root package name */
    private Date f3352b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f3353c;

    /* renamed from: d  reason: collision with root package name */
    private final UUID f3354d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f3355e;

    /* renamed from: f  reason: collision with root package name */
    private a f3356f;

    /* renamed from: g  reason: collision with root package name */
    private Long f3357g;

    /* renamed from: h  reason: collision with root package name */
    private Double f3358h;

    /* renamed from: i  reason: collision with root package name */
    private final String f3359i;

    /* renamed from: j  reason: collision with root package name */
    private String f3360j;

    /* renamed from: k  reason: collision with root package name */
    private final String f3361k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f3362l;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public enum a {
        Ok,
        Exited,
        Crashed
    }

    public h() {
        this(a.Ok, cn.jiguang.f.b.c(), cn.jiguang.f.b.c(), 0, UUID.randomUUID(), Boolean.TRUE, null, null, null, null, "production");
    }

    public h(a aVar, Date date, Date date2, int i4, UUID uuid, Boolean bool, Long l4, Double d4, String str, String str2, String str3) {
        this.f3362l = new Object();
        this.f3356f = aVar;
        this.f3351a = date;
        this.f3352b = date2;
        this.f3353c = new AtomicInteger(i4);
        this.f3354d = uuid;
        this.f3355e = bool;
        this.f3357g = l4;
        this.f3358h = d4;
        this.f3359i = str;
        this.f3360j = str2;
        this.f3361k = str3;
    }

    private double b(Date date) {
        double abs = Math.abs(date.getTime() - this.f3351a.getTime());
        Double.isNaN(abs);
        return abs / 1000.0d;
    }

    private long c(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Date a() {
        Date date = this.f3351a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public void a(Date date) {
        synchronized (this.f3362l) {
            this.f3355e = null;
            if (this.f3356f == a.Ok) {
                this.f3356f = a.Exited;
            }
            if (date == null) {
                date = cn.jiguang.f.b.c();
            }
            this.f3352b = date;
            Date date2 = this.f3352b;
            if (date2 != null) {
                this.f3358h = Double.valueOf(b(date2));
                this.f3357g = Long.valueOf(c(this.f3352b));
            }
        }
    }

    public boolean a(a aVar, String str, boolean z3) {
        boolean z4;
        synchronized (this.f3362l) {
            boolean z5 = false;
            z4 = true;
            if (aVar != null) {
                try {
                    this.f3356f = aVar;
                    z5 = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                this.f3360j = str;
                z5 = true;
            }
            if (z3) {
                this.f3353c.addAndGet(1);
            } else {
                z4 = z5;
            }
            if (z4) {
                this.f3355e = null;
                Date c4 = cn.jiguang.f.b.c();
                this.f3352b = c4;
                if (c4 != null) {
                    this.f3357g = Long.valueOf(c(c4));
                }
            }
        }
        return z4;
    }

    public UUID b() {
        return this.f3354d;
    }

    public Boolean c() {
        return this.f3355e;
    }

    public int d() {
        return this.f3353c.get();
    }

    public a e() {
        return this.f3356f;
    }

    public Long f() {
        return this.f3357g;
    }

    public Double g() {
        return this.f3358h;
    }

    public Date h() {
        Date date = this.f3352b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void i() {
        a(cn.jiguang.f.b.c());
    }

    /* renamed from: j */
    public h clone() {
        return new h(this.f3356f, this.f3351a, this.f3352b, this.f3353c.get(), this.f3354d, this.f3355e, this.f3357g, this.f3358h, this.f3359i, this.f3360j, this.f3361k);
    }
}
