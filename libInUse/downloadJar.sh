#!/bin/bash

# get jar and its dependencies
curl -L -O http://search.maven.org/remotecontent?filepath=org/apache/ivy/ivy/2.3.0/ivy-2.3.0.jar
java -jar ivy-2.3.0.jar -dependency com.thoughtworks.xstream xstream 1.4.8 -retrieve "lib/[artifact]-[revision](-[classifier]).[ext]"


