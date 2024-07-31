package com.alibaba.fastjson.serializer;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ContextValueFilter extends SerializeFilter {
    Object process(BeanContext beanContext, Object obj, String str, Object obj2);
}
