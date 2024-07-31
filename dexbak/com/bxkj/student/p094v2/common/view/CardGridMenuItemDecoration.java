package com.bxkj.student.p094v2.common.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.BaseApp;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: CardGridMenuItemDecoration.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001c¨\u0006 "}, m12616d2 = {"Lcom/bxkj/student/v2/common/view/CardGridMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "", "position", "spanCount", "", "b", "c", "type", "Landroid/graphics/drawable/GradientDrawable;", "a", "Landroid/graphics/Canvas;", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Lkotlin/f1;", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "getItemOffsets", "", "F", "mCornerRadius", "I", "mOutSize", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.view.CardGridMenuItemDecoration */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class CardGridMenuItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private final float f20154a = Tools.m57620a(10.0f, BaseApp.m44341b());

    /* renamed from: b */
    private final int f20155b = Tools.m57620a(15.0f, BaseApp.m44341b());

    /* renamed from: a */
    private final GradientDrawable m39049a(int i) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i == 0) {
            float f = this.f20154a;
            fArr = new float[]{f, f, f, f, f, f, f, f};
        } else if (i == 1) {
            float f2 = this.f20154a;
            fArr = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i != 2) {
            float f3 = this.f20154a;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f3, f3, f3, f3};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    /* renamed from: b */
    private final boolean m39048b(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i, int i2) {
        if (1 <= i2) {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                if (spanSizeLookup.getSpanSize(i - i3) != 1) {
                    return false;
                }
                if (i3 == i2) {
                    break;
                }
                i3 = i4;
            }
        }
        return true;
    }

    /* renamed from: c */
    private final boolean m39047c(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i, int i2) {
        int spanGroupIndex = spanSizeLookup.getSpanGroupIndex(i, i2);
        if (1 <= i2) {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                int i5 = i + i3;
                if (spanSizeLookup.getSpanGroupIndex(i5, i2) != spanGroupIndex) {
                    return spanSizeLookup.getSpanSize(i5) == 1;
                } else if (i3 == i2) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        C14342f0.m8184p(outRect, "outRect");
        C14342f0.m8184p(view, "view");
        C14342f0.m8184p(parent, "parent");
        C14342f0.m8184p(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            if (spanSizeLookup.getSpanSize(childAdapterPosition) != 1) {
                return;
            }
            int spanCount = gridLayoutManager.getSpanCount();
            C14342f0.m8185o(spanSizeLookup, "spanSizeLookup");
            boolean m39048b = m39048b(spanSizeLookup, childAdapterPosition, spanCount);
            boolean m39047c = m39047c(spanSizeLookup, childAdapterPosition, spanCount);
            if (!m39048b) {
                outRect.top = this.f20155b;
            }
            if (m39047c) {
                return;
            }
            outRect.bottom = this.f20155b;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        C14342f0.m8184p(c, "c");
        C14342f0.m8184p(parent, "parent");
        C14342f0.m8184p(state, "state");
        int childCount = parent.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int spanCount = gridLayoutManager.getSpanCount();
                GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
                int spanSize = spanSizeLookup.getSpanSize(childAdapterPosition);
                int spanIndex = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount);
                int i3 = 1;
                if (spanSize == 1 && spanIndex == 0) {
                    C14342f0.m8185o(spanSizeLookup, "spanSizeLookup");
                    boolean m39047c = m39047c(spanSizeLookup, childAdapterPosition, spanCount);
                    boolean m39048b = m39048b(spanSizeLookup, childAdapterPosition, spanCount);
                    if (m39048b) {
                        i3 = m39047c ? 2 : 3;
                    } else if (!m39047c) {
                        i3 = 0;
                    }
                    GradientDrawable m39049a = m39049a(i3);
                    int left = childAt.getLeft();
                    int top2 = m39048b ? childAt.getTop() : childAt.getTop() - this.f20155b;
                    int left2 = childAt.getLeft() + (childAt.getWidth() * spanCount);
                    int bottom = childAt.getBottom();
                    if (!m39047c) {
                        bottom += this.f20155b;
                    }
                    m39049a.setBounds(left, top2, left2, bottom);
                    m39049a.draw(c);
                }
                if (i2 >= childCount) {
                    return;
                }
                i = i2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            }
        }
    }
}
