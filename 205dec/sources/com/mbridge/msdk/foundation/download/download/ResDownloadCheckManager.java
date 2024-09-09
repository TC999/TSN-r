package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.v;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ResDownloadCheckManager {
    private static Map<String, Boolean> recordImageMap = new HashMap();
    private Map<String, Boolean> campaignStateMap;
    private Map<String, Boolean> preLoadSuccessedMap;
    private Map<String, Boolean> recordVideoMap;
    private Map<String, Boolean> recordZipMap;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static final class Holder {
        public static ResDownloadCheckManager instance = new ResDownloadCheckManager();

        private Holder() {
        }
    }

    private void addImageUrlToMap(List<String> list) {
        Map<String, Boolean> map;
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && (map = recordImageMap) != null && !map.containsKey(str)) {
                recordImageMap.put(str, Boolean.valueOf(b.a(a.f().j()).b(str)));
            }
        }
    }

    private void addUrlToMap(CampaignEx campaignEx) {
        List<CampaignEx.c.a> f4;
        if (campaignEx != null) {
            String videoUrlEncode = campaignEx.getVideoUrlEncode();
            Map<String, Boolean> map = this.recordVideoMap;
            if (map != null && !map.containsKey(videoUrlEncode)) {
                this.recordVideoMap.put(videoUrlEncode, Boolean.FALSE);
            }
            String str = campaignEx.getendcard_url();
            Map<String, Boolean> map2 = this.recordZipMap;
            if (map2 != null && !map2.containsKey(str)) {
                this.recordZipMap.put(str, Boolean.FALSE);
            }
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode == null || (f4 = rewardTemplateMode.f()) == null) {
                return;
            }
            for (CampaignEx.c.a aVar : f4) {
                if (aVar != null) {
                    addImageUrlToMap(aVar.f39235b);
                }
            }
        }
    }

    private boolean checkImageUrlState(boolean z3, String str) {
        boolean checkState = checkState(recordImageMap, str);
        if (checkState || b.a(a.f().j()).b(str)) {
            return true;
        }
        return checkState;
    }

    private boolean checkState(Map<String, Boolean> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (map != null) {
            if (map.containsKey(str)) {
                return map.get(str).booleanValue();
            }
            map.put(str, Boolean.FALSE);
            return false;
        }
        new HashMap().put(str, Boolean.FALSE);
        return false;
    }

    private boolean checkZipState(boolean z3, String str) {
        boolean checkState = checkState(this.recordZipMap, str);
        if (checkState || !z3 || TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
            return checkState;
        }
        this.recordZipMap.put(str, Boolean.TRUE);
        return true;
    }

    public static ResDownloadCheckManager getInstance() {
        return Holder.instance;
    }

    private boolean getIsEffectivePath(String str) {
        String d4 = v.d(str);
        File file = new File(e.b(c.MBRIDGE_VC) + File.separator + d4);
        try {
            if (file.exists() && file.isFile()) {
                return file.canRead();
            }
            return false;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private void updateCampaignState(String str, boolean z3) {
        if (this.campaignStateMap == null) {
            this.campaignStateMap = new HashMap();
        }
        this.campaignStateMap.put(str, Boolean.valueOf(z3));
    }

    public boolean checkImageState(boolean z3, CampaignEx.c cVar) {
        List<CampaignEx.c.a> f4;
        List<String> list;
        if (cVar != null && (f4 = cVar.f()) != null) {
            for (CampaignEx.c.a aVar : f4) {
                if (aVar != null && (list = aVar.f39235b) != null) {
                    for (String str : list) {
                        if (!checkImageUrlState(z3, str)) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return true;
    }

    public boolean checkPreLoadState(String str) {
        if (!TextUtils.isEmpty(str) && this.preLoadSuccessedMap.containsKey(str)) {
            return this.preLoadSuccessedMap.get(str).booleanValue();
        }
        return false;
    }

    public boolean containsVideoKey(String str) {
        if (this.recordVideoMap == null || TextUtils.isEmpty(str) || !this.recordVideoMap.containsKey(str)) {
            return false;
        }
        return this.recordVideoMap.get(str).booleanValue();
    }

    public boolean containsZipKey(String str) {
        if (this.recordZipMap == null || TextUtils.isEmpty(str) || !this.recordZipMap.containsKey(str)) {
            return false;
        }
        return this.recordZipMap.get(str).booleanValue();
    }

    public void removePreLoadState(String str) {
        if (this.preLoadSuccessedMap.containsKey(str)) {
            this.preLoadSuccessedMap.remove(str);
        }
    }

    public void setCampaignList(List<CampaignEx> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                addUrlToMap(campaignEx);
                updateCampaignState(campaignEx.getId(), false);
            }
        }
    }

    public void setImageDownloadDone(String str, boolean z3) {
        if (recordImageMap == null) {
            recordImageMap = new HashMap();
        }
        recordImageMap.put(str, Boolean.valueOf(z3));
    }

    public void setTemplatePreLoadDone(String str, boolean z3) {
        if (this.preLoadSuccessedMap == null) {
            this.preLoadSuccessedMap = new HashMap();
        }
        this.preLoadSuccessedMap.put(str, Boolean.valueOf(z3));
    }

    public void setVideoDownloadDone(String str, boolean z3) {
        if (this.recordVideoMap == null) {
            this.recordVideoMap = new HashMap();
        }
        this.recordVideoMap.put(str, Boolean.valueOf(z3));
    }

    public void setZipDownloadDone(String str, boolean z3) {
        if (this.recordZipMap == null) {
            this.recordZipMap = new HashMap();
        }
        this.recordZipMap.put(str, Boolean.valueOf(z3));
    }

    private ResDownloadCheckManager() {
        this.recordVideoMap = new HashMap();
        this.recordZipMap = new HashMap();
        this.campaignStateMap = new HashMap();
        this.preLoadSuccessedMap = new HashMap();
    }

    public void setCampaignList(CampaignEx campaignEx) {
        if (campaignEx != null) {
            addUrlToMap(campaignEx);
            updateCampaignState(campaignEx.getId(), false);
        }
    }
}
