package com.alibaba.fastjson.serializer;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;
    
    public static final SerializerFeature[] EMPTY;
    public static final int WRITE_MAP_NULL_FEATURES;
    public final int mask = 1 << ordinal();

    static {
        SerializerFeature serializerFeature = WriteMapNullValue;
        SerializerFeature serializerFeature2 = WriteNullListAsEmpty;
        SerializerFeature serializerFeature3 = WriteNullStringAsEmpty;
        SerializerFeature serializerFeature4 = WriteNullNumberAsZero;
        SerializerFeature serializerFeature5 = WriteNullBooleanAsFalse;
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | serializerFeature5.getMask() | serializerFeature2.getMask() | serializerFeature4.getMask() | serializerFeature3.getMask();
    }

    SerializerFeature() {
    }

    public static int config(int i, SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i | serializerFeature.mask;
        }
        return i & (serializerFeature.mask ^ (-1));
    }

    public static boolean isEnabled(int i, SerializerFeature serializerFeature) {
        return (i & serializerFeature.mask) != 0;
    }

    /* renamed from: of */
    public static int m55841of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        return i;
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, int i2, SerializerFeature serializerFeature) {
        int i3 = serializerFeature.mask;
        return ((i & i3) == 0 && (i2 & i3) == 0) ? false : true;
    }
}
