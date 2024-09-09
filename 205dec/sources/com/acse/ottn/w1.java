package com.acse.ottn;

import android.text.TextUtils;
import com.acse.ottn.model.AccessiblityModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static w1 f6931a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends TypeToken<AccessiblityModel> {
        public a() {
        }
    }

    public static w1 b() {
        if (f6931a == null) {
            synchronized (w1.class) {
                if (f6931a == null) {
                    f6931a = new w1();
                }
            }
        }
        return f6931a;
    }

    public void a() {
        g1.a().b("tb_lj_data", "");
    }

    public AccessiblityModel c() {
        String d4 = g1.a().d("tb_lj_data");
        Gson gson = new Gson();
        if (TextUtils.isEmpty(d4) || d4 == null) {
            return null;
        }
        return (AccessiblityModel) gson.fromJson(d4, new a().getType());
    }

    public final Object d() throws ObjectStreamException {
        return f6931a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        g1.a().b("tb_lj_data", new Gson().toJson(accessiblityModel));
    }
}
