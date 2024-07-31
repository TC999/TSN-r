package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.comparisons.Comparisons;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.random.Random;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: Collections.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u0010\u0010\t\u001a7\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00132\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\t\u001aC\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0019\u001a\u00020\u00182!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\bø\u0001\u0000\u001aC\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0019\u001a\u00020\u00182!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\bø\u0001\u0000\u001aF\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00062\u001f\b\u0001\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020!0\u001a¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010%\u001a\u00020\u00182\u001f\b\u0001\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020!0\u001a¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0019\u0010(\u001a\u00020'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u001a,\u0010)\u001a\u00020'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a!\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b\u001a!\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0087\b\u001a=\u0010.\u001a\u00028\u0001\"\u0010\b\u0000\u0010$*\u0006\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010**\u00028\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010,H\u0087\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a,\u00101\u001a\u00020'\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b0*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u001a&\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000022\u0006\u00104\u001a\u000203H\u0007\u001a\u001e\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000\u001aG\u0010:\u001a\u00020\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000007*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u0018¢\u0006\u0004\b:\u0010;\u001aU\u0010?\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u001a\u0010>\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000<j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`=2\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u0018¢\u0006\u0004\b?\u0010@\u001ai\u0010C\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u000107*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010A\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00182\u0016\b\u0004\u0010B\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a>\u0010F\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00182\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001a\u001a'\u0010\u0000\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0000\u0010G\u001a\b\u0010H\u001a\u00020!H\u0001\u001a\b\u0010I\u001a\u00020!H\u0001\"\u0019\u0010M\u001a\u00020J*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\bK\u0010L\"!\u0010P\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\bN\u0010O\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Q"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "s", "([Ljava/lang/Object;)Ljava/util/Collection;", "", ExifInterface.LONGITUDE_EAST, "elements", "L", "([Ljava/lang/Object;)Ljava/util/List;", "K", "", "O", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", CampaignEx.JSON_KEY_AD_Q, "P", "r", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "M", "(Ljava/lang/Object;)Ljava/util/List;", "N", "", "size", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "init", "o", "p", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "C", "capacity", "B", "", "I", "J", "R", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Function0;", "defaultValue", "H", "(Ljava/util/Collection;Ll1/a;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "D", "", "Lkotlin/random/Random;", "random", "U", "Q", "", "fromIndex", "toIndex", "u", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "v", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", DomainCampaignEx.LOOPBACK_KEY, "selector", UMCommonContent.f37777aG, "(Ljava/util/List;Ljava/lang/Comparable;IILl1/l;)I", "comparison", UMCommonContent.f37782aL, "(III)V", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/ranges/k;", "F", "(Ljava/util/Collection;)Lkotlin/ranges/k;", "indices", "G", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CollectionsKt__CollectionsKt extends CollectionsJVM {
    /* renamed from: A */
    public static /* synthetic */ int m12482A(List binarySearchBy, Comparable comparable, int i, int i2, InterfaceC15280l selector, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = binarySearchBy.size();
        }
        C14342f0.m8184p(binarySearchBy, "$this$binarySearchBy");
        C14342f0.m8184p(selector, "selector");
        return m12454t(binarySearchBy, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, comparable));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: B */
    private static final <E> List<E> m12481B(int i, @Inference InterfaceC15280l<? super List<E>, Unit> interfaceC15280l) {
        List m8966j;
        List<E> m8975a;
        m8966j = CollectionsJVM.m8966j(i);
        interfaceC15280l.invoke(m8966j);
        m8975a = CollectionsJVM.m8975a(m8966j);
        return m8975a;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: C */
    private static final <E> List<E> m12480C(@Inference InterfaceC15280l<? super List<E>, Unit> interfaceC15280l) {
        List<E> m8975a;
        List m8967i = CollectionsJVM.m8967i();
        interfaceC15280l.invoke(m8967i);
        m8975a = CollectionsJVM.m8975a(m8967i);
        return m8975a;
    }

    @InlineOnly
    /* renamed from: D */
    private static final <T> boolean m12479D(Collection<? extends T> collection, Collection<? extends T> collection2) {
        return collection.containsAll(collection2);
    }

    @NotNull
    /* renamed from: E */
    public static <T> List<T> m12478E() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    /* renamed from: F */
    public static C14413k m12477F(@NotNull Collection<?> indices) {
        C14342f0.m8184p(indices, "$this$indices");
        return new C14413k(0, indices.size() - 1);
    }

    /* renamed from: G */
    public static <T> int m12476G(@NotNull List<? extends T> lastIndex) {
        C14342f0.m8184p(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: H */
    private static final Object m12475H(Collection collection, InterfaceC15269a interfaceC15269a) {
        return collection.isEmpty() ? interfaceC15269a.invoke() : collection;
    }

    @InlineOnly
    /* renamed from: I */
    private static final <T> boolean m12474I(Collection<? extends T> collection) {
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: J */
    private static final <T> boolean m12473J(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @InlineOnly
    /* renamed from: K */
    private static final <T> List<T> m12472K() {
        List<T> m12478E;
        m12478E = m12478E();
        return m12478E;
    }

    @NotNull
    /* renamed from: L */
    public static <T> List<T> m12471L(@NotNull T... elements) {
        List<T> m12478E;
        List<T> m11537t;
        C14342f0.m8184p(elements, "elements");
        if (elements.length > 0) {
            m11537t = _ArraysJvm.m11537t(elements);
            return m11537t;
        }
        m12478E = m12478E();
        return m12478E;
    }

    @NotNull
    /* renamed from: M */
    public static final <T> List<T> m12470M(@Nullable T t) {
        List<T> m12478E;
        List<T> m8965k;
        if (t != null) {
            m8965k = CollectionsJVM.m8965k(t);
            return m8965k;
        }
        m12478E = m12478E();
        return m12478E;
    }

    @NotNull
    /* renamed from: N */
    public static <T> List<T> m12469N(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return _Arrays.m10133qa(elements);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: O */
    private static final <T> List<T> m12468O() {
        return new ArrayList();
    }

    @NotNull
    /* renamed from: P */
    public static <T> List<T> m12467P(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C14166k(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: Q */
    public static <T> List<T> m12466Q(@NotNull List<? extends T> optimizeReadOnlyList) {
        List<T> m12478E;
        List<T> m8965k;
        C14342f0.m8184p(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        if (size == 0) {
            m12478E = m12478E();
            return m12478E;
        } else if (size != 1) {
            return optimizeReadOnlyList;
        } else {
            m8965k = CollectionsJVM.m8965k(optimizeReadOnlyList.get(0));
            return m8965k;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: R */
    private static final <T> Collection<T> m12465R(Collection<? extends T> collection) {
        List m12478E;
        if (collection != 0) {
            return collection;
        }
        m12478E = m12478E();
        return m12478E;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: S */
    private static final <T> List<T> m12464S(List<? extends T> list) {
        List<T> m12478E;
        if (list != 0) {
            return list;
        }
        m12478E = m12478E();
        return m12478E;
    }

    /* renamed from: T */
    private static final void m12463T(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        } else if (i3 <= i) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: U */
    public static final <T> List<T> m12462U(@NotNull Iterable<? extends T> shuffled, @NotNull Random random) {
        C14342f0.m8184p(shuffled, "$this$shuffled");
        C14342f0.m8184p(random, "random");
        List<T> m12223K5 = _Collections.m12223K5(shuffled);
        _Collections.m12189R4(m12223K5, random);
        return m12223K5;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: V */
    public static void m12461V() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: W */
    public static void m12460W() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: o */
    private static final <T> List<T> m12459o(int i, InterfaceC15280l<? super Integer, ? extends T> interfaceC15280l) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(interfaceC15280l.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: p */
    private static final <T> List<T> m12458p(int i, InterfaceC15280l<? super Integer, ? extends T> interfaceC15280l) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(interfaceC15280l.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: q */
    private static final <T> ArrayList<T> m12457q() {
        return new ArrayList<>();
    }

    @NotNull
    /* renamed from: r */
    public static final <T> ArrayList<T> m12456r(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new C14166k(elements, true));
    }

    @NotNull
    /* renamed from: s */
    public static final <T> Collection<T> m12455s(@NotNull T[] asCollection) {
        C14342f0.m8184p(asCollection, "$this$asCollection");
        return new C14166k(asCollection, false);
    }

    /* renamed from: t */
    public static final <T> int m12454t(@NotNull List<? extends T> binarySearch, int i, int i2, @NotNull InterfaceC15280l<? super T, Integer> comparison) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        C14342f0.m8184p(comparison, "comparison");
        m12463T(binarySearch.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = comparison.invoke((T) binarySearch.get(i4)).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else if (intValue <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: u */
    public static final <T extends Comparable<? super T>> int m12453u(@NotNull List<? extends T> binarySearch, @Nullable T t, int i, int i2) {
        int m8803g;
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        m12463T(binarySearch.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            m8803g = Comparisons.m8803g(binarySearch.get(i4), t);
            if (m8803g < 0) {
                i = i4 + 1;
            } else if (m8803g <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: v */
    public static final <T> int m12452v(@NotNull List<? extends T> binarySearch, T t, @NotNull Comparator<? super T> comparator, int i, int i2) {
        C14342f0.m8184p(binarySearch, "$this$binarySearch");
        C14342f0.m8184p(comparator, "comparator");
        m12463T(binarySearch.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare((T) binarySearch.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: w */
    public static /* synthetic */ int m12451w(List list, int i, int i2, InterfaceC15280l interfaceC15280l, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return m12454t(list, i, i2, interfaceC15280l);
    }

    /* renamed from: x */
    public static /* synthetic */ int m12450x(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return m12453u(list, comparable, i, i2);
    }

    /* renamed from: y */
    public static /* synthetic */ int m12449y(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return m12452v(list, obj, comparator, i, i2);
    }

    /* renamed from: z */
    public static final <T, K extends Comparable<? super K>> int m12448z(@NotNull List<? extends T> binarySearchBy, @Nullable K k, int i, int i2, @NotNull InterfaceC15280l<? super T, ? extends K> selector) {
        C14342f0.m8184p(binarySearchBy, "$this$binarySearchBy");
        C14342f0.m8184p(selector, "selector");
        return m12454t(binarySearchBy, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }
}
