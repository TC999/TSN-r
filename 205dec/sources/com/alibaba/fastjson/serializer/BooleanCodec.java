package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = new BooleanCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t3;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 6) {
            jSONLexer.nextToken(16);
            t3 = (T) Boolean.TRUE;
        } else if (jSONLexer.token() == 7) {
            jSONLexer.nextToken(16);
            t3 = (T) Boolean.FALSE;
        } else if (jSONLexer.token() == 2) {
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken(16);
            if (intValue == 1) {
                t3 = (T) Boolean.TRUE;
            } else {
                t3 = (T) Boolean.FALSE;
            }
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            t3 = (T) TypeUtils.castToBoolean(parse);
        }
        return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) t3).booleanValue()) : t3;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 6;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write("false");
        }
    }
}
