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
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.util.C3770j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* renamed from: com.bumptech.glide.request.target.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: g */
    private static final String f14487g = "ViewTarget";

    /* renamed from: h */
    private static boolean f14488h;
    @Nullable

    /* renamed from: i */
    private static Integer f14489i;

    /* renamed from: b */
    protected final T f14490b;

    /* renamed from: c */
    private final C3754b f14491c;
    @Nullable

    /* renamed from: d */
    private View.OnAttachStateChangeListener f14492d;

    /* renamed from: e */
    private boolean f14493e;

    /* renamed from: f */
    private boolean f14494f;

    /* compiled from: ViewTarget.java */
    /* renamed from: com.bumptech.glide.request.target.r$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnAttachStateChangeListenerC3753a implements View.OnAttachStateChangeListener {
        View$OnAttachStateChangeListenerC3753a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewTarget.this.m44468o();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTarget.this.m44470l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.target.r$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3754b {

        /* renamed from: e */
        private static final int f14496e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f */
        static Integer f14497f;

        /* renamed from: a */
        private final View f14498a;

        /* renamed from: b */
        private final List<SizeReadyCallback> f14499b = new ArrayList();

        /* renamed from: c */
        boolean f14500c;
        @Nullable

        /* renamed from: d */
        private ViewTreeObserver$OnPreDrawListenerC3755a f14501d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.request.target.r$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC3755a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C3754b> f14502a;

            ViewTreeObserver$OnPreDrawListenerC3755a(@NonNull C3754b c3754b) {
                this.f14502a = new WeakReference<>(c3754b);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.f14487g, 2)) {
                    Log.v(ViewTarget.f14487g, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C3754b c3754b = this.f14502a.get();
                if (c3754b != null) {
                    c3754b.m44463a();
                    return true;
                }
                return true;
            }
        }

        C3754b(@NonNull View view) {
            this.f14498a = view;
        }

        /* renamed from: c */
        private static int m44461c(@NonNull Context context) {
            if (f14497f == null) {
                Display defaultDisplay = ((WindowManager) C3770j.m44392d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f14497f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f14497f.intValue();
        }

        /* renamed from: e */
        private int m44459e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f14500c && this.f14498a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f14498a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.f14487g, 4)) {
                Log.i(ViewTarget.f14487g, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m44461c(this.f14498a.getContext());
        }

        /* renamed from: f */
        private int m44458f() {
            int paddingTop = this.f14498a.getPaddingTop() + this.f14498a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f14498a.getLayoutParams();
            return m44459e(this.f14498a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: g */
        private int m44457g() {
            int paddingLeft = this.f14498a.getPaddingLeft() + this.f14498a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f14498a.getLayoutParams();
            return m44459e(this.f14498a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: h */
        private boolean m44456h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* renamed from: i */
        private boolean m44455i(int i, int i2) {
            return m44456h(i) && m44456h(i2);
        }

        /* renamed from: j */
        private void m44454j(int i, int i2) {
            Iterator it = new ArrayList(this.f14499b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).mo44365e(i, i2);
            }
        }

        /* renamed from: a */
        void m44463a() {
            if (this.f14499b.isEmpty()) {
                return;
            }
            int m44457g = m44457g();
            int m44458f = m44458f();
            if (m44455i(m44457g, m44458f)) {
                m44454j(m44457g, m44458f);
                m44462b();
            }
        }

        /* renamed from: b */
        void m44462b() {
            ViewTreeObserver viewTreeObserver = this.f14498a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f14501d);
            }
            this.f14501d = null;
            this.f14499b.clear();
        }

        /* renamed from: d */
        void m44460d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int m44457g = m44457g();
            int m44458f = m44458f();
            if (m44455i(m44457g, m44458f)) {
                sizeReadyCallback.mo44365e(m44457g, m44458f);
                return;
            }
            if (!this.f14499b.contains(sizeReadyCallback)) {
                this.f14499b.add(sizeReadyCallback);
            }
            if (this.f14501d == null) {
                ViewTreeObserver viewTreeObserver = this.f14498a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC3755a viewTreeObserver$OnPreDrawListenerC3755a = new ViewTreeObserver$OnPreDrawListenerC3755a(this);
                this.f14501d = viewTreeObserver$OnPreDrawListenerC3755a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC3755a);
            }
        }

        /* renamed from: k */
        void m44453k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f14499b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@NonNull T t) {
        this.f14490b = (T) C3770j.m44392d(t);
        this.f14491c = new C3754b(t);
    }

    @Nullable
    /* renamed from: e */
    private Object m44476e() {
        Integer num = f14489i;
        if (num == null) {
            return this.f14490b.getTag();
        }
        return this.f14490b.getTag(num.intValue());
    }

    /* renamed from: f */
    private void m44475f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f14492d;
        if (onAttachStateChangeListener == null || this.f14494f) {
            return;
        }
        this.f14490b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f14494f = true;
    }

    /* renamed from: g */
    private void m44474g() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f14492d;
        if (onAttachStateChangeListener == null || !this.f14494f) {
            return;
        }
        this.f14490b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f14494f = false;
    }

    /* renamed from: p */
    private void m44467p(@Nullable Object obj) {
        Integer num = f14489i;
        if (num == null) {
            f14488h = true;
            this.f14490b.setTag(obj);
            return;
        }
        this.f14490b.setTag(num.intValue(), obj);
    }

    /* renamed from: r */
    public static void m44465r(int i) {
        if (f14489i == null && !f14488h) {
            f14489i = Integer.valueOf(i);
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    /* renamed from: b */
    public void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f14491c.m44453k(sizeReadyCallback);
    }

    @NonNull
    /* renamed from: d */
    public final ViewTarget<T, Z> m44477d() {
        if (this.f14492d != null) {
            return this;
        }
        this.f14492d = new View$OnAttachStateChangeListenerC3753a();
        m44475f();
        return this;
    }

    @NonNull
    public T getView() {
        return this.f14490b;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    /* renamed from: h */
    public void mo44473h(@Nullable Drawable drawable) {
        super.mo44473h(drawable);
        m44475f();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    /* renamed from: i */
    public InterfaceC3744d mo44472i() {
        Object m44476e = m44476e();
        if (m44476e != null) {
            if (m44476e instanceof InterfaceC3744d) {
                return (InterfaceC3744d) m44476e;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    /* renamed from: j */
    public void mo44471j(@Nullable Drawable drawable) {
        super.mo44471j(drawable);
        this.f14491c.m44462b();
        if (this.f14493e) {
            return;
        }
        m44474g();
    }

    /* renamed from: l */
    void m44470l() {
        InterfaceC3744d mo44472i = mo44472i();
        if (mo44472i != null) {
            this.f14493e = true;
            mo44472i.clear();
            this.f14493e = false;
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    /* renamed from: m */
    public void mo44469m(@Nullable InterfaceC3744d interfaceC3744d) {
        m44467p(interfaceC3744d);
    }

    /* renamed from: o */
    void m44468o() {
        InterfaceC3744d mo44472i = mo44472i();
        if (mo44472i == null || !mo44472i.mo44527g()) {
            return;
        }
        mo44472i.mo44524j();
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    /* renamed from: q */
    public void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f14491c.m44460d(sizeReadyCallback);
    }

    @NonNull
    /* renamed from: s */
    public final ViewTarget<T, Z> m44464s() {
        this.f14491c.f14500c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f14490b;
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            m44464s();
        }
    }
}
