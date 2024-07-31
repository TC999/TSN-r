package com.acse.ottn.p041c;

import android.text.TextUtils;
import com.acse.ottn.util.C1625E;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
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

/* renamed from: com.acse.ottn.c.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1472c<T> implements Converter<ResponseBody, T> {

    /* renamed from: a */
    private final Type f2702a;

    public C1472c(Type type) {
        this.f2702a = type;
    }

    /* renamed from: a */
    public static String m56693a(String str) {
        if (str.contains("u")) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] split = str.split("u");
            for (int i = 1; i < split.length; i++) {
                stringBuffer.append((char) Integer.parseInt(split[i], 16));
            }
            return stringBuffer.toString();
        }
        return str;
    }

    /* renamed from: b */
    public static String m56691b(String str) {
        StringBuilder sb;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
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
            boolean z = true;
            if (new JSONObject(readUtf8).getInt("heart_beat") != 1) {
                z = false;
            }
            decryptKey = CommonUtil.getDecryptKey(z);
        } catch (JSONException unused) {
            decryptKey = CommonUtil.getDecryptKey(false);
        }
        if (TextUtils.isEmpty(decryptKey)) {
            return (T) JSON.parseObject(readUtf8, this.f2702a, new Feature[0]);
        }
        C1694ra.m55917a("RetrofitServiceManager", "samon responese data = " + m56693a(m56691b(C1625E.m56283a().m56281a(readUtf8, decryptKey))));
        return (T) JSON.parseObject(m56693a(m56691b(C1625E.m56283a().m56281a(readUtf8, decryptKey))), this.f2702a, new Feature[0]);
    }
}
