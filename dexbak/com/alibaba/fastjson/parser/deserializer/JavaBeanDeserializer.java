package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }

    protected void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        FieldInfo[] fieldInfoArr;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method == null || javaBeanInfo.defaultConstructorParameterSize <= 0) {
            try {
                if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context != null && context.object != null) {
                        if (type instanceof Class) {
                            String name = ((Class) type).getName();
                            String substring = name.substring(0, name.lastIndexOf(36));
                            Object obj2 = context.object;
                            String name2 = obj2.getClass().getName();
                            if (!name2.equals(substring)) {
                                ParseContext parseContext = context.parent;
                                if (parseContext != null && parseContext.object != null && (("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2)) && parseContext.object.getClass().getName().equals(substring))) {
                                    obj = parseContext.object;
                                }
                                obj2 = obj;
                            }
                            if (obj2 != null) {
                                newInstance = constructor.newInstance(obj2);
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                } else if (constructor != null) {
                    newInstance = constructor.newInstance(new Object[0]);
                } else {
                    newInstance = method.invoke(null, new Object[0]);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(newInstance, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return newInstance;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T t = (T) createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                if (i < length) {
                    char c = i == length + (-1) ? ']' : StringUtil.COMMA;
                    FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == Integer.TYPE) {
                        fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
                    } else if (cls == String.class) {
                        fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
                    } else if (cls == Long.TYPE) {
                        fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
                    } else if (cls.isEnum()) {
                        char current = jSONLexer.getCurrent();
                        if (current == '\"' || current == 'n') {
                            scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                        } else if (current >= '0' && current <= '9') {
                            scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                        } else {
                            scanEnum = scanEnum(jSONLexer, c);
                        }
                        fieldDeserializer.setValue(t, scanEnum);
                    } else if (cls == Boolean.TYPE) {
                        fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
                    } else if (cls == Float.TYPE) {
                        fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
                    } else if (cls == Double.TYPE) {
                        fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
                    } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                        fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
                    } else {
                        jSONLexer.nextToken(14);
                        fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
                        check(jSONLexer, c == ']' ? 15 : 16);
                    }
                    i++;
                } else {
                    jSONLexer.nextToken(16);
                    return t;
                }
            }
        } else {
            throw new JSONException("error");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                if (isSetFlag(i2, iArr)) {
                    return null;
                }
                return this.sortedFieldDeserializers[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a3  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    protected Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanFieldSymbol = jSONLexerBase.scanFieldSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            return enumDeserializer.getEnumByHashCode(scanFieldSymbol);
        }
        return null;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        Map<String, FieldDeserializer> map;
        boolean z;
        String str2 = null;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        int i = 0;
        if (fieldDeserializer == null) {
            boolean startsWith = str.startsWith(UMCommonContent.f37801ae);
            for (int i2 = 0; i2 < this.sortedFieldDeserializers.length; i2++) {
                if (!isSetFlag(i2, iArr)) {
                    FieldDeserializer fieldDeserializer2 = this.sortedFieldDeserializers[i2];
                    FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                    if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                        return null;
                    }
                    Class<?> cls = fieldInfo.fieldClass;
                    String str3 = fieldInfo.name;
                    if (str3.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str3.equalsIgnoreCase(str.substring(2))))) {
                        fieldDeserializer = fieldDeserializer2;
                        break;
                    }
                }
            }
        }
        if (fieldDeserializer == null) {
            int i3 = 0;
            while (true) {
                z = true;
                if (i3 >= str.length()) {
                    z = false;
                    break;
                }
                char charAt = str.charAt(i3);
                if (charAt == '_') {
                    str2 = str.replaceAll("_", "");
                    break;
                } else if (charAt == '-') {
                    str2 = str.replaceAll("-", "");
                    break;
                } else {
                    i3++;
                }
            }
            if (z && (fieldDeserializer = getFieldDeserializer(str2, iArr)) == null) {
                while (true) {
                    if (i >= this.sortedFieldDeserializers.length) {
                        break;
                    }
                    if (!isSetFlag(i, iArr)) {
                        FieldDeserializer fieldDeserializer3 = this.sortedFieldDeserializers[i];
                        if (fieldDeserializer3.fieldInfo.name.equalsIgnoreCase(str2)) {
                            fieldDeserializer = fieldDeserializer3;
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        return (fieldDeserializer != null || (map = this.alterNameFieldDeserializers) == null) ? fieldDeserializer : map.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:316:0x0473, code lost:
        r1 = r16;
        r7 = r17;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x05ab, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r11.token()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0234 A[Catch: all -> 0x05b9, TryCatch #5 {all -> 0x05b9, blocks: (B:71:0x00fa, B:73:0x00ff, B:76:0x0111, B:81:0x0120, B:88:0x012e, B:186:0x0234, B:188:0x023e, B:190:0x024a, B:321:0x0481, B:193:0x0255, B:200:0x0269, B:202:0x0273, B:204:0x027f, B:222:0x02ca, B:224:0x02d5, B:229:0x02e5, B:230:0x02ec, B:205:0x0283, B:207:0x028b, B:210:0x0293, B:211:0x029f, B:214:0x02a8, B:217:0x02ae, B:220:0x02b3, B:221:0x02bf, B:231:0x02ed, B:232:0x0307, B:234:0x030a, B:238:0x0314, B:240:0x031e, B:242:0x0331, B:245:0x033a, B:247:0x0346, B:249:0x0358, B:251:0x0360, B:253:0x0364, B:258:0x0373, B:260:0x037b, B:263:0x0394, B:264:0x039b, B:236:0x0310, B:268:0x03a7, B:270:0x03ad, B:271:0x03b7, B:273:0x03bd, B:93:0x013c, B:98:0x0146, B:103:0x0150, B:108:0x015a, B:110:0x0160, B:113:0x016e, B:115:0x0176, B:117:0x017a, B:125:0x0192, B:133:0x01a5, B:141:0x01b8, B:147:0x01c6, B:150:0x01cf, B:156:0x01e1, B:162:0x01f3, B:168:0x0205, B:174:0x0217), top: B:416:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03ad A[Catch: all -> 0x05b9, TryCatch #5 {all -> 0x05b9, blocks: (B:71:0x00fa, B:73:0x00ff, B:76:0x0111, B:81:0x0120, B:88:0x012e, B:186:0x0234, B:188:0x023e, B:190:0x024a, B:321:0x0481, B:193:0x0255, B:200:0x0269, B:202:0x0273, B:204:0x027f, B:222:0x02ca, B:224:0x02d5, B:229:0x02e5, B:230:0x02ec, B:205:0x0283, B:207:0x028b, B:210:0x0293, B:211:0x029f, B:214:0x02a8, B:217:0x02ae, B:220:0x02b3, B:221:0x02bf, B:231:0x02ed, B:232:0x0307, B:234:0x030a, B:238:0x0314, B:240:0x031e, B:242:0x0331, B:245:0x033a, B:247:0x0346, B:249:0x0358, B:251:0x0360, B:253:0x0364, B:258:0x0373, B:260:0x037b, B:263:0x0394, B:264:0x039b, B:236:0x0310, B:268:0x03a7, B:270:0x03ad, B:271:0x03b7, B:273:0x03bd, B:93:0x013c, B:98:0x0146, B:103:0x0150, B:108:0x015a, B:110:0x0160, B:113:0x016e, B:115:0x0176, B:117:0x017a, B:125:0x0192, B:133:0x01a5, B:141:0x01b8, B:147:0x01c6, B:150:0x01cf, B:156:0x01e1, B:162:0x01f3, B:168:0x0205, B:174:0x0217), top: B:416:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03bd A[Catch: all -> 0x05b9, TRY_LEAVE, TryCatch #5 {all -> 0x05b9, blocks: (B:71:0x00fa, B:73:0x00ff, B:76:0x0111, B:81:0x0120, B:88:0x012e, B:186:0x0234, B:188:0x023e, B:190:0x024a, B:321:0x0481, B:193:0x0255, B:200:0x0269, B:202:0x0273, B:204:0x027f, B:222:0x02ca, B:224:0x02d5, B:229:0x02e5, B:230:0x02ec, B:205:0x0283, B:207:0x028b, B:210:0x0293, B:211:0x029f, B:214:0x02a8, B:217:0x02ae, B:220:0x02b3, B:221:0x02bf, B:231:0x02ed, B:232:0x0307, B:234:0x030a, B:238:0x0314, B:240:0x031e, B:242:0x0331, B:245:0x033a, B:247:0x0346, B:249:0x0358, B:251:0x0360, B:253:0x0364, B:258:0x0373, B:260:0x037b, B:263:0x0394, B:264:0x039b, B:236:0x0310, B:268:0x03a7, B:270:0x03ad, B:271:0x03b7, B:273:0x03bd, B:93:0x013c, B:98:0x0146, B:103:0x0150, B:108:0x015a, B:110:0x0160, B:113:0x016e, B:115:0x0176, B:117:0x017a, B:125:0x0192, B:133:0x01a5, B:141:0x01b8, B:147:0x01c6, B:150:0x01cf, B:156:0x01e1, B:162:0x01f3, B:168:0x0205, B:174:0x0217), top: B:416:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0427 A[Catch: all -> 0x05b4, TryCatch #2 {all -> 0x05b4, blocks: (B:392:0x057f, B:277:0x03d2, B:310:0x045e, B:313:0x0468, B:315:0x0470, B:387:0x056d, B:389:0x0575, B:393:0x058d, B:394:0x05ab, B:280:0x03e2, B:296:0x040f, B:298:0x041d, B:283:0x03f0, B:285:0x03f6, B:287:0x03fa, B:289:0x03fe, B:291:0x0402, B:293:0x0406, B:294:0x040a, B:301:0x0427, B:303:0x0442, B:305:0x044a, B:308:0x0456, B:395:0x05ac, B:396:0x05b3), top: B:413:0x057f }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0468 A[Catch: all -> 0x05b4, TryCatch #2 {all -> 0x05b4, blocks: (B:392:0x057f, B:277:0x03d2, B:310:0x045e, B:313:0x0468, B:315:0x0470, B:387:0x056d, B:389:0x0575, B:393:0x058d, B:394:0x05ab, B:280:0x03e2, B:296:0x040f, B:298:0x041d, B:283:0x03f0, B:285:0x03f6, B:287:0x03fa, B:289:0x03fe, B:291:0x0402, B:293:0x0406, B:294:0x040a, B:301:0x0427, B:303:0x0442, B:305:0x044a, B:308:0x0456, B:395:0x05ac, B:396:0x05b3), top: B:413:0x057f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #3 {all -> 0x0045, blocks: (B:17:0x0035, B:19:0x003a, B:28:0x004f, B:30:0x005a, B:32:0x0060, B:38:0x006a, B:44:0x0079, B:49:0x0085, B:51:0x008f, B:55:0x0098, B:57:0x00a0, B:60:0x00aa, B:62:0x00cb, B:63:0x00d3, B:64:0x00e6, B:68:0x00ec), top: B:414:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x05c2  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r24, java.lang.reflect.Type r25, java.lang.Object r26, java.lang.Object r27, int r28, int[] r29) {
        /*
            Method dump skipped, instructions count: 1485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        String[] strArr;
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                FieldDeserializer smartMatch = smartMatch(entry.getKey());
                if (smartMatch != null) {
                    smartMatch.setValue(createInstance, TypeUtils.cast(value, smartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method != null) {
                try {
                    return method.invoke(createInstance, new Object[0]);
                } catch (Exception e) {
                    throw new JSONException("build object error", e);
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = map.get(fieldInfoArr[i].name);
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo2.creatorConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 != null) {
            try {
                return method2.invoke(null, objArr);
            } catch (Exception e3) {
                throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e3);
            }
        }
        return null;
    }
}
