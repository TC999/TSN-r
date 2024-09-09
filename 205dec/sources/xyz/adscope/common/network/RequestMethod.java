package xyz.adscope.common.network;

import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f64833a;

    /* renamed from: xyz.adscope.common.network.RequestMethod$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64834a;

        static {
            int[] iArr = new int[RequestMethod.values().length];
            f64834a = iArr;
            try {
                iArr[RequestMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64834a[RequestMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64834a[RequestMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f64834a[RequestMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    RequestMethod(String str) {
        this.f64833a = str;
    }

    public static RequestMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        upperCase.hashCode();
        char c4 = '\uffff';
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals("OPTIONS")) {
                    c4 = 0;
                    break;
                }
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c4 = 1;
                    break;
                }
                break;
            case 79599:
                if (upperCase.equals("PUT")) {
                    c4 = 2;
                    break;
                }
                break;
            case 2213344:
                if (upperCase.equals("HEAD")) {
                    c4 = 3;
                    break;
                }
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c4 = 4;
                    break;
                }
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c4 = 5;
                    break;
                }
                break;
            case 80083237:
                if (upperCase.equals("TRACE")) {
                    c4 = 6;
                    break;
                }
                break;
            case 2012838315:
                if (upperCase.equals("DELETE")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return OPTIONS;
            case 1:
                return GET;
            case 2:
                return PUT;
            case 3:
                return HEAD;
            case 4:
                return POST;
            case 5:
                return PATCH;
            case 6:
                return TRACE;
            case 7:
                return DELETE;
            default:
                return GET;
        }
    }

    public boolean allowBody() {
        int i4 = AnonymousClass1.f64834a[ordinal()];
        return i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f64833a;
    }
}
