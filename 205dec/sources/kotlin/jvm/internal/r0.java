package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SpreadBuilder.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Object> f55672a;

    public r0(int i4) {
        this.f55672a = new ArrayList<>(i4);
    }

    public void a(Object obj) {
        this.f55672a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f55672a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f55672a, objArr);
            }
        } else if (obj instanceof Collection) {
            this.f55672a.addAll((Collection) obj);
        } else if (obj instanceof Iterable) {
            for (Object obj2 : (Iterable) obj) {
                this.f55672a.add(obj2);
            }
        } else if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                this.f55672a.add(it.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f55672a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f55672a.toArray(objArr);
    }
}
