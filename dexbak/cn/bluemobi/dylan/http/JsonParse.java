package cn.bluemobi.dylan.http;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.github.mikephil.charting.utils.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class JsonParse implements HttpJsonKey {
    private static volatile JsonParse jsonParse;
    private String code = "code";
    private String msg = "msg";
    private String data = "data";
    private int successCode = -1;

    private JsonParse() {
    }

    private static void addIndentBlank(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('\t');
        }
    }

    public static String formatJson(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    sb.append('\n');
                    i2--;
                    addIndentBlank(sb, i2);
                    sb.append(charAt);
                }
                sb.append(charAt);
                sb.append('\n');
                i2++;
                addIndentBlank(sb, i2);
            } else {
                sb.append(charAt);
                if (c != '\\') {
                    sb.append('\n');
                    addIndentBlank(sb, i2);
                }
            }
            i++;
            c = charAt;
        }
        return sb.toString();
    }

    public static String formatMoney(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public static boolean getBoolean(Map<String, Object> map, String str) {
        return getBoolean(map, str, false);
    }

    public static double getDouble(Map<String, Object> map, String str) {
        return getDouble(map, str, Utils.DOUBLE_EPSILON);
    }

    public static float getFloat(Map<String, Object> map, String str) {
        return getFloat(map, str, 0.0f);
    }

    public static int getInt(Map<String, Object> map, String str) {
        return getInt(map, str, 0);
    }

    public static JsonParse getJsonParse() {
        if (jsonParse == null) {
            synchronized (Http.class) {
                if (jsonParse == null) {
                    jsonParse = new JsonParse();
                }
            }
        }
        return jsonParse;
    }

    public static List<Map<String, Object>> getList(Map<String, Object> map, String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.size() == 0 || isNull(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : (List) obj;
    }

    public static long getLong(Map<String, Object> map, String str) {
        return getLong(map, str, 0L);
    }

    public static Map<String, Object> getMap(Map<String, Object> map, String str) {
        Object obj;
        ArrayMap arrayMap = new ArrayMap();
        return (map == null || map.size() == 0 || isNull(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Map)) ? arrayMap : (Map) obj;
    }

    public static String getMoney(Map<String, Object> map, String str) {
        try {
            return formatMoney(getDouble(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return "0.00";
        }
    }

    public static String getString(Map<String, Object> map, String str) {
        return getString(map, str, "");
    }

    public static boolean isNull(String str) {
        return str == null || str.equals("") || str.equalsIgnoreCase("null");
    }

    public static boolean isNull2(String str) {
        return str == null || str.equals("");
    }

    public static List<Map<String, Object>> jsonToListMap(String str) throws JSONException {
        return !TextUtils.isEmpty(str) ? (List) JSON.parseObject(str, new TypeReference<List<Map<String, Object>>>() { // from class: cn.bluemobi.dylan.http.JsonParse.4
        }.getType(), new Feature[0]) : new ArrayList();
    }

    public static ArrayMap<String, Object> jsonToMap(String str) throws JSONException {
        return !TextUtils.isEmpty(str) ? (ArrayMap) JSON.parseObject(str, new TypeReference<ArrayMap<String, Object>>() { // from class: cn.bluemobi.dylan.http.JsonParse.3
        }.getType(), new Feature[0]) : new ArrayMap<>();
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public String getCode() {
        return this.code;
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public String getData() {
        return this.data;
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public String getMsg() {
        return this.msg;
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public int getSuccessCode() {
        return this.successCode;
    }

    public JsonParse initJson(String str, String str2, String str3, int i) {
        setCode(str).setData(str2).setMsg(str3).setSuccessCode(i);
        return jsonParse;
    }

    public ArrayMap<String, Object> jsonParse(String str) throws JSONException {
        return jsonParse(str, getCode(), getData(), getMsg());
    }

    public JsonParse setCode(String str) {
        this.code = str;
        return this;
    }

    public JsonParse setData(String str) {
        this.data = str;
        return this;
    }

    public JsonParse setMsg(String str) {
        this.msg = str;
        return this;
    }

    public JsonParse setSuccessCode(int i) {
        this.successCode = i;
        return this;
    }

    public static boolean getBoolean(Map<String, Object> map, String str, boolean z) {
        try {
            return Boolean.parseBoolean(getString(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return z;
        }
    }

    public static double getDouble(Map<String, Object> map, String str, double d) {
        try {
            return Double.parseDouble(getString(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return Utils.DOUBLE_EPSILON;
        }
    }

    public static float getFloat(Map<String, Object> map, String str, float f) {
        try {
            return Float.parseFloat(getString(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return 0.0f;
        }
    }

    public static int getInt(Map<String, Object> map, String str, int i) {
        try {
            return Integer.parseInt(getString(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return i;
        }
    }

    public static long getLong(Map<String, Object> map, String str, long j) {
        try {
            return Long.parseLong(getString(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return j;
        }
    }

    public static String getString(Map<String, Object> map, String str, String str2) {
        if (map == null || map.size() == 0 || isNull(str) || !map.containsKey(str)) {
            return str2;
        }
        Object obj = map.get(str);
        return obj == null ? "" : isNull(String.valueOf(obj)) ? str2 : map.get(str).toString();
    }

    public ArrayMap<String, Object> jsonParse(String str, String str2, String str3, String str4) throws JSONException {
        ArrayMap arrayMap = (ArrayMap) JSON.parseObject(str, new TypeReference<ArrayMap<String, Object>>() { // from class: cn.bluemobi.dylan.http.JsonParse.1
        }.getType(), new Feature[0]);
        ArrayMap<String, Object> arrayMap2 = new ArrayMap<>();
        ArrayMap arrayMap3 = new ArrayMap();
        if (arrayMap.containsKey(str3)) {
            Object obj = arrayMap.get(str3);
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Character) && !(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Short)) {
                if (obj instanceof JSONArray) {
                    arrayMap3.put(str3, obj);
                    arrayMap2.put(str3, arrayMap3);
                } else if (obj instanceof JSONObject) {
                    arrayMap3 = (ArrayMap) JSON.parseObject(obj.toString(), new TypeReference<ArrayMap<String, Object>>() { // from class: cn.bluemobi.dylan.http.JsonParse.2
                    }.getType(), new Feature[0]);
                    arrayMap2.put(str3, arrayMap3);
                } else {
                    arrayMap2.put(str3, arrayMap3);
                }
            } else {
                arrayMap3.put(str3, obj.toString());
                arrayMap2.put(str3, arrayMap3);
            }
        }
        for (String str5 : arrayMap.keySet()) {
            if (!str5.equals(str3)) {
                if (arrayMap3.containsKey(str5)) {
                    str5 = str5 + "2";
                }
                arrayMap3.put(str5, arrayMap.get(str5));
            }
        }
        arrayMap2.put(str3, arrayMap3);
        if (arrayMap.containsKey(str2)) {
            arrayMap2.put(str2, Integer.valueOf(getInt(arrayMap, str2)));
            arrayMap2.put(str4, getString(arrayMap, str4));
            return arrayMap2;
        }
        throw new JSONException();
    }

    public static <T> List<T> getList(Map<String, Object> map, String str, Class<T> cls) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        return (map == null || map.size() == 0 || isNull(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? arrayList : JSON.parseArray(JSON.toJSONString(obj), cls);
    }
}
