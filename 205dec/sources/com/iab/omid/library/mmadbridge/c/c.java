package com.iab.omid.library.mmadbridge.c;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.c.a;
import com.iab.omid.library.mmadbridge.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f37734a;

    public c(a aVar) {
        this.f37734a = aVar;
    }

    @Override // com.iab.omid.library.mmadbridge.c.a
    public JSONObject a(View view) {
        return com.iab.omid.library.mmadbridge.d.b.b(0, 0, 0, 0);
    }

    @Override // com.iab.omid.library.mmadbridge.c.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0547a interfaceC0547a, boolean z3, boolean z4) {
        Iterator<View> it = b().iterator();
        while (it.hasNext()) {
            interfaceC0547a.a(it.next(), this.f37734a, jSONObject, z4);
        }
    }

    @NonNull
    ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.mmadbridge.b.a a4 = com.iab.omid.library.mmadbridge.b.a.a();
        if (a4 != null) {
            Collection<h> e4 = a4.e();
            IdentityHashMap identityHashMap = new IdentityHashMap((e4.size() * 2) + 3);
            for (h hVar : e4) {
                View w3 = hVar.w();
                if (w3 != null && f.c(w3) && (rootView = w3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a5 = f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && f.a(arrayList.get(size - 1)) > a5) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
