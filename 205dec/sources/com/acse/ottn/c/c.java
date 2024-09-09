package com.acse.ottn.c;

import android.text.TextUtils;
import com.acse.ottn.g3;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.E;
import com.acse.ottn.util.ra;
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

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c<T> implements Converter<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Type f5315a;

    public c(Type type) {
        this.f5315a = type;
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
        String decryptKey;
        BufferedSource buffer = Okio.buffer(responseBody.source());
        String readUtf8 = buffer.readUtf8();
        buffer.close();
        try {
            boolean z3 = true;
            if (new JSONObject(readUtf8).getInt("heart_beat") != 1) {
                z3 = false;
            }
            decryptKey = CommonUtil.getDecryptKey(z3);
        } catch (JSONException unused) {
            decryptKey = CommonUtil.getDecryptKey(false);
        }
        if (TextUtils.isEmpty(decryptKey)) {
            return (T) JSON.parseObject(readUtf8, this.f5315a, new Feature[0]);
        }
        ra.a(g3.f5672e, "samon responese data = " + a(b(E.a().a(readUtf8, decryptKey))));
        return (T) JSON.parseObject(a(b(E.a().a(readUtf8, decryptKey))), this.f5315a, new Feature[0]);
    }
}
