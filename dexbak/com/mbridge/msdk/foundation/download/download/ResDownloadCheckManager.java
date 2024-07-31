package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ResDownloadCheckManager {
    private static Map<String, Boolean> recordImageMap = new HashMap();
    private Map<String, Boolean> campaignStateMap;
    private Map<String, Boolean> preLoadSuccessedMap;
    private Map<String, Boolean> recordVideoMap;
    private Map<String, Boolean> recordZipMap;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
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
                recordImageMap.put(str, Boolean.valueOf(CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22334b(str)));
            }
        }
    }

    private void addUrlToMap(CampaignEx campaignEx) {
        List<CampaignEx.C11317c.C11318a> m22633f;
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
            CampaignEx.C11317c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode == null || (m22633f = rewardTemplateMode.m22633f()) == null) {
                return;
            }
            for (CampaignEx.C11317c.C11318a c11318a : m22633f) {
                if (c11318a != null) {
                    addImageUrlToMap(c11318a.f30412b);
                }
            }
        }
    }

    private boolean checkImageUrlState(boolean z, String str) {
        boolean checkState = checkState(recordImageMap, str);
        if (checkState || CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22334b(str)) {
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

    private boolean checkZipState(boolean z, String str) {
        boolean checkState = checkState(this.recordZipMap, str);
        if (checkState || !z || TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
            return checkState;
        }
        this.recordZipMap.put(str, Boolean.TRUE);
        return true;
    }

    public static ResDownloadCheckManager getInstance() {
        return Holder.instance;
    }

    private boolean getIsEffectivePath(String str) {
        String m21744d = SameFileTool.m21744d(str);
        File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_VC) + File.separator + m21744d);
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

    private void updateCampaignState(String str, boolean z) {
        if (this.campaignStateMap == null) {
            this.campaignStateMap = new HashMap();
        }
        this.campaignStateMap.put(str, Boolean.valueOf(z));
    }

    public boolean checkImageState(boolean z, CampaignEx.C11317c c11317c) {
        List<CampaignEx.C11317c.C11318a> m22633f;
        List<String> list;
        if (c11317c != null && (m22633f = c11317c.m22633f()) != null) {
            for (CampaignEx.C11317c.C11318a c11318a : m22633f) {
                if (c11318a != null && (list = c11318a.f30412b) != null) {
                    for (String str : list) {
                        if (!checkImageUrlState(z, str)) {
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

    public void setImageDownloadDone(String str, boolean z) {
        if (recordImageMap == null) {
            recordImageMap = new HashMap();
        }
        recordImageMap.put(str, Boolean.valueOf(z));
    }

    public void setTemplatePreLoadDone(String str, boolean z) {
        if (this.preLoadSuccessedMap == null) {
            this.preLoadSuccessedMap = new HashMap();
        }
        this.preLoadSuccessedMap.put(str, Boolean.valueOf(z));
    }

    public void setVideoDownloadDone(String str, boolean z) {
        if (this.recordVideoMap == null) {
            this.recordVideoMap = new HashMap();
        }
        this.recordVideoMap.put(str, Boolean.valueOf(z));
    }

    public void setZipDownloadDone(String str, boolean z) {
        if (this.recordZipMap == null) {
            this.recordZipMap = new HashMap();
        }
        this.recordZipMap.put(str, Boolean.valueOf(z));
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
