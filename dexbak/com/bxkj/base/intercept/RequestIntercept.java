package com.bxkj.base.intercept;

import cn.bluemobi.dylan.http.MD5Utils;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
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

/* renamed from: com.bxkj.base.intercept.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestIntercept implements Interceptor {
    /* renamed from: a */
    private static String m44209a(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        if (z) {
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

    /* renamed from: b */
    public static String m44208b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            String str = (String) arrayList.get(i);
            sb.append(m44209a(str, map.get(str), false));
            sb.append("&");
        }
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        sb.append(m44209a(str2, map.get(str2), false));
        C11792j.m20470c("authInfo=" + ((Object) sb));
        return EncryptionUtils.f14797a.m44212a(LoginUser.getLoginUser().getToken(), sb.toString());
    }

    /* renamed from: c */
    private String m44207c(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField(TTDownloadField.TT_HEADERS);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            return ((Headers) field.get(part)).get("content-disposition").split(";")[1].split("=")[1].replace("\"", "");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    private String m44206d(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
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
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static String m44205e(Map<String, String> map, boolean z) {
        if (z) {
            return m44208b(map);
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            String str = (String) arrayList.get(i);
            sb.append(m44209a(str, map.get(str), false));
            sb.append("&");
        }
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        sb.append(m44209a(str2, map.get(str2), false));
        try {
            return URLEncoder.encode(MD5Utils.md5(sb.toString()), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    private int m44204f() {
        try {
            return BaseApp.m44341b().getPackageManager().getPackageInfo(BaseApp.m44341b().getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f4  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.intercept.RequestIntercept.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
