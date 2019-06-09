IF "%PRODUCT_HOME%" == "" (
  set PRODUCT_HOME=C:\product
)
IF "%JAVA_HOME%" == "" (
  set JAVA_HOME=%PRODUCT_HOME%\java\jdk1.8.0_212
)
IF "%APACHE_HOME%" == "" (
  set APACHE_HOME=%PRODUCT_HOME%\apache
)
IF "%MAVEN_HOME%" == "" (
  set MAVEN_HOME=%APACHE_HOME%\apache-maven-3.6.1
)
IF "%MAVEN_BIN%" == "" (
  set MAVEN_BIN=%MAVEN_HOME%\bin
)

set PATH=%PATH%;%MAVEN_BIN%;%JAVA_HOME%\bin

rem mvn dependency:copy-dependencies -DoutputDirectory=lib

mvn install