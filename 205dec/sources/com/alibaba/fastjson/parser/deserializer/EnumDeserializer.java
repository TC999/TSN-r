package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i4 = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i4 >= enumArr2.length) {
                break;
            }
            String name = enumArr2[i4].name();
            long j4 = -2128831035;
            for (int i5 = 0; i5 < name.length(); i5++) {
                j4 = (j4 ^ name.charAt(i5)) * 16777619;
            }
            jArr[i4] = j4;
            this.enumNameHashCodes[i4] = j4;
            i4++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i6 = 0; i6 < this.enumNameHashCodes.length; i6++) {
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                } else if (this.enumNameHashCodes[i6] == jArr[i7]) {
                    this.enums[i6] = this.ordinalEnums[i7];
                    break;
                } else {
                    i7++;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i4 = jSONLexer.token();
            if (i4 == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    Enum[] enumArr = this.ordinalEnums;
                    if (intValue <= enumArr.length) {
                        return (T) enumArr[intValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            } else if (i4 == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.enumClass, stringVal);
            } else if (i4 == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else {
                Object parse = defaultJSONParser.parse();
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + parse);
            }
        } catch (JSONException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new JSONException(e5.getMessage(), e5);
        }
    }

    public Enum getEnumByHashCode(long j4) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j4)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i4) {
        return this.ordinalEnums[i4];
    }
}
