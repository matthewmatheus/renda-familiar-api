create table receitas(

                        id bigInt not null auto_increment,
                        descricao varchar(200) not null,
                        valor varchar(100) not null unique,
                        data date not null unique,

                        primary key(id)

);