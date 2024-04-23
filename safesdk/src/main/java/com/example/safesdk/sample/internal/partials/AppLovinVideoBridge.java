package com.example.safesdk.sample.internal.partials;

import android.net.Uri;
import android.widget.VideoView;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* compiled from: AppLovinSourceFile */
public class AppLovinVideoBridge {
    public static void VideoViewPlay(VideoView vv) {
        Logger.m3600d("AppLovinVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AppLovinVideoBridge;->VideoViewPlay(Landroid/widget/VideoView;)V");
        try {
            Logger.m3601d("VideoBridge", "VideoViewPlay: player " + vv);
            CreativeInfoManager.m3072a(C1357d.f3593a, (Object) vv);
        } catch (Exception e) {
            Logger.m3601d("VideoBridge", "exception in VideoViewPlay: " + e.getMessage());
        }
        vv.start();
    }

    public static void VideoViewStop(VideoView vv) {
        Logger.m3600d("AppLovinVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AppLovinVideoBridge;->VideoViewStop(Landroid/widget/VideoView;)V");
        try {
            Logger.m3601d("VideoBridge", "VideoViewStop: player " + vv);
            CreativeInfoManager.onVideoCompleted(C1357d.f3593a, (Object) null);
        } catch (Exception e) {
            Logger.m3601d("VideoBridge", "exception in VideoViewStop : " + e.getMessage());
        }
        vv.stopPlayback();
    }

    public static void VideoViewSetVideoUri(VideoView vv, Uri uri) {
        Logger.m3600d("AppLovinVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AppLovinVideoBridge;->VideoViewSetVideoUri(Landroid/widget/VideoView;Landroid/net/Uri;)V");
        try {
            Logger.m3601d("VideoBridge", "VideoViewSetVideoUri: player " + vv + ", uri: " + uri);
            CreativeInfoManager.m3073a(C1357d.f3593a, (Object) vv, (Object) uri);
        } catch (Exception e) {
            Logger.m3601d("VideoBridge", "exception in VideoViewSetVideoPath: " + e.getMessage());
        }
        vv.setVideoURI(uri);
    }

    public static String stringInit(byte[] bytes, String charSet) throws UnsupportedEncodingException {
        Logger.m3600d("AppLovinVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AppLovinVideoBridge;->stringInit([BLjava/lang/String;)Ljava/lang/String;");
        String str = new String(bytes, charSet);
        try {
            C1361h.m3694b("VideoBridge", "stringInit message=" + str);
            if (str.contains("\"ads\"")) {
                CreativeInfoManager.m3078a(C1357d.f3593a, CreativeInfoManager.f2704d, str, (Map<String, List<String>>) null);
            }
        } catch (Throwable th) {
        }
        return str;
    }
}
