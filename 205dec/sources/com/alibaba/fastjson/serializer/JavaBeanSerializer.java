package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            for (LabelFilter labelFilter : list) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 != null) {
            for (LabelFilter labelFilter2 : list2) {
                if (!labelFilter2.apply(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    protected BeanContext getBeanContext(int i4) {
        return this.sortedGetters[i4].fieldContext;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i4 = 0;
        int length = this.sortedGetters.length - 1;
        while (i4 <= length) {
            int i5 = (i4 + length) >>> 1;
            int compareTo = this.sortedGetters[i5].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i4 = i5 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i5];
            } else {
                length = i5 - 1;
            }
        }
        return null;
    }

    protected Type getFieldType(int i4) {
        return this.sortedGetters[i4].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e4) {
                throw new JSONException("getFieldValue error." + str, e4);
            } catch (InvocationTargetException e5) {
                throw new JSONException("getFieldValue error." + str, e5);
            }
        }
        throw new JSONException("field not found. " + str);
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i4 = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i4++;
            }
        }
        return i4;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        write(jSONSerializer, obj, obj2, type, i4, false);
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            for (AfterFilter afterFilter : list) {
                c4 = afterFilter.writeAfter(jSONSerializer, obj, c4);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            for (AfterFilter afterFilter2 : list2) {
                c4 = afterFilter2.writeAfter(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            for (BeforeFilter beforeFilter : list) {
                c4 = beforeFilter.writeBefore(jSONSerializer, obj, c4);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            for (BeforeFilter beforeFilter2 : list2) {
                c4 = beforeFilter2.writeBefore(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i4) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i5 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext != null && (serialContext.features & i5) == 0 && (i4 & i5) == 0 && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i4) {
        int i5 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i5) == 0 && !jSONSerializer.out.beanToArray && (i4 & i5) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0158, code lost:
        if ((r25.beanInfo.features & r3) == 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c9, code lost:
        if (r10.fieldTransient != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0320 A[Catch: all -> 0x0358, TryCatch #5 {all -> 0x0358, blocks: (B:236:0x02fd, B:238:0x0320, B:239:0x0334, B:241:0x033a, B:242:0x0352, B:243:0x0357), top: B:256:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x033a A[Catch: all -> 0x0358, TryCatch #5 {all -> 0x0358, blocks: (B:236:0x02fd, B:238:0x0320, B:239:0x0334, B:241:0x033a, B:242:0x0352, B:243:0x0357), top: B:256:0x02fd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r26, java.lang.Object r27, java.lang.Object r28, java.lang.reflect.Type r29, int r30, boolean r31) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 862
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i5 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i5] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i5]);
            i5++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
            return;
        }
        this.getters = new FieldSerializer[fieldInfoArr.length];
        while (true) {
            FieldSerializer[] fieldSerializerArr2 = this.getters;
            if (i4 >= fieldSerializerArr2.length) {
                return;
            }
            fieldSerializerArr2[i4] = getFieldSerializer(serializeBeanInfo.fields[i4].name);
            i4++;
        }
    }
}
