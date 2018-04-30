# Попытка установить docker на win 7 x32

## ----

### 1.1 Устанавливаем Chocolatey
Cmd as admin  
`@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"`  

### 1.2 Проверяем Chocolatey  
Закрываем, открываем cmd as admin, пишем choco - скажет версию и подсказку  

### 1.3 Качаем ставим VirtualBox  

### 1.4 PowerShell as admin  
`choco install docker-machine -y`  
