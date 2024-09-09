package com.tencent.turingfd.sdk.ams.au;

import android.util.JsonWriter;
import com.tencent.turingfd.sdk.ams.au.Longan;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.throw  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cthrow {
    public static String a() {
        String a4 = Gooseberry.f52078f.a("s_h");
        if (a4 == null || a4.isEmpty()) {
            return "";
        }
        HashSet hashSet = new HashSet(Arrays.asList(a4.split(";")));
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                jsonWriter.name(str);
                Longan.Cif b4 = Bilberry.b(str);
                jsonWriter.beginObject();
                jsonWriter.name("std");
                jsonWriter.value(b4.f52138a);
                jsonWriter.name("err");
                jsonWriter.value(b4.f52139b);
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }
}
