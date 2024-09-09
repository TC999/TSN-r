package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
abstract class d<T, V> extends b4<T, V> {
    public d(Context context, T t3) {
        super(context, t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String U(PoiSearchV2.ShowFields showFields) {
        if (showFields == null || showFields.getValue() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if ((showFields.getValue() & 1) != 0) {
            sb.append("children,");
        }
        if ((showFields.getValue() & 2) != 0) {
            sb.append("business,");
        }
        if ((showFields.getValue() & 4) != 0) {
            sb.append("indoor,");
        }
        if ((showFields.getValue() & 8) != 0) {
            sb.append("navi,");
        }
        if ((showFields.getValue() & 16) != 0) {
            sb.append("photos,");
        }
        if (sb.length() > 0) {
            sb.replace(sb.length() - 1, sb.length(), "");
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean V(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
