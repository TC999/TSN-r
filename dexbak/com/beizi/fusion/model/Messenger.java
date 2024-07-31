package com.beizi.fusion.model;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.beizi.fusion.model.JsonResolver;
import com.umeng.analytics.pro.UContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Messenger {
    @JsonNode(key = "checkInterval")
    private long checkInterval;
    @JsonNode(key = "configVersion")
    private String configVersion;
    @JsonNode(key = UContent.f38134ax)
    private List<EventsBean> events;
    @JsonNode(key = "expireTime")
    private long expireTime;
    @JsonNode(key = "fileMaxSize")
    private String fileMaxSize;
    @JsonNode(key = "id")

    /* renamed from: id */
    private String f11483id;
    @JsonNode(key = "job")
    private String job;
    @JsonNode(key = ConstantHelper.LOG_VS)
    private String version;

    public static List<Messenger> arrayMessengerFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Messenger>>() { // from class: com.beizi.fusion.model.Messenger.1
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Messenger objectFromData(String str) {
        try {
            return (Messenger) JsonResolver.fromJson(str, (Class<Object>) Messenger.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public List<EventsBean> getEvents() {
        return this.events;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFileMaxSize() {
        return this.fileMaxSize;
    }

    public String getId() {
        return this.f11483id;
    }

    public String getJob() {
        return this.job;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCheckInterval(long j) {
        this.checkInterval = j;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setEvents(List<EventsBean> list) {
        this.events = list;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public void setFileMaxSize(String str) {
        this.fileMaxSize = str;
    }

    public void setId(String str) {
        this.f11483id = str;
    }

    public void setJob(String str) {
        this.job = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "Messenger{configVersion='" + this.configVersion + "', id='" + this.f11483id + "', job='" + this.job + "', version='" + this.version + "', checkInterval=" + this.checkInterval + ", expireTime=" + this.expireTime + ", fileMaxSize='" + this.fileMaxSize + "', events=" + this.events + '}';
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class EventsBean {
        @JsonNode(key = "codes")
        private List<String> codes;
        @JsonNode(key = "isOnline")
        private String isOnline;
        @JsonNode(key = "offlineUrl")
        private String offlineUrl;
        @JsonNode(key = "uploadUrl")
        private String uploadUrl;

        public static List<EventsBean> arrayEventsBeanFromData(String str) {
            try {
                return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<EventsBean>>() { // from class: com.beizi.fusion.model.Messenger.EventsBean.1
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static EventsBean objectFromData(String str) {
            try {
                return (EventsBean) JsonResolver.fromJson(str, (Class<Object>) EventsBean.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public List<String> getCodes() {
            return this.codes;
        }

        public String getIsOnline() {
            return this.isOnline;
        }

        public String getOfflineUrl() {
            return this.offlineUrl;
        }

        public String getUploadUrl() {
            return this.uploadUrl;
        }

        public void setCodes(List<String> list) {
            this.codes = list;
        }

        public void setIsOnline(String str) {
            this.isOnline = str;
        }

        public void setOfflineUrl(String str) {
            this.offlineUrl = str;
        }

        public void setUploadUrl(String str) {
            this.uploadUrl = str;
        }

        public String toString() {
            return "EventsBean{uploadUrl='" + this.uploadUrl + "', offlineUrl='" + this.offlineUrl + "', isOnline='" + this.isOnline + "', codes=" + this.codes + '}';
        }

        public static EventsBean objectFromData(String str, String str2) {
            try {
                return (EventsBean) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) EventsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public static List<EventsBean> arrayEventsBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<EventsBean>>() { // from class: com.beizi.fusion.model.Messenger.EventsBean.2
                }.getType());
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList();
            } catch (Exception e2) {
                e2.printStackTrace();
                return new ArrayList();
            }
        }
    }

    public static Messenger objectFromData(String str, String str2) {
        try {
            return (Messenger) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) Messenger.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<Messenger> arrayMessengerFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Messenger>>() { // from class: com.beizi.fusion.model.Messenger.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }
}
