package com.bytedance.sdk.component.widget.recycler.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c<T> {
        T c();

        boolean c(T t3);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w<T> implements c<T> {

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f30575c;

        /* renamed from: w  reason: collision with root package name */
        private int f30576w;

        public w(int i4) {
            if (i4 > 0) {
                this.f30575c = new Object[i4];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean w(T t3) {
            for (int i4 = 0; i4 < this.f30576w; i4++) {
                if (this.f30575c[i4] == t3) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.c.w.sr.c
        public T c() {
            int i4 = this.f30576w;
            if (i4 > 0) {
                int i5 = i4 - 1;
                Object[] objArr = this.f30575c;
                T t3 = (T) objArr[i5];
                objArr[i5] = null;
                this.f30576w = i4 - 1;
                return t3;
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.c.w.sr.c
        public boolean c(T t3) {
            if (!w(t3)) {
                int i4 = this.f30576w;
                Object[] objArr = this.f30575c;
                if (i4 < objArr.length) {
                    objArr[i4] = t3;
                    this.f30576w = i4 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
