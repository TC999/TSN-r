package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.acse.ottn.f3;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import d2.p;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewGroup.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a0\u0010\u0011\u001a\u00020\b*\u00020\u00002!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\rH\u0086\b\u001aE\u0010\u0013\u001a\u00020\b*\u00020\u000026\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0012H\u0086\b\u001a\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014*\u00020\u0000H\u0086\u0002\u001a\u0017\u0010\u0018\u001a\u00020\b*\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0001H\u0086\b\u001a5\u0010\u001d\u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u0019\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001b\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0086\b\u001a5\u0010 \u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u001e\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001f\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0087\b\"\u0016\u0010\u0017\u001a\u00020\u0001*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\"\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", f3.f5657f, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "contains", "Lkotlin/f1;", "plusAssign", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", "left", "top", "right", "bottom", "updateMargins", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "updateMarginsRelative", "getSize", "(Landroid/view/ViewGroup;)I", "Lkotlin/sequences/m;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/m;", "children", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewGroupKt {
    public static final boolean contains(@NotNull ViewGroup contains, @NotNull View view) {
        f0.q(contains, "$this$contains");
        f0.q(view, "view");
        return contains.indexOfChild(view) != -1;
    }

    public static final void forEach(@NotNull ViewGroup forEach, @NotNull l<? super View, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int childCount = forEach.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = forEach.getChildAt(i4);
            f0.h(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup forEachIndexed, @NotNull p<? super Integer, ? super View, f1> action) {
        f0.q(forEachIndexed, "$this$forEachIndexed");
        f0.q(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            Integer valueOf = Integer.valueOf(i4);
            View childAt = forEachIndexed.getChildAt(i4);
            f0.h(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup get, int i4) {
        f0.q(get, "$this$get");
        View childAt = get.getChildAt(i4);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + get.getChildCount());
    }

    @NotNull
    public static final m<View> getChildren(@NotNull final ViewGroup children) {
        f0.q(children, "$this$children");
        return new m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.m
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(children);
            }
        };
    }

    public static final int getSize(@NotNull ViewGroup size) {
        f0.q(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getChildCount() != 0;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup iterator) {
        f0.q(iterator, "$this$iterator");
        return new ViewGroupKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull ViewGroup minusAssign, @NotNull View view) {
        f0.q(minusAssign, "$this$minusAssign");
        f0.q(view, "view");
        minusAssign.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup plusAssign, @NotNull View view) {
        f0.q(plusAssign, "$this$plusAssign");
        f0.q(view, "view");
        plusAssign.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams setMargins, @Px int i4) {
        f0.q(setMargins, "$this$setMargins");
        setMargins.setMargins(i4, i4, i4, i4);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams updateMargins, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        f0.q(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams updateMargins, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = updateMargins.leftMargin;
        }
        if ((i8 & 2) != 0) {
            i5 = updateMargins.topMargin;
        }
        if ((i8 & 4) != 0) {
            i6 = updateMargins.rightMargin;
        }
        if ((i8 & 8) != 0) {
            i7 = updateMargins.bottomMargin;
        }
        f0.q(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i4, i5, i6, i7);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams updateMarginsRelative, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        f0.q(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i4);
        updateMarginsRelative.topMargin = i5;
        updateMarginsRelative.setMarginEnd(i6);
        updateMarginsRelative.bottomMargin = i7;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams updateMarginsRelative, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = updateMarginsRelative.getMarginStart();
        }
        if ((i8 & 2) != 0) {
            i5 = updateMarginsRelative.topMargin;
        }
        if ((i8 & 4) != 0) {
            i6 = updateMarginsRelative.getMarginEnd();
        }
        if ((i8 & 8) != 0) {
            i7 = updateMarginsRelative.bottomMargin;
        }
        f0.q(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i4);
        updateMarginsRelative.topMargin = i5;
        updateMarginsRelative.setMarginEnd(i6);
        updateMarginsRelative.bottomMargin = i7;
    }
}
