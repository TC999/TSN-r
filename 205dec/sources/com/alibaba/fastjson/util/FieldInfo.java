package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final char[] name_chars;
    private int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i4, int i5, int i6) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i4;
        this.serialzeFeatures = i5;
        this.parserFeatures = 0;
        this.isEnum = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            int i7 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        this.label = "";
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new String[0];
    }

    private static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z3 = false;
        for (int i4 = 0; i4 < typeArr.length; i4++) {
            Type type = typeArr[i4];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i4] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z3 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i5 = 0; i5 < typeVariableArr.length; i5++) {
                    if (type.equals(typeVariableArr[i5])) {
                        typeArr[i4] = typeArr2[i5];
                        z3 = true;
                    }
                }
            }
        }
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type getFieldType(java.lang.Class<?> r7, java.lang.reflect.Type r8, java.lang.reflect.Type r9) {
        /*
            if (r7 == 0) goto Lab
            if (r8 != 0) goto L6
            goto Lab
        L6:
            boolean r0 = r9 instanceof java.lang.reflect.GenericArrayType
            r1 = 0
            if (r0 == 0) goto L26
            r0 = r9
            java.lang.reflect.GenericArrayType r0 = (java.lang.reflect.GenericArrayType) r0
            java.lang.reflect.Type r0 = r0.getGenericComponentType()
            java.lang.reflect.Type r7 = getFieldType(r7, r8, r0)
            if (r0 == r7) goto L25
            java.lang.Class r7 = com.alibaba.fastjson.util.TypeUtils.getClass(r7)
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r1)
            java.lang.Class r7 = r7.getClass()
            return r7
        L25:
            return r9
        L26:
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.isGenericParamType(r8)
            if (r0 != 0) goto L2d
            return r9
        L2d:
            boolean r0 = r9 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L5f
            java.lang.reflect.Type r0 = com.alibaba.fastjson.util.TypeUtils.getGenericParamType(r8)
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r0)
            r3 = r9
            java.lang.reflect.TypeVariable r3 = (java.lang.reflect.TypeVariable) r3
            java.lang.reflect.TypeVariable[] r2 = r2.getTypeParameters()
        L42:
            int r4 = r2.length
            if (r1 >= r4) goto L5f
            r4 = r2[r1]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = r3.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L5c
            java.lang.reflect.Type[] r7 = r0.getActualTypeArguments()
            r7 = r7[r1]
            return r7
        L5c:
            int r1 = r1 + 1
            goto L42
        L5f:
            boolean r0 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto Lab
            r0 = r9
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r1 = r0.getActualTypeArguments()
            boolean r2 = r8 instanceof java.lang.reflect.ParameterizedType
            r3 = 0
            if (r2 == 0) goto L7a
            r3 = r8
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.TypeVariable[] r7 = r7.getTypeParameters()
        L76:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L93
        L7a:
            java.lang.reflect.Type r8 = r7.getGenericSuperclass()
            boolean r8 = r8 instanceof java.lang.reflect.ParameterizedType
            if (r8 == 0) goto L92
            java.lang.reflect.Type r8 = r7.getGenericSuperclass()
            r3 = r8
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.Class r7 = r7.getSuperclass()
            java.lang.reflect.TypeVariable[] r7 = r7.getTypeParameters()
            goto L76
        L92:
            r7 = r3
        L93:
            java.lang.reflect.Type[] r7 = r7.getActualTypeArguments()
            boolean r7 = getArgument(r1, r3, r7)
            if (r7 == 0) goto Lab
            com.alibaba.fastjson.util.ParameterizedTypeImpl r7 = new com.alibaba.fastjson.util.ParameterizedTypeImpl
            java.lang.reflect.Type r8 = r0.getOwnerType()
            java.lang.reflect.Type r9 = r0.getRawType()
            r7.<init>(r1, r8, r9)
            return r7
        Lab:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.getFieldType(java.lang.Class, java.lang.reflect.Type, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    private static Type getInheritGenericType(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] typeArr;
        Class<?> cls2 = (Class) typeVariable.getGenericDeclaration();
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr2 = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    getArgument(actualTypeArguments, cls.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls = cls.getSuperclass();
            }
            typeArr = typeArr2;
        }
        if (typeArr == null) {
            return null;
        }
        TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
        for (int i4 = 0; i4 < typeParameters.length; i4++) {
            if (typeVariable.equals(typeParameters[i4])) {
                return typeArr[i4];
            }
        }
        return null;
    }

    protected char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[length + 3];
        String str = this.name;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.field.get(obj);
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        Field field;
        if (cls == JSONField.class) {
            return getAnnotation();
        }
        T t3 = null;
        Method method = this.method;
        if (method != null) {
            t3 = (T) method.getAnnotation(cls);
        }
        return (t3 != null || (field = this.field) == null) ? t3 : (T) field.getAnnotation(cls);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    protected Class<?> getDeclaredClass() {
        Method method = this.method;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.field;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String getFormat() {
        return this.format;
    }

    public Member getMember() {
        Method method = this.method;
        return method != null ? method : this.field;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public void setAccessible() throws SecurityException {
        Method method = this.method;
        if (method != null) {
            TypeUtils.setAccessible(method);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        int i4 = this.ordinal;
        int i5 = fieldInfo.ordinal;
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        int compareTo = this.name.compareTo(fieldInfo.name);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> declaredClass = getDeclaredClass();
        Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
        if (declaredClass != null && declaredClass2 != null && declaredClass != declaredClass2) {
            if (declaredClass.isAssignableFrom(declaredClass2)) {
                return -1;
            }
            if (declaredClass2.isAssignableFrom(declaredClass)) {
                return 1;
            }
        }
        Field field = this.field;
        boolean z3 = false;
        boolean z4 = field != null && field.getType() == this.fieldClass;
        Field field2 = fieldInfo.field;
        if (field2 != null && field2.getType() == fieldInfo.fieldClass) {
            z3 = true;
        }
        if (!z4 || z3) {
            if (!z3 || z4) {
                if (!fieldInfo.fieldClass.isPrimitive() || this.fieldClass.isPrimitive()) {
                    if (!this.fieldClass.isPrimitive() || fieldInfo.fieldClass.isPrimitive()) {
                        if (!fieldInfo.fieldClass.getName().startsWith("java.") || this.fieldClass.getName().startsWith("java.")) {
                            if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
                                return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
                            }
                            return -1;
                        }
                        return 1;
                    }
                    return -1;
                }
                return 1;
            }
            return -1;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (r9.equals(r14) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FieldInfo(java.lang.String r14, java.lang.reflect.Method r15, java.lang.reflect.Field r16, java.lang.Class<?> r17, java.lang.reflect.Type r18, int r19, int r20, int r21, com.alibaba.fastjson.annotation.JSONField r22, com.alibaba.fastjson.annotation.JSONField r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, int, com.alibaba.fastjson.annotation.JSONField, com.alibaba.fastjson.annotation.JSONField, java.lang.String):void");
    }
}
