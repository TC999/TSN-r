package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ShareAction {

    /* renamed from: b  reason: collision with root package name */
    private SHARE_MEDIA f53837b;

    /* renamed from: c  reason: collision with root package name */
    private UMShareListener f53838c;

    /* renamed from: d  reason: collision with root package name */
    private ShareBoardlistener f53839d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f53840e;

    /* renamed from: f  reason: collision with root package name */
    private List<SHARE_MEDIA> f53841f;

    /* renamed from: k  reason: collision with root package name */
    private View f53846k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f53847l;

    /* renamed from: m  reason: collision with root package name */
    private ShareBoard f53848m;

    /* renamed from: a  reason: collision with root package name */
    private ShareContent f53836a = new ShareContent();

    /* renamed from: g  reason: collision with root package name */
    private final List<SnsPlatform> f53842g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private List<ShareContent> f53843h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private List<UMShareListener> f53844i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f53845j = 80;

    /* renamed from: n  reason: collision with root package name */
    private ShareBoardlistener f53849n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private ShareBoardlistener f53850o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareContent shareContent;
            int indexOf = ShareAction.this.f53841f.indexOf(share_media);
            int size = ShareAction.this.f53843h.size();
            if (size != 0) {
                if (indexOf < size) {
                    shareContent = (ShareContent) ShareAction.this.f53843h.get(indexOf);
                } else {
                    shareContent = (ShareContent) ShareAction.this.f53843h.get(size - 1);
                }
                ShareAction.this.f53836a = shareContent;
            }
            int size2 = ShareAction.this.f53844i.size();
            if (size2 != 0) {
                if (indexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f53838c = (UMShareListener) shareAction.f53844i.get(indexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f53838c = (UMShareListener) shareAction2.f53844i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f53840e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i4 = iArr[0];
            rect.left = i4;
            rect.top = iArr[1];
            rect.right = i4 + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e4) {
            SLog.error(e4);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f53842g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f53847l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f53848m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f53848m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f53837b;
    }

    public ShareContent getShareContent() {
        return this.f53836a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f53836a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f53836a.mMedia.toUrl().startsWith("http");
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f53840e)) {
            return;
        }
        if (this.f53842g.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("listener", this.f53838c);
            hashMap.put("content", this.f53836a);
            try {
                ShareBoard shareBoard = new ShareBoard(this.f53840e, this.f53842g, shareBoardConfig);
                this.f53848m = shareBoard;
                ShareBoardlistener shareBoardlistener = this.f53839d;
                if (shareBoardlistener == null) {
                    shareBoard.setShareBoardlistener(this.f53850o);
                } else {
                    shareBoard.setShareBoardlistener(shareBoardlistener);
                }
                this.f53848m.setFocusable(true);
                this.f53848m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f53846k == null) {
                    this.f53846k = this.f53840e.getWindow().getDecorView();
                }
                this.f53848m.showAtLocation(this.f53846k, this.f53845j, 0, 0);
                return;
            } catch (Exception e4) {
                SLog.error(e4);
                return;
            }
        }
        this.f53842g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f53842g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f53842g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f53842g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f53842g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("listener", this.f53838c);
        hashMap2.put("content", this.f53836a);
        ShareBoard shareBoard2 = new ShareBoard(this.f53840e, this.f53842g, shareBoardConfig);
        this.f53848m = shareBoard2;
        ShareBoardlistener shareBoardlistener2 = this.f53839d;
        if (shareBoardlistener2 == null) {
            shareBoard2.setShareBoardlistener(this.f53849n);
        } else {
            shareBoard2.setShareBoardlistener(shareBoardlistener2);
        }
        this.f53848m.setFocusable(true);
        this.f53848m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f53846k == null) {
            this.f53846k = this.f53840e.getWindow().getDecorView();
        }
        this.f53848m.showAtLocation(this.f53846k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f53838c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr != null && Arrays.asList(shareContentArr).size() != 0) {
            this.f53843h = Arrays.asList(shareContentArr);
        } else {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f53843h.add(shareContent);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f53841f = Arrays.asList(share_mediaArr);
        this.f53842g.clear();
        for (SHARE_MEDIA share_media : this.f53841f) {
            this.f53842g.add(share_media.toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f53844i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f53837b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f53836a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f53839d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f53840e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f53847l;
            }
            uMShareAPI.doShare(this.f53840e, this, this.f53838c);
        }
    }

    public ShareAction withApp(File file) {
        this.f53836a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f53836a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f53836a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f53836a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f53836a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f53836a.mMedia = uMImageArr[0];
        }
        this.f53836a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i4) {
        this.f53845j = i4;
        this.f53846k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f53836a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f53836a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f53836a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f53836a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f53836a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f53836a.mMedia = uMVideoArr[0];
        }
        this.f53836a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f53836a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f53836a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f53836a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
