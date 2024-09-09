package com.tencent.connect.common;

import android.content.Intent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UIListenerManager {

    /* renamed from: a  reason: collision with root package name */
    private static UIListenerManager f51508a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, ApiTask> f51509b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i4, IUiListener iUiListener) {
            this.mRequestCode = i4;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f51509b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f51509b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i4, IUiListener iUiListener) {
        if (i4 == 11101) {
            SLog.e("openSDK_LOG.UIListenerManager", "\u767b\u5f55\u7684\u63a5\u53e3\u56de\u8c03\u4e0d\u80fd\u91cd\u65b0\u6784\u5efa\uff0c\u6682\u65f6\u65e0\u6cd5\u63d0\u4f9b\uff0c\u5148\u8bb0\u5f55\u4e0b\u6765\u8fd9\u79cd\u60c5\u51b5\u662f\u5426\u5b58\u5728");
        } else if (i4 == 11105) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api \u7684\u63a5\u53e3\u56de\u8c03\u9700\u8981\u4f7f\u7528param\u6765\u91cd\u65b0\u6784\u5efa\uff0c\u6682\u65f6\u65e0\u6cd5\u63d0\u4f9b\uff0c\u5148\u8bb0\u5f55\u4e0b\u6765\u8fd9\u79cd\u60c5\u51b5\u662f\u5426\u5b58\u5728");
        } else if (i4 == 11106) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api \u7684H5\u63a5\u53e3\u56de\u8c03\u9700\u8981\u4f7f\u7528param\u6765\u91cd\u65b0\u6784\u5efa\uff0c\u6682\u65f6\u65e0\u6cd5\u63d0\u4f9b\uff0c\u5148\u8bb0\u5f55\u4e0b\u6765\u8fd9\u79cd\u60c5\u51b5\u662f\u5426\u5b58\u5728");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f51508a == null) {
            f51508a = new UIListenerManager();
        }
        return f51508a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f51509b) {
            apiTask = this.f51509b.get(str);
            this.f51509b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i4) {
        String a4 = k.a(i4);
        if (a4 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i4);
            return null;
        }
        return getListnerWithAction(a4);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra("key_action");
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra("key_error_code", 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra("key_response");
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(m.d(stringExtra2));
                        return;
                    } catch (JSONException e4) {
                        iUiListener.onError(new UiError(-4, "\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e\u683c\u5f0f\u6709\u8bef!", stringExtra2));
                        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e4);
                        return;
                    }
                }
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            iUiListener.onError(new UiError(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
        } else if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
            } else if (CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i4, int i5, Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i4 + " res=" + i5);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i4);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i4, iUiListener);
            } else {
                SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i5 != -1) {
            listnerWithRequestCode.onCancel();
            return true;
        } else if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra("key_action");
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra("key_error_code", 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra("key_response");
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(m.d(stringExtra2));
                            return true;
                        } catch (JSONException e4) {
                            listnerWithRequestCode.onError(new UiError(-4, "\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e\u683c\u5f0f\u6709\u8bef!", stringExtra2));
                            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e4);
                            return true;
                        }
                    }
                    SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                return true;
            } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra) && !"guildOpen".equals(stringExtra)) {
                if ("action_common_channel".equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra("key_error_code", 0);
                    if (intExtra2 == 0) {
                        String stringExtra3 = intent.getStringExtra("response");
                        if (stringExtra3 != null) {
                            try {
                                String stringExtra4 = intent.getStringExtra("message");
                                JSONObject d4 = m.d(stringExtra3);
                                d4.put("message", stringExtra4);
                                listnerWithRequestCode.onComplete(d4);
                                return true;
                            } catch (JSONException unused) {
                                listnerWithRequestCode.onError(new UiError(-4, "\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e\u683c\u5f0f\u6709\u8bef!", stringExtra3));
                                return true;
                            }
                        }
                        listnerWithRequestCode.onComplete(new JSONObject());
                        return true;
                    }
                    listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                    return true;
                }
                int intExtra3 = intent.getIntExtra("key_error_code", 0);
                if (intExtra3 == 0) {
                    String stringExtra5 = intent.getStringExtra("key_response");
                    if (stringExtra5 != null) {
                        try {
                            listnerWithRequestCode.onComplete(m.d(stringExtra5));
                            return true;
                        } catch (JSONException unused2) {
                            listnerWithRequestCode.onError(new UiError(-4, "\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e\u683c\u5f0f\u6709\u8bef!", stringExtra5));
                            return true;
                        }
                    }
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                listnerWithRequestCode.onError(new UiError(intExtra3, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                return true;
            } else {
                String stringExtra6 = intent.getStringExtra("result");
                String stringExtra7 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra6)) {
                    listnerWithRequestCode.onCancel();
                    return true;
                } else if ("error".equals(stringExtra6)) {
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra7 + ""));
                    return true;
                } else if (CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equals(stringExtra6)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra7 == null ? "{\"ret\": 0}" : stringExtra7));
                        return true;
                    } catch (JSONException e5) {
                        SLog.e("openSDK_LOG.UIListenerManager", "JSONException", e5);
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra7 + ""));
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }

    public Object setListenerWithRequestcode(int i4, IUiListener iUiListener) {
        ApiTask put;
        String a4 = k.a(i4);
        if (a4 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i4);
            return null;
        }
        synchronized (this.f51509b) {
            put = this.f51509b.put(a4, new ApiTask(i4, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int b4 = k.b(str);
        if (b4 == -1) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f51509b) {
            put = this.f51509b.put(str, new ApiTask(b4, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
