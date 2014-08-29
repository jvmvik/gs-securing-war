gs-securing-war
===============

Secure WAR file with Spring Security + LDAP
 with Spring Boot 1.1.5

This example shows how to create a secure war file using a real LDAP server.
 and, also provides a workaround a bug in the RELEASE 1.1.5.

Solved problems:
 - LDAP setup contextSource.afterPropertiesSet() (http://stackoverflow.com/questions/23344787/spring-ldap-security-without-xml)
 - LDAP dependencies
 - URL redirection to /, and not a random file.
 - Run spring-boot-starter-security 1.1.6.BUILD-SNAPSHOT

Project derived from gs-securing-web
 and add WEB and LDAP support.
---
http://spring.io/guides/gs/securing-web/

This was tested with Tomcat 8.0.8, Gradle 1.11, Spring Boot 1.1.5.

Victor
Austin, TX
August 29, 2014
