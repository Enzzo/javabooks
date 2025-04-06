INSERT INTO USERS(ID, USERNAME, ADDRESS_STREET, ADDRESS_ZIPCODE, ADDRESS_CITY)
VALUES(1, 'user1', 'Street 1', '12345', 'City A'), 
	(2, 'user2', 'Street 2',  '67890', 'City B'), 
	(3, 'user3', 'Street 3', '54321', 'City C');

INSERT INTO BILLINGDETAILS(ID, ACCOUNT, BANKNAME, USER_ID)
VALUES(1, 'account1', 'Bank A', 1),
	(2, 'account2', 'Bank B', 2),
	(3, 'account3', 'Bank C', 3),
	(4, 'account2', 'Bank B', 1),
	(5, 'account2', 'Bank B', 1),
	(6, 'account2', 'Bank B', 2);

INSERT INTO USER_BILLINGDETAILS (USER_ID, BILLINGDETAILS_ID)
VALUES(1, 1),
		(2, 2),
		(3, 3),
		(1, 4),
		(1, 5),
		(2, 6);