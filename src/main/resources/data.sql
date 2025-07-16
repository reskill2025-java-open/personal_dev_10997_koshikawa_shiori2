INSERT INTO categories(name) VALUES('食費');
INSERT INTO categories(name) VALUES('家賃');
INSERT INTO categories(name) VALUES('交通費');
INSERT INTO categories(name) VALUES('雑費');
INSERT INTO categories(name) VALUES('交際費');
INSERT INTO categories(name) VALUES('ガソリン代');

INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-04','1','昼食','カレー','1000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-07','2','家賃','6月の家賃','60000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-01','5','遊び','友達と飲み','3000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-08','1','買い出し','自炊用食材','3500');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-14','3','定期券','バス電車定期','70000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-15','5','ライブ','音楽のライブ','8000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-17','5','ランチ','同期とランチ','1500');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-18','5','飲み会','友達と飲み','4000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-15','1','買い出し','自炊用食材','4000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-12','5','お出かけ','カフェと服','13000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-06','5','飲み','友達と飲み','4000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-09','1','昼食','外食','1200');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-11','4','光熱費','水道、電気','10000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-11','4','光熱費','水道、電気','10000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('1','2025-07-18','2','家賃','今月の家賃','70000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-07-03','4','日用品','薬局で買い物','3000');
INSERT INTO kakeibo(user_id,date,category_id,title,detail,price)values('2','2025-06-29','5','ライブ','音楽のライブ','5000');
INSERT INTO accounts(name,password) VALUES('越川詩織','shiori0123');

INSERT INTO incom(user_id,date,title,detail,price)VALUES('1','2025-07-04','給与','6月の給与','210000');
INSERT INTO incom(user_id,date,title,detail,price)VALUES('2','2025-07-14','給与','7月の給与','180000');