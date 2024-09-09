package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;
import r2.k;
import r2.l;

/* compiled from: TypeSystemContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ArgumentList extends ArrayList<l> implements k {
    public ArgumentList(int i4) {
        super(i4);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof l) {
            return contains((l) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof l) {
            return indexOf((l) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof l) {
            return lastIndexOf((l) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof l) {
            return remove((l) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(l lVar) {
        return super.contains((Object) lVar);
    }

    public /* bridge */ int indexOf(l lVar) {
        return super.indexOf((Object) lVar);
    }

    public /* bridge */ int lastIndexOf(l lVar) {
        return super.lastIndexOf((Object) lVar);
    }

    public /* bridge */ boolean remove(l lVar) {
        return super.remove((Object) lVar);
    }
}
