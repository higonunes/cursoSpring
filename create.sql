
    create table categoria (
       id  serial not null,
        nome varchar(255),
        primary key (id)
    )

    create table cidade (
       id  serial not null,
        nome varchar(255),
        estado_id int4,
        primary key (id)
    )

    create table cliente (
       id  serial not null,
        cpf_ou_cnpj varchar(255),
        email varchar(255),
        nome varchar(255),
        tipo int4,
        primary key (id)
    )

    create table endereco (
       id  serial not null,
        bairro varchar(255),
        cep varchar(255),
        complemento varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        cidade_id int4,
        cliente_id int4,
        primary key (id)
    )

    create table estado (
       id  serial not null,
        nome varchar(255),
        primary key (id)
    )

    create table item_pedido (
       desconto float8,
        preco float8,
        quantidade int4,
        pedido_id int4 not null,
        produto_id int4 not null,
        primary key (pedido_id, produto_id)
    )

    create table pagamento (
       pedido_id int4 not null,
        estado int4,
        primary key (pedido_id)
    )

    create table pagamento_com_boleto (
       data_pagamento timestamp,
        data_vencimento timestamp,
        pedido_id int4 not null,
        primary key (pedido_id)
    )

    create table pagamento_com_cartao (
       numero_de_parcelas int4,
        pedido_id int4 not null,
        primary key (pedido_id)
    )

    create table pedido (
       id  serial not null,
        instante timestamp,
        cliente_id int4,
        endereco_entrega_id int4,
        primary key (id)
    )

    create table produto (
       id  serial not null,
        nome varchar(255),
        preco float8,
        primary key (id)
    )

    create table produto_cat (
       produto_id int4 not null,
        categoria_id int4 not null
    )

    create table telefone (
       cliente_id int4 not null,
        telefones varchar(255)
    )

    alter table cidade 
       add constraint FKkworrwk40xj58kevvh3evi500 
       foreign key (estado_id) 
       references estado

    alter table endereco 
       add constraint FK8b1kcb3wucapb8dejshyn5fsx 
       foreign key (cidade_id) 
       references cidade

    alter table endereco 
       add constraint FK8s7ivtl4foyhrfam9xqom73n9 
       foreign key (cliente_id) 
       references cliente

    alter table item_pedido 
       add constraint FK60ym08cfoysa17wrn1swyiuda 
       foreign key (pedido_id) 
       references pedido

    alter table item_pedido 
       add constraint FKtk55mn6d6bvl5h0no5uagi3sf 
       foreign key (produto_id) 
       references produto

    alter table pagamento 
       add constraint FKthad9tkw4188hb3qo1lm5ueb0 
       foreign key (pedido_id) 
       references pedido

    alter table pagamento_com_boleto 
       add constraint FKcr74vrxf8nfph0knq2bho8doo 
       foreign key (pedido_id) 
       references pagamento

    alter table pagamento_com_cartao 
       add constraint FKta3cdnuuxclwfh52t4qi432ow 
       foreign key (pedido_id) 
       references pagamento

    alter table pedido 
       add constraint FK30s8j2ktpay6of18lbyqn3632 
       foreign key (cliente_id) 
       references cliente

    alter table pedido 
       add constraint FKcrxxe5rpllxbh0sfi4a6rwphb 
       foreign key (endereco_entrega_id) 
       references endereco

    alter table produto_cat 
       add constraint FKfhcic05hqi9xmgk2vaax7d92a 
       foreign key (categoria_id) 
       references categoria

    alter table produto_cat 
       add constraint FK5nn89qhqane447vnehokohggc 
       foreign key (produto_id) 
       references produto

    alter table telefone 
       add constraint FK8aafha0njkoyoe3kvrwsy3g8u 
       foreign key (cliente_id) 
       references cliente
