package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b {
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static String SUFFIX_ALL_CHILDREN = "/*";
    public static String SUFFIX_ALL_FILE = "*";
    private static final long serialVersionUID = 3026909056348431027L;
    private AppStatusInfo data = new AppStatusInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -2403646317801179050L;
        private ArrayList<Strategy> namedStrategy;
        private Strategy strategy;
        private ArrayList<com.kwad.sdk.collector.model.d> target;
        private UploadConfig uploadConfig;
        private ArrayList<com.kwad.sdk.collector.model.d> uploadTarget;

        private AppStatusInfo() {
            this.strategy = new Strategy();
            this.target = new ArrayList<>();
            this.namedStrategy = new ArrayList<>();
            this.uploadTarget = new ArrayList<>();
            this.uploadConfig = new UploadConfig();
        }

        private void duplicateTarget() {
            Set<String> targetPackages = this.strategy.getTargetPackages();
            HashSet hashSet = new HashSet();
            Iterator<Strategy> it = this.namedStrategy.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().getTargetPackages());
            }
            targetPackages.retainAll(hashSet);
            this.strategy.removeTargetsByPackage(targetPackages);
        }

        public Strategy getStrategy() {
            return this.strategy;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("namedStrategy")) {
                    this.namedStrategy = Strategy.createFromJSONArray(jSONObject.getJSONArray("namedStrategy"));
                }
                if (jSONObject.has("uploadTarget")) {
                    this.uploadTarget = com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("uploadTarget"));
                }
                if (jSONObject.has("uploadConfig")) {
                    this.uploadConfig.parseJson(jSONObject.optJSONObject("uploadConfig"));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                ArrayList<com.kwad.sdk.collector.model.d> d4 = com.kwad.sdk.collector.model.c.d(optJSONArray);
                this.target = d4;
                this.strategy.setTarget(d4);
                duplicateTarget();
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "strategy", this.strategy);
            t.putValue(jSONObject, "target", this.target);
            t.putValue(jSONObject, "namedStrategy", this.namedStrategy);
            t.putValue(jSONObject, "uploadTarget", this.uploadTarget);
            t.a(jSONObject, "uploadConfig", this.uploadConfig);
            return jSONObject;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static Strategy LOCAL_DEFAULT = null;
        private static final long serialVersionUID = -1387498537762043285L;
        private long minLaunchInterval;
        private long scanInterval;
        private long startTime = 86400000;
        private long historyGranularity = 60000;
        private String name = null;
        private HashMap<String, com.kwad.sdk.collector.model.d> targetMap = new HashMap<>();
        private boolean needLaunch = true;
        private long needSaveLaunchTime = -1;

        static {
            Strategy strategy = new Strategy();
            LOCAL_DEFAULT = strategy;
            strategy.setStartTime(86400000L);
            LOCAL_DEFAULT.setHistoryGranularity(60000L);
        }

        public static ArrayList<Strategy> createFromJSONArray(JSONArray jSONArray) {
            ArrayList<Strategy> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONArray.getJSONObject(i4);
                    } catch (JSONException unused) {
                    }
                    if (jSONObject != null) {
                        Strategy strategy = new Strategy();
                        strategy.parseJson(jSONObject);
                        arrayList.add(strategy);
                    }
                }
            }
            return arrayList;
        }

        public long getHistoryGranularity() {
            return this.historyGranularity;
        }

        public long getMinLaunchIntervalWithMS() {
            return this.minLaunchInterval * 1000;
        }

        public String getName() {
            return this.name;
        }

        public long getNeedSaveLaunchTime() {
            return this.needSaveLaunchTime;
        }

        public long getScanInterval() {
            return this.scanInterval;
        }

        public long getStartTimeWithMS() {
            return this.startTime * 1000;
        }

        public ArrayList<com.kwad.sdk.collector.model.d> getTarget() {
            return new ArrayList<>(this.targetMap.values());
        }

        public Set<String> getTargetPackages() {
            Collection<com.kwad.sdk.collector.model.d> values = this.targetMap.values();
            HashSet hashSet = new HashSet();
            for (com.kwad.sdk.collector.model.d dVar : values) {
                hashSet.add(com.kwad.sdk.collector.model.c.a(dVar));
            }
            return hashSet;
        }

        public boolean isNeedLaunch() {
            return this.needLaunch;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.startTime = jSONObject.optLong("startTime");
                this.scanInterval = jSONObject.optLong("scanInterval");
                int optInt = jSONObject.optInt("historyGranularity");
                if (optInt > 0) {
                    this.historyGranularity = optInt * 1000;
                }
                this.name = jSONObject.optString("name");
                this.minLaunchInterval = jSONObject.optLong("minLaunchInterval");
                this.needSaveLaunchTime = jSONObject.optLong("needSaveLaunchTime");
                this.needLaunch = jSONObject.optBoolean("needLaunch");
                setTarget(com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("target")));
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }

        public void removeTargetsByPackage(Collection<String> collection) {
            for (String str : collection) {
                this.targetMap.remove(str);
            }
        }

        public void setHistoryGranularity(long j4) {
            this.historyGranularity = j4;
        }

        public void setNeedLaunch(boolean z3) {
            this.needLaunch = z3;
        }

        public void setNeedSaveLaunchTime(long j4) {
            this.needSaveLaunchTime = j4;
        }

        public void setScanInterval(long j4) {
            this.scanInterval = j4;
        }

        public void setStartTime(long j4) {
            this.startTime = j4;
        }

        public void setTarget(ArrayList<com.kwad.sdk.collector.model.d> arrayList) {
            if (arrayList != null) {
                Iterator<com.kwad.sdk.collector.model.d> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.collector.model.d next = it.next();
                    this.targetMap.put(com.kwad.sdk.collector.model.c.a(next), next);
                }
                return;
            }
            this.targetMap.clear();
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "startTime", this.startTime);
            t.putValue(jSONObject, "scanInterval", this.scanInterval);
            t.putValue(jSONObject, "historyGranularity", this.historyGranularity / 1000);
            t.putValue(jSONObject, "name", this.name);
            t.putValue(jSONObject, "target", getTarget());
            t.putValue(jSONObject, "minLaunchInterval", this.minLaunchInterval);
            t.putValue(jSONObject, "needSaveLaunchTime", this.needSaveLaunchTime);
            t.putValue(jSONObject, "needLaunch", this.needLaunch);
            return jSONObject;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class UploadConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final int DEFAULT_FILE_MAX_SIZE = 102400;
        private static final long serialVersionUID = 8541150615721258815L;
        public long fileMaxSize = 102400;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (this.fileMaxSize < 0) {
                this.fileMaxSize = 102400L;
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.fileMaxSize = jSONObject.optLong("fileMaxSize");
            }
            super.afterParseJson(jSONObject);
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "fileMaxSize", this.fileMaxSize);
            return jSONObject;
        }
    }

    @NonNull
    public static AppStatusRules createFromJson(String str) {
        AppStatusRules appStatusRules = new AppStatusRules();
        if (TextUtils.isEmpty(str)) {
            return appStatusRules;
        }
        try {
            appStatusRules.parseJson(new JSONObject(str));
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        return appStatusRules;
    }

    public static boolean isAppStatusTargetNotEmpty(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return false;
        }
        boolean targetNotEmpty = appStatusRules.targetNotEmpty();
        List<Strategy> obtainNamedStrategyList = appStatusRules.obtainNamedStrategyList();
        return targetNotEmpty || (obtainNamedStrategyList != null && obtainNamedStrategyList.size() > 0);
    }

    public static boolean isUploadTargetNotEmpty(AppStatusRules appStatusRules) {
        List<com.kwad.sdk.collector.model.d> uploadTargets;
        return (appStatusRules == null || (uploadTargets = appStatusRules.getUploadTargets()) == null || uploadTargets.size() <= 0) ? false : true;
    }

    public ArrayList<Strategy> getAllStrategy() {
        ArrayList<Strategy> arrayList = new ArrayList<>();
        if (this.data.strategy != null) {
            arrayList.add(this.data.strategy);
        }
        if (this.data.namedStrategy != null) {
            arrayList.addAll(this.data.namedStrategy);
        }
        return arrayList;
    }

    @Nullable
    public List<com.kwad.sdk.collector.model.d> getUploadTargets() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.uploadTarget;
    }

    public void initStatus(Context context) {
        Iterator<Strategy> it = getAllStrategy().iterator();
        while (it.hasNext()) {
            Strategy next = it.next();
            next.setNeedLaunch(i.a(context, next));
        }
    }

    public long obtainDefaultScanInterval() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
            return 0L;
        }
        long scanInterval = this.data.getStrategy().getScanInterval();
        return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
    }

    public Strategy obtainDefaultStrategy() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.strategy;
    }

    public List<Strategy> obtainNamedStrategyList() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.namedStrategy;
    }

    public long obtainUploadConfigFileMaxSize() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.uploadConfig == null) {
            return 102400L;
        }
        return this.data.uploadConfig.fileMaxSize;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"))));
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    public boolean targetNotEmpty() {
        AppStatusInfo appStatusInfo = this.data;
        return (appStatusInfo == null || appStatusInfo.target == null || this.data.target.size() <= 0) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "data", this.data);
        return json;
    }
}
