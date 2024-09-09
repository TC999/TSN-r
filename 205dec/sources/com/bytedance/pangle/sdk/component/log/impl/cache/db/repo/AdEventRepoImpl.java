package com.bytedance.pangle.sdk.component.log.impl.cache.db.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.DBMultiUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.DBEventUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.ad.AdLogEvent;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdEventRepoImpl implements AdLogEventRepo {
    protected List<String> idEventList = new ArrayList();
    private final Context mContext;
    private PolicyConfig mPolicyConfig;

    public AdEventRepoImpl(Context context, PolicyConfig policyConfig) {
        this.mContext = context;
        this.mPolicyConfig = policyConfig;
        if (policyConfig == null) {
            this.mPolicyConfig = PolicyConfig.createDefault();
        }
    }

    public static String addEncryptColumn() {
        return "ALTER TABLE " + LogInternalManager.getInstance().getDbCallback().getAdEventTableName() + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    private static String buildInOrNotInSql(String str, List<?> list, int i4, boolean z3) {
        int i5;
        String str2 = z3 ? " IN " : " NOT IN ";
        String str3 = z3 ? " OR " : " AND ";
        int min = Math.min(i4, 1000);
        int size = list.size();
        if (size % min == 0) {
            i5 = size / min;
        } else {
            i5 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 * min;
            String defaultIfEmpty = defaultIfEmpty(TextUtils.join("','", list.subList(i7, Math.min(i7 + min, size))), "");
            if (i6 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(defaultIfEmpty);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return defaultIfEmpty(sb2, str + str2 + "('')");
    }

    private static String defaultIfEmpty(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    private synchronized void deleteExpiredInternal(int i4, long j4) {
        long currentTimeMillis = System.currentTimeMillis() - j4;
        Context context = getContext();
        String tableName = getTableName();
        DBMultiUtils.delete(context, tableName, "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i4 + ""});
    }

    public static String getCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + LogInternalManager.getInstance().getDbCallback().getAdEventTableName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    private synchronized void increaseRetryCountInternal(List<AdLogEventFace> list) {
        LinkedList linkedList = new LinkedList();
        for (AdLogEventFace adLogEventFace : list) {
            linkedList.add(adLogEventFace.getLocalId());
        }
        DBMultiUtils.execSQL(getContext(), "UPDATE " + getTableName() + " SET " + AdLogEventRepo.COL_RETRY_COUNT + " = " + AdLogEventRepo.COL_RETRY_COUNT + "+1 WHERE " + buildInOrNotInSql("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized boolean checkNeedUpload(int i4) {
        if (this.mPolicyConfig == null) {
            return false;
        }
        int queryCount = queryCount();
        int i5 = this.mPolicyConfig.getmMaxCacheCount();
        LDebug.w("" + getTableName() + " check dbCount:" + queryCount + " MaxCacheCount:" + i5 + " message:" + i4);
        if (EventDebugUtils.isGroMore() && (i4 == 1 || i4 == 2)) {
            return queryCount >= 1;
        }
        return queryCount >= i5;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized void delete(List<AdLogEventFace> list) {
        if (list != null) {
            if (list.size() != 0) {
                LinkedList linkedList = new LinkedList();
                for (AdLogEventFace adLogEventFace : list) {
                    linkedList.add(adLogEventFace.getLocalId());
                    EventDebugUtils.debugRepoDeleteMessage(adLogEventFace);
                }
                DBMultiUtils.execSQL(getContext(), "DELETE FROM " + getTableName() + " WHERE " + buildInOrNotInSql("id", linkedList, 1000, true));
            }
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized void deleteExpired(int i4, long j4) {
        deleteExpiredInternal(i4, j4);
    }

    protected synchronized void deleteIdList(List<String> list) {
        LDebug.d("adevent repo delete: " + list.size());
        DBMultiUtils.execSQL(getContext(), "DELETE FROM " + getTableName() + " WHERE " + buildInOrNotInSql("id", list, 1000, true));
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getSuccess_delete_count(), list.size());
    }

    public Context getContext() {
        return this.mContext;
    }

    public byte getEventAdType() {
        return (byte) 0;
    }

    public byte getEventPriority() {
        return (byte) 2;
    }

    public String getTableName() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        if (dbCallback != null) {
            return dbCallback.getAdEventTableName();
        }
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized void increaseRetryCountAndDeleteExpired(List<AdLogEventFace> list, int i4, long j4) {
        if (list != null) {
            if (list.size() != 0) {
                try {
                    increaseRetryCountInternal(list);
                    deleteExpiredInternal(i4, j4);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public String printMessage() {
        return "In component db_real_ad.count:" + queryCount();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized List<AdLogEventFace> queryAll() {
        return queryAll(-1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r1 != null) goto L12;
     */
    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int queryCount() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.getContext()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            java.lang.String r3 = r10.getTableName()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            java.lang.String r5 = "count(1)"
            r4[r0] = r5     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = com.bytedance.pangle.sdk.component.log.impl.cache.db.DBMultiUtils.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            if (r1 == 0) goto L24
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2e
        L24:
            if (r1 == 0) goto L37
            goto L30
        L27:
            r0 = move-exception
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L34
        L2d:
            throw r0     // Catch: java.lang.Throwable -> L34
        L2e:
            if (r1 == 0) goto L37
        L30:
            r1.close()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            goto L37
        L34:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L37:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl.queryCount():int");
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized void save(AdLogEventFace adLogEventFace) {
        JSONObject event = adLogEventFace.getEvent();
        if (event != null && !TextUtils.isEmpty(adLogEventFace.getLocalId())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", adLogEventFace.getLocalId());
            String encryptWithCBC = LogInternalManager.getInstance().getAdLogDepend().encryptWithCBC(event.toString());
            if (!TextUtils.isEmpty(encryptWithCBC)) {
                contentValues.put("value", encryptWithCBC);
                contentValues.put(AdLogEventRepo.COL_GEN_TIME, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(AdLogEventRepo.COL_RETRY_COUNT, (Integer) 0);
                contentValues.put(AdLogEventRepo.COL_ENCRYPT_TYPE, (Integer) 1);
                DBMultiUtils.insert(getContext(), getTableName(), contentValues);
            }
        } else {
            LDebug.e("log_show_save", "save error");
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized List<AdLogEventFace> queryAll(int i4, String str) {
        LinkedList linkedList;
        long maxCount = DBEventUtils.getMaxCount(i4, getContext());
        LDebug.w("" + getTableName() + " query db max :" + maxCount + " limit:" + i4);
        String str2 = null;
        if (maxCount > 0 && !TextUtils.isEmpty(str)) {
            str2 = str + " DESC limit " + maxCount;
        }
        String str3 = str2;
        linkedList = new LinkedList();
        this.idEventList.clear();
        Cursor query = DBMultiUtils.query(getContext(), getTableName(), new String[]{"id", "value", AdLogEventRepo.COL_ENCRYPT_TYPE}, null, null, null, null, str3);
        if (query != null) {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("id"));
                String string2 = query.getString(query.getColumnIndex("value"));
                if (query.getInt(query.getColumnIndex(AdLogEventRepo.COL_ENCRYPT_TYPE)) == 1) {
                    string2 = adLogDepend.decryptWithCBC(string2);
                }
                if (TextUtils.isEmpty(string2)) {
                    LDebug.d("log_show_query : value is null");
                    this.idEventList.add(string);
                } else {
                    JSONObject jSONObject = new JSONObject(string2);
                    AdLogEvent adLogEvent = new AdLogEvent(string, jSONObject);
                    adLogEvent.setAdType(getEventAdType());
                    adLogEvent.setPriority(getEventPriority());
                    EventDebugUtils.debugQuery(jSONObject, adLogEvent);
                    linkedList.add(adLogEvent);
                }
            }
            try {
                query.close();
                if (!this.idEventList.isEmpty()) {
                    deleteIdList(this.idEventList);
                    this.idEventList.clear();
                }
            } catch (Exception unused) {
            }
        }
        LDebug.w("" + getTableName() + " query db actually size :" + linkedList.size());
        return linkedList;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public synchronized List<AdLogEventFace> queryAll(String str) {
        PolicyConfig policyConfig = this.mPolicyConfig;
        if (policyConfig == null) {
            return new ArrayList();
        }
        return queryAll(policyConfig.getmAtMostBatchSendCount(), str);
    }
}
