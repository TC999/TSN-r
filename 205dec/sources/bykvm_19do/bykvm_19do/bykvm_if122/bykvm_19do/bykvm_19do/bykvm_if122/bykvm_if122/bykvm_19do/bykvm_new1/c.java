package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

/* compiled from: Header.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1031d = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":");

    /* renamed from: e  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1032e = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1033f = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1034g = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1035h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1036i = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1037a;

    /* renamed from: b  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1038b;

    /* renamed from: c  reason: collision with root package name */
    final int f1039c;

    public c(String str, String str2) {
        this(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(str), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f1037a.equals(cVar.f1037a) && this.f1038b.equals(cVar.f1038b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1037a.hashCode() + 527) * 31) + this.f1038b.hashCode();
    }

    public String toString() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%s: %s", this.f1037a.h(), this.f1038b.h());
    }

    public c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar, String str) {
        this(fVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(str));
    }

    public c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar2) {
        this.f1037a = fVar;
        this.f1038b = fVar2;
        this.f1039c = fVar.e() + 32 + fVar2.e();
    }
}
