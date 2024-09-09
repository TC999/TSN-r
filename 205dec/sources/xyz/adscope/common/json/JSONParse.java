package xyz.adscope.common.json;

import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.json.inter.IJSONParse;
import xyz.adscope.common.json.util.JsonResolver;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class JSONParse implements IJSONParse {
    @Override // xyz.adscope.common.json.inter.IJSONParse
    public <T> T fromJson(String str, Class<T> cls) {
        try {
            return (T) JsonUtil.fromJson(new JSONObject(str), cls);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }

    @Override // xyz.adscope.common.json.inter.IJSONParse
    public <T> T fromJsonAnnotation(String str, Class<T> cls) {
        try {
            return (T) JsonResolver.fromJson(str, (Class<Object>) cls);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }

    @Override // xyz.adscope.common.json.inter.IJSONParse
    public String toJson(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }
}
