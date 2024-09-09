package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Method;
import java.util.List;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class e0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        List<AccessibilityServiceInfo> list;
        Method declaredMethod;
        Context c4 = pgla.a().c();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) c4.getSystemService((String) pblk.a(16777217, 0, 0L, "7add20", new byte[]{39, 96, 20, 21, 30, 52, 61, 66, 60, 56, 47, 119, 14}));
        if (accessibilityManager != null) {
            try {
                declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "69f0c9", new byte[]{32, 62, 1, 109, 82, 61, 33, 25, 59, 108, 34, 63, 52, 71, 95, 43, 38, 11, 62, 98, 46, 55, 28, 80, 69, 29, 48, 10, 33, 105, 36, 62, 57, 77, 79, 58}), new Class[0]);
            } catch (Throwable unused) {
            }
            if (declaredMethod != null) {
                list = (List) declaredMethod.invoke(accessibilityManager, new Object[0]);
                if (list != null || list.size() == 0) {
                    return jSONArray.toString();
                }
                for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put((String) pblk.a(16777217, 0, 0L, "35b79c", new byte[]{39, 33}), accessibilityServiceInfo.eventTypes);
                        jSONObject.put((String) pblk.a(16777217, 0, 0L, "ed05bd", new byte[]{125, 98}), accessibilityServiceInfo.getId());
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            }
            list = null;
            if (list != null) {
            }
            return jSONArray.toString();
        }
        return jSONArray.toString();
    }
}
