package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i == 2) {
            try {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                t = (T) Integer.valueOf(intValue);
            } catch (NumberFormatException e) {
                throw new JSONException("int value overflow, field : " + obj, e);
            }
        } else if (i == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            t = (T) Integer.valueOf(decimalValue.intValue());
        } else if (i == 12) {
            JSONObject jSONObject = new JSONObject(true);
            defaultJSONParser.parseObject((Map) jSONObject);
            t = (T) TypeUtils.castToInt(jSONObject);
        } else {
            t = (T) TypeUtils.castToInt(defaultJSONParser.parse());
        }
        return type == AtomicInteger.class ? (T) new AtomicInteger(((Integer) t).intValue()) : t;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
            } else if (cls == Short.class) {
                serializeWriter.write(83);
            }
        }
    }
}
