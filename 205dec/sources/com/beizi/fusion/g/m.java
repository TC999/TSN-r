package com.beizi.fusion.g;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiViewUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class m {
    public static List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View childAt = viewGroup.getChildAt(i4);
                arrayList.add(childAt);
                arrayList.addAll(a(childAt));
            }
        }
        return arrayList;
    }
}
