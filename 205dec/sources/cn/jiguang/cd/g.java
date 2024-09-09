package cn.jiguang.cd;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private volatile cn.jiguang.ce.h f3287a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f3288b = new Object();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final cn.jiguang.ce.h f3289a;

        /* renamed from: b  reason: collision with root package name */
        private final cn.jiguang.ce.h f3290b;

        public a(cn.jiguang.ce.h hVar, cn.jiguang.ce.h hVar2) {
            this.f3290b = hVar;
            this.f3289a = hVar2;
        }
    }

    public cn.jiguang.ce.h a() {
        cn.jiguang.ce.h clone;
        synchronized (this.f3288b) {
            clone = this.f3287a != null ? this.f3287a.clone() : null;
        }
        return clone;
    }

    public a b() {
        a aVar;
        synchronized (this.f3288b) {
            if (this.f3287a != null) {
                this.f3287a.i();
            }
            cn.jiguang.ce.h hVar = this.f3287a;
            this.f3287a = new cn.jiguang.ce.h();
            aVar = new a(this.f3287a.clone(), hVar != null ? hVar.clone() : null);
        }
        return aVar;
    }
}
