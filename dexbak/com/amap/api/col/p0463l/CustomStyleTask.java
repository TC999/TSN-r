package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.CustomStyleRequest;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.w1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CustomStyleTask extends ThreadTask {

    /* renamed from: a */
    private Context f5594a;

    /* renamed from: b */
    private IAMapDelegate f5595b;

    /* renamed from: c */
    private CustomStyleRequest f5596c;

    /* renamed from: d */
    private String f5597d;

    /* renamed from: e */
    private String f5598e;

    /* renamed from: g */
    private String f5599g;

    /* renamed from: h */
    private InterfaceC1979a f5600h;

    /* renamed from: i */
    private int f5601i;

    /* compiled from: CustomStyleTask.java */
    /* renamed from: com.amap.api.col.3l.w1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1979a {
        /* renamed from: a */
        void mo53604a(byte[] bArr, int i);

        /* renamed from: b */
        void mo53603b(byte[] bArr, int i);
    }

    public CustomStyleTask(Context context, InterfaceC1979a interfaceC1979a, int i, String str) {
        this.f5597d = null;
        this.f5598e = null;
        this.f5599g = null;
        this.f5594a = context;
        this.f5600h = interfaceC1979a;
        this.f5601i = i;
        if (this.f5596c == null) {
            this.f5596c = new CustomStyleRequest(context, "", i != 0);
        }
        this.f5596c.m53670b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.f5597d = sb.toString();
        this.f5598e = context.getCacheDir().getPath();
    }

    /* renamed from: c */
    private void m53608c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        SpUtil.m53602a(this.f5594a, "amap_style_config", "lastModified".concat(str), str2);
    }

    /* renamed from: d */
    private void m53607d(String str, byte[] bArr) {
        if (str == null || bArr == null || this.f5598e == null) {
            return;
        }
        FileUtil.saveFileContents(this.f5598e + File.separator + str, bArr);
    }

    /* renamed from: e */
    private byte[] m53606e(String str) {
        if (str == null || this.f5598e == null) {
            return null;
        }
        return FileUtil.readFileContents(this.f5598e + File.separator + str);
    }

    /* renamed from: f */
    private String m53605f(String str) {
        if (str == null) {
            return null;
        }
        Object m53601b = SpUtil.m53601b(this.f5594a, "amap_style_config", "lastModified".concat(str), "");
        if (!(m53601b instanceof String) || m53601b == "") {
            return null;
        }
        return (String) m53601b;
    }

    /* renamed from: a */
    public final void m53611a() {
        this.f5594a = null;
        if (this.f5596c != null) {
            this.f5596c = null;
        }
    }

    /* renamed from: b */
    public final void m53609b(String str) {
        CustomStyleRequest customStyleRequest = this.f5596c;
        if (customStyleRequest != null) {
            customStyleRequest.m53669c(str);
        }
        this.f5599g = str;
    }

    @Override // com.amap.api.col.p0463l.ThreadTask
    public final void runTask() {
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f5596c != null) {
                    String str = this.f5599g + this.f5597d;
                    String m53605f = m53605f(str);
                    if (m53605f != null) {
                        this.f5596c.m53668d(m53605f);
                    }
                    byte[] m53606e = m53606e(str);
                    InterfaceC1979a interfaceC1979a = this.f5600h;
                    if (interfaceC1979a != null && m53606e != null) {
                        interfaceC1979a.mo53604a(m53606e, this.f5601i);
                    }
                    CustomStyleRequest.C1967a m53534n = this.f5596c.m53534n();
                    if (m53534n != null && (bArr = m53534n.f5543a) != null) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(new String(bArr));
                        } catch (JSONException unused) {
                        }
                        if (jSONObject == null) {
                            if (this.f5600h != null) {
                                if (!Arrays.equals(m53534n.f5543a, m53606e)) {
                                    this.f5600h.mo53603b(m53534n.f5543a, this.f5601i);
                                }
                            } else {
                                IAMapDelegate iAMapDelegate = this.f5595b;
                                if (iAMapDelegate != null) {
                                    iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), m53534n.f5543a);
                                }
                            }
                            m53607d(str, m53534n.f5543a);
                            m53608c(str, m53534n.f5545c);
                        }
                    }
                }
                SDKLogHandler.m53872g(this.f5594a, C1732a3.m55691s());
                IAMapDelegate iAMapDelegate2 = this.f5595b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m53610b() {
        ThreadUtil.m53406a().m53405b(this);
    }

    public CustomStyleTask(Context context, IAMapDelegate iAMapDelegate) {
        this.f5597d = null;
        this.f5598e = null;
        this.f5599g = null;
        this.f5601i = 0;
        this.f5594a = context;
        this.f5595b = iAMapDelegate;
        if (this.f5596c == null) {
            this.f5596c = new CustomStyleRequest(context, "");
        }
    }
}
