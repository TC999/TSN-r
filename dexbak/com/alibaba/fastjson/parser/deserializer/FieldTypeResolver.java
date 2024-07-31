package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface FieldTypeResolver extends ParseProcess {
    Type resolve(Object obj, String str);
}
