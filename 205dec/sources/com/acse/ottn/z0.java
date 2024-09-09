package com.acse.ottn;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class z0<T> implements Converter<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    public final Type f7010a;

    public z0(Type type) {
        this.f7010a = type;
    }

    public static String b(String str) {
        StringBuilder sb;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (Integer.toHexString(charAt).length() == 1) {
                sb = new StringBuilder();
                str2 = "u0";
            } else {
                sb = new StringBuilder();
                str2 = "u";
            }
            sb.append(str2);
            sb.append(Integer.toHexString(charAt));
            stringBuffer.append(sb.toString());
        }
        return Pattern.compile("u02").matcher(stringBuffer).replaceAll("");
    }

    @Override // retrofit2.Converter
    /* renamed from: a */
    public T convert(ResponseBody responseBody) throws IOException {
        String a4;
        BufferedSource buffer = Okio.buffer(responseBody.source());
        String readUtf8 = buffer.readUtf8();
        buffer.close();
        try {
            boolean z3 = true;
            if (new JSONObject(readUtf8).getInt("heart_beat") != 1) {
                z3 = false;
            }
            a4 = j0.a(z3);
        } catch (JSONException unused) {
            a4 = j0.a(false);
        }
        if (TextUtils.isEmpty(a4)) {
            return (T) JSON.parseObject(readUtf8, this.f7010a, new Feature[0]);
        }
        z1.a(g3.f5672e, "samon responese data = " + a(b(f.a().a(readUtf8, a4))));
        return (T) JSON.parseObject(a(b(f.a().a(readUtf8, a4))), this.f7010a, new Feature[0]);
    }

    public static String a(String str) {
        if (str.contains("u")) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] split = str.split("u");
            for (int i4 = 1; i4 < split.length; i4++) {
                stringBuffer.append((char) Integer.parseInt(split[i4], 16));
            }
            return stringBuffer.toString();
        }
        return str;
    }
}
