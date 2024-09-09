package com.iab.omid.library.mmadbridge.c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.mmadbridge.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f37735a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0547a interfaceC0547a, boolean z3) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            interfaceC0547a.a(viewGroup.getChildAt(i4), this, jSONObject, z3);
        }
    }

    @TargetApi(21)
    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0547a interfaceC0547a, boolean z3) {
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0547a.a((View) it2.next(), this, jSONObject, z3);
            }
        }
    }

    @Override // com.iab.omid.library.mmadbridge.c.a
    public JSONObject a(View view) {
        if (view == null) {
            return com.iab.omid.library.mmadbridge.d.b.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f37735a);
        int[] iArr = this.f37735a;
        return com.iab.omid.library.mmadbridge.d.b.b(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.mmadbridge.c.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0547a interfaceC0547a, boolean z3, boolean z4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z3 || Build.VERSION.SDK_INT < 21) {
                b(viewGroup, jSONObject, interfaceC0547a, z4);
            } else {
                c(viewGroup, jSONObject, interfaceC0547a, z4);
            }
        }
    }
}
