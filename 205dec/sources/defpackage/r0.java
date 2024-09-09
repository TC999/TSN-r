package defpackage;

/* renamed from: r0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class r0 extends x0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f62033c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(Object obj, x0 x0Var, int i4) {
        super(x0Var);
        this.f62032b = i4;
        this.f62033c = obj;
    }

    @Override // defpackage.x0
    public final x0 b(String str, String str2) {
        switch (this.f62032b) {
            case 0:
                x0 b4 = super.b(str, str2);
                return "meta-data".equals(str2) ? new s0((P) ((r0) this.f62033c).f62033c, b4) : b4;
            default:
                x0 b5 = super.b(str, str2);
                return "application".equals(str2) ? new r0(this, b5, 0) : b5;
        }
    }
}
