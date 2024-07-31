package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final Type itemType;

    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        Type type = fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
            this.itemType = type2;
            return;
        }
        this.itemType = Object.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i;
        int i2;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        int i3 = 0;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i2 = 0;
                    while (i2 < length) {
                        if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                            break;
                        }
                        i2++;
                    }
                }
                i2 = -1;
                if (i2 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i2];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        i = 0;
                        while (i < length2) {
                            if (cls.getTypeParameters()[i].getName().equals(typeVariable2.getName())) {
                                break;
                            }
                            i++;
                        }
                    }
                    i = -1;
                    if (i != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                        type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            if (objectDeserializer == null) {
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer;
                this.itemFastMatchToken = objectDeserializer.getFastMatchToken();
            }
            ObjectDeserializer objectDeserializer2 = objectDeserializer;
            jSONLexer.nextToken(this.itemFastMatchToken);
            while (true) {
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                if (jSONLexer.token() == 15) {
                    jSONLexer.nextToken(16);
                    return;
                }
                collection.add(objectDeserializer2.deserialze(defaultJSONParser, type2, Integer.valueOf(i3)));
                defaultJSONParser.checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(this.itemFastMatchToken);
                }
                i3++;
            }
        } else {
            if (objectDeserializer == null) {
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer;
            }
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
            defaultJSONParser.checkListResolve(collection);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i != 8 && (i != 4 || jSONLexer.stringVal().length() != 0)) {
            Collection arrayList = new ArrayList();
            ParseContext context = defaultJSONParser.getContext();
            defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
            parseArray(defaultJSONParser, type, arrayList);
            defaultJSONParser.setContext(context);
            if (obj == null) {
                map.put(this.fieldInfo.name, arrayList);
                return;
            } else {
                setValue(obj, arrayList);
                return;
            }
        }
        setValue(obj, (String) null);
    }
}
