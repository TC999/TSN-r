package com.umeng.socialize.net.base;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.p571c.p572a.ImageImpl;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SocializeRequest extends URequest {
    private static final String BASE_URL = "https://log.umsns.com/";
    public static final int REQUEST_ANALYTIC = 1;
    public static final int REQUEST_API = 2;
    public static final int REQUEST_SOCIAL = 0;
    private static final String TAG = "SocializeRequest";
    private Map<String, URequest.FilePair> mFileMap;
    public int mOpId;
    private int mReqType;

    /* renamed from: com.umeng.socialize.net.base.SocializeRequest$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C134151 {
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

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum FILE_TYPE {
        IMAGE,
        VEDIO
    }

    public SocializeRequest(Context context, String str, Class<? extends SocializeReseponse> cls, int i, URequest.RequestMethod requestMethod) {
        super("");
        this.mFileMap = new HashMap();
        this.mReqType = 1;
        this.mResponseClz = cls;
        this.mOpId = i;
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
            SLog.m13210I(UmengText.NET.MACNULL);
        }
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, mac);
        if (!TextUtils.isEmpty(SocializeConstants.UID)) {
            hashMap.put("uid", SocializeConstants.UID);
        }
        try {
            hashMap.put("en", DeviceConfig.getNetworkAccessMode(context)[0]);
        } catch (Exception unused) {
            hashMap.put("en", "Unknown");
        }
        hashMap.put("de", Build.MODEL);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, "7.3.2");
        hashMap.put("os", "Android");
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidID(context));
        hashMap.put("sn", DeviceConfig.getDeviceSN());
        hashMap.put("os_version", DeviceConfig.getOsVersion());
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_DT, Long.valueOf(System.currentTimeMillis()));
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, SocializeUtils.getAppkey(context));
        hashMap.put(SocializeProtocolConstants.PROTOCOL_VERSION, SocializeConstants.PROTOCOL_VERSON);
        hashMap.put(SocializeConstants.USHARETYPE, Config.shareType);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, Config.SessionId);
        }
        try {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, 0);
        } catch (Exception e) {
            SLog.error(e);
        }
        return hashMap;
    }

    private String mapTostring(Map<String, Object> map) {
        if (this.mParams.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception e) {
            SLog.error(e);
            return null;
        }
    }

    public void addFileParams(byte[] bArr, FILE_TYPE file_type, String str) {
        if (FILE_TYPE.IMAGE == file_type) {
            String m13302c = ImageImpl.m13302c(bArr);
            if (TextUtils.isEmpty(m13302c)) {
                m13302c = "png";
            }
            this.mFileMap.put(SocializeProtocolConstants.PROTOCOL_KEY_IMAGE, new URequest.FilePair(SocializeUtils.md5(bArr) + "." + m13302c, bArr));
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
            baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, Config.SessionId);
        }
        baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, Integer.valueOf(this.mReqType));
        baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_OPID, Integer.valueOf(this.mOpId));
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
        if (C134151.$SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod[this.mMethod.ordinal()] != 1) {
            return URequest.GET;
        }
        return URequest.POST;
    }

    protected abstract String getPath();

    @Override // com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams("pcv", SocializeConstants.PROTOCOL_VERSON);
        addStringParams(SocializeConstants.USHARETYPE, Config.shareType);
        addStringParams("imei", DeviceConfig.getDeviceId(this.mContext));
        addStringParams("de", Build.MODEL);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_MAC, DeviceConfig.getMac(this.mContext));
        addStringParams("os", "Android");
        addStringParams("en", DeviceConfig.getNetworkAccessMode(this.mContext)[0]);
        addStringParams("uid", null);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, "7.3.2");
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DT, String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public void setBaseUrl(String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(getPath())) {
                str2 = new URL(new URL(str), getPath()).toString();
            }
        } catch (Exception e) {
            SLog.error(UmengText.NET.getURLERROR(str), e);
        }
        super.setBaseUrl(str2);
    }

    public void setReqType(int i) {
        this.mReqType = i;
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
