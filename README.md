# Java on Script  [![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT) ![Maven Central](https://img.shields.io/maven-central/v/com.adtsw/jos?color=blue&label=Version) ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/com.adtsw/jos?label=Snapshot&server=https%3A%2F%2Foss.sonatype.org%2F)


***Simple scripting library for Java programs***

---

### Features

* [x] Simple scripting syntax with support for nested blocks, for loops, if conditions
* [x] Support for adding custom function implementations

### Maven configuration

JoS is available on [Maven Central](http://search.maven.org/#search). You just have to add the following dependency in your `pom.xml` file.

```xml
<dependency>
  <groupId>com.adtsw</groupId>
  <artifactId>jos</artifactId>
  <version>1.0.2</version>
</dependency>
```

For ***snapshots***, add the following repository to your `pom.xml` file.
```xml
<repository>
    <id>sonatype snapshots</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
</repository>
```
The ***snapshot version*** has not been released yet.
```xml
<dependency>
  <groupId>com.adtsw</groupId>
  <artifactId>jos</artifactId>
  <version>TBD</version>
</dependency>
```

Sample Script
```
    // init variables
    test_variable = 14;
    test_variable_expression = test_variable * 2;
    test_diff = 0.0;
    
    // conditions
    if(test_variable != 0) {
        
        test_diff = ((test_variable * 1.0) / (test_variable_expression * 1.0)) * 100.0;
        
        // logging
        log("test diff");
        log(test_diff);

        // nested conditions
        if(test_diff == 50.0) {
            log("value matches. updating original value");
            test_diff = test_diff + 50.0;
        }
    }

    // for loops
    for_loop_value = 0;
    
    for(i=0, i<test_variable_expression, i=i+1) {
        if(i % 2 == 0) {
            for_loop_value = for_loop_value + 1;
        }
    }
```