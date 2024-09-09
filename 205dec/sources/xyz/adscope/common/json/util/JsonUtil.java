package xyz.adscope.common.json.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class JsonUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v13, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r7v15, types: [org.json.JSONArray] */
    public static void a(JSONObject jSONObject, Object obj, Field field) {
        Object jSONObject2;
        Object[] objArr;
        try {
            Class<?> type = field.getType();
            String name = field.getName();
            Object obj2 = field.get(obj);
            if (obj2 == null || obj2.equals(null)) {
                return;
            }
            if (TypeUtil.isBasicType(type)) {
                if (jSONObject.has(name)) {
                    return;
                }
                jSONObject.put(name, obj2);
                return;
            }
            if (List.class.isAssignableFrom(type)) {
                jSONObject2 = new JSONArray();
                for (Object obj3 : (List) obj2) {
                    if (!TypeUtil.isBasicType(obj3.getClass()) && !(obj3 instanceof JSONObject)) {
                        jSONObject2.put(new JSONObject(toJson(obj3)));
                    }
                    jSONObject2.put(obj3);
                }
            } else if (type.isArray()) {
                jSONObject2 = new JSONArray();
                for (Object obj4 : (Object[]) obj2) {
                    if (!TypeUtil.isBasicType(obj4.getClass()) && !(obj4 instanceof JSONObject)) {
                        jSONObject2.put(new JSONObject(toJson(obj4)));
                    }
                    jSONObject2.put(obj4);
                }
            } else if (JSONObject.class.isAssignableFrom(type)) {
                if (obj2 instanceof JSONObject) {
                    jSONObject.put(name, obj2);
                    LogUtil.i("JsonUtil", "valueJsonObject " + obj2);
                    return;
                }
                return;
            } else {
                jSONObject2 = new JSONObject(toJson(obj2));
            }
            jSONObject.put(name, jSONObject2);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
    }

    public static String addEscapeChar(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '\t') {
                str2 = "\\t";
            } else if (charAt == '\n') {
                str2 = "\\n";
            } else if (charAt == '\r') {
                str2 = "\\r";
            } else if (charAt == '\"') {
                str2 = "\\\"";
            } else if (charAt != '\\') {
                sb.append(charAt);
            } else {
                str2 = "\\\\";
            }
            sb.append(str2);
        }
        return ((Object) sb) + "";
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) fromJson(new JSONObject(str), cls);
    }

    public static <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
        StringBuilder sb;
        try {
            T newInstance = cls.newInstance();
            List<Field> allFields = FieldUtil.getAllFields(cls);
            if (allFields != null && allFields.size() > 0) {
                for (Field field : allFields) {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    FieldUtil.fillField(jSONObject, newInstance, field);
                }
            }
            return newInstance;
        } catch (IllegalAccessException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append("e : ");
            sb.append(e);
            LogUtil.e(CommonConstants.TAG, sb.toString());
            return null;
        } catch (InstantiationException e5) {
            e = e5;
            sb = new StringBuilder();
            sb.append("e : ");
            sb.append(e);
            LogUtil.e(CommonConstants.TAG, sb.toString());
            return null;
        }
    }

    public static Object jsonArrayToArray(JSONArray jSONArray, Class<?> cls) {
        try {
            Class<?> componentType = cls.getComponentType();
            int length = jSONArray.length();
            Object newInstance = Array.newInstance(componentType, length);
            for (int i4 = 0; i4 < length; i4++) {
                Array.set(newInstance, i4, TypeUtil.isBasicType(componentType) ? jSONArray.get(i4) : fromJson(jSONArray.getJSONObject(i4), componentType));
            }
            return newInstance;
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.Object> jsonArrayToList(org.json.JSONArray r4, java.lang.Class r5, java.lang.reflect.Type r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L68
            int r1 = r4.length()
            if (r1 != 0) goto La
            goto L68
        La:
            boolean r1 = r6 instanceof java.lang.reflect.ParameterizedType     // Catch: java.lang.Exception -> L51
            if (r1 == 0) goto L68
            boolean r1 = r5.isInterface()     // Catch: java.lang.Exception -> L51
            if (r1 != 0) goto L1e
            int r1 = r5.getModifiers()     // Catch: java.lang.Exception -> L51
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch: java.lang.Exception -> L51
            if (r1 == 0) goto L20
        L1e:
            java.lang.Class<java.util.ArrayList> r5 = java.util.ArrayList.class
        L20:
            java.lang.Object r5 = r5.newInstance()     // Catch: java.lang.Exception -> L51
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L51
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6     // Catch: java.lang.Exception -> L51
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()     // Catch: java.lang.Exception -> L51
            r1 = 0
            r6 = r6[r1]     // Catch: java.lang.Exception -> L51
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.Exception -> L51
            int r2 = r4.length()     // Catch: java.lang.Exception -> L51
        L35:
            if (r1 >= r2) goto L50
            boolean r3 = xyz.adscope.common.json.util.TypeUtil.isBasicType(r6)     // Catch: java.lang.Exception -> L51
            if (r3 == 0) goto L42
            java.lang.Object r3 = r4.get(r1)     // Catch: java.lang.Exception -> L51
            goto L4a
        L42:
            org.json.JSONObject r3 = r4.getJSONObject(r1)     // Catch: java.lang.Exception -> L51
            java.lang.Object r3 = fromJson(r3, r6)     // Catch: java.lang.Exception -> L51
        L4a:
            r5.add(r3)     // Catch: java.lang.Exception -> L51
            int r1 = r1 + 1
            goto L35
        L50:
            return r5
        L51:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "e : "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "common_log"
            xyz.adscope.common.tool.LogUtil.e(r5, r4)
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.json.util.JsonUtil.jsonArrayToList(org.json.JSONArray, java.lang.Class, java.lang.reflect.Type):java.util.List");
    }

    public static String objectToJson(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            List<Field> allFields = FieldUtil.getAllFields(obj.getClass());
            if (allFields != null && allFields.size() > 0) {
                for (Field field : allFields) {
                    if (!Modifier.isPublic(field.getModifiers()) && field.getModifiers() == 2) {
                        field.setAccessible(true);
                    }
                    a(jSONObject, obj, field);
                }
            }
            return jSONObject.toString();
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            Class<?> cls = obj.getClass();
            if (TypeUtil.isBasicType(cls)) {
                return obj.toString();
            }
            if (List.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = new JSONArray();
                for (Object obj2 : (List) obj) {
                    jSONArray.put(new JSONObject(toJson(obj2)));
                }
                return jSONArray.toString();
            } else if (cls.isArray()) {
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj3 : (Object[]) obj) {
                    jSONArray2.put(new JSONObject(toJson(obj3)));
                }
                return jSONArray2.toString();
            } else {
                return objectToJson(obj);
            }
        } catch (JSONException e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return "";
        }
    }
}
