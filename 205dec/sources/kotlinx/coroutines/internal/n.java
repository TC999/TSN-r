package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: InlineList.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J$\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/n;", "E", "", "element", "h", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/f1;", "action", "f", "(Ljava/lang/Object;Ld2/l;)V", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "holder", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f60381a;

    private /* synthetic */ n(@Nullable Object obj) {
        this.f60381a = obj;
    }

    @NotNull
    public static final /* synthetic */ n a(@Nullable Object obj) {
        return new n(obj);
    }

    @NotNull
    public static Object b(@Nullable Object obj) {
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, int i4, kotlin.jvm.internal.u uVar) {
        if ((i4 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof n) && kotlin.jvm.internal.f0.g(obj, ((n) obj2).j());
    }

    public static final boolean e(@Nullable Object obj, @Nullable Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    public static final void f(Object obj, @NotNull d2.l<? super E, f1> lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.invoke(obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            lVar.invoke((Object) arrayList.get(size));
        }
    }

    public static int g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NotNull
    public static final Object h(Object obj, E e4) {
        if (obj == null) {
            return b(e4);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e4);
            return b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e4);
        return b(arrayList);
    }

    @NotNull
    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return d(this.f60381a, obj);
    }

    public int hashCode() {
        return g(this.f60381a);
    }

    @Nullable
    public final /* synthetic */ Object j() {
        return this.f60381a;
    }

    public String toString() {
        return i(this.f60381a);
    }
}
