package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0012\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\u001f\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a7\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0011\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a7\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0011\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00152\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0003\"\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u0006\u001aF\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001a2\u001f\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001a2\u0006\u0010!\u001a\u00020 2\u001f\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a!\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "k", "", "elements", "u", "([Ljava/lang/Object;)Ljava/util/Set;", UMCommonContent.f37782aL, "", "p", CampaignEx.JSON_KEY_AD_Q, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", C7304t.f25048d, "m", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "n", "o", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "element", "v", "(Ljava/lang/Object;)Ljava/util/Set;", IAdInterListener.AdReqParam.WIDTH, ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "j", "", "capacity", "i", "s", "r", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/SetsKt")
/* renamed from: kotlin.collections.i1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14164i1 extends SetsJVM {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: i */
    private static final <E> Set<E> m11985i(int i, @Inference InterfaceC15280l<? super Set<E>, Unit> interfaceC15280l) {
        Set m11990e = SetsJVM.m11990e(i);
        interfaceC15280l.invoke(m11990e);
        return SetsJVM.m11994a(m11990e);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: j */
    private static final <E> Set<E> m11984j(@Inference InterfaceC15280l<? super Set<E>, Unit> interfaceC15280l) {
        Set m11991d = SetsJVM.m11991d();
        interfaceC15280l.invoke(m11991d);
        return SetsJVM.m11994a(m11991d);
    }

    @NotNull
    /* renamed from: k */
    public static <T> Set<T> m11983k() {
        return Sets.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: l */
    private static final <T> HashSet<T> m11982l() {
        return new HashSet<>();
    }

    @NotNull
    /* renamed from: m */
    public static final <T> HashSet<T> m11981m(@NotNull T... elements) {
        int m8944j;
        C14342f0.m8184p(elements, "elements");
        m8944j = MapsJVM.m8944j(elements.length);
        return (HashSet) _Arrays.m11151Jx(elements, new HashSet(m8944j));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: n */
    private static final <T> LinkedHashSet<T> m11980n() {
        return new LinkedHashSet<>();
    }

    @NotNull
    /* renamed from: o */
    public static final <T> LinkedHashSet<T> m11979o(@NotNull T... elements) {
        int m8944j;
        C14342f0.m8184p(elements, "elements");
        m8944j = MapsJVM.m8944j(elements.length);
        return (LinkedHashSet) _Arrays.m11151Jx(elements, new LinkedHashSet(m8944j));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: p */
    private static final <T> Set<T> m11978p() {
        return new LinkedHashSet();
    }

    @NotNull
    /* renamed from: q */
    public static final <T> Set<T> m11977q(@NotNull T... elements) {
        int m8944j;
        C14342f0.m8184p(elements, "elements");
        m8944j = MapsJVM.m8944j(elements.length);
        return (Set) _Arrays.m11151Jx(elements, new LinkedHashSet(m8944j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: r */
    public static <T> Set<T> m11976r(@NotNull Set<? extends T> optimizeReadOnlySet) {
        C14342f0.m8184p(optimizeReadOnlySet, "$this$optimizeReadOnlySet");
        int size = optimizeReadOnlySet.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlySet : C14162g1.m12005f(optimizeReadOnlySet.iterator().next());
        }
        return C14162g1.m12004k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: s */
    private static final <T> Set<T> m11975s(Set<? extends T> set) {
        return set != 0 ? set : C14162g1.m12004k();
    }

    @InlineOnly
    /* renamed from: t */
    private static final <T> Set<T> m11974t() {
        return C14162g1.m12004k();
    }

    @NotNull
    /* renamed from: u */
    public static final <T> Set<T> m11973u(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return elements.length > 0 ? _Arrays.m11246Gy(elements) : C14162g1.m12004k();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: v */
    public static final <T> Set<T> m11972v(@Nullable T t) {
        return t != null ? C14162g1.m12005f(t) : C14162g1.m12004k();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: w */
    public static final <T> Set<T> m11971w(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return (Set) _Arrays.m10101ra(elements, new LinkedHashSet());
    }
}
