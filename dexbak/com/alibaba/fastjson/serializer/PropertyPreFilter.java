package com.alibaba.fastjson.serializer;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
