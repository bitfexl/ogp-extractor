package com.github.bitfexl.ogpextractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class OGPExtractor {
    public OGPResult extract(String url) {
        try {
            return doExtract(url);
        } catch (IOException ex) {
            throw new RuntimeException("Error extracting Open Graph tags from '" + url + "'.", ex);
        }
    }

    private OGPResult doExtract(String url) throws IOException {
        final OGPResult result = new OGPResult();
        final Document doc = Jsoup.connect(url).get();
        final Element title = doc.selectFirst("title");

        if (title != null) {
            result.setHtmlTitle(title.text());
        }

        final Elements metaTags = doc.select("meta");
        for (Element metaTag : metaTags) {
            for (OGPResult.Tag possibleTag : OGPResult.Tag.values()) {
                if (result.hasTag(possibleTag)) {
                    continue;
                }

                if (metaTag.attr(possibleTag.keyAttribute).equalsIgnoreCase(possibleTag.keyValue)) {
                    result.setTag(possibleTag, metaTag.attr(possibleTag.valueAttribute).trim());
                }
            }
        }

        return result;
    }
}
