package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C14372l0;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Tuples;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\bø\u0001\u0000\u001a!\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a \u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0001\u001a\u001f\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u001a@\u0010\u0016\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u0015\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00150\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "", "iterator", "", "X", "", "Z", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "default", "Y", "", "", "d0", "(Ljava/util/Collection;)Z", SocialConstants.PARAM_SOURCE, "b0", "a0", "", "c0", "R", "Lkotlin/Pair;", "e0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14236x extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, m12616d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.x$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14237a<T> implements Iterable<T>, KMarkers {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f40984a;

        public C14237a(InterfaceC15269a interfaceC15269a) {
            this.f40984a = interfaceC15269a;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return (Iterator) this.f40984a.invoke();
        }
    }

    @InlineOnly
    /* renamed from: X */
    private static final <T> Iterable<T> m8958X(InterfaceC15269a<? extends Iterator<? extends T>> interfaceC15269a) {
        return new C14237a(interfaceC15269a);
    }

    @PublishedApi
    /* renamed from: Y */
    public static <T> int m8957Y(@NotNull Iterable<? extends T> collectionSizeOrDefault, int i) {
        C14342f0.m8184p(collectionSizeOrDefault, "$this$collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection) collectionSizeOrDefault).size() : i;
    }

    @PublishedApi
    @Nullable
    /* renamed from: Z */
    public static final <T> Integer m8956Z(@NotNull Iterable<? extends T> collectionSizeOrNull) {
        C14342f0.m8184p(collectionSizeOrNull, "$this$collectionSizeOrNull");
        if (collectionSizeOrNull instanceof Collection) {
            return Integer.valueOf(((Collection) collectionSizeOrNull).size());
        }
        return null;
    }

    @NotNull
    /* renamed from: a0 */
    public static <T> Collection<T> m8955a0(@NotNull Iterable<? extends T> convertToSetForSetOperation) {
        C14342f0.m8184p(convertToSetForSetOperation, "$this$convertToSetForSetOperation");
        if (convertToSetForSetOperation instanceof Set) {
            return (Collection) convertToSetForSetOperation;
        }
        if (convertToSetForSetOperation instanceof Collection) {
            Collection<T> collection = (Collection) convertToSetForSetOperation;
            return m8952d0(collection) ? _Collections.m12243G5(convertToSetForSetOperation) : collection;
        }
        return _Collections.m12243G5(convertToSetForSetOperation);
    }

    @NotNull
    /* renamed from: b0 */
    public static final <T> Collection<T> m8954b0(@NotNull Iterable<? extends T> convertToSetForSetOperationWith, @NotNull Iterable<? extends T> source) {
        C14342f0.m8184p(convertToSetForSetOperationWith, "$this$convertToSetForSetOperationWith");
        C14342f0.m8184p(source, "source");
        if (convertToSetForSetOperationWith instanceof Set) {
            return (Collection) convertToSetForSetOperationWith;
        }
        if (convertToSetForSetOperationWith instanceof Collection) {
            if (!(source instanceof Collection) || ((Collection) source).size() >= 2) {
                Collection<T> collection = (Collection) convertToSetForSetOperationWith;
                return m8952d0(collection) ? _Collections.m12243G5(convertToSetForSetOperationWith) : collection;
            }
            return (Collection) convertToSetForSetOperationWith;
        }
        return _Collections.m12243G5(convertToSetForSetOperationWith);
    }

    @NotNull
    /* renamed from: c0 */
    public static final <T> List<T> m8953c0(@NotNull Iterable<? extends Iterable<? extends T>> flatten) {
        C14342f0.m8184p(flatten, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable : flatten) {
            MutableCollections.m12416q0(arrayList, iterable);
        }
        return arrayList;
    }

    /* renamed from: d0 */
    private static final <T> boolean m8952d0(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    @NotNull
    /* renamed from: e0 */
    public static final <T, R> Tuples<List<T>, List<R>> m8951e0(@NotNull Iterable<? extends Tuples<? extends T, ? extends R>> unzip) {
        int m8957Y;
        C14342f0.m8184p(unzip, "$this$unzip");
        m8957Y = m8957Y(unzip, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        ArrayList arrayList2 = new ArrayList(m8957Y);
        for (Tuples<? extends T, ? extends R> tuples : unzip) {
            arrayList.add(tuples.getFirst());
            arrayList2.add(tuples.getSecond());
        }
        return C14372l0.m7952a(arrayList, arrayList2);
    }
}
