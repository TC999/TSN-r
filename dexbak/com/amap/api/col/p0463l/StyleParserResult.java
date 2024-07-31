package com.amap.api.col.p0463l;

import com.autonavi.base.p048ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3l.e2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class StyleParserResult {

    /* renamed from: a */
    private Map<Integer, StyleItem> f3906a = new ConcurrentHashMap();

    /* renamed from: b */
    private Object f3907b = null;

    /* renamed from: c */
    private StyleItem[] f3908c;

    /* renamed from: a */
    public final Map<Integer, StyleItem> m55253a() {
        return this.f3906a;
    }

    /* renamed from: b */
    public final StyleItem[] m55252b() {
        Map<Integer, StyleItem> map = this.f3906a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f3906a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f3908c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final StyleItem[] m55251c() {
        return this.f3908c;
    }

    /* renamed from: d */
    public final Object m55250d() {
        return this.f3907b;
    }
}
