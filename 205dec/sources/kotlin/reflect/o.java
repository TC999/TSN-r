package kotlin.reflect;

import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fJ\u000f\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/o;", "V", "Lkotlin/reflect/n;", "Lkotlin/Function0;", f3.f5657f, "()Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/o$a;", "getGetter", "()Lkotlin/reflect/o$a;", "getter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface o<V> extends n<V>, d2.a<V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlin/reflect/o$a;", "V", "Lkotlin/reflect/n$c;", "Lkotlin/Function0;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a<V> extends n.c<V>, d2.a<V> {
    }

    V get();

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate();

    @Override // kotlin.reflect.n
    @NotNull
    a<V> getGetter();
}
