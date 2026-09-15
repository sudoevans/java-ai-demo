module demo {
    requires org.slf4j;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;

    opens demo to spring.core, spring.beans, spring.context;
}
