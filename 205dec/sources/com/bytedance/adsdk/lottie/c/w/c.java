package com.bytedance.adsdk.lottie.c.w;

import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.n;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final f<K> f25472c;

    /* renamed from: e  reason: collision with root package name */
    protected n.k<A> f25474e;

    /* renamed from: a  reason: collision with root package name */
    final List<b> f25470a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f25471b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f25473d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private A f25475f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f25476g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f25477h = -1.0f;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface b {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.adsdk.lottie.c.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0350c<T> implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends n.h<T>> f25478a;

        /* renamed from: c  reason: collision with root package name */
        private n.h<T> f25480c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f25481d = -1.0f;

        /* renamed from: b  reason: collision with root package name */
        private n.h<T> f25479b = b(0.0f);

        C0350c(List<? extends n.h<T>> list) {
            this.f25478a = list;
        }

        private n.h<T> b(float f4) {
            List<? extends n.h<T>> list = this.f25478a;
            n.h<T> hVar = list.get(list.size() - 1);
            if (f4 >= hVar.i()) {
                return hVar;
            }
            for (int size = this.f25478a.size() - 2; size >= 1; size--) {
                n.h<T> hVar2 = this.f25478a.get(size);
                if (this.f25479b != hVar2 && hVar2.b(f4)) {
                    return hVar2;
                }
            }
            return this.f25478a.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean a(float f4) {
            n.h<T> hVar = this.f25480c;
            n.h<T> hVar2 = this.f25479b;
            if (hVar == hVar2 && this.f25481d == f4) {
                return true;
            }
            this.f25480c = hVar2;
            this.f25481d = f4;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c(float f4) {
            if (this.f25479b.b(f4)) {
                return !this.f25479b.h();
            }
            this.f25479b = b(f4);
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float sr() {
            List<? extends n.h<T>> list = this.f25478a;
            return list.get(list.size() - 1).g();
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public n.h<T> w() {
            return this.f25479b;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float xv() {
            return this.f25478a.get(0).i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class d<T> implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final n.h<T> f25482a;

        /* renamed from: b  reason: collision with root package name */
        private float f25483b = -1.0f;

        d(List<? extends n.h<T>> list) {
            this.f25482a = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean a(float f4) {
            if (this.f25483b == f4) {
                return true;
            }
            this.f25483b = f4;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c(float f4) {
            return !this.f25482a.h();
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float sr() {
            return this.f25482a.g();
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public n.h<T> w() {
            return this.f25482a;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float xv() {
            return this.f25482a.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class e<T> implements f<T> {
        private e() {
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean a(float f4) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public boolean c(float f4) {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float sr() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public n.h<T> w() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.f
        public float xv() {
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface f<T> {
        boolean a(float f4);

        boolean c();

        boolean c(float f4);

        @FloatRange(from = 0.0d, to = 1.0d)
        float sr();

        n.h<T> w();

        @FloatRange(from = 0.0d, to = 1.0d)
        float xv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<? extends n.h<K>> list) {
        this.f25472c = a(list);
    }

    private static <T> f<T> a(List<? extends n.h<T>> list) {
        if (list.isEmpty()) {
            return new e();
        }
        if (list.size() == 1) {
            return new d(list);
        }
        return new C0350c(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        if (this.f25476g == -1.0f) {
            this.f25476g = this.f25472c.xv();
        }
        return this.f25476g;
    }

    abstract A b(n.h<K> hVar, float f4);

    protected A c(n.h<K> hVar, float f4, float f5, float f6) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void d() {
        this.f25471b = true;
    }

    public void e(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f25472c.c()) {
            return;
        }
        if (f4 < i()) {
            f4 = i();
        } else if (f4 > h()) {
            f4 = h();
        }
        if (f4 == this.f25473d) {
            return;
        }
        this.f25473d = f4;
        if (this.f25472c.c(f4)) {
            m();
        }
    }

    public void f(b bVar) {
        this.f25470a.add(bVar);
    }

    public float g() {
        return this.f25473d;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float h() {
        if (this.f25477h == -1.0f) {
            this.f25477h = this.f25472c.sr();
        }
        return this.f25477h;
    }

    public A j() {
        A b4;
        float k4 = k();
        if (this.f25474e == null && this.f25472c.a(k4)) {
            return this.f25475f;
        }
        n.h<K> n4 = n();
        Interpolator interpolator = n4.f25669e;
        if (interpolator != null && n4.f25670f != null) {
            b4 = c(n4, k4, interpolator.getInterpolation(k4), n4.f25670f.getInterpolation(k4));
        } else {
            b4 = b(n4, l());
        }
        this.f25475f = b4;
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        if (this.f25471b) {
            return 0.0f;
        }
        n.h<K> n4 = n();
        if (n4.h()) {
            return 0.0f;
        }
        return (this.f25473d - n4.i()) / (n4.g() - n4.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float l() {
        n.h<K> n4 = n();
        if (n4 == null || n4.h()) {
            return 0.0f;
        }
        return n4.f25668d.getInterpolation(k());
    }

    public void m() {
        for (int i4 = 0; i4 < this.f25470a.size(); i4++) {
            this.f25470a.get(i4).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n.h<K> n() {
        s.b("BaseKeyframeAnimation#getCurrentKeyframe");
        n.h<K> w3 = this.f25472c.w();
        s.d("BaseKeyframeAnimation#getCurrentKeyframe");
        return w3;
    }
}
