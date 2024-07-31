package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SerializeTools;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* renamed from: com.mbridge.msdk.foundation.db.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CampaignClickDao extends BaseDao<CommonJumpLoader.JumpLoaderResult> {

    /* renamed from: a */
    public static final String f30325a = "c";

    /* renamed from: b */
    private static CampaignClickDao f30326b;

    /* renamed from: c */
    private Setting f30327c;

    /* renamed from: d */
    private int f30328d;

    private CampaignClickDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
        this.f30328d = 100;
    }

    /* renamed from: a */
    public static CampaignClickDao m22799a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30326b == null) {
            synchronized (CampaignClickDao.class) {
                if (f30326b == null) {
                    f30326b = new CampaignClickDao(commonAbsDBHelper);
                }
            }
        }
        return f30326b;
    }

    /* renamed from: c */
    private synchronized boolean m22794c(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid= '" + str2 + "'", null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r11 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r11 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult m22795b(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r2 = "campaignclick"
            r3 = 0
            java.lang.String r4 = "id=? AND unitid=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r6 = 0
            r5[r6] = r11     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r11 = 1
            r5[r11] = r12     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r11 == 0) goto L47
            int r12 = r11.getCount()     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            if (r12 <= 0) goto L47
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            if (r12 == 0) goto L47
            java.lang.String r12 = "result"
            int r12 = r11.getColumnIndex(r12)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            java.lang.String r12 = r11.getString(r12)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            if (r1 != 0) goto L47
            java.lang.Object r12 = com.mbridge.msdk.foundation.tools.SerializeTools.m21964a(r12)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r12 = (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r12     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L59
            r11.close()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L61
        L43:
            monitor-exit(r10)
            return r12
        L45:
            r12 = move-exception
            goto L51
        L47:
            if (r11 == 0) goto L57
        L49:
            r11.close()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L61
            goto L57
        L4d:
            r12 = move-exception
            goto L5b
        L4f:
            r12 = move-exception
            r11 = r0
        L51:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r11 == 0) goto L57
            goto L49
        L57:
            monitor-exit(r10)
            return r0
        L59:
            r12 = move-exception
            r0 = r11
        L5b:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L61
        L60:
            throw r12     // Catch: java.lang.Throwable -> L61
        L61:
            r11 = move-exception
            monitor-exit(r10)
            goto L65
        L64:
            throw r11
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignClickDao.m22795b(java.lang.String, java.lang.String):com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult");
    }

    /* renamed from: a */
    public final synchronized void m22800a() {
        try {
            getWritableDatabase().delete("campaignclick", "(pts not " + ((Object) null) + " AND (  ( " + DomainCampaignEx.JSON_KEY_TTC_TYPE + " = 2 AND (  ( cps = 1 AND (" + System.currentTimeMillis() + " - pts) > cpti )  OR  (cps = 0 AND (" + System.currentTimeMillis() + " - pts) > cpei )  )  ) OR ( " + DomainCampaignEx.JSON_KEY_TTC_TYPE + " = 1 AND  ( " + System.currentTimeMillis() + " - pts )  > " + DomainCampaignEx.JSON_KEY_TTC_CT2 + " ) ) ) OR ( pts is " + ((Object) null) + " AND  ( " + System.currentTimeMillis() + " - ts) > cti)", null);
        } catch (Exception e) {
            SameLogTool.m21733d(f30325a, e.getMessage());
        }
    }

    /* renamed from: a */
    public final synchronized long m22798a(CampaignEx campaignEx, String str, boolean z, int i, int i2) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            String m21965a = SerializeTools.m21965a(campaignEx.getJumpResult());
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", str);
            contentValues.put(CommonNetImpl.RESULT, m21965a);
            contentValues.put("cpti", Integer.valueOf(campaignEx.getPreClickInterval() * 1000));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
            contentValues.put("package_name", campaignEx.getPackageName());
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (z) {
                contentValues.put("pts", Long.valueOf(System.currentTimeMillis()));
                if (i == 0 || i == 1) {
                    contentValues.put("cps", Integer.valueOf(i));
                }
                if (m23252b != null && m23252b.m23414T() > 0) {
                    contentValues.put("n4", Integer.valueOf(m23252b.m23414T() * 1000));
                }
                contentValues.put(DomainCampaignEx.JSON_KEY_TTC_CT2, Integer.valueOf(campaignEx.getTtc_ct2() * 1000));
                contentValues.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, Integer.valueOf(i2));
            } else {
                contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
            }
            if (m23252b != null && m23252b.m23357ao() > 0) {
                contentValues.put("cpei", Integer.valueOf(m23252b.m23357ao() * 1000));
            }
            if (m23252b != null && m23252b.m23356ap() > 0) {
                contentValues.put("cpoci", Integer.valueOf(m23252b.m23356ap() * 1000));
            }
            if (m22794c(campaignEx.getId(), str)) {
                String str2 = "id = " + campaignEx.getId() + " AND unitid = " + str;
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, str2, null);
            }
            return getWritableDatabase().insert("campaignclick", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x01c6, code lost:
        if (r2 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01c8, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01d5, code lost:
        if (r2 == null) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22797a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignClickDao.m22797a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final synchronized boolean m22796a(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid='" + str2 + "' AND cti + ts > " + System.currentTimeMillis(), null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Exception e) {
            SameLogTool.m21733d(f30325a, e.getMessage());
            return false;
        }
    }
}
