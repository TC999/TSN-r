package com.umeng.analytics;

import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum Gender {
    Male(1) { // from class: com.umeng.analytics.Gender.1
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    },
    Female(2) { // from class: com.umeng.analytics.Gender.2
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    },
    Unknown(0) { // from class: com.umeng.analytics.Gender.3
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    };
    
    public int value;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.umeng.analytics.Gender$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f52429a;

        static {
            int[] iArr = new int[Gender.values().length];
            f52429a = iArr;
            try {
                iArr[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52429a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52429a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Gender getGender(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return Unknown;
            }
            return Female;
        }
        return Male;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i4 = AnonymousClass4.f52429a[gender.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN;
            }
            return com.umeng.commonsdk.statistics.proto.Gender.FEMALE;
        }
        return com.umeng.commonsdk.statistics.proto.Gender.MALE;
    }

    public int value() {
        return this.value;
    }

    Gender(int i4) {
        this.value = i4;
    }
}
