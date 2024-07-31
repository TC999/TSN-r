package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* renamed from: com.baidu.mobads.sdk.internal.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2705f {

    /* renamed from: a */
    private C2692dj f9065a;

    /* renamed from: b */
    private String f9066b;

    /* renamed from: com.baidu.mobads.sdk.internal.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2706a {
        /* renamed from: a */
        void mo50405a();

        /* renamed from: a */
        void mo50404a(int i, String str);

        /* renamed from: a */
        void mo50403a(NativeResponse nativeResponse);

        /* renamed from: a */
        void mo50402a(NativeResponse nativeResponse, int i);

        /* renamed from: a */
        void mo50401a(List<NativeResponse> list);

        /* renamed from: b */
        void mo50400b();

        /* renamed from: b */
        void mo50399b(int i, String str);

        /* renamed from: b */
        void mo50398b(NativeResponse nativeResponse);

        /* renamed from: c */
        void mo50397c();
    }

    /* renamed from: com.baidu.mobads.sdk.internal.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2707b {
        /* renamed from: a */
        void mo50396a(NativeResponse nativeResponse);
    }

    public C2705f(Context context, String str, InterfaceC2706a interfaceC2706a, boolean z, int i) {
        this(context, interfaceC2706a, new C2692dj(context, str, "feed", z, i));
    }

    /* renamed from: a */
    public void m50414a() {
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.m50810e();
        }
    }

    /* renamed from: b */
    public void m50408b() {
        m50407b((RequestParameters) null);
    }

    public C2705f(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        C2692dj c2692dj = new C2692dj(context, str, "feed", z, i);
        this.f9065a = c2692dj;
        c2692dj.m50522a(expressAdListener);
        this.f9065a.m50526a(1);
    }

    /* renamed from: b */
    public void m50407b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.m50809h(this.f9066b);
        }
        this.f9065a.m50521a(requestParameters);
        this.f9065a.mo50356a();
    }

    /* renamed from: a */
    public void m50411a(InterfaceC2707b interfaceC2707b) {
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.m50518a(interfaceC2707b);
        }
    }

    /* renamed from: a */
    public void m50413a(int i) {
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.f8671p = i;
        }
    }

    public C2705f(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        C2692dj c2692dj = new C2692dj(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.f9065a = c2692dj;
        c2692dj.m50523a(entryAdListener);
    }

    /* renamed from: a */
    public void m50409a(boolean z) {
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.m50513c(z);
        }
    }

    /* renamed from: b */
    public void m50406b(String str) {
        this.f9066b = str;
    }

    public C2705f(Context context, String str, InterfaceC2706a interfaceC2706a, boolean z, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f9065a = new C2692dj(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f9065a = new C2692dj(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f9065a = new C2692dj(context, str, "video", z, i);
            } else {
                this.f9065a = new C2692dj(context, str, "feed", z, i);
            }
        }
        this.f9065a.m50519a(interfaceC2706a);
    }

    /* renamed from: a */
    public String m50412a(RequestParameters requestParameters) {
        if (this.f9065a != null) {
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            this.f9065a.m50809h(this.f9066b);
            this.f9065a.m50521a(requestParameters);
            return this.f9065a.m50806m();
        }
        return null;
    }

    /* renamed from: a */
    public void m50410a(String str) {
        C2692dj c2692dj = this.f9065a;
        if (c2692dj != null) {
            c2692dj.m50814b(str);
        }
    }

    public C2705f(Context context, InterfaceC2706a interfaceC2706a, C2692dj c2692dj) {
        this.f9065a = c2692dj;
        c2692dj.m50519a(interfaceC2706a);
    }
}
