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
import com.bumptech.glide.C3533R;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.util.C3770j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bumptech.glide.request.target.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* renamed from: g */
    private static final String f14449g = "CustomViewTarget";
    @IdRes

    /* renamed from: h */
    private static final int f14450h = C3533R.C3536id.glide_custom_view_target_tag;

    /* renamed from: a */
    private final C3749b f14451a;

    /* renamed from: b */
    protected final T f14452b;
    @Nullable

    /* renamed from: c */
    private View.OnAttachStateChangeListener f14453c;

    /* renamed from: d */
    private boolean f14454d;

    /* renamed from: e */
    private boolean f14455e;
    @IdRes

    /* renamed from: f */
    private int f14456f;

    /* compiled from: CustomViewTarget.java */
    /* renamed from: com.bumptech.glide.request.target.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnAttachStateChangeListenerC3748a implements View.OnAttachStateChangeListener {
        View$OnAttachStateChangeListenerC3748a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            CustomViewTarget.this.m44505p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            CustomViewTarget.this.m44506o();
        }
    }

    /* compiled from: CustomViewTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.target.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static final class C3749b {

        /* renamed from: e */
        private static final int f14458e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f */
        static Integer f14459f;

        /* renamed from: a */
        private final View f14460a;

        /* renamed from: b */
        private final List<SizeReadyCallback> f14461b = new ArrayList();

        /* renamed from: c */
        boolean f14462c;
        @Nullable

        /* renamed from: d */
        private ViewTreeObserver$OnPreDrawListenerC3750a f14463d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CustomViewTarget.java */
        /* renamed from: com.bumptech.glide.request.target.f$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC3750a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C3749b> f14464a;

            ViewTreeObserver$OnPreDrawListenerC3750a(@NonNull C3749b c3749b) {
                this.f14464a = new WeakReference<>(c3749b);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.f14449g, 2)) {
                    Log.v(CustomViewTarget.f14449g, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C3749b c3749b = this.f14464a.get();
                if (c3749b != null) {
                    c3749b.m44501a();
                    return true;
                }
                return true;
            }
        }

        C3749b(@NonNull View view) {
            this.f14460a = view;
        }

        /* renamed from: c */
        private static int m44499c(@NonNull Context context) {
            if (f14459f == null) {
                Display defaultDisplay = ((WindowManager) C3770j.m44392d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f14459f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f14459f.intValue();
        }

        /* renamed from: e */
        private int m44497e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f14462c && this.f14460a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f14460a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(CustomViewTarget.f14449g, 4)) {
                Log.i(CustomViewTarget.f14449g, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m44499c(this.f14460a.getContext());
        }

        /* renamed from: f */
        private int m44496f() {
            int paddingTop = this.f14460a.getPaddingTop() + this.f14460a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f14460a.getLayoutParams();
            return m44497e(this.f14460a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: g */
        private int m44495g() {
            int paddingLeft = this.f14460a.getPaddingLeft() + this.f14460a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f14460a.getLayoutParams();
            return m44497e(this.f14460a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: h */
        private boolean m44494h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* renamed from: i */
        private boolean m44493i(int i, int i2) {
            return m44494h(i) && m44494h(i2);
        }

        /* renamed from: j */
        private void m44492j(int i, int i2) {
            Iterator it = new ArrayList(this.f14461b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).mo44365e(i, i2);
            }
        }

        /* renamed from: a */
        void m44501a() {
            if (this.f14461b.isEmpty()) {
                return;
            }
            int m44495g = m44495g();
            int m44496f = m44496f();
            if (m44493i(m44495g, m44496f)) {
                m44492j(m44495g, m44496f);
                m44500b();
            }
        }

        /* renamed from: b */
        void m44500b() {
            ViewTreeObserver viewTreeObserver = this.f14460a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f14463d);
            }
            this.f14463d = null;
            this.f14461b.clear();
        }

        /* renamed from: d */
        void m44498d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int m44495g = m44495g();
            int m44496f = m44496f();
            if (m44493i(m44495g, m44496f)) {
                sizeReadyCallback.mo44365e(m44495g, m44496f);
                return;
            }
            if (!this.f14461b.contains(sizeReadyCallback)) {
                this.f14461b.add(sizeReadyCallback);
            }
            if (this.f14463d == null) {
                ViewTreeObserver viewTreeObserver = this.f14460a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC3750a viewTreeObserver$OnPreDrawListenerC3750a = new ViewTreeObserver$OnPreDrawListenerC3750a(this);
                this.f14463d = viewTreeObserver$OnPreDrawListenerC3750a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC3750a);
            }
        }

        /* renamed from: k */
        void m44491k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f14461b.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(@NonNull T t) {
        this.f14452b = (T) C3770j.m44392d(t);
        this.f14451a = new C3749b(t);
    }

    @Nullable
    /* renamed from: c */
    private Object m44512c() {
        T t = this.f14452b;
        int i = this.f14456f;
        if (i == 0) {
            i = f14450h;
        }
        return t.getTag(i);
    }

    /* renamed from: e */
    private void m44510e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f14453c;
        if (onAttachStateChangeListener == null || this.f14455e) {
            return;
        }
        this.f14452b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f14455e = true;
    }

    /* renamed from: f */
    private void m44509f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f14453c;
        if (onAttachStateChangeListener == null || !this.f14455e) {
            return;
        }
        this.f14452b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f14455e = false;
    }

    /* renamed from: r */
    private void m44504r(@Nullable Object obj) {
        T t = this.f14452b;
        int i = this.f14456f;
        if (i == 0) {
            i = f14450h;
        }
        t.setTag(i, obj);
    }

    @NonNull
    /* renamed from: a */
    public final CustomViewTarget<T, Z> m44513a() {
        if (this.f14453c != null) {
            return this;
        }
        this.f14453c = new View$OnAttachStateChangeListenerC3748a();
        m44510e();
        return this;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: b */
    public final void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f14451a.m44491k(sizeReadyCallback);
    }

    @NonNull
    /* renamed from: d */
    public final T m44511d() {
        return this.f14452b;
    }

    /* renamed from: g */
    protected abstract void m44508g(@Nullable Drawable drawable);

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: h */
    public final void mo44473h(@Nullable Drawable drawable) {
        m44510e();
        m44507l(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    /* renamed from: i */
    public final InterfaceC3744d mo44472i() {
        Object m44512c = m44512c();
        if (m44512c != null) {
            if (m44512c instanceof InterfaceC3744d) {
                return (InterfaceC3744d) m44512c;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: j */
    public final void mo44471j(@Nullable Drawable drawable) {
        this.f14451a.m44500b();
        m44508g(drawable);
        if (this.f14454d) {
            return;
        }
        m44509f();
    }

    /* renamed from: l */
    protected void m44507l(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: m */
    public final void mo44469m(@Nullable InterfaceC3744d interfaceC3744d) {
        m44504r(interfaceC3744d);
    }

    /* renamed from: o */
    final void m44506o() {
        InterfaceC3744d mo44472i = mo44472i();
        if (mo44472i != null) {
            this.f14454d = true;
            mo44472i.clear();
            this.f14454d = false;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    /* renamed from: p */
    final void m44505p() {
        InterfaceC3744d mo44472i = mo44472i();
        if (mo44472i == null || !mo44472i.mo44527g()) {
            return;
        }
        mo44472i.mo44524j();
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: q */
    public final void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f14451a.m44498d(sizeReadyCallback);
    }

    /* renamed from: s */
    public final CustomViewTarget<T, Z> m44503s(@IdRes int i) {
        if (this.f14456f == 0) {
            this.f14456f = i;
            return this;
        }
        throw new IllegalArgumentException("You cannot change the tag id once it has been set.");
    }

    @NonNull
    /* renamed from: t */
    public final CustomViewTarget<T, Z> m44502t() {
        this.f14451a.f14462c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f14452b;
    }
}
