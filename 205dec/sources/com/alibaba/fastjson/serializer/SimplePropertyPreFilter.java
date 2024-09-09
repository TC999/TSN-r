package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;
    private int maxLevel;

    public SimplePropertyPreFilter(String... strArr) {
        this(null, strArr);
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str) {
        if (obj == null) {
            return true;
        }
        Class<?> cls = this.clazz;
        if (cls == null || cls.isInstance(obj)) {
            if (this.excludes.contains(str)) {
                return false;
            }
            if (this.maxLevel > 0) {
                int i4 = 0;
                for (SerialContext serialContext = jSONSerializer.context; serialContext != null; serialContext = serialContext.parent) {
                    i4++;
                    if (i4 > this.maxLevel) {
                        return false;
                    }
                }
            }
            return this.includes.size() == 0 || this.includes.contains(str);
        }
        return true;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int i4) {
        this.maxLevel = i4;
    }

    public SimplePropertyPreFilter(Class<?> cls, String... strArr) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        this.maxLevel = 0;
        this.clazz = cls;
        for (String str : strArr) {
            if (str != null) {
                this.includes.add(str);
            }
        }
    }
}
