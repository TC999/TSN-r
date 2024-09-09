package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.math.BigDecimal, T, java.lang.Object] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type != Double.TYPE && type != Double.class) {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                if (type == Short.TYPE || type == Short.class) {
                    if (longValue <= 32767 && longValue >= -32768) {
                        return (T) Short.valueOf((short) longValue);
                    }
                    throw new JSONException("short overflow : " + longValue);
                } else if (type != Byte.TYPE && type != Byte.class) {
                    if (longValue >= -2147483648L && longValue <= 2147483647L) {
                        return (T) Integer.valueOf((int) longValue);
                    }
                    return (T) Long.valueOf(longValue);
                } else if (longValue <= 127 && longValue >= -128) {
                    return (T) Byte.valueOf((byte) longValue);
                } else {
                    throw new JSONException("short overflow : " + longValue);
                }
            }
            String numberString = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString));
        } else if (jSONLexer.token() == 3) {
            if (type != Double.TYPE && type != Double.class) {
                ?? r13 = (T) jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                if (type != Short.TYPE && type != Short.class) {
                    return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r13.byteValue()) : r13;
                } else if (r13.compareTo(BigDecimal.valueOf(32767L)) <= 0 && r13.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                    return (T) Short.valueOf(r13.shortValue());
                } else {
                    throw new JSONException("short overflow : " + ((Object) r13));
                }
            }
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString2));
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            if (type != Double.TYPE && type != Double.class) {
                if (type != Short.TYPE && type != Short.class) {
                    if (type != Byte.TYPE && type != Byte.class) {
                        return (T) TypeUtils.castToBigDecimal(parse);
                    }
                    return (T) TypeUtils.castToByte(parse);
                }
                return (T) TypeUtils.castToShort(parse);
            }
            return (T) TypeUtils.castToDouble(parse);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
