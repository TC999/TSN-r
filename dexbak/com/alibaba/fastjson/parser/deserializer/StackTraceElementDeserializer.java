package com.alibaba.fastjson.parser.deserializer;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01b0, code lost:
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
