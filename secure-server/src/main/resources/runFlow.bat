rem THIS COMMAND TO REGENERATE SERVER CERTIFICATE AND PUT IT INTO SERVER KEYSTORE

rem keytool -genkeypair -alias secure-amazon-server -keyalg RSA -dname "CN=localhost,OU=CoreValue AWS Server,O=CoreValue Services LLC,L=Lviv,S=Ukraine,C=UA" -keypass secret -keystore server-keystore.jks -storepass secret -ext san=IP:54.191.93.15

rem NOTE: Manually update application.yml file to use new server alias if you change it

rem EXPORT SERVER CERTIFICATE 

rem keytool -exportcert -alias secure-amazon-server -file secure-amazon-server-public.cer -keystore server-keystore.jks -storepass secret

rem IMPORT EXPORTED SERVER CERTIFICATE INTO CLIENT TRUSTSTORE

keytool -importcert -keystore ../../../../secure-client/src/main/resources/client-truststore.jks -alias secure-amazon-server-public -file secure-amazon-server-public.cer -storepass secret