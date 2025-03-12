# Запуск:
- собрать пакет `mvn clean package`
- собрать образы `docker-compose up`
- запускаем оболочку CQL `docker run -it --network cassandra-net --rm cassandra cqlsh cassandra`
- Если эта команда потерпит неудачу с сообщением "Unable to connect to any servers", следует подождать пару минут и попробовать снова
- Когда оболочка будет готова