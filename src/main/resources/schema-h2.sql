CREATE TABLE enrollee
(
	enroll_id NUMBER(10) NOT NULL,
	name VARCHAR2(50) NOT NULL,
	status CHAR(1) NOT NULL,
	contact NUMBER(10) NULL,
	dob DATE NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE dependents
(
	id NUMBER(10) NOT NULL,
	name VARCHAR2(50) NOT NULL,	
	dob DATE NOT NULL,
	enroll_id  NUMBER(10) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_dependents
    FOREIGN KEY (enroll_id) 
        REFERENCES enrollee(enroll_id)
);