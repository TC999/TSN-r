package xyz.adscope.common.json.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FieldUtil {
    public static void fillField(JSONObject jSONObject, Object obj, Field field) {
        Object obj2;
        Object fromJson;
        if (jSONObject == null || obj == null || jSONObject.equals("{}") || field == null) {
            return;
        }
        try {
            Class<?> type = field.getType();
            String name = field.getName();
            if (!jSONObject.has(name) || (obj2 = jSONObject.get(name)) == null || obj2.equals(null)) {
                return;
            }
            if (TypeUtil.isBasicType(type)) {
                jSONObject.remove(name);
                if (!TypeUtil.isWrapType(type) && !String.class.isAssignableFrom(type)) {
                    field.set(obj, obj2);
                    return;
                }
                fromJson = type.getConstructor(String.class).newInstance(obj2.toString());
            } else if (List.class.isAssignableFrom(type)) {
                fromJson = JsonUtil.jsonArrayToList(jSONObject.getJSONArray(name), type, field.getGenericType());
            } else if (type.isArray()) {
                fromJson = JsonUtil.jsonArrayToArray(jSONObject.getJSONArray(name), type);
                if (fromJson == null) {
                    return;
                }
            } else {
                LogUtil.i("FiledUtil", "fieldClazz bean type ");
                fromJson = JsonUtil.fromJson(jSONObject.getJSONObject(name), type);
            }
            field.set(obj, fromJson);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
    }

    public static List<Field> getAllFields(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return arrayList;
    }
}
