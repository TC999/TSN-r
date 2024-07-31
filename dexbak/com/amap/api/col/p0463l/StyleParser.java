package com.amap.api.col.p0463l;

import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.p048ae.gmap.style.StyleElement;
import com.autonavi.base.p048ae.gmap.style.StyleItem;
import com.kuaishou.weapon.p205p0.C7183b;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.c2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class StyleParser {

    /* renamed from: d */
    private static final int[] f3718d = {1};

    /* renamed from: a */
    private int f3719a = 0;

    /* renamed from: b */
    private int f3720b = -1;

    /* renamed from: c */
    List<EngineStyleKeyItem> f3721c = null;

    /* renamed from: b */
    public static int m55514b(String str) {
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

    /* renamed from: c */
    public static StyleConfig m55513c(byte[] bArr) {
        StyleConfig styleConfig;
        StyleConfig styleConfig2 = null;
        try {
            styleConfig = new StyleConfig();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bytes = C7304t.f25048d.getBytes("utf-8");
            int length = bArr.length;
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) (bytes[i % length2] ^ bArr[i]);
            }
            styleConfig.m55748b(Convert.getString(bArr, 0, 4));
            styleConfig.m55747c(Convert.getString(bArr, 4, 32));
            styleConfig.m55746d(Convert.getString(bArr, 36, 10));
            styleConfig.m55745e(m55509g(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
            return styleConfig;
        } catch (Throwable th2) {
            th = th2;
            styleConfig2 = styleConfig;
            th.printStackTrace();
            return styleConfig2;
        }
    }

    /* renamed from: f */
    private static StyleElement m55510f(Map<Integer, StyleItem> map, int i, int i2, EngineStyleKeyItem engineStyleKeyItem) {
        StyleItem styleItem = map.get(Integer.valueOf(i));
        if (styleItem == null) {
            styleItem = new StyleItem(engineStyleKeyItem.f5812c);
            styleItem.mainKey = engineStyleKeyItem.f5810a;
            styleItem.subKey = engineStyleKeyItem.f5811b;
            map.put(Integer.valueOf(i), styleItem);
        }
        StyleElement styleElement = styleItem.get(i2);
        if (styleElement == null) {
            StyleElement styleElement2 = new StyleElement();
            styleElement2.styleElementType = i2;
            styleItem.put(i2, styleElement2);
            return styleElement2;
        }
        return styleElement;
    }

    /* renamed from: g */
    private static String m55509g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(C7183b.f24540a);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    private List<EngineStyleKeyItem> m55508h(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        for (EngineStyleKeyItem engineStyleKeyItem : this.f3721c) {
            if (engineStyleKeyItem != null) {
                String str4 = engineStyleKeyItem.f5814e;
                if (str4 != null && str4.equals(str2)) {
                    arrayList.add(engineStyleKeyItem);
                } else {
                    String str5 = engineStyleKeyItem.f5814e;
                    if (str5 != null && str5.equals(str) && (str3 = engineStyleKeyItem.f5815f) != null && str3.contains(str2)) {
                        arrayList.add(engineStyleKeyItem);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private void m55506j(StyleParserResult styleParserResult) {
        if (this.f3720b != -1) {
            Map<Integer, StyleItem> m55253a = styleParserResult.m55253a();
            for (EngineStyleKeyItem engineStyleKeyItem : m55508h("roads", "trafficRoadBackgroundColor")) {
                m55510f(m55253a, engineStyleKeyItem.f5813d, StyleElementType.m55424a("fillColor"), engineStyleKeyItem).value = this.f3720b;
                m55510f(m55253a, engineStyleKeyItem.f5813d, StyleElementType.m55424a("strokeColor"), engineStyleKeyItem).value = this.f3720b;
            }
        }
    }

    /* renamed from: k */
    private void m55505k(StyleParserResult styleParserResult, byte[] bArr, boolean z) {
        StyleConfig m55513c = m55513c(bArr);
        if (m55513c == null || m55513c.m55749a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(m55513c.m55749a());
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string != null && string.trim().equals("background")) {
                        this.f3719a = m55514b("#".concat(String.valueOf(jSONObject.optString("background"))));
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject(string);
                        if (optJSONObject != null) {
                            m55503m(string, styleParserResult.m55253a(), optJSONObject, z);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m55504l(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.f3721c == null) {
            this.f3721c = m55494v();
        }
        List<EngineStyleKeyItem> m55508h = m55508h(str, str2);
        for (EngineStyleKeyItem engineStyleKeyItem : m55508h) {
            if (engineStyleKeyItem == null || engineStyleKeyItem.f5812c == -1000) {
                return;
            }
            int i = engineStyleKeyItem.f5813d;
            if (!jSONObject.optBoolean("visible", true)) {
                StyleElement m55510f = m55510f(map, i, StyleElementType.m55424a("visible"), engineStyleKeyItem);
                m55510f.textureId = -1;
                m55510f.visible = 0;
            } else {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    m55510f(map, i, StyleElementType.m55424a("textFillColor"), engineStyleKeyItem).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    m55510f(map, i, StyleElementType.m55424a("textFillColor"), engineStyleKeyItem).opacity = 0.0f;
                    StyleElement m55510f2 = m55510f(map, i, StyleElementType.m55424a("textStrokeColor"), engineStyleKeyItem);
                    m55510f2.opacity = 0.0f;
                    m55510f2.visible = 0;
                    m55510f2.textureId = -1;
                }
                m55500p(map, jSONObject, "color", "opacity", i, engineStyleKeyItem);
                m55500p(map, jSONObject, "fillColor", "fillOpacity", i, engineStyleKeyItem);
                m55500p(map, jSONObject, "strokeColor", "strokeOpacity", i, engineStyleKeyItem);
                m55500p(map, jSONObject, "textFillColor", "textFillOpacity", i, engineStyleKeyItem);
                m55500p(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i, engineStyleKeyItem);
                m55500p(map, jSONObject, "backgroundColor", "backgroundOpacity", i, engineStyleKeyItem);
                if (z) {
                    m55501o(map, jSONObject, "textureName", i, engineStyleKeyItem);
                }
            }
        }
        m55508h.clear();
    }

    /* renamed from: m */
    private void m55503m(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("subType");
        if (optJSONObject == null) {
            m55504l(str, str, map, jSONObject, z);
            return;
        }
        JSONArray names = optJSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
            if (optJSONObject2.has("detailedType")) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detailedType");
                if (optJSONObject3 != null) {
                    JSONArray names2 = optJSONObject3.names();
                    for (int i2 = 0; i2 < names2.length(); i2++) {
                        String optString2 = names2.optString(i2);
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject(optString2);
                        if (optJSONObject4 != null) {
                            m55504l(str, optString2, map, optJSONObject4, z);
                        }
                    }
                }
            } else {
                m55504l(str, optString, map, optJSONObject2, z);
            }
        }
    }

    /* renamed from: n */
    private static void m55502n(Map<Integer, StyleItem> map, JSONObject jSONObject, int i, int i2, EngineStyleKeyItem engineStyleKeyItem) throws JSONException {
        int m55514b;
        StyleElement m55510f = m55510f(map, i, i2, engineStyleKeyItem);
        JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
        if (optJSONObject == null || (m55514b = m55514b(optJSONObject.optString("color"))) == 0) {
            return;
        }
        m55510f.value = m55514b;
        m55510f.textureId = optJSONObject.optInt("textureName", 0);
        m55510f.lineWidth = optJSONObject.optInt("lineWidth", 0);
        if (i >= 30 && i <= 38) {
            m55510f(map, i, 4, engineStyleKeyItem).opacity = 0.1f;
            return;
        }
        String str = engineStyleKeyItem.f5814e;
        if (str != null && str.equals("water") && i2 == 3) {
            m55510f(map, i, 2, engineStyleKeyItem).value = m55514b;
        }
    }

    /* renamed from: o */
    private static void m55501o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i, EngineStyleKeyItem engineStyleKeyItem) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt == 0) {
                return;
            }
            m55510f(map, i, StyleElementType.m55424a(str), engineStyleKeyItem).textureId = optInt;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: p */
    private static void m55500p(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i, EngineStyleKeyItem engineStyleKeyItem) {
        try {
            String optString = jSONObject.optString(str, null);
            float f = 1.0f;
            int i2 = 0;
            if (TextUtils.isEmpty(optString)) {
                f = (float) jSONObject.optDouble(str2, 1.0d);
            } else {
                i2 = m55514b("#".concat(String.valueOf(optString)));
            }
            if (i2 == 0 && f == 1.0d) {
                return;
            }
            int m55424a = StyleElementType.m55424a(str);
            StyleElement m55510f = m55510f(map, i, m55424a, engineStyleKeyItem);
            m55510f.value = i2;
            m55510f.opacity = f;
            String str3 = engineStyleKeyItem.f5815f;
            if (str3 != null && str3.equals("China")) {
                m55510f(map, i, m55424a, engineStyleKeyItem).opacity = 0.0f;
                return;
            }
            String str4 = engineStyleKeyItem.f5814e;
            if (str4 != null && str4.equals("water") && m55424a == 3) {
                StyleElement m55510f2 = m55510f(map, i, 2, engineStyleKeyItem);
                m55510f2.value = i2;
                m55510f2.opacity = f;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: q */
    private void m55499q(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i) throws JSONException {
        for (String str2 : strArr) {
            if (this.f3721c == null) {
                this.f3721c = m55494v();
            }
            for (EngineStyleKeyItem engineStyleKeyItem : m55508h(str, str2)) {
                m55502n(map, jSONObject, engineStyleKeyItem.f5813d, i, engineStyleKeyItem);
            }
        }
    }

    /* renamed from: r */
    private static void m55498r(JSONArray jSONArray, String str, String str2, String str3, List<EngineStyleKeyItem> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr3[i2] = optJSONArray.optInt(i2);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                list.add(new EngineStyleKeyItem(optInt, iArr, str, str2, str3));
            }
        }
    }

    /* renamed from: s */
    private boolean m55497s(Map<Integer, StyleItem> map, byte[] bArr) {
        String[] m55566a;
        int m55424a;
        int m55514b;
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("featureType");
                if (!TextUtils.isEmpty(optString)) {
                    if ("background".equals(optString)) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                        if (optJSONObject2 != null && (m55514b = m55514b(optJSONObject2.optString("color"))) != 0) {
                            this.f3719a = m55514b;
                        }
                    } else {
                        String m55565b = StyleItemAdaptor.m55565b(optString);
                        if (m55565b != null && (m55566a = StyleItemAdaptor.m55566a(optString)) != null && m55566a.length != 0) {
                            String optString2 = optJSONObject.optString("elementType");
                            if (!TextUtils.isEmpty(optString2) && (m55424a = StyleElementType.m55424a(optString2)) != -1) {
                                m55499q(map, optJSONObject, m55565b, m55566a, m55424a);
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

    /* renamed from: t */
    private StyleParserResult m55496t(String str, boolean z) {
        try {
            return m55495u(FileUtil.readFileContents(str), z);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: u */
    private StyleParserResult m55495u(byte[] bArr, boolean z) {
        StyleParserResult styleParserResult = new StyleParserResult();
        try {
            if (!m55497s(styleParserResult.m55253a(), bArr)) {
                m55505k(styleParserResult, bArr, z);
            }
            m55506j(styleParserResult);
            styleParserResult.m55252b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return styleParserResult;
    }

    /* renamed from: v */
    private List<EngineStyleKeyItem> m55494v() {
        JSONArray jSONArray;
        String str;
        String str2;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        int i;
        String str3;
        String str4;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        int i2;
        JSONObject jSONObject3;
        JSONObject optJSONObject;
        String str5;
        JSONObject jSONObject4;
        String str6 = "name";
        String str7 = "subType";
        this.f3721c = new ArrayList();
        try {
            jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return this.f3721c;
        }
        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            return this.f3721c;
        }
        JSONArray names = optJSONObject2.names();
        int length = names.length();
        int i3 = 0;
        while (i3 < length) {
            String optString = names.optString(i3);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
            if (optJSONObject3 != null) {
                String optString2 = optJSONObject3.optString(str6);
                if (optJSONObject3.has("styleMap")) {
                    m55498r(optJSONObject3.optJSONArray("styleMap"), optString, null, optString2, this.f3721c);
                } else if (optJSONObject3.has(str7)) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str7);
                    if (optJSONObject4 != null) {
                        JSONArray names2 = optJSONObject4.names();
                        int length2 = names2.length();
                        int i4 = 0;
                        while (i4 < length2) {
                            String optString3 = names2.optString(i4);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                            if (optJSONObject5 != null) {
                                jSONObject2 = optJSONObject2;
                                String optString4 = optJSONObject5.optString(str6);
                                jSONArray3 = names;
                                if (optJSONObject5.has("styleMap")) {
                                    i2 = length;
                                    m55498r(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + "-" + optString4, this.f3721c);
                                } else {
                                    i2 = length;
                                    if (optJSONObject5.has(str7) && (optJSONObject = optJSONObject5.optJSONObject(str7)) != null) {
                                        JSONArray names3 = optJSONObject.names();
                                        str4 = str7;
                                        int length3 = names3.length();
                                        jSONObject3 = optJSONObject4;
                                        int i5 = 0;
                                        while (i5 < length3) {
                                            int i6 = length3;
                                            String optString5 = names3.optString(i5);
                                            JSONArray jSONArray4 = names3;
                                            JSONObject optJSONObject6 = optJSONObject.optJSONObject(optString5);
                                            if (optJSONObject6 != null) {
                                                jSONObject4 = optJSONObject;
                                                String optString6 = optJSONObject6.optString(str6);
                                                if (optJSONObject6.has("styleMap")) {
                                                    str5 = str6;
                                                    m55498r(optJSONObject6.optJSONArray("styleMap"), optString, optString3 + "-" + optString5, optString2 + "-" + optString4 + "-" + optString6, this.f3721c);
                                                } else {
                                                    str5 = str6;
                                                }
                                            } else {
                                                str5 = str6;
                                                jSONObject4 = optJSONObject;
                                            }
                                            i5++;
                                            length3 = i6;
                                            names3 = jSONArray4;
                                            optJSONObject = jSONObject4;
                                            str6 = str5;
                                        }
                                        str3 = str6;
                                        i4++;
                                        optJSONObject2 = jSONObject2;
                                        length = i2;
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
                                i2 = length;
                            }
                            jSONObject3 = optJSONObject4;
                            i4++;
                            optJSONObject2 = jSONObject2;
                            length = i2;
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
                i = length;
                this.f3721c.add(new EngineStyleKeyItem(20021, f3718d, "roads", "trafficRoadBackgroundColor", null));
                i3++;
                optJSONObject2 = jSONObject;
                length = i;
                names = jSONArray2;
                str7 = str2;
                str6 = str;
            }
            str = str6;
            str2 = str7;
            jSONObject = optJSONObject2;
            jSONArray2 = names;
            i = length;
            i3++;
            optJSONObject2 = jSONObject;
            length = i;
            names = jSONArray2;
            str7 = str2;
            str6 = str;
        }
        return this.f3721c;
    }

    /* renamed from: a */
    public final int m55515a() {
        return this.f3719a;
    }

    /* renamed from: d */
    public final StyleParserResult m55512d(String str, boolean z) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return m55496t(str, z);
    }

    /* renamed from: e */
    public final StyleParserResult m55511e(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return m55495u(bArr, z);
    }

    /* renamed from: i */
    public final void m55507i(int i) {
        this.f3720b = i;
    }
}
