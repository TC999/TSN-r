package cn.jiguang.k;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3689a;

    /* renamed from: b  reason: collision with root package name */
    private String f3690b;

    public a(Context context) {
        this.f3690b = "";
        this.f3689a = context;
        this.f3690b = d.f("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cursor query = this.f3689a.getContentResolver().query(Uri.parse(this.f3690b), null, null, new String[]{str}, null);
            if (query != null) {
                r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            } else {
                cn.jiguang.w.a.b("MeizuDB", "return cursor is null,return");
            }
        } catch (Exception e4) {
            cn.jiguang.w.a.f("MeizuDB", "getId error: " + e4.getMessage());
        }
        return r1;
    }
}
