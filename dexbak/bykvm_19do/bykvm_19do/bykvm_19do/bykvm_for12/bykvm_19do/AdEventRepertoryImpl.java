package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.DBHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ListUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventRepertoryImpl implements AdEventRepertory<AdEvent> {

    /* renamed from: a */
    private final Context f565a;

    /* renamed from: b */
    private final DBAdapter f566b;

    /* renamed from: c */
    private final SPUtils f567c = SPUtils.m59131a("tt_adevent", m59437a());

    public AdEventRepertoryImpl(Context context) {
        this.f565a = context;
        this.f566b = DBAdapter.m59403a(context);
    }

    /* renamed from: b */
    private synchronized void m59423b(int i, int i2, long j) {
        DBHelper.C0975c m59402a = this.f566b.m59402a();
        String m59420c = m59420c(i);
        int m59395a = m59402a.m59395a(m59420c, "gen_time < ? AND retry >?", new String[]{(System.currentTimeMillis() - j) + "", i2 + ""});
        StringBuilder sb = new StringBuilder();
        sb.append("客户端容灾状态下事件过期时间(2天)：");
        sb.append(j);
        sb.append("，成功删除日志条数：delete count=");
        sb.append(m59395a);
        Logger.m37557e("AdEventThread", sb.toString());
    }

    /* renamed from: c */
    public static String m59421c() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE," + DomainCampaignEx.LOOPBACK_VALUE + " TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    /* renamed from: c */
    private String m59420c(int i) {
        return (i != 1 && i == 2) ? "adevent_applog" : "adevent";
    }

    /* renamed from: a */
    public Context m59437a() {
        Context context = this.f565a;
        return context == null ? InternalContainer.m59945d() : context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public synchronized List<AdEvent> mo59433a(int i, int i2, String str) {
        LinkedList linkedList;
        String str2 = null;
        if (i2 > 0) {
            if (!TextUtils.isEmpty(str)) {
                str2 = str + " DESC limit " + i2;
            }
        }
        linkedList = new LinkedList();
        Cursor m59394a = DBAdapter.m59403a(m59437a()).m59402a().m59394a(m59420c(i), new String[]{"id", DomainCampaignEx.LOOPBACK_VALUE}, null, null, null, null, str2, null);
        if (m59394a != null) {
            while (m59394a.moveToNext()) {
                linkedList.add(AdEvent.m59442a(m59394a.getString(m59394a.getColumnIndex("id")), m59394a.getString(m59394a.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE))));
            }
            m59394a.close();
        }
        return linkedList;
    }

    @VisibleForTesting
    /* renamed from: b */
    private synchronized void m59422b(int i, List<AdEvent> list) {
        LinkedList linkedList = new LinkedList();
        for (AdEvent adEvent : list) {
            linkedList.add(adEvent.f560a);
        }
        this.f566b.m59402a().m59397a("UPDATE " + m59420c(i) + " SET retry = retry+1 WHERE " + m59426a("id", (List<?>) linkedList, 1000, true));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo59431a(int i, AdEvent adEvent) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", adEvent.f560a);
        JSONObject jSONObject = adEvent.f561b;
        contentValues.put(DomainCampaignEx.LOOPBACK_VALUE, jSONObject != null ? jSONObject.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", (Integer) 0);
        this.f566b.m59402a().m59396a(m59420c(i), (String) null, contentValues);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public synchronized void mo59430a(int i, List<AdEvent> list) {
        if (ListUtils.m59174a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (AdEvent adEvent : list) {
            linkedList.add(adEvent.f560a);
        }
        this.f566b.m59402a().m59397a("DELETE FROM " + m59420c(i) + " WHERE " + m59426a("id", (List<?>) linkedList, 1000, true));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: b */
    public int mo59424b(int i) {
        if (i == 1) {
            return this.f567c.m59133a("serverbusy_retrycount", 0);
        }
        if (i == 2) {
            return this.f567c.m59133a("applog_serverbusy_retrycount", 0);
        }
        return 0;
    }

    /* renamed from: b */
    public static String m59425b() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE," + DomainCampaignEx.LOOPBACK_VALUE + " TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public synchronized void mo59434a(int i, int i2, long j) {
        m59423b(i, i2, j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public synchronized void mo59429a(int i, List<AdEvent> list, int i2, long j) {
        if (ListUtils.m59174a(list)) {
            return;
        }
        try {
            m59422b(i, list);
            m59423b(i, i2, j);
        } catch (Exception unused) {
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public void mo59428a(int i, boolean z) {
        if (i == 1) {
            this.f567c.m59122b("serverbusy_flag", z);
        } else if (i == 2) {
            this.f567c.m59122b("applog_serverbusy_flag", z);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public boolean mo59436a(int i) {
        if (i == 1) {
            return this.f567c.m59129a("serverbusy_flag", false);
        }
        if (i == 2) {
            return this.f567c.m59129a("applog_serverbusy_flag", false);
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory
    /* renamed from: a */
    public void mo59435a(int i, int i2) {
        if (i == 1) {
            this.f567c.m59125b("serverbusy_retrycount", i2);
        } else if (i == 2) {
            this.f567c.m59125b("applog_serverbusy_retrycount", i2);
        }
    }

    /* renamed from: a */
    private static String m59426a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        int i3 = size % min;
        Logger.m37562d("", "len=" + size + ",size=" + i3);
        if (i3 == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * min;
            String m59427a = m59427a(TextUtils.join("','", list.subList(i5, Math.min(i5 + min, size))), "");
            if (i4 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(m59427a);
            sb.append("')");
        }
        String sb2 = sb.toString();
        String m59427a2 = m59427a(sb2, str + str2 + "('')");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sql=");
        sb3.append(m59427a2);
        Logger.m37562d("", sb3.toString());
        return m59427a2;
    }

    /* renamed from: a */
    private static String m59427a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
