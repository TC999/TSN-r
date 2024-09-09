package com.hp.hpl.sparta.xpath;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Step.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class t {

    /* renamed from: d  reason: collision with root package name */
    public static t f37470d = new t(z.f37477a, a0.f37443a);

    /* renamed from: a  reason: collision with root package name */
    private final o f37471a;

    /* renamed from: b  reason: collision with root package name */
    private final k f37472b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37473c;

    t(o oVar, k kVar) {
        this.f37471a = oVar;
        this.f37472b = kVar;
        this.f37473c = false;
    }

    public o a() {
        return this.f37471a;
    }

    public k b() {
        return this.f37472b;
    }

    public boolean c() {
        return this.f37473c;
    }

    public boolean d() {
        return this.f37471a.b();
    }

    public String toString() {
        return this.f37471a.toString() + this.f37472b.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(c0 c0Var, boolean z3, s sVar) throws XPathException, IOException {
        this.f37473c = z3;
        int i4 = sVar.f37461a;
        if (i4 != -3) {
            if (i4 == 42) {
                this.f37471a = a.f37442a;
            } else if (i4 != 46) {
                if (i4 == 64) {
                    if (sVar.a() == -3) {
                        this.f37471a = new j(sVar.f37463c);
                    } else {
                        throw new XPathException(c0Var, "after @ in node test", sVar, "name");
                    }
                } else {
                    throw new XPathException(c0Var, "at begininning of step", sVar, "'.' or '*' or name");
                }
            } else if (sVar.a() == 46) {
                this.f37471a = q.f37454a;
            } else {
                sVar.c();
                this.f37471a = z.f37477a;
            }
        } else if (sVar.f37463c.equals("text")) {
            if (sVar.a() == 40 && sVar.a() == 41) {
                this.f37471a = y.f37476a;
            } else {
                throw new XPathException(c0Var, "after text", sVar, "()");
            }
        } else {
            this.f37471a = new m(sVar.f37463c);
        }
        if (sVar.a() == 91) {
            sVar.a();
            this.f37472b = n.a(c0Var, sVar);
            if (sVar.f37461a == 93) {
                sVar.a();
                return;
            }
            throw new XPathException(c0Var, "after predicate expression", sVar, "]");
        }
        this.f37472b = a0.f37443a;
    }
}
