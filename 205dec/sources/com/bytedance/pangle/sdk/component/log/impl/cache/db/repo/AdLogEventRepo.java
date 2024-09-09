package com.bytedance.pangle.sdk.component.log.impl.cache.db.repo;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface AdLogEventRepo {
    public static final String COL_ENCRYPT_TYPE = "encrypt";
    public static final String COL_GEN_TIME = "gen_time";
    public static final String COL_ID = "id";
    public static final String COL_RETRY_COUNT = "retry";
    public static final String COL_VALUE = "value";
    public static final int ENCRYPT_TYPE_AES = 1;
    public static final int ENCRYPT_TYPE_DEFAULT = 0;

    boolean checkNeedUpload(int i4);

    void delete(List<AdLogEventFace> list);

    void deleteExpired(int i4, long j4);

    void increaseRetryCountAndDeleteExpired(List<AdLogEventFace> list, int i4, long j4);

    String printMessage();

    List<AdLogEventFace> queryAll();

    List<AdLogEventFace> queryAll(int i4, String str);

    List<AdLogEventFace> queryAll(String str);

    int queryCount();

    void save(AdLogEventFace adLogEventFace);
}
