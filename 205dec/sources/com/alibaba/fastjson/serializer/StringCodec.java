package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static StringCodec instance = new StringCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == StringBuffer.class) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                return (T) new StringBuffer(stringVal);
            }
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (T) new StringBuffer(parse.toString());
        } else if (type == StringBuilder.class) {
            JSONLexer jSONLexer2 = defaultJSONParser.lexer;
            if (jSONLexer2.token() == 4) {
                String stringVal2 = jSONLexer2.stringVal();
                jSONLexer2.nextToken(16);
                return (T) new StringBuilder(stringVal2);
            }
            Object parse2 = defaultJSONParser.parse();
            if (parse2 == null) {
                return null;
            }
            return (T) new StringBuilder(parse2.toString());
        } else {
            return (T) deserialze(defaultJSONParser);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        write(jSONSerializer, (String) obj);
    }

    public void write(JSONSerializer jSONSerializer, String str) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (str == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            serializeWriter.writeString(str);
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 4) {
            T t3 = (T) lexer.stringVal();
            lexer.nextToken(16);
            return t3;
        } else if (lexer.token() == 2) {
            T t4 = (T) lexer.numberString();
            lexer.nextToken(16);
            return t4;
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (T) parse.toString();
        }
    }
}
