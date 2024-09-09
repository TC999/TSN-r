package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private dm f12851a;

    /* renamed from: b  reason: collision with root package name */
    private String f12852b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();

        void a(int i4, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i4);

        void a(List<NativeResponse> list);

        void b();

        void b(int i4, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public f(Context context, String str, a aVar, boolean z3, int i4) {
        this(context, aVar, new dm(context, str, "feed", z3, i4));
    }

    public void a() {
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public f(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z3, int i4) {
        dm dmVar = new dm(context, str, "feed", z3, i4);
        this.f12851a = dmVar;
        dmVar.a(expressAdListener);
        this.f12851a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.h(this.f12852b);
        }
        this.f12851a.a(requestParameters);
        this.f12851a.a();
    }

    public void a(b bVar) {
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.a(bVar);
        }
    }

    public void a(int i4) {
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.f12489p = i4;
        }
    }

    public f(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z3, int i4) {
        dm dmVar = new dm(context, str, "sones", z3, i4);
        this.f12851a = dmVar;
        dmVar.a(entryAdListener);
    }

    public void a(boolean z3) {
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.c(z3);
        }
    }

    public void b(String str) {
        this.f12852b = str;
    }

    public f(Context context, String str, a aVar, boolean z3, int i4, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("insite")) {
                this.f12851a = new dm(context, str, "insite", z3, i4);
            } else if (str2.equals("sug")) {
                this.f12851a = new dm(context, str, "sug", z3, i4);
            } else if (str2.equals("preroll")) {
                this.f12851a = new dm(context, str, "video", z3, i4);
            } else {
                this.f12851a = new dm(context, str, "feed", z3, i4);
            }
        }
        this.f12851a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f12851a != null) {
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            this.f12851a.h(this.f12852b);
            this.f12851a.a(requestParameters);
            return this.f12851a.m();
        }
        return null;
    }

    public void a(String str) {
        dm dmVar = this.f12851a;
        if (dmVar != null) {
            dmVar.b(str);
        }
    }

    public f(Context context, a aVar, dm dmVar) {
        this.f12851a = dmVar;
        dmVar.a(aVar);
    }
}
