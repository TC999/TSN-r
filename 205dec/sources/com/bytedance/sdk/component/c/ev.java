package com.bytedance.sdk.component.c;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private a f29657c;

    private ev(a aVar) {
        this.f29657c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ev c(a aVar) {
        return new ev(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T c(String str, Type type) throws JSONException {
        c(str);
        if (!type.equals(JSONObject.class) && (!(type instanceof Class) || !JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) this.f29657c.c(str, type);
        }
        return (T) new JSONObject(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> String c(T t3) {
        String obj;
        if (t3 == null) {
            return "{}";
        }
        if (!(t3 instanceof JSONObject) && !(t3 instanceof JSONArray)) {
            obj = this.f29657c.c(t3);
        } else {
            obj = t3.toString();
        }
        c(obj);
        return obj;
    }

    private static void c(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        gd.c(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
    }
}
