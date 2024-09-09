package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: UpdateStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class v3 {

    /* renamed from: a  reason: collision with root package name */
    v3 f10346a;

    public v3() {
    }

    public void a(int i4) {
        v3 v3Var = this.f10346a;
        if (v3Var != null) {
            v3Var.a(i4);
        }
    }

    public void b(boolean z3) {
        v3 v3Var = this.f10346a;
        if (v3Var != null) {
            v3Var.b(z3);
        }
    }

    protected abstract boolean c();

    public int d() {
        v3 v3Var = this.f10346a;
        return Math.min(Integer.MAX_VALUE, v3Var != null ? v3Var.d() : Integer.MAX_VALUE);
    }

    public final boolean e() {
        v3 v3Var = this.f10346a;
        if (v3Var != null ? v3Var.e() : true) {
            return c();
        }
        return false;
    }

    public v3(v3 v3Var) {
        this.f10346a = v3Var;
    }
}
