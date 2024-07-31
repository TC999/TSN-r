package p611k0;

import android.view.MotionEvent;
import p607j0.LinkHandler;
import p616l0.LinkTapEvent;

/* renamed from: k0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Callbacks {

    /* renamed from: a */
    private OnLoadCompleteListener f40808a;

    /* renamed from: b */
    private OnErrorListener f40809b;

    /* renamed from: c */
    private OnPageErrorListener f40810c;

    /* renamed from: d */
    private OnRenderListener f40811d;

    /* renamed from: e */
    private OnPageChangeListener f40812e;

    /* renamed from: f */
    private OnPageScrollListener f40813f;

    /* renamed from: g */
    private OnDrawListener f40814g;

    /* renamed from: h */
    private OnDrawListener f40815h;

    /* renamed from: i */
    private OnTapListener f40816i;

    /* renamed from: j */
    private OnLongPressListener f40817j;

    /* renamed from: k */
    private LinkHandler f40818k;

    /* renamed from: a */
    public void m12657a(LinkTapEvent linkTapEvent) {
        LinkHandler linkHandler = this.f40818k;
        if (linkHandler != null) {
            linkHandler.mo12667a(linkTapEvent);
        }
    }

    /* renamed from: b */
    public void m12656b(int i) {
        OnLoadCompleteListener onLoadCompleteListener = this.f40808a;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.mo12634a(i);
        }
    }

    /* renamed from: c */
    public void m12655c(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener = this.f40817j;
        if (onLongPressListener != null) {
            onLongPressListener.onLongPress(motionEvent);
        }
    }

    /* renamed from: d */
    public void m12654d(int i, int i2) {
        OnPageChangeListener onPageChangeListener = this.f40812e;
        if (onPageChangeListener != null) {
            onPageChangeListener.mo12633a(i, i2);
        }
    }

    /* renamed from: e */
    public boolean m12653e(int i, Throwable th) {
        OnPageErrorListener onPageErrorListener = this.f40810c;
        if (onPageErrorListener != null) {
            onPageErrorListener.m12632a(i, th);
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public void m12652f(int i, float f) {
        OnPageScrollListener onPageScrollListener = this.f40813f;
        if (onPageScrollListener != null) {
            onPageScrollListener.m12631a(i, f);
        }
    }

    /* renamed from: g */
    public void m12651g(int i) {
        OnRenderListener onRenderListener = this.f40811d;
        if (onRenderListener != null) {
            onRenderListener.m12630a(i);
        }
    }

    /* renamed from: h */
    public boolean m12650h(MotionEvent motionEvent) {
        OnTapListener onTapListener = this.f40816i;
        return onTapListener != null && onTapListener.m12629a(motionEvent);
    }

    /* renamed from: i */
    public OnDrawListener m12649i() {
        return this.f40814g;
    }

    /* renamed from: j */
    public OnDrawListener m12648j() {
        return this.f40815h;
    }

    /* renamed from: k */
    public OnErrorListener m12647k() {
        return this.f40809b;
    }

    /* renamed from: l */
    public void m12646l(LinkHandler linkHandler) {
        this.f40818k = linkHandler;
    }

    /* renamed from: m */
    public void m12645m(OnDrawListener onDrawListener) {
        this.f40814g = onDrawListener;
    }

    /* renamed from: n */
    public void m12644n(OnDrawListener onDrawListener) {
        this.f40815h = onDrawListener;
    }

    /* renamed from: o */
    public void m12643o(OnErrorListener onErrorListener) {
        this.f40809b = onErrorListener;
    }

    /* renamed from: p */
    public void m12642p(OnLoadCompleteListener onLoadCompleteListener) {
        this.f40808a = onLoadCompleteListener;
    }

    /* renamed from: q */
    public void m12641q(OnLongPressListener onLongPressListener) {
        this.f40817j = onLongPressListener;
    }

    /* renamed from: r */
    public void m12640r(OnPageChangeListener onPageChangeListener) {
        this.f40812e = onPageChangeListener;
    }

    /* renamed from: s */
    public void m12639s(OnPageErrorListener onPageErrorListener) {
        this.f40810c = onPageErrorListener;
    }

    /* renamed from: t */
    public void m12638t(OnPageScrollListener onPageScrollListener) {
        this.f40813f = onPageScrollListener;
    }

    /* renamed from: u */
    public void m12637u(OnRenderListener onRenderListener) {
        this.f40811d = onRenderListener;
    }

    /* renamed from: v */
    public void m12636v(OnTapListener onTapListener) {
        this.f40816i = onTapListener;
    }
}
