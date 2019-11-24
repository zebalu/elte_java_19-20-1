created with command: `gradle init --type=java-application`

# Eszközök:

* jUnit 4: https://junit.org/junit4/
* jUnit 5: https://junit.org/junit5/
* spock: http://spockframework.org/spock/docs/1.3/index.html
* testNG: https://testng.org/doc/

## jUnit 4, manuális megoldás:

Le kell tölteni az alábbi jar-okat:
* https://repo1.maven.org/maven2/junit/junit/4.12/junit-4.12.jar
* https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

fordítás (ha a `junit-4.12.jar` és a `hamcrest-core-1.3.jar` fileok a fordítási gyökérben vannak): 
Windows-on: `javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar <path\to\TestClass.java>` | 
Unix-okon: `javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar <path/to/TestClass.java>`

futtatás: windows-on: `java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <path.to.TestClass>` | 
unix-okon: `java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <path.to.TestClass>`

## futtatás gradle-el

`gradlew build`

# Gradle

A Gradle egy build automatizáló rendszer: https://docs.gradle.org/current/userguide/userguide.html 

## saját gradle project generálása a minta project file-jaival:

1. készíts egy üres mappát
2. másold bele a `gradle` könyvtárat, valamint a `gradlew` és/vagy `gradlew.bat` file-okat.
3. futtasd a  `gradlew init --type=java-application` (Java alkalmazáshoz) vagy a `gradlew init --type=java-library` (java library-hez) parancsot

### Mi micsoda?

a létrejövő gradle specifikus file-ok közül:

* `build.gradle` a buildscript (a build során végrehajtandó feladatok listája)
* `settings.gradle` a build előtt futtatandó extra lépések

### Mi merre van?

* az alkalmazás forrás file-jai az `src/main/java/` könyvtárban találhatóak
* az alkalmazás tesztjei az `src/test/java/` könyvtárban helyezkednek el
* a kész alkalmazás a `build/distributions` mappába kerül
* a kész library a `build/libs` mappába kerül
* a tesztreport a `build/reports/tests/test` mappába kerül

# További példa

egy mappával feljebb: https://github.com/zebalu/elte_java_19-20-1/tree/master/09/lista-pelda
