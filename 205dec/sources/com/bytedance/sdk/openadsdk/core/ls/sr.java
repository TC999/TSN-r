package com.bytedance.sdk.openadsdk.core.ls;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends ev {
    public sr(Result result, int i4) {
        super(result, i4);
    }

    public boolean c() {
        if (xv() != null) {
            return xv().isSuccess();
        }
        return false;
    }

    public f w() {
        ValueSet values;
        if (xv() == null || (values = xv().values()) == null) {
            return null;
        }
        return new f((JSONObject) values.objectValue(4, JSONObject.class));
    }
}
