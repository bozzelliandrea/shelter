package org.shelter.core.http;

public interface MediaType {

    String ALL = "*/*";

    String APPLICATION_ATOM_XML = "application/atom+xml";

    String APPLICATION_CBOR = "application/cbor";

    String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

    String APPLICATION_GRAPHQL = "application/graphql+json";

    String APPLICATION_JSON = "application/json";

    @Deprecated
    String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

    String APPLICATION_OCTET_STREAM = "application/octet-stream";

    String APPLICATION_PDF = "application/pdf";

    String APPLICATION_PROBLEM_JSON = "application/problem+json";

    @Deprecated
    String APPLICATION_PROBLEM_JSON_UTF8 = "application/problem+json;charset=UTF-8";

    String APPLICATION_PROBLEM_XML = "application/problem+xml";

    String APPLICATION_PROTOBUF = "application/x-protobuf";

    String APPLICATION_RSS_XML = "application/rss+xml";

    String APPLICATION_NDJSON = "application/x-ndjson";

    @Deprecated
    String APPLICATION_STREAM_JSON = "application/stream+json";

    String APPLICATION_XHTML_XML = "application/xhtml+xml";

    String APPLICATION_XML = "application/xml";

    String IMAGE_GIF = "image/gif";

    String IMAGE_JPEG = "image/jpeg";

    String IMAGE_PNG = "image/png";

    String MULTIPART_FORM_DATA = "multipart/form-data";

    String MULTIPART_MIXED = "multipart/mixed";

    String MULTIPART_RELATED = "multipart/related";

    String TEXT_EVENT_STREAM = "text/event-stream";

    String TEXT_HTML = "text/html";

    String TEXT_MARKDOWN = "text/markdown";

    String TEXT_PLAIN = "text/plain";

    String TEXT_XML = "text/xml";
}
