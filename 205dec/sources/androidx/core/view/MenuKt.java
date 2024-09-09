package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.acse.ottn.f3;
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
/* compiled from: Menu.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0086\b\u001a0\u0010\u0010\u001a\u00020\b*\u00020\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\fH\u0086\b\u001aE\u0010\u0012\u001a\u00020\b*\u00020\u000026\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u0011H\u0086\b\u001a\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\u0000H\u0086\u0002\"\u0016\u0010\u0017\u001a\u00020\u0001*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Landroid/view/Menu;", "", "index", "Landroid/view/MenuItem;", f3.f5657f, "item", "", "contains", "Lkotlin/f1;", "minusAssign", "isEmpty", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/Function2;", "forEachIndexed", "", "iterator", "getSize", "(Landroid/view/Menu;)I", "size", "Lkotlin/sequences/m;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/m;", "children", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class MenuKt {
    public static final boolean contains(@NotNull Menu contains, @NotNull MenuItem item) {
        f0.q(contains, "$this$contains");
        f0.q(item, "item");
        int size = contains.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (f0.g(contains.getItem(i4), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu forEach, @NotNull l<? super MenuItem, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int size = forEach.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = forEach.getItem(i4);
            f0.h(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu forEachIndexed, @NotNull p<? super Integer, ? super MenuItem, f1> action) {
        f0.q(forEachIndexed, "$this$forEachIndexed");
        f0.q(action, "action");
        int size = forEachIndexed.size();
        for (int i4 = 0; i4 < size; i4++) {
            Integer valueOf = Integer.valueOf(i4);
            MenuItem item = forEachIndexed.getItem(i4);
            f0.h(item, "getItem(index)");
            action.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu get, int i4) {
        f0.q(get, "$this$get");
        MenuItem item = get.getItem(i4);
        f0.h(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final m<MenuItem> getChildren(@NotNull final Menu children) {
        f0.q(children, "$this$children");
        return new m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.m
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(children);
            }
        };
    }

    public static final int getSize(@NotNull Menu size) {
        f0.q(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull Menu isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu iterator) {
        f0.q(iterator, "$this$iterator");
        return new MenuKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull Menu minusAssign, @NotNull MenuItem item) {
        f0.q(minusAssign, "$this$minusAssign");
        f0.q(item, "item");
        minusAssign.removeItem(item.getItemId());
    }
}
