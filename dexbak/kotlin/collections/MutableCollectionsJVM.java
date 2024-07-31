package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Standard;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003H\u0087\b\u001a6\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000\u001a \u0010\f\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a2\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003\u001a(\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a!\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "Lkotlin/f1;", "n0", "Lkotlin/Function2;", "", "comparison", "o0", "", "m0", C7202bq.f24604g, DomainCampaignEx.LOOPBACK_VALUE, "j0", "(Ljava/util/List;Ljava/lang/Object;)V", "k0", "Ljava/util/Random;", "random", "l0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.a0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MutableCollectionsJVM extends C14240z {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: j0 */
    private static final <T> void m12446j0(List<T> list, T t) {
        Collections.fill(list, t);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: k0 */
    private static final <T> void m12445k0(List<T> list) {
        Collections.shuffle(list);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: l0 */
    private static final <T> void m12444l0(List<T> list, Random random) {
        Collections.shuffle(list, random);
    }

    /* renamed from: m0 */
    public static <T extends Comparable<? super T>> void m12443m0(@NotNull List<T> sort) {
        C14342f0.m8184p(sort, "$this$sort");
        if (sort.size() > 1) {
            Collections.sort(sort);
        }
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    @InlineOnly
    /* renamed from: n0 */
    private static final <T> void m12442n0(List<T> list, Comparator<? super T> comparator) {
        throw new Standard(null, 1, null);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @InlineOnly
    /* renamed from: o0 */
    private static final <T> void m12441o0(List<T> list, InterfaceC15284p<? super T, ? super T, Integer> interfaceC15284p) {
        throw new Standard(null, 1, null);
    }

    /* renamed from: p0 */
    public static <T> void m12440p0(@NotNull List<T> sortWith, @NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(sortWith, "$this$sortWith");
        C14342f0.m8184p(comparator, "comparator");
        if (sortWith.size() > 1) {
            Collections.sort(sortWith, comparator);
        }
    }
}
