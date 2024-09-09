package xyz.adscope.common.json.util;

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
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.json.inter.JsonNode;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class JsonResolver {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class TypeToken<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? super T> f64756a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f64757b;

        public TypeToken() {
            Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
            this.f64757b = superclassTypeParameter;
            this.f64756a = (Class<? super T>) getRawType(superclassTypeParameter);
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

        public static Type getSuperclassTypeParameter(Class<?> cls) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof Class) {
                throw new RuntimeException("Missing type parameter.");
            }
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }

        public Class<?> getRawType() {
            return this.f64756a;
        }

        public Type getType() {
            return this.f64757b;
        }
    }

    public static Object a(JSONArray jSONArray, Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(componentType, length);
        for (int i4 = 0; i4 < length; i4++) {
            Array.set(newInstance, i4, isBasicType(componentType) ? jSONArray.get(i4) : a(jSONArray.getJSONObject(i4), componentType));
        }
        return newInstance;
    }

    public static <T> T a(JSONObject jSONObject, Class<T> cls) {
        T newInstance = cls.newInstance();
        for (Field field : a((Class<?>) cls)) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                a(newInstance, field, jSONObject);
            } catch (JSONException e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v12, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r2v14, types: [org.json.JSONArray] */
    public static String a(Object obj) {
        Object obj2;
        Object jSONObject;
        Object[] objArr;
        JSONObject jSONObject2 = new JSONObject();
        for (Field field : a(obj.getClass())) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
            if (jsonNode != null && (obj2 = field.get(obj)) != null) {
                String key = jsonNode.key();
                Class<?> type = field.getType();
                if (!isBasicType(type)) {
                    if (List.class.isAssignableFrom(type)) {
                        jSONObject = new JSONArray();
                        for (Object obj3 : (List) obj2) {
                            if (isBasicType(obj3.getClass())) {
                                jSONObject.put(obj3);
                            } else {
                                jSONObject.put(new JSONObject(toJson(obj3)));
                            }
                        }
                    } else if (type.isArray()) {
                        jSONObject = new JSONArray();
                        for (Object obj4 : (Object[]) obj2) {
                            if (isBasicType(obj4.getClass())) {
                                jSONObject.put(obj4);
                            } else {
                                jSONObject.put(new JSONObject(toJson(obj4)));
                            }
                        }
                    } else {
                        jSONObject = new JSONObject(toJson(obj2));
                    }
                    jSONObject2.put(key, jSONObject);
                } else if (jSONObject2.has(key)) {
                    LogUtil.d("JSON::", "class[" + field.getDeclaringClass().getSimpleName() + "] declares multiple JSON fields named name[" + key + "]..");
                } else {
                    jSONObject2.put(key, obj2);
                }
            }
        }
        return jSONObject2.toString();
    }

    public static List<Field> a(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cls.getDeclaredFields());
        a(arrayList, cls);
        return arrayList;
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.Object> a(org.json.JSONArray r3, java.lang.Class r4, java.lang.reflect.Type r5) {
        /*
            if (r3 == 0) goto L48
            boolean r0 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L48
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
            if (r0 >= r1) goto L49
            boolean r2 = isBasicType(r5)
            if (r2 == 0) goto L3a
            java.lang.Object r2 = r3.get(r0)
            goto L42
        L3a:
            org.json.JSONObject r2 = r3.getJSONObject(r0)
            java.lang.Object r2 = a(r2, r5)
        L42:
            r4.add(r2)
            int r0 = r0 + 1
            goto L2d
        L48:
            r4 = 0
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.json.util.JsonResolver.a(org.json.JSONArray, java.lang.Class, java.lang.reflect.Type):java.util.List");
    }

    public static void a(Object obj, Field field, JSONObject jSONObject) {
        JsonNode jsonNode = (JsonNode) field.getAnnotation(JsonNode.class);
        if (jsonNode != null) {
            String key = jsonNode.key();
            if (jSONObject.has(key)) {
                Class<?> type = field.getType();
                if (!isBasicType(type)) {
                    Object obj2 = jSONObject.get(key);
                    if (obj2 == null || obj2.equals(null)) {
                        return;
                    }
                    field.set(obj, List.class.isAssignableFrom(type) ? a(jSONObject.getJSONArray(key), type, field.getGenericType()) : type.isArray() ? a(jSONObject.getJSONArray(key), type) : a(jSONObject.getJSONObject(key), type));
                    return;
                }
                Object obj3 = jSONObject.get(key);
                jSONObject.remove(key);
                try {
                    if (!isWrapType(type) && !String.class.isAssignableFrom(type)) {
                        field.set(obj, obj3);
                    }
                    field.set(obj, type.getConstructor(String.class).newInstance(obj3.toString()));
                } catch (Exception unused) {
                    throw new JSONException("invalid value[" + obj3 + "] for field[" + field.getName() + "]; valueClass[" + obj3.getClass() + "]; annotationName[" + key + "]");
                }
            }
        }
    }

    public static void a(List<Field> list, Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (declaredFields.length > 0) {
                Collections.addAll(list, declaredFields);
                a(list, superclass);
            }
        }
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) a(new JSONObject(str), cls);
    }

    public static <T> T fromJson(String str, Type type) {
        if (type instanceof Class) {
            return (T) a(new JSONObject(str), TypeToken.getRawType(type));
        }
        if (type instanceof ParameterizedType) {
            return (T) a(new JSONArray(str), TypeToken.getRawType(type), type);
        }
        if (type instanceof GenericArrayType) {
            return (T) a(new JSONArray(str), TypeToken.getRawType(type));
        }
        String name = type == null ? "null" : type.getClass().getName();
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
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

    public static String toJson(Object obj) {
        return toJson(obj, obj.getClass());
    }

    public static String toJson(Object obj, Class<?> cls) {
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
            return a(obj);
        }
    }
}
