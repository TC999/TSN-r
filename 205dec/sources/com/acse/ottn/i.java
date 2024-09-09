package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class i implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f5729a = null;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(i iVar);

        void b(i iVar);

        void c(i iVar);

        void d(i iVar);
    }

    public abstract i a(long j4);

    public abstract void a(Interpolator interpolator);

    public void a(a aVar) {
        if (this.f5729a == null) {
            this.f5729a = new ArrayList<>();
        }
        this.f5729a.add(aVar);
    }

    public void a(Object obj) {
    }

    public void b() {
    }

    public abstract void b(long j4);

    public void b(a aVar) {
        ArrayList<a> arrayList = this.f5729a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
        if (this.f5729a.size() == 0) {
            this.f5729a = null;
        }
    }

    public abstract long c();

    public void cancel() {
    }

    public ArrayList<a> d() {
        return this.f5729a;
    }

    public abstract long e();

    public abstract boolean f();

    public boolean g() {
        return f();
    }

    public void h() {
        ArrayList<a> arrayList = this.f5729a;
        if (arrayList != null) {
            arrayList.clear();
            this.f5729a = null;
        }
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    @Override // 
    /* renamed from: a */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            ArrayList<a> arrayList = this.f5729a;
            if (arrayList != null) {
                iVar.f5729a = new ArrayList<>();
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    iVar.f5729a.add(arrayList.get(i4));
                }
            }
            return iVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
