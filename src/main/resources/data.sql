INSERT INTO categories(name) VALUES('食費');
INSERT INTO categories(name) VALUES('家賃');
INSERT INTO categories(name) VALUES('交通費');
INSERT INTO categories(name) VALUES('雑費');
INSERT INTO categories(name) VALUES('交際費');
INSERT INTO categories(name) VALUES('ガソリン代');

INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-04','1','昼食','カレー','1000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-07','2','家賃','6月の家賃','70000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-01','5','遊び','友達と飲み','3000');

INSERT INTO accounts(name,password) VALUES('越川詩織','shiori0123');

INSERT INTO incom(user_id,date,title,detail,price)VALUES('1','2025-07-04','給与','6月の給与','210000');