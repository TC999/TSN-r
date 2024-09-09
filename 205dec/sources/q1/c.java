package q1;

import android.content.ComponentName;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.y;
import com.orhanobut.logger.j;
import com.tsn.chat.model.ChatModel;

/* compiled from: SerialSub.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends s1.a {
    @Override // s1.a, q1.b
    public void a(ChatModel chatModel) {
        j.c("\u63a5\u6536\u5230\u7fa4\u804a\u4fe1\u606f:" + chatModel.toString());
        LocalBroadcastManager.getInstance(s1.a.f64370a).sendBroadcast(new Intent("NOTIFY_RECEIVER_MESSAGE").putExtra("chatType", 2).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("groupId", chatModel.getGroupId()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // s1.a, q1.b
    public void b() {
        j.c("\u5ba2\u6237\u7aef\u79bb\u7ebf\u56de\u8c03");
    }

    @Override // s1.a, q1.b
    public void d() {
        LocalBroadcastManager.getInstance(s1.a.f64370a).sendBroadcast(new Intent("NOTIFY_HEART_CALLBACK_SUCCESS"));
        e();
        LoginUser.getLoginUser().setLogin(false);
        LoginUser.getLoginUser().setToken("");
        LoginUser.getLoginUser().setUserId("");
        cn.bluemobi.dylan.base.utils.a.n().j();
        if (LoginUser.getLoginUser().getUserType() == 1) {
            s1.a.f64370a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.student", "com.bxkj.student.MainActivity")).setFlags(335544320));
            s1.a.f64370a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.student", "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
        } else {
            s1.a.f64370a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(335544320));
        }
        if (y.a(s1.a.f64370a, AlarmChatService.class.getName())) {
            j.c("AlarmChatService----------isServiceRunning");
            s1.a.f64370a.stopService(new Intent(s1.a.f64370a, AlarmChatService.class));
        }
    }

    @Override // s1.a, q1.b
    public void f(ChatModel chatModel) {
        j.c("\u63a5\u6536\u5230\u804a\u5929\u4fe1\u606f:" + chatModel.toString());
        LocalBroadcastManager.getInstance(s1.a.f64370a).sendBroadcast(new Intent("NOTIFY_RECEIVER_MESSAGE").putExtra("chatType", 1).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // s1.a, q1.b
    public void j(String str) {
        cn.bluemobi.dylan.sqlitelibrary.c.h().delete(ChatMessageDb.class, "messageId=?", new String[]{str});
        j.c("\u6d88\u606f\u53d1\u9001\u56de\u8c03" + str);
        Intent intent = new Intent("NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS");
        intent.putExtra("messageId", str);
        LocalBroadcastManager.getInstance(s1.a.f64370a).sendBroadcast(intent);
        super.j(str);
    }

    @Override // s1.a, q1.b
    public void k() {
        j.c("\u5fc3\u8df3\u54cd\u5e94" + s1.a.f64370a);
        LocalBroadcastManager.getInstance(s1.a.f64370a).sendBroadcast(new Intent("NOTIFY_HEART_CALLBACK_SUCCESS"));
    }
}
