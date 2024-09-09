package com.qq.e.dl.i;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.k0;
import com.qq.e.dl.i.a;
import com.qq.e.dl.i.c;
import com.qq.e.dl.i.e;
import com.qq.e.dl.i.g;
import com.qq.e.dl.k.j;
import com.qq.e.dl.k.l;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f46956a;

    private a b(JSONObject jSONObject) {
        a.b bVar = new a.b();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                char c4 = '\uffff';
                int hashCode = next.hashCode();
                if (hashCode != 1606) {
                    if (hashCode != 1607) {
                        if (hashCode != 1638) {
                            switch (hashCode) {
                                case 1629:
                                    if (next.equals("30")) {
                                        c4 = 2;
                                        break;
                                    }
                                    break;
                                case 1630:
                                    if (next.equals("31")) {
                                        c4 = 3;
                                        break;
                                    }
                                    break;
                                case 1631:
                                    if (next.equals("32")) {
                                        c4 = 5;
                                        break;
                                    }
                                    break;
                                case 1632:
                                    if (next.equals("33")) {
                                        c4 = 6;
                                        break;
                                    }
                                    break;
                                case 1633:
                                    if (next.equals("34")) {
                                        c4 = 7;
                                        break;
                                    }
                                    break;
                                case 1634:
                                    if (next.equals("35")) {
                                        c4 = '\b';
                                        break;
                                    }
                                    break;
                                case 1635:
                                    if (next.equals("36")) {
                                        c4 = '\t';
                                        break;
                                    }
                                    break;
                            }
                        } else if (next.equals("39")) {
                            c4 = 4;
                        }
                    } else if (next.equals("29")) {
                        c4 = 0;
                    }
                } else if (next.equals("28")) {
                    c4 = 1;
                }
                switch (c4) {
                    case 0:
                        bVar.f46922a = jSONObject.optInt(next);
                        continue;
                    case 1:
                        bVar.f46923b = jSONObject.optString(next, a.f46907o);
                        continue;
                    case 2:
                        bVar.f46924c = jSONObject.optJSONArray(next);
                        continue;
                    case 3:
                        bVar.f46925d = jSONObject.optInt(next);
                        continue;
                    case 4:
                        bVar.f46927f = jSONObject.optInt(next);
                        continue;
                    case 5:
                        bVar.f46926e = jSONObject.optInt(next);
                        continue;
                    case 6:
                        bVar.f46928g = jSONObject.optInt(next);
                        continue;
                    case 7:
                        bVar.f46929h = jSONObject.optInt(next, 1);
                        continue;
                    case '\b':
                        bVar.f46930i = jSONObject.optInt(next);
                        continue;
                    case '\t':
                        bVar.f46931j = jSONObject.optJSONArray(next);
                        continue;
                }
            }
        }
        return bVar.a();
    }

    private c c(JSONObject jSONObject) {
        c.b bVar = new c.b();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                char c4 = '\uffff';
                switch (next.hashCode()) {
                    case 1600:
                        if (next.equals("22")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 1601:
                        if (next.equals("23")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 1602:
                        if (next.equals("24")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 1603:
                        if (next.equals("25")) {
                            c4 = 3;
                            break;
                        }
                        break;
                }
                if (c4 == 0) {
                    bVar.f46945a = jSONObject.optInt(next);
                } else if (c4 == 1) {
                    bVar.f46946b = jSONObject.optString(next);
                } else if (c4 == 2) {
                    bVar.f46947c = jSONObject.optString(next);
                } else if (c4 == 3) {
                    a(jSONObject.optJSONObject(next), bVar);
                }
            }
        }
        return bVar.a();
    }

    private e d(JSONObject jSONObject) {
        e.b bVar = new e.b();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                char c4 = '\uffff';
                switch (next.hashCode()) {
                    case 1724:
                        if (next.equals("62")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 1725:
                        if (next.equals("63")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 1726:
                        if (next.equals("64")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                if (c4 == 0) {
                    bVar.f46964a = jSONObject.optInt(next);
                } else if (c4 == 1) {
                    bVar.f46965b = jSONObject.optString(next);
                } else if (c4 == 2) {
                    a(jSONObject.optJSONObject(next), bVar);
                }
            }
        }
        return bVar.a();
    }

    public g a(String str) {
        if (str != null && str.length() >= 9) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f46956a = 101;
                if (jSONObject.length() > 0) {
                    return a(jSONObject);
                }
                return null;
            } catch (JSONException e4) {
                this.f46956a = 100;
                d1.a("parse template error", e4);
            }
        }
        return null;
    }

    private g a(JSONObject jSONObject) {
        Object opt;
        Object remove = jSONObject.remove("1");
        String obj = remove != null ? remove.toString() : null;
        if (TextUtils.isEmpty(obj)) {
            this.f46956a = remove == null ? 102 : 103;
            return null;
        }
        Object remove2 = jSONObject.remove("38");
        if (remove2 != null && (!(remove2 instanceof Number) || ((Number) remove2).intValue() != 2)) {
            this.f46956a = 104;
            return null;
        }
        Object remove3 = jSONObject.remove("43");
        if (remove3 != null && (!(remove3 instanceof Number) || ((Number) remove3).intValue() > 15)) {
            this.f46956a = 105;
            return null;
        }
        Object remove4 = jSONObject.remove("44");
        if (remove4 != null && (!(remove4 instanceof Number) || ((Number) remove4).intValue() < 15)) {
            this.f46956a = 106;
            return null;
        }
        g.b bVar = new g.b();
        bVar.f46984a = obj;
        Object remove5 = jSONObject.remove("javaScript");
        if (remove5 instanceof String) {
            bVar.f46991h = (String) remove5;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (opt = jSONObject.opt(next)) != null) {
                char c4 = '\uffff';
                int hashCode = next.hashCode();
                int i4 = 0;
                if (hashCode != 50) {
                    if (hashCode != 1599) {
                        if (hashCode != 1605) {
                            if (hashCode == 1723 && next.equals("61")) {
                                c4 = 2;
                            }
                        } else if (next.equals("27")) {
                            c4 = 3;
                        }
                    } else if (next.equals("21")) {
                        c4 = 1;
                    }
                } else if (next.equals("2")) {
                    c4 = 0;
                }
                if (c4 == 0) {
                    JSONArray jSONArray = (JSONArray) opt;
                    int length = jSONArray.length();
                    if (length > 0) {
                        g[] gVarArr = new g[length];
                        int i5 = 0;
                        for (int i6 = 0; i6 < length; i6++) {
                            g a4 = a(jSONArray.optJSONObject(i6));
                            if (a4 != null) {
                                gVarArr[i5] = a4;
                                i5++;
                            }
                        }
                        if (i5 == length) {
                            bVar.f46985b = gVarArr;
                        } else {
                            g[] gVarArr2 = new g[i5];
                            bVar.f46985b = gVarArr2;
                            System.arraycopy(gVarArr, 0, gVarArr2, 0, i5);
                        }
                    }
                } else if (c4 == 1) {
                    JSONArray jSONArray2 = (JSONArray) opt;
                    int length2 = jSONArray2.length();
                    if (length2 > 0) {
                        bVar.f46988e = new c[length2];
                        while (i4 < length2) {
                            bVar.f46988e[i4] = c(jSONArray2.optJSONObject(i4));
                            i4++;
                        }
                    }
                } else if (c4 == 2) {
                    JSONArray jSONArray3 = (JSONArray) opt;
                    int length3 = jSONArray3.length();
                    if (length3 > 0) {
                        bVar.f46989f = new e[length3];
                        while (i4 < length3) {
                            bVar.f46989f[i4] = d(jSONArray3.optJSONObject(i4));
                            i4++;
                        }
                    }
                } else if (c4 != 3) {
                    com.qq.e.dl.k.g a5 = l.a(opt);
                    if (a5 instanceof com.qq.e.dl.k.c) {
                        bVar.f46987d.put(next, (com.qq.e.dl.k.c) a5);
                    } else if (a5 instanceof j) {
                        bVar.f46986c.put(next, (j) a5);
                    }
                } else {
                    JSONArray jSONArray4 = (JSONArray) opt;
                    int length4 = jSONArray4.length();
                    if (length4 > 0) {
                        bVar.f46990g = new a[length4];
                        while (i4 < length4) {
                            bVar.f46990g[i4] = b(jSONArray4.optJSONObject(i4));
                            i4++;
                        }
                    }
                }
            }
        }
        this.f46956a = 107;
        return bVar.a();
    }

    private void a(JSONObject jSONObject, c.b bVar) {
        com.qq.e.dl.k.c b4;
        if (k0.a(jSONObject)) {
            return;
        }
        Object remove = jSONObject.remove("sag");
        if (remove instanceof String) {
            bVar.f46950f = (String) remove;
        }
        Object remove2 = jSONObject.remove("brd");
        if (remove2 instanceof JSONObject) {
            bVar.f46951g = (JSONObject) remove2;
        }
        Object remove3 = jSONObject.remove("bsd");
        if (remove3 instanceof JSONObject) {
            bVar.f46952h = (JSONObject) remove3;
        }
        Object remove4 = jSONObject.remove("nl");
        if (remove4 instanceof Integer) {
            bVar.f46953i = ((Integer) remove4).intValue() == 1;
        }
        Object remove5 = jSONObject.remove("saf");
        if (remove5 instanceof String) {
            bVar.f46954j = (String) remove5;
        }
        Object remove6 = jSONObject.remove("bpd");
        if (remove6 instanceof String) {
            bVar.f46955k = (String) remove6;
        }
        if (k0.a(jSONObject)) {
            return;
        }
        bVar.f46949e = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (b4 = l.b(jSONObject.opt(next))) != null) {
                bVar.f46949e.put(next, b4);
                keys.remove();
            }
        }
        if (jSONObject.length() > 0) {
            bVar.f46948d = jSONObject.toString();
        }
    }

    private void a(JSONObject jSONObject, e.b bVar) {
        com.qq.e.dl.k.c b4;
        if (k0.a(jSONObject)) {
            return;
        }
        Object remove = jSONObject.remove("sag");
        if (remove instanceof String) {
            bVar.f46968e = (String) remove;
        }
        Object remove2 = jSONObject.remove("brd");
        if (remove2 instanceof JSONObject) {
            bVar.f46969f = (JSONObject) remove2;
        }
        Object remove3 = jSONObject.remove("bsd");
        if (remove3 instanceof JSONObject) {
            bVar.f46970g = (JSONObject) remove3;
        }
        if (k0.a(jSONObject)) {
            return;
        }
        bVar.f46967d = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (b4 = l.b(jSONObject.opt(next))) != null) {
                bVar.f46967d.put(next, b4);
                keys.remove();
            }
        }
        if (jSONObject.length() > 0) {
            bVar.f46966c = jSONObject.toString();
        }
    }
}
