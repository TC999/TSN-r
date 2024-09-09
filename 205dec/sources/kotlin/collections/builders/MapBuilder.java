package kotlin.collections.builders;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import e2.g;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000e\b\u0000\u0018\u0000 \u0087\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001BI\b\u0002\u0012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010`\u001a\u00020\b\u0012\u0006\u0010b\u001a\u00020\b\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001B\n\b\u0016\u00a2\u0006\u0005\b\u0083\u0001\u0010;B\u0014\b\u0016\u0012\u0007\u0010\u0085\u0001\u001a\u00020\b\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u0013J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!H\u0002J\u001c\u0010&\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0002J\"\u0010)\u001a\u00020\u00182\u0018\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$0'H\u0002J\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!J\b\u0010+\u001a\u00020\u0018H\u0016J\u0017\u0010,\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b.\u0010-J\u001a\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b/\u00100J!\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b1\u00102J\u001e\u00103\u001a\u00020\n2\u0014\u0010(\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0019\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b4\u00100J\b\u00105\u001a\u00020\nH\u0016J\u0013\u00106\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u00107\u001a\u00020\bH\u0016J\b\u00109\u001a\u000208H\u0016J\u000f\u0010<\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b=\u0010\u0013J\u0017\u0010@\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b?\u0010\u0013J#\u0010C\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0000\u00a2\u0006\u0004\bA\u0010BJ\u001b\u0010G\u001a\u00020\u00182\n\u0010D\u001a\u0006\u0012\u0002\b\u00030'H\u0000\u00a2\u0006\u0004\bE\u0010FJ#\u0010I\u001a\u00020\u00182\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H\u0000\u00a2\u0006\u0004\bH\u0010BJ\u0017\u0010L\u001a\u00020\u00182\u0006\u0010J\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\bK\u0010-J\u001b\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000\u00a2\u0006\u0004\bN\u0010OJ\u001b\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000\u00a2\u0006\u0004\bR\u0010SJ\u001b\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010UH\u0000\u00a2\u0006\u0004\bV\u0010WR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010^R\u0016\u0010`\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR$\u0010e\u001a\u00020\b2\u0006\u0010d\u001a\u00020\b8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\be\u0010a\u001a\u0004\bf\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010l\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR$\u0010o\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR$\u0010q\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00188\u0000@BX\u0080\u000e\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010\f\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010gR\u0014\u0010w\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010gR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000x8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\by\u0010zR\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00028\u00010|8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010~R)\u0010\u0082\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0080\u00010x8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010z\u00a8\u0006\u008e\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "n", "Lkotlin/f1;", "ensureExtraCapacity", "capacity", "ensureCapacity", "", "allocateValuesArray", "()[Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "hash", "(Ljava/lang/Object;)I", "compact", "newHashSize", "rehash", "i", "", "putRehash", "findKey", "value", "findValue", "index", "removeKeyAt", "removedHash", "removeHashAt", "", "other", "contentEquals", "", "entry", "putEntry", "", "from", "putAllEntries", "build", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", f3.f5657f, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "clear", "equals", "hashCode", "", "toString", "checkIsMutable$kotlin_stdlib", "()V", "checkIsMutable", "addKey$kotlin_stdlib", "addKey", "removeKey$kotlin_stdlib", "removeKey", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "m", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$e;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$e;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator", "keysArray", "[Ljava/lang/Object;", "valuesArray", "", "presenceArray", "[I", "hashArray", "maxProbeDistance", "I", "length", "hashShift", "<set-?>", "size", "getSize", "()I", "Lkotlin/collections/builders/d;", "keysView", "Lkotlin/collections/builders/d;", "Lkotlin/collections/builders/e;", "valuesView", "Lkotlin/collections/builders/e;", "Lkotlin/collections/builders/c;", "entriesView", "Lkotlin/collections/builders/c;", "isReadOnly", "Z", "isReadOnly$kotlin_stdlib", "()Z", "getCapacity", "getHashSize", "hashSize", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "initialCapacity", "(I)V", "Companion", "a", "b", "c", "d", "e", "f", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, e2.g {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    @Nullable
    private kotlin.collections.builders.c<K, V> entriesView;
    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    @NotNull
    private K[] keysArray;
    @Nullable
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;
    @NotNull
    private int[] presenceArray;
    private int size;
    @Nullable
    private V[] valuesArray;
    @Nullable
    private kotlin.collections.builders.e<V> valuesView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlin/collections/builders/MapBuilder$a;", "", "", "capacity", "c", "hashSize", "d", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i4) {
            int n4;
            n4 = q.n(i4, 1);
            return Integer.highestOneBit(n4 * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i4) {
            return Integer.numberOfLeadingZeros(i4) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002J\u000f\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\f\u00a8\u0006\u0014"}, d2 = {"Lkotlin/collections/builders/MapBuilder$b;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "", "Lkotlin/collections/builders/MapBuilder$c;", "j", "", "l", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lkotlin/f1;", "k", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, e2.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: j */
        public c<K, V> next() {
            if (a() < ((MapBuilder) e()).length) {
                int a4 = a();
                g(a4 + 1);
                h(a4);
                c<K, V> cVar = new c<>(e(), d());
                f();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void k(@NotNull StringBuilder sb) {
            f0.p(sb, "sb");
            if (a() < ((MapBuilder) e()).length) {
                int a4 = a();
                g(a4 + 1);
                h(a4);
                Object obj = ((MapBuilder) e()).keysArray[d()];
                if (f0.g(obj, e())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((MapBuilder) e()).valuesArray;
                f0.m(objArr);
                Object obj2 = objArr[d()];
                if (f0.g(obj2, e())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                f();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int l() {
            if (a() < ((MapBuilder) e()).length) {
                int a4 = a();
                g(a4 + 1);
                h(a4);
                Object obj = ((MapBuilder) e()).keysArray[d()];
                int hashCode = obj == null ? 0 : obj.hashCode();
                Object[] objArr = ((MapBuilder) e()).valuesArray;
                f0.m(objArr);
                Object obj2 = objArr[d()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                f();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00028\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/MapBuilder$c;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/collections/builders/MapBuilder;", "a", "Lkotlin/collections/builders/MapBuilder;", "map", "b", "I", "index", "getKey", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "getValue", "value", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, g.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final MapBuilder<K, V> f55269a;

        /* renamed from: b  reason: collision with root package name */
        private final int f55270b;

        public c(@NotNull MapBuilder<K, V> map, int i4) {
            f0.p(map, "map");
            this.f55269a = map;
            this.f55270b = i4;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (f0.g(entry.getKey(), getKey()) && f0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f55269a).keysArray[this.f55270b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f55269a).valuesArray;
            f0.m(objArr);
            return (V) objArr[this.f55270b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key == null ? 0 : key.hashCode();
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            this.f55269a.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.f55269a.allocateValuesArray();
            int i4 = this.f55270b;
            V v4 = (V) allocateValuesArray[i4];
            allocateValuesArray[i4] = v3;
            return v4;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/MapBuilder$d;", "K", "V", "", "Lkotlin/f1;", "f", "()V", "", "hasNext", "remove", "Lkotlin/collections/builders/MapBuilder;", "a", "Lkotlin/collections/builders/MapBuilder;", "e", "()Lkotlin/collections/builders/MapBuilder;", "map", "", "b", "I", "()I", "g", "(I)V", "index", "c", "d", "h", "lastIndex", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d<K, V> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final MapBuilder<K, V> f55271a;

        /* renamed from: b  reason: collision with root package name */
        private int f55272b;

        /* renamed from: c  reason: collision with root package name */
        private int f55273c;

        public d(@NotNull MapBuilder<K, V> map) {
            f0.p(map, "map");
            this.f55271a = map;
            this.f55273c = -1;
            f();
        }

        public final int a() {
            return this.f55272b;
        }

        public final int d() {
            return this.f55273c;
        }

        @NotNull
        public final MapBuilder<K, V> e() {
            return this.f55271a;
        }

        public final void f() {
            while (this.f55272b < ((MapBuilder) this.f55271a).length) {
                int[] iArr = ((MapBuilder) this.f55271a).presenceArray;
                int i4 = this.f55272b;
                if (iArr[i4] >= 0) {
                    return;
                }
                this.f55272b = i4 + 1;
            }
        }

        public final void g(int i4) {
            this.f55272b = i4;
        }

        public final void h(int i4) {
            this.f55273c = i4;
        }

        public final boolean hasNext() {
            return this.f55272b < ((MapBuilder) this.f55271a).length;
        }

        public final void remove() {
            if (this.f55273c != -1) {
                this.f55271a.checkIsMutable$kotlin_stdlib();
                this.f55271a.removeKeyAt(this.f55273c);
                this.f55273c = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$e;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, e2.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((MapBuilder) e()).length) {
                int a4 = a();
                g(a4 + 1);
                h(a4);
                K k4 = (K) ((MapBuilder) e()).keysArray[d()];
                f();
                return k4;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$f;", "K", "V", "Lkotlin/collections/builders/MapBuilder$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, e2.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((MapBuilder) e()).length) {
                int a4 = a();
                g(a4 + 1);
                h(a4);
                Object[] objArr = ((MapBuilder) e()).valuesArray;
                f0.m(objArr);
                V v3 = (V) objArr[d()];
                f();
                return v3;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i4, int i5) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i4;
        this.length = i5;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i4;
        V[] vArr = this.valuesArray;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i4 = this.length;
            if (i5 >= i4) {
                break;
            }
            if (this.presenceArray[i5] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i6] = kArr[i5];
                if (vArr != null) {
                    vArr[i6] = vArr[i5];
                }
                i6++;
            }
            i5++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i6, i4);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i6, this.length);
        }
        this.length = i6;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i4) {
        if (i4 >= 0) {
            if (i4 > getCapacity()) {
                int capacity = (getCapacity() * 3) / 2;
                if (i4 <= capacity) {
                    i4 = capacity;
                }
                this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, i4);
                V[] vArr = this.valuesArray;
                this.valuesArray = vArr == null ? null : (V[]) kotlin.collections.builders.b.e(vArr, i4);
                int[] copyOf = Arrays.copyOf(this.presenceArray, i4);
                f0.o(copyOf, "copyOf(this, newSize)");
                this.presenceArray = copyOf;
                int c4 = Companion.c(i4);
                if (c4 > getHashSize()) {
                    rehash(c4);
                    return;
                }
                return;
            } else if ((this.length + i4) - size() > getCapacity()) {
                rehash(getHashSize());
                return;
            } else {
                return;
            }
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i4) {
        ensureCapacity(this.length + i4);
    }

    private final int findKey(K k4) {
        int hash = hash(k4);
        int i4 = this.maxProbeDistance;
        while (true) {
            int i5 = this.hashArray[hash];
            if (i5 == 0) {
                return -1;
            }
            if (i5 > 0) {
                int i6 = i5 - 1;
                if (f0.g(this.keysArray[i6], k4)) {
                    return i6;
                }
            }
            i4--;
            if (i4 < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v3) {
        int i4 = this.length;
        while (true) {
            i4--;
            if (i4 < 0) {
                return -1;
            }
            if (this.presenceArray[i4] >= 0) {
                V[] vArr = this.valuesArray;
                f0.m(vArr);
                if (f0.g(vArr[i4], v3)) {
                    return i4;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k4) {
        return ((k4 == null ? 0 : k4.hashCode()) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z3 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z3 = true;
            }
        }
        return z3;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i4 = (-addKey$kotlin_stdlib) - 1;
        if (f0.g(entry.getValue(), allocateValuesArray[i4])) {
            return false;
        }
        allocateValuesArray[i4] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i4) {
        int hash = hash(this.keysArray[i4]);
        int i5 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i4 + 1;
                this.presenceArray[i4] = hash;
                return true;
            }
            i5--;
            if (i5 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i4) {
        if (this.length > size()) {
            compact();
        }
        int i5 = 0;
        if (i4 != getHashSize()) {
            this.hashArray = new int[i4];
            this.hashShift = Companion.d(i4);
        } else {
            o.l2(this.hashArray, 0, 0, getHashSize());
        }
        while (i5 < this.length) {
            int i6 = i5 + 1;
            if (!putRehash(i5)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i5 = i6;
        }
    }

    private final void removeHashAt(int i4) {
        int u3;
        u3 = q.u(this.maxProbeDistance * 2, getHashSize() / 2);
        int i5 = u3;
        int i6 = 0;
        int i7 = i4;
        do {
            i4 = i4 == 0 ? getHashSize() - 1 : i4 - 1;
            i6++;
            if (i6 > this.maxProbeDistance) {
                this.hashArray[i7] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i8 = iArr[i4];
            if (i8 == 0) {
                iArr[i7] = 0;
                return;
            }
            if (i8 < 0) {
                iArr[i7] = -1;
            } else {
                int i9 = i8 - 1;
                if (((hash(this.keysArray[i9]) - i4) & (getHashSize() - 1)) >= i6) {
                    this.hashArray[i7] = i8;
                    this.presenceArray[i9] = i7;
                }
                i5--;
            }
            i7 = i4;
            i6 = 0;
            i5--;
        } while (i5 >= 0);
        this.hashArray[i7] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i4) {
        kotlin.collections.builders.b.f(this.keysArray, i4);
        removeHashAt(this.presenceArray[i4]);
        this.presenceArray[i4] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new kotlin.collections.builders.f(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k4) {
        int u3;
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k4);
            u3 = q.u(this.maxProbeDistance * 2, getHashSize() / 2);
            int i4 = 0;
            while (true) {
                int i5 = this.hashArray[hash];
                if (i5 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i6 = this.length;
                        int i7 = i6 + 1;
                        this.length = i7;
                        this.keysArray[i6] = k4;
                        this.presenceArray[i6] = hash;
                        this.hashArray[hash] = i7;
                        this.size = size() + 1;
                        if (i4 > this.maxProbeDistance) {
                            this.maxProbeDistance = i4;
                        }
                        return i6;
                    }
                } else if (f0.g(this.keysArray[i5 - 1], k4)) {
                    return -i5;
                } else {
                    i4++;
                    if (i4 > u3) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i4 = this.length - 1;
        if (i4 >= 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                int[] iArr = this.presenceArray;
                int i7 = iArr[i5];
                if (i7 >= 0) {
                    this.hashArray[i7] = 0;
                    iArr[i5] = -1;
                }
                if (i5 == i4) {
                    break;
                }
                i5 = i6;
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m4) {
        f0.p(m4, "m");
        for (Object obj : m4) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        f0.p(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        return f0.g(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @NotNull
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        return vArr[findKey];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar == null) {
            kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
            this.entriesView = cVar2;
            return cVar2;
        }
        return cVar;
    }

    @NotNull
    public Set<K> getKeys() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar == null) {
            kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
            this.keysView = dVar2;
            return dVar2;
        }
        return dVar;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar == null) {
            kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
            this.valuesView = eVar2;
            return eVar2;
        }
        return eVar;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i4 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i4 += entriesIterator$kotlin_stdlib.l();
        }
        return i4;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k4, V v3) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k4);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i4 = (-addKey$kotlin_stdlib) - 1;
            V v4 = allocateValuesArray[i4];
            allocateValuesArray[i4] = v3;
            return v4;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v3;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        f0.p(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        V v3 = vArr[removeKey$kotlin_stdlib];
        kotlin.collections.builders.b.f(vArr, removeKey$kotlin_stdlib);
        return v3;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        f0.p(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        if (f0.g(vArr[findKey], entry.getValue())) {
            removeKeyAt(findKey);
            return true;
        }
        return false;
    }

    public final int removeKey$kotlin_stdlib(K k4) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k4);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v3) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v3);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i4 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i4 > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.k(sb);
            i4++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i4) {
        this(kotlin.collections.builders.b.d(i4), null, new int[i4], new int[Companion.c(i4)], 2, 0);
    }
}
