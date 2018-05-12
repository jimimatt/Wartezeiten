#!/bin/bash
# check if jar file is present
JAR=Wartezeiten.jar
if [ ! -f $JAR ]
  then
    echo "$JAR not found!"
    exit 1
fi
DIR="$1"
 
# failsafe - fall back to current directory
[ "$DIR" == "" ] && DIR="." || DIR="./$DIR"
 
# save and change IFS
OLDIFS=$IFS
IFS=$'\n'
 
# read all file name into an array
fileArray=($(ls $DIR | grep -i ".in$"))
 
# restore it
IFS=$OLDIFS
 
# get length of an array
tLen=${#fileArray[@]}
 
# use for loop read all filenames
for (( i=0; i<${tLen}; i++ ));
do
#  echo "${fileArray[$i]}"
#  echo "${fileArray[$i]%.*}.out"
  java -jar $JAR "$DIR/${fileArray[$i]}" "$DIR/${fileArray[$i]%.*}.out"
done
