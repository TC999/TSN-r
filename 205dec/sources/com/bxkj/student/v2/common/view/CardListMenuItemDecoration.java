package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
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
/* compiled from: CardListMenuItemDecoration.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/bxkj/student/v2/common/view/CardListMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "position", "", "b", "c", "type", "Landroid/graphics/drawable/GradientDrawable;", "a", "Landroid/graphics/Canvas;", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Lkotlin/f1;", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "getItemOffsets", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "I", "mOutSize", "", "F", "mCornerRadius", "d", "dividerColor", "e", "dividerLineWidth", "f", "dividerLineMarginLeft", "g", "dividerLineMarginRight", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CardListMenuItemDecoration extends RecyclerView.ItemDecoration {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f23408a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final int f23409b = u.a(10.0f, BaseApp.b());

    /* renamed from: c  reason: collision with root package name */
    private final float f23410c = u.a(10.0f, BaseApp.b());

    /* renamed from: d  reason: collision with root package name */
    private int f23411d = 2131034208;

    /* renamed from: e  reason: collision with root package name */
    private final int f23412e = u.a(1.0f, BaseApp.b());

    /* renamed from: f  reason: collision with root package name */
    private final int f23413f = u.a(55.0f, BaseApp.b());

    /* renamed from: g  reason: collision with root package name */
    private final int f23414g = u.a(10.0f, BaseApp.b());

    private final GradientDrawable a(int i4) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i4 == 0) {
            float f4 = this.f23410c;
            fArr = new float[]{f4, f4, f4, f4, f4, f4, f4, f4};
        } else if (i4 == 1) {
            float f5 = this.f23410c;
            fArr = new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i4 != 2) {
            float f6 = this.f23410c;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f6, f6, f6, f6};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    private final boolean b(RecyclerView recyclerView, int i4) {
        if (i4 == 0) {
            return true;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemViewType(i4));
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        return !f0.g(valueOf, adapter2 != null ? Integer.valueOf(adapter2.getItemViewType(i4 - 1)) : null);
    }

    private final boolean c(RecyclerView recyclerView, int i4) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (i4 == (adapter == null ? 0 : adapter.getItemCount() - 1)) {
            return true;
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Integer valueOf = adapter2 == null ? null : Integer.valueOf(adapter2.getItemViewType(i4));
        RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
        return !f0.g(valueOf, adapter3 != null ? Integer.valueOf(adapter3.getItemViewType(i4 + 1)) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        f0.p(outRect, "outRect");
        f0.p(view, "view");
        f0.p(parent, "parent");
        f0.p(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        boolean z3 = false;
        if (adapter != null && adapter.getItemViewType(childAdapterPosition) == 0) {
            z3 = true;
        }
        if (z3) {
            return;
        }
        boolean b4 = b(parent, childAdapterPosition);
        boolean c4 = c(parent, childAdapterPosition);
        if (b4) {
            outRect.top = this.f23409b;
        }
        if (c4) {
            outRect.bottom = this.f23409b;
        } else {
            outRect.bottom = this.f23412e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c4, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        f0.p(c4, "c");
        f0.p(parent, "parent");
        f0.p(state, "state");
        super.onDraw(c4, parent, state);
        int childCount = parent.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            RecyclerView.Adapter adapter = parent.getAdapter();
            int i6 = 1;
            if (!(adapter != null && adapter.getItemViewType(i4) == 0)) {
                View childAt = parent.getChildAt(i4);
                int childAdapterPosition = parent.getChildAdapterPosition(childAt);
                boolean b4 = b(parent, childAdapterPosition);
                boolean c5 = c(parent, childAdapterPosition);
                if (b4 && c5) {
                    i6 = 0;
                } else if (!b4 || c5) {
                    i6 = (!c5 || b4) ? 2 : 3;
                }
                GradientDrawable a4 = a(i6);
                a4.setBounds(childAt.getLeft(), !b4 ? childAt.getTop() : childAt.getTop() - this.f23409b, childAt.getLeft() + childAt.getWidth(), childAt.getBottom() + (!c5 ? this.f23412e : this.f23409b));
                a4.draw(c4);
                if (!c5) {
                    this.f23408a.setColor(ContextCompat.getColor(parent.getContext(), this.f23411d));
                    this.f23408a.setStrokeWidth(this.f23412e);
                    c4.drawLine(childAt.getLeft() + this.f23413f, childAt.getBottom() + this.f23412e, childAt.getRight() - this.f23414g, childAt.getBottom() + this.f23412e, this.f23408a);
                }
            }
            if (i5 >= childCount) {
                return;
            }
            i4 = i5;
        }
    }
}
