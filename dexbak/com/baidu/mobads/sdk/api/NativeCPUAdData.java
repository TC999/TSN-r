package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.internal.C2585ae;
import com.baidu.mobads.sdk.internal.C2598ao;
import com.baidu.mobads.sdk.internal.C2601aq;
import com.baidu.mobads.sdk.internal.C2602ar;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2607aw;
import com.baidu.mobads.sdk.internal.C2632br;
import com.baidu.mobads.sdk.internal.C2736x;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeCPUAdData implements IBasicCPUData, Observer {
    private static final String CLASS_NAME = C2736x.f9314l;
    private final ClassLoader classLoader;
    private IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public C2602ar remoteUtils;

    public NativeCPUAdData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = C2602ar.m50968a(context, CLASS_NAME);
        this.classLoader = C2632br.m50753a(context);
    }

    private String getAdid() {
        return this.remoteUtils.m50963c(this.mInstance, "getAdid", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCanClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.m50967a(this.mInstance, "handleCanClickView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        C2601aq.m50973a(StubApp.getOrigApplicationContext(this.mCtx.getApplicationContext())).m50969b(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(View view) {
        this.remoteUtils.m50967a(this.mInstance, "clickHotItem", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getActionType", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAdHeight", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAdLogoUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAdLogoUrl", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAdWidth", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPackageName() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getPackageName", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.remoteUtils.m50963c(this.mInstance, "getAppPermissionUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.remoteUtils.m50963c(this.mInstance, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPublisher() {
        return this.remoteUtils.m50963c(this.mInstance, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppVersion() {
        return this.remoteUtils.m50963c(this.mInstance, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAttribute", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAuthor() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAuthor", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBaiduLogoUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getBaiduLogoUrl", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBrandName() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getBrandName", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelId() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getCatId", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelName() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getCatName", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getCommentCounts", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<Integer> getContentAttributesList() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getContentAttributesList", new Object[0]);
        if (m50964b instanceof List) {
            return (List) m50964b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getContentClickUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getContentClickUrl", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getCtime", new Object[0]);
        if (m50964b instanceof Long) {
            return ((Long) m50964b).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getDesc() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getContent", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.remoteUtils.m50964b(this.mInstance, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getDownloadStatus", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getDuration", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.remoteUtils.m50964b(this.mInstance, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getHotId", new Object[0]);
        if (m50964b instanceof Long) {
            return ((Long) m50964b).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getHotWord() {
        return this.remoteUtils.m50963c(this.mInstance, "getHotWord", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getIconUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getAvatar", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getImage() {
        return this.remoteUtils.m50963c(this.mInstance, "getImage", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getImageUrls() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getImageList", new Object[0]);
        if (m50964b instanceof List) {
            return (List) m50964b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getLabel() {
        return this.remoteUtils.m50963c(this.mInstance, "getLabel", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getPlayCounts", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getPresentationType", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getReadCounts", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getScore", new Object[0]);
        return m50964b instanceof Double ? ((Double) m50964b).doubleValue() : Utils.DOUBLE_EPSILON;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getSmallImageList", new Object[0]);
        if (m50964b instanceof List) {
            return (List) m50964b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getStyleTypeCpu", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getThumbHeight", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getThumbUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getThumbUrl", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getThumbWidth", new Object[0]);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getTitle() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getTitle", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getType() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getType", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getUpdateTime() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getUpdateTime", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getVUrl() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getVUrl", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleClick(View view, Object... objArr) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        long j = 0;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Long)) {
            j = ((Long) objArr[0]).longValue();
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 1, Long.valueOf(j));
        } else if (view instanceof TextView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 2, Long.valueOf(j));
        }
        this.remoteUtils.m50967a(this.mInstance, "handleClick", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.m50967a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.m50967a(this.mInstance, "handleCreativeView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(View view, int i) {
        this.remoteUtils.m50967a(this.mInstance, "handleDislikeClick", view, Integer.valueOf(i));
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "isAutoplay", new Object[0]);
        if (m50964b instanceof Boolean) {
            return ((Boolean) m50964b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "isCanGoLp", new Object[0]);
        if (m50964b instanceof Boolean) {
            return ((Boolean) m50964b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        return ((Boolean) this.remoteUtils.m50964b(this.mInstance, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "isTop", new Object[0]);
        if (m50964b instanceof Boolean) {
            return ((Boolean) m50964b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.remoteUtils.m50967a(this.mInstance, "markDislike", strArr);
    }

    public void monitorVisibleTime(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.m50967a(this.mInstance, "monitorVisibleTime", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.m50967a(this.mInstance, "onImpression", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        C2601aq.m50973a(StubApp.getOrigApplicationContext(this.mCtx.getApplicationContext())).m50970a(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(View view, final List<View> list, List<View> list2, IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        setStatusListener(cpuNativeStatusCB);
        onImpression(view);
        monitorVisibleTime(view);
        if (list != null && list.size() > 0) {
            for (final View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            NativeCPUAdData.this.handleCanClickView(view3);
                            view2.setClickable(false);
                            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    View view4 = view2;
                                    if (view4 != null) {
                                        view4.setClickable(true);
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (final View view3 : list2) {
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        NativeCPUAdData.this.handleCreativeView(view4);
                        view3.setClickable(false);
                        view3.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                View$OnClickListenerC25582 view$OnClickListenerC25582 = View$OnClickListenerC25582.this;
                                if (list != null) {
                                    view3.setClickable(true);
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(final IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
        try {
            this.remoteUtils.m50967a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.classLoader, new Class[]{C2603as.m50953a(C2736x.f9315m, this.classLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    C2607aw.AbstractC2608a m50898h = C2607aw.m50898h("NativeCPUAdData");
                    m50898h.mo50872c("invoke: " + method.getName());
                    if (cpuNativeStatusCB == null) {
                        return null;
                    }
                    String name = method.getName();
                    if ("onAdDownloadWindowShow".equals(name)) {
                        cpuNativeStatusCB.onAdDownloadWindowShow();
                    } else if ("onPermissionShow".equals(name)) {
                        cpuNativeStatusCB.onPermissionShow();
                    } else if ("onPermissionClose".equals(name)) {
                        cpuNativeStatusCB.onPermissionClose();
                    } else if ("onPrivacyClick".equals(name)) {
                        cpuNativeStatusCB.onPrivacyClick();
                    } else if ("onPrivacyLpClose".equals(name)) {
                        cpuNativeStatusCB.onPrivacyLpClose();
                    } else if ("onNotifyPerformance".equals(name)) {
                        if (objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                            cpuNativeStatusCB.onNotifyPerformance((String) objArr[0]);
                        }
                    } else if ("startRouter".equals(name)) {
                        C2598ao.m50990a((Context) objArr[0], (String) objArr[1]);
                    }
                    return null;
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof C2585ae) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof IOAdEvent)) {
            IOAdEvent iOAdEvent = (IOAdEvent) obj;
            String message = iOAdEvent.getMessage();
            Map<String, Object> data = iOAdEvent.getData();
            if (data != null) {
                Object obj2 = data.get("adid");
                if ((obj2 instanceof String) && ((String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }
}
