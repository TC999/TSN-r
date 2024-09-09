package cn.jiguang.cd;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final cn.jiguang.ce.b f3281a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f3282b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread f3283c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3284d;

    public c(cn.jiguang.ce.b bVar, Throwable th, Thread thread) {
        this(bVar, th, thread, false);
    }

    public c(cn.jiguang.ce.b bVar, Throwable th, Thread thread, boolean z3) {
        this.f3281a = bVar;
        this.f3282b = th;
        this.f3283c = thread;
        this.f3284d = z3;
    }

    public cn.jiguang.ce.b a() {
        return this.f3281a;
    }

    public Throwable b() {
        return this.f3282b;
    }

    public Thread c() {
        return this.f3283c;
    }

    public boolean d() {
        return this.f3284d;
    }
}
