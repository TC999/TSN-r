package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Intent;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMMoreHandler extends UMSSOHandler {
    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return "7.3.2";
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(ShareContent shareContent, UMShareListener uMShareListener) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (shareContent.mMedia instanceof UMImage) {
            intent.setType("image/*");
            File asFileImage = ((UMImage) shareContent.mMedia).asFileImage();
            if (asFileImage != null) {
                intent.putExtra("android.intent.extra.STREAM", SocializeUtils.insertImage(getContext(), asFileImage.getPath()));
            }
        } else {
            intent.setType("text/plain");
        }
        intent.putExtra("android.intent.extra.SUBJECT", shareContent.subject);
        intent.putExtra("android.intent.extra.TEXT", shareContent.mText);
        Intent createChooser = Intent.createChooser(intent, Config.MORE_TITLE);
        createChooser.addFlags(268435456);
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                currentActivity.startActivity(createChooser);
                uMShareListener.onResult(SHARE_MEDIA.MORE);
            } else {
                uMShareListener.onError(SHARE_MEDIA.MORE, new Exception("activity null!"));
            }
            return true;
        } catch (Exception e) {
            SLog.error(UmengText.INTER.MOREERROR, e);
            uMShareListener.onError(SHARE_MEDIA.MORE, e);
            return true;
        }
    }
}
