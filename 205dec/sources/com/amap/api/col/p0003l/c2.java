package com.amap.api.col.p0003l;

import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StyleParser.java */
/* renamed from: com.amap.api.col.3l.c2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c2 {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f7300d = {1};

    /* renamed from: a  reason: collision with root package name */
    private int f7301a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f7302b = -1;

    /* renamed from: c  reason: collision with root package name */
    List<z1> f7303c = null;

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#".concat(str);
            }
            return Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static a2 c(byte[] bArr) {
        a2 a2Var;
        a2 a2Var2 = null;
        try {
            a2Var = new a2();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bytes = "l".getBytes("utf-8");
            int length = bArr.length;
            int length2 = bytes.length;
            for (int i4 = 0; i4 < length; i4++) {
                bArr[i4] = (byte) (bytes[i4 % length2] ^ bArr[i4]);
            }
            a2Var.b(Convert.getString(bArr, 0, 4));
            a2Var.c(Convert.getString(bArr, 4, 32));
            a2Var.d(Convert.getString(bArr, 36, 10));
            a2Var.e(g(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
            return a2Var;
        } catch (Throwable th2) {
            th = th2;
            a2Var2 = a2Var;
            th.printStackTrace();
            return a2Var2;
        }
    }

    private static StyleElement f(Map<Integer, StyleItem> map, int i4, int i5, z1 z1Var) {
        StyleItem styleItem = map.get(Integer.valueOf(i4));
        if (styleItem == null) {
            styleItem = new StyleItem(z1Var.f9577c);
            styleItem.mainKey = z1Var.f9575a;
            styleItem.subKey = z1Var.f9576b;
            map.put(Integer.valueOf(i4), styleItem);
        }
        StyleElement styleElement = styleItem.get(i5);
        if (styleElement == null) {
            StyleElement styleElement2 = new StyleElement();
            styleElement2.styleElementType = i5;
            styleItem.put(i5, styleElement2);
            return styleElement2;
        }
        return styleElement;
    }

    private static String g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<z1> h(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        for (z1 z1Var : this.f7303c) {
            if (z1Var != null) {
                String str4 = z1Var.f9579e;
                if (str4 != null && str4.equals(str2)) {
                    arrayList.add(z1Var);
                } else {
                    String str5 = z1Var.f9579e;
                    if (str5 != null && str5.equals(str) && (str3 = z1Var.f9580f) != null && str3.contains(str2)) {
                        arrayList.add(z1Var);
                    }
                }
            }
        }
        return arrayList;
    }

    private void j(e2 e2Var) {
        if (this.f7302b != -1) {
            Map<Integer, StyleItem> a4 = e2Var.a();
            for (z1 z1Var : h("roads", "trafficRoadBackgroundColor")) {
                f(a4, z1Var.f9578d, cx.a("fillColor"), z1Var).value = this.f7302b;
                f(a4, z1Var.f9578d, cx.a("strokeColor"), z1Var).value = this.f7302b;
            }
        }
    }

    private void k(e2 e2Var, byte[] bArr, boolean z3) {
        a2 c4 = c(bArr);
        if (c4 == null || c4.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(c4.a());
            JSONArray names = jSONObject.names();
            for (int i4 = 0; i4 < names.length(); i4++) {
                String string = names.getString(i4);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string != null && string.trim().equals("background")) {
                        this.f7301a = b("#".concat(String.valueOf(jSONObject.optString("background"))));
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject(string);
                        if (optJSONObject != null) {
                            m(string, e2Var.a(), optJSONObject, z3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void l(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z3) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.f7303c == null) {
            this.f7303c = v();
        }
        List<z1> h4 = h(str, str2);
        for (z1 z1Var : h4) {
            if (z1Var == null || z1Var.f9577c == -1000) {
                return;
            }
            int i4 = z1Var.f9578d;
            if (!jSONObject.optBoolean("visible", true)) {
                StyleElement f4 = f(map, i4, cx.a("visible"), z1Var);
                f4.textureId = -1;
                f4.visible = 0;
            } else {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    f(map, i4, cx.a("textFillColor"), z1Var).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    f(map, i4, cx.a("textFillColor"), z1Var).opacity = 0.0f;
                    StyleElement f5 = f(map, i4, cx.a("textStrokeColor"), z1Var);
                    f5.opacity = 0.0f;
                    f5.visible = 0;
                    f5.textureId = -1;
                }
                p(map, jSONObject, "color", "opacity", i4, z1Var);
                p(map, jSONObject, "fillColor", "fillOpacity", i4, z1Var);
                p(map, jSONObject, "strokeColor", "strokeOpacity", i4, z1Var);
                p(map, jSONObject, "textFillColor", "textFillOpacity", i4, z1Var);
                p(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i4, z1Var);
                p(map, jSONObject, "backgroundColor", "backgroundOpacity", i4, z1Var);
                if (z3) {
                    o(map, jSONObject, "textureName", i4, z1Var);
                }
            }
        }
        h4.clear();
    }

    private void m(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z3) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("subType");
        if (optJSONObject == null) {
            l(str, str, map, jSONObject, z3);
            return;
        }
        JSONArray names = optJSONObject.names();
        for (int i4 = 0; i4 < names.length(); i4++) {
            String optString = names.optString(i4);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
            if (optJSONObject2.has("detailedType")) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detailedType");
                if (optJSONObject3 != null) {
                    JSONArray names2 = optJSONObject3.names();
                    for (int i5 = 0; i5 < names2.length(); i5++) {
                        String optString2 = names2.optString(i5);
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject(optString2);
                        if (optJSONObject4 != null) {
                            l(str, optString2, map, optJSONObject4, z3);
                        }
                    }
                }
            } else {
                l(str, optString, map, optJSONObject2, z3);
            }
        }
    }

    private static void n(Map<Integer, StyleItem> map, JSONObject jSONObject, int i4, int i5, z1 z1Var) throws JSONException {
        int b4;
        StyleElement f4 = f(map, i4, i5, z1Var);
        JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
        if (optJSONObject == null || (b4 = b(optJSONObject.optString("color"))) == 0) {
            return;
        }
        f4.value = b4;
        f4.textureId = optJSONObject.optInt("textureName", 0);
        f4.lineWidth = optJSONObject.optInt("lineWidth", 0);
        if (i4 >= 30 && i4 <= 38) {
            f(map, i4, 4, z1Var).opacity = 0.1f;
            return;
        }
        String str = z1Var.f9579e;
        if (str != null && str.equals("water") && i5 == 3) {
            f(map, i4, 2, z1Var).value = b4;
        }
    }

    private static void o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i4, z1 z1Var) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt == 0) {
                return;
            }
            f(map, i4, cx.a(str), z1Var).textureId = optInt;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void p(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i4, z1 z1Var) {
        try {
            String optString = jSONObject.optString(str, null);
            float f4 = 1.0f;
            int i5 = 0;
            if (TextUtils.isEmpty(optString)) {
                f4 = (float) jSONObject.optDouble(str2, 1.0d);
            } else {
                i5 = b("#".concat(String.valueOf(optString)));
            }
            if (i5 == 0 && f4 == 1.0d) {
                return;
            }
            int a4 = cx.a(str);
            StyleElement f5 = f(map, i4, a4, z1Var);
            f5.value = i5;
            f5.opacity = f4;
            String str3 = z1Var.f9580f;
            if (str3 != null && str3.equals("China")) {
                f(map, i4, a4, z1Var).opacity = 0.0f;
                return;
            }
            String str4 = z1Var.f9579e;
            if (str4 != null && str4.equals("water") && a4 == 3) {
                StyleElement f6 = f(map, i4, 2, z1Var);
                f6.value = i5;
                f6.opacity = f4;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void q(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i4) throws JSONException {
        for (String str2 : strArr) {
            if (this.f7303c == null) {
                this.f7303c = v();
            }
            for (z1 z1Var : h(str, str2)) {
                n(map, jSONObject, z1Var.f9578d, i4, z1Var);
            }
        }
    }

    private static void r(JSONArray jSONArray, String str, String str2, String str3, List<z1> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i5 = 0; i5 < length2; i5++) {
                        iArr3[i5] = optJSONArray.optInt(i5);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                list.add(new z1(optInt, iArr, str, str2, str3));
            }
        }
    }

    private boolean s(Map<Integer, StyleItem> map, byte[] bArr) {
        String[] a4;
        int a5;
        int b4;
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                String optString = optJSONObject.optString("featureType");
                if (!TextUtils.isEmpty(optString)) {
                    if ("background".equals(optString)) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                        if (optJSONObject2 != null && (b4 = b(optJSONObject2.optString("color"))) != 0) {
                            this.f7301a = b4;
                        }
                    } else {
                        String b5 = b2.b(optString);
                        if (b5 != null && (a4 = b2.a(optString)) != null && a4.length != 0) {
                            String optString2 = optJSONObject.optString("elementType");
                            if (!TextUtils.isEmpty(optString2) && (a5 = cx.a(optString2)) != -1) {
                                q(map, optJSONObject, b5, a4, a5);
                            }
                        }
                    }
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private e2 t(String str, boolean z3) {
        try {
            return u(FileUtil.readFileContents(str), z3);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private e2 u(byte[] bArr, boolean z3) {
        e2 e2Var = new e2();
        try {
            if (!s(e2Var.a(), bArr)) {
                k(e2Var, bArr, z3);
            }
            j(e2Var);
            e2Var.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return e2Var;
    }

    private List<z1> v() {
        JSONArray jSONArray;
        String str;
        String str2;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        int i4;
        String str3;
        String str4;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        int i5;
        JSONObject jSONObject3;
        JSONObject optJSONObject;
        String str5;
        JSONObject jSONObject4;
        String str6 = "name";
        String str7 = "subType";
        this.f7303c = new ArrayList();
        try {
            jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"\u533a\u57df\u9762\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"\u9646\u5730\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"\u7eff\u5730\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"\u6559\u80b2\u4f53\u80b2\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"\u516c\u5171\u8bbe\u65bd\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"\u4ea4\u901a\u67a2\u7ebd\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"\u666f\u533a\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"\u6587\u5316\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"\u533b\u7597\u536b\u751f\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"\u8fd0\u52a8\u573a\u6240\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"\u5546\u4e1a\u573a\u6240\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"\u505c\u8f66\u573a\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"\u5730\u94c1\u8bbe\u65bd\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"\u6c34\u7cfb\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"\u5efa\u7b51\u7269\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"\u9053\u8def\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"\u9ad8\u901f\u516c\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"\u57ce\u5e02\u73af\u7ebf\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"\u56fd\u9053\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"\u7701\u9053\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"\u4e8c\u7ea7\u516c\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"\u4e09\u7ea7\u516c\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"\u56db\u7ea7\u9053\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"\u5728\u5efa\u9053\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"\u94c1\u8def\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"\u9ad8\u94c1\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"\u5730\u94c1\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"\u5728\u5efa\u5730\u94c1\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"\u5929\u6865\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"\u5730\u9053\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"\u5176\u4ed6\u7ebf\u6761\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"\u9053\u8def\u8def\u724c\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"\u6807\u6ce8\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"\u5174\u8da3\u70b9\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"\u4f4f\u5bbf\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"\u9910\u996e\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"\u8d2d\u7269\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"\u98ce\u666f\u540d\u80dc\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"\u4ea4\u901a\u8bbe\u65bd\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"\u91d1\u878d\u4fdd\u9669\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"\u79d1\u6559\u6587\u5316\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"\u751f\u6d3b\u670d\u52a1\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"\u533b\u7597\u4fdd\u5065\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"\u4f11\u95f2\u4f53\u80b2\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"\u516c\u5171\u8bbe\u65bd\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"\u5546\u52a1\u4f4f\u5b85\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"\u653f\u5e9c\u673a\u6784\u53ca\u793e\u4f1a\u56e2\u4f53\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"\u6469\u6258\u8f66\u670d\u52a1\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"\u6c7d\u8f66\u670d\u52a1\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"\u901a\u884c\u8bbe\u65bd\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"\u5730\u94c1\u7ad9\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"\u9053\u8def\u9644\u5c5e\u8bbe\u65bd\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"\u5730\u540d\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"\u5176\u4ed6\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"\u533a\u57df\u6807\u6ce8\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"\u5927\u6d32\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"\u56fd\u5bb6\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"\u7701/\u76f4\u8f96\u5e02/\u81ea\u6cbb\u533a/\u7279\u522b\u884c\u653f\u533a\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"\u57ce\u5e02\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"\u533a\u53bf\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"\u4e61\u9547\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"\u6751\u5e84\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"\u884c\u653f\u533a\u8fb9\u754c\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"\u4e2d\u56fd\u56fd\u754c\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"\u5916\u56fd\u56fd\u754c/\u505c\u706b\u7ebf/\u4e3b\u5f20\u7ebf\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"\u7701\u754c\u7ebf\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return this.f7303c;
        }
        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            return this.f7303c;
        }
        JSONArray names = optJSONObject2.names();
        int length = names.length();
        int i6 = 0;
        while (i6 < length) {
            String optString = names.optString(i6);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
            if (optJSONObject3 != null) {
                String optString2 = optJSONObject3.optString(str6);
                if (optJSONObject3.has("styleMap")) {
                    r(optJSONObject3.optJSONArray("styleMap"), optString, null, optString2, this.f7303c);
                } else if (optJSONObject3.has(str7)) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str7);
                    if (optJSONObject4 != null) {
                        JSONArray names2 = optJSONObject4.names();
                        int length2 = names2.length();
                        int i7 = 0;
                        while (i7 < length2) {
                            String optString3 = names2.optString(i7);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                            if (optJSONObject5 != null) {
                                jSONObject2 = optJSONObject2;
                                String optString4 = optJSONObject5.optString(str6);
                                jSONArray3 = names;
                                if (optJSONObject5.has("styleMap")) {
                                    i5 = length;
                                    r(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + "-" + optString4, this.f7303c);
                                } else {
                                    i5 = length;
                                    if (optJSONObject5.has(str7) && (optJSONObject = optJSONObject5.optJSONObject(str7)) != null) {
                                        JSONArray names3 = optJSONObject.names();
                                        str4 = str7;
                                        int length3 = names3.length();
                                        jSONObject3 = optJSONObject4;
                                        int i8 = 0;
                                        while (i8 < length3) {
                                            int i9 = length3;
                                            String optString5 = names3.optString(i8);
                                            JSONArray jSONArray4 = names3;
                                            JSONObject optJSONObject6 = optJSONObject.optJSONObject(optString5);
                                            if (optJSONObject6 != null) {
                                                jSONObject4 = optJSONObject;
                                                String optString6 = optJSONObject6.optString(str6);
                                                if (optJSONObject6.has("styleMap")) {
                                                    str5 = str6;
                                                    r(optJSONObject6.optJSONArray("styleMap"), optString, optString3 + "-" + optString5, optString2 + "-" + optString4 + "-" + optString6, this.f7303c);
                                                } else {
                                                    str5 = str6;
                                                }
                                            } else {
                                                str5 = str6;
                                                jSONObject4 = optJSONObject;
                                            }
                                            i8++;
                                            length3 = i9;
                                            names3 = jSONArray4;
                                            optJSONObject = jSONObject4;
                                            str6 = str5;
                                        }
                                        str3 = str6;
                                        i7++;
                                        optJSONObject2 = jSONObject2;
                                        length = i5;
                                        names = jSONArray3;
                                        str7 = str4;
                                        optJSONObject4 = jSONObject3;
                                        str6 = str3;
                                    }
                                }
                                str3 = str6;
                                str4 = str7;
                            } else {
                                str3 = str6;
                                str4 = str7;
                                jSONObject2 = optJSONObject2;
                                jSONArray3 = names;
                                i5 = length;
                            }
                            jSONObject3 = optJSONObject4;
                            i7++;
                            optJSONObject2 = jSONObject2;
                            length = i5;
                            names = jSONArray3;
                            str7 = str4;
                            optJSONObject4 = jSONObject3;
                            str6 = str3;
                        }
                    }
                }
                str = str6;
                str2 = str7;
                jSONObject = optJSONObject2;
                jSONArray2 = names;
                i4 = length;
                this.f7303c.add(new z1(20021, f7300d, "roads", "trafficRoadBackgroundColor", null));
                i6++;
                optJSONObject2 = jSONObject;
                length = i4;
                names = jSONArray2;
                str7 = str2;
                str6 = str;
            }
            str = str6;
            str2 = str7;
            jSONObject = optJSONObject2;
            jSONArray2 = names;
            i4 = length;
            i6++;
            optJSONObject2 = jSONObject;
            length = i4;
            names = jSONArray2;
            str7 = str2;
            str6 = str;
        }
        return this.f7303c;
    }

    public final int a() {
        return this.f7301a;
    }

    public final e2 d(String str, boolean z3) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return t(str, z3);
    }

    public final e2 e(byte[] bArr, boolean z3) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return u(bArr, z3);
    }

    public final void i(int i4) {
        this.f7302b = i4;
    }
}
