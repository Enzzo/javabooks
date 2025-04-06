# Ассоциации в предметной области
В этом примере иллюстрируется отношение "many-to-many" <br>

``` java
public class User{
	Set billingDetails;
}

public class BillingDetails{
	Set user;
}
```

Для этого потребуется создать <i>таблицу ссылок</i> (link table)

``` sql
create table USER_BILLINGDETAILS(
	USER_ID bigint,
	BILLINGDETAILS_ID bigint,
	primary key (USER_ID, BILLINGDETAILS_ID),
	foreign key (USER_ID) references USERS,
	foreign key (BILLINGDETAILS_ID) references BILLIINGDETAILS
);
```
А в таблице `billingdetails` следует удалить `foreign key`:<br>

``` sql
CREATE TABLE BILLINGDETAILS(
	ID BIGINT NOT NULL PRIMARY KEY,
	ACCOUNT VARCHAR(15) NOT NULL,
	BANKNAME VARCHAR(255) NOT NULL,
	USER_ID BIGINT NOT NULL
);
```