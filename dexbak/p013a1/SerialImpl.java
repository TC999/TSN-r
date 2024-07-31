package p013a1;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.RequestMessage;
import com.tsn.chat.utils.DateHelp;
import com.tsn.chat.utils.Global;
import com.tsn.chat.utils.NettySendMessageUtil;
import com.tsn.chat.utils.SocketUtil;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import p660y0.BaseApplication;
import p660y0.Serial;

/* renamed from: a1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SerialImpl implements Serial {

    /* renamed from: a */
    public static Context f51a;

    /* renamed from: p */
    public static void m60047p() {
        ChatModel chatModel = new ChatModel();
        chatModel.setCreateTime(DateHelp.m14863c());
        chatModel.setFromUserId("47932");
        chatModel.setFromUserName("郭清枝");
        chatModel.setToUserId("47932,39850,39858,40125,40209,40223,40232,40236,42127,41446,45897,44998,47297,47712,47719,47723,40231,40240,40341,40351,40356,40805,42034,42070,42114,42318,40559,47370,47415,43931,44735,44747,45315,46760,46764,47304,47305,47314,46769,46853,47022,47089");
        chatModel.setToUserName("wangmazi");
        chatModel.setSchoolId("wgydx");
        chatModel.setMsg(CommonNetImpl.f39530AS);
        chatModel.setGroupId("638");
        chatModel.setMessageId("c5ef9a84-c3fc-4ca2-88f3-bb1affcc88e0");
        chatModel.setPhoto("");
        BaseApplication.m38a().mo29o(chatModel);
    }

    @Override // p660y0.Serial
    /* renamed from: a */
    public void mo28a(ChatModel chatModel) {
    }

    @Override // p660y0.Serial
    /* renamed from: b */
    public void mo27b() {
    }

    @Override // p660y0.Serial
    /* renamed from: c */
    public void mo37c() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", Global.f37509e);
        hashMap.put("userId", Global.f37508d);
        hashMap.put(CampaignEx.JSON_KEY_HB, "chat");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (Global.f37505a.size() > 0) {
            NettySendMessageUtil.m14858a(requestMessage);
        }
    }

    @Override // p660y0.Serial
    /* renamed from: d */
    public void mo26d() {
    }

    @Override // p660y0.Serial
    /* renamed from: e */
    public void mo36e() {
        Global.f37508d = "";
        Global.f37509e = "";
        Global.f37505a.close();
    }

    @Override // p660y0.Serial
    /* renamed from: f */
    public void mo25f(ChatModel chatModel) {
    }

    @Override // p660y0.Serial
    /* renamed from: g */
    public int mo35g(String str, String str2, String str3, String str4) {
        mo36e();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new SocketUtil(str3, Integer.parseInt(str4), countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Global.f37505a.size() == 0) {
            return 2;
        }
        Global.f37508d = str;
        Global.f37509e = str2;
        BaseApplication.m38a().mo30n(str, str2);
        return 1;
    }

    @Override // p660y0.Serial
    /* renamed from: h */
    public void mo34h() {
    }

    @Override // p660y0.Serial
    /* renamed from: i */
    public void mo33i() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", Global.f37509e);
        hashMap.put("userId", Global.f37508d);
        hashMap.put(CampaignEx.JSON_KEY_HB, "back");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (Global.f37505a.size() > 0) {
            NettySendMessageUtil.m14858a(requestMessage);
        }
    }

    @Override // p660y0.Serial
    /* renamed from: j */
    public void mo24j(String str) {
    }

    @Override // p660y0.Serial
    /* renamed from: k */
    public void mo23k() {
    }

    @Override // p660y0.Serial
    /* renamed from: l */
    public void mo32l(Context context) {
        f51a = context;
    }

    @Override // p660y0.Serial
    /* renamed from: m */
    public void mo31m(ChatModel chatModel) {
        chatModel.setType("2");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (Global.f37505a.size() > 0) {
            NettySendMessageUtil.m14858a(requestMessage);
        }
    }

    @Override // p660y0.Serial
    /* renamed from: n */
    public void mo30n(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", str);
        hashMap.put("schoolId", str2);
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 1, jSONString);
        if (Global.f37505a.size() > 0) {
            NettySendMessageUtil.m14858a(requestMessage);
        }
    }

    @Override // p660y0.Serial
    /* renamed from: o */
    public void mo29o(ChatModel chatModel) {
        chatModel.setType("1");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (Global.f37505a.size() > 0) {
            NettySendMessageUtil.m14858a(requestMessage);
        }
    }
}
