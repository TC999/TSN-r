package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bk implements aa.a {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ bj f12491c;

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bk f12492a = new bk((bl) null);

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.f12491c = bjVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.f12491c.f12482i.a("XAbstractProdTemplate", "AbstractProdTemplate,load-dex\u8bf7\u6c42\uff0c\u56de\u8c03\u5931\u8d25");
        this.f12491c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.f12491c.f12482i.a("XAbstractProdTemplate", "AbstractProdTemplate,load-dex\u8bf7\u6c42\uff0c\u56de\u8c03\u6210\u529f");
        this.f12491c.i();
    }
}
