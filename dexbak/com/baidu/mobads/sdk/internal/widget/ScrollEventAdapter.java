package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private static final int f9165a = 0;

    /* renamed from: b */
    private static final int f9166b = 1;

    /* renamed from: c */
    private static final int f9167c = 2;

    /* renamed from: d */
    private static final int f9168d = 3;

    /* renamed from: e */
    private static final int f9169e = 4;

    /* renamed from: f */
    private static final int f9170f = -1;

    /* renamed from: g */
    private ViewPager2.OnPageChangeCallback f9171g;
    @NonNull

    /* renamed from: h */
    private final ViewPager2 f9172h;
    @NonNull

    /* renamed from: i */
    private final RecyclerView f9173i;
    @NonNull

    /* renamed from: j */
    private final LinearLayoutManager f9174j;

    /* renamed from: k */
    private int f9175k;

    /* renamed from: l */
    private int f9176l;

    /* renamed from: m */
    private ScrollEventValues f9177m;

    /* renamed from: n */
    private int f9178n;

    /* renamed from: o */
    private int f9179o;

    /* renamed from: p */
    private boolean f9180p;

    /* renamed from: q */
    private boolean f9181q;

    /* renamed from: r */
    private boolean f9182r;

    /* renamed from: s */
    private boolean f9183s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private @interface AdapterState {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class ScrollEventValues {

        /* renamed from: a */
        int f9184a;

        /* renamed from: b */
        float f9185b;

        /* renamed from: c */
        int f9186c;

        ScrollEventValues() {
        }

        /* renamed from: a */
        void m50252a() {
            this.f9184a = -1;
            this.f9185b = 0.0f;
            this.f9186c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f9172h = viewPager2;
        RecyclerView recyclerView = viewPager2.f9198j;
        this.f9173i = recyclerView;
        this.f9174j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f9177m = new ScrollEventValues();
        m50256i();
    }

    /* renamed from: a */
    private void m50265a(boolean z) {
        this.f9183s = z;
        this.f9175k = z ? 4 : 1;
        int i = this.f9179o;
        if (i != -1) {
            this.f9178n = i;
            this.f9179o = -1;
        } else if (this.f9178n == -1) {
            this.f9178n = m50253l();
        }
        m50269a(1);
    }

    /* renamed from: i */
    private void m50256i() {
        this.f9175k = 0;
        this.f9176l = 0;
        this.f9177m.m50252a();
        this.f9178n = -1;
        this.f9179o = -1;
        this.f9180p = false;
        this.f9181q = false;
        this.f9183s = false;
        this.f9182r = false;
    }

    /* renamed from: j */
    private void m50255j() {
        int top2;
        ScrollEventValues scrollEventValues = this.f9177m;
        int findFirstVisibleItemPosition = this.f9174j.findFirstVisibleItemPosition();
        scrollEventValues.f9184a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.m50252a();
            return;
        }
        View findViewByPosition = this.f9174j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.m50252a();
            return;
        }
        int leftDecorationWidth = this.f9174j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f9174j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f9174j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f9174j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f9174j.getOrientation() == 0) {
            top2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f9173i.getPaddingLeft();
            if (this.f9172h.m50244c()) {
                top2 = -top2;
            }
            height = width;
        } else {
            top2 = (findViewByPosition.getTop() - topDecorationHeight) - this.f9173i.getPaddingTop();
        }
        int i = -top2;
        scrollEventValues.f9186c = i;
        if (i < 0) {
            if (new AnimateLayoutChangeDetector(this.f9174j).m50297a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f9186c)));
        }
        scrollEventValues.f9185b = height == 0 ? 0.0f : i / height;
    }

    /* renamed from: k */
    private boolean m50254k() {
        int i = this.f9175k;
        return i == 1 || i == 4;
    }

    /* renamed from: l */
    private int m50253l() {
        return this.f9174j.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m50264b() {
        this.f9175k = 4;
        m50265a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m50262c() {
        if (!m50259f() || this.f9183s) {
            this.f9183s = false;
            m50255j();
            ScrollEventValues scrollEventValues = this.f9177m;
            if (scrollEventValues.f9186c == 0) {
                int i = scrollEventValues.f9184a;
                if (i != this.f9178n) {
                    m50263b(i);
                }
                m50269a(0);
                m50256i();
                return;
            }
            m50269a(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m50261d() {
        return this.f9176l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m50260e() {
        return this.f9176l == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m50259f() {
        return this.f9176l == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m50258g() {
        return this.f9183s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public double m50257h() {
        m50255j();
        ScrollEventValues scrollEventValues = this.f9177m;
        double d = scrollEventValues.f9184a;
        double d2 = scrollEventValues.f9185b;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d + d2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        boolean z = true;
        if ((this.f9175k != 1 || this.f9176l != 1) && i == 1) {
            m50265a(false);
        } else if (m50254k() && i == 2) {
            if (this.f9181q) {
                m50269a(2);
                this.f9180p = true;
            }
        } else {
            if (m50254k() && i == 0) {
                m50255j();
                if (!this.f9181q) {
                    int i2 = this.f9177m.f9184a;
                    if (i2 != -1) {
                        m50268a(i2, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f9177m;
                    if (scrollEventValues.f9186c == 0) {
                        int i3 = this.f9178n;
                        int i4 = scrollEventValues.f9184a;
                        if (i3 != i4) {
                            m50263b(i4);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    m50269a(0);
                    m50256i();
                }
            }
            if (this.f9175k == 2 && i == 0 && this.f9182r) {
                m50255j();
                ScrollEventValues scrollEventValues2 = this.f9177m;
                if (scrollEventValues2.f9186c == 0) {
                    int i5 = this.f9179o;
                    int i6 = scrollEventValues2.f9184a;
                    if (i5 != i6) {
                        if (i6 == -1) {
                            i6 = 0;
                        }
                        m50263b(i6);
                    }
                    m50269a(0);
                    m50256i();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if ((r5 < 0) == r3.f9172h.m50244c()) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f9181q = r4
            r3.m50255j()
            boolean r0 = r3.f9180p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.f9180p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f9172h
            boolean r6 = r6.m50244c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f9177m
            int r6 = r5.f9186c
            if (r6 == 0) goto L2f
            int r5 = r5.f9184a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f9177m
            int r5 = r5.f9184a
        L33:
            r3.f9179o = r5
            int r6 = r3.f9178n
            if (r6 == r5) goto L4b
            r3.m50263b(r5)
            goto L4b
        L3d:
            int r5 = r3.f9175k
            if (r5 != 0) goto L4b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f9177m
            int r5 = r5.f9184a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.m50263b(r5)
        L4b:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f9177m
            int r6 = r5.f9184a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f9185b
            int r5 = r5.f9186c
            r3.m50268a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f9177m
            int r6 = r5.f9184a
            int r0 = r3.f9179o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f9186c
            if (r5 != 0) goto L71
            int r5 = r3.f9176l
            if (r5 == r4) goto L71
            r3.m50269a(r2)
            r3.m50256i()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* renamed from: b */
    private void m50263b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f9171g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m50270a() {
        this.f9182r = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m50267a(int i, boolean z) {
        this.f9175k = z ? 2 : 3;
        this.f9183s = false;
        boolean z2 = this.f9179o != i;
        this.f9179o = i;
        m50269a(2);
        if (z2) {
            m50263b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m50266a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f9171g = onPageChangeCallback;
    }

    /* renamed from: a */
    private void m50269a(int i) {
        if ((this.f9175k == 3 && this.f9176l == 0) || this.f9176l == i) {
            return;
        }
        this.f9176l = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f9171g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: a */
    private void m50268a(int i, float f, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f9171g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f, i2);
        }
    }
}
