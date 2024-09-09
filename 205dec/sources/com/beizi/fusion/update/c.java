package com.beizi.fusion.update;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.ab;
import com.beizi.fusion.g.ad;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.d;
import com.beizi.fusion.g.f;
import com.beizi.fusion.g.z;
import com.beizi.fusion.model.RequestInfo;
import org.json.JSONObject;
import xyz.adscope.ad.constants.ConstantConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HeartSender.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends AsyncTask<String, Integer, a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f15138a;

    /* renamed from: b  reason: collision with root package name */
    private b f15139b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, b bVar) {
        try {
            this.f15138a = context;
            this.f15139b = bVar;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public a doInBackground(String... strArr) {
        String a4;
        try {
            if (!RequestInfo.getInstance(this.f15138a).isInit) {
                RequestInfo.getInstance(this.f15138a).init();
            }
            if (strArr != null && strArr.length > 0) {
                a4 = strArr[0];
            } else {
                a4 = f.a(ConstantConfig.sHeartUrl);
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                if (BeiZis.getTransferProtocol()) {
                    a4 = a4.replace("http:", "https:");
                }
            }
            int indexOf = a4.indexOf("?");
            String substring = a4.substring(0, indexOf);
            String a5 = d.a(ad.a(), z.a(av.a(this.f15138a, a4.substring(indexOf + 1), null)));
            if (a5 != null) {
                String a6 = ab.a(substring, a5.getBytes());
                if (!TextUtils.isEmpty(a6)) {
                    JSONObject jSONObject = new JSONObject(a6);
                    if (jSONObject.optInt("code") == 200) {
                        au.a(this.f15138a, "lastUpdateTime", Long.valueOf(System.currentTimeMillis()));
                        String optString = jSONObject.optString("data");
                        if (!TextUtils.isEmpty(optString) && !optString.equalsIgnoreCase("null") && !optString.equals("{}")) {
                            return new a(this.f15138a, optString);
                        }
                    }
                }
            }
        } catch (Error e4) {
            e4.printStackTrace();
        } catch (RuntimeException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(a aVar) {
        if (aVar != null && aVar.a()) {
            this.f15139b.a(aVar);
            return;
        }
        b bVar = this.f15139b;
        if (bVar != null) {
            bVar.a(1000);
        }
    }
}
