package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.BaseApp;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: CardGridMenuItemDecoration.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/bxkj/student/v2/common/view/CardGridMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "", "position", "spanCount", "", "b", "c", "type", "Landroid/graphics/drawable/GradientDrawable;", "a", "Landroid/graphics/Canvas;", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Lkotlin/f1;", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "getItemOffsets", "", "F", "mCornerRadius", "I", "mOutSize", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CardGridMenuItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final float f23406a = u.a(10.0f, BaseApp.b());

    /* renamed from: b  reason: collision with root package name */
    private final int f23407b = u.a(15.0f, BaseApp.b());

    private final GradientDrawable a(int i4) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i4 == 0) {
            float f4 = this.f23406a;
            fArr = new float[]{f4, f4, f4, f4, f4, f4, f4, f4};
        } else if (i4 == 1) {
            float f5 = this.f23406a;
            fArr = new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i4 != 2) {
            float f6 = this.f23406a;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f6, f6, f6, f6};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    private final boolean b(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i4, int i5) {
        if (1 <= i5) {
            int i6 = 1;
            while (true) {
                int i7 = i6 + 1;
                if (spanSizeLookup.getSpanSize(i4 - i6) != 1) {
                    return false;
                }
                if (i6 == i5) {
                    break;
                }
                i6 = i7;
            }
        }
        return true;
    }

    private final boolean c(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i4, int i5) {
        int spanGroupIndex = spanSizeLookup.getSpanGroupIndex(i4, i5);
        if (1 <= i5) {
            int i6 = 1;
            while (true) {
                int i7 = i6 + 1;
                int i8 = i4 + i6;
                if (spanSizeLookup.getSpanGroupIndex(i8, i5) != spanGroupIndex) {
                    return spanSizeLookup.getSpanSize(i8) == 1;
                } else if (i6 == i5) {
                    break;
                } else {
                    i6 = i7;
                }
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        f0.p(outRect, "outRect");
        f0.p(view, "view");
        f0.p(parent, "parent");
        f0.p(state, "state");
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
            f0.o(spanSizeLookup, "spanSizeLookup");
            boolean b4 = b(spanSizeLookup, childAdapterPosition, spanCount);
            boolean c4 = c(spanSizeLookup, childAdapterPosition, spanCount);
            if (!b4) {
                outRect.top = this.f23407b;
            }
            if (c4) {
                return;
            }
            outRect.bottom = this.f23407b;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c4, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        f0.p(c4, "c");
        f0.p(parent, "parent");
        f0.p(state, "state");
        int childCount = parent.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            View childAt = parent.getChildAt(i4);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int spanCount = gridLayoutManager.getSpanCount();
                GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
                int spanSize = spanSizeLookup.getSpanSize(childAdapterPosition);
                int spanIndex = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount);
                int i6 = 1;
                if (spanSize == 1 && spanIndex == 0) {
                    f0.o(spanSizeLookup, "spanSizeLookup");
                    boolean c5 = c(spanSizeLookup, childAdapterPosition, spanCount);
                    boolean b4 = b(spanSizeLookup, childAdapterPosition, spanCount);
                    if (b4) {
                        i6 = c5 ? 2 : 3;
                    } else if (!c5) {
                        i6 = 0;
                    }
                    GradientDrawable a4 = a(i6);
                    int left = childAt.getLeft();
                    int top2 = b4 ? childAt.getTop() : childAt.getTop() - this.f23407b;
                    int left2 = childAt.getLeft() + (childAt.getWidth() * spanCount);
                    int bottom = childAt.getBottom();
                    if (!c5) {
                        bottom += this.f23407b;
                    }
                    a4.setBounds(left, top2, left2, bottom);
                    a4.draw(c4);
                }
                if (i5 >= childCount) {
                    return;
                }
                i4 = i5;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            }
        }
    }
}
