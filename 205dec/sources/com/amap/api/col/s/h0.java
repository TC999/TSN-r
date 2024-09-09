package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AutoTSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h0 implements IAutoTSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f9871a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f9872b;

    /* renamed from: c  reason: collision with root package name */
    private AutoTSearch.Query f9873c;

    /* renamed from: d  reason: collision with root package name */
    private AutoTSearch.OnChargeStationListener f9874d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AutoTSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.a aVar;
            Message obtainMessage = h0.this.f9872b.obtainMessage();
            obtainMessage.arg1 = 20;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            AutoTChargeStationResult autoTChargeStationResult = null;
            try {
                try {
                    autoTChargeStationResult = h0.this.searchChargeStation();
                    bundle.putInt("errorCode", 1000);
                    aVar = new u4.a();
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                    aVar = new u4.a();
                }
                aVar.f10287b = h0.this.f9874d;
                aVar.f10286a = autoTChargeStationResult;
                obtainMessage.obj = aVar;
                obtainMessage.setData(bundle);
                h0.this.f9872b.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.a aVar2 = new u4.a();
                aVar2.f10287b = h0.this.f9874d;
                aVar2.f10286a = autoTChargeStationResult;
                obtainMessage.obj = aVar2;
                obtainMessage.setData(bundle);
                h0.this.f9872b.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public h0(Context context) throws AMapException {
        this.f9872b = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f9871a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9872b = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            s4.d(this.f9871a);
            AutoTSearch.Query query = this.f9873c;
            if (query != null) {
                return new b0(this.f9871a, query.m30clone()).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            throw new AMapException(e4.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void searchChargeStationAsync() {
        try {
            y.a().b(new a());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f9874d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setQuery(AutoTSearch.Query query) {
        this.f9873c = query;
    }
}
