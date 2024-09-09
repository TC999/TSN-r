package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
class ANNativeUnifiedAdAdapter extends BaseNativeUnifiedAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private List<NativeUnifiedADData> data;
    private i delegate;
    private ADListener listener;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            List list;
            if (aDEvent == null) {
                return;
            }
            if (aDEvent.getType() == 100 && (list = (List) aDEvent.getParam(List.class)) != null) {
                ANNativeUnifiedAdAdapter.this.data = list;
            }
            ANNativeUnifiedAdAdapter.this.listener.onADEvent(aDEvent);
        }
    }

    public ANNativeUnifiedAdAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.delegate = new i(context, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, com.qq.e.comm.plugin.b.l.f42028e, "", new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public int getAdapterPriority() {
        return this.delegate.g();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.delegate.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.delegate.getCompetitionWinUrls();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return this.data.get(0).getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        List<NativeUnifiedADData> list = this.data;
        if (list != null && !list.isEmpty()) {
            return this.data.get(0).getExtraInfo();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.delegate.getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj;
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty() || (obj = this.data.get(0).getExtraInfo().get(ConstantAd.KEY_CACHE_AD)) == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean isContractAd() {
        return false;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void loadData(int i4) {
        this.data = null;
        this.delegate.loadData(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setAdListener(ADListener aDListener) {
        this.listener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setCategories(List<String> list) {
        this.delegate.setCategories(list);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setECPMLevel(String str) {
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<NativeUnifiedADData> it = this.data.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(str);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMaxVideoDuration(int i4) {
        this.delegate.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.delegate.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMinVideoDuration(int i4) {
        this.delegate.setMinVideoDuration(i4);
    }
}
