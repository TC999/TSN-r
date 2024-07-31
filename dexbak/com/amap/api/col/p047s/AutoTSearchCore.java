package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.s.h0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AutoTSearchCore implements IAutoTSearch {

    /* renamed from: a */
    private Context f6143a;

    /* renamed from: b */
    private Handler f6144b;

    /* renamed from: c */
    private AutoTSearch.Query f6145c;

    /* renamed from: d */
    private AutoTSearch.OnChargeStationListener f6146d;

    /* compiled from: AutoTSearchCore.java */
    /* renamed from: com.amap.api.col.s.h0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2065a implements Runnable {
        RunnableC2065a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2166a c2166a;
            Message obtainMessage = AutoTSearchCore.this.f6144b.obtainMessage();
            obtainMessage.arg1 = 20;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            AutoTChargeStationResult autoTChargeStationResult = null;
            try {
                try {
                    autoTChargeStationResult = AutoTSearchCore.this.searchChargeStation();
                    bundle.putInt("errorCode", 1000);
                    c2166a = new MessageHandler.C2166a();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2166a = new MessageHandler.C2166a();
                }
                c2166a.f6559b = AutoTSearchCore.this.f6146d;
                c2166a.f6558a = autoTChargeStationResult;
                obtainMessage.obj = c2166a;
                obtainMessage.setData(bundle);
                AutoTSearchCore.this.f6144b.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2166a c2166a2 = new MessageHandler.C2166a();
                c2166a2.f6559b = AutoTSearchCore.this.f6146d;
                c2166a2.f6558a = autoTChargeStationResult;
                obtainMessage.obj = c2166a2;
                obtainMessage.setData(bundle);
                AutoTSearchCore.this.f6144b.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public AutoTSearchCore(Context context) throws AMapException {
        this.f6144b = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6143a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6144b = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6143a);
            AutoTSearch.Query query = this.f6145c;
            if (query != null) {
                return new AutoTPoiSearchHandler(this.f6143a, query.m60109clone()).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            throw new AMapException(e.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void searchChargeStationAsync() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2065a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f6146d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setQuery(AutoTSearch.Query query) {
        this.f6145c = query;
    }
}
