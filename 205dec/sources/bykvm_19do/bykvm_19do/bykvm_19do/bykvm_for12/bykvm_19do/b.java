package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.l;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdEventRepertoryImpl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements a<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f558a;

    /* renamed from: b  reason: collision with root package name */
    private final h f559b;

    /* renamed from: c  reason: collision with root package name */
    private final r f560c = r.a("tt_adevent", a());

    public b(Context context) {
        this.f558a = context;
        this.f559b = h.a(context);
    }

    private synchronized void b(int i4, int i5, long j4) {
        i.c a4 = this.f559b.a();
        String c4 = c(i4);
        int a5 = a4.a(c4, "gen_time < ? AND retry >?", new String[]{(System.currentTimeMillis() - j4) + "", i5 + ""});
        StringBuilder sb = new StringBuilder();
        sb.append("\u5ba2\u6237\u7aef\u5bb9\u707e\u72b6\u6001\u4e0b\u4e8b\u4ef6\u8fc7\u671f\u65f6\u95f4(2\u5929)\uff1a");
        sb.append(j4);
        sb.append("\uff0c\u6210\u529f\u5220\u9664\u65e5\u5fd7\u6761\u6570\uff1adelete count=");
        sb.append(a5);
        Logger.e("AdEventThread", sb.toString());
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0)";
    }

    private String c(int i4) {
        return (i4 != 1 && i4 == 2) ? "adevent_applog" : "adevent";
    }

    public Context a() {
        Context context = this.f558a;
        return context == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() : context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public synchronized List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> a(int i4, int i5, String str) {
        LinkedList linkedList;
        String str2 = null;
        if (i5 > 0) {
            if (!TextUtils.isEmpty(str)) {
                str2 = str + " DESC limit " + i5;
            }
        }
        linkedList = new LinkedList();
        Cursor a4 = h.a(a()).a().a(c(i4), new String[]{"id", "value"}, null, null, null, null, str2, null);
        if (a4 != null) {
            while (a4.moveToNext()) {
                linkedList.add(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(a4.getString(a4.getColumnIndex("id")), a4.getString(a4.getColumnIndex("value"))));
            }
            a4.close();
        }
        return linkedList;
    }

    @VisibleForTesting
    private synchronized void b(int i4, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> list) {
        LinkedList linkedList = new LinkedList();
        for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a aVar : list) {
            linkedList.add(aVar.f553a);
        }
        this.f559b.a().a("UPDATE " + c(i4) + " SET " + AdLogEventRepo.COL_RETRY_COUNT + " = " + AdLogEventRepo.COL_RETRY_COUNT + "+1 WHERE " + a("id", (List<?>) linkedList, 1000, true));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public synchronized void a(int i4, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f553a);
        JSONObject jSONObject = aVar.f554b;
        contentValues.put("value", jSONObject != null ? jSONObject.toString() : "");
        contentValues.put(AdLogEventRepo.COL_GEN_TIME, Long.valueOf(System.currentTimeMillis()));
        contentValues.put(AdLogEventRepo.COL_RETRY_COUNT, (Integer) 0);
        this.f559b.a().a(c(i4), (String) null, contentValues);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public synchronized void a(int i4, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> list) {
        if (l.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a aVar : list) {
            linkedList.add(aVar.f553a);
        }
        this.f559b.a().a("DELETE FROM " + c(i4) + " WHERE " + a("id", (List<?>) linkedList, 1000, true));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public int b(int i4) {
        if (i4 == 1) {
            return this.f560c.a("serverbusy_retrycount", 0);
        }
        if (i4 == 2) {
            return this.f560c.a("applog_serverbusy_retrycount", 0);
        }
        return 0;
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public synchronized void a(int i4, int i5, long j4) {
        b(i4, i5, j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public synchronized void a(int i4, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> list, int i5, long j4) {
        if (l.a(list)) {
            return;
        }
        try {
            b(i4, list);
            b(i4, i5, j4);
        } catch (Exception unused) {
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public void a(int i4, boolean z3) {
        if (i4 == 1) {
            this.f560c.b("serverbusy_flag", z3);
        } else if (i4 == 2) {
            this.f560c.b("applog_serverbusy_flag", z3);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public boolean a(int i4) {
        if (i4 == 1) {
            return this.f560c.a("serverbusy_flag", false);
        }
        if (i4 == 2) {
            return this.f560c.a("applog_serverbusy_flag", false);
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
    public void a(int i4, int i5) {
        if (i4 == 1) {
            this.f560c.b("serverbusy_retrycount", i5);
        } else if (i4 == 2) {
            this.f560c.b("applog_serverbusy_retrycount", i5);
        }
    }

    private static String a(String str, List<?> list, int i4, boolean z3) {
        int i5;
        String str2 = z3 ? " IN " : " NOT IN ";
        String str3 = z3 ? " OR " : " AND ";
        int min = Math.min(i4, 1000);
        int size = list.size();
        int i6 = size % min;
        Logger.d("", "len=" + size + ",size=" + i6);
        if (i6 == 0) {
            i5 = size / min;
        } else {
            i5 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * min;
            String a4 = a(TextUtils.join("','", list.subList(i8, Math.min(i8 + min, size))), "");
            if (i7 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a4);
            sb.append("')");
        }
        String sb2 = sb.toString();
        String a5 = a(sb2, str + str2 + "('')");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sql=");
        sb3.append(a5);
        Logger.d("", sb3.toString());
        return a5;
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
