@echooff
java -jar selenium-server-standalone-3.141.59.jar -role hub -port 5555
java -Dwebdriver-chrome.driver="D:\GroupFramework_08-May-2022\GroupABHIAutomation\drivers\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://10.0.109.140:5555/grid/register/