-- begin DDCPC_POWER_CONSTRAINT
create table DDCPC_POWER_CONSTRAINT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    TYPE_ varchar(50) not null,
    NAME varchar(255),
    DESCRIPTION longvarchar,
    ACTIVE boolean not null,
    CONSTRAINT_ID varchar(36),
    --
    -- from ddcpc_UserPowerConstraint
    USER_ID varchar(36),
    --
    -- from ddcpc_RolePowerConstraint
    ROLE_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCPC_POWER_CONSTRAINT
