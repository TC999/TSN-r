package com.amap.api.col.p0003l;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StyleParserResult.java */
/* renamed from: com.amap.api.col.3l.e2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, StyleItem> f7477a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private Object f7478b = null;

    /* renamed from: c  reason: collision with root package name */
    private StyleItem[] f7479c;

    public final Map<Integer, StyleItem> a() {
        return this.f7477a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f7477a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f7477a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f7479c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f7479c;
    }

    public final Object d() {
        return this.f7478b;
    }
}
