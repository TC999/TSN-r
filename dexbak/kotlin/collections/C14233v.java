package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"kotlin/collections/w", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/x", "kotlin/collections/y", "kotlin/collections/z", "kotlin/collections/a0", "kotlin/collections/b0", "kotlin/collections/c0", "kotlin/collections/d0", "kotlin/collections/e0"}, m12616d2 = {}, m12615k = 4, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14233v extends _Collections {
    private C14233v() {
    }

    /* renamed from: G */
    public static /* bridge */ /* synthetic */ int m9027G(@NotNull List list) {
        return CollectionsKt__CollectionsKt.m12476G(list);
    }

    @NotNull
    /* renamed from: I5 */
    public static /* bridge */ /* synthetic */ List m9025I5(@NotNull Iterable iterable) {
        return _Collections.m12233I5(iterable);
    }

    /* renamed from: P0 */
    public static /* bridge */ /* synthetic */ boolean m9018P0(@NotNull Iterable iterable, @NotNull InterfaceC15280l interfaceC15280l) {
        return MutableCollections.m12423P0(iterable, interfaceC15280l);
    }

    /* renamed from: S4 */
    public static /* bridge */ /* synthetic */ Object m9014S4(@NotNull Iterable iterable) {
        return _Collections.m12184S4(iterable);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: W */
    public static /* bridge */ /* synthetic */ void m9012W() {
        CollectionsKt__CollectionsKt.m12460W();
    }

    /* renamed from: X2 */
    public static /* bridge */ /* synthetic */ Appendable m9011X2(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC15280l interfaceC15280l, int i2, Object obj) {
        Appendable m12166W2;
        m12166W2 = _Collections.m12166W2(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : interfaceC15280l);
        return m12166W2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    /* renamed from: X3 */
    public static /* bridge */ /* synthetic */ Comparable m9010X3(@NotNull Iterable iterable) {
        return _Collections.m12160X3(iterable);
    }

    @PublishedApi
    /* renamed from: Y */
    public static /* bridge */ /* synthetic */ int m9008Y(@NotNull Iterable iterable, int i) {
        return C14236x.m8957Y(iterable, i);
    }

    @NotNull
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ List m8998k(Object obj) {
        return CollectionsJVM.m8965k(obj);
    }
}
