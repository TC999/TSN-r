package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: kotlin.jvm.internal.r0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SpreadBuilder {

    /* renamed from: a */
    private final ArrayList<Object> f41182a;

    public SpreadBuilder(int i) {
        this.f41182a = new ArrayList<>(i);
    }

    /* renamed from: a */
    public void m8068a(Object obj) {
        this.f41182a.add(obj);
    }

    /* renamed from: b */
    public void m8067b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f41182a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f41182a, objArr);
            }
        } else if (obj instanceof Collection) {
            this.f41182a.addAll((Collection) obj);
        } else if (obj instanceof Iterable) {
            for (Object obj2 : (Iterable) obj) {
                this.f41182a.add(obj2);
            }
        } else if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                this.f41182a.add(it.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    /* renamed from: c */
    public int m8066c() {
        return this.f41182a.size();
    }

    /* renamed from: d */
    public Object[] m8065d(Object[] objArr) {
        return this.f41182a.toArray(objArr);
    }
}
