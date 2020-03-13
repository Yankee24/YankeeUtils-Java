### YankeeUtils

---
一些常用的 Scala 工具类

---
#### 配置文件相关工具类
- PropertiesUtil：读取配置文件，并获取指定 key 的 value 值

---
#### Redis相关工具类
- JedisPoolUtil：获取 JedisCluster 集群连接
- JedisUtil：获取 Jedis 连接

---
#### 日期相关工具类
- LocalDateTimeFormatUtil：可以将 LocalDateTime、LocalDate 和 LocalTime 类型的日期转换为指定格式的字符串，也可以自己传入相应的参数指定相应的格式；同时可以将 String 类型的日期转换为 LocalDateTime、LocalDate
，也可以自己传入相应的 String 格式
 和 LocalTime
- DateFormatUtil：可以将 Date 类型的日期转换为指定格式的字符串，也可以自己传入相应的参数指定相应的格式；同时可以将 String 类型的日期转换为 Date，也可以自己传入相应的 String 格式
- LocalDateTimeUtil：计算两个日期之间相差的月份、天数、秒数和毫秒数，传入的参数可以是 LocalDateTime，也可以是 String 类型，如果是 String 类型必须带上格式化的参数