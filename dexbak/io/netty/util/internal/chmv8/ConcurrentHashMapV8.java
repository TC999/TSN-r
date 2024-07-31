package io.netty.util.internal.chmv8;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.C14084a;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ConcurrentHashMapV8<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    static final int RESERVED = -3;
    static final int SEED_INCREMENT = 1640531527;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final long TRANSFERORIGIN;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;

    /* renamed from: U */
    private static final Unsafe f40297U;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final AtomicInteger counterHashCodeGenerator;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private volatile transient int transferOrigin;
    private transient ValuesView<K, V> values;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface Action<A> {
        void apply(A a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class BaseIterator<K, V> extends Traverser<K, V> {
        Node<K, V> lastReturned;
        final ConcurrentHashMapV8<K, V> map;

        BaseIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMapV8;
            advance();
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                this.lastReturned = null;
                this.map.replaceNode(node.key, null, null);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface BiAction<A, B> {
        void apply(A a, B b);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface BiFun<A, B, T> {
        T apply(A a, B b);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static abstract class BulkTask<K, V, R> extends CountedCompleter<R> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        int index;
        Node<K, V> next;
        Node<K, V>[] tab;

        BulkTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr) {
            super(bulkTask);
            this.batch = i;
            this.baseIndex = i2;
            this.index = i2;
            this.tab = nodeArr;
            if (nodeArr == null) {
                this.baseLimit = 0;
                this.baseSize = 0;
            } else if (bulkTask == null) {
                int length = nodeArr.length;
                this.baseLimit = length;
                this.baseSize = length;
            } else {
                this.baseLimit = i3;
                this.baseSize = bulkTask.baseSize;
            }
        }

        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int length;
            int i;
            Node<K, V> node = this.next;
            if (node != null) {
                node = node.next;
            }
            while (node == null) {
                if (this.baseIndex < this.baseLimit && (nodeArr = this.tab) != null && (length = nodeArr.length) > (i = this.index) && i >= 0) {
                    node = ConcurrentHashMapV8.tabAt(nodeArr, i);
                    if (node != null && node.hash < 0) {
                        if (node instanceof ForwardingNode) {
                            this.tab = ((ForwardingNode) node).nextTable;
                            node = null;
                        } else {
                            node = node instanceof TreeBin ? ((TreeBin) node).first : null;
                        }
                    }
                    int i2 = this.index + this.baseSize;
                    this.index = i2;
                    if (i2 >= length) {
                        int i3 = this.baseIndex + 1;
                        this.baseIndex = i3;
                        this.index = i3;
                    }
                } else {
                    this.next = null;
                    return null;
                }
            }
            this.next = node;
            return node;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ConcurrentHashMapSpliterator<T> {
        long estimateSize();

        void forEachRemaining(Action<? super T> action);

        boolean tryAdvance(Action<? super T> action);

        ConcurrentHashMapSpliterator<T> trySplit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class CounterCell {

        /* renamed from: p0 */
        volatile long f40298p0;

        /* renamed from: p1 */
        volatile long f40299p1;

        /* renamed from: p2 */
        volatile long f40300p2;

        /* renamed from: p3 */
        volatile long f40301p3;

        /* renamed from: p4 */
        volatile long f40302p4;

        /* renamed from: p5 */
        volatile long f40303p5;

        /* renamed from: p6 */
        volatile long f40304p6;

        /* renamed from: q0 */
        volatile long f40305q0;

        /* renamed from: q1 */
        volatile long f40306q1;

        /* renamed from: q2 */
        volatile long f40307q2;

        /* renamed from: q3 */
        volatile long f40308q3;

        /* renamed from: q4 */
        volatile long f40309q4;

        /* renamed from: q5 */
        volatile long f40310q5;

        /* renamed from: q6 */
        volatile long f40311q6;
        volatile long value;

        CounterCell(long j) {
            this.value = j;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class CounterHashCode {
        int code;

        CounterHashCode() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface DoubleByDoubleToDouble {
        double apply(double d, double d2);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntryIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            Node<K, V> node = this.next;
            if (node != null) {
                K k = node.key;
                V v = node.val;
                this.lastReturned = node;
                advance();
                return new MapEntry(k, v, this.map);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(concurrentHashMapV8);
        }

        @Override // java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            boolean z = false;
            for (Map.Entry<K, V> entry : collection) {
                if (add((Map.Entry) entry)) {
                    z = true;
                }
            }
            return z;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            V v;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (v = this.map.get(key)) == null || (value = entry.getValue()) == null || (value != v && !value.equals(v))) ? false : true;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        public void forEach(Action<? super Map.Entry<K, V>> action) {
            action.getClass();
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    return;
                }
                action.apply(new MapEntry(advance.key, advance.val, this.map));
            }
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            Node<K, V>[] nodeArr = this.map.table;
            int i = 0;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance == null) {
                        break;
                    }
                    i += advance.hashCode();
                }
            }
            return i;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.map.remove(key, value);
        }

        public ConcurrentHashMapSpliterator<Map.Entry<K, V>> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long sumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntrySpliterator(nodeArr, length, 0, length, sumCount >= 0 ? sumCount : 0L, concurrentHashMapV8);
        }

        public boolean add(Map.Entry<K, V> entry) {
            return this.map.putVal(entry.getKey(), entry.getValue(), false) == null;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class EntrySpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<Map.Entry<K, V>> {
        long est;
        final ConcurrentHashMapV8<K, V> map;

        EntrySpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMapV8;
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public void forEachRemaining(Action<? super Map.Entry<K, V>> action) {
            action.getClass();
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    return;
                }
                action.apply(new MapEntry(advance.key, advance.val, this.map));
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public boolean tryAdvance(Action<? super Map.Entry<K, V>> action) {
            action.getClass();
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.apply(new MapEntry(advance.key, advance.val, this.map));
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public ConcurrentHashMapSpliterator<Map.Entry<K, V>> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new EntrySpliterator(nodeArr, i4, i3, i2, j, this.map);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super Map.Entry<K, V>> action;

        ForEachEntryTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super Map.Entry<K, V>> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super Map.Entry<K, V>> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachEntryTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.apply(advance);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super K> action;

        ForEachKeyTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super K> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super K> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachKeyTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.apply((K) advance.key);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void> {
        final BiAction<? super K, ? super V> action;

        ForEachMappingTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiAction<? super K, ? super V> biAction) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = biAction;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiAction<? super K, ? super V> biAction = this.action;
            if (biAction == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachMappingTask(this, i4, i3, i2, this.tab, biAction).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    biAction.apply((K) advance.key, (V) advance.val);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<Map.Entry<K, V>, ? extends U> transformer;

        ForEachTransformedEntryTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<Map.Entry<K, V>, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedEntryTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    Object obj = (U) fun.apply(advance);
                    if (obj != null) {
                        action.apply(obj);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<? super K, ? extends U> transformer;

        ForEachTransformedKeyTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super K, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<? super K, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedKeyTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    Object obj = (U) fun.apply((K) advance.key);
                    if (obj != null) {
                        action.apply(obj);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final BiFun<? super K, ? super V, ? extends U> transformer;

        ForEachTransformedMappingTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiFun<? super K, ? super V, ? extends U> biFun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = biFun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            BiFun<? super K, ? super V, ? extends U> biFun = this.transformer;
            if (biFun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedMappingTask(this, i4, i3, i2, this.tab, biFun, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    Object obj = (U) biFun.apply((K) advance.key, (V) advance.val);
                    if (obj != null) {
                        action.apply(obj);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<? super V, ? extends U> transformer;

        ForEachTransformedValueTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super V, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<? super V, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedValueTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    Object obj = (U) fun.apply((V) advance.val);
                    if (obj != null) {
                        action.apply(obj);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super V> action;

        ForEachValueTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super V> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super V> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachValueTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.apply((V) advance.val);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class ForwardingNode<K, V> extends Node<K, V> {
        final Node<K, V>[] nextTable;

        ForwardingNode(Node<K, V>[] nodeArr) {
            super(-1, null, null, null);
            this.nextTable = nodeArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
            if ((r0 instanceof io.netty.util.internal.chmv8.ConcurrentHashMapV8.ForwardingNode) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
            r0 = ((io.netty.util.internal.chmv8.ConcurrentHashMapV8.ForwardingNode) r0).nextTable;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
            return r0.find(r5, r6);
         */
        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node<K, V> find(int r5, java.lang.Object r6) {
            /*
                r4 = this;
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r0 = r4.nextTable
            L2:
                r1 = 0
                if (r6 == 0) goto L39
                if (r0 == 0) goto L39
                int r2 = r0.length
                if (r2 == 0) goto L39
                int r2 = r2 + (-1)
                r2 = r2 & r5
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.tabAt(r0, r2)
                if (r0 != 0) goto L14
                goto L39
            L14:
                int r2 = r0.hash
                if (r2 != r5) goto L25
                K r3 = r0.key
                if (r3 == r6) goto L24
                if (r3 == 0) goto L25
                boolean r3 = r6.equals(r3)
                if (r3 == 0) goto L25
            L24:
                return r0
            L25:
                if (r2 >= 0) goto L35
                boolean r1 = r0 instanceof io.netty.util.internal.chmv8.ConcurrentHashMapV8.ForwardingNode
                if (r1 == 0) goto L30
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$ForwardingNode r0 = (io.netty.util.internal.chmv8.ConcurrentHashMapV8.ForwardingNode) r0
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r0 = r0.nextTable
                goto L2
            L30:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r5 = r0.find(r5, r6)
                return r5
            L35:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V> r0 = r0.next
                if (r0 != 0) goto L14
            L39:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.ForwardingNode.find(int, java.lang.Object):io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node");
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface Fun<A, T> {
        T apply(A a);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface IntByIntToInt {
        int apply(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Iterator<K>, Enumeration<K> {
        KeyIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final K next() {
            Node<K, V> node = this.next;
            if (node != null) {
                K k = node.key;
                this.lastReturned = node;
                advance();
                return k;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Set<K>, Serializable {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        KeySetView(ConcurrentHashMapV8<K, V> concurrentHashMapV8, V v) {
            super(concurrentHashMapV8);
            this.value = v;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K k) {
            V v = this.value;
            if (v != null) {
                return this.map.putVal(k, v, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            V v = this.value;
            if (v != null) {
                boolean z = false;
                for (K k : collection) {
                    if (this.map.putVal(k, v, true) == null) {
                        z = true;
                    }
                }
                return z;
            }
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        public void forEach(Action<? super K> action) {
            action.getClass();
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    return;
                }
                action.apply((K) advance.key);
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMapV8 getMap() {
            return super.getMap();
        }

        public V getMappedValue() {
            return this.value;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Iterator<K> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().hashCode();
            }
            return i;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        public ConcurrentHashMapSpliterator<K> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long sumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, length, 0, length, sumCount >= 0 ? sumCount : 0L);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class KeySpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<K> {
        long est;

        KeySpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public void forEachRemaining(Action<? super K> action) {
            action.getClass();
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    return;
                }
                action.apply((K) advance.key);
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public boolean tryAdvance(Action<? super K> action) {
            action.getClass();
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.apply((K) advance.key);
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public ConcurrentHashMapSpliterator<K> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new KeySpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface LongByLongToLong {
        long apply(long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class MapEntry<K, V> implements Map.Entry<K, V> {
        final K key;
        final ConcurrentHashMapV8<K, V> map;
        V val;

        MapEntry(K k, V v, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            this.key = k;
            this.val = v;
            this.map = concurrentHashMapV8;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            K k;
            V v;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (k = this.key) || key.equals(k)) && (value == (v = this.val) || value.equals(v));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            v.getClass();
            V v2 = this.val;
            this.val = v;
            this.map.put(this.key, v);
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceEntriesTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        final Fun<Map.Entry<K, V>, ? extends U> transformer;

        MapReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesTask<K, V, U> mapReduceEntriesTask, Fun<Map.Entry<K, V>, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesTask<K, V, U> mapReduceEntriesTask = new MapReduceEntriesTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceEntriesTask;
                mapReduceEntriesTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply(advance);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceEntriesTask mapReduceEntriesTask2 = (MapReduceEntriesTask) firstComplete;
                MapReduceEntriesTask<K, V, U> mapReduceEntriesTask3 = mapReduceEntriesTask2.rights;
                while (mapReduceEntriesTask3 != null) {
                    U u = mapReduceEntriesTask3.result;
                    if (u != null) {
                        Object obj3 = (U) mapReduceEntriesTask2.result;
                        if (obj3 != null) {
                            u = biFun.apply(obj3, u);
                        }
                        mapReduceEntriesTask2.result = (U) u;
                    }
                    mapReduceEntriesTask3 = mapReduceEntriesTask3.nextRight;
                    mapReduceEntriesTask2.rights = mapReduceEntriesTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        final ObjectToDouble<Map.Entry<K, V>> transformer;

        MapReduceEntriesToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask, ObjectToDouble<Map.Entry<K, V>> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<Map.Entry<K, V>> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double d = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask = new MapReduceEntriesToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, d, doubleByDoubleToDouble);
                this.rights = mapReduceEntriesToDoubleTask;
                mapReduceEntriesToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<Map.Entry<K, V>> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                d = doubleByDoubleToDouble.apply(d, objectToDouble2.apply(advance));
            }
            this.result = d;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceEntriesToDoubleTask mapReduceEntriesToDoubleTask2 = (MapReduceEntriesToDoubleTask) firstComplete;
                MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask2.rights;
                while (mapReduceEntriesToDoubleTask3 != null) {
                    mapReduceEntriesToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceEntriesToDoubleTask2.result, mapReduceEntriesToDoubleTask3.result);
                    mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask3.nextRight;
                    mapReduceEntriesToDoubleTask2.rights = mapReduceEntriesToDoubleTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceEntriesToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        final ObjectToInt<Map.Entry<K, V>> transformer;

        MapReduceEntriesToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask, ObjectToInt<Map.Entry<K, V>> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<Map.Entry<K, V>> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int i = this.basis;
            int i2 = this.baseIndex;
            while (this.batch > 0) {
                int i3 = this.baseLimit;
                int i4 = (i3 + i2) >>> 1;
                if (i4 <= i2) {
                    break;
                }
                addToPendingCount(1);
                int i5 = this.batch >>> 1;
                this.batch = i5;
                this.baseLimit = i4;
                MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask = new MapReduceEntriesToIntTask<>(this, i5, i4, i3, this.tab, this.rights, objectToInt, i, intByIntToInt);
                this.rights = mapReduceEntriesToIntTask;
                mapReduceEntriesToIntTask.fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                i = intByIntToInt.apply(i, objectToInt.apply(advance));
            }
            this.result = i;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceEntriesToIntTask mapReduceEntriesToIntTask2 = (MapReduceEntriesToIntTask) firstComplete;
                MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask2.rights;
                while (mapReduceEntriesToIntTask3 != null) {
                    mapReduceEntriesToIntTask2.result = intByIntToInt.apply(mapReduceEntriesToIntTask2.result, mapReduceEntriesToIntTask3.result);
                    mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask3.nextRight;
                    mapReduceEntriesToIntTask2.rights = mapReduceEntriesToIntTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceEntriesToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        final ObjectToLong<Map.Entry<K, V>> transformer;

        MapReduceEntriesToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask, ObjectToLong<Map.Entry<K, V>> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<Map.Entry<K, V>> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long j = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask = new MapReduceEntriesToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, j, longByLongToLong);
                this.rights = mapReduceEntriesToLongTask;
                mapReduceEntriesToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<Map.Entry<K, V>> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                j = longByLongToLong.apply(j, objectToLong2.apply(advance));
            }
            this.result = j;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceEntriesToLongTask mapReduceEntriesToLongTask2 = (MapReduceEntriesToLongTask) firstComplete;
                MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask2.rights;
                while (mapReduceEntriesToLongTask3 != null) {
                    mapReduceEntriesToLongTask2.result = longByLongToLong.apply(mapReduceEntriesToLongTask2.result, mapReduceEntriesToLongTask3.result);
                    mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask3.nextRight;
                    mapReduceEntriesToLongTask2.rights = mapReduceEntriesToLongTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceKeysTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        final Fun<? super K, ? extends U> transformer;

        MapReduceKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysTask<K, V, U> mapReduceKeysTask, Fun<? super K, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<? super K, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysTask<K, V, U> mapReduceKeysTask = new MapReduceKeysTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceKeysTask;
                mapReduceKeysTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply((K) advance.key);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceKeysTask mapReduceKeysTask2 = (MapReduceKeysTask) firstComplete;
                MapReduceKeysTask<K, V, U> mapReduceKeysTask3 = mapReduceKeysTask2.rights;
                while (mapReduceKeysTask3 != null) {
                    U u = mapReduceKeysTask3.result;
                    if (u != null) {
                        Object obj3 = (U) mapReduceKeysTask2.result;
                        if (obj3 != null) {
                            u = biFun.apply(obj3, u);
                        }
                        mapReduceKeysTask2.result = (U) u;
                    }
                    mapReduceKeysTask3 = mapReduceKeysTask3.nextRight;
                    mapReduceKeysTask2.rights = mapReduceKeysTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        final ObjectToDouble<? super K> transformer;

        MapReduceKeysToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask, ObjectToDouble<? super K> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<? super K> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double d = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask = new MapReduceKeysToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, d, doubleByDoubleToDouble);
                this.rights = mapReduceKeysToDoubleTask;
                mapReduceKeysToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<? super K> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                d = doubleByDoubleToDouble.apply(d, objectToDouble2.apply((K) advance.key));
            }
            this.result = d;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceKeysToDoubleTask mapReduceKeysToDoubleTask2 = (MapReduceKeysToDoubleTask) firstComplete;
                MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask2.rights;
                while (mapReduceKeysToDoubleTask3 != null) {
                    mapReduceKeysToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceKeysToDoubleTask2.result, mapReduceKeysToDoubleTask3.result);
                    mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask3.nextRight;
                    mapReduceKeysToDoubleTask2.rights = mapReduceKeysToDoubleTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceKeysToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        final ObjectToInt<? super K> transformer;

        MapReduceKeysToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask, ObjectToInt<? super K> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<? super K> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int i = this.basis;
            int i2 = this.baseIndex;
            while (this.batch > 0) {
                int i3 = this.baseLimit;
                int i4 = (i3 + i2) >>> 1;
                if (i4 <= i2) {
                    break;
                }
                addToPendingCount(1);
                int i5 = this.batch >>> 1;
                this.batch = i5;
                this.baseLimit = i4;
                MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask = new MapReduceKeysToIntTask<>(this, i5, i4, i3, this.tab, this.rights, objectToInt, i, intByIntToInt);
                this.rights = mapReduceKeysToIntTask;
                mapReduceKeysToIntTask.fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                i = intByIntToInt.apply(i, objectToInt.apply((K) advance.key));
            }
            this.result = i;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceKeysToIntTask mapReduceKeysToIntTask2 = (MapReduceKeysToIntTask) firstComplete;
                MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask3 = mapReduceKeysToIntTask2.rights;
                while (mapReduceKeysToIntTask3 != null) {
                    mapReduceKeysToIntTask2.result = intByIntToInt.apply(mapReduceKeysToIntTask2.result, mapReduceKeysToIntTask3.result);
                    mapReduceKeysToIntTask3 = mapReduceKeysToIntTask3.nextRight;
                    mapReduceKeysToIntTask2.rights = mapReduceKeysToIntTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceKeysToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        final ObjectToLong<? super K> transformer;

        MapReduceKeysToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask, ObjectToLong<? super K> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<? super K> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long j = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask = new MapReduceKeysToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, j, longByLongToLong);
                this.rights = mapReduceKeysToLongTask;
                mapReduceKeysToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<? super K> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                j = longByLongToLong.apply(j, objectToLong2.apply((K) advance.key));
            }
            this.result = j;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceKeysToLongTask mapReduceKeysToLongTask2 = (MapReduceKeysToLongTask) firstComplete;
                MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask3 = mapReduceKeysToLongTask2.rights;
                while (mapReduceKeysToLongTask3 != null) {
                    mapReduceKeysToLongTask2.result = longByLongToLong.apply(mapReduceKeysToLongTask2.result, mapReduceKeysToLongTask3.result);
                    mapReduceKeysToLongTask3 = mapReduceKeysToLongTask3.nextRight;
                    mapReduceKeysToLongTask2.rights = mapReduceKeysToLongTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceMappingsTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        final BiFun<? super K, ? super V, ? extends U> transformer;

        MapReduceMappingsTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsTask<K, V, U> mapReduceMappingsTask, BiFun<? super K, ? super V, ? extends U> biFun, BiFun<? super U, ? super U, ? extends U> biFun2) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsTask;
            this.transformer = biFun;
            this.reducer = biFun2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            BiFun<? super K, ? super V, ? extends U> biFun2 = this.transformer;
            if (biFun2 == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsTask<K, V, U> mapReduceMappingsTask = new MapReduceMappingsTask<>(this, i4, i3, i2, this.tab, this.rights, biFun2, biFun);
                this.rights = mapReduceMappingsTask;
                mapReduceMappingsTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                Object obj2 = (U) biFun2.apply((K) advance.key, (V) advance.val);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceMappingsTask mapReduceMappingsTask2 = (MapReduceMappingsTask) firstComplete;
                MapReduceMappingsTask<K, V, U> mapReduceMappingsTask3 = mapReduceMappingsTask2.rights;
                while (mapReduceMappingsTask3 != null) {
                    U u = mapReduceMappingsTask3.result;
                    if (u != null) {
                        Object obj3 = (U) mapReduceMappingsTask2.result;
                        if (obj3 != null) {
                            u = biFun.apply(obj3, u);
                        }
                        mapReduceMappingsTask2.result = (U) u;
                    }
                    mapReduceMappingsTask3 = mapReduceMappingsTask3.nextRight;
                    mapReduceMappingsTask2.rights = mapReduceMappingsTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        final ObjectByObjectToDouble<? super K, ? super V> transformer;

        MapReduceMappingsToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask, ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToDoubleTask;
            this.transformer = objectByObjectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble = this.transformer;
            if (objectByObjectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double d = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask = new MapReduceMappingsToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectByObjectToDouble, d, doubleByDoubleToDouble);
                this.rights = mapReduceMappingsToDoubleTask;
                mapReduceMappingsToDoubleTask.fork();
                objectByObjectToDouble = objectByObjectToDouble;
                i = i;
            }
            ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble2 = objectByObjectToDouble;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                d = doubleByDoubleToDouble.apply(d, objectByObjectToDouble2.apply((K) advance.key, (V) advance.val));
            }
            this.result = d;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceMappingsToDoubleTask mapReduceMappingsToDoubleTask2 = (MapReduceMappingsToDoubleTask) firstComplete;
                MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask2.rights;
                while (mapReduceMappingsToDoubleTask3 != null) {
                    mapReduceMappingsToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceMappingsToDoubleTask2.result, mapReduceMappingsToDoubleTask3.result);
                    mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask3.nextRight;
                    mapReduceMappingsToDoubleTask2.rights = mapReduceMappingsToDoubleTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceMappingsToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        final ObjectByObjectToInt<? super K, ? super V> transformer;

        MapReduceMappingsToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask, ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToIntTask;
            this.transformer = objectByObjectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt = this.transformer;
            if (objectByObjectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int i = this.basis;
            int i2 = this.baseIndex;
            while (this.batch > 0) {
                int i3 = this.baseLimit;
                int i4 = (i3 + i2) >>> 1;
                if (i4 <= i2) {
                    break;
                }
                addToPendingCount(1);
                int i5 = this.batch >>> 1;
                this.batch = i5;
                this.baseLimit = i4;
                MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask = new MapReduceMappingsToIntTask<>(this, i5, i4, i3, this.tab, this.rights, objectByObjectToInt, i, intByIntToInt);
                this.rights = mapReduceMappingsToIntTask;
                mapReduceMappingsToIntTask.fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                i = intByIntToInt.apply(i, objectByObjectToInt.apply((K) advance.key, (V) advance.val));
            }
            this.result = i;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceMappingsToIntTask mapReduceMappingsToIntTask2 = (MapReduceMappingsToIntTask) firstComplete;
                MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask2.rights;
                while (mapReduceMappingsToIntTask3 != null) {
                    mapReduceMappingsToIntTask2.result = intByIntToInt.apply(mapReduceMappingsToIntTask2.result, mapReduceMappingsToIntTask3.result);
                    mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask3.nextRight;
                    mapReduceMappingsToIntTask2.rights = mapReduceMappingsToIntTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceMappingsToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        final ObjectByObjectToLong<? super K, ? super V> transformer;

        MapReduceMappingsToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask, ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToLongTask;
            this.transformer = objectByObjectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong = this.transformer;
            if (objectByObjectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long j = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask = new MapReduceMappingsToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectByObjectToLong, j, longByLongToLong);
                this.rights = mapReduceMappingsToLongTask;
                mapReduceMappingsToLongTask.fork();
                objectByObjectToLong = objectByObjectToLong;
                i = i;
            }
            ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong2 = objectByObjectToLong;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                j = longByLongToLong.apply(j, objectByObjectToLong2.apply((K) advance.key, (V) advance.val));
            }
            this.result = j;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceMappingsToLongTask mapReduceMappingsToLongTask2 = (MapReduceMappingsToLongTask) firstComplete;
                MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask2.rights;
                while (mapReduceMappingsToLongTask3 != null) {
                    mapReduceMappingsToLongTask2.result = longByLongToLong.apply(mapReduceMappingsToLongTask2.result, mapReduceMappingsToLongTask3.result);
                    mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask3.nextRight;
                    mapReduceMappingsToLongTask2.rights = mapReduceMappingsToLongTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceValuesTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        final Fun<? super V, ? extends U> transformer;

        MapReduceValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesTask<K, V, U> mapReduceValuesTask, Fun<? super V, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<? super V, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesTask<K, V, U> mapReduceValuesTask = new MapReduceValuesTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceValuesTask;
                mapReduceValuesTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply((V) advance.val);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceValuesTask mapReduceValuesTask2 = (MapReduceValuesTask) firstComplete;
                MapReduceValuesTask<K, V, U> mapReduceValuesTask3 = mapReduceValuesTask2.rights;
                while (mapReduceValuesTask3 != null) {
                    U u = mapReduceValuesTask3.result;
                    if (u != null) {
                        Object obj3 = (U) mapReduceValuesTask2.result;
                        if (obj3 != null) {
                            u = biFun.apply(obj3, u);
                        }
                        mapReduceValuesTask2.result = (U) u;
                    }
                    mapReduceValuesTask3 = mapReduceValuesTask3.nextRight;
                    mapReduceValuesTask2.rights = mapReduceValuesTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        final ObjectToDouble<? super V> transformer;

        MapReduceValuesToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask, ObjectToDouble<? super V> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<? super V> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double d = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask = new MapReduceValuesToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, d, doubleByDoubleToDouble);
                this.rights = mapReduceValuesToDoubleTask;
                mapReduceValuesToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<? super V> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                d = doubleByDoubleToDouble.apply(d, objectToDouble2.apply((V) advance.val));
            }
            this.result = d;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceValuesToDoubleTask mapReduceValuesToDoubleTask2 = (MapReduceValuesToDoubleTask) firstComplete;
                MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask2.rights;
                while (mapReduceValuesToDoubleTask3 != null) {
                    mapReduceValuesToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceValuesToDoubleTask2.result, mapReduceValuesToDoubleTask3.result);
                    mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask3.nextRight;
                    mapReduceValuesToDoubleTask2.rights = mapReduceValuesToDoubleTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceValuesToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        final ObjectToInt<? super V> transformer;

        MapReduceValuesToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask, ObjectToInt<? super V> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<? super V> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int i = this.basis;
            int i2 = this.baseIndex;
            while (this.batch > 0) {
                int i3 = this.baseLimit;
                int i4 = (i3 + i2) >>> 1;
                if (i4 <= i2) {
                    break;
                }
                addToPendingCount(1);
                int i5 = this.batch >>> 1;
                this.batch = i5;
                this.baseLimit = i4;
                MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask = new MapReduceValuesToIntTask<>(this, i5, i4, i3, this.tab, this.rights, objectToInt, i, intByIntToInt);
                this.rights = mapReduceValuesToIntTask;
                mapReduceValuesToIntTask.fork();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                i = intByIntToInt.apply(i, objectToInt.apply((V) advance.val));
            }
            this.result = i;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceValuesToIntTask mapReduceValuesToIntTask2 = (MapReduceValuesToIntTask) firstComplete;
                MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask3 = mapReduceValuesToIntTask2.rights;
                while (mapReduceValuesToIntTask3 != null) {
                    mapReduceValuesToIntTask2.result = intByIntToInt.apply(mapReduceValuesToIntTask2.result, mapReduceValuesToIntTask3.result);
                    mapReduceValuesToIntTask3 = mapReduceValuesToIntTask3.nextRight;
                    mapReduceValuesToIntTask2.rights = mapReduceValuesToIntTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceValuesToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        final ObjectToLong<? super V> transformer;

        MapReduceValuesToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask, ObjectToLong<? super V> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<? super V> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long j = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask = new MapReduceValuesToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, j, longByLongToLong);
                this.rights = mapReduceValuesToLongTask;
                mapReduceValuesToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<? super V> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    break;
                }
                j = longByLongToLong.apply(j, objectToLong2.apply((V) advance.val));
            }
            this.result = j;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                MapReduceValuesToLongTask mapReduceValuesToLongTask2 = (MapReduceValuesToLongTask) firstComplete;
                MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask3 = mapReduceValuesToLongTask2.rights;
                while (mapReduceValuesToLongTask3 != null) {
                    mapReduceValuesToLongTask2.result = longByLongToLong.apply(mapReduceValuesToLongTask2.result, mapReduceValuesToLongTask3.result);
                    mapReduceValuesToLongTask3 = mapReduceValuesToLongTask3.nextRight;
                    mapReduceValuesToLongTask2.rights = mapReduceValuesToLongTask3;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        volatile Node<K, V> next;
        volatile V val;

        Node(int i, K k, V v, Node<K, V> node) {
            this.hash = i;
            this.key = k;
            this.val = v;
            this.next = node;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            K k;
            V v;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (k = this.key) || key.equals(k)) && (value == (v = this.val) || value.equals(v));
        }

        Node<K, V> find(int i, Object obj) {
            K k;
            if (obj != null) {
                Node<K, V> node = this;
                do {
                    if (node.hash == i && ((k = node.key) == obj || (k != null && obj.equals(k)))) {
                        return node;
                    }
                    node = node.next;
                } while (node != null);
                return null;
            }
            return null;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectByObjectToDouble<A, B> {
        double apply(A a, B b);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectByObjectToInt<A, B> {
        int apply(A a, B b);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectByObjectToLong<A, B> {
        long apply(A a, B b);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectToDouble<A> {
        double apply(A a);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectToInt<A> {
        int apply(A a);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface ObjectToLong<A> {
        long apply(A a);
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>> {
        ReduceEntriesTask<K, V> nextRight;
        final BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;

        ReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceEntriesTask<K, V> reduceEntriesTask, BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceEntriesTask;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceEntriesTask<K, V> reduceEntriesTask = new ReduceEntriesTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceEntriesTask;
                    reduceEntriesTask.fork();
                }
                Map.Entry<K, V> entry = null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    entry = entry == null ? advance : biFun.apply(entry, advance);
                }
                this.result = entry;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    ReduceEntriesTask reduceEntriesTask2 = (ReduceEntriesTask) firstComplete;
                    ReduceEntriesTask<K, V> reduceEntriesTask3 = reduceEntriesTask2.rights;
                    while (reduceEntriesTask3 != null) {
                        Map.Entry<K, V> entry2 = reduceEntriesTask3.result;
                        if (entry2 != null) {
                            Map.Entry<K, V> entry3 = reduceEntriesTask2.result;
                            if (entry3 != null) {
                                entry2 = biFun.apply(entry3, entry2);
                            }
                            reduceEntriesTask2.result = entry2;
                        }
                        reduceEntriesTask3 = reduceEntriesTask3.nextRight;
                        reduceEntriesTask2.rights = reduceEntriesTask3;
                    }
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Map.Entry<K, V> getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K> {
        ReduceKeysTask<K, V> nextRight;
        final BiFun<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;

        ReduceKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceKeysTask<K, V> reduceKeysTask, BiFun<? super K, ? super K, ? extends K> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceKeysTask;
            this.reducer = biFun;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super K, ? super K, ? extends K> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceKeysTask<K, V> reduceKeysTask = new ReduceKeysTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceKeysTask;
                    reduceKeysTask.fork();
                }
                Object obj = (K) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    K k = advance.key;
                    if (obj == null) {
                        obj = k;
                    } else if (k != 0) {
                        obj = (K) biFun.apply(obj, k);
                    }
                }
                this.result = (K) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    ReduceKeysTask reduceKeysTask2 = (ReduceKeysTask) firstComplete;
                    ReduceKeysTask<K, V> reduceKeysTask3 = reduceKeysTask2.rights;
                    while (reduceKeysTask3 != null) {
                        K k2 = reduceKeysTask3.result;
                        if (k2 != null) {
                            Object obj2 = (K) reduceKeysTask2.result;
                            if (obj2 != null) {
                                k2 = biFun.apply(obj2, k2);
                            }
                            reduceKeysTask2.result = (K) k2;
                        }
                        reduceKeysTask3 = reduceKeysTask3.nextRight;
                        reduceKeysTask2.rights = reduceKeysTask3;
                    }
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final K getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V> {
        ReduceValuesTask<K, V> nextRight;
        final BiFun<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;

        ReduceValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceValuesTask<K, V> reduceValuesTask, BiFun<? super V, ? super V, ? extends V> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceValuesTask;
            this.reducer = biFun;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super V, ? super V, ? extends V> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceValuesTask<K, V> reduceValuesTask = new ReduceValuesTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceValuesTask;
                    reduceValuesTask.fork();
                }
                Object obj = (V) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    V v = advance.val;
                    obj = obj == null ? v : (V) biFun.apply(obj, v);
                }
                this.result = (V) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    ReduceValuesTask reduceValuesTask2 = (ReduceValuesTask) firstComplete;
                    ReduceValuesTask<K, V> reduceValuesTask3 = reduceValuesTask2.rights;
                    while (reduceValuesTask3 != null) {
                        V v2 = reduceValuesTask3.result;
                        if (v2 != null) {
                            Object obj2 = (V) reduceValuesTask2.result;
                            if (obj2 != null) {
                                v2 = biFun.apply(obj2, v2);
                            }
                            reduceValuesTask2.result = (V) v2;
                        }
                        reduceValuesTask3 = reduceValuesTask3.nextRight;
                        reduceValuesTask2.rights = reduceValuesTask3;
                    }
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final V getRawResult() {
            return this.result;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ReservationNode<K, V> extends Node<K, V> {
        ReservationNode() {
            super(-3, null, null, null);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        Node<K, V> find(int i, Object obj) {
            return null;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<Map.Entry<K, V>, ? extends U> searchFunction;

        SearchEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<Map.Entry<K, V>, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                } else if (atomicReference.get() != null) {
                    return;
                } else {
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    new SearchEntriesTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
                }
            }
            while (atomicReference.get() == null) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    propagateCompletion();
                    return;
                }
                U apply = fun.apply(advance);
                if (apply != null) {
                    if (atomicReference.compareAndSet(null, apply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<? super K, ? extends U> searchFunction;

        SearchKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super K, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<? super K, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                } else if (atomicReference.get() != null) {
                    return;
                } else {
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    new SearchKeysTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
                }
            }
            while (atomicReference.get() == null) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    propagateCompletion();
                    return;
                }
                U apply = fun.apply((K) advance.key);
                if (apply != null) {
                    if (atomicReference.compareAndSet(null, apply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final BiFun<? super K, ? super V, ? extends U> searchFunction;

        SearchMappingsTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiFun<? super K, ? super V, ? extends U> biFun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = biFun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            BiFun<? super K, ? super V, ? extends U> biFun = this.searchFunction;
            if (biFun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                } else if (atomicReference.get() != null) {
                    return;
                } else {
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    new SearchMappingsTask(this, i4, i3, i2, this.tab, biFun, atomicReference).fork();
                }
            }
            while (atomicReference.get() == null) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    propagateCompletion();
                    return;
                }
                U apply = biFun.apply((K) advance.key, (V) advance.val);
                if (apply != null) {
                    if (atomicReference.compareAndSet(null, apply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<? super V, ? extends U> searchFunction;

        SearchValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super V, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<? super V, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                } else if (atomicReference.get() != null) {
                    return;
                } else {
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    new SearchValuesTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
                }
            }
            while (atomicReference.get() == null) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    propagateCompletion();
                    return;
                }
                U apply = fun.apply((V) advance.val);
                if (apply != null) {
                    if (atomicReference.compareAndSet(null, apply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        Segment(float f) {
            this.loadFactor = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class Traverser<K, V> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node<K, V> next = null;
        Node<K, V>[] tab;

        Traverser(Node<K, V>[] nodeArr, int i, int i2, int i3) {
            this.tab = nodeArr;
            this.baseSize = i;
            this.index = i2;
            this.baseIndex = i2;
            this.baseLimit = i3;
        }

        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int length;
            int i;
            Node<K, V> node = this.next;
            if (node != null) {
                node = node.next;
            }
            while (node == null) {
                if (this.baseIndex < this.baseLimit && (nodeArr = this.tab) != null && (length = nodeArr.length) > (i = this.index) && i >= 0) {
                    node = ConcurrentHashMapV8.tabAt(nodeArr, i);
                    if (node != null && node.hash < 0) {
                        if (node instanceof ForwardingNode) {
                            this.tab = ((ForwardingNode) node).nextTable;
                            node = null;
                        } else {
                            node = node instanceof TreeBin ? ((TreeBin) node).first : null;
                        }
                    }
                    int i2 = this.index + this.baseSize;
                    this.index = i2;
                    if (i2 >= length) {
                        int i3 = this.baseIndex + 1;
                        this.baseIndex = i3;
                        this.index = i3;
                    }
                } else {
                    this.next = null;
                    return null;
                }
            }
            this.next = node;
            return node;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class TreeBin<K, V> extends Node<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long LOCKSTATE;
        static final int READER = 4;

        /* renamed from: U */
        private static final Unsafe f40312U;
        static final int WAITER = 2;
        static final int WRITER = 1;
        volatile TreeNode<K, V> first;
        volatile int lockState;
        TreeNode<K, V> root;
        volatile Thread waiter;

        static {
            try {
                Unsafe access$000 = ConcurrentHashMapV8.access$000();
                f40312U = access$000;
                LOCKSTATE = access$000.objectFieldOffset(TreeBin.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TreeBin(TreeNode<K, V> treeNode) {
            super(-2, null, null, null);
            int compareComparables;
            this.first = treeNode;
            TreeNode<K, V> treeNode2 = null;
            while (treeNode != null) {
                TreeNode<K, V> treeNode3 = (TreeNode) treeNode.next;
                treeNode.right = null;
                treeNode.left = null;
                if (treeNode2 == null) {
                    treeNode.parent = null;
                    treeNode.red = false;
                } else {
                    K k = treeNode.key;
                    int i = treeNode.hash;
                    TreeNode<K, V> treeNode4 = treeNode2;
                    Class<?> cls = null;
                    while (true) {
                        int i2 = treeNode4.hash;
                        if (i2 > i) {
                            compareComparables = -1;
                        } else if (i2 < i) {
                            compareComparables = 1;
                        } else {
                            compareComparables = (cls == null && (cls = ConcurrentHashMapV8.comparableClassFor(k)) == null) ? 0 : ConcurrentHashMapV8.compareComparables(cls, k, treeNode4.key);
                        }
                        TreeNode<K, V> treeNode5 = compareComparables <= 0 ? treeNode4.left : treeNode4.right;
                        if (treeNode5 == null) {
                            break;
                        }
                        treeNode4 = treeNode5;
                    }
                    treeNode.parent = treeNode4;
                    if (compareComparables <= 0) {
                        treeNode4.left = treeNode;
                    } else {
                        treeNode4.right = treeNode;
                    }
                    treeNode = balanceInsertion(treeNode2, treeNode);
                }
                treeNode2 = treeNode;
                treeNode = treeNode3;
            }
            this.root = treeNode2;
        }

        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            while (treeNode2 != null && treeNode2 != treeNode) {
                TreeNode<K, V> treeNode3 = treeNode2.parent;
                if (treeNode3 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                } else if (treeNode2.red) {
                    treeNode2.red = false;
                    return treeNode;
                } else {
                    TreeNode<K, V> treeNode4 = treeNode3.left;
                    if (treeNode4 == treeNode2) {
                        TreeNode<K, V> treeNode5 = treeNode3.right;
                        if (treeNode5 != null && treeNode5.red) {
                            treeNode5.red = false;
                            treeNode3.red = true;
                            treeNode = rotateLeft(treeNode, treeNode3);
                            treeNode3 = treeNode2.parent;
                            treeNode5 = treeNode3 == null ? null : treeNode3.right;
                        }
                        if (treeNode5 != null) {
                            TreeNode<K, V> treeNode6 = treeNode5.left;
                            TreeNode<K, V> treeNode7 = treeNode5.right;
                            if ((treeNode7 != null && treeNode7.red) || (treeNode6 != null && treeNode6.red)) {
                                if (treeNode7 == null || !treeNode7.red) {
                                    if (treeNode6 != null) {
                                        treeNode6.red = false;
                                    }
                                    treeNode5.red = true;
                                    treeNode = rotateRight(treeNode, treeNode5);
                                    treeNode3 = treeNode2.parent;
                                    treeNode5 = treeNode3 != null ? treeNode3.right : null;
                                }
                                if (treeNode5 != null) {
                                    treeNode5.red = treeNode3 == null ? false : treeNode3.red;
                                    TreeNode<K, V> treeNode8 = treeNode5.right;
                                    if (treeNode8 != null) {
                                        treeNode8.red = false;
                                    }
                                }
                                if (treeNode3 != null) {
                                    treeNode3.red = false;
                                    treeNode = rotateLeft(treeNode, treeNode3);
                                }
                                treeNode2 = treeNode;
                            } else {
                                treeNode5.red = true;
                            }
                        }
                        treeNode2 = treeNode3;
                    } else {
                        if (treeNode4 != null && treeNode4.red) {
                            treeNode4.red = false;
                            treeNode3.red = true;
                            treeNode = rotateRight(treeNode, treeNode3);
                            treeNode3 = treeNode2.parent;
                            treeNode4 = treeNode3 == null ? null : treeNode3.left;
                        }
                        if (treeNode4 != null) {
                            TreeNode<K, V> treeNode9 = treeNode4.left;
                            TreeNode<K, V> treeNode10 = treeNode4.right;
                            if ((treeNode9 != null && treeNode9.red) || (treeNode10 != null && treeNode10.red)) {
                                if (treeNode9 == null || !treeNode9.red) {
                                    if (treeNode10 != null) {
                                        treeNode10.red = false;
                                    }
                                    treeNode4.red = true;
                                    treeNode = rotateLeft(treeNode, treeNode4);
                                    treeNode3 = treeNode2.parent;
                                    treeNode4 = treeNode3 != null ? treeNode3.left : null;
                                }
                                if (treeNode4 != null) {
                                    treeNode4.red = treeNode3 == null ? false : treeNode3.red;
                                    TreeNode<K, V> treeNode11 = treeNode4.left;
                                    if (treeNode11 != null) {
                                        treeNode11.red = false;
                                    }
                                }
                                if (treeNode3 != null) {
                                    treeNode3.red = false;
                                    treeNode = rotateRight(treeNode, treeNode3);
                                }
                                treeNode2 = treeNode;
                            } else {
                                treeNode4.red = true;
                            }
                        }
                        treeNode2 = treeNode3;
                    }
                }
            }
            return treeNode;
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            treeNode2.red = true;
            while (true) {
                TreeNode<K, V> treeNode4 = treeNode2.parent;
                if (treeNode4 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                } else if (!treeNode4.red || (treeNode3 = treeNode4.parent) == null) {
                    break;
                } else {
                    TreeNode<K, V> treeNode5 = treeNode3.left;
                    if (treeNode4 == treeNode5) {
                        TreeNode<K, V> treeNode6 = treeNode3.right;
                        if (treeNode6 != null && treeNode6.red) {
                            treeNode6.red = false;
                            treeNode4.red = false;
                            treeNode3.red = true;
                            treeNode2 = treeNode3;
                        } else {
                            if (treeNode2 == treeNode4.right) {
                                treeNode = rotateLeft(treeNode, treeNode4);
                                TreeNode<K, V> treeNode7 = treeNode4.parent;
                                treeNode3 = treeNode7 == null ? null : treeNode7.parent;
                                treeNode4 = treeNode7;
                                treeNode2 = treeNode4;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = false;
                                if (treeNode3 != null) {
                                    treeNode3.red = true;
                                    treeNode = rotateRight(treeNode, treeNode3);
                                }
                            }
                        }
                    } else if (treeNode5 != null && treeNode5.red) {
                        treeNode5.red = false;
                        treeNode4.red = false;
                        treeNode3.red = true;
                        treeNode2 = treeNode3;
                    } else {
                        if (treeNode2 == treeNode4.left) {
                            treeNode = rotateRight(treeNode, treeNode4);
                            TreeNode<K, V> treeNode8 = treeNode4.parent;
                            treeNode3 = treeNode8 == null ? null : treeNode8.parent;
                            treeNode4 = treeNode8;
                            treeNode2 = treeNode4;
                        }
                        if (treeNode4 != null) {
                            treeNode4.red = false;
                            if (treeNode3 != null) {
                                treeNode3.red = true;
                                treeNode = rotateLeft(treeNode, treeNode3);
                            }
                        }
                    }
                }
            }
            return treeNode;
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2 = treeNode.parent;
            TreeNode<K, V> treeNode3 = treeNode.left;
            TreeNode<K, V> treeNode4 = treeNode.right;
            TreeNode<K, V> treeNode5 = treeNode.prev;
            TreeNode treeNode6 = (TreeNode) treeNode.next;
            if (treeNode5 == null || treeNode5.next == treeNode) {
                if (treeNode6 == null || treeNode6.prev == treeNode) {
                    if (treeNode2 == null || treeNode == treeNode2.left || treeNode == treeNode2.right) {
                        if (treeNode3 == null || (treeNode3.parent == treeNode && treeNode3.hash <= treeNode.hash)) {
                            if (treeNode4 == null || (treeNode4.parent == treeNode && treeNode4.hash >= treeNode.hash)) {
                                if (treeNode.red && treeNode3 != null && treeNode3.red && treeNode4 != null && treeNode4.red) {
                                    return false;
                                }
                                if (treeNode3 == null || checkInvariants(treeNode3)) {
                                    return treeNode4 == null || checkInvariants(treeNode4);
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private final void contendedLock() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & 1) == 0) {
                    if (f40312U.compareAndSwapInt(this, LOCKSTATE, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (f40312U.compareAndSwapInt(this, LOCKSTATE, i, i | 2)) {
                        this.waiter = Thread.currentThread();
                        z = true;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.waiter = null;
            }
        }

        private final void lockRoot() {
            if (f40312U.compareAndSwapInt(this, LOCKSTATE, 0, 1)) {
                return;
            }
            contendedLock();
        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.right) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.left;
                treeNode2.right = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.left == treeNode2) {
                    treeNode5.left = treeNode3;
                } else {
                    treeNode5.right = treeNode3;
                }
                treeNode3.left = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.left) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.right;
                treeNode2.left = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.right == treeNode2) {
                    treeNode5.right = treeNode3;
                } else {
                    treeNode5.left = treeNode3;
                }
                treeNode3.right = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        private final void unlockRoot() {
            this.lockState = 0;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        final Node<K, V> find(int i, Object obj) {
            Unsafe unsafe;
            long j;
            int i2;
            Thread thread;
            K k;
            TreeNode<K, V> treeNode = null;
            if (obj != null) {
                for (Node<K, V> node = this.first; node != null; node = node.next) {
                    int i3 = this.lockState;
                    if ((i3 & 3) != 0) {
                        if (node.hash == i && ((k = node.key) == obj || (k != null && obj.equals(k)))) {
                            return node;
                        }
                    } else if (f40312U.compareAndSwapInt(this, LOCKSTATE, i3, i3 + 4)) {
                        try {
                            TreeNode<K, V> treeNode2 = this.root;
                            if (treeNode2 != null) {
                                treeNode = treeNode2.findTreeNode(i, obj, null);
                            }
                            return treeNode;
                        } finally {
                            do {
                                unsafe = f40312U;
                                j = LOCKSTATE;
                                i2 = this.lockState;
                            } while (!unsafe.compareAndSwapInt(this, j, i2, i2 - 4));
                            if (i2 == 6 && (thread = this.waiter) != null) {
                                LockSupport.unpark(thread);
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x008f A[LOOP:0: B:3:0x0004->B:51:0x008f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x005a A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeNode<K, V> putTreeVal(int r13, K r14, V r15) {
            /*
                r12 = this;
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r0 = r12.root
                r1 = 0
                r2 = r1
            L4:
                if (r0 != 0) goto L17
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r0 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode
                r7 = 0
                r8 = 0
                r3 = r0
                r4 = r13
                r5 = r14
                r6 = r15
                r3.<init>(r4, r5, r6, r7, r8)
                r12.root = r0
                r12.first = r0
                goto L89
            L17:
                int r3 = r0.hash
                r4 = -1
                r8 = 1
                if (r3 <= r13) goto L1f
            L1d:
                r9 = -1
                goto L51
            L1f:
                if (r3 >= r13) goto L23
            L21:
                r9 = 1
                goto L51
            L23:
                K r3 = r0.key
                if (r3 == r14) goto L92
                if (r3 == 0) goto L31
                boolean r5 = r14.equals(r3)
                if (r5 == 0) goto L31
                goto L92
            L31:
                if (r2 != 0) goto L39
                java.lang.Class r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.comparableClassFor(r14)
                if (r2 == 0) goto L3f
            L39:
                int r3 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.compareComparables(r2, r14, r3)
                if (r3 != 0) goto L50
            L3f:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.left
                if (r3 != 0) goto L44
                goto L21
            L44:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.right
                if (r3 == 0) goto L1d
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r3 = r3.findTreeNode(r13, r14, r2)
                if (r3 != 0) goto L4f
                goto L1d
            L4f:
                return r3
            L50:
                r9 = r3
            L51:
                if (r9 >= 0) goto L56
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.left
                goto L58
            L56:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.right
            L58:
                if (r3 != 0) goto L8f
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r10 = r12.first
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r11 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode
                r2 = r11
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r10
                r7 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                r12.first = r11
                if (r10 == 0) goto L6d
                r10.prev = r11
            L6d:
                if (r9 >= 0) goto L72
                r0.left = r11
                goto L74
            L72:
                r0.right = r11
            L74:
                boolean r13 = r0.red
                if (r13 != 0) goto L7b
                r11.red = r8
                goto L89
            L7b:
                r12.lockRoot()
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r13 = r12.root     // Catch: java.lang.Throwable -> L8a
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r13 = balanceInsertion(r13, r11)     // Catch: java.lang.Throwable -> L8a
                r12.root = r13     // Catch: java.lang.Throwable -> L8a
                r12.unlockRoot()
            L89:
                return r1
            L8a:
                r13 = move-exception
                r12.unlockRoot()
                throw r13
            L8f:
                r0 = r3
                goto L4
            L92:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin.putTreeVal(int, java.lang.Object, java.lang.Object):io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode");
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x008d A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:22:0x002f, B:26:0x0038, B:29:0x003e, B:31:0x004c, B:39:0x0064, B:41:0x006e, B:42:0x0070, B:57:0x008d, B:64:0x009e, B:60:0x0095, B:62:0x0099, B:63:0x009c, B:65:0x00a4, B:69:0x00ad, B:71:0x00b1, B:73:0x00b5, B:75:0x00b9, B:79:0x00c2, B:76:0x00bc, B:78:0x00c0, B:68:0x00a9, B:45:0x0076, B:47:0x007a, B:48:0x007d, B:32:0x0051, B:34:0x0057, B:36:0x005b, B:37:0x005e, B:38:0x0060), top: B:86:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00a9 A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:22:0x002f, B:26:0x0038, B:29:0x003e, B:31:0x004c, B:39:0x0064, B:41:0x006e, B:42:0x0070, B:57:0x008d, B:64:0x009e, B:60:0x0095, B:62:0x0099, B:63:0x009c, B:65:0x00a4, B:69:0x00ad, B:71:0x00b1, B:73:0x00b5, B:75:0x00b9, B:79:0x00c2, B:76:0x00bc, B:78:0x00c0, B:68:0x00a9, B:45:0x0076, B:47:0x007a, B:48:0x007d, B:32:0x0051, B:34:0x0057, B:36:0x005b, B:37:0x005e, B:38:0x0060), top: B:86:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00b1 A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:22:0x002f, B:26:0x0038, B:29:0x003e, B:31:0x004c, B:39:0x0064, B:41:0x006e, B:42:0x0070, B:57:0x008d, B:64:0x009e, B:60:0x0095, B:62:0x0099, B:63:0x009c, B:65:0x00a4, B:69:0x00ad, B:71:0x00b1, B:73:0x00b5, B:75:0x00b9, B:79:0x00c2, B:76:0x00bc, B:78:0x00c0, B:68:0x00a9, B:45:0x0076, B:47:0x007a, B:48:0x007d, B:32:0x0051, B:34:0x0057, B:36:0x005b, B:37:0x005e, B:38:0x0060), top: B:86:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00b9 A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:22:0x002f, B:26:0x0038, B:29:0x003e, B:31:0x004c, B:39:0x0064, B:41:0x006e, B:42:0x0070, B:57:0x008d, B:64:0x009e, B:60:0x0095, B:62:0x0099, B:63:0x009c, B:65:0x00a4, B:69:0x00ad, B:71:0x00b1, B:73:0x00b5, B:75:0x00b9, B:79:0x00c2, B:76:0x00bc, B:78:0x00c0, B:68:0x00a9, B:45:0x0076, B:47:0x007a, B:48:0x007d, B:32:0x0051, B:34:0x0057, B:36:0x005b, B:37:0x005e, B:38:0x0060), top: B:86:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00bc A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:22:0x002f, B:26:0x0038, B:29:0x003e, B:31:0x004c, B:39:0x0064, B:41:0x006e, B:42:0x0070, B:57:0x008d, B:64:0x009e, B:60:0x0095, B:62:0x0099, B:63:0x009c, B:65:0x00a4, B:69:0x00ad, B:71:0x00b1, B:73:0x00b5, B:75:0x00b9, B:79:0x00c2, B:76:0x00bc, B:78:0x00c0, B:68:0x00a9, B:45:0x0076, B:47:0x007a, B:48:0x007d, B:32:0x0051, B:34:0x0057, B:36:0x005b, B:37:0x005e, B:38:0x0060), top: B:86:0x002f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final boolean removeTreeNode(io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeNode<K, V> r10) {
            /*
                Method dump skipped, instructions count: 207
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin.removeTreeNode(io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class TreeNode<K, V> extends Node<K, V> {
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        TreeNode(int i, K k, V v, Node<K, V> node, TreeNode<K, V> treeNode) {
            super(i, k, v, node);
            this.parent = treeNode;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        Node<K, V> find(int i, Object obj) {
            return findTreeNode(i, obj, null);
        }

        final TreeNode<K, V> findTreeNode(int i, Object obj, Class<?> cls) {
            int compareComparables;
            TreeNode<K, V> findTreeNode;
            if (obj != null) {
                TreeNode<K, V> treeNode = this;
                do {
                    TreeNode<K, V> treeNode2 = treeNode.left;
                    TreeNode<K, V> treeNode3 = treeNode.right;
                    int i2 = treeNode.hash;
                    if (i2 <= i) {
                        if (i2 >= i) {
                            K k = treeNode.key;
                            if (k == obj || (k != null && obj.equals(k))) {
                                return treeNode;
                            }
                            if (treeNode2 == null && treeNode3 == null) {
                                return null;
                            }
                            if ((cls == null && (cls = ConcurrentHashMapV8.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMapV8.compareComparables(cls, obj, k)) == 0) {
                                if (treeNode2 != null) {
                                    if (treeNode3 != null && (findTreeNode = treeNode3.findTreeNode(i, obj, cls)) != null) {
                                        return findTreeNode;
                                    }
                                }
                            } else if (compareComparables >= 0) {
                                treeNode2 = treeNode3;
                            }
                        }
                        treeNode = treeNode3;
                        continue;
                    }
                    treeNode = treeNode2;
                    continue;
                } while (treeNode != null);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Iterator<V>, Enumeration<V> {
        ValueIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> node = this.next;
            if (node != null) {
                V v = node.val;
                this.lastReturned = node;
                advance();
                return v;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ValueSpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<V> {
        long est;

        ValueSpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public void forEachRemaining(Action<? super V> action) {
            action.getClass();
            while (true) {
                Node<K, V> advance = advance();
                if (advance == null) {
                    return;
                }
                action.apply((V) advance.val);
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public boolean tryAdvance(Action<? super V> action) {
            action.getClass();
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.apply((V) advance.val);
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public ConcurrentHashMapSpliterator<V> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new ValueSpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Collection<V>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(concurrentHashMapV8);
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        public void forEach(Action<? super V> action) {
            action.getClass();
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    return;
                }
                action.apply((V) advance.val);
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean remove(Object obj) {
            if (obj != null) {
                Iterator<V> it = iterator();
                while (it.hasNext()) {
                    if (obj.equals(it.next())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public ConcurrentHashMapSpliterator<V> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long sumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueSpliterator(nodeArr, length, 0, length, sumCount >= 0 ? sumCount : 0L);
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        counterHashCodeGenerator = new AtomicInteger();
        try {
            Unsafe unsafe = getUnsafe();
            f40297U = unsafe;
            SIZECTL = unsafe.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafe.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("transferIndex"));
            TRANSFERORIGIN = unsafe.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("transferOrigin"));
            BASECOUNT = unsafe.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("baseCount"));
            CELLSBUSY = unsafe.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafe.objectFieldOffset(CounterCell.class.getDeclaredField(DomainCampaignEx.LOOPBACK_VALUE));
            ABASE = unsafe.arrayBaseOffset(Node[].class);
            int arrayIndexScale = unsafe.arrayIndexScale(Node[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                return;
            }
            throw new Error("data type scale not a power of two");
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentHashMapV8() {
    }

    static /* synthetic */ Unsafe access$000() {
        return getUnsafe();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.compareAndSwapLong(r19, r2, r4, r11) == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r20, int r22) {
        /*
            r19 = this;
            r8 = r19
            r9 = r22
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$CounterCell[] r10 = r8.counterCells
            if (r10 != 0) goto L19
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.f40297U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.BASECOUNT
            long r4 = r8.baseCount
            long r11 = r4 + r20
            r1 = r19
            r6 = r11
            boolean r0 = r0.compareAndSwapLong(r1, r2, r4, r6)
            if (r0 != 0) goto L49
        L19:
            io.netty.util.internal.InternalThreadLocalMap r1 = io.netty.util.internal.InternalThreadLocalMap.get()
            io.netty.util.internal.IntegerHolder r4 = r1.counterHashCode()
            r0 = 1
            if (r4 == 0) goto L94
            if (r10 == 0) goto L94
            int r2 = r10.length
            int r2 = r2 - r0
            if (r2 < 0) goto L94
            int r3 = r4.value
            r2 = r2 & r3
            r12 = r10[r2]
            if (r12 == 0) goto L94
            sun.misc.Unsafe r11 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.f40297U
            long r13 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.CELLVALUE
            long r2 = r12.value
            long r17 = r2 + r20
            r15 = r2
            boolean r2 = r11.compareAndSwapLong(r12, r13, r15, r17)
            if (r2 != 0) goto L42
            r5 = r2
            goto L95
        L42:
            if (r9 > r0) goto L45
            return
        L45:
            long r11 = r19.sumCount()
        L49:
            if (r9 < 0) goto L93
        L4b:
            int r4 = r8.sizeCtl
            long r0 = (long) r4
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 < 0) goto L93
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r6 = r8.table
            if (r6 == 0) goto L93
            int r0 = r6.length
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r1) goto L93
            if (r4 >= 0) goto L7d
            r0 = -1
            if (r4 == r0) goto L93
            int r0 = r8.transferIndex
            int r1 = r8.transferOrigin
            if (r0 <= r1) goto L93
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r7 = r8.nextTable
            if (r7 != 0) goto L6b
            goto L93
        L6b:
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.f40297U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.SIZECTL
            int r5 = r4 + (-1)
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8e
            r8.transfer(r6, r7)
            goto L8e
        L7d:
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.f40297U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.SIZECTL
            r5 = -2
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8e
            r0 = 0
            r8.transfer(r6, r0)
        L8e:
            long r11 = r19.sumCount()
            goto L4b
        L93:
            return
        L94:
            r5 = 1
        L95:
            r0 = r19
            r2 = r20
            r0.fullAddCount(r1, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.addCount(long, int):void");
    }

    static final <K, V> boolean casTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node, Node<K, V> node2) {
        return C14084a.m12679a(f40297U, nodeArr, ABASE + (i << ASHIFT), node, node2);
    }

    static Class<?> comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (obj instanceof Comparable) {
            Class<?> cls = obj.getClass();
            if (cls == String.class) {
                return cls;
            }
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces != null) {
                for (Type type : genericInterfaces) {
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                            return cls;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static int compareComparables(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ae, code lost:
        if (r25.counterCells != r7) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b0, code lost:
        r1 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8.CounterCell[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b5, code lost:
        if (r2 >= r8) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b7, code lost:
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        r25.counterCells = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118 A[EDGE_INSN: B:96:0x0118->B:85:0x0118 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void fullAddCount(io.netty.util.internal.InternalThreadLocalMap r26, long r27, io.netty.util.internal.IntegerHolder r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.fullAddCount(io.netty.util.internal.InternalThreadLocalMap, long, io.netty.util.internal.IntegerHolder, boolean):void");
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ConcurrentHashMapV8.1
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        Field[] declaredFields;
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }

    private final Node<K, V>[] initTable() {
        while (true) {
            Node<K, V>[] nodeArr = this.table;
            if (nodeArr != null && nodeArr.length != 0) {
                return nodeArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else if (f40297U.compareAndSwapInt(this, SIZECTL, i, -1)) {
                try {
                    Node<K, V>[] nodeArr2 = this.table;
                    if (nodeArr2 == null || nodeArr2.length == 0) {
                        int i2 = i > 0 ? i : 16;
                        Node<K, V>[] nodeArr3 = new Node[i2];
                        this.table = nodeArr3;
                        i = i2 - (i2 >>> 2);
                        nodeArr2 = nodeArr3;
                    }
                    this.sizeCtl = i;
                    return nodeArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i;
                    throw th;
                }
            }
        }
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMapV8(), Boolean.TRUE);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        long j;
        int tableSizeFor;
        boolean z;
        K k;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j2 = 0;
        long j3 = 0;
        Node<K, V> node = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j3++;
            node = new Node<>(spread(readObject.hashCode()), readObject, readObject2, node);
        }
        if (j3 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j3 >= IjkMediaMeta.AV_CH_STEREO_LEFT) {
            tableSizeFor = 1073741824;
        } else {
            int i = (int) j3;
            tableSizeFor = tableSizeFor(i + (i >>> 1) + 1);
        }
        Node<K, V>[] nodeArr = new Node[tableSizeFor];
        int i2 = tableSizeFor - 1;
        while (node != null) {
            Node<K, V> node2 = node.next;
            int i3 = node.hash;
            int i4 = i3 & i2;
            Node<K, V> tabAt = tabAt(nodeArr, i4);
            if (tabAt == null) {
                z = true;
            } else {
                K k2 = node.key;
                if (tabAt.hash >= 0) {
                    int i5 = 0;
                    for (Node<K, V> node3 = tabAt; node3 != null; node3 = node3.next) {
                        if (node3.hash == i3 && ((k = node3.key) == k2 || (k != null && k2.equals(k)))) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    z = true;
                    if (z && i5 >= 8) {
                        j2++;
                        node.next = tabAt;
                        Node<K, V> node4 = node;
                        TreeNode<K, V> treeNode = null;
                        TreeNode<K, V> treeNode2 = null;
                        while (node4 != null) {
                            long j4 = j2;
                            TreeNode<K, V> treeNode3 = new TreeNode<>(node4.hash, node4.key, node4.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            node4 = node4.next;
                            treeNode2 = treeNode3;
                            j2 = j4;
                        }
                        setTabAt(nodeArr, i4, new TreeBin(treeNode));
                    }
                } else if (((TreeBin) tabAt).putTreeVal(i3, k2, node.val) == null) {
                    j2 += j;
                }
                z = false;
            }
            if (z) {
                j2++;
                node.next = tabAt;
                setTabAt(nodeArr, i4, node);
            }
            j = 1;
            node = node2;
        }
        this.table = nodeArr;
        this.sizeCtl = tableSizeFor - (tableSizeFor >>> 2);
        this.baseCount = j2;
    }

    static final <K, V> void setTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node) {
        f40297U.putObjectVolatile(nodeArr, (i << ASHIFT) + ABASE, node);
    }

    static final int spread(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    static final <K, V> Node<K, V> tabAt(Node<K, V>[] nodeArr, int i) {
        return (Node) f40297U.getObjectVolatile(nodeArr, (i << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        if (i7 >= 1073741824) {
            return 1073741824;
        }
        return 1 + i7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node] */
    /* JADX WARN: Type inference failed for: r11v9, types: [io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node] */
    /* JADX WARN: Type inference failed for: r6v17, types: [io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>] */
    /* JADX WARN: Type inference failed for: r6v22, types: [io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>] */
    private final void transfer(Node<K, V>[] nodeArr, Node<K, V>[] nodeArr2) {
        Node<K, V>[] nodeArr3;
        int i;
        int i2;
        ForwardingNode forwardingNode;
        ConcurrentHashMapV8<K, V> concurrentHashMapV8;
        Unsafe unsafe;
        long j;
        int i3;
        int i4;
        int i5;
        int i6;
        Node treeBin;
        Node treeBin2;
        TreeNode treeNode;
        TreeNode treeNode2;
        ConcurrentHashMapV8<K, V> concurrentHashMapV82 = this;
        Node<K, V>[] nodeArr4 = nodeArr;
        int length = nodeArr4.length;
        int i7 = NCPU;
        int i8 = i7 > 1 ? (length >>> 3) / i7 : length;
        int i9 = i8 < 16 ? 16 : i8;
        if (nodeArr2 == null) {
            try {
                Node<K, V>[] nodeArr5 = new Node[length << 1];
                concurrentHashMapV82.nextTable = nodeArr5;
                concurrentHashMapV82.transferOrigin = length;
                concurrentHashMapV82.transferIndex = length;
                ForwardingNode forwardingNode2 = new ForwardingNode(nodeArr4);
                int i10 = length;
                while (i10 > 0) {
                    int i11 = i10 > i9 ? i10 - i9 : 0;
                    for (int i12 = i11; i12 < i10; i12++) {
                        nodeArr5[i12] = forwardingNode2;
                    }
                    for (int i13 = length + i11; i13 < length + i10; i13++) {
                        nodeArr5[i13] = forwardingNode2;
                    }
                    f40297U.putOrderedInt(concurrentHashMapV82, TRANSFERORIGIN, i11);
                    i10 = i11;
                }
                nodeArr3 = nodeArr5;
            } catch (Throwable unused) {
                concurrentHashMapV82.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            nodeArr3 = nodeArr2;
        }
        int length2 = nodeArr3.length;
        ForwardingNode forwardingNode3 = new ForwardingNode(nodeArr3);
        int i14 = -1;
        int i15 = 0;
        int i16 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i17 = i15 - 1;
                if (i17 >= i16 || z2) {
                    i15 = i17;
                    i16 = i16;
                } else {
                    int i18 = concurrentHashMapV82.transferIndex;
                    if (i18 <= concurrentHashMapV82.transferOrigin) {
                        i15 = -1;
                    } else {
                        Unsafe unsafe2 = f40297U;
                        long j2 = TRANSFERINDEX;
                        int i19 = i18 > i9 ? i18 - i9 : 0;
                        int i20 = i16;
                        if (unsafe2.compareAndSwapInt(this, j2, i18, i19)) {
                            i15 = i18 - 1;
                            i16 = i19;
                        } else {
                            i15 = i17;
                            i16 = i20;
                        }
                    }
                }
                z = false;
            } else {
                int i21 = i16;
                TreeNode<K, V> treeNode3 = null;
                if (i15 < 0 || i15 >= length || (i6 = i15 + length) >= length2) {
                    i = i9;
                    i2 = length2;
                    forwardingNode = forwardingNode3;
                    concurrentHashMapV8 = this;
                    if (z2) {
                        concurrentHashMapV8.nextTable = null;
                        concurrentHashMapV8.table = nodeArr3;
                        concurrentHashMapV8.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    do {
                        unsafe = f40297U;
                        j = SIZECTL;
                        i3 = concurrentHashMapV8.sizeCtl;
                        i4 = i3 + 1;
                    } while (!unsafe.compareAndSwapInt(this, j, i3, i4));
                    if (i4 != -1) {
                        return;
                    }
                    i5 = length;
                    z = true;
                    z2 = true;
                } else {
                    Node tabAt = tabAt(nodeArr4, i15);
                    if (tabAt == null) {
                        if (casTabAt(nodeArr4, i15, null, forwardingNode3)) {
                            setTabAt(nodeArr3, i15, null);
                            setTabAt(nodeArr3, i6, null);
                            i5 = i15;
                            concurrentHashMapV8 = concurrentHashMapV82;
                            i = i9;
                            i2 = length2;
                            forwardingNode = forwardingNode3;
                            z = true;
                        } else {
                            i5 = i15;
                            concurrentHashMapV8 = concurrentHashMapV82;
                            i = i9;
                            i2 = length2;
                            forwardingNode = forwardingNode3;
                        }
                    } else {
                        int i22 = tabAt.hash;
                        if (i22 != i14) {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr4, i15) == tabAt) {
                                    if (i22 >= 0) {
                                        int i23 = i22 & length;
                                        TreeNode treeNode4 = tabAt;
                                        for (TreeNode treeNode5 = tabAt.next; treeNode5 != null; treeNode5 = treeNode5.next) {
                                            int i24 = treeNode5.hash & length;
                                            if (i24 != i23) {
                                                treeNode4 = treeNode5;
                                                i23 = i24;
                                            }
                                        }
                                        if (i23 == 0) {
                                            treeNode = null;
                                            treeNode3 = treeNode4;
                                        } else {
                                            treeNode = treeNode4;
                                        }
                                        Node node = tabAt;
                                        while (node != treeNode4) {
                                            int i25 = node.hash;
                                            K k = node.key;
                                            int i26 = i9;
                                            V v = node.val;
                                            if ((i25 & length) == 0) {
                                                treeNode2 = treeNode4;
                                                treeNode3 = new Node(i25, k, v, treeNode3);
                                            } else {
                                                treeNode2 = treeNode4;
                                                treeNode = new Node(i25, k, v, treeNode);
                                            }
                                            node = node.next;
                                            treeNode4 = treeNode2;
                                            i9 = i26;
                                        }
                                        i = i9;
                                        setTabAt(nodeArr3, i15, treeNode3);
                                        setTabAt(nodeArr3, i6, treeNode);
                                        setTabAt(nodeArr4, i15, forwardingNode3);
                                        i2 = length2;
                                        forwardingNode = forwardingNode3;
                                    } else {
                                        i = i9;
                                        if (tabAt instanceof TreeBin) {
                                            TreeBin treeBin3 = (TreeBin) tabAt;
                                            TreeNode<K, V> treeNode6 = null;
                                            TreeNode<K, V> treeNode7 = null;
                                            Node<K, V> node2 = treeBin3.first;
                                            int i27 = 0;
                                            int i28 = 0;
                                            TreeNode<K, V> treeNode8 = null;
                                            while (node2 != null) {
                                                int i29 = length2;
                                                int i30 = node2.hash;
                                                ForwardingNode forwardingNode4 = forwardingNode3;
                                                TreeNode<K, V> treeNode9 = new TreeNode<>(i30, node2.key, node2.val, null, null);
                                                if ((i30 & length) == 0) {
                                                    treeNode9.prev = treeNode7;
                                                    if (treeNode7 == null) {
                                                        treeNode3 = treeNode9;
                                                    } else {
                                                        treeNode7.next = treeNode9;
                                                    }
                                                    i28++;
                                                    treeNode7 = treeNode9;
                                                } else {
                                                    treeNode9.prev = treeNode6;
                                                    if (treeNode6 == null) {
                                                        treeNode8 = treeNode9;
                                                    } else {
                                                        treeNode6.next = treeNode9;
                                                    }
                                                    i27++;
                                                    treeNode6 = treeNode9;
                                                }
                                                node2 = node2.next;
                                                length2 = i29;
                                                forwardingNode3 = forwardingNode4;
                                            }
                                            i2 = length2;
                                            ForwardingNode forwardingNode5 = forwardingNode3;
                                            if (i28 <= 6) {
                                                treeBin = untreeify(treeNode3);
                                            } else {
                                                treeBin = i27 != 0 ? new TreeBin(treeNode3) : treeBin3;
                                            }
                                            if (i27 <= 6) {
                                                treeBin2 = untreeify(treeNode8);
                                            } else {
                                                treeBin2 = i28 != 0 ? new TreeBin(treeNode8) : treeBin3;
                                            }
                                            setTabAt(nodeArr3, i15, treeBin);
                                            setTabAt(nodeArr3, i6, treeBin2);
                                            nodeArr4 = nodeArr;
                                            forwardingNode = forwardingNode5;
                                            setTabAt(nodeArr4, i15, forwardingNode);
                                        }
                                    }
                                    z = true;
                                } else {
                                    i = i9;
                                }
                                i2 = length2;
                                forwardingNode = forwardingNode3;
                            }
                            concurrentHashMapV8 = this;
                            i5 = i15;
                        }
                        i5 = i15;
                        concurrentHashMapV8 = concurrentHashMapV82;
                        i = i9;
                        i2 = length2;
                        forwardingNode = forwardingNode3;
                        z = true;
                    }
                }
                i15 = i5;
                forwardingNode3 = forwardingNode;
                concurrentHashMapV82 = concurrentHashMapV8;
                i16 = i21;
                i9 = i;
                length2 = i2;
                i14 = -1;
            }
        }
    }

    private final void treeifyBin(Node<K, V>[] nodeArr, int i) {
        int i2;
        if (nodeArr != null) {
            TreeNode<K, V> treeNode = null;
            if (nodeArr.length < 64) {
                if (nodeArr == this.table && (i2 = this.sizeCtl) >= 0 && f40297U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                    return;
                }
                return;
            }
            Node<K, V> tabAt = tabAt(nodeArr, i);
            if (tabAt == null || tabAt.hash < 0) {
                return;
            }
            synchronized (tabAt) {
                if (tabAt(nodeArr, i) == tabAt) {
                    Node<K, V> node = tabAt;
                    TreeNode<K, V> treeNode2 = null;
                    while (node != null) {
                        TreeNode<K, V> treeNode3 = new TreeNode<>(node.hash, node.key, node.val, null, null);
                        treeNode3.prev = treeNode2;
                        if (treeNode2 == null) {
                            treeNode = treeNode3;
                        } else {
                            treeNode2.next = treeNode3;
                        }
                        node = node.next;
                        treeNode2 = treeNode3;
                    }
                    setTabAt(nodeArr, i, new TreeBin(treeNode));
                }
            }
        }
    }

    private final void tryPresize(int i) {
        int length;
        int tableSizeFor = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                return;
            }
            Node<K, V>[] nodeArr = this.table;
            if (nodeArr == null || (length = nodeArr.length) == 0) {
                int i3 = i2 > tableSizeFor ? i2 : tableSizeFor;
                if (f40297U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                    try {
                        if (this.table == nodeArr) {
                            this.table = new Node[i3];
                            i2 = i3 - (i3 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i2;
                    }
                } else {
                    continue;
                }
            } else if (tableSizeFor <= i2 || length >= 1073741824) {
                return;
            } else {
                if (nodeArr == this.table && f40297U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                }
            }
        }
    }

    static <K, V> Node<K, V> untreeify(Node<K, V> node) {
        Node<K, V> node2 = null;
        Node<K, V> node3 = null;
        while (node != null) {
            Node<K, V> node4 = new Node<>(node.hash, node.key, node.val, null);
            if (node3 == null) {
                node2 = node4;
            } else {
                node3.next = node4;
            }
            node = node.next;
            node3 = node4;
        }
        return node2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i = 1;
        int i2 = 0;
        while (i < 16) {
            i2++;
            i <<= 1;
        }
        int i3 = 32 - i2;
        int i4 = i - 1;
        Segment[] segmentArr = new Segment[16];
        for (int i5 = 0; i5 < 16; i5++) {
            segmentArr[i5] = new Segment(0.75f);
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", i3);
        objectOutputStream.putFields().put("segmentMask", i4);
        objectOutputStream.writeFields();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                objectOutputStream.writeObject(advance.key);
                objectOutputStream.writeObject(advance.val);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    final int batchFor(long j) {
        if (j != Long.MAX_VALUE) {
            long sumCount = sumCount();
            if (sumCount <= 1 || sumCount < j) {
                return 0;
            }
            int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism() << 2;
            if (j > 0) {
                long j2 = sumCount / j;
                return j2 >= ((long) commonPoolParallelism) ? commonPoolParallelism : (int) j2;
            }
            return commonPoolParallelism;
        }
        return 0;
    }

    @Override // java.util.Map
    public void clear() {
        Node<K, V> tabAt;
        Node<K, V> node;
        Node<K, V>[] nodeArr = this.table;
        long j = 0;
        loop0: while (true) {
            int i = 0;
            while (nodeArr != null && i < nodeArr.length) {
                tabAt = tabAt(nodeArr, i);
                if (tabAt == null) {
                    i++;
                } else {
                    int i2 = tabAt.hash;
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (tabAt) {
                        if (tabAt(nodeArr, i) == tabAt) {
                            if (i2 >= 0) {
                                node = tabAt;
                            } else {
                                node = tabAt instanceof TreeBin ? ((TreeBin) tabAt).first : null;
                            }
                            while (node != null) {
                                j--;
                                node = node.next;
                            }
                            setTabAt(nodeArr, i, null);
                            i++;
                        }
                    }
                }
            }
            nodeArr = helpTransfer(nodeArr, tabAt);
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    public V compute(K k, BiFun<? super K, ? super V, ? extends V> biFun) {
        int i;
        Node node;
        V v;
        K k2;
        if (k == null || biFun == null) {
            throw null;
        }
        int spread = spread(k.hashCode());
        Node<K, V>[] nodeArr = this.table;
        int i2 = 0;
        V v2 = null;
        int i3 = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & spread;
                    Node<K, V> tabAt = tabAt(nodeArr, i4);
                    if (tabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArr, i4, null, reservationNode)) {
                                V apply = biFun.apply(k, null);
                                if (apply != null) {
                                    node = new Node(spread, k, apply, null);
                                    i = 1;
                                } else {
                                    i = i3;
                                    node = null;
                                }
                                setTabAt(nodeArr, i4, node);
                                i3 = i;
                                v2 = apply;
                                i2 = 1;
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i5 = tabAt.hash;
                        if (i5 == -1) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i4) == tabAt) {
                                    if (i5 >= 0) {
                                        Node<K, V> node2 = null;
                                        Node<K, V> node3 = tabAt;
                                        i2 = 1;
                                        while (true) {
                                            if (node3.hash != spread || ((k2 = node3.key) != k && (k2 == null || !k.equals(k2)))) {
                                                Node<K, V> node4 = node3.next;
                                                if (node4 == null) {
                                                    V apply2 = biFun.apply(k, null);
                                                    if (apply2 != null) {
                                                        node3.next = new Node<>(spread, k, apply2, null);
                                                        v = apply2;
                                                        i3 = 1;
                                                    } else {
                                                        v = apply2;
                                                    }
                                                } else {
                                                    i2++;
                                                    node2 = node3;
                                                    node3 = node4;
                                                }
                                            }
                                        }
                                        v = biFun.apply(k, (V) node3.val);
                                        if (v != null) {
                                            node3.val = v;
                                        } else {
                                            Node<K, V> node5 = node3.next;
                                            if (node2 != null) {
                                                node2.next = node5;
                                            } else {
                                                setTabAt(nodeArr, i4, node5);
                                            }
                                            i3 = -1;
                                        }
                                        v2 = v;
                                    } else if (tabAt instanceof TreeBin) {
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        TreeNode<K, V> findTreeNode = treeNode != null ? treeNode.findTreeNode(spread, k, null) : null;
                                        V apply3 = biFun.apply(k, findTreeNode == null ? (Object) null : findTreeNode.val);
                                        if (apply3 == null) {
                                            if (findTreeNode != null) {
                                                if (treeBin.removeTreeNode(findTreeNode)) {
                                                    setTabAt(nodeArr, i4, untreeify(treeBin.first));
                                                }
                                                v2 = apply3;
                                                i2 = 1;
                                                i3 = -1;
                                            }
                                            v2 = apply3;
                                            i2 = 1;
                                        } else if (findTreeNode != null) {
                                            findTreeNode.val = apply3;
                                            v2 = apply3;
                                            i2 = 1;
                                        } else {
                                            treeBin.putTreeVal(spread, k, apply3);
                                            v2 = apply3;
                                            i2 = 1;
                                            i3 = 1;
                                        }
                                    }
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(nodeArr, i4);
                                }
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (i3 != 0) {
            addCount(i3, i2);
        }
        return v2;
    }

    public V computeIfAbsent(K k, Fun<? super K, ? extends V> fun) {
        TreeNode<K, V> findTreeNode;
        V v;
        K k2;
        if (k == null || fun == null) {
            throw null;
        }
        int spread = spread(k.hashCode());
        Node<K, V>[] nodeArr = this.table;
        V v2 = null;
        int i = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i2 = (length - 1) & spread;
                    Node<K, V> tabAt = tabAt(nodeArr, i2);
                    boolean z = true;
                    if (tabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArr, i2, null, reservationNode)) {
                                V apply = fun.apply(k);
                                setTabAt(nodeArr, i2, apply != null ? new Node(spread, k, apply, null) : null);
                                v2 = apply;
                                i = 1;
                            }
                        }
                        if (i != 0) {
                            break;
                        }
                    } else {
                        int i3 = tabAt.hash;
                        if (i3 == -1) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i2) == tabAt) {
                                    if (i3 >= 0) {
                                        Node<K, V> node = tabAt;
                                        int i4 = 1;
                                        while (true) {
                                            if (node.hash != spread || ((k2 = node.key) != k && (k2 == null || !k.equals(k2)))) {
                                                Node<K, V> node2 = node.next;
                                                if (node2 == null) {
                                                    V apply2 = fun.apply(k);
                                                    if (apply2 != null) {
                                                        node.next = new Node<>(spread, k, apply2, null);
                                                        v = apply2;
                                                    } else {
                                                        v = apply2;
                                                    }
                                                } else {
                                                    i4++;
                                                    node = node2;
                                                }
                                            }
                                        }
                                        v = node.val;
                                        z = false;
                                        int i5 = i4;
                                        v2 = v;
                                        i = i5;
                                    } else if (tabAt instanceof TreeBin) {
                                        i = 2;
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        if (treeNode != null && (findTreeNode = treeNode.findTreeNode(spread, k, null)) != null) {
                                            v2 = findTreeNode.val;
                                        } else {
                                            V apply3 = fun.apply(k);
                                            if (apply3 != null) {
                                                treeBin.putTreeVal(spread, k, apply3);
                                                v2 = apply3;
                                            } else {
                                                v2 = apply3;
                                            }
                                        }
                                    }
                                }
                                z = false;
                            }
                            if (i != 0) {
                                if (i >= 8) {
                                    treeifyBin(nodeArr, i2);
                                }
                                if (!z) {
                                    return v2;
                                }
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (v2 != null) {
            addCount(1L, i);
        }
        return v2;
    }

    public V computeIfPresent(K k, BiFun<? super K, ? super V, ? extends V> biFun) {
        TreeNode<K, V> findTreeNode;
        K k2;
        if (k == null || biFun == null) {
            throw null;
        }
        int spread = spread(k.hashCode());
        Node<K, V>[] nodeArr = this.table;
        int i = 0;
        V v = null;
        int i2 = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i3 = (length - 1) & spread;
                    Node<K, V> tabAt = tabAt(nodeArr, i3);
                    if (tabAt == null) {
                        break;
                    }
                    int i4 = tabAt.hash;
                    if (i4 == -1) {
                        nodeArr = helpTransfer(nodeArr, tabAt);
                    } else {
                        synchronized (tabAt) {
                            if (tabAt(nodeArr, i3) == tabAt) {
                                if (i4 >= 0) {
                                    i2 = 1;
                                    Node<K, V> node = null;
                                    Node<K, V> node2 = tabAt;
                                    while (true) {
                                        if (node2.hash != spread || ((k2 = node2.key) != k && (k2 == null || !k.equals(k2)))) {
                                            Node<K, V> node3 = node2.next;
                                            if (node3 == null) {
                                                break;
                                            }
                                            i2++;
                                            node = node2;
                                            node2 = node3;
                                        }
                                    }
                                    v = biFun.apply(k, (V) node2.val);
                                    if (v != null) {
                                        node2.val = v;
                                    } else {
                                        Node<K, V> node4 = node2.next;
                                        if (node != null) {
                                            node.next = node4;
                                        } else {
                                            setTabAt(nodeArr, i3, node4);
                                        }
                                        i = -1;
                                    }
                                } else if (tabAt instanceof TreeBin) {
                                    i2 = 2;
                                    TreeBin treeBin = (TreeBin) tabAt;
                                    TreeNode<K, V> treeNode = treeBin.root;
                                    if (treeNode != null && (findTreeNode = treeNode.findTreeNode(spread, k, null)) != null) {
                                        v = biFun.apply(k, (V) findTreeNode.val);
                                        if (v != null) {
                                            findTreeNode.val = v;
                                        } else {
                                            if (treeBin.removeTreeNode(findTreeNode)) {
                                                setTabAt(nodeArr, i3, untreeify(treeBin.first));
                                            }
                                            i = -1;
                                        }
                                    }
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return v;
    }

    @Deprecated
    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                V v = advance.val;
                if (v == obj) {
                    return true;
                }
                if (v != null && obj.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Enumeration<V> elements() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new ValueIterator(nodeArr, length, 0, length, this);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView<K, V> entrySetView2 = new EntrySetView<>(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Node<K, V>[] nodeArr = this.table;
                int length = nodeArr == null ? 0 : nodeArr.length;
                Traverser traverser = new Traverser(nodeArr, length, 0, length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        V v2 = advance.val;
                        Object obj2 = map.get(advance.key);
                        if (obj2 == null || (obj2 != v2 && !obj2.equals(v2))) {
                            break;
                        }
                    } else {
                        for (Map.Entry<K, V> entry : map.entrySet()) {
                            K key = entry.getKey();
                            if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public void forEach(BiAction<? super K, ? super V> biAction) {
        biAction.getClass();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node<K, V> advance = traverser.advance();
            if (advance == null) {
                return;
            }
            biAction.apply((K) advance.key, (V) advance.val);
        }
    }

    public void forEachEntry(long j, Action<? super Map.Entry<K, V>> action) {
        action.getClass();
        new ForEachEntryTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    public void forEachKey(long j, Action<? super K> action) {
        action.getClass();
        new ForEachKeyTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    public void forEachValue(long j, Action<? super V> action) {
        action.getClass();
        new ForEachValueTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        return r1.val;
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = spread(r0)
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r1 = r4.table
            r2 = 0
            if (r1 == 0) goto L4e
            int r3 = r1.length
            if (r3 <= 0) goto L4e
            int r3 = r3 + (-1)
            r3 = r3 & r0
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r1 = tabAt(r1, r3)
            if (r1 == 0) goto L4e
            int r3 = r1.hash
            if (r3 != r0) goto L2c
            K r3 = r1.key
            if (r3 == r5) goto L29
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L29:
            V r5 = r1.val
            return r5
        L2c:
            if (r3 >= 0) goto L37
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r5 = r1.find(r0, r5)
            if (r5 == 0) goto L36
            V r2 = r5.val
        L36:
            return r2
        L37:
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V> r1 = r1.next
            if (r1 == 0) goto L4e
            int r3 = r1.hash
            if (r3 != r0) goto L37
            K r3 = r1.key
            if (r3 == r5) goto L4b
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L4b:
            V r5 = r1.val
            return r5
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 == null ? v : v2;
    }

    @Override // java.util.Map
    public int hashCode() {
        Node<K, V>[] nodeArr = this.table;
        int i = 0;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                i += advance.val.hashCode() ^ advance.key.hashCode();
            }
        }
        return i;
    }

    final Node<K, V>[] helpTransfer(Node<K, V>[] nodeArr, Node<K, V> node) {
        Node<K, V>[] nodeArr2;
        int i;
        if ((node instanceof ForwardingNode) && (nodeArr2 = ((ForwardingNode) node).nextTable) != null) {
            if (nodeArr2 == this.nextTable && nodeArr == this.table && this.transferIndex > this.transferOrigin && (i = this.sizeCtl) < -1 && f40297U.compareAndSwapInt(this, SIZECTL, i, i - 1)) {
                transfer(nodeArr, nodeArr2);
            }
            return nodeArr2;
        }
        return this.table;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    public Enumeration<K> keys() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new KeyIterator(nodeArr, length, 0, length, this);
    }

    public long mappingCount() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0L;
        }
        return sumCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public V merge(K k, V v, BiFun<? super V, ? super V, ? extends V> biFun) {
        int i;
        V v2;
        K k2;
        V v3 = v;
        if (k == null || v3 == null || biFun == null) {
            throw null;
        }
        int spread = spread(k.hashCode());
        Node<K, V>[] nodeArr = this.table;
        int i2 = 0;
        V v4 = null;
        int i3 = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & spread;
                    Node<K, V> tabAt = tabAt(nodeArr, i4);
                    i = 1;
                    if (tabAt == null) {
                        if (casTabAt(nodeArr, i4, null, new Node(spread, k, v3, null))) {
                            break;
                        }
                    } else {
                        int i5 = tabAt.hash;
                        if (i5 == -1) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i4) == tabAt) {
                                    if (i5 >= 0) {
                                        Node<K, V> node = null;
                                        Node<K, V> node2 = tabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node2.hash != spread || ((k2 = node2.key) != k && (k2 == null || !k.equals(k2)))) {
                                                Node<K, V> node3 = node2.next;
                                                if (node3 == null) {
                                                    node2.next = new Node<>(spread, k, v3, null);
                                                    v2 = v3;
                                                    i3 = 1;
                                                    break;
                                                }
                                                i6++;
                                                node = node2;
                                                node2 = node3;
                                            }
                                        }
                                        v2 = biFun.apply((V) node2.val, v3);
                                        if (v2 != null) {
                                            node2.val = v2;
                                        } else {
                                            Node<K, V> node4 = node2.next;
                                            if (node != null) {
                                                node.next = node4;
                                            } else {
                                                setTabAt(nodeArr, i4, node4);
                                            }
                                            i3 = -1;
                                        }
                                        i2 = i6;
                                        v4 = v2;
                                    } else if (tabAt instanceof TreeBin) {
                                        i2 = 2;
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        TreeNode<K, V> findTreeNode = treeNode == null ? null : treeNode.findTreeNode(spread, k, null);
                                        V apply = findTreeNode == null ? v3 : biFun.apply((V) findTreeNode.val, v3);
                                        if (apply == null) {
                                            if (findTreeNode != null) {
                                                if (treeBin.removeTreeNode(findTreeNode)) {
                                                    setTabAt(nodeArr, i4, untreeify(treeBin.first));
                                                }
                                                v4 = apply;
                                                i3 = -1;
                                            }
                                            v4 = apply;
                                        } else if (findTreeNode != null) {
                                            findTreeNode.val = apply;
                                            v4 = apply;
                                        } else {
                                            treeBin.putTreeVal(spread, k, apply);
                                            v4 = apply;
                                            i3 = 1;
                                        }
                                    }
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(nodeArr, i4);
                                }
                                i = i3;
                                v3 = v4;
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return v3;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return putVal(k, v, false);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        return putVal(k, v, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        r7 = r6.val;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
        if (r11 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
        r6.val = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final V putVal(K r9, V r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L9b
            if (r10 == 0) goto L9b
            int r1 = r9.hashCode()
            int r1 = spread(r1)
            r2 = 0
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r3 = r8.table
        L10:
            if (r3 == 0) goto L95
            int r4 = r3.length
            if (r4 != 0) goto L17
            goto L95
        L17:
            int r4 = r4 + (-1)
            r4 = r4 & r1
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r5 = tabAt(r3, r4)
            if (r5 != 0) goto L2d
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r5 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node
            r5.<init>(r1, r9, r10, r0)
            boolean r4 = casTabAt(r3, r4, r0, r5)
            if (r4 == 0) goto L10
            goto L8c
        L2d:
            int r6 = r5.hash
            r7 = -1
            if (r6 != r7) goto L37
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node[] r3 = r8.helpTransfer(r3, r5)
            goto L10
        L37:
            monitor-enter(r5)
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r7 = tabAt(r3, r4)     // Catch: java.lang.Throwable -> L92
            if (r7 != r5) goto L7e
            if (r6 < 0) goto L69
            r2 = 1
            r6 = r5
        L42:
            int r7 = r6.hash     // Catch: java.lang.Throwable -> L92
            if (r7 != r1) goto L59
            K r7 = r6.key     // Catch: java.lang.Throwable -> L92
            if (r7 == r9) goto L52
            if (r7 == 0) goto L59
            boolean r7 = r9.equals(r7)     // Catch: java.lang.Throwable -> L92
            if (r7 == 0) goto L59
        L52:
            V r7 = r6.val     // Catch: java.lang.Throwable -> L92
            if (r11 != 0) goto L7f
            r6.val = r10     // Catch: java.lang.Throwable -> L92
            goto L7f
        L59:
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V> r7 = r6.next     // Catch: java.lang.Throwable -> L92
            if (r7 != 0) goto L65
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node r7 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node     // Catch: java.lang.Throwable -> L92
            r7.<init>(r1, r9, r10, r0)     // Catch: java.lang.Throwable -> L92
            r6.next = r7     // Catch: java.lang.Throwable -> L92
            goto L7e
        L65:
            int r2 = r2 + 1
            r6 = r7
            goto L42
        L69:
            boolean r6 = r5 instanceof io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin     // Catch: java.lang.Throwable -> L92
            if (r6 == 0) goto L7e
            r2 = 2
            r6 = r5
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeBin r6 = (io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin) r6     // Catch: java.lang.Throwable -> L92
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r6 = r6.putTreeVal(r1, r9, r10)     // Catch: java.lang.Throwable -> L92
            if (r6 == 0) goto L7e
            V r7 = r6.val     // Catch: java.lang.Throwable -> L92
            if (r11 != 0) goto L7f
            r6.val = r10     // Catch: java.lang.Throwable -> L92
            goto L7f
        L7e:
            r7 = r0
        L7f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L10
            r9 = 8
            if (r2 < r9) goto L89
            r8.treeifyBin(r3, r4)
        L89:
            if (r7 == 0) goto L8c
            return r7
        L8c:
            r9 = 1
            r8.addCount(r9, r2)
            return r0
        L92:
            r9 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L92
            throw r9
        L95:
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node[] r3 = r8.initTable()
            goto L10
        L9b:
            goto L9d
        L9c:
            throw r0
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.putVal(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    public <U> U reduce(long j, BiFun<? super K, ? super V, ? extends U> biFun, BiFun<? super U, ? super U, ? extends U> biFun2) {
        if (biFun != null && biFun2 != null) {
            return new MapReduceMappingsTask(null, batchFor(j), 0, 0, this.table, null, biFun, biFun2).invoke();
        }
        throw null;
    }

    public Map.Entry<K, V> reduceEntries(long j, BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun) {
        biFun.getClass();
        return new ReduceEntriesTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public double reduceEntriesToDouble(long j, ObjectToDouble<Map.Entry<K, V>> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble != null && doubleByDoubleToDouble != null) {
            return new MapReduceEntriesToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
        }
        throw null;
    }

    public int reduceEntriesToInt(long j, ObjectToInt<Map.Entry<K, V>> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt != null && intByIntToInt != null) {
            return new MapReduceEntriesToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
        }
        throw null;
    }

    public long reduceEntriesToLong(long j, ObjectToLong<Map.Entry<K, V>> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong != null && longByLongToLong != null) {
            return new MapReduceEntriesToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
        }
        throw null;
    }

    public K reduceKeys(long j, BiFun<? super K, ? super K, ? extends K> biFun) {
        biFun.getClass();
        return new ReduceKeysTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public double reduceKeysToDouble(long j, ObjectToDouble<? super K> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble != null && doubleByDoubleToDouble != null) {
            return new MapReduceKeysToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
        }
        throw null;
    }

    public int reduceKeysToInt(long j, ObjectToInt<? super K> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt != null && intByIntToInt != null) {
            return new MapReduceKeysToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
        }
        throw null;
    }

    public long reduceKeysToLong(long j, ObjectToLong<? super K> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong != null && longByLongToLong != null) {
            return new MapReduceKeysToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
        }
        throw null;
    }

    public double reduceToDouble(long j, ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectByObjectToDouble != null && doubleByDoubleToDouble != null) {
            return new MapReduceMappingsToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
        }
        throw null;
    }

    public int reduceToInt(long j, ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectByObjectToInt != null && intByIntToInt != null) {
            return new MapReduceMappingsToIntTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToInt, i, intByIntToInt).invoke().intValue();
        }
        throw null;
    }

    public long reduceToLong(long j, ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectByObjectToLong != null && longByLongToLong != null) {
            return new MapReduceMappingsToLongTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToLong, j2, longByLongToLong).invoke().longValue();
        }
        throw null;
    }

    public V reduceValues(long j, BiFun<? super V, ? super V, ? extends V> biFun) {
        biFun.getClass();
        return new ReduceValuesTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public double reduceValuesToDouble(long j, ObjectToDouble<? super V> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble != null && doubleByDoubleToDouble != null) {
            return new MapReduceValuesToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
        }
        throw null;
    }

    public int reduceValuesToInt(long j, ObjectToInt<? super V> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt != null && intByIntToInt != null) {
            return new MapReduceValuesToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
        }
        throw null;
    }

    public long reduceValuesToLong(long j, ObjectToLong<? super V> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong != null && longByLongToLong != null) {
            return new MapReduceValuesToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
        }
        throw null;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return replaceNode(obj, null, null);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K k, V v, V v2) {
        if (k == null || v == null || v2 == null) {
            throw null;
        }
        return replaceNode(k, v2, v) != null;
    }

    public void replaceAll(BiFun<? super K, ? super V, ? extends V> biFun) {
        biFun.getClass();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node<K, V> advance = traverser.advance();
            if (advance == null) {
                return;
            }
            Object obj = (V) advance.val;
            Object obj2 = (K) advance.key;
            do {
                V apply = biFun.apply(obj2, obj);
                apply.getClass();
                if (replaceNode(obj2, apply, obj) == null) {
                    obj = (V) get(obj2);
                }
            } while (obj != null);
        }
    }

    final V replaceNode(Object obj, V v, Object obj2) {
        int length;
        int i;
        Node<K, V> tabAt;
        Object obj3;
        TreeNode<K, V> findTreeNode;
        K k;
        int spread = spread(obj.hashCode());
        Node<K, V>[] nodeArr = this.table;
        while (true) {
            if (nodeArr == null || (length = nodeArr.length) == 0 || (tabAt = tabAt(nodeArr, (i = (length - 1) & spread))) == null) {
                break;
            }
            int i2 = tabAt.hash;
            if (i2 == -1) {
                nodeArr = helpTransfer(nodeArr, tabAt);
            } else {
                boolean z = false;
                synchronized (tabAt) {
                    if (tabAt(nodeArr, i) == tabAt) {
                        if (i2 >= 0) {
                            Node<K, V> node = null;
                            Node<K, V> node2 = tabAt;
                            while (true) {
                                if (node2.hash != spread || ((k = node2.key) != obj && (k == null || !obj.equals(k)))) {
                                    Node<K, V> node3 = node2.next;
                                    if (node3 == null) {
                                        break;
                                    }
                                    node = node2;
                                    node2 = node3;
                                }
                            }
                            obj3 = node2.val;
                            if (obj2 == null || obj2 == obj3 || (obj3 != null && obj2.equals(obj3))) {
                                if (v != null) {
                                    node2.val = v;
                                } else if (node != null) {
                                    node.next = node2.next;
                                } else {
                                    setTabAt(nodeArr, i, node2.next);
                                }
                                z = true;
                            }
                            obj3 = null;
                            z = true;
                        } else if (tabAt instanceof TreeBin) {
                            TreeBin treeBin = (TreeBin) tabAt;
                            TreeNode<K, V> treeNode = treeBin.root;
                            if (treeNode != null && (findTreeNode = treeNode.findTreeNode(spread, obj, null)) != null) {
                                obj3 = findTreeNode.val;
                                if (obj2 == null || obj2 == obj3 || (obj3 != null && obj2.equals(obj3))) {
                                    if (v != null) {
                                        findTreeNode.val = v;
                                    } else if (treeBin.removeTreeNode(findTreeNode)) {
                                        setTabAt(nodeArr, i, untreeify(treeBin.first));
                                    }
                                    z = true;
                                }
                            }
                            obj3 = null;
                            z = true;
                        }
                    }
                    obj3 = null;
                }
                if (z) {
                    if (obj3 != null) {
                        if (v == null) {
                            addCount(-1L, -1);
                        }
                        return obj3;
                    }
                }
            }
        }
        return null;
    }

    public <U> U search(long j, BiFun<? super K, ? super V, ? extends U> biFun) {
        biFun.getClass();
        return new SearchMappingsTask(null, batchFor(j), 0, 0, this.table, biFun, new AtomicReference()).invoke();
    }

    public <U> U searchEntries(long j, Fun<Map.Entry<K, V>, ? extends U> fun) {
        fun.getClass();
        return new SearchEntriesTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    public <U> U searchKeys(long j, Fun<? super K, ? extends U> fun) {
        fun.getClass();
        return new SearchKeysTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    public <U> U searchValues(long j, Fun<? super V, ? extends U> fun) {
        fun.getClass();
        return new SearchValuesTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    @Override // java.util.Map
    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        if (counterCellArr != null) {
            for (CounterCell counterCell : counterCellArr) {
                if (counterCell != null) {
                    j += counterCell.value;
                }
            }
        }
        return j;
    }

    public String toString() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<K, V> advance = traverser.advance();
        if (advance != null) {
            while (true) {
                K k = advance.key;
                V v = advance.val;
                if (k == this) {
                    k = "(this Map)";
                }
                sb.append(k);
                sb.append('=');
                if (v == this) {
                    v = "(this Map)";
                }
                sb.append(v);
                advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                sb.append(StringUtil.COMMA);
                sb.append(HttpConstants.SP_CHAR);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView<K, V> valuesView2 = new ValuesView<>(this);
        this.values = valuesView2;
        return valuesView2;
    }

    public ConcurrentHashMapV8(int i) {
        if (i >= 0) {
            this.sizeCtl = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int i) {
        return new KeySetView<>(new ConcurrentHashMapV8(i), Boolean.TRUE);
    }

    @Override // java.util.Map
    public KeySetView<K, V> keySet() {
        KeySetView<K, V> keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView<K, V> keySetView2 = new KeySetView<>(this, null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    public <U> void forEachEntry(long j, Fun<Map.Entry<K, V>, ? extends U> fun, Action<? super U> action) {
        if (fun != null && action != null) {
            new ForEachTransformedEntryTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
            return;
        }
        throw null;
    }

    public <U> void forEachKey(long j, Fun<? super K, ? extends U> fun, Action<? super U> action) {
        if (fun != null && action != null) {
            new ForEachTransformedKeyTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
            return;
        }
        throw null;
    }

    public <U> void forEachValue(long j, Fun<? super V, ? extends U> fun, Action<? super U> action) {
        if (fun != null && action != null) {
            new ForEachTransformedValueTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
            return;
        }
        throw null;
    }

    public KeySetView<K, V> keySet(V v) {
        v.getClass();
        return new KeySetView<>(this, v);
    }

    public <U> U reduceEntries(long j, Fun<Map.Entry<K, V>, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun != null && biFun != null) {
            return new MapReduceEntriesTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
        }
        throw null;
    }

    public <U> U reduceKeys(long j, Fun<? super K, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun != null && biFun != null) {
            return new MapReduceKeysTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
        }
        throw null;
    }

    public <U> U reduceValues(long j, Fun<? super V, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun != null && biFun != null) {
            return new MapReduceValuesTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
        }
        throw null;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K k, V v) {
        if (k != null && v != null) {
            return replaceNode(k, v, null);
        }
        throw null;
    }

    public ConcurrentHashMapV8(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    public void forEach(long j, BiAction<? super K, ? super V> biAction) {
        biAction.getClass();
        new ForEachMappingTask(null, batchFor(j), 0, 0, this.table, biAction).invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class CollectionView<K, V, E> implements Collection<E>, Serializable {
        private static final String oomeMsg = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMapV8<K, V> map;

        CollectionView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            this.map = concurrentHashMapV8;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
        @Override // java.util.Collection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean containsAll(java.util.Collection<?> r2) {
            /*
                r1 = this;
                if (r2 == r1) goto L1a
                java.util.Iterator r2 = r2.iterator()
            L6:
                boolean r0 = r2.hasNext()
                if (r0 == 0) goto L1a
                java.lang.Object r0 = r2.next()
                if (r0 == 0) goto L18
                boolean r0 = r1.contains(r0)
                if (r0 != 0) goto L6
            L18:
                r2 = 0
                return r2
            L1a:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView.containsAll(java.util.Collection):boolean");
        }

        public ConcurrentHashMapV8<K, V> getMap() {
            return this.map;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.Collection
        public abstract boolean remove(Object obj);

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long mappingCount = this.map.mappingCount();
            if (mappingCount <= 2147483639) {
                int i = (int) mappingCount;
                Object[] objArr = new Object[i];
                int i2 = 0;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    if (i2 == i) {
                        int i3 = ConcurrentHashMapV8.MAX_ARRAY_SIZE;
                        if (i < ConcurrentHashMapV8.MAX_ARRAY_SIZE) {
                            if (i < 1073741819) {
                                i3 = (i >>> 1) + 1 + i;
                            }
                            objArr = Arrays.copyOf(objArr, i3);
                            i = i3;
                        } else {
                            throw new OutOfMemoryError(oomeMsg);
                        }
                    }
                    objArr[i2] = next;
                    i2++;
                }
                return i2 == i ? objArr : Arrays.copyOf(objArr, i2);
            }
            throw new OutOfMemoryError(oomeMsg);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator<E> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(StringUtil.COMMA);
                    sb.append(HttpConstants.SP_CHAR);
                }
            }
            sb.append(']');
            return sb.toString();
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            long mappingCount = this.map.mappingCount();
            if (mappingCount <= 2147483639) {
                int i = (int) mappingCount;
                T[] tArr2 = tArr.length >= i ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
                int length = tArr2.length;
                int i2 = 0;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    if (i2 == length) {
                        int i3 = ConcurrentHashMapV8.MAX_ARRAY_SIZE;
                        if (length < ConcurrentHashMapV8.MAX_ARRAY_SIZE) {
                            if (length < 1073741819) {
                                i3 = (length >>> 1) + 1 + length;
                            }
                            tArr2 = (T[]) Arrays.copyOf(tArr2, i3);
                            length = i3;
                        } else {
                            throw new OutOfMemoryError(oomeMsg);
                        }
                    }
                    tArr2[i2] = next;
                    i2++;
                }
                if (tArr != tArr2 || i2 >= length) {
                    return i2 == length ? (T[]) tArr2 : (T[]) Arrays.copyOf(tArr2, i2);
                }
                tArr2[i2] = null;
                return (T[]) tArr2;
            }
            throw new OutOfMemoryError(oomeMsg);
        }
    }

    public <U> void forEach(long j, BiFun<? super K, ? super V, ? extends U> biFun, Action<? super U> action) {
        if (biFun != null && action != null) {
            new ForEachTransformedMappingTask(null, batchFor(j), 0, 0, this.table, biFun, action).invoke();
            return;
        }
        throw null;
    }

    public ConcurrentHashMapV8(int i, float f) {
        this(i, f, 1);
    }

    public ConcurrentHashMapV8(int i, float f, int i2) {
        if (f > 0.0f && i >= 0 && i2 > 0) {
            double d = (i < i2 ? i2 : i) / f;
            Double.isNaN(d);
            long j = (long) (d + 1.0d);
            this.sizeCtl = j >= IjkMediaMeta.AV_CH_STEREO_RIGHT ? 1073741824 : tableSizeFor((int) j);
            return;
        }
        throw new IllegalArgumentException();
    }
}
