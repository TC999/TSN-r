package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class r<T extends View, Z> extends com.bumptech.glide.request.target.b<Z> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f18005g = "ViewTarget";

    /* renamed from: h  reason: collision with root package name */
    private static boolean f18006h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Integer f18007i;

    /* renamed from: b  reason: collision with root package name */
    protected final T f18008b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18009c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f18010d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18011e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18012f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewTarget.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.o();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f18014e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f  reason: collision with root package name */
        static Integer f18015f;

        /* renamed from: a  reason: collision with root package name */
        private final View f18016a;

        /* renamed from: b  reason: collision with root package name */
        private final List<o> f18017b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f18018c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f18019d;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ViewTarget.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<b> f18020a;

            a(@NonNull b bVar) {
                this.f18020a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = this.f18020a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        b(@NonNull View view) {
            this.f18016a = view;
        }

        private static int c(@NonNull Context context) {
            if (f18015f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f18015f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f18015f.intValue();
        }

        private int e(int i4, int i5, int i6) {
            int i7 = i5 - i6;
            if (i7 > 0) {
                return i7;
            }
            if (this.f18018c && this.f18016a.isLayoutRequested()) {
                return 0;
            }
            int i8 = i4 - i6;
            if (i8 > 0) {
                return i8;
            }
            if (this.f18016a.isLayoutRequested() || i5 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f18016a.getContext());
        }

        private int f() {
            int paddingTop = this.f18016a.getPaddingTop() + this.f18016a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f18016a.getLayoutParams();
            return e(this.f18016a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f18016a.getPaddingLeft() + this.f18016a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f18016a.getLayoutParams();
            return e(this.f18016a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i4) {
            return i4 > 0 || i4 == Integer.MIN_VALUE;
        }

        private boolean i(int i4, int i5) {
            return h(i4) && h(i5);
        }

        private void j(int i4, int i5) {
            Iterator it = new ArrayList(this.f18017b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).e(i4, i5);
            }
        }

        void a() {
            if (this.f18017b.isEmpty()) {
                return;
            }
            int g4 = g();
            int f4 = f();
            if (i(g4, f4)) {
                j(g4, f4);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f18016a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f18019d);
            }
            this.f18019d = null;
            this.f18017b.clear();
        }

        void d(@NonNull o oVar) {
            int g4 = g();
            int f4 = f();
            if (i(g4, f4)) {
                oVar.e(g4, f4);
                return;
            }
            if (!this.f18017b.contains(oVar)) {
                this.f18017b.add(oVar);
            }
            if (this.f18019d == null) {
                ViewTreeObserver viewTreeObserver = this.f18016a.getViewTreeObserver();
                a aVar = new a(this);
                this.f18019d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull o oVar) {
            this.f18017b.remove(oVar);
        }
    }

    public r(@NonNull T t3) {
        this.f18008b = (T) com.bumptech.glide.util.j.d(t3);
        this.f18009c = new b(t3);
    }

    @Nullable
    private Object e() {
        Integer num = f18007i;
        if (num == null) {
            return this.f18008b.getTag();
        }
        return this.f18008b.getTag(num.intValue());
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f18010d;
        if (onAttachStateChangeListener == null || this.f18012f) {
            return;
        }
        this.f18008b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f18012f = true;
    }

    private void g() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f18010d;
        if (onAttachStateChangeListener == null || !this.f18012f) {
            return;
        }
        this.f18008b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f18012f = false;
    }

    private void p(@Nullable Object obj) {
        Integer num = f18007i;
        if (num == null) {
            f18006h = true;
            this.f18008b.setTag(obj);
            return;
        }
        this.f18008b.setTag(num.intValue(), obj);
    }

    public static void r(int i4) {
        if (f18007i == null && !f18006h) {
            f18007i = Integer.valueOf(i4);
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.bumptech.glide.request.target.p
    @CallSuper
    public void b(@NonNull o oVar) {
        this.f18009c.k(oVar);
    }

    @NonNull
    public final r<T, Z> d() {
        if (this.f18010d != null) {
            return this;
        }
        this.f18010d = new a();
        f();
        return this;
    }

    @NonNull
    public T getView() {
        return this.f18008b;
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @CallSuper
    public void h(@Nullable Drawable drawable) {
        super.h(drawable);
        f();
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @Nullable
    public com.bumptech.glide.request.d i() {
        Object e4 = e();
        if (e4 != null) {
            if (e4 instanceof com.bumptech.glide.request.d) {
                return (com.bumptech.glide.request.d) e4;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @CallSuper
    public void j(@Nullable Drawable drawable) {
        super.j(drawable);
        this.f18009c.b();
        if (this.f18011e) {
            return;
        }
        g();
    }

    void l() {
        com.bumptech.glide.request.d i4 = i();
        if (i4 != null) {
            this.f18011e = true;
            i4.clear();
            this.f18011e = false;
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void m(@Nullable com.bumptech.glide.request.d dVar) {
        p(dVar);
    }

    void o() {
        com.bumptech.glide.request.d i4 = i();
        if (i4 == null || !i4.g()) {
            return;
        }
        i4.j();
    }

    @Override // com.bumptech.glide.request.target.p
    @CallSuper
    public void q(@NonNull o oVar) {
        this.f18009c.d(oVar);
    }

    @NonNull
    public final r<T, Z> s() {
        this.f18009c.f18018c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f18008b;
    }

    @Deprecated
    public r(@NonNull T t3, boolean z3) {
        this(t3);
        if (z3) {
            s();
        }
    }
}
