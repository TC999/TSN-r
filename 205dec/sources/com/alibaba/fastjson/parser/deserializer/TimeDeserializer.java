package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
        T t3 = (T) defaultJSONParser.parse();
        if (t3 == null) {
            return null;
        }
        if (t3 instanceof Time) {
            return t3;
        }
        if (t3 instanceof Number) {
            return (T) new Time(((Number) t3).longValue());
        }
        if (t3 instanceof String) {
            String str = (String) t3;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            if (jSONScanner.scanISO8601DateIfMatch()) {
                parseLong = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                boolean z3 = false;
                int i4 = 0;
                while (true) {
                    if (i4 >= str.length()) {
                        z3 = true;
                        break;
                    }
                    char charAt = str.charAt(i4);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i4++;
                }
                if (!z3) {
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
