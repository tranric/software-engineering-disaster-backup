drop database vrs;
create database vrs;

use vrs;

create table Owners(
	FirstName varchar(20) not null,
	MiddleInitial varchar(1),
	LastName varchar(10) not null,
	DateOfBirth date not null,
	Gender varchar(6),
	Email varchar(200) not null,
	Phone varchar(10) not null,
	DriversLicID varchar(10) not null,
	primary key (DriversLicID)
);

create table Login(
	    Userid varchar(10) not null,
	    Pass varchar(60) not null,
	    Role varchar(10) not null,
	    primary key (Userid)
);


create table AddressBook(
	AddressID varchar(10) not null,
	    StreetNumber int not null,
		StreetName varchar(50) not null,
	    PostalCode varchar(6) not null,
	    City varchar(10) not null,
	    Province varchar(10) not null,
	    Unit varchar(8),
	    primary key (AddressID)
);

create table OwnerAddress(
    DriversLicID varchar(10) not null,
    Addressid varchar(10) not null,
    foreign key (DriversLicID) references Owners(DriversLicID) on update cascade on delete cascade,
    foreign key (Addressid) references AddressBook(Addressid) on update cascade on delete cascade
);

create table VehicleModels(
    Make varchar(10) not null,
    Model varchar(10) not null,
    Bodystyle varchar(20) not null,
    Weight double not null,
    Passengers int,
    Diesel boolean not null,
    ModelType varchar(20) not null,
    Year int not null,
    Cost double not null,
    ModelID varchar(10) not null,
    primary key (ModelID)   
);    

create table VehicleDetails(
	VIN varchar(28) not null,
    DriversLicID varchar(10) not null,
    Colour varchar(10) not null,
    Mileage int not null,
    ModelID varchar(10) not null,
    primary key (VIN),
    foreign key (DriversLicID) references Owners(DriversLicID) on update cascade on delete cascade,
    foreign key (ModelID) references VehicleModels(ModelID) on update cascade on delete cascade
);

create table VehicleRegistry(
	VIN varchar(28) not null,
    DriversLicID varchar(10) not null,
    RegisteredOn date not null,
    Taxes double not null,
    RegistrationID varchar(20) not null,
    Branch varchar(20),
    Lien varchar(255),
    InsuranceName varchar(255) not null,
    InsuranceValidity date not null,
    primary key (RegistrationID),
    foreign key (DriversLicID) references Owners(DriversLicID) on update cascade on delete cascade,
    foreign key (VIN) references VehicleDetails(VIN) on update cascade on delete cascade
);

create table IssuedPlates(
	PlateNumber varchar(8) not null,
    IssuedOn date not null,
    ExpiresOn date not null,
    PlateType varchar(16) not null,
    RegistrationID varchar(20) not null,
    RenewalFee double not null,
    ISDue boolean,
    Branch varchar(20),
    primary key (PlateNumber),
	foreign key (RegistrationID) references VehicleRegistry(RegistrationID) on update cascade on delete cascade
);

insert into Login values ('admin', '$2a$10$DUkHSn/S9UTRIOPhQ1.qbOJxgoJhNN6bXHEt9lV83HXOBCB7blZUi', 'admin'); -- The password is 'admin'