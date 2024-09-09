package com.kwad.sdk.ranger.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    @NonNull
    public String aNA;
    public b aNB;
    public a aNC;
    public Object aNw;
    public String aNx;
    public String aNy;
    public boolean aNz;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0719a extends com.kwad.sdk.core.response.a.a {
        public String aND;
        public String aNE;
        public String aNF;
        public List<String> aNG;
        public List<C0719a> aNH = new ArrayList();
        public Object aNI;
        public List<Object> aNJ;
        public String className;
        public String fieldName;

        private Object KG() {
            Object obj = null;
            try {
            } catch (Exception e4) {
                c.d(a.TAG, Log.getStackTraceString(e4));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = s.gw(this.className);
            String str = a.TAG;
            c.d(str, "Class.forName(className):" + this.className + " value:" + obj);
            List<C0719a> list = this.aNH;
            if (list != null && !list.isEmpty()) {
                for (C0719a c0719a : this.aNH) {
                    c0719a.aNI = obj;
                    String str2 = a.TAG;
                    c.d(str2, "param.ob:" + c0719a.aNI);
                    try {
                        s.a(c0719a.aNI, c0719a.fieldName, c0719a.getValue());
                    } catch (Exception e5) {
                        c.d(a.TAG, Log.getStackTraceString(e5));
                    }
                }
            }
            String str3 = a.TAG;
            c.d(str3, "return value in special:" + obj);
            return obj;
        }

        private Object KH() {
            if (TextUtils.isEmpty(this.aNF)) {
                return ao(this.aND, this.aNE);
            }
            this.aNJ = new ArrayList();
            for (String str : this.aNG) {
                Object ao = ao(this.aNF, str);
                if (ao != null) {
                    this.aNJ.add(ao);
                }
            }
            return this.aNJ;
        }

        private static Object ao(String str, String str2) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    obj = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    obj = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    obj = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    obj = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    obj = str2;
                }
            } catch (Exception e4) {
                c.w(a.TAG, Log.getStackTraceString(e4));
            }
            return obj;
        }

        public final Object getValue() {
            if (TextUtils.isEmpty(this.aND) && TextUtils.isEmpty(this.aNF)) {
                return KG();
            }
            return KH();
        }
    }

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public boolean aNK;
        public List<C0719a> aNL;
        public Object[] aNM;
        public String name;

        public final boolean KF() {
            if (TextUtils.isEmpty(this.name)) {
                List<C0719a> list = this.aNL;
                return (list == null || list.isEmpty()) && this.aNM == null;
            }
            return false;
        }

        public final Object[] KI() {
            List<C0719a> list = this.aNL;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aNL.size()];
            for (int i4 = 0; i4 < this.aNL.size(); i4++) {
                objArr[i4] = this.aNL.get(i4).getValue();
            }
            return objArr;
        }
    }

    public final boolean KF() {
        if (this.aNw == null && TextUtils.isEmpty(this.aNx) && TextUtils.isEmpty(this.aNy) && TextUtils.isEmpty(this.aNA)) {
            b bVar = this.aNB;
            if (bVar == null || bVar.KF()) {
                a aVar = this.aNC;
                return aVar == null || aVar.KF();
            }
            return false;
        }
        return false;
    }
}
