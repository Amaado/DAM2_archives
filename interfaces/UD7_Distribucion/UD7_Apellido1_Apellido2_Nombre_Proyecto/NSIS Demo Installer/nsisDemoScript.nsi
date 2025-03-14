;[Save document as UTF-8 with BOM]

;Incluir UI moderno
!include "MUI2.nsh"


;[Installer Atributtes]

Name "Instalador de demostración creado con NSIS"
OutFile "NsisDemoInstaller.exe"
Unicode True
InstallDir "$PROGRAMFILES\Test"
RequestExecutionLevel user
!define MUI_ABORTWARNING


;[Pages]

!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES


;Idioma / Descripcion
!insertmacro MUI_LANGUAGE "Spanish"


;[Sections]

Section "NsisDemo.jar" SecDummy
SetOutPath "$INSTDIR"
File NsisDemo.jar
SectionEnd

;Descripciones que aparecerán junto al componente cuando se seleccione. Aparece junto al componente
LangString DESC_SecDummy ${LANG_SPANISH} "Instalación del fichero NsisDemo.jar"
!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
!insertmacro MUI_DESCRIPTION_TEXT ${SecDummy} $(DESC_SecDummy)
!insertmacro MUI_FUNCTION_DESCRIPTION_END


