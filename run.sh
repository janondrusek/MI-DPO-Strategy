#!/bin/bash
WHICH="`which which`"
JAVA="`${WHICH} java`"

JAR="target/strategy*.jar"
PATH="target/classes/graf8.out"
STRATEGY="dfs"

if [[ -n $1 ]]
then
	STRATEGY="${1}"
fi

if [[ -n $2 ]]
then
	JAR="${2}" 
fi 

if [[ -n $3 ]]
then
	PATH="${3}"
fi

if [[ -z ${JAVA} ]]
then
	echo -n "!!! JVM not found !!!" 
else
	echo -n "Running using: ${JAVA} path"  
	eval "${JAVA} -version" 
	eval "${JAVA} -jar ${JAR} ${PATH} ${STRATEGY}"
fi
