package com.iab.omid.library.mmadbridge.p203c;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7085a;
import com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7106f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7097c implements InterfaceC7094a {

    /* renamed from: a */
    private final InterfaceC7094a f24252a;

    public C7097c(InterfaceC7094a interfaceC7094a) {
        this.f24252a = interfaceC7094a;
    }

    @Override // com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a
    /* renamed from: a */
    public JSONObject mo34708a(View view) {
        return C7101b.m34694b(0, 0, 0, 0);
    }

    @Override // com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a
    /* renamed from: a */
    public void mo34707a(View view, JSONObject jSONObject, InterfaceC7094a.InterfaceC7095a interfaceC7095a, boolean z, boolean z2) {
        Iterator<View> it = m34709b().iterator();
        while (it.hasNext()) {
            interfaceC7095a.mo34624a(it.next(), this.f24252a, jSONObject, z2);
        }
    }

    @NonNull
    /* renamed from: b */
    ArrayList<View> m34709b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C7085a m34757a = C7085a.m34757a();
        if (m34757a != null) {
            Collection<C7081h> m34753e = m34757a.m34753e();
            IdentityHashMap identityHashMap = new IdentityHashMap((m34753e.size() * 2) + 3);
            for (C7081h c7081h : m34753e) {
                View m34785w = c7081h.m34785w();
                if (m34785w != null && C7106f.m34659c(m34785w) && (rootView = m34785w.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float m34661a = C7106f.m34661a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C7106f.m34661a(arrayList.get(size - 1)) > m34661a) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
