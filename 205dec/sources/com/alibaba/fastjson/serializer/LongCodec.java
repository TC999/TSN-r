package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LongCodec implements ObjectSerializer, ObjectDeserializer {
    public static LongCodec instance = new LongCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object castToLong;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = jSONLexer.token();
        if (i4 == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            castToLong = (T) Long.valueOf(longValue);
        } else {
            if (i4 == 12) {
                JSONObject jSONObject = new JSONObject(true);
                defaultJSONParser.parseObject((Map) jSONObject);
                castToLong = (T) TypeUtils.castToLong(jSONObject);
            } else {
                castToLong = TypeUtils.castToLong(defaultJSONParser.parse());
            }
            if (castToLong == null) {
                return null;
            }
        }
        return type == AtomicLong.class ? (T) new AtomicLong(((Long) castToLong).longValue()) : (T) castToLong;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        long longValue = ((Long) obj).longValue();
        serializeWriter.writeLong(longValue);
        if (!serializeWriter.isEnabled(SerializerFeature.WriteClassName) || longValue > 2147483647L || longValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        serializeWriter.write(76);
    }
}
