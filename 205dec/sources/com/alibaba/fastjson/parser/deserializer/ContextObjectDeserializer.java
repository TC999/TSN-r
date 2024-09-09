package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class ContextObjectDeserializer implements ObjectDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    public abstract <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i4);
}
