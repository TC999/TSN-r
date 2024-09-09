package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i5 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i5 < iArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i5]);
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i5 < sArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i5]);
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i5 < jArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i5]);
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i5 < zArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i5]);
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i5 < fArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                float f4 = fArr[i5];
                if (Float.isNaN(f4)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f4));
                }
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            while (i5 < dArr.length) {
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                double d4 = dArr[i5];
                if (Double.isNaN(d4)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d4));
                }
                i5++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
        } else {
            serializeWriter.writeString(new String((char[]) obj));
        }
    }
}
