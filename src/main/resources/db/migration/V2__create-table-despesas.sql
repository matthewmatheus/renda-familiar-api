create table despesas(

                        id bigInt not null auto_increment,
                        descricao varchar(200) not null,
                        valor varchar(100) not null unique,
                        data varchar(15) not null unique,

                        primary key(id)

);