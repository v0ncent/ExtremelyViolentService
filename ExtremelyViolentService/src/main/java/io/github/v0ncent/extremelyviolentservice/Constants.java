package io.github.v0ncent.extremelyviolentservice;

public final class Constants {
    public static final class SequenceNames {
        public static final String GALLERY_SEQ = "gallery_seq";
    }

    public static final class Excerpts {
        public static final String GALLERY_EXCERPT = "Gallery Post";
    }

    public static final class Tags {
        public static final String GALLERY_TAG = "- gallery";
    }

    public static final class Properties {
        public static final String APPLICATION_NAME = "ExtremelyViolentService";
        public static final String MONGO_URI = Config.get("MONGO_URI");
        public static final String MONGO_DATABASE = Config.get("MONGODB_DATABASE");

        public static final String APPLICATION_NAME_PROP = "spring.application.name";
        public static final String MONGO_URI_PROP = "spring.data.mongodb.uri";
        public static final String MONGO_DATABASE_PROP = "spring.data.mongodb.database";
    }
}
