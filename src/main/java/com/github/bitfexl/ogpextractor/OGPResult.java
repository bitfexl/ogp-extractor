package com.github.bitfexl.ogpextractor;

import java.util.HashMap;
import java.util.Map;

public class OGPResult {
    /**
     * Common meta tags. See: <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta/name">Standard metadata names</a> and <a href="https://ogp.me/">Open Graph protocol</a>
     */
    public enum Tag {
        HTML_DESCRIPTION("name", "description", "content"),
        HTML_KEYWORDS("name", "keywords", "content"),
        HTML_AUTHOR("name", "author", "content"),
        HTML_APPLICATION_NAME("name", "application-name", "content"),
        HTML_GENERATOR("name", "generator", "content"),
        HTML_THEME_COLOR("name", "theme-color", "content"),
        HTML_COLOR_SCHEME("name", "color-scheme", "content"),
        OG_TITLE("og:title"),
        OG_TYPE("og:type"),
        OG_IMAGE("og:image"),
        OG_URL("og:url"),
        OG_AUDIO("og:audio"),
        OG_DESCRIPTION("og:description"),
        OG_DETERMINER("og:determiner"),
        OG_LOCALE("og:locale"),
        OG_LOCALE_ALTERNATE("og:locale:alternate"),
        OG_SITE_NAME("og:site_name"),
        OG_VIDEO("og:video");

        public final String keyAttribute;

        public final String keyValue;

        public final String valueAttribute;

        Tag(String keyValue) {
            this("property", keyValue, "content");
        }

        Tag(String keyAttribute, String keyValue, String valueAttribute) {
            this.keyAttribute = keyAttribute;
            this.keyValue = keyValue;
            this.valueAttribute = valueAttribute;
        }
    }

    private String htmlTitle;

    private final Map<Tag, String> tags = new HashMap<>();

    public void setTag(Tag tag, String value) {
        tags.put(tag, value);
    }

    public String getTag(Tag tag) {
        return tags.get(tag);
    }

    public boolean hasTag(Tag tag) {
        return tags.containsKey(tag);
    }

    public String getHtmlTitle() {
        return htmlTitle;
    }

    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }
}
