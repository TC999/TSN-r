package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = new TimeDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        long parseLong;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken(4);
            if (jSONLexer.token() == 4) {
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        return (T) new Time(longValue);
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error");
        }
        T t = (T) defaultJSONParser.parse();
        if (t == null) {
            return null;
        }
        if (t instanceof Time) {
            return t;
        }
        if (t instanceof Number) {
            return (T) new Time(((Number) t).longValue());
        }
        if (t instanceof String) {
            String str = (String) t;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            if (jSONScanner.scanISO8601DateIfMatch()) {
                parseLong = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= str.length()) {
                        z = true;
                        break;
                    }
                    char charAt = str.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i++;
                }
                if (!z) {
                    jSONScanner.close();
                    return (T) Time.valueOf(str);
                }
                parseLong = Long.parseLong(str);
            }
            jSONScanner.close();
            return (T) new Time(parseLong);
        }
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
