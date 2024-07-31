package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.click.p460a.RetryReportControl;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p478e.CommonTaskLoader;
import com.mbridge.msdk.rover.RoverListener;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonJumpLoader extends CommonLoader {

    /* renamed from: d */
    private int f29961d;

    /* renamed from: g */
    private CommonTaskLoader f29964g;

    /* renamed from: h */
    private WebViewSpiderLoader f29965h;

    /* renamed from: b */
    private int f29959b = 0;

    /* renamed from: c */
    private String f29960c = null;

    /* renamed from: a */
    JumpLoaderResult f29958a = null;

    /* renamed from: e */
    private CommonLoaderListener f29962e = null;

    /* renamed from: f */
    private boolean f29963f = true;

    /* renamed from: i */
    private Handler f29966i = new Handler(Looper.getMainLooper());

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class JumpLoaderResult implements NoProGuard, Serializable {
        public static final int CODE_DOWNLOAD = 3;
        public static final int CODE_LINK = 2;
        public static final int CODE_MARKET = 1;
        public static final int CODE_NULL = 4;
        private static final long serialVersionUID = 1;
        private int code;
        private String content;
        private String exceptionMsg;
        private String header;
        private boolean is302Jump;
        private boolean jumpDone;
        private String msg;
        private String noticeurl;
        private int statusCode;
        private boolean success;
        private int type;
        private String url;

        public int getCode() {
            return this.code;
        }

        public String getContent() {
            return this.content;
        }

        public String getExceptionMsg() {
            return this.exceptionMsg;
        }

        public String getHeader() {
            return this.header;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getNoticeurl() {
            return this.noticeurl;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public int getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isIs302Jump() {
            return this.is302Jump;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public boolean isjumpDone() {
            return this.jumpDone;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setExceptionMsg(String str) {
            this.exceptionMsg = str;
        }

        public void setHeader(String str) {
            this.header = str;
        }

        public void setIs302Jump(boolean z) {
            this.is302Jump = z;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setNoticeurl(String str) {
            this.noticeurl = str;
        }

        public void setStatusCode(int i) {
            this.statusCode = i;
        }

        public void setSuccess(boolean z) {
            this.success = z;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setjumpDone(boolean z) {
            this.jumpDone = z;
        }
    }

    public CommonJumpLoader(Context context, boolean z) {
        if (z) {
            this.f29964g = new CommonTaskLoader(context, 2);
        } else {
            this.f29964g = new CommonTaskLoader(context);
        }
        this.f29965h = new WebViewSpiderLoader(context, z);
    }

    /* renamed from: a */
    public final void m23171a(String str, String str2, CampaignEx campaignEx, CommonLoaderListener commonLoaderListener) {
        m23170a(str, str2, campaignEx, commonLoaderListener, null);
    }

    /* renamed from: a */
    public final void m23169a(String str, String str2, CampaignEx campaignEx, CommonLoaderListener commonLoaderListener, String str3, boolean z, boolean z2, int i) {
        String str4;
        boolean z3;
        this.f29960c = str3;
        this.f29962e = commonLoaderListener;
        this.f29958a = null;
        this.f29961d = i;
        boolean z4 = false;
        if (campaignEx != null) {
            z4 = ("5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) ? true : true;
            str4 = campaignEx.getId();
            z3 = z4;
        } else {
            str4 = "";
            z3 = false;
        }
        this.f29965h.m23024a(str3, commonLoaderListener, z3, str, str4, str2, null, campaignEx, z, z2, i);
    }

    /* renamed from: a */
    public final void m23170a(String str, String str2, CampaignEx campaignEx, CommonLoaderListener commonLoaderListener, RoverListener roverListener) {
        this.f29960c = new String(campaignEx.getClickURL());
        this.f29962e = commonLoaderListener;
        this.f29958a = null;
        this.f29965h.m23024a(campaignEx.getClickURL(), commonLoaderListener, "5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), str, campaignEx.getId(), str2, roverListener, campaignEx, true, false, RetryReportControl.f29983j);
    }

    @Override // com.mbridge.msdk.click.CommonLoader
    /* renamed from: a */
    public final void mo23030a() {
        this.f29963f = false;
    }
}
