package com.alibaba.fastjson.parser;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch;
    
    public final int mask = 1 << ordinal();

    Feature() {
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return i | feature.mask;
        }
        return i & (feature.mask ^ (-1));
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (i & feature.mask) != 0;
    }

    /* renamed from: of */
    public static int m55842of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i = 0;
        for (Feature feature : featureArr) {
            i |= feature.mask;
        }
        return i;
    }

    public final int getMask() {
        return this.mask;
    }
}
