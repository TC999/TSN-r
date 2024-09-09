package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f46501a = {"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_dark.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_dark_fb.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_dark_fw.png"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f46502b = {"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_light_1.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_light_fb.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_light_fw.png"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f46503c = {"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_gray_transparent.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_gray_transparent_fb.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_gray_transparent_fw.png"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f46504d = {"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_white_transparent.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_white_transparent_fb.png", "https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/ams_logo_white_transparent_fw.png"};

    public static int a() {
        return f1.a(com.qq.e.comm.plugin.d0.a.d().a(), 16);
    }

    public static int b() {
        return f1.a(com.qq.e.comm.plugin.d0.a.d().a(), 44);
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        return (eVar == null || TextUtils.isEmpty(eVar.y()) || com.qq.e.comm.plugin.d0.a.d().f().a("te_oalca", eVar.q0(), 0) != 1) ? false : true;
    }

    public static void a(ImageView imageView) {
        a(imageView, false);
    }

    public static void a(ImageView imageView, int i4, boolean z3, boolean z4) {
        String str;
        if (imageView == null) {
            return;
        }
        char c4 = z3 ? (char) 2 : z4 ? (char) 1 : (char) 0;
        if (i4 == 0) {
            str = f46501a[c4];
        } else if (i4 == 1) {
            str = f46502b[c4];
        } else if (i4 != 2) {
            str = i4 != 3 ? null : f46504d[c4];
        } else {
            str = f46503c[c4];
        }
        com.qq.e.comm.plugin.b0.b.a().a(str, imageView, null, m1.a("iVBORw0KGgoAAAANSUhEUgAAALAAAABACAMAAACN+w11AAAAk1BMVEUAAADJycm+vr6FhYWrq6vExMS7u7sqKioNDQ2pqakXFxeDg4Nqamq6uroAAAAFBQU/Pz+zs7OAgIBPT093d3eQkJAeHh7CwsJWVlYCAgJxcXFsbGx7e3syMjK2trajo6NHR0c3NzdhYWFbW1sAAACenp64uLiLi4sAAACWlpbAwMAAAAAAAACwsLCampoAAAAAAABG2VplAAAAMXRSTlNmwrmUq763cWmrbJSJtwBneLGRfY2abryAZ4uIj3Oypnp1hIJVorSYOZ67Ewaun0A6tTVaZwAABDFJREFUaN7tmuuO2jAQRsdJNnYc0tzvCRCuCyxs3//pOiF2SmlBWYjSRuX8+4SEjkYzHiMM35DD9xX886w+D7UrCn+8w0h4/6iFP0ZQXcnqA4VHU9+a929wgFFxgE8YFe8wog5Gxqb74sWLF/8E3OEwJlxCTLgDB4GmadALaZkFPgOJHc3n1IbOBITE90qsx27zMSEE+oAVU0VRZlRG31RVb8GhMzohOdzEJ8SAPoWZib7IOhW+ao25ZNCVnBANbnIiJO9T2F4clQZ6jo6pnsnKe4rmJSGahOYlObRQQizoUTh1ZorAB4QWakPgwG00ch8DWmZY4D6F6U6XwhXGKFMFWdmLcE5uAw8QbTfSd4aRL1C1Qw+jcDC5w7KtR9yvMAtc6TtNAGxf7VTgWphCB7hOiG5I6tJfAl8FBTXpuykYQOlJ38KxexDmLk4cB+irh9NqJ331HQegXhhu1RovQX3GI84eFpa+FPoTLsN24E40hWrnWhtjp4q1wf1JNvH5E8Lou3egP+GoaBvYwA7gu/jt7S12Q9XLS/RNvHOp+ePCQe3bo/DSkL5uzoDl6IvExvkIZr7XNHOVPt7DAYUehZmny4HzKIDvvjVMC98G5gRqg88eFkb6FOZbOXBbCoALTwrjwNlVpj4rzLVrUFi7gn7p0iMqvHbseuHtG994HQFEE1P4eo79oDAlHaDwBRbNIaxhRZlqKUrTw24iB67GXEQ35v8vCEfBEWts5BzshasgcfwWW4ENbF60C6+yb9yAKQxP5Ade7jCApbyx7a2AyYGrKfDTG8IwJHweeBOsXcp5LeSsLUUQRgDV1jDW23bhccf3K3Zj3ochmszczXHn2yKG03aBlBh31n6va6Fo4CgJPC9I2JWwDsPBm2nTw0qcx7/c2Jh6Pt/2hqrmpS3nz3Ou5smFbpw0ycMnWuofxX6bnOMCY4O+sIHlijiOQxw4sfCQ7Lffld3Qnz8gIjlhVgDIHKPAY2DP5cLbhHOMTiHHDy5YEhIOJsy2umyAusL04sYWYTSUWFQ44BjbhRfABSYhQXdheG63LzdScO0A2EUbjyUAbHUpPMPIl6YUTuCCGSH+YMJrKehO7MuG2CQpALMUsfGOS4w/D+SMXy06ZzDhqezgkDfrWZAxjLxZH3HsnuPckx38y7dzQmIYTNiVDVGmdYNI4W10VpHlNhlcCJtz+/qQGE44FCvCTwEpRYdgx9akTf31dfNtpZi5q58dIc7ccMLUOPsmcgabSNMmJnrtO6uaZDclXvLfJPznhNMvCKc0dN2wAokTTrX6Bi8V11OtiNro5EV2fQFyxGLuKqz/gXjI696JkBNAD4tjIKjoiM7C1h8YUpjrdUf0MXRDQd0cOmP9A8Iwrv+MXrzoyn/6JmUFo3oFBvA5vmdgo3toN76njKN7LIocPkdQ5dX3Q+36AxFUS6qPK49nAAAAAElFTkSuQmCC"));
    }

    public static void a(ImageView imageView, boolean z3) {
        a(imageView, 0, false, z3);
    }
}
