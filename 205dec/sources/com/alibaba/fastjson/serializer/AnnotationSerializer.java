package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import sun.reflect.annotation.AnnotationType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AnnotationSerializer implements ObjectSerializer {
    public static AnnotationSerializer instance = new AnnotationSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Map members = AnnotationType.getInstance(interfaces[0]).members();
            JSONObject jSONObject = new JSONObject(members.size());
            Object obj3 = null;
            for (Map.Entry entry : members.entrySet()) {
                try {
                    obj3 = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
                jSONObject.put((String) entry.getKey(), JSON.toJSON(obj3));
            }
            jSONSerializer.write(jSONObject);
        }
    }
}
