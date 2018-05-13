# How To Doxygen

## Voraussetzung:
Doxygen ist installiert (und Path-Variable ist gesetzt, falls nicht den bin/ Ordner in die Path Variable setzen).  
[http://www.stack.nl/~dimitri/doxygen/download.html](http://www.stack.nl/~dimitri/doxygen/download.html "get it here!")

## Anleitung:

1. Erzeuge Konfigurationsdatei für Doxygen:
    $> doxygen -g
Ausführen im *root*-Verzeichnis des Projekts.
Es wird die Datei "Doxyfile" erzeugt (Parameter für anderen Namen kann angegeben werden).
2. Anpassen der Konfigurationsdatei:
Relevante Einstellungen (große Datei - mit strg-f arbeiten):  
    * JAVADOC_AUTOBRIEF
    * **OPTIMIZE_OUTPUT_JAVA**
    * EXTRACT_ALL
	* EXTRACT_PRIVATE
	* EXTRACT_PACKAGE
	* EXTRACT_STATIC
	* EXTRACT_LOCAL_CLASSES
	* EXTRACT_LOCAL_METHODS
	* **INPUT** (hier wird der Pfad zu den Source-Dateien angegeben)
    * GENERATE_HTML
	* HTML_OUTPUT (Ausgabeordner der html-Doku)
	* **GENERATE_LATEX**
	* LATEX_OUTPUT (Ausgabeordner der Latex-Doku)
	* COMPACT_LATEX
	* LATEX_SOURCE_CODE
3. Dokumentation erzeugen mit:
    $> doxygen Doxyfile
*Doxyfile* ist der Name der Konfigurationsdatei.
4. PDF erzeugen:  
In den Latex-Output-Ordner wechseln und
    $> make
ausführen.
