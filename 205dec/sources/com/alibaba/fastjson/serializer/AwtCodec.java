package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AwtCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AwtCodec instance = new AwtCodec();

    private Object parseRef(DefaultJSONParser defaultJSONParser, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        lexer.nextTokenWithColon(4);
        String stringVal = lexer.stringVal();
        defaultJSONParser.setContext(defaultJSONParser.getContext(), obj);
        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(defaultJSONParser.getContext(), stringVal));
        defaultJSONParser.popContext();
        defaultJSONParser.setResolveStatus(1);
        lexer.nextToken(13);
        defaultJSONParser.accept(13);
        return null;
    }

    public static boolean support(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t3;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error");
        } else {
            jSONLexer.nextToken();
            if (type == Point.class) {
                t3 = (T) parsePoint(defaultJSONParser, obj);
            } else if (type == Rectangle.class) {
                t3 = (T) parseRectangle(defaultJSONParser);
            } else if (type == Color.class) {
                t3 = (T) parseColor(defaultJSONParser);
            } else if (type == Font.class) {
                t3 = (T) parseFont(defaultJSONParser);
            } else {
                throw new JSONException("not support awt class : " + type);
            }
            ParseContext context = defaultJSONParser.getContext();
            defaultJSONParser.setContext(t3, obj);
            defaultJSONParser.setContext(context);
            return t3;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    protected Color parseColor(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    int intValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                    if (stringVal.equalsIgnoreCase("r")) {
                        i4 = intValue;
                    } else if (stringVal.equalsIgnoreCase("g")) {
                        i5 = intValue;
                    } else if (stringVal.equalsIgnoreCase("b")) {
                        i6 = intValue;
                    } else if (!stringVal.equalsIgnoreCase("alpha")) {
                        throw new JSONException("syntax error, " + stringVal);
                    } else {
                        i7 = intValue;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Color(i4, i5, i6, i7);
    }

    protected Font parseFont(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                if (stringVal.equalsIgnoreCase("name")) {
                    if (jSONLexer.token() == 4) {
                        str = jSONLexer.stringVal();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (stringVal.equalsIgnoreCase("style")) {
                    if (jSONLexer.token() == 2) {
                        i4 = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (stringVal.equalsIgnoreCase("size")) {
                    if (jSONLexer.token() == 2) {
                        i5 = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else {
                    throw new JSONException("syntax error, " + stringVal);
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Font(str, i4, i5);
    }

    protected Point parsePoint(DefaultJSONParser defaultJSONParser, Object obj) {
        int floatValue;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        int i5 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                if (JSON.DEFAULT_TYPE_KEY.equals(stringVal)) {
                    defaultJSONParser.acceptType("java.awt.Point");
                } else if ("$ref".equals(stringVal)) {
                    return (Point) parseRef(defaultJSONParser, obj);
                } else {
                    jSONLexer.nextTokenWithColon(2);
                    int i6 = jSONLexer.token();
                    if (i6 == 2) {
                        floatValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else if (i6 == 3) {
                        floatValue = (int) jSONLexer.floatValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error : " + jSONLexer.tokenName());
                    }
                    if (stringVal.equalsIgnoreCase("x")) {
                        i4 = floatValue;
                    } else if (!stringVal.equalsIgnoreCase("y")) {
                        throw new JSONException("syntax error, " + stringVal);
                    } else {
                        i5 = floatValue;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Point(i4, i5);
    }

    protected Rectangle parseRectangle(DefaultJSONParser defaultJSONParser) {
        int floatValue;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                int i8 = jSONLexer.token();
                if (i8 == 2) {
                    floatValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                } else if (i8 == 3) {
                    floatValue = (int) jSONLexer.floatValue();
                    jSONLexer.nextToken();
                } else {
                    throw new JSONException("syntax error");
                }
                if (stringVal.equalsIgnoreCase("x")) {
                    i4 = floatValue;
                } else if (stringVal.equalsIgnoreCase("y")) {
                    i5 = floatValue;
                } else if (stringVal.equalsIgnoreCase("width")) {
                    i6 = floatValue;
                } else if (!stringVal.equalsIgnoreCase("height")) {
                    throw new JSONException("syntax error, " + stringVal);
                } else {
                    i7 = floatValue;
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Rectangle(i4, i5, i6, i7);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", point.x);
            serializeWriter.writeFieldValue(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", font.getName());
            serializeWriter.writeFieldValue(',', "style", font.getStyle());
            serializeWriter.writeFieldValue(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", rectangle.x);
            serializeWriter.writeFieldValue(',', "y", rectangle.y);
            serializeWriter.writeFieldValue(',', "width", rectangle.width);
            serializeWriter.writeFieldValue(',', "height", rectangle.height);
        } else if (obj instanceof Color) {
            Color color = (Color) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), "r", color.getRed());
            serializeWriter.writeFieldValue(',', "g", color.getGreen());
            serializeWriter.writeFieldValue(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.writeFieldValue(',', "alpha", color.getAlpha());
            }
        } else {
            throw new JSONException("not support awt class : " + obj.getClass().getName());
        }
        serializeWriter.write(125);
    }

    protected char writeClassName(SerializeWriter serializeWriter, Class<?> cls, char c4) {
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            serializeWriter.writeString(cls.getName());
            return ',';
        }
        return c4;
    }
}
