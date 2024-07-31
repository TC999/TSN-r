package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;

/* renamed from: com.kuaishou.weapon.p0.bn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7198bn {

    /* renamed from: a */
    private Context f24596a;

    public C7198bn(Context context) {
        this.f24596a = context;
    }

    /* renamed from: b */
    public static String m34155b(String str) {
        try {
            String str2 = new String(C7212c.m34109a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            return new String(AbstractC7249d.m34009b(C7284i.m33862a(C7183b.m34305b(str2.substring(0, 16), str2.substring(0, 16), C7212c.m34109a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34156a(String str, String str2) {
        try {
            return m34152c(str, new String(C7212c.m34109a(str2.getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public String m34153c(String str) {
        try {
            return m34152c(str, new String(C7212c.m34109a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34157a(String str) {
        try {
            return m34154b(str, new String(C7212c.m34109a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public String m34152c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str2.length() < 16) {
            int length = str2.length();
            StringBuilder sb = new StringBuilder(str2);
            for (int i = 0; i < 16 - length; i++) {
                sb.append("0");
            }
            str2 = sb.toString();
        } else if (str2.length() > 16) {
            str2 = str2.substring(0, 16);
        }
        byte[] m34011a = AbstractC7249d.m34011a(str.getBytes());
        if (Engine.loadSuccess) {
            bArr = Engine.getInstance(this.f24596a).m33856ac(Engine.getInstance(this.f24596a).m33855ar(m34011a, str2.getBytes()), str2.substring(0, 16).getBytes());
        } else {
            try {
                bArr = C7183b.m34307a(str2.substring(0, 16), str2.substring(0, 16), C7284i.m33859b(m34011a, str2));
            } catch (Throwable unused) {
                bArr = null;
            }
        }
        if (bArr != null && bArr.length > 0) {
            return C7212c.m34105b(bArr, 2);
        }
        return null;
    }

    /* renamed from: b */
    public String m34154b(String str, String str2) {
        byte[] m33862a;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] m34109a = C7212c.m34109a(str.getBytes(), 2);
            if (Engine.loadSuccess) {
                m33862a = Engine.getInstance(this.f24596a).m33853dr(Engine.getInstance(this.f24596a).m33854dc(m34109a, str2.substring(0, 16).getBytes()), str2.getBytes());
            } else {
                m33862a = C7284i.m33862a(C7183b.m34305b(str2.substring(0, 16), str2.substring(0, 16), m34109a), str2.substring(0, 16));
            }
            return new String(AbstractC7249d.m34009b(m33862a));
        } catch (Exception unused) {
            return null;
        }
    }
}
