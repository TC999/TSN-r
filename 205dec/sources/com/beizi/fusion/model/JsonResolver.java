package com.beizi.fusion.model;

import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JsonResolver {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class TypeToken<T> {
        final Class<? super T> rawType;
        final Type type;

        /* JADX INFO: Access modifiers changed from: protected */
        public TypeToken() {
            Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
            this.type = superclassTypeParameter;
            this.rawType = (Class<? super T>) getRawType(superclassTypeParameter);
        }

        public static Type getInterfacesTypeParameter(Class<?> cls, Class<?> cls2) {
            Type[] genericInterfaces;
            for (Type type : cls.getGenericInterfaces()) {
                if ((type instanceof ParameterizedType) && cls2.isAssignableFrom(getRawType(type))) {
                    return ((ParameterizedType) type).getActualTypeArguments()[0];
                }
            }
            return null;
        }

        public static Type getSuperclassTypeParameter(Class<?> cls) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof Class)) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
            throw new RuntimeException("Missing type parameter.");
        }

        public Class<?> getRawType() {
            return this.rawType;
        }

        public Type getType() {
            return this.type;
        }

        public static Class<?> getRawType(Type type) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                throw new IllegalArgumentException();
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    return getRawType(((WildcardType) type).getUpperBounds()[0]);
                }
                String name = type == null ? "null" : type.getClass().getName();
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
            }
        }
    }

    private static void fillField(Object obj, Field field, JSONObject jSONObject) throws Exception {
        JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
        if (jsonNode != null) {
            String key = jsonNode.key();
            if (jSONObject.has(key)) {
                Class<?> type = field.getType();
                if (isBasicType(type)) {
                    Object obj2 = jSONObject.get(key);
                    jSONObject.remove(key);
                    try {
                        if (!isWrapType(type) && !String.class.isAssignableFrom(type)) {
                            field.set(obj, obj2);
                            return;
                        }
                        field.set(obj, type.getConstructor(String.class).newInstance(obj2.toString()));
                        return;
                    } catch (Exception unused) {
                        throw new JSONException("invalid value[" + obj2 + "] for field[" + field.getName() + "]; valueClass[" + obj2.getClass() + "]; annotationName[" + key + "]");
                    }
                }
                Object obj3 = jSONObject.get(key);
                if (obj3 == null || obj3.equals(null)) {
                    return;
                }
                if (List.class.isAssignableFrom(type)) {
                    field.set(obj, jsonArray2List(jSONObject.getJSONArray(key), type, field.getGenericType()));
                } else if (type.isArray()) {
                    field.set(obj, jsonArray2Array(jSONObject.getJSONArray(key), type));
                } else {
                    field.set(obj, fromJson(jSONObject.getJSONObject(key), type));
                }
            }
        }
    }

    private static void fillSuperFields(List<Field> list, Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (declaredFields.length > 0) {
                Collections.addAll(list, declaredFields);
                fillSuperFields(list, superclass);
            }
        }
    }

    public static <T> T fromJson(String str, Type type) throws Exception {
        if (type instanceof Class) {
            return (T) fromJson(new JSONObject(str), TypeToken.getRawType(type));
        }
        if (type instanceof ParameterizedType) {
            return (T) jsonArray2List(new JSONArray(str), TypeToken.getRawType(type), type);
        }
        if (type instanceof GenericArrayType) {
            return (T) jsonArray2Array(new JSONArray(str), TypeToken.getRawType(type));
        }
        String name = type == null ? "null" : type.getClass().getName();
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }

    private static List<Field> getAllFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        fillSuperFields(arrayList, cls);
        return arrayList;
    }

    public static boolean isBasicType(Class<?> cls) {
        if (cls.isPrimitive() || String.class.isAssignableFrom(cls)) {
            return true;
        }
        return isWrapType(cls);
    }

    public static boolean isWrapType(Class<?> cls) {
        return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
    }

    private static Object jsonArray2Array(JSONArray jSONArray, Class<?> cls) throws Exception {
        Object fromJson;
        Class<?> componentType = cls.getComponentType();
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(componentType, length);
        for (int i4 = 0; i4 < length; i4++) {
            if (isBasicType(componentType)) {
                fromJson = jSONArray.get(i4);
            } else {
                fromJson = fromJson(jSONArray.getJSONObject(i4), componentType);
            }
            Array.set(newInstance, i4, fromJson);
        }
        return newInstance;
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.Object> jsonArray2List(org.json.JSONArray r3, java.lang.Class r4, java.lang.reflect.Type r5) throws java.lang.Exception {
        /*
            if (r3 == 0) goto L4b
            boolean r0 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L4b
            boolean r0 = r4.isInterface()
            if (r0 != 0) goto L16
            int r0 = r4.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 == 0) goto L18
        L16:
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
        L18:
            java.lang.Object r4 = r4.newInstance()
            java.util.List r4 = (java.util.List) r4
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r0 = 0
            r5 = r5[r0]
            java.lang.Class r5 = (java.lang.Class) r5
            int r1 = r3.length()
        L2d:
            if (r0 >= r1) goto L4c
            boolean r2 = isBasicType(r5)
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r3.get(r0)
            r4.add(r2)
            goto L48
        L3d:
            org.json.JSONObject r2 = r3.getJSONObject(r0)
            java.lang.Object r2 = fromJson(r2, r5)
            r4.add(r2)
        L48:
            int r0 = r0 + 1
            goto L2d
        L4b:
            r4 = 0
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.model.JsonResolver.jsonArray2List(org.json.JSONArray, java.lang.Class, java.lang.reflect.Type):java.util.List");
    }

    private static String object2Json(Object obj) throws Exception {
        Object obj2;
        Object[] objArr;
        JSONObject jSONObject = new JSONObject();
        for (Field field : getAllFields(obj.getClass())) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
            if (jsonNode != null && (obj2 = field.get(obj)) != null) {
                String key = jsonNode.key();
                Class<?> type = field.getType();
                if (isBasicType(type)) {
                    if (!jSONObject.has(key)) {
                        jSONObject.put(key, obj2);
                    } else {
                        Log.w("JSON::", "class[" + field.getDeclaringClass().getSimpleName() + "] declares multiple JSON fields named name[" + key + "]..");
                    }
                } else if (List.class.isAssignableFrom(type)) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj3 : (List) obj2) {
                        if (isBasicType(obj3.getClass())) {
                            jSONArray.put(obj3);
                        } else {
                            jSONArray.put(new JSONObject(toJson(obj3)));
                        }
                    }
                    jSONObject.put(key, jSONArray);
                } else if (type.isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (Object obj4 : (Object[]) obj2) {
                        if (isBasicType(obj4.getClass())) {
                            jSONArray2.put(obj4);
                        } else {
                            jSONArray2.put(new JSONObject(toJson(obj4)));
                        }
                    }
                    jSONObject.put(key, jSONArray2);
                } else {
                    jSONObject.put(key, new JSONObject(toJson(obj2)));
                }
            }
        }
        return jSONObject.toString();
    }

    public static String toJson(Object obj) throws Exception {
        return toJson(obj, obj.getClass());
    }

    public static String toJson(Object obj, Class<?> cls) throws Exception {
        if (isBasicType(cls)) {
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
            return object2Json(obj);
        }
    }

    public static <T> T fromJson(String str, Class<T> cls) throws Exception {
        return (T) fromJson(new JSONObject(str), cls);
    }

    private static <T> T fromJson(JSONObject jSONObject, Class<T> cls) throws Exception {
        T newInstance = cls.newInstance();
        for (Field field : getAllFields(cls)) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                fillField(newInstance, field, jSONObject);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return newInstance;
    }
}
