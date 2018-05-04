INPUT_FILE_ENDING="in"
OUTPUT_FILE_ENDING="out"
PATH_TO_DATA=""

if [ $1 ]
  then
    PATH_TO_DATA=$1/
fi

for f in $PATH_TO_DATA*.$INPUT_FILE_ENDING
do
  java -jar Wartezeiten.jar $f ${f%.*}.$OUTPUT_FILE_ENDING
done

