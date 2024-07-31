package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;
import okhttp3.HttpUrl;

/* renamed from: com.amap.api.col.s.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
abstract class PoiHandler<T, V> extends BasicLBSRestHandler<T, V> {
    public PoiHandler(Context context, T t) {
        super(context, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: U */
    public static String m53099U(PoiSearchV2.ShowFields showFields) {
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
    /* renamed from: V */
    public static boolean m53098V(String str) {
        return str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
