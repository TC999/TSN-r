package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: UpdateStrategy.java */
/* renamed from: com.amap.api.col.3l.w7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class w7 {

    /* renamed from: a  reason: collision with root package name */
    w7 f9370a;

    public w7() {
    }

    public int a() {
        w7 w7Var = this.f9370a;
        return Math.min(Integer.MAX_VALUE, w7Var != null ? w7Var.a() : Integer.MAX_VALUE);
    }

    public void b(int i4) {
        w7 w7Var = this.f9370a;
        if (w7Var != null) {
            w7Var.b(i4);
        }
    }

    public void c(boolean z3) {
        w7 w7Var = this.f9370a;
        if (w7Var != null) {
            w7Var.c(z3);
        }
    }

    protected abstract boolean d();

    public final boolean e() {
        w7 w7Var = this.f9370a;
        if (w7Var != null ? w7Var.e() : true) {
            return d();
        }
        return false;
    }

    public w7(w7 w7Var) {
        this.f9370a = w7Var;
    }
}
