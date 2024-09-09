package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.a  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class AbstractC1361a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<InterfaceC0082a> f4880a = null;

    /* renamed from: com.acse.ottn.animator.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface InterfaceC0082a {
        void a(AbstractC1361a abstractC1361a);

        void b(AbstractC1361a abstractC1361a);

        void c(AbstractC1361a abstractC1361a);

        void d(AbstractC1361a abstractC1361a);
    }

    public abstract AbstractC1361a a(long j4);

    public void a() {
    }

    public abstract void a(Interpolator interpolator);

    public void a(InterfaceC0082a interfaceC0082a) {
        if (this.f4880a == null) {
            this.f4880a = new ArrayList<>();
        }
        this.f4880a.add(interfaceC0082a);
    }

    public void a(Object obj) {
    }

    public abstract long b();

    public abstract void b(long j4);

    public void b(InterfaceC0082a interfaceC0082a) {
        ArrayList<InterfaceC0082a> arrayList = this.f4880a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC0082a);
        if (this.f4880a.size() == 0) {
            this.f4880a = null;
        }
    }

    public ArrayList<InterfaceC0082a> c() {
        return this.f4880a;
    }

    public void cancel() {
    }

    @Override // 
    /* renamed from: clone */
    public AbstractC1361a mo10clone() {
        try {
            AbstractC1361a abstractC1361a = (AbstractC1361a) super.clone();
            ArrayList<InterfaceC0082a> arrayList = this.f4880a;
            if (arrayList != null) {
                abstractC1361a.f4880a = new ArrayList<>();
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    abstractC1361a.f4880a.add(arrayList.get(i4));
                }
            }
            return abstractC1361a;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public abstract long d();

    public abstract boolean e();

    public boolean f() {
        return e();
    }

    public void g() {
        ArrayList<InterfaceC0082a> arrayList = this.f4880a;
        if (arrayList != null) {
            arrayList.clear();
            this.f4880a = null;
        }
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
