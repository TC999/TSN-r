package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() == 4) {
            if (str.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    return;
                }
                return;
            }
            throw new JSONException("type not match error");
        }
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) obj);
        }
        return obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj2 = parseContext != null ? parseContext.object : null;
            Object object = str.startsWith("$") ? getObject(str) : resolveTask.context.object;
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (object != null && object.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    object = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj2, object);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (Object.class.equals(type3)) {
                    if (wildcardType.getLowerBounds().length == 0) {
                        return parse();
                    }
                    throw new JSONException("not support type : " + type);
                }
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class) type3, (Collection) arrayList2);
                return arrayList2;
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        }
        throw new JSONException("not support type " + type);
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraTypeProvider : list) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor extraProcessor : list2) {
                extraProcessor.processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x020d, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0218, code lost:
        if (r5.token() != 13) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x021a, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x021d, code lost:
        r0 = r16.config.getDeserializer(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0225, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0227, code lost:
        r0 = ((com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0).createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r16, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x022e, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x022f, code lost:
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0233, code lost:
        if (r8 != java.lang.Cloneable.class) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0235, code lost:
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0241, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0243, code lost:
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0248, code lost:
        r0 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x024f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0250, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0258, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0259, code lost:
        setResolveStatus(2);
        r3 = r16.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x025f, code lost:
        if (r3 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0263, code lost:
        if ((r18 instanceof java.lang.Integer) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0269, code lost:
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026b, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0272, code lost:
        if (r17.size() <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0274, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r8, r16.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0280, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x028e, code lost:
        return r16.config.getDeserializer(r8).deserialze(r16, r8, r18);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:187:0x034e A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x037a A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03d6 A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04a1 A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04ba A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04c2 A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04c7 A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04dc A[Catch: all -> 0x0568, TRY_ENTER, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x04d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x03df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d7 A[Catch: all -> 0x0568, TryCatch #1 {all -> 0x0568, blocks: (B:18:0x0060, B:21:0x0073, B:25:0x008d, B:95:0x01d7, B:96:0x01dd, B:98:0x01e8, B:100:0x01f0, B:102:0x0201, B:104:0x020d, B:106:0x021a, B:107:0x021d, B:109:0x0227, B:114:0x0235, B:115:0x023b, B:117:0x0243, B:118:0x0248, B:122:0x0251, B:123:0x0258, B:124:0x0259, B:126:0x0261, B:128:0x0265, B:130:0x026b, B:131:0x026e, B:133:0x0274, B:136:0x0281, B:143:0x0296, B:145:0x029e, B:147:0x02a8, B:149:0x02b9, B:151:0x02bd, B:153:0x02c3, B:156:0x02c8, B:158:0x02cc, B:177:0x0316, B:179:0x031e, B:182:0x0327, B:183:0x032c, B:159:0x02cf, B:161:0x02d7, B:164:0x02dd, B:165:0x02e9, B:168:0x02f2, B:171:0x02f8, B:174:0x02fe, B:175:0x030a, B:184:0x032d, B:185:0x034b, B:187:0x034e, B:189:0x0352, B:191:0x0356, B:194:0x035c, B:198:0x0364, B:202:0x0371, B:206:0x037a, B:208:0x0389, B:210:0x0394, B:211:0x039c, B:212:0x039f, B:224:0x03cb, B:226:0x03d6, B:229:0x03e1, B:232:0x03f1, B:233:0x0411, B:219:0x03af, B:221:0x03b9, B:223:0x03c8, B:222:0x03be, B:236:0x0416, B:238:0x0420, B:240:0x0426, B:241:0x0429, B:243:0x0434, B:244:0x0438, B:246:0x0443, B:249:0x044a, B:252:0x0453, B:253:0x0458, B:256:0x045d, B:258:0x0462, B:262:0x046b, B:264:0x0478, B:266:0x047e, B:269:0x0484, B:271:0x048a, B:273:0x0492, B:276:0x04a1, B:279:0x04a9, B:280:0x04ab, B:282:0x04ba, B:285:0x04c7, B:286:0x04ca, B:288:0x04d2, B:291:0x04dc, B:294:0x04e6, B:295:0x04eb, B:296:0x04f0, B:297:0x050a, B:283:0x04c2, B:298:0x050b, B:300:0x051a, B:301:0x051e, B:303:0x0529, B:306:0x0530, B:309:0x053b, B:310:0x055b, B:28:0x009f, B:29:0x00bd, B:31:0x00c0, B:33:0x00cb, B:35:0x00cf, B:37:0x00d3, B:40:0x00d9, B:47:0x00e8, B:49:0x00f0, B:52:0x0100, B:53:0x0118, B:54:0x0119, B:55:0x011e, B:66:0x0133, B:67:0x0139, B:69:0x0140, B:72:0x014a, B:75:0x0152, B:76:0x016a, B:70:0x0145, B:77:0x016b, B:78:0x0183, B:84:0x018d, B:86:0x0195, B:89:0x01a6, B:90:0x01c6, B:91:0x01c7, B:92:0x01cc, B:93:0x01cd, B:311:0x055c, B:312:0x0561, B:313:0x0562, B:314:0x0567), top: B:320:0x0060, inners: #0, #2 }] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i != 12) {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i != 26) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken();
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken();
                        return Boolean.FALSE;
                    case 8:
                        jSONLexer.nextToken();
                        return null;
                    case 9:
                        jSONLexer.nextToken(18);
                        if (jSONLexer.token() == 18) {
                            jSONLexer.nextToken(10);
                            accept(10);
                            long longValue = jSONLexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, " + jSONLexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray(hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray(treeSet, obj);
                                return treeSet;
                            case 23:
                                jSONLexer.nextToken();
                                return null;
                            default:
                                throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                }
            } else {
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
            }
        } else {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i3];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i3 == typeArr.length - 1 && (type instanceof Class)) {
                                Class cls2 = (Class) type;
                                z = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z = false;
                            }
                            if (z && this.lexer.token() != i2) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, null);
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i2 = jSONLexer.token();
                    Number number = null;
                    number = null;
                    if (i2 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        number = integerValue;
                    } else if (i2 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        number = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i2 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        number = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            number = date;
                        }
                    } else if (i2 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        number = bool;
                    } else if (i2 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        number = bool2;
                    } else if (i2 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i2 == 12) {
                        number = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                    } else if (i2 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else {
                        if (i2 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i));
                            number = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                number = jSONArray.toArray();
                            }
                        } else if (i2 != 15) {
                            number = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(number);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i++;
                } finally {
                    setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos());
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }
}
