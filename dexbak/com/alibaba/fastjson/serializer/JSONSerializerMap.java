package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class JSONSerializerMap extends SerializeConfig {
    public final boolean put(Class<?> cls, ObjectSerializer objectSerializer) {
        return super.put((Type) cls, objectSerializer);
    }
}
