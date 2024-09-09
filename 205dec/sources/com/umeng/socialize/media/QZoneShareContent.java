package com.umeng.socialize.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import java.io.File;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QZoneShareContent extends SimpleShareContent {
    private boolean isPublish;
    public int mShareType;
    private UMediaObject uMedia;

    public QZoneShareContent(ShareContent shareContent) {
        super(shareContent);
        this.isPublish = false;
        this.mShareType = 1;
        this.uMedia = shareContent.mMedia;
    }

    private void buildAudioParams(Bundle bundle) {
        UMImage thumbImage = getBaseMediaObject().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        bundle.putString("targetUrl", getBaseMediaObject().toUrl());
        if (getMusic() != null) {
            bundle.putString("targetUrl", getMusic().getmTargetUrl());
        }
        bundle.putString("title", objectSetTitle(getBaseMediaObject()));
        bundle.putString("summary", objectSetDescription(getBaseMediaObject()));
        bundle.putString("audio_url", getBaseMediaObject().toUrl());
    }

    private void buildImageParams(Bundle bundle) {
        if (getImage() == null || getImage().asFileImage() == null) {
            return;
        }
        bundle.putString("imageUrl", getImage().asFileImage().toString());
    }

    private void buildWebParams(Bundle bundle) {
        UMImage thumbImage = getUmWeb().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        bundle.putString("targetUrl", getUmWeb().toUrl());
        bundle.putString("title", objectSetTitle(getUmWeb()));
        bundle.putString("summary", objectSetDescription(getUmWeb()));
    }

    public Bundle buildParamsQzone() {
        Bundle bundle = new Bundle();
        this.isPublish = false;
        int i4 = 3;
        if (getmStyle() != 2 && getmStyle() != 3) {
            if (getmStyle() == 4) {
                this.mShareType = 2;
                buildAudioParams(bundle);
            } else if (getmStyle() == 16) {
                buildWebParams(bundle);
            } else if (getmStyle() == 8) {
                buildAudioParams(bundle);
            } else {
                this.isPublish = true;
                bundle.putString("summary", getText());
            }
            i4 = 1;
        } else {
            this.mShareType = 5;
            buildImageParams(bundle);
            this.isPublish = true;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (getmImages() != null && getmImages().length > 0) {
            for (UMImage uMImage : getmImages()) {
                File asFileImage = uMImage.asFileImage();
                if (asFileImage != null) {
                    arrayList.add(asFileImage.toString());
                }
            }
            bundle.remove("imageLocalUrl");
            bundle.putStringArrayList("imageUrl", arrayList);
        } else {
            String string = bundle.getString("imageUrl");
            bundle.remove("imageUrl");
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            String string2 = bundle.getString("imageLocalUrl");
            bundle.remove("imageLocalUrl");
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(string2);
            }
            bundle.putStringArrayList("imageLocalUrl", arrayList);
        }
        bundle.putInt("req_type", i4);
        return bundle;
    }

    public UMediaObject getMedia() {
        return this.uMedia;
    }

    public boolean getisPublish() {
        return this.isPublish;
    }
}
