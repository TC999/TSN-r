package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class<Object>) Integer.class));
            if (castToInt == null) {
                return (T) OptionalInt.empty();
            }
            return (T) OptionalInt.of(castToInt.intValue());
        } else if (type == OptionalLong.class) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class<Object>) Long.class));
            if (castToLong == null) {
                return (T) OptionalLong.empty();
            }
            return (T) OptionalLong.of(castToLong.longValue());
        } else if (type == OptionalDouble.class) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class<Object>) Double.class));
            if (castToDouble == null) {
                return (T) OptionalDouble.empty();
            }
            return (T) OptionalDouble.of(castToDouble.doubleValue());
        } else {
            Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
            if (parseObject == null) {
                return (T) Optional.empty();
            }
            return (T) Optional.of(parseObject);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
        } else if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            jSONSerializer.write(optional.isPresent() ? optional.get() : null);
        } else if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                jSONSerializer.write(Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                jSONSerializer.writeNull();
            }
        } else if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                jSONSerializer.out.writeInt(optionalInt.getAsInt());
            } else {
                jSONSerializer.writeNull();
            }
        } else if (obj instanceof OptionalLong) {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (optionalLong.isPresent()) {
                jSONSerializer.out.writeLong(optionalLong.getAsLong());
            } else {
                jSONSerializer.writeNull();
            }
        } else {
            throw new JSONException("not support optional : " + obj.getClass());
        }
    }
}
