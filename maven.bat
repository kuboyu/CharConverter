IF "%PRODUCT_HOME%" == "" (
  set PRODUCT_HOME=C:\product
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

set PATH=%PATH%;%MAVEN_BIN%

mvn dependency:copy-dependencies -DoutputDirectory=lib