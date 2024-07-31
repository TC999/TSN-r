package androidx.core.view;

import android.view.MenuItem;
import com.umeng.ccg.CcgConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a0\u0010\u0010\u001a\u00020\b*\u00020\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\fH\u0086\b\u001aE\u0010\u0012\u001a\u00020\b*\u00020\u000026\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0011H\u0086\b\u001a\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\u0000H\u0086\u0002\"\u0016\u0010\u0017\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m12616d2 = {"Landroid/view/Menu;", "", "index", "Landroid/view/MenuItem;", "get", "item", "", "contains", "Lkotlin/f1;", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CcgConstant.f38549t, "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "getSize", "(Landroid/view/Menu;)I", "size", "Lkotlin/sequences/m;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/m;", "children", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.view.MenuKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Menu {
    public static final boolean contains(@NotNull android.view.Menu contains, @NotNull MenuItem item) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(item, "item");
        int size = contains.size();
        for (int i = 0; i < size; i++) {
            if (C14342f0.m8193g(contains.getItem(i), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull android.view.Menu forEach, @NotNull InterfaceC15280l<? super MenuItem, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = forEach.getItem(i);
            C14342f0.m8192h(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull android.view.Menu forEachIndexed, @NotNull InterfaceC15284p<? super Integer, ? super MenuItem, Unit> action) {
        C14342f0.m8183q(forEachIndexed, "$this$forEachIndexed");
        C14342f0.m8183q(action, "action");
        int size = forEachIndexed.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = forEachIndexed.getItem(i);
            C14342f0.m8192h(item, "getItem(index)");
            action.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull android.view.Menu get, int i) {
        C14342f0.m8183q(get, "$this$get");
        MenuItem item = get.getItem(i);
        C14342f0.m8192h(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull final android.view.Menu children) {
        C14342f0.m8183q(children, "$this$children");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<MenuItem> iterator() {
                return Menu.iterator(children);
            }
        };
    }

    public static final int getSize(@NotNull android.view.Menu size) {
        C14342f0.m8183q(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull android.view.Menu isEmpty) {
        C14342f0.m8183q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull android.view.Menu isNotEmpty) {
        C14342f0.m8183q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull android.view.Menu iterator) {
        C14342f0.m8183q(iterator, "$this$iterator");
        return new MenuKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull android.view.Menu minusAssign, @NotNull MenuItem item) {
        C14342f0.m8183q(minusAssign, "$this$minusAssign");
        C14342f0.m8183q(item, "item");
        minusAssign.removeItem(item.getItemId());
    }
}
