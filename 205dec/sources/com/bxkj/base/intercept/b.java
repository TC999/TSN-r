package com.bxkj.base.intercept;

import cn.bluemobi.dylan.http.MD5Utils;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestIntercept.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b implements Interceptor {
    private static String a(String str, String str2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        if (z3) {
            try {
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                sb.append(str2);
            }
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < arrayList.size() - 1; i4++) {
            String str = (String) arrayList.get(i4);
            sb.append(a(str, map.get(str), false));
            sb.append("&");
        }
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        sb.append(a(str2, map.get(str2), false));
        j.c("authInfo=" + ((Object) sb));
        return a.f18282a.a(LoginUser.getLoginUser().getToken(), sb.toString());
    }

    private String c(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("headers");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            return ((Headers) field.get(part)).get("content-disposition").split(";")[1].split("=")[1].replace("\"", "");
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    private String d(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            RequestBody requestBody = (RequestBody) field.get(part);
            MediaType contentType = requestBody.contentType();
            if (contentType.subtype().equals("form-data")) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                return buffer.readString(contentType.charset(Charset.forName("UTF-8")));
            }
            return "dylan_file";
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String e(Map<String, String> map, boolean z3) {
        if (z3) {
            return b(map);
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < arrayList.size() - 1; i4++) {
            String str = (String) arrayList.get(i4);
            sb.append(a(str, map.get(str), false));
            sb.append("&");
        }
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        sb.append(a(str2, map.get(str2), false));
        try {
            return URLEncoder.encode(MD5Utils.md5(sb.toString()), "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    private int f() {
        try {
            return BaseApp.b().getPackageManager().getPackageInfo(BaseApp.b().getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f8  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.intercept.b.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
