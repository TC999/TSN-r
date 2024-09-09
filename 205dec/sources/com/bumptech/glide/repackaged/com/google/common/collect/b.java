package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractIterator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class b<T> extends i0<T> {

    /* renamed from: a  reason: collision with root package name */
    private EnumC0181b f17664a = EnumC0181b.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private T f17665b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17666a;

        static {
            int[] iArr = new int[EnumC0181b.values().length];
            f17666a = iArr;
            try {
                iArr[EnumC0181b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17666a[EnumC0181b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public enum EnumC0181b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean d() {
        this.f17664a = EnumC0181b.FAILED;
        this.f17665b = a();
        if (this.f17664a != EnumC0181b.DONE) {
            this.f17664a = EnumC0181b.READY;
            return true;
        }
        return false;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f17664a = EnumC0181b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.bumptech.glide.repackaged.com.google.common.base.d.n(this.f17664a != EnumC0181b.FAILED);
        int i4 = a.f17666a[this.f17664a.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return d();
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f17664a = EnumC0181b.NOT_READY;
            T t3 = this.f17665b;
            this.f17665b = null;
            return t3;
        }
        throw new NoSuchElementException();
    }
}
