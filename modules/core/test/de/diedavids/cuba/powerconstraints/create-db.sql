-- begin DDCPC_CUSTOMER
create table DDCPC_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRIORITY integer,
    FIRST_NAME varchar(255),
    DOCUMENT_NUMBER varchar(50) not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end DDCPC_CUSTOMER
-- begin DDCPC_ORDER
create table DDCPC_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(255) not null,
    ORDER_DATE date not null,
    SHIPPING_DATE date,
    SHIPPING_MODE integer,
    CUSTOMER_ID varchar(36) not null,
    PRODUCT_ID varchar(36) not null,
    PRICE decimal(19, 2),
    QUANTITY double precision,
    TOTAL_PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end DDCPC_ORDER
-- begin DDCPC_MLB_PLAYER
create table DDCPC_MLB_PLAYER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TEAM_ID varchar(36),
    HEIGHT integer,
    WEIGHT integer,
    AGE double precision,
    BIRTHDAY date,
    BIRTHDAY_LOCAL_DATE date,
    LEFT_HANDED boolean,
    ANNUAL_SALARY decimal(19, 2),
    ANNUAL_SALARY_LONG bigint,
    --
    primary key (ID)
)^
-- end DDCPC_MLB_PLAYER
-- begin DDCPC_MLB_TEAM
create table DDCPC_MLB_TEAM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    STATE varchar(50),
    CODE varchar(255) not null,
    TELEPHONE integer,
    --
    primary key (ID)
)^
-- end DDCPC_MLB_TEAM
-- begin DDCPC_PRODUCT
create table DDCPC_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(255) not null,
    NAME varchar(255) not null,
    CATEGORY_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCPC_PRODUCT
-- begin DDCPC_PRODUCT_CATEGORY
create table DDCPC_PRODUCT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    PARENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCPC_PRODUCT_CATEGORY
-- begin DDCPC_BASEBALL_STRENGTH
create table DDCPC_BASEBALL_STRENGTH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    SCORE integer not null,
    --
    primary key (ID)
)^
-- end DDCPC_BASEBALL_STRENGTH
-- begin DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK
create table DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK (
    BASEBALL_STRENGTH_ID varchar(36) not null,
    MLB_PLAYER_ID varchar(36) not null,
    primary key (BASEBALL_STRENGTH_ID, MLB_PLAYER_ID)
)^
-- end DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK



-- begin DDCPC_ORDER
alter table DDCPC_ORDER add constraint FK_DDCPC_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references DDCPC_CUSTOMER(ID)^
alter table DDCPC_ORDER add constraint FK_DDCPC_ORDER_ON_PRODUCT foreign key (PRODUCT_ID) references DDCPC_PRODUCT(ID)^
create index IDX_DDCPC_ORDER_ON_CUSTOMER on DDCPC_ORDER (CUSTOMER_ID)^
create index IDX_DDCPC_ORDER_ON_PRODUCT on DDCPC_ORDER (PRODUCT_ID)^
-- end DDCPC_ORDER
-- begin DDCPC_MLB_PLAYER
alter table DDCPC_MLB_PLAYER add constraint FK_DDCPC_MLB_PLAYER_ON_TEAM foreign key (TEAM_ID) references DDCPC_MLB_TEAM(ID)^
create index IDX_DDCPC_MLB_PLAYER_ON_TEAM on DDCPC_MLB_PLAYER (TEAM_ID)^
-- end DDCPC_MLB_PLAYER
-- begin DDCPC_MLB_TEAM
create unique index IDX_DDCPC_MLB_TEAM_UNQ on DDCPC_MLB_TEAM (CODE, DELETE_TS) ^
-- end DDCPC_MLB_TEAM
-- begin DDCPC_PRODUCT
alter table DDCPC_PRODUCT add constraint FK_DDCPC_PRODUCT_ON_CATEGORY foreign key (CATEGORY_ID) references DDCPC_PRODUCT_CATEGORY(ID)^
create unique index IDX_DDCPC_PRODUCT_UNIQ_PRODUCT_ID on DDCPC_PRODUCT (PRODUCT_ID) ^
create index IDX_DDCPC_PRODUCT_ON_CATEGORY on DDCPC_PRODUCT (CATEGORY_ID)^
-- end DDCPC_PRODUCT
-- begin DDCPC_PRODUCT_CATEGORY
alter table DDCPC_PRODUCT_CATEGORY add constraint FK_DDCPC_PRODUCT_CATEGORY_ON_PARENT foreign key (PARENT_ID) references DDCPC_PRODUCT_CATEGORY(ID)^
create index IDX_DDCPC_PRODUCT_CATEGORY_ON_PARENT on DDCPC_PRODUCT_CATEGORY (PARENT_ID)^
-- end DDCPC_PRODUCT_CATEGORY
-- begin DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK
alter table DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK add constraint FK_MLBPLABASSTR_ON_BASEBALL_STRENGTH foreign key (BASEBALL_STRENGTH_ID) references DDCPC_BASEBALL_STRENGTH(ID)^
alter table DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK add constraint FK_MLBPLABASSTR_ON_MLB_PLAYER foreign key (MLB_PLAYER_ID) references DDCPC_MLB_PLAYER(ID)^
-- end DDCPC_MLB_PLAYER_BASEBALL_STRENGTH_LINK
