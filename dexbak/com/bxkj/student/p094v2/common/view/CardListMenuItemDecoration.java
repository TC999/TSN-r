package com.bxkj.student.p094v2.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.BaseApp;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: CardListMenuItemDecoration.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0019¨\u0006("}, m12616d2 = {"Lcom/bxkj/student/v2/common/view/CardListMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "position", "", "b", "c", "type", "Landroid/graphics/drawable/GradientDrawable;", "a", "Landroid/graphics/Canvas;", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Lkotlin/f1;", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "getItemOffsets", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "I", "mOutSize", "", "F", "mCornerRadius", "d", "dividerColor", "e", "dividerLineWidth", "f", "dividerLineMarginLeft", "g", "dividerLineMarginRight", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.view.CardListMenuItemDecoration */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class CardListMenuItemDecoration extends RecyclerView.ItemDecoration {
    @NotNull

    /* renamed from: a */
    private final Paint f20156a = new Paint(1);

    /* renamed from: b */
    private final int f20157b = Tools.m57620a(10.0f, BaseApp.m44341b());

    /* renamed from: c */
    private final float f20158c = Tools.m57620a(10.0f, BaseApp.m44341b());

    /* renamed from: d */
    private int f20159d = C4215R.C4217color.defaultBackgroundColor;

    /* renamed from: e */
    private final int f20160e = Tools.m57620a(1.0f, BaseApp.m44341b());

    /* renamed from: f */
    private final int f20161f = Tools.m57620a(55.0f, BaseApp.m44341b());

    /* renamed from: g */
    private final int f20162g = Tools.m57620a(10.0f, BaseApp.m44341b());

    /* renamed from: a */
    private final GradientDrawable m39046a(int i) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i == 0) {
            float f = this.f20158c;
            fArr = new float[]{f, f, f, f, f, f, f, f};
        } else if (i == 1) {
            float f2 = this.f20158c;
            fArr = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i != 2) {
            float f3 = this.f20158c;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f3, f3, f3, f3};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    /* renamed from: b */
    private final boolean m39045b(RecyclerView recyclerView, int i) {
        if (i == 0) {
            return true;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemViewType(i));
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        return !C14342f0.m8193g(valueOf, adapter2 != null ? Integer.valueOf(adapter2.getItemViewType(i - 1)) : null);
    }

    /* renamed from: c */
    private final boolean m39044c(RecyclerView recyclerView, int i) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (i == (adapter == null ? 0 : adapter.getItemCount() - 1)) {
            return true;
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Integer valueOf = adapter2 == null ? null : Integer.valueOf(adapter2.getItemViewType(i));
        RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
        return !C14342f0.m8193g(valueOf, adapter3 != null ? Integer.valueOf(adapter3.getItemViewType(i + 1)) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        C14342f0.m8184p(outRect, "outRect");
        C14342f0.m8184p(view, "view");
        C14342f0.m8184p(parent, "parent");
        C14342f0.m8184p(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        boolean z = false;
        if (adapter != null && adapter.getItemViewType(childAdapterPosition) == 0) {
            z = true;
        }
        if (z) {
            return;
        }
        boolean m39045b = m39045b(parent, childAdapterPosition);
        boolean m39044c = m39044c(parent, childAdapterPosition);
        if (m39045b) {
            outRect.top = this.f20157b;
        }
        if (m39044c) {
            outRect.bottom = this.f20157b;
        } else {
            outRect.bottom = this.f20160e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        C14342f0.m8184p(c, "c");
        C14342f0.m8184p(parent, "parent");
        C14342f0.m8184p(state, "state");
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            RecyclerView.Adapter adapter = parent.getAdapter();
            int i3 = 1;
            if (!(adapter != null && adapter.getItemViewType(i) == 0)) {
                View childAt = parent.getChildAt(i);
                int childAdapterPosition = parent.getChildAdapterPosition(childAt);
                boolean m39045b = m39045b(parent, childAdapterPosition);
                boolean m39044c = m39044c(parent, childAdapterPosition);
                if (m39045b && m39044c) {
                    i3 = 0;
                } else if (!m39045b || m39044c) {
                    i3 = (!m39044c || m39045b) ? 2 : 3;
                }
                GradientDrawable m39046a = m39046a(i3);
                m39046a.setBounds(childAt.getLeft(), !m39045b ? childAt.getTop() : childAt.getTop() - this.f20157b, childAt.getLeft() + childAt.getWidth(), childAt.getBottom() + (!m39044c ? this.f20160e : this.f20157b));
                m39046a.draw(c);
                if (!m39044c) {
                    this.f20156a.setColor(ContextCompat.getColor(parent.getContext(), this.f20159d));
                    this.f20156a.setStrokeWidth(this.f20160e);
                    c.drawLine(childAt.getLeft() + this.f20161f, childAt.getBottom() + this.f20160e, childAt.getRight() - this.f20162g, childAt.getBottom() + this.f20160e, this.f20156a);
                }
            }
            if (i2 >= childCount) {
                return;
            }
            i = i2;
        }
    }
}