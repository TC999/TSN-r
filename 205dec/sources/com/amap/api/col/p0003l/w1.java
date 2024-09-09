package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.v1;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CustomStyleTask.java */
/* renamed from: com.amap.api.col.3l.w1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w1 extends a8 {

    /* renamed from: a  reason: collision with root package name */
    private Context f9332a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f9333b;

    /* renamed from: c  reason: collision with root package name */
    private v1 f9334c;

    /* renamed from: d  reason: collision with root package name */
    private String f9335d;

    /* renamed from: e  reason: collision with root package name */
    private String f9336e;

    /* renamed from: g  reason: collision with root package name */
    private String f9337g;

    /* renamed from: h  reason: collision with root package name */
    private a f9338h;

    /* renamed from: i  reason: collision with root package name */
    private int f9339i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CustomStyleTask.java */
    /* renamed from: com.amap.api.col.3l.w1$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(byte[] bArr, int i4);

        void b(byte[] bArr, int i4);
    }

    public w1(Context context, a aVar, int i4, String str) {
        this.f9335d = null;
        this.f9336e = null;
        this.f9337g = null;
        this.f9332a = context;
        this.f9338h = aVar;
        this.f9339i = i4;
        if (this.f9334c == null) {
            this.f9334c = new v1(context, "", i4 != 0);
        }
        this.f9334c.b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.f9335d = sb.toString();
        this.f9336e = context.getCacheDir().getPath();
    }

    private void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        w2.a(this.f9332a, "amap_style_config", "lastModified".concat(str), str2);
    }

    private void d(String str, byte[] bArr) {
        if (str == null || bArr == null || this.f9336e == null) {
            return;
        }
        FileUtil.saveFileContents(this.f9336e + File.separator + str, bArr);
    }

    private byte[] e(String str) {
        if (str == null || this.f9336e == null) {
            return null;
        }
        return FileUtil.readFileContents(this.f9336e + File.separator + str);
    }

    private String f(String str) {
        if (str == null) {
            return null;
        }
        Object b4 = w2.b(this.f9332a, "amap_style_config", "lastModified".concat(str), "");
        if (!(b4 instanceof String) || b4 == "") {
            return null;
        }
        return (String) b4;
    }

    public final void a() {
        this.f9332a = null;
        if (this.f9334c != null) {
            this.f9334c = null;
        }
    }

    public final void b(String str) {
        v1 v1Var = this.f9334c;
        if (v1Var != null) {
            v1Var.c(str);
        }
        this.f9337g = str;
    }

    @Override // com.amap.api.col.p0003l.a8
    public final void runTask() {
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f9334c != null) {
                    String str = this.f9337g + this.f9335d;
                    String f4 = f(str);
                    if (f4 != null) {
                        this.f9334c.d(f4);
                    }
                    byte[] e4 = e(str);
                    a aVar = this.f9338h;
                    if (aVar != null && e4 != null) {
                        aVar.a(e4, this.f9339i);
                    }
                    v1.a n4 = this.f9334c.n();
                    if (n4 != null && (bArr = n4.f9198a) != null) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(new String(bArr));
                        } catch (JSONException unused) {
                        }
                        if (jSONObject == null) {
                            if (this.f9338h != null) {
                                if (!Arrays.equals(n4.f9198a, e4)) {
                                    this.f9338h.b(n4.f9198a, this.f9339i);
                                }
                            } else {
                                IAMapDelegate iAMapDelegate = this.f9333b;
                                if (iAMapDelegate != null) {
                                    iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), n4.f9198a);
                                }
                            }
                            d(str, n4.f9198a);
                            c(str, n4.f9200c);
                        }
                    }
                }
                u5.g(this.f9332a, a3.s());
                IAMapDelegate iAMapDelegate2 = this.f9333b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            u5.p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        y2.a().b(this);
    }

    public w1(Context context, IAMapDelegate iAMapDelegate) {
        this.f9335d = null;
        this.f9336e = null;
        this.f9337g = null;
        this.f9339i = 0;
        this.f9332a = context;
        this.f9333b = iAMapDelegate;
        if (this.f9334c == null) {
            this.f9334c = new v1(context, "");
        }
    }
}
