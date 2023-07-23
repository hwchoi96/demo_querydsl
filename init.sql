create database db_demo;

create table db_demo.tb_user (
    id      bigint            auto_increment      primary key ,
    name    varchar(30)     not null ,
    address varchar(200)    null ,
    email   varchar(40)     not null    unique
);

create table db_demo.tb_product (
    id          bigint          auto_increment      primary key ,
    name        varchar(50)     not null ,
    price       int             not null ,
    category    varchar(30)     not null
);

create table db_demo.tb_order (
    order_id    bigint      auto_increment  primary key,
    user_id     bigint      not null ,
    product_id  bigint      not null ,

    constraint fk_tb_user_tb_order foreign key (user_id) references db_demo.tb_user(id),
    constraint fk_tb_product_tb_order foreign key (product_id) references db_demo.tb_product(id)
);

insert into db_demo.tb_user(id, name, address, email) values (100, '데모!', '주소1', 'email');

insert into db_demo.tb_product(name, price, category) VALUES ('책1', 30000, '도서');
insert into db_demo.tb_product(name, price, category) VALUES ('책2', 15000, '도서');
insert into db_demo.tb_product(name, price, category) VALUES ('책3', 28000, '도서');
insert into db_demo.tb_product(name, price, category) VALUES ('책4', 12500, '도서');
insert into db_demo.tb_product(name, price, category) VALUES ('사과', 2500, '과일');
insert into db_demo.tb_product(name, price, category) VALUES ('배', 2200, '과일');
insert into db_demo.tb_product(name, price, category) VALUES ('귤', 1500, '과일');
insert into db_demo.tb_product(name, price, category) VALUES ('수박', 13500, '과일');
insert into db_demo.tb_product(name, price, category) VALUES ('노트북', 1000500, '전자기기');
insert into db_demo.tb_product(name, price, category) VALUES ('컴퓨터', 1842000, '전자기기');
insert into db_demo.tb_product(name, price, category) VALUES ('에어팟', 200000, '전자기기');
insert into db_demo.tb_product(name, price, category) VALUES ('버즈', 150000, '전자기기');
insert into db_demo.tb_product(name, price, category) VALUES ('물', 800, '음료');
insert into db_demo.tb_product(name, price, category) VALUES ('음료수', 1200, '음료');
insert into db_demo.tb_product(name, price, category) VALUES ('썬크림', 10000, '화장품');
insert into db_demo.tb_product(name, price, category) VALUES ('바디로션', 15000, '화장품');
insert into db_demo.tb_product(name, price, category) VALUES ('폼클렌징', 11000, '화장품');
insert into db_demo.tb_product(name, price, category) VALUES ('슬리퍼', 5000, '신발');
insert into db_demo.tb_product(name, price, category) VALUES ('운동화', 150000, '신발');
insert into db_demo.tb_product(name, price, category) VALUES ('구두', 230000, '신발');
insert into db_demo.tb_product(name, price, category) VALUES ('힐', 150000, '신발');

insert into db_demo.tb_order(user_id, product_id) VALUES (100, 1);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 2);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 3);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 4);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 5);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 6);
insert into db_demo.tb_order(user_id, product_id) VALUES (100, 7);