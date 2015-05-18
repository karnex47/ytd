package strd.karnex.com.stream_downloader.extractor;

import strd.karnex.com.stream_downloader.extractor.internal.YoutubeExtractor;

/**
 * Created by Diptarka on 5/14/2015.
 */
public class ExtractorFactory {
    public InfoExtractor createExtractorFor(String url) {
        return (InfoExtractor) new YoutubeExtractor();
    }
}
