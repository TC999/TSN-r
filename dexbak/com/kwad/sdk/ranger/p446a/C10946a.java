package com.kwad.sdk.ranger.p446a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11124s;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* renamed from: com.kwad.sdk.ranger.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10946a extends C10482a {
    public static final String TAG = "Ranger_" + C10946a.class.getSimpleName();
    @NonNull
    public String aNA;
    public C10948b aNB;
    public C10946a aNC;
    public Object aNw;
    public String aNx;
    public String aNy;
    public boolean aNz;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10947a extends C10482a {
        public String aND;
        public String aNE;
        public String aNF;
        public List<String> aNG;
        public List<C10947a> aNH = new ArrayList();
        public Object aNI;
        public List<Object> aNJ;
        public String className;
        public String fieldName;

        /* renamed from: KG */
        private Object m24391KG() {
            Object obj = null;
            try {
            } catch (Exception e) {
                C10331c.m26254d(C10946a.TAG, Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(this.className)) {
                C10331c.m26246w(C10946a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = C11124s.m23688gw(this.className);
            String str = C10946a.TAG;
            C10331c.m26254d(str, "Class.forName(className):" + this.className + " value:" + obj);
            List<C10947a> list = this.aNH;
            if (list != null && !list.isEmpty()) {
                for (C10947a c10947a : this.aNH) {
                    c10947a.aNI = obj;
                    String str2 = C10946a.TAG;
                    C10331c.m26254d(str2, "param.ob:" + c10947a.aNI);
                    try {
                        C11124s.m23707a(c10947a.aNI, c10947a.fieldName, c10947a.getValue());
                    } catch (Exception e2) {
                        C10331c.m26254d(C10946a.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            String str3 = C10946a.TAG;
            C10331c.m26254d(str3, "return value in special:" + obj);
            return obj;
        }

        /* renamed from: KH */
        private Object m24390KH() {
            if (TextUtils.isEmpty(this.aNF)) {
                return m24389ao(this.aND, this.aNE);
            }
            this.aNJ = new ArrayList();
            for (String str : this.aNG) {
                Object m24389ao = m24389ao(this.aNF, str);
                if (m24389ao != null) {
                    this.aNJ.add(m24389ao);
                }
            }
            return this.aNJ;
        }

        /* renamed from: ao */
        private static Object m24389ao(String str, String str2) {
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
            } catch (Exception e) {
                C10331c.m26246w(C10946a.TAG, Log.getStackTraceString(e));
            }
            return obj;
        }

        public final Object getValue() {
            if (TextUtils.isEmpty(this.aND) && TextUtils.isEmpty(this.aNF)) {
                return m24391KG();
            }
            return m24390KH();
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10948b extends C10482a {
        public boolean aNK;
        public List<C10947a> aNL;
        public Object[] aNM;
        public String name;

        /* renamed from: KF */
        public final boolean m24388KF() {
            if (TextUtils.isEmpty(this.name)) {
                List<C10947a> list = this.aNL;
                return (list == null || list.isEmpty()) && this.aNM == null;
            }
            return false;
        }

        /* renamed from: KI */
        public final Object[] m24387KI() {
            List<C10947a> list = this.aNL;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aNL.size()];
            for (int i = 0; i < this.aNL.size(); i++) {
                objArr[i] = this.aNL.get(i).getValue();
            }
            return objArr;
        }
    }

    /* renamed from: KF */
    public final boolean m24392KF() {
        if (this.aNw == null && TextUtils.isEmpty(this.aNx) && TextUtils.isEmpty(this.aNy) && TextUtils.isEmpty(this.aNA)) {
            C10948b c10948b = this.aNB;
            if (c10948b == null || c10948b.m24388KF()) {
                C10946a c10946a = this.aNC;
                return c10946a == null || c10946a.m24392KF();
            }
            return false;
        }
        return false;
    }
}
