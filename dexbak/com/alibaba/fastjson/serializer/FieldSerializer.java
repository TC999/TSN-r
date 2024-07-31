package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FieldSerializer implements Comparable<FieldSerializer> {
    private final String double_quoted_fieldPrefix;
    protected int features;
    protected BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    protected boolean persistenceOneToMany;
    private RuntimeSerializerInfo runtimeInfo;
    protected boolean serializeUsing = false;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected final boolean writeNull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class RuntimeSerializerInfo {
        final ObjectSerializer fieldSerializer;
        final Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo) {
        boolean z;
        SerializerFeature[] serialzeFeatures;
        JSONType jSONType;
        SerializerFeature[] serialzeFeatures2;
        boolean z2 = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        this.persistenceOneToMany = false;
        this.fieldInfo = fieldInfo;
        this.fieldContext = new BeanContext(cls, fieldInfo);
        if (cls != null && fieldInfo.isEnum && (jSONType = (JSONType) cls.getAnnotation(JSONType.class)) != null) {
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
        }
        fieldInfo.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo.name + "\":";
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures3 = annotation.serialzeFeatures();
            int length = serialzeFeatures3.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ((serialzeFeatures3[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            String format = annotation.format();
            this.format = format;
            if (format.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature2 : annotation.serialzeFeatures()) {
                if (serializerFeature2 == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature2 == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
            this.features = SerializerFeature.m55841of(annotation.serialzeFeatures());
            z2 = z;
        }
        this.writeNull = z2;
        this.persistenceOneToMany = TypeUtils.isAnnotationPresentOneToMany(fieldInfo.method);
    }

    public Object getPropertyValue(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null || this.fieldInfo.fieldClass != Date.class) {
            return obj2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(obj2);
    }

    public Object getPropertyValueDirect(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.persistenceOneToMany && TypeUtils.isHibernateInitialized(obj2)) {
            return null;
        }
        return obj2;
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (serializeWriter.quoteFieldNames) {
            if (serializeWriter.useSingleQuotes) {
                if (this.single_quoted_fieldPrefix == null) {
                    this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
                }
                serializeWriter.write(this.single_quoted_fieldPrefix);
                return;
            }
            serializeWriter.write(this.double_quoted_fieldPrefix);
            return;
        }
        if (this.un_quoted_fieldPrefix == null) {
            this.un_quoted_fieldPrefix = this.fieldInfo.name + ":";
        }
        serializeWriter.write(this.un_quoted_fieldPrefix);
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        ObjectSerializer objectSerializer;
        Class<?> cls;
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls = this.fieldInfo.fieldClass;
            } else {
                cls = obj.getClass();
            }
            ObjectSerializer objectSerializer2 = null;
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.serializeUsing() != Void.class) {
                objectSerializer2 = (ObjectSerializer) annotation.serializeUsing().newInstance();
                this.serializeUsing = true;
            } else {
                if (this.format != null) {
                    if (cls != Double.TYPE && cls != Double.class) {
                        if (cls == Float.TYPE || cls == Float.class) {
                            objectSerializer2 = new FloatCodec(this.format);
                        }
                    } else {
                        objectSerializer2 = new DoubleSerializer(this.format);
                    }
                }
                if (objectSerializer2 == null) {
                    objectSerializer2 = jSONSerializer.getObjectWriter(cls);
                }
            }
            this.runtimeInfo = new RuntimeSerializerInfo(objectSerializer2, cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        FieldInfo fieldInfo = this.fieldInfo;
        int i = fieldInfo.serialzeFeatures;
        if (obj == null) {
            Class<?> cls2 = runtimeSerializerInfo.runtimeFieldClass;
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (Number.class.isAssignableFrom(cls2)) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullNumberAsZero.mask);
                return;
            } else if (String.class == cls2) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullStringAsEmpty.mask);
                return;
            } else if (Boolean.class == cls2) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullBooleanAsFalse.mask);
                return;
            } else if (Collection.class.isAssignableFrom(cls2)) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullListAsEmpty.mask);
                return;
            } else {
                ObjectSerializer objectSerializer3 = runtimeSerializerInfo.fieldSerializer;
                if (serializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES) && (objectSerializer3 instanceof JavaBeanSerializer)) {
                    serializeWriter.writeNull();
                    return;
                }
                FieldInfo fieldInfo2 = this.fieldInfo;
                objectSerializer3.write(jSONSerializer, null, fieldInfo2.name, fieldInfo2.fieldType, i);
                return;
            }
        }
        if (fieldInfo.isEnum) {
            if (this.writeEnumUsingName) {
                jSONSerializer.out.writeString(((Enum) obj).name());
                return;
            } else if (this.writeEnumUsingToString) {
                jSONSerializer.out.writeString(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls3 = obj.getClass();
        if (cls3 != runtimeSerializerInfo.runtimeFieldClass && !this.serializeUsing) {
            objectSerializer = jSONSerializer.getObjectWriter(cls3);
        } else {
            objectSerializer = runtimeSerializerInfo.fieldSerializer;
        }
        ObjectSerializer objectSerializer4 = objectSerializer;
        String str = this.format;
        if (str != null && !(objectSerializer4 instanceof DoubleSerializer) && !(objectSerializer4 instanceof FloatCodec)) {
            if (objectSerializer4 instanceof ContextObjectSerializer) {
                ((ContextObjectSerializer) objectSerializer4).write(jSONSerializer, obj, this.fieldContext);
                return;
            } else {
                jSONSerializer.writeWithFormat(obj, str);
                return;
            }
        }
        FieldInfo fieldInfo3 = this.fieldInfo;
        if (fieldInfo3.unwrapped) {
            if (objectSerializer4 instanceof JavaBeanSerializer) {
                ((JavaBeanSerializer) objectSerializer4).write(jSONSerializer, obj, fieldInfo3.name, fieldInfo3.fieldType, i, true);
                return;
            } else if (objectSerializer4 instanceof MapSerializer) {
                ((MapSerializer) objectSerializer4).write(jSONSerializer, obj, fieldInfo3.name, fieldInfo3.fieldType, i, true);
                return;
            }
        }
        objectSerializer4.write(jSONSerializer, obj, fieldInfo3.name, fieldInfo3.fieldType, i);
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }
}
