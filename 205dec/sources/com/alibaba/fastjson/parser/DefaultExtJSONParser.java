package com.alibaba.fastjson.parser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig) {
        super(str, parserConfig);
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig, int i4) {
        super(str, parserConfig, i4);
    }

    public DefaultExtJSONParser(char[] cArr, int i4, ParserConfig parserConfig, int i5) {
        super(cArr, i4, parserConfig, i5);
    }
}
