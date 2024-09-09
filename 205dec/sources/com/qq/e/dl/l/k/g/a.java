package com.qq.e.dl.l.k.g;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.dl.l.k.g.c f47196a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.OnFlingListener f47197b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView.OnScrollListener f47198c;

    /* renamed from: d  reason: collision with root package name */
    private int f47199d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f47200e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f47201f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f47202g;

    /* compiled from: A */
    /* renamed from: com.qq.e.dl.l.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0918a implements Runnable {
        RunnableC0918a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            if (a.this.f47199d == 0) {
                return;
            }
            e m4 = a.this.f47196a.m();
            int i4 = -2;
            if (m4.getScrollState() == 0 && (itemCount = m4.getAdapter().getItemCount()) > 0 && (itemCount == Integer.MAX_VALUE || (i4 = ((com.qq.e.dl.l.k.g.b) a.this.f47196a.i()).h()) < itemCount - 1)) {
                a.this.a(i4);
            }
            m4.postDelayed(this, a.this.f47201f);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (a.this.f47202g != null) {
                view.postDelayed(a.this.f47202g, a.this.f47201f);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (a.this.f47202g != null) {
                view.removeCallbacks(a.this.f47202g);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class c extends RecyclerView.OnFlingListener {
        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i4, int i5) {
            if (a.this.f47199d != 0) {
                a.this.a(i4, i5);
                return true;
            }
            return true;
        }

        /* synthetic */ c(a aVar, RunnableC0918a runnableC0918a) {
            this();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class d extends RecyclerView.OnScrollListener {
        private d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            if (i4 != 1) {
                if (i4 == 2 || a.this.f47200e) {
                    return;
                }
                a.this.a(0, 0);
                return;
            }
            a.this.f47200e = false;
        }

        /* synthetic */ d(a aVar, RunnableC0918a runnableC0918a) {
            this();
        }
    }

    public a(com.qq.e.dl.l.k.g.c cVar) {
        this.f47196a = cVar;
    }

    private int b(int i4, int i5, int i6) {
        return (i4 - i5) - i6;
    }

    private int c(int i4, int i5, int i6) {
        return (i4 + i5) - i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        this.f47199d = i4;
        if (i4 == 0) {
            this.f47196a.m().setOnScrollListener(null);
            return;
        }
        if (this.f47198c == null) {
            this.f47198c = new d(this, null);
        }
        this.f47196a.m().setOnScrollListener(this.f47198c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) {
        if (i4 <= 0) {
            return;
        }
        this.f47201f = i4;
        if (this.f47202g != null) {
            return;
        }
        this.f47202g = new RunnableC0918a();
        this.f47196a.m().addOnAttachStateChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        if (z3) {
            this.f47196a.m().setOnFlingListener(null);
            return;
        }
        if (this.f47197b == null) {
            this.f47197b = new c(this, null);
        }
        this.f47196a.m().setOnFlingListener(this.f47197b);
    }

    private void b(int i4, boolean z3) {
        if (i4 == -2) {
            i4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).f();
        }
        if (i4 == 0) {
            return;
        }
        if (i4 == -1) {
            i4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).g();
        }
        if (i4 < 0) {
            return;
        }
        e m4 = this.f47196a.m();
        if (i4 > 0) {
            m4.smoothScrollToPosition(i4 - 1);
            return;
        }
        View childAt = m4.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z3) {
            int b4 = b(childAt.getTop(), marginLayoutParams == null ? 0 : marginLayoutParams.topMargin, 0);
            if (b4 != 0) {
                m4.smoothScrollBy(0, b4);
                return;
            }
            return;
        }
        int b5 = b(childAt.getLeft(), marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin, 0);
        if (b5 != 0) {
            m4.smoothScrollBy(b5, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        int i5 = this.f47199d;
        if (i5 == 8) {
            a();
            return;
        }
        if (i5 == 4) {
            a(i4, ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).j() == 1, true);
        } else if (i5 == 16) {
            a(i4, ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).j() == 1);
        }
    }

    private void a() {
        int right;
        int bottom;
        e m4 = this.f47196a.m();
        View childAt = m4.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (((com.qq.e.dl.l.k.g.b) this.f47196a.i()).j() == 1) {
            if (marginLayoutParams != null && marginLayoutParams.bottomMargin != 0) {
                bottom = childAt.getBottom() + marginLayoutParams.bottomMargin;
            } else {
                bottom = childAt.getBottom();
            }
            if (bottom != 0) {
                m4.smoothScrollBy(0, bottom);
                return;
            }
            return;
        }
        if (marginLayoutParams != null && marginLayoutParams.rightMargin != 0) {
            right = childAt.getRight() + marginLayoutParams.rightMargin;
        } else {
            right = childAt.getRight();
        }
        if (right != 0) {
            m4.smoothScrollBy(right, 0);
        }
    }

    private void a(int i4, boolean z3, boolean z4) {
        e m4;
        View childAt;
        int e4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).e();
        if (e4 >= 0 && (childAt = (m4 = this.f47196a.m()).getChildAt(e4)) != null) {
            if (z3) {
                int height = m4.getHeight();
                int a4 = a(childAt.getTop(), childAt.getBottom(), height);
                if (!z4 ? a4 < 0 : a4 > 0) {
                    m4.smoothScrollBy(0, a4);
                    return;
                } else if (!z4 ? e4 <= 0 : e4 >= m4.getChildCount() - 1) {
                    View childAt2 = m4.getChildAt(z4 ? e4 + 1 : e4 - 1);
                    m4.smoothScrollBy(0, a(childAt2.getTop(), childAt2.getBottom(), height));
                    return;
                } else if (z4) {
                    a(i4, z3);
                    return;
                } else {
                    b(i4, z3);
                    return;
                }
            }
            int width = m4.getWidth();
            int a5 = a(childAt.getLeft(), childAt.getRight(), width);
            if (!z4 ? a5 < 0 : a5 > 0) {
                m4.smoothScrollBy(a5, 0);
            } else if (!z4 ? e4 <= 0 : e4 >= m4.getChildCount() - 1) {
                View childAt3 = m4.getChildAt(z4 ? e4 + 1 : e4 - 1);
                m4.smoothScrollBy(a(childAt3.getLeft(), childAt3.getRight(), width), 0);
            } else if (z4) {
                a(i4, z3);
            } else {
                b(i4, z3);
            }
        }
    }

    private void a(int i4, boolean z3) {
        if (i4 == -2) {
            i4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).h();
        }
        e m4 = this.f47196a.m();
        int itemCount = m4.getAdapter().getItemCount() - 1;
        if (i4 == itemCount) {
            return;
        }
        if (i4 == -1) {
            i4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).i();
        }
        if (i4 < 0) {
            return;
        }
        int i5 = i4 + 1;
        if (i5 <= itemCount) {
            m4.smoothScrollToPosition(i5);
            return;
        }
        View childAt = m4.getChildAt(m4.getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z3) {
            int c4 = c(childAt.getBottom(), marginLayoutParams == null ? 0 : marginLayoutParams.bottomMargin, m4.getHeight());
            if (c4 != 0) {
                m4.smoothScrollBy(0, c4);
                return;
            }
            return;
        }
        int c5 = c(childAt.getRight(), marginLayoutParams == null ? 0 : marginLayoutParams.rightMargin, m4.getWidth());
        if (c5 != 0) {
            m4.smoothScrollBy(c5, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, int i5) {
        e m4 = this.f47196a.m();
        int childCount = m4.getChildCount();
        if (childCount == 0) {
            return;
        }
        this.f47200e = true;
        boolean z3 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).j() == 1;
        if (z3) {
            i4 = i5;
        }
        int i6 = this.f47199d;
        if (i6 == 4) {
            a(z3, i4);
        } else if (i6 == 8) {
            a(z3, 0, 0, i4);
        } else {
            a(z3, childCount - 1, z3 ? m4.getHeight() : m4.getWidth(), i4);
        }
    }

    private void a(boolean z3, int i4) {
        e m4;
        View childAt;
        if (i4 > 0) {
            a(-2, z3, true);
        } else if (i4 < 0) {
            a(-2, z3, false);
        } else {
            int e4 = ((com.qq.e.dl.l.k.g.b) this.f47196a.i()).e();
            if (e4 >= 0 && (childAt = (m4 = this.f47196a.m()).getChildAt(e4)) != null) {
                if (z3) {
                    int a4 = a(childAt.getTop(), childAt.getBottom(), m4.getHeight());
                    if (a4 != 0) {
                        m4.smoothScrollBy(0, a4);
                        return;
                    }
                    return;
                }
                int a5 = a(childAt.getLeft(), childAt.getRight(), m4.getWidth());
                if (a5 != 0) {
                    m4.smoothScrollBy(a5, 0);
                }
            }
        }
    }

    private int a(int i4, int i5, int i6) {
        return ((i4 + i5) - i6) / 2;
    }

    private void a(boolean z3, int i4, int i5, int i6) {
        e m4 = this.f47196a.m();
        View childAt = m4.getChildAt(i4);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z3) {
            int a4 = a(childAt.getTop(), childAt.getBottom(), marginLayoutParams == null ? 0 : marginLayoutParams.topMargin, marginLayoutParams == null ? 0 : marginLayoutParams.bottomMargin, i5, i6);
            if (a4 != 0) {
                m4.smoothScrollBy(0, a4);
                return;
            }
            return;
        }
        int a5 = a(childAt.getLeft(), childAt.getRight(), marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin, marginLayoutParams == null ? 0 : marginLayoutParams.rightMargin, i5, i6);
        if (a5 != 0) {
            m4.smoothScrollBy(a5, 0);
        }
    }

    private int a(int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i9 > 0) {
            return c(i5, i7, i8);
        }
        if (i9 < 0) {
            return b(i4, i6, i8);
        }
        int b4 = b(i4, i6, i8);
        int c4 = c(i5, i7, i8);
        return b4 + c4 > 0 ? b4 : c4;
    }
}
