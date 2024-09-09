package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JSONPDeserializer implements ObjectDeserializer {
    public static final JSONPDeserializer instance = new JSONPDeserializer();

    /* JADX WARN: Type inference failed for: r1v1, types: [com.alibaba.fastjson.JSONPObject, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        int i4;
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        String scanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
        jSONLexerBase.nextToken();
        int i5 = jSONLexerBase.token();
        if (i5 == 25) {
            String str = scanSymbolUnQuoted + ".";
            scanSymbolUnQuoted = str + jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            jSONLexerBase.nextToken();
            i5 = jSONLexerBase.token();
        }
        ?? r12 = (T) new JSONPObject(scanSymbolUnQuoted);
        if (i5 == 10) {
            jSONLexerBase.nextToken();
            while (true) {
                r12.addParameter(defaultJSONParser.parse());
                i4 = jSONLexerBase.token();
                if (i4 != 16) {
                    break;
                }
                jSONLexerBase.nextToken();
            }
            if (i4 == 11) {
                jSONLexerBase.nextToken();
                if (jSONLexerBase.token() == 24) {
                    jSONLexerBase.nextToken();
                }
                return r12;
            }
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }
}
