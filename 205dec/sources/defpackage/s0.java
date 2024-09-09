package defpackage;

import java.util.HashMap;

/* renamed from: s0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class s0 extends x0 {

    /* renamed from: b  reason: collision with root package name */
    public String f64367b;

    /* renamed from: c  reason: collision with root package name */
    public Object f64368c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ P f64369d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(P p3, x0 x0Var) {
        super(x0Var);
        this.f64369d = p3;
        this.f64367b = null;
        this.f64368c = null;
    }

    @Override // defpackage.x0
    public final void a(String str, String str2, int i4, int i5, Object obj) {
        if (i5 == 3 && "name".equals(str2)) {
            this.f64367b = (String) obj;
        }
        if ("value".equals(str2)) {
            this.f64368c = obj;
        }
        super.a(str, str2, i4, i5, obj);
    }

    @Override // defpackage.x0
    public final void c() {
        Object obj;
        String str = this.f64367b;
        if (str != null && (obj = this.f64368c) != null) {
            ((HashMap) this.f64369d.f53a).put(str, obj);
        }
        super.c();
    }
}
