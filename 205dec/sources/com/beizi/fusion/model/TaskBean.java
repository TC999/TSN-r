package com.beizi.fusion.model;

import com.beizi.fusion.model.JsonResolver;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TaskBean {
    @JsonNode(key = "backTaskArray")
    private List<BackTaskArrayBean> backTaskArray;
    @JsonNode(key = "checkInterval")
    private long checkInterval;
    @JsonNode(key = "expired")
    private long expired;

    public static List<TaskBean> arrayTaskBeanFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskBean.1
            }.getType());
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static TaskBean objectFromData(String str) {
        try {
            return (TaskBean) JsonResolver.fromJson(str, (Class<Object>) TaskBean.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<BackTaskArrayBean> getBackTaskArray() {
        return this.backTaskArray;
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public long getExpired() {
        return this.expired;
    }

    public void setBackTaskArray(List<BackTaskArrayBean> list) {
        this.backTaskArray = list;
    }

    public void setCheckInterval(long j4) {
        this.checkInterval = j4;
    }

    public void setExpired(long j4) {
        this.expired = j4;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class BackTaskArrayBean {
        @JsonNode(key = "action")
        private List<String> action;
        @JsonNode(key = "apps")
        private List<AppLinkBean> apps;
        @JsonNode(key = "contentUrl")
        private String contentUrl;
        @JsonNode(key = "method")
        private String method;
        @JsonNode(key = "repeatCount")
        private int repeatCount;
        @JsonNode(key = "report")
        private List<String> report;
        @JsonNode(key = "showTime")
        private long showTime;
        @JsonNode(key = "sleepTime")
        private long sleepTime;
        @JsonNode(key = "type")
        private int type;
        @JsonNode(key = "userAgent")
        private String userAgent;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class AppLinkBean {
            @JsonNode(key = "appLinkId")
            private String appLinkId;
            @JsonNode(key = "testLink")
            private String testLink;

            public String getAppLinkId() {
                return this.appLinkId;
            }

            public String getTestLink() {
                return this.testLink;
            }

            public void setAppLinkId(String str) {
                this.appLinkId = str;
            }

            public void setTestLink(String str) {
                this.testLink = str;
            }
        }

        public static List<BackTaskArrayBean> arrayBackTaskArrayBeanFromData(String str) {
            try {
                return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskBean.BackTaskArrayBean.1
                }.getType());
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        public static BackTaskArrayBean objectFromData(String str) {
            try {
                return (BackTaskArrayBean) JsonResolver.fromJson(str, (Class<Object>) BackTaskArrayBean.class);
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        public List<String> getAction() {
            return this.action;
        }

        public List<AppLinkBean> getApps() {
            return this.apps;
        }

        public String getContentUrl() {
            return this.contentUrl;
        }

        public String getMethod() {
            return this.method;
        }

        public int getRepeatCount() {
            return this.repeatCount;
        }

        public List<String> getReport() {
            return this.report;
        }

        public long getShowTime() {
            return this.showTime;
        }

        public long getSleepTime() {
            return this.sleepTime;
        }

        public int getType() {
            return this.type;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public void setAction(List<String> list) {
            this.action = list;
        }

        public void setApps(List<AppLinkBean> list) {
            this.apps = list;
        }

        public void setContentUrl(String str) {
            this.contentUrl = str;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public void setRepeatCount(int i4) {
            this.repeatCount = i4;
        }

        public void setReport(List<String> list) {
            this.report = list;
        }

        public void setShowTime(long j4) {
            this.showTime = j4;
        }

        public void setSleepTime(long j4) {
            this.sleepTime = j4;
        }

        public void setType(int i4) {
            this.type = i4;
        }

        public void setUserAgent(String str) {
            this.userAgent = str;
        }

        public static BackTaskArrayBean objectFromData(String str, String str2) {
            try {
                return (BackTaskArrayBean) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) BackTaskArrayBean.class);
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        }

        public static List<BackTaskArrayBean> arrayBackTaskArrayBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskBean.BackTaskArrayBean.2
                }.getType());
            } catch (JSONException e4) {
                e4.printStackTrace();
                return new ArrayList();
            } catch (Exception e5) {
                e5.printStackTrace();
                return new ArrayList();
            }
        }
    }

    public static TaskBean objectFromData(String str, String str2) {
        try {
            return (TaskBean) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) TaskBean.class);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static List<TaskBean> arrayTaskBeanFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskBean.2
            }.getType());
        } catch (JSONException e4) {
            e4.printStackTrace();
            return new ArrayList();
        } catch (Exception e5) {
            e5.printStackTrace();
            return new ArrayList();
        }
    }
}
