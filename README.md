# Liquibase Implementation

One of the main problems of having different development environments and multiple developers are releases. Releases tend to be confusing and a time consuming task, and sometimes, if not done correctly, it could lead to a disaster on a production env. Teams should be really careful while releasing everything needed for their systems and, one of the most common mistakes on releases is to forget running a script or making a database change.

1. Create a new project of Spring Boot
2. Create a directory under `resources`: db/changelog/
3. Add a file `db.changelog-master.xml` inside of `sources/db/changelog`
4. Create folder with name `name` inside of `resources/db/changelog`
5. Add dependencies in build.gradle
    ```
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath 'de.undercouch:gradle-download-task:3.1.2'
        classpath 'org.liquibase:liquibase-core:3.4.1'
        classpath "org.liquibase:liquibase-gradle-plugin:1.1.1"
        classpath 'mysql:mysql-connector-java:5.1.13'
    }
    ```
6. Add plugin of liquibase
    ```
    apply plugin: "liquibase"
    ```
7. Create task of gradle
    ```
    task('dev') << {
        println "executing dev"
        liquibase {
            activities {
                main {
                    changeLogFile changeLog
                    url 'jdbc:mysql://localhost:3306/demo'
                    username 'root'
                    password ''
                }
            }
        }
    }
    ```
8. Add new file `application.properties` inside of resources/application.properties
9. Add these lines
    ```
    spring.liquibase.enabled=true
    spring.liquibase.change-log=classpath:/db/changelog/changelog-master.xml
    ```
10. Paste this code in the changelog-master.xml
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <databaseChangeLog
            xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                          http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">
    </databaseChangeLog>
    ```
11. Create our first change
12. Create a folder inside src/main/resources/db/changelog/
13. Create a new file 05312020.sample.sql
14. Copy and paste the following code:
    ```sql
    create table test1
    (
        id int auto_increment,
        name varchar(255) not null,
        constraint test1_pk
            primary key (id)
    );
    ```
15. Execute the task

