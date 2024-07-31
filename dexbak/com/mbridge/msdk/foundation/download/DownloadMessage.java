package com.mbridge.msdk.foundation.download;

import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadMessage<T> {
    private T campaign;
    private int downloadRate;
    private DownloadResourceType downloadResourceType;
    private String downloadUrl;
    private Map<String, Object> extraData;
    private String resourceUrl;
    private String saveFileName;
    private String saveFilePath;
    private String md5 = "";
    private boolean checkMD5 = false;
    private int from = 0;

    public DownloadMessage(T t, String str, String str2, int i, DownloadResourceType downloadResourceType) {
        this.campaign = t;
        this.downloadUrl = str;
        this.saveFileName = str2;
        this.downloadRate = i;
        this.downloadResourceType = downloadResourceType;
        try {
            URL url = new URL(str);
            this.resourceUrl = url.getProtocol() + "://" + url.getHost() + url.getPath();
            ILogger logger = GlobalComponent.getInstance().getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append(" resourceUrl: ");
            sb.append(this.resourceUrl);
            logger.log("DownloadMessage", sb.toString());
        } catch (MalformedURLException unused) {
            this.resourceUrl = "";
        }
    }

    public void addExtra(String str, Object obj) {
        if (this.extraData == null) {
            this.extraData = new HashMap(4);
        }
        this.extraData.put(str, obj);
    }

    public T getCampaign() {
        return this.campaign;
    }

    public int getDownloadRate() {
        return this.downloadRate;
    }

    public DownloadResourceType getDownloadResourceType() {
        return this.downloadResourceType;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public Object getExtra(String str) {
        Map<String, Object> map = this.extraData;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.extraData.get(str);
    }

    public int getFrom() {
        return this.from;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public String getSaveFileName() {
        return this.saveFileName;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public boolean isCheckMD5() {
        return this.checkMD5;
    }

    public void setCheckMD5(boolean z) {
        this.checkMD5 = z;
    }

    public void setDownloadRate(int i) {
        this.downloadRate = i;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }
}
