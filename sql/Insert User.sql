DROP TABLE IF EXISTS cuong.user;
CREATE TABLE user
(
userID bigint(20) NOT NULL AUTO_INCREMENT,
email varchar(255),
password varchar(255),
username varchar(255),
primary key (userID)
);

INSERT INTO Cuong.user ( userName, email,password )
			VALUES
				  ( "admin", "admin@gmail.com","123465" ),
                  ( "dotafifa", "dotafifa@gmail.com","851988" ),
                  ( "minhthu", "minhthu@gmail.com","851988" ),
				  ( "thiennhi", "thiennhi@gmail.com","851988" )
                  ;