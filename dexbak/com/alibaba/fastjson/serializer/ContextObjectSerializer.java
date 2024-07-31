package com.alibaba.fastjson.serializer;

import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ContextObjectSerializer extends ObjectSerializer {
    void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException;
}
