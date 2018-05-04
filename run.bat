@echo off
set INPUT_FILE_ENDING=in
set OUTPUT_FILE_ENDING=out
set PATH_TO_DATA=

if %1.==. (
	echo ""
) else (
	set PATH_TO_DATA=%1\
)

for %%i in (%PATH_TO_DATA%*.%INPUT_FILE_ENDING%) do (
	java -jar Wartezeiten.jar %PATH_TO_DATA%%%~nxi %PATH_TO_DATA%%%~ni.%OUTPUT_FILE_ENDING%
)
