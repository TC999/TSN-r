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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    static boolean isSetFlag(int i4, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i5 = i4 / 32;
        int i6 = i4 % 32;
        if (i5 < iArr.length) {
            if (((1 << i6) & iArr[i5]) != 0) {
                return true;
            }
        }
        return false;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i4 = jSONLexerBase.token();
        if (i4 == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i4 != 14) {
            defaultJSONParser.throwException(i4);
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
        int i5 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i5)));
            i5++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i6 = jSONLexerBase.token();
        if (i6 != 15) {
            defaultJSONParser.throwException(i6);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }

    protected void check(JSONLexer jSONLexer, int i4) {
        if (jSONLexer.token() != i4) {
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
                            } catch (Exception e4) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e4);
                            }
                        }
                    }
                }
                return newInstance;
            } catch (JSONException e5) {
                throw e5;
            } catch (Exception e6) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e6);
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
            T t3 = (T) createInstance(defaultJSONParser, type);
            int i4 = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                if (i4 < length) {
                    char c4 = i4 == length + (-1) ? ']' : ',';
                    FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i4];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == Integer.TYPE) {
                        fieldDeserializer.setValue((Object) t3, jSONLexer.scanInt(c4));
                    } else if (cls == String.class) {
                        fieldDeserializer.setValue((Object) t3, jSONLexer.scanString(c4));
                    } else if (cls == Long.TYPE) {
                        fieldDeserializer.setValue(t3, jSONLexer.scanLong(c4));
                    } else if (cls.isEnum()) {
                        char current = jSONLexer.getCurrent();
                        if (current == '\"' || current == 'n') {
                            scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c4);
                        } else if (current >= '0' && current <= '9') {
                            scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c4));
                        } else {
                            scanEnum = scanEnum(jSONLexer, c4);
                        }
                        fieldDeserializer.setValue(t3, scanEnum);
                    } else if (cls == Boolean.TYPE) {
                        fieldDeserializer.setValue(t3, jSONLexer.scanBoolean(c4));
                    } else if (cls == Float.TYPE) {
                        fieldDeserializer.setValue(t3, Float.valueOf(jSONLexer.scanFloat(c4)));
                    } else if (cls == Double.TYPE) {
                        fieldDeserializer.setValue(t3, Double.valueOf(jSONLexer.scanDouble(c4)));
                    } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                        fieldDeserializer.setValue(t3, new Date(jSONLexer.scanLong(c4)));
                    } else {
                        jSONLexer.nextToken(14);
                        fieldDeserializer.setValue(t3, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
                        check(jSONLexer, c4 == ']' ? 15 : 16);
                    }
                    i4++;
                } else {
                    jSONLexer.nextToken(16);
                    return t3;
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

    public Type getFieldType(int i4) {
        return this.sortedFieldDeserializers[i4].fieldInfo.fieldType;
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

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i4) {
        return parseRest(defaultJSONParser, type, obj, obj2, i4, new int[0]);
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c4) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i4) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i4, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int i4 = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i4 <= length) {
            int i5 = (i4 + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i5].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i4 = i5 + 1;
            } else if (compareTo <= 0) {
                if (isSetFlag(i5, iArr)) {
                    return null;
                }
                return this.sortedFieldDeserializers[i5];
            } else {
                length = i5 - 1;
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

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i4, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i4, iArr);
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
        boolean z3;
        String str2 = null;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        int i4 = 0;
        if (fieldDeserializer == null) {
            boolean startsWith = str.startsWith("is");
            for (int i5 = 0; i5 < this.sortedFieldDeserializers.length; i5++) {
                if (!isSetFlag(i5, iArr)) {
                    FieldDeserializer fieldDeserializer2 = this.sortedFieldDeserializers[i5];
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
            int i6 = 0;
            while (true) {
                z3 = true;
                if (i6 >= str.length()) {
                    z3 = false;
                    break;
                }
                char charAt = str.charAt(i6);
                if (charAt == '_') {
                    str2 = str.replaceAll("_", "");
                    break;
                } else if (charAt == '-') {
                    str2 = str.replaceAll("-", "");
                    break;
                } else {
                    i6++;
                }
            }
            if (z3 && (fieldDeserializer = getFieldDeserializer(str2, iArr)) == null) {
                while (true) {
                    if (i4 >= this.sortedFieldDeserializers.length) {
                        break;
                    }
                    if (!isSetFlag(i4, iArr)) {
                        FieldDeserializer fieldDeserializer3 = this.sortedFieldDeserializers[i4];
                        if (fieldDeserializer3.fieldInfo.name.equalsIgnoreCase(str2)) {
                            fieldDeserializer = fieldDeserializer3;
                            break;
                        }
                    }
                    i4++;
                }
            }
        }
        return (fieldDeserializer != null || (map = this.alterNameFieldDeserializers) == null) ? fieldDeserializer : map.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:261:0x037f, code lost:
        r12 = r1;
        r1 = r17;
        r27 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0475, code lost:
        r1 = r16;
        r7 = r17;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0479, code lost:
        if (r12 != null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x047b, code lost:
        if (r1 != null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x047d, code lost:
        r1 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r24, r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0481, code lost:
        if (r7 != null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0483, code lost:
        r7 = r24.setContext(r14, r1, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0487, code lost:
        if (r7 == null) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0489, code lost:
        r7.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x048b, code lost:
        r24.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x048e, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x048f, code lost:
        r0 = r23.beanInfo.fields;
        r2 = r0.length;
        r3 = new java.lang.Object[r2];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0497, code lost:
        if (r4 >= r2) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0499, code lost:
        r5 = r0[r4];
        r6 = r1.get(r5.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x04a1, code lost:
        if (r6 != null) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x04a3, code lost:
        r5 = r5.fieldType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x04a7, code lost:
        if (r5 != java.lang.Byte.TYPE) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x04a9, code lost:
        r6 = java.lang.Byte.valueOf(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x04b0, code lost:
        if (r5 != java.lang.Short.TYPE) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x04b2, code lost:
        r6 = java.lang.Short.valueOf(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x04b9, code lost:
        if (r5 != java.lang.Integer.TYPE) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x04bb, code lost:
        r6 = java.lang.Integer.valueOf(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x04c2, code lost:
        if (r5 != java.lang.Long.TYPE) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x04c4, code lost:
        r6 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x04cd, code lost:
        if (r5 != java.lang.Float.TYPE) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x04cf, code lost:
        r6 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x04d7, code lost:
        if (r5 != java.lang.Double.TYPE) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x04d9, code lost:
        r6 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x04e2, code lost:
        if (r5 != java.lang.Boolean.TYPE) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x04e4, code lost:
        r6 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x04e6, code lost:
        r3[r4] = r6;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x04eb, code lost:
        r0 = r23.beanInfo;
        r1 = r0.creatorConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x04ef, code lost:
        if (r1 == null) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x04f1, code lost:
        r0 = r1.newInstance(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x04f5, code lost:
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x04f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0517, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r23.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0518, code lost:
        r0 = r0.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x051a, code lost:
        if (r0 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x051d, code lost:
        r0 = r0.invoke(null, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0522, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0542, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r23.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0543, code lost:
        r0 = r23.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0547, code lost:
        if (r0 != null) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0549, code lost:
        if (r7 == null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x054b, code lost:
        r7.object = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x054d, code lost:
        r24.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0550, code lost:
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0552, code lost:
        r0 = (T) r0.invoke(r12, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0558, code lost:
        if (r7 == null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x055a, code lost:
        r7.object = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x055c, code lost:
        r24.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x055f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0560, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0568, code lost:
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0569, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x056a, code lost:
        r13 = r7;
        r1 = (T) r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0235 A[Catch: all -> 0x05bd, TryCatch #6 {all -> 0x05bd, blocks: (B:71:0x00fb, B:73:0x0100, B:76:0x0112, B:81:0x0121, B:88:0x012f, B:186:0x0235, B:188:0x023f, B:190:0x024b, B:321:0x0483, B:193:0x0256, B:200:0x026a, B:202:0x0274, B:204:0x0280, B:222:0x02cb, B:224:0x02d6, B:229:0x02e6, B:230:0x02ed, B:205:0x0284, B:207:0x028c, B:210:0x0294, B:211:0x02a0, B:214:0x02a9, B:217:0x02af, B:220:0x02b4, B:221:0x02c0, B:231:0x02ee, B:232:0x0308, B:234:0x030b, B:238:0x0315, B:240:0x031f, B:242:0x0332, B:245:0x033b, B:247:0x0347, B:249:0x0359, B:251:0x0361, B:253:0x0365, B:258:0x0374, B:260:0x037c, B:263:0x0395, B:264:0x039d, B:236:0x0311, B:268:0x03a9, B:270:0x03af, B:271:0x03b9, B:273:0x03bf, B:93:0x013d, B:98:0x0147, B:103:0x0151, B:108:0x015b, B:110:0x0161, B:113:0x016f, B:115:0x0177, B:117:0x017b, B:125:0x0193, B:133:0x01a6, B:141:0x01b9, B:147:0x01c7, B:150:0x01d0, B:156:0x01e2, B:162:0x01f4, B:168:0x0206, B:174:0x0218), top: B:418:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03af A[Catch: all -> 0x05bd, TryCatch #6 {all -> 0x05bd, blocks: (B:71:0x00fb, B:73:0x0100, B:76:0x0112, B:81:0x0121, B:88:0x012f, B:186:0x0235, B:188:0x023f, B:190:0x024b, B:321:0x0483, B:193:0x0256, B:200:0x026a, B:202:0x0274, B:204:0x0280, B:222:0x02cb, B:224:0x02d6, B:229:0x02e6, B:230:0x02ed, B:205:0x0284, B:207:0x028c, B:210:0x0294, B:211:0x02a0, B:214:0x02a9, B:217:0x02af, B:220:0x02b4, B:221:0x02c0, B:231:0x02ee, B:232:0x0308, B:234:0x030b, B:238:0x0315, B:240:0x031f, B:242:0x0332, B:245:0x033b, B:247:0x0347, B:249:0x0359, B:251:0x0361, B:253:0x0365, B:258:0x0374, B:260:0x037c, B:263:0x0395, B:264:0x039d, B:236:0x0311, B:268:0x03a9, B:270:0x03af, B:271:0x03b9, B:273:0x03bf, B:93:0x013d, B:98:0x0147, B:103:0x0151, B:108:0x015b, B:110:0x0161, B:113:0x016f, B:115:0x0177, B:117:0x017b, B:125:0x0193, B:133:0x01a6, B:141:0x01b9, B:147:0x01c7, B:150:0x01d0, B:156:0x01e2, B:162:0x01f4, B:168:0x0206, B:174:0x0218), top: B:418:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03bf A[Catch: all -> 0x05bd, TRY_LEAVE, TryCatch #6 {all -> 0x05bd, blocks: (B:71:0x00fb, B:73:0x0100, B:76:0x0112, B:81:0x0121, B:88:0x012f, B:186:0x0235, B:188:0x023f, B:190:0x024b, B:321:0x0483, B:193:0x0256, B:200:0x026a, B:202:0x0274, B:204:0x0280, B:222:0x02cb, B:224:0x02d6, B:229:0x02e6, B:230:0x02ed, B:205:0x0284, B:207:0x028c, B:210:0x0294, B:211:0x02a0, B:214:0x02a9, B:217:0x02af, B:220:0x02b4, B:221:0x02c0, B:231:0x02ee, B:232:0x0308, B:234:0x030b, B:238:0x0315, B:240:0x031f, B:242:0x0332, B:245:0x033b, B:247:0x0347, B:249:0x0359, B:251:0x0361, B:253:0x0365, B:258:0x0374, B:260:0x037c, B:263:0x0395, B:264:0x039d, B:236:0x0311, B:268:0x03a9, B:270:0x03af, B:271:0x03b9, B:273:0x03bf, B:93:0x013d, B:98:0x0147, B:103:0x0151, B:108:0x015b, B:110:0x0161, B:113:0x016f, B:115:0x0177, B:117:0x017b, B:125:0x0193, B:133:0x01a6, B:141:0x01b9, B:147:0x01c7, B:150:0x01d0, B:156:0x01e2, B:162:0x01f4, B:168:0x0206, B:174:0x0218), top: B:418:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0429 A[Catch: all -> 0x05b8, TryCatch #3 {all -> 0x05b8, blocks: (B:392:0x0581, B:277:0x03d4, B:310:0x0460, B:313:0x046a, B:315:0x0472, B:387:0x056f, B:389:0x0577, B:393:0x058f, B:394:0x05ae, B:280:0x03e4, B:296:0x0411, B:298:0x041f, B:283:0x03f2, B:285:0x03f8, B:287:0x03fc, B:289:0x0400, B:291:0x0404, B:293:0x0408, B:294:0x040c, B:301:0x0429, B:303:0x0444, B:305:0x044c, B:308:0x0458, B:395:0x05af, B:396:0x05b7), top: B:414:0x0581 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x046a A[Catch: all -> 0x05b8, TryCatch #3 {all -> 0x05b8, blocks: (B:392:0x0581, B:277:0x03d4, B:310:0x0460, B:313:0x046a, B:315:0x0472, B:387:0x056f, B:389:0x0577, B:393:0x058f, B:394:0x05ae, B:280:0x03e4, B:296:0x0411, B:298:0x041f, B:283:0x03f2, B:285:0x03f8, B:287:0x03fc, B:289:0x0400, B:291:0x0404, B:293:0x0408, B:294:0x040c, B:301:0x0429, B:303:0x0444, B:305:0x044c, B:308:0x0458, B:395:0x05af, B:396:0x05b7), top: B:414:0x0581 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #2 {all -> 0x0045, blocks: (B:17:0x0035, B:19:0x003a, B:28:0x004f, B:30:0x005a, B:32:0x0060, B:38:0x006a, B:44:0x0079, B:49:0x0085, B:51:0x008f, B:55:0x0098, B:57:0x00a0, B:60:0x00aa, B:62:0x00cc, B:63:0x00d4, B:64:0x00e7, B:68:0x00ed), top: B:413:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x05c6  */
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
            Method dump skipped, instructions count: 1489
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
        for (int i4 = 0; i4 < length; i4++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i4];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i4] = createFieldDeserializer;
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
        for (int i5 = 0; i5 < length2; i5++) {
            this.fieldDeserializers[i5] = getFieldDeserializer(javaBeanInfo.fields[i5].name);
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
                } catch (Exception e4) {
                    throw new JSONException("build object error", e4);
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i4 = 0; i4 < length; i4++) {
            objArr[i4] = map.get(fieldInfoArr[i4].name);
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo2.creatorConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e5) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e5);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 != null) {
            try {
                return method2.invoke(null, objArr);
            } catch (Exception e6) {
                throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e6);
            }
        }
        return null;
    }
}
