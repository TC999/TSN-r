package com.mbridge.msdk.out;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.confirmation.e;
import com.mbridge.msdk.mbnative.c.a;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBNativeHandler extends MBCommonHandler {
    public static final int OPERATE_LOAD = 1;
    public static final int OPERATE_LOAD_FRAME = 2;
    private static final String TAG = "com.mbridge.msdk.out.MBNativeHandler";
    public static final String TEMPLATE_ID = "id";
    public static final String TEMPLATE_NUM = "ad_num";
    private static String mUnitID;
    private a adListener;
    private b clickControler;
    private Context context;
    private Map<String, Object> map;
    private com.mbridge.msdk.mbnative.e.a nativeProvider;
    private List<NativeListener.Template> templateList;
    private NativeListener.NativeTrackingListener trackingListener;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class KeyWordInfo {
        String keyWordPN;
        String keyWorkVN;

        public KeyWordInfo(String str, String str2) {
            this.keyWordPN = str;
            this.keyWorkVN = str2;
        }

        public String getKeyWordPN() {
            return this.keyWordPN;
        }

        public String getKeyWorkVN() {
            return this.keyWorkVN;
        }

        public void setKeyWordPN(String str) {
            this.keyWordPN = str;
        }

        public void setKeyWorkVN(String str) {
            this.keyWorkVN = str;
        }
    }

    public MBNativeHandler(Context context) {
        this.adListener = new a();
        this.context = context;
        if (com.mbridge.msdk.foundation.controller.a.f().j() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.f().b(context);
        }
        Map<String, Object> map = this.map;
        if (map == null || !map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            return;
        }
        String str = (String) this.map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        a aVar = this.adListener;
        if (aVar != null) {
            aVar.a(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String f4 = ac.f(str);
        if (TextUtils.isEmpty(f4)) {
            return;
        }
        ac.a(str, f4);
    }

    public static Map<String, Object> getNativeProperties(String str, String str2) {
        HashMap hashMap = new HashMap();
        mUnitID = str2;
        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        String str3 = MBridgeConstans.PLACEMENT_ID;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put(str3, str);
        hashMap.put(MBridgeConstans.PLUGIN_NAME, new String[]{MBridgeConstans.PLUGIN_NATIVE});
        hashMap.put(MBridgeConstans.PROPERTIES_LAYOUT_TYPE, 0);
        return hashMap;
    }

    public static String getTemplateString(List<NativeListener.Template> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (NativeListener.Template template : list) {
                        stringBuffer.append("{\"id\":");
                        stringBuffer.append(template.getId() + ",");
                        stringBuffer.append("\"ad_num\":");
                        stringBuffer.append(template.getAdNum() + "},");
                    }
                    return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private boolean loadMB() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            List<NativeListener.Template> list = this.templateList;
            if (list != null && list.size() > 0) {
                try {
                    this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
                } catch (Exception unused) {
                    x.c("com.mbridge.msdk", "MBSDK set template error");
                }
            }
            try {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
                if (this.nativeProvider == null) {
                    com.mbridge.msdk.mbnative.e.a aVar = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
                    this.nativeProvider = aVar;
                    aVar.a(this.context, (Resources) null, this.properties);
                }
                this.nativeProvider.a();
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
                return true;
            }
        }
        x.c("", "no unit id.");
        return true;
    }

    private boolean loadMBFrame() {
        List<NativeListener.Template> list = this.templateList;
        if (list != null && list.size() > 0) {
            try {
                this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
            } catch (Exception unused) {
                x.c("com.mbridge.msdk", "MBSDK set template error");
            }
        }
        try {
            this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            if (this.nativeProvider == null) {
                com.mbridge.msdk.mbnative.e.a aVar = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
                this.nativeProvider = aVar;
                aVar.a(this.context, (Resources) null, this.properties);
            }
            this.nativeProvider.b();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public static String parseKeyWordInfoListStr(List<KeyWordInfo> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < list.size(); i4++) {
                JSONObject jSONObject = new JSONObject();
                KeyWordInfo keyWordInfo = list.get(i4);
                if (!TextUtils.isEmpty(keyWordInfo.getKeyWordPN()) && !TextUtils.isEmpty(keyWordInfo.getKeyWorkVN())) {
                    jSONObject.put("p", keyWordInfo.getKeyWordPN());
                    jSONObject.put("v", keyWordInfo.getKeyWorkVN());
                    com.mbridge.msdk.foundation.controller.a f4 = com.mbridge.msdk.foundation.controller.a.f();
                    if (f4 != null) {
                        List<String> a4 = f4.a(false);
                        if (a4 != null) {
                            if (a4.contains(keyWordInfo.getKeyWordPN())) {
                                jSONObject.put("i", 1);
                            } else {
                                jSONObject.put("i", 0);
                            }
                        } else {
                            jSONObject.put("i", 2);
                        }
                    }
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(TAG, e4.getMessage());
            return null;
        }
    }

    public void addTemplate(NativeListener.Template template) {
        if (template != null) {
            if (this.templateList == null) {
                this.templateList = new ArrayList();
            }
            this.templateList.add(template);
        }
    }

    public String buildTemplateString() {
        try {
            List<NativeListener.Template> list = this.templateList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (NativeListener.Template template : this.templateList) {
                stringBuffer.append("{\"id\":");
                stringBuffer.append(template.getId() + ",");
                stringBuffer.append("\"ad_num\":");
                stringBuffer.append(template.getAdNum() + "},");
            }
            return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
        } catch (Exception unused) {
            return null;
        }
    }

    public void clearCacheByUnitid(String str) {
        try {
            if (ag.a(str)) {
                return;
            }
            f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).c(str);
            com.mbridge.msdk.mbnative.a.f.a(3).a(str);
            com.mbridge.msdk.mbnative.a.f.a(6).a(str);
            com.mbridge.msdk.mbnative.a.f.a(7).a(str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void clearVideoCache() {
        try {
            com.mbridge.msdk.mbnative.e.a aVar = this.nativeProvider;
            if (aVar != null) {
                aVar.c();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void dismissConfirmDialog() {
        e.a().c();
    }

    public a getAdListener() {
        return this.adListener;
    }

    public String getRequestId() {
        com.mbridge.msdk.mbnative.e.a aVar = this.nativeProvider;
        return aVar != null ? aVar.e() : "";
    }

    public NativeListener.NativeTrackingListener getTrackingListener() {
        return this.trackingListener;
    }

    public void handleResult(Campaign campaign, String str) {
        if (this.clickControler == null) {
            Map<String, Object> map = this.map;
            this.clickControler = new b(this.context, map != null ? (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID) : null);
        }
        this.clickControler.a(campaign, str);
    }

    @Override // com.mbridge.msdk.out.MBCommonHandler
    public boolean load() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            loadMB();
            return true;
        }
        x.c("", "no unit id.");
        return true;
    }

    public boolean loadFrame() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            loadMBFrame();
            return true;
        }
        x.c("", "no unit id.");
        return true;
    }

    public void registerView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, campaign);
    }

    @Override // com.mbridge.msdk.out.MBCommonHandler
    public void release() {
        com.mbridge.msdk.mbnative.e.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.d();
        }
        this.trackingListener = null;
    }

    public void setAdListener(NativeListener.NativeAdListener nativeAdListener) {
        a aVar = new a(nativeAdListener);
        this.adListener = aVar;
        aVar.a(mUnitID);
        com.mbridge.msdk.mbnative.e.a aVar2 = this.nativeProvider;
        if (aVar2 != null) {
            aVar2.a(this.adListener);
        }
    }

    public void setMustBrowser(boolean z3) {
        ab.f39746b = z3;
    }

    public void setTrackingListener(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.trackingListener = nativeTrackingListener;
        com.mbridge.msdk.mbnative.e.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.a(nativeTrackingListener);
        }
    }

    public void unregisterView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, campaign);
    }

    public void registerView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, list, campaign);
    }

    public void unregisterView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.e.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, list, campaign);
    }

    public MBNativeHandler(Map<String, Object> map, Context context) {
        super(map, context);
        this.adListener = new a();
        this.context = context;
        this.map = map;
        if (com.mbridge.msdk.foundation.controller.a.f().j() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.f().b(context);
        }
        if (map != null) {
            try {
                if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && map.get(MBridgeConstans.PROPERTIES_UNIT_ID) != null && (map.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String) && map.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && map.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) != null && (map.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer) && map.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && map.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) != null) {
                    boolean z3 = map.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (map == null || !map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            return;
        }
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        a aVar = this.adListener;
        if (aVar != null) {
            aVar.a(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String f4 = ac.f(str);
        if (TextUtils.isEmpty(f4)) {
            return;
        }
        ac.a(str, f4);
    }
}
