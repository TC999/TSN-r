package cn.jiguang.y;

import android.content.Context;
import cn.jiguang.common.n.d;
import cn.jpush.android.api.InAppSlotParams;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends cn.jiguang.ah.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3892a;

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f3892a = context;
        return "JDataCollectStatistic";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        super.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(2600)) {
            return;
        }
        try {
            JSONArray a4 = a.a(context);
            if (a4 != null && a4.length() != 0) {
                ArrayList<JSONArray> a5 = d.a(a4);
                if (a5 != null && !a5.isEmpty()) {
                    int i4 = 0;
                    int size = a5.size();
                    while (i4 < size) {
                        JSONObject jSONObject = new JSONObject();
                        i4++;
                        jSONObject.put("slice_index", i4);
                        jSONObject.put("slice_count", size);
                        jSONObject.put("data", a5.get(i4));
                        jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                        cn.jiguang.ah.d.a(context, jSONObject, "collect_statistic");
                        cn.jiguang.ah.d.a(context, (Object) jSONObject);
                    }
                    a.b(context);
                    super.c(context, str);
                    return;
                }
                cn.jiguang.w.a.f("JDataCollectStatistic", "statistic data partition failed");
                return;
            }
            cn.jiguang.w.a.b("JDataCollectStatistic", "no collect statistic data to report");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataCollectStatistic", "collect data report failed: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return super.d(context, str);
    }
}
