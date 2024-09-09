package kotlin.comparisons;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.p;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Comparisons.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\u001a[\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004\u00a2\u0006\u0004\b\b\u0010\t\u001aG\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002 \u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003H\u0002\u00a2\u0006\u0004\b\n\u0010\t\u001aC\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a_\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u0007\"\f\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a>\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001aZ\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u00f8\u0001\u0000\u001a>\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001aZ\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u00f8\u0001\u0000\u001aR\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001an\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u00f8\u0001\u0000\u001aR\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001an\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\b\u00f8\u0001\u0000\u001ap\u0010#\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u001028\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00070\u001fH\u0087\b\u00f8\u0001\u0000\u001aO\u0010$\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0086\u0004\u001aO\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0086\u0004\u001a@\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020&2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010\u001a-\u0010(\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u001a@\u0010)\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020&2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010\u001a-\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u001a&\u0010+\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a&\u0010,\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a0\u0010-\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006."}, d2 = {"T", "a", "b", "", "Lkotlin/Function1;", "", "selectors", "", "j", "(Ljava/lang/Object;Ljava/lang/Object;[Ld2/l;)I", "k", "selector", "h", "(Ljava/lang/Object;Ljava/lang/Object;Ld2/l;)I", "K", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "i", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Ld2/l;)I", "g", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "d", "([Ld2/l;)Ljava/util/Comparator;", "c", "e", "f", "t", "u", "v", "w", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comparison", "x", "s", "y", "", "n", "m", "p", "o", "l", CampaignEx.JSON_KEY_AD_Q, "r", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l<T, Comparable<?>>[] f55466a;

        /* JADX WARN: Multi-variable type inference failed */
        a(d2.l<? super T, ? extends Comparable<?>>[] lVarArr) {
            this.f55466a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            return b.k(t3, t4, this.f55466a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* renamed from: kotlin.comparisons.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1096b<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l<T, Comparable<?>> f55467a;

        /* JADX WARN: Multi-variable type inference failed */
        public C1096b(d2.l<? super T, ? extends Comparable<?>> lVar) {
            this.f55467a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            d2.l<T, Comparable<?>> lVar = this.f55467a;
            g4 = b.g(lVar.invoke(t3), lVar.invoke(t4));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f55468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<T, K> f55469b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Comparator<? super K> comparator, d2.l<? super T, ? extends K> lVar) {
            this.f55468a = comparator;
            this.f55469b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            Comparator<? super K> comparator = this.f55468a;
            d2.l<T, K> lVar = this.f55469b;
            return comparator.compare(lVar.invoke(t3), lVar.invoke(t4));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l<T, Comparable<?>> f55470a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(d2.l<? super T, ? extends Comparable<?>> lVar) {
            this.f55470a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            d2.l<T, Comparable<?>> lVar = this.f55470a;
            g4 = b.g(lVar.invoke(t4), lVar.invoke(t3));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f55471a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<T, K> f55472b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<? super K> comparator, d2.l<? super T, ? extends K> lVar) {
            this.f55471a = comparator;
            this.f55472b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            Comparator<? super K> comparator = this.f55471a;
            d2.l<T, K> lVar = this.f55472b;
            return comparator.compare(lVar.invoke(t4), lVar.invoke(t3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f55473a;

        f(Comparator<? super T> comparator) {
            this.f55473a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t3, @Nullable T t4) {
            if (t3 == t4) {
                return 0;
            }
            if (t3 == null) {
                return -1;
            }
            if (t4 == null) {
                return 1;
            }
            return this.f55473a.compare(t3, t4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f55474a;

        g(Comparator<? super T> comparator) {
            this.f55474a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t3, @Nullable T t4) {
            if (t3 == t4) {
                return 0;
            }
            if (t3 == null) {
                return 1;
            }
            if (t4 == null) {
                return -1;
            }
            return this.f55474a.compare(t3, t4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class h<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55475a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f55476b;

        h(Comparator<T> comparator, Comparator<? super T> comparator2) {
            this.f55475a = comparator;
            this.f55476b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int compare = this.f55475a.compare(t3, t4);
            return compare != 0 ? compare : this.f55476b.compare(t3, t4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<T, Comparable<?>> f55478b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, d2.l<? super T, ? extends Comparable<?>> lVar) {
            this.f55477a = comparator;
            this.f55478b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            int compare = this.f55477a.compare(t3, t4);
            if (compare != 0) {
                return compare;
            }
            d2.l<T, Comparable<?>> lVar = this.f55478b;
            g4 = b.g(lVar.invoke(t3), lVar.invoke(t4));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55479a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f55480b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.l<T, K> f55481c;

        /* JADX WARN: Multi-variable type inference failed */
        public j(Comparator<T> comparator, Comparator<? super K> comparator2, d2.l<? super T, ? extends K> lVar) {
            this.f55479a = comparator;
            this.f55480b = comparator2;
            this.f55481c = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int compare = this.f55479a.compare(t3, t4);
            if (compare != 0) {
                return compare;
            }
            Comparator<? super K> comparator = this.f55480b;
            d2.l<T, K> lVar = this.f55481c;
            return comparator.compare(lVar.invoke(t3), lVar.invoke(t4));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class k<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55482a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<T, Comparable<?>> f55483b;

        /* JADX WARN: Multi-variable type inference failed */
        public k(Comparator<T> comparator, d2.l<? super T, ? extends Comparable<?>> lVar) {
            this.f55482a = comparator;
            this.f55483b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            int compare = this.f55482a.compare(t3, t4);
            if (compare != 0) {
                return compare;
            }
            d2.l<T, Comparable<?>> lVar = this.f55483b;
            g4 = b.g(lVar.invoke(t4), lVar.invoke(t3));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class l<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f55485b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.l<T, K> f55486c;

        /* JADX WARN: Multi-variable type inference failed */
        public l(Comparator<T> comparator, Comparator<? super K> comparator2, d2.l<? super T, ? extends K> lVar) {
            this.f55484a = comparator;
            this.f55485b = comparator2;
            this.f55486c = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int compare = this.f55484a.compare(t3, t4);
            if (compare != 0) {
                return compare;
            }
            Comparator<? super K> comparator = this.f55485b;
            d2.l<T, K> lVar = this.f55486c;
            return comparator.compare(lVar.invoke(t4), lVar.invoke(t3));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class m<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p<T, T, Integer> f55488b;

        /* JADX WARN: Multi-variable type inference failed */
        public m(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
            this.f55487a = comparator;
            this.f55488b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int compare = this.f55487a.compare(t3, t4);
            return compare != 0 ? compare : this.f55488b.invoke(t3, t4).intValue();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class n<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator<T> f55489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f55490b;

        n(Comparator<T> comparator, Comparator<? super T> comparator2) {
            this.f55489a = comparator;
            this.f55490b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int compare = this.f55489a.compare(t3, t4);
            return compare != 0 ? compare : this.f55490b.compare(t4, t3);
        }
    }

    @InlineOnly
    private static final <T> Comparator<T> b(d2.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(selector, "selector");
        return new C1096b(selector);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> c(Comparator<? super K> comparator, d2.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return new c(comparator, selector);
    }

    @NotNull
    public static final <T> Comparator<T> d(@NotNull d2.l<? super T, ? extends Comparable<?>>... selectors) {
        f0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return new a(selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @InlineOnly
    private static final <T> Comparator<T> e(d2.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(selector, "selector");
        return new d(selector);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> f(Comparator<? super K> comparator, d2.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return new e(comparator, selector);
    }

    public static <T extends Comparable<?>> int g(@Nullable T t3, @Nullable T t4) {
        if (t3 == t4) {
            return 0;
        }
        if (t3 == null) {
            return -1;
        }
        if (t4 == null) {
            return 1;
        }
        return t3.compareTo(t4);
    }

    @InlineOnly
    private static final <T> int h(T t3, T t4, d2.l<? super T, ? extends Comparable<?>> selector) {
        int g4;
        f0.p(selector, "selector");
        g4 = g(selector.invoke(t3), selector.invoke(t4));
        return g4;
    }

    @InlineOnly
    private static final <T, K> int i(T t3, T t4, Comparator<? super K> comparator, d2.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return comparator.compare((K) selector.invoke(t3), (K) selector.invoke(t4));
    }

    public static final <T> int j(T t3, T t4, @NotNull d2.l<? super T, ? extends Comparable<?>>... selectors) {
        f0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return k(t3, t4, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int k(T t3, T t4, d2.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        int g4;
        int length = lVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            d2.l<? super T, ? extends Comparable<?>> lVar = lVarArr[i4];
            i4++;
            g4 = g(lVar.invoke(t3), lVar.invoke(t4));
            if (g4 != 0) {
                return g4;
            }
        }
        return 0;
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> l() {
        return kotlin.comparisons.e.f55491a;
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> m() {
        Comparator l4;
        l4 = l();
        return n(l4);
    }

    @NotNull
    public static final <T> Comparator<T> n(@NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return new f(comparator);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> o() {
        Comparator l4;
        l4 = l();
        return p(l4);
    }

    @NotNull
    public static final <T> Comparator<T> p(@NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return new g(comparator);
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> q() {
        return kotlin.comparisons.f.f55492a;
    }

    @NotNull
    public static final <T> Comparator<T> r(@NotNull Comparator<T> comparator) {
        f0.p(comparator, "<this>");
        if (comparator instanceof kotlin.comparisons.g) {
            return ((kotlin.comparisons.g) comparator).a();
        }
        Comparator<T> comparator2 = kotlin.comparisons.e.f55491a;
        if (f0.g(comparator, comparator2)) {
            return kotlin.comparisons.f.f55492a;
        }
        if (!f0.g(comparator, kotlin.comparisons.f.f55492a)) {
            comparator2 = new kotlin.comparisons.g<>(comparator);
        }
        return comparator2;
    }

    @NotNull
    public static final <T> Comparator<T> s(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        return new h(comparator, comparator2);
    }

    @InlineOnly
    private static final <T> Comparator<T> t(Comparator<T> comparator, d2.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(comparator, "<this>");
        f0.p(selector, "selector");
        return new i(comparator, selector);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> u(Comparator<T> comparator, Comparator<? super K> comparator2, d2.l<? super T, ? extends K> selector) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        f0.p(selector, "selector");
        return new j(comparator, comparator2, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> v(Comparator<T> comparator, d2.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(comparator, "<this>");
        f0.p(selector, "selector");
        return new k(comparator, selector);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> w(Comparator<T> comparator, Comparator<? super K> comparator2, d2.l<? super T, ? extends K> selector) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        f0.p(selector, "selector");
        return new l(comparator, comparator2, selector);
    }

    @InlineOnly
    private static final <T> Comparator<T> x(Comparator<T> comparator, p<? super T, ? super T, Integer> comparison) {
        f0.p(comparator, "<this>");
        f0.p(comparison, "comparison");
        return new m(comparator, comparison);
    }

    @NotNull
    public static final <T> Comparator<T> y(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        return new n(comparator, comparator2);
    }
}
