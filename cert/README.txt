#Para sacar los SHA usar keytool -list -v -keystore "key store path" -alias "key alias"
#Keystore para compilaciones debug

keystore: debug.keystore

storePassword: marveldebug
keyAlias: marveldebug
keyPassword: marveldebug

SHA1: E4:84:86:A2:68:CB:91:55:E4:6B:B1:05:E9:77:F7:0F:11:C7:6B:F1
SHA256: F7:5B:7F:8A:63:4F:B9:0B:96:2A:E1:73:E2:D1:D5:FD:03:EE:70:78:2C:B3:1E:5F:99:CD:DB:B1:C9:FC:D4:3C


#Keystore para compilaciones release (store)

keystore: release.keystore

storePassword: marvel
keyAlias: marvel
keyPassword: marvel

SHA1: 32:39:3B:36:AE:01:76:4F:08:94:B3:58:FF:51:60:15:6E:D9:09:77
SHA256: 3C:62:DE:60:0E:BE:BC:E6:41:62:09:15:B8:1E:C6:B9:07:60:FF:AF:14:DE:28:F8:00:A8:67:19:43:DD:55:66