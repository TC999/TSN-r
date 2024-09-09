package com.umeng.vt.diff;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Channel {
    private static final String UM_VISUAL_IMPRINT = "utm-visual";

    private void download() {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("download", new Class[0])) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void storeConfig(Map<String, String> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("storeConfig", Map.class)) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), map);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void init(Context context) {
        if (context == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        loadConfig(origApplicationContext);
        registerListener(origApplicationContext);
    }

    public void loadConfig(Context context) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "utm-visual", null);
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        String str = new String(Base64.decode(imprintProperty, 0));
        HashMap hashMap = new HashMap();
        hashMap.put("data-track", str);
        storeConfig(hashMap);
    }

    public void registerListener(final Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback("utm-visual", new UMImprintChangeCallback() { // from class: com.umeng.vt.diff.Channel.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if ("utm-visual".equals(str)) {
                    Channel.this.loadConfig(context);
                }
            }
        });
    }
}