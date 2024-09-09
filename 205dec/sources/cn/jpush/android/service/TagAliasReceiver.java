package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class TagAliasReceiver extends BroadcastReceiver {
    public static final String ACTION_TAG_ALIAS_CALLBACK = "cn.jpush.android.intent.TAG_ALIAS_CALLBACK";
    public static final String ACTION_TAG_ALIAS_TIMEOUT = "cn.jpush.android.intent.TAG_ALIAS_TIMEOUT";
    public static final String KEY_TAGALIASOPERATOR_CALLBACKCODE = "tagalias_errorcode";
    public static final String KEY_TAGALIASOPERATOR_SEQID = "tagalias_seqid";
    private static final String TAG = "TagAliasReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            Logger.ww(TAG, "TagAliasOperator onReceive intent is null");
            return;
        }
        long longExtra = intent.getLongExtra(KEY_TAGALIASOPERATOR_SEQID, -1L);
        int intExtra = intent.getIntExtra(KEY_TAGALIASOPERATOR_CALLBACKCODE, 0);
        if (longExtra == -1) {
            Logger.w(TAG, "TagAliasOperator onReceive rid is invalide");
        } else {
            ActionHelper.getInstance().onTagAliasResponse(context, longExtra, intExtra, intent);
        }
    }
}
