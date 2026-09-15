module demo.db {
    exports demo.db;

    requires transitive demo.domain;
    requires com.fasterxml.jackson.databind;
}
