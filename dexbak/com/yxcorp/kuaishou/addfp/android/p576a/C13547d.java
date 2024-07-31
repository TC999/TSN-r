package com.yxcorp.kuaishou.addfp.android.p576a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.kuaishou.weapon.p205p0.C7282g;
import com.tencent.connect.common.Constants;
import com.yxcorp.kuaishou.addfp.android.p577b.C13550b;
import com.yxcorp.kuaishou.addfp.android.p577b.C13555g;
import com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.yxcorp.kuaishou.addfp.android.a.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13547d {

    /* renamed from: d */
    private static volatile C13547d f40042d;

    /* renamed from: a */
    private C13548e f40043a;

    /* renamed from: b */
    private ConcurrentHashMap f40044b = new ConcurrentHashMap(10);

    /* renamed from: c */
    private Context f40045c;

    private C13547d(Context context) {
        this.f40043a = null;
        try {
            this.f40045c = context;
            this.f40043a = new C13548e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C13547d m12896a(Context context) {
        if (f40042d == null) {
            synchronized (C13547d.class) {
                if (f40042d == null) {
                    f40042d = new C13547d(context);
                }
            }
        }
        return f40042d;
    }

    /* renamed from: a */
    private String m12892a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(hashMap);
            String str = new String(Base64.encode(C13550b.m12883c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                        return "";
                    } catch (IOException unused2) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    /* renamed from: a */
    public static void m12895a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(C13550b.m12886a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                fileWriter.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused2) {
        }
    }

    /* renamed from: a */
    public synchronized Pair m12897a() {
        byte[] bArr;
        if (this.f40044b != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty((String) this.f40044b.get("cache_e"))) {
                return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f40044b);
            }
        }
        this.f40044b.clear();
        String m12888b = this.f40043a.m12888b();
        if (!TextUtils.isEmpty(m12888b)) {
            try {
                bArr = Base64.decode(m12888b, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.decode(m12888b, 8);
                } catch (Throwable unused2) {
                }
            }
            JSONObject jSONObject = new JSONObject(new String(C13550b.m12884b(bArr, "20212102sjcudiab".getBytes())));
            this.f40044b.put("cache_e", jSONObject.optString("cache_e", ""));
            this.f40044b.put("cache_m", jSONObject.optString("cache_m", ""));
            this.f40044b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
        }
        ConcurrentHashMap concurrentHashMap = this.f40044b;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty((String) this.f40044b.get("cache_e"))) {
                return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f40044b);
            }
        }
        return Pair.create(Pair.create(Boolean.TRUE, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO), null);
    }

    /* renamed from: a */
    public String m12894a(String str) {
        try {
            File file = new File(C13550b.m12886a(this.f40045c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public synchronized void m12893a(String str, String str2) {
        byte[] bArr;
        LinkedHashMap linkedHashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f40044b.put("c_time", Long.toString(currentTimeMillis));
            this.f40044b.put("cache_e", str);
            this.f40044b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] m12883c = C13550b.m12883c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(m12883c, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(m12883c, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f40043a.m12889a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String m12866a = C13557a.m12866a(this.f40045c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(m12866a) && C13555g.m12875a(this.f40045c, new String[]{C7282g.f24951i, C7282g.f24952j})) {
                m12866a = m12894a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(m12866a) && (linkedHashMap = m12891b(m12866a)) != null) {
                C13546c c13546c = C13545b.f40036a;
                String m12905a = c13546c.m12905a();
                if (!TextUtils.isEmpty(m12905a)) {
                    if (linkedHashMap.containsKey(m12905a)) {
                        linkedHashMap.remove(m12905a);
                    }
                    linkedHashMap.put(c13546c.m12905a(), str);
                }
            }
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(C13545b.f40036a.m12905a(), str);
            }
            String m12892a = m12892a(linkedHashMap);
            if (!TextUtils.isEmpty(m12892a)) {
                try {
                    Settings.System.putString(this.f40045c.getContentResolver(), "k_w_o_d_out_dtt", m12892a);
                } catch (Throwable unused4) {
                }
                if (C13555g.m12875a(this.f40045c, new String[]{C7282g.f24951i, C7282g.f24952j})) {
                    m12895a(this.f40045c, m12892a);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public LinkedHashMap m12891b(String str) {
        Throwable th;
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(C13550b.m12884b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return new LinkedHashMap();
    }
}
