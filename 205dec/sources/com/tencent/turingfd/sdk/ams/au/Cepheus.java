package com.tencent.turingfd.sdk.ams.au;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.turingfd.sdk.ams.au.Serpens;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cepheus {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f51964a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f51965b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f51966c;

    static {
        HashSet hashSet = new HashSet();
        f51964a = hashSet;
        f51965b = new String[0];
        hashSet.add(Cextends.a(Cextends.M));
        hashSet.add(Cextends.a(Cextends.N));
        hashSet.add(Cextends.a(Cextends.O));
        hashSet.add(Cextends.a(Cextends.P));
        hashSet.add(Cextends.a(Cextends.Q));
        hashSet.add(Cextends.a(Cextends.R));
        hashSet.add(Cextends.a(Cextends.S));
        hashSet.add(Cextends.a(Cextends.T));
        hashSet.add(Cextends.a(Cextends.U));
        hashSet.add(Cextends.a(Cextends.V));
        hashSet.add(Cextends.a(Cextends.W));
        hashSet.add(Cextends.a(Cextends.X));
        HashSet hashSet2 = new HashSet();
        f51966c = hashSet2;
        hashSet2.add(Cextends.a(Cextends.f52247L));
    }

    public static List<Cswitch> a() {
        boolean z3;
        boolean z4;
        Serpens.Cdo b4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b4 = Serpens.b(Integer.parseInt(str))) != null) {
                            arrayList2.add(b4);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int myPid = Process.myPid();
        Iterator it = arrayList2.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Serpens.Cdo cdo = (Serpens.Cdo) it.next();
            if (myPid == cdo.f52171a) {
                i4 = cdo.f52175e;
            }
        }
        if (i4 != 0 && myPid != i4) {
            Iterator it2 = arrayList2.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                Serpens.Cdo cdo2 = (Serpens.Cdo) it2.next();
                if (i4 == cdo2.f52171a) {
                    str2 = cdo2.f52174d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Cswitch cswitch = new Cswitch();
                cswitch.f52361c = Damson.f52009a + Damson.f52013e;
                cswitch.f52362d = str2;
                arrayList3.add(cswitch);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Serpens.Cdo cdo3 = (Serpens.Cdo) it3.next();
            Iterator it4 = ((HashSet) f51964a).iterator();
            while (it4.hasNext()) {
                if (cdo3.f52174d.contains((String) it4.next())) {
                    sb.append(cdo3.f52174d);
                    sb.append("_");
                }
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            Cswitch cswitch2 = new Cswitch();
            cswitch2.f52361c = Damson.f52009a + Damson.f52011c;
            cswitch2.f52362d = sb2.substring(0, sb2.length() - 1);
            arrayList4.add(cswitch2);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb3 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it5 = arrayList2.iterator();
        int i5 = 0;
        while (it5.hasNext()) {
            Serpens.Cdo cdo4 = (Serpens.Cdo) it5.next();
            if (cdo4.f52173c == 0 && cdo4.f52174d.startsWith(TTPathConst.sSeparator) && !cdo4.f52174d.startsWith("/system") && !cdo4.f52174d.startsWith("/dev") && !cdo4.f52174d.startsWith("/sbin") && !cdo4.f52174d.startsWith("/init") && !cdo4.f52174d.startsWith("/vendor") && !cdo4.f52174d.startsWith("/bin") && !cdo4.f52174d.startsWith("/usr") && !cdo4.f52174d.contains("kinguser") && !cdo4.f52174d.endsWith("so")) {
                Iterator it6 = ((HashSet) f51964a).iterator();
                while (true) {
                    if (it6.hasNext()) {
                        if (cdo4.f52174d.contains((String) it6.next())) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    continue;
                } else {
                    Iterator it7 = ((HashSet) f51966c).iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            if (cdo4.f52174d.contains((String) it7.next())) {
                                z4 = true;
                                break;
                            }
                        } else {
                            z4 = false;
                            break;
                        }
                    }
                    if (z4) {
                        continue;
                    } else {
                        hashSet.add(cdo4.f52174d);
                        int i6 = i5 + 1;
                        if (i5 >= 8) {
                            break;
                        }
                        i5 = i6;
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            Iterator it8 = hashSet.iterator();
            while (it8.hasNext()) {
                sb3.append((String) it8.next());
                sb3.append("%3B");
            }
            String sb4 = sb3.toString();
            Cswitch cswitch3 = new Cswitch();
            cswitch3.f52361c = Damson.f52009a + Damson.f52012d;
            cswitch3.f52362d = sb4.substring(0, sb4.length() - 1);
            arrayList5.add(cswitch3);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a4 = a(Cextends.a(Cextends.f52289o0), Cextends.a(Cextends.C0), "v4");
        if (!TextUtils.isEmpty(a4)) {
            stringBuffer.append(a4);
        }
        String a5 = a(Cextends.a(Cextends.f52291p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (!TextUtils.isEmpty(a5)) {
            if (!TextUtils.isEmpty(a4)) {
                stringBuffer.append("_");
            }
            stringBuffer.append(a5);
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        String[] strArr;
        String[] split;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String str4 = new String(Ccontinue.a(str));
            if (TextUtils.isEmpty(str4)) {
                strArr = f51965b;
            } else {
                strArr = str4.split("\n");
                if (strArr == null || strArr.length == 0) {
                    strArr = f51965b;
                }
            }
        } catch (Throwable unused) {
            strArr = null;
        }
        if (strArr == null) {
            stringBuffer.append(str3 + ";-1");
            return stringBuffer.toString();
        }
        stringBuffer.append(str3 + ";0");
        new HashMap();
        HashMap hashMap = new HashMap();
        Pattern compile = Pattern.compile(str2);
        for (String str5 : strArr) {
            Matcher matcher = compile.matcher(str5);
            if (matcher.find()) {
                String trim = matcher.group(4).trim();
                if ("0A".equals(matcher.group(3)) && (split = matcher.group(1).split(":")) != null && split.length >= 2) {
                    hashMap.put(split[1], trim);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            stringBuffer.append(";");
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                stringBuffer.append((String) hashMap.get(str6));
                stringBuffer.append(":");
                stringBuffer.append(str6);
                if (it.hasNext()) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }
}
