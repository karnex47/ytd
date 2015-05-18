package strd.karnex.com.stream_downloader.extractor.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import strd.karnex.com.stream_downloader.extractor.InfoExtractor;

/**
 * Created by Diptarka on 5/14/2015.
 */
public class YoutubeExtractor extends InfoExtractor{
    private final Pattern VALID_URL = Pattern.compile("((https?://)?(www\\.)?)?((youtube\\.com/watch\\?v=)|(youtu\\.be/))([0-9A-Za-z_-]{11})$");

    @Override
    public boolean suitable(String url) {
        return VALID_URL.matcher(url).matches();
    }
}
