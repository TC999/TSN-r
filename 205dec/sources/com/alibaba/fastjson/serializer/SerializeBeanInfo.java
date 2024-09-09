package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SerializeBeanInfo {
    protected final Class<?> beanType;
    protected int features;
    protected final FieldInfo[] fields;
    protected final JSONType jsonType;
    protected final FieldInfo[] sortedFields;
    protected final String typeKey;
    protected final String typeName;

    public SerializeBeanInfo(Class<?> cls, JSONType jSONType, String str, String str2, int i4, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        this.beanType = cls;
        this.jsonType = jSONType;
        this.typeName = str;
        this.typeKey = str2;
        this.features = i4;
        this.fields = fieldInfoArr;
        this.sortedFields = fieldInfoArr2;
    }
}
