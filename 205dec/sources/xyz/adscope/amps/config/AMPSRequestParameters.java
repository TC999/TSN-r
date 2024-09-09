package xyz.adscope.amps.config;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSRequestParameters {
    private int adCount;
    private Map<String, Object> customExtraParameters;
    private String extraData;
    private int height;
    private String jsonObject;
    private String loadType;
    private String spaceId;
    private int timeOut;
    private String userId;
    private int width;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        private String extraData;
        private int height;
        private String spaceId;
        private String userId;
        private int width;
        private int timeOut = 5000;
        private int adCount = 1;

        public AMPSRequestParameters build() {
            AMPSRequestParameters aMPSRequestParameters = new AMPSRequestParameters();
            aMPSRequestParameters.setSpaceId(this.spaceId);
            aMPSRequestParameters.setWidth(this.width);
            aMPSRequestParameters.setHeight(this.height);
            aMPSRequestParameters.setUserId(this.userId);
            aMPSRequestParameters.setExtraData(this.extraData);
            aMPSRequestParameters.setTimeOut(this.timeOut);
            aMPSRequestParameters.setAdCount(this.adCount);
            return aMPSRequestParameters;
        }

        public Builder setAdCount(int i4) {
            this.adCount = i4;
            return this;
        }

        public Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public Builder setHeight(int i4) {
            this.height = i4;
            return this;
        }

        public Builder setSpaceId(String str) {
            this.spaceId = str;
            return this;
        }

        public Builder setTimeOut(int i4) {
            this.timeOut = i4;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setWidth(int i4) {
            this.width = i4;
            return this;
        }
    }

    public int getAdCount() {
        return this.adCount;
    }

    public Map<String, Object> getCustomExtraParameters() {
        return this.customExtraParameters;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public int getHeight() {
        return this.height;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public String getLoadType() {
        return this.loadType;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAdCount(int i4) {
        this.adCount = i4;
    }

    public void setCustomExtraParameters(Map<String, Object> map) {
        this.customExtraParameters = map;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setHeight(int i4) {
        this.height = i4;
    }

    public void setJsonObject(String str) {
        this.jsonObject = str;
    }

    public void setLoadType(String str) {
        this.loadType = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTimeOut(int i4) {
        this.timeOut = i4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWidth(int i4) {
        this.width = i4;
    }
}
