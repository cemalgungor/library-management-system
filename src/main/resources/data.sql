insert into books_detail(detail_id,about_author,comments,page_number,summary) values (1,'test','testcomments',257,'testsummary');
insert into books_detail(detail_id,about_author,comments,page_number,summary) values (2,'test2','testcomments2',250,'testsummary2');
insert into books (id,book_name,author,price,detail_id,publish_date) values (1,'Karamazov Kardesler','Dostoyevski',20,1,parsedatetime('17-09-2012', 'dd-MM-yyyy'));
insert into books (id,book_name,author,price,detail_id,publish_date) values (2,'Ölü Canlar','Gogol',17,2,parsedatetime('17-09-2011', 'dd-MM-yyyy'));
