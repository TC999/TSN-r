package xyz.adscope.ad.control.template;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.model.http.response.config.TemplateModel;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.KeyGenerator;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TemplateManager {
    private static TemplateManager mInstance;
    public String TEMPLATE_KEY = "";

    private TemplateManager() {
    }

    public static TemplateManager getInstance() {
        if (mInstance == null) {
            synchronized (TemplateManager.class) {
                if (mInstance == null) {
                    mInstance = new TemplateManager();
                }
            }
        }
        return mInstance;
    }

    private String getTemplateKey(String str, boolean z3) {
        this.TEMPLATE_KEY = "AdScopeADN_" + str;
        if (z3) {
            return this.TEMPLATE_KEY + "_render";
        }
        return this.TEMPLATE_KEY + "_interaction";
    }

    private List<String> readDefaultTemplateList(String str, String str2, String str3, boolean z3) {
        String templateKey = getTemplateKey(str, z3);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(AdScopeSpUtil.getString(templateKey))) {
            String encrypt = AesUtil.encrypt(KeyGenerator.generateAesKey(), str3);
            HashMap hashMap = new HashMap();
            hashMap.put(TemplateConfig.DEFAULT_ID, str2);
            hashMap.put(str2, encrypt);
            AdScopeSpUtil.putString(templateKey, hashMap.toString());
            arrayList.add(str2);
        } else {
            for (Map.Entry<String, String> entry : StringUtil.mapStringToMap(AdScopeSpUtil.getString(templateKey)).entrySet()) {
                if (!TemplateConfig.DEFAULT_ID.equals(entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    private String readLocalTemplateModel(String str, boolean z3) {
        Map<String, String> mapStringToMap;
        String string = AdScopeSpUtil.getString(getTemplateKey(str, z3));
        if (!TextUtils.isEmpty(string) && (mapStringToMap = StringUtil.mapStringToMap(string)) != null && !mapStringToMap.isEmpty()) {
            String str2 = mapStringToMap.containsKey(TemplateConfig.DEFAULT_ID) ? mapStringToMap.get(TemplateConfig.DEFAULT_ID) : "";
            for (Map.Entry<String, String> entry : mapStringToMap.entrySet()) {
                if (str2.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return "";
    }

    private void updateLocalTemplate(String str, boolean z3, List<TemplateModel> list) {
        String interactionId;
        for (int i4 = 0; i4 < list.size(); i4++) {
            TemplateModel templateModel = list.get(i4);
            String templateKey = getTemplateKey(templateModel.getAdType(), z3);
            if (!TextUtils.isEmpty(templateModel.getAdType())) {
                if (z3) {
                    interactionId = templateModel.getRenderId();
                } else {
                    interactionId = templateModel.getInteractionId();
                }
                if (!TextUtils.isEmpty(interactionId)) {
                    if (TextUtils.isEmpty(AdScopeSpUtil.getString(templateKey))) {
                        String encrypt = AesUtil.encrypt(KeyGenerator.generateAesKey(), str);
                        HashMap hashMap = new HashMap();
                        hashMap.put(TemplateConfig.DEFAULT_ID, interactionId);
                        hashMap.put(TemplateConfig.DEFAULT_ID_VALUE, encrypt);
                    } else {
                        StringUtil.mapStringToMap(AdScopeSpUtil.getString(templateKey)).put(TemplateConfig.DEFAULT_ID, interactionId);
                    }
                }
            }
        }
    }

    private void writeLocalTemplate(String str, String str2, String str3, String str4, String str5, boolean z3) {
        Map mapStringToMap;
        String templateKey = getTemplateKey(str, z3);
        String encrypt = AesUtil.encrypt(KeyGenerator.generateAesKey(), str5);
        if (TextUtils.isEmpty(AdScopeSpUtil.getString(templateKey))) {
            String encrypt2 = AesUtil.encrypt(KeyGenerator.generateAesKey(), str3);
            mapStringToMap = new HashMap();
            mapStringToMap.put(TemplateConfig.DEFAULT_ID, str2);
            mapStringToMap.put(str2, encrypt2);
            mapStringToMap.put(str4, encrypt);
        } else {
            mapStringToMap = StringUtil.mapStringToMap(AdScopeSpUtil.getString(templateKey));
            mapStringToMap.put(str4, encrypt);
        }
        AdScopeSpUtil.putString(templateKey, mapStringToMap.toString());
    }

    public void changeDefLocalInteractionTemplate(List<TemplateModel> list) {
        updateLocalTemplate(TemplateConfig.DEFAULT_INTERACTION_TEMPLATE, false, list);
    }

    public void changeDefLocalRenderTemplate(List<TemplateModel> list) {
        updateLocalTemplate(TemplateConfig.DEFAULT_RENDER_TEMPLATE, true, list);
    }

    public String readLocalInteractionModel(String str) {
        String readLocalTemplateModel = readLocalTemplateModel(str, false);
        return !TextUtils.isEmpty(readLocalTemplateModel) ? AesUtil.decrypt(KeyGenerator.generateAesKey(), readLocalTemplateModel) : TemplateConfig.DEFAULT_INTERACTION_TEMPLATE;
    }

    public List<String> readLocalInteractionTemplateList(String str) {
        return readDefaultTemplateList(str, TemplateConfig.DEFAULT_ID_VALUE, TemplateConfig.DEFAULT_INTERACTION_TEMPLATE, false);
    }

    public String readLocalRenderModel(String str) {
        String readLocalTemplateModel = readLocalTemplateModel(str, true);
        return !TextUtils.isEmpty(readLocalTemplateModel) ? AesUtil.decrypt(KeyGenerator.generateAesKey(), readLocalTemplateModel) : TemplateConfig.DEFAULT_RENDER_TEMPLATE;
    }

    public List<String> readLocalRenderTemplateList(String str) {
        return readDefaultTemplateList(str, TemplateConfig.DEFAULT_ID_VALUE, TemplateConfig.DEFAULT_RENDER_TEMPLATE, true);
    }

    public void updateTemplateConfig(List<TemplateModel> list) {
        changeDefLocalRenderTemplate(list);
        changeDefLocalInteractionTemplate(list);
    }

    public void writeLocalInteractionTemplate(String str, String str2, String str3) {
        writeLocalTemplate(str, TemplateConfig.DEFAULT_ID_VALUE, TemplateConfig.DEFAULT_INTERACTION_TEMPLATE, str2, str3, false);
    }

    public void writeLocalRenderTemplate(String str, String str2, String str3) {
        writeLocalTemplate(str, TemplateConfig.DEFAULT_ID_VALUE, TemplateConfig.DEFAULT_RENDER_TEMPLATE, str2, str3, true);
    }
}
