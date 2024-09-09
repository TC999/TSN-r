package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        int i4;
        int i5;
        int i6;
        StringBuffer stringBuffer = new StringBuffer();
        int i7 = 0;
        while (true) {
            String str = "map";
            if (i7 < arrayList.size()) {
                String str2 = arrayList.get(i7);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
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
                arrayList.set(i7, str);
                i7++;
            } else {
                Collections.reverse(arrayList);
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    String str3 = arrayList.get(i8);
                    if (str3.equals("list")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i6));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i5) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i4));
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
