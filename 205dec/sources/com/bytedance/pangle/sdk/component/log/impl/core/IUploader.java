package com.bytedance.pangle.sdk.component.log.impl.core;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IUploader {
    public static final int CODE_RSPBODY_EXCEPTION = 511;
    public static final int CODE_RSPBODY_RSP_OVERDUE = 513;
    public static final int CODE_RSPBODY_SIGN_FAIL = 512;
    public static final int CODE_RSP_IS_NULL = 510;
    public static final int DEFAULT = 0;
    public static final int INVALID_DATA_CODE = -1;
    public static final int OTHER_ERROR = -2;
    public static final int SERVER_BUSY = 509;
    public static final int SUCCESS_CODE = 200;

    void upload(List<AdLogEventFace> list, IUploadResult iUploadResult);
}
