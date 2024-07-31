package com.tencent.bugly.proguard;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12785a {
    /* renamed from: a */
    public static String m16019a(ArrayList<String> arrayList) {
        int i;
        int i2;
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = 0;
        while (true) {
            String str = "map";
            if (i4 < arrayList.size()) {
                String str2 = arrayList.get(i4);
                if (str2.equals("java.lang.Integer") || str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (!str2.equals("java.lang.Character")) {
                    if (str2.equals("java.lang.String")) {
                        str = "string";
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                } else {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                arrayList.set(i4, str);
                i4++;
            } else {
                Collections.reverse(arrayList);
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    String str3 = arrayList.get(i5);
                    if (str3.equals("list")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i2) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }
}
