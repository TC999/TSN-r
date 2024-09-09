package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f26325a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f26326b;

    public float a(int i4) {
        return 1.0f;
    }

    public abstract int b();

    public int c(Object obj) {
        return -1;
    }

    @Deprecated
    public Object d(View view, int i4) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object e(ViewGroup viewGroup, int i4) {
        return d(viewGroup, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f26326b = dataSetObserver;
        }
    }

    public void g(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void h(View view) {
    }

    @Deprecated
    public void i(View view, int i4, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void j(ViewGroup viewGroup) {
        h(viewGroup);
    }

    public void k(ViewGroup viewGroup, int i4, Object obj) {
        i(viewGroup, i4, obj);
    }

    public abstract boolean l(View view, Object obj);

    public Parcelable m() {
        return null;
    }

    @Deprecated
    public void n(View view) {
    }

    @Deprecated
    public void o(View view, int i4, Object obj) {
    }

    public void p(ViewGroup viewGroup) {
        n(viewGroup);
    }

    public void q(ViewGroup viewGroup, int i4, Object obj) {
        o(viewGroup, i4, obj);
    }

    public void r() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f26326b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f26325a.notifyChanged();
    }
}
