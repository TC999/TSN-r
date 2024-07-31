package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0221 A[Catch: all -> 0x02b5, TryCatch #1 {all -> 0x02b5, blocks: (B:24:0x0044, B:25:0x0047, B:27:0x0053, B:38:0x0072, B:40:0x0083, B:41:0x0090, B:43:0x0096, B:45:0x00a8, B:48:0x00b0, B:51:0x00b5, B:53:0x00bf, B:55:0x00c3, B:58:0x00ce, B:61:0x00db, B:63:0x00df, B:66:0x00e7, B:69:0x00ec, B:71:0x00f6, B:73:0x00fa, B:76:0x0105, B:79:0x010f, B:81:0x0113, B:84:0x011b, B:87:0x0120, B:89:0x012a, B:91:0x012e, B:94:0x0139, B:97:0x0143, B:99:0x0147, B:102:0x014f, B:105:0x0154, B:107:0x015e, B:109:0x0162, B:112:0x016e, B:115:0x0179, B:117:0x017d, B:120:0x0185, B:123:0x018a, B:125:0x0194, B:127:0x0198, B:128:0x01a1, B:129:0x01a7, B:131:0x01ab, B:134:0x01b3, B:137:0x01b8, B:139:0x01c2, B:141:0x01c6, B:142:0x01cf, B:145:0x01d8, B:148:0x01dd, B:152:0x020e, B:155:0x021b, B:157:0x0221, B:159:0x0226, B:160:0x0229, B:162:0x0231, B:163:0x0234, B:177:0x0268, B:180:0x0271, B:182:0x0279, B:183:0x0287, B:165:0x023a, B:166:0x023d, B:168:0x0245, B:170:0x024d, B:173:0x0256, B:175:0x0261, B:174:0x025a, B:149:0x01f6, B:33:0x0067), top: B:200:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0268 A[Catch: all -> 0x02b5, TryCatch #1 {all -> 0x02b5, blocks: (B:24:0x0044, B:25:0x0047, B:27:0x0053, B:38:0x0072, B:40:0x0083, B:41:0x0090, B:43:0x0096, B:45:0x00a8, B:48:0x00b0, B:51:0x00b5, B:53:0x00bf, B:55:0x00c3, B:58:0x00ce, B:61:0x00db, B:63:0x00df, B:66:0x00e7, B:69:0x00ec, B:71:0x00f6, B:73:0x00fa, B:76:0x0105, B:79:0x010f, B:81:0x0113, B:84:0x011b, B:87:0x0120, B:89:0x012a, B:91:0x012e, B:94:0x0139, B:97:0x0143, B:99:0x0147, B:102:0x014f, B:105:0x0154, B:107:0x015e, B:109:0x0162, B:112:0x016e, B:115:0x0179, B:117:0x017d, B:120:0x0185, B:123:0x018a, B:125:0x0194, B:127:0x0198, B:128:0x01a1, B:129:0x01a7, B:131:0x01ab, B:134:0x01b3, B:137:0x01b8, B:139:0x01c2, B:141:0x01c6, B:142:0x01cf, B:145:0x01d8, B:148:0x01dd, B:152:0x020e, B:155:0x021b, B:157:0x0221, B:159:0x0226, B:160:0x0229, B:162:0x0231, B:163:0x0234, B:177:0x0268, B:180:0x0271, B:182:0x0279, B:183:0x0287, B:165:0x023a, B:166:0x023d, B:168:0x0245, B:170:0x024d, B:173:0x0256, B:175:0x0261, B:174:0x025a, B:149:0x01f6, B:33:0x0067), top: B:200:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0271 A[Catch: all -> 0x02b5, TryCatch #1 {all -> 0x02b5, blocks: (B:24:0x0044, B:25:0x0047, B:27:0x0053, B:38:0x0072, B:40:0x0083, B:41:0x0090, B:43:0x0096, B:45:0x00a8, B:48:0x00b0, B:51:0x00b5, B:53:0x00bf, B:55:0x00c3, B:58:0x00ce, B:61:0x00db, B:63:0x00df, B:66:0x00e7, B:69:0x00ec, B:71:0x00f6, B:73:0x00fa, B:76:0x0105, B:79:0x010f, B:81:0x0113, B:84:0x011b, B:87:0x0120, B:89:0x012a, B:91:0x012e, B:94:0x0139, B:97:0x0143, B:99:0x0147, B:102:0x014f, B:105:0x0154, B:107:0x015e, B:109:0x0162, B:112:0x016e, B:115:0x0179, B:117:0x017d, B:120:0x0185, B:123:0x018a, B:125:0x0194, B:127:0x0198, B:128:0x01a1, B:129:0x01a7, B:131:0x01ab, B:134:0x01b3, B:137:0x01b8, B:139:0x01c2, B:141:0x01c6, B:142:0x01cf, B:145:0x01d8, B:148:0x01dd, B:152:0x020e, B:155:0x021b, B:157:0x0221, B:159:0x0226, B:160:0x0229, B:162:0x0231, B:163:0x0234, B:177:0x0268, B:180:0x0271, B:182:0x0279, B:183:0x0287, B:165:0x023a, B:166:0x023d, B:168:0x0245, B:170:0x024d, B:173:0x0256, B:175:0x0261, B:174:0x025a, B:149:0x01f6, B:33:0x0067), top: B:200:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096 A[Catch: all -> 0x02b5, TryCatch #1 {all -> 0x02b5, blocks: (B:24:0x0044, B:25:0x0047, B:27:0x0053, B:38:0x0072, B:40:0x0083, B:41:0x0090, B:43:0x0096, B:45:0x00a8, B:48:0x00b0, B:51:0x00b5, B:53:0x00bf, B:55:0x00c3, B:58:0x00ce, B:61:0x00db, B:63:0x00df, B:66:0x00e7, B:69:0x00ec, B:71:0x00f6, B:73:0x00fa, B:76:0x0105, B:79:0x010f, B:81:0x0113, B:84:0x011b, B:87:0x0120, B:89:0x012a, B:91:0x012e, B:94:0x0139, B:97:0x0143, B:99:0x0147, B:102:0x014f, B:105:0x0154, B:107:0x015e, B:109:0x0162, B:112:0x016e, B:115:0x0179, B:117:0x017d, B:120:0x0185, B:123:0x018a, B:125:0x0194, B:127:0x0198, B:128:0x01a1, B:129:0x01a7, B:131:0x01ab, B:134:0x01b3, B:137:0x01b8, B:139:0x01c2, B:141:0x01c6, B:142:0x01cf, B:145:0x01d8, B:148:0x01dd, B:152:0x020e, B:155:0x021b, B:157:0x0221, B:159:0x0226, B:160:0x0229, B:162:0x0231, B:163:0x0234, B:177:0x0268, B:180:0x0271, B:182:0x0279, B:183:0x0287, B:165:0x023a, B:166:0x023d, B:168:0x0245, B:170:0x024d, B:173:0x0256, B:175:0x0261, B:174:0x025a, B:149:0x01f6, B:33:0x0067), top: B:200:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r21, java.lang.Object r22, java.lang.Object r23, java.lang.reflect.Type r24, int r25, boolean r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
