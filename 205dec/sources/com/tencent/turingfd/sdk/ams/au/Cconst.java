package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.const  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cconst {

    /* renamed from: a  reason: collision with root package name */
    public final String f52235a;

    /* renamed from: b  reason: collision with root package name */
    public final int f52236b;

    /* renamed from: c  reason: collision with root package name */
    public final Codlin f52237c;

    public Cconst(String str, int i4, Codlin codlin) {
        this.f52235a = str;
        this.f52236b = i4;
        this.f52237c = codlin;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.f52235a;
        if (str == null) {
            str = "";
        }
        sb.append(a("&", "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", str))))));
        sb.append("_");
        sb.append(this.f52236b);
        sb.append("_");
        Codlin codlin = this.f52237c;
        if (codlin == null) {
            return sb.toString();
        }
        sb.append(codlin.f51972c);
        sb.append(":");
        sb.append(this.f52237c.f51973d);
        sb.append(":");
        Iterator<Core> it = this.f52237c.f51974e.iterator();
        while (it.hasNext()) {
            Core next = it.next();
            sb.append(next.f51976c);
            sb.append(",");
            sb.append(",");
            sb.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f51979f));
            if (format.indexOf(".") > 0) {
                format = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(format);
            sb.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f51980g));
            if (format2.indexOf(".") > 0) {
                format2 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(format2);
            if (it.hasNext()) {
                sb.append(";");
            }
        }
        sb.append(":");
        sb.append(this.f52237c.f51975f);
        return sb.toString();
    }
}
