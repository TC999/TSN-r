package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.db.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidReplaceCampignDao extends BaseDao {

    /* renamed from: a */
    private static volatile BidReplaceCampignDao f30324a;

    private BidReplaceCampignDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static BidReplaceCampignDao m22806a(Context context) {
        if (f30324a == null) {
            synchronized (BidReplaceCampignDao.class) {
                if (f30324a == null) {
                    f30324a = new BidReplaceCampignDao(CommonSDKDBHelper.m22721a(context));
                }
            }
        }
        return f30324a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c7, code lost:
        if (r9 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d9, code lost:
        if (0 == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00db, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00de, code lost:
        return r0;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.mbridge.msdk.foundation.entity.BidTokenRuleBean> m22801b(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto Lc
            return r0
        Lc:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L13
            return r0
        L13:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM bid_replace_campaign WHERE "
            r1.append(r2)
            java.lang.String r2 = "bid_unit_id"
            r1.append(r2)
            java.lang.String r2 = " = '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = "' AND "
            r1.append(r9)
            java.lang.String r9 = "real_request_id"
            r1.append(r9)
            java.lang.String r9 = " = '"
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = "'"
            r1.append(r9)
            r9 = 0
            java.lang.Object r10 = new java.lang.Object     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.<init>()     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            monitor-enter(r10)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            android.database.sqlite.SQLiteDatabase r2 = r8.getReadableDatabase()     // Catch: java.lang.Throwable -> Lca
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lca
            android.database.Cursor r9 = r2.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> Lca
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lca
            if (r9 == 0) goto Lc7
            int r10 = r9.getCount()     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            if (r10 <= 0) goto Lc7
        L5d:
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            if (r10 == 0) goto Lc7
            com.mbridge.msdk.foundation.entity.d r10 = new com.mbridge.msdk.foundation.entity.d     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.<init>()     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r1 = "bid_unit_id"
            int r1 = r9.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r1 = r9.getString(r1)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r2 = "expect_bid_token"
            int r2 = r9.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r2 = r9.getString(r2)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r3 = "expect_encrypt_price"
            int r3 = r9.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r3 = r9.getString(r3)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r4 = "real_request_id"
            int r4 = r9.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r4 = r9.getString(r4)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r5 = "real_encrypt_price"
            int r5 = r9.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r5 = r9.getString(r5)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r6 = "real_token_rule"
            int r6 = r9.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            int r6 = r9.getInt(r6)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            java.lang.String r7 = "is_replace"
            int r7 = r9.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            int r7 = r9.getInt(r7)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22606a(r1)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22603b(r2)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22601c(r3)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22599d(r4)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22598e(r5)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22607a(r6)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r10.m22604b(r7)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            r0.add(r10)     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
            goto L5d
        Lc7:
            if (r9 == 0) goto Lde
            goto Ldb
        Lca:
            r1 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lca
            throw r1     // Catch: java.lang.Throwable -> Lcd java.lang.Exception -> Lcf
        Lcd:
            r10 = move-exception
            goto Ldf
        Lcf:
            r10 = move-exception
            java.lang.String r1 = "BidReplaceCampaignDao"
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch: java.lang.Throwable -> Lcd
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r10)     // Catch: java.lang.Throwable -> Lcd
            if (r9 == 0) goto Lde
        Ldb:
            r9.close()
        Lde:
            return r0
        Ldf:
            if (r9 == 0) goto Le4
            r9.close()
        Le4:
            goto Le6
        Le5:
            throw r10
        Le6:
            goto Le5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.BidReplaceCampignDao.m22801b(java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public final void m22802a(String str, List<CampaignEx> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        try {
            String requestId = list.get(0).getRequestId();
            String encryptPrice = list.get(0).getEncryptPrice();
            String campaignUnitId = list.get(0).getCampaignUnitId();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("bid_unit_id", campaignUnitId);
            contentValues.put("expect_bid_token", str);
            contentValues.put("expect_encrypt_price", "");
            contentValues.put("real_request_id", requestId);
            contentValues.put("real_encrypt_price", encryptPrice);
            contentValues.put("real_token_rule", (Integer) 1);
            contentValues.put("is_replace", (Integer) 0);
            writableDatabase.insert("bid_replace_campaign", null, contentValues);
            SameLogTool.m21733d("HBOPTIMIZE", "插入数据到对应关系表 期望 bidToken 值" + str + "+ 用于替换期望Offer 的RequestId " + requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final int m22804a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_replace", (Integer) 1);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = '" + str2 + "' AND expect_bid_token = '" + str + "'", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public final int m22805a(String str) {
        try {
            String str2 = "real_request_id = '" + str + "' AND is_replace = 1";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", str2, null);
        } catch (Exception e) {
            SameLogTool.m21733d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public final int m22807a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", null);
        } catch (Exception e) {
            SameLogTool.m21733d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public final int m22803a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expect_encrypt_price", str3);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = '" + str2 + "' AND expect_bid_token = '" + str + "'", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
