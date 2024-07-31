package com.iab.omid.library.mmadbridge.p203c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7098d implements InterfaceC7094a {

    /* renamed from: a */
    private final int[] f24253a = new int[2];

    /* renamed from: b */
    private void m34706b(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC7094a.InterfaceC7095a interfaceC7095a, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            interfaceC7095a.mo34624a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }

    @TargetApi(21)
    /* renamed from: c */
    private void m34705c(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC7094a.InterfaceC7095a interfaceC7095a, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
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
                interfaceC7095a.mo34624a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    @Override // com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a
    /* renamed from: a */
    public JSONObject mo34708a(View view) {
        if (view == null) {
            return C7101b.m34694b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f24253a);
        int[] iArr = this.f24253a;
        return C7101b.m34694b(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a
    /* renamed from: a */
    public void mo34707a(View view, JSONObject jSONObject, InterfaceC7094a.InterfaceC7095a interfaceC7095a, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m34706b(viewGroup, jSONObject, interfaceC7095a, z2);
            } else {
                m34705c(viewGroup, jSONObject, interfaceC7095a, z2);
            }
        }
    }
}
