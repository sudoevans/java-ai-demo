FROM container-registry.oracle.com/java/jdk:25.0.4.1 AS builder

WORKDIR /opt/app

ARG JAVA_MODULES=java.base,java.compiler,java.desktop,java.instrument,java.management,java.naming,java.sql,java.security.jgss

# binutils are needed by the `--strip-debug` command line option.
RUN dnf install -y binutils && dnf clean all
RUN jlink \
      --output './jre' \
      --no-header-files \
      --no-man-pages \
      --strip-debug \
      --add-modules "${JAVA_MODULES}" \
      --compress=zip-9

FROM container-registry.oracle.com/os/oraclelinux:10-slim

WORKDIR /opt/app

COPY --from=builder /opt/app/jre /opt/jre
COPY ./target/jlink-multi-architecture-spring-boot-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["/opt/jre/bin/java", "-jar", "app.jar"]
