package com.bytedance.sdk.component.f.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.component.f.w {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f29786c;

    /* renamed from: w  reason: collision with root package name */
    private xv f29787w;

    public w(com.bytedance.sdk.component.f.c cVar) {
        this.f29786c = cVar;
    }

    private <T> T w(String str, T t3) {
        try {
            String w3 = this.f29786c.w(this.f29787w.c(str), "");
            return TextUtils.isEmpty(w3) ? t3 : (T) new JSONObject((String) this.f29787w.w(w3)).get(str);
        } catch (Throwable unused) {
            return t3;
        }
    }

    public void c(xv xvVar) {
        this.f29787w = xvVar;
    }

    private <T> void c(String str, T t3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, t3);
            this.f29786c.c(this.f29787w.c(str), this.f29787w.c(jSONObject.toString()));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, int i4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, i4);
        } else {
            c(str, (String) Integer.valueOf(i4));
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public int w(String str, int i4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return i4;
        }
        if (this.f29787w == null) {
            return cVar.w(str, i4);
        }
        return ((Integer) w(str, (String) Integer.valueOf(i4))).intValue();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, long j4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, j4);
        } else {
            c(str, (String) Long.valueOf(j4));
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public long w(String str, long j4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return j4;
        }
        if (this.f29787w == null) {
            return cVar.w(str, j4);
        }
        return ((Long) w(str, (String) Long.valueOf(j4))).longValue();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, float f4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, f4);
        } else {
            c(str, (String) Float.valueOf(f4));
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public float w(String str, float f4) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return f4;
        }
        if (this.f29787w == null) {
            return cVar.w(str, f4);
        }
        return ((Float) w(str, (String) Float.valueOf(f4))).floatValue();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, boolean z3) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, z3);
        } else {
            c(str, (String) Boolean.valueOf(z3));
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public boolean w(String str, boolean z3) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return z3;
        }
        if (this.f29787w == null) {
            return cVar.w(str, z3);
        }
        return ((Boolean) w(str, (String) Boolean.valueOf(z3))).booleanValue();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, String str2) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, str2);
        } else {
            c(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public String w(String str, String str2) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return str2;
        }
        if (this.f29787w == null) {
            return cVar.w(str, str2);
        }
        return (String) w(str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, Set<String> set) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str, set);
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str2 : set) {
            hashSet.add(this.f29787w.c(str2));
        }
        this.f29786c.c(this.f29787w.c(str), hashSet);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Set<String> w(String str, Set<String> set) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return set;
        }
        xv xvVar = this.f29787w;
        if (xvVar == null) {
            return cVar.w(str, set);
        }
        Set<String> w3 = cVar.w(xvVar.c(str), set);
        HashSet hashSet = new HashSet();
        for (String str2 : w3) {
            hashSet.add(this.f29787w.w(str2));
        }
        return hashSet;
    }

    @Override // com.bytedance.sdk.component.f.c
    public Map<String, ?> c() {
        try {
            com.bytedance.sdk.component.f.c cVar = this.f29786c;
            if (cVar == null) {
                return Collections.emptyMap();
            }
            Map<String, ?> c4 = cVar.c();
            if (this.f29787w == null) {
                return c4;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ?> entry : c4.entrySet()) {
                String str = (String) this.f29787w.w(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof Set) {
                    HashSet hashSet = new HashSet();
                    for (String str2 : (Set) value) {
                        hashSet.add(this.f29787w.w(str2));
                    }
                    hashMap.put(str, hashSet);
                } else {
                    hashMap.put(str, new JSONObject((String) this.f29787w.w(value.toString())).get(str));
                }
            }
            return hashMap;
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public void w() {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        cVar.w();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str) {
        com.bytedance.sdk.component.f.c cVar = this.f29786c;
        if (cVar == null) {
            return;
        }
        if (this.f29787w == null) {
            cVar.c(str);
        }
        this.f29786c.c(this.f29787w.c(str));
    }
}
