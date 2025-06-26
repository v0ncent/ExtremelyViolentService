package io.github.v0ncent.extremelyviolentservice;

public final class Constants {
    public static final class SequenceNames {
        public static final String GALLERY_SEQ = "gallery_seq";
        public static final String COMICS_SEQ = "comics_seq";
        public static final String NEWS_SEQ = "news_seq";
        public static final String ADMIN_SEQ = "admin_seq";
    }

    public static final class Excerpts {
        public static final String GALLERY_EXCERPT = "Gallery Post";
        public static final String COMICS_EXCERPT = "Comics";
        public static final String NEWS_EXCERPT = "News";
    }

    public static final class Tags {
        public static final String GALLERY_TAG = "- gallery";
        public static final String COMICS_TAG = "- comic";
        public static final String NEWS_TAG = "- news";
    }

    public static final class RepositoryPackages {
        public static final String CONTENT_REPOSITORIES_PACKAGE = "io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories";
    }

    public static final class MongoTemplateReferences {
        public static final String CONTENT_MONGO_TEMPLATE_REFERENCE = "contentMongoTemplate";
        public static final String ADMIN_MONGO_TEMPLATE_REFERENCE = "adminMongoTemplate";
        public static final String SEQUENCE_MONGO_TEMPLATE_REFERENCE = "sequenceMongoTemplate";
    }

    public static final class EnvironmentVariables {
        public static final String MONGODB_CONTENT_DATABASE = "MONGODB_CONTENT_DATABASE";
        public static final String MONGODB_ADMIN_DATABASE = "MONGODB_ADMIN_DATABASE";
        public static final String MONGODB_SEQUENCE_DATABASE = "MONGODB_SEQUENCE_DATABASE";
        public static final String MONGO_URI = "MONGO_URI";
    }

    public static final class PropertyNames {
        public static final String SPRING_APPLICATION_NAME = "spring.application.name";
        public static final String SPRING_DATA_MONGODB_URI = "spring.data.mongodb.uri";
        public static final String SPRING_DATA_MONGODB_DATABASE = "spring.data.mongodb.database";
        public static final String LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_DATA_MONGODB = "logging.level.org.springframework.data.mongodb";
        public static final String LOGGING_LEVEL_COM_MONGODB = "logging.level.com.mongodb";
    }

    public static final class PropertyValues {
        public static final String SPRING_APPLICATION_NAME = "ExtremelyViolentService";
        public static final String SPRING_DATA_MONGODB_URI = Config.get("MONGO_URI");
        public static final String SPRING_DATA_MONGODB_DATABASE = Config.get("MONGODB_CONTENT_DATABASE");
        public static final String LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_DATA_MONGODB = "DEBUG";
        public static final String LOGGING_LEVEL_COM_MONGODB = "DEBUG";
    }
}
