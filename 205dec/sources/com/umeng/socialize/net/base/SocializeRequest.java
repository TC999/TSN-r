package com.umeng.socialize.net.base;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class SocializeRequest extends URequest {
    private static final String BASE_URL = "https://log.umsns.com/";
    public static final int REQUEST_ANALYTIC = 1;
    public static final int REQUEST_API = 2;
    public static final int REQUEST_SOCIAL = 0;
    private static final String TAG = "SocializeRequest";
    private Map<String, URequest.FilePair> mFileMap;
    public int mOpId;
    private int mReqType;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.umeng.socialize.net.base.SocializeRequest$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod;

        static {
            int[] iArr = new int[URequest.RequestMethod.values().length];
            $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod = iArr;
            try {
                iArr[URequest.RequestMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod[URequest.RequestMethod.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum FILE_TYPE {
        IMAGE,
        VEDIO
    }

    public SocializeRequest(Context context, String str, Class<? extends SocializeReseponse> cls, int i4, URequest.RequestMethod requestMethod) {
        super("");
        this.mFileMap = new HashMap();
        this.mReqType = 1;
        this.mResponseClz = cls;
        this.mOpId = i4;
        this.mContext = context;
        this.mMethod = requestMethod;
        setBaseUrl("https://log.umsns.com/");
    }

    public static Map<String, Object> getBaseQuery(Context context) {
        HashMap hashMap = new HashMap();
        String deviceId = DeviceConfig.getDeviceId(context);
        if (!TextUtils.isEmpty(deviceId)) {
            hashMap.put("imei", deviceId);
        }
        String mac = DeviceConfig.getMac(context);
        if (TextUtils.isEmpty(mac)) {
            mac = DefaultClass.getMac();
            SLog.I(UmengText.NET.MACNULL);
        }
        hashMap.put("mac", mac);
        if (!TextUtils.isEmpty(SocializeConstants.UID)) {
            hashMap.put("uid", SocializeConstants.UID);
        }
        try {
            hashMap.put("en", DeviceConfig.getNetworkAccessMode(context)[0]);
        } catch (Exception unused) {
            hashMap.put("en", "Unknown");
        }
        hashMap.put("de", Build.MODEL);
        hashMap.put("sdkv", "7.3.2");
        hashMap.put("os", "Android");
        hashMap.put("android_id", DeviceConfig.getAndroidID(context));
        hashMap.put("sn", DeviceConfig.getDeviceSN());
        hashMap.put("os_version", DeviceConfig.getOsVersion());
        hashMap.put("dt", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("ak", SocializeUtils.getAppkey(context));
        hashMap.put(SocializeProtocolConstants.PROTOCOL_VERSION, "3.0");
        hashMap.put("u_sharetype", Config.shareType);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            hashMap.put("ek", Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            hashMap.put("sid", Config.SessionId);
        }
        try {
            hashMap.put("tp", 0);
        } catch (Exception e4) {
            SLog.error(e4);
        }
        return hashMap;
    }

    private String mapTostring(Map<String, Object> map) {
        if (this.mParams.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception e4) {
            SLog.error(e4);
            return null;
        }
    }

    public void addFileParams(byte[] bArr, FILE_TYPE file_type, String str) {
        if (FILE_TYPE.IMAGE == file_type) {
            String c4 = a.c(bArr);
            if (TextUtils.isEmpty(c4)) {
                c4 = "png";
            }
            this.mFileMap.put(SocializeProtocolConstants.PROTOCOL_KEY_IMAGE, new URequest.FilePair(SocializeUtils.md5(bArr) + "." + c4, bArr));
        }
    }

    public void addMediaParams(UMediaObject uMediaObject) {
        if (uMediaObject == null) {
            return;
        }
        if (uMediaObject instanceof BaseMediaObject) {
            addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, ((BaseMediaObject) uMediaObject).getTitle());
        }
        if (uMediaObject.isUrlMedia()) {
            for (Map.Entry<String, Object> entry : uMediaObject.toUrlExtraParams().entrySet()) {
                addStringParams(entry.getKey(), entry.getValue().toString());
            }
            return;
        }
        byte[] bArr = uMediaObject.toByte();
        if (bArr != null) {
            addFileParams(bArr, FILE_TYPE.IMAGE, null);
        }
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public Map<String, Object> buildParams() {
        Map<String, Object> baseQuery = getBaseQuery(this.mContext);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            baseQuery.put("ek", Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            baseQuery.put("sid", Config.SessionId);
        }
        baseQuery.put("tp", Integer.valueOf(this.mReqType));
        baseQuery.put("opid", Integer.valueOf(this.mOpId));
        baseQuery.put("uid", UMUtils.getUMId(this.mContext));
        baseQuery.putAll(this.mParams);
        return baseQuery;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public Map<String, Object> getBodyPair() {
        return buildParams();
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public Map<String, URequest.FilePair> getFilePair() {
        return this.mFileMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.umeng.socialize.net.utils.URequest
    public String getHttpMethod() {
        if (AnonymousClass1.$SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod[this.mMethod.ordinal()] != 1) {
            return URequest.GET;
        }
        return URequest.POST;
    }

    protected abstract String getPath();

    @Override // com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams("pcv", "3.0");
        addStringParams("u_sharetype", Config.shareType);
        addStringParams("imei", DeviceConfig.getDeviceId(this.mContext));
        addStringParams("de", Build.MODEL);
        addStringParams("mac", DeviceConfig.getMac(this.mContext));
        addStringParams("os", "Android");
        addStringParams("en", DeviceConfig.getNetworkAccessMode(this.mContext)[0]);
        addStringParams("uid", null);
        addStringParams("sdkv", "7.3.2");
        addStringParams("dt", String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public void setBaseUrl(String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(getPath())) {
                str2 = new URL(new URL(str), getPath()).toString();
            }
        } catch (Exception e4) {
            SLog.error(UmengText.NET.getURLERROR(str), e4);
        }
        super.setBaseUrl(str2);
    }

    public void setReqType(int i4) {
        this.mReqType = i4;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String toGetUrl() {
        return generateGetURL(getBaseUrl(), buildParams());
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public JSONObject toJson() {
        return null;
    }
}
