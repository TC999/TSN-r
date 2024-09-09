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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int f12951a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f12952b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12953c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12954d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f12955e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12956f = -1;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f12957g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ViewPager2 f12958h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final RecyclerView f12959i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final LinearLayoutManager f12960j;

    /* renamed from: k  reason: collision with root package name */
    private int f12961k;

    /* renamed from: l  reason: collision with root package name */
    private int f12962l;

    /* renamed from: m  reason: collision with root package name */
    private ScrollEventValues f12963m;

    /* renamed from: n  reason: collision with root package name */
    private int f12964n;

    /* renamed from: o  reason: collision with root package name */
    private int f12965o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12966p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12967q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12968r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12969s;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private @interface AdapterState {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f12970a;

        /* renamed from: b  reason: collision with root package name */
        float f12971b;

        /* renamed from: c  reason: collision with root package name */
        int f12972c;

        ScrollEventValues() {
        }

        void a() {
            this.f12970a = -1;
            this.f12971b = 0.0f;
            this.f12972c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f12958h = viewPager2;
        RecyclerView recyclerView = viewPager2.f12982j;
        this.f12959i = recyclerView;
        this.f12960j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f12963m = new ScrollEventValues();
        i();
    }

    private void a(boolean z3) {
        this.f12969s = z3;
        this.f12961k = z3 ? 4 : 1;
        int i4 = this.f12965o;
        if (i4 != -1) {
            this.f12964n = i4;
            this.f12965o = -1;
        } else if (this.f12964n == -1) {
            this.f12964n = l();
        }
        a(1);
    }

    private void i() {
        this.f12961k = 0;
        this.f12962l = 0;
        this.f12963m.a();
        this.f12964n = -1;
        this.f12965o = -1;
        this.f12966p = false;
        this.f12967q = false;
        this.f12969s = false;
        this.f12968r = false;
    }

    private void j() {
        int top2;
        ScrollEventValues scrollEventValues = this.f12963m;
        int findFirstVisibleItemPosition = this.f12960j.findFirstVisibleItemPosition();
        scrollEventValues.f12970a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f12960j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f12960j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f12960j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f12960j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f12960j.getBottomDecorationHeight(findViewByPosition);
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
        if (this.f12960j.getOrientation() == 0) {
            top2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f12959i.getPaddingLeft();
            if (this.f12958h.c()) {
                top2 = -top2;
            }
            height = width;
        } else {
            top2 = (findViewByPosition.getTop() - topDecorationHeight) - this.f12959i.getPaddingTop();
        }
        int i4 = -top2;
        scrollEventValues.f12972c = i4;
        if (i4 < 0) {
            if (new AnimateLayoutChangeDetector(this.f12960j).a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f12972c)));
        }
        scrollEventValues.f12971b = height == 0 ? 0.0f : i4 / height;
    }

    private boolean k() {
        int i4 = this.f12961k;
        return i4 == 1 || i4 == 4;
    }

    private int l() {
        return this.f12960j.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f12961k = 4;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (!f() || this.f12969s) {
            this.f12969s = false;
            j();
            ScrollEventValues scrollEventValues = this.f12963m;
            if (scrollEventValues.f12972c == 0) {
                int i4 = scrollEventValues.f12970a;
                if (i4 != this.f12964n) {
                    b(i4);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f12962l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f12962l == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f12962l == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f12969s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        j();
        ScrollEventValues scrollEventValues = this.f12963m;
        double d4 = scrollEventValues.f12970a;
        double d5 = scrollEventValues.f12971b;
        Double.isNaN(d4);
        Double.isNaN(d5);
        return d4 + d5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i4) {
        boolean z3 = true;
        if ((this.f12961k != 1 || this.f12962l != 1) && i4 == 1) {
            a(false);
        } else if (k() && i4 == 2) {
            if (this.f12967q) {
                a(2);
                this.f12966p = true;
            }
        } else {
            if (k() && i4 == 0) {
                j();
                if (!this.f12967q) {
                    int i5 = this.f12963m.f12970a;
                    if (i5 != -1) {
                        a(i5, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f12963m;
                    if (scrollEventValues.f12972c == 0) {
                        int i6 = this.f12964n;
                        int i7 = scrollEventValues.f12970a;
                        if (i6 != i7) {
                            b(i7);
                        }
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    a(0);
                    i();
                }
            }
            if (this.f12961k == 2 && i4 == 0 && this.f12968r) {
                j();
                ScrollEventValues scrollEventValues2 = this.f12963m;
                if (scrollEventValues2.f12972c == 0) {
                    int i8 = this.f12965o;
                    int i9 = scrollEventValues2.f12970a;
                    if (i8 != i9) {
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        b(i9);
                    }
                    a(0);
                    i();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if ((r5 < 0) == r3.f12958h.c()) goto L36;
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
            r3.f12967q = r4
            r3.j()
            boolean r0 = r3.f12966p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.f12966p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f12958h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12963m
            int r6 = r5.f12972c
            if (r6 == 0) goto L2f
            int r5 = r5.f12970a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12963m
            int r5 = r5.f12970a
        L33:
            r3.f12965o = r5
            int r6 = r3.f12964n
            if (r6 == r5) goto L4b
            r3.b(r5)
            goto L4b
        L3d:
            int r5 = r3.f12961k
            if (r5 != 0) goto L4b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12963m
            int r5 = r5.f12970a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.b(r5)
        L4b:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12963m
            int r6 = r5.f12970a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f12971b
            int r5 = r5.f12972c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12963m
            int r6 = r5.f12970a
            int r0 = r3.f12965o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f12972c
            if (r5 != 0) goto L71
            int r5 = r3.f12962l
            if (r5 == r4) goto L71
            r3.a(r2)
            r3.i()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i4) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12957g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f12968r = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, boolean z3) {
        this.f12961k = z3 ? 2 : 3;
        this.f12969s = false;
        boolean z4 = this.f12965o != i4;
        this.f12965o = i4;
        a(2);
        if (z4) {
            b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12957g = onPageChangeCallback;
    }

    private void a(int i4) {
        if ((this.f12961k == 3 && this.f12962l == 0) || this.f12962l == i4) {
            return;
        }
        this.f12962l = i4;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12957g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i4);
        }
    }

    private void a(int i4, float f4, int i5) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12957g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i4, f4, i5);
        }
    }
}
