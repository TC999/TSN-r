package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class CommonJumpLoader extends d {

    /* renamed from: d  reason: collision with root package name */
    private int f38788d;

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f38791g;

    /* renamed from: h  reason: collision with root package name */
    private h f38792h;

    /* renamed from: b  reason: collision with root package name */
    private int f38786b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f38787c = null;

    /* renamed from: a  reason: collision with root package name */
    JumpLoaderResult f38785a = null;

    /* renamed from: e  reason: collision with root package name */
    private e f38789e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38790f = true;

    /* renamed from: i  reason: collision with root package name */
    private Handler f38793i = new Handler(Looper.getMainLooper());

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
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

        public void setCode(int i4) {
            this.code = i4;
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

        public void setIs302Jump(boolean z3) {
            this.is302Jump = z3;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setNoticeurl(String str) {
            this.noticeurl = str;
        }

        public void setStatusCode(int i4) {
            this.statusCode = i4;
        }

        public void setSuccess(boolean z3) {
            this.success = z3;
        }

        public void setType(int i4) {
            this.type = i4;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setjumpDone(boolean z3) {
            this.jumpDone = z3;
        }
    }

    public CommonJumpLoader(Context context, boolean z3) {
        if (z3) {
            this.f38791g = new com.mbridge.msdk.foundation.same.e.b(context, 2);
        } else {
            this.f38791g = new com.mbridge.msdk.foundation.same.e.b(context);
        }
        this.f38792h = new h(context, z3);
    }

    public final void a(String str, String str2, CampaignEx campaignEx, e eVar) {
        a(str, str2, campaignEx, eVar, null);
    }

    public final void a(String str, String str2, CampaignEx campaignEx, e eVar, String str3, boolean z3, boolean z4, int i4) {
        String str4;
        boolean z5;
        this.f38787c = str3;
        this.f38789e = eVar;
        this.f38785a = null;
        this.f38788d = i4;
        boolean z6 = false;
        if (campaignEx != null) {
            z6 = ("5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) ? true : true;
            str4 = campaignEx.getId();
            z5 = z6;
        } else {
            str4 = "";
            z5 = false;
        }
        this.f38792h.a(str3, eVar, z5, str, str4, str2, null, campaignEx, z3, z4, i4);
    }

    public final void a(String str, String str2, CampaignEx campaignEx, e eVar, com.mbridge.msdk.rover.d dVar) {
        this.f38787c = new String(campaignEx.getClickURL());
        this.f38789e = eVar;
        this.f38785a = null;
        this.f38792h.a(campaignEx.getClickURL(), eVar, "5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), str, campaignEx.getId(), str2, dVar, campaignEx, true, false, com.mbridge.msdk.click.a.a.f38810j);
    }

    @Override // com.mbridge.msdk.click.d
    public final void a() {
        this.f38790f = false;
    }
}
