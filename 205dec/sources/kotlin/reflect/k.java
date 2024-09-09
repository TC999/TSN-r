package kotlin.reflect;

import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/k;", "V", "Lkotlin/reflect/o;", "Lkotlin/reflect/j;", "value", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;)V", "Lkotlin/reflect/k$a;", "getSetter", "()Lkotlin/reflect/k$a;", "setter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface k<V> extends o<V>, j<V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/k$a;", "V", "Lkotlin/reflect/j$a;", "Lkotlin/Function1;", "Lkotlin/f1;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a<V> extends j.a<V>, d2.l<V, f1> {
    }

    @NotNull
    a<V> getSetter();

    void set(V v3);
}
