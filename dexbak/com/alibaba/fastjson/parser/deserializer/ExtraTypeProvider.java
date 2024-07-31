package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ExtraTypeProvider extends ParseProcess {
    Type getExtraType(Object obj, String str);
}
