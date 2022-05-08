# 目的
数十TBの日次連携がMuleSoftで実現できるかの検討のため、データ転送のスループットを測定する。

# 検証方法

# 測定結果
https://docs.google.com/spreadsheets/d/1EQYcKGkEYL2XpAGBdF5k2Vdr0_Jfi4jeVCfvhlj3TFM/edit?usp=sharing


# 参考情報
## GClog

wrapper.java.additional.20=-XX:+PrintGCApplicationStoppedTime
wrapper.java.additional.21=-XX:+PrintGCDetails
wrapper.java.additional.22=-XX:+PrintGCDateStamps
wrapper.java.additional.23=-XX:+PrintTenuringDistribution
wrapper.java.additional.24=-Xloggc:%MULE_HOME%/logs/gc.log

wrapper.java.additional.25=-Duser.language=en
wrapper.java.additional.26=-Duser.country=US
