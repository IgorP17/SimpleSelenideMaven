# Попытка установить docker на win 7 x32

## 1. Docker Client

### 1.1 Устанавливаем Chocolatey
Cmd as admin,  
`@powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))" && SET PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin`  
PowerShell  
`iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))`  

### 1.2 Проверяем Chocolatey  
Закрываем, открываем cmd as admin, пишем choco - скажет версию и подсказку  

### 1.3 Качаем ставим VirtualBox  
