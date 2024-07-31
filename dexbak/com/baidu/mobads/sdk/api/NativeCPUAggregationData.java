package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.IBasicCPUAggregation;
import com.baidu.mobads.sdk.internal.C2602ar;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2632br;
import com.baidu.mobads.sdk.internal.C2736x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeCPUAggregationData implements IBasicCPUAggregation {
    private static final String CLASS_NAME = C2736x.f9316n;
    private final ClassLoader mClassLoader;
    private IBasicCPUAggregation.ICpuHotNativeStatus mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public C2602ar remoteUtils;

    public NativeCPUAggregationData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = C2602ar.m50968a(context, CLASS_NAME);
        this.mClassLoader = C2632br.m50753a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.m50967a(this.mInstance, "handleClickView", view);
    }

    private void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.m50967a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.m50967a(this.mInstance, "onImpression", view);
    }

    private void setStatusListener(IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        this.mCpuNativeStatusCBListener = iCpuHotNativeStatus;
        try {
            this.remoteUtils.m50967a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.mClassLoader, new Class[]{C2603as.m50953a(C2736x.f9317o, this.mClassLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (NativeCPUAggregationData.this.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                        NativeCPUAggregationData.this.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                    }
                    return null;
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getContentId() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getContentId", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public List<String> getImagesList() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getImagesList", new Object[0]);
        if (m50964b instanceof List) {
            return (List) m50964b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getLongTitle() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getLongTitle", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getShortTitle() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getShortTitle", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getTitle() {
        Object m50964b = this.remoteUtils.m50964b(this.mInstance, "getTitle", new Object[0]);
        return m50964b instanceof String ? (String) m50964b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public void registerViewForInteraction(View view, List<View> list, IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        setStatusListener(iCpuHotNativeStatus);
        onImpression(view);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (final View view2 : list) {
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        NativeCPUAggregationData.this.handleClickView(view3);
                        view2.setClickable(false);
                        view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
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
}
