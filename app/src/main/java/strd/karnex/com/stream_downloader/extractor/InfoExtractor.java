package strd.karnex.com.stream_downloader.extractor;

/**
 * Created by Diptarka on 5/14/2015.
 */
public abstract  class InfoExtractor {
    public boolean suitable(String url) {
        return false;
    }
}
