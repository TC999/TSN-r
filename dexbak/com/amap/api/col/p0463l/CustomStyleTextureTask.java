package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.CustomStyleTextureRequest;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* renamed from: com.amap.api.col.3l.y1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CustomStyleTextureTask extends ThreadTask {

    /* renamed from: a */
    private Context f5780a;

    /* renamed from: b */
    private CustomStyleTextureRequest f5781b;

    /* renamed from: c */
    private StyleParserResult f5782c;

    /* renamed from: d */
    private InterfaceC2006a f5783d;

    /* compiled from: CustomStyleTextureTask.java */
    /* renamed from: com.amap.api.col.3l.y1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2006a {
        /* renamed from: a */
        void mo53407a(String str, StyleParserResult styleParserResult);
    }

    public CustomStyleTextureTask(Context context) {
        this.f5780a = context;
        if (this.f5781b == null) {
            this.f5781b = new CustomStyleTextureRequest(context, "");
        }
    }

    /* renamed from: a */
    private static String m53413a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    /* renamed from: e */
    private static void m53408e(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    /* renamed from: b */
    public final void m53412b() {
        ThreadUtil.m53406a().m53405b(this);
    }

    /* renamed from: c */
    public final void m53410c(StyleParserResult styleParserResult) {
        this.f5782c = styleParserResult;
    }

    /* renamed from: d */
    public final void m53409d(String str) {
        CustomStyleTextureRequest customStyleTextureRequest = this.f5781b;
        if (customStyleTextureRequest != null) {
            customStyleTextureRequest.m53562b(str);
        }
    }

    @Override // com.amap.api.col.p0463l.ThreadTask
    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                CustomStyleTextureRequest customStyleTextureRequest = this.f5781b;
                if (customStyleTextureRequest != null) {
                    CustomStyleTextureRequest.C1982a m53534n = customStyleTextureRequest.m53534n();
                    String str = null;
                    if (m53534n != null && m53534n.f5656a != null) {
                        str = m53413a(this.f5780a) + "/custom_texture_data";
                        m53408e(str, m53534n.f5656a);
                    }
                    InterfaceC2006a interfaceC2006a = this.f5783d;
                    if (interfaceC2006a != null) {
                        interfaceC2006a.mo53407a(str, this.f5782c);
                    }
                }
                SDKLogHandler.m53872g(this.f5780a, C1732a3.m55691s());
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m53414a() {
        this.f5780a = null;
        if (this.f5781b != null) {
            this.f5781b = null;
        }
    }

    /* renamed from: b */
    public final void m53411b(InterfaceC2006a interfaceC2006a) {
        this.f5783d = interfaceC2006a;
    }
}
