@REM #########################################################   
@REM  Name: �ݹ鸴���ļ�����Ѵ��ļ�������ϣ��ִ�е��Ǹ�Ŀ¼  

@REM  Desciption:   

@REM  Author: amosryan  

@REM  Date: 2015-06-08  

@REM  Version: 1.0  

@REM  Copyright: Jimmy.  

@REM #########################################################  

  

@echo off  

setlocal enabledelayedexpansion  

  

@REM �����������Ƶ��ļ�:Դ�ļ���Ŀ���ļ�  

set WHAT_SRC_FILENAME=Root_OK 
set WHAT_SHOULD_BE_COPYED=Root  

  

for /r . %%a in (!WHAT_SHOULD_BE_COPYED!) do (  

  if exist %%a (  

  echo "����"%%a   

  copy /y .\%WHAT_SRC_FILENAME%  "%%a"  

 )  

)  

  
pause
