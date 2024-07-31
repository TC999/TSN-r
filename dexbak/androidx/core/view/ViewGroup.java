package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.RequiresApi;
import com.beizi.fusion.widget.ScrollClickView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.ccg.CcgConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a0\u0010\u0011\u001a\u00020\b*\u00020\u00002!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\rH\u0086\b\u001aE\u0010\u0013\u001a\u00020\b*\u00020\u000026\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0012H\u0086\b\u001a\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014*\u00020\u0000H\u0086\u0002\u001a\u0017\u0010\u0018\u001a\u00020\b*\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0001H\u0086\b\u001a5\u0010\u001d\u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u0019\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001b\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0086\b\u001a5\u0010 \u001a\u00020\b*\u00020\u00162\b\b\u0003\u0010\u001e\u001a\u00020\u00012\b\b\u0003\u0010\u001a\u001a\u00020\u00012\b\b\u0003\u0010\u001f\u001a\u00020\u00012\b\b\u0003\u0010\u001c\u001a\u00020\u0001H\u0087\b\"\u0016\u0010\u0017\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, m12616d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", "get", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "contains", "Lkotlin/f1;", "plusAssign", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CcgConstant.f38549t, "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", ScrollClickView.DIR_LEFT, "top", ScrollClickView.DIR_RIGHT, "bottom", "updateMargins", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "updateMarginsRelative", "getSize", "(Landroid/view/ViewGroup;)I", "Lkotlin/sequences/m;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/m;", "children", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.view.ViewGroupKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewGroup {
    public static final boolean contains(@NotNull android.view.ViewGroup contains, @NotNull View view) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(view, "view");
        return contains.indexOfChild(view) != -1;
    }

    public static final void forEach(@NotNull android.view.ViewGroup forEach, @NotNull InterfaceC15280l<? super View, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
        int childCount = forEach.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = forEach.getChildAt(i);
            C14342f0.m8192h(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@NotNull android.view.ViewGroup forEachIndexed, @NotNull InterfaceC15284p<? super Integer, ? super View, Unit> action) {
        C14342f0.m8183q(forEachIndexed, "$this$forEachIndexed");
        C14342f0.m8183q(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Integer valueOf = Integer.valueOf(i);
            View childAt = forEachIndexed.getChildAt(i);
            C14342f0.m8192h(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
        }
    }

    @NotNull
    public static final View get(@NotNull android.view.ViewGroup get, int i) {
        C14342f0.m8183q(get, "$this$get");
        View childAt = get.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + get.getChildCount());
    }

    @NotNull
    public static final Sequence<View> getChildren(@NotNull final android.view.ViewGroup children) {
        C14342f0.m8183q(children, "$this$children");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroup.iterator(children);
            }
        };
    }

    public static final int getSize(@NotNull android.view.ViewGroup size) {
        C14342f0.m8183q(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(@NotNull android.view.ViewGroup isEmpty) {
        C14342f0.m8183q(isEmpty, "$this$isEmpty");
        return isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull android.view.ViewGroup isNotEmpty) {
        C14342f0.m8183q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getChildCount() != 0;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull android.view.ViewGroup iterator) {
        C14342f0.m8183q(iterator, "$this$iterator");
        return new ViewGroupKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull android.view.ViewGroup minusAssign, @NotNull View view) {
        C14342f0.m8183q(minusAssign, "$this$minusAssign");
        C14342f0.m8183q(view, "view");
        minusAssign.removeView(view);
    }

    public static final void plusAssign(@NotNull android.view.ViewGroup plusAssign, @NotNull View view) {
        C14342f0.m8183q(plusAssign, "$this$plusAssign");
        C14342f0.m8183q(view, "view");
        plusAssign.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams setMargins, @InterfaceC0075Px int i) {
        C14342f0.m8183q(setMargins, "$this$setMargins");
        setMargins.setMargins(i, i, i, i);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams updateMargins, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        C14342f0.m8183q(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams updateMargins, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMargins.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = updateMargins.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMargins.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = updateMargins.bottomMargin;
        }
        C14342f0.m8183q(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams updateMarginsRelative, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        C14342f0.m8183q(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams updateMarginsRelative, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMarginsRelative.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = updateMarginsRelative.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMarginsRelative.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = updateMarginsRelative.bottomMargin;
        }
        C14342f0.m8183q(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }
}
