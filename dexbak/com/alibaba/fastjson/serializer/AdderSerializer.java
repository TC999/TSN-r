package com.alibaba.fastjson.serializer;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof LongAdder) {
            serializeWriter.writeFieldValue('{', DomainCampaignEx.LOOPBACK_VALUE, ((LongAdder) obj).longValue());
            serializeWriter.write(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI);
        } else if (obj instanceof DoubleAdder) {
            serializeWriter.writeFieldValue('{', DomainCampaignEx.LOOPBACK_VALUE, ((DoubleAdder) obj).doubleValue());
            serializeWriter.write(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI);
        }
    }
}
