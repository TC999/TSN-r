package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?>[] constructors;
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e6, code lost:
        if (r14 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e8, code lost:
        r13 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f4, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
        r13 = (T) createException(r5, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fa, code lost:
        if (r13 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
        r13 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0101, code lost:
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0103, code lost:
        ((java.lang.Throwable) r13).setStackTrace(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0106, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0107, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010f, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012b, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r14.getName());
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
