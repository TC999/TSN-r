package com.tencent.connect.common;

import android.content.Intent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UIListenerManager {

    /* renamed from: a */
    private static UIListenerManager f37143a;

    /* renamed from: b */
    private Map<String, ApiTask> f37144b;

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f37144b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f37144b = Collections.synchronizedMap(new HashMap());
        }
    }

    /* renamed from: a */
    private IUiListener m15304a(int i, IUiListener iUiListener) {
        if (i == 11101) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f37143a == null) {
            f37143a = new UIListenerManager();
        }
        return f37143a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f37144b) {
            apiTask = this.f37144b.get(str);
            this.f37144b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String m15001a = C13066k.m15001a(i);
        if (m15001a == null) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
            return null;
        }
        return getListnerWithAction(m15001a);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(C13071m.m14933d(stringExtra2));
                        return;
                    } catch (JSONException e) {
                        iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        SLog.m15128e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        return;
                    }
                }
                SLog.m15131d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            SLog.m15129e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        } else if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra(CommonNetImpl.RESULT);
            String stringExtra4 = intent.getStringExtra("response");
            if (CommonNetImpl.CANCEL.equals(stringExtra3)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
            } else if (CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = m15304a(i, iUiListener);
            } else {
                SLog.m15129e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 != -1) {
            listnerWithRequestCode.onCancel();
            return true;
        } else if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(C13071m.m14933d(stringExtra2));
                            return true;
                        } catch (JSONException e) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            SLog.m15128e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                            return true;
                        }
                    }
                    SLog.m15131d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                SLog.m15129e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra) && !"guildOpen".equals(stringExtra)) {
                if ("action_common_channel".equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra2 == 0) {
                        String stringExtra3 = intent.getStringExtra("response");
                        if (stringExtra3 != null) {
                            try {
                                String stringExtra4 = intent.getStringExtra("message");
                                JSONObject m14933d = C13071m.m14933d(stringExtra3);
                                m14933d.put("message", stringExtra4);
                                listnerWithRequestCode.onComplete(m14933d);
                                return true;
                            } catch (JSONException unused) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra3));
                                return true;
                            }
                        }
                        listnerWithRequestCode.onComplete(new JSONObject());
                        return true;
                    }
                    listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    return true;
                }
                int intExtra3 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra3 == 0) {
                    String stringExtra5 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra5 != null) {
                        try {
                            listnerWithRequestCode.onComplete(C13071m.m14933d(stringExtra5));
                            return true;
                        } catch (JSONException unused2) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra5));
                            return true;
                        }
                    }
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                listnerWithRequestCode.onError(new UiError(intExtra3, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            } else {
                String stringExtra6 = intent.getStringExtra(CommonNetImpl.RESULT);
                String stringExtra7 = intent.getStringExtra("response");
                if (CommonNetImpl.CANCEL.equals(stringExtra6)) {
                    listnerWithRequestCode.onCancel();
                    return true;
                } else if ("error".equals(stringExtra6)) {
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra7 + ""));
                    return true;
                } else if (CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equals(stringExtra6)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra7 == null ? "{\"ret\": 0}" : stringExtra7));
                        return true;
                    } catch (JSONException e2) {
                        SLog.m15128e("openSDK_LOG.UIListenerManager", "JSONException", e2);
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra7 + ""));
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        ApiTask put;
        String m15001a = C13066k.m15001a(i);
        if (m15001a == null) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.f37144b) {
            put = this.f37144b.put(m15001a, new ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int m14986b = C13066k.m14986b(str);
        if (m14986b == -1) {
            SLog.m15129e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f37144b) {
            put = this.f37144b.put(str, new ApiTask(m14986b, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
