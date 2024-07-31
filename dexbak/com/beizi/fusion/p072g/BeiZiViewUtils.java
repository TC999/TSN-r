package com.beizi.fusion.p072g;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.g.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiViewUtils {
    /* renamed from: a */
    public static List<View> m48237a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                arrayList.add(childAt);
                arrayList.addAll(m48237a(childAt));
            }
        }
        return arrayList;
    }
}
