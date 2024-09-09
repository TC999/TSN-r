package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        Object obj3;
        int i5;
        boolean isEnabled = jSONSerializer.out.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter serializeWriter = jSONSerializer.out;
        Type collectionItemType = isEnabled ? TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            char c4 = ',';
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter.append('[');
                jSONSerializer.incrementIndent();
                int i6 = 0;
                for (Object obj4 : list) {
                    if (i6 != 0) {
                        serializeWriter.append(c4);
                    }
                    jSONSerializer.println();
                    if (obj4 != null) {
                        if (jSONSerializer.containsReference(obj4)) {
                            jSONSerializer.writeReference(obj4);
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj4.getClass());
                            jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            objectWriter.write(jSONSerializer, obj4, Integer.valueOf(i6), collectionItemType, 0);
                        }
                    } else {
                        jSONSerializer.out.writeNull();
                    }
                    i6++;
                    c4 = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.append(']');
                return;
            }
            serializeWriter.append('[');
            int size = list.size();
            for (int i7 = 0; i7 < size; i7 = i5 + 1) {
                Object obj5 = list.get(i7);
                if (i7 != 0) {
                    serializeWriter.append(',');
                }
                if (obj5 == null) {
                    serializeWriter.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj5).longValue();
                        if (isEnabled) {
                            serializeWriter.writeLong(longValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.writeLong(longValue);
                        }
                    } else {
                        if (serializeWriter.disableCircularReferenceDetect) {
                            obj3 = obj5;
                            i5 = i7;
                        } else {
                            obj3 = obj5;
                            i5 = i7;
                            jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                        }
                        if (jSONSerializer.containsReference(obj3)) {
                            jSONSerializer.writeReference(obj3);
                        } else {
                            jSONSerializer.getObjectWriter(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i5), collectionItemType, 0);
                        }
                    }
                }
                i5 = i7;
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
