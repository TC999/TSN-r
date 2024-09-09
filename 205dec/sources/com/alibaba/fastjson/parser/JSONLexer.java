package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface JSONLexer {
    public static final int ARRAY = 2;
    public static final int END = 4;
    public static final char EOI = 26;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int OBJECT = 1;
    public static final int UNKNOWN = 0;
    public static final int VALUE = 3;
    public static final int VALUE_NULL = 5;

    byte[] bytesValue();

    void close();

    void config(Feature feature, boolean z3);

    Number decimalValue(boolean z3);

    BigDecimal decimalValue();

    float floatValue();

    char getCurrent();

    Locale getLocale();

    TimeZone getTimeZone();

    String info();

    int intValue();

    Number integerValue();

    boolean isBlankInput();

    boolean isEnabled(int i4);

    boolean isEnabled(Feature feature);

    boolean isRef();

    long longValue();

    char next();

    void nextToken();

    void nextToken(int i4);

    void nextTokenWithColon();

    void nextTokenWithColon(int i4);

    String numberString();

    int pos();

    void resetStringPosition();

    boolean scanBoolean(char c4);

    double scanDouble(char c4);

    Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c4);

    float scanFloat(char c4);

    int scanInt(char c4);

    long scanLong(char c4);

    void scanNumber();

    String scanString(char c4);

    void scanString();

    void scanStringArray(Collection<String> collection, char c4);

    String scanSymbol(SymbolTable symbolTable);

    String scanSymbol(SymbolTable symbolTable, char c4);

    String scanSymbolUnQuoted(SymbolTable symbolTable);

    String scanSymbolWithSeperator(SymbolTable symbolTable, char c4);

    void setLocale(Locale locale);

    void setTimeZone(TimeZone timeZone);

    void skipWhitespace();

    String stringVal();

    int token();

    String tokenName();
}
