# chapter 2.2
## Настройка проекта:
### 1. Зависимости (pom.xml):
Для работы потребуются: JPA, Hibernate, H2, Simple-JNDI<br>

``` xml
<dependency>
	<groupId>org.codehaus.btm</groupId>
	<artifactId>btm</artifactId>
	<version>2.1.4</version>
</dependency>
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<version>2.3.232</version>
</dependency>
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-entitymanager</artifactId>
	<version>5.6.15.Final</version>
</dependency>
<dependency>
	<groupId>simple-jndi</groupId>
	<artifactId>simple-jndi</artifactId>
	<version>0.11.4.1</version>
</dependency>
```

### 2. persistence.xml:
Этот файл находится в папке `src/main/resources/META-INF` и содержит определение единицы хранения с именем `HelloWorldPU`. Файл указывает:

- Использование JTA‑datasource с именем myDS.
- Класс-сущность (ru.vasilev.hibernate.model.Message), который будет храниться в базе.
- Свойство javax.persistence.schema-generation.database.action со значением drop-and-create – при запуске схема базы данных будет удаляться и создаваться заново.
- Свойства для форматирования и комментирования SQL.

```xml
<!-- src/main/resources/META-INF/persistence.xml -->
<persistence
    version="2.1"
    xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                        http://xmlns.jcp.org/xml/ns/persistence_2_1.xsd">
    
    <persistence-unit name="HelloWorldPU">
        <!-- Определение JTA data source, имя должно совпадать с тем, что будет привязано через JNDI -->
        <jta-data-source>myDS</jta-data-source>
        <!-- Класс-сущность, которую сохраняем в базе -->
        <class>ru.vasilev.hibernate.model.Message</class>
        <!-- Запрещаем автоматический поиск классов, не указанных явно -->
        <exclude-unlisted-classes>true</exclude-unlisted-classes>
        <properties>
            <!-- Указание на автоматическое удаление и создание схемы БД -->
            <property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
            <!-- Форматирование SQL для вывода в консоль -->
            <property name="hibernate.format_sql" value="true" />
            <property name="hibernate.use_sql_comments" value="true" />
            <!-- Можно дополнительно указать свойства подключения для Hibernate, но в нашем случае DataSource настраивается через JNDI -->
        </properties>
    </persistence-unit>
</persistence>

```
### 3. jndi.properties:
Файл jndi.properties размещается в src/main/resources и используется библиотекой Simple‑JNDI для инициализации JNDI‑контекста. Здесь мы указываем корневую папку для ресурсов JNDI, а также, что контекст общий.

```
# src/main/resources/jndi.properties
java.naming.factory.initial=org.osjava.sj.SimpleContextFactory
org.osjava.sj.root=./src/main/resources/jndi
org.osjava.sj.jndi.shared=true
```

- java.naming.factory.initial – указывает класс фабрики, который будет создавать JNDI контекст (Simple‑JNDI).

- org.osjava.sj.root – корневая папка, где будут храниться JNDI‑ресурсы (можно оставить пустой, если ресурсы задаются программно).

- org.osjava.sj.jndi.shared – настройка для совместного использования контекста.