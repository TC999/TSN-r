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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CustomViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f17967g = "CustomViewTarget";
    @IdRes

    /* renamed from: h  reason: collision with root package name */
    private static final int f17968h = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    private final b f17969a;

    /* renamed from: b  reason: collision with root package name */
    protected final T f17970b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f17971c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17972d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17973e;
    @IdRes

    /* renamed from: f  reason: collision with root package name */
    private int f17974f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: CustomViewTarget.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.o();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: CustomViewTarget.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f17976e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f  reason: collision with root package name */
        static Integer f17977f;

        /* renamed from: a  reason: collision with root package name */
        private final View f17978a;

        /* renamed from: b  reason: collision with root package name */
        private final List<o> f17979b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f17980c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f17981d;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: CustomViewTarget.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<b> f17982a;

            a(@NonNull b bVar) {
                this.f17982a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = this.f17982a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        b(@NonNull View view) {
            this.f17978a = view;
        }

        private static int c(@NonNull Context context) {
            if (f17977f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f17977f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f17977f.intValue();
        }

        private int e(int i4, int i5, int i6) {
            int i7 = i5 - i6;
            if (i7 > 0) {
                return i7;
            }
            if (this.f17980c && this.f17978a.isLayoutRequested()) {
                return 0;
            }
            int i8 = i4 - i6;
            if (i8 > 0) {
                return i8;
            }
            if (this.f17978a.isLayoutRequested() || i5 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f17978a.getContext());
        }

        private int f() {
            int paddingTop = this.f17978a.getPaddingTop() + this.f17978a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f17978a.getLayoutParams();
            return e(this.f17978a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f17978a.getPaddingLeft() + this.f17978a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f17978a.getLayoutParams();
            return e(this.f17978a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i4) {
            return i4 > 0 || i4 == Integer.MIN_VALUE;
        }

        private boolean i(int i4, int i5) {
            return h(i4) && h(i5);
        }

        private void j(int i4, int i5) {
            Iterator it = new ArrayList(this.f17979b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).e(i4, i5);
            }
        }

        void a() {
            if (this.f17979b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f17978a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f17981d);
            }
            this.f17981d = null;
            this.f17979b.clear();
        }

        void d(@NonNull o oVar) {
            int g4 = g();
            int f4 = f();
            if (i(g4, f4)) {
                oVar.e(g4, f4);
                return;
            }
            if (!this.f17979b.contains(oVar)) {
                this.f17979b.add(oVar);
            }
            if (this.f17981d == null) {
                ViewTreeObserver viewTreeObserver = this.f17978a.getViewTreeObserver();
                a aVar = new a(this);
                this.f17981d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull o oVar) {
            this.f17979b.remove(oVar);
        }
    }

    public f(@NonNull T t3) {
        this.f17970b = (T) com.bumptech.glide.util.j.d(t3);
        this.f17969a = new b(t3);
    }

    @Nullable
    private Object c() {
        T t3 = this.f17970b;
        int i4 = this.f17974f;
        if (i4 == 0) {
            i4 = f17968h;
        }
        return t3.getTag(i4);
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17971c;
        if (onAttachStateChangeListener == null || this.f17973e) {
            return;
        }
        this.f17970b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f17973e = true;
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17971c;
        if (onAttachStateChangeListener == null || !this.f17973e) {
            return;
        }
        this.f17970b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f17973e = false;
    }

    private void r(@Nullable Object obj) {
        T t3 = this.f17970b;
        int i4 = this.f17974f;
        if (i4 == 0) {
            i4 = f17968h;
        }
        t3.setTag(i4, obj);
    }

    @NonNull
    public final f<T, Z> a() {
        if (this.f17971c != null) {
            return this;
        }
        this.f17971c = new a();
        e();
        return this;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void b(@NonNull o oVar) {
        this.f17969a.k(oVar);
    }

    @NonNull
    public final T d() {
        return this.f17970b;
    }

    protected abstract void g(@Nullable Drawable drawable);

    @Override // com.bumptech.glide.request.target.p
    public final void h(@Nullable Drawable drawable) {
        e();
        l(drawable);
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public final com.bumptech.glide.request.d i() {
        Object c4 = c();
        if (c4 != null) {
            if (c4 instanceof com.bumptech.glide.request.d) {
                return (com.bumptech.glide.request.d) c4;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void j(@Nullable Drawable drawable) {
        this.f17969a.b();
        g(drawable);
        if (this.f17972d) {
            return;
        }
        f();
    }

    protected void l(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public final void m(@Nullable com.bumptech.glide.request.d dVar) {
        r(dVar);
    }

    final void o() {
        com.bumptech.glide.request.d i4 = i();
        if (i4 != null) {
            this.f17972d = true;
            i4.clear();
            this.f17972d = false;
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    final void p() {
        com.bumptech.glide.request.d i4 = i();
        if (i4 == null || !i4.g()) {
            return;
        }
        i4.j();
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        this.f17969a.d(oVar);
    }

    public final f<T, Z> s(@IdRes int i4) {
        if (this.f17974f == 0) {
            this.f17974f = i4;
            return this;
        }
        throw new IllegalArgumentException("You cannot change the tag id once it has been set.");
    }

    @NonNull
    public final f<T, Z> t() {
        this.f17969a.f17980c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f17970b;
    }
}
