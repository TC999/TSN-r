package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1334a implements Cloneable {

    /* renamed from: a */
    ArrayList<InterfaceC1335a> f2333a = null;

    /* renamed from: com.acse.ottn.animator.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1335a {
        /* renamed from: a */
        void mo56852a(AbstractC1334a abstractC1334a);

        /* renamed from: b */
        void mo56856b(AbstractC1334a abstractC1334a);

        /* renamed from: c */
        void mo56855c(AbstractC1334a abstractC1334a);

        /* renamed from: d */
        void mo56854d(AbstractC1334a abstractC1334a);
    }

    /* renamed from: a */
    public abstract AbstractC1334a mo57054a(long j);

    /* renamed from: a */
    public void mo57109a() {
    }

    /* renamed from: a */
    public abstract void mo57108a(Interpolator interpolator);

    /* renamed from: a */
    public void m57118a(InterfaceC1335a interfaceC1335a) {
        if (this.f2333a == null) {
            this.f2333a = new ArrayList<>();
        }
        this.f2333a.add(interfaceC1335a);
    }

    /* renamed from: a */
    public void mo57052a(Object obj) {
    }

    /* renamed from: b */
    public abstract long mo57101b();

    /* renamed from: b */
    public abstract void mo57100b(long j);

    /* renamed from: b */
    public void m57117b(InterfaceC1335a interfaceC1335a) {
        ArrayList<InterfaceC1335a> arrayList = this.f2333a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC1335a);
        if (this.f2333a.size() == 0) {
            this.f2333a = null;
        }
    }

    /* renamed from: c */
    public ArrayList<InterfaceC1335a> m57116c() {
        return this.f2333a;
    }

    public void cancel() {
    }

    @Override // 
    /* renamed from: clone */
    public AbstractC1334a mo60089clone() {
        try {
            AbstractC1334a abstractC1334a = (AbstractC1334a) super.clone();
            ArrayList<InterfaceC1335a> arrayList = this.f2333a;
            if (arrayList != null) {
                abstractC1334a.f2333a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    abstractC1334a.f2333a.add(arrayList.get(i));
                }
            }
            return abstractC1334a;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public abstract long mo57096d();

    /* renamed from: e */
    public abstract boolean mo57094e();

    /* renamed from: f */
    public boolean mo57093f() {
        return mo57094e();
    }

    /* renamed from: g */
    public void m57115g() {
        ArrayList<InterfaceC1335a> arrayList = this.f2333a;
        if (arrayList != null) {
            arrayList.clear();
            this.f2333a = null;
        }
    }

    /* renamed from: h */
    public void mo57040h() {
    }

    /* renamed from: i */
    public void mo57039i() {
    }

    /* renamed from: j */
    public void mo57038j() {
    }
}
