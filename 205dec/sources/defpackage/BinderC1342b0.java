package defpackage;

import android.os.Bundle;
import android.util.ArraySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: b0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class BinderC1342b0 extends F {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesC1344c0 f241a;

    public BinderC1342b0(SharedPreferencesC1344c0 sharedPreferencesC1344c0) {
        this.f241a = sharedPreferencesC1344c0;
    }

    public final synchronized void f(Bundle bundle) {
        try {
            ArraySet arraySet = new ArraySet();
            if (bundle.containsKey("delete")) {
                Set<String> set = (Set) bundle.getSerializable("delete");
                arraySet.addAll(set);
                for (String str : set) {
                    this.f241a.f1467a.remove(str);
                }
            }
            if (bundle.containsKey("put")) {
                Map map = (Map) bundle.getSerializable("put");
                this.f241a.f1467a.putAll(map);
                arraySet.addAll(map.keySet());
            }
            synchronized (this.f241a.f1468b) {
                Iterator it = arraySet.iterator();
                while (it.hasNext()) {
                    this.f241a.f1468b.forEach(new N0(this, (String) it.next(), 1));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
