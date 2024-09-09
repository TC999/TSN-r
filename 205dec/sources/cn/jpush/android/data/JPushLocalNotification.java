package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushLocalNotification implements Serializable {
    private static final long serialVersionUID = 1472982106750878137L;

    /* renamed from: f  reason: collision with root package name */
    private String f4164f;

    /* renamed from: g  reason: collision with root package name */
    private String f4165g;

    /* renamed from: h  reason: collision with root package name */
    private String f4166h;

    /* renamed from: i  reason: collision with root package name */
    private long f4167i;

    /* renamed from: a  reason: collision with root package name */
    private int f4159a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f4160b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f4161c = "00";

    /* renamed from: d  reason: collision with root package name */
    private String f4162d = "00";

    /* renamed from: e  reason: collision with root package name */
    private long f4163e = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f4168j = 1;

    /* renamed from: k  reason: collision with root package name */
    private int f4169k = 1;

    /* renamed from: l  reason: collision with root package name */
    private String f4170l = "";

    /* renamed from: m  reason: collision with root package name */
    private String f4171m = "";

    /* renamed from: n  reason: collision with root package name */
    private int f4172n = 0;

    /* renamed from: o  reason: collision with root package name */
    private String f4173o = "";

    private void a(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f4168j == ((JPushLocalNotification) obj).f4168j;
    }

    public long getBroadcastTime() {
        return this.f4163e;
    }

    public long getBuilderId() {
        return this.f4167i;
    }

    public String getCategory() {
        return this.f4173o;
    }

    public String getContent() {
        return this.f4164f;
    }

    public String getExtras() {
        return this.f4166h;
    }

    public long getNotificationId() {
        return this.f4168j;
    }

    public int getPriority() {
        return this.f4172n;
    }

    public String getTitle() {
        return this.f4165g;
    }

    public int hashCode() {
        long j4 = this.f4168j;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public void setBroadcastTime(int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 < 0 || i5 < 1 || i5 > 12 || i6 < 1 || i6 > 31 || i7 < 0 || i7 > 23 || i8 < 0 || i8 > 59 || i9 < 0 || i9 > 59) {
            Logger.ee("JPushLocalNotification", "Set time fail! Please check your args!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i4, i5 - 1, i6, i7, i8, i9);
        Date time = calendar.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < currentTimeMillis) {
            this.f4163e = currentTimeMillis;
        } else {
            this.f4163e = time.getTime();
        }
    }

    public void setBroadcastTime(long j4) {
        this.f4163e = j4;
    }

    public void setBroadcastTime(Date date) {
        this.f4163e = date.getTime();
    }

    public void setBuilderId(long j4) {
        this.f4167i = j4;
    }

    public void setCategory(String str) {
        this.f4173o = str;
    }

    public void setContent(String str) {
        this.f4164f = str;
    }

    public void setExtras(String str) {
        this.f4166h = str;
    }

    public void setNotificationId(long j4) {
        this.f4168j = (int) j4;
    }

    public void setPriority(int i4) {
        this.f4172n = i4;
    }

    public void setTitle(String str) {
        this.f4165g = str;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.f4166h)) {
                jSONObject2.put("n_extras", new JSONObject(this.f4166h));
            }
            jSONObject2.put("n_priority", this.f4172n);
            a("n_category", this.f4173o, jSONObject2);
            a("n_content", this.f4164f, jSONObject2);
            a("n_title", this.f4165g, jSONObject2);
            a("n_content", this.f4164f, jSONObject2);
            jSONObject2.put("ad_t", 0);
            jSONObject.put("m_content", jSONObject2);
            a(JThirdPlatFormInterface.KEY_MSG_ID, "" + this.f4168j, jSONObject);
            a("content_type", this.f4171m, jSONObject);
            a("override_msg_id", this.f4170l, jSONObject);
            jSONObject.put("n_only", this.f4169k);
            jSONObject.put("n_builder_id", this.f4167i);
            jSONObject.put("show_type", 3);
            jSONObject.put("notificaion_type", 1);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
