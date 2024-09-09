package io.netty.util.internal;

import io.netty.util.Recycler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RecyclableArrayList extends ArrayList<Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final Recycler<RecyclableArrayList> RECYCLER = new Recycler<RecyclableArrayList>() { // from class: io.netty.util.internal.RecyclableArrayList.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public RecyclableArrayList newObject(Recycler.Handle<RecyclableArrayList> handle) {
            return new RecyclableArrayList(handle);
        }
    };
    private static final long serialVersionUID = -8605125654176467947L;
    private final Recycler.Handle<RecyclableArrayList> handle;
    private boolean insertSinceRecycled;

    private static void checkNullElements(Collection<?> collection) {
        if ((collection instanceof RandomAccess) && (collection instanceof List)) {
            List list = (List) collection;
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (list.get(i4) == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
            }
            return;
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("c contains null values");
            }
        }
    }

    public static RecyclableArrayList newInstance() {
        return newInstance(8);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        if (obj != null) {
            if (super.add(obj)) {
                this.insertSinceRecycled = true;
                return true;
            }
            return false;
        }
        throw new NullPointerException("element");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<?> collection) {
        checkNullElements(collection);
        if (super.addAll(collection)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public boolean recycle() {
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i4, Object obj) {
        if (obj != null) {
            Object obj2 = super.set(i4, obj);
            this.insertSinceRecycled = true;
            return obj2;
        }
        throw new NullPointerException("element");
    }

    private RecyclableArrayList(Recycler.Handle<RecyclableArrayList> handle) {
        this(handle, 8);
    }

    public static RecyclableArrayList newInstance(int i4) {
        RecyclableArrayList recyclableArrayList = RECYCLER.get();
        recyclableArrayList.ensureCapacity(i4);
        return recyclableArrayList;
    }

    private RecyclableArrayList(Recycler.Handle<RecyclableArrayList> handle, int i4) {
        super(i4);
        this.handle = handle;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i4, Object obj) {
        if (obj != null) {
            super.add(i4, obj);
            this.insertSinceRecycled = true;
            return;
        }
        throw new NullPointerException("element");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection<?> collection) {
        checkNullElements(collection);
        if (super.addAll(i4, collection)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }
}
